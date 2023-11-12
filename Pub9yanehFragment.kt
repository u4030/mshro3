package com.example.markizalhadidi.ui.pub9yaneh

import android.app.Dialog
import android.graphics.Color
import android.os.Bundle
import android.text.Editable
import android.text.SpannableString
import android.text.TextWatcher
import android.text.style.AbsoluteSizeSpan
import android.text.style.ForegroundColorSpan
import android.view.*
import android.widget.CheckBox
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.markizalhadidi.R
import com.example.markizalhadidi.databinding.*
import com.example.markizalhadidi.ui.estqbal.EstqbalViewModel

class Pub9yanehFragment : Fragment() {
    private var _binding: FragmentPub9yanehBinding? = null
    private val binding get() = _binding!!

    private lateinit var bindingtoolbar: ActivityMainBinding

    private lateinit var viewModelPub9yaneh: Pub9yanehViewModel
    private lateinit var viewModeleEstqbal: EstqbalViewModel

    private lateinit var customDialogFR: Dialog
    private lateinit var customDialog_RAD: Dialog
    private lateinit var customDialog_MO3: Dialog
    private lateinit var customDialog_KAT: Dialog
    private lateinit var customDialog_8sha6: Dialog
    private lateinit var customDialog_b5a5: Dialog
    private lateinit var customDialog_mobared: Dialog
    private lateinit var customDialog_oxg: Dialog

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentPub9yanehBinding.inflate(inflater, container, false)
        val root: View = binding.root

        setHasOptionsMenu(true)

        viewModeleEstqbal = activity?.run {
            ViewModelProvider(this).get(EstqbalViewModel::class.java)
        } ?: throw Exception("Invalid Activity")

        viewModelPub9yaneh = activity?.run {
            ViewModelProvider(this).get(Pub9yanehViewModel::class.java)
        } ?: throw Exception("Invalid Activity")

        val spannableString = SpannableString("يجب عدم ترك خانة السعر فارغة")
        spannableString.setSpan(
            ForegroundColorSpan(Color.GREEN), 0, spannableString.length, 0
        )
        spannableString.setSpan(
            AbsoluteSizeSpan(60), 0, spannableString.length, 0
        )
        val toast_notempty = Toast.makeText(context, spannableString, Toast.LENGTH_SHORT)

        val spannableString1 = SpannableString("يجب اختيار احدى الخانات")
        spannableString1.setSpan(
            ForegroundColorSpan(Color.GREEN), 0, spannableString1.length, 0
        )
        spannableString1.setSpan(
            AbsoluteSizeSpan(65), 0, spannableString1.length, 0
        )
        val toast_notempty1 = Toast.makeText(context, spannableString1, Toast.LENGTH_SHORT)

        val bindingFR = FrontDailogBinding.inflate(layoutInflater)
        customDialogFR = Dialog(activity!!)
        customDialogFR.setContentView(bindingFR.root)
        customDialogFR.setCancelable(false)
        customDialogFR.window?.setLayout(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )
        customDialogFR.window?.setFlags(WindowManager.LayoutParams.FLAG_SECURE, WindowManager.LayoutParams.FLAG_SECURE)

        bindingtoolbar = ActivityMainBinding.inflate(layoutInflater)
        val toolbar = activity?.findViewById<Toolbar>(R.id.toolbar)
        toolbar?.setTitleTextAppearance(this.context, R.style.boldText)

        viewModelPub9yaneh.editTextList.clear()
        viewModelPub9yaneh.checkBoxList.clear()

