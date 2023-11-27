package com.example.markizalhadidi.ui.Outcom

import android.annotation.SuppressLint
import android.app.Dialog
import android.content.Context
import android.net.ConnectivityManager
import android.os.Build
import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.Toast
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import com.example.markizalhadidi.R
import com.example.markizalhadidi.databinding.CalendarDailogBinding
import com.example.markizalhadidi.databinding.DialogDeleteBinding
import com.example.markizalhadidi.databinding.FragmentOutcomingBinding
import com.example.markizalhadidi.databinding.SearchDailogBinding
import com.example.markizalhadidi.model.Check9ader
import com.example.markizalhadidi.model.Check9aser
import com.example.markizalhadidi.model.CheckData
import com.example.markizalhadidi.model.User
import com.example.markizalhadidi.recyclerview.ShowData9ader
import com.example.markizalhadidi.ui.incom.IncomingViewModel
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ListenerRegistration
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.OnItemLongClickListener
import com.xwray.groupie.Section
import java.text.SimpleDateFormat
import java.time.LocalDate
import java.time.LocalTime
import java.util.*


class OutcomingFragment : Fragment() {

    private var _binding: FragmentOutcomingBinding? = null
    private val binding get() = _binding!!

    private lateinit var viewModelinc: IncomingViewModel

    private lateinit var mCurrentChatChannelId: String
    private var mCurrentUserId = FirebaseAuth.getInstance().currentUser!!.uid
    private val firestoreInstance: FirebaseFirestore by lazy { FirebaseFirestore.getInstance()}
    private val chatChannelsCollectionRef = firestoreInstance.collection("chatChannels")
    private lateinit var currentUser: User

    private lateinit var  otheruserid :String
    private lateinit var nEwChatCannelId1 : String

    private var totalQuantityincoming :Int=0
    private var totalQuantityOutcoming :Int=0
    private var total_solaf_mowazaf :Int=0

    private var counternam = 1
    private var counter8emah = 1
    private val messageAdapter by lazy { GroupAdapter<ShowData9ader.ViewHolder>() }
    private lateinit var chatSection: Section

    private lateinit var name_mowazaf :String

    var startDateo =""
    var endDateo =""

    private lateinit var customDialogSE: Dialog
    private lateinit var customDialogCALENDAR: Dialog
    private lateinit var customDialogDL: Dialog

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentOutcomingBinding.inflate(inflater, container, false)
        val root: View = binding.root

        otheruserid = "BC4qqF0IJndE4hnldFOJ4ocue9O2"

        viewModelinc = activity?.run {
            ViewModelProvider(this).get(IncomingViewModel::class.java)
        } ?: throw Exception("Invalid Activity")

        getUserInfo {user ->
            currentUser = user
        }

        var osem_al9der =""
        var wa9f_al9ader =""
        var qemet_al9ader =""

        binding.no3.isEnabled = false
        binding.description.isEnabled = false
        binding.n8ed.isEnabled = false
        binding.btnAdd9ader.isEnabled = false

