package com.example.markizalhadidi

import android.app.Dialog
import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.*
import android.widget.CheckBox
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.drawerlayout.widget.DrawerLayout
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.markizalhadidi.databinding.ActivityMainBinding
import com.example.markizalhadidi.databinding.DialogAddBinding
import com.example.markizalhadidi.databinding.PayingDailogBinding
import com.example.markizalhadidi.model.User
import com.example.markizalhadidi.ui.estqbal.EstqbalViewModel
import com.example.markizalhadidi.ui.fa79computer.Fa79ComputerViewModel
import com.example.markizalhadidi.ui.gear.GearViewModel
import com.example.markizalhadidi.ui.hay2ah.Hay2ahViewModel
import com.example.markizalhadidi.ui.hay2ah.Hy2ah2ViewModel
import com.example.markizalhadidi.ui.khrba2.Khrba2ViewModel
import com.example.markizalhadidi.ui.m5ra6ah.M5ra6ahViewModel
import com.example.markizalhadidi.ui.mainfrgment.AddViewModel
import com.example.markizalhadidi.ui.mo7arek.Mo7arekViewModel
import com.example.markizalhadidi.ui.pub9yaneh.Pub9yanehViewModel
import com.google.android.material.navigation.NavigationView
import com.google.android.material.textfield.TextInputEditText
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FieldValue
import com.google.firebase.firestore.FirebaseFirestore
import java.util.*

@Suppress("UNREACHABLE_CODE")
class MainActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMainBinding

    private lateinit var hy2ahModel: Hay2ahViewModel
    private lateinit var hy2ah2Model: Hy2ah2ViewModel
    private lateinit var viewModelPub9yaneh: Pub9yanehViewModel
    private lateinit var viewModeleGear: GearViewModel
    private lateinit var viewModeleMo7arek: Mo7arekViewModel
    private lateinit var viewModelM5ra6ah: M5ra6ahViewModel
    private lateinit var viewModelFa79Com: Fa79ComputerViewModel
    private lateinit var viewModelkhrbaa: Khrba2ViewModel
    private lateinit var viewModeleEstqbal: EstqbalViewModel
    private lateinit var viewModeleAdd: AddViewModel

    var totalAllModel  :Int = 0
    var totalAcount :Int = 0

    private lateinit var customDialogFB_paying: Dialog

    private lateinit var customDialogADDM : Dialog
    var editText: EditText? = null
    var inputEdit :TextInputEditText? =null

    private lateinit var currentUser: User
    private var mCurrentUserId = FirebaseAuth.getInstance().currentUser!!.uid
    private val firestoreInstance: FirebaseFirestore by lazy { FirebaseFirestore.getInstance() }
    private val chatChannelsCollectionRef = firestoreInstance.collection("chatChannels")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.appBarMain.toolbar)

        getUserInfo {user ->
            currentUser = user
        }

        hy2ahModel = run {
            ViewModelProvider(this).get(Hay2ahViewModel::class.java)
        } ?: throw Exception("Invalid Activity")
        hy2ah2Model = run {
            ViewModelProvider(this).get(Hy2ah2ViewModel::class.java)
        } ?: throw Exception("Invalid Activity")
        viewModeleGear =  run {
            ViewModelProvider(this).get(GearViewModel::class.java)
        } ?: throw Exception("Invalid Activity")
        viewModeleMo7arek = run {ViewModelProvider(this)[Mo7arekViewModel::class.java]}
        viewModelM5ra6ah = run {ViewModelProvider(this)[M5ra6ahViewModel::class.java]}
        viewModelFa79Com = run {ViewModelProvider(this)[Fa79ComputerViewModel::class.java]}
        viewModelkhrbaa = run {ViewModelProvider(this)[Khrba2ViewModel::class.java]}
        viewModeleEstqbal = run {
            ViewModelProvider(this).get(EstqbalViewModel::class.java)
        } ?: throw Exception("Invalid Activity")

        viewModeleAdd = run {
            ViewModelProvider(this).get(AddViewModel::class.java)
        } ?: throw Exception("Invalid Activity")


        viewModelPub9yaneh = run {
            ViewModelProvider(this).get(Pub9yanehViewModel::class.java)
        } ?: throw Exception("Invalid Activity")