        for (i in 1..21) {
            val editTextName = "pricpub9yaneh$i"
            val editText =
                binding::class.java.getDeclaredField(editTextName).get(binding) as EditText
            viewModelPub9yaneh.editTextList.add(editText)
            val checkBoxName = "chpub9yaneh$i"
            val checkBox =
                binding::class.java.getDeclaredField(checkBoxName).get(binding) as CheckBox
            viewModelPub9yaneh.checkBoxList.add(checkBox)
            checkBox.setOnCheckedChangeListener { _, isChecked ->
                    if (isChecked && editText.text.isEmpty() && checkBox != viewModelPub9yaneh.checkBoxList[2] &&
                        checkBox != viewModelPub9yaneh.checkBoxList[3] && checkBox != viewModelPub9yaneh.checkBoxList[4]
                        && checkBox != viewModelPub9yaneh.checkBoxList[7] && checkBox != viewModelPub9yaneh.checkBoxList[12]
                        && checkBox != viewModelPub9yaneh.checkBoxList[14] && checkBox != viewModelPub9yaneh.checkBoxList[15]
                        && checkBox != viewModelPub9yaneh.checkBoxList[17]) {
                        checkBox.isChecked = false
                        Toast.makeText(activity, "يجب إدخال السعر اولا", Toast.LENGTH_LONG).apply {
                            show()
                        }
                    } else {
                        if (!checkBox.isChecked) {
                            editText.text = null
                            val totalAmount =
                                viewModelPub9yaneh.editTextList.filter { it.text.isNotEmpty() }
                                    .sumOf { it.text.toString().toIntOrNull() ?: 0 }
                            viewModelPub9yaneh.totalAmount = totalAmount.toString()
                            toolbar?.title =
                                "مجموع قائمة الصيانه: " + viewModelPub9yaneh.totalAmount
                        } else {

                            val totalAmount =
                                viewModelPub9yaneh.editTextList.filter { it.text.isNotEmpty() }
                                    .sumOf { it.text.toString().toIntOrNull() ?: 0 }
                            viewModelPub9yaneh.totalAmount = totalAmount.toString()
                            toolbar?.title =
                                "مجموع قائمة الصيانه: " + viewModelPub9yaneh.totalAmount

                            for (v in viewModelPub9yaneh.editTextList.indices) {
                                for (j in viewModelPub9yaneh.editTextList.indices) {
                                    if (j != v) {
                                        viewModelPub9yaneh.editTextList[j].isEnabled = true
                                    }
                                }
                            }
                        }
                    }
                }
            }

