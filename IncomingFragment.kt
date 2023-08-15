package com.example.mizanalnasr.ui.Incom

import android.annotation.SuppressLint
import android.app.Dialog
import android.arch.lifecycle.ViewModelProviders
import android.content.Context
import android.content.Context.INPUT_METHOD_SERVICE
import android.graphics.Color
import android.graphics.Typeface
import android.graphics.drawable.ColorDrawable
import android.net.ConnectivityManager
import android.os.Build
import android.os.Bundle
import android.support.annotation.RequiresApi
import android.support.design.widget.FloatingActionButton
import android.support.v4.app.Fragment
import android.support.v7.widget.DividerItemDecoration
import android.text.Editable
import android.text.InputType
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
import com.example.mizanalnasr.model.CheckMainData
import com.example.mizanalnasr.recycler.SenderTextMessageItem
import com.example.neprotest.glide.GlideApp
import com.example.neprotest.model.CheckData
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.*
import com.google.firebase.storage.FirebaseStorage
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.OnItemClickListener
import com.xwray.groupie.OnItemLongClickListener
import com.xwray.groupie.Section
import com.xwray.groupie.ViewHolder
import com.xwray.groupie.kotlinandroidextensions.Item
import kotlinx.android.synthetic.main.activity_sign_up.*
import kotlinx.android.synthetic.main.app_bar_main.*
import kotlinx.android.synthetic.main.calendar_dailog.*
import kotlinx.android.synthetic.main.camera_dailog.*
import kotlinx.android.synthetic.main.dialog_accept.*
import kotlinx.android.synthetic.main.dialog_delete.*
import kotlinx.android.synthetic.main.edit_dailog.*
import kotlinx.android.synthetic.main.fragment_first.*
import kotlinx.android.synthetic.main.fragment_incoming.*
import kotlinx.android.synthetic.main.fragment_incoming.view.*
import kotlinx.android.synthetic.main.fragment_outcoming.*
import kotlinx.android.synthetic.main.image_view.*
import kotlinx.android.synthetic.main.paying_dailog.*
import kotlinx.android.synthetic.main.recyclerbox.*
import java.text.SimpleDateFormat
import java.time.LocalDate
import java.time.LocalTime
import java.util.*

class IncomingFragment : Fragment() {
    private var _binding: FragmentIncomingBinding? = null

    var sum =""

    private lateinit var viewModel: IncomingViewModel

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
    var totalM5ra6ah :Int = 0

    var start_date =""
    var end_date =""

    private lateinit var checkBoxauto1: EditText
    private lateinit var viewtext1: EditText
    private lateinit var checkBoxauto2: EditText
    private lateinit var viewtext2: EditText
    private lateinit var checkBoxauto3: EditText
    private lateinit var viewtext3: EditText
    private lateinit var checkBoxauto4: EditText
    private lateinit var viewtext4: EditText
    private lateinit var checkBoxauto5: EditText
    private lateinit var viewtext5: EditText
    private lateinit var checkBoxauto6: EditText
    private lateinit var viewtext6: EditText
    private lateinit var checkBoxauto7: EditText
    private lateinit var viewtext7: EditText
    private lateinit var checkBoxauto8: EditText
    private lateinit var viewtext8: EditText
    private lateinit var checkBoxauto9: EditText
    private lateinit var viewtext9: EditText
    private lateinit var checkBoxauto10: EditText
    private lateinit var viewtext10: EditText
    private lateinit var checkBoxauto11: EditText
    private lateinit var viewtext11: EditText
    private lateinit var checkBoxauto12: EditText
    private lateinit var viewtext12: EditText
    private lateinit var checkBoxauto13: EditText
    private lateinit var viewtext13: EditText
    private lateinit var checkBoxauto14: EditText
    private lateinit var viewtext14: EditText
    private lateinit var checkBoxauto15: EditText
    private lateinit var viewtext15: EditText
    private lateinit var checkBoxauto16: EditText
    private lateinit var viewtext16: EditText
    private lateinit var checkBoxauto17: EditText
    private lateinit var viewtext17: EditText
    private lateinit var checkBoxauto18: EditText
    private lateinit var viewtext18: EditText
    private lateinit var checkBoxauto19: EditText
    private lateinit var viewtext19: EditText
    private lateinit var checkBoxauto20: EditText
    private lateinit var viewtext20: EditText
    private lateinit var checkBoxauto21: EditText
    private lateinit var viewtext21: EditText
    private lateinit var checkBoxauto22: EditText
    private lateinit var viewtext22: EditText
    private lateinit var checkBoxauto23: EditText
    private lateinit var viewtext23: EditText
    private lateinit var checkBoxauto24: EditText
    private lateinit var viewtext24: EditText
    private lateinit var checkBoxauto25: EditText
    private lateinit var viewtext25: EditText
    private lateinit var checkBoxauto26: EditText
    private lateinit var viewtext26: EditText
    private lateinit var checkBoxauto27: EditText
    private lateinit var viewtext27: EditText
    private lateinit var checkBoxauto28: EditText
    private lateinit var viewtext28: EditText
    private lateinit var checkBoxauto29: EditText
    private lateinit var viewtext29: EditText
    private lateinit var checkBoxauto30: EditText
    private lateinit var viewtext30: EditText
    private lateinit var checkBoxauto31: EditText
    private lateinit var viewtext31: EditText
    private lateinit var checkBoxauto32: EditText
    private lateinit var viewtext32: EditText
    private lateinit var checkBoxauto33: EditText
    private lateinit var viewtext33: EditText
    private lateinit var checkBoxauto34: EditText
    private lateinit var viewtext34: EditText
    private lateinit var checkBoxauto35: EditText
    private lateinit var viewtext35: EditText
    private lateinit var checkBoxauto36: EditText
    private lateinit var viewtext36: EditText
    private lateinit var checkBoxauto37: EditText
    private lateinit var viewtext37: EditText
    private lateinit var checkBoxauto38: EditText
    private lateinit var viewtext38: EditText
    private lateinit var checkBoxauto39: EditText
    private lateinit var viewtext39: EditText
    private lateinit var checkBoxauto40: EditText
    private lateinit var viewtext40: EditText
    private lateinit var checkBoxauto41: EditText
    private lateinit var viewtext41: EditText
    private lateinit var checkBoxauto42: EditText
    private lateinit var viewtext42: EditText
    private lateinit var checkBoxauto43: EditText
    private lateinit var viewtext43: EditText
    private lateinit var checkBoxauto44: EditText
    private lateinit var viewtext44: EditText
    private lateinit var checkBoxauto45: EditText
    private lateinit var viewtext45: EditText
    private lateinit var checkBoxauto46: EditText
    private lateinit var viewtext46: EditText
    private lateinit var checkBoxauto47: EditText
    private lateinit var viewtext47: EditText
    private lateinit var checkBoxauto48: EditText
    private lateinit var viewtext48: EditText
    private lateinit var checkBoxauto49: EditText
    private lateinit var viewtext49: EditText
    private lateinit var checkBoxauto50: EditText
    private lateinit var viewtext50: EditText
    private lateinit var checkBoxauto51: EditText
    private lateinit var viewtext51: EditText
    private lateinit var checkBoxauto52: EditText
    private lateinit var viewtext52: EditText
    private lateinit var checkBoxauto53: EditText
    private lateinit var viewtext53: EditText
    private lateinit var checkBoxauto54: EditText
    private lateinit var viewtext54: EditText
    private lateinit var checkBoxauto55: EditText
    private lateinit var viewtext55: EditText
    private lateinit var checkBoxauto56: EditText
    private lateinit var viewtext56: EditText
    private lateinit var checkBoxauto57: EditText
    private lateinit var viewtext57: EditText
    private lateinit var checkBoxauto58: EditText
    private lateinit var viewtext58: EditText
    private lateinit var checkBoxauto59: EditText
    private lateinit var viewtext59: EditText

    private val storageInstance: FirebaseStorage by lazy {
        FirebaseStorage.getInstance()
    }
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        _binding = FragmentIncomingBinding.inflate(inflater, container, false)
        val root: View = binding.root

        viewModel = activity?.run {
            ViewModelProviders.of(this).get(IncomingViewModel::class.java)
        } ?: throw Exception("Invalid Activity")

        if (!isNetworkAvailable(requireContext())) {
            Toast.makeText(requireContext(), "خدمة الانترنت غير متوفرة", Toast.LENGTH_LONG).apply {
                setGravity(Gravity.CENTER, 0, 200)
                show()
            }
        }

        val fab = activity?.findViewById<FloatingActionButton>(R.id.fab)
        val fab1 = activity?.findViewById<FloatingActionButton>(R.id.fab1)
        val fab2 = activity?.findViewById<FloatingActionButton>(R.id.fab2)
        fab!!.hide()
        fab1!!.hide()
        fab2!!.hide()
//        RecipientId = activity?.intent!!.getStringExtra("other_uid").toString()
        RecipientId = "zydXcSSEwZaPsNVwZ1oiDQubnjG3"
        root.btn_end_calendar.isEnabled=false

        createChatChannel { channelId ->
            mCurrentChatChannelId = channelId
            getMessages(channelId,::initRecyclerView)
            getTotal(channelId)
        }
//        eaglealignment21@yahoo.com

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
       TODO("VERSION.SDK_INT < O")
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
                    totalM5ra6ah= 0
                    if (task.isSuccessful) {
                        for (i in task.result!!.documents) {
                            if(  i.toObject(CheckData::class.java)!!.cash_price11.isNotEmpty()){
                                totalQuantity += i.toObject(CheckData::class.java)!!.cash_price11.toInt()
                            }
                            if(  i.toObject(CheckData::class.java)!!.wallet_price1.isNotEmpty()){
                                totalQuantity += i.toObject(CheckData::class.java)!!.wallet_price1.toInt()
                            }
                            if(  i.toObject(CheckData::class.java)!!.price3_5.isNotEmpty()){
                                totalM5ra6ah += i.toObject(CheckData::class.java)!!.price3_5.toInt()
                            }
                            if(  i.toObject(CheckData::class.java)!!.price3_6.isNotEmpty()){
                                totalM5ra6ah += i.toObject(CheckData::class.java)!!.price3_6.toInt()
                            }

                        }
                        texticoming.text="مجموع الكاش "+totalQuantity.toString()
                        texttotalm6ra6ah.text="مجموع المخرطة "+totalM5ra6ah.toString()
                    }
                }
        }

        if(search_incoming.text.toString().isNotEmpty()){
            val searchname=search_incoming.text.toString()
            totalQuantity=0
            totalM5ra6ah=0
            chatChannelsCollectionRef.document(channelId).collection("messages")
                .orderBy(getField(searchname))
                .startAt(searchname).endAt(searchname + "\uf8ff")
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
                                if (i.toObject(CheckData::class.java)!!.receivables_price1.isEmpty()) {
                                    if (i.toObject(CheckData::class.java)!!.price3_5.isNotEmpty()) {
                                        totalM5ra6ah += i.toObject(CheckData::class.java)!!.price3_5.toInt()
                                    }
                                    if (i.toObject(CheckData::class.java)!!.price3_6.isNotEmpty()) {
                                        totalM5ra6ah += i.toObject(CheckData::class.java)!!.price3_6.toInt()
                                    }
                                }
                            }
                            texticoming.text="مجموع الكاش "+totalQuantity.toString()
                            texttotalm6ra6ah.text="مجموع المخرطة "+totalM5ra6ah.toString()

                        }
                    }
                }
        else {
            totalQuantity=0
            totalM5ra6ah=0
            chatChannelsCollectionRef.document(channelId).collection("messages")
                    .orderBy("date")
                    .startAt(startDate).endAt(endtDate)
                .get()
                .addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        for (i in task.result!!.documents) {
                            if (i.toObject(CheckData::class.java)!!.cash_price11.isNotEmpty()) {
                                totalQuantity += i.toObject(CheckData::class.java)!!.cash_price11.toInt()
                                viewModel.totalrecinc += i.toObject(CheckData::class.java)!!.cash_price11.toInt()
                            }
                            if (i.toObject(CheckData::class.java)!!.wallet_price1.isNotEmpty()) {
                                totalQuantity += i.toObject(CheckData::class.java)!!.wallet_price1.toInt()
                            }
                            if (i.toObject(CheckData::class.java)!!.receivables_price1.isEmpty()) {
                                if (i.toObject(CheckData::class.java)!!.price3_5.isNotEmpty()) {
                                    totalM5ra6ah += i.toObject(CheckData::class.java)!!.price3_5.toInt()
                                }
                                if (i.toObject(CheckData::class.java)!!.price3_6.isNotEmpty()) {
                                    totalM5ra6ah += i.toObject(CheckData::class.java)!!.price3_6.toInt()
                                }
                            }
                        }
                        texticoming.text = "مجموع الكاش " + totalQuantity.toString()
                        texttotalm6ra6ah.text="مجموع المخرطة "+totalM5ra6ah.toString()
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
                                document.toObject(CheckMainData::class.java)!!,
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
                .orderBy(getField(searchname))
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
                                    document.toObject(CheckMainData::class.java)!!,
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
                                document.toObject(CheckMainData::class.java)!!,
                                this.context!!
                            )
                        )
                    }
                    onListen(items)
                }
        }
    }

    fun getField(searchname: String): String {
        return when {
            searchname.matches(Regex("^079.*")) -> "cusphone"
            searchname.matches(Regex("^078.*")) -> "cusphone"
            searchname.matches(Regex("^077.*")) -> "cusphone"
            searchname.matches(Regex("^\\d{2}.*$")) -> "numcar"
            searchname.matches(Regex("^ذمم.*")) -> "receivables1"
            else -> "cusname"
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
                setOnItemLongClickListener(onItemLongClick)

            }
        }
    }

    private val onItemLongClick = OnItemLongClickListener { item, view ->
        if (item is SenderTextMessageItem){
            val customDialogDL = Dialog(activity!!)
            customDialogDL.setContentView(R.layout.dialog_delete)
            customDialogDL.setCancelable(false)
            customDialogDL.window?.setLayout(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
            )
            customDialogDL.show()
            customDialogDL.dl_yes.setOnClickListener {
                if (!isNetworkAvailable(requireContext())) {
                    Toast.makeText(requireContext(), "خدمة الانترنت غير متوفرة", Toast.LENGTH_LONG)
                        .apply {
                            setGravity(Gravity.CENTER, 0, 0)
                            show()
                        }
                } else {
                    chatChannelsCollectionRef.document(mCurrentChatChannelId)
                        .collection("messages")
                        .document(item.messageId)
                        .delete()
                        .addOnSuccessListener {
                            Toast.makeText(
                                requireContext(),
                                "تم الحذف من قاعدة البيانات",
                                Toast.LENGTH_LONG
                            ).show()
                        }
                        .addOnFailureListener { Toast.makeText(requireContext(), "فشل عملية الحذف", Toast.LENGTH_LONG)}
//                e -> Log.w(TAG, "فشل عملية الحذف")
                    customDialogDL.dismiss()
                }
            }

            customDialogDL.dl_no.setOnClickListener {
                customDialogDL.dismiss()
            }
        }
        true
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

            checkBoxauto1 = EditText(this.context)
            viewtext1 = EditText(this.context)
            checkBoxauto2 = EditText(this.context)
            viewtext2 = EditText(this.context)
            checkBoxauto3 = EditText(this.context)
            viewtext3 = EditText(this.context)
            checkBoxauto4 = EditText(this.context)
            checkBoxauto5 = EditText(this.context)
            checkBoxauto6 = EditText(this.context)
            checkBoxauto7 = EditText(this.context)
            checkBoxauto8 = EditText(this.context)
            checkBoxauto9 = EditText(this.context)
            checkBoxauto10 = EditText(this.context)
            checkBoxauto11 = EditText(this.context)
            checkBoxauto12 = EditText(this.context)
            checkBoxauto13 = EditText(this.context)
            checkBoxauto14 = EditText(this.context)
            checkBoxauto15 = EditText(this.context)
            checkBoxauto16 = EditText(this.context)
            checkBoxauto17 = EditText(this.context)
            checkBoxauto18 = EditText(this.context)
            checkBoxauto19 = EditText(this.context)
            checkBoxauto20 = EditText(this.context)
            checkBoxauto21 = EditText(this.context)
            checkBoxauto22 = EditText(this.context)
            checkBoxauto23 = EditText(this.context)
            checkBoxauto24 = EditText(this.context)
            checkBoxauto25 = EditText(this.context)
            checkBoxauto26 = EditText(this.context)
            checkBoxauto27 = EditText(this.context)
            checkBoxauto28 = EditText(this.context)
            checkBoxauto29 = EditText(this.context)
            checkBoxauto30 = EditText(this.context)
            checkBoxauto31 = EditText(this.context)
            checkBoxauto32 = EditText(this.context)
            checkBoxauto33 = EditText(this.context)
            checkBoxauto34 = EditText(this.context)
            checkBoxauto35 = EditText(this.context)
            checkBoxauto36 = EditText(this.context)
            checkBoxauto37 = EditText(this.context)
            checkBoxauto38 = EditText(this.context)
            checkBoxauto39 = EditText(this.context)
            checkBoxauto40 = EditText(this.context)
            checkBoxauto41 = EditText(this.context)
            checkBoxauto42 = EditText(this.context)
            checkBoxauto43 = EditText(this.context)
            checkBoxauto44 = EditText(this.context)
            checkBoxauto45 = EditText(this.context)
            checkBoxauto46 = EditText(this.context)
            checkBoxauto47 = EditText(this.context)
            checkBoxauto48 = EditText(this.context)
            checkBoxauto49 = EditText(this.context)
            checkBoxauto50 = EditText(this.context)
            checkBoxauto51 = EditText(this.context)
            checkBoxauto52 = EditText(this.context)
            checkBoxauto53 = EditText(this.context)
            checkBoxauto54 = EditText(this.context)
            checkBoxauto55 = EditText(this.context)
            checkBoxauto56 = EditText(this.context)
            checkBoxauto57 = EditText(this.context)
            checkBoxauto58 = EditText(this.context)
            checkBoxauto59 = EditText(this.context)

            viewtext4 = EditText(this.context)
            viewtext5 = EditText(this.context)
            viewtext6 = EditText(this.context)
            viewtext7 = EditText(this.context)
            viewtext8 = EditText(this.context)
            viewtext9 = EditText(this.context)
            viewtext10 = EditText(this.context)
            viewtext11 = EditText(this.context)
            viewtext12 = EditText(this.context)
            viewtext13 = EditText(this.context)
            viewtext14 = EditText(this.context)
            viewtext15 = EditText(this.context)
            viewtext16 = EditText(this.context)
            viewtext17 = EditText(this.context)
            viewtext18 = EditText(this.context)
            viewtext19 = EditText(this.context)
            viewtext20 = EditText(this.context)
            viewtext21 = EditText(this.context)
            viewtext22 = EditText(this.context)
            viewtext23 = EditText(this.context)
            viewtext24 = EditText(this.context)
            viewtext25 = EditText(this.context)
            viewtext26 = EditText(this.context)
            viewtext27 = EditText(this.context)
            viewtext28 = EditText(this.context)
            viewtext29 = EditText(this.context)
            viewtext30 = EditText(this.context)
            viewtext31 = EditText(this.context)
            viewtext32 = EditText(this.context)
            viewtext33 = EditText(this.context)
            viewtext34 = EditText(this.context)
            viewtext35 = EditText(this.context)
            viewtext36 = EditText(this.context)
            viewtext37 = EditText(this.context)
            viewtext38 = EditText(this.context)
            viewtext39 = EditText(this.context)
            viewtext40 = EditText(this.context)
            viewtext41 = EditText(this.context)
            viewtext42 = EditText(this.context)
            viewtext43 = EditText(this.context)
            viewtext44 = EditText(this.context)
            viewtext45 = EditText(this.context)
            viewtext46 = EditText(this.context)
            viewtext47 = EditText(this.context)
            viewtext48 = EditText(this.context)
            viewtext49 = EditText(this.context)
            viewtext50 = EditText(this.context)
            viewtext51 = EditText(this.context)
            viewtext52 = EditText(this.context)
            viewtext53 = EditText(this.context)
            viewtext54 = EditText(this.context)
            viewtext55 = EditText(this.context)
            viewtext56 = EditText(this.context)
            viewtext57 = EditText(this.context)
            viewtext58 = EditText(this.context)
            viewtext59 = EditText(this.context)


            if (item.checkData.customerImage.isNotEmpty()) {
                GlideApp.with(context!!)
                    .load(storageInstance.getReference(item.checkData.customerImage))
                    .into(customDialogFB.img_show_incom)
            }
            customDialogFB.img_show_incom.setOnClickListener {
//                val currentImage = customDialogFB.img_show_incom.drawable
//                val defaultImage = resources.getDrawable(R.mipmap.logo_foreground, null)
//                if (currentImage == defaultImage) {
//                    Toast.makeText(requireContext(), "خدمة الانترنت غير متوفرة", Toast.LENGTH_LONG).apply {
//                        setGravity(Gravity.TOP, 0, 0)
//                        show()
//                    }
//                }
//                else{
                    GlideApp.with(context!!)
                        .load(storageInstance.getReference(item.checkData.customerImage))
                        .into(customDialogIMG.img_full_scren)
                    customDialogIMG.show()
//                }
            }
            customDialogFB.name_E_D.setText(item.checkData.cusname)
            customDialogFB.phone_E_D.setText(item.checkData.cusphone)
            customDialogFB.plate_E_D.setText(item.checkData.numcar)
            customDialogFB.totalall_E_D.text = item.checkData.total
            customDialogFB.totalall_E_D.gravity = Gravity.CENTER
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
            var total = ""

            var ech1 = ""
            var ech2 = ""
            var ech3 = ""
            var ech4 = ""
            var ech5 = ""
            var ech6 = ""
            var ech7 = ""
            var ech8 = ""
            var ech9 = ""
            var ech10 = ""
            var ech11 = ""
            var ech12 = ""
            var ech13 = ""
            var ech14 = ""
            var ech15 = ""
            var ech16 = ""
            var ech17 = ""
            var ech18 = ""
            var ech19 = ""
            var ech20 = ""
            var ech21 = ""
            var ech22 = ""
            var ech23 = ""
            var ech24 = ""
            var ech25 = ""
            var ech26 = ""
            var ech27 = ""
            var ech28 = ""
            var ech29 = ""
            var ech30 = ""
            var ech31 = ""
            var ech32 = ""
            var ech33 = ""
            var ech34 = ""
            var ech35 = ""
            var ech36 = ""
            var ech37 = ""
            var ech38 = ""
            var ech39 = ""
            var ech40 = ""
            var ech41 = ""
            var ech42 = ""
            var ech43 = ""
            var ech44 = ""
            var ech45 = ""
            var ech46 = ""
            var ech47 = ""
            var ech48 = ""
            var ech49 = ""
            var ech50 = ""
            var ech51 = ""
            var ech52 = ""
            var ech53 = ""
            var ech54 = ""
            var ech55 = ""
            var ech56 = ""
            var ech57 = ""
            var ech58 = ""
            var ech59 = ""

            var epr1 =""
            var epr2 =""
            var epr3 =""
            var epr4 =""
            var epr5 =""
            var epr6 =""
            var epr7 =""
            var epr8 =""
            var epr9 =""
            var epr10 =""
            var epr11 =""
            var epr12 =""
            var epr13 =""
            var epr14 =""
            var epr15 =""
            var epr16 =""
            var epr17 =""
            var epr18 =""
            var epr19 =""
            var epr20 =""
            var epr21 =""
            var epr22 =""
            var epr23 =""
            var epr24 =""
            var epr25 =""
            var epr26 =""
            var epr27 =""
            var epr28 =""
            var epr29 =""
            var epr30 =""
            var epr31 =""
            var epr32 =""
            var epr33 =""
            var epr34 =""
            var epr35 =""
            var epr36 =""
            var epr37 =""
            var epr38 =""
            var epr39 =""
            var epr40 =""
            var epr41 =""
            var epr42 =""
            var epr43 =""
            var epr44 =""
            var epr45 =""
            var epr46 =""
            var epr47 =""
            var epr48 =""
            var epr49 =""
            var epr50 =""
            var epr51 =""
            var epr52 =""
            var epr53 =""
            var epr54 =""
            var epr55 =""
            var epr56 =""
            var epr57 =""
            var epr58 =""
            var epr59 =""


            var totalrecivable :Int=0
            var total_cash :Int =0
            var total_wallte :Int=0
            var total_credit :Int=0
            var total_discount :Int=0

            if (item.checkData.ojor2ed.isNotEmpty()){
                customDialogFB.apply {
                    oj_2yed_img.setText("اجور ايد  " + item.checkData.ojor2ed)
                }
            }

            if (item.checkData.ojorm5r6ah.isNotEmpty()){
                customDialogFB.apply {
                    m5r6ah_img.setText("اجور مخرطة  " + item.checkData.ojorm5r6ah)
                }
            }

            if (item.checkData.mjmo3came > 0.toString()){
                customDialogFB.apply {
                    total_img.setText("مجوع الاجور  " + item.checkData.mjmo3came)
                }
            }

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
                        gravity = Gravity.RIGHT
                    }
                }
            }

                    customDialogFB.add_cash_price_E.setOnEditorActionListener { textView, i, keyEvent ->
                    if (i==EditorInfo.IME_ACTION_DONE) {
                        if(customDialogFB.add_cash_price_E.text.toString().toInt() > customDialogFB.edit_receivabel_price.text.toString().toInt()){
                            Toast.makeText(requireContext(), "القيمة المدخلة اكبر من قيمة الذمم", Toast.LENGTH_LONG)
                                .show()}else{
                            total_cash += customDialogFB.add_cash_price_E.text.toString().toInt()
                            customDialogFB.edit_cash_price.text = total_cash.toString()
                            totalrecivable -= customDialogFB.add_cash_price_E.text.toString().toInt()
                            customDialogFB.edit_receivabel_price.text = totalrecivable.toString()
                            customDialogFB.add_cash_price_E.setText("")}
                            val imm: InputMethodManager = context!!.getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
                            if (imm.isActive)
                                imm.toggleSoftInput(InputMethodManager.HIDE_IMPLICIT_ONLY, 0)
                            true
                        }else{ false }
                }

            customDialogFB.add_wallte_price_E.setOnEditorActionListener { textView, i, keyEvent ->
                if (i==EditorInfo.IME_ACTION_DONE){
                    if(customDialogFB.add_wallte_price_E.text.toString().toInt() > customDialogFB.edit_receivabel_price.text.toString().toInt()){
                        Toast.makeText(requireContext(), "القيمة المدخلة اكبر من قيمة الذمم", Toast.LENGTH_LONG)
                            .show()}else{
                    total_wallte +=  customDialogFB.add_wallte_price_E.text.toString().toInt()
                    customDialogFB.edit_wallte_price.text =total_wallte.toString()
                    totalrecivable -=customDialogFB.add_wallte_price_E.text.toString().toInt()
                    customDialogFB.edit_receivabel_price.text=totalrecivable.toString()
                    customDialogFB.add_wallte_price_E.setText("")}
                    val imm: InputMethodManager = context!!.getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
                    if (imm.isActive)
                        imm.toggleSoftInput(InputMethodManager.HIDE_IMPLICIT_ONLY, 0)
                    true
                }else{false}
            }

            customDialogFB.add_credit_price_E.setOnEditorActionListener { textView, i, keyEvent ->
                if (i==EditorInfo.IME_ACTION_DONE){
                    if(customDialogFB.add_credit_price_E.text.toString().toInt() > customDialogFB.edit_receivabel_price.text.toString().toInt()){
                        Toast.makeText(requireContext(), "القيمة المدخلة اكبر من قيمة الذمم", Toast.LENGTH_LONG)
                            .show()}else{
                    total_credit +=  customDialogFB.add_credit_price_E.text.toString().toInt()
                    customDialogFB.edit_credit_price.text =total_credit.toString()
                    totalrecivable -=customDialogFB.add_credit_price_E.text.toString().toInt()
                    customDialogFB.edit_receivabel_price.text=totalrecivable.toString()
                    customDialogFB.add_credit_price_E.setText("")}
                    val imm: InputMethodManager = context!!.getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
                    if (imm.isActive)
                        imm.toggleSoftInput(InputMethodManager.HIDE_IMPLICIT_ONLY, 0)
                    true
                }else{false}
            }

            customDialogFB.add_discount_price_E.setOnEditorActionListener { textView, i, keyEvent ->
                if (i==EditorInfo.IME_ACTION_DONE){
                    if(customDialogFB.add_discount_price_E.text.toString().toInt() > customDialogFB.edit_receivabel_price.text.toString().toInt()){
                        Toast.makeText(requireContext(), "القيمة المدخلة اكبر من قيمة الذمم", Toast.LENGTH_LONG)
                            .show()}else{
                    total_discount +=  customDialogFB.add_discount_price_E.text.toString().toInt()
                    customDialogFB.edit_discount_price.text =total_discount.toString()
                    totalrecivable -=customDialogFB.add_discount_price_E.text.toString().toInt()
                    customDialogFB.edit_receivabel_price.text=totalrecivable.toString()
                    customDialogFB.add_discount_price_E.setText("")}
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
                            setGravity(Gravity.TOP, 0, 200)
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
                            cash_name_E = customDialogFB.edit_cash_name.text.toString()
                            cash_price11_E = customDialogFB.edit_cash_price.text.toString()
                        }

                        val val_edit_wallte_price = customDialogFB.edit_wallte_price.text.toString()
                        if (val_edit_wallte_price.isNotEmpty()) {
                            wallte_name_E = customDialogFB.edit_wallte_name.text.toString()
                            wallet_price1_E = customDialogFB.edit_wallte_price.text.toString()
                        }

                        val val_edit_credit_price = customDialogFB.edit_credit_price.text.toString()
                        if (val_edit_credit_price.isNotEmpty()) {
                            credit_name_E = customDialogFB.edit_credit_name.text.toString()
                            credit_price1_E = customDialogFB.edit_credit_price.text.toString()
                        }

                        val val_edit_discount_price =
                            customDialogFB.edit_discount_price.text.toString()
                        if (val_edit_discount_price.isNotEmpty()) {
                            discount_name_E = customDialogFB.edit_discount_name.text.toString()
                            discount_price_E = customDialogFB.edit_discount_price.text.toString()
                        }

                    if (customDialogFB.edit_receivabel_price.text.toString().toInt() == 0){
                        checkreceivables_E =""
                        receivables_price1_E =""
                    }else {
                        checkreceivables_E = customDialogFB.checkreceivables.text.toString()
                        receivables_price1_E = customDialogFB.edit_receivabel_price.text.toString()
                    }


                    if(checkBoxauto1.text.toString().trim().isEmpty() && viewtext1.text.toString().trim()
                            .isNotEmpty()) {
                        viewtext1.requestFocus()
                        viewtext1.error = "يجب حذف القيمة"
                        return@setOnClickListener
                    }

                    if (checkBoxauto2.text.toString().trim().isEmpty() && viewtext2.text.toString().trim()
                            .isNotEmpty()) {
                        viewtext2.requestFocus()
                        viewtext2.error = "يجب حذف القيمة"
                        return@setOnClickListener
                    }

                    if(checkBoxauto3.text.toString().trim().isEmpty() && viewtext3.text.toString().trim()
                            .isNotEmpty()) {
                        viewtext3.requestFocus()
                        viewtext3.error = "يجب حذف القيمة"
                        return@setOnClickListener
                    }

                    if(checkBoxauto4.text.toString().trim().isEmpty() && viewtext4.text.toString().trim().isNotEmpty()) {
                        viewtext4.requestFocus()
                        viewtext4.error = "يجب حذف القيمة"
                        return@setOnClickListener
                    }


                    if(checkBoxauto5.text.toString().trim().isEmpty() && viewtext5.text.toString().trim().isNotEmpty()) {
                        viewtext5.requestFocus()
                        viewtext5.error = "يجب حذف القيمة"
                        return@setOnClickListener
                    }

                    if(checkBoxauto6.text.toString().trim().isEmpty() && viewtext6.text.toString().trim().isNotEmpty()) {
                        viewtext6.requestFocus()
                        viewtext6.error = "يجب حذف القيمة"
                        return@setOnClickListener
                    }

                    if(checkBoxauto7.text.toString().trim().isEmpty() && viewtext7.text.toString().trim().isNotEmpty()) {
                        viewtext7.requestFocus()
                        viewtext7.error = "يجب حذف القيمة"
                        return@setOnClickListener
                    }

                    if(checkBoxauto8.text.toString().trim().isEmpty() && viewtext8.text.toString().trim().isNotEmpty()) {
                        viewtext8.requestFocus()
                        viewtext8.error = "يجب حذف القيمة"
                        return@setOnClickListener
                    }

                    if(checkBoxauto9.text.toString().trim().isEmpty() && viewtext9.text.toString().trim().isNotEmpty()) {
                        viewtext9.requestFocus()
                        viewtext9.error = "يجب حذف القيمة"
                        return@setOnClickListener
                    }
                    if(checkBoxauto10.text.toString().trim().isEmpty() && viewtext10.text.toString().trim().isNotEmpty()) {
                        viewtext10.requestFocus()
                        viewtext10.error = "يجب حذف القيمة"
                        return@setOnClickListener
                    }
                    if(checkBoxauto11.text.toString().trim().isEmpty() && viewtext11.text.toString().trim().isNotEmpty()) {
                        viewtext11.requestFocus()
                        viewtext11.error = "يجب حذف القيمة"
                        return@setOnClickListener
                    }
                    if(checkBoxauto12.text.toString().trim().isEmpty() && viewtext12.text.toString().trim().isNotEmpty()) {
                        viewtext12.requestFocus()
                        viewtext12.error = "يجب حذف القيمة"
                        return@setOnClickListener
                    }
                    if(checkBoxauto13.text.toString().trim().isEmpty() && viewtext13.text.toString().trim().isNotEmpty()) {
                        viewtext13.requestFocus()
                        viewtext13.error = "يجب حذف القيمة"
                        return@setOnClickListener
                    }
                    if(checkBoxauto14.text.toString().trim().isEmpty() && viewtext14.text.toString().trim().isNotEmpty()) {
                        viewtext14.requestFocus()
                        viewtext14.error = "يجب حذف القيمة"
                        return@setOnClickListener
                    }
                    if(checkBoxauto15.text.toString().trim().isEmpty() && viewtext15.text.toString().trim().isNotEmpty()) {
                        viewtext15.requestFocus()
                        viewtext15.error = "يجب حذف القيمة"
                        return@setOnClickListener
                    }
                    if(checkBoxauto16.text.toString().trim().isEmpty() && viewtext16.text.toString().trim().isNotEmpty()) {
                        viewtext16.requestFocus()
                        viewtext16.error = "يجب حذف القيمة"
                        return@setOnClickListener
                    }
                    if(checkBoxauto17.text.toString().trim().isEmpty() && viewtext17.text.toString().trim().isNotEmpty()) {
                        viewtext17.requestFocus()
                        viewtext17.error = "يجب حذف القيمة"
                        return@setOnClickListener
                    }
                    if(checkBoxauto18.text.toString().trim().isEmpty() && viewtext18.text.toString().trim().isNotEmpty()) {
                        viewtext18.requestFocus()
                        viewtext18.error = "يجب حذف القيمة"
                        return@setOnClickListener
                    }
                    if(checkBoxauto19.text.toString().trim().isEmpty() && viewtext19.text.toString().trim().isNotEmpty()) {
                        viewtext19.requestFocus()
                        viewtext19.error = "يجب حذف القيمة"
                        return@setOnClickListener
                    }
                    if(checkBoxauto20.text.toString().trim().isEmpty() && viewtext20.text.toString().trim().isNotEmpty()) {
                        viewtext20.requestFocus()
                        viewtext20.error = "يجب حذف القيمة"
                        return@setOnClickListener
                    }
                    if(checkBoxauto21.text.toString().trim().isEmpty() && viewtext21.text.toString().trim().isNotEmpty()) {
                        viewtext21.requestFocus()
                        viewtext21.error = "يجب حذف القيمة"
                        return@setOnClickListener
                    }
                    if(checkBoxauto22.text.toString().trim().isEmpty() && viewtext22.text.toString().trim().isNotEmpty()) {
                        viewtext22.requestFocus()
                        viewtext22.error = "يجب حذف القيمة"
                        return@setOnClickListener
                    }
                    if(checkBoxauto23.text.toString().trim().isEmpty() && viewtext23.text.toString().trim().isNotEmpty()) {
                        viewtext23.requestFocus()
                        viewtext23.error = "يجب حذف القيمة"
                        return@setOnClickListener
                    }
                    if(checkBoxauto24.text.toString().trim().isEmpty() && viewtext24.text.toString().trim().isNotEmpty()) {
                        viewtext24.requestFocus()
                        viewtext24.error = "يجب حذف القيمة"
                        return@setOnClickListener
                    }
                    if(checkBoxauto25.text.toString().trim().isEmpty() && viewtext25.text.toString().trim().isNotEmpty()) {
                        viewtext25.requestFocus()
                        viewtext25.error = "يجب حذف القيمة"
                        return@setOnClickListener
                    }
                    if(checkBoxauto26.text.toString().trim().isEmpty() && viewtext26.text.toString().trim().isNotEmpty()) {
                        viewtext26.requestFocus()
                        viewtext26.error = "يجب حذف القيمة"
                        return@setOnClickListener
                    }
                    if(checkBoxauto27.text.toString().trim().isEmpty() && viewtext27.text.toString().trim().isNotEmpty()) {
                        viewtext27.requestFocus()
                        viewtext27.error = "يجب حذف القيمة"
                        return@setOnClickListener
                    }
                    if(checkBoxauto28.text.toString().trim().isEmpty() && viewtext28.text.toString().trim().isNotEmpty()) {
                        viewtext28.requestFocus()
                        viewtext28.error = "يجب حذف القيمة"
                        return@setOnClickListener
                    }
                    if(checkBoxauto29.text.toString().trim().isEmpty() && viewtext29.text.toString().trim().isNotEmpty()) {
                        viewtext29.requestFocus()
                        viewtext29.error = "يجب حذف القيمة"
                        return@setOnClickListener
                    }
                    if(checkBoxauto30.text.toString().trim().isEmpty() && viewtext30.text.toString().trim().isNotEmpty()) {
                        viewtext30.requestFocus()
                        viewtext30.error = "يجب حذف القيمة"
                        return@setOnClickListener
                    }
                    if(checkBoxauto31.text.toString().trim().isEmpty() && viewtext31.text.toString().trim().isNotEmpty()) {
                        viewtext31.requestFocus()
                        viewtext31.error = "يجب حذف القيمة"
                        return@setOnClickListener
                    }
                    if(checkBoxauto32.text.toString().trim().isEmpty() && viewtext32.text.toString().trim().isNotEmpty()) {
                        viewtext32.requestFocus()
                        viewtext32.error = "يجب حذف القيمة"
                        return@setOnClickListener
                    }
                    if(checkBoxauto33.text.toString().trim().isEmpty() && viewtext33.text.toString().trim().isNotEmpty()) {
                        viewtext33.requestFocus()
                        viewtext33.error = "يجب حذف القيمة"
                        return@setOnClickListener
                    }
                    if(checkBoxauto34.text.toString().trim().isEmpty() && viewtext34.text.toString().trim().isNotEmpty()) {
                        viewtext34.requestFocus()
                        viewtext34.error = "يجب حذف القيمة"
                        return@setOnClickListener
                    }
                    if(checkBoxauto35.text.toString().trim().isEmpty() && viewtext35.text.toString().trim().isNotEmpty()) {
                        viewtext35.requestFocus()
                        viewtext35.error = "يجب حذف القيمة"
                        return@setOnClickListener
                    }
                    if(checkBoxauto36.text.toString().trim().isEmpty() && viewtext36.text.toString().trim().isNotEmpty()) {
                        viewtext36.requestFocus()
                        viewtext36.error = "يجب حذف القيمة"
                        return@setOnClickListener
                    }
                    if(checkBoxauto37.text.toString().trim().isEmpty() && viewtext37.text.toString().trim().isNotEmpty()) {
                        viewtext37.requestFocus()
                        viewtext37.error = "يجب حذف القيمة"
                        return@setOnClickListener
                    }
                    if(checkBoxauto38.text.toString().trim().isEmpty() && viewtext38.text.toString().trim().isNotEmpty()) {
                        viewtext38.requestFocus()
                        viewtext38.error = "يجب حذف القيمة"
                        return@setOnClickListener
                    }
                    if(checkBoxauto39.text.toString().trim().isEmpty() && viewtext39.text.toString().trim().isNotEmpty()) {
                        viewtext39.requestFocus()
                        viewtext39.error = "يجب حذف القيمة"
                        return@setOnClickListener
                    }
                    if(checkBoxauto40.text.toString().trim().isEmpty() && viewtext40.text.toString().trim().isNotEmpty()) {
                        viewtext40.requestFocus()
                        viewtext40.error = "يجب حذف القيمة"
                        return@setOnClickListener
                    }
                    if(checkBoxauto41.text.toString().trim().isEmpty() && viewtext41.text.toString().trim().isNotEmpty()) {
                        viewtext41.requestFocus()
                        viewtext41.error = "يجب حذف القيمة"
                        return@setOnClickListener
                    }
                    if(checkBoxauto42.text.toString().trim().isEmpty() && viewtext42.text.toString().trim().isNotEmpty()) {
                        viewtext42.requestFocus()
                        viewtext42.error = "يجب حذف القيمة"
                        return@setOnClickListener
                    }
                    if(checkBoxauto43.text.toString().trim().isEmpty() && viewtext43.text.toString().trim().isNotEmpty()) {
                        viewtext43.requestFocus()
                        viewtext43.error = "يجب حذف القيمة"
                        return@setOnClickListener
                    }
                    if(checkBoxauto44.text.toString().trim().isEmpty() && viewtext44.text.toString().trim().isNotEmpty()) {
                        viewtext44.requestFocus()
                        viewtext44.error = "يجب حذف القيمة"
                        return@setOnClickListener
                    }
                    if(checkBoxauto45.text.toString().trim().isEmpty() && viewtext45.text.toString().trim().isNotEmpty()) {
                        viewtext45.requestFocus()
                        viewtext45.error = "يجب حذف القيمة"
                        return@setOnClickListener
                    }
                    if(checkBoxauto46.text.toString().trim().isEmpty() && viewtext46.text.toString().trim().isNotEmpty()) {
                        viewtext46.requestFocus()
                        viewtext46.error = "يجب حذف القيمة"
                        return@setOnClickListener
                    }
                    if(checkBoxauto47.text.toString().trim().isEmpty() && viewtext47.text.toString().trim().isNotEmpty()) {
                        viewtext47.requestFocus()
                        viewtext47.error = "يجب حذف القيمة"
                        return@setOnClickListener
                    }
                    if(checkBoxauto48.text.toString().trim().isEmpty() && viewtext48.text.toString().trim().isNotEmpty()) {
                        viewtext48.requestFocus()
                        viewtext48.error = "يجب حذف القيمة"
                        return@setOnClickListener
                    }
                    if(checkBoxauto49.text.toString().trim().isEmpty() && viewtext49.text.toString().trim().isNotEmpty()) {
                        viewtext49.requestFocus()
                        viewtext49.error = "يجب حذف القيمة"
                        return@setOnClickListener
                    }
                    if(checkBoxauto50.text.toString().trim().isEmpty() && viewtext50.text.toString().trim().isNotEmpty()) {
                        viewtext50.requestFocus()
                        viewtext50.error = "يجب حذف القيمة"
                        return@setOnClickListener
                    }
                    if(checkBoxauto51.text.toString().trim().isEmpty() && viewtext51.text.toString().trim().isNotEmpty()) {
                        viewtext51.requestFocus()
                        viewtext51.error = "يجب حذف القيمة"
                        return@setOnClickListener
                    }
                    if(checkBoxauto52.text.toString().trim().isEmpty() && viewtext52.text.toString().trim().isNotEmpty()) {
                        viewtext52.requestFocus()
                        viewtext52.error = "يجب حذف القيمة"
                        return@setOnClickListener
                    }
                    if(checkBoxauto53.text.toString().trim().isEmpty() && viewtext53.text.toString().trim().isNotEmpty()) {
                        viewtext53.requestFocus()
                        viewtext53.error = "يجب حذف القيمة"
                        return@setOnClickListener
                    }
                    if(checkBoxauto54.text.toString().trim().isEmpty() && viewtext54.text.toString().trim().isNotEmpty()) {
                        viewtext54.requestFocus()
                        viewtext54.error = "يجب حذف القيمة"
                        return@setOnClickListener
                    }
                    if(checkBoxauto55.text.toString().trim().isEmpty() && viewtext55.text.toString().trim().isNotEmpty()) {
                        viewtext55.requestFocus()
                        viewtext55.error = "يجب حذف القيمة"
                        return@setOnClickListener
                    }
                    if(checkBoxauto56.text.toString().trim().isEmpty() && viewtext56.text.toString().trim().isNotEmpty()) {
                        viewtext56.requestFocus()
                        viewtext56.error = "يجب حذف القيمة"
                        return@setOnClickListener
                    }
                    if(checkBoxauto57.text.toString().trim().isEmpty() && viewtext57.text.toString().trim().isNotEmpty()) {
                        viewtext57.requestFocus()
                        viewtext57.error = "يجب حذف القيمة"
                        return@setOnClickListener
                    }
                    if(checkBoxauto58.text.toString().trim().isEmpty() && viewtext58.text.toString().trim().isNotEmpty()) {
                        viewtext58.requestFocus()
                        viewtext58.error = "يجب حذف القيمة"
                        return@setOnClickListener
                    }
                    if(checkBoxauto59.text.toString().trim().isEmpty() && viewtext59.text.toString().trim().isNotEmpty()) {
                        viewtext59.requestFocus()
                        viewtext59.error = "يجب حذف القيمة"
                        return@setOnClickListener
                    }

                    if(customDialogFB.edit_receivabel_price.text.toString().isNotEmpty()) {

                        if (customDialogFB.totalall_E_D.text.toString()
                                .toInt() < customDialogFB.edit_receivabel_price.text.toString()
                                .toInt()
                        ) {
//                            customDialogFB.totalall_E_D.requestFocus()
//                            customDialogFB.totalall_E_D.error = "المجوع اقل من الذمم"
//                            Toast.makeText(requireContext(), "المجوع اقل من الذمم", Toast.LENGTH_LONG).apply{
//                                setGravity(Gravity.CENTER, 0, 200)
//                                view.background = ColorDrawable(Color.RED)
//                                show()
//                                val valuecash = customDialogFB.edit_cash_price.text.toString().toIntOrNull() ?: 0
//                                val valuewallte = customDialogFB.edit_wallte_price.text.toString().toIntOrNull() ?: 0
//                                val valuecredit = customDialogFB.edit_credit_price.text.toString().toIntOrNull() ?: 0
//                                val valuediscount = customDialogFB.edit_discount_price.text.toString().toIntOrNull() ?: 0
//                                val valuereceivabel = customDialogFB.edit_receivabel_price.text.toString().toIntOrNull() ?: 0
//                                val editsu = valuecash + valuewallte + valuecredit + valuediscount
//
//                                    val  oldtotal = customDialogFB.totalall_E_D.text.toString().toInt()
//                                    val finshtotal = oldtotal - editsu
//                                    customDialogFB.edit_receivabel_price.text = finshtotal.toString()
//                                    receivables_price1_E = customDialogFB.edit_receivabel_price.text.toString()
//                            }
//                            return@setOnClickListener
//                        }
                            val customDialogACCEPT = Dialog(activity!!)
                            customDialogACCEPT.setContentView(R.layout.dialog_accept)
                            customDialogACCEPT.setCancelable(false)
                            customDialogACCEPT.window?.setLayout(
                                ViewGroup.LayoutParams.MATCH_PARENT,
                                ViewGroup.LayoutParams.WRAP_CONTENT
                            )
                            customDialogACCEPT.btn_accept_yes.setOnClickListener {
                                val valuecash =
                                    customDialogFB.edit_cash_price.text.toString().toIntOrNull()
                                        ?: 0
                                val valuewallte =
                                    customDialogFB.edit_wallte_price.text.toString().toIntOrNull()
                                        ?: 0
                                val valuecredit =
                                    customDialogFB.edit_credit_price.text.toString().toIntOrNull()
                                        ?: 0
                                val valuediscount =
                                    customDialogFB.edit_discount_price.text.toString().toIntOrNull()
                                        ?: 0

                                val editsu = valuecash + valuewallte + valuecredit + valuediscount

                                val oldtotal = customDialogFB.totalall_E_D.text.toString().toInt()
                                val finshtotal = oldtotal - editsu
                                customDialogFB.edit_receivabel_price.text = finshtotal.toString()
                                receivables_price1_E =
                                    customDialogFB.edit_receivabel_price.text.toString()
                                customDialogACCEPT.valeditrec.text =
                                    finshtotal.toString()
                                customDialogACCEPT.dismiss()
                            }

                            customDialogACCEPT.btn_accept_no.setOnClickListener {
                                customDialogACCEPT.dismiss()
                            }
                            customDialogACCEPT.show()
                        }
                    }

                   val valuecash = customDialogFB.edit_cash_price.text.toString().toIntOrNull() ?: 0
		           val valuewallte = customDialogFB.edit_wallte_price.text.toString().toIntOrNull() ?: 0
		           val valuecredit = customDialogFB.edit_credit_price.text.toString().toIntOrNull() ?: 0
		           val valuediscount = customDialogFB.edit_discount_price.text.toString().toIntOrNull() ?: 0
		           val valuereceivabel = customDialogFB.edit_receivabel_price.text.toString().toIntOrNull() ?: 0
                   val editsu = valuecash + valuewallte + valuecredit + valuediscount + valuereceivabel

                    if (customDialogFB.totalall_E_D.text.toString()
                            .toInt() < editsu){
                        customDialogFB.totalall_E_D.requestFocus()
                        customDialogFB.totalall_E_D.error = "المجوع اقل من قيمة الفاتورة كامله"
                        Toast.makeText(requireContext(), "المجوع اقل من قيمة الفاتورة كامله", Toast.LENGTH_LONG).apply{
                            setGravity(Gravity.CENTER, 0, 200)
                                view.background = ColorDrawable(Color.RED)
                            show()
                        }
                        return@setOnClickListener

                    }



                    total = customDialogFB.totalall_E_D.text.toString()
                    ech1 = checkBoxauto1.text.toString().trim()
                    ech2 = checkBoxauto2.text.toString().trim()
                    ech3 = checkBoxauto3.text.toString().trim()
                    ech4 = checkBoxauto4.text.toString().trim()
                    ech5 = checkBoxauto5.text.toString().trim()
                    ech6 = checkBoxauto6.text.toString().trim()
                    ech7 = checkBoxauto7.text.toString().trim()
                    ech8 = checkBoxauto8.text.toString().trim()
                    ech9 = checkBoxauto9.text.toString().trim()
                    ech10 = checkBoxauto10.text.toString().trim()
                    ech11 = checkBoxauto11.text.toString().trim()
                    ech12 = checkBoxauto12.text.toString().trim()
                    ech13 = checkBoxauto13.text.toString().trim()
                    ech14 = checkBoxauto14.text.toString().trim()
                    ech15 = checkBoxauto15.text.toString().trim()
                    ech16 = checkBoxauto16.text.toString().trim()
                    ech17 = checkBoxauto17.text.toString().trim()
                    ech18 = checkBoxauto18.text.toString().trim()
                    ech19 = checkBoxauto19.text.toString().trim()
                    ech20 = checkBoxauto20.text.toString().trim()
                    ech21 = checkBoxauto21.text.toString().trim()
                    ech22 = checkBoxauto22.text.toString().trim()
                    ech23 = checkBoxauto23.text.toString().trim()
                    ech24 = checkBoxauto24.text.toString().trim()
                    ech25 = checkBoxauto25.text.toString().trim()
                    ech26 = checkBoxauto26.text.toString().trim()
                    ech27 = checkBoxauto27.text.toString().trim()
                    ech28 = checkBoxauto28.text.toString().trim()
                    ech29 = checkBoxauto29.text.toString().trim()
                    ech30 = checkBoxauto30.text.toString().trim()
                    ech31 = checkBoxauto31.text.toString().trim()
                    ech32 = checkBoxauto32.text.toString().trim()
                    ech33 = checkBoxauto33.text.toString().trim()
                    ech34 = checkBoxauto34.text.toString().trim()
                    ech35 = checkBoxauto35.text.toString().trim()
                    ech36 = checkBoxauto36.text.toString().trim()
                    ech37 = checkBoxauto37.text.toString().trim()
                    ech38 = checkBoxauto38.text.toString().trim()
                    ech39 = checkBoxauto39.text.toString().trim()
                    ech40 = checkBoxauto40.text.toString().trim()
                    ech41 = checkBoxauto41.text.toString().trim()
                    ech42 = checkBoxauto42.text.toString().trim()
                    ech43 = checkBoxauto43.text.toString().trim()
                    ech44 = checkBoxauto44.text.toString().trim()
                    ech45 = checkBoxauto45.text.toString().trim()
                    ech46 = checkBoxauto46.text.toString().trim()
                    ech47 = checkBoxauto47.text.toString().trim()
                    ech48 = checkBoxauto48.text.toString().trim()
                    ech49 = checkBoxauto49.text.toString().trim()
                    ech50 = checkBoxauto50.text.toString().trim()
                    ech51 = checkBoxauto51.text.toString().trim()
                    ech52 = checkBoxauto52.text.toString().trim()
                    ech53 = checkBoxauto53.text.toString().trim()
                    ech54 = checkBoxauto54.text.toString().trim()
                    ech55 = checkBoxauto55.text.toString().trim()
                    ech56 = checkBoxauto56.text.toString().trim()
                    ech57 = checkBoxauto57.text.toString().trim()
                    ech58 = checkBoxauto58.text.toString().trim()
                    ech59 = checkBoxauto59.text.toString().trim()


                    epr1 = viewtext1.text.toString().trim()
                    epr2 = viewtext2.text.toString().trim()
                    epr3 = viewtext3.text.toString().trim()
                    epr4 = viewtext4.text.toString().trim()
                    epr5 = viewtext5.text.toString().trim()
                    epr6 = viewtext6.text.toString().trim()
                    epr7 = viewtext7.text.toString().trim()
                    epr8 = viewtext8.text.toString().trim()
                    epr9 = viewtext9.text.toString().trim()
                    epr10 = viewtext10.text.toString().trim()
                    epr11 = viewtext11.text.toString().trim()
                    epr12 = viewtext12.text.toString().trim()
                    epr13 = viewtext13.text.toString().trim()
                    epr14 = viewtext14.text.toString().trim()
                    epr15 = viewtext15.text.toString().trim()
                    epr16 = viewtext16.text.toString().trim()
                    epr17 = viewtext17.text.toString().trim()
                    epr18 = viewtext18.text.toString().trim()
                    epr19 = viewtext19.text.toString().trim()
                    epr20 = viewtext20.text.toString().trim()
                    epr21 = viewtext21.text.toString().trim()
                    epr22 = viewtext22.text.toString().trim()
                    epr23 = viewtext23.text.toString().trim()
                    epr24 = viewtext24.text.toString().trim()
                    epr25 = viewtext25.text.toString().trim()
                    epr26 = viewtext26.text.toString().trim()
                    epr27 = viewtext27.text.toString().trim()
                    epr28 = viewtext28.text.toString().trim()
                    epr29 = viewtext29.text.toString().trim()
                    epr30 = viewtext30.text.toString().trim()
                    epr31 = viewtext31.text.toString().trim()
                    epr32 = viewtext32.text.toString().trim()
                    epr33 = viewtext33.text.toString().trim()
                    epr34 = viewtext34.text.toString().trim()
                    epr35 = viewtext35.text.toString().trim()
                    epr36 = viewtext36.text.toString().trim()
                    epr37 = viewtext37.text.toString().trim()
                    epr38 = viewtext38.text.toString().trim()
                    epr39 = viewtext39.text.toString().trim()
                    epr40 = viewtext40.text.toString().trim()
                    epr41 = viewtext41.text.toString().trim()
                    epr42 = viewtext42.text.toString().trim()
                    epr43 = viewtext43.text.toString().trim()
                    epr44 = viewtext44.text.toString().trim()
                    epr45 = viewtext45.text.toString().trim()
                    epr46 = viewtext46.text.toString().trim()
                    epr47 = viewtext47.text.toString().trim()
                    epr48 = viewtext48.text.toString().trim()
                    epr49 = viewtext49.text.toString().trim()
                    epr50 = viewtext50.text.toString().trim()
                    epr51 = viewtext51.text.toString().trim()
                    epr52 = viewtext52.text.toString().trim()
                    epr53 = viewtext53.text.toString().trim()
                    epr54 = viewtext54.text.toString().trim()
                    epr55 = viewtext55.text.toString().trim()
                    epr56 = viewtext56.text.toString().trim()
                    epr57 = viewtext57.text.toString().trim()
                    epr58 = viewtext58.text.toString().trim()
                    epr59 = viewtext59.text.toString().trim()



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
                            total,

                            ech1,
                            ech2,
                            ech3,
                            ech4,
                            ech5,
                            ech6,
                            ech7,
                            ech8,
                            ech9,
                            ech10,
                            ech11,
                            ech12,
                            ech13,
                            ech14,
                            ech15,
                            ech16,
                            ech17,
                            ech18,
                            ech19,
                            ech20,
                            ech21,
                            ech22,
                            ech23,
                            ech24,
                            ech25,
                            ech26,
                            ech27,
                            ech28,
                            ech29,
                            ech30,
                            ech31,
                            ech32,
                            ech33,
                            ech34,
                            ech35,
                            ech36,
                            ech37,
                            ech38,
                            ech39,
                            ech40,
                            ech41,
                            ech42,
                            ech43,
                            ech44,
                            ech45,
                            ech46,
                            ech47,
                            ech48,
                            ech49,
                            ech50,
                            ech51,
                            ech52,
                            ech53,
                            ech54,
                            ech55,
                            ech56,
                            ech57,
                            ech58,
                            ech59,

                            epr1,
                            epr2,
                            epr3,
                            epr4,
                            epr5,
                            epr6,
                            epr7,
                            epr8,
                            epr9,
                            epr10,
                            epr11,
                            epr12,
                            epr13,
                            epr14,
                            epr15,
                            epr16,
                            epr17,
                            epr18,
                            epr19,
                            epr20,
                            epr21,
                            epr22,
                            epr23,
                            epr24,
                            epr25,
                            epr26,
                            epr27,
                            epr28,
                            epr29,
                            epr30,
                            epr31,
                            epr32,
                            epr33,
                            epr34,
                            epr35,
                            epr36,
                            epr37,
                            epr38,
                            epr39,
                            epr40,
                            epr41,
                            epr42,
                            epr43,
                            epr44,
                            epr45,
                            epr46,
                            epr47,
                            epr48,
                            epr49,
                            epr50,
                            epr51,
                            epr52,
                            epr53,
                            epr54,
                            epr55,
                            epr56,
                            epr57,
                            epr58,
                            epr59,

                        "معاذ ابو الهيجاء",
                        "محمد ذياب",

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
                        contentMessage["receivables1"] = checkupdate.receivables1
                        contentMessage["date"] = checkupdate.date
                        contentMessage["senderName"] = checkupdate.senderName
                        contentMessage["recipientName"] = checkupdate.recipientName
                        contentMessage["total"] = checkupdate.total

                    contentMessage["check1"] = checkupdate.eich1
                    contentMessage["check2"] = checkupdate.eich2
                    contentMessage["check3"] = checkupdate.eich3
                    contentMessage["check4"] = checkupdate.eich4
                    contentMessage["check5"] = checkupdate.eich5
                    contentMessage["check6"] = checkupdate.eich6
                    contentMessage["check7"] = checkupdate.eich7
                    contentMessage["check8"] = checkupdate.eich8
                    contentMessage["check9"] = checkupdate.eich9
                    contentMessage["check10"] = checkupdate.eich10
                    contentMessage["check11"] = checkupdate.eich11
                    contentMessage["check12"] = checkupdate.eich12
                    contentMessage["check13"] = checkupdate.eich13
                    contentMessage["check14"] = checkupdate.eich14
                    contentMessage["check15"] = checkupdate.eich15
                    contentMessage["check16"] = checkupdate.eich16
                    contentMessage["check17"] = checkupdate.eich17
                    contentMessage["check18"] = checkupdate.eich18
                    contentMessage["check19"] = checkupdate.eich19
                    contentMessage["check20"] = checkupdate.eich20

                    contentMessage["check2_1"] = checkupdate.eich21
                    contentMessage["check2_2"] = checkupdate.eich22
                    contentMessage["check2_3"] = checkupdate.eich23
                    contentMessage["check2_4"] = checkupdate.eich24
                    contentMessage["check2_5"] = checkupdate.eich25
                    contentMessage["check2_6"] = checkupdate.eich26
                    contentMessage["check2_7"] = checkupdate.eich27
                    contentMessage["check2_8"] = checkupdate.eich28
                    contentMessage["check2_9"] = checkupdate.eich29
                    contentMessage["check2_10"] = checkupdate.eich30
                    contentMessage["check2_11"] = checkupdate.eich31
                    contentMessage["check2_12"] = checkupdate.eich32
                    contentMessage["check2_13"] = checkupdate.eich33
                    contentMessage["check2_14"] = checkupdate.eich34
                    contentMessage["check2_15"] = checkupdate.eich35
                    contentMessage["check2_16"] = checkupdate.eich36
                    contentMessage["check2_17"] = checkupdate.eich37
                    contentMessage["check2_18"] = checkupdate.eich38
                    contentMessage["check2_19"] = checkupdate.eich39
                    contentMessage["check2_20"] = checkupdate.eich40
                    contentMessage["check2_21"] = checkupdate.eich41
                    contentMessage["check2_22"] = checkupdate.eich42

                    contentMessage["check3_1"] = checkupdate.eich43
                    contentMessage["check3_2"] = checkupdate.eich44
                    contentMessage["check3_3"] = checkupdate.eich45
                    contentMessage["check3_4"] = checkupdate.eich46
                    contentMessage["check3_5"] = checkupdate.eich47
                    contentMessage["check3_6"] = checkupdate.eich48
                    contentMessage["check3_7"] = checkupdate.eich49
                    contentMessage["check3_8"] = checkupdate.eich50

                    contentMessage["price1"] = checkupdate.eipr1
                    contentMessage["price2"] = checkupdate.eipr2
                    contentMessage["price3"] = checkupdate.eipr3
                    contentMessage["price4"] = checkupdate.eipr4
                    contentMessage["price5"] = checkupdate.eipr5
                    contentMessage["price6"] = checkupdate.eipr6
                    contentMessage["price7"] = checkupdate.eipr7
                    contentMessage["price8"] = checkupdate.eipr8
                    contentMessage["price9"] = checkupdate.eipr9
                    contentMessage["price10"] = checkupdate.eipr10
                    contentMessage["price11"] = checkupdate.eipr11
                    contentMessage["price12"] = checkupdate.eipr12
                    contentMessage["price13"] = checkupdate.eipr13
                    contentMessage["price14"] = checkupdate.eipr14
                    contentMessage["price15"] = checkupdate.eipr15
                    contentMessage["price16"] = checkupdate.eipr16
                    contentMessage["price17"] = checkupdate.eipr17
                    contentMessage["price18"] = checkupdate.eipr18
                    contentMessage["price19"] = checkupdate.eipr19
                    contentMessage["price20"] = checkupdate.eipr20

                    contentMessage["price2_1"] = checkupdate.eipr21
                    contentMessage["price2_2"] = checkupdate.eipr22
                    contentMessage["price2_3"] = checkupdate.eipr23
                    contentMessage["price2_4"] = checkupdate.eipr24
                    contentMessage["price2_5"] = checkupdate.eipr25
                    contentMessage["price2_6"] = checkupdate.eipr26
                    contentMessage["price2_7"] = checkupdate.eipr27
                    contentMessage["price2_8"] = checkupdate.eipr28
                    contentMessage["price2_9"] = checkupdate.eipr29
                    contentMessage["price2_10"] = checkupdate.eipr30
                    contentMessage["price2_11"] = checkupdate.eipr31
                    contentMessage["price2_12"] = checkupdate.eipr32
                    contentMessage["price2_13"] = checkupdate.eipr33
                    contentMessage["price2_14"] = checkupdate.eipr34
                    contentMessage["price2_15"] = checkupdate.eipr35
                    contentMessage["price2_16"] = checkupdate.eipr36
                    contentMessage["price2_17"] = checkupdate.eipr37
                    contentMessage["price2_18"] = checkupdate.eipr38
                    contentMessage["price2_19"] = checkupdate.eipr39
                    contentMessage["price2_20"] = checkupdate.eipr40
                    contentMessage["price2_21"] = checkupdate.eipr41
                    contentMessage["price2_22"] = checkupdate.eipr42

                    contentMessage["price3_1"] = checkupdate.eipr43
                    contentMessage["price3_2"] = checkupdate.eipr44
                    contentMessage["price3_3"] = checkupdate.eipr45
                    contentMessage["price3_4"] = checkupdate.eipr46
                    contentMessage["price3_5"] = checkupdate.eipr47
                    contentMessage["price3_6"] = checkupdate.eipr48
                    contentMessage["price3_7"] = checkupdate.eipr49
                    contentMessage["price3_8"] = checkupdate.eipr50

                    contentMessage["editD1"] = checkupdate.eich51
                    contentMessage["editD2"] = checkupdate.eich52
                    contentMessage["editD3"] = checkupdate.eich53
                    contentMessage["editD4"] = checkupdate.eich54
                    contentMessage["editD5"] = checkupdate.eich55
                    contentMessage["editD6"] = checkupdate.eich56
                    contentMessage["editD7"] = checkupdate.eich57
                    contentMessage["editD8"] = checkupdate.eich58
                    contentMessage["editD9"] = checkupdate.eich59

                    contentMessage["pricD1"] = checkupdate.eipr51
                    contentMessage["pricD2"] = checkupdate.eipr52
                    contentMessage["pricD3"] = checkupdate.eipr53
                    contentMessage["pricD4"] = checkupdate.eipr54
                    contentMessage["pricD5"] = checkupdate.eipr55
                    contentMessage["pricD6"] = checkupdate.eipr56
                    contentMessage["pricD7"] = checkupdate.eipr57
                    contentMessage["pricD8"] = checkupdate.eipr58
                    contentMessage["pricD9"] = checkupdate.eipr59

                    chatChannelsCollectionRef.document(mCurrentChatChannelId)
                            .collection("messages")
                            .document(item.messageId)
                            .update(contentMessage)

                        messageAdapter.clear()
                        totalQuantity = 0
                        getTotal(mCurrentChatChannelId)
                        customDialogFB.dismiss()
                    } else {
                    Toast.makeText(activity, "لن يتم تعديل اي قيم مالية (لا يوجد ذمم)", Toast.LENGTH_LONG).apply {
                        setGravity(Gravity.TOP or Gravity.CENTER_HORIZONTAL, 0, 0)
                        show()
//                    val contentMessage = mutableMapOf<String, Any>()
//                    contentMessage["receivables1"] = ""
//                    chatChannelsCollectionRef.document(mCurrentChatChannelId)
//                        .collection("messages")
//                        .document(item.messageId)
//                        .update(contentMessage)
                    }
                    }
                    customDialogFB.dismiss()
                }
            }

            if (item.checkData.check1.isNotEmpty()){
                customDialogFB.apply {
                    checkBoxauto1.setText(item.checkData.check1)
                    checkBoxauto1.setTextColor(Color.parseColor("#000000"))
                    checkBoxauto1.layoutParams = LinearLayout.LayoutParams(
                        ViewGroup.LayoutParams.WRAP_CONTENT,
                        ViewGroup.LayoutParams.WRAP_CONTENT, Float.MIN_VALUE)
                    viewtext1.setText(item.checkData.price1)
                    viewtext1.setTextColor(Color.parseColor("#000000"))
                    p1.addView(viewtext1)
                    L_c1.addView(checkBoxauto1)
                    checkBoxauto1.setSelectAllOnFocus(true)
                    viewtext1.setSelectAllOnFocus(true)
                    checkBoxauto1.textSize = 14f
                    checkBoxauto1.setTypeface(null, Typeface.BOLD)
                    checkBoxauto1.isSingleLine = true
                    viewtext1.isSingleLine = true
                    checkBoxauto1.textSize = 14f
                    viewtext1.textSize = 14f
                    viewtext1.inputType = InputType.TYPE_CLASS_PHONE

                    viewtext1.addTextChangedListener(object : TextWatcher {
                        override fun beforeTextChanged(
                            s: CharSequence?,
                            start: Int,
                            count: Int,
                            after: Int
                        ) {
                        }

                        override fun onTextChanged(
                            s: CharSequence?,
                            start: Int,
                            before: Int,
                            count: Int
                        ) {
                            val value1 = viewtext1.text.toString().toIntOrNull() ?: 0
                            val value2 = viewtext2.text.toString().toIntOrNull() ?: 0
                            val value3 = viewtext3.text.toString().toIntOrNull() ?: 0
                            val value4 = viewtext4.text.toString().toIntOrNull() ?: 0
                            val value5 = viewtext5.text.toString().toIntOrNull() ?: 0
                            val value6 = viewtext6.text.toString().toIntOrNull() ?: 0
                            val value7 = viewtext7.text.toString().toIntOrNull() ?: 0
                            val value8 = viewtext8.text.toString().toIntOrNull() ?: 0
                            val value9 = viewtext9.text.toString().toIntOrNull() ?: 0
                            val value10 = viewtext10.text.toString().toIntOrNull() ?: 0
                            val value11 = viewtext11.text.toString().toIntOrNull() ?: 0
                            val value12 = viewtext12.text.toString().toIntOrNull() ?: 0
                            val value13 = viewtext13.text.toString().toIntOrNull() ?: 0
                            val value14 = viewtext14.text.toString().toIntOrNull() ?: 0
                            val value15 = viewtext15.text.toString().toIntOrNull() ?: 0
                            val value16 = viewtext16.text.toString().toIntOrNull() ?: 0
                            val value17 = viewtext17.text.toString().toIntOrNull() ?: 0
                            val value18 = viewtext18.text.toString().toIntOrNull() ?: 0
                            val value19 = viewtext19.text.toString().toIntOrNull() ?: 0
                            val value20 = viewtext20.text.toString().toIntOrNull() ?: 0
                            val value21 = viewtext21.text.toString().toIntOrNull() ?: 0
                            val value22 = viewtext22.text.toString().toIntOrNull() ?: 0
                            val value23 = viewtext23.text.toString().toIntOrNull() ?: 0
                            val value24 = viewtext24.text.toString().toIntOrNull() ?: 0
                            val value25 = viewtext25.text.toString().toIntOrNull() ?: 0
                            val value26 = viewtext26.text.toString().toIntOrNull() ?: 0
                            val value27 = viewtext27.text.toString().toIntOrNull() ?: 0
                            val value28 = viewtext28.text.toString().toIntOrNull() ?: 0
                            val value29 = viewtext29.text.toString().toIntOrNull() ?: 0
                            val value30 = viewtext30.text.toString().toIntOrNull() ?: 0
                            val value31 = viewtext31.text.toString().toIntOrNull() ?: 0
                            val value32 = viewtext32.text.toString().toIntOrNull() ?: 0
                            val value33 = viewtext33.text.toString().toIntOrNull() ?: 0
                            val value34 = viewtext34.text.toString().toIntOrNull() ?: 0
                            val value35 = viewtext35.text.toString().toIntOrNull() ?: 0
                            val value36 = viewtext36.text.toString().toIntOrNull() ?: 0
                            val value37 = viewtext37.text.toString().toIntOrNull() ?: 0
                            val value38 = viewtext38.text.toString().toIntOrNull() ?: 0
                            val value39 = viewtext39.text.toString().toIntOrNull() ?: 0
                            val value40 = viewtext40.text.toString().toIntOrNull() ?: 0
                            val value41 = viewtext41.text.toString().toIntOrNull() ?: 0
                            val value42 = viewtext42.text.toString().toIntOrNull() ?: 0
                            val value43 = viewtext43.text.toString().toIntOrNull() ?: 0
                            val value44 = viewtext44.text.toString().toIntOrNull() ?: 0
                            val value45 = viewtext45.text.toString().toIntOrNull() ?: 0
                            val value46 = viewtext46.text.toString().toIntOrNull() ?: 0
                            val value47 = viewtext47.text.toString().toIntOrNull() ?: 0
                            val value48 = viewtext48.text.toString().toIntOrNull() ?: 0
                            val value49 = viewtext49.text.toString().toIntOrNull() ?: 0
                            val value50 = viewtext50.text.toString().toIntOrNull() ?: 0
                            val value51 = viewtext51.text.toString().toIntOrNull() ?: 0
                            val value52 = viewtext52.text.toString().toIntOrNull() ?: 0
                            val value53 = viewtext53.text.toString().toIntOrNull() ?: 0
                            val value54 = viewtext54.text.toString().toIntOrNull() ?: 0
                            val value55 = viewtext55.text.toString().toIntOrNull() ?: 0
                            val value56 = viewtext56.text.toString().toIntOrNull() ?: 0
                            val value57 = viewtext57.text.toString().toIntOrNull() ?: 0
                            val value58 = viewtext58.text.toString().toIntOrNull() ?: 0
                            val value59 = viewtext59.text.toString().toIntOrNull() ?: 0

                            sum = (value1 + value2 + value3 + value4  + value5 +
                                    value6 + value7  + value8  + value9 + value10 + value11 +
                                    value12 + value13 + value14 + value15  + value16  + value17 +
                                    value18 + value19  + value20  + value21 + value22 + value23 +
                                    value24 + value25 + value26 + value27  + value28  + value29 +
                                    value30 + value31  + value32  + value33 + value34 + value35 +
                                    value36 + value37 + value38 + value39  + value40  + value41 +
                                    value42 + value43  + value44  + value45 + value46 + value47 +
                                    value48 + value49 + value50 + value51  + value52  + value53 +
                                    value54 + value55  + value56  + value57 + value58 + value59).toString()

                            totalall_E_D.text = (sum)
                        }
                        override fun afterTextChanged(s: Editable?) {
                        }
                    })
                }
            }

            if (item.checkData.check2.isNotEmpty()){
                customDialogFB.apply {
                    checkBoxauto2.setText(item.checkData.check2)
                    checkBoxauto2.setTextColor(Color.parseColor("#000000"))
                    checkBoxauto2.layoutParams = LinearLayout.LayoutParams(
                        ViewGroup.LayoutParams.WRAP_CONTENT,
                        ViewGroup.LayoutParams.WRAP_CONTENT, Float.MIN_VALUE)
                    viewtext2.setText(item.checkData.price2)
                    viewtext2.setTextColor(Color.parseColor("#000000"))
                    p2.addView(viewtext2)
                    L_c2.addView(checkBoxauto2)
                    viewtext2.setSelectAllOnFocus(true)
                    checkBoxauto2.setSelectAllOnFocus(true)
                    checkBoxauto2.textSize = 14f
                    checkBoxauto2.setTypeface(null, Typeface.BOLD)
                    checkBoxauto2.isSingleLine = true
                    viewtext2.isSingleLine = true
                    viewtext2.textSize = 14f
                    viewtext2.inputType = InputType.TYPE_CLASS_PHONE

                    viewtext2.addTextChangedListener(object : TextWatcher {
                        override fun beforeTextChanged(
                            s: CharSequence?,
                            start: Int,
                            count: Int,
                            after: Int
                        ) {
                        }

                        override fun onTextChanged(
                            s: CharSequence?,
                            start: Int,
                            before: Int,
                            count: Int
                        ) {
                            val value1 = viewtext1.text.toString().toIntOrNull() ?: 0
                            val value2 = viewtext2.text.toString().toIntOrNull() ?: 0
                            val value3 = viewtext3.text.toString().toIntOrNull() ?: 0
                            val value4 = viewtext4.text.toString().toIntOrNull() ?: 0
                            val value5 = viewtext5.text.toString().toIntOrNull() ?: 0
                            val value6 = viewtext6.text.toString().toIntOrNull() ?: 0
                            val value7 = viewtext7.text.toString().toIntOrNull() ?: 0
                            val value8 = viewtext8.text.toString().toIntOrNull() ?: 0
                            val value9 = viewtext9.text.toString().toIntOrNull() ?: 0
                            val value10 = viewtext10.text.toString().toIntOrNull() ?: 0
                            val value11 = viewtext11.text.toString().toIntOrNull() ?: 0
                            val value12 = viewtext12.text.toString().toIntOrNull() ?: 0
                            val value13 = viewtext13.text.toString().toIntOrNull() ?: 0
                            val value14 = viewtext14.text.toString().toIntOrNull() ?: 0
                            val value15 = viewtext15.text.toString().toIntOrNull() ?: 0
                            val value16 = viewtext16.text.toString().toIntOrNull() ?: 0
                            val value17 = viewtext17.text.toString().toIntOrNull() ?: 0
                            val value18 = viewtext18.text.toString().toIntOrNull() ?: 0
                            val value19 = viewtext19.text.toString().toIntOrNull() ?: 0
                            val value20 = viewtext20.text.toString().toIntOrNull() ?: 0
                            val value21 = viewtext21.text.toString().toIntOrNull() ?: 0
                            val value22 = viewtext22.text.toString().toIntOrNull() ?: 0
                            val value23 = viewtext23.text.toString().toIntOrNull() ?: 0
                            val value24 = viewtext24.text.toString().toIntOrNull() ?: 0
                            val value25 = viewtext25.text.toString().toIntOrNull() ?: 0
                            val value26 = viewtext26.text.toString().toIntOrNull() ?: 0
                            val value27 = viewtext27.text.toString().toIntOrNull() ?: 0
                            val value28 = viewtext28.text.toString().toIntOrNull() ?: 0
                            val value29 = viewtext29.text.toString().toIntOrNull() ?: 0
                            val value30 = viewtext30.text.toString().toIntOrNull() ?: 0
                            val value31 = viewtext31.text.toString().toIntOrNull() ?: 0
                            val value32 = viewtext32.text.toString().toIntOrNull() ?: 0
                            val value33 = viewtext33.text.toString().toIntOrNull() ?: 0
                            val value34 = viewtext34.text.toString().toIntOrNull() ?: 0
                            val value35 = viewtext35.text.toString().toIntOrNull() ?: 0
                            val value36 = viewtext36.text.toString().toIntOrNull() ?: 0
                            val value37 = viewtext37.text.toString().toIntOrNull() ?: 0
                            val value38 = viewtext38.text.toString().toIntOrNull() ?: 0
                            val value39 = viewtext39.text.toString().toIntOrNull() ?: 0
                            val value40 = viewtext40.text.toString().toIntOrNull() ?: 0
                            val value41 = viewtext41.text.toString().toIntOrNull() ?: 0
                            val value42 = viewtext42.text.toString().toIntOrNull() ?: 0
                            val value43 = viewtext43.text.toString().toIntOrNull() ?: 0
                            val value44 = viewtext44.text.toString().toIntOrNull() ?: 0
                            val value45 = viewtext45.text.toString().toIntOrNull() ?: 0
                            val value46 = viewtext46.text.toString().toIntOrNull() ?: 0
                            val value47 = viewtext47.text.toString().toIntOrNull() ?: 0
                            val value48 = viewtext48.text.toString().toIntOrNull() ?: 0
                            val value49 = viewtext49.text.toString().toIntOrNull() ?: 0
                            val value50 = viewtext50.text.toString().toIntOrNull() ?: 0
                            val value51 = viewtext51.text.toString().toIntOrNull() ?: 0
                            val value52 = viewtext52.text.toString().toIntOrNull() ?: 0
                            val value53 = viewtext53.text.toString().toIntOrNull() ?: 0
                            val value54 = viewtext54.text.toString().toIntOrNull() ?: 0
                            val value55 = viewtext55.text.toString().toIntOrNull() ?: 0
                            val value56 = viewtext56.text.toString().toIntOrNull() ?: 0
                            val value57 = viewtext57.text.toString().toIntOrNull() ?: 0
                            val value58 = viewtext58.text.toString().toIntOrNull() ?: 0
                            val value59 = viewtext59.text.toString().toIntOrNull() ?: 0

                            sum = (value1 + value2 + value3 + value4  + value5 +
                                    value6 + value7  + value8  + value9 + value10 + value11 +
                                    value12 + value13 + value14 + value15  + value16  + value17 +
                                    value18 + value19  + value20  + value21 + value22 + value23 +
                                    value24 + value25 + value26 + value27  + value28  + value29 +
                                    value30 + value31  + value32  + value33 + value34 + value35 +
                                    value36 + value37 + value38 + value39  + value40  + value41 +
                                    value42 + value43  + value44  + value45 + value46 + value47 +
                                    value48 + value49 + value50 + value51  + value52  + value53 +
                                    value54 + value55  + value56  + value57 + value58 + value59).toString()

                            totalall_E_D.text = (sum)
                        }

                        override fun afterTextChanged(s: Editable?) {
                        }
                    })
                }
            }

            if (item.checkData.check3.isNotEmpty()){
                customDialogFB.apply {
                    checkBoxauto3.setText(item.checkData.check3)
                    checkBoxauto3.setTextColor(Color.parseColor("#000000"))
                    checkBoxauto3.layoutParams = LinearLayout.LayoutParams(
                        ViewGroup.LayoutParams.WRAP_CONTENT,
                        ViewGroup.LayoutParams.WRAP_CONTENT, Float.MIN_VALUE)
                    viewtext3.setText(item.checkData.price3)
                    viewtext3.setTextColor(Color.parseColor("#000000"))
                    p3.addView(viewtext3)
                    L_c3.addView(checkBoxauto3)
                    viewtext3.setSelectAllOnFocus(true)
                    checkBoxauto3.setSelectAllOnFocus(true)
                    checkBoxauto3.textSize = 14f
                    checkBoxauto3.setTypeface(null, Typeface.BOLD)
                    checkBoxauto3.isSingleLine = true
                    viewtext3.isSingleLine = true
                    viewtext3.textSize = 14f
                    viewtext3.inputType = InputType.TYPE_CLASS_PHONE

                    viewtext3.addTextChangedListener(object : TextWatcher {
                        override fun beforeTextChanged(
                            s: CharSequence?,
                            start: Int,
                            count: Int,
                            after: Int
                        ) {
                        }

                        override fun onTextChanged(
                            s: CharSequence?,
                            start: Int,
                            before: Int,
                            count: Int
                        ) {
                            val value1 = viewtext1.text.toString().toIntOrNull() ?: 0
                            val value2 = viewtext2.text.toString().toIntOrNull() ?: 0
                            val value3 = viewtext3.text.toString().toIntOrNull() ?: 0
                            val value4 = viewtext4.text.toString().toIntOrNull() ?: 0
                            val value5 = viewtext5.text.toString().toIntOrNull() ?: 0
                            val value6 = viewtext6.text.toString().toIntOrNull() ?: 0
                            val value7 = viewtext7.text.toString().toIntOrNull() ?: 0
                            val value8 = viewtext8.text.toString().toIntOrNull() ?: 0
                            val value9 = viewtext9.text.toString().toIntOrNull() ?: 0
                            val value10 = viewtext10.text.toString().toIntOrNull() ?: 0
                            val value11 = viewtext11.text.toString().toIntOrNull() ?: 0
                            val value12 = viewtext12.text.toString().toIntOrNull() ?: 0
                            val value13 = viewtext13.text.toString().toIntOrNull() ?: 0
                            val value14 = viewtext14.text.toString().toIntOrNull() ?: 0
                            val value15 = viewtext15.text.toString().toIntOrNull() ?: 0
                            val value16 = viewtext16.text.toString().toIntOrNull() ?: 0
                            val value17 = viewtext17.text.toString().toIntOrNull() ?: 0
                            val value18 = viewtext18.text.toString().toIntOrNull() ?: 0
                            val value19 = viewtext19.text.toString().toIntOrNull() ?: 0
                            val value20 = viewtext20.text.toString().toIntOrNull() ?: 0
                            val value21 = viewtext21.text.toString().toIntOrNull() ?: 0
                            val value22 = viewtext22.text.toString().toIntOrNull() ?: 0
                            val value23 = viewtext23.text.toString().toIntOrNull() ?: 0
                            val value24 = viewtext24.text.toString().toIntOrNull() ?: 0
                            val value25 = viewtext25.text.toString().toIntOrNull() ?: 0
                            val value26 = viewtext26.text.toString().toIntOrNull() ?: 0
                            val value27 = viewtext27.text.toString().toIntOrNull() ?: 0
                            val value28 = viewtext28.text.toString().toIntOrNull() ?: 0
                            val value29 = viewtext29.text.toString().toIntOrNull() ?: 0
                            val value30 = viewtext30.text.toString().toIntOrNull() ?: 0
                            val value31 = viewtext31.text.toString().toIntOrNull() ?: 0
                            val value32 = viewtext32.text.toString().toIntOrNull() ?: 0
                            val value33 = viewtext33.text.toString().toIntOrNull() ?: 0
                            val value34 = viewtext34.text.toString().toIntOrNull() ?: 0
                            val value35 = viewtext35.text.toString().toIntOrNull() ?: 0
                            val value36 = viewtext36.text.toString().toIntOrNull() ?: 0
                            val value37 = viewtext37.text.toString().toIntOrNull() ?: 0
                            val value38 = viewtext38.text.toString().toIntOrNull() ?: 0
                            val value39 = viewtext39.text.toString().toIntOrNull() ?: 0
                            val value40 = viewtext40.text.toString().toIntOrNull() ?: 0
                            val value41 = viewtext41.text.toString().toIntOrNull() ?: 0
                            val value42 = viewtext42.text.toString().toIntOrNull() ?: 0
                            val value43 = viewtext43.text.toString().toIntOrNull() ?: 0
                            val value44 = viewtext44.text.toString().toIntOrNull() ?: 0
                            val value45 = viewtext45.text.toString().toIntOrNull() ?: 0
                            val value46 = viewtext46.text.toString().toIntOrNull() ?: 0
                            val value47 = viewtext47.text.toString().toIntOrNull() ?: 0
                            val value48 = viewtext48.text.toString().toIntOrNull() ?: 0
                            val value49 = viewtext49.text.toString().toIntOrNull() ?: 0
                            val value50 = viewtext50.text.toString().toIntOrNull() ?: 0
                            val value51 = viewtext51.text.toString().toIntOrNull() ?: 0
                            val value52 = viewtext52.text.toString().toIntOrNull() ?: 0
                            val value53 = viewtext53.text.toString().toIntOrNull() ?: 0
                            val value54 = viewtext54.text.toString().toIntOrNull() ?: 0
                            val value55 = viewtext55.text.toString().toIntOrNull() ?: 0
                            val value56 = viewtext56.text.toString().toIntOrNull() ?: 0
                            val value57 = viewtext57.text.toString().toIntOrNull() ?: 0
                            val value58 = viewtext58.text.toString().toIntOrNull() ?: 0
                            val value59 = viewtext59.text.toString().toIntOrNull() ?: 0

                            sum = (value1 + value2 + value3 + value4  + value5 +
                                    value6 + value7  + value8  + value9 + value10 + value11 +
                                    value12 + value13 + value14 + value15  + value16  + value17 +
                                    value18 + value19  + value20  + value21 + value22 + value23 +
                                    value24 + value25 + value26 + value27  + value28  + value29 +
                                    value30 + value31  + value32  + value33 + value34 + value35 +
                                    value36 + value37 + value38 + value39  + value40  + value41 +
                                    value42 + value43  + value44  + value45 + value46 + value47 +
                                    value48 + value49 + value50 + value51  + value52  + value53 +
                                    value54 + value55  + value56  + value57 + value58 + value59).toString()

                            totalall_E_D.text = (sum)
                        }

                        override fun afterTextChanged(s: Editable?) {
                        }
                    })
                }
            }

            if (item.checkData.check4.isNotEmpty()){
                customDialogFB.apply { checkBoxauto4.setText(item.checkData.check4)
                    checkBoxauto4.setTextColor(Color.parseColor("#000000"))
                    checkBoxauto4.layoutParams = LinearLayout.LayoutParams(
                        ViewGroup.LayoutParams.WRAP_CONTENT,
                        ViewGroup.LayoutParams.WRAP_CONTENT, Float.MIN_VALUE)
                    viewtext4.setText(item.checkData.price4)
                    viewtext4.setTextColor(Color.parseColor("#000000"))
                    p4.addView(viewtext4)
                    L_c4.addView(checkBoxauto4)
                    viewtext4.setSelectAllOnFocus(true)
                    checkBoxauto4.setSelectAllOnFocus(true)
                    checkBoxauto4.textSize = 14f
                    checkBoxauto4.setTypeface(null, Typeface.BOLD)
                    checkBoxauto4.isSingleLine = true
                    viewtext4.isSingleLine = true
                    viewtext4.textSize = 14f
                    viewtext4.inputType = InputType.TYPE_CLASS_PHONE

                    viewtext4.addTextChangedListener(object : TextWatcher {
                        override fun beforeTextChanged(
                            s: CharSequence?,
                            start: Int,
                            count: Int,
                            after: Int
                        ) {
                        }

                        override fun onTextChanged(
                            s: CharSequence?,
                            start: Int,
                            before: Int,
                            count: Int
                        ) {
                            val value1 = viewtext1.text.toString().toIntOrNull() ?: 0
                            val value2 = viewtext2.text.toString().toIntOrNull() ?: 0
                            val value3 = viewtext3.text.toString().toIntOrNull() ?: 0
                            val value4 = viewtext4.text.toString().toIntOrNull() ?: 0
                            val value5 = viewtext5.text.toString().toIntOrNull() ?: 0
                            val value6 = viewtext6.text.toString().toIntOrNull() ?: 0
                            val value7 = viewtext7.text.toString().toIntOrNull() ?: 0
                            val value8 = viewtext8.text.toString().toIntOrNull() ?: 0
                            val value9 = viewtext9.text.toString().toIntOrNull() ?: 0
                            val value10 = viewtext10.text.toString().toIntOrNull() ?: 0
                            val value11 = viewtext11.text.toString().toIntOrNull() ?: 0
                            val value12 = viewtext12.text.toString().toIntOrNull() ?: 0
                            val value13 = viewtext13.text.toString().toIntOrNull() ?: 0
                            val value14 = viewtext14.text.toString().toIntOrNull() ?: 0
                            val value15 = viewtext15.text.toString().toIntOrNull() ?: 0
                            val value16 = viewtext16.text.toString().toIntOrNull() ?: 0
                            val value17 = viewtext17.text.toString().toIntOrNull() ?: 0
                            val value18 = viewtext18.text.toString().toIntOrNull() ?: 0
                            val value19 = viewtext19.text.toString().toIntOrNull() ?: 0
                            val value20 = viewtext20.text.toString().toIntOrNull() ?: 0
                            val value21 = viewtext21.text.toString().toIntOrNull() ?: 0
                            val value22 = viewtext22.text.toString().toIntOrNull() ?: 0
                            val value23 = viewtext23.text.toString().toIntOrNull() ?: 0
                            val value24 = viewtext24.text.toString().toIntOrNull() ?: 0
                            val value25 = viewtext25.text.toString().toIntOrNull() ?: 0
                            val value26 = viewtext26.text.toString().toIntOrNull() ?: 0
                            val value27 = viewtext27.text.toString().toIntOrNull() ?: 0
                            val value28 = viewtext28.text.toString().toIntOrNull() ?: 0
                            val value29 = viewtext29.text.toString().toIntOrNull() ?: 0
                            val value30 = viewtext30.text.toString().toIntOrNull() ?: 0
                            val value31 = viewtext31.text.toString().toIntOrNull() ?: 0
                            val value32 = viewtext32.text.toString().toIntOrNull() ?: 0
                            val value33 = viewtext33.text.toString().toIntOrNull() ?: 0
                            val value34 = viewtext34.text.toString().toIntOrNull() ?: 0
                            val value35 = viewtext35.text.toString().toIntOrNull() ?: 0
                            val value36 = viewtext36.text.toString().toIntOrNull() ?: 0
                            val value37 = viewtext37.text.toString().toIntOrNull() ?: 0
                            val value38 = viewtext38.text.toString().toIntOrNull() ?: 0
                            val value39 = viewtext39.text.toString().toIntOrNull() ?: 0
                            val value40 = viewtext40.text.toString().toIntOrNull() ?: 0
                            val value41 = viewtext41.text.toString().toIntOrNull() ?: 0
                            val value42 = viewtext42.text.toString().toIntOrNull() ?: 0
                            val value43 = viewtext43.text.toString().toIntOrNull() ?: 0
                            val value44 = viewtext44.text.toString().toIntOrNull() ?: 0
                            val value45 = viewtext45.text.toString().toIntOrNull() ?: 0
                            val value46 = viewtext46.text.toString().toIntOrNull() ?: 0
                            val value47 = viewtext47.text.toString().toIntOrNull() ?: 0
                            val value48 = viewtext48.text.toString().toIntOrNull() ?: 0
                            val value49 = viewtext49.text.toString().toIntOrNull() ?: 0
                            val value50 = viewtext50.text.toString().toIntOrNull() ?: 0
                            val value51 = viewtext51.text.toString().toIntOrNull() ?: 0
                            val value52 = viewtext52.text.toString().toIntOrNull() ?: 0
                            val value53 = viewtext53.text.toString().toIntOrNull() ?: 0
                            val value54 = viewtext54.text.toString().toIntOrNull() ?: 0
                            val value55 = viewtext55.text.toString().toIntOrNull() ?: 0
                            val value56 = viewtext56.text.toString().toIntOrNull() ?: 0
                            val value57 = viewtext57.text.toString().toIntOrNull() ?: 0
                            val value58 = viewtext58.text.toString().toIntOrNull() ?: 0
                            val value59 = viewtext59.text.toString().toIntOrNull() ?: 0

                            sum = (value1 + value2 + value3 + value4 + value5 +
                                    value6 + value7 + value8 + value9 + value10 + value11 +
                                    value12 + value13 + value14 + value15 + value16 + value17 +
                                    value18 + value19 + value20 + value21 + value22 + value23 +
                                    value24 + value25 + value26 + value27 + value28 + value29 +
                                    value30 + value31 + value32 + value33 + value34 + value35 +
                                    value36 + value37 + value38 + value39 + value40 + value41 +
                                    value42 + value43 + value44 + value45 + value46 + value47 +
                                    value48 + value49 + value50 + value51 + value52 + value53 +
                                    value54 + value55 + value56 + value57 + value58 + value59).toString()

                            totalall_E_D.text = (sum)
                        }
                            override fun afterTextChanged(s: Editable?) {
                            }
                        })
                    }
            }

                if (item.checkData.check5.isNotEmpty()){
                    customDialogFB.apply { checkBoxauto5.setText(item.checkData.check5)
                        checkBoxauto5.setTextColor(Color.parseColor("#000000"))
                        checkBoxauto5.layoutParams = LinearLayout.LayoutParams(
                            ViewGroup.LayoutParams.WRAP_CONTENT,
                            ViewGroup.LayoutParams.WRAP_CONTENT, Float.MIN_VALUE)
                        viewtext5.setText(item.checkData.price5)
                        viewtext5.setTextColor(Color.parseColor("#000000"))
                        p5.addView(viewtext5)
                        L_c5.addView(checkBoxauto5)
                        viewtext5.setSelectAllOnFocus(true)
                        checkBoxauto5.setSelectAllOnFocus(true)
                        checkBoxauto5.textSize = 14f
                        checkBoxauto5.setTypeface(null, Typeface.BOLD)
                        checkBoxauto5.isSingleLine = true
                        viewtext5.isSingleLine = true
                        viewtext5.textSize = 14f
                        viewtext5.inputType = InputType.TYPE_CLASS_PHONE
                        viewtext5.addTextChangedListener(object : TextWatcher {
                            override fun beforeTextChanged(
                                s: CharSequence?,
                                start: Int,
                                count: Int,
                                after: Int
                            ) {
                            }

                            override fun onTextChanged(
                                s: CharSequence?,
                                start: Int,
                                before: Int,
                                count: Int
                            ) {
                                val value1 = viewtext1.text.toString().toIntOrNull() ?: 0
                                val value2 = viewtext2.text.toString().toIntOrNull() ?: 0
                                val value3 = viewtext3.text.toString().toIntOrNull() ?: 0
                                val value4 = viewtext4.text.toString().toIntOrNull() ?: 0
                                val value5 = viewtext5.text.toString().toIntOrNull() ?: 0
                                val value6 = viewtext6.text.toString().toIntOrNull() ?: 0
                                val value7 = viewtext7.text.toString().toIntOrNull() ?: 0
                                val value8 = viewtext8.text.toString().toIntOrNull() ?: 0
                                val value9 = viewtext9.text.toString().toIntOrNull() ?: 0
                                val value10 = viewtext10.text.toString().toIntOrNull() ?: 0
                                val value11 = viewtext11.text.toString().toIntOrNull() ?: 0
                                val value12 = viewtext12.text.toString().toIntOrNull() ?: 0
                                val value13 = viewtext13.text.toString().toIntOrNull() ?: 0
                                val value14 = viewtext14.text.toString().toIntOrNull() ?: 0
                                val value15 = viewtext15.text.toString().toIntOrNull() ?: 0
                                val value16 = viewtext16.text.toString().toIntOrNull() ?: 0
                                val value17 = viewtext17.text.toString().toIntOrNull() ?: 0
                                val value18 = viewtext18.text.toString().toIntOrNull() ?: 0
                                val value19 = viewtext19.text.toString().toIntOrNull() ?: 0
                                val value20 = viewtext20.text.toString().toIntOrNull() ?: 0
                                val value21 = viewtext21.text.toString().toIntOrNull() ?: 0
                                val value22 = viewtext22.text.toString().toIntOrNull() ?: 0
                                val value23 = viewtext23.text.toString().toIntOrNull() ?: 0
                                val value24 = viewtext24.text.toString().toIntOrNull() ?: 0
                                val value25 = viewtext25.text.toString().toIntOrNull() ?: 0
                                val value26 = viewtext26.text.toString().toIntOrNull() ?: 0
                                val value27 = viewtext27.text.toString().toIntOrNull() ?: 0
                                val value28 = viewtext28.text.toString().toIntOrNull() ?: 0
                                val value29 = viewtext29.text.toString().toIntOrNull() ?: 0
                                val value30 = viewtext30.text.toString().toIntOrNull() ?: 0
                                val value31 = viewtext31.text.toString().toIntOrNull() ?: 0
                                val value32 = viewtext32.text.toString().toIntOrNull() ?: 0
                                val value33 = viewtext33.text.toString().toIntOrNull() ?: 0
                                val value34 = viewtext34.text.toString().toIntOrNull() ?: 0
                                val value35 = viewtext35.text.toString().toIntOrNull() ?: 0
                                val value36 = viewtext36.text.toString().toIntOrNull() ?: 0
                                val value37 = viewtext37.text.toString().toIntOrNull() ?: 0
                                val value38 = viewtext38.text.toString().toIntOrNull() ?: 0
                                val value39 = viewtext39.text.toString().toIntOrNull() ?: 0
                                val value40 = viewtext40.text.toString().toIntOrNull() ?: 0
                                val value41 = viewtext41.text.toString().toIntOrNull() ?: 0
                                val value42 = viewtext42.text.toString().toIntOrNull() ?: 0
                                val value43 = viewtext43.text.toString().toIntOrNull() ?: 0
                                val value44 = viewtext44.text.toString().toIntOrNull() ?: 0
                                val value45 = viewtext45.text.toString().toIntOrNull() ?: 0
                                val value46 = viewtext46.text.toString().toIntOrNull() ?: 0
                                val value47 = viewtext47.text.toString().toIntOrNull() ?: 0
                                val value48 = viewtext48.text.toString().toIntOrNull() ?: 0
                                val value49 = viewtext49.text.toString().toIntOrNull() ?: 0
                                val value50 = viewtext50.text.toString().toIntOrNull() ?: 0
                                val value51 = viewtext51.text.toString().toIntOrNull() ?: 0
                                val value52 = viewtext52.text.toString().toIntOrNull() ?: 0
                                val value53 = viewtext53.text.toString().toIntOrNull() ?: 0
                                val value54 = viewtext54.text.toString().toIntOrNull() ?: 0
                                val value55 = viewtext55.text.toString().toIntOrNull() ?: 0
                                val value56 = viewtext56.text.toString().toIntOrNull() ?: 0
                                val value57 = viewtext57.text.toString().toIntOrNull() ?: 0
                                val value58 = viewtext58.text.toString().toIntOrNull() ?: 0
                                val value59 = viewtext59.text.toString().toIntOrNull() ?: 0

                                sum = (value1 + value2 + value3 + value4 + value5 +
                                        value6 + value7 + value8 + value9 + value10 + value11 +
                                        value12 + value13 + value14 + value15 + value16 + value17 +
                                        value18 + value19 + value20 + value21 + value22 + value23 +
                                        value24 + value25 + value26 + value27 + value28 + value29 +
                                        value30 + value31 + value32 + value33 + value34 + value35 +
                                        value36 + value37 + value38 + value39 + value40 + value41 +
                                        value42 + value43 + value44 + value45 + value46 + value47 +
                                        value48 + value49 + value50 + value51 + value52 + value53 +
                                        value54 + value55 + value56 + value57 + value58 + value59).toString()

                                totalall_E_D.text = (sum)
                            }

                                override fun afterTextChanged(s: Editable?) {
                                }
                            })
                        }
                }

                    if (item.checkData.check6.isNotEmpty()){
                        customDialogFB.apply { checkBoxauto6.setText(item.checkData.check6)
                            checkBoxauto6.setTextColor(Color.parseColor("#000000"))
                            checkBoxauto6.layoutParams = LinearLayout.LayoutParams(
                                ViewGroup.LayoutParams.WRAP_CONTENT,
                                ViewGroup.LayoutParams.WRAP_CONTENT, Float.MIN_VALUE)
                            viewtext6.setText(item.checkData.price6)
                            viewtext6.setTextColor(Color.parseColor("#000000"))
                            p6.addView(viewtext6)
                            L_c6.addView(checkBoxauto6)
                            viewtext6.setSelectAllOnFocus(true)
                            checkBoxauto6.setSelectAllOnFocus(true)
                            checkBoxauto6.textSize = 14f
                            checkBoxauto6.setTypeface(null, Typeface.BOLD)
                            checkBoxauto6.isSingleLine = true
                            checkBoxauto6.isSingleLine = true
                            viewtext6.textSize = 14f
                            viewtext6.inputType = InputType.TYPE_CLASS_PHONE
                            viewtext6.addTextChangedListener(object : TextWatcher {
                                override fun beforeTextChanged(
                                    s: CharSequence?,
                                    start: Int,
                                    count: Int,
                                    after: Int
                                ) {
                                }

                                override fun onTextChanged(
                                    s: CharSequence?,
                                    start: Int,
                                    before: Int,
                                    count: Int
                                ) {
                                    val value1 = viewtext1.text.toString().toIntOrNull() ?: 0
                                    val value2 = viewtext2.text.toString().toIntOrNull() ?: 0
                                    val value3 = viewtext3.text.toString().toIntOrNull() ?: 0
                                    val value4 = viewtext4.text.toString().toIntOrNull() ?: 0
                                    val value5 = viewtext5.text.toString().toIntOrNull() ?: 0
                                    val value6 = viewtext6.text.toString().toIntOrNull() ?: 0
                                    val value7 = viewtext7.text.toString().toIntOrNull() ?: 0
                                    val value8 = viewtext8.text.toString().toIntOrNull() ?: 0
                                    val value9 = viewtext9.text.toString().toIntOrNull() ?: 0
                                    val value10 = viewtext10.text.toString().toIntOrNull() ?: 0
                                    val value11 = viewtext11.text.toString().toIntOrNull() ?: 0
                                    val value12 = viewtext12.text.toString().toIntOrNull() ?: 0
                                    val value13 = viewtext13.text.toString().toIntOrNull() ?: 0
                                    val value14 = viewtext14.text.toString().toIntOrNull() ?: 0
                                    val value15 = viewtext15.text.toString().toIntOrNull() ?: 0
                                    val value16 = viewtext16.text.toString().toIntOrNull() ?: 0
                                    val value17 = viewtext17.text.toString().toIntOrNull() ?: 0
                                    val value18 = viewtext18.text.toString().toIntOrNull() ?: 0
                                    val value19 = viewtext19.text.toString().toIntOrNull() ?: 0
                                    val value20 = viewtext20.text.toString().toIntOrNull() ?: 0
                                    val value21 = viewtext21.text.toString().toIntOrNull() ?: 0
                                    val value22 = viewtext22.text.toString().toIntOrNull() ?: 0
                                    val value23 = viewtext23.text.toString().toIntOrNull() ?: 0
                                    val value24 = viewtext24.text.toString().toIntOrNull() ?: 0
                                    val value25 = viewtext25.text.toString().toIntOrNull() ?: 0
                                    val value26 = viewtext26.text.toString().toIntOrNull() ?: 0
                                    val value27 = viewtext27.text.toString().toIntOrNull() ?: 0
                                    val value28 = viewtext28.text.toString().toIntOrNull() ?: 0
                                    val value29 = viewtext29.text.toString().toIntOrNull() ?: 0
                                    val value30 = viewtext30.text.toString().toIntOrNull() ?: 0
                                    val value31 = viewtext31.text.toString().toIntOrNull() ?: 0
                                    val value32 = viewtext32.text.toString().toIntOrNull() ?: 0
                                    val value33 = viewtext33.text.toString().toIntOrNull() ?: 0
                                    val value34 = viewtext34.text.toString().toIntOrNull() ?: 0
                                    val value35 = viewtext35.text.toString().toIntOrNull() ?: 0
                                    val value36 = viewtext36.text.toString().toIntOrNull() ?: 0
                                    val value37 = viewtext37.text.toString().toIntOrNull() ?: 0
                                    val value38 = viewtext38.text.toString().toIntOrNull() ?: 0
                                    val value39 = viewtext39.text.toString().toIntOrNull() ?: 0
                                    val value40 = viewtext40.text.toString().toIntOrNull() ?: 0
                                    val value41 = viewtext41.text.toString().toIntOrNull() ?: 0
                                    val value42 = viewtext42.text.toString().toIntOrNull() ?: 0
                                    val value43 = viewtext43.text.toString().toIntOrNull() ?: 0
                                    val value44 = viewtext44.text.toString().toIntOrNull() ?: 0
                                    val value45 = viewtext45.text.toString().toIntOrNull() ?: 0
                                    val value46 = viewtext46.text.toString().toIntOrNull() ?: 0
                                    val value47 = viewtext47.text.toString().toIntOrNull() ?: 0
                                    val value48 = viewtext48.text.toString().toIntOrNull() ?: 0
                                    val value49 = viewtext49.text.toString().toIntOrNull() ?: 0
                                    val value50 = viewtext50.text.toString().toIntOrNull() ?: 0
                                    val value51 = viewtext51.text.toString().toIntOrNull() ?: 0
                                    val value52 = viewtext52.text.toString().toIntOrNull() ?: 0
                                    val value53 = viewtext53.text.toString().toIntOrNull() ?: 0
                                    val value54 = viewtext54.text.toString().toIntOrNull() ?: 0
                                    val value55 = viewtext55.text.toString().toIntOrNull() ?: 0
                                    val value56 = viewtext56.text.toString().toIntOrNull() ?: 0
                                    val value57 = viewtext57.text.toString().toIntOrNull() ?: 0
                                    val value58 = viewtext58.text.toString().toIntOrNull() ?: 0
                                    val value59 = viewtext59.text.toString().toIntOrNull() ?: 0

                                    sum = (value1 + value2 + value3 + value4  + value5 +
                                            value6 + value7  + value8  + value9 + value10 + value11 +
                                            value12 + value13 + value14 + value15  + value16  + value17 +
                                            value18 + value19  + value20  + value21 + value22 + value23 +
                                            value24 + value25 + value26 + value27  + value28  + value29 +
                                            value30 + value31  + value32  + value33 + value34 + value35 +
                                            value36 + value37 + value38 + value39  + value40  + value41 +
                                            value42 + value43  + value44  + value45 + value46 + value47 +
                                            value48 + value49 + value50 + value51  + value52  + value53 +
                                            value54 + value55  + value56  + value57 + value58 + value59).toString()

                                    totalall_E_D.text = (sum)
                                }

                                override fun afterTextChanged(s: Editable?) {
                                }
                            })
                        }
                    }

                    if (item.checkData.check7.isNotEmpty()){
                        customDialogFB.apply { checkBoxauto7.setText(item.checkData.check7)
                            checkBoxauto7.setTextColor(Color.parseColor("#000000"))
                            checkBoxauto7.layoutParams = LinearLayout.LayoutParams(
                                ViewGroup.LayoutParams.WRAP_CONTENT,
                                ViewGroup.LayoutParams.WRAP_CONTENT, Float.MIN_VALUE)
                            viewtext7.setText(item.checkData.price7)
                            viewtext7.setTextColor(Color.parseColor("#000000"))
                            p7.addView(viewtext7)
                            L_c7.addView(checkBoxauto7)
                            viewtext7.setSelectAllOnFocus(true)
                            checkBoxauto7.setSelectAllOnFocus(true)
                            checkBoxauto7.textSize = 14f
                            checkBoxauto7.setTypeface(null, Typeface.BOLD)
                            checkBoxauto7.isSingleLine = true
                            viewtext7.isSingleLine = true
                            viewtext7.textSize = 14f
                            viewtext7.inputType = InputType.TYPE_CLASS_PHONE

                            viewtext7.addTextChangedListener(object : TextWatcher {
                                override fun beforeTextChanged(
                                    s: CharSequence?,
                                    start: Int,
                                    count: Int,
                                    after: Int
                                ) {
                                }

                                override fun onTextChanged(
                                    s: CharSequence?,
                                    start: Int,
                                    before: Int,
                                    count: Int
                                ) {
                                    val value1 = viewtext1.text.toString().toIntOrNull() ?: 0
                                    val value2 = viewtext2.text.toString().toIntOrNull() ?: 0
                                    val value3 = viewtext3.text.toString().toIntOrNull() ?: 0
                                    val value4 = viewtext4.text.toString().toIntOrNull() ?: 0
                                    val value5 = viewtext5.text.toString().toIntOrNull() ?: 0
                                    val value6 = viewtext6.text.toString().toIntOrNull() ?: 0
                                    val value7 = viewtext7.text.toString().toIntOrNull() ?: 0
                                    val value8 = viewtext8.text.toString().toIntOrNull() ?: 0
                                    val value9 = viewtext9.text.toString().toIntOrNull() ?: 0
                                    val value10 = viewtext10.text.toString().toIntOrNull() ?: 0
                                    val value11 = viewtext11.text.toString().toIntOrNull() ?: 0
                                    val value12 = viewtext12.text.toString().toIntOrNull() ?: 0
                                    val value13 = viewtext13.text.toString().toIntOrNull() ?: 0
                                    val value14 = viewtext14.text.toString().toIntOrNull() ?: 0
                                    val value15 = viewtext15.text.toString().toIntOrNull() ?: 0
                                    val value16 = viewtext16.text.toString().toIntOrNull() ?: 0
                                    val value17 = viewtext17.text.toString().toIntOrNull() ?: 0
                                    val value18 = viewtext18.text.toString().toIntOrNull() ?: 0
                                    val value19 = viewtext19.text.toString().toIntOrNull() ?: 0
                                    val value20 = viewtext20.text.toString().toIntOrNull() ?: 0
                                    val value21 = viewtext21.text.toString().toIntOrNull() ?: 0
                                    val value22 = viewtext22.text.toString().toIntOrNull() ?: 0
                                    val value23 = viewtext23.text.toString().toIntOrNull() ?: 0
                                    val value24 = viewtext24.text.toString().toIntOrNull() ?: 0
                                    val value25 = viewtext25.text.toString().toIntOrNull() ?: 0
                                    val value26 = viewtext26.text.toString().toIntOrNull() ?: 0
                                    val value27 = viewtext27.text.toString().toIntOrNull() ?: 0
                                    val value28 = viewtext28.text.toString().toIntOrNull() ?: 0
                                    val value29 = viewtext29.text.toString().toIntOrNull() ?: 0
                                    val value30 = viewtext30.text.toString().toIntOrNull() ?: 0
                                    val value31 = viewtext31.text.toString().toIntOrNull() ?: 0
                                    val value32 = viewtext32.text.toString().toIntOrNull() ?: 0
                                    val value33 = viewtext33.text.toString().toIntOrNull() ?: 0
                                    val value34 = viewtext34.text.toString().toIntOrNull() ?: 0
                                    val value35 = viewtext35.text.toString().toIntOrNull() ?: 0
                                    val value36 = viewtext36.text.toString().toIntOrNull() ?: 0
                                    val value37 = viewtext37.text.toString().toIntOrNull() ?: 0
                                    val value38 = viewtext38.text.toString().toIntOrNull() ?: 0
                                    val value39 = viewtext39.text.toString().toIntOrNull() ?: 0
                                    val value40 = viewtext40.text.toString().toIntOrNull() ?: 0
                                    val value41 = viewtext41.text.toString().toIntOrNull() ?: 0
                                    val value42 = viewtext42.text.toString().toIntOrNull() ?: 0
                                    val value43 = viewtext43.text.toString().toIntOrNull() ?: 0
                                    val value44 = viewtext44.text.toString().toIntOrNull() ?: 0
                                    val value45 = viewtext45.text.toString().toIntOrNull() ?: 0
                                    val value46 = viewtext46.text.toString().toIntOrNull() ?: 0
                                    val value47 = viewtext47.text.toString().toIntOrNull() ?: 0
                                    val value48 = viewtext48.text.toString().toIntOrNull() ?: 0
                                    val value49 = viewtext49.text.toString().toIntOrNull() ?: 0
                                    val value50 = viewtext50.text.toString().toIntOrNull() ?: 0
                                    val value51 = viewtext51.text.toString().toIntOrNull() ?: 0
                                    val value52 = viewtext52.text.toString().toIntOrNull() ?: 0
                                    val value53 = viewtext53.text.toString().toIntOrNull() ?: 0
                                    val value54 = viewtext54.text.toString().toIntOrNull() ?: 0
                                    val value55 = viewtext55.text.toString().toIntOrNull() ?: 0
                                    val value56 = viewtext56.text.toString().toIntOrNull() ?: 0
                                    val value57 = viewtext57.text.toString().toIntOrNull() ?: 0
                                    val value58 = viewtext58.text.toString().toIntOrNull() ?: 0
                                    val value59 = viewtext59.text.toString().toIntOrNull() ?: 0

                                    sum = (value1 + value2 + value3 + value4  + value5 +
                                            value6 + value7  + value8  + value9 + value10 + value11 +
                                            value12 + value13 + value14 + value15  + value16  + value17 +
                                            value18 + value19  + value20  + value21 + value22 + value23 +
                                            value24 + value25 + value26 + value27  + value28  + value29 +
                                            value30 + value31  + value32  + value33 + value34 + value35 +
                                            value36 + value37 + value38 + value39  + value40  + value41 +
                                            value42 + value43  + value44  + value45 + value46 + value47 +
                                            value48 + value49 + value50 + value51  + value52  + value53 +
                                            value54 + value55  + value56  + value57 + value58 + value59).toString()

                                    totalall_E_D.text = (sum)
                                }

                                override fun afterTextChanged(s: Editable?) {
                                }
                            })
                        }
                    }

                    if (item.checkData.check8.isNotEmpty()){
                        customDialogFB.apply { checkBoxauto8.setText(item.checkData.check8)
                            checkBoxauto8.setTextColor(Color.parseColor("#000000"))
                            checkBoxauto8.layoutParams = LinearLayout.LayoutParams(
                                ViewGroup.LayoutParams.WRAP_CONTENT,
                                ViewGroup.LayoutParams.WRAP_CONTENT, Float.MIN_VALUE)
                            viewtext8.setText(item.checkData.price8)
                            viewtext8.setTextColor(Color.parseColor("#000000"))
                            p8.addView(viewtext8)
                            L_c8.addView(checkBoxauto8)
                            viewtext8.setSelectAllOnFocus(true)
                            checkBoxauto8.setSelectAllOnFocus(true)
                            checkBoxauto8.textSize = 14f
                            checkBoxauto8.setTypeface(null, Typeface.BOLD)
                            checkBoxauto8.isSingleLine = true
                            viewtext8.isSingleLine = true
                            viewtext8.textSize = 14f
                            viewtext8.inputType = InputType.TYPE_CLASS_PHONE

                            viewtext8.addTextChangedListener(object : TextWatcher {
                                override fun beforeTextChanged(
                                    s: CharSequence?,
                                    start: Int,
                                    count: Int,
                                    after: Int
                                ) {
                                }

                                override fun onTextChanged(
                                    s: CharSequence?,
                                    start: Int,
                                    before: Int,
                                    count: Int
                                ) {
                                    val value1 = viewtext1.text.toString().toIntOrNull() ?: 0
                                    val value2 = viewtext2.text.toString().toIntOrNull() ?: 0
                                    val value3 = viewtext3.text.toString().toIntOrNull() ?: 0
                                    val value4 = viewtext4.text.toString().toIntOrNull() ?: 0
                                    val value5 = viewtext5.text.toString().toIntOrNull() ?: 0
                                    val value6 = viewtext6.text.toString().toIntOrNull() ?: 0
                                    val value7 = viewtext7.text.toString().toIntOrNull() ?: 0
                                    val value8 = viewtext8.text.toString().toIntOrNull() ?: 0
                                    val value9 = viewtext9.text.toString().toIntOrNull() ?: 0
                                    val value10 = viewtext10.text.toString().toIntOrNull() ?: 0
                                    val value11 = viewtext11.text.toString().toIntOrNull() ?: 0
                                    val value12 = viewtext12.text.toString().toIntOrNull() ?: 0
                                    val value13 = viewtext13.text.toString().toIntOrNull() ?: 0
                                    val value14 = viewtext14.text.toString().toIntOrNull() ?: 0
                                    val value15 = viewtext15.text.toString().toIntOrNull() ?: 0
                                    val value16 = viewtext16.text.toString().toIntOrNull() ?: 0
                                    val value17 = viewtext17.text.toString().toIntOrNull() ?: 0
                                    val value18 = viewtext18.text.toString().toIntOrNull() ?: 0
                                    val value19 = viewtext19.text.toString().toIntOrNull() ?: 0
                                    val value20 = viewtext20.text.toString().toIntOrNull() ?: 0
                                    val value21 = viewtext21.text.toString().toIntOrNull() ?: 0
                                    val value22 = viewtext22.text.toString().toIntOrNull() ?: 0
                                    val value23 = viewtext23.text.toString().toIntOrNull() ?: 0
                                    val value24 = viewtext24.text.toString().toIntOrNull() ?: 0
                                    val value25 = viewtext25.text.toString().toIntOrNull() ?: 0
                                    val value26 = viewtext26.text.toString().toIntOrNull() ?: 0
                                    val value27 = viewtext27.text.toString().toIntOrNull() ?: 0
                                    val value28 = viewtext28.text.toString().toIntOrNull() ?: 0
                                    val value29 = viewtext29.text.toString().toIntOrNull() ?: 0
                                    val value30 = viewtext30.text.toString().toIntOrNull() ?: 0
                                    val value31 = viewtext31.text.toString().toIntOrNull() ?: 0
                                    val value32 = viewtext32.text.toString().toIntOrNull() ?: 0
                                    val value33 = viewtext33.text.toString().toIntOrNull() ?: 0
                                    val value34 = viewtext34.text.toString().toIntOrNull() ?: 0
                                    val value35 = viewtext35.text.toString().toIntOrNull() ?: 0
                                    val value36 = viewtext36.text.toString().toIntOrNull() ?: 0
                                    val value37 = viewtext37.text.toString().toIntOrNull() ?: 0
                                    val value38 = viewtext38.text.toString().toIntOrNull() ?: 0
                                    val value39 = viewtext39.text.toString().toIntOrNull() ?: 0
                                    val value40 = viewtext40.text.toString().toIntOrNull() ?: 0
                                    val value41 = viewtext41.text.toString().toIntOrNull() ?: 0
                                    val value42 = viewtext42.text.toString().toIntOrNull() ?: 0
                                    val value43 = viewtext43.text.toString().toIntOrNull() ?: 0
                                    val value44 = viewtext44.text.toString().toIntOrNull() ?: 0
                                    val value45 = viewtext45.text.toString().toIntOrNull() ?: 0
                                    val value46 = viewtext46.text.toString().toIntOrNull() ?: 0
                                    val value47 = viewtext47.text.toString().toIntOrNull() ?: 0
                                    val value48 = viewtext48.text.toString().toIntOrNull() ?: 0
                                    val value49 = viewtext49.text.toString().toIntOrNull() ?: 0
                                    val value50 = viewtext50.text.toString().toIntOrNull() ?: 0
                                    val value51 = viewtext51.text.toString().toIntOrNull() ?: 0
                                    val value52 = viewtext52.text.toString().toIntOrNull() ?: 0
                                    val value53 = viewtext53.text.toString().toIntOrNull() ?: 0
                                    val value54 = viewtext54.text.toString().toIntOrNull() ?: 0
                                    val value55 = viewtext55.text.toString().toIntOrNull() ?: 0
                                    val value56 = viewtext56.text.toString().toIntOrNull() ?: 0
                                    val value57 = viewtext57.text.toString().toIntOrNull() ?: 0
                                    val value58 = viewtext58.text.toString().toIntOrNull() ?: 0
                                    val value59 = viewtext59.text.toString().toIntOrNull() ?: 0

                                    sum = (value1 + value2 + value3 + value4  + value5 +
                                            value6 + value7  + value8  + value9 + value10 + value11 +
                                            value12 + value13 + value14 + value15  + value16  + value17 +
                                            value18 + value19  + value20  + value21 + value22 + value23 +
                                            value24 + value25 + value26 + value27  + value28  + value29 +
                                            value30 + value31  + value32  + value33 + value34 + value35 +
                                            value36 + value37 + value38 + value39  + value40  + value41 +
                                            value42 + value43  + value44  + value45 + value46 + value47 +
                                            value48 + value49 + value50 + value51  + value52  + value53 +
                                            value54 + value55  + value56  + value57 + value58 + value59).toString()

                                    totalall_E_D.text = (sum)
                                }

                                override fun afterTextChanged(s: Editable?) {
                                }
                            })
                        }
                    }

                    if (item.checkData.check9.isNotEmpty()){
                        customDialogFB.apply { checkBoxauto9.setText(item.checkData.check9)
                            checkBoxauto9.setTextColor(Color.parseColor("#000000"))
                            checkBoxauto9.layoutParams = LinearLayout.LayoutParams(
                                ViewGroup.LayoutParams.WRAP_CONTENT,
                                ViewGroup.LayoutParams.WRAP_CONTENT, Float.MIN_VALUE)
                            viewtext9.setText(item.checkData.price9)
                            viewtext9.setTextColor(Color.parseColor("#000000"))
                            p9.addView(viewtext9)
                            L_c9.addView(checkBoxauto9)
                            viewtext9.setSelectAllOnFocus(true)
                            checkBoxauto9.setSelectAllOnFocus(true)
                            checkBoxauto9.textSize = 14f
                            checkBoxauto9.setTypeface(null, Typeface.BOLD)
                            checkBoxauto9.isSingleLine = true
                            viewtext9.isSingleLine = true
                            viewtext9.textSize = 14f
                            viewtext9.inputType = InputType.TYPE_CLASS_PHONE

                            viewtext9.addTextChangedListener(object : TextWatcher {
                                override fun beforeTextChanged(
                                    s: CharSequence?,
                                    start: Int,
                                    count: Int,
                                    after: Int
                                ) {
                                }

                                override fun onTextChanged(
                                    s: CharSequence?,
                                    start: Int,
                                    before: Int,
                                    count: Int
                                ) {
                                    val value1 = viewtext1.text.toString().toIntOrNull() ?: 0
                                    val value2 = viewtext2.text.toString().toIntOrNull() ?: 0
                                    val value3 = viewtext3.text.toString().toIntOrNull() ?: 0
                                    val value4 = viewtext4.text.toString().toIntOrNull() ?: 0
                                    val value5 = viewtext5.text.toString().toIntOrNull() ?: 0
                                    val value6 = viewtext6.text.toString().toIntOrNull() ?: 0
                                    val value7 = viewtext7.text.toString().toIntOrNull() ?: 0
                                    val value8 = viewtext8.text.toString().toIntOrNull() ?: 0
                                    val value9 = viewtext9.text.toString().toIntOrNull() ?: 0
                                    val value10 = viewtext10.text.toString().toIntOrNull() ?: 0
                                    val value11 = viewtext11.text.toString().toIntOrNull() ?: 0
                                    val value12 = viewtext12.text.toString().toIntOrNull() ?: 0
                                    val value13 = viewtext13.text.toString().toIntOrNull() ?: 0
                                    val value14 = viewtext14.text.toString().toIntOrNull() ?: 0
                                    val value15 = viewtext15.text.toString().toIntOrNull() ?: 0
                                    val value16 = viewtext16.text.toString().toIntOrNull() ?: 0
                                    val value17 = viewtext17.text.toString().toIntOrNull() ?: 0
                                    val value18 = viewtext18.text.toString().toIntOrNull() ?: 0
                                    val value19 = viewtext19.text.toString().toIntOrNull() ?: 0
                                    val value20 = viewtext20.text.toString().toIntOrNull() ?: 0
                                    val value21 = viewtext21.text.toString().toIntOrNull() ?: 0
                                    val value22 = viewtext22.text.toString().toIntOrNull() ?: 0
                                    val value23 = viewtext23.text.toString().toIntOrNull() ?: 0
                                    val value24 = viewtext24.text.toString().toIntOrNull() ?: 0
                                    val value25 = viewtext25.text.toString().toIntOrNull() ?: 0
                                    val value26 = viewtext26.text.toString().toIntOrNull() ?: 0
                                    val value27 = viewtext27.text.toString().toIntOrNull() ?: 0
                                    val value28 = viewtext28.text.toString().toIntOrNull() ?: 0
                                    val value29 = viewtext29.text.toString().toIntOrNull() ?: 0
                                    val value30 = viewtext30.text.toString().toIntOrNull() ?: 0
                                    val value31 = viewtext31.text.toString().toIntOrNull() ?: 0
                                    val value32 = viewtext32.text.toString().toIntOrNull() ?: 0
                                    val value33 = viewtext33.text.toString().toIntOrNull() ?: 0
                                    val value34 = viewtext34.text.toString().toIntOrNull() ?: 0
                                    val value35 = viewtext35.text.toString().toIntOrNull() ?: 0
                                    val value36 = viewtext36.text.toString().toIntOrNull() ?: 0
                                    val value37 = viewtext37.text.toString().toIntOrNull() ?: 0
                                    val value38 = viewtext38.text.toString().toIntOrNull() ?: 0
                                    val value39 = viewtext39.text.toString().toIntOrNull() ?: 0
                                    val value40 = viewtext40.text.toString().toIntOrNull() ?: 0
                                    val value41 = viewtext41.text.toString().toIntOrNull() ?: 0
                                    val value42 = viewtext42.text.toString().toIntOrNull() ?: 0
                                    val value43 = viewtext43.text.toString().toIntOrNull() ?: 0
                                    val value44 = viewtext44.text.toString().toIntOrNull() ?: 0
                                    val value45 = viewtext45.text.toString().toIntOrNull() ?: 0
                                    val value46 = viewtext46.text.toString().toIntOrNull() ?: 0
                                    val value47 = viewtext47.text.toString().toIntOrNull() ?: 0
                                    val value48 = viewtext48.text.toString().toIntOrNull() ?: 0
                                    val value49 = viewtext49.text.toString().toIntOrNull() ?: 0
                                    val value50 = viewtext50.text.toString().toIntOrNull() ?: 0
                                    val value51 = viewtext51.text.toString().toIntOrNull() ?: 0
                                    val value52 = viewtext52.text.toString().toIntOrNull() ?: 0
                                    val value53 = viewtext53.text.toString().toIntOrNull() ?: 0
                                    val value54 = viewtext54.text.toString().toIntOrNull() ?: 0
                                    val value55 = viewtext55.text.toString().toIntOrNull() ?: 0
                                    val value56 = viewtext56.text.toString().toIntOrNull() ?: 0
                                    val value57 = viewtext57.text.toString().toIntOrNull() ?: 0
                                    val value58 = viewtext58.text.toString().toIntOrNull() ?: 0
                                    val value59 = viewtext59.text.toString().toIntOrNull() ?: 0

                                    sum = (value1 + value2 + value3 + value4  + value5 +
                                            value6 + value7  + value8  + value9 + value10 + value11 +
                                            value12 + value13 + value14 + value15  + value16  + value17 +
                                            value18 + value19  + value20  + value21 + value22 + value23 +
                                            value24 + value25 + value26 + value27  + value28  + value29 +
                                            value30 + value31  + value32  + value33 + value34 + value35 +
                                            value36 + value37 + value38 + value39  + value40  + value41 +
                                            value42 + value43  + value44  + value45 + value46 + value47 +
                                            value48 + value49 + value50 + value51  + value52  + value53 +
                                            value54 + value55  + value56  + value57 + value58 + value59).toString()

                                    totalall_E_D.text = (sum)
                                }

                                override fun afterTextChanged(s: Editable?) {
                                }
                            })
                        }
                    }

                    if (item.checkData.check10.isNotEmpty()){
                        customDialogFB.apply { checkBoxauto10.setText(item.checkData.check10)
                            checkBoxauto10.setTextColor(Color.parseColor("#000000"))
                            checkBoxauto10.layoutParams = LinearLayout.LayoutParams(
                                ViewGroup.LayoutParams.WRAP_CONTENT,
                                ViewGroup.LayoutParams.WRAP_CONTENT, Float.MIN_VALUE)
                            viewtext10.setText(item.checkData.price10)
                            viewtext10.setTextColor(Color.parseColor("#000000"))
                            p10.addView(viewtext10)
                            L_c10.addView(checkBoxauto10)
                            viewtext10.setSelectAllOnFocus(true)
                            checkBoxauto10.setSelectAllOnFocus(true)
                            checkBoxauto10.textSize = 14f
                            checkBoxauto10.setTypeface(null, Typeface.BOLD)
                            checkBoxauto10.isSingleLine = true
                            viewtext10.isSingleLine = true
                            viewtext10.textSize = 14f
                            viewtext10.inputType = InputType.TYPE_CLASS_PHONE

                            viewtext10.addTextChangedListener(object : TextWatcher {
                                override fun beforeTextChanged(
                                    s: CharSequence?,
                                    start: Int,
                                    count: Int,
                                    after: Int
                                ) {
                                }

                                override fun onTextChanged(
                                    s: CharSequence?,
                                    start: Int,
                                    before: Int,
                                    count: Int
                                ) {
                                    val value1 = viewtext1.text.toString().toIntOrNull() ?: 0
                                    val value2 = viewtext2.text.toString().toIntOrNull() ?: 0
                                    val value3 = viewtext3.text.toString().toIntOrNull() ?: 0
                                    val value4 = viewtext4.text.toString().toIntOrNull() ?: 0
                                    val value5 = viewtext5.text.toString().toIntOrNull() ?: 0
                                    val value6 = viewtext6.text.toString().toIntOrNull() ?: 0
                                    val value7 = viewtext7.text.toString().toIntOrNull() ?: 0
                                    val value8 = viewtext8.text.toString().toIntOrNull() ?: 0
                                    val value9 = viewtext9.text.toString().toIntOrNull() ?: 0
                                    val value10 = viewtext10.text.toString().toIntOrNull() ?: 0
                                    val value11 = viewtext11.text.toString().toIntOrNull() ?: 0
                                    val value12 = viewtext12.text.toString().toIntOrNull() ?: 0
                                    val value13 = viewtext13.text.toString().toIntOrNull() ?: 0
                                    val value14 = viewtext14.text.toString().toIntOrNull() ?: 0
                                    val value15 = viewtext15.text.toString().toIntOrNull() ?: 0
                                    val value16 = viewtext16.text.toString().toIntOrNull() ?: 0
                                    val value17 = viewtext17.text.toString().toIntOrNull() ?: 0
                                    val value18 = viewtext18.text.toString().toIntOrNull() ?: 0
                                    val value19 = viewtext19.text.toString().toIntOrNull() ?: 0
                                    val value20 = viewtext20.text.toString().toIntOrNull() ?: 0
                                    val value21 = viewtext21.text.toString().toIntOrNull() ?: 0
                                    val value22 = viewtext22.text.toString().toIntOrNull() ?: 0
                                    val value23 = viewtext23.text.toString().toIntOrNull() ?: 0
                                    val value24 = viewtext24.text.toString().toIntOrNull() ?: 0
                                    val value25 = viewtext25.text.toString().toIntOrNull() ?: 0
                                    val value26 = viewtext26.text.toString().toIntOrNull() ?: 0
                                    val value27 = viewtext27.text.toString().toIntOrNull() ?: 0
                                    val value28 = viewtext28.text.toString().toIntOrNull() ?: 0
                                    val value29 = viewtext29.text.toString().toIntOrNull() ?: 0
                                    val value30 = viewtext30.text.toString().toIntOrNull() ?: 0
                                    val value31 = viewtext31.text.toString().toIntOrNull() ?: 0
                                    val value32 = viewtext32.text.toString().toIntOrNull() ?: 0
                                    val value33 = viewtext33.text.toString().toIntOrNull() ?: 0
                                    val value34 = viewtext34.text.toString().toIntOrNull() ?: 0
                                    val value35 = viewtext35.text.toString().toIntOrNull() ?: 0
                                    val value36 = viewtext36.text.toString().toIntOrNull() ?: 0
                                    val value37 = viewtext37.text.toString().toIntOrNull() ?: 0
                                    val value38 = viewtext38.text.toString().toIntOrNull() ?: 0
                                    val value39 = viewtext39.text.toString().toIntOrNull() ?: 0
                                    val value40 = viewtext40.text.toString().toIntOrNull() ?: 0
                                    val value41 = viewtext41.text.toString().toIntOrNull() ?: 0
                                    val value42 = viewtext42.text.toString().toIntOrNull() ?: 0
                                    val value43 = viewtext43.text.toString().toIntOrNull() ?: 0
                                    val value44 = viewtext44.text.toString().toIntOrNull() ?: 0
                                    val value45 = viewtext45.text.toString().toIntOrNull() ?: 0
                                    val value46 = viewtext46.text.toString().toIntOrNull() ?: 0
                                    val value47 = viewtext47.text.toString().toIntOrNull() ?: 0
                                    val value48 = viewtext48.text.toString().toIntOrNull() ?: 0
                                    val value49 = viewtext49.text.toString().toIntOrNull() ?: 0
                                    val value50 = viewtext50.text.toString().toIntOrNull() ?: 0
                                    val value51 = viewtext51.text.toString().toIntOrNull() ?: 0
                                    val value52 = viewtext52.text.toString().toIntOrNull() ?: 0
                                    val value53 = viewtext53.text.toString().toIntOrNull() ?: 0
                                    val value54 = viewtext54.text.toString().toIntOrNull() ?: 0
                                    val value55 = viewtext55.text.toString().toIntOrNull() ?: 0
                                    val value56 = viewtext56.text.toString().toIntOrNull() ?: 0
                                    val value57 = viewtext57.text.toString().toIntOrNull() ?: 0
                                    val value58 = viewtext58.text.toString().toIntOrNull() ?: 0
                                    val value59 = viewtext59.text.toString().toIntOrNull() ?: 0

                                    sum = (value1 + value2 + value3 + value4  + value5 +
                                            value6 + value7  + value8  + value9 + value10 + value11 +
                                            value12 + value13 + value14 + value15  + value16  + value17 +
                                            value18 + value19  + value20  + value21 + value22 + value23 +
                                            value24 + value25 + value26 + value27  + value28  + value29 +
                                            value30 + value31  + value32  + value33 + value34 + value35 +
                                            value36 + value37 + value38 + value39  + value40  + value41 +
                                            value42 + value43  + value44  + value45 + value46 + value47 +
                                            value48 + value49 + value50 + value51  + value52  + value53 +
                                            value54 + value55  + value56  + value57 + value58 + value59).toString()

                                    totalall_E_D.text = (sum)
                                }

                                override fun afterTextChanged(s: Editable?) {
                                }
                            })
                        }
                    }

                    if (item.checkData.check11.isNotEmpty()){
                        customDialogFB.apply {
                            checkBoxauto11.setText(item.checkData.check11)
                            checkBoxauto11.setTextColor(Color.parseColor("#000000"))
                            checkBoxauto11.layoutParams = LinearLayout.LayoutParams(
                                ViewGroup.LayoutParams.WRAP_CONTENT,
                                ViewGroup.LayoutParams.WRAP_CONTENT, Float.MIN_VALUE)
                            viewtext11.setText(item.checkData.price11)
                            viewtext11.setTextColor(Color.parseColor("#000000"))
                            p11.addView(viewtext11)
                            L_c11.addView(checkBoxauto11)
                            viewtext11.setSelectAllOnFocus(true)
                            checkBoxauto11.setSelectAllOnFocus(true)
                            checkBoxauto11.textSize = 14f
                            checkBoxauto11.setTypeface(null, Typeface.BOLD)
                            checkBoxauto11.isSingleLine = true
                            viewtext11.isSingleLine = true
                            viewtext11.textSize = 14f
                            viewtext11.inputType = InputType.TYPE_CLASS_PHONE
                            viewtext11.addTextChangedListener(object : TextWatcher {
                                override fun beforeTextChanged(
                                    s: CharSequence?,
                                    start: Int,
                                    count: Int,
                                    after: Int
                                ) {
                                }

                                override fun onTextChanged(
                                    s: CharSequence?,
                                    start: Int,
                                    before: Int,
                                    count: Int
                                ) {
                                    val value1 = viewtext1.text.toString().toIntOrNull() ?: 0
                                    val value2 = viewtext2.text.toString().toIntOrNull() ?: 0
                                    val value3 = viewtext3.text.toString().toIntOrNull() ?: 0
                                    val value4 = viewtext4.text.toString().toIntOrNull() ?: 0
                                    val value5 = viewtext5.text.toString().toIntOrNull() ?: 0
                                    val value6 = viewtext6.text.toString().toIntOrNull() ?: 0
                                    val value7 = viewtext7.text.toString().toIntOrNull() ?: 0
                                    val value8 = viewtext8.text.toString().toIntOrNull() ?: 0
                                    val value9 = viewtext9.text.toString().toIntOrNull() ?: 0
                                    val value10 = viewtext10.text.toString().toIntOrNull() ?: 0
                                    val value11 = viewtext11.text.toString().toIntOrNull() ?: 0
                                    val value12 = viewtext12.text.toString().toIntOrNull() ?: 0
                                    val value13 = viewtext13.text.toString().toIntOrNull() ?: 0
                                    val value14 = viewtext14.text.toString().toIntOrNull() ?: 0
                                    val value15 = viewtext15.text.toString().toIntOrNull() ?: 0
                                    val value16 = viewtext16.text.toString().toIntOrNull() ?: 0
                                    val value17 = viewtext17.text.toString().toIntOrNull() ?: 0
                                    val value18 = viewtext18.text.toString().toIntOrNull() ?: 0
                                    val value19 = viewtext19.text.toString().toIntOrNull() ?: 0
                                    val value20 = viewtext20.text.toString().toIntOrNull() ?: 0
                                    val value21 = viewtext21.text.toString().toIntOrNull() ?: 0
                                    val value22 = viewtext22.text.toString().toIntOrNull() ?: 0
                                    val value23 = viewtext23.text.toString().toIntOrNull() ?: 0
                                    val value24 = viewtext24.text.toString().toIntOrNull() ?: 0
                                    val value25 = viewtext25.text.toString().toIntOrNull() ?: 0
                                    val value26 = viewtext26.text.toString().toIntOrNull() ?: 0
                                    val value27 = viewtext27.text.toString().toIntOrNull() ?: 0
                                    val value28 = viewtext28.text.toString().toIntOrNull() ?: 0
                                    val value29 = viewtext29.text.toString().toIntOrNull() ?: 0
                                    val value30 = viewtext30.text.toString().toIntOrNull() ?: 0
                                    val value31 = viewtext31.text.toString().toIntOrNull() ?: 0
                                    val value32 = viewtext32.text.toString().toIntOrNull() ?: 0
                                    val value33 = viewtext33.text.toString().toIntOrNull() ?: 0
                                    val value34 = viewtext34.text.toString().toIntOrNull() ?: 0
                                    val value35 = viewtext35.text.toString().toIntOrNull() ?: 0
                                    val value36 = viewtext36.text.toString().toIntOrNull() ?: 0
                                    val value37 = viewtext37.text.toString().toIntOrNull() ?: 0
                                    val value38 = viewtext38.text.toString().toIntOrNull() ?: 0
                                    val value39 = viewtext39.text.toString().toIntOrNull() ?: 0
                                    val value40 = viewtext40.text.toString().toIntOrNull() ?: 0
                                    val value41 = viewtext41.text.toString().toIntOrNull() ?: 0
                                    val value42 = viewtext42.text.toString().toIntOrNull() ?: 0
                                    val value43 = viewtext43.text.toString().toIntOrNull() ?: 0
                                    val value44 = viewtext44.text.toString().toIntOrNull() ?: 0
                                    val value45 = viewtext45.text.toString().toIntOrNull() ?: 0
                                    val value46 = viewtext46.text.toString().toIntOrNull() ?: 0
                                    val value47 = viewtext47.text.toString().toIntOrNull() ?: 0
                                    val value48 = viewtext48.text.toString().toIntOrNull() ?: 0
                                    val value49 = viewtext49.text.toString().toIntOrNull() ?: 0
                                    val value50 = viewtext50.text.toString().toIntOrNull() ?: 0
                                    val value51 = viewtext51.text.toString().toIntOrNull() ?: 0
                                    val value52 = viewtext52.text.toString().toIntOrNull() ?: 0
                                    val value53 = viewtext53.text.toString().toIntOrNull() ?: 0
                                    val value54 = viewtext54.text.toString().toIntOrNull() ?: 0
                                    val value55 = viewtext55.text.toString().toIntOrNull() ?: 0
                                    val value56 = viewtext56.text.toString().toIntOrNull() ?: 0
                                    val value57 = viewtext57.text.toString().toIntOrNull() ?: 0
                                    val value58 = viewtext58.text.toString().toIntOrNull() ?: 0
                                    val value59 = viewtext59.text.toString().toIntOrNull() ?: 0

                                    sum = (value1 + value2 + value3 + value4  + value5 +
                                            value6 + value7  + value8  + value9 + value10 + value11 +
                                            value12 + value13 + value14 + value15  + value16  + value17 +
                                            value18 + value19  + value20  + value21 + value22 + value23 +
                                            value24 + value25 + value26 + value27  + value28  + value29 +
                                            value30 + value31  + value32  + value33 + value34 + value35 +
                                            value36 + value37 + value38 + value39  + value40  + value41 +
                                            value42 + value43  + value44  + value45 + value46 + value47 +
                                            value48 + value49 + value50 + value51  + value52  + value53 +
                                            value54 + value55  + value56  + value57 + value58 + value59).toString()

                                    totalall_E_D.text = (sum)
                                }

                                override fun afterTextChanged(s: Editable?) {
                                }
                            })
                        }
                    }

                    if (item.checkData.check12.isNotEmpty()){
                        customDialogFB.apply {
                            checkBoxauto12.setText(item.checkData.check12)
                            checkBoxauto12.setTextColor(Color.parseColor("#000000"))
                            checkBoxauto12.layoutParams = LinearLayout.LayoutParams(
                                ViewGroup.LayoutParams.WRAP_CONTENT,
                                ViewGroup.LayoutParams.WRAP_CONTENT, Float.MIN_VALUE)
                            viewtext12.setText(item.checkData.price12)
                            viewtext12.setTextColor(Color.parseColor("#000000"))
                            p12.addView(viewtext12)
                            L_c12.addView(checkBoxauto12)
                            viewtext12.setSelectAllOnFocus(true)
                            checkBoxauto12.setSelectAllOnFocus(true)
                            checkBoxauto12.textSize = 14f
                            checkBoxauto12.setTypeface(null, Typeface.BOLD)
                            checkBoxauto12.isSingleLine = true
                            viewtext12.isSingleLine = true
                            viewtext12.textSize = 14f
                            viewtext12.inputType = InputType.TYPE_CLASS_PHONE

                            viewtext12.addTextChangedListener(object : TextWatcher {
                                override fun beforeTextChanged(
                                    s: CharSequence?,
                                    start: Int,
                                    count: Int,
                                    after: Int
                                ) {
                                }

                                override fun onTextChanged(
                                    s: CharSequence?,
                                    start: Int,
                                    before: Int,
                                    count: Int
                                ) {
                                    val value1 = viewtext1.text.toString().toIntOrNull() ?: 0
                                    val value2 = viewtext2.text.toString().toIntOrNull() ?: 0
                                    val value3 = viewtext3.text.toString().toIntOrNull() ?: 0
                                    val value4 = viewtext4.text.toString().toIntOrNull() ?: 0
                                    val value5 = viewtext5.text.toString().toIntOrNull() ?: 0
                                    val value6 = viewtext6.text.toString().toIntOrNull() ?: 0
                                    val value7 = viewtext7.text.toString().toIntOrNull() ?: 0
                                    val value8 = viewtext8.text.toString().toIntOrNull() ?: 0
                                    val value9 = viewtext9.text.toString().toIntOrNull() ?: 0
                                    val value10 = viewtext10.text.toString().toIntOrNull() ?: 0
                                    val value11 = viewtext11.text.toString().toIntOrNull() ?: 0
                                    val value12 = viewtext12.text.toString().toIntOrNull() ?: 0
                                    val value13 = viewtext13.text.toString().toIntOrNull() ?: 0
                                    val value14 = viewtext14.text.toString().toIntOrNull() ?: 0
                                    val value15 = viewtext15.text.toString().toIntOrNull() ?: 0
                                    val value16 = viewtext16.text.toString().toIntOrNull() ?: 0
                                    val value17 = viewtext17.text.toString().toIntOrNull() ?: 0
                                    val value18 = viewtext18.text.toString().toIntOrNull() ?: 0
                                    val value19 = viewtext19.text.toString().toIntOrNull() ?: 0
                                    val value20 = viewtext20.text.toString().toIntOrNull() ?: 0
                                    val value21 = viewtext21.text.toString().toIntOrNull() ?: 0
                                    val value22 = viewtext22.text.toString().toIntOrNull() ?: 0
                                    val value23 = viewtext23.text.toString().toIntOrNull() ?: 0
                                    val value24 = viewtext24.text.toString().toIntOrNull() ?: 0
                                    val value25 = viewtext25.text.toString().toIntOrNull() ?: 0
                                    val value26 = viewtext26.text.toString().toIntOrNull() ?: 0
                                    val value27 = viewtext27.text.toString().toIntOrNull() ?: 0
                                    val value28 = viewtext28.text.toString().toIntOrNull() ?: 0
                                    val value29 = viewtext29.text.toString().toIntOrNull() ?: 0
                                    val value30 = viewtext30.text.toString().toIntOrNull() ?: 0
                                    val value31 = viewtext31.text.toString().toIntOrNull() ?: 0
                                    val value32 = viewtext32.text.toString().toIntOrNull() ?: 0
                                    val value33 = viewtext33.text.toString().toIntOrNull() ?: 0
                                    val value34 = viewtext34.text.toString().toIntOrNull() ?: 0
                                    val value35 = viewtext35.text.toString().toIntOrNull() ?: 0
                                    val value36 = viewtext36.text.toString().toIntOrNull() ?: 0
                                    val value37 = viewtext37.text.toString().toIntOrNull() ?: 0
                                    val value38 = viewtext38.text.toString().toIntOrNull() ?: 0
                                    val value39 = viewtext39.text.toString().toIntOrNull() ?: 0
                                    val value40 = viewtext40.text.toString().toIntOrNull() ?: 0
                                    val value41 = viewtext41.text.toString().toIntOrNull() ?: 0
                                    val value42 = viewtext42.text.toString().toIntOrNull() ?: 0
                                    val value43 = viewtext43.text.toString().toIntOrNull() ?: 0
                                    val value44 = viewtext44.text.toString().toIntOrNull() ?: 0
                                    val value45 = viewtext45.text.toString().toIntOrNull() ?: 0
                                    val value46 = viewtext46.text.toString().toIntOrNull() ?: 0
                                    val value47 = viewtext47.text.toString().toIntOrNull() ?: 0
                                    val value48 = viewtext48.text.toString().toIntOrNull() ?: 0
                                    val value49 = viewtext49.text.toString().toIntOrNull() ?: 0
                                    val value50 = viewtext50.text.toString().toIntOrNull() ?: 0
                                    val value51 = viewtext51.text.toString().toIntOrNull() ?: 0
                                    val value52 = viewtext52.text.toString().toIntOrNull() ?: 0
                                    val value53 = viewtext53.text.toString().toIntOrNull() ?: 0
                                    val value54 = viewtext54.text.toString().toIntOrNull() ?: 0
                                    val value55 = viewtext55.text.toString().toIntOrNull() ?: 0
                                    val value56 = viewtext56.text.toString().toIntOrNull() ?: 0
                                    val value57 = viewtext57.text.toString().toIntOrNull() ?: 0
                                    val value58 = viewtext58.text.toString().toIntOrNull() ?: 0
                                    val value59 = viewtext59.text.toString().toIntOrNull() ?: 0

                                    sum = (value1 + value2 + value3 + value4 + value5 +
                                            value6 + value7 + value8 + value9 + value10 + value11 +
                                            value12 + value13 + value14 + value15 + value16 + value17 +
                                            value18 + value19 + value20 + value21 + value22 + value23 +
                                            value24 + value25 + value26 + value27 + value28 + value29 +
                                            value30 + value31 + value32 + value33 + value34 + value35 +
                                            value36 + value37 + value38 + value39 + value40 + value41 +
                                            value42 + value43 + value44 + value45 + value46 + value47 +
                                            value48 + value49 + value50 + value51 + value52 + value53 +
                                            value54 + value55 + value56 + value57 + value58 + value59).toString()

                                    totalall_E_D.text = (sum)
                                }

                                override fun afterTextChanged(s: Editable?) {
                                }
                            })
                        }
                    }

                    if (item.checkData.check13.isNotEmpty()){
                        customDialogFB.apply { checkBoxauto13.setText(item.checkData.check13)
                            checkBoxauto13.setTextColor(Color.parseColor("#000000"))
                            checkBoxauto13.layoutParams = LinearLayout.LayoutParams(
                                ViewGroup.LayoutParams.WRAP_CONTENT,
                                ViewGroup.LayoutParams.WRAP_CONTENT, Float.MIN_VALUE)
                            viewtext13.setText(item.checkData.price13)
                            viewtext13.setTextColor(Color.parseColor("#000000"))
                            p13.addView(viewtext13)
                            L_c13.addView(checkBoxauto13)
                            viewtext13.setSelectAllOnFocus(true)
                            checkBoxauto13.setSelectAllOnFocus(true)
                            checkBoxauto13.textSize = 14f
                            checkBoxauto13.setTypeface(null, Typeface.BOLD)
                            checkBoxauto13.isSingleLine = true
                            viewtext13.isSingleLine = true
                            viewtext13.textSize = 14f
                            viewtext13.inputType = InputType.TYPE_CLASS_PHONE

                            viewtext13.addTextChangedListener(object : TextWatcher {
                                override fun beforeTextChanged(
                                    s: CharSequence?,
                                    start: Int,
                                    count: Int,
                                    after: Int
                                ) {
                                }

                                override fun onTextChanged(
                                    s: CharSequence?,
                                    start: Int,
                                    before: Int,
                                    count: Int
                                ) {
                                    val value1 = viewtext1.text.toString().toIntOrNull() ?: 0
                                    val value2 = viewtext2.text.toString().toIntOrNull() ?: 0
                                    val value3 = viewtext3.text.toString().toIntOrNull() ?: 0
                                    val value4 = viewtext4.text.toString().toIntOrNull() ?: 0
                                    val value5 = viewtext5.text.toString().toIntOrNull() ?: 0
                                    val value6 = viewtext6.text.toString().toIntOrNull() ?: 0
                                    val value7 = viewtext7.text.toString().toIntOrNull() ?: 0
                                    val value8 = viewtext8.text.toString().toIntOrNull() ?: 0
                                    val value9 = viewtext9.text.toString().toIntOrNull() ?: 0
                                    val value10 = viewtext10.text.toString().toIntOrNull() ?: 0
                                    val value11 = viewtext11.text.toString().toIntOrNull() ?: 0
                                    val value12 = viewtext12.text.toString().toIntOrNull() ?: 0
                                    val value13 = viewtext13.text.toString().toIntOrNull() ?: 0
                                    val value14 = viewtext14.text.toString().toIntOrNull() ?: 0
                                    val value15 = viewtext15.text.toString().toIntOrNull() ?: 0
                                    val value16 = viewtext16.text.toString().toIntOrNull() ?: 0
                                    val value17 = viewtext17.text.toString().toIntOrNull() ?: 0
                                    val value18 = viewtext18.text.toString().toIntOrNull() ?: 0
                                    val value19 = viewtext19.text.toString().toIntOrNull() ?: 0
                                    val value20 = viewtext20.text.toString().toIntOrNull() ?: 0
                                    val value21 = viewtext21.text.toString().toIntOrNull() ?: 0
                                    val value22 = viewtext22.text.toString().toIntOrNull() ?: 0
                                    val value23 = viewtext23.text.toString().toIntOrNull() ?: 0
                                    val value24 = viewtext24.text.toString().toIntOrNull() ?: 0
                                    val value25 = viewtext25.text.toString().toIntOrNull() ?: 0
                                    val value26 = viewtext26.text.toString().toIntOrNull() ?: 0
                                    val value27 = viewtext27.text.toString().toIntOrNull() ?: 0
                                    val value28 = viewtext28.text.toString().toIntOrNull() ?: 0
                                    val value29 = viewtext29.text.toString().toIntOrNull() ?: 0
                                    val value30 = viewtext30.text.toString().toIntOrNull() ?: 0
                                    val value31 = viewtext31.text.toString().toIntOrNull() ?: 0
                                    val value32 = viewtext32.text.toString().toIntOrNull() ?: 0
                                    val value33 = viewtext33.text.toString().toIntOrNull() ?: 0
                                    val value34 = viewtext34.text.toString().toIntOrNull() ?: 0
                                    val value35 = viewtext35.text.toString().toIntOrNull() ?: 0
                                    val value36 = viewtext36.text.toString().toIntOrNull() ?: 0
                                    val value37 = viewtext37.text.toString().toIntOrNull() ?: 0
                                    val value38 = viewtext38.text.toString().toIntOrNull() ?: 0
                                    val value39 = viewtext39.text.toString().toIntOrNull() ?: 0
                                    val value40 = viewtext40.text.toString().toIntOrNull() ?: 0
                                    val value41 = viewtext41.text.toString().toIntOrNull() ?: 0
                                    val value42 = viewtext42.text.toString().toIntOrNull() ?: 0
                                    val value43 = viewtext43.text.toString().toIntOrNull() ?: 0
                                    val value44 = viewtext44.text.toString().toIntOrNull() ?: 0
                                    val value45 = viewtext45.text.toString().toIntOrNull() ?: 0
                                    val value46 = viewtext46.text.toString().toIntOrNull() ?: 0
                                    val value47 = viewtext47.text.toString().toIntOrNull() ?: 0
                                    val value48 = viewtext48.text.toString().toIntOrNull() ?: 0
                                    val value49 = viewtext49.text.toString().toIntOrNull() ?: 0
                                    val value50 = viewtext50.text.toString().toIntOrNull() ?: 0
                                    val value51 = viewtext51.text.toString().toIntOrNull() ?: 0
                                    val value52 = viewtext52.text.toString().toIntOrNull() ?: 0
                                    val value53 = viewtext53.text.toString().toIntOrNull() ?: 0
                                    val value54 = viewtext54.text.toString().toIntOrNull() ?: 0
                                    val value55 = viewtext55.text.toString().toIntOrNull() ?: 0
                                    val value56 = viewtext56.text.toString().toIntOrNull() ?: 0
                                    val value57 = viewtext57.text.toString().toIntOrNull() ?: 0
                                    val value58 = viewtext58.text.toString().toIntOrNull() ?: 0
                                    val value59 = viewtext59.text.toString().toIntOrNull() ?: 0

                                    sum = (value1 + value2 + value3 + value4  + value5 +
                                            value6 + value7  + value8  + value9 + value10 + value11 +
                                            value12 + value13 + value14 + value15  + value16  + value17 +
                                            value18 + value19  + value20  + value21 + value22 + value23 +
                                            value24 + value25 + value26 + value27  + value28  + value29 +
                                            value30 + value31  + value32  + value33 + value34 + value35 +
                                            value36 + value37 + value38 + value39  + value40  + value41 +
                                            value42 + value43  + value44  + value45 + value46 + value47 +
                                            value48 + value49 + value50 + value51  + value52  + value53 +
                                            value54 + value55  + value56  + value57 + value58 + value59).toString()

                                    totalall_E_D.text = (sum)
                                }

                                override fun afterTextChanged(s: Editable?) {
                                }
                            })
                        }
                    }

                    if (item.checkData.check14.isNotEmpty()){
                        customDialogFB.apply {
                            checkBoxauto14.setText(item.checkData.check14)
                            checkBoxauto14.setTextColor(Color.parseColor("#000000"))
                            checkBoxauto14.layoutParams = LinearLayout.LayoutParams(
                                ViewGroup.LayoutParams.WRAP_CONTENT,
                                ViewGroup.LayoutParams.WRAP_CONTENT, Float.MIN_VALUE)
                            viewtext14.setText(item.checkData.price14)
                            viewtext14.setTextColor(Color.parseColor("#000000"))
                            p14.addView(viewtext14)
                            L_c14.addView(checkBoxauto14)
                            viewtext14.setSelectAllOnFocus(true)
                            checkBoxauto14.setSelectAllOnFocus(true)
                            checkBoxauto14.textSize = 14f
                            checkBoxauto14.setTypeface(null, Typeface.BOLD)
                            checkBoxauto14.isSingleLine = true
                            viewtext14.isSingleLine = true
                            viewtext14.textSize = 14f
                            viewtext14.inputType = InputType.TYPE_CLASS_PHONE

                            viewtext14.addTextChangedListener(object : TextWatcher {
                                override fun beforeTextChanged(
                                    s: CharSequence?,
                                    start: Int,
                                    count: Int,
                                    after: Int
                                ) {
                                }

                                override fun onTextChanged(
                                    s: CharSequence?,
                                    start: Int,
                                    before: Int,
                                    count: Int
                                ) {
                                    val value1 = viewtext1.text.toString().toIntOrNull() ?: 0
                                    val value2 = viewtext2.text.toString().toIntOrNull() ?: 0
                                    val value3 = viewtext3.text.toString().toIntOrNull() ?: 0
                                    val value4 = viewtext4.text.toString().toIntOrNull() ?: 0
                                    val value5 = viewtext5.text.toString().toIntOrNull() ?: 0
                                    val value6 = viewtext6.text.toString().toIntOrNull() ?: 0
                                    val value7 = viewtext7.text.toString().toIntOrNull() ?: 0
                                    val value8 = viewtext8.text.toString().toIntOrNull() ?: 0
                                    val value9 = viewtext9.text.toString().toIntOrNull() ?: 0
                                    val value10 = viewtext10.text.toString().toIntOrNull() ?: 0
                                    val value11 = viewtext11.text.toString().toIntOrNull() ?: 0
                                    val value12 = viewtext12.text.toString().toIntOrNull() ?: 0
                                    val value13 = viewtext13.text.toString().toIntOrNull() ?: 0
                                    val value14 = viewtext14.text.toString().toIntOrNull() ?: 0
                                    val value15 = viewtext15.text.toString().toIntOrNull() ?: 0
                                    val value16 = viewtext16.text.toString().toIntOrNull() ?: 0
                                    val value17 = viewtext17.text.toString().toIntOrNull() ?: 0
                                    val value18 = viewtext18.text.toString().toIntOrNull() ?: 0
                                    val value19 = viewtext19.text.toString().toIntOrNull() ?: 0
                                    val value20 = viewtext20.text.toString().toIntOrNull() ?: 0
                                    val value21 = viewtext21.text.toString().toIntOrNull() ?: 0
                                    val value22 = viewtext22.text.toString().toIntOrNull() ?: 0
                                    val value23 = viewtext23.text.toString().toIntOrNull() ?: 0
                                    val value24 = viewtext24.text.toString().toIntOrNull() ?: 0
                                    val value25 = viewtext25.text.toString().toIntOrNull() ?: 0
                                    val value26 = viewtext26.text.toString().toIntOrNull() ?: 0
                                    val value27 = viewtext27.text.toString().toIntOrNull() ?: 0
                                    val value28 = viewtext28.text.toString().toIntOrNull() ?: 0
                                    val value29 = viewtext29.text.toString().toIntOrNull() ?: 0
                                    val value30 = viewtext30.text.toString().toIntOrNull() ?: 0
                                    val value31 = viewtext31.text.toString().toIntOrNull() ?: 0
                                    val value32 = viewtext32.text.toString().toIntOrNull() ?: 0
                                    val value33 = viewtext33.text.toString().toIntOrNull() ?: 0
                                    val value34 = viewtext34.text.toString().toIntOrNull() ?: 0
                                    val value35 = viewtext35.text.toString().toIntOrNull() ?: 0
                                    val value36 = viewtext36.text.toString().toIntOrNull() ?: 0
                                    val value37 = viewtext37.text.toString().toIntOrNull() ?: 0
                                    val value38 = viewtext38.text.toString().toIntOrNull() ?: 0
                                    val value39 = viewtext39.text.toString().toIntOrNull() ?: 0
                                    val value40 = viewtext40.text.toString().toIntOrNull() ?: 0
                                    val value41 = viewtext41.text.toString().toIntOrNull() ?: 0
                                    val value42 = viewtext42.text.toString().toIntOrNull() ?: 0
                                    val value43 = viewtext43.text.toString().toIntOrNull() ?: 0
                                    val value44 = viewtext44.text.toString().toIntOrNull() ?: 0
                                    val value45 = viewtext45.text.toString().toIntOrNull() ?: 0
                                    val value46 = viewtext46.text.toString().toIntOrNull() ?: 0
                                    val value47 = viewtext47.text.toString().toIntOrNull() ?: 0
                                    val value48 = viewtext48.text.toString().toIntOrNull() ?: 0
                                    val value49 = viewtext49.text.toString().toIntOrNull() ?: 0
                                    val value50 = viewtext50.text.toString().toIntOrNull() ?: 0
                                    val value51 = viewtext51.text.toString().toIntOrNull() ?: 0
                                    val value52 = viewtext52.text.toString().toIntOrNull() ?: 0
                                    val value53 = viewtext53.text.toString().toIntOrNull() ?: 0
                                    val value54 = viewtext54.text.toString().toIntOrNull() ?: 0
                                    val value55 = viewtext55.text.toString().toIntOrNull() ?: 0
                                    val value56 = viewtext56.text.toString().toIntOrNull() ?: 0
                                    val value57 = viewtext57.text.toString().toIntOrNull() ?: 0
                                    val value58 = viewtext58.text.toString().toIntOrNull() ?: 0
                                    val value59 = viewtext59.text.toString().toIntOrNull() ?: 0

                                    sum = (value1 + value2 + value3 + value4  + value5 +
                                            value6 + value7  + value8  + value9 + value10 + value11 +
                                            value12 + value13 + value14 + value15  + value16  + value17 +
                                            value18 + value19  + value20  + value21 + value22 + value23 +
                                            value24 + value25 + value26 + value27  + value28  + value29 +
                                            value30 + value31  + value32  + value33 + value34 + value35 +
                                            value36 + value37 + value38 + value39  + value40  + value41 +
                                            value42 + value43  + value44  + value45 + value46 + value47 +
                                            value48 + value49 + value50 + value51  + value52  + value53 +
                                            value54 + value55  + value56  + value57 + value58 + value59).toString()

                                    totalall_E_D.text = (sum)
                                }

                                override fun afterTextChanged(s: Editable?) {
                                }
                            })
                        }
                    }

                    if (item.checkData.check15.isNotEmpty()){
                        customDialogFB.apply {
                            checkBoxauto15.setText(item.checkData.check15)
                            checkBoxauto15.setTextColor(Color.parseColor("#000000"))
                            checkBoxauto15.layoutParams = LinearLayout.LayoutParams(
                                ViewGroup.LayoutParams.WRAP_CONTENT,
                                ViewGroup.LayoutParams.WRAP_CONTENT, Float.MIN_VALUE)
                            viewtext15.setText(item.checkData.price15)
                            viewtext15.setTextColor(Color.parseColor("#000000"))
                            p15.addView(viewtext15)
                            L_c15.addView(checkBoxauto15)
                            viewtext15.setSelectAllOnFocus(true)
                            checkBoxauto15.setSelectAllOnFocus(true)
                            checkBoxauto15.textSize = 14f
                            checkBoxauto15.setTypeface(null, Typeface.BOLD)
                            checkBoxauto15.isSingleLine = true
                            viewtext15.isSingleLine = true
                            viewtext15.textSize = 14f
                            viewtext15.inputType = InputType.TYPE_CLASS_PHONE

                            viewtext15.addTextChangedListener(object : TextWatcher {
                                override fun beforeTextChanged(
                                    s: CharSequence?,
                                    start: Int,
                                    count: Int,
                                    after: Int
                                ) {
                                }

                                override fun onTextChanged(
                                    s: CharSequence?,
                                    start: Int,
                                    before: Int,
                                    count: Int
                                ) {
                                    val value1 = viewtext1.text.toString().toIntOrNull() ?: 0
                                    val value2 = viewtext2.text.toString().toIntOrNull() ?: 0
                                    val value3 = viewtext3.text.toString().toIntOrNull() ?: 0
                                    val value4 = viewtext4.text.toString().toIntOrNull() ?: 0
                                    val value5 = viewtext5.text.toString().toIntOrNull() ?: 0
                                    val value6 = viewtext6.text.toString().toIntOrNull() ?: 0
                                    val value7 = viewtext7.text.toString().toIntOrNull() ?: 0
                                    val value8 = viewtext8.text.toString().toIntOrNull() ?: 0
                                    val value9 = viewtext9.text.toString().toIntOrNull() ?: 0
                                    val value10 = viewtext10.text.toString().toIntOrNull() ?: 0
                                    val value11 = viewtext11.text.toString().toIntOrNull() ?: 0
                                    val value12 = viewtext12.text.toString().toIntOrNull() ?: 0
                                    val value13 = viewtext13.text.toString().toIntOrNull() ?: 0
                                    val value14 = viewtext14.text.toString().toIntOrNull() ?: 0
                                    val value15 = viewtext15.text.toString().toIntOrNull() ?: 0
                                    val value16 = viewtext16.text.toString().toIntOrNull() ?: 0
                                    val value17 = viewtext17.text.toString().toIntOrNull() ?: 0
                                    val value18 = viewtext18.text.toString().toIntOrNull() ?: 0
                                    val value19 = viewtext19.text.toString().toIntOrNull() ?: 0
                                    val value20 = viewtext20.text.toString().toIntOrNull() ?: 0
                                    val value21 = viewtext21.text.toString().toIntOrNull() ?: 0
                                    val value22 = viewtext22.text.toString().toIntOrNull() ?: 0
                                    val value23 = viewtext23.text.toString().toIntOrNull() ?: 0
                                    val value24 = viewtext24.text.toString().toIntOrNull() ?: 0
                                    val value25 = viewtext25.text.toString().toIntOrNull() ?: 0
                                    val value26 = viewtext26.text.toString().toIntOrNull() ?: 0
                                    val value27 = viewtext27.text.toString().toIntOrNull() ?: 0
                                    val value28 = viewtext28.text.toString().toIntOrNull() ?: 0
                                    val value29 = viewtext29.text.toString().toIntOrNull() ?: 0
                                    val value30 = viewtext30.text.toString().toIntOrNull() ?: 0
                                    val value31 = viewtext31.text.toString().toIntOrNull() ?: 0
                                    val value32 = viewtext32.text.toString().toIntOrNull() ?: 0
                                    val value33 = viewtext33.text.toString().toIntOrNull() ?: 0
                                    val value34 = viewtext34.text.toString().toIntOrNull() ?: 0
                                    val value35 = viewtext35.text.toString().toIntOrNull() ?: 0
                                    val value36 = viewtext36.text.toString().toIntOrNull() ?: 0
                                    val value37 = viewtext37.text.toString().toIntOrNull() ?: 0
                                    val value38 = viewtext38.text.toString().toIntOrNull() ?: 0
                                    val value39 = viewtext39.text.toString().toIntOrNull() ?: 0
                                    val value40 = viewtext40.text.toString().toIntOrNull() ?: 0
                                    val value41 = viewtext41.text.toString().toIntOrNull() ?: 0
                                    val value42 = viewtext42.text.toString().toIntOrNull() ?: 0
                                    val value43 = viewtext43.text.toString().toIntOrNull() ?: 0
                                    val value44 = viewtext44.text.toString().toIntOrNull() ?: 0
                                    val value45 = viewtext45.text.toString().toIntOrNull() ?: 0
                                    val value46 = viewtext46.text.toString().toIntOrNull() ?: 0
                                    val value47 = viewtext47.text.toString().toIntOrNull() ?: 0
                                    val value48 = viewtext48.text.toString().toIntOrNull() ?: 0
                                    val value49 = viewtext49.text.toString().toIntOrNull() ?: 0
                                    val value50 = viewtext50.text.toString().toIntOrNull() ?: 0
                                    val value51 = viewtext51.text.toString().toIntOrNull() ?: 0
                                    val value52 = viewtext52.text.toString().toIntOrNull() ?: 0
                                    val value53 = viewtext53.text.toString().toIntOrNull() ?: 0
                                    val value54 = viewtext54.text.toString().toIntOrNull() ?: 0
                                    val value55 = viewtext55.text.toString().toIntOrNull() ?: 0
                                    val value56 = viewtext56.text.toString().toIntOrNull() ?: 0
                                    val value57 = viewtext57.text.toString().toIntOrNull() ?: 0
                                    val value58 = viewtext58.text.toString().toIntOrNull() ?: 0
                                    val value59 = viewtext59.text.toString().toIntOrNull() ?: 0

                                    sum = (value1 + value2 + value3 + value4  + value5 +
                                            value6 + value7  + value8  + value9 + value10 + value11 +
                                            value12 + value13 + value14 + value15  + value16  + value17 +
                                            value18 + value19  + value20  + value21 + value22 + value23 +
                                            value24 + value25 + value26 + value27  + value28  + value29 +
                                            value30 + value31  + value32  + value33 + value34 + value35 +
                                            value36 + value37 + value38 + value39  + value40  + value41 +
                                            value42 + value43  + value44  + value45 + value46 + value47 +
                                            value48 + value49 + value50 + value51  + value52  + value53 +
                                            value54 + value55  + value56  + value57 + value58 + value59).toString()

                                    totalall_E_D.text = (sum)
                                }

                                override fun afterTextChanged(s: Editable?) {
                                }
                            })
                        }
                    }

                    if (item.checkData.check16.isNotEmpty()){
                        customDialogFB.apply { checkBoxauto16.setText(item.checkData.check16)
                            checkBoxauto16.setTextColor(Color.parseColor("#000000"))
                            checkBoxauto16.layoutParams = LinearLayout.LayoutParams(
                                ViewGroup.LayoutParams.WRAP_CONTENT,
                                ViewGroup.LayoutParams.WRAP_CONTENT, Float.MIN_VALUE)
                            viewtext16.setText(item.checkData.price16)
                            viewtext16.setTextColor(Color.parseColor("#000000"))
                            p16.addView(viewtext16)
                            L_c16.addView(checkBoxauto16)
                            viewtext16.setSelectAllOnFocus(true)
                            checkBoxauto16.setSelectAllOnFocus(true)
                            checkBoxauto16.textSize = 14f
                            checkBoxauto16.setTypeface(null, Typeface.BOLD)
                            checkBoxauto16.isSingleLine = true
                            viewtext16.isSingleLine = true
                            viewtext16.textSize = 14f
                            viewtext16.inputType = InputType.TYPE_CLASS_PHONE

                            viewtext16.addTextChangedListener(object : TextWatcher {
                                override fun beforeTextChanged(
                                    s: CharSequence?,
                                    start: Int,
                                    count: Int,
                                    after: Int
                                ) {
                                }

                                override fun onTextChanged(
                                    s: CharSequence?,
                                    start: Int,
                                    before: Int,
                                    count: Int
                                ) {
                                    val value1 = viewtext1.text.toString().toIntOrNull() ?: 0
                                    val value2 = viewtext2.text.toString().toIntOrNull() ?: 0
                                    val value3 = viewtext3.text.toString().toIntOrNull() ?: 0
                                    val value4 = viewtext4.text.toString().toIntOrNull() ?: 0
                                    val value5 = viewtext5.text.toString().toIntOrNull() ?: 0
                                    val value6 = viewtext6.text.toString().toIntOrNull() ?: 0
                                    val value7 = viewtext7.text.toString().toIntOrNull() ?: 0
                                    val value8 = viewtext8.text.toString().toIntOrNull() ?: 0
                                    val value9 = viewtext9.text.toString().toIntOrNull() ?: 0
                                    val value10 = viewtext10.text.toString().toIntOrNull() ?: 0
                                    val value11 = viewtext11.text.toString().toIntOrNull() ?: 0
                                    val value12 = viewtext12.text.toString().toIntOrNull() ?: 0
                                    val value13 = viewtext13.text.toString().toIntOrNull() ?: 0
                                    val value14 = viewtext14.text.toString().toIntOrNull() ?: 0
                                    val value15 = viewtext15.text.toString().toIntOrNull() ?: 0
                                    val value16 = viewtext16.text.toString().toIntOrNull() ?: 0
                                    val value17 = viewtext17.text.toString().toIntOrNull() ?: 0
                                    val value18 = viewtext18.text.toString().toIntOrNull() ?: 0
                                    val value19 = viewtext19.text.toString().toIntOrNull() ?: 0
                                    val value20 = viewtext20.text.toString().toIntOrNull() ?: 0
                                    val value21 = viewtext21.text.toString().toIntOrNull() ?: 0
                                    val value22 = viewtext22.text.toString().toIntOrNull() ?: 0
                                    val value23 = viewtext23.text.toString().toIntOrNull() ?: 0
                                    val value24 = viewtext24.text.toString().toIntOrNull() ?: 0
                                    val value25 = viewtext25.text.toString().toIntOrNull() ?: 0
                                    val value26 = viewtext26.text.toString().toIntOrNull() ?: 0
                                    val value27 = viewtext27.text.toString().toIntOrNull() ?: 0
                                    val value28 = viewtext28.text.toString().toIntOrNull() ?: 0
                                    val value29 = viewtext29.text.toString().toIntOrNull() ?: 0
                                    val value30 = viewtext30.text.toString().toIntOrNull() ?: 0
                                    val value31 = viewtext31.text.toString().toIntOrNull() ?: 0
                                    val value32 = viewtext32.text.toString().toIntOrNull() ?: 0
                                    val value33 = viewtext33.text.toString().toIntOrNull() ?: 0
                                    val value34 = viewtext34.text.toString().toIntOrNull() ?: 0
                                    val value35 = viewtext35.text.toString().toIntOrNull() ?: 0
                                    val value36 = viewtext36.text.toString().toIntOrNull() ?: 0
                                    val value37 = viewtext37.text.toString().toIntOrNull() ?: 0
                                    val value38 = viewtext38.text.toString().toIntOrNull() ?: 0
                                    val value39 = viewtext39.text.toString().toIntOrNull() ?: 0
                                    val value40 = viewtext40.text.toString().toIntOrNull() ?: 0
                                    val value41 = viewtext41.text.toString().toIntOrNull() ?: 0
                                    val value42 = viewtext42.text.toString().toIntOrNull() ?: 0
                                    val value43 = viewtext43.text.toString().toIntOrNull() ?: 0
                                    val value44 = viewtext44.text.toString().toIntOrNull() ?: 0
                                    val value45 = viewtext45.text.toString().toIntOrNull() ?: 0
                                    val value46 = viewtext46.text.toString().toIntOrNull() ?: 0
                                    val value47 = viewtext47.text.toString().toIntOrNull() ?: 0
                                    val value48 = viewtext48.text.toString().toIntOrNull() ?: 0
                                    val value49 = viewtext49.text.toString().toIntOrNull() ?: 0
                                    val value50 = viewtext50.text.toString().toIntOrNull() ?: 0
                                    val value51 = viewtext51.text.toString().toIntOrNull() ?: 0
                                    val value52 = viewtext52.text.toString().toIntOrNull() ?: 0
                                    val value53 = viewtext53.text.toString().toIntOrNull() ?: 0
                                    val value54 = viewtext54.text.toString().toIntOrNull() ?: 0
                                    val value55 = viewtext55.text.toString().toIntOrNull() ?: 0
                                    val value56 = viewtext56.text.toString().toIntOrNull() ?: 0
                                    val value57 = viewtext57.text.toString().toIntOrNull() ?: 0
                                    val value58 = viewtext58.text.toString().toIntOrNull() ?: 0
                                    val value59 = viewtext59.text.toString().toIntOrNull() ?: 0

                                    sum = (value1 + value2 + value3 + value4  + value5 +
                                            value6 + value7  + value8  + value9 + value10 + value11 +
                                            value12 + value13 + value14 + value15  + value16  + value17 +
                                            value18 + value19  + value20  + value21 + value22 + value23 +
                                            value24 + value25 + value26 + value27  + value28  + value29 +
                                            value30 + value31  + value32  + value33 + value34 + value35 +
                                            value36 + value37 + value38 + value39  + value40  + value41 +
                                            value42 + value43  + value44  + value45 + value46 + value47 +
                                            value48 + value49 + value50 + value51  + value52  + value53 +
                                            value54 + value55  + value56  + value57 + value58 + value59).toString()

                                    totalall_E_D.text = (sum)
                                }

                                override fun afterTextChanged(s: Editable?) {
                                }
                            })
                        }
                    }

                    if (item.checkData.check17.isNotEmpty()){
                        customDialogFB.apply {
                            checkBoxauto17.setText(item.checkData.check17)
                            checkBoxauto17.setTextColor(Color.parseColor("#000000"))
                            checkBoxauto17.layoutParams = LinearLayout.LayoutParams(
                                ViewGroup.LayoutParams.WRAP_CONTENT,
                                ViewGroup.LayoutParams.WRAP_CONTENT, Float.MIN_VALUE)
                            viewtext17.setText(item.checkData.price17)
                            viewtext17.setTextColor(Color.parseColor("#000000"))
                            p17.addView(viewtext17)
                            L_c17.addView(checkBoxauto17)
                            viewtext17.setSelectAllOnFocus(true)
                            checkBoxauto17.setSelectAllOnFocus(true)
                            checkBoxauto17.textSize = 14f
                            checkBoxauto17.setTypeface(null, Typeface.BOLD)
                            checkBoxauto17.isSingleLine = true
                            viewtext17.isSingleLine = true
                            viewtext17.textSize = 14f
                            viewtext17.inputType = InputType.TYPE_CLASS_PHONE

                            viewtext17.addTextChangedListener(object : TextWatcher {
                                override fun beforeTextChanged(
                                    s: CharSequence?,
                                    start: Int,
                                    count: Int,
                                    after: Int
                                ) {
                                }

                                override fun onTextChanged(
                                    s: CharSequence?,
                                    start: Int,
                                    before: Int,
                                    count: Int
                                ) {

                                    val value1 = viewtext1.text.toString().toIntOrNull() ?: 0
                                    val value2 = viewtext2.text.toString().toIntOrNull() ?: 0
                                    val value3 = viewtext3.text.toString().toIntOrNull() ?: 0
                                    val value4 = viewtext4.text.toString().toIntOrNull() ?: 0
                                    val value5 = viewtext5.text.toString().toIntOrNull() ?: 0
                                    val value6 = viewtext6.text.toString().toIntOrNull() ?: 0
                                    val value7 = viewtext7.text.toString().toIntOrNull() ?: 0
                                    val value8 = viewtext8.text.toString().toIntOrNull() ?: 0
                                    val value9 = viewtext9.text.toString().toIntOrNull() ?: 0
                                    val value10 = viewtext10.text.toString().toIntOrNull() ?: 0
                                    val value11 = viewtext11.text.toString().toIntOrNull() ?: 0
                                    val value12 = viewtext12.text.toString().toIntOrNull() ?: 0
                                    val value13 = viewtext13.text.toString().toIntOrNull() ?: 0
                                    val value14 = viewtext14.text.toString().toIntOrNull() ?: 0
                                    val value15 = viewtext15.text.toString().toIntOrNull() ?: 0
                                    val value16 = viewtext16.text.toString().toIntOrNull() ?: 0
                                    val value17 = viewtext17.text.toString().toIntOrNull() ?: 0
                                    val value18 = viewtext18.text.toString().toIntOrNull() ?: 0
                                    val value19 = viewtext19.text.toString().toIntOrNull() ?: 0
                                    val value20 = viewtext20.text.toString().toIntOrNull() ?: 0
                                    val value21 = viewtext21.text.toString().toIntOrNull() ?: 0
                                    val value22 = viewtext22.text.toString().toIntOrNull() ?: 0
                                    val value23 = viewtext23.text.toString().toIntOrNull() ?: 0
                                    val value24 = viewtext24.text.toString().toIntOrNull() ?: 0
                                    val value25 = viewtext25.text.toString().toIntOrNull() ?: 0
                                    val value26 = viewtext26.text.toString().toIntOrNull() ?: 0
                                    val value27 = viewtext27.text.toString().toIntOrNull() ?: 0
                                    val value28 = viewtext28.text.toString().toIntOrNull() ?: 0
                                    val value29 = viewtext29.text.toString().toIntOrNull() ?: 0
                                    val value30 = viewtext30.text.toString().toIntOrNull() ?: 0
                                    val value31 = viewtext31.text.toString().toIntOrNull() ?: 0
                                    val value32 = viewtext32.text.toString().toIntOrNull() ?: 0
                                    val value33 = viewtext33.text.toString().toIntOrNull() ?: 0
                                    val value34 = viewtext34.text.toString().toIntOrNull() ?: 0
                                    val value35 = viewtext35.text.toString().toIntOrNull() ?: 0
                                    val value36 = viewtext36.text.toString().toIntOrNull() ?: 0
                                    val value37 = viewtext37.text.toString().toIntOrNull() ?: 0
                                    val value38 = viewtext38.text.toString().toIntOrNull() ?: 0
                                    val value39 = viewtext39.text.toString().toIntOrNull() ?: 0
                                    val value40 = viewtext40.text.toString().toIntOrNull() ?: 0
                                    val value41 = viewtext41.text.toString().toIntOrNull() ?: 0
                                    val value42 = viewtext42.text.toString().toIntOrNull() ?: 0
                                    val value43 = viewtext43.text.toString().toIntOrNull() ?: 0
                                    val value44 = viewtext44.text.toString().toIntOrNull() ?: 0
                                    val value45 = viewtext45.text.toString().toIntOrNull() ?: 0
                                    val value46 = viewtext46.text.toString().toIntOrNull() ?: 0
                                    val value47 = viewtext47.text.toString().toIntOrNull() ?: 0
                                    val value48 = viewtext48.text.toString().toIntOrNull() ?: 0
                                    val value49 = viewtext49.text.toString().toIntOrNull() ?: 0
                                    val value50 = viewtext50.text.toString().toIntOrNull() ?: 0
                                    val value51 = viewtext51.text.toString().toIntOrNull() ?: 0
                                    val value52 = viewtext52.text.toString().toIntOrNull() ?: 0
                                    val value53 = viewtext53.text.toString().toIntOrNull() ?: 0
                                    val value54 = viewtext54.text.toString().toIntOrNull() ?: 0
                                    val value55 = viewtext55.text.toString().toIntOrNull() ?: 0
                                    val value56 = viewtext56.text.toString().toIntOrNull() ?: 0
                                    val value57 = viewtext57.text.toString().toIntOrNull() ?: 0
                                    val value58 = viewtext58.text.toString().toIntOrNull() ?: 0
                                    val value59 = viewtext59.text.toString().toIntOrNull() ?: 0

                                    sum = (value1 + value2 + value3 + value4  + value5 +
                                            value6 + value7  + value8  + value9 + value10 + value11 +
                                            value12 + value13 + value14 + value15  + value16  + value17 +
                                            value18 + value19  + value20  + value21 + value22 + value23 +
                                            value24 + value25 + value26 + value27  + value28  + value29 +
                                            value30 + value31  + value32  + value33 + value34 + value35 +
                                            value36 + value37 + value38 + value39  + value40  + value41 +
                                            value42 + value43  + value44  + value45 + value46 + value47 +
                                            value48 + value49 + value50 + value51  + value52  + value53 +
                                            value54 + value55  + value56  + value57 + value58 + value59).toString()

                                    totalall_E_D.text = (sum)
                                }

                                override fun afterTextChanged(s: Editable?) {
                                }
                            })
                        }
                    }

                    if (item.checkData.check18.isNotEmpty()){
                        customDialogFB.apply {
                            checkBoxauto18.setText(item.checkData.check18)
                            checkBoxauto18.setTextColor(Color.parseColor("#000000"))
                            checkBoxauto18.layoutParams = LinearLayout.LayoutParams(
                                ViewGroup.LayoutParams.WRAP_CONTENT,
                                ViewGroup.LayoutParams.WRAP_CONTENT, Float.MIN_VALUE)
                            viewtext18.setText(item.checkData.price18)
                            viewtext18.setTextColor(Color.parseColor("#000000"))
                            p18.addView(viewtext18)
                            L_c18.addView(checkBoxauto18)
                            viewtext18.setSelectAllOnFocus(true)
                            checkBoxauto18.setSelectAllOnFocus(true)
                            checkBoxauto18.textSize = 14f
                            checkBoxauto18.setTypeface(null, Typeface.BOLD)
                            checkBoxauto18.isSingleLine = true
                            viewtext18.isSingleLine = true
                            viewtext18.textSize = 14f
                            viewtext18.inputType = InputType.TYPE_CLASS_PHONE

                            viewtext18.addTextChangedListener(object : TextWatcher {
                                override fun beforeTextChanged(
                                    s: CharSequence?,
                                    start: Int,
                                    count: Int,
                                    after: Int
                                ) {
                                }

                                override fun onTextChanged(
                                    s: CharSequence?,
                                    start: Int,
                                    before: Int,
                                    count: Int
                                ) {
                                    val value1 = viewtext1.text.toString().toIntOrNull() ?: 0
                                    val value2 = viewtext2.text.toString().toIntOrNull() ?: 0
                                    val value3 = viewtext3.text.toString().toIntOrNull() ?: 0
                                    val value4 = viewtext4.text.toString().toIntOrNull() ?: 0
                                    val value5 = viewtext5.text.toString().toIntOrNull() ?: 0
                                    val value6 = viewtext6.text.toString().toIntOrNull() ?: 0
                                    val value7 = viewtext7.text.toString().toIntOrNull() ?: 0
                                    val value8 = viewtext8.text.toString().toIntOrNull() ?: 0
                                    val value9 = viewtext9.text.toString().toIntOrNull() ?: 0
                                    val value10 = viewtext10.text.toString().toIntOrNull() ?: 0
                                    val value11 = viewtext11.text.toString().toIntOrNull() ?: 0
                                    val value12 = viewtext12.text.toString().toIntOrNull() ?: 0
                                    val value13 = viewtext13.text.toString().toIntOrNull() ?: 0
                                    val value14 = viewtext14.text.toString().toIntOrNull() ?: 0
                                    val value15 = viewtext15.text.toString().toIntOrNull() ?: 0
                                    val value16 = viewtext16.text.toString().toIntOrNull() ?: 0
                                    val value17 = viewtext17.text.toString().toIntOrNull() ?: 0
                                    val value18 = viewtext18.text.toString().toIntOrNull() ?: 0
                                    val value19 = viewtext19.text.toString().toIntOrNull() ?: 0
                                    val value20 = viewtext20.text.toString().toIntOrNull() ?: 0
                                    val value21 = viewtext21.text.toString().toIntOrNull() ?: 0
                                    val value22 = viewtext22.text.toString().toIntOrNull() ?: 0
                                    val value23 = viewtext23.text.toString().toIntOrNull() ?: 0
                                    val value24 = viewtext24.text.toString().toIntOrNull() ?: 0
                                    val value25 = viewtext25.text.toString().toIntOrNull() ?: 0
                                    val value26 = viewtext26.text.toString().toIntOrNull() ?: 0
                                    val value27 = viewtext27.text.toString().toIntOrNull() ?: 0
                                    val value28 = viewtext28.text.toString().toIntOrNull() ?: 0
                                    val value29 = viewtext29.text.toString().toIntOrNull() ?: 0
                                    val value30 = viewtext30.text.toString().toIntOrNull() ?: 0
                                    val value31 = viewtext31.text.toString().toIntOrNull() ?: 0
                                    val value32 = viewtext32.text.toString().toIntOrNull() ?: 0
                                    val value33 = viewtext33.text.toString().toIntOrNull() ?: 0
                                    val value34 = viewtext34.text.toString().toIntOrNull() ?: 0
                                    val value35 = viewtext35.text.toString().toIntOrNull() ?: 0
                                    val value36 = viewtext36.text.toString().toIntOrNull() ?: 0
                                    val value37 = viewtext37.text.toString().toIntOrNull() ?: 0
                                    val value38 = viewtext38.text.toString().toIntOrNull() ?: 0
                                    val value39 = viewtext39.text.toString().toIntOrNull() ?: 0
                                    val value40 = viewtext40.text.toString().toIntOrNull() ?: 0
                                    val value41 = viewtext41.text.toString().toIntOrNull() ?: 0
                                    val value42 = viewtext42.text.toString().toIntOrNull() ?: 0
                                    val value43 = viewtext43.text.toString().toIntOrNull() ?: 0
                                    val value44 = viewtext44.text.toString().toIntOrNull() ?: 0
                                    val value45 = viewtext45.text.toString().toIntOrNull() ?: 0
                                    val value46 = viewtext46.text.toString().toIntOrNull() ?: 0
                                    val value47 = viewtext47.text.toString().toIntOrNull() ?: 0
                                    val value48 = viewtext48.text.toString().toIntOrNull() ?: 0
                                    val value49 = viewtext49.text.toString().toIntOrNull() ?: 0
                                    val value50 = viewtext50.text.toString().toIntOrNull() ?: 0
                                    val value51 = viewtext51.text.toString().toIntOrNull() ?: 0
                                    val value52 = viewtext52.text.toString().toIntOrNull() ?: 0
                                    val value53 = viewtext53.text.toString().toIntOrNull() ?: 0
                                    val value54 = viewtext54.text.toString().toIntOrNull() ?: 0
                                    val value55 = viewtext55.text.toString().toIntOrNull() ?: 0
                                    val value56 = viewtext56.text.toString().toIntOrNull() ?: 0
                                    val value57 = viewtext57.text.toString().toIntOrNull() ?: 0
                                    val value58 = viewtext58.text.toString().toIntOrNull() ?: 0
                                    val value59 = viewtext59.text.toString().toIntOrNull() ?: 0

                                    sum = (value1 + value2 + value3 + value4  + value5 +
                                            value6 + value7  + value8  + value9 + value10 + value11 +
                                            value12 + value13 + value14 + value15  + value16  + value17 +
                                            value18 + value19  + value20  + value21 + value22 + value23 +
                                            value24 + value25 + value26 + value27  + value28  + value29 +
                                            value30 + value31  + value32  + value33 + value34 + value35 +
                                            value36 + value37 + value38 + value39  + value40  + value41 +
                                            value42 + value43  + value44  + value45 + value46 + value47 +
                                            value48 + value49 + value50 + value51  + value52  + value53 +
                                            value54 + value55  + value56  + value57 + value58 + value59).toString()

                                    totalall_E_D.text = (sum)
                                }

                                override fun afterTextChanged(s: Editable?) {
                                }
                            })
                        }
                    }

                    if (item.checkData.check19.isNotEmpty()){
                        customDialogFB.apply {
                            checkBoxauto19.setText(item.checkData.check19)
                            checkBoxauto19.setTextColor(Color.parseColor("#000000"))
                            checkBoxauto19.layoutParams = LinearLayout.LayoutParams(
                                ViewGroup.LayoutParams.WRAP_CONTENT,
                                ViewGroup.LayoutParams.WRAP_CONTENT, Float.MIN_VALUE)
                            viewtext19.setText(item.checkData.price19)
                            viewtext19.setTextColor(Color.parseColor("#000000"))
                            p19.addView(viewtext19)
                            L_c19.addView(checkBoxauto19)
                            viewtext19.setSelectAllOnFocus(true)
                            checkBoxauto19.setSelectAllOnFocus(true)
                            checkBoxauto19.textSize = 14f
                            checkBoxauto19.setTypeface(null, Typeface.BOLD)
                            checkBoxauto19.isSingleLine = true
                            viewtext19.isSingleLine = true
                            viewtext19.textSize = 14f
                            viewtext19.inputType = InputType.TYPE_CLASS_PHONE

                            viewtext19.addTextChangedListener(object : TextWatcher {
                                override fun beforeTextChanged(
                                    s: CharSequence?,
                                    start: Int,
                                    count: Int,
                                    after: Int
                                ) {
                                }

                                override fun onTextChanged(
                                    s: CharSequence?,
                                    start: Int,
                                    before: Int,
                                    count: Int
                                ) {
                                    val value1 = viewtext1.text.toString().toIntOrNull() ?: 0
                                    val value2 = viewtext2.text.toString().toIntOrNull() ?: 0
                                    val value3 = viewtext3.text.toString().toIntOrNull() ?: 0
                                    val value4 = viewtext4.text.toString().toIntOrNull() ?: 0
                                    val value5 = viewtext5.text.toString().toIntOrNull() ?: 0
                                    val value6 = viewtext6.text.toString().toIntOrNull() ?: 0
                                    val value7 = viewtext7.text.toString().toIntOrNull() ?: 0
                                    val value8 = viewtext8.text.toString().toIntOrNull() ?: 0
                                    val value9 = viewtext9.text.toString().toIntOrNull() ?: 0
                                    val value10 = viewtext10.text.toString().toIntOrNull() ?: 0
                                    val value11 = viewtext11.text.toString().toIntOrNull() ?: 0
                                    val value12 = viewtext12.text.toString().toIntOrNull() ?: 0
                                    val value13 = viewtext13.text.toString().toIntOrNull() ?: 0
                                    val value14 = viewtext14.text.toString().toIntOrNull() ?: 0
                                    val value15 = viewtext15.text.toString().toIntOrNull() ?: 0
                                    val value16 = viewtext16.text.toString().toIntOrNull() ?: 0
                                    val value17 = viewtext17.text.toString().toIntOrNull() ?: 0
                                    val value18 = viewtext18.text.toString().toIntOrNull() ?: 0
                                    val value19 = viewtext19.text.toString().toIntOrNull() ?: 0
                                    val value20 = viewtext20.text.toString().toIntOrNull() ?: 0
                                    val value21 = viewtext21.text.toString().toIntOrNull() ?: 0
                                    val value22 = viewtext22.text.toString().toIntOrNull() ?: 0
                                    val value23 = viewtext23.text.toString().toIntOrNull() ?: 0
                                    val value24 = viewtext24.text.toString().toIntOrNull() ?: 0
                                    val value25 = viewtext25.text.toString().toIntOrNull() ?: 0
                                    val value26 = viewtext26.text.toString().toIntOrNull() ?: 0
                                    val value27 = viewtext27.text.toString().toIntOrNull() ?: 0
                                    val value28 = viewtext28.text.toString().toIntOrNull() ?: 0
                                    val value29 = viewtext29.text.toString().toIntOrNull() ?: 0
                                    val value30 = viewtext30.text.toString().toIntOrNull() ?: 0
                                    val value31 = viewtext31.text.toString().toIntOrNull() ?: 0
                                    val value32 = viewtext32.text.toString().toIntOrNull() ?: 0
                                    val value33 = viewtext33.text.toString().toIntOrNull() ?: 0
                                    val value34 = viewtext34.text.toString().toIntOrNull() ?: 0
                                    val value35 = viewtext35.text.toString().toIntOrNull() ?: 0
                                    val value36 = viewtext36.text.toString().toIntOrNull() ?: 0
                                    val value37 = viewtext37.text.toString().toIntOrNull() ?: 0
                                    val value38 = viewtext38.text.toString().toIntOrNull() ?: 0
                                    val value39 = viewtext39.text.toString().toIntOrNull() ?: 0
                                    val value40 = viewtext40.text.toString().toIntOrNull() ?: 0
                                    val value41 = viewtext41.text.toString().toIntOrNull() ?: 0
                                    val value42 = viewtext42.text.toString().toIntOrNull() ?: 0
                                    val value43 = viewtext43.text.toString().toIntOrNull() ?: 0
                                    val value44 = viewtext44.text.toString().toIntOrNull() ?: 0
                                    val value45 = viewtext45.text.toString().toIntOrNull() ?: 0
                                    val value46 = viewtext46.text.toString().toIntOrNull() ?: 0
                                    val value47 = viewtext47.text.toString().toIntOrNull() ?: 0
                                    val value48 = viewtext48.text.toString().toIntOrNull() ?: 0
                                    val value49 = viewtext49.text.toString().toIntOrNull() ?: 0
                                    val value50 = viewtext50.text.toString().toIntOrNull() ?: 0
                                    val value51 = viewtext51.text.toString().toIntOrNull() ?: 0
                                    val value52 = viewtext52.text.toString().toIntOrNull() ?: 0
                                    val value53 = viewtext53.text.toString().toIntOrNull() ?: 0
                                    val value54 = viewtext54.text.toString().toIntOrNull() ?: 0
                                    val value55 = viewtext55.text.toString().toIntOrNull() ?: 0
                                    val value56 = viewtext56.text.toString().toIntOrNull() ?: 0
                                    val value57 = viewtext57.text.toString().toIntOrNull() ?: 0
                                    val value58 = viewtext58.text.toString().toIntOrNull() ?: 0
                                    val value59 = viewtext59.text.toString().toIntOrNull() ?: 0

                                    sum = (value1 + value2 + value3 + value4  + value5 +
                                            value6 + value7  + value8  + value9 + value10 + value11 +
                                            value12 + value13 + value14 + value15  + value16  + value17 +
                                            value18 + value19  + value20  + value21 + value22 + value23 +
                                            value24 + value25 + value26 + value27  + value28  + value29 +
                                            value30 + value31  + value32  + value33 + value34 + value35 +
                                            value36 + value37 + value38 + value39  + value40  + value41 +
                                            value42 + value43  + value44  + value45 + value46 + value47 +
                                            value48 + value49 + value50 + value51  + value52  + value53 +
                                            value54 + value55  + value56  + value57 + value58 + value59).toString()

                                    totalall_E_D.text = (sum)
                                }

                                override fun afterTextChanged(s: Editable?) {
                                }
                            })
                        }
                    }

                    if (item.checkData.check20.isNotEmpty()){
                        customDialogFB.apply {
                            checkBoxauto20.setText(item.checkData.check20)
                            checkBoxauto20.setTextColor(Color.parseColor("#000000"))
                            checkBoxauto20.layoutParams = LinearLayout.LayoutParams(
                                ViewGroup.LayoutParams.WRAP_CONTENT,
                                ViewGroup.LayoutParams.WRAP_CONTENT, Float.MIN_VALUE)
                            viewtext20.setText(item.checkData.price20)
                            viewtext20.setTextColor(Color.parseColor("#000000"))
                            p20.addView(viewtext20)
                            L_c20.addView(checkBoxauto20)
                            viewtext20.setSelectAllOnFocus(true)
                            checkBoxauto20.setSelectAllOnFocus(true)
                            checkBoxauto20.textSize = 14f
                            checkBoxauto20.setTypeface(null, Typeface.BOLD)
                            checkBoxauto20.isSingleLine = true
                            viewtext20.isSingleLine = true
                            viewtext20.textSize = 14f
                            viewtext20.inputType = InputType.TYPE_CLASS_PHONE

                            viewtext20.addTextChangedListener(object : TextWatcher {
                                override fun beforeTextChanged(
                                    s: CharSequence?,
                                    start: Int,
                                    count: Int,
                                    after: Int
                                ) {
                                }

                                override fun onTextChanged(
                                    s: CharSequence?,
                                    start: Int,
                                    before: Int,
                                    count: Int
                                ) {
                                    val value1 = viewtext1.text.toString().toIntOrNull() ?: 0
                                    val value2 = viewtext2.text.toString().toIntOrNull() ?: 0
                                    val value3 = viewtext3.text.toString().toIntOrNull() ?: 0
                                    val value4 = viewtext4.text.toString().toIntOrNull() ?: 0
                                    val value5 = viewtext5.text.toString().toIntOrNull() ?: 0
                                    val value6 = viewtext6.text.toString().toIntOrNull() ?: 0
                                    val value7 = viewtext7.text.toString().toIntOrNull() ?: 0
                                    val value8 = viewtext8.text.toString().toIntOrNull() ?: 0
                                    val value9 = viewtext9.text.toString().toIntOrNull() ?: 0
                                    val value10 = viewtext10.text.toString().toIntOrNull() ?: 0
                                    val value11 = viewtext11.text.toString().toIntOrNull() ?: 0
                                    val value12 = viewtext12.text.toString().toIntOrNull() ?: 0
                                    val value13 = viewtext13.text.toString().toIntOrNull() ?: 0
                                    val value14 = viewtext14.text.toString().toIntOrNull() ?: 0
                                    val value15 = viewtext15.text.toString().toIntOrNull() ?: 0
                                    val value16 = viewtext16.text.toString().toIntOrNull() ?: 0
                                    val value17 = viewtext17.text.toString().toIntOrNull() ?: 0
                                    val value18 = viewtext18.text.toString().toIntOrNull() ?: 0
                                    val value19 = viewtext19.text.toString().toIntOrNull() ?: 0
                                    val value20 = viewtext20.text.toString().toIntOrNull() ?: 0
                                    val value21 = viewtext21.text.toString().toIntOrNull() ?: 0
                                    val value22 = viewtext22.text.toString().toIntOrNull() ?: 0
                                    val value23 = viewtext23.text.toString().toIntOrNull() ?: 0
                                    val value24 = viewtext24.text.toString().toIntOrNull() ?: 0
                                    val value25 = viewtext25.text.toString().toIntOrNull() ?: 0
                                    val value26 = viewtext26.text.toString().toIntOrNull() ?: 0
                                    val value27 = viewtext27.text.toString().toIntOrNull() ?: 0
                                    val value28 = viewtext28.text.toString().toIntOrNull() ?: 0
                                    val value29 = viewtext29.text.toString().toIntOrNull() ?: 0
                                    val value30 = viewtext30.text.toString().toIntOrNull() ?: 0
                                    val value31 = viewtext31.text.toString().toIntOrNull() ?: 0
                                    val value32 = viewtext32.text.toString().toIntOrNull() ?: 0
                                    val value33 = viewtext33.text.toString().toIntOrNull() ?: 0
                                    val value34 = viewtext34.text.toString().toIntOrNull() ?: 0
                                    val value35 = viewtext35.text.toString().toIntOrNull() ?: 0
                                    val value36 = viewtext36.text.toString().toIntOrNull() ?: 0
                                    val value37 = viewtext37.text.toString().toIntOrNull() ?: 0
                                    val value38 = viewtext38.text.toString().toIntOrNull() ?: 0
                                    val value39 = viewtext39.text.toString().toIntOrNull() ?: 0
                                    val value40 = viewtext40.text.toString().toIntOrNull() ?: 0
                                    val value41 = viewtext41.text.toString().toIntOrNull() ?: 0
                                    val value42 = viewtext42.text.toString().toIntOrNull() ?: 0
                                    val value43 = viewtext43.text.toString().toIntOrNull() ?: 0
                                    val value44 = viewtext44.text.toString().toIntOrNull() ?: 0
                                    val value45 = viewtext45.text.toString().toIntOrNull() ?: 0
                                    val value46 = viewtext46.text.toString().toIntOrNull() ?: 0
                                    val value47 = viewtext47.text.toString().toIntOrNull() ?: 0
                                    val value48 = viewtext48.text.toString().toIntOrNull() ?: 0
                                    val value49 = viewtext49.text.toString().toIntOrNull() ?: 0
                                    val value50 = viewtext50.text.toString().toIntOrNull() ?: 0
                                    val value51 = viewtext51.text.toString().toIntOrNull() ?: 0
                                    val value52 = viewtext52.text.toString().toIntOrNull() ?: 0
                                    val value53 = viewtext53.text.toString().toIntOrNull() ?: 0
                                    val value54 = viewtext54.text.toString().toIntOrNull() ?: 0
                                    val value55 = viewtext55.text.toString().toIntOrNull() ?: 0
                                    val value56 = viewtext56.text.toString().toIntOrNull() ?: 0
                                    val value57 = viewtext57.text.toString().toIntOrNull() ?: 0
                                    val value58 = viewtext58.text.toString().toIntOrNull() ?: 0
                                    val value59 = viewtext59.text.toString().toIntOrNull() ?: 0

                                    sum = (value1 + value2 + value3 + value4  + value5 +
                                            value6 + value7  + value8  + value9 + value10 + value11 +
                                            value12 + value13 + value14 + value15  + value16  + value17 +
                                            value18 + value19  + value20  + value21 + value22 + value23 +
                                            value24 + value25 + value26 + value27  + value28  + value29 +
                                            value30 + value31  + value32  + value33 + value34 + value35 +
                                            value36 + value37 + value38 + value39  + value40  + value41 +
                                            value42 + value43  + value44  + value45 + value46 + value47 +
                                            value48 + value49 + value50 + value51  + value52  + value53 +
                                            value54 + value55  + value56  + value57 + value58 + value59).toString()

                                    totalall_E_D.text = (sum)
                                }

                                override fun afterTextChanged(s: Editable?) {
                                }
                            })
                        }
                    }

                    if (item.checkData.editD1.isNotEmpty()){
                        customDialogFB.apply {
                            checkBoxauto51.setText(item.checkData.editD1)
                            checkBoxauto51.setTextColor(Color.parseColor("#000000"))
                            checkBoxauto51.layoutParams = LinearLayout.LayoutParams(
                                ViewGroup.LayoutParams.WRAP_CONTENT,
                                ViewGroup.LayoutParams.WRAP_CONTENT, Float.MIN_VALUE)
                            viewtext51.setText(item.checkData.pricD1)
                            viewtext51.setTextColor(Color.parseColor("#000000"))
                            p51.addView(viewtext51)
                            L_c51.addView(checkBoxauto51)
                            viewtext51.setSelectAllOnFocus(true)
                            checkBoxauto51.setSelectAllOnFocus(true)
                            checkBoxauto51.textSize = 14f
                            checkBoxauto51.setTypeface(null, Typeface.BOLD)
                            checkBoxauto51.isSingleLine = true
                            viewtext51.isSingleLine = true
                            viewtext51.textSize = 14f
                            viewtext51.inputType = InputType.TYPE_CLASS_PHONE

                            viewtext51.addTextChangedListener(object : TextWatcher {
                                override fun beforeTextChanged(
                                    s: CharSequence?,
                                    start: Int,
                                    count: Int,
                                    after: Int
                                ) {
                                }

                                override fun onTextChanged(
                                    s: CharSequence?,
                                    start: Int,
                                    before: Int,
                                    count: Int
                                ) {
                                    val value1 = viewtext1.text.toString().toIntOrNull() ?: 0
                                    val value2 = viewtext2.text.toString().toIntOrNull() ?: 0
                                    val value3 = viewtext3.text.toString().toIntOrNull() ?: 0
                                    val value4 = viewtext4.text.toString().toIntOrNull() ?: 0
                                    val value5 = viewtext5.text.toString().toIntOrNull() ?: 0
                                    val value6 = viewtext6.text.toString().toIntOrNull() ?: 0
                                    val value7 = viewtext7.text.toString().toIntOrNull() ?: 0
                                    val value8 = viewtext8.text.toString().toIntOrNull() ?: 0
                                    val value9 = viewtext9.text.toString().toIntOrNull() ?: 0
                                    val value10 = viewtext10.text.toString().toIntOrNull() ?: 0
                                    val value11 = viewtext11.text.toString().toIntOrNull() ?: 0
                                    val value12 = viewtext12.text.toString().toIntOrNull() ?: 0
                                    val value13 = viewtext13.text.toString().toIntOrNull() ?: 0
                                    val value14 = viewtext14.text.toString().toIntOrNull() ?: 0
                                    val value15 = viewtext15.text.toString().toIntOrNull() ?: 0
                                    val value16 = viewtext16.text.toString().toIntOrNull() ?: 0
                                    val value17 = viewtext17.text.toString().toIntOrNull() ?: 0
                                    val value18 = viewtext18.text.toString().toIntOrNull() ?: 0
                                    val value19 = viewtext19.text.toString().toIntOrNull() ?: 0
                                    val value20 = viewtext20.text.toString().toIntOrNull() ?: 0
                                    val value21 = viewtext21.text.toString().toIntOrNull() ?: 0
                                    val value22 = viewtext22.text.toString().toIntOrNull() ?: 0
                                    val value23 = viewtext23.text.toString().toIntOrNull() ?: 0
                                    val value24 = viewtext24.text.toString().toIntOrNull() ?: 0
                                    val value25 = viewtext25.text.toString().toIntOrNull() ?: 0
                                    val value26 = viewtext26.text.toString().toIntOrNull() ?: 0
                                    val value27 = viewtext27.text.toString().toIntOrNull() ?: 0
                                    val value28 = viewtext28.text.toString().toIntOrNull() ?: 0
                                    val value29 = viewtext29.text.toString().toIntOrNull() ?: 0
                                    val value30 = viewtext30.text.toString().toIntOrNull() ?: 0
                                    val value31 = viewtext31.text.toString().toIntOrNull() ?: 0
                                    val value32 = viewtext32.text.toString().toIntOrNull() ?: 0
                                    val value33 = viewtext33.text.toString().toIntOrNull() ?: 0
                                    val value34 = viewtext34.text.toString().toIntOrNull() ?: 0
                                    val value35 = viewtext35.text.toString().toIntOrNull() ?: 0
                                    val value36 = viewtext36.text.toString().toIntOrNull() ?: 0
                                    val value37 = viewtext37.text.toString().toIntOrNull() ?: 0
                                    val value38 = viewtext38.text.toString().toIntOrNull() ?: 0
                                    val value39 = viewtext39.text.toString().toIntOrNull() ?: 0
                                    val value40 = viewtext40.text.toString().toIntOrNull() ?: 0
                                    val value41 = viewtext41.text.toString().toIntOrNull() ?: 0
                                    val value42 = viewtext42.text.toString().toIntOrNull() ?: 0
                                    val value43 = viewtext43.text.toString().toIntOrNull() ?: 0
                                    val value44 = viewtext44.text.toString().toIntOrNull() ?: 0
                                    val value45 = viewtext45.text.toString().toIntOrNull() ?: 0
                                    val value46 = viewtext46.text.toString().toIntOrNull() ?: 0
                                    val value47 = viewtext47.text.toString().toIntOrNull() ?: 0
                                    val value48 = viewtext48.text.toString().toIntOrNull() ?: 0
                                    val value49 = viewtext49.text.toString().toIntOrNull() ?: 0
                                    val value50 = viewtext50.text.toString().toIntOrNull() ?: 0
                                    val value51 = viewtext51.text.toString().toIntOrNull() ?: 0
                                    val value52 = viewtext52.text.toString().toIntOrNull() ?: 0
                                    val value53 = viewtext53.text.toString().toIntOrNull() ?: 0
                                    val value54 = viewtext54.text.toString().toIntOrNull() ?: 0
                                    val value55 = viewtext55.text.toString().toIntOrNull() ?: 0
                                    val value56 = viewtext56.text.toString().toIntOrNull() ?: 0
                                    val value57 = viewtext57.text.toString().toIntOrNull() ?: 0
                                    val value58 = viewtext58.text.toString().toIntOrNull() ?: 0
                                    val value59 = viewtext59.text.toString().toIntOrNull() ?: 0

                                    sum = (value1 + value2 + value3 + value4  + value5 +
                                            value6 + value7  + value8  + value9 + value10 + value11 +
                                            value12 + value13 + value14 + value15  + value16  + value17 +
                                            value18 + value19  + value20  + value21 + value22 + value23 +
                                            value24 + value25 + value26 + value27  + value28  + value29 +
                                            value30 + value31  + value32  + value33 + value34 + value35 +
                                            value36 + value37 + value38 + value39  + value40  + value41 +
                                            value42 + value43  + value44  + value45 + value46 + value47 +
                                            value48 + value49 + value50 + value51  + value52  + value53 +
                                            value54 + value55  + value56  + value57 + value58 + value59).toString()

                                    totalall_E_D.text = (sum)
                                }

                                override fun afterTextChanged(s: Editable?) {
                                }
                            })
                        }
                    }

                    if (item.checkData.editD2.isNotEmpty()){
                        customDialogFB.apply { checkBoxauto52.setText(item.checkData.editD2)
                            checkBoxauto52.setTextColor(Color.parseColor("#000000"))
                            checkBoxauto52.layoutParams = LinearLayout.LayoutParams(
                                ViewGroup.LayoutParams.WRAP_CONTENT,
                                ViewGroup.LayoutParams.WRAP_CONTENT, Float.MIN_VALUE)
                            viewtext52.setText(item.checkData.pricD2)
                            viewtext52.setTextColor(Color.parseColor("#000000"))
                            p52.addView(viewtext52)
                            L_c52.addView(checkBoxauto52)
                            viewtext52.setSelectAllOnFocus(true)
                            checkBoxauto52.setSelectAllOnFocus(true)
                            checkBoxauto52.textSize = 14f
                            checkBoxauto52.setTypeface(null, Typeface.BOLD)
                            checkBoxauto52.isSingleLine = true
                            viewtext52.isSingleLine = true
                            viewtext52.textSize = 14f
                            viewtext52.inputType = InputType.TYPE_CLASS_PHONE

                            viewtext52.addTextChangedListener(object : TextWatcher {
                                override fun beforeTextChanged(
                                    s: CharSequence?,
                                    start: Int,
                                    count: Int,
                                    after: Int
                                ) {
                                }

                                override fun onTextChanged(
                                    s: CharSequence?,
                                    start: Int,
                                    before: Int,
                                    count: Int
                                ) {
                                    val value1 = viewtext1.text.toString().toIntOrNull() ?: 0
                                    val value2 = viewtext2.text.toString().toIntOrNull() ?: 0
                                    val value3 = viewtext3.text.toString().toIntOrNull() ?: 0
                                    val value4 = viewtext4.text.toString().toIntOrNull() ?: 0
                                    val value5 = viewtext5.text.toString().toIntOrNull() ?: 0
                                    val value6 = viewtext6.text.toString().toIntOrNull() ?: 0
                                    val value7 = viewtext7.text.toString().toIntOrNull() ?: 0
                                    val value8 = viewtext8.text.toString().toIntOrNull() ?: 0
                                    val value9 = viewtext9.text.toString().toIntOrNull() ?: 0
                                    val value10 = viewtext10.text.toString().toIntOrNull() ?: 0
                                    val value11 = viewtext11.text.toString().toIntOrNull() ?: 0
                                    val value12 = viewtext12.text.toString().toIntOrNull() ?: 0
                                    val value13 = viewtext13.text.toString().toIntOrNull() ?: 0
                                    val value14 = viewtext14.text.toString().toIntOrNull() ?: 0
                                    val value15 = viewtext15.text.toString().toIntOrNull() ?: 0
                                    val value16 = viewtext16.text.toString().toIntOrNull() ?: 0
                                    val value17 = viewtext17.text.toString().toIntOrNull() ?: 0
                                    val value18 = viewtext18.text.toString().toIntOrNull() ?: 0
                                    val value19 = viewtext19.text.toString().toIntOrNull() ?: 0
                                    val value20 = viewtext20.text.toString().toIntOrNull() ?: 0
                                    val value21 = viewtext21.text.toString().toIntOrNull() ?: 0
                                    val value22 = viewtext22.text.toString().toIntOrNull() ?: 0
                                    val value23 = viewtext23.text.toString().toIntOrNull() ?: 0
                                    val value24 = viewtext24.text.toString().toIntOrNull() ?: 0
                                    val value25 = viewtext25.text.toString().toIntOrNull() ?: 0
                                    val value26 = viewtext26.text.toString().toIntOrNull() ?: 0
                                    val value27 = viewtext27.text.toString().toIntOrNull() ?: 0
                                    val value28 = viewtext28.text.toString().toIntOrNull() ?: 0
                                    val value29 = viewtext29.text.toString().toIntOrNull() ?: 0
                                    val value30 = viewtext30.text.toString().toIntOrNull() ?: 0
                                    val value31 = viewtext31.text.toString().toIntOrNull() ?: 0
                                    val value32 = viewtext32.text.toString().toIntOrNull() ?: 0
                                    val value33 = viewtext33.text.toString().toIntOrNull() ?: 0
                                    val value34 = viewtext34.text.toString().toIntOrNull() ?: 0
                                    val value35 = viewtext35.text.toString().toIntOrNull() ?: 0
                                    val value36 = viewtext36.text.toString().toIntOrNull() ?: 0
                                    val value37 = viewtext37.text.toString().toIntOrNull() ?: 0
                                    val value38 = viewtext38.text.toString().toIntOrNull() ?: 0
                                    val value39 = viewtext39.text.toString().toIntOrNull() ?: 0
                                    val value40 = viewtext40.text.toString().toIntOrNull() ?: 0
                                    val value41 = viewtext41.text.toString().toIntOrNull() ?: 0
                                    val value42 = viewtext42.text.toString().toIntOrNull() ?: 0
                                    val value43 = viewtext43.text.toString().toIntOrNull() ?: 0
                                    val value44 = viewtext44.text.toString().toIntOrNull() ?: 0
                                    val value45 = viewtext45.text.toString().toIntOrNull() ?: 0
                                    val value46 = viewtext46.text.toString().toIntOrNull() ?: 0
                                    val value47 = viewtext47.text.toString().toIntOrNull() ?: 0
                                    val value48 = viewtext48.text.toString().toIntOrNull() ?: 0
                                    val value49 = viewtext49.text.toString().toIntOrNull() ?: 0
                                    val value50 = viewtext50.text.toString().toIntOrNull() ?: 0
                                    val value51 = viewtext51.text.toString().toIntOrNull() ?: 0
                                    val value52 = viewtext52.text.toString().toIntOrNull() ?: 0
                                    val value53 = viewtext53.text.toString().toIntOrNull() ?: 0
                                    val value54 = viewtext54.text.toString().toIntOrNull() ?: 0
                                    val value55 = viewtext55.text.toString().toIntOrNull() ?: 0
                                    val value56 = viewtext56.text.toString().toIntOrNull() ?: 0
                                    val value57 = viewtext57.text.toString().toIntOrNull() ?: 0
                                    val value58 = viewtext58.text.toString().toIntOrNull() ?: 0
                                    val value59 = viewtext59.text.toString().toIntOrNull() ?: 0

                                    sum = (value1 + value2 + value3 + value4  + value5 +
                                            value6 + value7  + value8  + value9 + value10 + value11 +
                                            value12 + value13 + value14 + value15  + value16  + value17 +
                                            value18 + value19  + value20  + value21 + value22 + value23 +
                                            value24 + value25 + value26 + value27  + value28  + value29 +
                                            value30 + value31  + value32  + value33 + value34 + value35 +
                                            value36 + value37 + value38 + value39  + value40  + value41 +
                                            value42 + value43  + value44  + value45 + value46 + value47 +
                                            value48 + value49 + value50 + value51  + value52  + value53 +
                                            value54 + value55  + value56  + value57 + value58 + value59).toString()

                                    totalall_E_D.text = (sum)
                                }

                                override fun afterTextChanged(s: Editable?) {
                                }
                            })
                        }
                    }

                    if (item.checkData.editD3.isNotEmpty()){
                        customDialogFB.apply { checkBoxauto53.setText(item.checkData.editD3)
                            checkBoxauto53.setTextColor(Color.parseColor("#000000"))
                            checkBoxauto53.layoutParams = LinearLayout.LayoutParams(
                                ViewGroup.LayoutParams.WRAP_CONTENT,
                                ViewGroup.LayoutParams.WRAP_CONTENT, Float.MIN_VALUE)
                            viewtext53.setText(item.checkData.pricD3)
                            viewtext53.setTextColor(Color.parseColor("#000000"))
                            p53.addView(viewtext53)
                            L_c53.addView(checkBoxauto53)
                            viewtext53.setSelectAllOnFocus(true)
                            checkBoxauto53.setSelectAllOnFocus(true)
                            checkBoxauto53.textSize = 14f
                            checkBoxauto53.setTypeface(null, Typeface.BOLD)
                            checkBoxauto53.isSingleLine = true
                            viewtext53.isSingleLine = true
                            viewtext53.textSize = 14f
                            viewtext53.inputType = InputType.TYPE_CLASS_PHONE

                            viewtext53.addTextChangedListener(object : TextWatcher {
                                override fun beforeTextChanged(
                                    s: CharSequence?,
                                    start: Int,
                                    count: Int,
                                    after: Int
                                ) {
                                }

                                override fun onTextChanged(
                                    s: CharSequence?,
                                    start: Int,
                                    before: Int,
                                    count: Int
                                ) {
                                    val value1 = viewtext1.text.toString().toIntOrNull() ?: 0
                                    val value2 = viewtext2.text.toString().toIntOrNull() ?: 0
                                    val value3 = viewtext3.text.toString().toIntOrNull() ?: 0
                                    val value4 = viewtext4.text.toString().toIntOrNull() ?: 0
                                    val value5 = viewtext5.text.toString().toIntOrNull() ?: 0
                                    val value6 = viewtext6.text.toString().toIntOrNull() ?: 0
                                    val value7 = viewtext7.text.toString().toIntOrNull() ?: 0
                                    val value8 = viewtext8.text.toString().toIntOrNull() ?: 0
                                    val value9 = viewtext9.text.toString().toIntOrNull() ?: 0
                                    val value10 = viewtext10.text.toString().toIntOrNull() ?: 0
                                    val value11 = viewtext11.text.toString().toIntOrNull() ?: 0
                                    val value12 = viewtext12.text.toString().toIntOrNull() ?: 0
                                    val value13 = viewtext13.text.toString().toIntOrNull() ?: 0
                                    val value14 = viewtext14.text.toString().toIntOrNull() ?: 0
                                    val value15 = viewtext15.text.toString().toIntOrNull() ?: 0
                                    val value16 = viewtext16.text.toString().toIntOrNull() ?: 0
                                    val value17 = viewtext17.text.toString().toIntOrNull() ?: 0
                                    val value18 = viewtext18.text.toString().toIntOrNull() ?: 0
                                    val value19 = viewtext19.text.toString().toIntOrNull() ?: 0
                                    val value20 = viewtext20.text.toString().toIntOrNull() ?: 0
                                    val value21 = viewtext21.text.toString().toIntOrNull() ?: 0
                                    val value22 = viewtext22.text.toString().toIntOrNull() ?: 0
                                    val value23 = viewtext23.text.toString().toIntOrNull() ?: 0
                                    val value24 = viewtext24.text.toString().toIntOrNull() ?: 0
                                    val value25 = viewtext25.text.toString().toIntOrNull() ?: 0
                                    val value26 = viewtext26.text.toString().toIntOrNull() ?: 0
                                    val value27 = viewtext27.text.toString().toIntOrNull() ?: 0
                                    val value28 = viewtext28.text.toString().toIntOrNull() ?: 0
                                    val value29 = viewtext29.text.toString().toIntOrNull() ?: 0
                                    val value30 = viewtext30.text.toString().toIntOrNull() ?: 0
                                    val value31 = viewtext31.text.toString().toIntOrNull() ?: 0
                                    val value32 = viewtext32.text.toString().toIntOrNull() ?: 0
                                    val value33 = viewtext33.text.toString().toIntOrNull() ?: 0
                                    val value34 = viewtext34.text.toString().toIntOrNull() ?: 0
                                    val value35 = viewtext35.text.toString().toIntOrNull() ?: 0
                                    val value36 = viewtext36.text.toString().toIntOrNull() ?: 0
                                    val value37 = viewtext37.text.toString().toIntOrNull() ?: 0
                                    val value38 = viewtext38.text.toString().toIntOrNull() ?: 0
                                    val value39 = viewtext39.text.toString().toIntOrNull() ?: 0
                                    val value40 = viewtext40.text.toString().toIntOrNull() ?: 0
                                    val value41 = viewtext41.text.toString().toIntOrNull() ?: 0
                                    val value42 = viewtext42.text.toString().toIntOrNull() ?: 0
                                    val value43 = viewtext43.text.toString().toIntOrNull() ?: 0
                                    val value44 = viewtext44.text.toString().toIntOrNull() ?: 0
                                    val value45 = viewtext45.text.toString().toIntOrNull() ?: 0
                                    val value46 = viewtext46.text.toString().toIntOrNull() ?: 0
                                    val value47 = viewtext47.text.toString().toIntOrNull() ?: 0
                                    val value48 = viewtext48.text.toString().toIntOrNull() ?: 0
                                    val value49 = viewtext49.text.toString().toIntOrNull() ?: 0
                                    val value50 = viewtext50.text.toString().toIntOrNull() ?: 0
                                    val value51 = viewtext51.text.toString().toIntOrNull() ?: 0
                                    val value52 = viewtext52.text.toString().toIntOrNull() ?: 0
                                    val value53 = viewtext53.text.toString().toIntOrNull() ?: 0
                                    val value54 = viewtext54.text.toString().toIntOrNull() ?: 0
                                    val value55 = viewtext55.text.toString().toIntOrNull() ?: 0
                                    val value56 = viewtext56.text.toString().toIntOrNull() ?: 0
                                    val value57 = viewtext57.text.toString().toIntOrNull() ?: 0
                                    val value58 = viewtext58.text.toString().toIntOrNull() ?: 0
                                    val value59 = viewtext59.text.toString().toIntOrNull() ?: 0

                                    sum = (value1 + value2 + value3 + value4  + value5 +
                                            value6 + value7  + value8  + value9 + value10 + value11 +
                                            value12 + value13 + value14 + value15  + value16  + value17 +
                                            value18 + value19  + value20  + value21 + value22 + value23 +
                                            value24 + value25 + value26 + value27  + value28  + value29 +
                                            value30 + value31  + value32  + value33 + value34 + value35 +
                                            value36 + value37 + value38 + value39  + value40  + value41 +
                                            value42 + value43  + value44  + value45 + value46 + value47 +
                                            value48 + value49 + value50 + value51  + value52  + value53 +
                                            value54 + value55  + value56  + value57 + value58 + value59).toString()

                                    totalall_E_D.text = (sum)
                                }

                                override fun afterTextChanged(s: Editable?) {
                                }
                            })
                        }
                    }

                    if (item.checkData.editD4.isNotEmpty()){
                        customDialogFB.apply { checkBoxauto54.setText(item.checkData.editD4)
                            checkBoxauto54.setTextColor(Color.parseColor("#000000"))
                            checkBoxauto54.layoutParams = LinearLayout.LayoutParams(
                                ViewGroup.LayoutParams.WRAP_CONTENT,
                                ViewGroup.LayoutParams.WRAP_CONTENT, Float.MIN_VALUE)
                            viewtext54.setText(item.checkData.pricD4)
                            viewtext54.setTextColor(Color.parseColor("#000000"))
                            p54.addView(viewtext54)
                            L_c54.addView(checkBoxauto54)
                            viewtext54.setSelectAllOnFocus(true)
                            checkBoxauto54.setSelectAllOnFocus(true)
                            checkBoxauto54.textSize = 14f
                            checkBoxauto54.setTypeface(null, Typeface.BOLD)
                            checkBoxauto54.isSingleLine = true
                            viewtext54.isSingleLine = true
                            viewtext54.textSize = 14f
                            viewtext54.inputType = InputType.TYPE_CLASS_PHONE

                            viewtext54.addTextChangedListener(object : TextWatcher {
                                override fun beforeTextChanged(
                                    s: CharSequence?,
                                    start: Int,
                                    count: Int,
                                    after: Int
                                ) {
                                }

                                override fun onTextChanged(
                                    s: CharSequence?,
                                    start: Int,
                                    before: Int,
                                    count: Int
                                ) {
                                    val value1 = viewtext1.text.toString().toIntOrNull() ?: 0
                                    val value2 = viewtext2.text.toString().toIntOrNull() ?: 0
                                    val value3 = viewtext3.text.toString().toIntOrNull() ?: 0
                                    val value4 = viewtext4.text.toString().toIntOrNull() ?: 0
                                    val value5 = viewtext5.text.toString().toIntOrNull() ?: 0
                                    val value6 = viewtext6.text.toString().toIntOrNull() ?: 0
                                    val value7 = viewtext7.text.toString().toIntOrNull() ?: 0
                                    val value8 = viewtext8.text.toString().toIntOrNull() ?: 0
                                    val value9 = viewtext9.text.toString().toIntOrNull() ?: 0
                                    val value10 = viewtext10.text.toString().toIntOrNull() ?: 0
                                    val value11 = viewtext11.text.toString().toIntOrNull() ?: 0
                                    val value12 = viewtext12.text.toString().toIntOrNull() ?: 0
                                    val value13 = viewtext13.text.toString().toIntOrNull() ?: 0
                                    val value14 = viewtext14.text.toString().toIntOrNull() ?: 0
                                    val value15 = viewtext15.text.toString().toIntOrNull() ?: 0
                                    val value16 = viewtext16.text.toString().toIntOrNull() ?: 0
                                    val value17 = viewtext17.text.toString().toIntOrNull() ?: 0
                                    val value18 = viewtext18.text.toString().toIntOrNull() ?: 0
                                    val value19 = viewtext19.text.toString().toIntOrNull() ?: 0
                                    val value20 = viewtext20.text.toString().toIntOrNull() ?: 0
                                    val value21 = viewtext21.text.toString().toIntOrNull() ?: 0
                                    val value22 = viewtext22.text.toString().toIntOrNull() ?: 0
                                    val value23 = viewtext23.text.toString().toIntOrNull() ?: 0
                                    val value24 = viewtext24.text.toString().toIntOrNull() ?: 0
                                    val value25 = viewtext25.text.toString().toIntOrNull() ?: 0
                                    val value26 = viewtext26.text.toString().toIntOrNull() ?: 0
                                    val value27 = viewtext27.text.toString().toIntOrNull() ?: 0
                                    val value28 = viewtext28.text.toString().toIntOrNull() ?: 0
                                    val value29 = viewtext29.text.toString().toIntOrNull() ?: 0
                                    val value30 = viewtext30.text.toString().toIntOrNull() ?: 0
                                    val value31 = viewtext31.text.toString().toIntOrNull() ?: 0
                                    val value32 = viewtext32.text.toString().toIntOrNull() ?: 0
                                    val value33 = viewtext33.text.toString().toIntOrNull() ?: 0
                                    val value34 = viewtext34.text.toString().toIntOrNull() ?: 0
                                    val value35 = viewtext35.text.toString().toIntOrNull() ?: 0
                                    val value36 = viewtext36.text.toString().toIntOrNull() ?: 0
                                    val value37 = viewtext37.text.toString().toIntOrNull() ?: 0
                                    val value38 = viewtext38.text.toString().toIntOrNull() ?: 0
                                    val value39 = viewtext39.text.toString().toIntOrNull() ?: 0
                                    val value40 = viewtext40.text.toString().toIntOrNull() ?: 0
                                    val value41 = viewtext41.text.toString().toIntOrNull() ?: 0
                                    val value42 = viewtext42.text.toString().toIntOrNull() ?: 0
                                    val value43 = viewtext43.text.toString().toIntOrNull() ?: 0
                                    val value44 = viewtext44.text.toString().toIntOrNull() ?: 0
                                    val value45 = viewtext45.text.toString().toIntOrNull() ?: 0
                                    val value46 = viewtext46.text.toString().toIntOrNull() ?: 0
                                    val value47 = viewtext47.text.toString().toIntOrNull() ?: 0
                                    val value48 = viewtext48.text.toString().toIntOrNull() ?: 0
                                    val value49 = viewtext49.text.toString().toIntOrNull() ?: 0
                                    val value50 = viewtext50.text.toString().toIntOrNull() ?: 0
                                    val value51 = viewtext51.text.toString().toIntOrNull() ?: 0
                                    val value52 = viewtext52.text.toString().toIntOrNull() ?: 0
                                    val value53 = viewtext53.text.toString().toIntOrNull() ?: 0
                                    val value54 = viewtext54.text.toString().toIntOrNull() ?: 0
                                    val value55 = viewtext55.text.toString().toIntOrNull() ?: 0
                                    val value56 = viewtext56.text.toString().toIntOrNull() ?: 0
                                    val value57 = viewtext57.text.toString().toIntOrNull() ?: 0
                                    val value58 = viewtext58.text.toString().toIntOrNull() ?: 0
                                    val value59 = viewtext59.text.toString().toIntOrNull() ?: 0

                                    sum = (value1 + value2 + value3 + value4  + value5 +
                                            value6 + value7  + value8  + value9 + value10 + value11 +
                                            value12 + value13 + value14 + value15  + value16  + value17 +
                                            value18 + value19  + value20  + value21 + value22 + value23 +
                                            value24 + value25 + value26 + value27  + value28  + value29 +
                                            value30 + value31  + value32  + value33 + value34 + value35 +
                                            value36 + value37 + value38 + value39  + value40  + value41 +
                                            value42 + value43  + value44  + value45 + value46 + value47 +
                                            value48 + value49 + value50 + value51  + value52  + value53 +
                                            value54 + value55  + value56  + value57 + value58 + value59).toString()

                                    totalall_E_D.text = (sum)
                                }

                                override fun afterTextChanged(s: Editable?) {
                                }
                            })
                        }
                    }

                    if (item.checkData.editD5.isNotEmpty()){

                        customDialogFB.apply {
                            checkBoxauto55.setText(item.checkData.editD5)
                            checkBoxauto55.setTextColor(Color.parseColor("#000000"))
                            checkBoxauto55.layoutParams = LinearLayout.LayoutParams(
                                ViewGroup.LayoutParams.WRAP_CONTENT,
                                ViewGroup.LayoutParams.WRAP_CONTENT, Float.MIN_VALUE)
                            viewtext55.setText(item.checkData.pricD5)
                            viewtext55.setTextColor(Color.parseColor("#000000"))
                            p55.addView(viewtext55)
                            L_c55.addView(checkBoxauto55)
                            viewtext55.setSelectAllOnFocus(true)
                            checkBoxauto55.setSelectAllOnFocus(true)
                            checkBoxauto55.textSize = 14f
                            checkBoxauto55.setTypeface(null, Typeface.BOLD)
                            checkBoxauto55.isSingleLine = true
                            viewtext55.isSingleLine = true
                            viewtext55.textSize = 14f
                            viewtext55.inputType = InputType.TYPE_CLASS_PHONE

                            viewtext55.addTextChangedListener(object : TextWatcher {
                                override fun beforeTextChanged(
                                    s: CharSequence?,
                                    start: Int,
                                    count: Int,
                                    after: Int
                                ) {
                                }

                                override fun onTextChanged(
                                    s: CharSequence?,
                                    start: Int,
                                    before: Int,
                                    count: Int
                                ) {
                                    val value1 = viewtext1.text.toString().toIntOrNull() ?: 0
                                    val value2 = viewtext2.text.toString().toIntOrNull() ?: 0
                                    val value3 = viewtext3.text.toString().toIntOrNull() ?: 0
                                    val value4 = viewtext4.text.toString().toIntOrNull() ?: 0
                                    val value5 = viewtext5.text.toString().toIntOrNull() ?: 0
                                    val value6 = viewtext6.text.toString().toIntOrNull() ?: 0
                                    val value7 = viewtext7.text.toString().toIntOrNull() ?: 0
                                    val value8 = viewtext8.text.toString().toIntOrNull() ?: 0
                                    val value9 = viewtext9.text.toString().toIntOrNull() ?: 0
                                    val value10 = viewtext10.text.toString().toIntOrNull() ?: 0
                                    val value11 = viewtext11.text.toString().toIntOrNull() ?: 0
                                    val value12 = viewtext12.text.toString().toIntOrNull() ?: 0
                                    val value13 = viewtext13.text.toString().toIntOrNull() ?: 0
                                    val value14 = viewtext14.text.toString().toIntOrNull() ?: 0
                                    val value15 = viewtext15.text.toString().toIntOrNull() ?: 0
                                    val value16 = viewtext16.text.toString().toIntOrNull() ?: 0
                                    val value17 = viewtext17.text.toString().toIntOrNull() ?: 0
                                    val value18 = viewtext18.text.toString().toIntOrNull() ?: 0
                                    val value19 = viewtext19.text.toString().toIntOrNull() ?: 0
                                    val value20 = viewtext20.text.toString().toIntOrNull() ?: 0
                                    val value21 = viewtext21.text.toString().toIntOrNull() ?: 0
                                    val value22 = viewtext22.text.toString().toIntOrNull() ?: 0
                                    val value23 = viewtext23.text.toString().toIntOrNull() ?: 0
                                    val value24 = viewtext24.text.toString().toIntOrNull() ?: 0
                                    val value25 = viewtext25.text.toString().toIntOrNull() ?: 0
                                    val value26 = viewtext26.text.toString().toIntOrNull() ?: 0
                                    val value27 = viewtext27.text.toString().toIntOrNull() ?: 0
                                    val value28 = viewtext28.text.toString().toIntOrNull() ?: 0
                                    val value29 = viewtext29.text.toString().toIntOrNull() ?: 0
                                    val value30 = viewtext30.text.toString().toIntOrNull() ?: 0
                                    val value31 = viewtext31.text.toString().toIntOrNull() ?: 0
                                    val value32 = viewtext32.text.toString().toIntOrNull() ?: 0
                                    val value33 = viewtext33.text.toString().toIntOrNull() ?: 0
                                    val value34 = viewtext34.text.toString().toIntOrNull() ?: 0
                                    val value35 = viewtext35.text.toString().toIntOrNull() ?: 0
                                    val value36 = viewtext36.text.toString().toIntOrNull() ?: 0
                                    val value37 = viewtext37.text.toString().toIntOrNull() ?: 0
                                    val value38 = viewtext38.text.toString().toIntOrNull() ?: 0
                                    val value39 = viewtext39.text.toString().toIntOrNull() ?: 0
                                    val value40 = viewtext40.text.toString().toIntOrNull() ?: 0
                                    val value41 = viewtext41.text.toString().toIntOrNull() ?: 0
                                    val value42 = viewtext42.text.toString().toIntOrNull() ?: 0
                                    val value43 = viewtext43.text.toString().toIntOrNull() ?: 0
                                    val value44 = viewtext44.text.toString().toIntOrNull() ?: 0
                                    val value45 = viewtext45.text.toString().toIntOrNull() ?: 0
                                    val value46 = viewtext46.text.toString().toIntOrNull() ?: 0
                                    val value47 = viewtext47.text.toString().toIntOrNull() ?: 0
                                    val value48 = viewtext48.text.toString().toIntOrNull() ?: 0
                                    val value49 = viewtext49.text.toString().toIntOrNull() ?: 0
                                    val value50 = viewtext50.text.toString().toIntOrNull() ?: 0
                                    val value51 = viewtext51.text.toString().toIntOrNull() ?: 0
                                    val value52 = viewtext52.text.toString().toIntOrNull() ?: 0
                                    val value53 = viewtext53.text.toString().toIntOrNull() ?: 0
                                    val value54 = viewtext54.text.toString().toIntOrNull() ?: 0
                                    val value55 = viewtext55.text.toString().toIntOrNull() ?: 0
                                    val value56 = viewtext56.text.toString().toIntOrNull() ?: 0
                                    val value57 = viewtext57.text.toString().toIntOrNull() ?: 0
                                    val value58 = viewtext58.text.toString().toIntOrNull() ?: 0
                                    val value59 = viewtext59.text.toString().toIntOrNull() ?: 0

                                    sum = (value1 + value2 + value3 + value4  + value5 +
                                            value6 + value7  + value8  + value9 + value10 + value11 +
                                            value12 + value13 + value14 + value15  + value16  + value17 +
                                            value18 + value19  + value20  + value21 + value22 + value23 +
                                            value24 + value25 + value26 + value27  + value28  + value29 +
                                            value30 + value31  + value32  + value33 + value34 + value35 +
                                            value36 + value37 + value38 + value39  + value40  + value41 +
                                            value42 + value43  + value44  + value45 + value46 + value47 +
                                            value48 + value49 + value50 + value51  + value52  + value53 +
                                            value54 + value55  + value56  + value57 + value58 + value59).toString()

                                    totalall_E_D.text = (sum)
                                }

                                override fun afterTextChanged(s: Editable?) {
                                }
                            })
                        }
                    }

                    if (item.checkData.editD6.isNotEmpty()){
                        customDialogFB.apply {
                            checkBoxauto56.setText(item.checkData.editD6)
                            checkBoxauto56.setTextColor(Color.parseColor("#000000"))
                            checkBoxauto56.layoutParams = LinearLayout.LayoutParams(
                                ViewGroup.LayoutParams.WRAP_CONTENT,
                                ViewGroup.LayoutParams.WRAP_CONTENT, Float.MIN_VALUE)
                            viewtext56.setText(item.checkData.pricD6)
                            viewtext56.setTextColor(Color.parseColor("#000000"))
                            p56.addView(viewtext56)
                            L_c56.addView(checkBoxauto56)
                            viewtext56.setSelectAllOnFocus(true)
                            checkBoxauto56.setSelectAllOnFocus(true)
                            checkBoxauto56.textSize = 14f
                            checkBoxauto56.setTypeface(null, Typeface.BOLD)
                            checkBoxauto56.isSingleLine = true
                            viewtext56.isSingleLine = true
                            viewtext56.textSize = 14f
                            viewtext56.inputType = InputType.TYPE_CLASS_PHONE

                            viewtext56.addTextChangedListener(object : TextWatcher {
                                override fun beforeTextChanged(
                                    s: CharSequence?,
                                    start: Int,
                                    count: Int,
                                    after: Int
                                ) {
                                }

                                override fun onTextChanged(
                                    s: CharSequence?,
                                    start: Int,
                                    before: Int,
                                    count: Int
                                ) {
                                    val value1 = viewtext1.text.toString().toIntOrNull() ?: 0
                                    val value2 = viewtext2.text.toString().toIntOrNull() ?: 0
                                    val value3 = viewtext3.text.toString().toIntOrNull() ?: 0
                                    val value4 = viewtext4.text.toString().toIntOrNull() ?: 0
                                    val value5 = viewtext5.text.toString().toIntOrNull() ?: 0
                                    val value6 = viewtext6.text.toString().toIntOrNull() ?: 0
                                    val value7 = viewtext7.text.toString().toIntOrNull() ?: 0
                                    val value8 = viewtext8.text.toString().toIntOrNull() ?: 0
                                    val value9 = viewtext9.text.toString().toIntOrNull() ?: 0
                                    val value10 = viewtext10.text.toString().toIntOrNull() ?: 0
                                    val value11 = viewtext11.text.toString().toIntOrNull() ?: 0
                                    val value12 = viewtext12.text.toString().toIntOrNull() ?: 0
                                    val value13 = viewtext13.text.toString().toIntOrNull() ?: 0
                                    val value14 = viewtext14.text.toString().toIntOrNull() ?: 0
                                    val value15 = viewtext15.text.toString().toIntOrNull() ?: 0
                                    val value16 = viewtext16.text.toString().toIntOrNull() ?: 0
                                    val value17 = viewtext17.text.toString().toIntOrNull() ?: 0
                                    val value18 = viewtext18.text.toString().toIntOrNull() ?: 0
                                    val value19 = viewtext19.text.toString().toIntOrNull() ?: 0
                                    val value20 = viewtext20.text.toString().toIntOrNull() ?: 0
                                    val value21 = viewtext21.text.toString().toIntOrNull() ?: 0
                                    val value22 = viewtext22.text.toString().toIntOrNull() ?: 0
                                    val value23 = viewtext23.text.toString().toIntOrNull() ?: 0
                                    val value24 = viewtext24.text.toString().toIntOrNull() ?: 0
                                    val value25 = viewtext25.text.toString().toIntOrNull() ?: 0
                                    val value26 = viewtext26.text.toString().toIntOrNull() ?: 0
                                    val value27 = viewtext27.text.toString().toIntOrNull() ?: 0
                                    val value28 = viewtext28.text.toString().toIntOrNull() ?: 0
                                    val value29 = viewtext29.text.toString().toIntOrNull() ?: 0
                                    val value30 = viewtext30.text.toString().toIntOrNull() ?: 0
                                    val value31 = viewtext31.text.toString().toIntOrNull() ?: 0
                                    val value32 = viewtext32.text.toString().toIntOrNull() ?: 0
                                    val value33 = viewtext33.text.toString().toIntOrNull() ?: 0
                                    val value34 = viewtext34.text.toString().toIntOrNull() ?: 0
                                    val value35 = viewtext35.text.toString().toIntOrNull() ?: 0
                                    val value36 = viewtext36.text.toString().toIntOrNull() ?: 0
                                    val value37 = viewtext37.text.toString().toIntOrNull() ?: 0
                                    val value38 = viewtext38.text.toString().toIntOrNull() ?: 0
                                    val value39 = viewtext39.text.toString().toIntOrNull() ?: 0
                                    val value40 = viewtext40.text.toString().toIntOrNull() ?: 0
                                    val value41 = viewtext41.text.toString().toIntOrNull() ?: 0
                                    val value42 = viewtext42.text.toString().toIntOrNull() ?: 0
                                    val value43 = viewtext43.text.toString().toIntOrNull() ?: 0
                                    val value44 = viewtext44.text.toString().toIntOrNull() ?: 0
                                    val value45 = viewtext45.text.toString().toIntOrNull() ?: 0
                                    val value46 = viewtext46.text.toString().toIntOrNull() ?: 0
                                    val value47 = viewtext47.text.toString().toIntOrNull() ?: 0
                                    val value48 = viewtext48.text.toString().toIntOrNull() ?: 0
                                    val value49 = viewtext49.text.toString().toIntOrNull() ?: 0
                                    val value50 = viewtext50.text.toString().toIntOrNull() ?: 0
                                    val value51 = viewtext51.text.toString().toIntOrNull() ?: 0
                                    val value52 = viewtext52.text.toString().toIntOrNull() ?: 0
                                    val value53 = viewtext53.text.toString().toIntOrNull() ?: 0
                                    val value54 = viewtext54.text.toString().toIntOrNull() ?: 0
                                    val value55 = viewtext55.text.toString().toIntOrNull() ?: 0
                                    val value56 = viewtext56.text.toString().toIntOrNull() ?: 0
                                    val value57 = viewtext57.text.toString().toIntOrNull() ?: 0
                                    val value58 = viewtext58.text.toString().toIntOrNull() ?: 0
                                    val value59 = viewtext59.text.toString().toIntOrNull() ?: 0

                                    sum = (value1 + value2 + value3 + value4  + value5 +
                                            value6 + value7  + value8  + value9 + value10 + value11 +
                                            value12 + value13 + value14 + value15  + value16  + value17 +
                                            value18 + value19  + value20  + value21 + value22 + value23 +
                                            value24 + value25 + value26 + value27  + value28  + value29 +
                                            value30 + value31  + value32  + value33 + value34 + value35 +
                                            value36 + value37 + value38 + value39  + value40  + value41 +
                                            value42 + value43  + value44  + value45 + value46 + value47 +
                                            value48 + value49 + value50 + value51  + value52  + value53 +
                                            value54 + value55  + value56  + value57 + value58 + value59).toString()

                                    totalall_E_D.text = (sum)
                                }

                                override fun afterTextChanged(s: Editable?) {
                                }
                            })
                        }
                    }

                    if (item.checkData.editD7.isNotEmpty()){
                        customDialogFB.apply {
                            checkBoxauto57.setText(item.checkData.editD7)
                            checkBoxauto57.setTextColor(Color.parseColor("#000000"))
                            checkBoxauto57.layoutParams = LinearLayout.LayoutParams(
                                ViewGroup.LayoutParams.WRAP_CONTENT,
                                ViewGroup.LayoutParams.WRAP_CONTENT, Float.MIN_VALUE)
                            viewtext57.setText(item.checkData.pricD7)
                            viewtext57.setTextColor(Color.parseColor("#000000"))
                            p57.addView(viewtext57)
                            L_c57.addView(checkBoxauto57)
                            viewtext57.setSelectAllOnFocus(true)
                            checkBoxauto57.setSelectAllOnFocus(true)
                            checkBoxauto57.textSize = 14f
                            checkBoxauto57.setTypeface(null, Typeface.BOLD)
                            checkBoxauto57.isSingleLine = true
                            viewtext57.isSingleLine = true
                            viewtext57.textSize = 14f
                            viewtext57.inputType = InputType.TYPE_CLASS_PHONE

                            viewtext57.addTextChangedListener(object : TextWatcher {
                                override fun beforeTextChanged(
                                    s: CharSequence?,
                                    start: Int,
                                    count: Int,
                                    after: Int
                                ) {
                                }

                                override fun onTextChanged(
                                    s: CharSequence?,
                                    start: Int,
                                    before: Int,
                                    count: Int
                                ) {
                                    val value1 = viewtext1.text.toString().toIntOrNull() ?: 0
                                    val value2 = viewtext2.text.toString().toIntOrNull() ?: 0
                                    val value3 = viewtext3.text.toString().toIntOrNull() ?: 0
                                    val value4 = viewtext4.text.toString().toIntOrNull() ?: 0
                                    val value5 = viewtext5.text.toString().toIntOrNull() ?: 0
                                    val value6 = viewtext6.text.toString().toIntOrNull() ?: 0
                                    val value7 = viewtext7.text.toString().toIntOrNull() ?: 0
                                    val value8 = viewtext8.text.toString().toIntOrNull() ?: 0
                                    val value9 = viewtext9.text.toString().toIntOrNull() ?: 0
                                    val value10 = viewtext10.text.toString().toIntOrNull() ?: 0
                                    val value11 = viewtext11.text.toString().toIntOrNull() ?: 0
                                    val value12 = viewtext12.text.toString().toIntOrNull() ?: 0
                                    val value13 = viewtext13.text.toString().toIntOrNull() ?: 0
                                    val value14 = viewtext14.text.toString().toIntOrNull() ?: 0
                                    val value15 = viewtext15.text.toString().toIntOrNull() ?: 0
                                    val value16 = viewtext16.text.toString().toIntOrNull() ?: 0
                                    val value17 = viewtext17.text.toString().toIntOrNull() ?: 0
                                    val value18 = viewtext18.text.toString().toIntOrNull() ?: 0
                                    val value19 = viewtext19.text.toString().toIntOrNull() ?: 0
                                    val value20 = viewtext20.text.toString().toIntOrNull() ?: 0
                                    val value21 = viewtext21.text.toString().toIntOrNull() ?: 0
                                    val value22 = viewtext22.text.toString().toIntOrNull() ?: 0
                                    val value23 = viewtext23.text.toString().toIntOrNull() ?: 0
                                    val value24 = viewtext24.text.toString().toIntOrNull() ?: 0
                                    val value25 = viewtext25.text.toString().toIntOrNull() ?: 0
                                    val value26 = viewtext26.text.toString().toIntOrNull() ?: 0
                                    val value27 = viewtext27.text.toString().toIntOrNull() ?: 0
                                    val value28 = viewtext28.text.toString().toIntOrNull() ?: 0
                                    val value29 = viewtext29.text.toString().toIntOrNull() ?: 0
                                    val value30 = viewtext30.text.toString().toIntOrNull() ?: 0
                                    val value31 = viewtext31.text.toString().toIntOrNull() ?: 0
                                    val value32 = viewtext32.text.toString().toIntOrNull() ?: 0
                                    val value33 = viewtext33.text.toString().toIntOrNull() ?: 0
                                    val value34 = viewtext34.text.toString().toIntOrNull() ?: 0
                                    val value35 = viewtext35.text.toString().toIntOrNull() ?: 0
                                    val value36 = viewtext36.text.toString().toIntOrNull() ?: 0
                                    val value37 = viewtext37.text.toString().toIntOrNull() ?: 0
                                    val value38 = viewtext38.text.toString().toIntOrNull() ?: 0
                                    val value39 = viewtext39.text.toString().toIntOrNull() ?: 0
                                    val value40 = viewtext40.text.toString().toIntOrNull() ?: 0
                                    val value41 = viewtext41.text.toString().toIntOrNull() ?: 0
                                    val value42 = viewtext42.text.toString().toIntOrNull() ?: 0
                                    val value43 = viewtext43.text.toString().toIntOrNull() ?: 0
                                    val value44 = viewtext44.text.toString().toIntOrNull() ?: 0
                                    val value45 = viewtext45.text.toString().toIntOrNull() ?: 0
                                    val value46 = viewtext46.text.toString().toIntOrNull() ?: 0
                                    val value47 = viewtext47.text.toString().toIntOrNull() ?: 0
                                    val value48 = viewtext48.text.toString().toIntOrNull() ?: 0
                                    val value49 = viewtext49.text.toString().toIntOrNull() ?: 0
                                    val value50 = viewtext50.text.toString().toIntOrNull() ?: 0
                                    val value51 = viewtext51.text.toString().toIntOrNull() ?: 0
                                    val value52 = viewtext52.text.toString().toIntOrNull() ?: 0
                                    val value53 = viewtext53.text.toString().toIntOrNull() ?: 0
                                    val value54 = viewtext54.text.toString().toIntOrNull() ?: 0
                                    val value55 = viewtext55.text.toString().toIntOrNull() ?: 0
                                    val value56 = viewtext56.text.toString().toIntOrNull() ?: 0
                                    val value57 = viewtext57.text.toString().toIntOrNull() ?: 0
                                    val value58 = viewtext58.text.toString().toIntOrNull() ?: 0
                                    val value59 = viewtext59.text.toString().toIntOrNull() ?: 0

                                    sum = (value1 + value2 + value3 + value4  + value5 +
                                            value6 + value7  + value8  + value9 + value10 + value11 +
                                            value12 + value13 + value14 + value15  + value16  + value17 +
                                            value18 + value19  + value20  + value21 + value22 + value23 +
                                            value24 + value25 + value26 + value27  + value28  + value29 +
                                            value30 + value31  + value32  + value33 + value34 + value35 +
                                            value36 + value37 + value38 + value39  + value40  + value41 +
                                            value42 + value43  + value44  + value45 + value46 + value47 +
                                            value48 + value49 + value50 + value51  + value52  + value53 +
                                            value54 + value55  + value56  + value57 + value58 + value59).toString()

                                    totalall_E_D.text = (sum)
                                }

                                override fun afterTextChanged(s: Editable?) {
                                }
                            })
                        }
                    }

                    if (item.checkData.editD8.isNotEmpty()){
                        customDialogFB.apply {
                            checkBoxauto58.setText(item.checkData.editD8)
                            checkBoxauto58.setTextColor(Color.parseColor("#000000"))
                            checkBoxauto58.layoutParams = LinearLayout.LayoutParams(
                                ViewGroup.LayoutParams.WRAP_CONTENT,
                                ViewGroup.LayoutParams.WRAP_CONTENT, Float.MIN_VALUE)
                            viewtext58.setText(item.checkData.pricD8)
                            viewtext58.setTextColor(Color.parseColor("#000000"))
                            p58.addView(viewtext58)
                            L_c58.addView(checkBoxauto58)
                            viewtext58.setSelectAllOnFocus(true)
                            checkBoxauto58.setSelectAllOnFocus(true)
                            checkBoxauto58.textSize = 14f
                            checkBoxauto58.setTypeface(null, Typeface.BOLD)
                            checkBoxauto58.isSingleLine = true
                            viewtext58.isSingleLine = true
                            viewtext58.textSize = 14f
                            viewtext58.inputType = InputType.TYPE_CLASS_PHONE

                            viewtext58.addTextChangedListener(object : TextWatcher {
                                override fun beforeTextChanged(
                                    s: CharSequence?,
                                    start: Int,
                                    count: Int,
                                    after: Int
                                ) {
                                }

                                override fun onTextChanged(
                                    s: CharSequence?,
                                    start: Int,
                                    before: Int,
                                    count: Int
                                ) {
                                    val value1 = viewtext1.text.toString().toIntOrNull() ?: 0
                                    val value2 = viewtext2.text.toString().toIntOrNull() ?: 0
                                    val value3 = viewtext3.text.toString().toIntOrNull() ?: 0
                                    val value4 = viewtext4.text.toString().toIntOrNull() ?: 0
                                    val value5 = viewtext5.text.toString().toIntOrNull() ?: 0
                                    val value6 = viewtext6.text.toString().toIntOrNull() ?: 0
                                    val value7 = viewtext7.text.toString().toIntOrNull() ?: 0
                                    val value8 = viewtext8.text.toString().toIntOrNull() ?: 0
                                    val value9 = viewtext9.text.toString().toIntOrNull() ?: 0
                                    val value10 = viewtext10.text.toString().toIntOrNull() ?: 0
                                    val value11 = viewtext11.text.toString().toIntOrNull() ?: 0
                                    val value12 = viewtext12.text.toString().toIntOrNull() ?: 0
                                    val value13 = viewtext13.text.toString().toIntOrNull() ?: 0
                                    val value14 = viewtext14.text.toString().toIntOrNull() ?: 0
                                    val value15 = viewtext15.text.toString().toIntOrNull() ?: 0
                                    val value16 = viewtext16.text.toString().toIntOrNull() ?: 0
                                    val value17 = viewtext17.text.toString().toIntOrNull() ?: 0
                                    val value18 = viewtext18.text.toString().toIntOrNull() ?: 0
                                    val value19 = viewtext19.text.toString().toIntOrNull() ?: 0
                                    val value20 = viewtext20.text.toString().toIntOrNull() ?: 0
                                    val value21 = viewtext21.text.toString().toIntOrNull() ?: 0
                                    val value22 = viewtext22.text.toString().toIntOrNull() ?: 0
                                    val value23 = viewtext23.text.toString().toIntOrNull() ?: 0
                                    val value24 = viewtext24.text.toString().toIntOrNull() ?: 0
                                    val value25 = viewtext25.text.toString().toIntOrNull() ?: 0
                                    val value26 = viewtext26.text.toString().toIntOrNull() ?: 0
                                    val value27 = viewtext27.text.toString().toIntOrNull() ?: 0
                                    val value28 = viewtext28.text.toString().toIntOrNull() ?: 0
                                    val value29 = viewtext29.text.toString().toIntOrNull() ?: 0
                                    val value30 = viewtext30.text.toString().toIntOrNull() ?: 0
                                    val value31 = viewtext31.text.toString().toIntOrNull() ?: 0
                                    val value32 = viewtext32.text.toString().toIntOrNull() ?: 0
                                    val value33 = viewtext33.text.toString().toIntOrNull() ?: 0
                                    val value34 = viewtext34.text.toString().toIntOrNull() ?: 0
                                    val value35 = viewtext35.text.toString().toIntOrNull() ?: 0
                                    val value36 = viewtext36.text.toString().toIntOrNull() ?: 0
                                    val value37 = viewtext37.text.toString().toIntOrNull() ?: 0
                                    val value38 = viewtext38.text.toString().toIntOrNull() ?: 0
                                    val value39 = viewtext39.text.toString().toIntOrNull() ?: 0
                                    val value40 = viewtext40.text.toString().toIntOrNull() ?: 0
                                    val value41 = viewtext41.text.toString().toIntOrNull() ?: 0
                                    val value42 = viewtext42.text.toString().toIntOrNull() ?: 0
                                    val value43 = viewtext43.text.toString().toIntOrNull() ?: 0
                                    val value44 = viewtext44.text.toString().toIntOrNull() ?: 0
                                    val value45 = viewtext45.text.toString().toIntOrNull() ?: 0
                                    val value46 = viewtext46.text.toString().toIntOrNull() ?: 0
                                    val value47 = viewtext47.text.toString().toIntOrNull() ?: 0
                                    val value48 = viewtext48.text.toString().toIntOrNull() ?: 0
                                    val value49 = viewtext49.text.toString().toIntOrNull() ?: 0
                                    val value50 = viewtext50.text.toString().toIntOrNull() ?: 0
                                    val value51 = viewtext51.text.toString().toIntOrNull() ?: 0
                                    val value52 = viewtext52.text.toString().toIntOrNull() ?: 0
                                    val value53 = viewtext53.text.toString().toIntOrNull() ?: 0
                                    val value54 = viewtext54.text.toString().toIntOrNull() ?: 0
                                    val value55 = viewtext55.text.toString().toIntOrNull() ?: 0
                                    val value56 = viewtext56.text.toString().toIntOrNull() ?: 0
                                    val value57 = viewtext57.text.toString().toIntOrNull() ?: 0
                                    val value58 = viewtext58.text.toString().toIntOrNull() ?: 0
                                    val value59 = viewtext59.text.toString().toIntOrNull() ?: 0

                                    sum = (value1 + value2 + value3 + value4  + value5 +
                                            value6 + value7  + value8  + value9 + value10 + value11 +
                                            value12 + value13 + value14 + value15  + value16  + value17 +
                                            value18 + value19  + value20  + value21 + value22 + value23 +
                                            value24 + value25 + value26 + value27  + value28  + value29 +
                                            value30 + value31  + value32  + value33 + value34 + value35 +
                                            value36 + value37 + value38 + value39  + value40  + value41 +
                                            value42 + value43  + value44  + value45 + value46 + value47 +
                                            value48 + value49 + value50 + value51  + value52  + value53 +
                                            value54 + value55  + value56  + value57 + value58 + value59).toString()

                                    totalall_E_D.text = (sum)
                                }

                                override fun afterTextChanged(s: Editable?) {
                                }
                            })
                        }
                    }

                    if (item.checkData.editD9.isNotEmpty()){
                        customDialogFB.apply {
                            checkBoxauto59.setText(item.checkData.editD9)
                            checkBoxauto59.setTextColor(Color.parseColor("#000000"))
                            checkBoxauto59.layoutParams = LinearLayout.LayoutParams(
                                ViewGroup.LayoutParams.WRAP_CONTENT,
                                ViewGroup.LayoutParams.WRAP_CONTENT, Float.MIN_VALUE)
                            viewtext59.setText(item.checkData.pricD9)
                            viewtext59.setTextColor(Color.parseColor("#000000"))
                            p59.addView(viewtext59)
                            L_c59.addView(checkBoxauto59)
                            viewtext59.setSelectAllOnFocus(true)
                            checkBoxauto59.setSelectAllOnFocus(true)
                            checkBoxauto59.textSize = 14f
                            checkBoxauto59.setTypeface(null, Typeface.BOLD)
                            checkBoxauto59.isSingleLine = true
                            viewtext59.isSingleLine = true
                            viewtext59.textSize = 14f
                            viewtext59.inputType = InputType.TYPE_CLASS_PHONE

                            viewtext59.addTextChangedListener(object : TextWatcher {
                                override fun beforeTextChanged(
                                    s: CharSequence?,
                                    start: Int,
                                    count: Int,
                                    after: Int
                                ) {
                                }

                                override fun onTextChanged(
                                    s: CharSequence?,
                                    start: Int,
                                    before: Int,
                                    count: Int
                                ) {
                                    val value1 = viewtext1.text.toString().toIntOrNull() ?: 0
                                    val value2 = viewtext2.text.toString().toIntOrNull() ?: 0
                                    val value3 = viewtext3.text.toString().toIntOrNull() ?: 0
                                    val value4 = viewtext4.text.toString().toIntOrNull() ?: 0
                                    val value5 = viewtext5.text.toString().toIntOrNull() ?: 0
                                    val value6 = viewtext6.text.toString().toIntOrNull() ?: 0
                                    val value7 = viewtext7.text.toString().toIntOrNull() ?: 0
                                    val value8 = viewtext8.text.toString().toIntOrNull() ?: 0
                                    val value9 = viewtext9.text.toString().toIntOrNull() ?: 0
                                    val value10 = viewtext10.text.toString().toIntOrNull() ?: 0
                                    val value11 = viewtext11.text.toString().toIntOrNull() ?: 0
                                    val value12 = viewtext12.text.toString().toIntOrNull() ?: 0
                                    val value13 = viewtext13.text.toString().toIntOrNull() ?: 0
                                    val value14 = viewtext14.text.toString().toIntOrNull() ?: 0
                                    val value15 = viewtext15.text.toString().toIntOrNull() ?: 0
                                    val value16 = viewtext16.text.toString().toIntOrNull() ?: 0
                                    val value17 = viewtext17.text.toString().toIntOrNull() ?: 0
                                    val value18 = viewtext18.text.toString().toIntOrNull() ?: 0
                                    val value19 = viewtext19.text.toString().toIntOrNull() ?: 0
                                    val value20 = viewtext20.text.toString().toIntOrNull() ?: 0
                                    val value21 = viewtext21.text.toString().toIntOrNull() ?: 0
                                    val value22 = viewtext22.text.toString().toIntOrNull() ?: 0
                                    val value23 = viewtext23.text.toString().toIntOrNull() ?: 0
                                    val value24 = viewtext24.text.toString().toIntOrNull() ?: 0
                                    val value25 = viewtext25.text.toString().toIntOrNull() ?: 0
                                    val value26 = viewtext26.text.toString().toIntOrNull() ?: 0
                                    val value27 = viewtext27.text.toString().toIntOrNull() ?: 0
                                    val value28 = viewtext28.text.toString().toIntOrNull() ?: 0
                                    val value29 = viewtext29.text.toString().toIntOrNull() ?: 0
                                    val value30 = viewtext30.text.toString().toIntOrNull() ?: 0
                                    val value31 = viewtext31.text.toString().toIntOrNull() ?: 0
                                    val value32 = viewtext32.text.toString().toIntOrNull() ?: 0
                                    val value33 = viewtext33.text.toString().toIntOrNull() ?: 0
                                    val value34 = viewtext34.text.toString().toIntOrNull() ?: 0
                                    val value35 = viewtext35.text.toString().toIntOrNull() ?: 0
                                    val value36 = viewtext36.text.toString().toIntOrNull() ?: 0
                                    val value37 = viewtext37.text.toString().toIntOrNull() ?: 0
                                    val value38 = viewtext38.text.toString().toIntOrNull() ?: 0
                                    val value39 = viewtext39.text.toString().toIntOrNull() ?: 0
                                    val value40 = viewtext40.text.toString().toIntOrNull() ?: 0
                                    val value41 = viewtext41.text.toString().toIntOrNull() ?: 0
                                    val value42 = viewtext42.text.toString().toIntOrNull() ?: 0
                                    val value43 = viewtext43.text.toString().toIntOrNull() ?: 0
                                    val value44 = viewtext44.text.toString().toIntOrNull() ?: 0
                                    val value45 = viewtext45.text.toString().toIntOrNull() ?: 0
                                    val value46 = viewtext46.text.toString().toIntOrNull() ?: 0
                                    val value47 = viewtext47.text.toString().toIntOrNull() ?: 0
                                    val value48 = viewtext48.text.toString().toIntOrNull() ?: 0
                                    val value49 = viewtext49.text.toString().toIntOrNull() ?: 0
                                    val value50 = viewtext50.text.toString().toIntOrNull() ?: 0
                                    val value51 = viewtext51.text.toString().toIntOrNull() ?: 0
                                    val value52 = viewtext52.text.toString().toIntOrNull() ?: 0
                                    val value53 = viewtext53.text.toString().toIntOrNull() ?: 0
                                    val value54 = viewtext54.text.toString().toIntOrNull() ?: 0
                                    val value55 = viewtext55.text.toString().toIntOrNull() ?: 0
                                    val value56 = viewtext56.text.toString().toIntOrNull() ?: 0
                                    val value57 = viewtext57.text.toString().toIntOrNull() ?: 0
                                    val value58 = viewtext58.text.toString().toIntOrNull() ?: 0
                                    val value59 = viewtext59.text.toString().toIntOrNull() ?: 0

                                    sum = (value1 + value2 + value3 + value4  + value5 +
                                            value6 + value7  + value8  + value9 + value10 + value11 +
                                            value12 + value13 + value14 + value15  + value16  + value17 +
                                            value18 + value19  + value20  + value21 + value22 + value23 +
                                            value24 + value25 + value26 + value27  + value28  + value29 +
                                            value30 + value31  + value32  + value33 + value34 + value35 +
                                            value36 + value37 + value38 + value39  + value40  + value41 +
                                            value42 + value43  + value44  + value45 + value46 + value47 +
                                            value48 + value49 + value50 + value51  + value52  + value53 +
                                            value54 + value55  + value56  + value57 + value58 + value59).toString()

                                    totalall_E_D.text = (sum)
                                }

                                override fun afterTextChanged(s: Editable?) {
                                }
                            })
                        }
                    }

                    if (item.checkData.check2_1.isNotEmpty()){
                        customDialogFB.apply {
                            checkBoxauto21.setText(item.checkData.check2_1)
                            checkBoxauto21.setTextColor(Color.parseColor("#000000"))
                            checkBoxauto21.layoutParams = LinearLayout.LayoutParams(
                                ViewGroup.LayoutParams.WRAP_CONTENT,
                                ViewGroup.LayoutParams.WRAP_CONTENT, Float.MIN_VALUE)
                            viewtext21.setText(item.checkData.price2_1)
                            viewtext21.setTextColor(Color.parseColor("#000000"))
                            p21.addView(viewtext21)
                            L_c21.addView(checkBoxauto21)
                            viewtext21.setSelectAllOnFocus(true)
                            checkBoxauto21.setSelectAllOnFocus(true)
                            checkBoxauto21.textSize = 14f
                            checkBoxauto21.setTypeface(null, Typeface.BOLD)
                            checkBoxauto21.isSingleLine = true
                            viewtext21.isSingleLine = true
                            viewtext21.textSize = 14f
                            viewtext21.inputType = InputType.TYPE_CLASS_PHONE

                            viewtext21.addTextChangedListener(object : TextWatcher {
                                override fun beforeTextChanged(
                                    s: CharSequence?,
                                    start: Int,
                                    count: Int,
                                    after: Int
                                ) {
                                }

                                override fun onTextChanged(
                                    s: CharSequence?,
                                    start: Int,
                                    before: Int,
                                    count: Int
                                ) {
                                    val value1 = viewtext1.text.toString().toIntOrNull() ?: 0
                                    val value2 = viewtext2.text.toString().toIntOrNull() ?: 0
                                    val value3 = viewtext3.text.toString().toIntOrNull() ?: 0
                                    val value4 = viewtext4.text.toString().toIntOrNull() ?: 0
                                    val value5 = viewtext5.text.toString().toIntOrNull() ?: 0
                                    val value6 = viewtext6.text.toString().toIntOrNull() ?: 0
                                    val value7 = viewtext7.text.toString().toIntOrNull() ?: 0
                                    val value8 = viewtext8.text.toString().toIntOrNull() ?: 0
                                    val value9 = viewtext9.text.toString().toIntOrNull() ?: 0
                                    val value10 = viewtext10.text.toString().toIntOrNull() ?: 0
                                    val value11 = viewtext11.text.toString().toIntOrNull() ?: 0
                                    val value12 = viewtext12.text.toString().toIntOrNull() ?: 0
                                    val value13 = viewtext13.text.toString().toIntOrNull() ?: 0
                                    val value14 = viewtext14.text.toString().toIntOrNull() ?: 0
                                    val value15 = viewtext15.text.toString().toIntOrNull() ?: 0
                                    val value16 = viewtext16.text.toString().toIntOrNull() ?: 0
                                    val value17 = viewtext17.text.toString().toIntOrNull() ?: 0
                                    val value18 = viewtext18.text.toString().toIntOrNull() ?: 0
                                    val value19 = viewtext19.text.toString().toIntOrNull() ?: 0
                                    val value20 = viewtext20.text.toString().toIntOrNull() ?: 0
                                    val value21 = viewtext21.text.toString().toIntOrNull() ?: 0
                                    val value22 = viewtext22.text.toString().toIntOrNull() ?: 0
                                    val value23 = viewtext23.text.toString().toIntOrNull() ?: 0
                                    val value24 = viewtext24.text.toString().toIntOrNull() ?: 0
                                    val value25 = viewtext25.text.toString().toIntOrNull() ?: 0
                                    val value26 = viewtext26.text.toString().toIntOrNull() ?: 0
                                    val value27 = viewtext27.text.toString().toIntOrNull() ?: 0
                                    val value28 = viewtext28.text.toString().toIntOrNull() ?: 0
                                    val value29 = viewtext29.text.toString().toIntOrNull() ?: 0
                                    val value30 = viewtext30.text.toString().toIntOrNull() ?: 0
                                    val value31 = viewtext31.text.toString().toIntOrNull() ?: 0
                                    val value32 = viewtext32.text.toString().toIntOrNull() ?: 0
                                    val value33 = viewtext33.text.toString().toIntOrNull() ?: 0
                                    val value34 = viewtext34.text.toString().toIntOrNull() ?: 0
                                    val value35 = viewtext35.text.toString().toIntOrNull() ?: 0
                                    val value36 = viewtext36.text.toString().toIntOrNull() ?: 0
                                    val value37 = viewtext37.text.toString().toIntOrNull() ?: 0
                                    val value38 = viewtext38.text.toString().toIntOrNull() ?: 0
                                    val value39 = viewtext39.text.toString().toIntOrNull() ?: 0
                                    val value40 = viewtext40.text.toString().toIntOrNull() ?: 0
                                    val value41 = viewtext41.text.toString().toIntOrNull() ?: 0
                                    val value42 = viewtext42.text.toString().toIntOrNull() ?: 0
                                    val value43 = viewtext43.text.toString().toIntOrNull() ?: 0
                                    val value44 = viewtext44.text.toString().toIntOrNull() ?: 0
                                    val value45 = viewtext45.text.toString().toIntOrNull() ?: 0
                                    val value46 = viewtext46.text.toString().toIntOrNull() ?: 0
                                    val value47 = viewtext47.text.toString().toIntOrNull() ?: 0
                                    val value48 = viewtext48.text.toString().toIntOrNull() ?: 0
                                    val value49 = viewtext49.text.toString().toIntOrNull() ?: 0
                                    val value50 = viewtext50.text.toString().toIntOrNull() ?: 0
                                    val value51 = viewtext51.text.toString().toIntOrNull() ?: 0
                                    val value52 = viewtext52.text.toString().toIntOrNull() ?: 0
                                    val value53 = viewtext53.text.toString().toIntOrNull() ?: 0
                                    val value54 = viewtext54.text.toString().toIntOrNull() ?: 0
                                    val value55 = viewtext55.text.toString().toIntOrNull() ?: 0
                                    val value56 = viewtext56.text.toString().toIntOrNull() ?: 0
                                    val value57 = viewtext57.text.toString().toIntOrNull() ?: 0
                                    val value58 = viewtext58.text.toString().toIntOrNull() ?: 0
                                    val value59 = viewtext59.text.toString().toIntOrNull() ?: 0

                                    sum = (value1 + value2 + value3 + value4  + value5 +
                                            value6 + value7  + value8  + value9 + value10 + value11 +
                                            value12 + value13 + value14 + value15  + value16  + value17 +
                                            value18 + value19  + value20  + value21 + value22 + value23 +
                                            value24 + value25 + value26 + value27  + value28  + value29 +
                                            value30 + value31  + value32  + value33 + value34 + value35 +
                                            value36 + value37 + value38 + value39  + value40  + value41 +
                                            value42 + value43  + value44  + value45 + value46 + value47 +
                                            value48 + value49 + value50 + value51  + value52  + value53 +
                                            value54 + value55  + value56  + value57 + value58 + value59).toString()

                                    totalall_E_D.text = (sum)
                                }

                                override fun afterTextChanged(s: Editable?) {
                                }
                            })
                        }
                    }

                    if (item.checkData.check2_2.isNotEmpty()){
                        customDialogFB.apply {
                            checkBoxauto22.setText(item.checkData.check2_2)
                            checkBoxauto22.setTextColor(Color.parseColor("#000000"))
                            checkBoxauto22.layoutParams = LinearLayout.LayoutParams(
                                ViewGroup.LayoutParams.WRAP_CONTENT,
                                ViewGroup.LayoutParams.WRAP_CONTENT, Float.MIN_VALUE)
                            viewtext22.setText(item.checkData.price2_2)
                            viewtext22.setTextColor(Color.parseColor("#000000"))
                            p22.addView(viewtext22)
                            L_c22.addView(checkBoxauto22)
                            viewtext22.setSelectAllOnFocus(true)
                            checkBoxauto22.setSelectAllOnFocus(true)
                            checkBoxauto22.textSize = 14f
                            checkBoxauto22.setTypeface(null, Typeface.BOLD)
                            checkBoxauto22.isSingleLine = true
                            viewtext22.isSingleLine = true
                            viewtext22.textSize = 14f
                            viewtext22.inputType = InputType.TYPE_CLASS_PHONE

                            viewtext22.addTextChangedListener(object : TextWatcher {
                                override fun beforeTextChanged(
                                    s: CharSequence?,
                                    start: Int,
                                    count: Int,
                                    after: Int
                                ) {
                                }

                                override fun onTextChanged(
                                    s: CharSequence?,
                                    start: Int,
                                    before: Int,
                                    count: Int
                                ) {
                                    val value1 = viewtext1.text.toString().toIntOrNull() ?: 0
                                    val value2 = viewtext2.text.toString().toIntOrNull() ?: 0
                                    val value3 = viewtext3.text.toString().toIntOrNull() ?: 0
                                    val value4 = viewtext4.text.toString().toIntOrNull() ?: 0
                                    val value5 = viewtext5.text.toString().toIntOrNull() ?: 0
                                    val value6 = viewtext6.text.toString().toIntOrNull() ?: 0
                                    val value7 = viewtext7.text.toString().toIntOrNull() ?: 0
                                    val value8 = viewtext8.text.toString().toIntOrNull() ?: 0
                                    val value9 = viewtext9.text.toString().toIntOrNull() ?: 0
                                    val value10 = viewtext10.text.toString().toIntOrNull() ?: 0
                                    val value11 = viewtext11.text.toString().toIntOrNull() ?: 0
                                    val value12 = viewtext12.text.toString().toIntOrNull() ?: 0
                                    val value13 = viewtext13.text.toString().toIntOrNull() ?: 0
                                    val value14 = viewtext14.text.toString().toIntOrNull() ?: 0
                                    val value15 = viewtext15.text.toString().toIntOrNull() ?: 0
                                    val value16 = viewtext16.text.toString().toIntOrNull() ?: 0
                                    val value17 = viewtext17.text.toString().toIntOrNull() ?: 0
                                    val value18 = viewtext18.text.toString().toIntOrNull() ?: 0
                                    val value19 = viewtext19.text.toString().toIntOrNull() ?: 0
                                    val value20 = viewtext20.text.toString().toIntOrNull() ?: 0
                                    val value21 = viewtext21.text.toString().toIntOrNull() ?: 0
                                    val value22 = viewtext22.text.toString().toIntOrNull() ?: 0
                                    val value23 = viewtext23.text.toString().toIntOrNull() ?: 0
                                    val value24 = viewtext24.text.toString().toIntOrNull() ?: 0
                                    val value25 = viewtext25.text.toString().toIntOrNull() ?: 0
                                    val value26 = viewtext26.text.toString().toIntOrNull() ?: 0
                                    val value27 = viewtext27.text.toString().toIntOrNull() ?: 0
                                    val value28 = viewtext28.text.toString().toIntOrNull() ?: 0
                                    val value29 = viewtext29.text.toString().toIntOrNull() ?: 0
                                    val value30 = viewtext30.text.toString().toIntOrNull() ?: 0
                                    val value31 = viewtext31.text.toString().toIntOrNull() ?: 0
                                    val value32 = viewtext32.text.toString().toIntOrNull() ?: 0
                                    val value33 = viewtext33.text.toString().toIntOrNull() ?: 0
                                    val value34 = viewtext34.text.toString().toIntOrNull() ?: 0
                                    val value35 = viewtext35.text.toString().toIntOrNull() ?: 0
                                    val value36 = viewtext36.text.toString().toIntOrNull() ?: 0
                                    val value37 = viewtext37.text.toString().toIntOrNull() ?: 0
                                    val value38 = viewtext38.text.toString().toIntOrNull() ?: 0
                                    val value39 = viewtext39.text.toString().toIntOrNull() ?: 0
                                    val value40 = viewtext40.text.toString().toIntOrNull() ?: 0
                                    val value41 = viewtext41.text.toString().toIntOrNull() ?: 0
                                    val value42 = viewtext42.text.toString().toIntOrNull() ?: 0
                                    val value43 = viewtext43.text.toString().toIntOrNull() ?: 0
                                    val value44 = viewtext44.text.toString().toIntOrNull() ?: 0
                                    val value45 = viewtext45.text.toString().toIntOrNull() ?: 0
                                    val value46 = viewtext46.text.toString().toIntOrNull() ?: 0
                                    val value47 = viewtext47.text.toString().toIntOrNull() ?: 0
                                    val value48 = viewtext48.text.toString().toIntOrNull() ?: 0
                                    val value49 = viewtext49.text.toString().toIntOrNull() ?: 0
                                    val value50 = viewtext50.text.toString().toIntOrNull() ?: 0
                                    val value51 = viewtext51.text.toString().toIntOrNull() ?: 0
                                    val value52 = viewtext52.text.toString().toIntOrNull() ?: 0
                                    val value53 = viewtext53.text.toString().toIntOrNull() ?: 0
                                    val value54 = viewtext54.text.toString().toIntOrNull() ?: 0
                                    val value55 = viewtext55.text.toString().toIntOrNull() ?: 0
                                    val value56 = viewtext56.text.toString().toIntOrNull() ?: 0
                                    val value57 = viewtext57.text.toString().toIntOrNull() ?: 0
                                    val value58 = viewtext58.text.toString().toIntOrNull() ?: 0
                                    val value59 = viewtext59.text.toString().toIntOrNull() ?: 0

                                    sum = (value1 + value2 + value3 + value4  + value5 +
                                            value6 + value7  + value8  + value9 + value10 + value11 +
                                            value12 + value13 + value14 + value15  + value16  + value17 +
                                            value18 + value19  + value20  + value21 + value22 + value23 +
                                            value24 + value25 + value26 + value27  + value28  + value29 +
                                            value30 + value31  + value32  + value33 + value34 + value35 +
                                            value36 + value37 + value38 + value39  + value40  + value41 +
                                            value42 + value43  + value44  + value45 + value46 + value47 +
                                            value48 + value49 + value50 + value51  + value52  + value53 +
                                            value54 + value55  + value56  + value57 + value58 + value59).toString()

                                    totalall_E_D.text = (sum)
                                }

                                override fun afterTextChanged(s: Editable?) {
                                }
                            })
                        }
                    }

                    if (item.checkData.check2_3.isNotEmpty()){
                        customDialogFB.apply {
                            checkBoxauto23.setText(item.checkData.check2_3)
                            checkBoxauto23.setTextColor(Color.parseColor("#000000"))
                            checkBoxauto23.layoutParams = LinearLayout.LayoutParams(
                                ViewGroup.LayoutParams.WRAP_CONTENT,
                                ViewGroup.LayoutParams.WRAP_CONTENT, Float.MIN_VALUE)
                            viewtext23.setText(item.checkData.price2_3)
                            viewtext23.setTextColor(Color.parseColor("#000000"))
                            p23.addView(viewtext23)
                            L_c23.addView(checkBoxauto23)
                            viewtext23.setSelectAllOnFocus(true)
                            checkBoxauto23.setSelectAllOnFocus(true)
                            checkBoxauto23.textSize = 14f
                            checkBoxauto23.setTypeface(null, Typeface.BOLD)
                            checkBoxauto23.isSingleLine = true
                            viewtext23.isSingleLine = true
                            viewtext23.textSize = 14f
                            viewtext23.inputType = InputType.TYPE_CLASS_PHONE

                            viewtext23.addTextChangedListener(object : TextWatcher {
                                override fun beforeTextChanged(
                                    s: CharSequence?,
                                    start: Int,
                                    count: Int,
                                    after: Int
                                ) {
                                }

                                override fun onTextChanged(
                                    s: CharSequence?,
                                    start: Int,
                                    before: Int,
                                    count: Int
                                ) {
                                    val value1 = viewtext1.text.toString().toIntOrNull() ?: 0
                                    val value2 = viewtext2.text.toString().toIntOrNull() ?: 0
                                    val value3 = viewtext3.text.toString().toIntOrNull() ?: 0
                                    val value4 = viewtext4.text.toString().toIntOrNull() ?: 0
                                    val value5 = viewtext5.text.toString().toIntOrNull() ?: 0
                                    val value6 = viewtext6.text.toString().toIntOrNull() ?: 0
                                    val value7 = viewtext7.text.toString().toIntOrNull() ?: 0
                                    val value8 = viewtext8.text.toString().toIntOrNull() ?: 0
                                    val value9 = viewtext9.text.toString().toIntOrNull() ?: 0
                                    val value10 = viewtext10.text.toString().toIntOrNull() ?: 0
                                    val value11 = viewtext11.text.toString().toIntOrNull() ?: 0
                                    val value12 = viewtext12.text.toString().toIntOrNull() ?: 0
                                    val value13 = viewtext13.text.toString().toIntOrNull() ?: 0
                                    val value14 = viewtext14.text.toString().toIntOrNull() ?: 0
                                    val value15 = viewtext15.text.toString().toIntOrNull() ?: 0
                                    val value16 = viewtext16.text.toString().toIntOrNull() ?: 0
                                    val value17 = viewtext17.text.toString().toIntOrNull() ?: 0
                                    val value18 = viewtext18.text.toString().toIntOrNull() ?: 0
                                    val value19 = viewtext19.text.toString().toIntOrNull() ?: 0
                                    val value20 = viewtext20.text.toString().toIntOrNull() ?: 0
                                    val value21 = viewtext21.text.toString().toIntOrNull() ?: 0
                                    val value22 = viewtext22.text.toString().toIntOrNull() ?: 0
                                    val value23 = viewtext23.text.toString().toIntOrNull() ?: 0
                                    val value24 = viewtext24.text.toString().toIntOrNull() ?: 0
                                    val value25 = viewtext25.text.toString().toIntOrNull() ?: 0
                                    val value26 = viewtext26.text.toString().toIntOrNull() ?: 0
                                    val value27 = viewtext27.text.toString().toIntOrNull() ?: 0
                                    val value28 = viewtext28.text.toString().toIntOrNull() ?: 0
                                    val value29 = viewtext29.text.toString().toIntOrNull() ?: 0
                                    val value30 = viewtext30.text.toString().toIntOrNull() ?: 0
                                    val value31 = viewtext31.text.toString().toIntOrNull() ?: 0
                                    val value32 = viewtext32.text.toString().toIntOrNull() ?: 0
                                    val value33 = viewtext33.text.toString().toIntOrNull() ?: 0
                                    val value34 = viewtext34.text.toString().toIntOrNull() ?: 0
                                    val value35 = viewtext35.text.toString().toIntOrNull() ?: 0
                                    val value36 = viewtext36.text.toString().toIntOrNull() ?: 0
                                    val value37 = viewtext37.text.toString().toIntOrNull() ?: 0
                                    val value38 = viewtext38.text.toString().toIntOrNull() ?: 0
                                    val value39 = viewtext39.text.toString().toIntOrNull() ?: 0
                                    val value40 = viewtext40.text.toString().toIntOrNull() ?: 0
                                    val value41 = viewtext41.text.toString().toIntOrNull() ?: 0
                                    val value42 = viewtext42.text.toString().toIntOrNull() ?: 0
                                    val value43 = viewtext43.text.toString().toIntOrNull() ?: 0
                                    val value44 = viewtext44.text.toString().toIntOrNull() ?: 0
                                    val value45 = viewtext45.text.toString().toIntOrNull() ?: 0
                                    val value46 = viewtext46.text.toString().toIntOrNull() ?: 0
                                    val value47 = viewtext47.text.toString().toIntOrNull() ?: 0
                                    val value48 = viewtext48.text.toString().toIntOrNull() ?: 0
                                    val value49 = viewtext49.text.toString().toIntOrNull() ?: 0
                                    val value50 = viewtext50.text.toString().toIntOrNull() ?: 0
                                    val value51 = viewtext51.text.toString().toIntOrNull() ?: 0
                                    val value52 = viewtext52.text.toString().toIntOrNull() ?: 0
                                    val value53 = viewtext53.text.toString().toIntOrNull() ?: 0
                                    val value54 = viewtext54.text.toString().toIntOrNull() ?: 0
                                    val value55 = viewtext55.text.toString().toIntOrNull() ?: 0
                                    val value56 = viewtext56.text.toString().toIntOrNull() ?: 0
                                    val value57 = viewtext57.text.toString().toIntOrNull() ?: 0
                                    val value58 = viewtext58.text.toString().toIntOrNull() ?: 0
                                    val value59 = viewtext59.text.toString().toIntOrNull() ?: 0

                                    sum = (value1 + value2 + value3 + value4  + value5 +
                                            value6 + value7  + value8  + value9 + value10 + value11 +
                                            value12 + value13 + value14 + value15  + value16  + value17 +
                                            value18 + value19  + value20  + value21 + value22 + value23 +
                                            value24 + value25 + value26 + value27  + value28  + value29 +
                                            value30 + value31  + value32  + value33 + value34 + value35 +
                                            value36 + value37 + value38 + value39  + value40  + value41 +
                                            value42 + value43  + value44  + value45 + value46 + value47 +
                                            value48 + value49 + value50 + value51  + value52  + value53 +
                                            value54 + value55  + value56  + value57 + value58 + value59).toString()

                                    totalall_E_D.text = (sum)
                                }

                                override fun afterTextChanged(s: Editable?) {
                                }
                            })
                        }
                    }

                    if (item.checkData.check2_4.isNotEmpty()){
                        customDialogFB.apply {
                            checkBoxauto24.setText(item.checkData.check2_4)
                            checkBoxauto24.setTextColor(Color.parseColor("#000000"))
                            checkBoxauto24.layoutParams = LinearLayout.LayoutParams(
                                ViewGroup.LayoutParams.WRAP_CONTENT,
                                ViewGroup.LayoutParams.WRAP_CONTENT, Float.MIN_VALUE)
                            viewtext24.setText(item.checkData.price2_4)
                            viewtext24.setTextColor(Color.parseColor("#000000"))
                            p24.addView(viewtext24)
                            L_c24.addView(checkBoxauto24)
                            viewtext24.setSelectAllOnFocus(true)
                            checkBoxauto24.setSelectAllOnFocus(true)
                            checkBoxauto24.textSize = 14f
                            checkBoxauto24.setTypeface(null, Typeface.BOLD)
                            checkBoxauto24.isSingleLine = true
                            viewtext24.isSingleLine = true
                            viewtext24.textSize = 14f
                            viewtext24.inputType = InputType.TYPE_CLASS_PHONE

                            viewtext24.addTextChangedListener(object : TextWatcher {
                                override fun beforeTextChanged(
                                    s: CharSequence?,
                                    start: Int,
                                    count: Int,
                                    after: Int
                                ) {
                                }

                                override fun onTextChanged(
                                    s: CharSequence?,
                                    start: Int,
                                    before: Int,
                                    count: Int
                                ) {
                                    val value1 = viewtext1.text.toString().toIntOrNull() ?: 0
                                    val value2 = viewtext2.text.toString().toIntOrNull() ?: 0
                                    val value3 = viewtext3.text.toString().toIntOrNull() ?: 0
                                    val value4 = viewtext4.text.toString().toIntOrNull() ?: 0
                                    val value5 = viewtext5.text.toString().toIntOrNull() ?: 0
                                    val value6 = viewtext6.text.toString().toIntOrNull() ?: 0
                                    val value7 = viewtext7.text.toString().toIntOrNull() ?: 0
                                    val value8 = viewtext8.text.toString().toIntOrNull() ?: 0
                                    val value9 = viewtext9.text.toString().toIntOrNull() ?: 0
                                    val value10 = viewtext10.text.toString().toIntOrNull() ?: 0
                                    val value11 = viewtext11.text.toString().toIntOrNull() ?: 0
                                    val value12 = viewtext12.text.toString().toIntOrNull() ?: 0
                                    val value13 = viewtext13.text.toString().toIntOrNull() ?: 0
                                    val value14 = viewtext14.text.toString().toIntOrNull() ?: 0
                                    val value15 = viewtext15.text.toString().toIntOrNull() ?: 0
                                    val value16 = viewtext16.text.toString().toIntOrNull() ?: 0
                                    val value17 = viewtext17.text.toString().toIntOrNull() ?: 0
                                    val value18 = viewtext18.text.toString().toIntOrNull() ?: 0
                                    val value19 = viewtext19.text.toString().toIntOrNull() ?: 0
                                    val value20 = viewtext20.text.toString().toIntOrNull() ?: 0
                                    val value21 = viewtext21.text.toString().toIntOrNull() ?: 0
                                    val value22 = viewtext22.text.toString().toIntOrNull() ?: 0
                                    val value23 = viewtext23.text.toString().toIntOrNull() ?: 0
                                    val value24 = viewtext24.text.toString().toIntOrNull() ?: 0
                                    val value25 = viewtext25.text.toString().toIntOrNull() ?: 0
                                    val value26 = viewtext26.text.toString().toIntOrNull() ?: 0
                                    val value27 = viewtext27.text.toString().toIntOrNull() ?: 0
                                    val value28 = viewtext28.text.toString().toIntOrNull() ?: 0
                                    val value29 = viewtext29.text.toString().toIntOrNull() ?: 0
                                    val value30 = viewtext30.text.toString().toIntOrNull() ?: 0
                                    val value31 = viewtext31.text.toString().toIntOrNull() ?: 0
                                    val value32 = viewtext32.text.toString().toIntOrNull() ?: 0
                                    val value33 = viewtext33.text.toString().toIntOrNull() ?: 0
                                    val value34 = viewtext34.text.toString().toIntOrNull() ?: 0
                                    val value35 = viewtext35.text.toString().toIntOrNull() ?: 0
                                    val value36 = viewtext36.text.toString().toIntOrNull() ?: 0
                                    val value37 = viewtext37.text.toString().toIntOrNull() ?: 0
                                    val value38 = viewtext38.text.toString().toIntOrNull() ?: 0
                                    val value39 = viewtext39.text.toString().toIntOrNull() ?: 0
                                    val value40 = viewtext40.text.toString().toIntOrNull() ?: 0
                                    val value41 = viewtext41.text.toString().toIntOrNull() ?: 0
                                    val value42 = viewtext42.text.toString().toIntOrNull() ?: 0
                                    val value43 = viewtext43.text.toString().toIntOrNull() ?: 0
                                    val value44 = viewtext44.text.toString().toIntOrNull() ?: 0
                                    val value45 = viewtext45.text.toString().toIntOrNull() ?: 0
                                    val value46 = viewtext46.text.toString().toIntOrNull() ?: 0
                                    val value47 = viewtext47.text.toString().toIntOrNull() ?: 0
                                    val value48 = viewtext48.text.toString().toIntOrNull() ?: 0
                                    val value49 = viewtext49.text.toString().toIntOrNull() ?: 0
                                    val value50 = viewtext50.text.toString().toIntOrNull() ?: 0
                                    val value51 = viewtext51.text.toString().toIntOrNull() ?: 0
                                    val value52 = viewtext52.text.toString().toIntOrNull() ?: 0
                                    val value53 = viewtext53.text.toString().toIntOrNull() ?: 0
                                    val value54 = viewtext54.text.toString().toIntOrNull() ?: 0
                                    val value55 = viewtext55.text.toString().toIntOrNull() ?: 0
                                    val value56 = viewtext56.text.toString().toIntOrNull() ?: 0
                                    val value57 = viewtext57.text.toString().toIntOrNull() ?: 0
                                    val value58 = viewtext58.text.toString().toIntOrNull() ?: 0
                                    val value59 = viewtext59.text.toString().toIntOrNull() ?: 0

                                    sum = (value1 + value2 + value3 + value4  + value5 +
                                            value6 + value7  + value8  + value9 + value10 + value11 +
                                            value12 + value13 + value14 + value15  + value16  + value17 +
                                            value18 + value19  + value20  + value21 + value22 + value23 +
                                            value24 + value25 + value26 + value27  + value28  + value29 +
                                            value30 + value31  + value32  + value33 + value34 + value35 +
                                            value36 + value37 + value38 + value39  + value40  + value41 +
                                            value42 + value43  + value44  + value45 + value46 + value47 +
                                            value48 + value49 + value50 + value51  + value52  + value53 +
                                            value54 + value55  + value56  + value57 + value58 + value59).toString()

                                    totalall_E_D.text = (sum)
                                }

                                override fun afterTextChanged(s: Editable?) {
                                }
                            })
                        }
                    }

                    if (item.checkData.check2_5.isNotEmpty()){
                        customDialogFB.apply {
                            checkBoxauto25.setText(item.checkData.check2_5)
                            checkBoxauto25.setTextColor(Color.parseColor("#000000"))
                            checkBoxauto25.layoutParams = LinearLayout.LayoutParams(
                                ViewGroup.LayoutParams.WRAP_CONTENT,
                                ViewGroup.LayoutParams.WRAP_CONTENT, Float.MIN_VALUE)
                            viewtext25.setText(item.checkData.price2_5)
                            viewtext25.setTextColor(Color.parseColor("#000000"))
                            p25.addView(viewtext25)
                            L_c25.addView(checkBoxauto25)
                            viewtext25.setSelectAllOnFocus(true)
                            checkBoxauto25.setSelectAllOnFocus(true)
                            checkBoxauto25.textSize = 14f
                            checkBoxauto25.setTypeface(null, Typeface.BOLD)
                            checkBoxauto25.isSingleLine = true
                            viewtext25.isSingleLine = true
                            viewtext25.textSize = 14f
                            viewtext25.inputType = InputType.TYPE_CLASS_PHONE

                            viewtext25.addTextChangedListener(object : TextWatcher {
                                override fun beforeTextChanged(
                                    s: CharSequence?,
                                    start: Int,
                                    count: Int,
                                    after: Int
                                ) {
                                }

                                override fun onTextChanged(
                                    s: CharSequence?,
                                    start: Int,
                                    before: Int,
                                    count: Int
                                ) {
                                    val value1 = viewtext1.text.toString().toIntOrNull() ?: 0
                                    val value2 = viewtext2.text.toString().toIntOrNull() ?: 0
                                    val value3 = viewtext3.text.toString().toIntOrNull() ?: 0
                                    val value4 = viewtext4.text.toString().toIntOrNull() ?: 0
                                    val value5 = viewtext5.text.toString().toIntOrNull() ?: 0
                                    val value6 = viewtext6.text.toString().toIntOrNull() ?: 0
                                    val value7 = viewtext7.text.toString().toIntOrNull() ?: 0
                                    val value8 = viewtext8.text.toString().toIntOrNull() ?: 0
                                    val value9 = viewtext9.text.toString().toIntOrNull() ?: 0
                                    val value10 = viewtext10.text.toString().toIntOrNull() ?: 0
                                    val value11 = viewtext11.text.toString().toIntOrNull() ?: 0
                                    val value12 = viewtext12.text.toString().toIntOrNull() ?: 0
                                    val value13 = viewtext13.text.toString().toIntOrNull() ?: 0
                                    val value14 = viewtext14.text.toString().toIntOrNull() ?: 0
                                    val value15 = viewtext15.text.toString().toIntOrNull() ?: 0
                                    val value16 = viewtext16.text.toString().toIntOrNull() ?: 0
                                    val value17 = viewtext17.text.toString().toIntOrNull() ?: 0
                                    val value18 = viewtext18.text.toString().toIntOrNull() ?: 0
                                    val value19 = viewtext19.text.toString().toIntOrNull() ?: 0
                                    val value20 = viewtext20.text.toString().toIntOrNull() ?: 0
                                    val value21 = viewtext21.text.toString().toIntOrNull() ?: 0
                                    val value22 = viewtext22.text.toString().toIntOrNull() ?: 0
                                    val value23 = viewtext23.text.toString().toIntOrNull() ?: 0
                                    val value24 = viewtext24.text.toString().toIntOrNull() ?: 0
                                    val value25 = viewtext25.text.toString().toIntOrNull() ?: 0
                                    val value26 = viewtext26.text.toString().toIntOrNull() ?: 0
                                    val value27 = viewtext27.text.toString().toIntOrNull() ?: 0
                                    val value28 = viewtext28.text.toString().toIntOrNull() ?: 0
                                    val value29 = viewtext29.text.toString().toIntOrNull() ?: 0
                                    val value30 = viewtext30.text.toString().toIntOrNull() ?: 0
                                    val value31 = viewtext31.text.toString().toIntOrNull() ?: 0
                                    val value32 = viewtext32.text.toString().toIntOrNull() ?: 0
                                    val value33 = viewtext33.text.toString().toIntOrNull() ?: 0
                                    val value34 = viewtext34.text.toString().toIntOrNull() ?: 0
                                    val value35 = viewtext35.text.toString().toIntOrNull() ?: 0
                                    val value36 = viewtext36.text.toString().toIntOrNull() ?: 0
                                    val value37 = viewtext37.text.toString().toIntOrNull() ?: 0
                                    val value38 = viewtext38.text.toString().toIntOrNull() ?: 0
                                    val value39 = viewtext39.text.toString().toIntOrNull() ?: 0
                                    val value40 = viewtext40.text.toString().toIntOrNull() ?: 0
                                    val value41 = viewtext41.text.toString().toIntOrNull() ?: 0
                                    val value42 = viewtext42.text.toString().toIntOrNull() ?: 0
                                    val value43 = viewtext43.text.toString().toIntOrNull() ?: 0
                                    val value44 = viewtext44.text.toString().toIntOrNull() ?: 0
                                    val value45 = viewtext45.text.toString().toIntOrNull() ?: 0
                                    val value46 = viewtext46.text.toString().toIntOrNull() ?: 0
                                    val value47 = viewtext47.text.toString().toIntOrNull() ?: 0
                                    val value48 = viewtext48.text.toString().toIntOrNull() ?: 0
                                    val value49 = viewtext49.text.toString().toIntOrNull() ?: 0
                                    val value50 = viewtext50.text.toString().toIntOrNull() ?: 0
                                    val value51 = viewtext51.text.toString().toIntOrNull() ?: 0
                                    val value52 = viewtext52.text.toString().toIntOrNull() ?: 0
                                    val value53 = viewtext53.text.toString().toIntOrNull() ?: 0
                                    val value54 = viewtext54.text.toString().toIntOrNull() ?: 0
                                    val value55 = viewtext55.text.toString().toIntOrNull() ?: 0
                                    val value56 = viewtext56.text.toString().toIntOrNull() ?: 0
                                    val value57 = viewtext57.text.toString().toIntOrNull() ?: 0
                                    val value58 = viewtext58.text.toString().toIntOrNull() ?: 0
                                    val value59 = viewtext59.text.toString().toIntOrNull() ?: 0

                                    sum = (value1 + value2 + value3 + value4  + value5 +
                                            value6 + value7  + value8  + value9 + value10 + value11 +
                                            value12 + value13 + value14 + value15  + value16  + value17 +
                                            value18 + value19  + value20  + value21 + value22 + value23 +
                                            value24 + value25 + value26 + value27  + value28  + value29 +
                                            value30 + value31  + value32  + value33 + value34 + value35 +
                                            value36 + value37 + value38 + value39  + value40  + value41 +
                                            value42 + value43  + value44  + value45 + value46 + value47 +
                                            value48 + value49 + value50 + value51  + value52  + value53 +
                                            value54 + value55  + value56  + value57 + value58 + value59).toString()

                                    totalall_E_D.text = (sum)
                                }

                                override fun afterTextChanged(s: Editable?) {
                                }
                            })
                        }
                    }

                    if (item.checkData.check2_6.isNotEmpty()){
                        customDialogFB.apply {
                            checkBoxauto26.setText(item.checkData.check2_6)
                            checkBoxauto26.setTextColor(Color.parseColor("#000000"))
                            checkBoxauto26.layoutParams = LinearLayout.LayoutParams(
                                ViewGroup.LayoutParams.WRAP_CONTENT,
                                ViewGroup.LayoutParams.WRAP_CONTENT, Float.MIN_VALUE)
                            viewtext26.setText(item.checkData.price2_6)
                            viewtext26.setTextColor(Color.parseColor("#000000"))
                            p26.addView(viewtext26)
                            L_c26.addView(checkBoxauto26)
                            viewtext26.setSelectAllOnFocus(true)
                            checkBoxauto26.setSelectAllOnFocus(true)
                            checkBoxauto26.textSize = 14f
                            checkBoxauto26.setTypeface(null, Typeface.BOLD)
                            checkBoxauto26.isSingleLine = true
                            viewtext26.isSingleLine = true
                            viewtext26.textSize = 14f
                            viewtext26.inputType = InputType.TYPE_CLASS_PHONE

                            viewtext26.addTextChangedListener(object : TextWatcher {
                                override fun beforeTextChanged(
                                    s: CharSequence?,
                                    start: Int,
                                    count: Int,
                                    after: Int
                                ) {
                                }

                                override fun onTextChanged(
                                    s: CharSequence?,
                                    start: Int,
                                    before: Int,
                                    count: Int
                                ) {
                                    val value1 = viewtext1.text.toString().toIntOrNull() ?: 0
                                    val value2 = viewtext2.text.toString().toIntOrNull() ?: 0
                                    val value3 = viewtext3.text.toString().toIntOrNull() ?: 0
                                    val value4 = viewtext4.text.toString().toIntOrNull() ?: 0
                                    val value5 = viewtext5.text.toString().toIntOrNull() ?: 0
                                    val value6 = viewtext6.text.toString().toIntOrNull() ?: 0
                                    val value7 = viewtext7.text.toString().toIntOrNull() ?: 0
                                    val value8 = viewtext8.text.toString().toIntOrNull() ?: 0
                                    val value9 = viewtext9.text.toString().toIntOrNull() ?: 0
                                    val value10 = viewtext10.text.toString().toIntOrNull() ?: 0
                                    val value11 = viewtext11.text.toString().toIntOrNull() ?: 0
                                    val value12 = viewtext12.text.toString().toIntOrNull() ?: 0
                                    val value13 = viewtext13.text.toString().toIntOrNull() ?: 0
                                    val value14 = viewtext14.text.toString().toIntOrNull() ?: 0
                                    val value15 = viewtext15.text.toString().toIntOrNull() ?: 0
                                    val value16 = viewtext16.text.toString().toIntOrNull() ?: 0
                                    val value17 = viewtext17.text.toString().toIntOrNull() ?: 0
                                    val value18 = viewtext18.text.toString().toIntOrNull() ?: 0
                                    val value19 = viewtext19.text.toString().toIntOrNull() ?: 0
                                    val value20 = viewtext20.text.toString().toIntOrNull() ?: 0
                                    val value21 = viewtext21.text.toString().toIntOrNull() ?: 0
                                    val value22 = viewtext22.text.toString().toIntOrNull() ?: 0
                                    val value23 = viewtext23.text.toString().toIntOrNull() ?: 0
                                    val value24 = viewtext24.text.toString().toIntOrNull() ?: 0
                                    val value25 = viewtext25.text.toString().toIntOrNull() ?: 0
                                    val value26 = viewtext26.text.toString().toIntOrNull() ?: 0
                                    val value27 = viewtext27.text.toString().toIntOrNull() ?: 0
                                    val value28 = viewtext28.text.toString().toIntOrNull() ?: 0
                                    val value29 = viewtext29.text.toString().toIntOrNull() ?: 0
                                    val value30 = viewtext30.text.toString().toIntOrNull() ?: 0
                                    val value31 = viewtext31.text.toString().toIntOrNull() ?: 0
                                    val value32 = viewtext32.text.toString().toIntOrNull() ?: 0
                                    val value33 = viewtext33.text.toString().toIntOrNull() ?: 0
                                    val value34 = viewtext34.text.toString().toIntOrNull() ?: 0
                                    val value35 = viewtext35.text.toString().toIntOrNull() ?: 0
                                    val value36 = viewtext36.text.toString().toIntOrNull() ?: 0
                                    val value37 = viewtext37.text.toString().toIntOrNull() ?: 0
                                    val value38 = viewtext38.text.toString().toIntOrNull() ?: 0
                                    val value39 = viewtext39.text.toString().toIntOrNull() ?: 0
                                    val value40 = viewtext40.text.toString().toIntOrNull() ?: 0
                                    val value41 = viewtext41.text.toString().toIntOrNull() ?: 0
                                    val value42 = viewtext42.text.toString().toIntOrNull() ?: 0
                                    val value43 = viewtext43.text.toString().toIntOrNull() ?: 0
                                    val value44 = viewtext44.text.toString().toIntOrNull() ?: 0
                                    val value45 = viewtext45.text.toString().toIntOrNull() ?: 0
                                    val value46 = viewtext46.text.toString().toIntOrNull() ?: 0
                                    val value47 = viewtext47.text.toString().toIntOrNull() ?: 0
                                    val value48 = viewtext48.text.toString().toIntOrNull() ?: 0
                                    val value49 = viewtext49.text.toString().toIntOrNull() ?: 0
                                    val value50 = viewtext50.text.toString().toIntOrNull() ?: 0
                                    val value51 = viewtext51.text.toString().toIntOrNull() ?: 0
                                    val value52 = viewtext52.text.toString().toIntOrNull() ?: 0
                                    val value53 = viewtext53.text.toString().toIntOrNull() ?: 0
                                    val value54 = viewtext54.text.toString().toIntOrNull() ?: 0
                                    val value55 = viewtext55.text.toString().toIntOrNull() ?: 0
                                    val value56 = viewtext56.text.toString().toIntOrNull() ?: 0
                                    val value57 = viewtext57.text.toString().toIntOrNull() ?: 0
                                    val value58 = viewtext58.text.toString().toIntOrNull() ?: 0
                                    val value59 = viewtext59.text.toString().toIntOrNull() ?: 0

                                    sum = (value1 + value2 + value3 + value4  + value5 +
                                            value6 + value7  + value8  + value9 + value10 + value11 +
                                            value12 + value13 + value14 + value15  + value16  + value17 +
                                            value18 + value19  + value20  + value21 + value22 + value23 +
                                            value24 + value25 + value26 + value27  + value28  + value29 +
                                            value30 + value31  + value32  + value33 + value34 + value35 +
                                            value36 + value37 + value38 + value39  + value40  + value41 +
                                            value42 + value43  + value44  + value45 + value46 + value47 +
                                            value48 + value49 + value50 + value51  + value52  + value53 +
                                            value54 + value55  + value56  + value57 + value58 + value59).toString()

                                    totalall_E_D.text = (sum)
                                }

                                override fun afterTextChanged(s: Editable?) {
                                }
                            })
                        }
                    }

                    if (item.checkData.check2_7.isNotEmpty()){
                        customDialogFB.apply {
                            checkBoxauto27.setText(item.checkData.check2_7)
                            checkBoxauto27.setTextColor(Color.parseColor("#000000"))
                            checkBoxauto27.layoutParams = LinearLayout.LayoutParams(
                                ViewGroup.LayoutParams.WRAP_CONTENT,
                                ViewGroup.LayoutParams.WRAP_CONTENT, Float.MIN_VALUE)
                            viewtext27.setText(item.checkData.price2_7)
                            viewtext27.setTextColor(Color.parseColor("#000000"))
                            p27.addView(viewtext27)
                            L_c27.addView(checkBoxauto27)
                            viewtext27.setSelectAllOnFocus(true)
                            checkBoxauto27.setSelectAllOnFocus(true)
                            checkBoxauto27.textSize = 14f
                            checkBoxauto27.setTypeface(null, Typeface.BOLD)
                            checkBoxauto27.isSingleLine = true
                            viewtext27.isSingleLine = true
                            viewtext27.textSize = 14f
                            viewtext27.inputType = InputType.TYPE_CLASS_PHONE

                            viewtext27.addTextChangedListener(object : TextWatcher {
                                override fun beforeTextChanged(
                                    s: CharSequence?,
                                    start: Int,
                                    count: Int,
                                    after: Int
                                ) {
                                }

                                override fun onTextChanged(
                                    s: CharSequence?,
                                    start: Int,
                                    before: Int,
                                    count: Int
                                ) {
                                    val value1 = viewtext1.text.toString().toIntOrNull() ?: 0
                                    val value2 = viewtext2.text.toString().toIntOrNull() ?: 0
                                    val value3 = viewtext3.text.toString().toIntOrNull() ?: 0
                                    val value4 = viewtext4.text.toString().toIntOrNull() ?: 0
                                    val value5 = viewtext5.text.toString().toIntOrNull() ?: 0
                                    val value6 = viewtext6.text.toString().toIntOrNull() ?: 0
                                    val value7 = viewtext7.text.toString().toIntOrNull() ?: 0
                                    val value8 = viewtext8.text.toString().toIntOrNull() ?: 0
                                    val value9 = viewtext9.text.toString().toIntOrNull() ?: 0
                                    val value10 = viewtext10.text.toString().toIntOrNull() ?: 0
                                    val value11 = viewtext11.text.toString().toIntOrNull() ?: 0
                                    val value12 = viewtext12.text.toString().toIntOrNull() ?: 0
                                    val value13 = viewtext13.text.toString().toIntOrNull() ?: 0
                                    val value14 = viewtext14.text.toString().toIntOrNull() ?: 0
                                    val value15 = viewtext15.text.toString().toIntOrNull() ?: 0
                                    val value16 = viewtext16.text.toString().toIntOrNull() ?: 0
                                    val value17 = viewtext17.text.toString().toIntOrNull() ?: 0
                                    val value18 = viewtext18.text.toString().toIntOrNull() ?: 0
                                    val value19 = viewtext19.text.toString().toIntOrNull() ?: 0
                                    val value20 = viewtext20.text.toString().toIntOrNull() ?: 0
                                    val value21 = viewtext21.text.toString().toIntOrNull() ?: 0
                                    val value22 = viewtext22.text.toString().toIntOrNull() ?: 0
                                    val value23 = viewtext23.text.toString().toIntOrNull() ?: 0
                                    val value24 = viewtext24.text.toString().toIntOrNull() ?: 0
                                    val value25 = viewtext25.text.toString().toIntOrNull() ?: 0
                                    val value26 = viewtext26.text.toString().toIntOrNull() ?: 0
                                    val value27 = viewtext27.text.toString().toIntOrNull() ?: 0
                                    val value28 = viewtext28.text.toString().toIntOrNull() ?: 0
                                    val value29 = viewtext29.text.toString().toIntOrNull() ?: 0
                                    val value30 = viewtext30.text.toString().toIntOrNull() ?: 0
                                    val value31 = viewtext31.text.toString().toIntOrNull() ?: 0
                                    val value32 = viewtext32.text.toString().toIntOrNull() ?: 0
                                    val value33 = viewtext33.text.toString().toIntOrNull() ?: 0
                                    val value34 = viewtext34.text.toString().toIntOrNull() ?: 0
                                    val value35 = viewtext35.text.toString().toIntOrNull() ?: 0
                                    val value36 = viewtext36.text.toString().toIntOrNull() ?: 0
                                    val value37 = viewtext37.text.toString().toIntOrNull() ?: 0
                                    val value38 = viewtext38.text.toString().toIntOrNull() ?: 0
                                    val value39 = viewtext39.text.toString().toIntOrNull() ?: 0
                                    val value40 = viewtext40.text.toString().toIntOrNull() ?: 0
                                    val value41 = viewtext41.text.toString().toIntOrNull() ?: 0
                                    val value42 = viewtext42.text.toString().toIntOrNull() ?: 0
                                    val value43 = viewtext43.text.toString().toIntOrNull() ?: 0
                                    val value44 = viewtext44.text.toString().toIntOrNull() ?: 0
                                    val value45 = viewtext45.text.toString().toIntOrNull() ?: 0
                                    val value46 = viewtext46.text.toString().toIntOrNull() ?: 0
                                    val value47 = viewtext47.text.toString().toIntOrNull() ?: 0
                                    val value48 = viewtext48.text.toString().toIntOrNull() ?: 0
                                    val value49 = viewtext49.text.toString().toIntOrNull() ?: 0
                                    val value50 = viewtext50.text.toString().toIntOrNull() ?: 0
                                    val value51 = viewtext51.text.toString().toIntOrNull() ?: 0
                                    val value52 = viewtext52.text.toString().toIntOrNull() ?: 0
                                    val value53 = viewtext53.text.toString().toIntOrNull() ?: 0
                                    val value54 = viewtext54.text.toString().toIntOrNull() ?: 0
                                    val value55 = viewtext55.text.toString().toIntOrNull() ?: 0
                                    val value56 = viewtext56.text.toString().toIntOrNull() ?: 0
                                    val value57 = viewtext57.text.toString().toIntOrNull() ?: 0
                                    val value58 = viewtext58.text.toString().toIntOrNull() ?: 0
                                    val value59 = viewtext59.text.toString().toIntOrNull() ?: 0

                                    sum = (value1 + value2 + value3 + value4  + value5 +
                                            value6 + value7  + value8  + value9 + value10 + value11 +
                                            value12 + value13 + value14 + value15  + value16  + value17 +
                                            value18 + value19  + value20  + value21 + value22 + value23 +
                                            value24 + value25 + value26 + value27  + value28  + value29 +
                                            value30 + value31  + value32  + value33 + value34 + value35 +
                                            value36 + value37 + value38 + value39  + value40  + value41 +
                                            value42 + value43  + value44  + value45 + value46 + value47 +
                                            value48 + value49 + value50 + value51  + value52  + value53 +
                                            value54 + value55  + value56  + value57 + value58 + value59).toString()

                                    totalall_E_D.text = (sum)
                                }

                                override fun afterTextChanged(s: Editable?) {
                                }
                            })
                        }
                    }

                    if (item.checkData.check2_8.isNotEmpty()){
                        customDialogFB.apply {
                            checkBoxauto28.setText(item.checkData.check2_8)
                            checkBoxauto28.setTextColor(Color.parseColor("#000000"))
                            checkBoxauto28.layoutParams = LinearLayout.LayoutParams(
                                ViewGroup.LayoutParams.WRAP_CONTENT,
                                ViewGroup.LayoutParams.WRAP_CONTENT, Float.MIN_VALUE)
                            viewtext28.setText(item.checkData.price2_8)
                            viewtext28.setTextColor(Color.parseColor("#000000"))
                            p28.addView(viewtext28)
                            L_c28.addView(checkBoxauto28)
                            viewtext28.setSelectAllOnFocus(true)
                            checkBoxauto28.setSelectAllOnFocus(true)
                            checkBoxauto28.textSize = 14f
                            checkBoxauto28.setTypeface(null, Typeface.BOLD)
                            checkBoxauto28.isSingleLine = true
                            viewtext28.isSingleLine = true
                            viewtext28.textSize = 14f
                            viewtext28.inputType = InputType.TYPE_CLASS_PHONE

                            viewtext28.addTextChangedListener(object : TextWatcher {
                                override fun beforeTextChanged(
                                    s: CharSequence?,
                                    start: Int,
                                    count: Int,
                                    after: Int
                                ) {
                                }

                                override fun onTextChanged(
                                    s: CharSequence?,
                                    start: Int,
                                    before: Int,
                                    count: Int
                                ) {
                                    val value1 = viewtext1.text.toString().toIntOrNull() ?: 0
                                    val value2 = viewtext2.text.toString().toIntOrNull() ?: 0
                                    val value3 = viewtext3.text.toString().toIntOrNull() ?: 0
                                    val value4 = viewtext4.text.toString().toIntOrNull() ?: 0
                                    val value5 = viewtext5.text.toString().toIntOrNull() ?: 0
                                    val value6 = viewtext6.text.toString().toIntOrNull() ?: 0
                                    val value7 = viewtext7.text.toString().toIntOrNull() ?: 0
                                    val value8 = viewtext8.text.toString().toIntOrNull() ?: 0
                                    val value9 = viewtext9.text.toString().toIntOrNull() ?: 0
                                    val value10 = viewtext10.text.toString().toIntOrNull() ?: 0
                                    val value11 = viewtext11.text.toString().toIntOrNull() ?: 0
                                    val value12 = viewtext12.text.toString().toIntOrNull() ?: 0
                                    val value13 = viewtext13.text.toString().toIntOrNull() ?: 0
                                    val value14 = viewtext14.text.toString().toIntOrNull() ?: 0
                                    val value15 = viewtext15.text.toString().toIntOrNull() ?: 0
                                    val value16 = viewtext16.text.toString().toIntOrNull() ?: 0
                                    val value17 = viewtext17.text.toString().toIntOrNull() ?: 0
                                    val value18 = viewtext18.text.toString().toIntOrNull() ?: 0
                                    val value19 = viewtext19.text.toString().toIntOrNull() ?: 0
                                    val value20 = viewtext20.text.toString().toIntOrNull() ?: 0
                                    val value21 = viewtext21.text.toString().toIntOrNull() ?: 0
                                    val value22 = viewtext22.text.toString().toIntOrNull() ?: 0
                                    val value23 = viewtext23.text.toString().toIntOrNull() ?: 0
                                    val value24 = viewtext24.text.toString().toIntOrNull() ?: 0
                                    val value25 = viewtext25.text.toString().toIntOrNull() ?: 0
                                    val value26 = viewtext26.text.toString().toIntOrNull() ?: 0
                                    val value27 = viewtext27.text.toString().toIntOrNull() ?: 0
                                    val value28 = viewtext28.text.toString().toIntOrNull() ?: 0
                                    val value29 = viewtext29.text.toString().toIntOrNull() ?: 0
                                    val value30 = viewtext30.text.toString().toIntOrNull() ?: 0
                                    val value31 = viewtext31.text.toString().toIntOrNull() ?: 0
                                    val value32 = viewtext32.text.toString().toIntOrNull() ?: 0
                                    val value33 = viewtext33.text.toString().toIntOrNull() ?: 0
                                    val value34 = viewtext34.text.toString().toIntOrNull() ?: 0
                                    val value35 = viewtext35.text.toString().toIntOrNull() ?: 0
                                    val value36 = viewtext36.text.toString().toIntOrNull() ?: 0
                                    val value37 = viewtext37.text.toString().toIntOrNull() ?: 0
                                    val value38 = viewtext38.text.toString().toIntOrNull() ?: 0
                                    val value39 = viewtext39.text.toString().toIntOrNull() ?: 0
                                    val value40 = viewtext40.text.toString().toIntOrNull() ?: 0
                                    val value41 = viewtext41.text.toString().toIntOrNull() ?: 0
                                    val value42 = viewtext42.text.toString().toIntOrNull() ?: 0
                                    val value43 = viewtext43.text.toString().toIntOrNull() ?: 0
                                    val value44 = viewtext44.text.toString().toIntOrNull() ?: 0
                                    val value45 = viewtext45.text.toString().toIntOrNull() ?: 0
                                    val value46 = viewtext46.text.toString().toIntOrNull() ?: 0
                                    val value47 = viewtext47.text.toString().toIntOrNull() ?: 0
                                    val value48 = viewtext48.text.toString().toIntOrNull() ?: 0
                                    val value49 = viewtext49.text.toString().toIntOrNull() ?: 0
                                    val value50 = viewtext50.text.toString().toIntOrNull() ?: 0
                                    val value51 = viewtext51.text.toString().toIntOrNull() ?: 0
                                    val value52 = viewtext52.text.toString().toIntOrNull() ?: 0
                                    val value53 = viewtext53.text.toString().toIntOrNull() ?: 0
                                    val value54 = viewtext54.text.toString().toIntOrNull() ?: 0
                                    val value55 = viewtext55.text.toString().toIntOrNull() ?: 0
                                    val value56 = viewtext56.text.toString().toIntOrNull() ?: 0
                                    val value57 = viewtext57.text.toString().toIntOrNull() ?: 0
                                    val value58 = viewtext58.text.toString().toIntOrNull() ?: 0
                                    val value59 = viewtext59.text.toString().toIntOrNull() ?: 0

                                    sum = (value1 + value2 + value3 + value4  + value5 +
                                            value6 + value7  + value8  + value9 + value10 + value11 +
                                            value12 + value13 + value14 + value15  + value16  + value17 +
                                            value18 + value19  + value20  + value21 + value22 + value23 +
                                            value24 + value25 + value26 + value27  + value28  + value29 +
                                            value30 + value31  + value32  + value33 + value34 + value35 +
                                            value36 + value37 + value38 + value39  + value40  + value41 +
                                            value42 + value43  + value44  + value45 + value46 + value47 +
                                            value48 + value49 + value50 + value51  + value52  + value53 +
                                            value54 + value55  + value56  + value57 + value58 + value59).toString()

                                    totalall_E_D.text = (sum)
                                }

                                override fun afterTextChanged(s: Editable?) {
                                }
                            })
                        }
                    }

                    if (item.checkData.check2_9.isNotEmpty()){
                        customDialogFB.apply {
                            checkBoxauto29.setText(item.checkData.check2_9)
                            checkBoxauto29.setTextColor(Color.parseColor("#000000"))
                            checkBoxauto29.layoutParams = LinearLayout.LayoutParams(
                                ViewGroup.LayoutParams.WRAP_CONTENT,
                                ViewGroup.LayoutParams.WRAP_CONTENT, Float.MIN_VALUE)
                            viewtext29.setText(item.checkData.price2_9)
                            viewtext29.setTextColor(Color.parseColor("#000000"))
                            p29.addView(viewtext29)
                            L_c29.addView(checkBoxauto29)
                            viewtext29.setSelectAllOnFocus(true)
                            checkBoxauto29.setSelectAllOnFocus(true)
                            checkBoxauto29.textSize = 14f
                            checkBoxauto29.setTypeface(null, Typeface.BOLD)
                            checkBoxauto29.isSingleLine = true
                            viewtext29.isSingleLine = true
                            viewtext29.textSize = 14f
                            viewtext29.inputType = InputType.TYPE_CLASS_PHONE

                            viewtext29.addTextChangedListener(object : TextWatcher {
                                override fun beforeTextChanged(
                                    s: CharSequence?,
                                    start: Int,
                                    count: Int,
                                    after: Int
                                ) {
                                }

                                override fun onTextChanged(
                                    s: CharSequence?,
                                    start: Int,
                                    before: Int,
                                    count: Int
                                ) {
                                    val value1 = viewtext1.text.toString().toIntOrNull() ?: 0
                                    val value2 = viewtext2.text.toString().toIntOrNull() ?: 0
                                    val value3 = viewtext3.text.toString().toIntOrNull() ?: 0
                                    val value4 = viewtext4.text.toString().toIntOrNull() ?: 0
                                    val value5 = viewtext5.text.toString().toIntOrNull() ?: 0
                                    val value6 = viewtext6.text.toString().toIntOrNull() ?: 0
                                    val value7 = viewtext7.text.toString().toIntOrNull() ?: 0
                                    val value8 = viewtext8.text.toString().toIntOrNull() ?: 0
                                    val value9 = viewtext9.text.toString().toIntOrNull() ?: 0
                                    val value10 = viewtext10.text.toString().toIntOrNull() ?: 0
                                    val value11 = viewtext11.text.toString().toIntOrNull() ?: 0
                                    val value12 = viewtext12.text.toString().toIntOrNull() ?: 0
                                    val value13 = viewtext13.text.toString().toIntOrNull() ?: 0
                                    val value14 = viewtext14.text.toString().toIntOrNull() ?: 0
                                    val value15 = viewtext15.text.toString().toIntOrNull() ?: 0
                                    val value16 = viewtext16.text.toString().toIntOrNull() ?: 0
                                    val value17 = viewtext17.text.toString().toIntOrNull() ?: 0
                                    val value18 = viewtext18.text.toString().toIntOrNull() ?: 0
                                    val value19 = viewtext19.text.toString().toIntOrNull() ?: 0
                                    val value20 = viewtext20.text.toString().toIntOrNull() ?: 0
                                    val value21 = viewtext21.text.toString().toIntOrNull() ?: 0
                                    val value22 = viewtext22.text.toString().toIntOrNull() ?: 0
                                    val value23 = viewtext23.text.toString().toIntOrNull() ?: 0
                                    val value24 = viewtext24.text.toString().toIntOrNull() ?: 0
                                    val value25 = viewtext25.text.toString().toIntOrNull() ?: 0
                                    val value26 = viewtext26.text.toString().toIntOrNull() ?: 0
                                    val value27 = viewtext27.text.toString().toIntOrNull() ?: 0
                                    val value28 = viewtext28.text.toString().toIntOrNull() ?: 0
                                    val value29 = viewtext29.text.toString().toIntOrNull() ?: 0
                                    val value30 = viewtext30.text.toString().toIntOrNull() ?: 0
                                    val value31 = viewtext31.text.toString().toIntOrNull() ?: 0
                                    val value32 = viewtext32.text.toString().toIntOrNull() ?: 0
                                    val value33 = viewtext33.text.toString().toIntOrNull() ?: 0
                                    val value34 = viewtext34.text.toString().toIntOrNull() ?: 0
                                    val value35 = viewtext35.text.toString().toIntOrNull() ?: 0
                                    val value36 = viewtext36.text.toString().toIntOrNull() ?: 0
                                    val value37 = viewtext37.text.toString().toIntOrNull() ?: 0
                                    val value38 = viewtext38.text.toString().toIntOrNull() ?: 0
                                    val value39 = viewtext39.text.toString().toIntOrNull() ?: 0
                                    val value40 = viewtext40.text.toString().toIntOrNull() ?: 0
                                    val value41 = viewtext41.text.toString().toIntOrNull() ?: 0
                                    val value42 = viewtext42.text.toString().toIntOrNull() ?: 0
                                    val value43 = viewtext43.text.toString().toIntOrNull() ?: 0
                                    val value44 = viewtext44.text.toString().toIntOrNull() ?: 0
                                    val value45 = viewtext45.text.toString().toIntOrNull() ?: 0
                                    val value46 = viewtext46.text.toString().toIntOrNull() ?: 0
                                    val value47 = viewtext47.text.toString().toIntOrNull() ?: 0
                                    val value48 = viewtext48.text.toString().toIntOrNull() ?: 0
                                    val value49 = viewtext49.text.toString().toIntOrNull() ?: 0
                                    val value50 = viewtext50.text.toString().toIntOrNull() ?: 0
                                    val value51 = viewtext51.text.toString().toIntOrNull() ?: 0
                                    val value52 = viewtext52.text.toString().toIntOrNull() ?: 0
                                    val value53 = viewtext53.text.toString().toIntOrNull() ?: 0
                                    val value54 = viewtext54.text.toString().toIntOrNull() ?: 0
                                    val value55 = viewtext55.text.toString().toIntOrNull() ?: 0
                                    val value56 = viewtext56.text.toString().toIntOrNull() ?: 0
                                    val value57 = viewtext57.text.toString().toIntOrNull() ?: 0
                                    val value58 = viewtext58.text.toString().toIntOrNull() ?: 0
                                    val value59 = viewtext59.text.toString().toIntOrNull() ?: 0

                                    sum = (value1 + value2 + value3 + value4  + value5 +
                                            value6 + value7  + value8  + value9 + value10 + value11 +
                                            value12 + value13 + value14 + value15  + value16  + value17 +
                                            value18 + value19  + value20  + value21 + value22 + value23 +
                                            value24 + value25 + value26 + value27  + value28  + value29 +
                                            value30 + value31  + value32  + value33 + value34 + value35 +
                                            value36 + value37 + value38 + value39  + value40  + value41 +
                                            value42 + value43  + value44  + value45 + value46 + value47 +
                                            value48 + value49 + value50 + value51  + value52  + value53 +
                                            value54 + value55  + value56  + value57 + value58 + value59).toString()

                                    totalall_E_D.text = (sum)
                                }

                                override fun afterTextChanged(s: Editable?) {
                                }
                            })
                        }
                    }

                    if (item.checkData.check2_10.isNotEmpty()){
                        customDialogFB.apply {
                            checkBoxauto30.setText(item.checkData.check2_10)
                            checkBoxauto30.setTextColor(Color.parseColor("#000000"))
                            checkBoxauto30.layoutParams = LinearLayout.LayoutParams(
                                ViewGroup.LayoutParams.WRAP_CONTENT,
                                ViewGroup.LayoutParams.WRAP_CONTENT, Float.MIN_VALUE)
                            viewtext30.setText(item.checkData.price2_10)
                            viewtext30.setTextColor(Color.parseColor("#000000"))
                            p30.addView(viewtext30)
                            L_c30.addView(checkBoxauto30)
                            viewtext30.setSelectAllOnFocus(true)
                            checkBoxauto30.setSelectAllOnFocus(true)
                            checkBoxauto30.textSize = 14f
                            checkBoxauto30.setTypeface(null, Typeface.BOLD)
                            checkBoxauto30.isSingleLine = true
                            viewtext30.isSingleLine = true
                            viewtext30.textSize = 14f
                            viewtext30.inputType = InputType.TYPE_CLASS_PHONE

                            viewtext30.addTextChangedListener(object : TextWatcher {
                                override fun beforeTextChanged(
                                    s: CharSequence?,
                                    start: Int,
                                    count: Int,
                                    after: Int
                                ) {
                                }

                                override fun onTextChanged(
                                    s: CharSequence?,
                                    start: Int,
                                    before: Int,
                                    count: Int
                                ) {
                                    val value1 = viewtext1.text.toString().toIntOrNull() ?: 0
                                    val value2 = viewtext2.text.toString().toIntOrNull() ?: 0
                                    val value3 = viewtext3.text.toString().toIntOrNull() ?: 0
                                    val value4 = viewtext4.text.toString().toIntOrNull() ?: 0
                                    val value5 = viewtext5.text.toString().toIntOrNull() ?: 0
                                    val value6 = viewtext6.text.toString().toIntOrNull() ?: 0
                                    val value7 = viewtext7.text.toString().toIntOrNull() ?: 0
                                    val value8 = viewtext8.text.toString().toIntOrNull() ?: 0
                                    val value9 = viewtext9.text.toString().toIntOrNull() ?: 0
                                    val value10 = viewtext10.text.toString().toIntOrNull() ?: 0
                                    val value11 = viewtext11.text.toString().toIntOrNull() ?: 0
                                    val value12 = viewtext12.text.toString().toIntOrNull() ?: 0
                                    val value13 = viewtext13.text.toString().toIntOrNull() ?: 0
                                    val value14 = viewtext14.text.toString().toIntOrNull() ?: 0
                                    val value15 = viewtext15.text.toString().toIntOrNull() ?: 0
                                    val value16 = viewtext16.text.toString().toIntOrNull() ?: 0
                                    val value17 = viewtext17.text.toString().toIntOrNull() ?: 0
                                    val value18 = viewtext18.text.toString().toIntOrNull() ?: 0
                                    val value19 = viewtext19.text.toString().toIntOrNull() ?: 0
                                    val value20 = viewtext20.text.toString().toIntOrNull() ?: 0
                                    val value21 = viewtext21.text.toString().toIntOrNull() ?: 0
                                    val value22 = viewtext22.text.toString().toIntOrNull() ?: 0
                                    val value23 = viewtext23.text.toString().toIntOrNull() ?: 0
                                    val value24 = viewtext24.text.toString().toIntOrNull() ?: 0
                                    val value25 = viewtext25.text.toString().toIntOrNull() ?: 0
                                    val value26 = viewtext26.text.toString().toIntOrNull() ?: 0
                                    val value27 = viewtext27.text.toString().toIntOrNull() ?: 0
                                    val value28 = viewtext28.text.toString().toIntOrNull() ?: 0
                                    val value29 = viewtext29.text.toString().toIntOrNull() ?: 0
                                    val value30 = viewtext30.text.toString().toIntOrNull() ?: 0
                                    val value31 = viewtext31.text.toString().toIntOrNull() ?: 0
                                    val value32 = viewtext32.text.toString().toIntOrNull() ?: 0
                                    val value33 = viewtext33.text.toString().toIntOrNull() ?: 0
                                    val value34 = viewtext34.text.toString().toIntOrNull() ?: 0
                                    val value35 = viewtext35.text.toString().toIntOrNull() ?: 0
                                    val value36 = viewtext36.text.toString().toIntOrNull() ?: 0
                                    val value37 = viewtext37.text.toString().toIntOrNull() ?: 0
                                    val value38 = viewtext38.text.toString().toIntOrNull() ?: 0
                                    val value39 = viewtext39.text.toString().toIntOrNull() ?: 0
                                    val value40 = viewtext40.text.toString().toIntOrNull() ?: 0
                                    val value41 = viewtext41.text.toString().toIntOrNull() ?: 0
                                    val value42 = viewtext42.text.toString().toIntOrNull() ?: 0
                                    val value43 = viewtext43.text.toString().toIntOrNull() ?: 0
                                    val value44 = viewtext44.text.toString().toIntOrNull() ?: 0
                                    val value45 = viewtext45.text.toString().toIntOrNull() ?: 0
                                    val value46 = viewtext46.text.toString().toIntOrNull() ?: 0
                                    val value47 = viewtext47.text.toString().toIntOrNull() ?: 0
                                    val value48 = viewtext48.text.toString().toIntOrNull() ?: 0
                                    val value49 = viewtext49.text.toString().toIntOrNull() ?: 0
                                    val value50 = viewtext50.text.toString().toIntOrNull() ?: 0
                                    val value51 = viewtext51.text.toString().toIntOrNull() ?: 0
                                    val value52 = viewtext52.text.toString().toIntOrNull() ?: 0
                                    val value53 = viewtext53.text.toString().toIntOrNull() ?: 0
                                    val value54 = viewtext54.text.toString().toIntOrNull() ?: 0
                                    val value55 = viewtext55.text.toString().toIntOrNull() ?: 0
                                    val value56 = viewtext56.text.toString().toIntOrNull() ?: 0
                                    val value57 = viewtext57.text.toString().toIntOrNull() ?: 0
                                    val value58 = viewtext58.text.toString().toIntOrNull() ?: 0
                                    val value59 = viewtext59.text.toString().toIntOrNull() ?: 0

                                    sum = (value1 + value2 + value3 + value4  + value5 +
                                            value6 + value7  + value8  + value9 + value10 + value11 +
                                            value12 + value13 + value14 + value15  + value16  + value17 +
                                            value18 + value19  + value20  + value21 + value22 + value23 +
                                            value24 + value25 + value26 + value27  + value28  + value29 +
                                            value30 + value31  + value32  + value33 + value34 + value35 +
                                            value36 + value37 + value38 + value39  + value40  + value41 +
                                            value42 + value43  + value44  + value45 + value46 + value47 +
                                            value48 + value49 + value50 + value51  + value52  + value53 +
                                            value54 + value55  + value56  + value57 + value58 + value59).toString()

                                    totalall_E_D.text = (sum)
                                }

                                override fun afterTextChanged(s: Editable?) {
                                }
                            })
                        }
                    }

                    if (item.checkData.check2_11.isNotEmpty()){
                        customDialogFB.apply {
                            checkBoxauto31.setText(item.checkData.check2_11)
                            checkBoxauto31.setTextColor(Color.parseColor("#000000"))
                            checkBoxauto31.layoutParams = LinearLayout.LayoutParams(
                                ViewGroup.LayoutParams.WRAP_CONTENT,
                                ViewGroup.LayoutParams.WRAP_CONTENT, Float.MIN_VALUE)
                            viewtext31.setText(item.checkData.price2_11)
                            viewtext31.setTextColor(Color.parseColor("#000000"))
                            p31.addView(viewtext31)
                            L_c31.addView(checkBoxauto31)
                            viewtext31.setSelectAllOnFocus(true)
                            checkBoxauto31.setSelectAllOnFocus(true)
                            checkBoxauto31.textSize = 14f
                            checkBoxauto31.setTypeface(null, Typeface.BOLD)
                            checkBoxauto31.isSingleLine = true
                            viewtext31.isSingleLine = true
                            viewtext31.textSize = 14f
                            viewtext31.inputType = InputType.TYPE_CLASS_PHONE

                            viewtext31.addTextChangedListener(object : TextWatcher {
                                override fun beforeTextChanged(
                                    s: CharSequence?,
                                    start: Int,
                                    count: Int,
                                    after: Int
                                ) {
                                }

                                override fun onTextChanged(
                                    s: CharSequence?,
                                    start: Int,
                                    before: Int,
                                    count: Int
                                ) {
                                    val value1 = viewtext1.text.toString().toIntOrNull() ?: 0
                                    val value2 = viewtext2.text.toString().toIntOrNull() ?: 0
                                    val value3 = viewtext3.text.toString().toIntOrNull() ?: 0
                                    val value4 = viewtext4.text.toString().toIntOrNull() ?: 0
                                    val value5 = viewtext5.text.toString().toIntOrNull() ?: 0
                                    val value6 = viewtext6.text.toString().toIntOrNull() ?: 0
                                    val value7 = viewtext7.text.toString().toIntOrNull() ?: 0
                                    val value8 = viewtext8.text.toString().toIntOrNull() ?: 0
                                    val value9 = viewtext9.text.toString().toIntOrNull() ?: 0
                                    val value10 = viewtext10.text.toString().toIntOrNull() ?: 0
                                    val value11 = viewtext11.text.toString().toIntOrNull() ?: 0
                                    val value12 = viewtext12.text.toString().toIntOrNull() ?: 0
                                    val value13 = viewtext13.text.toString().toIntOrNull() ?: 0
                                    val value14 = viewtext14.text.toString().toIntOrNull() ?: 0
                                    val value15 = viewtext15.text.toString().toIntOrNull() ?: 0
                                    val value16 = viewtext16.text.toString().toIntOrNull() ?: 0
                                    val value17 = viewtext17.text.toString().toIntOrNull() ?: 0
                                    val value18 = viewtext18.text.toString().toIntOrNull() ?: 0
                                    val value19 = viewtext19.text.toString().toIntOrNull() ?: 0
                                    val value20 = viewtext20.text.toString().toIntOrNull() ?: 0
                                    val value21 = viewtext21.text.toString().toIntOrNull() ?: 0
                                    val value22 = viewtext22.text.toString().toIntOrNull() ?: 0
                                    val value23 = viewtext23.text.toString().toIntOrNull() ?: 0
                                    val value24 = viewtext24.text.toString().toIntOrNull() ?: 0
                                    val value25 = viewtext25.text.toString().toIntOrNull() ?: 0
                                    val value26 = viewtext26.text.toString().toIntOrNull() ?: 0
                                    val value27 = viewtext27.text.toString().toIntOrNull() ?: 0
                                    val value28 = viewtext28.text.toString().toIntOrNull() ?: 0
                                    val value29 = viewtext29.text.toString().toIntOrNull() ?: 0
                                    val value30 = viewtext30.text.toString().toIntOrNull() ?: 0
                                    val value31 = viewtext31.text.toString().toIntOrNull() ?: 0
                                    val value32 = viewtext32.text.toString().toIntOrNull() ?: 0
                                    val value33 = viewtext33.text.toString().toIntOrNull() ?: 0
                                    val value34 = viewtext34.text.toString().toIntOrNull() ?: 0
                                    val value35 = viewtext35.text.toString().toIntOrNull() ?: 0
                                    val value36 = viewtext36.text.toString().toIntOrNull() ?: 0
                                    val value37 = viewtext37.text.toString().toIntOrNull() ?: 0
                                    val value38 = viewtext38.text.toString().toIntOrNull() ?: 0
                                    val value39 = viewtext39.text.toString().toIntOrNull() ?: 0
                                    val value40 = viewtext40.text.toString().toIntOrNull() ?: 0
                                    val value41 = viewtext41.text.toString().toIntOrNull() ?: 0
                                    val value42 = viewtext42.text.toString().toIntOrNull() ?: 0
                                    val value43 = viewtext43.text.toString().toIntOrNull() ?: 0
                                    val value44 = viewtext44.text.toString().toIntOrNull() ?: 0
                                    val value45 = viewtext45.text.toString().toIntOrNull() ?: 0
                                    val value46 = viewtext46.text.toString().toIntOrNull() ?: 0
                                    val value47 = viewtext47.text.toString().toIntOrNull() ?: 0
                                    val value48 = viewtext48.text.toString().toIntOrNull() ?: 0
                                    val value49 = viewtext49.text.toString().toIntOrNull() ?: 0
                                    val value50 = viewtext50.text.toString().toIntOrNull() ?: 0
                                    val value51 = viewtext51.text.toString().toIntOrNull() ?: 0
                                    val value52 = viewtext52.text.toString().toIntOrNull() ?: 0
                                    val value53 = viewtext53.text.toString().toIntOrNull() ?: 0
                                    val value54 = viewtext54.text.toString().toIntOrNull() ?: 0
                                    val value55 = viewtext55.text.toString().toIntOrNull() ?: 0
                                    val value56 = viewtext56.text.toString().toIntOrNull() ?: 0
                                    val value57 = viewtext57.text.toString().toIntOrNull() ?: 0
                                    val value58 = viewtext58.text.toString().toIntOrNull() ?: 0
                                    val value59 = viewtext59.text.toString().toIntOrNull() ?: 0

                                    sum = (value1 + value2 + value3 + value4  + value5 +
                                            value6 + value7  + value8  + value9 + value10 + value11 +
                                            value12 + value13 + value14 + value15  + value16  + value17 +
                                            value18 + value19  + value20  + value21 + value22 + value23 +
                                            value24 + value25 + value26 + value27  + value28  + value29 +
                                            value30 + value31  + value32  + value33 + value34 + value35 +
                                            value36 + value37 + value38 + value39  + value40  + value41 +
                                            value42 + value43  + value44  + value45 + value46 + value47 +
                                            value48 + value49 + value50 + value51  + value52  + value53 +
                                            value54 + value55  + value56  + value57 + value58 + value59).toString()

                                    totalall_E_D.text = (sum)
                                }

                                override fun afterTextChanged(s: Editable?) {
                                }
                            })
                        }
                    }

                    if (item.checkData.check2_12.isNotEmpty()){
                        customDialogFB.apply {
                            checkBoxauto32.setText(item.checkData.check2_12)
                            checkBoxauto32.setTextColor(Color.parseColor("#000000"))
                            checkBoxauto32.layoutParams = LinearLayout.LayoutParams(
                                ViewGroup.LayoutParams.WRAP_CONTENT,
                                ViewGroup.LayoutParams.WRAP_CONTENT, Float.MIN_VALUE)
                            viewtext32.setText(item.checkData.price2_12)
                            viewtext32.setTextColor(Color.parseColor("#000000"))
                            p32.addView(viewtext32)
                            L_c32.addView(checkBoxauto32)
                            viewtext32.setSelectAllOnFocus(true)
                            checkBoxauto32.setSelectAllOnFocus(true)
                            checkBoxauto32.textSize = 14f
                            checkBoxauto32.setTypeface(null, Typeface.BOLD)
                            checkBoxauto32.isSingleLine = true
                            checkBoxauto32.isSingleLine = true
                            viewtext32.textSize = 14f
                            viewtext32.inputType = InputType.TYPE_CLASS_PHONE

                            viewtext32.addTextChangedListener(object : TextWatcher {
                                override fun beforeTextChanged(
                                    s: CharSequence?,
                                    start: Int,
                                    count: Int,
                                    after: Int
                                ) {
                                }

                                override fun onTextChanged(
                                    s: CharSequence?,
                                    start: Int,
                                    before: Int,
                                    count: Int
                                ) {
                                    val value1 = viewtext1.text.toString().toIntOrNull() ?: 0
                                    val value2 = viewtext2.text.toString().toIntOrNull() ?: 0
                                    val value3 = viewtext3.text.toString().toIntOrNull() ?: 0
                                    val value4 = viewtext4.text.toString().toIntOrNull() ?: 0
                                    val value5 = viewtext5.text.toString().toIntOrNull() ?: 0
                                    val value6 = viewtext6.text.toString().toIntOrNull() ?: 0
                                    val value7 = viewtext7.text.toString().toIntOrNull() ?: 0
                                    val value8 = viewtext8.text.toString().toIntOrNull() ?: 0
                                    val value9 = viewtext9.text.toString().toIntOrNull() ?: 0
                                    val value10 = viewtext10.text.toString().toIntOrNull() ?: 0
                                    val value11 = viewtext11.text.toString().toIntOrNull() ?: 0
                                    val value12 = viewtext12.text.toString().toIntOrNull() ?: 0
                                    val value13 = viewtext13.text.toString().toIntOrNull() ?: 0
                                    val value14 = viewtext14.text.toString().toIntOrNull() ?: 0
                                    val value15 = viewtext15.text.toString().toIntOrNull() ?: 0
                                    val value16 = viewtext16.text.toString().toIntOrNull() ?: 0
                                    val value17 = viewtext17.text.toString().toIntOrNull() ?: 0
                                    val value18 = viewtext18.text.toString().toIntOrNull() ?: 0
                                    val value19 = viewtext19.text.toString().toIntOrNull() ?: 0
                                    val value20 = viewtext20.text.toString().toIntOrNull() ?: 0
                                    val value21 = viewtext21.text.toString().toIntOrNull() ?: 0
                                    val value22 = viewtext22.text.toString().toIntOrNull() ?: 0
                                    val value23 = viewtext23.text.toString().toIntOrNull() ?: 0
                                    val value24 = viewtext24.text.toString().toIntOrNull() ?: 0
                                    val value25 = viewtext25.text.toString().toIntOrNull() ?: 0
                                    val value26 = viewtext26.text.toString().toIntOrNull() ?: 0
                                    val value27 = viewtext27.text.toString().toIntOrNull() ?: 0
                                    val value28 = viewtext28.text.toString().toIntOrNull() ?: 0
                                    val value29 = viewtext29.text.toString().toIntOrNull() ?: 0
                                    val value30 = viewtext30.text.toString().toIntOrNull() ?: 0
                                    val value31 = viewtext31.text.toString().toIntOrNull() ?: 0
                                    val value32 = viewtext32.text.toString().toIntOrNull() ?: 0
                                    val value33 = viewtext33.text.toString().toIntOrNull() ?: 0
                                    val value34 = viewtext34.text.toString().toIntOrNull() ?: 0
                                    val value35 = viewtext35.text.toString().toIntOrNull() ?: 0
                                    val value36 = viewtext36.text.toString().toIntOrNull() ?: 0
                                    val value37 = viewtext37.text.toString().toIntOrNull() ?: 0
                                    val value38 = viewtext38.text.toString().toIntOrNull() ?: 0
                                    val value39 = viewtext39.text.toString().toIntOrNull() ?: 0
                                    val value40 = viewtext40.text.toString().toIntOrNull() ?: 0
                                    val value41 = viewtext41.text.toString().toIntOrNull() ?: 0
                                    val value42 = viewtext42.text.toString().toIntOrNull() ?: 0
                                    val value43 = viewtext43.text.toString().toIntOrNull() ?: 0
                                    val value44 = viewtext44.text.toString().toIntOrNull() ?: 0
                                    val value45 = viewtext45.text.toString().toIntOrNull() ?: 0
                                    val value46 = viewtext46.text.toString().toIntOrNull() ?: 0
                                    val value47 = viewtext47.text.toString().toIntOrNull() ?: 0
                                    val value48 = viewtext48.text.toString().toIntOrNull() ?: 0
                                    val value49 = viewtext49.text.toString().toIntOrNull() ?: 0
                                    val value50 = viewtext50.text.toString().toIntOrNull() ?: 0
                                    val value51 = viewtext51.text.toString().toIntOrNull() ?: 0
                                    val value52 = viewtext52.text.toString().toIntOrNull() ?: 0
                                    val value53 = viewtext53.text.toString().toIntOrNull() ?: 0
                                    val value54 = viewtext54.text.toString().toIntOrNull() ?: 0
                                    val value55 = viewtext55.text.toString().toIntOrNull() ?: 0
                                    val value56 = viewtext56.text.toString().toIntOrNull() ?: 0
                                    val value57 = viewtext57.text.toString().toIntOrNull() ?: 0
                                    val value58 = viewtext58.text.toString().toIntOrNull() ?: 0
                                    val value59 = viewtext59.text.toString().toIntOrNull() ?: 0

                                    sum = (value1 + value2 + value3 + value4  + value5 +
                                            value6 + value7  + value8  + value9 + value10 + value11 +
                                            value12 + value13 + value14 + value15  + value16  + value17 +
                                            value18 + value19  + value20  + value21 + value22 + value23 +
                                            value24 + value25 + value26 + value27  + value28  + value29 +
                                            value30 + value31  + value32  + value33 + value34 + value35 +
                                            value36 + value37 + value38 + value39  + value40  + value41 +
                                            value42 + value43  + value44  + value45 + value46 + value47 +
                                            value48 + value49 + value50 + value51  + value52  + value53 +
                                            value54 + value55  + value56  + value57 + value58 + value59).toString()

                                    totalall_E_D.text = (sum)
                                }

                                override fun afterTextChanged(s: Editable?) {
                                }
                            })
                        }
                    }

                    if (item.checkData.check2_13.isNotEmpty()){
                        customDialogFB.apply {
                            checkBoxauto33.setText(item.checkData.check2_13)
                            checkBoxauto33.setTextColor(Color.parseColor("#000000"))
                            checkBoxauto33.layoutParams = LinearLayout.LayoutParams(
                                ViewGroup.LayoutParams.WRAP_CONTENT,
                                ViewGroup.LayoutParams.WRAP_CONTENT, Float.MIN_VALUE)
                            viewtext33.setText(item.checkData.price2_13)
                            viewtext33.setTextColor(Color.parseColor("#000000"))
                            p33.addView(viewtext33)
                            L_c33.addView(checkBoxauto33)
                            viewtext33.setSelectAllOnFocus(true)
                            checkBoxauto33.setSelectAllOnFocus(true)
                            checkBoxauto33.textSize = 14f
                            checkBoxauto33.setTypeface(null, Typeface.BOLD)
                            checkBoxauto33.isSingleLine = true
                            viewtext33.isSingleLine = true
                            viewtext33.textSize = 14f
                            viewtext33.inputType = InputType.TYPE_CLASS_PHONE

                            viewtext33.addTextChangedListener(object : TextWatcher {
                                override fun beforeTextChanged(
                                    s: CharSequence?,
                                    start: Int,
                                    count: Int,
                                    after: Int
                                ) {
                                }

                                override fun onTextChanged(
                                    s: CharSequence?,
                                    start: Int,
                                    before: Int,
                                    count: Int
                                ) {
                                    val value1 = viewtext1.text.toString().toIntOrNull() ?: 0
                                    val value2 = viewtext2.text.toString().toIntOrNull() ?: 0
                                    val value3 = viewtext3.text.toString().toIntOrNull() ?: 0
                                    val value4 = viewtext4.text.toString().toIntOrNull() ?: 0
                                    val value5 = viewtext5.text.toString().toIntOrNull() ?: 0
                                    val value6 = viewtext6.text.toString().toIntOrNull() ?: 0
                                    val value7 = viewtext7.text.toString().toIntOrNull() ?: 0
                                    val value8 = viewtext8.text.toString().toIntOrNull() ?: 0
                                    val value9 = viewtext9.text.toString().toIntOrNull() ?: 0
                                    val value10 = viewtext10.text.toString().toIntOrNull() ?: 0
                                    val value11 = viewtext11.text.toString().toIntOrNull() ?: 0
                                    val value12 = viewtext12.text.toString().toIntOrNull() ?: 0
                                    val value13 = viewtext13.text.toString().toIntOrNull() ?: 0
                                    val value14 = viewtext14.text.toString().toIntOrNull() ?: 0
                                    val value15 = viewtext15.text.toString().toIntOrNull() ?: 0
                                    val value16 = viewtext16.text.toString().toIntOrNull() ?: 0
                                    val value17 = viewtext17.text.toString().toIntOrNull() ?: 0
                                    val value18 = viewtext18.text.toString().toIntOrNull() ?: 0
                                    val value19 = viewtext19.text.toString().toIntOrNull() ?: 0
                                    val value20 = viewtext20.text.toString().toIntOrNull() ?: 0
                                    val value21 = viewtext21.text.toString().toIntOrNull() ?: 0
                                    val value22 = viewtext22.text.toString().toIntOrNull() ?: 0
                                    val value23 = viewtext23.text.toString().toIntOrNull() ?: 0
                                    val value24 = viewtext24.text.toString().toIntOrNull() ?: 0
                                    val value25 = viewtext25.text.toString().toIntOrNull() ?: 0
                                    val value26 = viewtext26.text.toString().toIntOrNull() ?: 0
                                    val value27 = viewtext27.text.toString().toIntOrNull() ?: 0
                                    val value28 = viewtext28.text.toString().toIntOrNull() ?: 0
                                    val value29 = viewtext29.text.toString().toIntOrNull() ?: 0
                                    val value30 = viewtext30.text.toString().toIntOrNull() ?: 0
                                    val value31 = viewtext31.text.toString().toIntOrNull() ?: 0
                                    val value32 = viewtext32.text.toString().toIntOrNull() ?: 0
                                    val value33 = viewtext33.text.toString().toIntOrNull() ?: 0
                                    val value34 = viewtext34.text.toString().toIntOrNull() ?: 0
                                    val value35 = viewtext35.text.toString().toIntOrNull() ?: 0
                                    val value36 = viewtext36.text.toString().toIntOrNull() ?: 0
                                    val value37 = viewtext37.text.toString().toIntOrNull() ?: 0
                                    val value38 = viewtext38.text.toString().toIntOrNull() ?: 0
                                    val value39 = viewtext39.text.toString().toIntOrNull() ?: 0
                                    val value40 = viewtext40.text.toString().toIntOrNull() ?: 0
                                    val value41 = viewtext41.text.toString().toIntOrNull() ?: 0
                                    val value42 = viewtext42.text.toString().toIntOrNull() ?: 0
                                    val value43 = viewtext43.text.toString().toIntOrNull() ?: 0
                                    val value44 = viewtext44.text.toString().toIntOrNull() ?: 0
                                    val value45 = viewtext45.text.toString().toIntOrNull() ?: 0
                                    val value46 = viewtext46.text.toString().toIntOrNull() ?: 0
                                    val value47 = viewtext47.text.toString().toIntOrNull() ?: 0
                                    val value48 = viewtext48.text.toString().toIntOrNull() ?: 0
                                    val value49 = viewtext49.text.toString().toIntOrNull() ?: 0
                                    val value50 = viewtext50.text.toString().toIntOrNull() ?: 0
                                    val value51 = viewtext51.text.toString().toIntOrNull() ?: 0
                                    val value52 = viewtext52.text.toString().toIntOrNull() ?: 0
                                    val value53 = viewtext53.text.toString().toIntOrNull() ?: 0
                                    val value54 = viewtext54.text.toString().toIntOrNull() ?: 0
                                    val value55 = viewtext55.text.toString().toIntOrNull() ?: 0
                                    val value56 = viewtext56.text.toString().toIntOrNull() ?: 0
                                    val value57 = viewtext57.text.toString().toIntOrNull() ?: 0
                                    val value58 = viewtext58.text.toString().toIntOrNull() ?: 0
                                    val value59 = viewtext59.text.toString().toIntOrNull() ?: 0

                                    sum = (value1 + value2 + value3 + value4  + value5 +
                                            value6 + value7  + value8  + value9 + value10 + value11 +
                                            value12 + value13 + value14 + value15  + value16  + value17 +
                                            value18 + value19  + value20  + value21 + value22 + value23 +
                                            value24 + value25 + value26 + value27  + value28  + value29 +
                                            value30 + value31  + value32  + value33 + value34 + value35 +
                                            value36 + value37 + value38 + value39  + value40  + value41 +
                                            value42 + value43  + value44  + value45 + value46 + value47 +
                                            value48 + value49 + value50 + value51  + value52  + value53 +
                                            value54 + value55  + value56  + value57 + value58 + value59).toString()

                                    totalall_E_D.text = (sum)
                                }

                                override fun afterTextChanged(s: Editable?) {
                                }
                            })
                        }
                    }

                    if (item.checkData.check2_14.isNotEmpty()){
                        customDialogFB.apply {
                            checkBoxauto34.setText(item.checkData.check2_14)
                            checkBoxauto34.setTextColor(Color.parseColor("#000000"))
                            checkBoxauto34.layoutParams = LinearLayout.LayoutParams(
                                ViewGroup.LayoutParams.WRAP_CONTENT,
                                ViewGroup.LayoutParams.WRAP_CONTENT, Float.MIN_VALUE)
                            viewtext34.setText(item.checkData.price2_14)
                            viewtext34.setTextColor(Color.parseColor("#000000"))
                            p34.addView(viewtext34)
                            L_c34.addView(checkBoxauto34)
                            viewtext34.setSelectAllOnFocus(true)
                            checkBoxauto34.setSelectAllOnFocus(true)
                            checkBoxauto34.textSize = 14f
                            checkBoxauto34.setTypeface(null, Typeface.BOLD)
                            checkBoxauto34.isSingleLine = true
                            viewtext34.isSingleLine = true
                            viewtext34.textSize = 14f
                            viewtext34.inputType = InputType.TYPE_CLASS_PHONE

                            viewtext34.addTextChangedListener(object : TextWatcher {
                                override fun beforeTextChanged(
                                    s: CharSequence?,
                                    start: Int,
                                    count: Int,
                                    after: Int
                                ) {
                                }

                                override fun onTextChanged(
                                    s: CharSequence?,
                                    start: Int,
                                    before: Int,
                                    count: Int
                                ) {
                                    val value1 = viewtext1.text.toString().toIntOrNull() ?: 0
                                    val value2 = viewtext2.text.toString().toIntOrNull() ?: 0
                                    val value3 = viewtext3.text.toString().toIntOrNull() ?: 0
                                    val value4 = viewtext4.text.toString().toIntOrNull() ?: 0
                                    val value5 = viewtext5.text.toString().toIntOrNull() ?: 0
                                    val value6 = viewtext6.text.toString().toIntOrNull() ?: 0
                                    val value7 = viewtext7.text.toString().toIntOrNull() ?: 0
                                    val value8 = viewtext8.text.toString().toIntOrNull() ?: 0
                                    val value9 = viewtext9.text.toString().toIntOrNull() ?: 0
                                    val value10 = viewtext10.text.toString().toIntOrNull() ?: 0
                                    val value11 = viewtext11.text.toString().toIntOrNull() ?: 0
                                    val value12 = viewtext12.text.toString().toIntOrNull() ?: 0
                                    val value13 = viewtext13.text.toString().toIntOrNull() ?: 0
                                    val value14 = viewtext14.text.toString().toIntOrNull() ?: 0
                                    val value15 = viewtext15.text.toString().toIntOrNull() ?: 0
                                    val value16 = viewtext16.text.toString().toIntOrNull() ?: 0
                                    val value17 = viewtext17.text.toString().toIntOrNull() ?: 0
                                    val value18 = viewtext18.text.toString().toIntOrNull() ?: 0
                                    val value19 = viewtext19.text.toString().toIntOrNull() ?: 0
                                    val value20 = viewtext20.text.toString().toIntOrNull() ?: 0
                                    val value21 = viewtext21.text.toString().toIntOrNull() ?: 0
                                    val value22 = viewtext22.text.toString().toIntOrNull() ?: 0
                                    val value23 = viewtext23.text.toString().toIntOrNull() ?: 0
                                    val value24 = viewtext24.text.toString().toIntOrNull() ?: 0
                                    val value25 = viewtext25.text.toString().toIntOrNull() ?: 0
                                    val value26 = viewtext26.text.toString().toIntOrNull() ?: 0
                                    val value27 = viewtext27.text.toString().toIntOrNull() ?: 0
                                    val value28 = viewtext28.text.toString().toIntOrNull() ?: 0
                                    val value29 = viewtext29.text.toString().toIntOrNull() ?: 0
                                    val value30 = viewtext30.text.toString().toIntOrNull() ?: 0
                                    val value31 = viewtext31.text.toString().toIntOrNull() ?: 0
                                    val value32 = viewtext32.text.toString().toIntOrNull() ?: 0
                                    val value33 = viewtext33.text.toString().toIntOrNull() ?: 0
                                    val value34 = viewtext34.text.toString().toIntOrNull() ?: 0
                                    val value35 = viewtext35.text.toString().toIntOrNull() ?: 0
                                    val value36 = viewtext36.text.toString().toIntOrNull() ?: 0
                                    val value37 = viewtext37.text.toString().toIntOrNull() ?: 0
                                    val value38 = viewtext38.text.toString().toIntOrNull() ?: 0
                                    val value39 = viewtext39.text.toString().toIntOrNull() ?: 0
                                    val value40 = viewtext40.text.toString().toIntOrNull() ?: 0
                                    val value41 = viewtext41.text.toString().toIntOrNull() ?: 0
                                    val value42 = viewtext42.text.toString().toIntOrNull() ?: 0
                                    val value43 = viewtext43.text.toString().toIntOrNull() ?: 0
                                    val value44 = viewtext44.text.toString().toIntOrNull() ?: 0
                                    val value45 = viewtext45.text.toString().toIntOrNull() ?: 0
                                    val value46 = viewtext46.text.toString().toIntOrNull() ?: 0
                                    val value47 = viewtext47.text.toString().toIntOrNull() ?: 0
                                    val value48 = viewtext48.text.toString().toIntOrNull() ?: 0
                                    val value49 = viewtext49.text.toString().toIntOrNull() ?: 0
                                    val value50 = viewtext50.text.toString().toIntOrNull() ?: 0
                                    val value51 = viewtext51.text.toString().toIntOrNull() ?: 0
                                    val value52 = viewtext52.text.toString().toIntOrNull() ?: 0
                                    val value53 = viewtext53.text.toString().toIntOrNull() ?: 0
                                    val value54 = viewtext54.text.toString().toIntOrNull() ?: 0
                                    val value55 = viewtext55.text.toString().toIntOrNull() ?: 0
                                    val value56 = viewtext56.text.toString().toIntOrNull() ?: 0
                                    val value57 = viewtext57.text.toString().toIntOrNull() ?: 0
                                    val value58 = viewtext58.text.toString().toIntOrNull() ?: 0
                                    val value59 = viewtext59.text.toString().toIntOrNull() ?: 0

                                    sum = (value1 + value2 + value3 + value4  + value5 +
                                            value6 + value7  + value8  + value9 + value10 + value11 +
                                            value12 + value13 + value14 + value15  + value16  + value17 +
                                            value18 + value19  + value20  + value21 + value22 + value23 +
                                            value24 + value25 + value26 + value27  + value28  + value29 +
                                            value30 + value31  + value32  + value33 + value34 + value35 +
                                            value36 + value37 + value38 + value39  + value40  + value41 +
                                            value42 + value43  + value44  + value45 + value46 + value47 +
                                            value48 + value49 + value50 + value51  + value52  + value53 +
                                            value54 + value55  + value56  + value57 + value58 + value59).toString()

                                    totalall_E_D.text = (sum)
                                }

                                override fun afterTextChanged(s: Editable?) {
                                }
                            })
                        }
                    }

                    if (item.checkData.check2_15.isNotEmpty()){
                        customDialogFB.apply {
                            checkBoxauto35.setText(item.checkData.check2_15)
                            checkBoxauto35.setTextColor(Color.parseColor("#000000"))
                            checkBoxauto35.layoutParams = LinearLayout.LayoutParams(
                                ViewGroup.LayoutParams.WRAP_CONTENT,
                                ViewGroup.LayoutParams.WRAP_CONTENT, Float.MIN_VALUE)
                            viewtext35.setText(item.checkData.price2_15)
                            viewtext35.setTextColor(Color.parseColor("#000000"))
                            p35.addView(viewtext35)
                            L_c35.addView(checkBoxauto35)
                            viewtext35.setSelectAllOnFocus(true)
                            checkBoxauto35.setSelectAllOnFocus(true)
                            checkBoxauto35.textSize = 14f
                            checkBoxauto35.setTypeface(null, Typeface.BOLD)
                            checkBoxauto35.isSingleLine = true
                            viewtext35.isSingleLine = true
                            viewtext35.textSize = 14f
                            viewtext35.inputType = InputType.TYPE_CLASS_PHONE

                            viewtext35.addTextChangedListener(object : TextWatcher {
                                override fun beforeTextChanged(
                                    s: CharSequence?,
                                    start: Int,
                                    count: Int,
                                    after: Int
                                ) {
                                }

                                override fun onTextChanged(
                                    s: CharSequence?,
                                    start: Int,
                                    before: Int,
                                    count: Int
                                ) {
                                    val value1 = viewtext1.text.toString().toIntOrNull() ?: 0
                                    val value2 = viewtext2.text.toString().toIntOrNull() ?: 0
                                    val value3 = viewtext3.text.toString().toIntOrNull() ?: 0
                                    val value4 = viewtext4.text.toString().toIntOrNull() ?: 0
                                    val value5 = viewtext5.text.toString().toIntOrNull() ?: 0
                                    val value6 = viewtext6.text.toString().toIntOrNull() ?: 0
                                    val value7 = viewtext7.text.toString().toIntOrNull() ?: 0
                                    val value8 = viewtext8.text.toString().toIntOrNull() ?: 0
                                    val value9 = viewtext9.text.toString().toIntOrNull() ?: 0
                                    val value10 = viewtext10.text.toString().toIntOrNull() ?: 0
                                    val value11 = viewtext11.text.toString().toIntOrNull() ?: 0
                                    val value12 = viewtext12.text.toString().toIntOrNull() ?: 0
                                    val value13 = viewtext13.text.toString().toIntOrNull() ?: 0
                                    val value14 = viewtext14.text.toString().toIntOrNull() ?: 0
                                    val value15 = viewtext15.text.toString().toIntOrNull() ?: 0
                                    val value16 = viewtext16.text.toString().toIntOrNull() ?: 0
                                    val value17 = viewtext17.text.toString().toIntOrNull() ?: 0
                                    val value18 = viewtext18.text.toString().toIntOrNull() ?: 0
                                    val value19 = viewtext19.text.toString().toIntOrNull() ?: 0
                                    val value20 = viewtext20.text.toString().toIntOrNull() ?: 0
                                    val value21 = viewtext21.text.toString().toIntOrNull() ?: 0
                                    val value22 = viewtext22.text.toString().toIntOrNull() ?: 0
                                    val value23 = viewtext23.text.toString().toIntOrNull() ?: 0
                                    val value24 = viewtext24.text.toString().toIntOrNull() ?: 0
                                    val value25 = viewtext25.text.toString().toIntOrNull() ?: 0
                                    val value26 = viewtext26.text.toString().toIntOrNull() ?: 0
                                    val value27 = viewtext27.text.toString().toIntOrNull() ?: 0
                                    val value28 = viewtext28.text.toString().toIntOrNull() ?: 0
                                    val value29 = viewtext29.text.toString().toIntOrNull() ?: 0
                                    val value30 = viewtext30.text.toString().toIntOrNull() ?: 0
                                    val value31 = viewtext31.text.toString().toIntOrNull() ?: 0
                                    val value32 = viewtext32.text.toString().toIntOrNull() ?: 0
                                    val value33 = viewtext33.text.toString().toIntOrNull() ?: 0
                                    val value34 = viewtext34.text.toString().toIntOrNull() ?: 0
                                    val value35 = viewtext35.text.toString().toIntOrNull() ?: 0
                                    val value36 = viewtext36.text.toString().toIntOrNull() ?: 0
                                    val value37 = viewtext37.text.toString().toIntOrNull() ?: 0
                                    val value38 = viewtext38.text.toString().toIntOrNull() ?: 0
                                    val value39 = viewtext39.text.toString().toIntOrNull() ?: 0
                                    val value40 = viewtext40.text.toString().toIntOrNull() ?: 0
                                    val value41 = viewtext41.text.toString().toIntOrNull() ?: 0
                                    val value42 = viewtext42.text.toString().toIntOrNull() ?: 0
                                    val value43 = viewtext43.text.toString().toIntOrNull() ?: 0
                                    val value44 = viewtext44.text.toString().toIntOrNull() ?: 0
                                    val value45 = viewtext45.text.toString().toIntOrNull() ?: 0
                                    val value46 = viewtext46.text.toString().toIntOrNull() ?: 0
                                    val value47 = viewtext47.text.toString().toIntOrNull() ?: 0
                                    val value48 = viewtext48.text.toString().toIntOrNull() ?: 0
                                    val value49 = viewtext49.text.toString().toIntOrNull() ?: 0
                                    val value50 = viewtext50.text.toString().toIntOrNull() ?: 0
                                    val value51 = viewtext51.text.toString().toIntOrNull() ?: 0
                                    val value52 = viewtext52.text.toString().toIntOrNull() ?: 0
                                    val value53 = viewtext53.text.toString().toIntOrNull() ?: 0
                                    val value54 = viewtext54.text.toString().toIntOrNull() ?: 0
                                    val value55 = viewtext55.text.toString().toIntOrNull() ?: 0
                                    val value56 = viewtext56.text.toString().toIntOrNull() ?: 0
                                    val value57 = viewtext57.text.toString().toIntOrNull() ?: 0
                                    val value58 = viewtext58.text.toString().toIntOrNull() ?: 0
                                    val value59 = viewtext59.text.toString().toIntOrNull() ?: 0

                                    sum = (value1 + value2 + value3 + value4 + value5 +
                                            value6 + value7 + value8 + value9 + value10 + value11 +
                                            value12 + value13 + value14 + value15 + value16 + value17 +
                                            value18 + value19 + value20 + value21 + value22 + value23 +
                                            value24 + value25 + value26 + value27 + value28 + value29 +
                                            value30 + value31 + value32 + value33 + value34 + value35 +
                                            value36 + value37 + value38 + value39 + value40 + value41 +
                                            value42 + value43 + value44 + value45 + value46 + value47 +
                                            value48 + value49 + value50 + value51 + value52 + value53 +
                                            value54 + value55 + value56 + value57 + value58 + value59).toString()

                                    totalall_E_D.text = (sum)
                                }

                                override fun afterTextChanged(s: Editable?) {
                                }
                            })
                        }
                    }

                    if (item.checkData.check2_16.isNotEmpty()){
                        customDialogFB.apply {
                            checkBoxauto36.setText(item.checkData.check2_16)
                            checkBoxauto36.setTextColor(Color.parseColor("#000000"))
                            checkBoxauto36.layoutParams = LinearLayout.LayoutParams(
                                ViewGroup.LayoutParams.WRAP_CONTENT,
                                ViewGroup.LayoutParams.WRAP_CONTENT, Float.MIN_VALUE)
                            viewtext36.setText(item.checkData.price2_16)
                            viewtext36.setTextColor(Color.parseColor("#000000"))
                            p36.addView(viewtext36)
                            L_c36.addView(checkBoxauto36)
                            viewtext36.setSelectAllOnFocus(true)
                            checkBoxauto36.setSelectAllOnFocus(true)
                            checkBoxauto36.textSize = 14f
                            checkBoxauto36.setTypeface(null, Typeface.BOLD)
                            checkBoxauto36.isSingleLine = true
                            viewtext36.isSingleLine = true
                            viewtext36.textSize = 14f
                            viewtext36.inputType = InputType.TYPE_CLASS_PHONE

                            viewtext36.addTextChangedListener(object : TextWatcher {
                                override fun beforeTextChanged(
                                    s: CharSequence?,
                                    start: Int,
                                    count: Int,
                                    after: Int
                                ) {
                                }

                                override fun onTextChanged(
                                    s: CharSequence?,
                                    start: Int,
                                    before: Int,
                                    count: Int
                                ) {
                                    val value1 = viewtext1.text.toString().toIntOrNull() ?: 0
                                    val value2 = viewtext2.text.toString().toIntOrNull() ?: 0
                                    val value3 = viewtext3.text.toString().toIntOrNull() ?: 0
                                    val value4 = viewtext4.text.toString().toIntOrNull() ?: 0
                                    val value5 = viewtext5.text.toString().toIntOrNull() ?: 0
                                    val value6 = viewtext6.text.toString().toIntOrNull() ?: 0
                                    val value7 = viewtext7.text.toString().toIntOrNull() ?: 0
                                    val value8 = viewtext8.text.toString().toIntOrNull() ?: 0
                                    val value9 = viewtext9.text.toString().toIntOrNull() ?: 0
                                    val value10 = viewtext10.text.toString().toIntOrNull() ?: 0
                                    val value11 = viewtext11.text.toString().toIntOrNull() ?: 0
                                    val value12 = viewtext12.text.toString().toIntOrNull() ?: 0
                                    val value13 = viewtext13.text.toString().toIntOrNull() ?: 0
                                    val value14 = viewtext14.text.toString().toIntOrNull() ?: 0
                                    val value15 = viewtext15.text.toString().toIntOrNull() ?: 0
                                    val value16 = viewtext16.text.toString().toIntOrNull() ?: 0
                                    val value17 = viewtext17.text.toString().toIntOrNull() ?: 0
                                    val value18 = viewtext18.text.toString().toIntOrNull() ?: 0
                                    val value19 = viewtext19.text.toString().toIntOrNull() ?: 0
                                    val value20 = viewtext20.text.toString().toIntOrNull() ?: 0
                                    val value21 = viewtext21.text.toString().toIntOrNull() ?: 0
                                    val value22 = viewtext22.text.toString().toIntOrNull() ?: 0
                                    val value23 = viewtext23.text.toString().toIntOrNull() ?: 0
                                    val value24 = viewtext24.text.toString().toIntOrNull() ?: 0
                                    val value25 = viewtext25.text.toString().toIntOrNull() ?: 0
                                    val value26 = viewtext26.text.toString().toIntOrNull() ?: 0
                                    val value27 = viewtext27.text.toString().toIntOrNull() ?: 0
                                    val value28 = viewtext28.text.toString().toIntOrNull() ?: 0
                                    val value29 = viewtext29.text.toString().toIntOrNull() ?: 0
                                    val value30 = viewtext30.text.toString().toIntOrNull() ?: 0
                                    val value31 = viewtext31.text.toString().toIntOrNull() ?: 0
                                    val value32 = viewtext32.text.toString().toIntOrNull() ?: 0
                                    val value33 = viewtext33.text.toString().toIntOrNull() ?: 0
                                    val value34 = viewtext34.text.toString().toIntOrNull() ?: 0
                                    val value35 = viewtext35.text.toString().toIntOrNull() ?: 0
                                    val value36 = viewtext36.text.toString().toIntOrNull() ?: 0
                                    val value37 = viewtext37.text.toString().toIntOrNull() ?: 0
                                    val value38 = viewtext38.text.toString().toIntOrNull() ?: 0
                                    val value39 = viewtext39.text.toString().toIntOrNull() ?: 0
                                    val value40 = viewtext40.text.toString().toIntOrNull() ?: 0
                                    val value41 = viewtext41.text.toString().toIntOrNull() ?: 0
                                    val value42 = viewtext42.text.toString().toIntOrNull() ?: 0
                                    val value43 = viewtext43.text.toString().toIntOrNull() ?: 0
                                    val value44 = viewtext44.text.toString().toIntOrNull() ?: 0
                                    val value45 = viewtext45.text.toString().toIntOrNull() ?: 0
                                    val value46 = viewtext46.text.toString().toIntOrNull() ?: 0
                                    val value47 = viewtext47.text.toString().toIntOrNull() ?: 0
                                    val value48 = viewtext48.text.toString().toIntOrNull() ?: 0
                                    val value49 = viewtext49.text.toString().toIntOrNull() ?: 0
                                    val value50 = viewtext50.text.toString().toIntOrNull() ?: 0
                                    val value51 = viewtext51.text.toString().toIntOrNull() ?: 0
                                    val value52 = viewtext52.text.toString().toIntOrNull() ?: 0
                                    val value53 = viewtext53.text.toString().toIntOrNull() ?: 0
                                    val value54 = viewtext54.text.toString().toIntOrNull() ?: 0
                                    val value55 = viewtext55.text.toString().toIntOrNull() ?: 0
                                    val value56 = viewtext56.text.toString().toIntOrNull() ?: 0
                                    val value57 = viewtext57.text.toString().toIntOrNull() ?: 0
                                    val value58 = viewtext58.text.toString().toIntOrNull() ?: 0
                                    val value59 = viewtext59.text.toString().toIntOrNull() ?: 0

                                    sum = (value1 + value2 + value3 + value4  + value5 +
                                            value6 + value7  + value8  + value9 + value10 + value11 +
                                            value12 + value13 + value14 + value15  + value16  + value17 +
                                            value18 + value19  + value20  + value21 + value22 + value23 +
                                            value24 + value25 + value26 + value27  + value28  + value29 +
                                            value30 + value31  + value32  + value33 + value34 + value35 +
                                            value36 + value37 + value38 + value39  + value40  + value41 +
                                            value42 + value43  + value44  + value45 + value46 + value47 +
                                            value48 + value49 + value50 + value51  + value52  + value53 +
                                            value54 + value55  + value56  + value57 + value58 + value59).toString()

                                    totalall_E_D.text = (sum)
                                }

                                override fun afterTextChanged(s: Editable?) {
                                }
                            })
                        }
                    }

                    if (item.checkData.check2_17.isNotEmpty()){
                        customDialogFB.apply {
                            checkBoxauto37.setText(item.checkData.check2_17)
                            checkBoxauto37.setTextColor(Color.parseColor("#000000"))
                            checkBoxauto37.layoutParams = LinearLayout.LayoutParams(
                                ViewGroup.LayoutParams.WRAP_CONTENT,
                                ViewGroup.LayoutParams.WRAP_CONTENT, Float.MIN_VALUE)
                            viewtext37.setText(item.checkData.price2_17)
                            viewtext37.setTextColor(Color.parseColor("#000000"))
                            p37.addView(viewtext37)
                            L_c37.addView(checkBoxauto37)
                            viewtext37.setSelectAllOnFocus(true)
                            checkBoxauto37.setSelectAllOnFocus(true)
                            checkBoxauto37.textSize = 14f
                            checkBoxauto37.setTypeface(null, Typeface.BOLD)
                            checkBoxauto37.isSingleLine = true
                            viewtext37.isSingleLine = true
                            viewtext37.textSize = 14f
                            viewtext37.inputType = InputType.TYPE_CLASS_PHONE

                            viewtext37.addTextChangedListener(object : TextWatcher {
                                override fun beforeTextChanged(
                                    s: CharSequence?,
                                    start: Int,
                                    count: Int,
                                    after: Int
                                ) {
                                }

                                override fun onTextChanged(
                                    s: CharSequence?,
                                    start: Int,
                                    before: Int,
                                    count: Int
                                ) {
                                    val value1 = viewtext1.text.toString().toIntOrNull() ?: 0
                                    val value2 = viewtext2.text.toString().toIntOrNull() ?: 0
                                    val value3 = viewtext3.text.toString().toIntOrNull() ?: 0
                                    val value4 = viewtext4.text.toString().toIntOrNull() ?: 0
                                    val value5 = viewtext5.text.toString().toIntOrNull() ?: 0
                                    val value6 = viewtext6.text.toString().toIntOrNull() ?: 0
                                    val value7 = viewtext7.text.toString().toIntOrNull() ?: 0
                                    val value8 = viewtext8.text.toString().toIntOrNull() ?: 0
                                    val value9 = viewtext9.text.toString().toIntOrNull() ?: 0
                                    val value10 = viewtext10.text.toString().toIntOrNull() ?: 0
                                    val value11 = viewtext11.text.toString().toIntOrNull() ?: 0
                                    val value12 = viewtext12.text.toString().toIntOrNull() ?: 0
                                    val value13 = viewtext13.text.toString().toIntOrNull() ?: 0
                                    val value14 = viewtext14.text.toString().toIntOrNull() ?: 0
                                    val value15 = viewtext15.text.toString().toIntOrNull() ?: 0
                                    val value16 = viewtext16.text.toString().toIntOrNull() ?: 0
                                    val value17 = viewtext17.text.toString().toIntOrNull() ?: 0
                                    val value18 = viewtext18.text.toString().toIntOrNull() ?: 0
                                    val value19 = viewtext19.text.toString().toIntOrNull() ?: 0
                                    val value20 = viewtext20.text.toString().toIntOrNull() ?: 0
                                    val value21 = viewtext21.text.toString().toIntOrNull() ?: 0
                                    val value22 = viewtext22.text.toString().toIntOrNull() ?: 0
                                    val value23 = viewtext23.text.toString().toIntOrNull() ?: 0
                                    val value24 = viewtext24.text.toString().toIntOrNull() ?: 0
                                    val value25 = viewtext25.text.toString().toIntOrNull() ?: 0
                                    val value26 = viewtext26.text.toString().toIntOrNull() ?: 0
                                    val value27 = viewtext27.text.toString().toIntOrNull() ?: 0
                                    val value28 = viewtext28.text.toString().toIntOrNull() ?: 0
                                    val value29 = viewtext29.text.toString().toIntOrNull() ?: 0
                                    val value30 = viewtext30.text.toString().toIntOrNull() ?: 0
                                    val value31 = viewtext31.text.toString().toIntOrNull() ?: 0
                                    val value32 = viewtext32.text.toString().toIntOrNull() ?: 0
                                    val value33 = viewtext33.text.toString().toIntOrNull() ?: 0
                                    val value34 = viewtext34.text.toString().toIntOrNull() ?: 0
                                    val value35 = viewtext35.text.toString().toIntOrNull() ?: 0
                                    val value36 = viewtext36.text.toString().toIntOrNull() ?: 0
                                    val value37 = viewtext37.text.toString().toIntOrNull() ?: 0
                                    val value38 = viewtext38.text.toString().toIntOrNull() ?: 0
                                    val value39 = viewtext39.text.toString().toIntOrNull() ?: 0
                                    val value40 = viewtext40.text.toString().toIntOrNull() ?: 0
                                    val value41 = viewtext41.text.toString().toIntOrNull() ?: 0
                                    val value42 = viewtext42.text.toString().toIntOrNull() ?: 0
                                    val value43 = viewtext43.text.toString().toIntOrNull() ?: 0
                                    val value44 = viewtext44.text.toString().toIntOrNull() ?: 0
                                    val value45 = viewtext45.text.toString().toIntOrNull() ?: 0
                                    val value46 = viewtext46.text.toString().toIntOrNull() ?: 0
                                    val value47 = viewtext47.text.toString().toIntOrNull() ?: 0
                                    val value48 = viewtext48.text.toString().toIntOrNull() ?: 0
                                    val value49 = viewtext49.text.toString().toIntOrNull() ?: 0
                                    val value50 = viewtext50.text.toString().toIntOrNull() ?: 0
                                    val value51 = viewtext51.text.toString().toIntOrNull() ?: 0
                                    val value52 = viewtext52.text.toString().toIntOrNull() ?: 0
                                    val value53 = viewtext53.text.toString().toIntOrNull() ?: 0
                                    val value54 = viewtext54.text.toString().toIntOrNull() ?: 0
                                    val value55 = viewtext55.text.toString().toIntOrNull() ?: 0
                                    val value56 = viewtext56.text.toString().toIntOrNull() ?: 0
                                    val value57 = viewtext57.text.toString().toIntOrNull() ?: 0
                                    val value58 = viewtext58.text.toString().toIntOrNull() ?: 0
                                    val value59 = viewtext59.text.toString().toIntOrNull() ?: 0

                                    sum = (value1 + value2 + value3 + value4  + value5 +
                                            value6 + value7  + value8  + value9 + value10 + value11 +
                                            value12 + value13 + value14 + value15  + value16  + value17 +
                                            value18 + value19  + value20  + value21 + value22 + value23 +
                                            value24 + value25 + value26 + value27  + value28  + value29 +
                                            value30 + value31  + value32  + value33 + value34 + value35 +
                                            value36 + value37 + value38 + value39  + value40  + value41 +
                                            value42 + value43  + value44  + value45 + value46 + value47 +
                                            value48 + value49 + value50 + value51  + value52  + value53 +
                                            value54 + value55  + value56  + value57 + value58 + value59).toString()

                                    totalall_E_D.text = (sum)
                                }

                                override fun afterTextChanged(s: Editable?) {
                                }
                            })
                        }
                    }

                    if (item.checkData.check2_18.isNotEmpty()){
                        customDialogFB.apply {
                            checkBoxauto38.setText(item.checkData.check2_18)
                            checkBoxauto38.setTextColor(Color.parseColor("#000000"))
                            checkBoxauto38.layoutParams = LinearLayout.LayoutParams(
                                ViewGroup.LayoutParams.WRAP_CONTENT,
                                ViewGroup.LayoutParams.WRAP_CONTENT, Float.MIN_VALUE)
                            viewtext38.setText(item.checkData.price2_18)
                            viewtext38.setTextColor(Color.parseColor("#000000"))
                            p38.addView(viewtext38)
                            L_c38.addView(checkBoxauto38)
                            viewtext38.setSelectAllOnFocus(true)
                            checkBoxauto38.setSelectAllOnFocus(true)
                            checkBoxauto38.textSize = 14f
                            checkBoxauto38.setTypeface(null, Typeface.BOLD)
                            checkBoxauto38.isSingleLine = true
                            viewtext38.isSingleLine = true
                            viewtext38.textSize = 14f
                            viewtext38.inputType = InputType.TYPE_CLASS_PHONE

                            viewtext38.addTextChangedListener(object : TextWatcher {
                                override fun beforeTextChanged(
                                    s: CharSequence?,
                                    start: Int,
                                    count: Int,
                                    after: Int
                                ) {
                                }

                                override fun onTextChanged(
                                    s: CharSequence?,
                                    start: Int,
                                    before: Int,
                                    count: Int
                                ) {
                                    val value1 = viewtext1.text.toString().toIntOrNull() ?: 0
                                    val value2 = viewtext2.text.toString().toIntOrNull() ?: 0
                                    val value3 = viewtext3.text.toString().toIntOrNull() ?: 0
                                    val value4 = viewtext4.text.toString().toIntOrNull() ?: 0
                                    val value5 = viewtext5.text.toString().toIntOrNull() ?: 0
                                    val value6 = viewtext6.text.toString().toIntOrNull() ?: 0
                                    val value7 = viewtext7.text.toString().toIntOrNull() ?: 0
                                    val value8 = viewtext8.text.toString().toIntOrNull() ?: 0
                                    val value9 = viewtext9.text.toString().toIntOrNull() ?: 0
                                    val value10 = viewtext10.text.toString().toIntOrNull() ?: 0
                                    val value11 = viewtext11.text.toString().toIntOrNull() ?: 0
                                    val value12 = viewtext12.text.toString().toIntOrNull() ?: 0
                                    val value13 = viewtext13.text.toString().toIntOrNull() ?: 0
                                    val value14 = viewtext14.text.toString().toIntOrNull() ?: 0
                                    val value15 = viewtext15.text.toString().toIntOrNull() ?: 0
                                    val value16 = viewtext16.text.toString().toIntOrNull() ?: 0
                                    val value17 = viewtext17.text.toString().toIntOrNull() ?: 0
                                    val value18 = viewtext18.text.toString().toIntOrNull() ?: 0
                                    val value19 = viewtext19.text.toString().toIntOrNull() ?: 0
                                    val value20 = viewtext20.text.toString().toIntOrNull() ?: 0
                                    val value21 = viewtext21.text.toString().toIntOrNull() ?: 0
                                    val value22 = viewtext22.text.toString().toIntOrNull() ?: 0
                                    val value23 = viewtext23.text.toString().toIntOrNull() ?: 0
                                    val value24 = viewtext24.text.toString().toIntOrNull() ?: 0
                                    val value25 = viewtext25.text.toString().toIntOrNull() ?: 0
                                    val value26 = viewtext26.text.toString().toIntOrNull() ?: 0
                                    val value27 = viewtext27.text.toString().toIntOrNull() ?: 0
                                    val value28 = viewtext28.text.toString().toIntOrNull() ?: 0
                                    val value29 = viewtext29.text.toString().toIntOrNull() ?: 0
                                    val value30 = viewtext30.text.toString().toIntOrNull() ?: 0
                                    val value31 = viewtext31.text.toString().toIntOrNull() ?: 0
                                    val value32 = viewtext32.text.toString().toIntOrNull() ?: 0
                                    val value33 = viewtext33.text.toString().toIntOrNull() ?: 0
                                    val value34 = viewtext34.text.toString().toIntOrNull() ?: 0
                                    val value35 = viewtext35.text.toString().toIntOrNull() ?: 0
                                    val value36 = viewtext36.text.toString().toIntOrNull() ?: 0
                                    val value37 = viewtext37.text.toString().toIntOrNull() ?: 0
                                    val value38 = viewtext38.text.toString().toIntOrNull() ?: 0
                                    val value39 = viewtext39.text.toString().toIntOrNull() ?: 0
                                    val value40 = viewtext40.text.toString().toIntOrNull() ?: 0
                                    val value41 = viewtext41.text.toString().toIntOrNull() ?: 0
                                    val value42 = viewtext42.text.toString().toIntOrNull() ?: 0
                                    val value43 = viewtext43.text.toString().toIntOrNull() ?: 0
                                    val value44 = viewtext44.text.toString().toIntOrNull() ?: 0
                                    val value45 = viewtext45.text.toString().toIntOrNull() ?: 0
                                    val value46 = viewtext46.text.toString().toIntOrNull() ?: 0
                                    val value47 = viewtext47.text.toString().toIntOrNull() ?: 0
                                    val value48 = viewtext48.text.toString().toIntOrNull() ?: 0
                                    val value49 = viewtext49.text.toString().toIntOrNull() ?: 0
                                    val value50 = viewtext50.text.toString().toIntOrNull() ?: 0
                                    val value51 = viewtext51.text.toString().toIntOrNull() ?: 0
                                    val value52 = viewtext52.text.toString().toIntOrNull() ?: 0
                                    val value53 = viewtext53.text.toString().toIntOrNull() ?: 0
                                    val value54 = viewtext54.text.toString().toIntOrNull() ?: 0
                                    val value55 = viewtext55.text.toString().toIntOrNull() ?: 0
                                    val value56 = viewtext56.text.toString().toIntOrNull() ?: 0
                                    val value57 = viewtext57.text.toString().toIntOrNull() ?: 0
                                    val value58 = viewtext58.text.toString().toIntOrNull() ?: 0
                                    val value59 = viewtext59.text.toString().toIntOrNull() ?: 0

                                    sum = (value1 + value2 + value3 + value4  + value5 +
                                            value6 + value7  + value8  + value9 + value10 + value11 +
                                            value12 + value13 + value14 + value15  + value16  + value17 +
                                            value18 + value19  + value20  + value21 + value22 + value23 +
                                            value24 + value25 + value26 + value27  + value28  + value29 +
                                            value30 + value31  + value32  + value33 + value34 + value35 +
                                            value36 + value37 + value38 + value39  + value40  + value41 +
                                            value42 + value43  + value44  + value45 + value46 + value47 +
                                            value48 + value49 + value50 + value51  + value52  + value53 +
                                            value54 + value55  + value56  + value57 + value58 + value59).toString()

                                    totalall_E_D.text = (sum)
                                }

                                override fun afterTextChanged(s: Editable?) {
                                }
                            })
                        }
                    }

                    if (item.checkData.check2_19.isNotEmpty()){
                        customDialogFB.apply {
                            checkBoxauto39.setText(item.checkData.check2_19)
                            checkBoxauto39.setTextColor(Color.parseColor("#000000"))
                            checkBoxauto39.layoutParams = LinearLayout.LayoutParams(
                                ViewGroup.LayoutParams.WRAP_CONTENT,
                                ViewGroup.LayoutParams.WRAP_CONTENT, Float.MIN_VALUE)
                            viewtext39.setText(item.checkData.price2_19)
                            viewtext39.setTextColor(Color.parseColor("#000000"))
                            p39.addView(viewtext39)
                            L_c39.addView(checkBoxauto39)
                            viewtext39.setSelectAllOnFocus(true)
                            checkBoxauto39.setSelectAllOnFocus(true)
                            checkBoxauto39.textSize = 14f
                            checkBoxauto39.setTypeface(null, Typeface.BOLD)
                            checkBoxauto39.isSingleLine = true
                            viewtext39.isSingleLine = true
                            viewtext39.textSize = 14f
                            viewtext39.inputType = InputType.TYPE_CLASS_PHONE

                            viewtext39.addTextChangedListener(object : TextWatcher {
                                override fun beforeTextChanged(
                                    s: CharSequence?,
                                    start: Int,
                                    count: Int,
                                    after: Int
                                ) {
                                }

                                override fun onTextChanged(
                                    s: CharSequence?,
                                    start: Int,
                                    before: Int,
                                    count: Int
                                ) {
                                    val value1 = viewtext1.text.toString().toIntOrNull() ?: 0
                                    val value2 = viewtext2.text.toString().toIntOrNull() ?: 0
                                    val value3 = viewtext3.text.toString().toIntOrNull() ?: 0
                                    val value4 = viewtext4.text.toString().toIntOrNull() ?: 0
                                    val value5 = viewtext5.text.toString().toIntOrNull() ?: 0
                                    val value6 = viewtext6.text.toString().toIntOrNull() ?: 0
                                    val value7 = viewtext7.text.toString().toIntOrNull() ?: 0
                                    val value8 = viewtext8.text.toString().toIntOrNull() ?: 0
                                    val value9 = viewtext9.text.toString().toIntOrNull() ?: 0
                                    val value10 = viewtext10.text.toString().toIntOrNull() ?: 0
                                    val value11 = viewtext11.text.toString().toIntOrNull() ?: 0
                                    val value12 = viewtext12.text.toString().toIntOrNull() ?: 0
                                    val value13 = viewtext13.text.toString().toIntOrNull() ?: 0
                                    val value14 = viewtext14.text.toString().toIntOrNull() ?: 0
                                    val value15 = viewtext15.text.toString().toIntOrNull() ?: 0
                                    val value16 = viewtext16.text.toString().toIntOrNull() ?: 0
                                    val value17 = viewtext17.text.toString().toIntOrNull() ?: 0
                                    val value18 = viewtext18.text.toString().toIntOrNull() ?: 0
                                    val value19 = viewtext19.text.toString().toIntOrNull() ?: 0
                                    val value20 = viewtext20.text.toString().toIntOrNull() ?: 0
                                    val value21 = viewtext21.text.toString().toIntOrNull() ?: 0
                                    val value22 = viewtext22.text.toString().toIntOrNull() ?: 0
                                    val value23 = viewtext23.text.toString().toIntOrNull() ?: 0
                                    val value24 = viewtext24.text.toString().toIntOrNull() ?: 0
                                    val value25 = viewtext25.text.toString().toIntOrNull() ?: 0
                                    val value26 = viewtext26.text.toString().toIntOrNull() ?: 0
                                    val value27 = viewtext27.text.toString().toIntOrNull() ?: 0
                                    val value28 = viewtext28.text.toString().toIntOrNull() ?: 0
                                    val value29 = viewtext29.text.toString().toIntOrNull() ?: 0
                                    val value30 = viewtext30.text.toString().toIntOrNull() ?: 0
                                    val value31 = viewtext31.text.toString().toIntOrNull() ?: 0
                                    val value32 = viewtext32.text.toString().toIntOrNull() ?: 0
                                    val value33 = viewtext33.text.toString().toIntOrNull() ?: 0
                                    val value34 = viewtext34.text.toString().toIntOrNull() ?: 0
                                    val value35 = viewtext35.text.toString().toIntOrNull() ?: 0
                                    val value36 = viewtext36.text.toString().toIntOrNull() ?: 0
                                    val value37 = viewtext37.text.toString().toIntOrNull() ?: 0
                                    val value38 = viewtext38.text.toString().toIntOrNull() ?: 0
                                    val value39 = viewtext39.text.toString().toIntOrNull() ?: 0
                                    val value40 = viewtext40.text.toString().toIntOrNull() ?: 0
                                    val value41 = viewtext41.text.toString().toIntOrNull() ?: 0
                                    val value42 = viewtext42.text.toString().toIntOrNull() ?: 0
                                    val value43 = viewtext43.text.toString().toIntOrNull() ?: 0
                                    val value44 = viewtext44.text.toString().toIntOrNull() ?: 0
                                    val value45 = viewtext45.text.toString().toIntOrNull() ?: 0
                                    val value46 = viewtext46.text.toString().toIntOrNull() ?: 0
                                    val value47 = viewtext47.text.toString().toIntOrNull() ?: 0
                                    val value48 = viewtext48.text.toString().toIntOrNull() ?: 0
                                    val value49 = viewtext49.text.toString().toIntOrNull() ?: 0
                                    val value50 = viewtext50.text.toString().toIntOrNull() ?: 0
                                    val value51 = viewtext51.text.toString().toIntOrNull() ?: 0
                                    val value52 = viewtext52.text.toString().toIntOrNull() ?: 0
                                    val value53 = viewtext53.text.toString().toIntOrNull() ?: 0
                                    val value54 = viewtext54.text.toString().toIntOrNull() ?: 0
                                    val value55 = viewtext55.text.toString().toIntOrNull() ?: 0
                                    val value56 = viewtext56.text.toString().toIntOrNull() ?: 0
                                    val value57 = viewtext57.text.toString().toIntOrNull() ?: 0
                                    val value58 = viewtext58.text.toString().toIntOrNull() ?: 0
                                    val value59 = viewtext59.text.toString().toIntOrNull() ?: 0

                                    sum = (value1 + value2 + value3 + value4  + value5 +
                                            value6 + value7  + value8  + value9 + value10 + value11 +
                                            value12 + value13 + value14 + value15  + value16  + value17 +
                                            value18 + value19  + value20  + value21 + value22 + value23 +
                                            value24 + value25 + value26 + value27  + value28  + value29 +
                                            value30 + value31  + value32  + value33 + value34 + value35 +
                                            value36 + value37 + value38 + value39  + value40  + value41 +
                                            value42 + value43  + value44  + value45 + value46 + value47 +
                                            value48 + value49 + value50 + value51  + value52  + value53 +
                                            value54 + value55  + value56  + value57 + value58 + value59).toString()

                                    totalall_E_D.text = (sum)
                                }

                                override fun afterTextChanged(s: Editable?) {
                                }
                            })
                        }
                    }

                    if (item.checkData.check2_20.isNotEmpty()){
                        customDialogFB.apply {
                            checkBoxauto40.setText(item.checkData.check2_20)
                            checkBoxauto40.setTextColor(Color.parseColor("#000000"))
                            checkBoxauto40.layoutParams = LinearLayout.LayoutParams(
                                ViewGroup.LayoutParams.WRAP_CONTENT,
                                ViewGroup.LayoutParams.WRAP_CONTENT, Float.MIN_VALUE)
                            viewtext40.setText(item.checkData.price2_20)
                            viewtext40.setTextColor(Color.parseColor("#000000"))
                            p40.addView(viewtext40)
                            L_c40.addView(checkBoxauto40)
                            viewtext40.setSelectAllOnFocus(true)
                            checkBoxauto40.setSelectAllOnFocus(true)
                            checkBoxauto40.textSize = 14f
                            checkBoxauto40.setTypeface(null, Typeface.BOLD)
                            checkBoxauto40.isSingleLine = true
                            viewtext40.isSingleLine = true
                            viewtext40.textSize = 14f
                            viewtext40.inputType = InputType.TYPE_CLASS_PHONE

                            viewtext40.addTextChangedListener(object : TextWatcher {
                                override fun beforeTextChanged(
                                    s: CharSequence?,
                                    start: Int,
                                    count: Int,
                                    after: Int
                                ) {
                                }

                                override fun onTextChanged(
                                    s: CharSequence?,
                                    start: Int,
                                    before: Int,
                                    count: Int
                                ) {
                                    val value1 = viewtext1.text.toString().toIntOrNull() ?: 0
                                    val value2 = viewtext2.text.toString().toIntOrNull() ?: 0
                                    val value3 = viewtext3.text.toString().toIntOrNull() ?: 0
                                    val value4 = viewtext4.text.toString().toIntOrNull() ?: 0
                                    val value5 = viewtext5.text.toString().toIntOrNull() ?: 0
                                    val value6 = viewtext6.text.toString().toIntOrNull() ?: 0
                                    val value7 = viewtext7.text.toString().toIntOrNull() ?: 0
                                    val value8 = viewtext8.text.toString().toIntOrNull() ?: 0
                                    val value9 = viewtext9.text.toString().toIntOrNull() ?: 0
                                    val value10 = viewtext10.text.toString().toIntOrNull() ?: 0
                                    val value11 = viewtext11.text.toString().toIntOrNull() ?: 0
                                    val value12 = viewtext12.text.toString().toIntOrNull() ?: 0
                                    val value13 = viewtext13.text.toString().toIntOrNull() ?: 0
                                    val value14 = viewtext14.text.toString().toIntOrNull() ?: 0
                                    val value15 = viewtext15.text.toString().toIntOrNull() ?: 0
                                    val value16 = viewtext16.text.toString().toIntOrNull() ?: 0
                                    val value17 = viewtext17.text.toString().toIntOrNull() ?: 0
                                    val value18 = viewtext18.text.toString().toIntOrNull() ?: 0
                                    val value19 = viewtext19.text.toString().toIntOrNull() ?: 0
                                    val value20 = viewtext20.text.toString().toIntOrNull() ?: 0
                                    val value21 = viewtext21.text.toString().toIntOrNull() ?: 0
                                    val value22 = viewtext22.text.toString().toIntOrNull() ?: 0
                                    val value23 = viewtext23.text.toString().toIntOrNull() ?: 0
                                    val value24 = viewtext24.text.toString().toIntOrNull() ?: 0
                                    val value25 = viewtext25.text.toString().toIntOrNull() ?: 0
                                    val value26 = viewtext26.text.toString().toIntOrNull() ?: 0
                                    val value27 = viewtext27.text.toString().toIntOrNull() ?: 0
                                    val value28 = viewtext28.text.toString().toIntOrNull() ?: 0
                                    val value29 = viewtext29.text.toString().toIntOrNull() ?: 0
                                    val value30 = viewtext30.text.toString().toIntOrNull() ?: 0
                                    val value31 = viewtext31.text.toString().toIntOrNull() ?: 0
                                    val value32 = viewtext32.text.toString().toIntOrNull() ?: 0
                                    val value33 = viewtext33.text.toString().toIntOrNull() ?: 0
                                    val value34 = viewtext34.text.toString().toIntOrNull() ?: 0
                                    val value35 = viewtext35.text.toString().toIntOrNull() ?: 0
                                    val value36 = viewtext36.text.toString().toIntOrNull() ?: 0
                                    val value37 = viewtext37.text.toString().toIntOrNull() ?: 0
                                    val value38 = viewtext38.text.toString().toIntOrNull() ?: 0
                                    val value39 = viewtext39.text.toString().toIntOrNull() ?: 0
                                    val value40 = viewtext40.text.toString().toIntOrNull() ?: 0
                                    val value41 = viewtext41.text.toString().toIntOrNull() ?: 0
                                    val value42 = viewtext42.text.toString().toIntOrNull() ?: 0
                                    val value43 = viewtext43.text.toString().toIntOrNull() ?: 0
                                    val value44 = viewtext44.text.toString().toIntOrNull() ?: 0
                                    val value45 = viewtext45.text.toString().toIntOrNull() ?: 0
                                    val value46 = viewtext46.text.toString().toIntOrNull() ?: 0
                                    val value47 = viewtext47.text.toString().toIntOrNull() ?: 0
                                    val value48 = viewtext48.text.toString().toIntOrNull() ?: 0
                                    val value49 = viewtext49.text.toString().toIntOrNull() ?: 0
                                    val value50 = viewtext50.text.toString().toIntOrNull() ?: 0
                                    val value51 = viewtext51.text.toString().toIntOrNull() ?: 0
                                    val value52 = viewtext52.text.toString().toIntOrNull() ?: 0
                                    val value53 = viewtext53.text.toString().toIntOrNull() ?: 0
                                    val value54 = viewtext54.text.toString().toIntOrNull() ?: 0
                                    val value55 = viewtext55.text.toString().toIntOrNull() ?: 0
                                    val value56 = viewtext56.text.toString().toIntOrNull() ?: 0
                                    val value57 = viewtext57.text.toString().toIntOrNull() ?: 0
                                    val value58 = viewtext58.text.toString().toIntOrNull() ?: 0
                                    val value59 = viewtext59.text.toString().toIntOrNull() ?: 0

                                    sum = (value1 + value2 + value3 + value4  + value5 +
                                            value6 + value7  + value8  + value9 + value10 + value11 +
                                            value12 + value13 + value14 + value15  + value16  + value17 +
                                            value18 + value19  + value20  + value21 + value22 + value23 +
                                            value24 + value25 + value26 + value27  + value28  + value29 +
                                            value30 + value31  + value32  + value33 + value34 + value35 +
                                            value36 + value37 + value38 + value39  + value40  + value41 +
                                            value42 + value43  + value44  + value45 + value46 + value47 +
                                            value48 + value49 + value50 + value51  + value52  + value53 +
                                            value54 + value55  + value56  + value57 + value58 + value59).toString()

                                    totalall_E_D.text = (sum)
                                }

                                override fun afterTextChanged(s: Editable?) {
                                }
                            })
                        }
                    }

                    if (item.checkData.check2_21.isNotEmpty()){
                        customDialogFB.apply {
                            checkBoxauto41.setText(item.checkData.check2_21)
                            checkBoxauto41.setTextColor(Color.parseColor("#000000"))
                            checkBoxauto41.layoutParams = LinearLayout.LayoutParams(
                                ViewGroup.LayoutParams.WRAP_CONTENT,
                                ViewGroup.LayoutParams.WRAP_CONTENT, Float.MIN_VALUE)
                            viewtext41.setText(item.checkData.price2_21)
                            viewtext41.setTextColor(Color.parseColor("#000000"))
                            p41.addView(viewtext41)
                            L_c41.addView(checkBoxauto41)
                            viewtext41.setSelectAllOnFocus(true)
                            checkBoxauto41.setSelectAllOnFocus(true)
                            checkBoxauto41.textSize = 14f
                            checkBoxauto41.setTypeface(null, Typeface.BOLD)
                            checkBoxauto41.isSingleLine = true
                            viewtext41.isSingleLine = true
                            viewtext41.textSize = 14f
                            viewtext41.inputType = InputType.TYPE_CLASS_PHONE

                            viewtext41.addTextChangedListener(object : TextWatcher {
                                override fun beforeTextChanged(
                                    s: CharSequence?,
                                    start: Int,
                                    count: Int,
                                    after: Int
                                ) {
                                }

                                override fun onTextChanged(
                                    s: CharSequence?,
                                    start: Int,
                                    before: Int,
                                    count: Int
                                ) {
                                    val value1 = viewtext1.text.toString().toIntOrNull() ?: 0
                                    val value2 = viewtext2.text.toString().toIntOrNull() ?: 0
                                    val value3 = viewtext3.text.toString().toIntOrNull() ?: 0
                                    val value4 = viewtext4.text.toString().toIntOrNull() ?: 0
                                    val value5 = viewtext5.text.toString().toIntOrNull() ?: 0
                                    val value6 = viewtext6.text.toString().toIntOrNull() ?: 0
                                    val value7 = viewtext7.text.toString().toIntOrNull() ?: 0
                                    val value8 = viewtext8.text.toString().toIntOrNull() ?: 0
                                    val value9 = viewtext9.text.toString().toIntOrNull() ?: 0
                                    val value10 = viewtext10.text.toString().toIntOrNull() ?: 0
                                    val value11 = viewtext11.text.toString().toIntOrNull() ?: 0
                                    val value12 = viewtext12.text.toString().toIntOrNull() ?: 0
                                    val value13 = viewtext13.text.toString().toIntOrNull() ?: 0
                                    val value14 = viewtext14.text.toString().toIntOrNull() ?: 0
                                    val value15 = viewtext15.text.toString().toIntOrNull() ?: 0
                                    val value16 = viewtext16.text.toString().toIntOrNull() ?: 0
                                    val value17 = viewtext17.text.toString().toIntOrNull() ?: 0
                                    val value18 = viewtext18.text.toString().toIntOrNull() ?: 0
                                    val value19 = viewtext19.text.toString().toIntOrNull() ?: 0
                                    val value20 = viewtext20.text.toString().toIntOrNull() ?: 0
                                    val value21 = viewtext21.text.toString().toIntOrNull() ?: 0
                                    val value22 = viewtext22.text.toString().toIntOrNull() ?: 0
                                    val value23 = viewtext23.text.toString().toIntOrNull() ?: 0
                                    val value24 = viewtext24.text.toString().toIntOrNull() ?: 0
                                    val value25 = viewtext25.text.toString().toIntOrNull() ?: 0
                                    val value26 = viewtext26.text.toString().toIntOrNull() ?: 0
                                    val value27 = viewtext27.text.toString().toIntOrNull() ?: 0
                                    val value28 = viewtext28.text.toString().toIntOrNull() ?: 0
                                    val value29 = viewtext29.text.toString().toIntOrNull() ?: 0
                                    val value30 = viewtext30.text.toString().toIntOrNull() ?: 0
                                    val value31 = viewtext31.text.toString().toIntOrNull() ?: 0
                                    val value32 = viewtext32.text.toString().toIntOrNull() ?: 0
                                    val value33 = viewtext33.text.toString().toIntOrNull() ?: 0
                                    val value34 = viewtext34.text.toString().toIntOrNull() ?: 0
                                    val value35 = viewtext35.text.toString().toIntOrNull() ?: 0
                                    val value36 = viewtext36.text.toString().toIntOrNull() ?: 0
                                    val value37 = viewtext37.text.toString().toIntOrNull() ?: 0
                                    val value38 = viewtext38.text.toString().toIntOrNull() ?: 0
                                    val value39 = viewtext39.text.toString().toIntOrNull() ?: 0
                                    val value40 = viewtext40.text.toString().toIntOrNull() ?: 0
                                    val value41 = viewtext41.text.toString().toIntOrNull() ?: 0
                                    val value42 = viewtext42.text.toString().toIntOrNull() ?: 0
                                    val value43 = viewtext43.text.toString().toIntOrNull() ?: 0
                                    val value44 = viewtext44.text.toString().toIntOrNull() ?: 0
                                    val value45 = viewtext45.text.toString().toIntOrNull() ?: 0
                                    val value46 = viewtext46.text.toString().toIntOrNull() ?: 0
                                    val value47 = viewtext47.text.toString().toIntOrNull() ?: 0
                                    val value48 = viewtext48.text.toString().toIntOrNull() ?: 0
                                    val value49 = viewtext49.text.toString().toIntOrNull() ?: 0
                                    val value50 = viewtext50.text.toString().toIntOrNull() ?: 0
                                    val value51 = viewtext51.text.toString().toIntOrNull() ?: 0
                                    val value52 = viewtext52.text.toString().toIntOrNull() ?: 0
                                    val value53 = viewtext53.text.toString().toIntOrNull() ?: 0
                                    val value54 = viewtext54.text.toString().toIntOrNull() ?: 0
                                    val value55 = viewtext55.text.toString().toIntOrNull() ?: 0
                                    val value56 = viewtext56.text.toString().toIntOrNull() ?: 0
                                    val value57 = viewtext57.text.toString().toIntOrNull() ?: 0
                                    val value58 = viewtext58.text.toString().toIntOrNull() ?: 0
                                    val value59 = viewtext59.text.toString().toIntOrNull() ?: 0

                                    sum = (value1 + value2 + value3 + value4  + value5 +
                                            value6 + value7  + value8  + value9 + value10 + value11 +
                                            value12 + value13 + value14 + value15  + value16  + value17 +
                                            value18 + value19  + value20  + value21 + value22 + value23 +
                                            value24 + value25 + value26 + value27  + value28  + value29 +
                                            value30 + value31  + value32  + value33 + value34 + value35 +
                                            value36 + value37 + value38 + value39  + value40  + value41 +
                                            value42 + value43  + value44  + value45 + value46 + value47 +
                                            value48 + value49 + value50 + value51  + value52  + value53 +
                                            value54 + value55  + value56  + value57 + value58 + value59).toString()

                                    totalall_E_D.text = (sum)
                                }

                                override fun afterTextChanged(s: Editable?) {
                                }
                            })
                        }
                    }

                    if (item.checkData.check2_22.isNotEmpty()){
                        customDialogFB.apply {
                            checkBoxauto42.setText(item.checkData.check2_22)
                            checkBoxauto42.setTextColor(Color.parseColor("#000000"))
                            checkBoxauto42.layoutParams = LinearLayout.LayoutParams(
                                ViewGroup.LayoutParams.WRAP_CONTENT,
                                ViewGroup.LayoutParams.WRAP_CONTENT, Float.MIN_VALUE)
                            viewtext42.setText(item.checkData.price2_22)
                            viewtext42.setTextColor(Color.parseColor("#000000"))
                            p42.addView(viewtext42)
                            L_c42.addView(checkBoxauto42)
                            viewtext42.setSelectAllOnFocus(true)
                            checkBoxauto42.setSelectAllOnFocus(true)
                            checkBoxauto42.textSize = 14f
                            checkBoxauto42.setTypeface(null, Typeface.BOLD)
                            checkBoxauto42.isSingleLine = true
                            viewtext42.isSingleLine = true
                            viewtext42.textSize = 14f
                            viewtext42.inputType = InputType.TYPE_CLASS_PHONE

                            viewtext42.addTextChangedListener(object : TextWatcher {
                                override fun beforeTextChanged(
                                    s: CharSequence?,
                                    start: Int,
                                    count: Int,
                                    after: Int
                                ) {
                                }

                                override fun onTextChanged(
                                    s: CharSequence?,
                                    start: Int,
                                    before: Int,
                                    count: Int
                                ) {
                                    val value1 = viewtext1.text.toString().toIntOrNull() ?: 0
                                    val value2 = viewtext2.text.toString().toIntOrNull() ?: 0
                                    val value3 = viewtext3.text.toString().toIntOrNull() ?: 0
                                    val value4 = viewtext4.text.toString().toIntOrNull() ?: 0
                                    val value5 = viewtext5.text.toString().toIntOrNull() ?: 0
                                    val value6 = viewtext6.text.toString().toIntOrNull() ?: 0
                                    val value7 = viewtext7.text.toString().toIntOrNull() ?: 0
                                    val value8 = viewtext8.text.toString().toIntOrNull() ?: 0
                                    val value9 = viewtext9.text.toString().toIntOrNull() ?: 0
                                    val value10 = viewtext10.text.toString().toIntOrNull() ?: 0
                                    val value11 = viewtext11.text.toString().toIntOrNull() ?: 0
                                    val value12 = viewtext12.text.toString().toIntOrNull() ?: 0
                                    val value13 = viewtext13.text.toString().toIntOrNull() ?: 0
                                    val value14 = viewtext14.text.toString().toIntOrNull() ?: 0
                                    val value15 = viewtext15.text.toString().toIntOrNull() ?: 0
                                    val value16 = viewtext16.text.toString().toIntOrNull() ?: 0
                                    val value17 = viewtext17.text.toString().toIntOrNull() ?: 0
                                    val value18 = viewtext18.text.toString().toIntOrNull() ?: 0
                                    val value19 = viewtext19.text.toString().toIntOrNull() ?: 0
                                    val value20 = viewtext20.text.toString().toIntOrNull() ?: 0
                                    val value21 = viewtext21.text.toString().toIntOrNull() ?: 0
                                    val value22 = viewtext22.text.toString().toIntOrNull() ?: 0
                                    val value23 = viewtext23.text.toString().toIntOrNull() ?: 0
                                    val value24 = viewtext24.text.toString().toIntOrNull() ?: 0
                                    val value25 = viewtext25.text.toString().toIntOrNull() ?: 0
                                    val value26 = viewtext26.text.toString().toIntOrNull() ?: 0
                                    val value27 = viewtext27.text.toString().toIntOrNull() ?: 0
                                    val value28 = viewtext28.text.toString().toIntOrNull() ?: 0
                                    val value29 = viewtext29.text.toString().toIntOrNull() ?: 0
                                    val value30 = viewtext30.text.toString().toIntOrNull() ?: 0
                                    val value31 = viewtext31.text.toString().toIntOrNull() ?: 0
                                    val value32 = viewtext32.text.toString().toIntOrNull() ?: 0
                                    val value33 = viewtext33.text.toString().toIntOrNull() ?: 0
                                    val value34 = viewtext34.text.toString().toIntOrNull() ?: 0
                                    val value35 = viewtext35.text.toString().toIntOrNull() ?: 0
                                    val value36 = viewtext36.text.toString().toIntOrNull() ?: 0
                                    val value37 = viewtext37.text.toString().toIntOrNull() ?: 0
                                    val value38 = viewtext38.text.toString().toIntOrNull() ?: 0
                                    val value39 = viewtext39.text.toString().toIntOrNull() ?: 0
                                    val value40 = viewtext40.text.toString().toIntOrNull() ?: 0
                                    val value41 = viewtext41.text.toString().toIntOrNull() ?: 0
                                    val value42 = viewtext42.text.toString().toIntOrNull() ?: 0
                                    val value43 = viewtext43.text.toString().toIntOrNull() ?: 0
                                    val value44 = viewtext44.text.toString().toIntOrNull() ?: 0
                                    val value45 = viewtext45.text.toString().toIntOrNull() ?: 0
                                    val value46 = viewtext46.text.toString().toIntOrNull() ?: 0
                                    val value47 = viewtext47.text.toString().toIntOrNull() ?: 0
                                    val value48 = viewtext48.text.toString().toIntOrNull() ?: 0
                                    val value49 = viewtext49.text.toString().toIntOrNull() ?: 0
                                    val value50 = viewtext50.text.toString().toIntOrNull() ?: 0
                                    val value51 = viewtext51.text.toString().toIntOrNull() ?: 0
                                    val value52 = viewtext52.text.toString().toIntOrNull() ?: 0
                                    val value53 = viewtext53.text.toString().toIntOrNull() ?: 0
                                    val value54 = viewtext54.text.toString().toIntOrNull() ?: 0
                                    val value55 = viewtext55.text.toString().toIntOrNull() ?: 0
                                    val value56 = viewtext56.text.toString().toIntOrNull() ?: 0
                                    val value57 = viewtext57.text.toString().toIntOrNull() ?: 0
                                    val value58 = viewtext58.text.toString().toIntOrNull() ?: 0
                                    val value59 = viewtext59.text.toString().toIntOrNull() ?: 0

                                    sum = (value1 + value2 + value3 + value4  + value5 +
                                            value6 + value7  + value8  + value9 + value10 + value11 +
                                            value12 + value13 + value14 + value15  + value16  + value17 +
                                            value18 + value19  + value20  + value21 + value22 + value23 +
                                            value24 + value25 + value26 + value27  + value28  + value29 +
                                            value30 + value31  + value32  + value33 + value34 + value35 +
                                            value36 + value37 + value38 + value39  + value40  + value41 +
                                            value42 + value43  + value44  + value45 + value46 + value47 +
                                            value48 + value49 + value50 + value51  + value52  + value53 +
                                            value54 + value55  + value56  + value57 + value58 + value59).toString()

                                    totalall_E_D.text = (sum)
                                }

                                override fun afterTextChanged(s: Editable?) {
                                }
                            })
                        }
                    }

                    if (item.checkData.check3_1.isNotEmpty()){
                        customDialogFB.apply {
                            checkBoxauto43.setText(item.checkData.check3_1)
                            checkBoxauto43.setTextColor(Color.parseColor("#000000"))
                            checkBoxauto43.layoutParams = LinearLayout.LayoutParams(
                                ViewGroup.LayoutParams.WRAP_CONTENT,
                                ViewGroup.LayoutParams.WRAP_CONTENT, Float.MIN_VALUE)
                            viewtext43.setText(item.checkData.price3_1)
                            viewtext43.setTextColor(Color.parseColor("#000000"))
                            p43.addView(viewtext43)
                            L_c43.addView(checkBoxauto43)
                            viewtext43.setSelectAllOnFocus(true)
                            checkBoxauto43.setSelectAllOnFocus(true)
                            checkBoxauto43.textSize = 14f
                            checkBoxauto43.setTypeface(null, Typeface.BOLD)
                            checkBoxauto43.isSingleLine = true
                            viewtext43.isSingleLine = true
                            viewtext43.textSize = 14f
                            viewtext43.inputType = InputType.TYPE_CLASS_PHONE

                            viewtext43.addTextChangedListener(object : TextWatcher {
                                override fun beforeTextChanged(
                                    s: CharSequence?,
                                    start: Int,
                                    count: Int,
                                    after: Int
                                ) {
                                }

                                override fun onTextChanged(
                                    s: CharSequence?,
                                    start: Int,
                                    before: Int,
                                    count: Int
                                ) {
                                    val value1 = viewtext1.text.toString().toIntOrNull() ?: 0
                                    val value2 = viewtext2.text.toString().toIntOrNull() ?: 0
                                    val value3 = viewtext3.text.toString().toIntOrNull() ?: 0
                                    val value4 = viewtext4.text.toString().toIntOrNull() ?: 0
                                    val value5 = viewtext5.text.toString().toIntOrNull() ?: 0
                                    val value6 = viewtext6.text.toString().toIntOrNull() ?: 0
                                    val value7 = viewtext7.text.toString().toIntOrNull() ?: 0
                                    val value8 = viewtext8.text.toString().toIntOrNull() ?: 0
                                    val value9 = viewtext9.text.toString().toIntOrNull() ?: 0
                                    val value10 = viewtext10.text.toString().toIntOrNull() ?: 0
                                    val value11 = viewtext11.text.toString().toIntOrNull() ?: 0
                                    val value12 = viewtext12.text.toString().toIntOrNull() ?: 0
                                    val value13 = viewtext13.text.toString().toIntOrNull() ?: 0
                                    val value14 = viewtext14.text.toString().toIntOrNull() ?: 0
                                    val value15 = viewtext15.text.toString().toIntOrNull() ?: 0
                                    val value16 = viewtext16.text.toString().toIntOrNull() ?: 0
                                    val value17 = viewtext17.text.toString().toIntOrNull() ?: 0
                                    val value18 = viewtext18.text.toString().toIntOrNull() ?: 0
                                    val value19 = viewtext19.text.toString().toIntOrNull() ?: 0
                                    val value20 = viewtext20.text.toString().toIntOrNull() ?: 0
                                    val value21 = viewtext21.text.toString().toIntOrNull() ?: 0
                                    val value22 = viewtext22.text.toString().toIntOrNull() ?: 0
                                    val value23 = viewtext23.text.toString().toIntOrNull() ?: 0
                                    val value24 = viewtext24.text.toString().toIntOrNull() ?: 0
                                    val value25 = viewtext25.text.toString().toIntOrNull() ?: 0
                                    val value26 = viewtext26.text.toString().toIntOrNull() ?: 0
                                    val value27 = viewtext27.text.toString().toIntOrNull() ?: 0
                                    val value28 = viewtext28.text.toString().toIntOrNull() ?: 0
                                    val value29 = viewtext29.text.toString().toIntOrNull() ?: 0
                                    val value30 = viewtext30.text.toString().toIntOrNull() ?: 0
                                    val value31 = viewtext31.text.toString().toIntOrNull() ?: 0
                                    val value32 = viewtext32.text.toString().toIntOrNull() ?: 0
                                    val value33 = viewtext33.text.toString().toIntOrNull() ?: 0
                                    val value34 = viewtext34.text.toString().toIntOrNull() ?: 0
                                    val value35 = viewtext35.text.toString().toIntOrNull() ?: 0
                                    val value36 = viewtext36.text.toString().toIntOrNull() ?: 0
                                    val value37 = viewtext37.text.toString().toIntOrNull() ?: 0
                                    val value38 = viewtext38.text.toString().toIntOrNull() ?: 0
                                    val value39 = viewtext39.text.toString().toIntOrNull() ?: 0
                                    val value40 = viewtext40.text.toString().toIntOrNull() ?: 0
                                    val value41 = viewtext41.text.toString().toIntOrNull() ?: 0
                                    val value42 = viewtext42.text.toString().toIntOrNull() ?: 0
                                    val value43 = viewtext43.text.toString().toIntOrNull() ?: 0
                                    val value44 = viewtext44.text.toString().toIntOrNull() ?: 0
                                    val value45 = viewtext45.text.toString().toIntOrNull() ?: 0
                                    val value46 = viewtext46.text.toString().toIntOrNull() ?: 0
                                    val value47 = viewtext47.text.toString().toIntOrNull() ?: 0
                                    val value48 = viewtext48.text.toString().toIntOrNull() ?: 0
                                    val value49 = viewtext49.text.toString().toIntOrNull() ?: 0
                                    val value50 = viewtext50.text.toString().toIntOrNull() ?: 0
                                    val value51 = viewtext51.text.toString().toIntOrNull() ?: 0
                                    val value52 = viewtext52.text.toString().toIntOrNull() ?: 0
                                    val value53 = viewtext53.text.toString().toIntOrNull() ?: 0
                                    val value54 = viewtext54.text.toString().toIntOrNull() ?: 0
                                    val value55 = viewtext55.text.toString().toIntOrNull() ?: 0
                                    val value56 = viewtext56.text.toString().toIntOrNull() ?: 0
                                    val value57 = viewtext57.text.toString().toIntOrNull() ?: 0
                                    val value58 = viewtext58.text.toString().toIntOrNull() ?: 0
                                    val value59 = viewtext59.text.toString().toIntOrNull() ?: 0

                                    sum = (value1 + value2 + value3 + value4  + value5 +
                                            value6 + value7  + value8  + value9 + value10 + value11 +
                                            value12 + value13 + value14 + value15  + value16  + value17 +
                                            value18 + value19  + value20  + value21 + value22 + value23 +
                                            value24 + value25 + value26 + value27  + value28  + value29 +
                                            value30 + value31  + value32  + value33 + value34 + value35 +
                                            value36 + value37 + value38 + value39  + value40  + value41 +
                                            value42 + value43  + value44  + value45 + value46 + value47 +
                                            value48 + value49 + value50 + value51  + value52  + value53 +
                                            value54 + value55  + value56  + value57 + value58 + value59).toString()

                                    totalall_E_D.text = (sum)
                                }

                                override fun afterTextChanged(s: Editable?) {
                                }
                            })
                        }
                    }

                    if (item.checkData.check3_2.isNotEmpty()){
                        customDialogFB.apply {
                            checkBoxauto44.setText(item.checkData.check3_2)
                            checkBoxauto44.setTextColor(Color.parseColor("#000000"))
                            checkBoxauto44.layoutParams = LinearLayout.LayoutParams(
                                ViewGroup.LayoutParams.WRAP_CONTENT,
                                ViewGroup.LayoutParams.WRAP_CONTENT, Float.MIN_VALUE)
                            viewtext44.setText(item.checkData.price3_2)
                            viewtext44.setTextColor(Color.parseColor("#000000"))
                            p44.addView(viewtext44)
                            L_c44.addView(checkBoxauto44)
                            viewtext44.setSelectAllOnFocus(true)
                            checkBoxauto44.setSelectAllOnFocus(true)
                            checkBoxauto44.textSize = 14f
                            checkBoxauto44.setTypeface(null, Typeface.BOLD)
                            checkBoxauto44.isSingleLine = true
                            viewtext44.isSingleLine = true
                            viewtext44.textSize = 14f
                            viewtext44.inputType = InputType.TYPE_CLASS_PHONE

                            viewtext44.addTextChangedListener(object : TextWatcher {
                                override fun beforeTextChanged(
                                    s: CharSequence?,
                                    start: Int,
                                    count: Int,
                                    after: Int
                                ) {
                                }

                                override fun onTextChanged(
                                    s: CharSequence?,
                                    start: Int,
                                    before: Int,
                                    count: Int
                                ) {
                                    val value1 = viewtext1.text.toString().toIntOrNull() ?: 0
                                    val value2 = viewtext2.text.toString().toIntOrNull() ?: 0
                                    val value3 = viewtext3.text.toString().toIntOrNull() ?: 0
                                    val value4 = viewtext4.text.toString().toIntOrNull() ?: 0
                                    val value5 = viewtext5.text.toString().toIntOrNull() ?: 0
                                    val value6 = viewtext6.text.toString().toIntOrNull() ?: 0
                                    val value7 = viewtext7.text.toString().toIntOrNull() ?: 0
                                    val value8 = viewtext8.text.toString().toIntOrNull() ?: 0
                                    val value9 = viewtext9.text.toString().toIntOrNull() ?: 0
                                    val value10 = viewtext10.text.toString().toIntOrNull() ?: 0
                                    val value11 = viewtext11.text.toString().toIntOrNull() ?: 0
                                    val value12 = viewtext12.text.toString().toIntOrNull() ?: 0
                                    val value13 = viewtext13.text.toString().toIntOrNull() ?: 0
                                    val value14 = viewtext14.text.toString().toIntOrNull() ?: 0
                                    val value15 = viewtext15.text.toString().toIntOrNull() ?: 0
                                    val value16 = viewtext16.text.toString().toIntOrNull() ?: 0
                                    val value17 = viewtext17.text.toString().toIntOrNull() ?: 0
                                    val value18 = viewtext18.text.toString().toIntOrNull() ?: 0
                                    val value19 = viewtext19.text.toString().toIntOrNull() ?: 0
                                    val value20 = viewtext20.text.toString().toIntOrNull() ?: 0
                                    val value21 = viewtext21.text.toString().toIntOrNull() ?: 0
                                    val value22 = viewtext22.text.toString().toIntOrNull() ?: 0
                                    val value23 = viewtext23.text.toString().toIntOrNull() ?: 0
                                    val value24 = viewtext24.text.toString().toIntOrNull() ?: 0
                                    val value25 = viewtext25.text.toString().toIntOrNull() ?: 0
                                    val value26 = viewtext26.text.toString().toIntOrNull() ?: 0
                                    val value27 = viewtext27.text.toString().toIntOrNull() ?: 0
                                    val value28 = viewtext28.text.toString().toIntOrNull() ?: 0
                                    val value29 = viewtext29.text.toString().toIntOrNull() ?: 0
                                    val value30 = viewtext30.text.toString().toIntOrNull() ?: 0
                                    val value31 = viewtext31.text.toString().toIntOrNull() ?: 0
                                    val value32 = viewtext32.text.toString().toIntOrNull() ?: 0
                                    val value33 = viewtext33.text.toString().toIntOrNull() ?: 0
                                    val value34 = viewtext34.text.toString().toIntOrNull() ?: 0
                                    val value35 = viewtext35.text.toString().toIntOrNull() ?: 0
                                    val value36 = viewtext36.text.toString().toIntOrNull() ?: 0
                                    val value37 = viewtext37.text.toString().toIntOrNull() ?: 0
                                    val value38 = viewtext38.text.toString().toIntOrNull() ?: 0
                                    val value39 = viewtext39.text.toString().toIntOrNull() ?: 0
                                    val value40 = viewtext40.text.toString().toIntOrNull() ?: 0
                                    val value41 = viewtext41.text.toString().toIntOrNull() ?: 0
                                    val value42 = viewtext42.text.toString().toIntOrNull() ?: 0
                                    val value43 = viewtext43.text.toString().toIntOrNull() ?: 0
                                    val value44 = viewtext44.text.toString().toIntOrNull() ?: 0
                                    val value45 = viewtext45.text.toString().toIntOrNull() ?: 0
                                    val value46 = viewtext46.text.toString().toIntOrNull() ?: 0
                                    val value47 = viewtext47.text.toString().toIntOrNull() ?: 0
                                    val value48 = viewtext48.text.toString().toIntOrNull() ?: 0
                                    val value49 = viewtext49.text.toString().toIntOrNull() ?: 0
                                    val value50 = viewtext50.text.toString().toIntOrNull() ?: 0
                                    val value51 = viewtext51.text.toString().toIntOrNull() ?: 0
                                    val value52 = viewtext52.text.toString().toIntOrNull() ?: 0
                                    val value53 = viewtext53.text.toString().toIntOrNull() ?: 0
                                    val value54 = viewtext54.text.toString().toIntOrNull() ?: 0
                                    val value55 = viewtext55.text.toString().toIntOrNull() ?: 0
                                    val value56 = viewtext56.text.toString().toIntOrNull() ?: 0
                                    val value57 = viewtext57.text.toString().toIntOrNull() ?: 0
                                    val value58 = viewtext58.text.toString().toIntOrNull() ?: 0
                                    val value59 = viewtext59.text.toString().toIntOrNull() ?: 0

                                    sum = (value1 + value2 + value3 + value4  + value5 +
                                            value6 + value7  + value8  + value9 + value10 + value11 +
                                            value12 + value13 + value14 + value15  + value16  + value17 +
                                            value18 + value19  + value20  + value21 + value22 + value23 +
                                            value24 + value25 + value26 + value27  + value28  + value29 +
                                            value30 + value31  + value32  + value33 + value34 + value35 +
                                            value36 + value37 + value38 + value39  + value40  + value41 +
                                            value42 + value43  + value44  + value45 + value46 + value47 +
                                            value48 + value49 + value50 + value51  + value52  + value53 +
                                            value54 + value55  + value56  + value57 + value58 + value59).toString()

                                    totalall_E_D.text = (sum)
                                }

                                override fun afterTextChanged(s: Editable?) {
                                }
                            })
                        }
                    }

                    if (item.checkData.check3_3.isNotEmpty()){
                        customDialogFB.apply {
                            checkBoxauto45.setText(item.checkData.check3_3)
                            checkBoxauto45.setTextColor(Color.parseColor("#000000"))
                            checkBoxauto45.layoutParams = LinearLayout.LayoutParams(
                                ViewGroup.LayoutParams.WRAP_CONTENT,
                                ViewGroup.LayoutParams.WRAP_CONTENT, Float.MIN_VALUE)
                            viewtext45.setText(item.checkData.price3_3)
                            viewtext45.setTextColor(Color.parseColor("#000000"))
                            p45.addView(viewtext45)
                            L_c45.addView(checkBoxauto45)
                            viewtext45.setSelectAllOnFocus(true)
                            checkBoxauto45.setSelectAllOnFocus(true)
                            checkBoxauto45.textSize = 14f
                            checkBoxauto45.setTypeface(null, Typeface.BOLD)
                            checkBoxauto45.isSingleLine = true
                            viewtext45.isSingleLine = true
                            viewtext45.textSize = 14f
                            viewtext45.inputType = InputType.TYPE_CLASS_PHONE

                            viewtext45.addTextChangedListener(object : TextWatcher {
                                override fun beforeTextChanged(
                                    s: CharSequence?,
                                    start: Int,
                                    count: Int,
                                    after: Int
                                ) {
                                }

                                override fun onTextChanged(
                                    s: CharSequence?,
                                    start: Int,
                                    before: Int,
                                    count: Int
                                ) {
                                    val value1 = viewtext1.text.toString().toIntOrNull() ?: 0
                                    val value2 = viewtext2.text.toString().toIntOrNull() ?: 0
                                    val value3 = viewtext3.text.toString().toIntOrNull() ?: 0
                                    val value4 = viewtext4.text.toString().toIntOrNull() ?: 0
                                    val value5 = viewtext5.text.toString().toIntOrNull() ?: 0
                                    val value6 = viewtext6.text.toString().toIntOrNull() ?: 0
                                    val value7 = viewtext7.text.toString().toIntOrNull() ?: 0
                                    val value8 = viewtext8.text.toString().toIntOrNull() ?: 0
                                    val value9 = viewtext9.text.toString().toIntOrNull() ?: 0
                                    val value10 = viewtext10.text.toString().toIntOrNull() ?: 0
                                    val value11 = viewtext11.text.toString().toIntOrNull() ?: 0
                                    val value12 = viewtext12.text.toString().toIntOrNull() ?: 0
                                    val value13 = viewtext13.text.toString().toIntOrNull() ?: 0
                                    val value14 = viewtext14.text.toString().toIntOrNull() ?: 0
                                    val value15 = viewtext15.text.toString().toIntOrNull() ?: 0
                                    val value16 = viewtext16.text.toString().toIntOrNull() ?: 0
                                    val value17 = viewtext17.text.toString().toIntOrNull() ?: 0
                                    val value18 = viewtext18.text.toString().toIntOrNull() ?: 0
                                    val value19 = viewtext19.text.toString().toIntOrNull() ?: 0
                                    val value20 = viewtext20.text.toString().toIntOrNull() ?: 0
                                    val value21 = viewtext21.text.toString().toIntOrNull() ?: 0
                                    val value22 = viewtext22.text.toString().toIntOrNull() ?: 0
                                    val value23 = viewtext23.text.toString().toIntOrNull() ?: 0
                                    val value24 = viewtext24.text.toString().toIntOrNull() ?: 0
                                    val value25 = viewtext25.text.toString().toIntOrNull() ?: 0
                                    val value26 = viewtext26.text.toString().toIntOrNull() ?: 0
                                    val value27 = viewtext27.text.toString().toIntOrNull() ?: 0
                                    val value28 = viewtext28.text.toString().toIntOrNull() ?: 0
                                    val value29 = viewtext29.text.toString().toIntOrNull() ?: 0
                                    val value30 = viewtext30.text.toString().toIntOrNull() ?: 0
                                    val value31 = viewtext31.text.toString().toIntOrNull() ?: 0
                                    val value32 = viewtext32.text.toString().toIntOrNull() ?: 0
                                    val value33 = viewtext33.text.toString().toIntOrNull() ?: 0
                                    val value34 = viewtext34.text.toString().toIntOrNull() ?: 0
                                    val value35 = viewtext35.text.toString().toIntOrNull() ?: 0
                                    val value36 = viewtext36.text.toString().toIntOrNull() ?: 0
                                    val value37 = viewtext37.text.toString().toIntOrNull() ?: 0
                                    val value38 = viewtext38.text.toString().toIntOrNull() ?: 0
                                    val value39 = viewtext39.text.toString().toIntOrNull() ?: 0
                                    val value40 = viewtext40.text.toString().toIntOrNull() ?: 0
                                    val value41 = viewtext41.text.toString().toIntOrNull() ?: 0
                                    val value42 = viewtext42.text.toString().toIntOrNull() ?: 0
                                    val value43 = viewtext43.text.toString().toIntOrNull() ?: 0
                                    val value44 = viewtext44.text.toString().toIntOrNull() ?: 0
                                    val value45 = viewtext45.text.toString().toIntOrNull() ?: 0
                                    val value46 = viewtext46.text.toString().toIntOrNull() ?: 0
                                    val value47 = viewtext47.text.toString().toIntOrNull() ?: 0
                                    val value48 = viewtext48.text.toString().toIntOrNull() ?: 0
                                    val value49 = viewtext49.text.toString().toIntOrNull() ?: 0
                                    val value50 = viewtext50.text.toString().toIntOrNull() ?: 0
                                    val value51 = viewtext51.text.toString().toIntOrNull() ?: 0
                                    val value52 = viewtext52.text.toString().toIntOrNull() ?: 0
                                    val value53 = viewtext53.text.toString().toIntOrNull() ?: 0
                                    val value54 = viewtext54.text.toString().toIntOrNull() ?: 0
                                    val value55 = viewtext55.text.toString().toIntOrNull() ?: 0
                                    val value56 = viewtext56.text.toString().toIntOrNull() ?: 0
                                    val value57 = viewtext57.text.toString().toIntOrNull() ?: 0
                                    val value58 = viewtext58.text.toString().toIntOrNull() ?: 0
                                    val value59 = viewtext59.text.toString().toIntOrNull() ?: 0

                                    sum = (value1 + value2 + value3 + value4  + value5 +
                                            value6 + value7  + value8  + value9 + value10 + value11 +
                                            value12 + value13 + value14 + value15  + value16  + value17 +
                                            value18 + value19  + value20  + value21 + value22 + value23 +
                                            value24 + value25 + value26 + value27  + value28  + value29 +
                                            value30 + value31  + value32  + value33 + value34 + value35 +
                                            value36 + value37 + value38 + value39  + value40  + value41 +
                                            value42 + value43  + value44  + value45 + value46 + value47 +
                                            value48 + value49 + value50 + value51  + value52  + value53 +
                                            value54 + value55  + value56  + value57 + value58 + value59).toString()

                                    totalall_E_D.text = (sum)
                                }

                                override fun afterTextChanged(s: Editable?) {
                                }
                            })
                        }
                    }

                    if (item.checkData.check3_4.isNotEmpty()){
                        customDialogFB.apply {
                            checkBoxauto46.setText(item.checkData.check3_4)
                            checkBoxauto46.setTextColor(Color.parseColor("#000000"))
                            checkBoxauto46.layoutParams = LinearLayout.LayoutParams(
                                ViewGroup.LayoutParams.WRAP_CONTENT,
                                ViewGroup.LayoutParams.WRAP_CONTENT, Float.MIN_VALUE)
                            viewtext46.setText(item.checkData.price3_4)
                            viewtext46.setTextColor(Color.parseColor("#000000"))
                            p46.addView(viewtext46)
                            L_c46.addView(checkBoxauto46)
                            viewtext46.setSelectAllOnFocus(true)
                            checkBoxauto46.setSelectAllOnFocus(true)
                            checkBoxauto46.textSize = 14f
                            checkBoxauto46.setTypeface(null, Typeface.BOLD)
                            checkBoxauto46.isSingleLine = true
                            viewtext46.isSingleLine = true
                            viewtext46.textSize = 14f
                            viewtext46.inputType = InputType.TYPE_CLASS_PHONE

                            viewtext46.addTextChangedListener(object : TextWatcher {
                                override fun beforeTextChanged(
                                    s: CharSequence?,
                                    start: Int,
                                    count: Int,
                                    after: Int
                                ) {
                                }

                                override fun onTextChanged(
                                    s: CharSequence?,
                                    start: Int,
                                    before: Int,
                                    count: Int
                                ) {
                                    val value1 = viewtext1.text.toString().toIntOrNull() ?: 0
                                    val value2 = viewtext2.text.toString().toIntOrNull() ?: 0
                                    val value3 = viewtext3.text.toString().toIntOrNull() ?: 0
                                    val value4 = viewtext4.text.toString().toIntOrNull() ?: 0
                                    val value5 = viewtext5.text.toString().toIntOrNull() ?: 0
                                    val value6 = viewtext6.text.toString().toIntOrNull() ?: 0
                                    val value7 = viewtext7.text.toString().toIntOrNull() ?: 0
                                    val value8 = viewtext8.text.toString().toIntOrNull() ?: 0
                                    val value9 = viewtext9.text.toString().toIntOrNull() ?: 0
                                    val value10 = viewtext10.text.toString().toIntOrNull() ?: 0
                                    val value11 = viewtext11.text.toString().toIntOrNull() ?: 0
                                    val value12 = viewtext12.text.toString().toIntOrNull() ?: 0
                                    val value13 = viewtext13.text.toString().toIntOrNull() ?: 0
                                    val value14 = viewtext14.text.toString().toIntOrNull() ?: 0
                                    val value15 = viewtext15.text.toString().toIntOrNull() ?: 0
                                    val value16 = viewtext16.text.toString().toIntOrNull() ?: 0
                                    val value17 = viewtext17.text.toString().toIntOrNull() ?: 0
                                    val value18 = viewtext18.text.toString().toIntOrNull() ?: 0
                                    val value19 = viewtext19.text.toString().toIntOrNull() ?: 0
                                    val value20 = viewtext20.text.toString().toIntOrNull() ?: 0
                                    val value21 = viewtext21.text.toString().toIntOrNull() ?: 0
                                    val value22 = viewtext22.text.toString().toIntOrNull() ?: 0
                                    val value23 = viewtext23.text.toString().toIntOrNull() ?: 0
                                    val value24 = viewtext24.text.toString().toIntOrNull() ?: 0
                                    val value25 = viewtext25.text.toString().toIntOrNull() ?: 0
                                    val value26 = viewtext26.text.toString().toIntOrNull() ?: 0
                                    val value27 = viewtext27.text.toString().toIntOrNull() ?: 0
                                    val value28 = viewtext28.text.toString().toIntOrNull() ?: 0
                                    val value29 = viewtext29.text.toString().toIntOrNull() ?: 0
                                    val value30 = viewtext30.text.toString().toIntOrNull() ?: 0
                                    val value31 = viewtext31.text.toString().toIntOrNull() ?: 0
                                    val value32 = viewtext32.text.toString().toIntOrNull() ?: 0
                                    val value33 = viewtext33.text.toString().toIntOrNull() ?: 0
                                    val value34 = viewtext34.text.toString().toIntOrNull() ?: 0
                                    val value35 = viewtext35.text.toString().toIntOrNull() ?: 0
                                    val value36 = viewtext36.text.toString().toIntOrNull() ?: 0
                                    val value37 = viewtext37.text.toString().toIntOrNull() ?: 0
                                    val value38 = viewtext38.text.toString().toIntOrNull() ?: 0
                                    val value39 = viewtext39.text.toString().toIntOrNull() ?: 0
                                    val value40 = viewtext40.text.toString().toIntOrNull() ?: 0
                                    val value41 = viewtext41.text.toString().toIntOrNull() ?: 0
                                    val value42 = viewtext42.text.toString().toIntOrNull() ?: 0
                                    val value43 = viewtext43.text.toString().toIntOrNull() ?: 0
                                    val value44 = viewtext44.text.toString().toIntOrNull() ?: 0
                                    val value45 = viewtext45.text.toString().toIntOrNull() ?: 0
                                    val value46 = viewtext46.text.toString().toIntOrNull() ?: 0
                                    val value47 = viewtext47.text.toString().toIntOrNull() ?: 0
                                    val value48 = viewtext48.text.toString().toIntOrNull() ?: 0
                                    val value49 = viewtext49.text.toString().toIntOrNull() ?: 0
                                    val value50 = viewtext50.text.toString().toIntOrNull() ?: 0
                                    val value51 = viewtext51.text.toString().toIntOrNull() ?: 0
                                    val value52 = viewtext52.text.toString().toIntOrNull() ?: 0
                                    val value53 = viewtext53.text.toString().toIntOrNull() ?: 0
                                    val value54 = viewtext54.text.toString().toIntOrNull() ?: 0
                                    val value55 = viewtext55.text.toString().toIntOrNull() ?: 0
                                    val value56 = viewtext56.text.toString().toIntOrNull() ?: 0
                                    val value57 = viewtext57.text.toString().toIntOrNull() ?: 0
                                    val value58 = viewtext58.text.toString().toIntOrNull() ?: 0
                                    val value59 = viewtext59.text.toString().toIntOrNull() ?: 0

                                    sum = (value1 + value2 + value3 + value4  + value5 +
                                            value6 + value7  + value8  + value9 + value10 + value11 +
                                            value12 + value13 + value14 + value15  + value16  + value17 +
                                            value18 + value19  + value20  + value21 + value22 + value23 +
                                            value24 + value25 + value26 + value27  + value28  + value29 +
                                            value30 + value31  + value32  + value33 + value34 + value35 +
                                            value36 + value37 + value38 + value39  + value40  + value41 +
                                            value42 + value43  + value44  + value45 + value46 + value47 +
                                            value48 + value49 + value50 + value51  + value52  + value53 +
                                            value54 + value55  + value56  + value57 + value58 + value59).toString()

                                    totalall_E_D.text = (sum)
                                }

                                override fun afterTextChanged(s: Editable?) {
                                }
                            })
                        }
                    }

                    if (item.checkData.check3_5.isNotEmpty()){
                        customDialogFB.apply {
                            checkBoxauto47.setText(item.checkData.check3_5)
                            checkBoxauto47.setTextColor(Color.parseColor("#000000"))
                            checkBoxauto47.layoutParams = LinearLayout.LayoutParams(
                                ViewGroup.LayoutParams.WRAP_CONTENT,
                                ViewGroup.LayoutParams.WRAP_CONTENT, Float.MIN_VALUE)
                            viewtext47.setText(item.checkData.price3_5)
                            viewtext47.setTextColor(Color.parseColor("#000000"))
                            p47.addView(viewtext47)
                            L_c47.addView(checkBoxauto47)
                            viewtext47.setSelectAllOnFocus(true)
                            checkBoxauto47.setSelectAllOnFocus(true)
                            checkBoxauto47.textSize = 14f
                            checkBoxauto47.setTypeface(null, Typeface.BOLD)
                            checkBoxauto47.isSingleLine = true
                            viewtext47.isSingleLine = true
                            viewtext47.textSize = 14f
                            viewtext47.inputType = InputType.TYPE_CLASS_PHONE

                            viewtext47.addTextChangedListener(object : TextWatcher {
                                override fun beforeTextChanged(
                                    s: CharSequence?,
                                    start: Int,
                                    count: Int,
                                    after: Int
                                ) {
                                }

                                override fun onTextChanged(
                                    s: CharSequence?,
                                    start: Int,
                                    before: Int,
                                    count: Int
                                ) {
                                    val value1 = viewtext1.text.toString().toIntOrNull() ?: 0
                                    val value2 = viewtext2.text.toString().toIntOrNull() ?: 0
                                    val value3 = viewtext3.text.toString().toIntOrNull() ?: 0
                                    val value4 = viewtext4.text.toString().toIntOrNull() ?: 0
                                    val value5 = viewtext5.text.toString().toIntOrNull() ?: 0
                                    val value6 = viewtext6.text.toString().toIntOrNull() ?: 0
                                    val value7 = viewtext7.text.toString().toIntOrNull() ?: 0
                                    val value8 = viewtext8.text.toString().toIntOrNull() ?: 0
                                    val value9 = viewtext9.text.toString().toIntOrNull() ?: 0
                                    val value10 = viewtext10.text.toString().toIntOrNull() ?: 0
                                    val value11 = viewtext11.text.toString().toIntOrNull() ?: 0
                                    val value12 = viewtext12.text.toString().toIntOrNull() ?: 0
                                    val value13 = viewtext13.text.toString().toIntOrNull() ?: 0
                                    val value14 = viewtext14.text.toString().toIntOrNull() ?: 0
                                    val value15 = viewtext15.text.toString().toIntOrNull() ?: 0
                                    val value16 = viewtext16.text.toString().toIntOrNull() ?: 0
                                    val value17 = viewtext17.text.toString().toIntOrNull() ?: 0
                                    val value18 = viewtext18.text.toString().toIntOrNull() ?: 0
                                    val value19 = viewtext19.text.toString().toIntOrNull() ?: 0
                                    val value20 = viewtext20.text.toString().toIntOrNull() ?: 0
                                    val value21 = viewtext21.text.toString().toIntOrNull() ?: 0
                                    val value22 = viewtext22.text.toString().toIntOrNull() ?: 0
                                    val value23 = viewtext23.text.toString().toIntOrNull() ?: 0
                                    val value24 = viewtext24.text.toString().toIntOrNull() ?: 0
                                    val value25 = viewtext25.text.toString().toIntOrNull() ?: 0
                                    val value26 = viewtext26.text.toString().toIntOrNull() ?: 0
                                    val value27 = viewtext27.text.toString().toIntOrNull() ?: 0
                                    val value28 = viewtext28.text.toString().toIntOrNull() ?: 0
                                    val value29 = viewtext29.text.toString().toIntOrNull() ?: 0
                                    val value30 = viewtext30.text.toString().toIntOrNull() ?: 0
                                    val value31 = viewtext31.text.toString().toIntOrNull() ?: 0
                                    val value32 = viewtext32.text.toString().toIntOrNull() ?: 0
                                    val value33 = viewtext33.text.toString().toIntOrNull() ?: 0
                                    val value34 = viewtext34.text.toString().toIntOrNull() ?: 0
                                    val value35 = viewtext35.text.toString().toIntOrNull() ?: 0
                                    val value36 = viewtext36.text.toString().toIntOrNull() ?: 0
                                    val value37 = viewtext37.text.toString().toIntOrNull() ?: 0
                                    val value38 = viewtext38.text.toString().toIntOrNull() ?: 0
                                    val value39 = viewtext39.text.toString().toIntOrNull() ?: 0
                                    val value40 = viewtext40.text.toString().toIntOrNull() ?: 0
                                    val value41 = viewtext41.text.toString().toIntOrNull() ?: 0
                                    val value42 = viewtext42.text.toString().toIntOrNull() ?: 0
                                    val value43 = viewtext43.text.toString().toIntOrNull() ?: 0
                                    val value44 = viewtext44.text.toString().toIntOrNull() ?: 0
                                    val value45 = viewtext45.text.toString().toIntOrNull() ?: 0
                                    val value46 = viewtext46.text.toString().toIntOrNull() ?: 0
                                    val value47 = viewtext47.text.toString().toIntOrNull() ?: 0
                                    val value48 = viewtext48.text.toString().toIntOrNull() ?: 0
                                    val value49 = viewtext49.text.toString().toIntOrNull() ?: 0
                                    val value50 = viewtext50.text.toString().toIntOrNull() ?: 0
                                    val value51 = viewtext51.text.toString().toIntOrNull() ?: 0
                                    val value52 = viewtext52.text.toString().toIntOrNull() ?: 0
                                    val value53 = viewtext53.text.toString().toIntOrNull() ?: 0
                                    val value54 = viewtext54.text.toString().toIntOrNull() ?: 0
                                    val value55 = viewtext55.text.toString().toIntOrNull() ?: 0
                                    val value56 = viewtext56.text.toString().toIntOrNull() ?: 0
                                    val value57 = viewtext57.text.toString().toIntOrNull() ?: 0
                                    val value58 = viewtext58.text.toString().toIntOrNull() ?: 0
                                    val value59 = viewtext59.text.toString().toIntOrNull() ?: 0

                                    sum = (value1 + value2 + value3 + value4  + value5 +
                                            value6 + value7  + value8  + value9 + value10 + value11 +
                                            value12 + value13 + value14 + value15  + value16  + value17 +
                                            value18 + value19  + value20  + value21 + value22 + value23 +
                                            value24 + value25 + value26 + value27  + value28  + value29 +
                                            value30 + value31  + value32  + value33 + value34 + value35 +
                                            value36 + value37 + value38 + value39  + value40  + value41 +
                                            value42 + value43  + value44  + value45 + value46 + value47 +
                                            value48 + value49 + value50 + value51  + value52  + value53 +
                                            value54 + value55  + value56  + value57 + value58 + value59).toString()

                                    totalall_E_D.text = (sum)
                                }

                                override fun afterTextChanged(s: Editable?) {
                                }
                            })
                        }
                    }

                    if (item.checkData.check3_6.isNotEmpty()){
                        customDialogFB.apply {
                            checkBoxauto48.setText(item.checkData.check3_6)
                            checkBoxauto48.setTextColor(Color.parseColor("#000000"))
                            checkBoxauto48.layoutParams = LinearLayout.LayoutParams(
                                ViewGroup.LayoutParams.WRAP_CONTENT,
                                ViewGroup.LayoutParams.WRAP_CONTENT, Float.MIN_VALUE)
                            viewtext48.setText(item.checkData.price3_6)
                            viewtext48.setTextColor(Color.parseColor("#000000"))
                            p48.addView(viewtext48)
                            L_c48.addView(checkBoxauto48)
                            viewtext48.setSelectAllOnFocus(true)
                            checkBoxauto48.setSelectAllOnFocus(true)
                            checkBoxauto48.textSize = 14f
                            checkBoxauto48.setTypeface(null, Typeface.BOLD)
                            checkBoxauto48.isSingleLine = true
                            viewtext48.isSingleLine = true
                            viewtext48.textSize = 14f
                            viewtext48.inputType = InputType.TYPE_CLASS_PHONE

                            viewtext48.addTextChangedListener(object : TextWatcher {
                                override fun beforeTextChanged(
                                    s: CharSequence?,
                                    start: Int,
                                    count: Int,
                                    after: Int
                                ) {
                                }

                                override fun onTextChanged(
                                    s: CharSequence?,
                                    start: Int,
                                    before: Int,
                                    count: Int
                                ) {
                                    val value1 = viewtext1.text.toString().toIntOrNull() ?: 0
                                    val value2 = viewtext2.text.toString().toIntOrNull() ?: 0
                                    val value3 = viewtext3.text.toString().toIntOrNull() ?: 0
                                    val value4 = viewtext4.text.toString().toIntOrNull() ?: 0
                                    val value5 = viewtext5.text.toString().toIntOrNull() ?: 0
                                    val value6 = viewtext6.text.toString().toIntOrNull() ?: 0
                                    val value7 = viewtext7.text.toString().toIntOrNull() ?: 0
                                    val value8 = viewtext8.text.toString().toIntOrNull() ?: 0
                                    val value9 = viewtext9.text.toString().toIntOrNull() ?: 0
                                    val value10 = viewtext10.text.toString().toIntOrNull() ?: 0
                                    val value11 = viewtext11.text.toString().toIntOrNull() ?: 0
                                    val value12 = viewtext12.text.toString().toIntOrNull() ?: 0
                                    val value13 = viewtext13.text.toString().toIntOrNull() ?: 0
                                    val value14 = viewtext14.text.toString().toIntOrNull() ?: 0
                                    val value15 = viewtext15.text.toString().toIntOrNull() ?: 0
                                    val value16 = viewtext16.text.toString().toIntOrNull() ?: 0
                                    val value17 = viewtext17.text.toString().toIntOrNull() ?: 0
                                    val value18 = viewtext18.text.toString().toIntOrNull() ?: 0
                                    val value19 = viewtext19.text.toString().toIntOrNull() ?: 0
                                    val value20 = viewtext20.text.toString().toIntOrNull() ?: 0
                                    val value21 = viewtext21.text.toString().toIntOrNull() ?: 0
                                    val value22 = viewtext22.text.toString().toIntOrNull() ?: 0
                                    val value23 = viewtext23.text.toString().toIntOrNull() ?: 0
                                    val value24 = viewtext24.text.toString().toIntOrNull() ?: 0
                                    val value25 = viewtext25.text.toString().toIntOrNull() ?: 0
                                    val value26 = viewtext26.text.toString().toIntOrNull() ?: 0
                                    val value27 = viewtext27.text.toString().toIntOrNull() ?: 0
                                    val value28 = viewtext28.text.toString().toIntOrNull() ?: 0
                                    val value29 = viewtext29.text.toString().toIntOrNull() ?: 0
                                    val value30 = viewtext30.text.toString().toIntOrNull() ?: 0
                                    val value31 = viewtext31.text.toString().toIntOrNull() ?: 0
                                    val value32 = viewtext32.text.toString().toIntOrNull() ?: 0
                                    val value33 = viewtext33.text.toString().toIntOrNull() ?: 0
                                    val value34 = viewtext34.text.toString().toIntOrNull() ?: 0
                                    val value35 = viewtext35.text.toString().toIntOrNull() ?: 0
                                    val value36 = viewtext36.text.toString().toIntOrNull() ?: 0
                                    val value37 = viewtext37.text.toString().toIntOrNull() ?: 0
                                    val value38 = viewtext38.text.toString().toIntOrNull() ?: 0
                                    val value39 = viewtext39.text.toString().toIntOrNull() ?: 0
                                    val value40 = viewtext40.text.toString().toIntOrNull() ?: 0
                                    val value41 = viewtext41.text.toString().toIntOrNull() ?: 0
                                    val value42 = viewtext42.text.toString().toIntOrNull() ?: 0
                                    val value43 = viewtext43.text.toString().toIntOrNull() ?: 0
                                    val value44 = viewtext44.text.toString().toIntOrNull() ?: 0
                                    val value45 = viewtext45.text.toString().toIntOrNull() ?: 0
                                    val value46 = viewtext46.text.toString().toIntOrNull() ?: 0
                                    val value47 = viewtext47.text.toString().toIntOrNull() ?: 0
                                    val value48 = viewtext48.text.toString().toIntOrNull() ?: 0
                                    val value49 = viewtext49.text.toString().toIntOrNull() ?: 0
                                    val value50 = viewtext50.text.toString().toIntOrNull() ?: 0
                                    val value51 = viewtext51.text.toString().toIntOrNull() ?: 0
                                    val value52 = viewtext52.text.toString().toIntOrNull() ?: 0
                                    val value53 = viewtext53.text.toString().toIntOrNull() ?: 0
                                    val value54 = viewtext54.text.toString().toIntOrNull() ?: 0
                                    val value55 = viewtext55.text.toString().toIntOrNull() ?: 0
                                    val value56 = viewtext56.text.toString().toIntOrNull() ?: 0
                                    val value57 = viewtext57.text.toString().toIntOrNull() ?: 0
                                    val value58 = viewtext58.text.toString().toIntOrNull() ?: 0
                                    val value59 = viewtext59.text.toString().toIntOrNull() ?: 0

                                    sum = (value1 + value2 + value3 + value4  + value5 +
                                            value6 + value7  + value8  + value9 + value10 + value11 +
                                            value12 + value13 + value14 + value15  + value16  + value17 +
                                            value18 + value19  + value20  + value21 + value22 + value23 +
                                            value24 + value25 + value26 + value27  + value28  + value29 +
                                            value30 + value31  + value32  + value33 + value34 + value35 +
                                            value36 + value37 + value38 + value39  + value40  + value41 +
                                            value42 + value43  + value44  + value45 + value46 + value47 +
                                            value48 + value49 + value50 + value51  + value52  + value53 +
                                            value54 + value55  + value56  + value57 + value58 + value59).toString()

                                    totalall_E_D.text = (sum)
                                }

                                override fun afterTextChanged(s: Editable?) {
                                }
                            })
                        }
                    }

                    if (item.checkData.check3_7.isNotEmpty()){
                        customDialogFB.apply {
                            checkBoxauto49.setText(item.checkData.check3_7)
                            checkBoxauto49.setTextColor(Color.parseColor("#000000"))
                            checkBoxauto49.layoutParams = LinearLayout.LayoutParams(
                                ViewGroup.LayoutParams.WRAP_CONTENT,
                                ViewGroup.LayoutParams.WRAP_CONTENT, Float.MIN_VALUE)
                            viewtext49.setText(item.checkData.price3_7)
                            viewtext49.setTextColor(Color.parseColor("#000000"))
                            p49.addView(viewtext49)
                            L_c49.addView(checkBoxauto49)
                            viewtext49.setSelectAllOnFocus(true)
                            checkBoxauto49.setSelectAllOnFocus(true)
                            checkBoxauto49.textSize = 14f
                            checkBoxauto49.setTypeface(null, Typeface.BOLD)
                            checkBoxauto49.isSingleLine = true
                            viewtext49.isSingleLine = true
                            viewtext49.textSize = 14f
                            viewtext49.inputType = InputType.TYPE_CLASS_PHONE

                            viewtext49.addTextChangedListener(object : TextWatcher {
                                override fun beforeTextChanged(
                                    s: CharSequence?,
                                    start: Int,
                                    count: Int,
                                    after: Int
                                ) {
                                }

                                override fun onTextChanged(
                                    s: CharSequence?,
                                    start: Int,
                                    before: Int,
                                    count: Int
                                ) {
                                    val value1 = viewtext1.text.toString().toIntOrNull() ?: 0
                                    val value2 = viewtext2.text.toString().toIntOrNull() ?: 0
                                    val value3 = viewtext3.text.toString().toIntOrNull() ?: 0
                                    val value4 = viewtext4.text.toString().toIntOrNull() ?: 0
                                    val value5 = viewtext5.text.toString().toIntOrNull() ?: 0
                                    val value6 = viewtext6.text.toString().toIntOrNull() ?: 0
                                    val value7 = viewtext7.text.toString().toIntOrNull() ?: 0
                                    val value8 = viewtext8.text.toString().toIntOrNull() ?: 0
                                    val value9 = viewtext9.text.toString().toIntOrNull() ?: 0
                                    val value10 = viewtext10.text.toString().toIntOrNull() ?: 0
                                    val value11 = viewtext11.text.toString().toIntOrNull() ?: 0
                                    val value12 = viewtext12.text.toString().toIntOrNull() ?: 0
                                    val value13 = viewtext13.text.toString().toIntOrNull() ?: 0
                                    val value14 = viewtext14.text.toString().toIntOrNull() ?: 0
                                    val value15 = viewtext15.text.toString().toIntOrNull() ?: 0
                                    val value16 = viewtext16.text.toString().toIntOrNull() ?: 0
                                    val value17 = viewtext17.text.toString().toIntOrNull() ?: 0
                                    val value18 = viewtext18.text.toString().toIntOrNull() ?: 0
                                    val value19 = viewtext19.text.toString().toIntOrNull() ?: 0
                                    val value20 = viewtext20.text.toString().toIntOrNull() ?: 0
                                    val value21 = viewtext21.text.toString().toIntOrNull() ?: 0
                                    val value22 = viewtext22.text.toString().toIntOrNull() ?: 0
                                    val value23 = viewtext23.text.toString().toIntOrNull() ?: 0
                                    val value24 = viewtext24.text.toString().toIntOrNull() ?: 0
                                    val value25 = viewtext25.text.toString().toIntOrNull() ?: 0
                                    val value26 = viewtext26.text.toString().toIntOrNull() ?: 0
                                    val value27 = viewtext27.text.toString().toIntOrNull() ?: 0
                                    val value28 = viewtext28.text.toString().toIntOrNull() ?: 0
                                    val value29 = viewtext29.text.toString().toIntOrNull() ?: 0
                                    val value30 = viewtext30.text.toString().toIntOrNull() ?: 0
                                    val value31 = viewtext31.text.toString().toIntOrNull() ?: 0
                                    val value32 = viewtext32.text.toString().toIntOrNull() ?: 0
                                    val value33 = viewtext33.text.toString().toIntOrNull() ?: 0
                                    val value34 = viewtext34.text.toString().toIntOrNull() ?: 0
                                    val value35 = viewtext35.text.toString().toIntOrNull() ?: 0
                                    val value36 = viewtext36.text.toString().toIntOrNull() ?: 0
                                    val value37 = viewtext37.text.toString().toIntOrNull() ?: 0
                                    val value38 = viewtext38.text.toString().toIntOrNull() ?: 0
                                    val value39 = viewtext39.text.toString().toIntOrNull() ?: 0
                                    val value40 = viewtext40.text.toString().toIntOrNull() ?: 0
                                    val value41 = viewtext41.text.toString().toIntOrNull() ?: 0
                                    val value42 = viewtext42.text.toString().toIntOrNull() ?: 0
                                    val value43 = viewtext43.text.toString().toIntOrNull() ?: 0
                                    val value44 = viewtext44.text.toString().toIntOrNull() ?: 0
                                    val value45 = viewtext45.text.toString().toIntOrNull() ?: 0
                                    val value46 = viewtext46.text.toString().toIntOrNull() ?: 0
                                    val value47 = viewtext47.text.toString().toIntOrNull() ?: 0
                                    val value48 = viewtext48.text.toString().toIntOrNull() ?: 0
                                    val value49 = viewtext49.text.toString().toIntOrNull() ?: 0
                                    val value50 = viewtext50.text.toString().toIntOrNull() ?: 0
                                    val value51 = viewtext51.text.toString().toIntOrNull() ?: 0
                                    val value52 = viewtext52.text.toString().toIntOrNull() ?: 0
                                    val value53 = viewtext53.text.toString().toIntOrNull() ?: 0
                                    val value54 = viewtext54.text.toString().toIntOrNull() ?: 0
                                    val value55 = viewtext55.text.toString().toIntOrNull() ?: 0
                                    val value56 = viewtext56.text.toString().toIntOrNull() ?: 0
                                    val value57 = viewtext57.text.toString().toIntOrNull() ?: 0
                                    val value58 = viewtext58.text.toString().toIntOrNull() ?: 0
                                    val value59 = viewtext59.text.toString().toIntOrNull() ?: 0

                                    sum = (value1 + value2 + value3 + value4  + value5 +
                                            value6 + value7  + value8  + value9 + value10 + value11 +
                                            value12 + value13 + value14 + value15  + value16  + value17 +
                                            value18 + value19  + value20  + value21 + value22 + value23 +
                                            value24 + value25 + value26 + value27  + value28  + value29 +
                                            value30 + value31  + value32  + value33 + value34 + value35 +
                                            value36 + value37 + value38 + value39  + value40  + value41 +
                                            value42 + value43  + value44  + value45 + value46 + value47 +
                                            value48 + value49 + value50 + value51  + value52  + value53 +
                                            value54 + value55  + value56  + value57 + value58 + value59).toString()

                                    totalall_E_D.text = (sum)
                                }

                                override fun afterTextChanged(s: Editable?) {
                                }
                            })
                        }
                    }

                    if (item.checkData.check3_8.isNotEmpty()){
                        customDialogFB.apply {
                            checkBoxauto50.setText(item.checkData.check3_8)
                            checkBoxauto50.setTextColor(Color.parseColor("#000000"))
                            checkBoxauto50.layoutParams = LinearLayout.LayoutParams(
                                ViewGroup.LayoutParams.WRAP_CONTENT,
                                ViewGroup.LayoutParams.WRAP_CONTENT, Float.MIN_VALUE)
                            viewtext50.setText(item.checkData.price3_8)
                            viewtext50.setTextColor(Color.parseColor("#000000"))
                            p50.addView(viewtext50)
                            L_c50.addView(checkBoxauto50)
                            viewtext50.setSelectAllOnFocus(true)
                            checkBoxauto50.setSelectAllOnFocus(true)
                            checkBoxauto50.textSize = 14f
                            checkBoxauto50.setTypeface(null, Typeface.BOLD)
                            checkBoxauto50.isSingleLine = true
                            viewtext50.isSingleLine = true
                            viewtext50.textSize = 14f
                            viewtext50.inputType = InputType.TYPE_CLASS_PHONE

                            viewtext50.addTextChangedListener(object : TextWatcher {
                                override fun beforeTextChanged(
                                    s: CharSequence?,
                                    start: Int,
                                    count: Int,
                                    after: Int
                                ) {
                                }

                                override fun onTextChanged(
                                    s: CharSequence?,
                                    start: Int,
                                    before: Int,
                                    count: Int
                                ) {
                                    val value1 = viewtext1.text.toString().toIntOrNull() ?: 0
                                    val value2 = viewtext2.text.toString().toIntOrNull() ?: 0
                                    val value3 = viewtext3.text.toString().toIntOrNull() ?: 0
                                    val value4 = viewtext4.text.toString().toIntOrNull() ?: 0
                                    val value5 = viewtext5.text.toString().toIntOrNull() ?: 0
                                    val value6 = viewtext6.text.toString().toIntOrNull() ?: 0
                                    val value7 = viewtext7.text.toString().toIntOrNull() ?: 0
                                    val value8 = viewtext8.text.toString().toIntOrNull() ?: 0
                                    val value9 = viewtext9.text.toString().toIntOrNull() ?: 0
                                    val value10 = viewtext10.text.toString().toIntOrNull() ?: 0
                                    val value11 = viewtext11.text.toString().toIntOrNull() ?: 0
                                    val value12 = viewtext12.text.toString().toIntOrNull() ?: 0
                                    val value13 = viewtext13.text.toString().toIntOrNull() ?: 0
                                    val value14 = viewtext14.text.toString().toIntOrNull() ?: 0
                                    val value15 = viewtext15.text.toString().toIntOrNull() ?: 0
                                    val value16 = viewtext16.text.toString().toIntOrNull() ?: 0
                                    val value17 = viewtext17.text.toString().toIntOrNull() ?: 0
                                    val value18 = viewtext18.text.toString().toIntOrNull() ?: 0
                                    val value19 = viewtext19.text.toString().toIntOrNull() ?: 0
                                    val value20 = viewtext20.text.toString().toIntOrNull() ?: 0
                                    val value21 = viewtext21.text.toString().toIntOrNull() ?: 0
                                    val value22 = viewtext22.text.toString().toIntOrNull() ?: 0
                                    val value23 = viewtext23.text.toString().toIntOrNull() ?: 0
                                    val value24 = viewtext24.text.toString().toIntOrNull() ?: 0
                                    val value25 = viewtext25.text.toString().toIntOrNull() ?: 0
                                    val value26 = viewtext26.text.toString().toIntOrNull() ?: 0
                                    val value27 = viewtext27.text.toString().toIntOrNull() ?: 0
                                    val value28 = viewtext28.text.toString().toIntOrNull() ?: 0
                                    val value29 = viewtext29.text.toString().toIntOrNull() ?: 0
                                    val value30 = viewtext30.text.toString().toIntOrNull() ?: 0
                                    val value31 = viewtext31.text.toString().toIntOrNull() ?: 0
                                    val value32 = viewtext32.text.toString().toIntOrNull() ?: 0
                                    val value33 = viewtext33.text.toString().toIntOrNull() ?: 0
                                    val value34 = viewtext34.text.toString().toIntOrNull() ?: 0
                                    val value35 = viewtext35.text.toString().toIntOrNull() ?: 0
                                    val value36 = viewtext36.text.toString().toIntOrNull() ?: 0
                                    val value37 = viewtext37.text.toString().toIntOrNull() ?: 0
                                    val value38 = viewtext38.text.toString().toIntOrNull() ?: 0
                                    val value39 = viewtext39.text.toString().toIntOrNull() ?: 0
                                    val value40 = viewtext40.text.toString().toIntOrNull() ?: 0
                                    val value41 = viewtext41.text.toString().toIntOrNull() ?: 0
                                    val value42 = viewtext42.text.toString().toIntOrNull() ?: 0
                                    val value43 = viewtext43.text.toString().toIntOrNull() ?: 0
                                    val value44 = viewtext44.text.toString().toIntOrNull() ?: 0
                                    val value45 = viewtext45.text.toString().toIntOrNull() ?: 0
                                    val value46 = viewtext46.text.toString().toIntOrNull() ?: 0
                                    val value47 = viewtext47.text.toString().toIntOrNull() ?: 0
                                    val value48 = viewtext48.text.toString().toIntOrNull() ?: 0
                                    val value49 = viewtext49.text.toString().toIntOrNull() ?: 0
                                    val value50 = viewtext50.text.toString().toIntOrNull() ?: 0
                                    val value51 = viewtext51.text.toString().toIntOrNull() ?: 0
                                    val value52 = viewtext52.text.toString().toIntOrNull() ?: 0
                                    val value53 = viewtext53.text.toString().toIntOrNull() ?: 0
                                    val value54 = viewtext54.text.toString().toIntOrNull() ?: 0
                                    val value55 = viewtext55.text.toString().toIntOrNull() ?: 0
                                    val value56 = viewtext56.text.toString().toIntOrNull() ?: 0
                                    val value57 = viewtext57.text.toString().toIntOrNull() ?: 0
                                    val value58 = viewtext58.text.toString().toIntOrNull() ?: 0
                                    val value59 = viewtext59.text.toString().toIntOrNull() ?: 0

                                    sum = (value1 + value2 + value3 + value4  + value5 +
                                            value6 + value7  + value8  + value9 + value10 + value11 +
                                            value12 + value13 + value14 + value15  + value16  + value17 +
                                            value18 + value19  + value20  + value21 + value22 + value23 +
                                            value24 + value25 + value26 + value27  + value28  + value29 +
                                            value30 + value31  + value32  + value33 + value34 + value35 +
                                            value36 + value37 + value38 + value39  + value40  + value41 +
                                            value42 + value43  + value44  + value45 + value46 + value47 +
                                            value48 + value49 + value50 + value51  + value52  + value53 +
                                            value54 + value55  + value56  + value57 + value58 + value59).toString()

                                    totalall_E_D.text = (sum)
                                }

                                override fun afterTextChanged(s: Editable?) {
                                }
                            })
                        }
                    }

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
