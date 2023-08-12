package com.example.mizanalnasr.ui.Outcom

import android.annotation.SuppressLint
import android.app.DatePickerDialog
import android.app.Dialog
import android.arch.lifecycle.ViewModelProviders
import android.os.Build
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.Toolbar
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.Toast
import com.example.mizanalnasr.R
import com.example.mizanalnasr.databinding.FragmentM5r6ahBinding
import com.example.mizanalnasr.databinding.FragmentOutcomingBinding
import com.example.mizanalnasr.model.Check9ader
import com.example.mizanalnasr.recycler.ShowData9ader
import com.example.mizanalnasr.ui.Incom.IncomingViewModel
import com.example.neprotest.model.CheckData
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ListenerRegistration
import com.google.firebase.firestore.Query
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.Section
import com.xwray.groupie.ViewHolder
import com.xwray.groupie.kotlinandroidextensions.Item
import kotlinx.android.synthetic.main.app_bar_main.*
import kotlinx.android.synthetic.main.calendar_dailog.*
import kotlinx.android.synthetic.main.fragment_incoming.*
import kotlinx.android.synthetic.main.fragment_outcoming.*
import kotlinx.android.synthetic.main.fragment_outcoming.view.*
import kotlinx.android.synthetic.main.search_dailog.*
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

    private lateinit var  otheruserid :String
    private lateinit var nEwChatCannelId1 : String

    private var totalQuantityincoming :Int=0
    private var totalQuantityOutcoming :Int=0
    private var total_solaf_mowazaf :Int=0

    private var counternam = 1
    private var counter8emah = 1
    private val messageAdapter by lazy { GroupAdapter<ViewHolder>() }
    private lateinit var chatSection: Section

    private lateinit var name_mowazaf :String

    var startDateo =""
    var endDateo =""

    private lateinit var customDialogSE: Dialog
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentOutcomingBinding.inflate(inflater, container, false)
        val root: View = binding.root

        otheruserid = "zydXcSSEwZaPsNVwZ1oiDQubnjG3"

        viewModelinc = activity?.run {
            ViewModelProviders.of(this).get(IncomingViewModel::class.java)
        } ?: throw Exception("Invalid Activity")


        var osem_al9der =""
        var wa9f_al9ader =""
        var qemet_al9ader =""

        root.no3.isEnabled = false
        root.description.isEnabled = false
        root.n8ed.isEnabled = false
        root.btn_add_9ader.isEnabled = false

        createChatChannel { channelId ->
            mCurrentChatChannelId = channelId
            getMessages(channelId,::initRecyclerView)
            getTotaloutcoming(channelId)

            createChatChannel1 { channelId1 ->
                getTotalincoming(channelId1)


                val b59o9 = arrayOf(
                    "احمد الزيود",
                    "احمد ابو جدعة",
                    "بدر حماد",
                    "سفيان العوادين",
                    "مهند ابو عمر",
                    "يونس براهمة",
                    "محمد عبد الحق",
                    "معاذ ابو الهيجاء",
                    "ميزان النسر"
                )
                val adapter =
                    ArrayAdapter(activity!!, android.R.layout.simple_spinner_dropdown_item, b59o9)
                val autoCompleteTextView = activity!!.findViewById<AutoCompleteTextView>(R.id.no3)
                autoCompleteTextView.threshold = 0
                autoCompleteTextView.setAdapter(adapter)

                val toolbar = activity?.findViewById<Toolbar>(R.id.toolbar)
                toolbar?.setTitleTextAppearance(this.context, R.style.boldText)

                root.btn_new_9ader.setOnClickListener {
                    val ref = chatChannelsCollectionRef.document(channelId).collection("messages")
                        .document()
                    ref.set(mapOf())
                        .addOnSuccessListener {
                            nEwChatCannelId1 = ref.id
                            counternam = 1
                            counter8emah = 1
                            root.description.setText("")
                            root.btn_new_9ader.isEnabled = false
                            root.no3.isEnabled = true
                            root.description.isEnabled = true
                            root.n8ed.isEnabled = true
                            root.btn_add_9ader.isEnabled = true
                            root.no3.requestFocus()
                        }
                }

                root.btn_add_9ader.setOnClickListener {

                    if (no3.text.toString().trim().isEmpty()) {
                        no3.error = "يجب عدم ترك الخانة فارغة"
                        no3.requestFocus()
                        return@setOnClickListener
                    }
                    if (description.text.toString().trim().isEmpty()) {
                        description.error = "يجب عدم ترك الخانة فارغة"
                        description.requestFocus()
                        return@setOnClickListener
                    }
                    if (n8ed.text.toString().trim().isEmpty()) {
                        n8ed.error = "يجب عدم ترك الخانة فارغة"
                        n8ed.requestFocus()
                        return@setOnClickListener
                    }
                    osem_al9der = no3.text.toString().trim()
                    wa9f_al9ader = description.text.toString().trim()
                    qemet_al9ader = n8ed.text.toString().trim()

                    val content = Check9ader(
                        "محمد ذياب",
                        Calendar.getInstance().time,
                        "محمد ذياب",
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
                    description.setText("")
                    n8ed.setText("")
                    btn_new_9ader.isEnabled = true
                    no3.isEnabled = false
                    getTotaloutcoming(channelId)
                    getTotalincoming(channelId1)
                }
                root.dialog_search.setOnClickListener {

                    customDialogSE = Dialog(activity!!)
                    customDialogSE.setContentView(R.layout.search_dailog)
                    customDialogSE.setCancelable(false)
                    customDialogSE.window?.setLayout(
                        ViewGroup.LayoutParams.MATCH_PARENT,
                        ViewGroup.LayoutParams.WRAP_CONTENT
                    )

                    customDialogSE.btn_start_date.setOnClickListener {
                        // Create DatePickerDialog for start date
//                        val datePickerDialog = DatePickerDialog(
//                            requireContext(),
//                            { _, year, monthOfYear, dayOfMonth ->
//                                // Set selected date to texStartDate
//                                startDateo = "$dayOfMonth/${monthOfYear + 1}/$year 00:00"
//                                customDialogSE.tex_start_date.text = startDateo
//                            },
//                            Calendar.getInstance().get(Calendar.YEAR),
//                            Calendar.getInstance().get(Calendar.MONTH),
//                            Calendar.getInstance().get(Calendar.DAY_OF_MONTH)
//                        )
//                        datePickerDialog.show()
                        val customDialogCALENDAR = Dialog(activity!!)
                        customDialogCALENDAR.setContentView(R.layout.calendar_dailog)
                        customDialogCALENDAR.setCancelable(false)
                        customDialogCALENDAR.window?.setLayout(
                            ViewGroup.LayoutParams.MATCH_PARENT,
                            ViewGroup.LayoutParams.WRAP_CONTENT
                        )

                        customDialogCALENDAR.calendarView.setOnDateChangeListener { view, year, month, day ->
                            val month1 = month +1
                            customDialogSE.tex_start_date.setText("$year-$month1-$day").toString()
                            startDateo +="$year-$month1-$day 00:00"
                            customDialogCALENDAR.dismiss()
                        }
                        customDialogCALENDAR.show()
                        customDialogSE.show()
                    }

                    customDialogSE.btn_end_date.setOnClickListener {

                        val customDialogCALENDAR = Dialog(activity!!)
                        customDialogCALENDAR.setContentView(R.layout.calendar_dailog)
                        customDialogCALENDAR.setCancelable(false)
                        customDialogCALENDAR.window?.setLayout(
                            ViewGroup.LayoutParams.MATCH_PARENT,
                            ViewGroup.LayoutParams.WRAP_CONTENT
                        )

                        customDialogCALENDAR.calendarView.setOnDateChangeListener { view, year, month, day ->
                            val month = month +1
                            customDialogSE.tex_end_date.setText("$year-$month-$day").toString()
                            endDateo +="$year-$month-$day 23:59:59"
//                            getMessages(mCurrentChatChannelId,::initRecyclerView)
//                            getTotal(mCurrentChatChannelId)

//                            btn_start_calendar.isEnabled=true
                            customDialogCALENDAR.dismiss()
                        }
//                        // Create DatePickerDialog for end date
//                        val datePickerDialog = DatePickerDialog(
//                            requireContext(),
//                            { _, year, monthOfYear, dayOfMonth ->
//                                // Set selected date to texEndDate
//                                 endDateo = "$dayOfMonth/${monthOfYear + 1}/$year 23:59:59"
//                                customDialogSE.tex_end_date.text = endDateo
//                            },
//                            Calendar.getInstance().get(Calendar.YEAR),
//                            Calendar.getInstance().get(Calendar.MONTH),
//                            Calendar.getInstance().get(Calendar.DAY_OF_MONTH)
//                        )
//                        datePickerDialog.show()
                        customDialogCALENDAR.show()
                        customDialogSE.show()
                    }

                    val adapter1 =
                        ArrayAdapter(activity!!, android.R.layout.simple_spinner_dropdown_item, b59o9)
                    val autoCompleteTextView1 = customDialogSE.findViewById<AutoCompleteTextView>(R.id.search_out)
                    autoCompleteTextView1.threshold = 0
                    autoCompleteTextView1.setAdapter(adapter1)

                    customDialogSE.search_name.setOnClickListener {
                        if (customDialogSE.search_out.text.toString().isNotEmpty() &&
                            customDialogSE.tex_start_date.text.toString().isNotEmpty() &&
                            customDialogSE.tex_end_date.text.toString().isNotEmpty()    ) {
                            val name = customDialogSE.search_out.text.toString()
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
                            getMessages(mCurrentChatChannelId,::initRecyclerView)
                            getTotaloutcoming(mCurrentChatChannelId)
                        }
                        else{
                            if (customDialogSE.search_out.text.toString().isEmpty() &&
                                customDialogSE.tex_start_date.text.toString().isNotEmpty() &&
                                customDialogSE.tex_end_date.text.toString().isNotEmpty()    ) {
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
                            getMessages(mCurrentChatChannelId,::initRecyclerView)
                            getTotaloutcoming(mCurrentChatChannelId)
                        }

                        customDialogSE.dismiss()
                    }
//                    startDateo =""
//                    endDateo =""
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

        if (customDialogSE.search_out.text.toString().isNotEmpty() &&
            customDialogSE.tex_start_date.text.toString().isNotEmpty() &&
            customDialogSE.tex_end_date.text.toString().isNotEmpty()    ) {
            val name = customDialogSE.search_out.text.toString()
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
        else {
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
                        outcoming.text = "مجموع الصادر " + totalQuantityOutcoming.toString()
                    }
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
                        if (i.toObject(CheckData::class.java)!!.cash_price11.isNotEmpty()) {
                            totalQuantityincoming += i.toObject(CheckData::class.java)!!.cash_price11.toInt()
                        }
                    }
                    incoming.text="مجموع الكاش " + totalQuantityincoming.toString()
                    total9ader.text = "صافي الدخل" + (totalQuantityincoming - totalQuantityOutcoming).toString()
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

    private fun creatdocument(channelId: String, check: Check9ader) {
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
                btn_new_9ader.isEnabled = true
            }
    }

    private fun getMessages(channelId:String, onListen: (List<Item>) -> Unit): ListenerRegistration {

        if (customDialogSE.search_out.text.toString().isNotEmpty() &&
            customDialogSE.tex_start_date.text.toString().isNotEmpty() &&
            customDialogSE.tex_end_date.text.toString().isNotEmpty()
        ) {
            val name = customDialogSE.search_out.text.toString()
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
                    val items = mutableListOf<Item>()
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

        if (customDialogSE.search_out.text.toString().isEmpty() &&
            customDialogSE.tex_start_date.text.toString().isNotEmpty() &&
            customDialogSE.tex_end_date.text.toString().isNotEmpty()
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
                    val items = mutableListOf<Item>()
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
                        val items = mutableListOf<Item>()
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
    private fun initRecyclerView(item: List<Item>) {
        recyclorder9ader.apply {
            addItemDecoration(
                DividerItemDecoration(this.context, DividerItemDecoration.VERTICAL)
            )
            messageAdapter.clear()
            adapter = messageAdapter.apply {
                chatSection = Section(item)
                add(chatSection)
//                setOnItemClickListener(onItemClick)
//                setOnItemLongClickListener(onItemLongClick)

            }
        }
    }

}