package com.example.mizanalnasr.ui.home

import android.app.Dialog
import android.arch.lifecycle.ViewModelProviders
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.Toolbar
import android.text.SpannableString
import android.text.style.AbsoluteSizeSpan
import android.text.style.ForegroundColorSpan
import android.view.*
import android.widget.CheckBox
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.example.mizanalnasr.R
import com.example.mizanalnasr.databinding.FragmentHomeBinding
import com.example.mizanalnasr.ui.first.FirstViewModel
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.dialog_break.*
import kotlinx.android.synthetic.main.dialog_mezan.*
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.android.synthetic.main.fragment_home.view.*
import kotlinx.android.synthetic.main.front_dailog.*
import kotlinx.android.synthetic.main.r2syet_2ks_dailog.*

class HomeFragment : Fragment() {
    private lateinit var viewModel: FirstViewModel
    private lateinit var homeModel: HomeViewModel
    private lateinit var homeModel2: Home2ViewModel
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    private lateinit var customDialogFB_paying: Dialog
    private lateinit var customDialogMZ: Dialog
    private lateinit var customDialogF79: Dialog
    private lateinit var customDialogR2SX: Dialog
    private lateinit var customDialogBRK: Dialog
    private lateinit var customDialogFR: Dialog

    private lateinit var ch1: CheckBox
    private lateinit var editTextNumber1: TextView
    private lateinit var ch2: CheckBox
    private lateinit var editTextNumber2: TextView
    private lateinit var ch3: CheckBox
    private lateinit var editTextNumber3: TextView
    private lateinit var ch4: CheckBox
    private lateinit var editTextNumber4: TextView
    private lateinit var ch5: CheckBox
    private lateinit var editTextNumber5: TextView
    private lateinit var ch6: CheckBox
    private lateinit var editTextNumber6: TextView
    private lateinit var ch7: CheckBox
    private lateinit var editTextNumber7: TextView
    private lateinit var ch8: CheckBox
    private lateinit var editTextNumber8: TextView
    private lateinit var ch9: CheckBox
    private lateinit var editTextNumber9: TextView
    private lateinit var ch10: CheckBox
    private lateinit var editTextNumber10: TextView
    private lateinit var ch11: CheckBox
    private lateinit var editTextNumber11: TextView
    private lateinit var ch12: CheckBox
    private lateinit var editTextNumber12: TextView
    private lateinit var ch13: CheckBox
    private lateinit var editTextNumber13: TextView
    private lateinit var ch14: CheckBox
    private lateinit var editTextNumber14: TextView
    private lateinit var ch15: CheckBox
    private lateinit var editTextNumber15: TextView
    private lateinit var ch16: CheckBox
    private lateinit var editTextNumber16: TextView
    private lateinit var ch17: CheckBox
    private lateinit var editTextNumber17: TextView
    private lateinit var ch18: CheckBox
    private lateinit var editTextNumber18: TextView
    private lateinit var ch19: CheckBox
    private lateinit var editTextNumber19: TextView
    private lateinit var ch20: CheckBox
    private lateinit var editTextNumber20: TextView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        customDialogFB_paying = Dialog(activity!!)
        customDialogFB_paying.setContentView(R.layout.paying_dailog)
        customDialogFB_paying.setCancelable(false)
        customDialogFB_paying.window?.setLayout(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )
        customDialogMZ = Dialog(activity!!)
        customDialogMZ.setContentView(R.layout.dialog_mezan)
        customDialogMZ.setCancelable(false)
        customDialogMZ.window?.setLayout(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.WRAP_CONTENT)

        customDialogF79 = Dialog(activity!!)
        customDialogF79.setContentView(R.layout.dialog_fa7e9)
        customDialogF79.setCancelable(false)
        customDialogF79.window?.setLayout(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.WRAP_CONTENT)

        customDialogR2SX = Dialog(activity!!)
        customDialogR2SX.setContentView(R.layout.r2syet_2ks_dailog)
        customDialogR2SX.setCancelable(true)
        customDialogR2SX.window?.setLayout(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )

        customDialogBRK = Dialog(activity!!)
        customDialogBRK.setContentView(R.layout.dialog_break)
        customDialogBRK.setCancelable(false)
        customDialogBRK.window?.setLayout(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )

        customDialogFR = Dialog(activity!!)
        customDialogFR.setContentView(R.layout.front_dailog)
        customDialogFR.setCancelable(false)
        customDialogFR.window?.setLayout(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )

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

        val toolbar = activity?.findViewById<Toolbar>(R.id.toolbar)
        toolbar?.setTitleTextAppearance(this.context, R.style.boldText)

        viewModel = activity?.run {
            ViewModelProviders.of(this).get(FirstViewModel::class.java)
        } ?: throw Exception("Invalid Activity")

        homeModel = activity?.run {
            ViewModelProviders.of(this).get(HomeViewModel::class.java)
        } ?: throw Exception("Invalid Activity")

        homeModel2 = activity?.run {
            ViewModelProviders.of(this).get(Home2ViewModel::class.java)
        } ?: throw Exception("Invalid Activity")

        ch1= root.findViewById(R.id.ch1)
        ch2= root.findViewById(R.id.ch2)
        ch3= root.findViewById(R.id.ch3)
        ch4= root.findViewById(R.id.ch4)
        ch5= root.findViewById(R.id.ch5)
        ch6= root.findViewById(R.id.ch6)
        ch7= root.findViewById(R.id.ch7)
        ch8= root.findViewById(R.id.ch8)
        ch9= root.findViewById(R.id.ch9)
        ch10= root.findViewById(R.id.ch10)
        ch11= root.findViewById(R.id.ch11)
        ch12= root.findViewById(R.id.ch12)
        ch13= root.findViewById(R.id.ch13)
        ch14= root.findViewById(R.id.ch14)
        ch15= root.findViewById(R.id.ch15)
        ch16= root.findViewById(R.id.ch16)
        ch17= root.findViewById(R.id.ch17)
        ch18= root.findViewById(R.id.ch18)
        ch19= root.findViewById(R.id.ch19)
        ch20= root.findViewById(R.id.ch20)

        editTextNumber1= root.findViewById(R.id.editTextNumber1)
        editTextNumber2= root.findViewById(R.id.pricd2)
        editTextNumber3= root.findViewById(R.id.pricd3)
        editTextNumber4= root.findViewById(R.id.pricd4)
        editTextNumber5= root.findViewById(R.id.pricd5)
        editTextNumber6= root.findViewById(R.id.pricd6)
        editTextNumber7= root.findViewById(R.id.pricd7)
        editTextNumber8= root.findViewById(R.id.pricd8)
        editTextNumber9= root.findViewById(R.id.pricd9)
        editTextNumber10= root.findViewById(R.id.editTextNumber10)
        editTextNumber11= root.findViewById(R.id.editTextNumber11)
        editTextNumber12= root.findViewById(R.id.editTextNumber12)
        editTextNumber13= root.findViewById(R.id.editTextNumber13)
        editTextNumber14= root.findViewById(R.id.editTextNumber14)
        editTextNumber15= root.findViewById(R.id.editTextNumber15)
        editTextNumber16= root.findViewById(R.id.editTextNumber16)
        editTextNumber17= root.findViewById(R.id.editTextNumber17)
        editTextNumber18= root.findViewById(R.id.editTextNumber18)
        editTextNumber19= root.findViewById(R.id.editTextNumber19)
        editTextNumber20= root.findViewById(R.id.editTextNumber20)

//            homeModel.check1 = ch1.text.toString()
//            homeModel.check2 =
//            homeModel.check3 =
//            homeModel.check4 =
//            homeModel.check5 =
//            homeModel.check6 =
//            homeModel.check7 =
//            homeModel.check8 =
//            homeModel.check9 =
//            homeModel.check10 =
//            homeModel.check11 =
//            homeModel.check12 =
//            homeModel.check13 =
//            homeModel.check14 =
//            homeModel.check15 =
//            homeModel.check16 =
//            homeModel.check17 =
//            homeModel.check18 =
//            homeModel.check19 =
//            homeModel.check20 =

        ch1.setOnCheckedChangeListener { _, isChecked ->
        if (ch1.isChecked) {

            customDialogMZ.front.setOnCheckedChangeListener { _, isChecked1 ->
                if (customDialogMZ.front.isChecked) {
                    ch1.text ="ميزان امامي"
//                        ch1.text.toString() + " " + customDialogMZ.front.text.toString()
                } else {
                    ch1.text = "ميزان"
                    customDialogMZ.s3er_yadwee_fa7.setText("")
                }

                if (customDialogMZ.front.isChecked && customDialogMZ.rear.isChecked) {
                    ch1.text = "ميزان امامي و خلفي"
                    customDialogMZ.s3er_yadwee_fa7.setText("10")
                } else {
                    if (customDialogMZ.front.isChecked) {
                        ch1.text = "ميزان امامي"
                        customDialogMZ.s3er_yadwee_fa7.setText("5")
                    }
                    if (customDialogMZ.rear.isChecked) {
                        ch1.text = "ميزان خلفي"
                        customDialogMZ.s3er_yadwee_fa7.setText("5")
                    }
                }
            }
            customDialogMZ.rear.setOnCheckedChangeListener { _, isChecked2 ->
                if (customDialogMZ.rear.isChecked) {
                    ch1.text = "ميزان خلفي"
                        ch1.text.toString() + " " +
                            customDialogMZ.rear.text.toString()
                }else{ch1.text = "ميزان"
                    customDialogMZ.s3er_yadwee_fa7.setText("")}

                if (customDialogMZ.rear.isChecked && customDialogMZ.front.isChecked){
                    ch1.text = "ميزان امامي و خلفي"
                    customDialogMZ.s3er_yadwee_fa7.setText("10")
                }else {
                    if (customDialogMZ.front.isChecked) {
                        ch1.text = "ميزان امامي"
                        customDialogMZ.s3er_yadwee_fa7.setText("5")
                    }
                    if (customDialogMZ.rear.isChecked) {
                        ch1.text = "ميزان خلفي"
                        customDialogMZ.s3er_yadwee_fa7.setText("5")
                    }
                }

            }

            customDialogMZ.btn_sv_dig_fa7.setOnClickListener {
                if (!customDialogMZ.front.isChecked && !customDialogMZ.rear.isChecked) {
                    toast_notempty1.show()
                } else {
                    val  aa=customDialogMZ.s3er_yadwee_fa7.text.toString().trim()
                    if (aa.isEmpty()) {
                        toast_notempty.show()
                    } else {
                        editTextNumber1.text = customDialogMZ.s3er_yadwee_fa7.text.toString()
                        viewModel.totalAmount += editTextNumber1.text.toString().toInt()

                        homeModel.checkname1 += ch1.text.toString().trim()
                        homeModel.editname1 += editTextNumber1.text.toString().trim()
                        toolbar?.title =   viewModel.totalAmount.toString()
                        customDialogMZ.dismiss()
                    }
                }
            }
            customDialogMZ.btn_cn_dig_mz.setOnClickListener {
                ch1.isChecked = false
                customDialogMZ.s3er_yadwee_fa7.setText("")
                customDialogMZ.dismiss()
            }
            customDialogMZ.show()

        }
        else {
            if (editTextNumber1.text.toString().isNotEmpty()){
                viewModel.totalAmount -= editTextNumber1.text.toString().toInt()
                toolbar?.title =  viewModel.totalAmount.toString()
                editTextNumber1.text = ""}
            ch1.text = "ميزان"
            homeModel.checkname1 = ""
            homeModel.editname1 = ""
        }
    }

        ch2.setOnCheckedChangeListener { _, isChecked ->
            if (ch2.isChecked) {

                customDialogF79.btn_sv_dig_fa7.setOnClickListener {
                    if (customDialogF79.s3er_yadwee_fa7.text.toString().isEmpty()) {
                        toast_notempty.show()
                    } else {
                        pricd2.text = customDialogF79.s3er_yadwee_fa7.text.toString()
                        viewModel.totalAmount += pricd2.text.toString().toInt()
                        toolbar?.title =  viewModel.totalAmount.toString()
                        customDialogF79.dismiss()
                    }
                }
                customDialogF79.show()
                homeModel.checkname2 += ch2.text.toString().trim()
                homeModel.editname2 += pricd2.text.toString().trim()
            } else {
                viewModel.totalAmount -= pricd2.text.toString().toInt()
                toolbar?.title =  viewModel.totalAmount.toString()
                pricd2.text = ""
                homeModel.checkname2 = ""
                homeModel.editname2 =  ""
            }
        }

        ch3.setOnCheckedChangeListener { _, isChecked ->
            if (ch3.isChecked) {

                customDialogR2SX.outsideright.setOnCheckedChangeListener { _, isChecked1 ->

                    if (customDialogR2SX.outsideright.isChecked) {
                        ch3.text = "راسية اكس خارجية يمين"
                    }else{ch3.text = "راسية اكس"
                        customDialogR2SX.s3er_r2s_acx.setText("")}

                    if (customDialogR2SX.outsideright.isChecked && customDialogR2SX.outsideleft.isChecked && customDialogR2SX.insideright.isChecked && customDialogR2SX.insideleft.isChecked) {
                        ch3.text = "تغير جميع الرأسيات الخارجية و الداخلية"
                        customDialogR2SX.s3er_r2s_acx.setText("40")
                    } else {
                        if (customDialogR2SX.outsideright.isChecked && customDialogR2SX.outsideleft.isChecked && customDialogR2SX.insideright.isChecked) {
                            ch3.text = "راسيتين اكس خارجية و الداخلية يمين"
                            customDialogR2SX.s3er_r2s_acx.setText("30")
                        }else {
                            if (customDialogR2SX.outsideright.isChecked && customDialogR2SX.outsideleft.isChecked && customDialogR2SX.insideleft.isChecked) {
                                ch3.text = "راسيتين اكس خارجية و الداخلية يسار"
                                customDialogR2SX.s3er_r2s_acx.setText("30")
                            }else {
                                if (customDialogR2SX.outsideright.isChecked && customDialogR2SX.insideright.isChecked && customDialogR2SX.insideleft.isChecked) {
                                    ch3.text = "راسية اكس خارجية يمين و الداخليتين"
                                    customDialogR2SX.s3er_r2s_acx.setText("30")
                                }else {
                                    if (customDialogR2SX.outsideleft.isChecked && customDialogR2SX.insideright.isChecked && customDialogR2SX.insideleft.isChecked) {
                                        ch3.text = "راسية اكس خارجية يسار و الداخليتين"
                                        customDialogR2SX.s3er_r2s_acx.setText("30")
                                    }else {
                                        if (customDialogR2SX.outsideright.isChecked && customDialogR2SX.outsideleft.isChecked) {
                                            ch3.text = "راسية اكس خارجية يمين و يسار"
                                            customDialogR2SX.s3er_r2s_acx.setText("20")
                                        }else {
                                            if (customDialogR2SX.outsideright.isChecked && customDialogR2SX.insideright.isChecked) {
                                                ch3.text = "راسية اكس خارجية يمين و داخلية يمين"
                                                customDialogR2SX.s3er_r2s_acx.setText("20")
                                            }else {
                                                if (customDialogR2SX.outsideright.isChecked && customDialogR2SX.insideleft.isChecked) {
                                                    ch3.text = "راسية اكس خارجية يمين و داخلية يسار"
                                                    customDialogR2SX.s3er_r2s_acx.setText("20")
                                                }else {
                                                    if (customDialogR2SX.outsideleft.isChecked && customDialogR2SX.insideright.isChecked) {
                                                        ch3.text = "راسية اكس خارجية يسار و داخلية يمين"
                                                        customDialogR2SX.s3er_r2s_acx.setText("20")
                                                    }else {
                                                        if (customDialogR2SX.outsideleft.isChecked && customDialogR2SX.insideleft.isChecked) {
                                                            ch3.text = "راسية اكس خارجية يسار و داخلية يسار"
                                                            customDialogR2SX.s3er_r2s_acx.setText("20")
                                                        }else {
                                                            if (customDialogR2SX.insideright.isChecked && customDialogR2SX.insideleft.isChecked) {
                                                                ch3.text = "راسية اكس داخلية يمين و يسار"
                                                                customDialogR2SX.s3er_r2s_acx.setText("20")
                                                            } else {

                                                                if (customDialogR2SX.outsideright.isChecked) {
                                                                    ch3.text = "راسية اكس خارجية يمين"
                                                                    customDialogR2SX.s3er_r2s_acx.setText("10")
                                                                }
                                                                if (customDialogR2SX.outsideleft.isChecked) {
                                                                    ch3.text = "راسية اكس خارجية يسار"
                                                                    customDialogR2SX.s3er_r2s_acx.setText("10")
                                                                }

                                                                if (customDialogR2SX.insideleft.isChecked) {
                                                                    ch3.text = "راسية اكس داخلية يسار"
                                                                    customDialogR2SX.s3er_r2s_acx.setText("10")
                                                                }
                                                                if (customDialogR2SX.insideright.isChecked) {
                                                                    ch3.text = "راسية اكس داخلية يمين"
                                                                    customDialogR2SX.s3er_r2s_acx.setText("10")
                                                                }
                                                            }
                                                        }
                                                    }}}}}}}}}
                    customDialogR2SX.show()
                }



                customDialogR2SX.outsideleft.setOnCheckedChangeListener { _, isChecked2 ->
                    if (customDialogR2SX.outsideleft.isChecked) {
                        ch3.text = "راسية اكس خارجية يسار"
                    }else{ch3.text = "راسية اكس"
                        customDialogR2SX.s3er_r2s_acx.setText("")}

                    if (customDialogR2SX.outsideright.isChecked && customDialogR2SX.outsideleft.isChecked && customDialogR2SX.insideright.isChecked && customDialogR2SX.insideleft.isChecked ) {
                        ch3.text = "تغير جميع الرأسيات الخارجية و الداخلية"
                        customDialogR2SX.s3er_r2s_acx.setText("40")
                    }else{
                        if (customDialogR2SX.outsideleft.isChecked && customDialogR2SX.outsideright.isChecked && customDialogR2SX.insideright.isChecked ) {
                            ch3.text = "راسيتين اكس خارجية و الداخلية يمين"
                            customDialogR2SX.s3er_r2s_acx.setText("30")
                        }else{
                            if (customDialogR2SX.outsideleft.isChecked && customDialogR2SX.outsideright.isChecked && customDialogR2SX.insideleft.isChecked ) {
                                ch3.text = "راسيتين اكس خارجية و الداخلية يسار"
                                customDialogR2SX.s3er_r2s_acx.setText("30")
                            }else{
                                if (customDialogR2SX.outsideright.isChecked && customDialogR2SX.insideright.isChecked && customDialogR2SX.insideleft.isChecked ) {
                                    ch3.text = "راسية اكس خارجية يمين و الداخليتين"
                                    customDialogR2SX.s3er_r2s_acx.setText("30")
                                }else{
                                    if (customDialogR2SX.outsideleft.isChecked && customDialogR2SX.insideright.isChecked && customDialogR2SX.insideleft.isChecked ) {
                                        ch3.text = "راسية اكس خارجية يسار و الداخليتين"
                                        customDialogR2SX.s3er_r2s_acx.setText("30")
                                    }else{
//                                else {
                                        if (customDialogR2SX.outsideleft.isChecked && customDialogR2SX.outsideright.isChecked) {
                                            ch3.text = "راسية اكس خارجية يمين و يسار"
                                            customDialogR2SX.s3er_r2s_acx.setText("20")
                                        }else{
                                            if (customDialogR2SX.outsideright.isChecked && customDialogR2SX.insideright.isChecked) {
                                                ch3.text = "راسية اكس خارجية يمين و داخلية يمين"
                                                customDialogR2SX.s3er_r2s_acx.setText("20")
                                            }else{
                                                if (customDialogR2SX.outsideright.isChecked && customDialogR2SX.insideleft.isChecked) {
                                                    ch3.text = "راسية اكس خارجية يمين و داخلية يسار"
                                                    customDialogR2SX.s3er_r2s_acx.setText("20")
                                                }else{
                                                    if (customDialogR2SX.outsideleft.isChecked && customDialogR2SX.insideright.isChecked) {
                                                        ch3.text = "راسية اكس خارجية يسار و داخلية يمين"
                                                        customDialogR2SX.s3er_r2s_acx.setText("20")
                                                    }else{
                                                        if (customDialogR2SX.outsideleft.isChecked && customDialogR2SX.insideleft.isChecked) {
                                                            ch3.text = "راسية اكس خارجية يسار و داخلية يسار"
                                                            customDialogR2SX.s3er_r2s_acx.setText("20")
                                                        }else{
                                                            if (customDialogR2SX.insideright.isChecked && customDialogR2SX.insideleft.isChecked) {
                                                                ch3.text = "راسية اكس داخلية يمين و يسار"
                                                                customDialogR2SX.s3er_r2s_acx.setText("20")
                                                            } else {

                                                                if (customDialogR2SX.outsideleft.isChecked) {
                                                                    ch3.text = "راسية اكس خارجية يسار"
                                                                    customDialogR2SX.s3er_r2s_acx.setText("10")
                                                                }

                                                                if (customDialogR2SX.outsideright.isChecked) {
                                                                    ch3.text = "راسية اكس خارجية يمين"
                                                                    customDialogR2SX.s3er_r2s_acx.setText("10")
                                                                }

                                                                if (customDialogR2SX.insideleft.isChecked) {
                                                                    ch3.text = "راسية اكس داخلية يسار"
                                                                    customDialogR2SX.s3er_r2s_acx.setText("10")
                                                                }
                                                                if (customDialogR2SX.insideright.isChecked) {
                                                                    ch3.text = "راسية اكس داخلية يمين"
                                                                    customDialogR2SX.s3er_r2s_acx.setText("10")
                                                                }
                                                            }
                                                        }
                                                    }}}}}}}}}
                    customDialogR2SX.show()
                }



                customDialogR2SX.insideleft.setOnCheckedChangeListener { _, isChecked2 ->
                    if (customDialogR2SX.insideleft.isChecked) {
                        ch3.text = "راسية اكس داخلية يسار"
                    }else{ch3.text = "راسية اكس"
                        customDialogR2SX.s3er_r2s_acx.setText("")}

                    if (customDialogR2SX.outsideright.isChecked && customDialogR2SX.outsideleft.isChecked && customDialogR2SX.insideright.isChecked && customDialogR2SX.insideleft.isChecked ) {
                        ch3.text = "تغير جميع الرأسيات الخارجية و الداخلية"
                        customDialogR2SX.s3er_r2s_acx.setText("40")
                    }else {
                        if (customDialogR2SX.outsideright.isChecked && customDialogR2SX.outsideleft.isChecked && customDialogR2SX.insideright.isChecked ) {
                            ch3.text = "راسيتين اكس خارجية و الداخلية يمين"
                            customDialogR2SX.s3er_r2s_acx.setText("30")
                        }else {
                            if (customDialogR2SX.insideleft.isChecked && customDialogR2SX.outsideleft.isChecked && customDialogR2SX.outsideright.isChecked) {
                                ch3.text = "راسيتين اكس خارجية و الداخلية يسار"
                                customDialogR2SX.s3er_r2s_acx.setText("30")
                            }else {
                                if (customDialogR2SX.insideleft.isChecked && customDialogR2SX.insideright.isChecked && customDialogR2SX.outsideright.isChecked) {
                                    ch3.text = "راسية اكس خارجية يمين و الداخليتين"
                                    customDialogR2SX.s3er_r2s_acx.setText("30")
                                }else {
                                    if (customDialogR2SX.insideleft.isChecked && customDialogR2SX.insideright.isChecked && customDialogR2SX.outsideleft.isChecked) {
                                        ch3.text = "راسية اكس خارجية يسار و الداخليتين"
                                        customDialogR2SX.s3er_r2s_acx.setText("30")
                                    }else {
                                        if (customDialogR2SX.outsideright.isChecked && customDialogR2SX.outsideleft.isChecked) {
                                            ch3.text = "راسية اكس خارجية يمين و يسار"
                                            customDialogR2SX.s3er_r2s_acx.setText("20")
                                        }else {
                                            if (customDialogR2SX.outsideright.isChecked && customDialogR2SX.insideright.isChecked) {
                                                ch3.text = "راسية اكس خارجية يمين و داخلية يمين"
                                                customDialogR2SX.s3er_r2s_acx.setText("20")
                                            }else {
                                                if (customDialogR2SX.insideleft.isChecked && customDialogR2SX.outsideright.isChecked) {
                                                    ch3.text = "راسية اكس خارجية يمين و داخلية يسار"
                                                    customDialogR2SX.s3er_r2s_acx.setText("20")
                                                }else {
                                                    if (customDialogR2SX.outsideleft.isChecked && customDialogR2SX.insideright.isChecked) {
                                                        ch3.text = "راسية اكس خارجية يسار و داخلية يمين"
                                                        customDialogR2SX.s3er_r2s_acx.setText("20")
                                                    }else {
                                                        if (customDialogR2SX.insideleft.isChecked && customDialogR2SX.outsideleft.isChecked) {
                                                            ch3.text = "راسية اكس خارجية يسار و داخلية يسار"
                                                            customDialogR2SX.s3er_r2s_acx.setText("20")
                                                        }else {
                                                            if (customDialogR2SX.insideleft.isChecked && customDialogR2SX.insideright.isChecked) {
                                                                ch3.text = "راسية اكس داخلية يمين و يسار"
                                                                customDialogR2SX.s3er_r2s_acx.setText("20")
                                                            } else {
                                                                if (customDialogR2SX.insideright.isChecked) {
                                                                    ch3.text = "راسية اكس داخلية يمين"
                                                                    customDialogR2SX.s3er_r2s_acx.setText("10")
                                                                }
                                                                if (customDialogR2SX.outsideright.isChecked) {
                                                                    ch3.text = "راسية اكس خارجية يمين"
                                                                    customDialogR2SX.s3er_r2s_acx.setText("10")
                                                                }
                                                                if (customDialogR2SX.outsideleft.isChecked) {
                                                                    ch3.text = "راسية اكس خارجية يسار"
                                                                    customDialogR2SX.s3er_r2s_acx.setText("10")
                                                                }

                                                                if (customDialogR2SX.insideleft.isChecked) {
                                                                    ch3.text = "راسية اكس داخلية يسار"
                                                                    customDialogR2SX.s3er_r2s_acx.setText("10")
                                                                }
                                                            }
                                                        }
                                                    }}}}}}}}}

                    customDialogR2SX.show()
                }

                customDialogR2SX.insideright.setOnCheckedChangeListener { _, isChecked2 ->
                    if (customDialogR2SX.insideright.isChecked) {
                        ch3.text = "راسية اكس داخلية يمين"
                    }else{ch3.text = "راسية اكس"
                        customDialogR2SX.s3er_r2s_acx.setText("")}

                    if (customDialogR2SX.outsideright.isChecked && customDialogR2SX.outsideleft.isChecked && customDialogR2SX.insideright.isChecked && customDialogR2SX.insideleft.isChecked ) {
                        ch3.text = "تغير جميع الرأسيات الخارجية و الداخلية"
                        customDialogR2SX.s3er_r2s_acx.setText("40")
                    }else{
                        if (customDialogR2SX.insideright.isChecked && customDialogR2SX.outsideleft.isChecked && customDialogR2SX.outsideright.isChecked ) {
                            ch3.text = "راسيتين اكس خارجية و الداخلية يمين"
                            customDialogR2SX.s3er_r2s_acx.setText("30")
                        }else {
                            if (customDialogR2SX.outsideright.isChecked && customDialogR2SX.outsideleft.isChecked && customDialogR2SX.insideleft.isChecked ) {
                                ch3.text = "راسيتين اكس خارجية و الداخلية يسار"
                                customDialogR2SX.s3er_r2s_acx.setText("30")
                            }else {
                                if (customDialogR2SX.insideright.isChecked && customDialogR2SX.outsideright.isChecked && customDialogR2SX.insideleft.isChecked ) {
                                    ch3.text = "راسية اكس خارجية يمين و الداخليتين"
                                    customDialogR2SX.s3er_r2s_acx.setText("30")
                                }else {
                                    if (customDialogR2SX.insideright.isChecked && customDialogR2SX.outsideleft.isChecked && customDialogR2SX.insideleft.isChecked ) {
                                        ch3.text = "راسية اكس خارجية يسار و الداخليتين"
                                        customDialogR2SX.s3er_r2s_acx.setText("30")
                                    }else {
                                        if (customDialogR2SX.outsideright.isChecked && customDialogR2SX.outsideleft.isChecked ) {
                                            ch3.text = "راسية اكس خارجية يمين و يسار"
                                            customDialogR2SX.s3er_r2s_acx.setText("20")
                                        }else {
                                            if (customDialogR2SX.insideright.isChecked && customDialogR2SX.outsideright.isChecked ) {
                                                ch3.text = "راسية اكس خارجية يمين و داخلية يمين"
                                                customDialogR2SX.s3er_r2s_acx.setText("20")
                                            }else {
                                                if (customDialogR2SX.outsideright.isChecked && customDialogR2SX.insideleft.isChecked ) {
                                                    ch3.text = "راسية اكس خارجية يمين و داخلية يسار"
                                                    customDialogR2SX.s3er_r2s_acx.setText("20")
                                                }else {
                                                    if (customDialogR2SX.insideright.isChecked && customDialogR2SX.outsideleft.isChecked) {
                                                        ch3.text = "راسية اكس خارجية يسار و داخلية يمين"
                                                        customDialogR2SX.s3er_r2s_acx.setText("20")
                                                    }else {
                                                        if (customDialogR2SX.outsideleft.isChecked && customDialogR2SX.insideleft.isChecked) {
                                                            ch3.text = "راسية اكس خارجية يسار و داخلية يسار"
                                                            customDialogR2SX.s3er_r2s_acx.setText("20")
                                                        }else {
                                                            if (customDialogR2SX.insideright.isChecked && customDialogR2SX.insideleft.isChecked) {
                                                                ch3.text = "راسية اكس داخلية يمين و يسار"
                                                                customDialogR2SX.s3er_r2s_acx.setText("20")
                                                            } else {
                                                                if (customDialogR2SX.insideright.isChecked) {
                                                                    ch3.text = "راسية اكس داخلية يمين"
                                                                    customDialogR2SX.s3er_r2s_acx.setText("10")
                                                                }
                                                                if (customDialogR2SX.insideleft.isChecked) {
                                                                    ch3.text = "راسية اكس داخلية يسار"
                                                                    customDialogR2SX.s3er_r2s_acx.setText("10")
                                                                }
                                                                if (customDialogR2SX.outsideleft.isChecked) {
                                                                    ch3.text = "راسية اكس خارجية يسار"
                                                                    customDialogR2SX.s3er_r2s_acx.setText("10")
                                                                }
                                                                if (customDialogR2SX.outsideright.isChecked) {
                                                                    ch3.text = "راسية اكس خارجية يمين"
                                                                    customDialogR2SX.s3er_r2s_acx.setText("10")
                                                                }
                                                            }
                                                        }
                                                    }}}}}}}}}
                    customDialogR2SX.show()
                }


                customDialogR2SX.btn_r2s_sav.setOnClickListener {
                    if (!customDialogR2SX.outsideright.isChecked && !customDialogR2SX.outsideleft.isChecked
                        && !customDialogR2SX.insideright.isChecked && !customDialogR2SX.insideleft.isChecked ) {
                        toast_notempty1.show()}else{
                        if (customDialogR2SX.s3er_r2s_acx.text.toString().trim().isEmpty()){
                            toast_notempty.show()
                        }else{
                            pricd3.text=customDialogR2SX.s3er_r2s_acx.text.toString()
                            viewModel.totalAmount += pricd3.text.toString().toInt()
                            toolbar?.title =  viewModel.totalAmount.toString()
                            customDialogR2SX.dismiss()
                        }
                    }
                }
                customDialogR2SX.btn_r2s_can.setOnClickListener {
                    if (pricd3.text.toString().isEmpty()) {
                        ch3.text = "راسية اكس"
                        ch3.isChecked = false
                    }
                    customDialogR2SX.dismiss()
                }

                customDialogR2SX.show()
                homeModel.checkname3 += ch3.text.toString().trim()
                homeModel.editname3 += pricd3.text.toString().trim()
            } else {
                if (pricd3.text.toString().isNotEmpty()) {
                    viewModel.totalAmount -= pricd3.text.toString().toInt()
                    toolbar?.title =  viewModel.totalAmount.toString()
                    ch3.text = "راسية اكس"
                    pricd3.text = ""
                    homeModel.checkname3 =  ""
                    homeModel.editname3 =  ""
                }else{ch3.text = "راسية اكس"}
            }
        }