//        binding.appBarMain.fab.setOnTouchListener(MovableFloatingActionButton(this, null, 0))

        binding.appBarMain.fab.setOnClickListener {
            val customDialogadd = DialogAddBinding.inflate(layoutInflater)
            customDialogADDM = Dialog(this)
            customDialogADDM.setContentView(customDialogadd.root)
            customDialogADDM.setCancelable(false)
            customDialogADDM.window?.setLayout(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT)
            customDialogADDM.window?.setFlags(WindowManager.LayoutParams.FLAG_SECURE, WindowManager.LayoutParams.FLAG_SECURE)

            val editTextListpric = mutableListOf<EditText>()
            val inputEditTextList = mutableListOf<TextInputEditText>()
            for (i in 1..9) {
                val editTextName = "pricadd$i"
                editText =
                    customDialogadd::class.java.getDeclaredField(editTextName)
                        .get(customDialogadd) as EditText
                editTextListpric.add(editText!!)

                val inputEditName = "tproced$i"
                inputEdit =
                    customDialogadd::class.java.getDeclaredField(inputEditName)
                        .get(customDialogadd) as TextInputEditText
                inputEditTextList.add(inputEdit!!)

                val totalAmount = editTextListpric.filter { it.text.isNotEmpty() }
                    .sumOf { it.text.toString().toInt() }
                viewModeleAdd.totalAmount = totalAmount.toString()
                customDialogadd.texttootaladd.text =
                    "مجموع قائمة الاضافة اليدويه: " + viewModeleAdd.totalAmount

                for (a in 0 until editTextListpric.size) {
                    if (viewModeleAdd.editTextListpric.size > a) {
                        editText!!.text = viewModeleAdd.editTextListpric[a].text
                    }
                }

                for (f in 0 until inputEditTextList.size) {
                    if (viewModeleAdd.inputEditTextList.size > f) {
                        inputEdit!!.text = viewModeleAdd.inputEditTextList[f].text
                    }
                }

//                val contentDelField = mutableMapOf<String, Any>()
                customDialogadd.btnclos.setOnClickListener {
//                    viewModeleAdd.editTextListpric.clear()
//                    viewModeleAdd.inputEditTextList.clear()
//                    for (w in 0 until editTextListpric.size) {
//                        contentDelField["pricadd${w + 1}"] = FieldValue.delete()
//                        contentDelField["tproced${w + 1}"] = FieldValue.delete()
////                        val variableDelNamepric =
////                            hashMapOf<String, Any>("pricadd${w + 1}" to FieldValue.delete())
//                        chatChannelsCollectionRef.document(viewModeleEstqbal.myData1)
//                            .collection("messages")
//                            .document(viewModeleEstqbal.myData2)
//                            .update(contentDelField)
//                    }
                    customDialogADDM.dismiss()
                }

                customDialogadd.btnsavadd.setOnClickListener {
                    for (q in 0 until editTextListpric.size) {
                        if (editTextListpric[q].text.isNotEmpty() && inputEditTextList[q].text!!.isEmpty()) {
                            inputEditTextList[q].requestFocus()
                            inputEditTextList[q].error = "يجب عدم ترك الخانة فارغة"
                            return@setOnClickListener
                        }
                            if (editTextListpric[q].text.isEmpty() && inputEditTextList[q].text!!.isNotEmpty()) {
                                editTextListpric[q].requestFocus()
                                editTextListpric[q].error = "يجب عدم ترك الخانة فارغة"
                                return@setOnClickListener
                            }
                            if (editTextListpric[q].text.isEmpty() && inputEditTextList[q].text!!.isEmpty()) {
                                inputEditTextList[q].error = null
                            }
                        }

                    if (!isNetworkAvailable(this)) {
                        Toast.makeText(
                            this,
                            "خدمة الانترنت غير متوفرة",
                            Toast.LENGTH_LONG
                        ).apply {
                            setGravity(Gravity.CENTER, 0, 0)
                            show()
                        }
                    } else {
                        val contentMessage2 = mutableMapOf<String, Any>()
                        for (i in 0 until editTextListpric.size) {
                            if (editTextListpric[i].text.isNotEmpty() && inputEditTextList[i].text!!.isNotEmpty()) {
                                val variableNamepric = "pricadd${i + 1}"
                                contentMessage2[variableNamepric] =
                                    editTextListpric[i].text.toString()

                                val variableName = "tproced${i + 1}"
                                contentMessage2[variableName] =
                                    inputEditTextList[i].text.toString()
                                contentMessage2["totaladdman"] =
                                    viewModeleEstqbal.totalAmount
                                chatChannelsCollectionRef.document(viewModeleEstqbal.myData1)
                                    .collection("messages")
                                    .document(viewModeleEstqbal.myData2)
                                    .update(contentMessage2)
                            } else {
//                                val variableDelNamepric =
//                                    hashMapOf<String, Any>("pricadd${i + 1}" to FieldValue.delete())
                                val delFieldeAdd= mutableMapOf<String, Any>()
                                delFieldeAdd["pricadd${i + 1}"] = FieldValue.delete()
                                delFieldeAdd["tproced${i + 1}"] = FieldValue.delete()
                                chatChannelsCollectionRef.document(viewModeleEstqbal.myData1)
                                    .collection("messages")
                                    .document(viewModeleEstqbal.myData2)
                                    .update(delFieldeAdd)
                            }
                        }

                        customDialogADDM.dismiss()
                    }
                }
            }

            for (i in editTextListpric.indices) {
                editTextListpric[i].addTextChangedListener(object : TextWatcher {
                    override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

                    override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                        viewModeleAdd.editTextListpric.clear()
                        viewModeleAdd.editTextListpric.addAll(editTextListpric)

                        val totalAmount = editTextListpric.filter { it.text.isNotEmpty() }.sumOf { it.text.toString().toInt() }
                        viewModeleAdd.totalAmount = totalAmount.toString()
                        customDialogadd.texttootaladd.text = "مجموع قائمة الاضافة اليدويه: " + viewModeleAdd.totalAmount
                    }

                    override fun afterTextChanged(s: Editable?) {
                    }
                })
            }

            for (i in inputEditTextList.indices) {
                inputEditTextList[i].addTextChangedListener(object : TextWatcher {
                    override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

                    override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                        viewModeleAdd.inputEditTextList.clear()
                        viewModeleAdd.inputEditTextList.addAll(inputEditTextList)
                    }

                    override fun afterTextChanged(s: Editable?) {
                    }
                })
            }
            customDialogADDM.show()
        }

        val drawerLayout: DrawerLayout = binding.drawerLayout
        val navView: NavigationView = binding.navView
        val navController = findNavController(R.id.nav_host_fragment_content_main)

        val menu = navView.menu


        menu.findItem(R.id.nav_fawterwared).isVisible = false
        menu.findItem(R.id.nav_fawterwared).isEnabled = false
        menu.findItem(R.id.nav_mainkhrbaa).isVisible = false
            menu.findItem(R.id.nav_mainkhrbaa).isEnabled = false
        if (currentUser.profession == "مدير") {
            menu.findItem(R.id.nav_fawterwared).isVisible = true
            menu.findItem(R.id.nav_fawterwared).isEnabled = true

        }