        createChatChannel { channelId ->
            mCurrentChatChannelId = channelId
            getMessages(channelId,::initRecyclerView)
            getTotaloutcoming(channelId)

            val customDialogCAL = CalendarDailogBinding.inflate(layoutInflater)
            customDialogCALENDAR = Dialog(activity!!)
            customDialogCALENDAR.setContentView(customDialogCAL.root)
            customDialogCALENDAR.setCancelable(false)
            customDialogCALENDAR.window?.setLayout(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
            )

            val bindingSE = SearchDailogBinding.inflate(layoutInflater)
            customDialogSE = Dialog(activity!!)
            customDialogSE.setContentView(bindingSE.root)
            customDialogSE.setCancelable(false)
            customDialogSE.window?.setLayout(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
            )

            createChatChannel1 { channelId1 ->
                getTotalincoming(channelId1)

                val b59o9 = arrayOf(
                    "علي ملكاوي",
                    "مالك السخنة",
                    "صالح ابو راس",
                    "ابراهيم ابو راس",
                    "خالد المصري",
                    "سالم",
                    "م.احمد حديدي",
                    "عمار",
                    "مركز الحديدي"
                )
                val adapter =
                    ArrayAdapter(activity!!, android.R.layout.simple_spinner_dropdown_item, b59o9)
                val autoCompleteTextView = activity!!.findViewById<AutoCompleteTextView>(R.id.no3)
                autoCompleteTextView.threshold = 0
                autoCompleteTextView.setAdapter(adapter)

                val toolbar = activity?.findViewById<Toolbar>(R.id.toolbar)
                toolbar?.setTitleTextAppearance(this.context, R.style.boldText)

                binding.btnNew9ader.setOnClickListener {
                    val ref = chatChannelsCollectionRef.document(channelId).collection("messages")
                        .document()
                    ref.set(mapOf<String, Any>())
                        .addOnSuccessListener {
                            nEwChatCannelId1 = ref.id
                            counternam = 1
                            counter8emah = 1
                            binding.description.setText("")
                            binding.btnNew9ader.isEnabled = false
                            binding.no3.isEnabled = true
                            binding.description.isEnabled = true
                            binding.n8ed.isEnabled = true
                            binding.btnAdd9ader.isEnabled = true
                            binding.no3.requestFocus()
                        }
                }

                binding.btnAdd9ader.setOnClickListener {

                    if (binding.no3.text.toString().trim().isEmpty()) {
                        binding.no3.error = "يجب عدم ترك الخانة فارغة"
                        binding.no3.requestFocus()
                        return@setOnClickListener
                    }
                    if (binding.description.text.toString().trim().isEmpty()) {
                        binding.description.error = "يجب عدم ترك الخانة فارغة"
                        binding.description.requestFocus()
                        return@setOnClickListener
                    }
                    if (binding.n8ed.text.toString().trim().isEmpty()) {
                        binding.n8ed.error = "يجب عدم ترك الخانة فارغة"
                        binding.n8ed.requestFocus()
                        return@setOnClickListener
                    }
                    osem_al9der = binding.no3.text.toString().trim()
                    wa9f_al9ader = binding.description.text.toString().trim()
                    qemet_al9ader = binding.n8ed.text.toString().trim()

                    val content = Check9aser(
                        currentUser.name,
                        Calendar.getInstance().time,
                        currentUser.name,
                        osem_al9der,
                        wa9f_al9ader,

                        "",
                        "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "",
                        qemet_al9ader,
                        "",
                        "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", ""
                    )
                    creatdocument(
                        channelId, content
                    )
                    binding.description.setText("")
                    binding.n8ed.setText("")
                    binding.btnNew9ader.isEnabled = true
                    binding.no3.isEnabled = false
                    getTotaloutcoming(channelId)
                    getTotalincoming(channelId1)
                }


                binding.dialogSearch.setOnClickListener {

                    bindingSE.btnStartDate.setOnClickListener {

                        customDialogCAL.calendarView.setOnDateChangeListener { view, year, month, day ->
                            val month1 = month +1
                            bindingSE.texStartDate.setText("$year-$month1-$day").toString()
                            startDateo +="$year-$month1-$day 00:00"
                            customDialogCALENDAR.dismiss()
                        }
                        customDialogCALENDAR.show()
                        customDialogSE.show()
                    }

                    bindingSE.btnEndDate.setOnClickListener {
                        customDialogCAL.calendarView.setOnDateChangeListener { view, year, month, day ->
                            val month = month +1
                            bindingSE.texEndDate.setText("$year-$month-$day").toString()
                            endDateo +="$year-$month-$day 23:59:59"

                            customDialogCALENDAR.dismiss()
                        }
                        customDialogCALENDAR.show()
                        customDialogSE.show()
                    }

                    val adapter1 =
                        ArrayAdapter(activity!!, android.R.layout.simple_spinner_dropdown_item, b59o9)
                    val autoCompleteTextView1 = customDialogSE.findViewById<AutoCompleteTextView>(R.id.search_out)
                    autoCompleteTextView1.threshold = 0
                    autoCompleteTextView1.setAdapter(adapter1)

                    bindingSE.searchName.setOnClickListener {

                        if (bindingSE.searchOut.text.toString().isEmpty() &&
                            bindingSE.texStartDate.text.toString().isEmpty() &&
                            bindingSE.texEndDate.text.toString().isEmpty()    ) {
                            Toast.makeText(
                                requireContext(),
                                "يجب تحديد فترة زمنيه أو وضع اسم",
                                Toast.LENGTH_LONG
                            ).show()
                        }

                        if (bindingSE.searchOut.text.toString().isNotEmpty() &&
                            bindingSE.texStartDate.text.toString().isEmpty() &&
                            bindingSE.texEndDate.text.toString().isNotEmpty()    ) {
                                Toast.makeText(
                                requireContext(),
                                "يجب وضع تاريخ البداية",
                                Toast.LENGTH_LONG
                            ).show()
                        }

                        if (bindingSE.searchOut.text.toString().isNotEmpty() &&
                            bindingSE.texStartDate.text.toString().isNotEmpty() &&
                            bindingSE.texEndDate.text.toString().isEmpty()    ) {
                                Toast.makeText(
                                requireContext(),
                                "يجب تاريخ وضع النهاية",
                                Toast.LENGTH_LONG
                            ).show()
                        }

                        if (bindingSE.searchOut.text.toString().isNotEmpty() &&
                            bindingSE.texStartDate.text.toString().isNotEmpty() &&
                            bindingSE.texEndDate.text.toString().isNotEmpty()) {
                            val name = bindingSE.searchOut.text.toString()
                            val dateFormat_start = SimpleDateFormat("yyy-MM-dd hh:mm")
                            val date1 = startDateo
                            val date_start = dateFormat_start.parse(date1)
                            val startDate_cal = com.google.firebase.Timestamp(date_start)
                            val dateFormat_end = SimpleDateFormat("yyy-MM-dd hh:mm:ss")
                            val date2 = endDateo
                            val date_end = dateFormat_end.parse(date2)
                            val endtDate_cal = com.google.firebase.Timestamp(date_end)
                            chatChannelsCollectionRef.document(channelId).collection("messages")
                                .orderBy("date")
                                .whereGreaterThanOrEqualTo("date", startDate_cal)
                                .whereLessThanOrEqualTo("date", endtDate_cal)
                                .whereEqualTo("name9ader", name)
                                .get()
                                .addOnCompleteListener { task ->
                                    if (task.isSuccessful) {
                                        total_solaf_mowazaf =0
                                        for (i in task.result!!.documents) {
                                            for ((key, value) in i.data!!) {
                                                if (key.startsWith("qemet9ader")) {
                                                    total_solaf_mowazaf += value.toString().toInt()
                                                }
                                            }
                                            name_mowazaf =
                                                i.toObject(Check9ader::class.java)!!.name9ader
                                        }
                                        toolbar?.title =
                                            "مصروفات " + (name_mowazaf + " " + total_solaf_mowazaf.toString())
                                    }
                                }
                        }
                        else{
                            if (bindingSE.searchOut.text.toString().isEmpty() &&
                                bindingSE.texStartDate.text.toString().isEmpty() &&
                                bindingSE.texEndDate.text.toString().isNotEmpty()    ) {
                                        Toast.makeText(
                                        requireContext(),
                                        "يجب وضع تاريخ البداية",
                                        Toast.LENGTH_LONG
                                    ).show()
                                }

                                if (bindingSE.searchOut.text.toString().isEmpty() &&
                                    bindingSE.texStartDate.text.toString().isNotEmpty() &&
                                    bindingSE.texEndDate.text.toString().isEmpty()    ) {
                                        Toast.makeText(
                                        requireContext(),
                                        "يجب تاريخ وضع النهاية",
                                        Toast.LENGTH_LONG
                                    ).show()
                            }

                            if (bindingSE.searchOut.text.toString().isEmpty() &&
                                bindingSE.texStartDate.text.toString().isNotEmpty() &&
                                bindingSE.texEndDate.text.toString().isNotEmpty()    ) {
                                val dateFormat_start = SimpleDateFormat("yyy-MM-dd hh:mm")
                                val date1 = startDateo
                                val date_start = dateFormat_start.parse(date1)
                                val startDate_cal = com.google.firebase.Timestamp(date_start)
                                val dateFormat_end = SimpleDateFormat("yyy-MM-dd hh:mm:ss")
                                val date2 = endDateo
                                val date_end = dateFormat_end.parse(date2)
                                val endtDate_cal = com.google.firebase.Timestamp(date_end)
                                chatChannelsCollectionRef.document(channelId).collection("messages")
                                    .orderBy("date")
                                    .whereGreaterThanOrEqualTo("date", startDate_cal)
                                    .whereLessThanOrEqualTo("date", endtDate_cal)
                                    .get()
                                    .addOnCompleteListener { task ->
                                        if (task.isSuccessful) {
                                            total_solaf_mowazaf =0
                                            for (i in task.result!!.documents) {
                                                for ((key, value) in i.data!!) {
                                                    if (key.startsWith("qemet9ader")) {
                                                        total_solaf_mowazaf += value.toString()
                                                            .toInt()
                                                    }
                                                }
                                                name_mowazaf =
                                                    i.toObject(Check9ader::class.java)!!.name9ader
                                            }
                                            toolbar?.title =
                                                "مصروفات " + ( total_solaf_mowazaf.toString())

                                        }
                                    }

                            }
                        }
                        getMessages(channelId,::initRecyclerView)
                        getTotaloutcoming(channelId)
                        bindingSE.texStartDate.text=""
                        bindingSE.texEndDate.text=""
                        bindingSE.searchOut.setText("")
                        customDialogSE.dismiss()
                    }
                    customDialogSE.show()
                }
        }
        }
        return root
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