        ch4.setOnCheckedChangeListener { _, isChecked ->

            if (ch4.isChecked) {

                customDialogBRK.d_b_front.setOnCheckedChangeListener { _, isChecked1 ->
                    if (customDialogBRK.d_b_front.isChecked) {
                        ch4.text ="بريك امامي"
                    } else {
                        ch4.text = "بريك"
                        customDialogBRK.s3er_yadwee_break.setText("")
                    }
                    if (customDialogBRK.d_b_front.isChecked && customDialogBRK.d_b_rear.isChecked) {
                        ch4.text = "بريك امامي و خلفي"
                        customDialogBRK.s3er_yadwee_break.setText("10")
                    } else {
                        if (customDialogBRK.d_b_front.isChecked) {
                            ch4.text = "بريك امامي"
                            customDialogBRK.s3er_yadwee_break.setText("5")
                        }
                        if (customDialogBRK.d_b_rear.isChecked) {
                            ch4.text = "بريك خلفي"
                            customDialogBRK.s3er_yadwee_break.setText("5")
                        }
                    }
                }

                customDialogBRK.d_b_rear.setOnCheckedChangeListener { _, isChecked2 ->
                    if (customDialogBRK.d_b_rear.isChecked) {
                        ch4.text ="بريك خلفي"
                    } else {
                        ch4.text = "بريك"
                        customDialogBRK.s3er_yadwee_break.setText("")
                    }
                    if (customDialogBRK.d_b_front.isChecked && customDialogBRK.d_b_rear.isChecked) {
                        ch4.text = "بريك امامي و خلفي"
                        customDialogBRK.s3er_yadwee_break.setText("10")
                    } else {
                        if (customDialogBRK.d_b_rear.isChecked) {
                            ch4.text = "بريك خلفي"
                            customDialogBRK.s3er_yadwee_break.setText("5")
                        }
                        if (customDialogBRK.d_b_front.isChecked) {
                            ch4.text = "بريك امامي"
                            customDialogBRK.s3er_yadwee_break.setText("5")
                        }
                    }
                }

                customDialogBRK.btn_sv_dig_break.setOnClickListener {
                    if (!customDialogBRK.d_b_front.isChecked && !customDialogBRK.d_b_rear.isChecked) {
                        toast_notempty1.show()}else{
                        if (customDialogBRK.s3er_yadwee_break.text.toString().trim().isEmpty()){
                            toast_notempty.show()
                            ch4.isChecked = false
                        }else{
                            pricd4.text=customDialogBRK.s3er_yadwee_break.text.toString()
                            viewModel.totalAmount += pricd4.text.toString().toInt()
                            toolbar?.title =  viewModel.totalAmount.toString()
                            customDialogBRK.dismiss()
                        }
                    }
                }

                customDialogBRK.btn_cn_dig_break.setOnClickListener {
                    if (pricd4.text.toString().isEmpty()) {
                        ch4.text = " بريك"
                        ch4.isChecked = false
                    }
                    customDialogBRK.dismiss()
                }
                customDialogBRK.show()
                homeModel.checkname4 += ch4.text.toString().trim()
                homeModel.editname4 += pricd4.text.toString().trim()
            } else {
                if (pricd4.text.toString().isNotEmpty()) {
                    viewModel.totalAmount -= pricd4.text.toString().toInt()
                    toolbar?.title =  viewModel.totalAmount.toString()
                    ch4.text = "بريك"
                    pricd4.text = ""
                    homeModel.checkname4 =  ""
                    homeModel.editname4 =  ""
                }else{ch4.text = "بريك"}
            }
        }