        for (h in viewModelPub9yaneh.checkBoxList.indices) {
            viewModelPub9yaneh.checkBoxList[2].setOnCheckedChangeListener { _, isChecked3 ->
                if (isChecked3) {
                    bindingFR.frontright.text = "رديتر محرك"
                    bindingFR.frontleft.text = "رديتر انفيرتر"
                    bindingFR.frontright.setOnCheckedChangeListener { _, isChecked1 ->
                        if (bindingFR.frontright.isChecked) {
                            binding.chpub9yaneh3.text =
                                "دورة تنضيف ماء محرك"
                        } else {
                            binding.chpub9yaneh3.text = "دورة تنضيف رديتر"
                            bindingFR.s3erYadwee.setText("")
                        }
                        if (bindingFR.frontright.isChecked && bindingFR.frontleft.isChecked) {
                            binding.chpub9yaneh3.text = "دورة تنضيف ماء محرك و انفيرتر"
                            bindingFR.s3erYadwee.setText("20")
                        } else {
                            if (bindingFR.frontright.isChecked) {
                                binding.chpub9yaneh3.text = "دورة تنضيف ماء محرك"
                                bindingFR.s3erYadwee.setText("10")
                            }
                            if (bindingFR.frontleft.isChecked) {
                                binding.chpub9yaneh3.text = "دورة تنضيف ماء انفيرتر"
                                bindingFR.s3erYadwee.setText("10")
                            }
                        }
                    }
                    bindingFR.frontleft.setOnCheckedChangeListener { _, isChecked2 ->
                        if (bindingFR.frontleft.isChecked) {
                            binding.chpub9yaneh3.text = "دورة تنضيف ماء انفيرتر"
                        } else {
                            binding.chpub9yaneh3.text = "دورة تنضيف رديتر"
                            bindingFR.s3erYadwee.setText("")
                        }

                        if (bindingFR.frontleft.isChecked && bindingFR.frontright.isChecked) {
                            binding.chpub9yaneh3.text = "دورة تنضيف ماء محرك و انفيرتر"
                            bindingFR.s3erYadwee.setText("20")
                        } else {
                            if (bindingFR.frontright.isChecked) {
                                binding.chpub9yaneh3.text = "دورة تنضيف ماء محرك"
                                bindingFR.s3erYadwee.setText("10")
                            }
                            if (bindingFR.frontleft.isChecked) {
                                binding.chpub9yaneh3.text = "دورة تنضيف ماء انفيرتر"
                                bindingFR.s3erYadwee.setText("10")
                            }
                        }
                    }

                    bindingFR.buttonDailogSave.setOnClickListener {
                        if (!bindingFR.frontright.isChecked && !bindingFR.frontleft.isChecked) {
                            toast_notempty1.show()
                        } else {
                            if (bindingFR.s3erYadwee.text.toString().trim().isEmpty()) {
                                toast_notempty.show()
                            } else {
                                binding.pricpub9yaneh3.setText(bindingFR.s3erYadwee.text.toString())
                                reactiveeditttext()
                                customDialogFR.dismiss()
                            }
                        }
                    }
                    bindingFR.buttonDailogCancel.setOnClickListener {
                        if (binding.pricpub9yaneh3.text.isEmpty()) {
                            binding.chpub9yaneh3.text = "دورة تنضيف رديتر"
                            binding.chpub9yaneh3.isChecked = false
                            bindingFR.s3erYadwee.setText("")
                        }
                        customDialogFR.dismiss()
                    }
                    bindingFR.frontleft.isChecked = false
                    bindingFR.frontright.isChecked = false
                    customDialogFR.show()
                } else {
                    binding.chpub9yaneh3.text = "دورة تنضيف رديتر"
                    binding.pricpub9yaneh3.setText("")
                }
            }

            val customDialograd = DialogRadiatorBinding.inflate(layoutInflater)
            customDialog_RAD = Dialog(activity!!)
            customDialog_RAD.setContentView(customDialograd.root)
            customDialog_RAD.setCancelable(false)
            customDialog_RAD.window?.setLayout(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT)
            customDialog_RAD.window?.setFlags(
                WindowManager.LayoutParams.FLAG_SECURE,
                WindowManager.LayoutParams.FLAG_SECURE)

            viewModelPub9yaneh.checkBoxList[3].setOnCheckedChangeListener { _, isChecked4 ->
                if (isChecked4) {
//                    customDialograd.radeng.isChecked = false
//                    customDialograd.radinv.isChecked = false
//                    customDialograd.radac.isChecked = false
//                    customDialograd.radbord.isChecked = false
//                    customDialograd.airfalp.isChecked = false
                    customDialograd.s3erman.text = null
                    customDialog_RAD.show()
                }else{
                    binding.chpub9yaneh4.text = "رديتر محرك / انفرتر"
                    binding.pricpub9yaneh4.text = null
                }
                val checkBoxList = mutableListOf<CheckBox>()
                val checkBoxNames = listOf("radeng", "radinv", "radac", "radbord", "airfalp")
                for (checkBoxName in checkBoxNames) {
                    val checkBox =
                        customDialograd::class.java.getDeclaredField(checkBoxName)
                            .get(customDialograd) as CheckBox
                    checkBoxList.add(checkBox)
                    checkBox.setOnCheckedChangeListener { _, _ ->
                        val selectedCheckBoxes = checkBoxList.filter { it.isChecked }
                        if (selectedCheckBoxes.size == 1) {
                            binding.chpub9yaneh4.text ="تبديل " + selectedCheckBoxes[0].text
                        } else if (selectedCheckBoxes.size > 1) {
                            binding.chpub9yaneh4.text ="تبديل " +
                                selectedCheckBoxes.joinToString(separator = " ,") { it.text }
                        } else {
                            binding.chpub9yaneh4.text = "رديتر محرك / انفرتر"
                        }
                    }
                }
                customDialograd.btnradsav.setOnClickListener {
                    for (a in checkBoxList.indices){
                        if (!checkBoxList.any { it.isChecked }) {
                            Toast.makeText(context, "يجب تحديد احد الخانات", Toast.LENGTH_LONG).show()
                            return@setOnClickListener
                        }else{
                            if (customDialograd.s3erman.text.isEmpty()){
                                customDialograd.s3erman.requestFocus()
                                customDialograd.s3erman.error = "يجب تحديد وضع السعر"
                                return@setOnClickListener
                            }else {
                                binding.pricpub9yaneh4.text = customDialograd.s3erman.text
                                reactiveeditttext()
                                customDialog_RAD.dismiss()
                            }
                        }
                    }
                }
                customDialograd.btnradcan.setOnClickListener {
                    checkBoxList.forEach { it.isChecked = false }
                    customDialograd.s3erman.text = null
                    binding.chpub9yaneh4.isChecked = false
                    customDialog_RAD.dismiss()
                }
            }

            val customDialogmo3 = DialogMo3Binding.inflate(layoutInflater)
            customDialog_MO3 = Dialog(activity!!)
            customDialog_MO3.setContentView(customDialogmo3.root)
            customDialog_MO3.setCancelable(false)
            customDialog_MO3.window?.setLayout(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT)
            customDialog_MO3.window?.setFlags(
                WindowManager.LayoutParams.FLAG_SECURE,
                WindowManager.LayoutParams.FLAG_SECURE)

            viewModelPub9yaneh.checkBoxList[4].setOnCheckedChangeListener { _, isChecked5 ->
                if (isChecked5) {
//                    customDialogmo3.dBRear.isChecked = false
//                    customDialogmo3.dBFront.isChecked = false
//                    customDialogmo3.qb8ab.isChecked = false
                    customDialogmo3.dBRear.text = "معاير سفلي"
                    customDialogmo3.dBFront.text = "معاير علوي"
                    customDialogmo3.qb8ab.text = "بكرة"
                    customDialogmo3.s3erYadweeBreak.text = null
                    customDialog_MO3.show()
                }else{
                    binding.chpub9yaneh5.text = "تبديل معاير"
                    binding.pricpub9yaneh5.text = null
                }
                val checkBoxList = mutableListOf<CheckBox>()
                val checkBoxNames = listOf("dBRear", "dBFront", "qb8ab")
                for (checkBoxName in checkBoxNames) {
                    val checkBox =
                        customDialogmo3::class.java.getDeclaredField(checkBoxName)
                            .get(customDialogmo3) as CheckBox
                    checkBoxList.add(checkBox)
                    checkBox.setOnCheckedChangeListener { _, _ ->
                        val selectedCheckBoxes = checkBoxList.filter { it.isChecked }
                        if (selectedCheckBoxes.size == 1) {
                            binding.chpub9yaneh5.text ="تبديل " + selectedCheckBoxes[0].text
                        } else if (selectedCheckBoxes.size > 1) {
                            binding.chpub9yaneh5.text ="تبديل " +
                                    selectedCheckBoxes.joinToString(separator = " ,") { it.text }
                        } else {
                            binding.chpub9yaneh5.text = "تبديل معاير"
                        }
                    }
                }
                customDialogmo3.btnSvDigBreak.setOnClickListener {
                    for (a in checkBoxList.indices){
                        if (!checkBoxList.any { it.isChecked }) {
                            Toast.makeText(context, "يجب تحديد احد الخانات", Toast.LENGTH_LONG).show()
                            return@setOnClickListener
                        }else{
                            if (customDialogmo3.s3erYadweeBreak.text.isEmpty()){
                                customDialogmo3.s3erYadweeBreak.requestFocus()
                                customDialogmo3.s3erYadweeBreak.error = "يجب تحديد وضع السعر"
                                return@setOnClickListener
                            }else {
                                binding.pricpub9yaneh5.text = customDialogmo3.s3erYadweeBreak.text
                                reactiveeditttext()
                                customDialog_MO3.dismiss()

                            }
                        }
                    }
                }
                customDialogmo3.btnCnDigBreak.setOnClickListener {
                    checkBoxList.forEach { it.isChecked = false }
                    customDialogmo3.s3erYadweeBreak.text = null
                    binding.chpub9yaneh5.isChecked = false
                    customDialog_MO3.dismiss()
                }
            }
            val binding8sha6 = Dialog8sha6Binding.inflate(layoutInflater)
            customDialog_8sha6 = Dialog(activity!!)
            customDialog_8sha6.setContentView(binding8sha6.root)
            customDialog_8sha6.setCancelable(false)
            customDialog_8sha6.window?.setLayout(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
            )
            customDialog_8sha6.window?.setFlags(WindowManager.LayoutParams.FLAG_SECURE, WindowManager.LayoutParams.FLAG_SECURE)

            viewModelPub9yaneh.checkBoxList[7].setOnCheckedChangeListener { _, isChecked8 ->
                if (isChecked8) {
//                    binding8sha6.frontleft.isChecked = false
//                    binding8sha6.frontright.isChecked = false

                    binding8sha6.frontleft.text = "قشاط دينمو"
                    binding8sha6.frontright.text = "قشاط طرمبة ماء"

                    binding8sha6.s3erYadwee.text = null
                    customDialog_8sha6.show()
                }else{
                    binding.chpub9yaneh8.text = "تبديل قشاط"
                    binding.pricpub9yaneh8.text = null
                }
                val checkBoxList = mutableListOf<CheckBox>()
                val checkBoxNames = listOf("frontleft", "frontright")
                for (checkBoxName in checkBoxNames) {
                    val checkBox =
                        binding8sha6::class.java.getDeclaredField(checkBoxName)
                            .get(binding8sha6) as CheckBox
                    checkBoxList.add(checkBox)
                    checkBox.setOnCheckedChangeListener { _, _ ->
                        val selectedCheckBoxes = checkBoxList.filter { it.isChecked }
                        if (selectedCheckBoxes.size == 1) {
                            binding.chpub9yaneh8.text ="تبديل " + selectedCheckBoxes[0].text
                        } else if (selectedCheckBoxes.size > 1) {
                            binding.chpub9yaneh8.text ="تبديل " +
                                    selectedCheckBoxes.joinToString(separator = " ,") { it.text }
                        } else {
                            binding.chpub9yaneh8.text = "تبديل قشاط"
                        }
                    }
                }
                binding8sha6.buttonDailogSave.setOnClickListener {
                    for (a in checkBoxList.indices){
                        if (!checkBoxList.any { it.isChecked }) {
                            Toast.makeText(context, "يجب تحديد احد الخانات", Toast.LENGTH_LONG).show()
                            return@setOnClickListener
                        }else{
                            if (binding8sha6.s3erYadwee.text.isEmpty()){
                                binding8sha6.s3erYadwee.requestFocus()
                                binding8sha6.s3erYadwee.error = "يجب تحديد وضع السعر"
                                return@setOnClickListener
                            }else {
                                binding.pricpub9yaneh8.text = binding8sha6.s3erYadwee.text
                                reactiveeditttext()
                                customDialog_8sha6.dismiss()

                            }
                        }
                    }
                }
                binding8sha6.buttonDailogCancel.setOnClickListener {
                    checkBoxList.forEach { it.isChecked = false }
                    binding8sha6.s3erYadwee.text = null
                    binding.chpub9yaneh8.isChecked = false
                    customDialog_8sha6.dismiss()
                }
            }

            val bindingKAT = DialogKatBinding.inflate(layoutInflater)
            customDialog_KAT = Dialog(activity!!)
            customDialog_KAT.setContentView(bindingKAT.root)
            customDialog_KAT.setCancelable(false)
            customDialog_KAT.window?.setLayout(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
            )
            customDialog_KAT.window?.setFlags(WindowManager.LayoutParams.FLAG_SECURE, WindowManager.LayoutParams.FLAG_SECURE)

            viewModelPub9yaneh.checkBoxList[12].setOnCheckedChangeListener { _, isChecked13 ->
                if (isChecked13) {
//                    bindingKAT.outsideleft.isChecked = false
//                    bindingKAT.outsideright.isChecked = false
//                    bindingKAT.insideleft.isChecked = false
//                    bindingKAT.insideright.isChecked = false

                    bindingKAT.outsideleft.text = "تنضيف كتلايزر علوي"
                    bindingKAT.outsideright.text = "تنضيف كتلايزر سفلي"
                    bindingKAT.insideleft.text = "تبديل كتلايزر علوي"
                    bindingKAT.insideright.text = "تبديل كتلايزر سفلي"
                    bindingKAT.titR2sOut.text = "تنضيف"
                    bindingKAT.titR2sIn.text = "تبديل"
                    bindingKAT.s3erR2sAcx.text = null
                    customDialog_KAT.show()
                }else{
                    binding.chpub9yaneh13.text = "كتلايزر"
                    binding.pricpub9yaneh13.text = null
                }
                val checkBoxList = mutableListOf<CheckBox>()
                val checkBoxNames = listOf("outsideleft", "outsideright" , "insideleft" , "insideright")
                for (checkBoxName in checkBoxNames) {
                    val checkBox =
                        bindingKAT::class.java.getDeclaredField(checkBoxName)
                            .get(bindingKAT) as CheckBox
                    checkBoxList.add(checkBox)
                    checkBox.setOnCheckedChangeListener { _, _ ->
                        val selectedCheckBoxes = checkBoxList.filter { it.isChecked }
                        if (selectedCheckBoxes.size == 1) {
                            binding.chpub9yaneh13.text = selectedCheckBoxes[0].text
                        } else if (selectedCheckBoxes.size > 1) {
                            binding.chpub9yaneh13.text =
                                    selectedCheckBoxes.joinToString(separator = " ,") { it.text }
                        } else {
                            binding.chpub9yaneh13.text = "كتلايزر"
                        }
                    }
                }
                bindingKAT.btnR2sSav.setOnClickListener {
                    for (a in checkBoxList.indices){
                        if (!checkBoxList.any { it.isChecked }) {
                            Toast.makeText(context, "يجب تحديد احد الخانات", Toast.LENGTH_LONG).show()
                            return@setOnClickListener
                        }else{
                            if (bindingKAT.s3erR2sAcx.text.isEmpty()){
                                bindingKAT.s3erR2sAcx.requestFocus()
                                bindingKAT.s3erR2sAcx.error = "يجب تحديد وضع السعر"
                                return@setOnClickListener
                            }else {
                                binding.pricpub9yaneh13.text = bindingKAT.s3erR2sAcx.text
                                reactiveeditttext()
                                customDialog_KAT.dismiss()

                            }
                        }
                    }
                }
                bindingKAT.btnR2sCan.setOnClickListener {
                    checkBoxList.forEach { it.isChecked = false }
                    bindingKAT.s3erR2sAcx.text = null
                    binding.chpub9yaneh13.isChecked = false
                    customDialog_KAT.dismiss()
                }
            }
            val bindingb5a5 = DialogB5a5Binding.inflate(layoutInflater)
            customDialog_b5a5 = Dialog(activity!!)
            customDialog_b5a5.setContentView(bindingb5a5.root)
            customDialog_b5a5.setCancelable(false)
            customDialog_b5a5.window?.setLayout(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
            )
            customDialog_b5a5.window?.setFlags(WindowManager.LayoutParams.FLAG_SECURE, WindowManager.LayoutParams.FLAG_SECURE)

            viewModelPub9yaneh.checkBoxList[14].setOnCheckedChangeListener { _, isChecked15 ->
                if (isChecked15) {
//                    bindingb5a5.frontleft.isChecked = false
//                    bindingb5a5.frontright.isChecked = false

                    bindingb5a5.frontleft.text = "تنضيف بخاخات"
                    bindingb5a5.frontright.text = "تبديل بخاخات"

                    bindingb5a5.s3erYadwee.text = null
                    customDialog_b5a5.show()
                }else{
                    binding.chpub9yaneh15.text = "بخاخات"
                    binding.pricpub9yaneh15.text = null
                }
                val checkBoxList = mutableListOf<CheckBox>()
                val checkBoxNames = listOf("frontleft", "frontright")
                for (checkBoxName in checkBoxNames) {
                    val checkBox =
                        bindingb5a5::class.java.getDeclaredField(checkBoxName)
                            .get(bindingb5a5) as CheckBox
                    checkBoxList.add(checkBox)
                    checkBox.setOnCheckedChangeListener { _, _ ->
                        val selectedCheckBoxes = checkBoxList.filter { it.isChecked }
                        if (selectedCheckBoxes.size == 1) {
                            binding.chpub9yaneh15.text =selectedCheckBoxes[0].text
                        } else if (selectedCheckBoxes.size > 1) {
                            binding.chpub9yaneh15.text =
                                    selectedCheckBoxes.joinToString(separator = " ,") { it.text }
                        } else {
                            binding.chpub9yaneh15.text = "بخاخات"
                        }
                    }
                }
                bindingb5a5.buttonDailogSave.setOnClickListener {
                    for (a in checkBoxList.indices){
                        if (!checkBoxList.any { it.isChecked }) {
                            Toast.makeText(context, "يجب تحديد احد الخانات", Toast.LENGTH_LONG).show()
                            return@setOnClickListener
                        }else{
                            if (bindingb5a5.s3erYadwee.text.isEmpty()){
                                bindingb5a5.s3erYadwee.requestFocus()
                                bindingb5a5.s3erYadwee.error = "يجب تحديد وضع السعر"
                                return@setOnClickListener
                            }else {
                                binding.pricpub9yaneh15.text = bindingb5a5.s3erYadwee.text
                                reactiveeditttext()
                                customDialog_b5a5.dismiss()

                            }
                        }
                    }
                }
                bindingb5a5.buttonDailogCancel.setOnClickListener {
                    checkBoxList.forEach { it.isChecked = false }
                    bindingb5a5.s3erYadwee.text = null
                    binding.chpub9yaneh15.isChecked = false
                    customDialog_b5a5.dismiss()
                }
            }

            val bindingmobared = DialogMobaredBinding.inflate(layoutInflater)
            customDialog_mobared = Dialog(activity!!)
            customDialog_mobared.setContentView(bindingmobared.root)
            customDialog_mobared.setCancelable(false)
            customDialog_mobared.window?.setLayout(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
            )
            customDialog_mobared.window?.setFlags(WindowManager.LayoutParams.FLAG_SECURE, WindowManager.LayoutParams.FLAG_SECURE)

            viewModelPub9yaneh.checkBoxList[15].setOnCheckedChangeListener { _, isChecked16 ->
                if (isChecked16) {
//                    bindingmobared.frontleft.isChecked = false
//                    bindingmobared.frontright.isChecked = false

                    bindingmobared.frontleft.text = "مبرد زيت محرك"
                    bindingmobared.frontright.text = "مبرد زيت جير"

                    bindingmobared.s3erYadwee.text = null
                    customDialog_mobared.show()
                }else{
                    binding.chpub9yaneh16.text = "مبرد زيت"
                    binding.pricpub9yaneh16.text = null
                }
                val checkBoxList = mutableListOf<CheckBox>()
                val checkBoxNames = listOf("frontleft", "frontright")
                for (checkBoxName in checkBoxNames) {
                    val checkBox =
                        bindingmobared::class.java.getDeclaredField(checkBoxName)
                            .get(bindingmobared) as CheckBox
                    checkBoxList.add(checkBox)
                    checkBox.setOnCheckedChangeListener { _, _ ->
                        val selectedCheckBoxes = checkBoxList.filter { it.isChecked }
                        if (selectedCheckBoxes.size == 1) {
                            binding.chpub9yaneh16.text ="تبديل " + selectedCheckBoxes[0].text
                        } else if (selectedCheckBoxes.size > 1) {
                            binding.chpub9yaneh16.text ="تبديل " +
                                    selectedCheckBoxes.joinToString(separator = " ,") { it.text }
                        } else {
                            binding.chpub9yaneh16.text = "مبرد زيت"
                        }
                    }
                }
                bindingmobared.buttonDailogSave.setOnClickListener {
                    for (a in checkBoxList.indices){
                        if (!checkBoxList.any { it.isChecked }) {
                            Toast.makeText(context, "يجب تحديد احد الخانات", Toast.LENGTH_LONG).show()
                            return@setOnClickListener
                        }else{
                            if (bindingmobared.s3erYadwee.text.isEmpty()){
                                bindingmobared.s3erYadwee.requestFocus()
                                bindingmobared.s3erYadwee.error = "يجب تحديد وضع السعر"
                                return@setOnClickListener
                            }else {
                                binding.pricpub9yaneh16.text = bindingmobared.s3erYadwee.text
                                reactiveeditttext()
                                customDialog_mobared.dismiss()

                            }
                        }
                    }
                }
                bindingmobared.buttonDailogCancel.setOnClickListener {
                    checkBoxList.forEach { it.isChecked = false }
                    bindingmobared.s3erYadwee.text = null
                    binding.chpub9yaneh16.isChecked = false
                    customDialog_mobared.dismiss()
                }
            }

            val bindingoxg = DialogOxgBinding.inflate(layoutInflater)
            customDialog_oxg = Dialog(activity!!)
            customDialog_oxg.setContentView(bindingoxg.root)
            customDialog_oxg.setCancelable(false)
            customDialog_oxg.window?.setLayout(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
            )
            customDialog_oxg.window?.setFlags(WindowManager.LayoutParams.FLAG_SECURE, WindowManager.LayoutParams.FLAG_SECURE)

            viewModelPub9yaneh.checkBoxList[17].setOnCheckedChangeListener { _, isChecked18 ->
                if (isChecked18) {
//                    bindingoxg.frontleft.isChecked = false
//                    bindingoxg.frontright.isChecked = false

                    bindingoxg.frontleft.text = "حساس اكسجين علوي"
                    bindingoxg.frontright.text = "حساس اكسجين سفلي"

                    bindingoxg.s3erYadwee.text = null
                    customDialog_oxg.show()
                }else{
                    binding.chpub9yaneh18.text = "حساس اكسجين"
                    binding.pricpub9yaneh18.text = null
                }
                val checkBoxList = mutableListOf<CheckBox>()
                val checkBoxNames = listOf("frontleft", "frontright")
                for (checkBoxName in checkBoxNames) {
                    val checkBox =
                        bindingoxg::class.java.getDeclaredField(checkBoxName)
                            .get(bindingoxg) as CheckBox
                    checkBoxList.add(checkBox)
                    checkBox.setOnCheckedChangeListener { _, _ ->
                        val selectedCheckBoxes = checkBoxList.filter { it.isChecked }
                        if (selectedCheckBoxes.size == 1) {
                            binding.chpub9yaneh18.text ="تبديل " + selectedCheckBoxes[0].text
                        } else if (selectedCheckBoxes.size > 1) {
                            binding.chpub9yaneh18.text ="تبديل " +
                                    selectedCheckBoxes.joinToString(separator = " ,") { it.text }
                        } else {
                            binding.chpub9yaneh18.text = "حساس اكسجين"
                        }
                    }
                }
                bindingoxg.buttonDailogSave.setOnClickListener {
                    for (a in checkBoxList.indices){
                        if (!checkBoxList.any { it.isChecked }) {
                            Toast.makeText(context, "يجب تحديد احد الخانات", Toast.LENGTH_LONG).show()
                            return@setOnClickListener
                        }else{
                            if (bindingoxg.s3erYadwee.text.isEmpty()){
                                bindingoxg.s3erYadwee.requestFocus()
                                bindingoxg.s3erYadwee.error = "يجب تحديد وضع السعر"
                                return@setOnClickListener
                            }else {
                                binding.pricpub9yaneh18.text = bindingoxg.s3erYadwee.text
                                reactiveeditttext()
                                customDialog_oxg.dismiss()

                            }
                        }
                    }
                }
                bindingoxg.buttonDailogCancel.setOnClickListener {
                    checkBoxList.forEach { it.isChecked = false }
                    bindingoxg.s3erYadwee.text = null
                    binding.chpub9yaneh18.isChecked = false
                    customDialog_oxg.dismiss()
                }
            }
        }