//        else{if (currentUser.profession == "ميكانيكي"){
//            menu.findItem(R.id.nav_fawterwared).isVisible = false
//            menu.findItem(R.id.nav_fawterwared).isEnabled = false
//            menu.findItem(R.id.nav_mainkhrbaa).isVisible = false
//            menu.findItem(R.id.nav_mainkhrbaa).isEnabled = false
//        }
//        else{menu.findItem(R.id.nav_mainkhrbaa).isVisible = false
//            menu.findItem(R.id.nav_mainkhrbaa).isEnabled = false
//            menu.findItem(R.id.nav_fawterwared).isVisible = true
//            menu.findItem(R.id.nav_fawterwared).isEnabled = true
//        }
//        }

        appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.nav_fawterwared,
                R.id.nav_gear,R.id.nav_estkbal,R.id.nav_fa79com,
                R.id.nav_mainkhrbaa,
                R.id.nav_mainfragment,
                R.id.nav_khrba2,R.id.nav_m5ra6ah,
                R.id.nav_hy2ah1,R.id.nav_hy2ah2,R.id.nav_mo7arek,
                R.id.nav_pub9yan,R.id.nav_mainhay2ah
            ), drawerLayout
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        if (item.itemId ==R.id.action_Save) {
            val customDialogpaying = PayingDailogBinding.inflate(layoutInflater)
            customDialogFB_paying = Dialog(this)
            customDialogFB_paying.setContentView(customDialogpaying.root)
            customDialogFB_paying.setCancelable(false)
            customDialogFB_paying.window?.setLayout(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT)
            customDialogFB_paying.window?.setFlags(WindowManager.LayoutParams.FLAG_SECURE, WindowManager.LayoutParams.FLAG_SECURE)

            val totalpub9yaneh = viewModelPub9yaneh.totalAmount.toIntOrNull() ?:0
            val totalhy2a1 = hy2ahModel.totalAmount.toIntOrNull() ?:0
            val totalmo7arek = viewModeleMo7arek.totalAmount.toIntOrNull() ?:0
            val totalgear = viewModeleGear.totalAmount.toIntOrNull() ?:0
            val totalm5r6ah = viewModelM5ra6ah.totalAmount.toIntOrNull() ?:0
            val hy2ah2total = hy2ah2Model.totalAmount.toIntOrNull() ?:0
            val totalfa7e9 = viewModelFa79Com.totalAmount.toIntOrNull() ?:0
            val totalkahrba2 = viewModelkhrbaa.totalAmount.toIntOrNull() ?:0
            val totaladd = viewModeleAdd.totalAmount.toIntOrNull() ?:0
            totalAllModel =
                (totalhy2a1 + hy2ah2total + totalmo7arek + totalgear + totalpub9yaneh +
                        totalm5r6ah + totalfa7e9 + totalkahrba2 + totaladd)
            customDialogpaying.receivprice.setText(totalAllModel.toString())

            val checkBoxList = mutableListOf<CheckBox>()
            val editTextList = mutableListOf<EditText>()
            val checkBoxNames = listOf("cashPaying", "wallet", "credit", "Discount" , "receivables")
            val editTextNames = listOf("cashPrice", "walletPrice", "creditPrice", "DiscountPrice" , "receivprice")
            val selectedEditTextValues = mutableListOf<String>()
            for (editTextName in editTextNames) {
                val editText = customDialogpaying::class.java.getDeclaredField(editTextName).get(customDialogpaying) as EditText
                editTextList.add(editText)
            }
                for (checkBoxName in checkBoxNames) {
                    val checkBox =
                        customDialogpaying::class.java.getDeclaredField(checkBoxName)
                            .get(customDialogpaying) as CheckBox
                    checkBoxList.add(checkBox)
                    checkBox.setOnCheckedChangeListener { _, isChecked ->
                        if (isChecked ) {
                            selectedEditTextValues.clear()
                            for (i in checkBoxList.indices) {
                                if (checkBoxList[i].isChecked && editTextList[i].text.isEmpty() && i !=4) {
                                    checkBox.isChecked = false
                                    Toast.makeText(this, "يجب إدخال مبلغ الـ"+checkBoxList[i].text, Toast.LENGTH_LONG).apply {
                                        show()}

                                }else{if (checkBoxList[i].isChecked && i !=4){
                                    selectedEditTextValues.add(editTextList[i].text.toString())
                                    totalAcount = totalAllModel - (selectedEditTextValues.sumOf { it.toInt() })
                                    customDialogpaying.receivprice.setText(totalAcount.toString())
                                }
                                }
                            }
                        }else{
                            for (i in checkBoxList.indices) {
                                if (!checkBoxList[i].isChecked) {
                                    editTextList[i].text = null
totalAcount = totalAllModel - editTextList.filter { it.text.isNotEmpty() }.sumOf { it.text.toString().toIntOrNull() ?: 0 }

            customDialogpaying.receivprice.setText(totalAcount.toString())

                                }
                            }
                        }
                    }
                }

            customDialogpaying.buttonDailogSaveP.setOnClickListener {
                for (r in 0 until editTextList.size) {
                    if (editTextList[r].text.isNotEmpty() && !checkBoxList[r].isChecked && r != 4) {
                        editTextList[r].requestFocus()
                        editTextList[r].error = "يجب تحديد الخانة بعلامة صح"
                        return@setOnClickListener
                    }

                    if (editTextList[4].text.isNotEmpty() && editTextList[4].text.toString().toInt() > 0 && !checkBoxList[4].isChecked) {
                        Toast.makeText(this,"يوجد ذمم يجب تحديد الخانة",Toast.LENGTH_LONG).show()
                        return@setOnClickListener
                    }

                    if (!isNetworkAvailable(this)) {
            Toast.makeText(this,"خدمة الانترنت غير متوفرة",Toast.LENGTH_LONG).show()
                    } else {
                        val contentMessage2 = mutableMapOf<String, Any>()
                        contentMessage2["total"] =totalAllModel.toString()

                        if (editTextList[r].text.isNotEmpty() && checkBoxList[r].isChecked) {
                            contentMessage2[editTextNames[r]] =
                                editTextList[r].text.toString()
                            contentMessage2[checkBoxNames[r]] =
                                checkBoxList[r].text.toString()

                            for (a in 0 until viewModeleGear.editTextList.size) {
                                if (viewModeleGear.editGearTextList.size > a) {
                                    if (viewModeleGear.editTextList[a].text.isNotEmpty()) {
                                        viewModeleGear.variableGearpric = "pricgear${a + 1}"
                                        contentMessage2[viewModeleGear.variableGearpric] =
                                            viewModeleGear.editGearTextList[a].text.toString()
                                        contentMessage2["date"] = Calendar.getInstance().time
                                    }
                                        if (viewModeleGear.checkBoxList[a].isChecked){
                                            viewModeleGear.variableGearName = "chgear${a + 1}"
                                            contentMessage2[viewModeleGear.variableGearName] =
                                                viewModeleGear.checkBoxGearList[a].text.toString()
                                        }
                                    }
                                }

                            for (b in 0 until viewModeleMo7arek.editTextList.size) {
                                if (viewModeleMo7arek.editMo7arekTextList.size > b) {
                                    if (viewModeleMo7arek.editTextList[b].text.isNotEmpty()) {
                                        val variableMo7arekpric = "pricmo7arek${b + 1}"
                                        contentMessage2[variableMo7arekpric] =
                                            viewModeleMo7arek.editMo7arekTextList[b].text.toString()
                                        contentMessage2["date"] = Calendar.getInstance().time
                                    }
                                    if (viewModeleMo7arek.checkBoxList[b].isChecked){
                                        val variableMo7arekName = "chmo7arek${b + 1}"
                                        contentMessage2[variableMo7arekName] =
                                            viewModeleMo7arek.checkBoxMo7arekList[b].text.toString()
                                    }
                                }
                            }

                            for (c in 0 until viewModelM5ra6ah.editTextList.size) {
                                if (viewModelM5ra6ah.editM5ra6ahTextList.size > c) {
                                    if (viewModelM5ra6ah.editTextList[c].text.isNotEmpty()) {
                                        val variableM5r6ahpric = "pricm5ra6ah${c + 1}"
                                        contentMessage2[variableM5r6ahpric] =
                                            viewModelM5ra6ah.editM5ra6ahTextList[c].text.toString()
                                        contentMessage2["date"] = Calendar.getInstance().time
                                    }
                                    if (viewModelM5ra6ah.checkBoxList[c].isChecked){
                                        val variableM5r6ahName = "chm5ra6ah${c + 1}"
                                        contentMessage2[variableM5r6ahName] =
                                            viewModelM5ra6ah.checkBoxM5ra6ahList[c].text.toString()
                                    }
                                }
                            }

                            for (d in 0 until hy2ahModel.editTextList.size) {
                                if (hy2ahModel.editHy2ah1TextList.size > d) {
                                    if (hy2ahModel.editTextList[d].text.isNotEmpty()) {
                                        val variablehy2ahpric = "pric${d + 1}"
                                        contentMessage2[variablehy2ahpric] =
                                            hy2ahModel.editHy2ah1TextList[d].text.toString()
                                        contentMessage2["date"] = Calendar.getInstance().time
                                    }
                                    if (hy2ahModel.checkBoxList[d].isChecked){
                                        val variablehy2ahName = "ch${d + 1}"
                                        contentMessage2[variablehy2ahName] =
                                            hy2ahModel.checkBoxHy2ah1List[d].text.toString()
                                    }
                                }
                            }

                            for (e in 0 until hy2ah2Model.editTextList.size) {
                                if (hy2ah2Model.editHy2ah2TextList.size > e) {
                                    if (hy2ah2Model.editTextList[e].text.isNotEmpty()) {
                                        val variablehy2ah2pric = "prichy2ahtow${e + 1}"
                                        contentMessage2[variablehy2ah2pric] =
                                            hy2ah2Model.editHy2ah2TextList[e].text.toString()
                                        contentMessage2["date"] = Calendar.getInstance().time
                                    }
                                    if (hy2ah2Model.checkBoxList[e].isChecked){
                                        val variablehy2ah2Name = "chhy2ahtow${e + 1}"
                                        contentMessage2[variablehy2ah2Name] =
                                            hy2ah2Model.checkBoxHy2ah2List[e].text.toString()
                                    }
                                }
                            }

                            for (f in 0 until viewModelFa79Com.editTextList.size) {
                                if (viewModelFa79Com.editFa79TextList.size > f) {
                                    if (viewModelFa79Com.editTextList[f].text.isNotEmpty()) {
                                       val variableFa79pric = "pricfa79com${f + 1}"
                                        contentMessage2[variableFa79pric] =
                                            viewModelFa79Com.editFa79TextList[f].text.toString()
                                        contentMessage2["date"] = Calendar.getInstance().time
                                    }
                                    if (viewModelFa79Com.checkBoxList[f].isChecked){
                                        val variableFa79Name = "chfa79com${f + 1}"
                                        contentMessage2[variableFa79Name] =
                                            viewModelFa79Com.checkBoxFa79List[f].text.toString()
                                    }
                                }
                            }

                            for (g in 0 until viewModelkhrbaa.editTextList.size) {
                                if (viewModelkhrbaa.editKhrba2TextList.size > g) {
                                    if (viewModelkhrbaa.editTextList[g].text.isNotEmpty()) {
                                        val variableKhrba2pric = "prickhrbaa${g + 1}"
                                        contentMessage2[variableKhrba2pric] =
                                            viewModelkhrbaa.editKhrba2TextList[g].text.toString()
                                        contentMessage2["date"] = Calendar.getInstance().time
                                    }

                                    if (viewModelkhrbaa.checkBoxList[g].isChecked){
                                        val variableKhrba2Name = "chkhrbaa${g + 1}"
                                        contentMessage2[variableKhrba2Name] =
                                            viewModelkhrbaa.checkBoxKhrba2List[g].text.toString()
                                    }
                                }
                            }

                            for (h in 0 until viewModelPub9yaneh.editTextList.size) {
                                if (viewModelPub9yaneh.editPub9yanehTextList.size > h) {
                                    if (viewModelPub9yaneh.editTextList[h].text.isNotEmpty()) {
                                        val variablePub9yanehpric = "pricpub9yaneh${h + 1}"
                                        contentMessage2[variablePub9yanehpric] =
                                            viewModelPub9yaneh.editPub9yanehTextList[h].text.toString()
                                        contentMessage2["date"] = Calendar.getInstance().time
                                    }

                                    if (viewModelPub9yaneh.checkBoxList[h].isChecked){
                                        val variablPub9yanehName = "chpub9yaneh${h + 1}"
                                        contentMessage2[variablPub9yanehName] =
                                            viewModelPub9yaneh.checkBoxPub9yanehList[h].text.toString()
                                    }
                                }
                            }
                            contentMessage2["totaladdman"] =
                                viewModeleEstqbal.totalAmount
                            chatChannelsCollectionRef.document(viewModeleEstqbal.myData1)
                                .collection("messages")
                                .document(viewModeleEstqbal.myData2)
                                .update(contentMessage2)
                        }
                        else {
                            val delFielde= mutableMapOf<String, Any>()
                            delFielde[editTextNames[r]] = FieldValue.delete()
                            delFielde[checkBoxNames[r]] = FieldValue.delete()
//                            val variableDelNamepric =
//                                hashMapOf<String, Any>(editTextNames[r] to FieldValue.delete())
                            chatChannelsCollectionRef.document(viewModeleEstqbal.myData1)
                                .collection("messages")
                                .document(viewModeleEstqbal.myData2)
                                .update(delFielde)
                        }
                    }
                }
                customDialogFB_paying.dismiss()
//                Navigation.findNavController(this,R.id.nav_host_fragment_content_main).navigate(R.id.nav_first)
                val intent = Intent(this, Users::class.java)
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK)
                startActivity(intent)
                finish()
            }

            customDialogpaying.buttonDailogCancelP.setOnClickListener {

                val textEdit = listOf(customDialogpaying.cashPrice, customDialogpaying.walletPrice
                    , customDialogpaying.creditPrice, customDialogpaying.DiscountPrice)

                textEdit.forEach {
                    it.setText("")
                }
                customDialogFB_paying.dismiss()
            }
            customDialogFB_paying.show()
    }

    return super.onOptionsItemSelected(item)

}

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment_content_main)
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
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