        ch5.setOnCheckedChangeListener { _, isChecked ->
            if (ch5.isChecked) {

                customDialogR2SX.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

                customDialogR2SX.card_r2s_2ks.setOnTouchListener { _, event ->
                    var x = 0f
                    var y = 0f
                    when (event.action) {
                        MotionEvent.ACTION_UP -> {
                            x = event.x
                            y = event.y
                        }
                        MotionEvent.ACTION_MOVE -> {
                            customDialogR2SX.window?.let {
                                val params: WindowManager.LayoutParams = it.attributes
                                params.x = event.rawX.toInt() - x.toInt()
                                params.y = event.rawY.toInt() - y.toInt()
                                it.attributes = params
                            }
                        }

                        MotionEvent.ACTION_UP -> {
                            customDialogR2SX.window?.let {
                                val params: WindowManager.LayoutParams = it.attributes
                                if (params.y < 0) {
                                    params.y = 0
                                    it.attributes = params
                                } else if (params.y > 2000) { // change this value to move up more
                                    params.y = 2000 // change this value to move up more
                                    it.attributes = params
                                }
                            }
                        }

                    }
                    true
                }

                customDialogR2SX.outsideright.setOnCheckedChangeListener { _, isChecked1 ->

                    if (customDialogR2SX.outsideright.isChecked) {
                        ch5.text = "كوشوكة اكس خارجية يمين"
                    } else {
                        ch5.text = "كوشوكة اكس خارجية"
                        customDialogR2SX.s3er_r2s_acx.setText("")
                    }

                    if (customDialogR2SX.outsideright.isChecked && customDialogR2SX.outsideleft.isChecked && customDialogR2SX.insideright.isChecked && customDialogR2SX.insideleft.isChecked) {
                        ch5.text = "تغير جميع كوشوكات الأكس الخارجية و الداخلية"
                        customDialogR2SX.s3er_r2s_acx.setText("20")
                    } else {
                        if (customDialogR2SX.outsideright.isChecked && customDialogR2SX.outsideleft.isChecked && customDialogR2SX.insideright.isChecked) {
                            ch5.text = "كوشوكتين اكس خارجية و الداخلية يمين"
                            customDialogR2SX.s3er_r2s_acx.setText("15")
                        } else {
                            if (customDialogR2SX.outsideright.isChecked && customDialogR2SX.outsideleft.isChecked && customDialogR2SX.insideleft.isChecked) {
                                ch5.text = "كوشوكتين اكس خارجية و الداخلية يسار"
                                customDialogR2SX.s3er_r2s_acx.setText("15")
                            } else {
                                if (customDialogR2SX.outsideright.isChecked && customDialogR2SX.insideright.isChecked && customDialogR2SX.insideleft.isChecked) {
                                    ch5.text = "كوشوكة اكس خارجية يمين و الداخليتين"
                                    customDialogR2SX.s3er_r2s_acx.setText("15")
                                } else {
                                    if (customDialogR2SX.outsideleft.isChecked && customDialogR2SX.insideright.isChecked && customDialogR2SX.insideleft.isChecked) {
                                        ch5.text = "كوشوكة اكس خارجية يسار و الداخليتين"
                                        customDialogR2SX.s3er_r2s_acx.setText("15")
                                    } else {
                                        if (customDialogR2SX.outsideright.isChecked && customDialogR2SX.outsideleft.isChecked) {
                                            ch5.text = "كوشوكة اكس خارجية يمين و يسار"
                                            customDialogR2SX.s3er_r2s_acx.setText("10")
                                        } else {
                                            if (customDialogR2SX.outsideright.isChecked && customDialogR2SX.insideright.isChecked) {
                                                ch5.text = "كوشوكة اكس خارجية يمين و داخلية يمين"
                                                customDialogR2SX.s3er_r2s_acx.setText("10")
                                            } else {
                                                if (customDialogR2SX.outsideright.isChecked && customDialogR2SX.insideleft.isChecked) {
                                                    ch5.text = "كوشوكة اكس خارجية يمين و داخلية يسار"
                                                    customDialogR2SX.s3er_r2s_acx.setText("10")
                                                } else {
                                                    if (customDialogR2SX.outsideleft.isChecked && customDialogR2SX.insideright.isChecked) {
                                                        ch5.text =
                                                            "كوشوكة اكس خارجية يسار و داخلية يمين"
                                                        customDialogR2SX.s3er_r2s_acx.setText("10")
                                                    } else {
                                                        if (customDialogR2SX.outsideleft.isChecked && customDialogR2SX.insideleft.isChecked) {
                                                            ch5.text =
                                                                "كوشوكة اكس خارجية يسار و داخلية يسار"
                                                            customDialogR2SX.s3er_r2s_acx.setText("10")
                                                        } else {
                                                            if (customDialogR2SX.insideright.isChecked && customDialogR2SX.insideleft.isChecked) {
                                                                ch5.text =
                                                                    "كوشوكة اكس داخلية يمين و يسار"
                                                                customDialogR2SX.s3er_r2s_acx.setText(
                                                                    "5"
                                                                )
                                                            } else {

                                                                if (customDialogR2SX.outsideright.isChecked) {
                                                                    ch5.text =
                                                                        "كوشوكة اكس خارجية يمين"
                                                                    customDialogR2SX.s3er_r2s_acx.setText(
                                                                        "5"
                                                                    )
                                                                }
                                                                if (customDialogR2SX.outsideleft.isChecked) {
                                                                    ch5.text =
                                                                        "كوشوكة اكس خارجية يسار"
                                                                    customDialogR2SX.s3er_r2s_acx.setText(
                                                                        "5"
                                                                    )
                                                                }

                                                                if (customDialogR2SX.insideleft.isChecked) {
                                                                    ch5.text =
                                                                        "كوشوكة اكس داخلية يسار"
                                                                    customDialogR2SX.s3er_r2s_acx.setText(
                                                                        "5"
                                                                    )
                                                                }
                                                                if (customDialogR2SX.insideright.isChecked) {
                                                                    ch5.text =
                                                                        "كوشوكة اكس داخلية يمين"
                                                                    customDialogR2SX.s3er_r2s_acx.setText(
                                                                        "5"
                                                                    )
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                    customDialogR2SX.show()
                }



                customDialogR2SX.outsideleft.setOnCheckedChangeListener { _, isChecked2 ->
                    if (customDialogR2SX.outsideleft.isChecked) {
                        ch5.text = "راسية اكس خارجية يسار"
                    } else {
                        ch5.text = "راسية اكس"
                        customDialogR2SX.s3er_r2s_acx.setText("")
                    }

                    if (customDialogR2SX.outsideright.isChecked && customDialogR2SX.outsideleft.isChecked && customDialogR2SX.insideright.isChecked && customDialogR2SX.insideleft.isChecked) {
                        ch5.text = "تغير جميع كوشوكات الأكس الخارجية و الداخلية"
                        customDialogR2SX.s3er_r2s_acx.setText("20")
                    } else {
                        if (customDialogR2SX.outsideright.isChecked && customDialogR2SX.outsideleft.isChecked && customDialogR2SX.insideright.isChecked) {
                            ch5.text = "كوشوكتين اكس خارجية و الداخلية يمين"
                            customDialogR2SX.s3er_r2s_acx.setText("15")
                        } else {
                            if (customDialogR2SX.outsideright.isChecked && customDialogR2SX.outsideleft.isChecked && customDialogR2SX.insideleft.isChecked) {
                                ch5.text = "كوشوكتين اكس خارجية و الداخلية يسار"
                                customDialogR2SX.s3er_r2s_acx.setText("15")
                            } else {
                                if (customDialogR2SX.outsideright.isChecked && customDialogR2SX.insideright.isChecked && customDialogR2SX.insideleft.isChecked) {
                                    ch5.text = "كوشوكة اكس خارجية يمين و الداخليتين"
                                    customDialogR2SX.s3er_r2s_acx.setText("15")
                                } else {
                                    if (customDialogR2SX.outsideleft.isChecked && customDialogR2SX.insideright.isChecked && customDialogR2SX.insideleft.isChecked) {
                                        ch5.text = "كوشوكة اكس خارجية يسار و الداخليتين"
                                        customDialogR2SX.s3er_r2s_acx.setText("15")
                                    } else {
                                        if (customDialogR2SX.outsideright.isChecked && customDialogR2SX.outsideleft.isChecked) {
                                            ch5.text = "كوشوكة اكس خارجية يمين و يسار"
                                            customDialogR2SX.s3er_r2s_acx.setText("10")
                                        } else {
                                            if (customDialogR2SX.outsideright.isChecked && customDialogR2SX.insideright.isChecked) {
                                                ch5.text = "كوشوكة اكس خارجية يمين و داخلية يمين"
                                                customDialogR2SX.s3er_r2s_acx.setText("10")
                                            } else {
                                                if (customDialogR2SX.outsideright.isChecked && customDialogR2SX.insideleft.isChecked) {
                                                    ch5.text = "كوشوكة اكس خارجية يمين و داخلية يسار"
                                                    customDialogR2SX.s3er_r2s_acx.setText("10")
                                                } else {
                                                    if (customDialogR2SX.outsideleft.isChecked && customDialogR2SX.insideright.isChecked) {
                                                        ch5.text =
                                                            "كوشوكة اكس خارجية يسار و داخلية يمين"
                                                        customDialogR2SX.s3er_r2s_acx.setText("10")
                                                    } else {
                                                        if (customDialogR2SX.outsideleft.isChecked && customDialogR2SX.insideleft.isChecked) {
                                                            ch5.text =
                                                                "كوشوكة اكس خارجية يسار و داخلية يسار"
                                                            customDialogR2SX.s3er_r2s_acx.setText("10")
                                                        } else {
                                                            if (customDialogR2SX.insideright.isChecked && customDialogR2SX.insideleft.isChecked) {
                                                                ch5.text =
                                                                    "كوشوكة اكس داخلية يمين و يسار"
                                                                customDialogR2SX.s3er_r2s_acx.setText(
                                                                    "5"
                                                                )
                                                            } else {

                                                                if (customDialogR2SX.outsideright.isChecked) {
                                                                    ch5.text =
                                                                        "كوشوكة اكس خارجية يمين"
                                                                    customDialogR2SX.s3er_r2s_acx.setText(
                                                                        "5"
                                                                    )
                                                                }
                                                                if (customDialogR2SX.outsideleft.isChecked) {
                                                                    ch5.text =
                                                                        "كوشوكة اكس خارجية يسار"
                                                                    customDialogR2SX.s3er_r2s_acx.setText(
                                                                        "5"
                                                                    )
                                                                }

                                                                if (customDialogR2SX.insideleft.isChecked) {
                                                                    ch5.text =
                                                                        "كوشوكة اكس داخلية يسار"
                                                                    customDialogR2SX.s3er_r2s_acx.setText(
                                                                        "5"
                                                                    )
                                                                }
                                                                if (customDialogR2SX.insideright.isChecked) {
                                                                    ch5.text =
                                                                        "كوشوكة اكس داخلية يمين"
                                                                    customDialogR2SX.s3er_r2s_acx.setText(
                                                                        "5"
                                                                    )
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                    customDialogR2SX.show()
                }



                customDialogR2SX.insideleft.setOnCheckedChangeListener { _, isChecked2 ->
                    if (customDialogR2SX.outsideright.isChecked) {
                        ch5.text = "كوشوكة اكس خارجية يمين"
                    } else {
                        ch5.text = "كوشوكة اكس خارجية"
                        customDialogR2SX.s3er_r2s_acx.setText("")
                    }

                    if (customDialogR2SX.outsideright.isChecked && customDialogR2SX.outsideleft.isChecked && customDialogR2SX.insideright.isChecked && customDialogR2SX.insideleft.isChecked) {
                        ch5.text = "تغير جميع كوشوكات الأكس الخارجية و الداخلية"
                        customDialogR2SX.s3er_r2s_acx.setText("20")
                    } else {
                        if (customDialogR2SX.outsideright.isChecked && customDialogR2SX.outsideleft.isChecked && customDialogR2SX.insideright.isChecked) {
                            ch5.text = "كوشوكتين اكس خارجية و الداخلية يمين"
                            customDialogR2SX.s3er_r2s_acx.setText("15")
                        } else {
                            if (customDialogR2SX.outsideright.isChecked && customDialogR2SX.outsideleft.isChecked && customDialogR2SX.insideleft.isChecked) {
                                ch5.text = "كوشوكتين اكس خارجية و الداخلية يسار"
                                customDialogR2SX.s3er_r2s_acx.setText("15")
                            } else {
                                if (customDialogR2SX.outsideright.isChecked && customDialogR2SX.insideright.isChecked && customDialogR2SX.insideleft.isChecked) {
                                    ch5.text = "كوشوكة اكس خارجية يمين و الداخليتين"
                                    customDialogR2SX.s3er_r2s_acx.setText("15")
                                } else {
                                    if (customDialogR2SX.outsideleft.isChecked && customDialogR2SX.insideright.isChecked && customDialogR2SX.insideleft.isChecked) {
                                        ch5.text = "كوشوكة اكس خارجية يسار و الداخليتين"
                                        customDialogR2SX.s3er_r2s_acx.setText("15")
                                    } else {
                                        if (customDialogR2SX.outsideright.isChecked && customDialogR2SX.outsideleft.isChecked) {
                                            ch5.text = "كوشوكة اكس خارجية يمين و يسار"
                                            customDialogR2SX.s3er_r2s_acx.setText("10")
                                        } else {
                                            if (customDialogR2SX.outsideright.isChecked && customDialogR2SX.insideright.isChecked) {
                                                ch5.text = "كوشوكة اكس خارجية يمين و داخلية يمين"
                                                customDialogR2SX.s3er_r2s_acx.setText("10")
                                            } else {
                                                if (customDialogR2SX.outsideright.isChecked && customDialogR2SX.insideleft.isChecked) {
                                                    ch5.text = "كوشوكة اكس خارجية يمين و داخلية يسار"
                                                    customDialogR2SX.s3er_r2s_acx.setText("10")
                                                } else {
                                                    if (customDialogR2SX.outsideleft.isChecked && customDialogR2SX.insideright.isChecked) {
                                                        ch5.text =
                                                            "كوشوكة اكس خارجية يسار و داخلية يمين"
                                                        customDialogR2SX.s3er_r2s_acx.setText("10")
                                                    } else {
                                                        if (customDialogR2SX.outsideleft.isChecked && customDialogR2SX.insideleft.isChecked) {
                                                            ch5.text =
                                                                "كوشوكة اكس خارجية يسار و داخلية يسار"
                                                            customDialogR2SX.s3er_r2s_acx.setText("10")
                                                        } else {
                                                            if (customDialogR2SX.insideright.isChecked && customDialogR2SX.insideleft.isChecked) {
                                                                ch5.text =
                                                                    "كوشوكة اكس داخلية يمين و يسار"
                                                                customDialogR2SX.s3er_r2s_acx.setText(
                                                                    "5"
                                                                )
                                                            } else {

                                                                if (customDialogR2SX.outsideright.isChecked) {
                                                                    ch5.text =
                                                                        "كوشوكة اكس خارجية يمين"
                                                                    customDialogR2SX.s3er_r2s_acx.setText(
                                                                        "5"
                                                                    )
                                                                }
                                                                if (customDialogR2SX.outsideleft.isChecked) {
                                                                    ch5.text =
                                                                        "كوشوكة اكس خارجية يسار"
                                                                    customDialogR2SX.s3er_r2s_acx.setText(
                                                                        "5"
                                                                    )
                                                                }

                                                                if (customDialogR2SX.insideleft.isChecked) {
                                                                    ch5.text =
                                                                        "كوشوكة اكس داخلية يسار"
                                                                    customDialogR2SX.s3er_r2s_acx.setText(
                                                                        "5"
                                                                    )
                                                                }
                                                                if (customDialogR2SX.insideright.isChecked) {
                                                                    ch5.text =
                                                                        "كوشوكة اكس داخلية يمين"
                                                                    customDialogR2SX.s3er_r2s_acx.setText(
                                                                        "5"
                                                                    )
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }

                    customDialogR2SX.show()
                }

                customDialogR2SX.insideright.setOnCheckedChangeListener { _, isChecked2 ->
                    if (customDialogR2SX.outsideright.isChecked) {
                        ch5.text = "كوشوكة اكس خارجية يمين"
                    } else {
                        ch5.text = "كوشوكة اكس خارجية"
                        customDialogR2SX.s3er_r2s_acx.setText("")
                    }

                    if (customDialogR2SX.outsideright.isChecked && customDialogR2SX.outsideleft.isChecked && customDialogR2SX.insideright.isChecked && customDialogR2SX.insideleft.isChecked) {
                        ch5.text = "تغير جميع كوشوكات الأكس الخارجية و الداخلية"
                        customDialogR2SX.s3er_r2s_acx.setText("20")
                    } else {
                        if (customDialogR2SX.outsideright.isChecked && customDialogR2SX.outsideleft.isChecked && customDialogR2SX.insideright.isChecked) {
                            ch5.text = "كوشوكتين اكس خارجية و الداخلية يمين"
                            customDialogR2SX.s3er_r2s_acx.setText("15")
                        } else {
                            if (customDialogR2SX.outsideright.isChecked && customDialogR2SX.outsideleft.isChecked && customDialogR2SX.insideleft.isChecked) {
                                ch5.text = "كوشوكتين اكس خارجية و الداخلية يسار"
                                customDialogR2SX.s3er_r2s_acx.setText("15")
                            } else {
                                if (customDialogR2SX.outsideright.isChecked && customDialogR2SX.insideright.isChecked && customDialogR2SX.insideleft.isChecked) {
                                    ch5.text = "كوشوكة اكس خارجية يمين و الداخليتين"
                                    customDialogR2SX.s3er_r2s_acx.setText("15")
                                } else {
                                    if (customDialogR2SX.outsideleft.isChecked && customDialogR2SX.insideright.isChecked && customDialogR2SX.insideleft.isChecked) {
                                        ch5.text = "كوشوكة اكس خارجية يسار و الداخليتين"
                                        customDialogR2SX.s3er_r2s_acx.setText("15")
                                    } else {
                                        if (customDialogR2SX.outsideright.isChecked && customDialogR2SX.outsideleft.isChecked) {
                                            ch5.text = "كوشوكة اكس خارجية يمين و يسار"
                                            customDialogR2SX.s3er_r2s_acx.setText("10")
                                        } else {
                                            if (customDialogR2SX.outsideright.isChecked && customDialogR2SX.insideright.isChecked) {
                                                ch5.text = "كوشوكة اكس خارجية يمين و داخلية يمين"
                                                customDialogR2SX.s3er_r2s_acx.setText("10")
                                            } else {
                                                if (customDialogR2SX.outsideright.isChecked && customDialogR2SX.insideleft.isChecked) {
                                                    ch5.text = "كوشوكة اكس خارجية يمين و داخلية يسار"
                                                    customDialogR2SX.s3er_r2s_acx.setText("10")
                                                } else {
                                                    if (customDialogR2SX.outsideleft.isChecked && customDialogR2SX.insideright.isChecked) {
                                                        ch5.text =
                                                            "كوشوكة اكس خارجية يسار و داخلية يمين"
                                                        customDialogR2SX.s3er_r2s_acx.setText("10")
                                                    } else {
                                                        if (customDialogR2SX.outsideleft.isChecked && customDialogR2SX.insideleft.isChecked) {
                                                            ch5.text =
                                                                "كوشوكة اكس خارجية يسار و داخلية يسار"
                                                            customDialogR2SX.s3er_r2s_acx.setText("10")
                                                        } else {
                                                            if (customDialogR2SX.insideright.isChecked && customDialogR2SX.insideleft.isChecked) {
                                                                ch5.text =
                                                                    "كوشوكة اكس داخلية يمين و يسار"
                                                                customDialogR2SX.s3er_r2s_acx.setText(
                                                                    "5"
                                                                )
                                                            } else {

                                                                if (customDialogR2SX.outsideright.isChecked) {
                                                                    ch5.text =
                                                                        "كوشوكة اكس خارجية يمين"
                                                                    customDialogR2SX.s3er_r2s_acx.setText(
                                                                        "5"
                                                                    )
                                                                }
                                                                if (customDialogR2SX.outsideleft.isChecked) {
                                                                    ch5.text =
                                                                        "كوشوكة اكس خارجية يسار"
                                                                    customDialogR2SX.s3er_r2s_acx.setText(
                                                                        "5"
                                                                    )
                                                                }

                                                                if (customDialogR2SX.insideleft.isChecked) {
                                                                    ch5.text =
                                                                        "كوشوكة اكس داخلية يسار"
                                                                    customDialogR2SX.s3er_r2s_acx.setText(
                                                                        "5"
                                                                    )
                                                                }
                                                                if (customDialogR2SX.insideright.isChecked) {
                                                                    ch5.text =
                                                                        "كوشوكة اكس داخلية يمين"
                                                                    customDialogR2SX.s3er_r2s_acx.setText(
                                                                        "5"
                                                                    )
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                    customDialogR2SX.show()
                }


                customDialogR2SX.btn_r2s_sav.setOnClickListener {
                    if (!customDialogR2SX.outsideright.isChecked && !customDialogR2SX.outsideleft.isChecked
                        && !customDialogR2SX.insideright.isChecked && !customDialogR2SX.insideleft.isChecked
                    ) {
                        toast_notempty1.show()
                    } else {
                        if (customDialogR2SX.s3er_r2s_acx.text.toString().trim().isEmpty()) {
                            toast_notempty.show()
                        } else {
                            pricd5.text = customDialogR2SX.s3er_r2s_acx.text.toString()
                            viewModel.totalAmount += pricd5.text.toString().toInt()
                            toolbar?.title =  viewModel.totalAmount.toString()
                            customDialogR2SX.dismiss()
                        }
                    }
                }
                customDialogR2SX.btn_r2s_can.setOnClickListener {
                    if (pricd5.text.toString().isEmpty()) {
                        ch5.text = "كوشوكة اكس"
                        ch5.isChecked = false
                    }
                    customDialogR2SX.dismiss()
                }

                customDialogR2SX.show()
                homeModel.checkname5 += ch5.text.toString().trim()
                homeModel.editname5 += pricd5.text.toString().trim()
            } else {
                if (pricd5.text.toString().isNotEmpty()) {
                    viewModel.totalAmount -= pricd5.text.toString().toInt()
                    toolbar?.title =  viewModel.totalAmount.toString()
                    ch5.text = "كوشوكة اكس"
                    pricd5.setText("")
                    homeModel.checkname5 =  ""
                    homeModel.editname5 =  ""
                } else {
                    ch5.text = "كوشوكة اكس"
                }
            }
        }

        ch6.setOnCheckedChangeListener { _, isChecked ->
            if (ch6.isChecked) {

                customDialogFR.frontright.setOnCheckedChangeListener { _, isChecked1 ->
                    if (customDialogFR.frontright.isChecked) {
                        ch6.text = "اكس امامي يمين"
                    } else {
                        ch6.text = "اكس امامي"
                        customDialogFR.s3er_yadwee.setText("")
                    }
                    if (customDialogFR.frontright.isChecked && customDialogFR.frontleft.isChecked) {
                        ch6.text = "اكس امامي يمين و يسار"
                        customDialogFR.s3er_yadwee.setText("10")
                    } else {
                        if (customDialogFR.frontright.isChecked) {
                            ch6.text = "اكس امامي يمين"
                            customDialogFR.s3er_yadwee.setText("5")
                        }
                        if (customDialogFR.frontleft.isChecked) {
                            ch6.text = "اكس امامي يسار"
                            customDialogFR.s3er_yadwee.setText("5")
                        }
                    }
                }

                customDialogFR.frontleft.setOnCheckedChangeListener { _, isChecked2 ->
                    if (customDialogFR.frontleft.isChecked) {
                        ch6.text = "اكس امامي يسار"
                    } else {
                        ch6.text = "اكس امامي"
                        customDialogFR.s3er_yadwee.setText("")
                    }
                    if (customDialogFR.frontright.isChecked && customDialogFR.frontleft.isChecked) {
                        ch6.text = "اكس امامي يمين و يسار"
                        customDialogFR.s3er_yadwee.setText("10")
                    } else {
                        if (customDialogFR.frontleft.isChecked) {
                            ch6.text = "اكس امامي يسار"
                            customDialogFR.s3er_yadwee.setText("5")
                        }
                        if (customDialogFR.frontright.isChecked) {
                            ch6.text = "اكس امامي يمين"
                            customDialogFR.s3er_yadwee.setText("5")
                        }
                    }
                }

                customDialogFR.button_dailog_save.setOnClickListener {
                    if (!customDialogFR.frontright.isChecked && !customDialogFR.frontleft.isChecked) {
                        toast_notempty1.show()
                    } else {
                        if (customDialogFR.s3er_yadwee.text.toString().trim().isEmpty()) {
                            toast_notempty.show()
                            ch6.isChecked = false
                        } else {
                            pricd6.text = customDialogFR.s3er_yadwee.text.toString()
                            viewModel.totalAmount += pricd6.text.toString().toInt()
                            toolbar?.title =  viewModel.totalAmount.toString()
                            customDialogFR.dismiss()
                        }
                    }
                }
                customDialogFR.button_dailog_cancel.setOnClickListener {
                    ch6.isChecked = false
                    customDialogFR.s3er_yadwee.setText("")
                    customDialogFR.dismiss()
                }
                customDialogFR.show()
                homeModel.checkname6 += ch6.text.toString().trim()
                homeModel.editname6 += pricd6.text.toString().trim()
            }
            else {
                if (pricd6.text.toString().isNotEmpty()){
                    viewModel.totalAmount -= pricd6.text.toString().toInt()
                    toolbar?.title =  viewModel.totalAmount.toString()
                    pricd6.text = ""
                    homeModel.checkname6 =  ""
                    homeModel.editname6 =  ""
                }
                ch6.text = "اكس امامي"
            }
        }

        ch7.setOnCheckedChangeListener { _, isChecked ->
            if (ch7.isChecked) {

                customDialogFR.lin_f.setOnTouchListener { _, event ->
                    var x = 0f
                    var y = 0f
                    when (event.action) {
                        MotionEvent.ACTION_UP -> {
                            x = event.x
                            y = event.y
                        }
                        MotionEvent.ACTION_MOVE -> {
                            customDialogFR.window?.let {
                                val params: WindowManager.LayoutParams = it.attributes
                                params.x = event.rawX.toInt() - x.toInt()
                                params.y = event.rawY.toInt() - y.toInt()
                                it.attributes = params
                            }
                        }

                        MotionEvent.ACTION_UP -> {
                            customDialogFR.window?.let {
                                val params: WindowManager.LayoutParams = it.attributes
                                if (params.y < 0) {
                                    params.y = 0
                                    it.attributes = params
                                } else if (params.y > 2000) { // change this value to move up more
                                    params.y = 2000 // change this value to move up more
                                    it.attributes = params
                                }
                            }
                        }

                    }
                    true
                }

                customDialogFR.frontright.setOnCheckedChangeListener { _, isChecked1 ->
                    if (customDialogFR.frontright.isChecked) {
                        ch7.text = "كوشوكة منفاخ يمين"
                    } else {
                        ch7.text = "كوشوكة منفاخ"
                        customDialogFR.s3er_yadwee.setText("")
                    }
                    if (customDialogFR.frontright.isChecked && customDialogFR.frontleft.isChecked) {
                        ch7.text = "كوشوكة منفاخ يمين و يسار"
                        customDialogFR.s3er_yadwee.setText("6")
                    } else {
                        if (customDialogFR.frontright.isChecked) {
                            ch7.text = "كوشوكة منفاخ يمين"
                            customDialogFR.s3er_yadwee.setText("3")
                        }
                        if (customDialogFR.frontleft.isChecked) {
                            ch7.text = "كوشوكة منفاخ يسار"
                            customDialogFR.s3er_yadwee.setText("3")
                        }
                    }
                }

                customDialogFR.frontleft.setOnCheckedChangeListener { _, isChecked2 ->
                    if (customDialogFR.frontleft.isChecked) {
                        ch7.text = "كوشوكة منفاخ يسار"
                    } else {
                        ch7.text = "كوشوكة منفاخ"
                        customDialogFR.s3er_yadwee.setText("")
                    }
                    if (customDialogFR.frontright.isChecked && customDialogFR.frontleft.isChecked) {
                        ch7.text = "كوشوكة منفاخ يمين و يسار"
                        customDialogFR.s3er_yadwee.setText("6")
                    } else {
                        if (customDialogFR.frontleft.isChecked) {
                            ch7.text = "كوشوكة منفاخ يسار"
                            customDialogFR.s3er_yadwee.setText("3")
                        }
                        if (customDialogFR.frontright.isChecked) {
                            ch7.text = "كوشوكة منفاخ يمين"
                            customDialogFR.s3er_yadwee.setText("3")
                        }
                    }
                }

                customDialogFR.button_dailog_save.setOnClickListener {
                    if (!customDialogFR.frontright.isChecked && !customDialogFR.frontleft.isChecked) {
                        toast_notempty1.show()
                    } else {
                        if (customDialogFR.s3er_yadwee.text.toString().trim().isEmpty()) {
                            toast_notempty.show()
                            ch7.isChecked = false
                        } else {
                            pricd7.text = customDialogFR.s3er_yadwee.text.toString()
                            viewModel.totalAmount += pricd7.text.toString().toInt()
                            toolbar?.title =  viewModel.totalAmount.toString()
                            customDialogFR.dismiss()
                        }
                    }
                }
                customDialogFR.button_dailog_cancel.setOnClickListener {
                    ch7.isChecked = false
                    customDialogFR.s3er_yadwee.setText("")
                    customDialogFR.dismiss()
                }
                customDialogFR.show()
                homeModel.checkname7 += ch7.text.toString().trim()
                homeModel.editname7 += pricd7.text.toString().trim()
            }
            else {
                if (pricd7.text.toString().isNotEmpty()){
                    viewModel.totalAmount -= pricd7.text.toString().toInt()
                    toolbar?.title =  viewModel.totalAmount.toString()
                    pricd7.text = ""
                    homeModel.checkname7 =  ""
                    homeModel.editname7 =  ""
                }
                ch7.text = "كوشوكة منفاخ"
            }
        }

        ch8.setOnCheckedChangeListener { _, isChecked ->
            if (ch8.isChecked) {

                customDialogR2SX.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

                customDialogR2SX.tit_r2s_out.text="امامي"
                customDialogR2SX.tit_r2s_in.text="خلفي"

                customDialogR2SX.card_r2s_2ks.setOnTouchListener { _, event ->
                    var x = 0f
                    var y = 0f
                    when (event.action) {
                        MotionEvent.ACTION_UP -> {
                            x = event.x
                            y = event.y
                        }
                        MotionEvent.ACTION_MOVE -> {
                            customDialogR2SX.window?.let {
                                val params: WindowManager.LayoutParams = it.attributes
                                params.x = event.rawX.toInt() - x.toInt()
                                params.y = event.rawY.toInt() - y.toInt()
                                it.attributes = params
                            }
                        }

                        MotionEvent.ACTION_UP -> {
                            customDialogR2SX.window?.let {
                                val params: WindowManager.LayoutParams = it.attributes
                                if (params.y < 0) {
                                    params.y = 0
                                    it.attributes = params
                                } else if (params.y > 2000) { // change this value to move up more
                                    params.y = 2000 // change this value to move up more
                                    it.attributes = params
                                }
                            }
                        }

                    }
                    true
                }

                customDialogR2SX.outsideright.setOnCheckedChangeListener { _, isChecked1 ->

                    if (customDialogR2SX.outsideright.isChecked) {
                        ch8.text = "كوشوكة عمود شيال امامي يمين"
                    } else {
                        ch8.text = "كوشوكة عمود شيال"
                        customDialogR2SX.s3er_r2s_acx.setText("")
                    }

                    if (customDialogR2SX.outsideright.isChecked && customDialogR2SX.outsideleft.isChecked && customDialogR2SX.insideright.isChecked && customDialogR2SX.insideleft.isChecked) {
                        ch8.text = "تغير جميع كوشوكات عمود الشيال"
                        customDialogR2SX.s3er_r2s_acx.setText("30")
                    } else {
                        if (customDialogR2SX.outsideright.isChecked && customDialogR2SX.outsideleft.isChecked && customDialogR2SX.insideright.isChecked) {
                            ch8.text = "كوشوكتين عمود شيال امامي و الخلفي يمين"
                            customDialogR2SX.s3er_r2s_acx.setText("25")
                        } else {
                            if (customDialogR2SX.outsideright.isChecked && customDialogR2SX.outsideleft.isChecked && customDialogR2SX.insideleft.isChecked) {
                                ch8.text = "كوشوكتين عمود شيال امامي  و الخلفي يسار"
                                customDialogR2SX.s3er_r2s_acx.setText("25")
                            } else {
                                if (customDialogR2SX.outsideright.isChecked && customDialogR2SX.insideright.isChecked && customDialogR2SX.insideleft.isChecked) {
                                    ch8.text = "كوشوكة عمود شيال امامي يمين و الخلفيتين"
                                    customDialogR2SX.s3er_r2s_acx.setText("20")
                                } else {
                                    if (customDialogR2SX.outsideleft.isChecked && customDialogR2SX.insideright.isChecked && customDialogR2SX.insideleft.isChecked) {
                                        ch8.text = "كوشوكة عمود شيال امامي يسار و الخلفيتين"
                                        customDialogR2SX.s3er_r2s_acx.setText("20")
                                    } else {
                                        if (customDialogR2SX.outsideright.isChecked && customDialogR2SX.outsideleft.isChecked) {
                                            ch8.text = "كوشوكة عمود شيال امامي يمين و يسار"
                                            customDialogR2SX.s3er_r2s_acx.setText("20")
                                        } else {
                                            if (customDialogR2SX.outsideright.isChecked && customDialogR2SX.insideright.isChecked) {
                                                ch8.text = "كوشوكة عمود شيال امامي يمين و خلفي يمين"
                                                customDialogR2SX.s3er_r2s_acx.setText("15")
                                            } else {
                                                if (customDialogR2SX.outsideright.isChecked && customDialogR2SX.insideleft.isChecked) {
                                                    ch8.text = "كوشوكة عمود شيال امامي يمين و خلفي يسار"
                                                    customDialogR2SX.s3er_r2s_acx.setText("15")
                                                } else {
                                                    if (customDialogR2SX.outsideleft.isChecked && customDialogR2SX.insideright.isChecked) {
                                                        ch8.text =
                                                            "كوشوكة عمود شيال امامي يسار و خلفي يمين"
                                                        customDialogR2SX.s3er_r2s_acx.setText("15")
                                                    } else {
                                                        if (customDialogR2SX.outsideleft.isChecked && customDialogR2SX.insideleft.isChecked) {
                                                            ch8.text =
                                                                "كوشوكة عمود شيال امامي يسار و خلفي يسار"
                                                            customDialogR2SX.s3er_r2s_acx.setText("15")
                                                        } else {
                                                            if (customDialogR2SX.insideright.isChecked && customDialogR2SX.insideleft.isChecked) {
                                                                ch8.text =
                                                                    "كوشوكة عمود شيال خلفي يمين و يسار"
                                                                customDialogR2SX.s3er_r2s_acx.setText(
                                                                    "10"
                                                                )
                                                            } else {

                                                                if (customDialogR2SX.outsideright.isChecked) {
                                                                    ch8.text =
                                                                        "كوشوكة عمود شيال امامي يمين"
                                                                    customDialogR2SX.s3er_r2s_acx.setText(
                                                                        "10"
                                                                    )
                                                                }
                                                                if (customDialogR2SX.outsideleft.isChecked) {
                                                                    ch8.text =
                                                                        "كوشوكة عمود شيال امامي يسار"
                                                                    customDialogR2SX.s3er_r2s_acx.setText(
                                                                        "10"
                                                                    )
                                                                }

                                                                if (customDialogR2SX.insideleft.isChecked) {
                                                                    ch8.text =
                                                                        "كوشوكة عمود شيال خلفي يسار"
                                                                    customDialogR2SX.s3er_r2s_acx.setText(
                                                                        "5"
                                                                    )
                                                                }
                                                                if (customDialogR2SX.insideright.isChecked) {
                                                                    ch8.text =
                                                                        "كوشوكة عمود شيال خلفي يمين"
                                                                    customDialogR2SX.s3er_r2s_acx.setText(
                                                                        "5"
                                                                    )
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                    customDialogR2SX.show()
                }



                customDialogR2SX.outsideleft.setOnCheckedChangeListener { _, isChecked2 ->
                    if (customDialogR2SX.outsideleft.isChecked) {
                        ch8.text = "راسية اكس خارجية يسار"
                    } else {
                        ch8.text = "راسية اكس"
                        customDialogR2SX.s3er_r2s_acx.setText("")
                    }

                    if (customDialogR2SX.outsideright.isChecked && customDialogR2SX.outsideleft.isChecked && customDialogR2SX.insideright.isChecked && customDialogR2SX.insideleft.isChecked) {
                        ch8.text = "تغير جميع كوشوكات عمود الشيال"
                        customDialogR2SX.s3er_r2s_acx.setText("30")
                    } else {
                        if (customDialogR2SX.outsideright.isChecked && customDialogR2SX.outsideleft.isChecked && customDialogR2SX.insideright.isChecked) {
                            ch8.text = "كوشوكتين عمود شيال امامي و الخلفي يمين"
                            customDialogR2SX.s3er_r2s_acx.setText("25")
                        } else {
                            if (customDialogR2SX.outsideright.isChecked && customDialogR2SX.outsideleft.isChecked && customDialogR2SX.insideleft.isChecked) {
                                ch8.text = "كوشوكتين عمود شيال امامي  و الخلفي يسار"
                                customDialogR2SX.s3er_r2s_acx.setText("25")
                            } else {
                                if (customDialogR2SX.outsideright.isChecked && customDialogR2SX.insideright.isChecked && customDialogR2SX.insideleft.isChecked) {
                                    ch8.text = "كوشوكة عمود شيال امامي يمين و الخلفيتين"
                                    customDialogR2SX.s3er_r2s_acx.setText("20")
                                } else {
                                    if (customDialogR2SX.outsideleft.isChecked && customDialogR2SX.insideright.isChecked && customDialogR2SX.insideleft.isChecked) {
                                        ch8.text = "كوشوكة عمود شيال امامي يسار و الخلفيتين"
                                        customDialogR2SX.s3er_r2s_acx.setText("20")
                                    } else {
                                        if (customDialogR2SX.outsideright.isChecked && customDialogR2SX.outsideleft.isChecked) {
                                            ch8.text = "كوشوكة عمود شيال امامي يمين و يسار"
                                            customDialogR2SX.s3er_r2s_acx.setText("20")
                                        } else {
                                            if (customDialogR2SX.outsideright.isChecked && customDialogR2SX.insideright.isChecked) {
                                                ch8.text = "كوشوكة عمود شيال امامي يمين و خلفي يمين"
                                                customDialogR2SX.s3er_r2s_acx.setText("15")
                                            } else {
                                                if (customDialogR2SX.outsideright.isChecked && customDialogR2SX.insideleft.isChecked) {
                                                    ch8.text = "كوشوكة عمود شيال امامي يمين و خلفي يسار"
                                                    customDialogR2SX.s3er_r2s_acx.setText("15")
                                                } else {
                                                    if (customDialogR2SX.outsideleft.isChecked && customDialogR2SX.insideright.isChecked) {
                                                        ch8.text =
                                                            "كوشوكة عمود شيال امامي يسار و خلفي يمين"
                                                        customDialogR2SX.s3er_r2s_acx.setText("15")
                                                    } else {
                                                        if (customDialogR2SX.outsideleft.isChecked && customDialogR2SX.insideleft.isChecked) {
                                                            ch8.text =
                                                                "كوشوكة عمود شيال امامي يسار و خلفي يسار"
                                                            customDialogR2SX.s3er_r2s_acx.setText("15")
                                                        } else {
                                                            if (customDialogR2SX.insideright.isChecked && customDialogR2SX.insideleft.isChecked) {
                                                                ch8.text =
                                                                    "كوشوكة عمود شيال خلفي يمين و يسار"
                                                                customDialogR2SX.s3er_r2s_acx.setText(
                                                                    "10"
                                                                )
                                                            } else {

                                                                if (customDialogR2SX.outsideright.isChecked) {
                                                                    ch8.text =
                                                                        "كوشوكة عمود شيال امامي يمين"
                                                                    customDialogR2SX.s3er_r2s_acx.setText(
                                                                        "10"
                                                                    )
                                                                }
                                                                if (customDialogR2SX.outsideleft.isChecked) {
                                                                    ch8.text =
                                                                        "كوشوكة عمود شيال امامي يسار"
                                                                    customDialogR2SX.s3er_r2s_acx.setText(
                                                                        "10"
                                                                    )
                                                                }

                                                                if (customDialogR2SX.insideleft.isChecked) {
                                                                    ch8.text =
                                                                        "كوشوكة عمود شيال خلفي يسار"
                                                                    customDialogR2SX.s3er_r2s_acx.setText(
                                                                        "5"
                                                                    )
                                                                }
                                                                if (customDialogR2SX.insideright.isChecked) {
                                                                    ch8.text =
                                                                        "كوشوكة عمود شيال خلفي يمين"
                                                                    customDialogR2SX.s3er_r2s_acx.setText(
                                                                        "5"
                                                                    )
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                    customDialogR2SX.show()
                }



                customDialogR2SX.insideleft.setOnCheckedChangeListener { _, isChecked2 ->
                    if (customDialogR2SX.outsideright.isChecked) {
                        ch8.text = "كوشوكة عمود شيال خارجية يمين"
                    } else {
                        ch8.text = "كوشوكة عمود شيال خارجية"
                        customDialogR2SX.s3er_r2s_acx.setText("")
                    }

                    if (customDialogR2SX.outsideright.isChecked && customDialogR2SX.outsideleft.isChecked && customDialogR2SX.insideright.isChecked && customDialogR2SX.insideleft.isChecked) {
                        ch8.text = "تغير جميع كوشوكات عمود الشيال"
                        customDialogR2SX.s3er_r2s_acx.setText("30")
                    } else {
                        if (customDialogR2SX.outsideright.isChecked && customDialogR2SX.outsideleft.isChecked && customDialogR2SX.insideright.isChecked) {
                            ch8.text = "كوشوكتين عمود شيال امامي و الخلفي يمين"
                            customDialogR2SX.s3er_r2s_acx.setText("25")
                        } else {
                            if (customDialogR2SX.outsideright.isChecked && customDialogR2SX.outsideleft.isChecked && customDialogR2SX.insideleft.isChecked) {
                                ch8.text = "كوشوكتين عمود شيال امامي  و الخلفي يسار"
                                customDialogR2SX.s3er_r2s_acx.setText("25")
                            } else {
                                if (customDialogR2SX.outsideright.isChecked && customDialogR2SX.insideright.isChecked && customDialogR2SX.insideleft.isChecked) {
                                    ch8.text = "كوشوكة عمود شيال امامي يمين و الخلفيتين"
                                    customDialogR2SX.s3er_r2s_acx.setText("20")
                                } else {
                                    if (customDialogR2SX.outsideleft.isChecked && customDialogR2SX.insideright.isChecked && customDialogR2SX.insideleft.isChecked) {
                                        ch8.text = "كوشوكة عمود شيال امامي يسار و الخلفيتين"
                                        customDialogR2SX.s3er_r2s_acx.setText("20")
                                    } else {
                                        if (customDialogR2SX.outsideright.isChecked && customDialogR2SX.outsideleft.isChecked) {
                                            ch8.text = "كوشوكة عمود شيال امامي يمين و يسار"
                                            customDialogR2SX.s3er_r2s_acx.setText("20")
                                        } else {
                                            if (customDialogR2SX.outsideright.isChecked && customDialogR2SX.insideright.isChecked) {
                                                ch8.text = "كوشوكة عمود شيال امامي يمين و خلفي يمين"
                                                customDialogR2SX.s3er_r2s_acx.setText("15")
                                            } else {
                                                if (customDialogR2SX.outsideright.isChecked && customDialogR2SX.insideleft.isChecked) {
                                                    ch8.text = "كوشوكة عمود شيال امامي يمين و خلفي يسار"
                                                    customDialogR2SX.s3er_r2s_acx.setText("15")
                                                } else {
                                                    if (customDialogR2SX.outsideleft.isChecked && customDialogR2SX.insideright.isChecked) {
                                                        ch8.text =
                                                            "كوشوكة عمود شيال امامي يسار و خلفي يمين"
                                                        customDialogR2SX.s3er_r2s_acx.setText("15")
                                                    } else {
                                                        if (customDialogR2SX.outsideleft.isChecked && customDialogR2SX.insideleft.isChecked) {
                                                            ch8.text =
                                                                "كوشوكة عمود شيال امامي يسار و خلفي يسار"
                                                            customDialogR2SX.s3er_r2s_acx.setText("15")
                                                        } else {
                                                            if (customDialogR2SX.insideright.isChecked && customDialogR2SX.insideleft.isChecked) {
                                                                ch8.text =
                                                                    "كوشوكة عمود شيال خلفي يمين و يسار"
                                                                customDialogR2SX.s3er_r2s_acx.setText(
                                                                    "10"
                                                                )
                                                            } else {

                                                                if (customDialogR2SX.outsideright.isChecked) {
                                                                    ch8.text =
                                                                        "كوشوكة عمود شيال امامي يمين"
                                                                    customDialogR2SX.s3er_r2s_acx.setText(
                                                                        "10"
                                                                    )
                                                                }
                                                                if (customDialogR2SX.outsideleft.isChecked) {
                                                                    ch8.text =
                                                                        "كوشوكة عمود شيال امامي يسار"
                                                                    customDialogR2SX.s3er_r2s_acx.setText(
                                                                        "10"
                                                                    )
                                                                }

                                                                if (customDialogR2SX.insideleft.isChecked) {
                                                                    ch8.text =
                                                                        "كوشوكة عمود شيال خلفي يسار"
                                                                    customDialogR2SX.s3er_r2s_acx.setText(
                                                                        "5"
                                                                    )
                                                                }
                                                                if (customDialogR2SX.insideright.isChecked) {
                                                                    ch8.text =
                                                                        "كوشوكة عمود شيال خلفي يمين"
                                                                    customDialogR2SX.s3er_r2s_acx.setText(
                                                                        "5"
                                                                    )
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }

                    customDialogR2SX.show()
                }

                customDialogR2SX.insideright.setOnCheckedChangeListener { _, isChecked2 ->
                    if (customDialogR2SX.outsideright.isChecked) {
                        ch8.text = "كوشوكة عمود شيال خارجية يمين"
                    } else {
                        ch8.text = "كوشوكة عمود شيال خارجية"
                        customDialogR2SX.s3er_r2s_acx.setText("")
                    }

                    if (customDialogR2SX.outsideright.isChecked && customDialogR2SX.outsideleft.isChecked && customDialogR2SX.insideright.isChecked && customDialogR2SX.insideleft.isChecked) {
                        ch8.text = "تغير جميع كوشوكات عمود الشيال"
                        customDialogR2SX.s3er_r2s_acx.setText("30")
                    } else {
                        if (customDialogR2SX.outsideright.isChecked && customDialogR2SX.outsideleft.isChecked && customDialogR2SX.insideright.isChecked) {
                            ch8.text = "كوشوكتين عمود شيال امامي و الخلفي يمين"
                            customDialogR2SX.s3er_r2s_acx.setText("25")
                        } else {
                            if (customDialogR2SX.outsideright.isChecked && customDialogR2SX.outsideleft.isChecked && customDialogR2SX.insideleft.isChecked) {
                                ch8.text = "كوشوكتين عمود شيال امامي  و الخلفي يسار"
                                customDialogR2SX.s3er_r2s_acx.setText("25")
                            } else {
                                if (customDialogR2SX.outsideright.isChecked && customDialogR2SX.insideright.isChecked && customDialogR2SX.insideleft.isChecked) {
                                    ch8.text = "كوشوكة عمود شيال امامي يمين و الخلفيتين"
                                    customDialogR2SX.s3er_r2s_acx.setText("20")
                                } else {
                                    if (customDialogR2SX.outsideleft.isChecked && customDialogR2SX.insideright.isChecked && customDialogR2SX.insideleft.isChecked) {
                                        ch8.text = "كوشوكة عمود شيال امامي يسار و الخلفيتين"
                                        customDialogR2SX.s3er_r2s_acx.setText("20")
                                    } else {
                                        if (customDialogR2SX.outsideright.isChecked && customDialogR2SX.outsideleft.isChecked) {
                                            ch8.text = "كوشوكة عمود شيال امامي يمين و يسار"
                                            customDialogR2SX.s3er_r2s_acx.setText("20")
                                        } else {
                                            if (customDialogR2SX.outsideright.isChecked && customDialogR2SX.insideright.isChecked) {
                                                ch8.text = "كوشوكة عمود شيال امامي يمين و خلفي يمين"
                                                customDialogR2SX.s3er_r2s_acx.setText("15")
                                            } else {
                                                if (customDialogR2SX.outsideright.isChecked && customDialogR2SX.insideleft.isChecked) {
                                                    ch8.text = "كوشوكة عمود شيال امامي يمين و خلفي يسار"
                                                    customDialogR2SX.s3er_r2s_acx.setText("15")
                                                } else {
                                                    if (customDialogR2SX.outsideleft.isChecked && customDialogR2SX.insideright.isChecked) {
                                                        ch8.text =
                                                            "كوشوكة عمود شيال امامي يسار و خلفي يمين"
                                                        customDialogR2SX.s3er_r2s_acx.setText("15")
                                                    } else {
                                                        if (customDialogR2SX.outsideleft.isChecked && customDialogR2SX.insideleft.isChecked) {
                                                            ch8.text =
                                                                "كوشوكة عمود شيال امامي يسار و خلفي يسار"
                                                            customDialogR2SX.s3er_r2s_acx.setText("15")
                                                        } else {
                                                            if (customDialogR2SX.insideright.isChecked && customDialogR2SX.insideleft.isChecked) {
                                                                ch8.text =
                                                                    "كوشوكة عمود شيال خلفي يمين و يسار"
                                                                customDialogR2SX.s3er_r2s_acx.setText(
                                                                    "10"
                                                                )
                                                            } else {

                                                                if (customDialogR2SX.outsideright.isChecked) {
                                                                    ch8.text =
                                                                        "كوشوكة عمود شيال امامي يمين"
                                                                    customDialogR2SX.s3er_r2s_acx.setText(
                                                                        "10"
                                                                    )
                                                                }
                                                                if (customDialogR2SX.outsideleft.isChecked) {
                                                                    ch8.text =
                                                                        "كوشوكة عمود شيال امامي يسار"
                                                                    customDialogR2SX.s3er_r2s_acx.setText(
                                                                        "10"
                                                                    )
                                                                }

                                                                if (customDialogR2SX.insideleft.isChecked) {
                                                                    ch8.text =
                                                                        "كوشوكة عمود شيال خلفي يسار"
                                                                    customDialogR2SX.s3er_r2s_acx.setText(
                                                                        "5"
                                                                    )
                                                                }
                                                                if (customDialogR2SX.insideright.isChecked) {
                                                                    ch8.text =
                                                                        "كوشوكة عمود شيال خلفي يمين"
                                                                    customDialogR2SX.s3er_r2s_acx.setText(
                                                                        "5"
                                                                    )
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                    customDialogR2SX.show()
                }


                customDialogR2SX.btn_r2s_sav.setOnClickListener {
                    if (!customDialogR2SX.outsideright.isChecked && !customDialogR2SX.outsideleft.isChecked
                        && !customDialogR2SX.insideright.isChecked && !customDialogR2SX.insideleft.isChecked
                    ) {
                        toast_notempty1.show()
                    } else {
                        if (customDialogR2SX.s3er_r2s_acx.text.toString().trim().isEmpty()) {
                            toast_notempty.show()
                        } else {
                            pricd8.text = customDialogR2SX.s3er_r2s_acx.text.toString()
                            viewModel.totalAmount += pricd8.text.toString().toInt()
                            toolbar?.title =  viewModel.totalAmount.toString()
                            customDialogR2SX.dismiss()
                        }
                    }
                }
                customDialogR2SX.btn_r2s_can.setOnClickListener {
                    if (pricd8.text.toString().isEmpty()) {
                        ch8.text = "كوشوكة عمود شيال"
                        ch8.isChecked = false
                    }
                    customDialogR2SX.dismiss()
                }

                customDialogR2SX.show()
                homeModel.checkname8 += ch8.text.toString().trim()
                homeModel.editname8 += pricd8.text.toString().trim()
            } else {
                if (pricd8.text.toString().isNotEmpty()) {
                    viewModel.totalAmount -= pricd8.text.toString().toInt()
                    toolbar?.title =  viewModel.totalAmount.toString()
                    ch8.text = "كوشوكة عمود شيال"
                    pricd8.setText("")
                    homeModel.checkname8 =  ""
                    homeModel.editname8 =  ""
                } else {
                    ch8.text = "كوشوكة عمود شيال"
                }
            }
        }

        ch9.setOnCheckedChangeListener { _, isChecked ->
            if (ch9.isChecked) {

                customDialogR2SX.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

                customDialogR2SX.card_r2s_2ks.setOnTouchListener { _, event ->
                    var x = 0f
                    var y = 0f
                    when (event.action) {
                        MotionEvent.ACTION_UP -> {
                            x = event.x
                            y = event.y
                        }
                        MotionEvent.ACTION_MOVE -> {
                            customDialogR2SX.window?.let {
                                val params: WindowManager.LayoutParams = it.attributes
                                params.x = event.rawX.toInt() - x.toInt()
                                params.y = event.rawY.toInt() - y.toInt()
                                it.attributes = params
                            }
                        }

                        MotionEvent.ACTION_UP -> {
                            customDialogR2SX.window?.let {
                                val params: WindowManager.LayoutParams = it.attributes
                                if (params.y < 0) {
                                    params.y = 0
                                    it.attributes = params
                                } else if (params.y > 2000) { // change this value to move up more
                                    params.y = 2000 // change this value to move up more
                                    it.attributes = params
                                }
                            }
                        }

                    }
                    true
                }

                customDialogR2SX.outsideright.setOnCheckedChangeListener { _, isChecked1 ->

                    if (customDialogR2SX.outsideright.isChecked) {
                        ch9.text = "جوزة خارجية يمين"
                    } else {
                        ch9.text = "جوزة"
                        customDialogR2SX.s3er_r2s_acx.setText("")
                    }

                    if (customDialogR2SX.outsideright.isChecked && customDialogR2SX.outsideleft.isChecked && customDialogR2SX.insideright.isChecked && customDialogR2SX.insideleft.isChecked) {
                        ch9.text = "تغير جميع الجوزات"
                        customDialogR2SX.s3er_r2s_acx.setText("16")
                    } else {
                        if (customDialogR2SX.outsideright.isChecked && customDialogR2SX.outsideleft.isChecked && customDialogR2SX.insideright.isChecked) {
                            ch9.text = "جوزتين خارجيات و الداخلية يمين"
                            customDialogR2SX.s3er_r2s_acx.setText("11")
                        } else {
                            if (customDialogR2SX.outsideright.isChecked && customDialogR2SX.outsideleft.isChecked && customDialogR2SX.insideleft.isChecked) {
                                ch9.text = "جوزتين خارجيات و الداخلية يسار"
                                customDialogR2SX.s3er_r2s_acx.setText("11")
                            } else {
                                if (customDialogR2SX.outsideright.isChecked && customDialogR2SX.insideright.isChecked && customDialogR2SX.insideleft.isChecked) {
                                    ch9.text = "جوزة خارجية يمين و الداخليتين"
                                    customDialogR2SX.s3er_r2s_acx.setText("13")
                                } else {
                                    if (customDialogR2SX.outsideleft.isChecked && customDialogR2SX.insideright.isChecked && customDialogR2SX.insideleft.isChecked) {
                                        ch9.text = "جوزة خارجية يسار و الداخليتين"
                                        customDialogR2SX.s3er_r2s_acx.setText("13")
                                    } else {
                                        if (customDialogR2SX.outsideright.isChecked && customDialogR2SX.outsideleft.isChecked) {
                                            ch9.text = "جوزة خارجية يمين و يسار"
                                            customDialogR2SX.s3er_r2s_acx.setText("6")
                                        } else {
                                            if (customDialogR2SX.outsideright.isChecked && customDialogR2SX.insideright.isChecked) {
                                                ch9.text = "جوزة خارجية يمين و داخلية يمين"
                                                customDialogR2SX.s3er_r2s_acx.setText("8")
                                            } else {
                                                if (customDialogR2SX.outsideright.isChecked && customDialogR2SX.insideleft.isChecked) {
                                                    ch9.text = "جوزة خارجية يمين و داخلية يسار"
                                                    customDialogR2SX.s3er_r2s_acx.setText("8")
                                                } else {
                                                    if (customDialogR2SX.outsideleft.isChecked && customDialogR2SX.insideright.isChecked) {
                                                        ch9.text =
                                                            "جوزة خارجية يسار و داخلية يمين"
                                                        customDialogR2SX.s3er_r2s_acx.setText("8")
                                                    } else {
                                                        if (customDialogR2SX.outsideleft.isChecked && customDialogR2SX.insideleft.isChecked) {
                                                            ch9.text =
                                                                "جوزة خارجية يسار و داخلية يسار"
                                                            customDialogR2SX.s3er_r2s_acx.setText("8")
                                                        } else {
                                                            if (customDialogR2SX.insideright.isChecked && customDialogR2SX.insideleft.isChecked) {
                                                                ch9.text =
                                                                    "جوزة داخلية يمين و يسار"
                                                                customDialogR2SX.s3er_r2s_acx.setText(
                                                                    "10"
                                                                )
                                                            } else {

                                                                if (customDialogR2SX.outsideright.isChecked) {
                                                                    ch9.text =
                                                                        "جوزة خارجية يمين"
                                                                    customDialogR2SX.s3er_r2s_acx.setText(
                                                                        "3"
                                                                    )
                                                                }
                                                                if (customDialogR2SX.outsideleft.isChecked) {
                                                                    ch9.text =
                                                                        "جوزة خارجية يسار"
                                                                    customDialogR2SX.s3er_r2s_acx.setText(
                                                                        "3"
                                                                    )
                                                                }

                                                                if (customDialogR2SX.insideleft.isChecked) {
                                                                    ch9.text =
                                                                        "جوزة داخلية يسار"
                                                                    customDialogR2SX.s3er_r2s_acx.setText(
                                                                        "5"
                                                                    )
                                                                }
                                                                if (customDialogR2SX.insideright.isChecked) {
                                                                    ch9.text =
                                                                        "جوزة داخلية يمين"
                                                                    customDialogR2SX.s3er_r2s_acx.setText(
                                                                        "5"
                                                                    )
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                    customDialogR2SX.show()
                }



                customDialogR2SX.outsideleft.setOnCheckedChangeListener { _, isChecked2 ->
                    if (customDialogR2SX.outsideleft.isChecked) {
                        ch9.text = "جوزة خارجية يمين"
                    } else {
                        ch9.text = "جوزة"
                        customDialogR2SX.s3er_r2s_acx.setText("")
                    }

                    if (customDialogR2SX.outsideright.isChecked && customDialogR2SX.outsideleft.isChecked && customDialogR2SX.insideright.isChecked && customDialogR2SX.insideleft.isChecked) {
                        ch9.text = "تغير جميع الجوزات"
                        customDialogR2SX.s3er_r2s_acx.setText("16")
                    } else {
                        if (customDialogR2SX.outsideright.isChecked && customDialogR2SX.outsideleft.isChecked && customDialogR2SX.insideright.isChecked) {
                            ch9.text = "جوزتين خارجيات و الداخلية يمين"
                            customDialogR2SX.s3er_r2s_acx.setText("11")
                        } else {
                            if (customDialogR2SX.outsideright.isChecked && customDialogR2SX.outsideleft.isChecked && customDialogR2SX.insideleft.isChecked) {
                                ch9.text = "جوزتين خارجيات و الداخلية يسار"
                                customDialogR2SX.s3er_r2s_acx.setText("11")
                            } else {
                                if (customDialogR2SX.outsideright.isChecked && customDialogR2SX.insideright.isChecked && customDialogR2SX.insideleft.isChecked) {
                                    ch9.text = "جوزة خارجية يمين و الداخليتين"
                                    customDialogR2SX.s3er_r2s_acx.setText("13")
                                } else {
                                    if (customDialogR2SX.outsideleft.isChecked && customDialogR2SX.insideright.isChecked && customDialogR2SX.insideleft.isChecked) {
                                        ch9.text = "جوزة خارجية يسار و الداخليتين"
                                        customDialogR2SX.s3er_r2s_acx.setText("13")
                                    } else {
                                        if (customDialogR2SX.outsideright.isChecked && customDialogR2SX.outsideleft.isChecked) {
                                            ch9.text = "جوزة خارجية يمين و يسار"
                                            customDialogR2SX.s3er_r2s_acx.setText("6")
                                        } else {
                                            if (customDialogR2SX.outsideright.isChecked && customDialogR2SX.insideright.isChecked) {
                                                ch9.text = "جوزة خارجية يمين و داخلية يمين"
                                                customDialogR2SX.s3er_r2s_acx.setText("8")
                                            } else {
                                                if (customDialogR2SX.outsideright.isChecked && customDialogR2SX.insideleft.isChecked) {
                                                    ch9.text = "جوزة خارجية يمين و داخلية يسار"
                                                    customDialogR2SX.s3er_r2s_acx.setText("8")
                                                } else {
                                                    if (customDialogR2SX.outsideleft.isChecked && customDialogR2SX.insideright.isChecked) {
                                                        ch9.text =
                                                            "جوزة خارجية يسار و داخلية يمين"
                                                        customDialogR2SX.s3er_r2s_acx.setText("8")
                                                    } else {
                                                        if (customDialogR2SX.outsideleft.isChecked && customDialogR2SX.insideleft.isChecked) {
                                                            ch9.text =
                                                                "جوزة خارجية يسار و داخلية يسار"
                                                            customDialogR2SX.s3er_r2s_acx.setText("8")
                                                        } else {
                                                            if (customDialogR2SX.insideright.isChecked && customDialogR2SX.insideleft.isChecked) {
                                                                ch9.text =
                                                                    "جوزة داخلية يمين و يسار"
                                                                customDialogR2SX.s3er_r2s_acx.setText(
                                                                    "10"
                                                                )
                                                            } else {

                                                                if (customDialogR2SX.outsideright.isChecked) {
                                                                    ch9.text =
                                                                        "جوزة خارجية يمين"
                                                                    customDialogR2SX.s3er_r2s_acx.setText(
                                                                        "3"
                                                                    )
                                                                }
                                                                if (customDialogR2SX.outsideleft.isChecked) {
                                                                    ch9.text =
                                                                        "جوزة خارجية يسار"
                                                                    customDialogR2SX.s3er_r2s_acx.setText(
                                                                        "3"
                                                                    )
                                                                }

                                                                if (customDialogR2SX.insideleft.isChecked) {
                                                                    ch9.text =
                                                                        "جوزة داخلية يسار"
                                                                    customDialogR2SX.s3er_r2s_acx.setText(
                                                                        "5"
                                                                    )
                                                                }
                                                                if (customDialogR2SX.insideright.isChecked) {
                                                                    ch9.text =
                                                                        "جوزة داخلية يمين"
                                                                    customDialogR2SX.s3er_r2s_acx.setText(
                                                                        "5"
                                                                    )
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                    customDialogR2SX.show()
                }



                customDialogR2SX.insideleft.setOnCheckedChangeListener { _, isChecked2 ->
                    if (customDialogR2SX.outsideright.isChecked) {
                        ch9.text = "جوزة خارجية يمين"
                    } else {
                        ch9.text = "جوزة"
                        customDialogR2SX.s3er_r2s_acx.setText("")
                    }

                    if (customDialogR2SX.outsideright.isChecked && customDialogR2SX.outsideleft.isChecked && customDialogR2SX.insideright.isChecked && customDialogR2SX.insideleft.isChecked) {
                        ch9.text = "تغير جميع الجوزات"
                        customDialogR2SX.s3er_r2s_acx.setText("16")
                    } else {
                        if (customDialogR2SX.outsideright.isChecked && customDialogR2SX.outsideleft.isChecked && customDialogR2SX.insideright.isChecked) {
                            ch9.text = "جوزتين خارجيات و الداخلية يمين"
                            customDialogR2SX.s3er_r2s_acx.setText("11")
                        } else {
                            if (customDialogR2SX.outsideright.isChecked && customDialogR2SX.outsideleft.isChecked && customDialogR2SX.insideleft.isChecked) {
                                ch9.text = "جوزتين خارجيات و الداخلية يسار"
                                customDialogR2SX.s3er_r2s_acx.setText("11")
                            } else {
                                if (customDialogR2SX.outsideright.isChecked && customDialogR2SX.insideright.isChecked && customDialogR2SX.insideleft.isChecked) {
                                    ch9.text = "جوزة خارجية يمين و الداخليتين"
                                    customDialogR2SX.s3er_r2s_acx.setText("13")
                                } else {
                                    if (customDialogR2SX.outsideleft.isChecked && customDialogR2SX.insideright.isChecked && customDialogR2SX.insideleft.isChecked) {
                                        ch9.text = "جوزة خارجية يسار و الداخليتين"
                                        customDialogR2SX.s3er_r2s_acx.setText("13")
                                    } else {
                                        if (customDialogR2SX.outsideright.isChecked && customDialogR2SX.outsideleft.isChecked) {
                                            ch9.text = "جوزة خارجية يمين و يسار"
                                            customDialogR2SX.s3er_r2s_acx.setText("6")
                                        } else {
                                            if (customDialogR2SX.outsideright.isChecked && customDialogR2SX.insideright.isChecked) {
                                                ch9.text = "جوزة خارجية يمين و داخلية يمين"
                                                customDialogR2SX.s3er_r2s_acx.setText("8")
                                            } else {
                                                if (customDialogR2SX.outsideright.isChecked && customDialogR2SX.insideleft.isChecked) {
                                                    ch9.text = "جوزة خارجية يمين و داخلية يسار"
                                                    customDialogR2SX.s3er_r2s_acx.setText("8")
                                                } else {
                                                    if (customDialogR2SX.outsideleft.isChecked && customDialogR2SX.insideright.isChecked) {
                                                        ch9.text =
                                                            "جوزة خارجية يسار و داخلية يمين"
                                                        customDialogR2SX.s3er_r2s_acx.setText("8")
                                                    } else {
                                                        if (customDialogR2SX.outsideleft.isChecked && customDialogR2SX.insideleft.isChecked) {
                                                            ch9.text =
                                                                "جوزة خارجية يسار و داخلية يسار"
                                                            customDialogR2SX.s3er_r2s_acx.setText("8")
                                                        } else {
                                                            if (customDialogR2SX.insideright.isChecked && customDialogR2SX.insideleft.isChecked) {
                                                                ch9.text =
                                                                    "جوزة داخلية يمين و يسار"
                                                                customDialogR2SX.s3er_r2s_acx.setText(
                                                                    "10"
                                                                )
                                                            } else {

                                                                if (customDialogR2SX.outsideright.isChecked) {
                                                                    ch9.text =
                                                                        "جوزة خارجية يمين"
                                                                    customDialogR2SX.s3er_r2s_acx.setText(
                                                                        "3"
                                                                    )
                                                                }
                                                                if (customDialogR2SX.outsideleft.isChecked) {
                                                                    ch9.text =
                                                                        "جوزة خارجية يسار"
                                                                    customDialogR2SX.s3er_r2s_acx.setText(
                                                                        "3"
                                                                    )
                                                                }

                                                                if (customDialogR2SX.insideleft.isChecked) {
                                                                    ch9.text =
                                                                        "جوزة داخلية يسار"
                                                                    customDialogR2SX.s3er_r2s_acx.setText(
                                                                        "5"
                                                                    )
                                                                }
                                                                if (customDialogR2SX.insideright.isChecked) {
                                                                    ch9.text =
                                                                        "جوزة داخلية يمين"
                                                                    customDialogR2SX.s3er_r2s_acx.setText(
                                                                        "5"
                                                                    )
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }

                    customDialogR2SX.show()
                }

                customDialogR2SX.insideright.setOnCheckedChangeListener { _, isChecked2 ->
                    if (customDialogR2SX.outsideright.isChecked) {
                        ch9.text = "جوزة خارجية يمين"
                    } else {
                        ch9.text = "جوزة"
                        customDialogR2SX.s3er_r2s_acx.setText("")
                    }

                    if (customDialogR2SX.outsideright.isChecked && customDialogR2SX.outsideleft.isChecked && customDialogR2SX.insideright.isChecked && customDialogR2SX.insideleft.isChecked) {
                        ch9.text = "تغير جميع الجوزات"
                        customDialogR2SX.s3er_r2s_acx.setText("16")
                    } else {
                        if (customDialogR2SX.outsideright.isChecked && customDialogR2SX.outsideleft.isChecked && customDialogR2SX.insideright.isChecked) {
                            ch9.text = "جوزتين خارجيات و الداخلية يمين"
                            customDialogR2SX.s3er_r2s_acx.setText("11")
                        } else {
                            if (customDialogR2SX.outsideright.isChecked && customDialogR2SX.outsideleft.isChecked && customDialogR2SX.insideleft.isChecked) {
                                ch9.text = "جوزتين خارجيات و الداخلية يسار"
                                customDialogR2SX.s3er_r2s_acx.setText("11")
                            } else {
                                if (customDialogR2SX.outsideright.isChecked && customDialogR2SX.insideright.isChecked && customDialogR2SX.insideleft.isChecked) {
                                    ch9.text = "جوزة خارجية يمين و الداخليتين"
                                    customDialogR2SX.s3er_r2s_acx.setText("13")
                                } else {
                                    if (customDialogR2SX.outsideleft.isChecked && customDialogR2SX.insideright.isChecked && customDialogR2SX.insideleft.isChecked) {
                                        ch9.text = "جوزة خارجية يسار و الداخليتين"
                                        customDialogR2SX.s3er_r2s_acx.setText("13")
                                    } else {
                                        if (customDialogR2SX.outsideright.isChecked && customDialogR2SX.outsideleft.isChecked) {
                                            ch9.text = "جوزة خارجية يمين و يسار"
                                            customDialogR2SX.s3er_r2s_acx.setText("6")
                                        } else {
                                            if (customDialogR2SX.outsideright.isChecked && customDialogR2SX.insideright.isChecked) {
                                                ch9.text = "جوزة خارجية يمين و داخلية يمين"
                                                customDialogR2SX.s3er_r2s_acx.setText("8")
                                            } else {
                                                if (customDialogR2SX.outsideright.isChecked && customDialogR2SX.insideleft.isChecked) {
                                                    ch9.text = "جوزة خارجية يمين و داخلية يسار"
                                                    customDialogR2SX.s3er_r2s_acx.setText("8")
                                                } else {
                                                    if (customDialogR2SX.outsideleft.isChecked && customDialogR2SX.insideright.isChecked) {
                                                        ch9.text =
                                                            "جوزة خارجية يسار و داخلية يمين"
                                                        customDialogR2SX.s3er_r2s_acx.setText("8")
                                                    } else {
                                                        if (customDialogR2SX.outsideleft.isChecked && customDialogR2SX.insideleft.isChecked) {
                                                            ch9.text =
                                                                "جوزة خارجية يسار و داخلية يسار"
                                                            customDialogR2SX.s3er_r2s_acx.setText("8")
                                                        } else {
                                                            if (customDialogR2SX.insideright.isChecked && customDialogR2SX.insideleft.isChecked) {
                                                                ch9.text =
                                                                    "جوزة داخلية يمين و يسار"
                                                                customDialogR2SX.s3er_r2s_acx.setText(
                                                                    "10"
                                                                )
                                                            } else {

                                                                if (customDialogR2SX.outsideright.isChecked) {
                                                                    ch9.text =
                                                                        "جوزة خارجية يمين"
                                                                    customDialogR2SX.s3er_r2s_acx.setText(
                                                                        "3"
                                                                    )
                                                                }
                                                                if (customDialogR2SX.outsideleft.isChecked) {
                                                                    ch9.text =
                                                                        "جوزة خارجية يسار"
                                                                    customDialogR2SX.s3er_r2s_acx.setText(
                                                                        "3"
                                                                    )
                                                                }

                                                                if (customDialogR2SX.insideleft.isChecked) {
                                                                    ch9.text =
                                                                        "جوزة داخلية يسار"
                                                                    customDialogR2SX.s3er_r2s_acx.setText(
                                                                        "5"
                                                                    )
                                                                }
                                                                if (customDialogR2SX.insideright.isChecked) {
                                                                    ch9.text =
                                                                        "جوزة داخلية يمين"
                                                                    customDialogR2SX.s3er_r2s_acx.setText(
                                                                        "5"
                                                                    )
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                    customDialogR2SX.show()
                }


                customDialogR2SX.btn_r2s_sav.setOnClickListener {
                    if (!customDialogR2SX.outsideright.isChecked && !customDialogR2SX.outsideleft.isChecked
                        && !customDialogR2SX.insideright.isChecked && !customDialogR2SX.insideleft.isChecked
                    ) {
                        toast_notempty1.show()
                    } else {
                        if (customDialogR2SX.s3er_r2s_acx.text.toString().trim().isEmpty()) {
                            toast_notempty.show()
                        } else {
                            pricd9.text = customDialogR2SX.s3er_r2s_acx.text.toString()
                            viewModel.totalAmount += pricd9.text.toString().toInt()
                            toolbar?.title =  viewModel.totalAmount.toString()
                            customDialogR2SX.dismiss()
                        }
                    }
                }
                customDialogR2SX.btn_r2s_can.setOnClickListener {
                    if (pricd9.text.toString().isEmpty()) {
                        ch9.text = "جوزة"
                        ch9.isChecked = false
                    }
                    customDialogR2SX.dismiss()
                }

                customDialogR2SX.show()
                homeModel.checkname9 += ch9.text.toString().trim()
                homeModel.editname9 += pricd9.text.toString().trim()
            } else {
                if (pricd9.text.toString().isNotEmpty()) {
                    viewModel.totalAmount -= pricd9.text.toString().toInt()
                    toolbar?.title =  viewModel.totalAmount.toString()
                    ch9.text = "جوزة"
                    pricd9.setText("")
                    homeModel.checkname9 =  ""
                    homeModel.editname9 =  ""
                } else {
                    ch9.text = "جوزة"
                }
            }
        }

        ch10.setOnCheckedChangeListener { _, isChecked ->
            if (ch10.isChecked) {

                customDialogR2SX.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
                customDialogR2SX.tit_r2s_out.text="علوية"
                customDialogR2SX.tit_r2s_in.text="سفلية"

                customDialogR2SX.card_r2s_2ks.setOnTouchListener { _, event ->
                    var x = 0f
                    var y = 0f
                    when (event.action) {
                        MotionEvent.ACTION_UP -> {
                            x = event.x
                            y = event.y
                        }
                        MotionEvent.ACTION_MOVE -> {
                            customDialogR2SX.window?.let {
                                val params: WindowManager.LayoutParams = it.attributes
                                params.x = event.rawX.toInt() - x.toInt()
                                params.y = event.rawY.toInt() - y.toInt()
                                it.attributes = params
                            }
                        }

                        MotionEvent.ACTION_UP -> {
                            customDialogR2SX.window?.let {
                                val params: WindowManager.LayoutParams = it.attributes
                                if (params.y < 0) {
                                    params.y = 0
                                    it.attributes = params
                                } else if (params.y > 2000) { // change this value to move up more
                                    params.y = 2000 // change this value to move up more
                                    it.attributes = params
                                }
                            }
                        }

                    }
                    true
                }

                customDialogR2SX.outsideright.setOnCheckedChangeListener { _, isChecked1 ->

                    if (customDialogR2SX.outsideright.isChecked) {
                        ch10.text = "بيضة علوية يمين"
                    } else {
                        ch10.text = "بيضة"
                        customDialogR2SX.s3er_r2s_acx.setText("")
                    }

                    if (customDialogR2SX.outsideright.isChecked && customDialogR2SX.outsideleft.isChecked && customDialogR2SX.insideright.isChecked && customDialogR2SX.insideleft.isChecked) {
                        ch10.text = "تغير جميع البيضات"
                        customDialogR2SX.s3er_r2s_acx.setText("20")
                    } else {
                        if (customDialogR2SX.outsideright.isChecked && customDialogR2SX.outsideleft.isChecked && customDialogR2SX.insideright.isChecked) {
                            ch10.text = "بيضتين علوية و السفلية يمين"
                            customDialogR2SX.s3er_r2s_acx.setText("15")
                        } else {
                            if (customDialogR2SX.outsideright.isChecked && customDialogR2SX.outsideleft.isChecked && customDialogR2SX.insideleft.isChecked) {
                                ch10.text = "بيضتين علوية و السفلية يسار"
                                customDialogR2SX.s3er_r2s_acx.setText("15")
                            } else {
                                if (customDialogR2SX.outsideright.isChecked && customDialogR2SX.insideright.isChecked && customDialogR2SX.insideleft.isChecked) {
                                    ch10.text = "بيضة علوية يمين و السفليتين"
                                    customDialogR2SX.s3er_r2s_acx.setText("15")
                                } else {
                                    if (customDialogR2SX.outsideleft.isChecked && customDialogR2SX.insideright.isChecked && customDialogR2SX.insideleft.isChecked) {
                                        ch10.text = "بيضة علوية يسار و السفليتين"
                                        customDialogR2SX.s3er_r2s_acx.setText("15")
                                    } else {
                                        if (customDialogR2SX.outsideright.isChecked && customDialogR2SX.outsideleft.isChecked) {
                                            ch10.text = "بيضة علوية يمين و يسار"
                                            customDialogR2SX.s3er_r2s_acx.setText("10")
                                        } else {
                                            if (customDialogR2SX.outsideright.isChecked && customDialogR2SX.insideright.isChecked) {
                                                ch10.text = "بيضة علوية يمين و السفلية يمين"
                                                customDialogR2SX.s3er_r2s_acx.setText("10")
                                            } else {
                                                if (customDialogR2SX.outsideright.isChecked && customDialogR2SX.insideleft.isChecked) {
                                                    ch10.text = "بيضة علوية يمين و السفلية يسار"
                                                    customDialogR2SX.s3er_r2s_acx.setText("10")
                                                } else {
                                                    if (customDialogR2SX.outsideleft.isChecked && customDialogR2SX.insideright.isChecked) {
                                                        ch10.text =
                                                            "بيضة علوية يسار و السفلية يمين"
                                                        customDialogR2SX.s3er_r2s_acx.setText("10")
                                                    } else {
                                                        if (customDialogR2SX.outsideleft.isChecked && customDialogR2SX.insideleft.isChecked) {
                                                            ch10.text =
                                                                "بيضة علوية يسار و السفلية يسار"
                                                            customDialogR2SX.s3er_r2s_acx.setText("10")
                                                        } else {
                                                            if (customDialogR2SX.insideright.isChecked && customDialogR2SX.insideleft.isChecked) {
                                                                ch10.text =
                                                                    "بيضة سفلية يمين و يسار"
                                                                customDialogR2SX.s3er_r2s_acx.setText(
                                                                    "10"
                                                                )
                                                            } else {

                                                                if (customDialogR2SX.outsideright.isChecked) {
                                                                    ch10.text =
                                                                        "بيضة علوية يمين"
                                                                    customDialogR2SX.s3er_r2s_acx.setText(
                                                                        "5"
                                                                    )
                                                                }
                                                                if (customDialogR2SX.outsideleft.isChecked) {
                                                                    ch10.text =
                                                                        "بيضة علوية يسار"
                                                                    customDialogR2SX.s3er_r2s_acx.setText(
                                                                        "5"
                                                                    )
                                                                }

                                                                if (customDialogR2SX.insideleft.isChecked) {
                                                                    ch10.text =
                                                                        "بيضة سفلية يسار"
                                                                    customDialogR2SX.s3er_r2s_acx.setText(
                                                                        "5"
                                                                    )
                                                                }
                                                                if (customDialogR2SX.insideright.isChecked) {
                                                                    ch10.text =
                                                                        "بيضة سفلية يمين"
                                                                    customDialogR2SX.s3er_r2s_acx.setText(
                                                                        "5"
                                                                    )
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                    customDialogR2SX.show()
                }



                customDialogR2SX.outsideleft.setOnCheckedChangeListener { _, isChecked2 ->
                    if (customDialogR2SX.outsideleft.isChecked) {
                        ch10.text = "بيضة علوية يسار"
                    } else {
                        ch10.text = "بيضة"
                        customDialogR2SX.s3er_r2s_acx.setText("")
                    }

                    if (customDialogR2SX.outsideright.isChecked && customDialogR2SX.outsideleft.isChecked && customDialogR2SX.insideright.isChecked && customDialogR2SX.insideleft.isChecked) {
                        ch10.text = "تغير جميع البيضات"
                        customDialogR2SX.s3er_r2s_acx.setText("20")
                    } else {
                        if (customDialogR2SX.outsideright.isChecked && customDialogR2SX.outsideleft.isChecked && customDialogR2SX.insideright.isChecked) {
                            ch10.text = "بيضتين علوية و السفلية يمين"
                            customDialogR2SX.s3er_r2s_acx.setText("15")
                        } else {
                            if (customDialogR2SX.outsideright.isChecked && customDialogR2SX.outsideleft.isChecked && customDialogR2SX.insideleft.isChecked) {
                                ch10.text = "بيضتين علوية و السفلية يسار"
                                customDialogR2SX.s3er_r2s_acx.setText("15")
                            } else {
                                if (customDialogR2SX.outsideright.isChecked && customDialogR2SX.insideright.isChecked && customDialogR2SX.insideleft.isChecked) {
                                    ch10.text = "بيضة علوية يمين و السفليتين"
                                    customDialogR2SX.s3er_r2s_acx.setText("15")
                                } else {
                                    if (customDialogR2SX.outsideleft.isChecked && customDialogR2SX.insideright.isChecked && customDialogR2SX.insideleft.isChecked) {
                                        ch10.text = "بيضة علوية يسار و السفليتين"
                                        customDialogR2SX.s3er_r2s_acx.setText("15")
                                    } else {
                                        if (customDialogR2SX.outsideright.isChecked && customDialogR2SX.outsideleft.isChecked) {
                                            ch10.text = "بيضة علوية يمين و يسار"
                                            customDialogR2SX.s3er_r2s_acx.setText("10")
                                        } else {
                                            if (customDialogR2SX.outsideright.isChecked && customDialogR2SX.insideright.isChecked) {
                                                ch10.text = "بيضة علوية يمين و السفلية يمين"
                                                customDialogR2SX.s3er_r2s_acx.setText("10")
                                            } else {
                                                if (customDialogR2SX.outsideright.isChecked && customDialogR2SX.insideleft.isChecked) {
                                                    ch10.text = "بيضة علوية يمين و السفلية يسار"
                                                    customDialogR2SX.s3er_r2s_acx.setText("10")
                                                } else {
                                                    if (customDialogR2SX.outsideleft.isChecked && customDialogR2SX.insideright.isChecked) {
                                                        ch10.text =
                                                            "بيضة علوية يسار و السفلية يمين"
                                                        customDialogR2SX.s3er_r2s_acx.setText("10")
                                                    } else {
                                                        if (customDialogR2SX.outsideleft.isChecked && customDialogR2SX.insideleft.isChecked) {
                                                            ch10.text =
                                                                "بيضة علوية يسار و السفلية يسار"
                                                            customDialogR2SX.s3er_r2s_acx.setText("10")
                                                        } else {
                                                            if (customDialogR2SX.insideright.isChecked && customDialogR2SX.insideleft.isChecked) {
                                                                ch10.text =
                                                                    "بيضة سفلية يمين و يسار"
                                                                customDialogR2SX.s3er_r2s_acx.setText(
                                                                    "10"
                                                                )
                                                            } else {

                                                                if (customDialogR2SX.outsideright.isChecked) {
                                                                    ch10.text =
                                                                        "بيضة علوية يمين"
                                                                    customDialogR2SX.s3er_r2s_acx.setText(
                                                                        "5"
                                                                    )
                                                                }
                                                                if (customDialogR2SX.outsideleft.isChecked) {
                                                                    ch10.text =
                                                                        "بيضة علوية يسار"
                                                                    customDialogR2SX.s3er_r2s_acx.setText(
                                                                        "5"
                                                                    )
                                                                }

                                                                if (customDialogR2SX.insideleft.isChecked) {
                                                                    ch10.text =
                                                                        "بيضة سفلية يسار"
                                                                    customDialogR2SX.s3er_r2s_acx.setText(
                                                                        "5"
                                                                    )
                                                                }
                                                                if (customDialogR2SX.insideright.isChecked) {
                                                                    ch10.text =
                                                                        "بيضة سفلية يمين"
                                                                    customDialogR2SX.s3er_r2s_acx.setText(
                                                                        "5"
                                                                    )
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                    customDialogR2SX.show()
                }



                customDialogR2SX.insideleft.setOnCheckedChangeListener { _, isChecked2 ->
                    if (customDialogR2SX.outsideright.isChecked) {
                        ch10.text = "بيضة سفلية يمين"
                    } else {
                        ch10.text = "بيضة"
                        customDialogR2SX.s3er_r2s_acx.setText("")
                    }

                    if (customDialogR2SX.outsideright.isChecked && customDialogR2SX.outsideleft.isChecked && customDialogR2SX.insideright.isChecked && customDialogR2SX.insideleft.isChecked) {
                        ch10.text = "تغير جميع البيضات"
                        customDialogR2SX.s3er_r2s_acx.setText("20")
                    } else {
                        if (customDialogR2SX.outsideright.isChecked && customDialogR2SX.outsideleft.isChecked && customDialogR2SX.insideright.isChecked) {
                            ch10.text = "بيضتين علوية و السفلية يمين"
                            customDialogR2SX.s3er_r2s_acx.setText("15")
                        } else {
                            if (customDialogR2SX.outsideright.isChecked && customDialogR2SX.outsideleft.isChecked && customDialogR2SX.insideleft.isChecked) {
                                ch10.text = "بيضتين علوية و السفلية يسار"
                                customDialogR2SX.s3er_r2s_acx.setText("15")
                            } else {
                                if (customDialogR2SX.outsideright.isChecked && customDialogR2SX.insideright.isChecked && customDialogR2SX.insideleft.isChecked) {
                                    ch10.text = "بيضة علوية يمين و السفليتين"
                                    customDialogR2SX.s3er_r2s_acx.setText("15")
                                } else {
                                    if (customDialogR2SX.outsideleft.isChecked && customDialogR2SX.insideright.isChecked && customDialogR2SX.insideleft.isChecked) {
                                        ch10.text = "بيضة علوية يسار و السفليتين"
                                        customDialogR2SX.s3er_r2s_acx.setText("15")
                                    } else {
                                        if (customDialogR2SX.outsideright.isChecked && customDialogR2SX.outsideleft.isChecked) {
                                            ch10.text = "بيضة علوية يمين و يسار"
                                            customDialogR2SX.s3er_r2s_acx.setText("10")
                                        } else {
                                            if (customDialogR2SX.outsideright.isChecked && customDialogR2SX.insideright.isChecked) {
                                                ch10.text = "بيضة علوية يمين و السفلية يمين"
                                                customDialogR2SX.s3er_r2s_acx.setText("10")
                                            } else {
                                                if (customDialogR2SX.outsideright.isChecked && customDialogR2SX.insideleft.isChecked) {
                                                    ch10.text = "بيضة علوية يمين و السفلية يسار"
                                                    customDialogR2SX.s3er_r2s_acx.setText("10")
                                                } else {
                                                    if (customDialogR2SX.outsideleft.isChecked && customDialogR2SX.insideright.isChecked) {
                                                        ch10.text =
                                                            "بيضة علوية يسار و السفلية يمين"
                                                        customDialogR2SX.s3er_r2s_acx.setText("10")
                                                    } else {
                                                        if (customDialogR2SX.outsideleft.isChecked && customDialogR2SX.insideleft.isChecked) {
                                                            ch10.text =
                                                                "بيضة علوية يسار و السفلية يسار"
                                                            customDialogR2SX.s3er_r2s_acx.setText("10")
                                                        } else {
                                                            if (customDialogR2SX.insideright.isChecked && customDialogR2SX.insideleft.isChecked) {
                                                                ch10.text =
                                                                    "بيضة سفلية يمين و يسار"
                                                                customDialogR2SX.s3er_r2s_acx.setText(
                                                                    "10"
                                                                )
                                                            } else {

                                                                if (customDialogR2SX.outsideright.isChecked) {
                                                                    ch10.text =
                                                                        "بيضة علوية يمين"
                                                                    customDialogR2SX.s3er_r2s_acx.setText(
                                                                        "5"
                                                                    )
                                                                }
                                                                if (customDialogR2SX.outsideleft.isChecked) {
                                                                    ch10.text =
                                                                        "بيضة علوية يسار"
                                                                    customDialogR2SX.s3er_r2s_acx.setText(
                                                                        "5"
                                                                    )
                                                                }

                                                                if (customDialogR2SX.insideleft.isChecked) {
                                                                    ch10.text =
                                                                        "بيضة سفلية يسار"
                                                                    customDialogR2SX.s3er_r2s_acx.setText(
                                                                        "5"
                                                                    )
                                                                }
                                                                if (customDialogR2SX.insideright.isChecked) {
                                                                    ch10.text =
                                                                        "بيضة سفلية يمين"
                                                                    customDialogR2SX.s3er_r2s_acx.setText(
                                                                        "5"
                                                                    )
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }

                    customDialogR2SX.show()
                }

                customDialogR2SX.insideright.setOnCheckedChangeListener { _, isChecked2 ->
                    if (customDialogR2SX.outsideright.isChecked) {
                        ch10.text = "بيضة سفلية يمين"
                    } else {
                        ch10.text = "بيضة"
                        customDialogR2SX.s3er_r2s_acx.setText("")
                    }

                    if (customDialogR2SX.outsideright.isChecked && customDialogR2SX.outsideleft.isChecked && customDialogR2SX.insideright.isChecked && customDialogR2SX.insideleft.isChecked) {
                        ch10.text = "تغير جميع البيضات"
                        customDialogR2SX.s3er_r2s_acx.setText("20")
                    } else {
                        if (customDialogR2SX.outsideright.isChecked && customDialogR2SX.outsideleft.isChecked && customDialogR2SX.insideright.isChecked) {
                            ch10.text = "بيضتين علوية و السفلية يمين"
                            customDialogR2SX.s3er_r2s_acx.setText("15")
                        } else {
                            if (customDialogR2SX.outsideright.isChecked && customDialogR2SX.outsideleft.isChecked && customDialogR2SX.insideleft.isChecked) {
                                ch10.text = "بيضتين علوية و السفلية يسار"
                                customDialogR2SX.s3er_r2s_acx.setText("15")
                            } else {
                                if (customDialogR2SX.outsideright.isChecked && customDialogR2SX.insideright.isChecked && customDialogR2SX.insideleft.isChecked) {
                                    ch10.text = "بيضة علوية يمين و السفليتين"
                                    customDialogR2SX.s3er_r2s_acx.setText("15")
                                } else {
                                    if (customDialogR2SX.outsideleft.isChecked && customDialogR2SX.insideright.isChecked && customDialogR2SX.insideleft.isChecked) {
                                        ch10.text = "بيضة علوية يسار و السفليتين"
                                        customDialogR2SX.s3er_r2s_acx.setText("15")
                                    } else {
                                        if (customDialogR2SX.outsideright.isChecked && customDialogR2SX.outsideleft.isChecked) {
                                            ch10.text = "بيضة علوية يمين و يسار"
                                            customDialogR2SX.s3er_r2s_acx.setText("10")
                                        } else {
                                            if (customDialogR2SX.outsideright.isChecked && customDialogR2SX.insideright.isChecked) {
                                                ch10.text = "بيضة علوية يمين و السفلية يمين"
                                                customDialogR2SX.s3er_r2s_acx.setText("10")
                                            } else {
                                                if (customDialogR2SX.outsideright.isChecked && customDialogR2SX.insideleft.isChecked) {
                                                    ch10.text = "بيضة علوية يمين و السفلية يسار"
                                                    customDialogR2SX.s3er_r2s_acx.setText("10")
                                                } else {
                                                    if (customDialogR2SX.outsideleft.isChecked && customDialogR2SX.insideright.isChecked) {
                                                        ch10.text =
                                                            "بيضة علوية يسار و السفلية يمين"
                                                        customDialogR2SX.s3er_r2s_acx.setText("10")
                                                    } else {
                                                        if (customDialogR2SX.outsideleft.isChecked && customDialogR2SX.insideleft.isChecked) {
                                                            ch10.text =
                                                                "بيضة علوية يسار و السفلية يسار"
                                                            customDialogR2SX.s3er_r2s_acx.setText("10")
                                                        } else {
                                                            if (customDialogR2SX.insideright.isChecked && customDialogR2SX.insideleft.isChecked) {
                                                                ch10.text =
                                                                    "بيضة سفلية يمين و يسار"
                                                                customDialogR2SX.s3er_r2s_acx.setText(
                                                                    "10"
                                                                )
                                                            } else {

                                                                if (customDialogR2SX.outsideright.isChecked) {
                                                                    ch10.text =
                                                                        "بيضة علوية يمين"
                                                                    customDialogR2SX.s3er_r2s_acx.setText(
                                                                        "5"
                                                                    )
                                                                }
                                                                if (customDialogR2SX.outsideleft.isChecked) {
                                                                    ch10.text =
                                                                        "بيضة علوية يسار"
                                                                    customDialogR2SX.s3er_r2s_acx.setText(
                                                                        "5"
                                                                    )
                                                                }

                                                                if (customDialogR2SX.insideleft.isChecked) {
                                                                    ch10.text =
                                                                        "بيضة سفلية يسار"
                                                                    customDialogR2SX.s3er_r2s_acx.setText(
                                                                        "5"
                                                                    )
                                                                }
                                                                if (customDialogR2SX.insideright.isChecked) {
                                                                    ch10.text =
                                                                        "بيضة سفلية يمين"
                                                                    customDialogR2SX.s3er_r2s_acx.setText(
                                                                        "5"
                                                                    )
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                    customDialogR2SX.show()
                }


                customDialogR2SX.btn_r2s_sav.setOnClickListener {
                    if (!customDialogR2SX.outsideright.isChecked && !customDialogR2SX.outsideleft.isChecked
                        && !customDialogR2SX.insideright.isChecked && !customDialogR2SX.insideleft.isChecked
                    ) {
                        toast_notempty1.show()
                    } else {
                        if (customDialogR2SX.s3er_r2s_acx.text.toString().trim().isEmpty()) {
                            toast_notempty.show()
//                            ch10.isChecked = false
                        } else {
                            editTextNumber10.text = customDialogR2SX.s3er_r2s_acx.text.toString()
                            viewModel.totalAmount += editTextNumber10.text.toString().toInt()
                            toolbar?.title =  viewModel.totalAmount.toString()
                            customDialogR2SX.dismiss()
                        }
                    }
                }
                customDialogR2SX.btn_r2s_can.setOnClickListener {
                    if (editTextNumber10.text.toString().isEmpty()) {
                        ch10.text = "بيضة"
                        ch10.isChecked = false
                    }
                    customDialogR2SX.dismiss()
                }

                customDialogR2SX.show()
                homeModel.checkname10 += ch10.text.toString().trim()
                homeModel.editname10 += editTextNumber10.text.toString().trim()
            } else {
                if (editTextNumber10.text.toString().isNotEmpty()) {
                    viewModel.totalAmount -= editTextNumber10.text.toString().toInt()
                    toolbar?.title =  viewModel.totalAmount.toString()
                    ch10.text = "بيضة"
                    editTextNumber10.setText("")
                    homeModel.checkname10 =  ""
                    homeModel.editname10 =  ""
                } else {
                    ch10.text = "بيضة"
                }
            }
        }

        ch11.setOnCheckedChangeListener { _, isChecked ->
            if (ch11.isChecked) {

                val window = customDialogFR.window
                window?.setGravity(Gravity.TOP)
                val lp = window?.attributes
                lp?.dimAmount = 0.0f
                lp?.flags = lp?.flags?.or(WindowManager.LayoutParams.FLAG_DIM_BEHIND)
                window?.attributes = lp

                customDialogFR.frontright.setOnCheckedChangeListener { _, isChecked1 ->
                    if (customDialogFR.frontright.isChecked) {
                        ch11.text = "شمزة اكس يمين"
                    } else {
                        ch11.text = "شمزة اكس"
                        customDialogFR.s3er_yadwee.setText("")
                    }
                    if (customDialogFR.frontright.isChecked && customDialogFR.frontleft.isChecked) {
                        ch11.text = "شمزة اكس يمين و يسار"
                        customDialogFR.s3er_yadwee.setText("10")
                    } else {
                        if (customDialogFR.frontright.isChecked) {
                            ch11.text = "شمزة اكس يمين"
                            customDialogFR.s3er_yadwee.setText("5")
                        }
                        if (customDialogFR.frontleft.isChecked) {
                            ch11.text = "شمزة اكس يسار"
                            customDialogFR.s3er_yadwee.setText("5")
                        }
                    }
                }

                customDialogFR.frontleft.setOnCheckedChangeListener { _, isChecked2 ->
                    if (customDialogFR.frontleft.isChecked) {
                        ch11.text = "شمزة اكس يسار"
                    } else {
                        ch11.text = "شمزة اكس"
                        customDialogFR.s3er_yadwee.setText("")
                    }
                    if (customDialogFR.frontright.isChecked && customDialogFR.frontleft.isChecked) {
                        ch11.text = "شمزة اكس يمين و يسار"
                        customDialogFR.s3er_yadwee.setText("10")
                    } else {
                        if (customDialogFR.frontleft.isChecked) {
                            ch11.text = "شمزة اكس يسار"
                            customDialogFR.s3er_yadwee.setText("5")
                        }
                        if (customDialogFR.frontright.isChecked) {
                            ch11.text = "شمزة اكس يمين"
                            customDialogFR.s3er_yadwee.setText("5")
                        }
                    }
                }

                customDialogFR.button_dailog_save.setOnClickListener {
                    if (!customDialogFR.frontright.isChecked && !customDialogFR.frontleft.isChecked) {
                        toast_notempty1.show()
                    } else {
                        if (customDialogFR.s3er_yadwee.text.toString().trim().isEmpty()) {
                            toast_notempty.show()
                            ch11.isChecked = false
                        } else {
                            editTextNumber11.text = customDialogFR.s3er_yadwee.text.toString()
                            viewModel.totalAmount += editTextNumber11.text.toString().toInt()
                            toolbar?.title =  viewModel.totalAmount.toString()
                            customDialogFR.dismiss()
                        }
                    }
                }
                customDialogFR.button_dailog_cancel.setOnClickListener {
                    ch11.isChecked = false
                    customDialogFR.s3er_yadwee.setText("")
                    customDialogFR.dismiss()
                }
                customDialogFR.show()
                homeModel.checkname11 += ch11.text.toString().trim()
                homeModel.editname11 += editTextNumber11.text.toString().trim()
            }
            else {
                if (editTextNumber11.text.toString().isNotEmpty()){
                    viewModel.totalAmount -= editTextNumber11.text.toString().toInt()
                    toolbar?.title =  viewModel.totalAmount.toString()
                    editTextNumber11.text = ""
                    homeModel.checkname11 =  ""
                    homeModel.editname11 =  ""
                }
                ch11.text = "شمزة اكس"
            }
        }

        ch12.setOnCheckedChangeListener { _, isChecked ->
            if (ch12.isChecked) {

                customDialogR2SX.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

                customDialogR2SX.card_r2s_2ks.setOnTouchListener { _, event ->
                    var x = 0f
                    var y = 0f
                    when (event.action) {
                        MotionEvent.ACTION_UP -> {
                            x = event.x
                            y = event.y
                        }
                        MotionEvent.ACTION_MOVE -> {
                            customDialogR2SX.window?.let {
                                val params: WindowManager.LayoutParams = it.attributes
                                params.x = event.rawX.toInt() - x.toInt()
                                params.y = event.rawY.toInt() - y.toInt()
                                it.attributes = params
                            }
                        }

                        MotionEvent.ACTION_UP -> {
                            customDialogR2SX.window?.let {
                                val params: WindowManager.LayoutParams = it.attributes
                                if (params.y < 0) {
                                    params.y = 0
                                    it.attributes = params
                                } else if (params.y > 2000) { // change this value to move up more
                                    params.y = 2000 // change this value to move up more
                                    it.attributes = params
                                }
                            }
                        }

                    }
                    true
                }

                customDialogR2SX.outsideright.setOnCheckedChangeListener { _, isChecked1 ->

                    if (customDialogR2SX.outsideright.isChecked) {
                        ch12.text = "عمود توازن جوزة امامي يمين"
                    } else {
                        ch12.text = "عمود توازن جوزة"
                        customDialogR2SX.s3er_r2s_acx.setText("")
                    }

                    if (customDialogR2SX.outsideright.isChecked && customDialogR2SX.outsideleft.isChecked && customDialogR2SX.insideright.isChecked && customDialogR2SX.insideleft.isChecked) {
                        ch12.text = "تغير جميع عمدان توازن جوزة"
                        customDialogR2SX.s3er_r2s_acx.setText("12")
                    } else {
                        if (customDialogR2SX.outsideright.isChecked && customDialogR2SX.outsideleft.isChecked && customDialogR2SX.insideright.isChecked) {
                            ch12.text = "عمدان توازن جوزة امامي و الخلفي يمين"
                            customDialogR2SX.s3er_r2s_acx.setText("9")
                        } else {
                            if (customDialogR2SX.outsideright.isChecked && customDialogR2SX.outsideleft.isChecked && customDialogR2SX.insideleft.isChecked) {
                                ch12.text = "عمدان توازن جوزة امامي و الخلفي يسار"
                                customDialogR2SX.s3er_r2s_acx.setText("9")
                            } else {
                                if (customDialogR2SX.outsideright.isChecked && customDialogR2SX.insideright.isChecked && customDialogR2SX.insideleft.isChecked) {
                                    ch12.text = "عمود توازن جوزة امامي يمين و الخلفيين"
                                    customDialogR2SX.s3er_r2s_acx.setText("9")
                                } else {
                                    if (customDialogR2SX.outsideleft.isChecked && customDialogR2SX.insideright.isChecked && customDialogR2SX.insideleft.isChecked) {
                                        ch12.text = "عمود توازن جوزة امامي يسار و الخلفيين"
                                        customDialogR2SX.s3er_r2s_acx.setText("9")
                                    } else {
                                        if (customDialogR2SX.outsideright.isChecked && customDialogR2SX.outsideleft.isChecked) {
                                            ch12.text = "عمود توازن جوزة امامي يمين و يسار"
                                            customDialogR2SX.s3er_r2s_acx.setText("6")
                                        } else {
                                            if (customDialogR2SX.outsideright.isChecked && customDialogR2SX.insideright.isChecked) {
                                                ch12.text = "عمود توازن جوزة امامي يمين و الخلفي يمين"
                                                customDialogR2SX.s3er_r2s_acx.setText("6")
                                            } else {
                                                if (customDialogR2SX.outsideright.isChecked && customDialogR2SX.insideleft.isChecked) {
                                                    ch12.text = "عمود توازن جوزة امامي يمين و الخلفي يسار"
                                                    customDialogR2SX.s3er_r2s_acx.setText("6")
                                                } else {
                                                    if (customDialogR2SX.outsideleft.isChecked && customDialogR2SX.insideright.isChecked) {
                                                        ch12.text =
                                                            "عمود توازن جوزة امامي يسار و الخلفي يمين"
                                                        customDialogR2SX.s3er_r2s_acx.setText("6")
                                                    } else {
                                                        if (customDialogR2SX.outsideleft.isChecked && customDialogR2SX.insideleft.isChecked) {
                                                            ch12.text =
                                                                "عمود توازن جوزة امامي يسار و الخلفي يسار"
                                                            customDialogR2SX.s3er_r2s_acx.setText("6")
                                                        } else {
                                                            if (customDialogR2SX.insideright.isChecked && customDialogR2SX.insideleft.isChecked) {
                                                                ch12.text =
                                                                    "عمود توازن جوزة خلفي يمين و يسار"
                                                                customDialogR2SX.s3er_r2s_acx.setText(
                                                                    "6"
                                                                )
                                                            } else {

                                                                if (customDialogR2SX.outsideright.isChecked) {
                                                                    ch12.text =
                                                                        "عمود توازن جوزة امامي يمين"
                                                                    customDialogR2SX.s3er_r2s_acx.setText(
                                                                        "3"
                                                                    )
                                                                }
                                                                if (customDialogR2SX.outsideleft.isChecked) {
                                                                    ch12.text =
                                                                        "عمود توازن جوزة امامي يسار"
                                                                    customDialogR2SX.s3er_r2s_acx.setText(
                                                                        "3"
                                                                    )
                                                                }

                                                                if (customDialogR2SX.insideleft.isChecked) {
                                                                    ch12.text =
                                                                        "عمود توازن جوزة خلفي يسار"
                                                                    customDialogR2SX.s3er_r2s_acx.setText(
                                                                        "3"
                                                                    )
                                                                }
                                                                if (customDialogR2SX.insideright.isChecked) {
                                                                    ch12.text =
                                                                        "عمود توازن جوزة خلفي يمين"
                                                                    customDialogR2SX.s3er_r2s_acx.setText(
                                                                        "3"
                                                                    )
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                    customDialogR2SX.show()
                }



                customDialogR2SX.outsideleft.setOnCheckedChangeListener { _, isChecked2 ->
                    if (customDialogR2SX.outsideleft.isChecked) {
                        ch12.text = "عمود توازن جوزة امامي يمين"
                    } else {
                        ch12.text = "عمود توازن جوزة"
                        customDialogR2SX.s3er_r2s_acx.setText("")
                    }

                    if (customDialogR2SX.outsideright.isChecked && customDialogR2SX.outsideleft.isChecked && customDialogR2SX.insideright.isChecked && customDialogR2SX.insideleft.isChecked) {
                        ch12.text = "تغير جميع عمدان توازن جوزة"
                        customDialogR2SX.s3er_r2s_acx.setText("12")
                    } else {
                        if (customDialogR2SX.outsideright.isChecked && customDialogR2SX.outsideleft.isChecked && customDialogR2SX.insideright.isChecked) {
                            ch12.text = "عمدان توازن جوزة امامي و الخلفي يمين"
                            customDialogR2SX.s3er_r2s_acx.setText("9")
                        } else {
                            if (customDialogR2SX.outsideright.isChecked && customDialogR2SX.outsideleft.isChecked && customDialogR2SX.insideleft.isChecked) {
                                ch12.text = "عمدان توازن جوزة امامي و الخلفي يسار"
                                customDialogR2SX.s3er_r2s_acx.setText("9")
                            } else {
                                if (customDialogR2SX.outsideright.isChecked && customDialogR2SX.insideright.isChecked && customDialogR2SX.insideleft.isChecked) {
                                    ch12.text = "عمود توازن جوزة امامي يمين و الخلفيين"
                                    customDialogR2SX.s3er_r2s_acx.setText("9")
                                } else {
                                    if (customDialogR2SX.outsideleft.isChecked && customDialogR2SX.insideright.isChecked && customDialogR2SX.insideleft.isChecked) {
                                        ch12.text = "عمود توازن جوزة امامي يسار و الخلفيين"
                                        customDialogR2SX.s3er_r2s_acx.setText("9")
                                    } else {
                                        if (customDialogR2SX.outsideright.isChecked && customDialogR2SX.outsideleft.isChecked) {
                                            ch12.text = "عمود توازن جوزة امامي يمين و يسار"
                                            customDialogR2SX.s3er_r2s_acx.setText("6")
                                        } else {
                                            if (customDialogR2SX.outsideright.isChecked && customDialogR2SX.insideright.isChecked) {
                                                ch12.text = "عمود توازن جوزة امامي يمين و الخلفي يمين"
                                                customDialogR2SX.s3er_r2s_acx.setText("6")
                                            } else {
                                                if (customDialogR2SX.outsideright.isChecked && customDialogR2SX.insideleft.isChecked) {
                                                    ch12.text = "عمود توازن جوزة امامي يمين و الخلفي يسار"
                                                    customDialogR2SX.s3er_r2s_acx.setText("6")
                                                } else {
                                                    if (customDialogR2SX.outsideleft.isChecked && customDialogR2SX.insideright.isChecked) {
                                                        ch12.text =
                                                            "عمود توازن جوزة امامي يسار و الخلفي يمين"
                                                        customDialogR2SX.s3er_r2s_acx.setText("6")
                                                    } else {
                                                        if (customDialogR2SX.outsideleft.isChecked && customDialogR2SX.insideleft.isChecked) {
                                                            ch12.text =
                                                                "عمود توازن جوزة امامي يسار و الخلفي يسار"
                                                            customDialogR2SX.s3er_r2s_acx.setText("6")
                                                        } else {
                                                            if (customDialogR2SX.insideright.isChecked && customDialogR2SX.insideleft.isChecked) {
                                                                ch12.text =
                                                                    "عمود توازن جوزة خلفي يمين و يسار"
                                                                customDialogR2SX.s3er_r2s_acx.setText(
                                                                    "6"
                                                                )
                                                            } else {

                                                                if (customDialogR2SX.outsideright.isChecked) {
                                                                    ch12.text =
                                                                        "عمود توازن جوزة امامي يمين"
                                                                    customDialogR2SX.s3er_r2s_acx.setText(
                                                                        "3"
                                                                    )
                                                                }
                                                                if (customDialogR2SX.outsideleft.isChecked) {
                                                                    ch12.text =
                                                                        "عمود توازن جوزة امامي يسار"
                                                                    customDialogR2SX.s3er_r2s_acx.setText(
                                                                        "3"
                                                                    )
                                                                }

                                                                if (customDialogR2SX.insideleft.isChecked) {
                                                                    ch12.text =
                                                                        "عمود توازن جوزة خلفي يسار"
                                                                    customDialogR2SX.s3er_r2s_acx.setText(
                                                                        "3"
                                                                    )
                                                                }
                                                                if (customDialogR2SX.insideright.isChecked) {
                                                                    ch12.text =
                                                                        "عمود توازن جوزة خلفي يمين"
                                                                    customDialogR2SX.s3er_r2s_acx.setText(
                                                                        "3"
                                                                    )
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                    customDialogR2SX.show()
                }



                customDialogR2SX.insideleft.setOnCheckedChangeListener { _, isChecked2 ->
                    if (customDialogR2SX.outsideright.isChecked) {
                        ch12.text = "عمود توازن جوزة امامي يمين"
                    } else {
                        ch12.text = "عمود توازن جوزة"
                        customDialogR2SX.s3er_r2s_acx.setText("")
                    }

                    if (customDialogR2SX.outsideright.isChecked && customDialogR2SX.outsideleft.isChecked && customDialogR2SX.insideright.isChecked && customDialogR2SX.insideleft.isChecked) {
                        ch12.text = "تغير جميع عمدان توازن جوزة"
                        customDialogR2SX.s3er_r2s_acx.setText("12")
                    } else {
                        if (customDialogR2SX.outsideright.isChecked && customDialogR2SX.outsideleft.isChecked && customDialogR2SX.insideright.isChecked) {
                            ch12.text = "عمدان توازن جوزة امامي و الخلفي يمين"
                            customDialogR2SX.s3er_r2s_acx.setText("9")
                        } else {
                            if (customDialogR2SX.outsideright.isChecked && customDialogR2SX.outsideleft.isChecked && customDialogR2SX.insideleft.isChecked) {
                                ch12.text = "عمدان توازن جوزة امامي و الخلفي يسار"
                                customDialogR2SX.s3er_r2s_acx.setText("9")
                            } else {
                                if (customDialogR2SX.outsideright.isChecked && customDialogR2SX.insideright.isChecked && customDialogR2SX.insideleft.isChecked) {
                                    ch12.text = "عمود توازن جوزة امامي يمين و الخلفيين"
                                    customDialogR2SX.s3er_r2s_acx.setText("9")
                                } else {
                                    if (customDialogR2SX.outsideleft.isChecked && customDialogR2SX.insideright.isChecked && customDialogR2SX.insideleft.isChecked) {
                                        ch12.text = "عمود توازن جوزة امامي يسار و الخلفيين"
                                        customDialogR2SX.s3er_r2s_acx.setText("9")
                                    } else {
                                        if (customDialogR2SX.outsideright.isChecked && customDialogR2SX.outsideleft.isChecked) {
                                            ch12.text = "عمود توازن جوزة امامي يمين و يسار"
                                            customDialogR2SX.s3er_r2s_acx.setText("6")
                                        } else {
                                            if (customDialogR2SX.outsideright.isChecked && customDialogR2SX.insideright.isChecked) {
                                                ch12.text = "عمود توازن جوزة امامي يمين و الخلفي يمين"
                                                customDialogR2SX.s3er_r2s_acx.setText("6")
                                            } else {
                                                if (customDialogR2SX.outsideright.isChecked && customDialogR2SX.insideleft.isChecked) {
                                                    ch12.text = "عمود توازن جوزة امامي يمين و الخلفي يسار"
                                                    customDialogR2SX.s3er_r2s_acx.setText("6")
                                                } else {
                                                    if (customDialogR2SX.outsideleft.isChecked && customDialogR2SX.insideright.isChecked) {
                                                        ch12.text =
                                                            "عمود توازن جوزة امامي يسار و الخلفي يمين"
                                                        customDialogR2SX.s3er_r2s_acx.setText("6")
                                                    } else {
                                                        if (customDialogR2SX.outsideleft.isChecked && customDialogR2SX.insideleft.isChecked) {
                                                            ch12.text =
                                                                "عمود توازن جوزة امامي يسار و الخلفي يسار"
                                                            customDialogR2SX.s3er_r2s_acx.setText("6")
                                                        } else {
                                                            if (customDialogR2SX.insideright.isChecked && customDialogR2SX.insideleft.isChecked) {
                                                                ch12.text =
                                                                    "عمود توازن جوزة خلفي يمين و يسار"
                                                                customDialogR2SX.s3er_r2s_acx.setText(
                                                                    "6"
                                                                )
                                                            } else {

                                                                if (customDialogR2SX.outsideright.isChecked) {
                                                                    ch12.text =
                                                                        "عمود توازن جوزة امامي يمين"
                                                                    customDialogR2SX.s3er_r2s_acx.setText(
                                                                        "3"
                                                                    )
                                                                }
                                                                if (customDialogR2SX.outsideleft.isChecked) {
                                                                    ch12.text =
                                                                        "عمود توازن جوزة امامي يسار"
                                                                    customDialogR2SX.s3er_r2s_acx.setText(
                                                                        "3"
                                                                    )
                                                                }

                                                                if (customDialogR2SX.insideleft.isChecked) {
                                                                    ch12.text =
                                                                        "عمود توازن جوزة خلفي يسار"
                                                                    customDialogR2SX.s3er_r2s_acx.setText(
                                                                        "3"
                                                                    )
                                                                }
                                                                if (customDialogR2SX.insideright.isChecked) {
                                                                    ch12.text =
                                                                        "عمود توازن جوزة خلفي يمين"
                                                                    customDialogR2SX.s3er_r2s_acx.setText(
                                                                        "3"
                                                                    )
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }

                    customDialogR2SX.show()
                }

                customDialogR2SX.insideright.setOnCheckedChangeListener { _, isChecked2 ->
                    if (customDialogR2SX.outsideright.isChecked) {
                        ch12.text = "عمود توازن جوزة امامي يمين"
                    } else {
                        ch12.text = "عمود توازن جوزة"
                        customDialogR2SX.s3er_r2s_acx.setText("")
                    }

                    if (customDialogR2SX.outsideright.isChecked && customDialogR2SX.outsideleft.isChecked && customDialogR2SX.insideright.isChecked && customDialogR2SX.insideleft.isChecked) {
                        ch12.text = "تغير جميع عمدان توازن جوزة"
                        customDialogR2SX.s3er_r2s_acx.setText("12")
                    } else {
                        if (customDialogR2SX.outsideright.isChecked && customDialogR2SX.outsideleft.isChecked && customDialogR2SX.insideright.isChecked) {
                            ch12.text = "عمدان توازن جوزة امامي و الخلفي يمين"
                            customDialogR2SX.s3er_r2s_acx.setText("9")
                        } else {
                            if (customDialogR2SX.outsideright.isChecked && customDialogR2SX.outsideleft.isChecked && customDialogR2SX.insideleft.isChecked) {
                                ch12.text = "عمدان توازن جوزة امامي و الخلفي يسار"
                                customDialogR2SX.s3er_r2s_acx.setText("9")
                            } else {
                                if (customDialogR2SX.outsideright.isChecked && customDialogR2SX.insideright.isChecked && customDialogR2SX.insideleft.isChecked) {
                                    ch12.text = "عمود توازن جوزة امامي يمين و الخلفيين"
                                    customDialogR2SX.s3er_r2s_acx.setText("9")
                                } else {
                                    if (customDialogR2SX.outsideleft.isChecked && customDialogR2SX.insideright.isChecked && customDialogR2SX.insideleft.isChecked) {
                                        ch12.text = "عمود توازن جوزة امامي يسار و الخلفيين"
                                        customDialogR2SX.s3er_r2s_acx.setText("9")
                                    } else {
                                        if (customDialogR2SX.outsideright.isChecked && customDialogR2SX.outsideleft.isChecked) {
                                            ch12.text = "عمود توازن جوزة امامي يمين و يسار"
                                            customDialogR2SX.s3er_r2s_acx.setText("6")
                                        } else {
                                            if (customDialogR2SX.outsideright.isChecked && customDialogR2SX.insideright.isChecked) {
                                                ch12.text = "عمود توازن جوزة امامي يمين و الخلفي يمين"
                                                customDialogR2SX.s3er_r2s_acx.setText("6")
                                            } else {
                                                if (customDialogR2SX.outsideright.isChecked && customDialogR2SX.insideleft.isChecked) {
                                                    ch12.text = "عمود توازن جوزة امامي يمين و الخلفي يسار"
                                                    customDialogR2SX.s3er_r2s_acx.setText("6")
                                                } else {
                                                    if (customDialogR2SX.outsideleft.isChecked && customDialogR2SX.insideright.isChecked) {
                                                        ch12.text =
                                                            "عمود توازن جوزة امامي يسار و الخلفي يمين"
                                                        customDialogR2SX.s3er_r2s_acx.setText("6")
                                                    } else {
                                                        if (customDialogR2SX.outsideleft.isChecked && customDialogR2SX.insideleft.isChecked) {
                                                            ch12.text =
                                                                "عمود توازن جوزة امامي يسار و الخلفي يسار"
                                                            customDialogR2SX.s3er_r2s_acx.setText("6")
                                                        } else {
                                                            if (customDialogR2SX.insideright.isChecked && customDialogR2SX.insideleft.isChecked) {
                                                                ch12.text =
                                                                    "عمود توازن جوزة خلفي يمين و يسار"
                                                                customDialogR2SX.s3er_r2s_acx.setText(
                                                                    "6"
                                                                )
                                                            } else {

                                                                if (customDialogR2SX.outsideright.isChecked) {
                                                                    ch12.text =
                                                                        "عمود توازن جوزة امامي يمين"
                                                                    customDialogR2SX.s3er_r2s_acx.setText(
                                                                        "3"
                                                                    )
                                                                }
                                                                if (customDialogR2SX.outsideleft.isChecked) {
                                                                    ch12.text =
                                                                        "عمود توازن جوزة امامي يسار"
                                                                    customDialogR2SX.s3er_r2s_acx.setText(
                                                                        "3"
                                                                    )
                                                                }

                                                                if (customDialogR2SX.insideleft.isChecked) {
                                                                    ch12.text =
                                                                        "عمود توازن جوزة خلفي يسار"
                                                                    customDialogR2SX.s3er_r2s_acx.setText(
                                                                        "3"
                                                                    )
                                                                }
                                                                if (customDialogR2SX.insideright.isChecked) {
                                                                    ch12.text =
                                                                        "عمود توازن جوزة خلفي يمين"
                                                                    customDialogR2SX.s3er_r2s_acx.setText(
                                                                        "3"
                                                                    )
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                    customDialogR2SX.show()
                }


                customDialogR2SX.btn_r2s_sav.setOnClickListener {
                    if (!customDialogR2SX.outsideright.isChecked && !customDialogR2SX.outsideleft.isChecked
                        && !customDialogR2SX.insideright.isChecked && !customDialogR2SX.insideleft.isChecked
                    ) {
                        toast_notempty1.show()
                    } else {
                        if (customDialogR2SX.s3er_r2s_acx.text.toString().trim().isEmpty()) {
                            toast_notempty.show()
                        } else {
                            editTextNumber12.text = customDialogR2SX.s3er_r2s_acx.text.toString()
                            viewModel.totalAmount += editTextNumber12.text.toString().toInt()
                            toolbar?.title =  viewModel.totalAmount.toString()
                            customDialogR2SX.dismiss()
                        }
                    }
                }
                customDialogR2SX.btn_r2s_can.setOnClickListener {
                    if (editTextNumber12.text.toString().isEmpty()) {
                        ch12.text = "عمود توازن جوزة"
                        ch12.isChecked = false
                    }
                    customDialogR2SX.dismiss()
                }

                customDialogR2SX.show()
                homeModel.checkname12 += ch12.text.toString().trim()
                homeModel.editname12 += editTextNumber12.text.toString().trim()
            } else {
                if (editTextNumber12.text.toString().isNotEmpty()) {
                    viewModel.totalAmount -= editTextNumber12.text.toString().toInt()
                    toolbar?.title =  viewModel.totalAmount.toString()
                    ch12.text = "عمود توازن جوزة"
                    editTextNumber12.setText("")
                    homeModel.checkname12 =  ""
                    homeModel.editname12 =  ""
                } else {
                    ch12.text = "عمود توازن جوزة"
                }
            }
        }

        ch13.setOnCheckedChangeListener { _, isChecked ->
            if (ch13.isChecked) {

                customDialogF79.s3er_yadwee_fa7.setText("10")

                customDialogF79.btn_sv_dig_fa7.setOnClickListener {
                    if (customDialogF79.s3er_yadwee_fa7.text.toString().isEmpty()) {
                        toast_notempty.show()
                    } else {
                        editTextNumber13.text = customDialogF79.s3er_yadwee_fa7.text.toString()
                        viewModel.totalAmount += editTextNumber13.text.toString().toInt()
                        toolbar?.title =  viewModel.totalAmount.toString()
                        customDialogF79.dismiss()
                    }
                }
                customDialogF79.show()
                homeModel.checkname13 += ch13.text.toString().trim()
                homeModel.editname13 += editTextNumber13.text.toString().trim()
            } else {
                viewModel.totalAmount -= editTextNumber13.text.toString().toInt()
                toolbar?.title =  viewModel.totalAmount.toString()
                editTextNumber13.text = ""
                homeModel.checkname13 =  ""
                homeModel.editname13 =  ""
            }
        }

        ch14.setOnCheckedChangeListener { _, isChecked ->
            if (ch14.isChecked) {

                customDialogR2SX.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
                customDialogR2SX.tit_r2s_out.text="امامي"
                customDialogR2SX.tit_r2s_in.text="خلفي"


                customDialogR2SX.card_r2s_2ks.setOnTouchListener { _, event ->
                    var x = 0f
                    var y = 0f
                    when (event.action) {
                        MotionEvent.ACTION_UP -> {
                            x = event.x
                            y = event.y
                        }
                        MotionEvent.ACTION_MOVE -> {
                            customDialogR2SX.window?.let {
                                val params: WindowManager.LayoutParams = it.attributes
                                params.x = event.rawX.toInt() - x.toInt()
                                params.y = event.rawY.toInt() - y.toInt()
                                it.attributes = params
                            }
                        }

                        MotionEvent.ACTION_UP -> {
                            customDialogR2SX.window?.let {
                                val params: WindowManager.LayoutParams = it.attributes
                                if (params.y < 0) {
                                    params.y = 0
                                    it.attributes = params
                                } else if (params.y > 2000) { // change this value to move up more
                                    params.y = 2000 // change this value to move up more
                                    it.attributes = params
                                }
                            }
                        }

                    }
                    true
                }

                customDialogR2SX.outsideright.setOnCheckedChangeListener { _, isChecked1 ->

                    if (customDialogR2SX.outsideright.isChecked) {
                        ch14.text = "هب امامي يمين"
                    } else {
                        ch14.text = "هب"
                        customDialogR2SX.s3er_r2s_acx.setText("")
                    }

                    if (customDialogR2SX.outsideright.isChecked && customDialogR2SX.outsideleft.isChecked && customDialogR2SX.insideright.isChecked && customDialogR2SX.insideleft.isChecked) {
                        ch14.text = "تغير جميع الهبات"
                        customDialogR2SX.s3er_r2s_acx.setText("40")
                    } else {
                        if (customDialogR2SX.outsideright.isChecked && customDialogR2SX.outsideleft.isChecked && customDialogR2SX.insideright.isChecked) {
                            ch14.text = "هب امامي كامل و الخلفي يمين"
                            customDialogR2SX.s3er_r2s_acx.setText("30")
                        } else {
                            if (customDialogR2SX.outsideright.isChecked && customDialogR2SX.outsideleft.isChecked && customDialogR2SX.insideleft.isChecked) {
                                ch14.text = "هب امامي كامل و الخلفي يسار"
                                customDialogR2SX.s3er_r2s_acx.setText("30")
                            } else {
                                if (customDialogR2SX.outsideright.isChecked && customDialogR2SX.insideright.isChecked && customDialogR2SX.insideleft.isChecked) {
                                    ch14.text = "هب امامي يمين و الخلفيين"
                                    customDialogR2SX.s3er_r2s_acx.setText("30")
                                } else {
                                    if (customDialogR2SX.outsideleft.isChecked && customDialogR2SX.insideright.isChecked && customDialogR2SX.insideleft.isChecked) {
                                        ch14.text = "هب امامي يسار و الخلفيين"
                                        customDialogR2SX.s3er_r2s_acx.setText("30")
                                    } else {
                                        if (customDialogR2SX.outsideright.isChecked && customDialogR2SX.outsideleft.isChecked) {
                                            ch14.text = "هب امامي يمين و يسار"
                                            customDialogR2SX.s3er_r2s_acx.setText("20")
                                        } else {
                                            if (customDialogR2SX.outsideright.isChecked && customDialogR2SX.insideright.isChecked) {
                                                ch14.text = "هب امامي يمين و الخلفي يمين"
                                                customDialogR2SX.s3er_r2s_acx.setText("20")
                                            } else {
                                                if (customDialogR2SX.outsideright.isChecked && customDialogR2SX.insideleft.isChecked) {
                                                    ch14.text = "هب امامي يمين و الخلفي يسار"
                                                    customDialogR2SX.s3er_r2s_acx.setText("20")
                                                } else {
                                                    if (customDialogR2SX.outsideleft.isChecked && customDialogR2SX.insideright.isChecked) {
                                                        ch14.text =
                                                            "هب امامي يسار و الخلفي يمين"
                                                        customDialogR2SX.s3er_r2s_acx.setText("20")
                                                    } else {
                                                        if (customDialogR2SX.outsideleft.isChecked && customDialogR2SX.insideleft.isChecked) {
                                                            ch14.text =
                                                                "هب امامي يسار و الخلفي يسار"
                                                            customDialogR2SX.s3er_r2s_acx.setText("20")
                                                        } else {
                                                            if (customDialogR2SX.insideright.isChecked && customDialogR2SX.insideleft.isChecked) {
                                                                ch14.text =
                                                                    "هب خلفي يمين و يسار"
                                                                customDialogR2SX.s3er_r2s_acx.setText(
                                                                    "20"
                                                                )
                                                            } else {

                                                                if (customDialogR2SX.outsideright.isChecked) {
                                                                    ch14.text =
                                                                        "هب امامي يمين"
                                                                    customDialogR2SX.s3er_r2s_acx.setText(
                                                                        "10"
                                                                    )
                                                                }
                                                                if (customDialogR2SX.outsideleft.isChecked) {
                                                                    ch14.text =
                                                                        "هب امامي يسار"
                                                                    customDialogR2SX.s3er_r2s_acx.setText(
                                                                        "10"
                                                                    )
                                                                }

                                                                if (customDialogR2SX.insideleft.isChecked) {
                                                                    ch14.text =
                                                                        "هب خلفي يسار"
                                                                    customDialogR2SX.s3er_r2s_acx.setText(
                                                                        "10"
                                                                    )
                                                                }
                                                                if (customDialogR2SX.insideright.isChecked) {
                                                                    ch14.text =
                                                                        "هب خلفي يمين"
                                                                    customDialogR2SX.s3er_r2s_acx.setText(
                                                                        "10"
                                                                    )
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                    customDialogR2SX.show()
                }

                customDialogR2SX.outsideleft.setOnCheckedChangeListener { _, isChecked2 ->
                    if (customDialogR2SX.outsideleft.isChecked) {
                        ch14.text = "هب امامي يمين"
                    } else {
                        ch14.text = "هب"
                        customDialogR2SX.s3er_r2s_acx.setText("")
                    }

                    if (customDialogR2SX.outsideright.isChecked && customDialogR2SX.outsideleft.isChecked && customDialogR2SX.insideright.isChecked && customDialogR2SX.insideleft.isChecked) {
                        ch14.text = "تغير جميع الهبات"
                        customDialogR2SX.s3er_r2s_acx.setText("40")
                    } else {
                        if (customDialogR2SX.outsideright.isChecked && customDialogR2SX.outsideleft.isChecked && customDialogR2SX.insideright.isChecked) {
                            ch14.text = "هب امامي كامل و الخلفي يمين"
                            customDialogR2SX.s3er_r2s_acx.setText("30")
                        } else {
                            if (customDialogR2SX.outsideright.isChecked && customDialogR2SX.outsideleft.isChecked && customDialogR2SX.insideleft.isChecked) {
                                ch14.text = "هب امامي كامل و الخلفي يسار"
                                customDialogR2SX.s3er_r2s_acx.setText("30")
                            } else {
                                if (customDialogR2SX.outsideright.isChecked && customDialogR2SX.insideright.isChecked && customDialogR2SX.insideleft.isChecked) {
                                    ch14.text = "هب امامي يمين و الخلفيين"
                                    customDialogR2SX.s3er_r2s_acx.setText("30")
                                } else {
                                    if (customDialogR2SX.outsideleft.isChecked && customDialogR2SX.insideright.isChecked && customDialogR2SX.insideleft.isChecked) {
                                        ch14.text = "هب امامي يسار و الخلفيين"
                                        customDialogR2SX.s3er_r2s_acx.setText("30")
                                    } else {
                                        if (customDialogR2SX.outsideright.isChecked && customDialogR2SX.outsideleft.isChecked) {
                                            ch14.text = "هب امامي يمين و يسار"
                                            customDialogR2SX.s3er_r2s_acx.setText("20")
                                        } else {
                                            if (customDialogR2SX.outsideright.isChecked && customDialogR2SX.insideright.isChecked) {
                                                ch14.text = "هب امامي يمين و الخلفي يمين"
                                                customDialogR2SX.s3er_r2s_acx.setText("20")
                                            } else {
                                                if (customDialogR2SX.outsideright.isChecked && customDialogR2SX.insideleft.isChecked) {
                                                    ch14.text = "هب امامي يمين و الخلفي يسار"
                                                    customDialogR2SX.s3er_r2s_acx.setText("20")
                                                } else {
                                                    if (customDialogR2SX.outsideleft.isChecked && customDialogR2SX.insideright.isChecked) {
                                                        ch14.text =
                                                            "هب امامي يسار و الخلفي يمين"
                                                        customDialogR2SX.s3er_r2s_acx.setText("20")
                                                    } else {
                                                        if (customDialogR2SX.outsideleft.isChecked && customDialogR2SX.insideleft.isChecked) {
                                                            ch14.text =
                                                                "هب امامي يسار و الخلفي يسار"
                                                            customDialogR2SX.s3er_r2s_acx.setText("20")
                                                        } else {
                                                            if (customDialogR2SX.insideright.isChecked && customDialogR2SX.insideleft.isChecked) {
                                                                ch14.text =
                                                                    "هب خلفي يمين و يسار"
                                                                customDialogR2SX.s3er_r2s_acx.setText(
                                                                    "20"
                                                                )
                                                            } else {

                                                                if (customDialogR2SX.outsideright.isChecked) {
                                                                    ch14.text =
                                                                        "هب امامي يمين"
                                                                    customDialogR2SX.s3er_r2s_acx.setText(
                                                                        "10"
                                                                    )
                                                                }
                                                                if (customDialogR2SX.outsideleft.isChecked) {
                                                                    ch14.text =
                                                                        "هب امامي يسار"
                                                                    customDialogR2SX.s3er_r2s_acx.setText(
                                                                        "10"
                                                                    )
                                                                }

                                                                if (customDialogR2SX.insideleft.isChecked) {
                                                                    ch14.text =
                                                                        "هب خلفي يسار"
                                                                    customDialogR2SX.s3er_r2s_acx.setText(
                                                                        "10"
                                                                    )
                                                                }
                                                                if (customDialogR2SX.insideright.isChecked) {
                                                                    ch14.text =
                                                                        "هب خلفي يمين"
                                                                    customDialogR2SX.s3er_r2s_acx.setText(
                                                                        "10"
                                                                    )
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                    customDialogR2SX.show()
                }



                customDialogR2SX.insideleft.setOnCheckedChangeListener { _, isChecked2 ->
                    if (customDialogR2SX.outsideright.isChecked) {
                        ch14.text = "هب امامي يمين"
                    } else {
                        ch14.text = "هب"
                        customDialogR2SX.s3er_r2s_acx.setText("")
                    }

                    if (customDialogR2SX.outsideright.isChecked && customDialogR2SX.outsideleft.isChecked && customDialogR2SX.insideright.isChecked && customDialogR2SX.insideleft.isChecked) {
                        ch14.text = "تغير جميع الهبات"
                        customDialogR2SX.s3er_r2s_acx.setText("40")
                    } else {
                        if (customDialogR2SX.outsideright.isChecked && customDialogR2SX.outsideleft.isChecked && customDialogR2SX.insideright.isChecked) {
                            ch14.text = "هب امامي كامل و الخلفي يمين"
                            customDialogR2SX.s3er_r2s_acx.setText("30")
                        } else {
                            if (customDialogR2SX.outsideright.isChecked && customDialogR2SX.outsideleft.isChecked && customDialogR2SX.insideleft.isChecked) {
                                ch14.text = "هب امامي كامل و الخلفي يسار"
                                customDialogR2SX.s3er_r2s_acx.setText("30")
                            } else {
                                if (customDialogR2SX.outsideright.isChecked && customDialogR2SX.insideright.isChecked && customDialogR2SX.insideleft.isChecked) {
                                    ch14.text = "هب امامي يمين و الخلفيين"
                                    customDialogR2SX.s3er_r2s_acx.setText("30")
                                } else {
                                    if (customDialogR2SX.outsideleft.isChecked && customDialogR2SX.insideright.isChecked && customDialogR2SX.insideleft.isChecked) {
                                        ch14.text = "هب امامي يسار و الخلفيين"
                                        customDialogR2SX.s3er_r2s_acx.setText("30")
                                    } else {
                                        if (customDialogR2SX.outsideright.isChecked && customDialogR2SX.outsideleft.isChecked) {
                                            ch14.text = "هب امامي يمين و يسار"
                                            customDialogR2SX.s3er_r2s_acx.setText("20")
                                        } else {
                                            if (customDialogR2SX.outsideright.isChecked && customDialogR2SX.insideright.isChecked) {
                                                ch14.text = "هب امامي يمين و الخلفي يمين"
                                                customDialogR2SX.s3er_r2s_acx.setText("20")
                                            } else {
                                                if (customDialogR2SX.outsideright.isChecked && customDialogR2SX.insideleft.isChecked) {
                                                    ch14.text = "هب امامي يمين و الخلفي يسار"
                                                    customDialogR2SX.s3er_r2s_acx.setText("20")
                                                } else {
                                                    if (customDialogR2SX.outsideleft.isChecked && customDialogR2SX.insideright.isChecked) {
                                                        ch14.text =
                                                            "هب امامي يسار و الخلفي يمين"
                                                        customDialogR2SX.s3er_r2s_acx.setText("20")
                                                    } else {
                                                        if (customDialogR2SX.outsideleft.isChecked && customDialogR2SX.insideleft.isChecked) {
                                                            ch14.text =
                                                                "هب امامي يسار و الخلفي يسار"
                                                            customDialogR2SX.s3er_r2s_acx.setText("20")
                                                        } else {
                                                            if (customDialogR2SX.insideright.isChecked && customDialogR2SX.insideleft.isChecked) {
                                                                ch14.text =
                                                                    "هب خلفي يمين و يسار"
                                                                customDialogR2SX.s3er_r2s_acx.setText(
                                                                    "20"
                                                                )
                                                            } else {

                                                                if (customDialogR2SX.outsideright.isChecked) {
                                                                    ch14.text =
                                                                        "هب امامي يمين"
                                                                    customDialogR2SX.s3er_r2s_acx.setText(
                                                                        "10"
                                                                    )
                                                                }
                                                                if (customDialogR2SX.outsideleft.isChecked) {
                                                                    ch14.text =
                                                                        "هب امامي يسار"
                                                                    customDialogR2SX.s3er_r2s_acx.setText(
                                                                        "10"
                                                                    )
                                                                }

                                                                if (customDialogR2SX.insideleft.isChecked) {
                                                                    ch14.text =
                                                                        "هب خلفي يسار"
                                                                    customDialogR2SX.s3er_r2s_acx.setText(
                                                                        "10"
                                                                    )
                                                                }
                                                                if (customDialogR2SX.insideright.isChecked) {
                                                                    ch14.text =
                                                                        "هب خلفي يمين"
                                                                    customDialogR2SX.s3er_r2s_acx.setText(
                                                                        "10"
                                                                    )
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }

                    customDialogR2SX.show()
                }

                customDialogR2SX.insideright.setOnCheckedChangeListener { _, isChecked2 ->
                    if (customDialogR2SX.insideright.isChecked) {
                        ch14.text = "هب امامي يمين"
                    } else {
                        ch14.text = "هب"
                        customDialogR2SX.s3er_r2s_acx.setText("")
                    }

                    if (customDialogR2SX.outsideright.isChecked && customDialogR2SX.outsideleft.isChecked && customDialogR2SX.insideright.isChecked && customDialogR2SX.insideleft.isChecked) {
                        ch14.text = "تغير جميع الهبات"
                        customDialogR2SX.s3er_r2s_acx.setText("40")
                    } else {
                        if (customDialogR2SX.outsideright.isChecked && customDialogR2SX.outsideleft.isChecked && customDialogR2SX.insideright.isChecked) {
                            ch14.text = "هب امامي كامل و الخلفي يمين"
                            customDialogR2SX.s3er_r2s_acx.setText("30")
                        } else {
                            if (customDialogR2SX.outsideright.isChecked && customDialogR2SX.outsideleft.isChecked && customDialogR2SX.insideleft.isChecked) {
                                ch14.text = "هب امامي كامل و الخلفي يسار"
                                customDialogR2SX.s3er_r2s_acx.setText("30")
                            } else {
                                if (customDialogR2SX.outsideright.isChecked && customDialogR2SX.insideright.isChecked && customDialogR2SX.insideleft.isChecked) {
                                    ch14.text = "هب امامي يمين و الخلفيين"
                                    customDialogR2SX.s3er_r2s_acx.setText("30")
                                } else {
                                    if (customDialogR2SX.outsideleft.isChecked && customDialogR2SX.insideright.isChecked && customDialogR2SX.insideleft.isChecked) {
                                        ch14.text = "هب امامي يسار و الخلفيين"
                                        customDialogR2SX.s3er_r2s_acx.setText("30")
                                    } else {
                                        if (customDialogR2SX.outsideright.isChecked && customDialogR2SX.outsideleft.isChecked) {
                                            ch14.text = "هب امامي يمين و يسار"
                                            customDialogR2SX.s3er_r2s_acx.setText("20")
                                        } else {
                                            if (customDialogR2SX.outsideright.isChecked && customDialogR2SX.insideright.isChecked) {
                                                ch14.text = "هب امامي يمين و الخلفي يمين"
                                                customDialogR2SX.s3er_r2s_acx.setText("20")
                                            } else {
                                                if (customDialogR2SX.outsideright.isChecked && customDialogR2SX.insideleft.isChecked) {
                                                    ch14.text = "هب امامي يمين و الخلفي يسار"
                                                    customDialogR2SX.s3er_r2s_acx.setText("20")
                                                } else {
                                                    if (customDialogR2SX.outsideleft.isChecked && customDialogR2SX.insideright.isChecked) {
                                                        ch14.text =
                                                            "هب امامي يسار و الخلفي يمين"
                                                        customDialogR2SX.s3er_r2s_acx.setText("20")
                                                    } else {
                                                        if (customDialogR2SX.outsideleft.isChecked && customDialogR2SX.insideleft.isChecked) {
                                                            ch14.text =
                                                                "هب امامي يسار و الخلفي يسار"
                                                            customDialogR2SX.s3er_r2s_acx.setText("20")
                                                        } else {
                                                            if (customDialogR2SX.insideright.isChecked && customDialogR2SX.insideleft.isChecked) {
                                                                ch14.text =
                                                                    "هب خلفي يمين و يسار"
                                                                customDialogR2SX.s3er_r2s_acx.setText(
                                                                    "20"
                                                                )
                                                            } else {

                                                                if (customDialogR2SX.outsideright.isChecked) {
                                                                    ch14.text =
                                                                        "هب امامي يمين"
                                                                    customDialogR2SX.s3er_r2s_acx.setText(
                                                                        "10"
                                                                    )
                                                                }
                                                                if (customDialogR2SX.outsideleft.isChecked) {
                                                                    ch14.text =
                                                                        "هب امامي يسار"
                                                                    customDialogR2SX.s3er_r2s_acx.setText(
                                                                        "10"
                                                                    )
                                                                }

                                                                if (customDialogR2SX.insideleft.isChecked) {
                                                                    ch14.text =
                                                                        "هب خلفي يسار"
                                                                    customDialogR2SX.s3er_r2s_acx.setText(
                                                                        "10"
                                                                    )
                                                                }
                                                                if (customDialogR2SX.insideright.isChecked) {
                                                                    ch14.text =
                                                                        "هب خلفي يمين"
                                                                    customDialogR2SX.s3er_r2s_acx.setText(
                                                                        "10"
                                                                    )
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                    customDialogR2SX.show()
                }


                customDialogR2SX.btn_r2s_sav.setOnClickListener {
                    if (!customDialogR2SX.outsideright.isChecked && !customDialogR2SX.outsideleft.isChecked
                        && !customDialogR2SX.insideright.isChecked && !customDialogR2SX.insideleft.isChecked
                    ) {
                        toast_notempty1.show()
                    } else {
                        if (customDialogR2SX.s3er_r2s_acx.text.toString().trim().isEmpty()) {
                            toast_notempty.show()
                        } else {
                            editTextNumber14.text = customDialogR2SX.s3er_r2s_acx.text.toString()
                            viewModel.totalAmount += editTextNumber14.text.toString().toInt()
                            toolbar?.title =  viewModel.totalAmount.toString()
                            customDialogR2SX.dismiss()
                        }
                    }
                }
                customDialogR2SX.btn_r2s_can.setOnClickListener {
                    if (editTextNumber14.text.toString().isEmpty()) {
                        ch14.text = "هب"
                        ch14.isChecked = false
                    }
                    customDialogR2SX.dismiss()
                }

                customDialogR2SX.show()
                homeModel.checkname14 += ch14.text.toString().trim()
                homeModel.editname14 += editTextNumber14.text.toString().trim()
            } else {
                if (editTextNumber14.text.toString().isNotEmpty()) {
                    viewModel.totalAmount -= editTextNumber14.text.toString().toInt()
                    toolbar?.title =  viewModel.totalAmount.toString()
                    ch14.text = "هب"
                    editTextNumber14.setText("")
                    homeModel.checkname14 =  ""
                    homeModel.editname14 =  ""
                } else {
                    ch14.text = "هب"
                }
            }
        }

        ch15.setOnCheckedChangeListener { _, isChecked ->
            if (ch15.isChecked) {

                customDialogF79.s3er_yadwee_fa7.setText("10")

                customDialogF79.btn_sv_dig_fa7.setOnClickListener {
                    if (customDialogF79.s3er_yadwee_fa7.text.toString().isEmpty()) {
                        toast_notempty.show()
                    } else {
                        editTextNumber15.text = customDialogF79.s3er_yadwee_fa7.text.toString()
                        viewModel.totalAmount += editTextNumber15.text.toString().toInt()
                        toolbar?.title =  viewModel.totalAmount.toString()
                        customDialogF79.dismiss()
                    }
                }
                customDialogF79.show()
                homeModel.checkname15 += ch15.text.toString().trim()
                homeModel.editname15 += editTextNumber15.text.toString().trim()
            } else {
                viewModel.totalAmount -= editTextNumber15.text.toString().toInt()
                toolbar?.title =  viewModel.totalAmount.toString()
                editTextNumber15.text = ""
                homeModel.checkname15 =  ""
                homeModel.editname15 =  ""
            }
        }

        ch16.setOnCheckedChangeListener { _, isChecked ->
            if (ch16.isChecked) {

                customDialogF79.s3er_yadwee_fa7.setText("40")

                customDialogF79.btn_sv_dig_fa7.setOnClickListener {
                    if (customDialogF79.s3er_yadwee_fa7.text.toString().isEmpty()) {
                        toast_notempty.show()
                    } else {
                        editTextNumber16.text = customDialogF79.s3er_yadwee_fa7.text.toString()
                        viewModel.totalAmount += editTextNumber16.text.toString().toInt()
                        toolbar?.title =  viewModel.totalAmount.toString()
                        customDialogF79.dismiss()
                    }
                }
                customDialogF79.show()
                homeModel.checkname16 += ch16.text.toString().trim()
                homeModel.editname16 += editTextNumber16.text.toString().trim()
            } else {
                viewModel.totalAmount -= editTextNumber16.text.toString().toInt()
                toolbar?.title =  viewModel.totalAmount.toString()
                editTextNumber16.text = ""
                homeModel.checkname16 =  ""
                homeModel.editname16 =  ""
            }
        }

        ch17.setOnCheckedChangeListener { _, isChecked ->
            if (ch17.isChecked) {

                customDialogF79.btn_sv_dig_fa7.setOnClickListener {
                    if (customDialogF79.s3er_yadwee_fa7.text.toString().isEmpty()) {
                        toast_notempty.show()
                    } else {
                        editTextNumber17.text = customDialogF79.s3er_yadwee_fa7.text.toString()
                        viewModel.totalAmount += editTextNumber17.text.toString().toInt()
                        toolbar?.title =  viewModel.totalAmount.toString()
                        customDialogF79.dismiss()
                    }
                }
                customDialogF79.show()
                homeModel.checkname17 += ch17.text.toString().trim()
                homeModel.editname17 += editTextNumber17.text.toString().trim()
            } else {
                viewModel.totalAmount -= editTextNumber17.text.toString().toInt()
                toolbar?.title =  viewModel.totalAmount.toString()
                editTextNumber17.text = ""
                homeModel.checkname17 =  ""
                homeModel.editname17 =  ""
            }
        }

        ch18.setOnCheckedChangeListener { _, isChecked ->
            if (ch18.isChecked) {

                customDialogF79.s3er_yadwee_fa7.setText("3")

                customDialogF79.btn_sv_dig_fa7.setOnClickListener {
                    if (customDialogF79.s3er_yadwee_fa7.text.toString().isEmpty()) {
                        toast_notempty.show()
                    } else {
                        editTextNumber18.text = customDialogF79.s3er_yadwee_fa7.text.toString()
                        viewModel.totalAmount += editTextNumber18.text.toString().toInt()
                        toolbar?.title =  viewModel.totalAmount.toString()
                        customDialogF79.dismiss()
                    }
                }
                customDialogF79.show()
                homeModel.checkname18 += ch18.text.toString().trim()
                homeModel.editname18 += editTextNumber18.text.toString().trim()
            } else {
                viewModel.totalAmount -= editTextNumber18.text.toString().toInt()
                toolbar?.title =  viewModel.totalAmount.toString()
                editTextNumber18.text = ""
                homeModel.checkname18 =  ""
                homeModel.editname18 =  ""
            }
        }

        ch19.setOnCheckedChangeListener { _, isChecked ->
            if (ch19.isChecked) {

                customDialogF79.s3er_yadwee_fa7.setText("5")

                customDialogF79.btn_sv_dig_fa7.setOnClickListener {
                    if (customDialogF79.s3er_yadwee_fa7.text.toString().isEmpty()) {
                        toast_notempty.show()
                    } else {
                        editTextNumber19.text = customDialogF79.s3er_yadwee_fa7.text.toString()
                        viewModel.totalAmount += editTextNumber19.text.toString().toInt()
                        toolbar?.title =  viewModel.totalAmount.toString()
                        customDialogF79.dismiss()
                    }
                }
                customDialogF79.show()
                homeModel.checkname19 += ch19.text.toString().trim()
                homeModel.editname19 += editTextNumber19.text.toString().trim()
            } else {
                viewModel.totalAmount -= editTextNumber19.text.toString().toInt()
                toolbar?.title =  viewModel.totalAmount.toString()
                editTextNumber19.text = ""
                homeModel.checkname19 =  ""
                homeModel.editname19 =  ""
            }
        }

        ch20.setOnCheckedChangeListener { _, isChecked ->
            if (ch20.isChecked) {

                customDialogF79.btn_sv_dig_fa7.setOnClickListener {
                    if (customDialogF79.s3er_yadwee_fa7.text.toString().isEmpty()) {
                        toast_notempty.show()
                    } else {
                        editTextNumber20.text = customDialogF79.s3er_yadwee_fa7.text.toString()
                        viewModel.totalAmount += editTextNumber20.text.toString().toInt()
                        toolbar?.title =  viewModel.totalAmount.toString()
                        customDialogF79.dismiss()
                    }
                }
                customDialogF79.show()
                homeModel.checkname20 += ch20.text.toString().trim()
                homeModel.editname20 += editTextNumber20.text.toString().trim()

            } else {
                viewModel.totalAmount -= editTextNumber20.text.toString().toInt()
                toolbar?.title =  viewModel.totalAmount.toString()
                editTextNumber20.text = ""
                homeModel.checkname20 =  ""
                homeModel.editname20 =  ""
            }
        }
        loadCheckBoxes()
        return root
    }

    override fun onPause() {
        super.onPause()
        saveCheckBoxes()
    }


    private fun saveCheckBoxes() {
        homeModel.ch1 = ch1.isChecked
        homeModel.ch2 = ch2.isChecked
        homeModel.ch3 = ch3.isChecked
        homeModel.ch4 = ch4.isChecked
        homeModel.ch5 = ch5.isChecked
        homeModel.ch6 = ch6.isChecked
        homeModel.ch7 = ch7.isChecked
        homeModel.ch8 = ch8.isChecked
        homeModel.ch9 = ch9.isChecked
        homeModel.ch10 = ch10.isChecked
        homeModel.ch11 = ch11.isChecked
        homeModel.ch12 = ch12.isChecked
        homeModel.ch13 = ch13.isChecked
        homeModel.ch14 = ch14.isChecked
        homeModel.ch15 = ch15.isChecked
        homeModel.ch16 = ch16.isChecked
        homeModel.ch17 = ch17.isChecked
        homeModel.ch18 = ch18.isChecked
        homeModel.ch19 = ch19.isChecked
        homeModel.ch20 = ch20.isChecked

        homeModel.editTextNumber1 = editTextNumber1.text.toString()
        homeModel.editTextNumber2 = editTextNumber2.text.toString()
        homeModel.editTextNumber3 = editTextNumber3.text.toString()
        homeModel.editTextNumber4 = editTextNumber4.text.toString()
        homeModel.editTextNumber5 = editTextNumber5.text.toString()
        homeModel.editTextNumber6 = editTextNumber6.text.toString()
        homeModel.editTextNumber7 = editTextNumber7.text.toString()
        homeModel.editTextNumber8 = editTextNumber8.text.toString()
        homeModel.editTextNumber9 = editTextNumber9.text.toString()
        homeModel.editTextNumber10 = editTextNumber10.text.toString()
        homeModel.editTextNumber11 = editTextNumber11.text.toString()
        homeModel.editTextNumber12 = editTextNumber12.text.toString()
        homeModel.editTextNumber13 = editTextNumber13.text.toString()
        homeModel.editTextNumber14 = editTextNumber14.text.toString()
        homeModel.editTextNumber15 = editTextNumber15.text.toString()
        homeModel.editTextNumber16 = editTextNumber16.text.toString()
        homeModel.editTextNumber17 = editTextNumber17.text.toString()
        homeModel.editTextNumber18 = editTextNumber18.text.toString()
        homeModel.editTextNumber19 = editTextNumber19.text.toString()
        homeModel.editTextNumber20 = editTextNumber20.text.toString()

        homeModel2.check1 = ch1.text.toString()
        homeModel2.check2 = ch2.text.toString()
        homeModel2.check3 = ch3.text.toString()
        homeModel2.check4 = ch4.text.toString()
        homeModel2.check5 = ch5.text.toString()
        homeModel2.check6 = ch6.text.toString()
        homeModel2.check7 = ch7.text.toString()
        homeModel2.check8 = ch8.text.toString()
        homeModel2.check9 = ch9.text.toString()
        homeModel2.check10 = ch10.text.toString()
        homeModel2.check11 = ch11.text.toString()
        homeModel2.check12 = ch12.text.toString()
        homeModel2.check13 = ch13.text.toString()
        homeModel2.check14 = ch14.text.toString()
        homeModel2.check15 = ch15.text.toString()
        homeModel2.check16 = ch16.text.toString()
        homeModel2.check17 = ch17.text.toString()
        homeModel2.check18 = ch18.text.toString()
        homeModel2.check19 = ch19.text.toString()
        homeModel2.check20 = ch20.text.toString()

    }

    private fun loadCheckBoxes() {
        ch1.isChecked = homeModel.ch1
        ch2.isChecked = homeModel.ch2
        ch3.isChecked = homeModel.ch3
        ch4.isChecked = homeModel.ch4
        ch5.isChecked = homeModel.ch5
        ch6.isChecked = homeModel.ch6
        ch7.isChecked = homeModel.ch7
        ch8.isChecked = homeModel.ch8
        ch9.isChecked = homeModel.ch9
        ch10.isChecked = homeModel.ch10
        ch11.isChecked = homeModel.ch11
        ch12.isChecked = homeModel.ch12
        ch13.isChecked = homeModel.ch13
        ch14.isChecked = homeModel.ch14
        ch15.isChecked = homeModel.ch15
        ch16.isChecked = homeModel.ch16
        ch17.isChecked = homeModel.ch17
        ch18.isChecked = homeModel.ch18
        ch19.isChecked = homeModel.ch19
        ch20.isChecked = homeModel.ch20

        editTextNumber1.text = homeModel.editTextNumber1
        editTextNumber2.text = homeModel.editTextNumber2
        editTextNumber3.text = homeModel.editTextNumber3
        editTextNumber4.text = homeModel.editTextNumber4
        editTextNumber5.text = homeModel.editTextNumber5
        editTextNumber6.text = homeModel.editTextNumber6
        editTextNumber7.text = homeModel.editTextNumber7
        editTextNumber8.text = homeModel.editTextNumber8
        editTextNumber9.text = homeModel.editTextNumber9
        editTextNumber10.text = homeModel.editTextNumber10
        editTextNumber11.text = homeModel.editTextNumber11
        editTextNumber12.text = homeModel.editTextNumber12
        editTextNumber13.text = homeModel.editTextNumber13
        editTextNumber14.text = homeModel.editTextNumber14
        editTextNumber15.text = homeModel.editTextNumber15
        editTextNumber16.text = homeModel.editTextNumber16
        editTextNumber17.text = homeModel.editTextNumber17
        editTextNumber18.text = homeModel.editTextNumber18
        editTextNumber19.text = homeModel.editTextNumber19
        editTextNumber20.text = homeModel.editTextNumber20

        ch1.text = homeModel2.check1
        ch2.text = homeModel2.check2
        ch3.text = homeModel2.check3
        ch4.text = homeModel2.check4
        ch5.text = homeModel2.check5
        ch6.text = homeModel2.check6
        ch7.text = homeModel2.check7
        ch8.text = homeModel2.check8
        ch9.text = homeModel2.check9
        ch10.text = homeModel2.check10
        ch11.text = homeModel2.check11
        ch12.text = homeModel2.check12
        ch13.text = homeModel2.check13
        ch14.text = homeModel2.check14
        ch15.text = homeModel2.check15
        ch16.text = homeModel2.check16
        ch17.text = homeModel2.check17
        ch18.text = homeModel2.check18
        ch19.text = homeModel2.check19
        ch20.text = homeModel2.check20

        customDialogMZ.dismiss()
        customDialogF79.dismiss()
        customDialogR2SX.dismiss()
        customDialogBRK.dismiss()
        customDialogFR.dismiss()
    }
}