        for (i in viewModelPub9yaneh.editTextList.indices) {
            viewModelPub9yaneh.editTextList[i].addTextChangedListener(object : TextWatcher {
                override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
                override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                    if (s.isNullOrEmpty()) {
                        viewModelPub9yaneh.checkBoxList[i].isChecked = false
                    }
                    if (s!!.isNotEmpty()) {
                        for (j in viewModelPub9yaneh.editTextList.indices) {
                            if (j != i) {
                                viewModelPub9yaneh.editTextList[j].isEnabled = false
                            }
                            viewModelPub9yaneh.editPub9yanehTextList.clear()
                            viewModelPub9yaneh.checkBoxPub9yanehList.clear()
                            viewModelPub9yaneh.editPub9yanehTextList.addAll(viewModelPub9yaneh.editTextList)
                            viewModelPub9yaneh.checkBoxPub9yanehList.addAll(viewModelPub9yaneh.checkBoxList)
                        }
                    }
                }
                override fun afterTextChanged(s: Editable?) {
                }
            })
        }

        loadCheckBoxes()
        return root
    }

    override fun onPause() {
        super.onPause()
        saveCheckBoxes()
    }

    private fun saveCheckBoxes() {

        viewModelPub9yaneh.chpub9yaneh3 = binding.chpub9yaneh3.isChecked
        viewModelPub9yaneh.chpub9yaneh4 = binding.chpub9yaneh4.isChecked
        viewModelPub9yaneh.chpub9yaneh5 = binding.chpub9yaneh5.isChecked
        viewModelPub9yaneh.chpub9yaneh8 = binding.chpub9yaneh8.isChecked
        viewModelPub9yaneh.chpub9yaneh13 = binding.chpub9yaneh13.isChecked
        viewModelPub9yaneh.chpub9yaneh15 = binding.chpub9yaneh15.isChecked
        viewModelPub9yaneh.chpub9yaneh16 = binding.chpub9yaneh16.isChecked
        viewModelPub9yaneh.chpub9yaneh18 = binding.chpub9yaneh18.isChecked

        viewModelPub9yaneh.chtext3 = binding.chpub9yaneh3.text.toString()
        viewModelPub9yaneh.chtext4 = binding.chpub9yaneh4.text.toString()
        viewModelPub9yaneh.chtext5 = binding.chpub9yaneh5.text.toString()
        viewModelPub9yaneh.chtext8 = binding.chpub9yaneh8.text.toString()
        viewModelPub9yaneh.chtext13 = binding.chpub9yaneh13.text.toString()
        viewModelPub9yaneh.chtext15 = binding.chpub9yaneh15.text.toString()
        viewModelPub9yaneh.chtext16 = binding.chpub9yaneh16.text.toString()
        viewModelPub9yaneh.chtext18 = binding.chpub9yaneh18.text.toString()

    }

    private fun loadCheckBoxes() {


        binding.chpub9yaneh3.isChecked = viewModelPub9yaneh.chpub9yaneh3
        binding.chpub9yaneh4.isChecked = viewModelPub9yaneh.chpub9yaneh3
        binding.chpub9yaneh5.isChecked = viewModelPub9yaneh.chpub9yaneh3
        binding.chpub9yaneh8.isChecked = viewModelPub9yaneh.chpub9yaneh3
        binding.chpub9yaneh13.isChecked = viewModelPub9yaneh.chpub9yaneh3
        binding.chpub9yaneh15.isChecked = viewModelPub9yaneh.chpub9yaneh3
        binding.chpub9yaneh16.isChecked = viewModelPub9yaneh.chpub9yaneh3
        binding.chpub9yaneh18.isChecked = viewModelPub9yaneh.chpub9yaneh3

        binding.chpub9yaneh3.text = viewModelPub9yaneh.chtext3
        binding.chpub9yaneh4.text = viewModelPub9yaneh.chtext4
        binding.chpub9yaneh5.text = viewModelPub9yaneh.chtext5
        binding.chpub9yaneh8.text = viewModelPub9yaneh.chtext8
        binding.chpub9yaneh13.text = viewModelPub9yaneh.chtext13
        binding.chpub9yaneh15.text = viewModelPub9yaneh.chtext15
        binding.chpub9yaneh16.text = viewModelPub9yaneh.chtext16
        binding.chpub9yaneh18.text = viewModelPub9yaneh.chtext18

         customDialogFR.dismiss()
         customDialog_RAD.dismiss()
         customDialog_MO3.dismiss()
         customDialog_KAT.dismiss()
         customDialog_8sha6.dismiss()
         customDialog_b5a5.dismiss()
         customDialog_mobared.dismiss()
         customDialog_oxg.dismiss()

    }

private fun reactiveeditttext(){
    for (v in viewModelPub9yaneh.editTextList.indices) {
    for (j in viewModelPub9yaneh.editTextList.indices) {
    if (j != v) {
    viewModelPub9yaneh.editTextList[j].isEnabled = true
    }
     }
      }
}

    override fun onPrepareOptionsMenu(menu: Menu) {
        menu.findItem(R.id.action_Save).isVisible = true
        super.onPrepareOptionsMenu(menu)
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}