    private fun getTotaloutcoming(channelId: String) {
        totalQuantityOutcoming=0
            chatChannelsCollectionRef.document(channelId).collection("messages")
                .orderBy("date")
                .startAt(startDate).endAt(endtDate)
                .get()
                .addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        for (i in task.result!!.documents) {
                            for ((key, value) in i.data!!) {
                                if (key.startsWith("qemet9ader")) {
                                    totalQuantityOutcoming += value.toString().toInt()
                                }
                            }
                        }
                        binding.outcoming.text = "مجموع الصادر " + totalQuantityOutcoming.toString()
                    }
                }
        }

    private fun getTotalincoming(channelId1: String) {
        totalQuantityincoming=0
        chatChannelsCollectionRef.document(channelId1).collection("messages")
            .orderBy("date")
            .startAt(startDate).endAt(endtDate)
            .get()
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    for (i in task.result!!.documents) {
                        if (i.toObject(CheckData::class.java)!!.cashPrice.isNotEmpty()) {
                            totalQuantityincoming += i.toObject(CheckData::class.java)!!.cashPrice.toInt()
                        }
                    }
                    binding.incoming.text="مجموع الكاش " + totalQuantityincoming.toString()
                    binding.total9ader.text = "صافي الدخل" + (totalQuantityincoming - totalQuantityOutcoming).toString()
                }
            }
    }
    private fun createChatChannel1(onComplete: (channelId1: String) -> Unit) {
        firestoreInstance.collection("users")
            .document(mCurrentUserId)
            .collection("sharedChat")
            .document(otheruserid)
            .get()
            .addOnSuccessListener { document ->
                if (document.exists()) {
                    onComplete(document["channelId"] as String)
                    return@addOnSuccessListener
                }
            }
    }

    private fun createChatChannel(onComplete: (channelId: String) -> Unit) {
        firestoreInstance.collection("users")
            .document(mCurrentUserId)
            .collection("sharedChat")
            .document(otheruserid+"2")
            .get()
            .addOnSuccessListener { document ->
                if (document.exists()) {
                    onComplete(document["channelId"] as String)
                    return@addOnSuccessListener
                }
                val newChatChannel = firestoreInstance.collection("users").document()
                firestoreInstance.collection("users")
                    .document(otheruserid)
                    .collection("sharedChat")
                    .document(mCurrentUserId+"2")
                    .set(mapOf("channelId" to newChatChannel.id))
                firestoreInstance.collection("users")
                    .document(mCurrentUserId)
                    .collection("sharedChat")
                    .document(otheruserid+"2")
                    .set(mapOf("channelId" to newChatChannel.id))
            }
    }

    private fun creatdocument(channelId: String, check: Check9aser) {
        val contentMessage2 = mutableMapOf<String, Any>()
        val ref = chatChannelsCollectionRef.document(channelId).collection("messages")
            .document(nEwChatCannelId1)
        contentMessage2["name9ader"] = check.name9ader
        contentMessage2["w9f9ader${counternam++}"] = check.w9f9ader1
        contentMessage2["qemet9ader${counter8emah++}"] = check.qemet9ader1
        contentMessage2["date"] = check.date
        contentMessage2["entryname"] = check.senderName
        ref.update(contentMessage2)
            .addOnSuccessListener { Toast.makeText(
                requireContext(),
                "تم الانتهاء من التخزين في قاعدة البيانات",
                Toast.LENGTH_LONG
            ).show()
                binding.btnNew9ader.isEnabled = true
            }
    }

    private fun getMessages(channelId:String, onListen: (List<ShowData9ader>) -> Unit): ListenerRegistration {
        val bindingSE = SearchDailogBinding.inflate(layoutInflater)
        customDialogSE = Dialog(activity!!)
        customDialogSE.setContentView(bindingSE.root)
        customDialogSE.setCancelable(false)
        customDialogSE.window?.setLayout(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )
        if (bindingSE.searchOut.text.toString().isNotEmpty() &&
            bindingSE.texStartDate.text.toString().isNotEmpty() &&
            bindingSE.texEndDate.text.toString().isNotEmpty()
        ) {
            val name = bindingSE.searchOut.text.toString()
            val dateFormat_start = SimpleDateFormat("yyy-MM-dd hh:mm")
            val date1 = startDateo
            val date_start = dateFormat_start.parse(date1)
            val startDate_cal = com.google.firebase.Timestamp(date_start)
            val dateFormat_end = SimpleDateFormat("yyy-MM-dd hh:mm:ss")
            val date2 = endDateo
            val date_end = dateFormat_end.parse(date2)
            val endtDate_cal = com.google.firebase.Timestamp(date_end)
            return chatChannelsCollectionRef.document(channelId).collection("messages")
                .whereEqualTo("name9ader", name)
                .whereGreaterThanOrEqualTo("date", startDate_cal)
                .whereLessThanOrEqualTo("date", endtDate_cal)
                .addSnapshotListener { querySnapshot, firebaseFirestoreException ->
                    if (firebaseFirestoreException != null) {
                        return@addSnapshotListener
                    }
                    val items = mutableListOf<ShowData9ader>()
                    querySnapshot!!.documents.forEach { document ->
                        items.add(
                            ShowData9ader(
                                document.id,
                                document.toObject(Check9ader::class.java)!!,
                                this.context!!
                            )
                        )
                    }
                    onListen(items)
                }
        }

        if (bindingSE.searchOut.text.toString().isEmpty() &&
            bindingSE.texStartDate.text.toString().isNotEmpty() &&
            bindingSE.texEndDate.text.toString().isNotEmpty()
        ) {
            val dateFormat_start = SimpleDateFormat("yyy-MM-dd hh:mm")
            val date1 = startDateo
            val date_start = dateFormat_start.parse(date1)
            val startDate_cal = com.google.firebase.Timestamp(date_start)
            val dateFormat_end = SimpleDateFormat("yyy-MM-dd hh:mm:ss")
            val date2 = endDateo
            val date_end = dateFormat_end.parse(date2)
            val endtDate_cal = com.google.firebase.Timestamp(date_end)
            return chatChannelsCollectionRef.document(channelId).collection("messages")
                .orderBy("date")
                .whereGreaterThanOrEqualTo("date", startDate_cal)
                .whereLessThanOrEqualTo("date", endtDate_cal)
                .addSnapshotListener { querySnapshot, firebaseFirestoreException ->
                    if (firebaseFirestoreException != null) {
                        return@addSnapshotListener
                    }
                    val items = mutableListOf<ShowData9ader>()
                    querySnapshot!!.documents.forEach { document ->
                        items.add(
                            ShowData9ader(
                                document.id,
                                document.toObject(Check9ader::class.java)!!,
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
                        val items = mutableListOf<ShowData9ader>()
                        querySnapshot!!.documents.forEach { document ->
                            items.add(
                                ShowData9ader(
                                    document.id,
                                    document.toObject(Check9ader::class.java)!!,
                                    this.context!!
                                )
                            )
                        }
                        onListen(items)
                    }
            }
    }
    private fun initRecyclerView(item: List<ShowData9ader>) {
        binding.recyclorder9ader.apply {
            addItemDecoration(
                DividerItemDecoration(this.context, DividerItemDecoration.VERTICAL)
            )
            messageAdapter.clear()
            adapter = messageAdapter.apply {
                chatSection = Section(item)
                add(chatSection)
                setOnItemLongClickListener(onItemLongClick)
            }
        }
    }

    private val onItemLongClick = OnItemLongClickListener { item, view ->
        if (item is ShowData9ader){
            val customDL = DialogDeleteBinding.inflate(layoutInflater)
            customDialogDL = Dialog(activity!!)
            customDialogDL.setContentView(customDL.root)
            customDialogDL.setCancelable(false)
            customDialogDL.window?.setLayout(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
            )
            customDialogDL.show()
            customDL.dlYes.setOnClickListener {
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
                    customDialogDL.dismiss()
                }
            }

            customDL.dlNo.setOnClickListener {
                customDialogDL.dismiss()
            }
        }
        true
    }

    private fun isNetworkAvailable(context: Context): Boolean {
        val connectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val activeNetworkInfo = connectivityManager.activeNetworkInfo
        return activeNetworkInfo != null && activeNetworkInfo.isConnected
    }

    private fun getUserInfo(onComplete:(User) -> Unit){
        firestoreInstance.collection("users")
            .document(mCurrentUserId).get().addOnSuccessListener {
                onComplete(it.toObject(User::class.java)!!)
            }
    }

}