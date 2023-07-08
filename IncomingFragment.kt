package com.example.mizanalnasr.ui.Incom

import android.annotation.SuppressLint
import android.app.Dialog
import android.content.Context
import android.content.Context.INPUT_METHOD_SERVICE
import android.graphics.Color
import android.net.ConnectivityManager
import android.os.Build
import android.os.Bundle
import android.support.annotation.RequiresApi
import android.support.design.widget.FloatingActionButton
import android.support.v4.app.Fragment
import android.support.v4.content.ContextCompat
import android.support.v7.widget.DividerItemDecoration
import android.text.Editable
import android.text.TextWatcher
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.EditorInfo
import android.view.inputmethod.InputMethodManager
import android.widget.*
import com.example.mizanalnasr.R
import com.example.mizanalnasr.databinding.FragmentIncomingBinding
import com.example.mizanalnasr.model.CheckData1
import com.example.mizanalnasr.recycler.SenderTextMessageItem
import com.example.neprotest.glide.GlideApp
import com.example.neprotest.model.CheckData
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.*
import com.google.firebase.storage.FirebaseStorage
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.OnItemClickListener
import com.xwray.groupie.Section
import com.xwray.groupie.ViewHolder
import com.xwray.groupie.kotlinandroidextensions.Item
import kotlinx.android.synthetic.main.app_bar_main.*
import kotlinx.android.synthetic.main.calendar_dailog.*
import kotlinx.android.synthetic.main.edit_dailog.*
import kotlinx.android.synthetic.main.fragment_incoming.*
import kotlinx.android.synthetic.main.fragment_incoming.view.*
import kotlinx.android.synthetic.main.image_view.*
import kotlinx.android.synthetic.main.paying_dailog.*
import kotlinx.android.synthetic.main.recyclerbox.*
import java.text.SimpleDateFormat
import java.time.LocalDate
import java.time.LocalTime
import java.util.*

class IncomingFragment : Fragment() {
    private var _binding: FragmentIncomingBinding? = null

    private val binding get() = _binding!!

    private val firestoreInstance: FirebaseFirestore by lazy {
        FirebaseFirestore.getInstance()}

    private val messageAdapter by lazy { GroupAdapter<ViewHolder>() }

    private lateinit var mCurrentChatChannelId: String

    private var mCurrentUserId = FirebaseAuth.getInstance().currentUser!!.uid

    private lateinit var RecipientId: String
    private lateinit var chatSection: Section
    private val chatChannelsCollectionRef = firestoreInstance.collection("chatChannels")

    var totalQuantity :Int = 0

    var start_date =""
    var end_date =""

    private val storageInstance: FirebaseStorage by lazy {
        FirebaseStorage.getInstance()
    }
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        _binding = FragmentIncomingBinding.inflate(inflater, container, false)
        val root: View = binding.root

//        val txt_tol_bar = activity?.findViewById<TextView>(R.id.txt_tol_bar)
//        txt_tol_bar!!.visibility = View.INVISIBLE

        if (!isNetworkAvailable(requireContext())) {
            Toast.makeText(requireContext(), "خدمة الانترنت غير متوفرة", Toast.LENGTH_LONG).apply {
                setGravity(Gravity.CENTER, 0, 0)
                show()
            }}

        val fab = activity?.findViewById<FloatingActionButton>(R.id.fab)
        val fab1 = activity?.findViewById<FloatingActionButton>(R.id.fab1)
        val fab2 = activity?.findViewById<FloatingActionButton>(R.id.fab2)
        fab!!.hide()
        fab1!!.hide()
        fab2!!.hide()
//        RecipientId = activity?.intent!!.getStringExtra("other_uid").toString()
        RecipientId = "Aq2v2rg2aeVVjVif0yk4jT0n19E2"
        root.btn_end_calendar.isEnabled=false

        createChatChannel { channelId ->
            mCurrentChatChannelId = channelId
            getMessages(channelId,::initRecyclerView)
            getTotal(channelId)
        }

        root.search_incoming.addTextChangedListener(texter)

        root.btn_start_calendar.setOnClickListener {
            val customDialogCALENDAR = Dialog(activity!!)
            customDialogCALENDAR.setContentView(R.layout.calendar_dailog)
            customDialogCALENDAR.setCancelable(false)
            customDialogCALENDAR.window?.setLayout(
                    ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT
            )

            customDialogCALENDAR.calendarView.setOnDateChangeListener { view, year, month, day ->
                val month1 = month +1
                text_start_calendar.setText("$year-$month1-$day").toString()
                start_date +="$year-$month1-$day 00:00"
                customDialogCALENDAR.dismiss()
            }
            btn_start_calendar.isEnabled=false
            btn_end_calendar.isEnabled=true
            customDialogCALENDAR.show()
        }

        root.btn_end_calendar.setOnClickListener {
            val customDialogCALENDAR = Dialog(activity!!)
            customDialogCALENDAR.setContentView(R.layout.calendar_dailog)
            customDialogCALENDAR.setCancelable(false)
            customDialogCALENDAR.window?.setLayout(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
            )

            customDialogCALENDAR.calendarView.setOnDateChangeListener { view, year, month, day ->
                val month = month +1
                text_end_calendar.setText("$year-$month-$day").toString()
                end_date +="$year-$month-$day 23:59:59"
                getMessages(mCurrentChatChannelId,::initRecyclerView)
                getTotal(mCurrentChatChannelId)
                start_date =""
                end_date =""
                btn_start_calendar.isEnabled=true
                customDialogCALENDAR.dismiss()
            }
            customDialogCALENDAR.show()
        }
        return root
    }

    private val texter = object :TextWatcher {
        override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
        }
        override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                getMessages(mCurrentChatChannelId,::initRecyclerView)
                getTotal(mCurrentChatChannelId)
            }else {
        TODO("VERSION.SDK_INT < O")

            }
        }
        override fun afterTextChanged(p0: Editable?) {
        }
    }

    private fun createChatChannel(onComplete: (channelId: String) -> Unit) {
        firestoreInstance.collection("users")
                .document(mCurrentUserId)
                .collection("sharedChat")
                .document(RecipientId)
                .get()
                .addOnSuccessListener { document ->
                    if (document.exists()) {
                        onComplete(document["channelId"] as String)
                        return@addOnSuccessListener
                    }
                }
    }

    val currentdate = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
        LocalDate.now().atTime(LocalTime.MIN).toString()
    } else {
//        TODO("VERSION.SDK_INT < O")
        Date().toString()
    }
    @SuppressLint("SimpleDateFormat")
    val dateFormat = SimpleDateFormat("yyy-MM-dd'T'HH:mm")
    val date1 = dateFormat.parse(currentdate)
    val startDate = com.google.firebase.Timestamp(date1)

    val lasttoday = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
        LocalDate.now().atTime(LocalTime.MAX).toString()
    } else {
//        TODO("VERSION.SDK_INT < O")
        Date().toString()
    }
    @SuppressLint("SimpleDateFormat")
    val lasttodayFormat = SimpleDateFormat("yyy-MM-dd'T'HH:mm:ss")
    val lasttoday_parse = lasttodayFormat.parse(lasttoday)
    val endtDate = com.google.firebase.Timestamp(lasttoday_parse)


    private fun getTotal(channelId: String) {
        if (text_end_calendar.text.toString().isNotEmpty()){
            val dateFormat_start = SimpleDateFormat("yyy-MM-dd hh:mm")
            val date1 = start_date
            val date_start = dateFormat_start.parse(date1)
            val startDate_cal = com.google.firebase.Timestamp(date_start)
            val dateFormat_end = SimpleDateFormat("yyy-MM-dd hh:mm:ss")
            val date2 = end_date
            val date_end = dateFormat_end.parse(date2)
            val endtDate_cal = com.google.firebase.Timestamp(date_end)

            chatChannelsCollectionRef.document(channelId).collection("messages")
                    .orderBy("date")
                    .startAt(startDate_cal).endAt(endtDate_cal)
                .get()
                .addOnCompleteListener { task ->
                    totalQuantity=0
                    if (task.isSuccessful) {
                        for (i in task.result!!.documents) {
                            if(  i.toObject(CheckData::class.java)!!.cash_price11.isNotEmpty()){
                                totalQuantity += i.toObject(CheckData::class.java)!!.cash_price11.toInt()
                            }
                            if(  i.toObject(CheckData::class.java)!!.wallet_price1.isNotEmpty()){
                                totalQuantity += i.toObject(CheckData::class.java)!!.wallet_price1.toInt()
                            }
                        }
                        texticoming.text="مجموع الكاش "+totalQuantity.toString()
                    }
                }
        }

        if(search_incoming.text.toString().isNotEmpty()){
            val searchname=search_incoming.text.toString()
            totalQuantity=0
            chatChannelsCollectionRef.document(channelId).collection("messages")
                    .orderBy("cusname")
                    .startAt(searchname).endAt(searchname + "\uf8ff")
                    .get()
                    .addOnCompleteListener { task ->
                        if (task.isSuccessful) {
                            for (i in task.result!!.documents) {
                                if(  i.toObject(CheckData::class.java)!!.cash_price11.isNotEmpty()){
                                    totalQuantity += i.toObject(CheckData::class.java)!!.cash_price11.toInt()
                                }
                                if(  i.toObject(CheckData::class.java)!!.wallet_price1.isNotEmpty()){
                                    totalQuantity += i.toObject(CheckData::class.java)!!.wallet_price1.toInt()
                                }
                            }
                            texticoming.text="مجموع الكاش "+totalQuantity.toString()
                        }
                    }
                }
        else {
            totalQuantity=0
            chatChannelsCollectionRef.document(channelId).collection("messages")
                    .orderBy("date")
                    .startAt(startDate).endAt(endtDate)
                .get()
                .addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        for (i in task.result!!.documents) {
                            if (i.toObject(CheckData::class.java)!!.cash_price11.isNotEmpty()) {
                                totalQuantity += i.toObject(CheckData::class.java)!!.cash_price11.toInt()
                            }
                            if (i.toObject(CheckData::class.java)!!.wallet_price1.isNotEmpty()) {
                                totalQuantity += i.toObject(CheckData::class.java)!!.wallet_price1.toInt()
                            }
                        }
                        texticoming.text = "مجموع الكاش " + totalQuantity.toString()
                    }
                }
        }
    }

    @RequiresApi(Build.VERSION_CODES.O)
    private fun getMessages(channelId:String, onListen: (List<Item>) -> Unit): ListenerRegistration {
        if (text_end_calendar.text.toString().isNotEmpty()){
            val dateFormat_start = SimpleDateFormat("yyy-MM-dd hh:mm")
            val date1 = start_date
            val date_start = dateFormat_start.parse(date1)
            val startDate_cal = com.google.firebase.Timestamp(date_start)
            val dateFormat_end = SimpleDateFormat("yyy-MM-dd hh:mm:ss")
            val date2 = end_date
            val date_end = dateFormat_end.parse(date2)
            val endtDate_cal = com.google.firebase.Timestamp(date_end)
            return chatChannelsCollectionRef.document(channelId).collection("messages")
                    .orderBy("date")
                    .startAt(startDate_cal).endAt(endtDate_cal)
                .addSnapshotListener { querySnapshot, firebaseFirestoreException ->
                    if (firebaseFirestoreException != null) {
                        return@addSnapshotListener
                    }
                    val items = mutableListOf<Item>()
                    querySnapshot!!.documents.forEach { document ->
                        items.add(
                            SenderTextMessageItem(
                                document.id,
                                document.toObject(CheckData::class.java)!!,
                                this.context!!
                            )
                        )
                    }
                    onListen(items)
                }
        }

        if (search_incoming.text.toString().isNotEmpty()){
            val searchname=search_incoming.text.toString()
            return chatChannelsCollectionRef.document(channelId).collection("messages")
                .orderBy("cusname")
                .startAt(searchname).endAt(searchname + "\uf8ff")
                .addSnapshotListener { querySnapshot, firebaseFirestoreException ->
                    if (firebaseFirestoreException != null) {
                        return@addSnapshotListener
                    }
                    val items = mutableListOf<Item>()
                    querySnapshot!!.documents.forEach { document ->
                        items.add(
                            SenderTextMessageItem(
                                document.id,
                                document.toObject(CheckData::class.java)!!,
                                this.context!!
                            )
                        )
                    }
                    onListen(items)
                }
        }
        else {

            return chatChannelsCollectionRef.document(channelId).collection("messages")
                    .orderBy("date")
                    .startAt(startDate).endAt(endtDate)
                .addSnapshotListener { querySnapshot, firebaseFirestoreException ->
                    if (firebaseFirestoreException != null) {
                        return@addSnapshotListener
                    }
                    val items = mutableListOf<Item>()
                    querySnapshot!!.documents.forEach { document ->
                        items.add(
                            SenderTextMessageItem(
                                document.id,
                                document.toObject(CheckData::class.java)!!,
                                this.context!!
                            )
                        )
                    }
                    onListen(items)
                }
        }
    }
    private fun initRecyclerView(item: List<Item>) {

        recyclerorders.apply {
            addItemDecoration(
                    DividerItemDecoration(this.context,DividerItemDecoration.VERTICAL)
            )
            messageAdapter.clear()
            adapter = messageAdapter.apply {
                chatSection = Section(item)
                add(chatSection)
                setOnItemClickListener(onItemClick)

            }
        }
    }
    @SuppressLint("SetTextI18n")
    private val onItemClick = OnItemClickListener { item, view ->
        if (item is SenderTextMessageItem) {

            val customDialogFB = Dialog(activity!!)
            customDialogFB.setContentView(R.layout.edit_dailog)
            customDialogFB.setCancelable(false)
            customDialogFB.window?.setLayout(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
            )

            val customDialogIMG = Dialog(activity!!)
            customDialogIMG.setContentView(R.layout.image_view)
            customDialogIMG.setCancelable(true)
            customDialogIMG.window?.setLayout(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
            )
            if (item.checkData.customerImage.isNotEmpty()) {
                GlideApp.with(context!!)
                    .load(storageInstance.getReference(item.checkData.customerImage))
                    .into(customDialogFB.img_show_incom)
            }
            customDialogFB.img_show_incom.setOnClickListener {
                GlideApp.with(context!!)
                    .load(storageInstance.getReference(item.checkData.customerImage))
                    .into(customDialogIMG.img_full_scren)
                customDialogIMG.show()
            }
            customDialogFB.name_E_D.setText(item.checkData.cusname)
            customDialogFB.phone_E_D.setText(item.checkData.cusphone)
            customDialogFB.plate_E_D.setText(item.checkData.numcar)
            customDialogFB.totalall_E_D.text = "المجموع " + item.checkData.total
            customDialogFB.totalall_E_D.setTextColor(Color.parseColor("#0637ED"))

            var customname = ""
            var customphone = ""
            var carnumber = ""
            var cash_name_E = ""
            var cash_price11_E = ""
            var wallte_name_E = ""
            var wallet_price1_E = ""
            var credit_name_E = ""
            var credit_price1_E = ""
            var discount_name_E = ""
            var discount_price_E = ""
            var receivables_price1_E = ""
            var checkreceivables_E = ""

            var totalrecivable :Int=0
            var total_cash :Int =0
            var total_wallte :Int=0
            var total_credit :Int=0
            var total_discount :Int=0

            if (item.checkData.cash_paying1.isNotEmpty()){
                customDialogFB.apply {
                    edit_cash_name.visibility = View.VISIBLE
                    edit_cash_price.visibility = View.VISIBLE
                    edit_cash_price.setText(item.checkData.cash_price11)
                    total_cash += edit_cash_price.text.toString().toInt()
                }
            }

            if (item.checkData.wallet1.isNotEmpty()){
                customDialogFB.apply {
                    edit_wallte_name.visibility = View.VISIBLE
                    edit_wallte_price.visibility = View.VISIBLE
                    edit_wallte_price.setText(item.checkData.wallet_price1)
                    total_wallte +=  customDialogFB.edit_wallte_price.text.toString().toInt()
                }
            }

            if (item.checkData.credit1.isNotEmpty()){
                customDialogFB.apply {
                    edit_credit_name.visibility = View.VISIBLE
                    edit_credit_price.visibility = View.VISIBLE
                    edit_credit_price.setText(item.checkData.credit_price1)
                    total_credit +=  customDialogFB.edit_credit_price.text.toString().toInt()
                }
            }

            if (item.checkData.discount1.isNotEmpty()){
                customDialogFB.apply {
                    edit_discount_name.visibility = View.VISIBLE
                    edit_discount_price.visibility = View.VISIBLE
                    edit_discount_price.setText(item.checkData.discount_price1)
                    total_discount +=  customDialogFB.edit_discount_price.text.toString().toInt()
                }
            }

            if (item.checkData.receivables_price1.isNotEmpty()){
                customDialogFB.apply {
                    checkreceivables.visibility = View.VISIBLE
                    edit_receivabel_price.visibility = View.VISIBLE
                    edit_receivabel_price.apply {
                        setText(item.checkData.receivables_price1)
                        totalrecivable += customDialogFB.edit_receivabel_price.text.toString().toInt()
                    }
                }
            }

                    customDialogFB.add_cash_price_E.setOnEditorActionListener { textView, i, keyEvent ->
                    if (i==EditorInfo.IME_ACTION_DONE) {
                            total_cash += customDialogFB.add_cash_price_E.text.toString().toInt()
                            customDialogFB.edit_cash_price.text = total_cash.toString()
                            totalrecivable -= customDialogFB.add_cash_price_E.text.toString().toInt()
                            customDialogFB.edit_receivabel_price.text = totalrecivable.toString()
                            customDialogFB.add_cash_price_E.setText("")
                            val imm: InputMethodManager = context!!.getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
                            if (imm.isActive)
                                imm.toggleSoftInput(InputMethodManager.HIDE_IMPLICIT_ONLY, 0)
                            true
                        }else{ false }
                }

            customDialogFB.add_wallte_price_E.setOnEditorActionListener { textView, i, keyEvent ->
                if (i==EditorInfo.IME_ACTION_DONE){
                    total_wallte +=  customDialogFB.add_wallte_price_E.text.toString().toInt()
                    customDialogFB.edit_wallte_price.text =total_wallte.toString()
                    totalrecivable -=customDialogFB.add_wallte_price_E.text.toString().toInt()
                    customDialogFB.edit_receivabel_price.text=totalrecivable.toString()
                    customDialogFB.add_wallte_price_E.setText("")
                    val imm: InputMethodManager = context!!.getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
                    if (imm.isActive)
                        imm.toggleSoftInput(InputMethodManager.HIDE_IMPLICIT_ONLY, 0)
                    true
                }else{false}
            }

            customDialogFB.add_credit_price_E.setOnEditorActionListener { textView, i, keyEvent ->
                if (i==EditorInfo.IME_ACTION_DONE){
                    total_credit +=  customDialogFB.add_credit_price_E.text.toString().toInt()
                    customDialogFB.edit_credit_price.text =total_credit.toString()
                    totalrecivable -=customDialogFB.add_credit_price_E.text.toString().toInt()
                    customDialogFB.edit_receivabel_price.text=totalrecivable.toString()
                    customDialogFB.add_credit_price_E.setText("")
                    val imm: InputMethodManager = context!!.getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
                    if (imm.isActive)
                        imm.toggleSoftInput(InputMethodManager.HIDE_IMPLICIT_ONLY, 0)
                    true
                }else{false}
            }

            customDialogFB.add_discount_price_E.setOnEditorActionListener { textView, i, keyEvent ->
                if (i==EditorInfo.IME_ACTION_DONE){
                    total_discount +=  customDialogFB.add_discount_price_E.text.toString().toInt()
                    customDialogFB.edit_discount_price.text =total_discount.toString()
                    totalrecivable -=customDialogFB.add_discount_price_E.text.toString().toInt()
                    customDialogFB.edit_receivabel_price.text=totalrecivable.toString()
                    customDialogFB.add_discount_price_E.setText("")
                    val imm: InputMethodManager = context!!.getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
                    if (imm.isActive)
                        imm.toggleSoftInput(InputMethodManager.HIDE_IMPLICIT_ONLY, 0)
                    true
                }else{false}
            }

            customDialogFB.save_edit.setOnClickListener {
                customname = customDialogFB.name_E_D.text.toString()
                customphone = customDialogFB.phone_E_D.text.toString()
                carnumber = customDialogFB.plate_E_D.text.toString()

                if (!isNetworkAvailable(requireContext())) {
                    Toast.makeText(requireContext(), "خدمة الانترنت غير متوفرة", Toast.LENGTH_LONG)
                        .apply {
                            setGravity(Gravity.CENTER, 0, 0)
                            show()
                        }
                }
                else { if (item.checkData.receivables_price1.isNotEmpty()) {


                        val val_edit_receivable =
                            customDialogFB.edit_receivabel_price.text.toString()
                        if (val_edit_receivable.isEmpty()) {
                            customDialogFB.checkreceivables.setText("")
                        }

                        val val_editcashprice = customDialogFB.edit_cash_price.text.toString()
                        if (val_editcashprice.isNotEmpty()) {
                            cash_name_E += customDialogFB.edit_cash_name.text.toString()
                            cash_price11_E += customDialogFB.edit_cash_price.text.toString()
                        } else {
                            customDialogFB.edit_cash_name.setText("")
                            cash_name_E += customDialogFB.edit_cash_name.text.toString()
                        }

                        val val_edit_wallte_price = customDialogFB.edit_wallte_price.text.toString()
                        if (val_edit_wallte_price.isNotEmpty()) {
                            wallte_name_E += customDialogFB.edit_wallte_name.text.toString()
                            wallet_price1_E += customDialogFB.edit_wallte_price.text.toString()
                        } else {
                            customDialogFB.edit_wallte_name.text = ""
                            wallte_name_E += customDialogFB.edit_wallte_name.text.toString()
                        }

                        val val_edit_credit_price = customDialogFB.edit_credit_price.text.toString()
                        if (val_edit_credit_price.isNotEmpty()) {
                            credit_name_E += customDialogFB.edit_credit_name.text.toString()
                            credit_price1_E += customDialogFB.edit_credit_price.text.toString()
                        } else {
                            customDialogFB.edit_credit_name.text = ""
                            credit_name_E += customDialogFB.edit_credit_name.text.toString()
                        }

                        val val_edit_discount_price =
                            customDialogFB.edit_discount_price.text.toString()
                        if (val_edit_discount_price.isNotEmpty()) {
                            discount_name_E += customDialogFB.edit_discount_name.text.toString()
                            discount_price_E += customDialogFB.edit_discount_price.text.toString()
                        } else {
                            customDialogFB.edit_discount_name.text = ""
                            discount_name_E += customDialogFB.edit_discount_name.text.toString()
                        }

                        checkreceivables_E += customDialogFB.checkreceivables.text.toString()
                        receivables_price1_E += customDialogFB.edit_receivabel_price.text.toString()

                        val checkupdate = CheckData1(
                            customname,
                            customphone,
                            carnumber,

                            cash_name_E,
                            wallte_name_E,
                            credit_name_E,
                            discount_name_E,
                            checkreceivables_E,
                            cash_price11_E,
                            wallet_price1_E,
                            credit_price1_E,
                            discount_price_E,
                            receivables_price1_E,

                            Calendar.getInstance().time
                        )

                        val contentMessage = mutableMapOf<String, Any>()
                        contentMessage["cusname"] = checkupdate.cusname
                        contentMessage["cusphone"] = checkupdate.cusphone
                        contentMessage["numcar"] = checkupdate.numcar
                        contentMessage["cash_paying1"] = checkupdate.cash_paying1
                        contentMessage["cash_price11"] = checkupdate.cash_price11
                        contentMessage["wallet1"] = checkupdate.wallet1
                        contentMessage["wallet_price1"] = checkupdate.wallet_price1
                        contentMessage["credit1"] = checkupdate.credit1
                        contentMessage["credit_price1"] = checkupdate.credit_price1
                        contentMessage["discount1"] = checkupdate.discount1
                        contentMessage["discount_price1"] = checkupdate.discount_price1
                        contentMessage["receivables_price1"] = checkupdate.receivables_price1
                        contentMessage["date"] = checkupdate.date

                        chatChannelsCollectionRef.document(mCurrentChatChannelId)
                            .collection("messages")
                            .document(item.messageId)
                            .update(contentMessage)

                        messageAdapter.clear()
                        totalQuantity = 0
                        getTotal(mCurrentChatChannelId)
                        customDialogFB.dismiss()
                    } else {
                        val edit_toast = Toast.makeText(
                            activity,
                            "لن يتم تعديل اي قيم مالية (لا يوجد ذمم)",
                            Toast.LENGTH_LONG
                        )
                        edit_toast.view!!.background.setTintList(
                            ContextCompat.getColorStateList(
                                this.context!!,
                                android.R.color.holo_red_dark
                            )
                        )
                        edit_toast.setGravity(5, 100, -400)
                        edit_toast.show()

                    }
                    customDialogFB.dismiss()
                }
            }
            if (item.checkData.check1.isNotEmpty()){
            val checkBoxauto1 = TextView(this.context)
//            val viewtext = TextView(this.context)
                customDialogFB.apply {
                checkBoxauto1.setText(item.checkData.check1)
                checkBoxauto1.setTextColor(Color.parseColor("#000000"))
                checkBoxauto1.layoutParams = LinearLayout.LayoutParams(
                    ViewGroup.LayoutParams.WRAP_CONTENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT, Float.MIN_VALUE)
//                viewtext.setText(item.checkData.price1)
//                viewtext.setTextColor(Color.parseColor("#000000"))
//                lein_E_D.addView(viewtext)
                lein_E_D.addView(checkBoxauto1)

            }}

        if (item.checkData.check2.isNotEmpty()){
            val checkBoxauto2 = TextView(this.context)
            val viewtext2 = TextView(this.context)
            customDialogFB.apply {
                checkBoxauto2.setText(item.checkData.check2)
                checkBoxauto2.setTextColor(Color.parseColor("#000000"))
                checkBoxauto2.layoutParams = LinearLayout.LayoutParams(
                    ViewGroup.LayoutParams.WRAP_CONTENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT, Float.MIN_VALUE)
                viewtext2.setText(item.checkData.price2)
                viewtext2.setTextColor(Color.parseColor("#000000"))
                lein2_E_D.addView(viewtext2)
                lein2_E_D.addView(checkBoxauto2)
            }}

        if (item.checkData.check3.isNotEmpty()){
            val checkBoxauto3 = TextView(this.context)
//            val viewtext3 = TextView(this.context)
            customDialogFB.apply { checkBoxauto3.setText(item.checkData.check3)
                checkBoxauto3.setTextColor(Color.parseColor("#000000"))
                checkBoxauto3.layoutParams = LinearLayout.LayoutParams(
                    ViewGroup.LayoutParams.WRAP_CONTENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT, Float.MIN_VALUE)
//                viewtext3.setText(item.checkData.price3)
//                viewtext3.setTextColor(Color.parseColor("#000000"))
//                lein3_E_D.addView(viewtext3)
                lein3_E_D.addView(checkBoxauto3)
            }}

        if (item.checkData.check4.isNotEmpty()){
           val checkBoxauto4 = TextView(this.context)
//            val viewtext4 = TextView(this.context)
            customDialogFB.apply { checkBoxauto4.setText(item.checkData.check4)
                checkBoxauto4.setTextColor(Color.parseColor("#000000"))
                checkBoxauto4.layoutParams = LinearLayout.LayoutParams(
                    ViewGroup.LayoutParams.WRAP_CONTENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT, Float.MIN_VALUE)
//                viewtext4.setText(item.checkData.price4)
//                viewtext4.setTextColor(Color.parseColor("#000000"))
//                lein4_E_D.addView(viewtext4)
                lein4_E_D.addView(checkBoxauto4)
            }}

        if (item.checkData.check5.isNotEmpty()){
            val checkBoxauto5 = TextView(this.context)
//            val viewtext5 = TextView(this.context)
            customDialogFB.apply { checkBoxauto5.setText(item.checkData.check5)
                checkBoxauto5.setTextColor(Color.parseColor("#000000"))
                checkBoxauto5.layoutParams = LinearLayout.LayoutParams(
                    ViewGroup.LayoutParams.WRAP_CONTENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT, Float.MIN_VALUE)
//                viewtext5.setText(item.checkData.price5)
//                viewtext5.setTextColor(Color.parseColor("#000000"))
//                lein5_E_D.addView(viewtext5)
                lein5_E_D.addView(checkBoxauto5)
            }}

        if (item.checkData.check6.isNotEmpty()){
            val checkBoxauto6 = TextView(this.context)
//            val viewtext6 = TextView(this.context)
            customDialogFB.apply { checkBoxauto6.setText(item.checkData.check6)
                checkBoxauto6.setTextColor(Color.parseColor("#000000"))
                checkBoxauto6.layoutParams = LinearLayout.LayoutParams(
                    ViewGroup.LayoutParams.WRAP_CONTENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT, Float.MIN_VALUE)
//                viewtext6.setText(item.checkData.price6)
//                viewtext6.setTextColor(Color.parseColor("#000000"))
//                lein6_E_D.addView(viewtext6)
                lein6_E_D.addView(checkBoxauto6)
            }}

        if (item.checkData.check7.isNotEmpty()){
            val checkBoxauto7 = TextView(this.context)
//            val viewtext7 = TextView(this.context)
            customDialogFB.apply { checkBoxauto7.setText(item.checkData.check7)
                checkBoxauto7.setTextColor(Color.parseColor("#000000"))
                checkBoxauto7.layoutParams = LinearLayout.LayoutParams(
                    ViewGroup.LayoutParams.WRAP_CONTENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT, Float.MIN_VALUE)
//                viewtext7.setText(item.checkData.price7)
//                viewtext7.setTextColor(Color.parseColor("#000000"))
//                lein7_E_D.addView(viewtext7)
                lein7_E_D.addView(checkBoxauto7)
            }}

        if (item.checkData.check8.isNotEmpty()){
            val checkBoxauto8 = TextView(this.context)
//            val viewtext8 = TextView(this.context)
            customDialogFB.apply { checkBoxauto8.setText(item.checkData.check8)
                checkBoxauto8.setTextColor(Color.parseColor("#000000"))
                checkBoxauto8.layoutParams = LinearLayout.LayoutParams(
                    ViewGroup.LayoutParams.WRAP_CONTENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT, Float.MIN_VALUE)
//                viewtext8.setText(item.checkData.price8)
//                viewtext8.setTextColor(Color.parseColor("#000000"))
//                lein8_E_D.addView(viewtext8)
                lein8_E_D.addView(checkBoxauto8)
            }}

        if (item.checkData.check9.isNotEmpty()){
           val checkBoxauto9 = TextView(this.context)
//            val viewtext9 = TextView(this.context)
            customDialogFB.apply { checkBoxauto9.setText(item.checkData.check9)
                checkBoxauto9.setTextColor(Color.parseColor("#000000"))
                checkBoxauto9.layoutParams = LinearLayout.LayoutParams(
                    ViewGroup.LayoutParams.WRAP_CONTENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT, Float.MIN_VALUE)
//                viewtext9.setText(item.checkData.price9)
//                viewtext9.setTextColor(Color.parseColor("#000000"))
//                lein9_E_D.addView(viewtext9)
                lein9_E_D.addView(checkBoxauto9)
            }}

        if (item.checkData.check10.isNotEmpty()){
            val checkBoxauto10 = TextView(this.context)
//            val viewtext10 = TextView(this.context)
            customDialogFB.apply { checkBoxauto10.setText(item.checkData.check10)
                checkBoxauto10.setTextColor(Color.parseColor("#000000"))
                checkBoxauto10.layoutParams = LinearLayout.LayoutParams(
                    ViewGroup.LayoutParams.WRAP_CONTENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT, Float.MIN_VALUE)
//                viewtext10.setText(item.checkData.price10)
//                viewtext10.setTextColor(Color.parseColor("#000000"))
//                lein10_E_D.addView(viewtext10)
                lein10_E_D.addView(checkBoxauto10)
            }}

        if (item.checkData.check11.isNotEmpty()){
            val checkBoxauto11 = TextView(this.context)
//            val viewtext11 = TextView(this.context)
            customDialogFB.apply {
                checkBoxauto11.setText(item.checkData.check11)
                checkBoxauto11.setTextColor(Color.parseColor("#000000"))
                checkBoxauto11.layoutParams = LinearLayout.LayoutParams(
                    ViewGroup.LayoutParams.WRAP_CONTENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT, Float.MIN_VALUE)
//                viewtext11.setText(item.checkData.price11)
//                viewtext11.setTextColor(Color.parseColor("#000000"))
//                lein11_E_D.addView(viewtext11)
                lein11_E_D.addView(checkBoxauto11)
            }}

        if (item.checkData.check12.isNotEmpty()){
            val checkBoxauto12 = TextView(this.context)
//            val viewtext12 = TextView(this.context)
            customDialogFB.apply {
                checkBoxauto12.setText(item.checkData.check12)
                checkBoxauto12.setTextColor(Color.parseColor("#000000"))
                checkBoxauto12.layoutParams = LinearLayout.LayoutParams(
                    ViewGroup.LayoutParams.WRAP_CONTENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT, Float.MIN_VALUE)
//                viewtext12.setText(item.checkData.price12)
//                viewtext12.setTextColor(Color.parseColor("#000000"))
//                lein12_E_D.addView(viewtext12)
                lein12_E_D.addView(checkBoxauto12)

            }}

        if (item.checkData.check13.isNotEmpty()){
            val checkBoxauto13 = TextView(this.context)
//            val viewtext13 = TextView(this.context)
            customDialogFB.apply { checkBoxauto13.setText(item.checkData.check13)
                checkBoxauto13.setTextColor(Color.parseColor("#000000"))
                checkBoxauto13.layoutParams = LinearLayout.LayoutParams(
                    ViewGroup.LayoutParams.WRAP_CONTENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT, Float.MIN_VALUE)
//                viewtext13.setText(item.checkData.price13)
//                viewtext13.setTextColor(Color.parseColor("#000000"))
//                lein13_E_D.addView(viewtext13)
                lein13_E_D.addView(checkBoxauto13)
            }}

        if (item.checkData.check14.isNotEmpty()){
           val checkBoxauto14 = TextView(this.context)
//            val viewtext14 = TextView(this.context)
            customDialogFB.apply {
                checkBoxauto14.setText(item.checkData.check14)
                checkBoxauto14.setTextColor(Color.parseColor("#000000"))
                checkBoxauto14.layoutParams = LinearLayout.LayoutParams(
                    ViewGroup.LayoutParams.WRAP_CONTENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT, Float.MIN_VALUE)
//                viewtext14.setText(item.checkData.price14)
//                viewtext14.setTextColor(Color.parseColor("#000000"))
//                lein14_E_D.addView(viewtext14)
                lein14_E_D.addView(checkBoxauto14)
        }}

        if (item.checkData.check15.isNotEmpty()){
            val checkBoxauto15 = TextView(this.context)
//            val viewtext15 = TextView(this.context)
            customDialogFB.apply {
                checkBoxauto15.setText(item.checkData.check15)
                checkBoxauto15.setTextColor(Color.parseColor("#000000"))
                checkBoxauto15.layoutParams = LinearLayout.LayoutParams(
                    ViewGroup.LayoutParams.WRAP_CONTENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT, Float.MIN_VALUE)
//                viewtext15.setText(item.checkData.price15)
//                viewtext15.setTextColor(Color.parseColor("#000000"))
//                lein15_E_D.addView(viewtext15)
                lein15_E_D.addView(checkBoxauto15)
            }}

        if (item.checkData.check16.isNotEmpty()){
            val checkBoxauto16 = TextView(this.context)
//            val viewtext16 = TextView(this.context)
            customDialogFB.apply { checkBoxauto16.setText(item.checkData.check16)
                checkBoxauto16.setTextColor(Color.parseColor("#000000"))
                checkBoxauto16.layoutParams = LinearLayout.LayoutParams(
                    ViewGroup.LayoutParams.WRAP_CONTENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT, Float.MIN_VALUE)
//                viewtext16.setText(item.checkData.price16)
//                viewtext16.setTextColor(Color.parseColor("#000000"))
//                lein16_E_D.addView(viewtext16)
                lein16_E_D.addView(checkBoxauto16)
            }}
        if (item.checkData.check17.isNotEmpty()){
            val checkBoxauto17 = TextView(this.context)
//            val viewtext17 = TextView(this.context)
            customDialogFB.apply {
                checkBoxauto17.setText(item.checkData.check17)
                checkBoxauto17.setTextColor(Color.parseColor("#000000"))
                checkBoxauto17.layoutParams = LinearLayout.LayoutParams(
                    ViewGroup.LayoutParams.WRAP_CONTENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT, Float.MIN_VALUE)
//                viewtext17.setText(item.checkData.price17)
//                viewtext17.setTextColor(Color.parseColor("#000000"))
//                lein17_E_D.addView(viewtext17)
                lein17_E_D.addView(checkBoxauto17)
            }}

        if (item.checkData.check18.isNotEmpty()){
            val checkBoxauto18 = TextView(this.context)
//            val viewtext18 = TextView(this.context)
            customDialogFB.apply {
                checkBoxauto18.setText(item.checkData.check14)
                checkBoxauto18.setTextColor(Color.parseColor("#000000"))
                checkBoxauto18.layoutParams = LinearLayout.LayoutParams(
                    ViewGroup.LayoutParams.WRAP_CONTENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT, Float.MIN_VALUE)
//                viewtext18.setText(item.checkData.price18)
//                viewtext18.setTextColor(Color.parseColor("#000000"))
//                lein18_E_D.addView(viewtext18)
                lein18_E_D.addView(checkBoxauto18)
            }}

            if (item.checkData.check19.isNotEmpty()){
                val checkBoxauto19 = TextView(this.context)
//                val viewtext19 = TextView(this.context)
                customDialogFB.apply {
                    checkBoxauto19.setText(item.checkData.check19)
                    checkBoxauto19.setTextColor(Color.parseColor("#000000"))
                    checkBoxauto19.layoutParams = LinearLayout.LayoutParams(
                        ViewGroup.LayoutParams.WRAP_CONTENT,
                        ViewGroup.LayoutParams.WRAP_CONTENT, Float.MIN_VALUE)
//                    viewtext19.setText(item.checkData.price19)
//                    viewtext19.setTextColor(Color.parseColor("#000000"))
//                    lein19_E_D.addView(viewtext19)
                    lein19_E_D.addView(checkBoxauto19)
                }}
            if (item.checkData.check20.isNotEmpty()){
                val checkBoxauto20 = TextView(this.context)
//                val viewtext20 = TextView(this.context)
                customDialogFB.apply {
                    checkBoxauto20.setText(item.checkData.check20)
                    checkBoxauto20.setTextColor(Color.parseColor("#000000"))
                    checkBoxauto20.layoutParams = LinearLayout.LayoutParams(
                        ViewGroup.LayoutParams.WRAP_CONTENT,
                        ViewGroup.LayoutParams.WRAP_CONTENT, Float.MIN_VALUE)
//                    viewtext20.setText(item.checkData.price20)
//                    viewtext20.setTextColor(Color.parseColor("#000000"))
//                    lein20_E_D.addView(viewtext20)
                    lein20_E_D.addView(checkBoxauto20)
                }}

        if (item.checkData.editD1.isNotEmpty()){
            val checkBoxautoD1 = EditText(this.context)
//            val viewtextD1 = EditText(this.context)
            customDialogFB.apply {
                checkBoxautoD1.setText(item.checkData.editD1)
                checkBoxautoD1.setTextColor(Color.parseColor("#000000"))
                checkBoxautoD1.layoutParams = LinearLayout.LayoutParams(
                    ViewGroup.LayoutParams.WRAP_CONTENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT, Float.MIN_VALUE)
//                viewtextD1.setText(item.checkData.pricD1)
//                viewtextD1.setTextColor(Color.parseColor("#000000"))
//                leinD1_E_D.addView(viewtextD1)
                leinD1_E_D.addView(checkBoxautoD1)
            }}

        if (item.checkData.editD2.isNotEmpty()){
            val checkBoxautoD2 = EditText(this.context)
//            val viewtextD2 = EditText(this.context)
            customDialogFB.apply { checkBoxautoD2.setText(item.checkData.editD2)
                checkBoxautoD2.setTextColor(Color.parseColor("#000000"))
                checkBoxautoD2.layoutParams = LinearLayout.LayoutParams(
                    ViewGroup.LayoutParams.WRAP_CONTENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT, Float.MIN_VALUE)
//                viewtextD2.setText(item.checkData.pricD2)
//                viewtextD2.setTextColor(Color.parseColor("#000000"))
//                leinD2_E_D.addView(viewtextD2)
                leinD2_E_D.addView(checkBoxautoD2)
            }}

        if (item.checkData.editD3.isNotEmpty()){
            val checkBoxautoD3 = EditText(this.context)
//            val viewtextD3 = EditText(this.context)
            customDialogFB.apply { checkBoxautoD3.setText(item.checkData.editD3)
                checkBoxautoD3.setTextColor(Color.parseColor("#000000"))
                checkBoxautoD3.layoutParams = LinearLayout.LayoutParams(
                    ViewGroup.LayoutParams.WRAP_CONTENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT, Float.MIN_VALUE)
//                viewtextD3.setText(item.checkData.pricD3)
//                viewtextD3.setTextColor(Color.parseColor("#000000"))
//                leinD3_E_D.addView(viewtextD3)
                leinD3_E_D.addView(checkBoxautoD3)
            }}

        if (item.checkData.editD4.isNotEmpty()){
            val checkBoxautoD4 = EditText(this.context)
//            val viewtextD4 = EditText(this.context)
            customDialogFB.apply { checkBoxautoD4.setText(item.checkData.editD4)
                checkBoxautoD4.setTextColor(Color.parseColor("#000000"))
                checkBoxautoD4.layoutParams = LinearLayout.LayoutParams(
                    ViewGroup.LayoutParams.WRAP_CONTENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT, Float.MIN_VALUE)
//                viewtextD4.setText(item.checkData.pricD4)
//                viewtextD4.setTextColor(Color.parseColor("#000000"))
//                leinD4_E_D.addView(viewtextD4)
                leinD4_E_D.addView(checkBoxautoD4)
            }}

        if (item.checkData.editD5.isNotEmpty()){
            val checkBoxautoD5 = EditText(this.context)
//            val viewtextD5 = EditText(this.context)
            customDialogFB.apply {
                checkBoxautoD5.setText(item.checkData.editD5)
                checkBoxautoD5.setTextColor(Color.parseColor("#000000"))
                checkBoxautoD5.layoutParams = LinearLayout.LayoutParams(
                    ViewGroup.LayoutParams.WRAP_CONTENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT, Float.MIN_VALUE)
//                viewtextD5.setText(item.checkData.pricD5)
//                viewtextD5.setTextColor(Color.parseColor("#000000"))
//                leinD5_E_D.addView(viewtextD5)
                leinD5_E_D.addView(checkBoxautoD5)
            }}

        if (item.checkData.editD6.isNotEmpty()){
            val checkBoxautoD6 = EditText(this.context)
//            val viewtextD6 = EditText(this.context)
            customDialogFB.apply {
                checkBoxautoD6.setText(item.checkData.editD6)
                checkBoxautoD6.setTextColor(Color.parseColor("#000000"))
                checkBoxautoD6.layoutParams = LinearLayout.LayoutParams(
                    ViewGroup.LayoutParams.WRAP_CONTENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT, Float.MIN_VALUE)
//                viewtextD6.setText(item.checkData.pricD6)
//                viewtextD6.setTextColor(Color.parseColor("#000000"))
//                leinD6_E_D.addView(viewtextD6)
                leinD6_E_D.addView(checkBoxautoD6)
            }}

        if (item.checkData.editD7.isNotEmpty()){
            val checkBoxautoD7 = EditText(this.context)
//            val viewtextD7 = EditText(this.context)
            customDialogFB.apply {
                checkBoxautoD7.setText(item.checkData.editD7)
                checkBoxautoD7.setTextColor(Color.parseColor("#000000"))
                checkBoxautoD7.layoutParams = LinearLayout.LayoutParams(
                    ViewGroup.LayoutParams.WRAP_CONTENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT, Float.MIN_VALUE)
//                viewtextD7.setText(item.checkData.pricD7)
//                viewtextD7.setTextColor(Color.parseColor("#000000"))
//                leinD7_E_D.addView(viewtextD7)
                leinD7_E_D.addView(checkBoxautoD7)
            }}

        if (item.checkData.editD8.isNotEmpty()){
            val checkBoxauto8 = EditText(this.context)
//            val viewtextD8 = EditText(this.context)
            customDialogFB.apply {
                checkBoxauto8.setText(item.checkData.editD8)
                checkBoxauto8.setTextColor(Color.parseColor("#000000"))
                checkBoxauto8.layoutParams = LinearLayout.LayoutParams(
                    ViewGroup.LayoutParams.WRAP_CONTENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT, Float.MIN_VALUE)
//                viewtextD8.setText(item.checkData.pricD8)
//                viewtextD8.setTextColor(Color.parseColor("#000000"))
//                leinD8_E_D.addView(viewtextD8)
                leinD8_E_D.addView(checkBoxauto8)
            }}

        if (item.checkData.editD9.isNotEmpty()){
            val checkBoxautoD9 = EditText(this.context)
//            val viewtextD9 = EditText(this.context)
            customDialogFB.apply {
                checkBoxautoD9.setText(item.checkData.editD9)
                checkBoxautoD9.setTextColor(Color.parseColor("#000000"))
                checkBoxautoD9.layoutParams = LinearLayout.LayoutParams(
                    ViewGroup.LayoutParams.WRAP_CONTENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT, Float.MIN_VALUE)
//                viewtextD9.setText(item.checkData.pricD9)
//                viewtextD9.setTextColor(Color.parseColor("#000000"))
//                leinD9_E_D.addView(viewtextD9)
                leinD9_E_D.addView(checkBoxautoD9)
            }
        }

            if (item.checkData.check2_1.isNotEmpty()){
                val checkBoxauto2_1 = TextView(this.context)
//                val viewtext2_1 = TextView(this.context)
                customDialogFB.apply {
                    checkBoxauto2_1.setText(item.checkData.check2_1)
                    checkBoxauto2_1.setTextColor(Color.parseColor("#000000"))
                    checkBoxauto2_1.layoutParams = LinearLayout.LayoutParams(
                        ViewGroup.LayoutParams.WRAP_CONTENT,
                        ViewGroup.LayoutParams.WRAP_CONTENT, Float.MIN_VALUE)
//                    viewtext2_1.setText(item.checkData.price2_1)
//                    viewtext2_1.setTextColor(Color.parseColor("#000000"))
//                    lein_E_D.addView(viewtext2_1)
                    lein_E_D.addView(checkBoxauto2_1)

                }}

            if (item.checkData.check2_2.isNotEmpty()){
                val checkBoxauto2_2 = TextView(this.context)
//                val viewtext2_2 = TextView(this.context)
                customDialogFB.apply {
                    checkBoxauto2_2.setText(item.checkData.check2_2)
                    checkBoxauto2_2.setTextColor(Color.parseColor("#000000"))
                    checkBoxauto2_2.layoutParams = LinearLayout.LayoutParams(
                        ViewGroup.LayoutParams.WRAP_CONTENT,
                        ViewGroup.LayoutParams.WRAP_CONTENT, Float.MIN_VALUE)
//                    viewtext2_2.setText(item.checkData.price2_2)
//                    viewtext2_2.setTextColor(Color.parseColor("#000000"))
//                    lein2_E_D.addView(viewtext2_2)
                    lein2_E_D.addView(checkBoxauto2_2)
                }}

            if (item.checkData.check2_3.isNotEmpty()){
                val checkBoxauto2_3 = TextView(this.context)
//                val viewtext2_3 = TextView(this.context)
                customDialogFB.apply {
                    checkBoxauto2_3.setText(item.checkData.check2_3)
                    checkBoxauto2_3.setTextColor(Color.parseColor("#000000"))
                    checkBoxauto2_3.layoutParams = LinearLayout.LayoutParams(
                        ViewGroup.LayoutParams.WRAP_CONTENT,
                        ViewGroup.LayoutParams.WRAP_CONTENT, Float.MIN_VALUE)
//                    viewtext2_3.setText(item.checkData.price2_3)
//                    viewtext2_3.setTextColor(Color.parseColor("#000000"))
//                    lein3_E_D.addView(viewtext2_3)
                    lein3_E_D.addView(checkBoxauto2_3)
                }}

            if (item.checkData.check2_4.isNotEmpty()){
                val checkBoxauto2_4 = TextView(this.context)
//                val viewtext2_4 = TextView(this.context)
                customDialogFB.apply {
                    checkBoxauto2_4.setText(item.checkData.check2_4)
                    checkBoxauto2_4.setTextColor(Color.parseColor("#000000"))
                    checkBoxauto2_4.layoutParams = LinearLayout.LayoutParams(
                        ViewGroup.LayoutParams.WRAP_CONTENT,
                        ViewGroup.LayoutParams.WRAP_CONTENT, Float.MIN_VALUE)
//                    viewtext2_4.setText(item.checkData.price2_4)
//                    viewtext2_4.setTextColor(Color.parseColor("#000000"))
//                    lein4_E_D.addView(viewtext2_4)
                    lein4_E_D.addView(checkBoxauto2_4)
                }}

            if (item.checkData.check2_5.isNotEmpty()){
                val checkBoxauto2_5 = TextView(this.context)
//                val viewtext2_5 = TextView(this.context)
                customDialogFB.apply {
                    checkBoxauto2_5.setText(item.checkData.check2_5)
                    checkBoxauto2_5.setTextColor(Color.parseColor("#000000"))
                    checkBoxauto2_5.layoutParams = LinearLayout.LayoutParams(
                        ViewGroup.LayoutParams.WRAP_CONTENT,
                        ViewGroup.LayoutParams.WRAP_CONTENT, Float.MIN_VALUE)
//                    viewtext2_5.setText(item.checkData.price2_5)
//                    viewtext2_5.setTextColor(Color.parseColor("#000000"))
//                    lein5_E_D.addView(viewtext2_5)
                    lein5_E_D.addView(checkBoxauto2_5)
                }}

            if (item.checkData.check2_6.isNotEmpty()){
                val checkBoxauto2_6 = TextView(this.context)
//                val viewtext2_6 = TextView(this.context)
                customDialogFB.apply {
                    checkBoxauto2_6.setText(item.checkData.check2_6)
                    checkBoxauto2_6.setTextColor(Color.parseColor("#000000"))
                    checkBoxauto2_6.layoutParams = LinearLayout.LayoutParams(
                        ViewGroup.LayoutParams.WRAP_CONTENT,
                        ViewGroup.LayoutParams.WRAP_CONTENT, Float.MIN_VALUE)
//                    viewtext2_6.setText(item.checkData.price2_6)
//                    viewtext2_6.setTextColor(Color.parseColor("#000000"))
//                    lein6_E_D.addView(viewtext2_6)
                    lein6_E_D.addView(checkBoxauto2_6)
                }}

            if (item.checkData.check2_7.isNotEmpty()){
                val checkBoxauto2_7 = TextView(this.context)
//                val viewtext2_7 = TextView(this.context)
                customDialogFB.apply {
                    checkBoxauto2_7.setText(item.checkData.check2_7)
                    checkBoxauto2_7.setTextColor(Color.parseColor("#000000"))
                    checkBoxauto2_7.layoutParams = LinearLayout.LayoutParams(
                        ViewGroup.LayoutParams.WRAP_CONTENT,
                        ViewGroup.LayoutParams.WRAP_CONTENT, Float.MIN_VALUE)
//                    viewtext2_7.setText(item.checkData.price2_7)
//                    viewtext2_7.setTextColor(Color.parseColor("#000000"))
//                    lein7_E_D.addView(viewtext2_7)
                    lein7_E_D.addView(checkBoxauto2_7)
                }}

            if (item.checkData.check2_8.isNotEmpty()){
                val checkBoxauto2_8 = TextView(this.context)
//                val viewtext2_8 = TextView(this.context)
                customDialogFB.apply {
                    checkBoxauto2_8.setText(item.checkData.check2_8)
                    checkBoxauto2_8.setTextColor(Color.parseColor("#000000"))
                    checkBoxauto2_8.layoutParams = LinearLayout.LayoutParams(
                        ViewGroup.LayoutParams.WRAP_CONTENT,
                        ViewGroup.LayoutParams.WRAP_CONTENT, Float.MIN_VALUE)
//                    viewtext2_8.setText(item.checkData.price2_8)
//                    viewtext2_8.setTextColor(Color.parseColor("#000000"))
//                    lein8_E_D.addView(viewtext2_8)
                    lein8_E_D.addView(checkBoxauto2_8)
                }}

            if (item.checkData.check2_9.isNotEmpty()){
                val checkBoxauto2_9 = TextView(this.context)
//                val viewtext2_9 = TextView(this.context)
                customDialogFB.apply {
                    checkBoxauto2_9.setText(item.checkData.check2_9)
                    checkBoxauto2_9.setTextColor(Color.parseColor("#000000"))
                    checkBoxauto2_9.layoutParams = LinearLayout.LayoutParams(
                        ViewGroup.LayoutParams.WRAP_CONTENT,
                        ViewGroup.LayoutParams.WRAP_CONTENT, Float.MIN_VALUE)
//                    viewtext2_9.setText(item.checkData.price2_9)
//                    viewtext2_9.setTextColor(Color.parseColor("#000000"))
//                    lein9_E_D.addView(viewtext2_9)
                    lein9_E_D.addView(checkBoxauto2_9)
                }}

            if (item.checkData.check2_10.isNotEmpty()){
                val checkBoxauto2_10 = TextView(this.context)
//                val viewtext2_10 = TextView(this.context)
                customDialogFB.apply {
                    checkBoxauto2_10.setText(item.checkData.check2_10)
                    checkBoxauto2_10.setTextColor(Color.parseColor("#000000"))
                    checkBoxauto2_10.layoutParams = LinearLayout.LayoutParams(
                        ViewGroup.LayoutParams.WRAP_CONTENT,
                        ViewGroup.LayoutParams.WRAP_CONTENT, Float.MIN_VALUE)
//                    viewtext2_10.setText(item.checkData.price2_10)
//                    viewtext2_10.setTextColor(Color.parseColor("#000000"))
//                    lein10_E_D.addView(viewtext2_10)
                    lein10_E_D.addView(checkBoxauto2_10)
                }}

            if (item.checkData.check2_11.isNotEmpty()){
                val checkBoxauto2_11 = TextView(this.context)
//                val viewtext2_11 = TextView(this.context)
                customDialogFB.apply {
                    checkBoxauto2_11.setText(item.checkData.check2_11)
                    checkBoxauto2_11.setTextColor(Color.parseColor("#000000"))
                    checkBoxauto2_11.layoutParams = LinearLayout.LayoutParams(
                        ViewGroup.LayoutParams.WRAP_CONTENT,
                        ViewGroup.LayoutParams.WRAP_CONTENT, Float.MIN_VALUE)
//                    viewtext2_11.setText(item.checkData.price2_11)
//                    viewtext2_11.setTextColor(Color.parseColor("#000000"))
//                    lein11_E_D.addView(viewtext2_11)
                    lein11_E_D.addView(checkBoxauto2_11)
                }}

            if (item.checkData.check2_12.isNotEmpty()){
                val checkBoxauto2_12 = TextView(this.context)
//                val viewtext2_12 = TextView(this.context)
                customDialogFB.apply {
                    checkBoxauto2_12.setText(item.checkData.check2_12)
                    checkBoxauto2_12.setTextColor(Color.parseColor("#000000"))
                    checkBoxauto2_12.layoutParams = LinearLayout.LayoutParams(
                        ViewGroup.LayoutParams.WRAP_CONTENT,
                        ViewGroup.LayoutParams.WRAP_CONTENT, Float.MIN_VALUE)
//                    viewtext2_12.setText(item.checkData.price2_12)
//                    viewtext2_12.setTextColor(Color.parseColor("#000000"))
//                    lein12_E_D.addView(viewtext2_12)
                    lein12_E_D.addView(checkBoxauto2_12)
                }}

            if (item.checkData.check2_13.isNotEmpty()){
                val checkBoxauto2_13 = TextView(this.context)
//                val viewtext2_13 = TextView(this.context)
                customDialogFB.apply {
                    checkBoxauto2_13.setText(item.checkData.check2_13)
                    checkBoxauto2_13.setTextColor(Color.parseColor("#000000"))
                    checkBoxauto2_13.layoutParams = LinearLayout.LayoutParams(
                        ViewGroup.LayoutParams.WRAP_CONTENT,
                        ViewGroup.LayoutParams.WRAP_CONTENT, Float.MIN_VALUE)
//                    viewtext2_13.setText(item.checkData.price2_13)
//                    viewtext2_13.setTextColor(Color.parseColor("#000000"))
//                    lein13_E_D.addView(viewtext2_13)
                    lein13_E_D.addView(checkBoxauto2_13)
                }}

            if (item.checkData.check2_14.isNotEmpty()){
                val checkBoxauto2_14 = TextView(this.context)
//                val viewtext2_14 = TextView(this.context)
                customDialogFB.apply {
                    checkBoxauto2_14.setText(item.checkData.check2_14)
                    checkBoxauto2_14.setTextColor(Color.parseColor("#000000"))
                    checkBoxauto2_14.layoutParams = LinearLayout.LayoutParams(
                        ViewGroup.LayoutParams.WRAP_CONTENT,
                        ViewGroup.LayoutParams.WRAP_CONTENT, Float.MIN_VALUE)
//                    viewtext2_14.setText(item.checkData.price2_14)
//                    viewtext2_14.setTextColor(Color.parseColor("#000000"))
//                    lein14_E_D.addView(viewtext2_14)
                    lein14_E_D.addView(checkBoxauto2_14)
                }}

            if (item.checkData.check2_15.isNotEmpty()){
                val checkBoxauto2_15 = TextView(this.context)
//                val viewtext2_15 = TextView(this.context)
                customDialogFB.apply {
                    checkBoxauto2_15.setText(item.checkData.check2_15)
                    checkBoxauto2_15.setTextColor(Color.parseColor("#000000"))
                    checkBoxauto2_15.layoutParams = LinearLayout.LayoutParams(
                        ViewGroup.LayoutParams.WRAP_CONTENT,
                        ViewGroup.LayoutParams.WRAP_CONTENT, Float.MIN_VALUE)
//                    viewtext2_15.setText(item.checkData.price2_15)
//                    viewtext2_15.setTextColor(Color.parseColor("#000000"))
//                    lein15_E_D.addView(viewtext2_15)
                    lein15_E_D.addView(checkBoxauto2_15)
                }}

            if (item.checkData.check2_16.isNotEmpty()){
                val checkBoxauto2_16 = TextView(this.context)
//                val viewtext2_16 = TextView(this.context)
                customDialogFB.apply {
                    checkBoxauto2_16.setText(item.checkData.check2_16)
                    checkBoxauto2_16.setTextColor(Color.parseColor("#000000"))
                    checkBoxauto2_16.layoutParams = LinearLayout.LayoutParams(
                        ViewGroup.LayoutParams.WRAP_CONTENT,
                        ViewGroup.LayoutParams.WRAP_CONTENT, Float.MIN_VALUE)
//                    viewtext2_16.setText(item.checkData.price2_16)
//                    viewtext2_16.setTextColor(Color.parseColor("#000000"))
//                    lein16_E_D.addView(viewtext2_16)
                    lein16_E_D.addView(checkBoxauto2_16)
                }}

            if (item.checkData.check2_17.isNotEmpty()){
                val checkBoxauto2_17 = TextView(this.context)
                val viewtext2_17 = TextView(this.context)
                customDialogFB.apply {
                    checkBoxauto2_17.setText(item.checkData.check2_17)
                    checkBoxauto2_17.setTextColor(Color.parseColor("#000000"))
                    checkBoxauto2_17.layoutParams = LinearLayout.LayoutParams(
                        ViewGroup.LayoutParams.WRAP_CONTENT,
                        ViewGroup.LayoutParams.WRAP_CONTENT, Float.MIN_VALUE)
//                    viewtext2_17.setText(item.checkData.price2_17)
//                    viewtext2_17.setTextColor(Color.parseColor("#000000"))
//                    lein17_E_D.addView(viewtext2_17)
                    lein17_E_D.addView(checkBoxauto2_17)
                }}

            if (item.checkData.check2_18.isNotEmpty()){
                val checkBoxauto2_18 = TextView(this.context)
//                val viewtext2_18 = TextView(this.context)
                customDialogFB.apply {
                    checkBoxauto2_18.setText(item.checkData.check2_18)
                    checkBoxauto2_18.setTextColor(Color.parseColor("#000000"))
                    checkBoxauto2_18.layoutParams = LinearLayout.LayoutParams(
                        ViewGroup.LayoutParams.WRAP_CONTENT,
                        ViewGroup.LayoutParams.WRAP_CONTENT, Float.MIN_VALUE)
//                    viewtext2_18.setText(item.checkData.price2_18)
//                    viewtext2_18.setTextColor(Color.parseColor("#000000"))
//                    lein18_E_D.addView(viewtext2_18)
                    lein18_E_D.addView(checkBoxauto2_18)
                }}

            if (item.checkData.check2_19.isNotEmpty()){
                val checkBoxauto2_19 = TextView(this.context)
//                val viewtext2_19 = TextView(this.context)
                customDialogFB.apply {
                    checkBoxauto2_19.setText(item.checkData.check2_19)
                    checkBoxauto2_19.setTextColor(Color.parseColor("#000000"))
                    checkBoxauto2_19.layoutParams = LinearLayout.LayoutParams(
                        ViewGroup.LayoutParams.WRAP_CONTENT,
                        ViewGroup.LayoutParams.WRAP_CONTENT, Float.MIN_VALUE)
//                    viewtext2_19.setText(item.checkData.price2_19)
//                    viewtext2_19.setTextColor(Color.parseColor("#000000"))
//                    lein19_E_D.addView(viewtext2_19)
                    lein19_E_D.addView(checkBoxauto2_19)
                }}

            if (item.checkData.check2_20.isNotEmpty()){
                val checkBoxauto2_20 = TextView(this.context)
//                val viewtext2_20 = TextView(this.context)
                customDialogFB.apply {
                    checkBoxauto2_20.setText(item.checkData.check2_20)
                    checkBoxauto2_20.setTextColor(Color.parseColor("#000000"))
                    checkBoxauto2_20.layoutParams = LinearLayout.LayoutParams(
                        ViewGroup.LayoutParams.WRAP_CONTENT,
                        ViewGroup.LayoutParams.WRAP_CONTENT, Float.MIN_VALUE)
//                    viewtext2_20.setText(item.checkData.price2_20)
//                    viewtext2_20.setTextColor(Color.parseColor("#000000"))
//                    lein20_E_D.addView(viewtext2_20)
                    lein20_E_D.addView(checkBoxauto2_20)
                }}

            if (item.checkData.check2_21.isNotEmpty()){
                val checkBoxauto2_21 = TextView(this.context)
//                val viewtext2_21 = TextView(this.context)
                customDialogFB.apply {
                    checkBoxauto2_21.setText(item.checkData.check2_21)
                    checkBoxauto2_21.setTextColor(Color.parseColor("#000000"))
                    checkBoxauto2_21.layoutParams = LinearLayout.LayoutParams(
                        ViewGroup.LayoutParams.WRAP_CONTENT,
                        ViewGroup.LayoutParams.WRAP_CONTENT, Float.MIN_VALUE)
//                    viewtext2_21.setText(item.checkData.price2_21)
//                    viewtext2_21.setTextColor(Color.parseColor("#000000"))
//                    lein21_E_D.addView(viewtext2_21)
                    lein21_E_D.addView(checkBoxauto2_21)
                }}

            if (item.checkData.check2_22.isNotEmpty()){
                val checkBoxauto2_22 = TextView(this.context)
//                val viewtext2_22 = TextView(this.context)
                customDialogFB.apply {
                    checkBoxauto2_22.setText(item.checkData.check2_22)
                    checkBoxauto2_22.setTextColor(Color.parseColor("#000000"))
                    checkBoxauto2_22.layoutParams = LinearLayout.LayoutParams(
                        ViewGroup.LayoutParams.WRAP_CONTENT,
                        ViewGroup.LayoutParams.WRAP_CONTENT, Float.MIN_VALUE)
//                    viewtext2_22.setText(item.checkData.price2_22)
//                    viewtext2_22.setTextColor(Color.parseColor("#000000"))
//                    lein22_E_D.addView(viewtext2_22)
                    lein22_E_D.addView(checkBoxauto2_22)
                }}

            if (item.checkData.check3_1.isNotEmpty()){
                val checkBoxauto3_1 = TextView(this.context)
                val viewtext3_1 = TextView(this.context)
                customDialogFB.apply {
                    checkBoxauto3_1.setText(item.checkData.check3_1)
                    checkBoxauto3_1.setTextColor(Color.parseColor("#000000"))
                    checkBoxauto3_1.layoutParams = LinearLayout.LayoutParams(
                        ViewGroup.LayoutParams.WRAP_CONTENT,
                        ViewGroup.LayoutParams.WRAP_CONTENT, Float.MIN_VALUE)
//                    viewtext3_1.setText(item.checkData.price3_1)
//                    viewtext3_1.setTextColor(Color.parseColor("#000000"))
//                    lein_E_D.addView(viewtext3_1)
                    lein_E_D.addView(checkBoxauto3_1)
                }}

            if (item.checkData.check3_2.isNotEmpty()){
                val checkBoxauto3_2 = TextView(this.context)
//                val viewtext3_2 = TextView(this.context)
                customDialogFB.apply {
                    checkBoxauto3_2.setText(item.checkData.check3_2)
                    checkBoxauto3_2.setTextColor(Color.parseColor("#000000"))
                    checkBoxauto3_2.layoutParams = LinearLayout.LayoutParams(
                        ViewGroup.LayoutParams.WRAP_CONTENT,
                        ViewGroup.LayoutParams.WRAP_CONTENT, Float.MIN_VALUE)
//                    viewtext3_2.setText(item.checkData.price3_2)
//                    viewtext3_2.setTextColor(Color.parseColor("#000000"))
//                    lein2_E_D.addView(viewtext3_2)
                    lein2_E_D.addView(checkBoxauto3_2)
                }}

            if (item.checkData.check3_3.isNotEmpty()){
                val checkBoxauto3_3 = TextView(this.context)
//                val viewtext3_3 = TextView(this.context)
                customDialogFB.apply {
                    checkBoxauto3_3.setText(item.checkData.check3_3)
                    checkBoxauto3_3.setTextColor(Color.parseColor("#000000"))
                    checkBoxauto3_3.layoutParams = LinearLayout.LayoutParams(
                        ViewGroup.LayoutParams.WRAP_CONTENT,
                        ViewGroup.LayoutParams.WRAP_CONTENT, Float.MIN_VALUE)
//                    viewtext3_3.setText(item.checkData.price3_3)
//                    viewtext3_3.setTextColor(Color.parseColor("#000000"))
//                    lein3_E_D.addView(viewtext3_3)
                    lein3_E_D.addView(checkBoxauto3_3)
                }}

            if (item.checkData.check3_4.isNotEmpty()){
                val checkBoxauto3_4 = TextView(this.context)
//                val viewtext3_4 = TextView(this.context)
                customDialogFB.apply {
                    checkBoxauto3_4.setText(item.checkData.check3_4)
                    checkBoxauto3_4.setTextColor(Color.parseColor("#000000"))
                    checkBoxauto3_4.layoutParams = LinearLayout.LayoutParams(
                        ViewGroup.LayoutParams.WRAP_CONTENT,
                        ViewGroup.LayoutParams.WRAP_CONTENT, Float.MIN_VALUE)
//                    viewtext3_4.setText(item.checkData.price3_4)
//                    viewtext3_4.setTextColor(Color.parseColor("#000000"))
//                    lein4_E_D.addView(viewtext3_4)
                    lein4_E_D.addView(checkBoxauto3_4)
                }}

            if (item.checkData.check3_5.isNotEmpty()){
                val checkBoxauto3_5 = TextView(this.context)
//                val viewtext3_5 = TextView(this.context)
                customDialogFB.apply {
                    checkBoxauto3_5.setText(item.checkData.check3_5)
                    checkBoxauto3_5.setTextColor(Color.parseColor("#000000"))
                    checkBoxauto3_5.layoutParams = LinearLayout.LayoutParams(
                        ViewGroup.LayoutParams.WRAP_CONTENT,
                        ViewGroup.LayoutParams.WRAP_CONTENT, Float.MIN_VALUE)
//                    viewtext3_5.setText(item.checkData.price3_5)
//                    viewtext3_5.setTextColor(Color.parseColor("#000000"))
//                    lein5_E_D.addView(viewtext3_5)
                    lein5_E_D.addView(checkBoxauto3_5)
                }}

            if (item.checkData.check3_6.isNotEmpty()){
                val checkBoxauto3_6 = TextView(this.context)
//                val viewtext3_6 = TextView(this.context)
                customDialogFB.apply {
                    checkBoxauto3_6.setText(item.checkData.check3_6)
                    checkBoxauto3_6.setTextColor(Color.parseColor("#000000"))
                    checkBoxauto3_6.layoutParams = LinearLayout.LayoutParams(
                        ViewGroup.LayoutParams.WRAP_CONTENT,
                        ViewGroup.LayoutParams.WRAP_CONTENT, Float.MIN_VALUE)
//                    viewtext3_6.setText(item.checkData.price3_6)
//                    viewtext3_6.setTextColor(Color.parseColor("#000000"))
//                    lein6_E_D.addView(viewtext3_6)
                    lein6_E_D.addView(checkBoxauto3_6)
                }}
customDialogFB.cancel2_edit.setOnClickListener {
    customDialogFB.dismiss()
}
            customDialogFB.show()
     }
    }

    private fun isNetworkAvailable(context: Context): Boolean {
        val connectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val activeNetworkInfo = connectivityManager.activeNetworkInfo
        return activeNetworkInfo != null && activeNetworkInfo.isConnected
    }
}
