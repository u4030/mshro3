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
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {


        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val customDialogFB_paying = Dialog(activity!!)
        customDialogFB_paying.setContentView(R.layout.paying_dailog)
        customDialogFB_paying.setCancelable(false)
        customDialogFB_paying.window?.setLayout(
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
        
        root.ch1.setOnCheckedChangeListener { _, isChecked ->
            if (ch1.isChecked) {
                val customDialogFB = Dialog(activity!!)
                customDialogFB.setContentView(R.layout.dialog_mezan)
                customDialogFB.setCancelable(false)
                customDialogFB.window?.setLayout(
                    ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT)

                customDialogFB.front.setOnCheckedChangeListener { _, isChecked1 ->
                    if (customDialogFB.front.isChecked) {
                        ch1.text =
                            ch1.text.toString() + " " + customDialogFB.front.text.toString()
                    } else {
                        ch1.text = "ميزان"
                        customDialogFB.s3er_yadwee_fa7.setText("")
                    }

                    if (customDialogFB.front.isChecked && customDialogFB.rear.isChecked) {
                        ch1.text = "ميزان امامي و خلفي"
                        customDialogFB.s3er_yadwee_fa7.setText("10")
                    } else {
                        if (customDialogFB.front.isChecked) {
                            ch1.text = "ميزان امامي"
                            customDialogFB.s3er_yadwee_fa7.setText("5")
                        }
                        if (customDialogFB.rear.isChecked) {
                            ch1.text = "ميزان خلفي"
                            customDialogFB.s3er_yadwee_fa7.setText("5")
                        }
                    }
                }
                customDialogFB.rear.setOnCheckedChangeListener { _, isChecked2 ->
                    if (customDialogFB.rear.isChecked) {
                        ch1.text = ch1.text.toString() + " " +
                                customDialogFB.rear.text.toString()
                    }else{ch1.text = "ميزان"
                        customDialogFB.s3er_yadwee_fa7.setText("")}

                    if (customDialogFB.rear.isChecked && customDialogFB.front.isChecked){
                        ch1.text = "ميزان امامي و خلفي"
                        customDialogFB.s3er_yadwee_fa7.setText("10")
                    }else {
                        if (customDialogFB.front.isChecked) {
                            ch1.text = "ميزان امامي"
                            customDialogFB.s3er_yadwee_fa7.setText("5")
                        }
                        if (customDialogFB.rear.isChecked) {
                            ch1.text = "ميزان خلفي"
                            customDialogFB.s3er_yadwee_fa7.setText("5")
                        }
                    }

                }

                customDialogFB.btn_sv_dig_fa7.setOnClickListener {
                    if (!customDialogFB.front.isChecked && !customDialogFB.rear.isChecked) {
                        toast_notempty1.show()
                    } else {
                        val  aa=customDialogFB.s3er_yadwee_fa7.text.toString().trim()
                        if (aa.isEmpty()) {
                            toast_notempty.show()
//                            ch1.isChecked = false
                        } else {
                            editTextNumber1.text = customDialogFB.s3er_yadwee_fa7.text.toString()
                            viewModel.totalAmount += editTextNumber1.text.toString().toInt()

                            toolbar?.title =   viewModel.totalAmount.toString()
                            customDialogFB.dismiss()
                        }
                    }
                }
                customDialogFB.btn_cn_dig_mz.setOnClickListener {
                    ch1.isChecked = false
                    customDialogFB.s3er_yadwee_fa7.setText("")
                    customDialogFB.dismiss()
                }
                customDialogFB.show()
                homeModel.checkname1 += ch1.text.toString().trim()
                homeModel.editname1 += editTextNumber1.text.toString().trim()
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

        root.ch2.setOnCheckedChangeListener { _, isChecked ->
            if (ch2.isChecked) {
                val customDialogFB = Dialog(activity!!)
                customDialogFB.setContentView(R.layout.dialog_fa7e9)
                customDialogFB.setCancelable(false)
                customDialogFB.window?.setLayout(
                    ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT)

                customDialogFB.btn_sv_dig_fa7.setOnClickListener {
                    if (customDialogFB.s3er_yadwee_fa7.text.toString().isEmpty()) {
                        toast_notempty.show()
                    } else {
                        pricd2.text = customDialogFB.s3er_yadwee_fa7.text.toString()
                        viewModel.totalAmount += pricd2.text.toString().toInt()
                        toolbar?.title =  viewModel.totalAmount.toString()
                        customDialogFB.dismiss()
                    }
                }
                customDialogFB.show()
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

        root.ch3.setOnCheckedChangeListener { _, isChecked ->
            if (ch3.isChecked) {

                val customDialogFB = Dialog(activity!!)
                customDialogFB.setContentView(R.layout.r2syet_2ks_dailog)
                customDialogFB.setCancelable(true)
                customDialogFB.window?.setLayout(
                    ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT
                )

                customDialogFB.outsideright.setOnCheckedChangeListener { _, isChecked1 ->

                    if (customDialogFB.outsideright.isChecked) {
                        ch3.text = "راسية اكس خارجية يمين"
                    }else{ch3.text = "راسية اكس"
                        customDialogFB.s3er_r2s_acx.setText("")}

                    if (customDialogFB.outsideright.isChecked && customDialogFB.outsideleft.isChecked && customDialogFB.insideright.isChecked && customDialogFB.insideleft.isChecked) {
                        ch3.text = "تغير جميع الرأسيات الخارجية و الداخلية"
                        customDialogFB.s3er_r2s_acx.setText("40")
                    } else {
                        if (customDialogFB.outsideright.isChecked && customDialogFB.outsideleft.isChecked && customDialogFB.insideright.isChecked) {
                            ch3.text = "راسيتين اكس خارجية و الداخلية يمين"
                            customDialogFB.s3er_r2s_acx.setText("30")
                        }else {
                            if (customDialogFB.outsideright.isChecked && customDialogFB.outsideleft.isChecked && customDialogFB.insideleft.isChecked) {
                                ch3.text = "راسيتين اكس خارجية و الداخلية يسار"
                                customDialogFB.s3er_r2s_acx.setText("30")
                            }else {
                                if (customDialogFB.outsideright.isChecked && customDialogFB.insideright.isChecked && customDialogFB.insideleft.isChecked) {
                                    ch3.text = "راسية اكس خارجية يمين و الداخليتين"
                                    customDialogFB.s3er_r2s_acx.setText("30")
                                }else {
                                    if (customDialogFB.outsideleft.isChecked && customDialogFB.insideright.isChecked && customDialogFB.insideleft.isChecked) {
                                        ch3.text = "راسية اكس خارجية يسار و الداخليتين"
                                        customDialogFB.s3er_r2s_acx.setText("30")
                                    }else {
                                        if (customDialogFB.outsideright.isChecked && customDialogFB.outsideleft.isChecked) {
                                            ch3.text = "راسية اكس خارجية يمين و يسار"
                                            customDialogFB.s3er_r2s_acx.setText("20")
                                        }else {
                                            if (customDialogFB.outsideright.isChecked && customDialogFB.insideright.isChecked) {
                                                ch3.text = "راسية اكس خارجية يمين و داخلية يمين"
                                                customDialogFB.s3er_r2s_acx.setText("20")
                                            }else {
                                                if (customDialogFB.outsideright.isChecked && customDialogFB.insideleft.isChecked) {
                                                    ch3.text = "راسية اكس خارجية يمين و داخلية يسار"
                                                    customDialogFB.s3er_r2s_acx.setText("20")
                                                }else {
                                                    if (customDialogFB.outsideleft.isChecked && customDialogFB.insideright.isChecked) {
                                                        ch3.text = "راسية اكس خارجية يسار و داخلية يمين"
                                                        customDialogFB.s3er_r2s_acx.setText("20")
                                                    }else {
                                                        if (customDialogFB.outsideleft.isChecked && customDialogFB.insideleft.isChecked) {
                                                            ch3.text = "راسية اكس خارجية يسار و داخلية يسار"
                                                            customDialogFB.s3er_r2s_acx.setText("20")
                                                        }else {
                                                            if (customDialogFB.insideright.isChecked && customDialogFB.insideleft.isChecked) {
                                                                ch3.text = "راسية اكس داخلية يمين و يسار"
                                                                customDialogFB.s3er_r2s_acx.setText("20")
                                                            } else {

                                                                if (customDialogFB.outsideright.isChecked) {
                                                                    ch3.text = "راسية اكس خارجية يمين"
                                                                    customDialogFB.s3er_r2s_acx.setText("10")
                                                                }
                                                                if (customDialogFB.outsideleft.isChecked) {
                                                                    ch3.text = "راسية اكس خارجية يسار"
                                                                    customDialogFB.s3er_r2s_acx.setText("10")
                                                                }

                                                                if (customDialogFB.insideleft.isChecked) {
                                                                    ch3.text = "راسية اكس داخلية يسار"
                                                                    customDialogFB.s3er_r2s_acx.setText("10")
                                                                }
                                                                if (customDialogFB.insideright.isChecked) {
                                                                    ch3.text = "راسية اكس داخلية يمين"
                                                                    customDialogFB.s3er_r2s_acx.setText("10")
                                                                }
                                                            }
                                                        }
                                                    }}}}}}}}}
                    customDialogFB.show()
                }



                customDialogFB.outsideleft.setOnCheckedChangeListener { _, isChecked2 ->
                    if (customDialogFB.outsideleft.isChecked) {
                        ch3.text = "راسية اكس خارجية يسار"
                    }else{ch3.text = "راسية اكس"
                        customDialogFB.s3er_r2s_acx.setText("")}

                    if (customDialogFB.outsideright.isChecked && customDialogFB.outsideleft.isChecked && customDialogFB.insideright.isChecked && customDialogFB.insideleft.isChecked ) {
                        ch3.text = "تغير جميع الرأسيات الخارجية و الداخلية"
                        customDialogFB.s3er_r2s_acx.setText("40")
                    }else{
                        if (customDialogFB.outsideleft.isChecked && customDialogFB.outsideright.isChecked && customDialogFB.insideright.isChecked ) {
                            ch3.text = "راسيتين اكس خارجية و الداخلية يمين"
                            customDialogFB.s3er_r2s_acx.setText("30")
                        }else{
                            if (customDialogFB.outsideleft.isChecked && customDialogFB.outsideright.isChecked && customDialogFB.insideleft.isChecked ) {
                                ch3.text = "راسيتين اكس خارجية و الداخلية يسار"
                                customDialogFB.s3er_r2s_acx.setText("30")
                            }else{
                                if (customDialogFB.outsideright.isChecked && customDialogFB.insideright.isChecked && customDialogFB.insideleft.isChecked ) {
                                    ch3.text = "راسية اكس خارجية يمين و الداخليتين"
                                    customDialogFB.s3er_r2s_acx.setText("30")
                                }else{
                                    if (customDialogFB.outsideleft.isChecked && customDialogFB.insideright.isChecked && customDialogFB.insideleft.isChecked ) {
                                        ch3.text = "راسية اكس خارجية يسار و الداخليتين"
                                        customDialogFB.s3er_r2s_acx.setText("30")
                                    }else{
//                                else {
                                        if (customDialogFB.outsideleft.isChecked && customDialogFB.outsideright.isChecked) {
                                            ch3.text = "راسية اكس خارجية يمين و يسار"
                                            customDialogFB.s3er_r2s_acx.setText("20")
                                        }else{
                                            if (customDialogFB.outsideright.isChecked && customDialogFB.insideright.isChecked) {
                                                ch3.text = "راسية اكس خارجية يمين و داخلية يمين"
                                                customDialogFB.s3er_r2s_acx.setText("20")
                                            }else{
                                                if (customDialogFB.outsideright.isChecked && customDialogFB.insideleft.isChecked) {
                                                    ch3.text = "راسية اكس خارجية يمين و داخلية يسار"
                                                    customDialogFB.s3er_r2s_acx.setText("20")
                                                }else{
                                                    if (customDialogFB.outsideleft.isChecked && customDialogFB.insideright.isChecked) {
                                                        ch3.text = "راسية اكس خارجية يسار و داخلية يمين"
                                                        customDialogFB.s3er_r2s_acx.setText("20")
                                                    }else{
                                                        if (customDialogFB.outsideleft.isChecked && customDialogFB.insideleft.isChecked) {
                                                            ch3.text = "راسية اكس خارجية يسار و داخلية يسار"
                                                            customDialogFB.s3er_r2s_acx.setText("20")
                                                        }else{
                                                            if (customDialogFB.insideright.isChecked && customDialogFB.insideleft.isChecked) {
                                                                ch3.text = "راسية اكس داخلية يمين و يسار"
                                                                customDialogFB.s3er_r2s_acx.setText("20")
                                                            } else {

                                                                if (customDialogFB.outsideleft.isChecked) {
                                                                    ch3.text = "راسية اكس خارجية يسار"
                                                                    customDialogFB.s3er_r2s_acx.setText("10")
                                                                }

                                                                if (customDialogFB.outsideright.isChecked) {
                                                                    ch3.text = "راسية اكس خارجية يمين"
                                                                    customDialogFB.s3er_r2s_acx.setText("10")
                                                                }

                                                                if (customDialogFB.insideleft.isChecked) {
                                                                    ch3.text = "راسية اكس داخلية يسار"
                                                                    customDialogFB.s3er_r2s_acx.setText("10")
                                                                }
                                                                if (customDialogFB.insideright.isChecked) {
                                                                    ch3.text = "راسية اكس داخلية يمين"
                                                                    customDialogFB.s3er_r2s_acx.setText("10")
                                                                }
                                                            }
                                                        }
                                                    }}}}}}}}}
                    customDialogFB.show()
                }



                customDialogFB.insideleft.setOnCheckedChangeListener { _, isChecked2 ->
                    if (customDialogFB.insideleft.isChecked) {
                        ch3.text = "راسية اكس داخلية يسار"
                    }else{ch3.text = "راسية اكس"
                        customDialogFB.s3er_r2s_acx.setText("")}

                    if (customDialogFB.outsideright.isChecked && customDialogFB.outsideleft.isChecked && customDialogFB.insideright.isChecked && customDialogFB.insideleft.isChecked ) {
                        ch3.text = "تغير جميع الرأسيات الخارجية و الداخلية"
                        customDialogFB.s3er_r2s_acx.setText("40")
                    }else {
                        if (customDialogFB.outsideright.isChecked && customDialogFB.outsideleft.isChecked && customDialogFB.insideright.isChecked ) {
                            ch3.text = "راسيتين اكس خارجية و الداخلية يمين"
                            customDialogFB.s3er_r2s_acx.setText("30")
                        }else {
                            if (customDialogFB.insideleft.isChecked && customDialogFB.outsideleft.isChecked && customDialogFB.outsideright.isChecked) {
                                ch3.text = "راسيتين اكس خارجية و الداخلية يسار"
                                customDialogFB.s3er_r2s_acx.setText("30")
                            }else {
                                if (customDialogFB.insideleft.isChecked && customDialogFB.insideright.isChecked && customDialogFB.outsideright.isChecked) {
                                    ch3.text = "راسية اكس خارجية يمين و الداخليتين"
                                    customDialogFB.s3er_r2s_acx.setText("30")
                                }else {
                                    if (customDialogFB.insideleft.isChecked && customDialogFB.insideright.isChecked && customDialogFB.outsideleft.isChecked) {
                                        ch3.text = "راسية اكس خارجية يسار و الداخليتين"
                                        customDialogFB.s3er_r2s_acx.setText("30")
                                    }else {
                                        if (customDialogFB.outsideright.isChecked && customDialogFB.outsideleft.isChecked) {
                                            ch3.text = "راسية اكس خارجية يمين و يسار"
                                            customDialogFB.s3er_r2s_acx.setText("20")
                                        }else {
                                            if (customDialogFB.outsideright.isChecked && customDialogFB.insideright.isChecked) {
                                                ch3.text = "راسية اكس خارجية يمين و داخلية يمين"
                                                customDialogFB.s3er_r2s_acx.setText("20")
                                            }else {
                                                if (customDialogFB.insideleft.isChecked && customDialogFB.outsideright.isChecked) {
                                                    ch3.text = "راسية اكس خارجية يمين و داخلية يسار"
                                                    customDialogFB.s3er_r2s_acx.setText("20")
                                                }else {
                                                    if (customDialogFB.outsideleft.isChecked && customDialogFB.insideright.isChecked) {
                                                        ch3.text = "راسية اكس خارجية يسار و داخلية يمين"
                                                        customDialogFB.s3er_r2s_acx.setText("20")
                                                    }else {
                                                        if (customDialogFB.insideleft.isChecked && customDialogFB.outsideleft.isChecked) {
                                                            ch3.text = "راسية اكس خارجية يسار و داخلية يسار"
                                                            customDialogFB.s3er_r2s_acx.setText("20")
                                                        }else {
                                                            if (customDialogFB.insideleft.isChecked && customDialogFB.insideright.isChecked) {
                                                                ch3.text = "راسية اكس داخلية يمين و يسار"
                                                                customDialogFB.s3er_r2s_acx.setText("20")
                                                            } else {
                                                                if (customDialogFB.insideright.isChecked) {
                                                                    ch3.text = "راسية اكس داخلية يمين"
                                                                    customDialogFB.s3er_r2s_acx.setText("10")
                                                                }
                                                                if (customDialogFB.outsideright.isChecked) {
                                                                    ch3.text = "راسية اكس خارجية يمين"
                                                                    customDialogFB.s3er_r2s_acx.setText("10")
                                                                }
                                                                if (customDialogFB.outsideleft.isChecked) {
                                                                    ch3.text = "راسية اكس خارجية يسار"
                                                                    customDialogFB.s3er_r2s_acx.setText("10")
                                                                }

                                                                if (customDialogFB.insideleft.isChecked) {
                                                                    ch3.text = "راسية اكس داخلية يسار"
                                                                    customDialogFB.s3er_r2s_acx.setText("10")
                                                                }
                                                            }
                                                        }
                                                    }}}}}}}}}

                    customDialogFB.show()
                }
//
                customDialogFB.insideright.setOnCheckedChangeListener { _, isChecked2 ->
                    if (customDialogFB.insideright.isChecked) {
                        ch3.text = "راسية اكس داخلية يمين"
                    }else{ch3.text = "راسية اكس"
                        customDialogFB.s3er_r2s_acx.setText("")}

                    if (customDialogFB.outsideright.isChecked && customDialogFB.outsideleft.isChecked && customDialogFB.insideright.isChecked && customDialogFB.insideleft.isChecked ) {
                        ch3.text = "تغير جميع الرأسيات الخارجية و الداخلية"
                        customDialogFB.s3er_r2s_acx.setText("40")
                    }else{
                        if (customDialogFB.insideright.isChecked && customDialogFB.outsideleft.isChecked && customDialogFB.outsideright.isChecked ) {
                            ch3.text = "راسيتين اكس خارجية و الداخلية يمين"
                            customDialogFB.s3er_r2s_acx.setText("30")
                        }else {
                            if (customDialogFB.outsideright.isChecked && customDialogFB.outsideleft.isChecked && customDialogFB.insideleft.isChecked ) {
                                ch3.text = "راسيتين اكس خارجية و الداخلية يسار"
                                customDialogFB.s3er_r2s_acx.setText("30")
                            }else {
                                if (customDialogFB.insideright.isChecked && customDialogFB.outsideright.isChecked && customDialogFB.insideleft.isChecked ) {
                                    ch3.text = "راسية اكس خارجية يمين و الداخليتين"
                                    customDialogFB.s3er_r2s_acx.setText("30")
                                }else {
                                    if (customDialogFB.insideright.isChecked && customDialogFB.outsideleft.isChecked && customDialogFB.insideleft.isChecked ) {
                                        ch3.text = "راسية اكس خارجية يسار و الداخليتين"
                                        customDialogFB.s3er_r2s_acx.setText("30")
                                    }else {
                                        if (customDialogFB.outsideright.isChecked && customDialogFB.outsideleft.isChecked ) {
                                            ch3.text = "راسية اكس خارجية يمين و يسار"
                                            customDialogFB.s3er_r2s_acx.setText("20")
                                        }else {
                                            if (customDialogFB.insideright.isChecked && customDialogFB.outsideright.isChecked ) {
                                                ch3.text = "راسية اكس خارجية يمين و داخلية يمين"
                                                customDialogFB.s3er_r2s_acx.setText("20")
                                            }else {
                                                if (customDialogFB.outsideright.isChecked && customDialogFB.insideleft.isChecked ) {
                                                    ch3.text = "راسية اكس خارجية يمين و داخلية يسار"
                                                    customDialogFB.s3er_r2s_acx.setText("20")
                                                }else {
                                                    if (customDialogFB.insideright.isChecked && customDialogFB.outsideleft.isChecked) {
                                                        ch3.text = "راسية اكس خارجية يسار و داخلية يمين"
                                                        customDialogFB.s3er_r2s_acx.setText("20")
                                                    }else {
                                                        if (customDialogFB.outsideleft.isChecked && customDialogFB.insideleft.isChecked) {
                                                            ch3.text = "راسية اكس خارجية يسار و داخلية يسار"
                                                            customDialogFB.s3er_r2s_acx.setText("20")
                                                        }else {
                                                            if (customDialogFB.insideright.isChecked && customDialogFB.insideleft.isChecked) {
                                                                ch3.text = "راسية اكس داخلية يمين و يسار"
                                                                customDialogFB.s3er_r2s_acx.setText("20")
                                                            } else {
                                                                if (customDialogFB.insideright.isChecked) {
                                                                    ch3.text = "راسية اكس داخلية يمين"
                                                                    customDialogFB.s3er_r2s_acx.setText("10")
                                                                }
                                                                if (customDialogFB.insideleft.isChecked) {
                                                                    ch3.text = "راسية اكس داخلية يسار"
                                                                    customDialogFB.s3er_r2s_acx.setText("10")
                                                                }
                                                                if (customDialogFB.outsideleft.isChecked) {
                                                                    ch3.text = "راسية اكس خارجية يسار"
                                                                    customDialogFB.s3er_r2s_acx.setText("10")
                                                                }
                                                                if (customDialogFB.outsideright.isChecked) {
                                                                    ch3.text = "راسية اكس خارجية يمين"
                                                                    customDialogFB.s3er_r2s_acx.setText("10")
                                                                }
                                                            }
                                                        }
                                                    }}}}}}}}}
                    customDialogFB.show()
                }


                customDialogFB.btn_r2s_sav.setOnClickListener {
                    if (!customDialogFB.outsideright.isChecked && !customDialogFB.outsideleft.isChecked
                        && !customDialogFB.insideright.isChecked && !customDialogFB.insideleft.isChecked ) {
                        toast_notempty1.show()}else{
                        if (customDialogFB.s3er_r2s_acx.text.toString().trim().isEmpty()){
                            toast_notempty.show()
//                                ch3.isChecked = false
                        }else{
                            pricd3.text=customDialogFB.s3er_r2s_acx.text.toString()
                            viewModel.totalAmount += pricd3.text.toString().toInt()
                            toolbar?.title =  viewModel.totalAmount.toString()
                            customDialogFB.dismiss()
                        }
                    }
                }
                customDialogFB.btn_r2s_can.setOnClickListener {
                    if (pricd3.text.toString().isEmpty()) {
                        ch3.text = "راسية اكس"
                        ch3.isChecked = false
                    }
                    customDialogFB.dismiss()
                }

                customDialogFB.show()
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

        root.ch4.setOnCheckedChangeListener { _, isChecked ->

            if (ch4.isChecked) {
                val customDialogFB = Dialog(activity!!)
                customDialogFB.setContentView(R.layout.dialog_break)
                customDialogFB.setCancelable(false)
                customDialogFB.window?.setLayout(
                    ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT
                )

                customDialogFB.d_b_front.setOnCheckedChangeListener { _, isChecked1 ->
                    if (customDialogFB.d_b_front.isChecked) {
                        ch4.text ="بريك امامي"
                    } else {
                        ch4.text = "بريك"
                        customDialogFB.s3er_yadwee_break.setText("")
                    }
                    if (customDialogFB.d_b_front.isChecked && customDialogFB.d_b_rear.isChecked) {
                        ch4.text = "بريك امامي و خلفي"
                        customDialogFB.s3er_yadwee_break.setText("10")
                    } else {
                        if (customDialogFB.d_b_front.isChecked) {
                            ch4.text = "بريك امامي"
                            customDialogFB.s3er_yadwee_break.setText("5")
                        }
                        if (customDialogFB.d_b_rear.isChecked) {
                            ch4.text = "بريك خلفي"
                            customDialogFB.s3er_yadwee_break.setText("5")
                        }
                    }
                }

                customDialogFB.d_b_rear.setOnCheckedChangeListener { _, isChecked2 ->
                    if (customDialogFB.d_b_rear.isChecked) {
                        ch4.text ="بريك خلفي"
                    } else {
                        ch4.text = "بريك"
                        customDialogFB.s3er_yadwee_break.setText("")
                    }
                    if (customDialogFB.d_b_front.isChecked && customDialogFB.d_b_rear.isChecked) {
                        ch4.text = "بريك امامي و خلفي"
                        customDialogFB.s3er_yadwee_break.setText("10")
                    } else {
                        if (customDialogFB.d_b_rear.isChecked) {
                            ch4.text = "بريك خلفي"
                            customDialogFB.s3er_yadwee_break.setText("5")
                        }
                        if (customDialogFB.d_b_front.isChecked) {
                            ch4.text = "بريك امامي"
                            customDialogFB.s3er_yadwee_break.setText("5")
                        }
                    }
                }

                customDialogFB.btn_sv_dig_break.setOnClickListener {
                    if (!customDialogFB.d_b_front.isChecked && !customDialogFB.d_b_rear.isChecked) {
                        toast_notempty1.show()}else{
                        if (customDialogFB.s3er_yadwee_break.text.toString().trim().isEmpty()){
                            toast_notempty.show()
                            ch4.isChecked = false
                        }else{
                            pricd4.text=customDialogFB.s3er_yadwee_break.text.toString()
                            viewModel.totalAmount += pricd4.text.toString().toInt()
                            toolbar?.title =  viewModel.totalAmount.toString()
                            customDialogFB.dismiss()
                        }
                    }
                }

                customDialogFB.btn_cn_dig_break.setOnClickListener {
                    if (pricd4.text.toString().isEmpty()) {
                        ch4.text = " بريك"
                        ch4.isChecked = false
                    }
                    customDialogFB.dismiss()
                }
                customDialogFB.show()
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

        root.ch5.setOnCheckedChangeListener { _, isChecked ->
            if (ch5.isChecked) {

                val customDialogFB = Dialog(activity!!)
                customDialogFB.setContentView(R.layout.r2syet_2ks_dailog)
                customDialogFB.setCancelable(false)
                customDialogFB.window?.setLayout(
                    ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT
                )

                customDialogFB.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

                customDialogFB.card_r2s_2ks.setOnTouchListener { _, event ->
                    var x = 0f
                    var y = 0f
                    when (event.action) {
                        MotionEvent.ACTION_UP -> {
                            x = event.x
                            y = event.y
                        }
                        MotionEvent.ACTION_MOVE -> {
                            customDialogFB.window?.let {
                                val params: WindowManager.LayoutParams = it.attributes
                                params.x = event.rawX.toInt() - x.toInt()
                                params.y = event.rawY.toInt() - y.toInt()
                                it.attributes = params
                            }
                        }

                        MotionEvent.ACTION_UP -> {
                            customDialogFB.window?.let {
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

                customDialogFB.outsideright.setOnCheckedChangeListener { _, isChecked1 ->

                    if (customDialogFB.outsideright.isChecked) {
                        ch5.text = "كوشوكة اكس خارجية يمين"
                    } else {
                        ch5.text = "كوشوكة اكس خارجية"
                        customDialogFB.s3er_r2s_acx.setText("")
                    }

                    if (customDialogFB.outsideright.isChecked && customDialogFB.outsideleft.isChecked && customDialogFB.insideright.isChecked && customDialogFB.insideleft.isChecked) {
                        ch5.text = "تغير جميع كوشوكات الأكس الخارجية و الداخلية"
                        customDialogFB.s3er_r2s_acx.setText("20")
                    } else {
                        if (customDialogFB.outsideright.isChecked && customDialogFB.outsideleft.isChecked && customDialogFB.insideright.isChecked) {
                            ch5.text = "كوشوكتين اكس خارجية و الداخلية يمين"
                            customDialogFB.s3er_r2s_acx.setText("15")
                        } else {
                            if (customDialogFB.outsideright.isChecked && customDialogFB.outsideleft.isChecked && customDialogFB.insideleft.isChecked) {
                                ch5.text = "كوشوكتين اكس خارجية و الداخلية يسار"
                                customDialogFB.s3er_r2s_acx.setText("15")
                            } else {
                                if (customDialogFB.outsideright.isChecked && customDialogFB.insideright.isChecked && customDialogFB.insideleft.isChecked) {
                                    ch5.text = "كوشوكة اكس خارجية يمين و الداخليتين"
                                    customDialogFB.s3er_r2s_acx.setText("15")
                                } else {
                                    if (customDialogFB.outsideleft.isChecked && customDialogFB.insideright.isChecked && customDialogFB.insideleft.isChecked) {
                                        ch5.text = "كوشوكة اكس خارجية يسار و الداخليتين"
                                        customDialogFB.s3er_r2s_acx.setText("15")
                                    } else {
                                        if (customDialogFB.outsideright.isChecked && customDialogFB.outsideleft.isChecked) {
                                            ch5.text = "كوشوكة اكس خارجية يمين و يسار"
                                            customDialogFB.s3er_r2s_acx.setText("10")
                                        } else {
                                            if (customDialogFB.outsideright.isChecked && customDialogFB.insideright.isChecked) {
                                                ch5.text = "كوشوكة اكس خارجية يمين و داخلية يمين"
                                                customDialogFB.s3er_r2s_acx.setText("10")
                                            } else {
                                                if (customDialogFB.outsideright.isChecked && customDialogFB.insideleft.isChecked) {
                                                    ch5.text = "كوشوكة اكس خارجية يمين و داخلية يسار"
                                                    customDialogFB.s3er_r2s_acx.setText("10")
                                                } else {
                                                    if (customDialogFB.outsideleft.isChecked && customDialogFB.insideright.isChecked) {
                                                        ch5.text =
                                                            "كوشوكة اكس خارجية يسار و داخلية يمين"
                                                        customDialogFB.s3er_r2s_acx.setText("10")
                                                    } else {
                                                        if (customDialogFB.outsideleft.isChecked && customDialogFB.insideleft.isChecked) {
                                                            ch5.text =
                                                                "كوشوكة اكس خارجية يسار و داخلية يسار"
                                                            customDialogFB.s3er_r2s_acx.setText("10")
                                                        } else {
                                                            if (customDialogFB.insideright.isChecked && customDialogFB.insideleft.isChecked) {
                                                                ch5.text =
                                                                    "كوشوكة اكس داخلية يمين و يسار"
                                                                customDialogFB.s3er_r2s_acx.setText(
                                                                    "5"
                                                                )
                                                            } else {

                                                                if (customDialogFB.outsideright.isChecked) {
                                                                    ch5.text =
                                                                        "كوشوكة اكس خارجية يمين"
                                                                    customDialogFB.s3er_r2s_acx.setText(
                                                                        "5"
                                                                    )
                                                                }
                                                                if (customDialogFB.outsideleft.isChecked) {
                                                                    ch5.text =
                                                                        "كوشوكة اكس خارجية يسار"
                                                                    customDialogFB.s3er_r2s_acx.setText(
                                                                        "5"
                                                                    )
                                                                }

                                                                if (customDialogFB.insideleft.isChecked) {
                                                                    ch5.text =
                                                                        "كوشوكة اكس داخلية يسار"
                                                                    customDialogFB.s3er_r2s_acx.setText(
                                                                        "5"
                                                                    )
                                                                }
                                                                if (customDialogFB.insideright.isChecked) {
                                                                    ch5.text =
                                                                        "كوشوكة اكس داخلية يمين"
                                                                    customDialogFB.s3er_r2s_acx.setText(
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
                    customDialogFB.show()
                }



                customDialogFB.outsideleft.setOnCheckedChangeListener { _, isChecked2 ->
                    if (customDialogFB.outsideleft.isChecked) {
                        ch5.text = "راسية اكس خارجية يسار"
                    } else {
                        ch5.text = "راسية اكس"
                        customDialogFB.s3er_r2s_acx.setText("")
                    }

                    if (customDialogFB.outsideright.isChecked && customDialogFB.outsideleft.isChecked && customDialogFB.insideright.isChecked && customDialogFB.insideleft.isChecked) {
                        ch5.text = "تغير جميع كوشوكات الأكس الخارجية و الداخلية"
                        customDialogFB.s3er_r2s_acx.setText("20")
                    } else {
                        if (customDialogFB.outsideright.isChecked && customDialogFB.outsideleft.isChecked && customDialogFB.insideright.isChecked) {
                            ch5.text = "كوشوكتين اكس خارجية و الداخلية يمين"
                            customDialogFB.s3er_r2s_acx.setText("15")
                        } else {
                            if (customDialogFB.outsideright.isChecked && customDialogFB.outsideleft.isChecked && customDialogFB.insideleft.isChecked) {
                                ch5.text = "كوشوكتين اكس خارجية و الداخلية يسار"
                                customDialogFB.s3er_r2s_acx.setText("15")
                            } else {
                                if (customDialogFB.outsideright.isChecked && customDialogFB.insideright.isChecked && customDialogFB.insideleft.isChecked) {
                                    ch5.text = "كوشوكة اكس خارجية يمين و الداخليتين"
                                    customDialogFB.s3er_r2s_acx.setText("15")
                                } else {
                                    if (customDialogFB.outsideleft.isChecked && customDialogFB.insideright.isChecked && customDialogFB.insideleft.isChecked) {
                                        ch5.text = "كوشوكة اكس خارجية يسار و الداخليتين"
                                        customDialogFB.s3er_r2s_acx.setText("15")
                                    } else {
                                        if (customDialogFB.outsideright.isChecked && customDialogFB.outsideleft.isChecked) {
                                            ch5.text = "كوشوكة اكس خارجية يمين و يسار"
                                            customDialogFB.s3er_r2s_acx.setText("10")
                                        } else {
                                            if (customDialogFB.outsideright.isChecked && customDialogFB.insideright.isChecked) {
                                                ch5.text = "كوشوكة اكس خارجية يمين و داخلية يمين"
                                                customDialogFB.s3er_r2s_acx.setText("10")
                                            } else {
                                                if (customDialogFB.outsideright.isChecked && customDialogFB.insideleft.isChecked) {
                                                    ch5.text = "كوشوكة اكس خارجية يمين و داخلية يسار"
                                                    customDialogFB.s3er_r2s_acx.setText("10")
                                                } else {
                                                    if (customDialogFB.outsideleft.isChecked && customDialogFB.insideright.isChecked) {
                                                        ch5.text =
                                                            "كوشوكة اكس خارجية يسار و داخلية يمين"
                                                        customDialogFB.s3er_r2s_acx.setText("10")
                                                    } else {
                                                        if (customDialogFB.outsideleft.isChecked && customDialogFB.insideleft.isChecked) {
                                                            ch5.text =
                                                                "كوشوكة اكس خارجية يسار و داخلية يسار"
                                                            customDialogFB.s3er_r2s_acx.setText("10")
                                                        } else {
                                                            if (customDialogFB.insideright.isChecked && customDialogFB.insideleft.isChecked) {
                                                                ch5.text =
                                                                    "كوشوكة اكس داخلية يمين و يسار"
                                                                customDialogFB.s3er_r2s_acx.setText(
                                                                    "5"
                                                                )
                                                            } else {

                                                                if (customDialogFB.outsideright.isChecked) {
                                                                    ch5.text =
                                                                        "كوشوكة اكس خارجية يمين"
                                                                    customDialogFB.s3er_r2s_acx.setText(
                                                                        "5"
                                                                    )
                                                                }
                                                                if (customDialogFB.outsideleft.isChecked) {
                                                                    ch5.text =
                                                                        "كوشوكة اكس خارجية يسار"
                                                                    customDialogFB.s3er_r2s_acx.setText(
                                                                        "5"
                                                                    )
                                                                }

                                                                if (customDialogFB.insideleft.isChecked) {
                                                                    ch5.text =
                                                                        "كوشوكة اكس داخلية يسار"
                                                                    customDialogFB.s3er_r2s_acx.setText(
                                                                        "5"
                                                                    )
                                                                }
                                                                if (customDialogFB.insideright.isChecked) {
                                                                    ch5.text =
                                                                        "كوشوكة اكس داخلية يمين"
                                                                    customDialogFB.s3er_r2s_acx.setText(
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
                    customDialogFB.show()
                }



                customDialogFB.insideleft.setOnCheckedChangeListener { _, isChecked2 ->
                    if (customDialogFB.outsideright.isChecked) {
                        ch5.text = "كوشوكة اكس خارجية يمين"
                    } else {
                        ch5.text = "كوشوكة اكس خارجية"
                        customDialogFB.s3er_r2s_acx.setText("")
                    }

                    if (customDialogFB.outsideright.isChecked && customDialogFB.outsideleft.isChecked && customDialogFB.insideright.isChecked && customDialogFB.insideleft.isChecked) {
                        ch5.text = "تغير جميع كوشوكات الأكس الخارجية و الداخلية"
                        customDialogFB.s3er_r2s_acx.setText("20")
                    } else {
                        if (customDialogFB.outsideright.isChecked && customDialogFB.outsideleft.isChecked && customDialogFB.insideright.isChecked) {
                            ch5.text = "كوشوكتين اكس خارجية و الداخلية يمين"
                            customDialogFB.s3er_r2s_acx.setText("15")
                        } else {
                            if (customDialogFB.outsideright.isChecked && customDialogFB.outsideleft.isChecked && customDialogFB.insideleft.isChecked) {
                                ch5.text = "كوشوكتين اكس خارجية و الداخلية يسار"
                                customDialogFB.s3er_r2s_acx.setText("15")
                            } else {
                                if (customDialogFB.outsideright.isChecked && customDialogFB.insideright.isChecked && customDialogFB.insideleft.isChecked) {
                                    ch5.text = "كوشوكة اكس خارجية يمين و الداخليتين"
                                    customDialogFB.s3er_r2s_acx.setText("15")
                                } else {
                                    if (customDialogFB.outsideleft.isChecked && customDialogFB.insideright.isChecked && customDialogFB.insideleft.isChecked) {
                                        ch5.text = "كوشوكة اكس خارجية يسار و الداخليتين"
                                        customDialogFB.s3er_r2s_acx.setText("15")
                                    } else {
                                        if (customDialogFB.outsideright.isChecked && customDialogFB.outsideleft.isChecked) {
                                            ch5.text = "كوشوكة اكس خارجية يمين و يسار"
                                            customDialogFB.s3er_r2s_acx.setText("10")
                                        } else {
                                            if (customDialogFB.outsideright.isChecked && customDialogFB.insideright.isChecked) {
                                                ch5.text = "كوشوكة اكس خارجية يمين و داخلية يمين"
                                                customDialogFB.s3er_r2s_acx.setText("10")
                                            } else {
                                                if (customDialogFB.outsideright.isChecked && customDialogFB.insideleft.isChecked) {
                                                    ch5.text = "كوشوكة اكس خارجية يمين و داخلية يسار"
                                                    customDialogFB.s3er_r2s_acx.setText("10")
                                                } else {
                                                    if (customDialogFB.outsideleft.isChecked && customDialogFB.insideright.isChecked) {
                                                        ch5.text =
                                                            "كوشوكة اكس خارجية يسار و داخلية يمين"
                                                        customDialogFB.s3er_r2s_acx.setText("10")
                                                    } else {
                                                        if (customDialogFB.outsideleft.isChecked && customDialogFB.insideleft.isChecked) {
                                                            ch5.text =
                                                                "كوشوكة اكس خارجية يسار و داخلية يسار"
                                                            customDialogFB.s3er_r2s_acx.setText("10")
                                                        } else {
                                                            if (customDialogFB.insideright.isChecked && customDialogFB.insideleft.isChecked) {
                                                                ch5.text =
                                                                    "كوشوكة اكس داخلية يمين و يسار"
                                                                customDialogFB.s3er_r2s_acx.setText(
                                                                    "5"
                                                                )
                                                            } else {

                                                                if (customDialogFB.outsideright.isChecked) {
                                                                    ch5.text =
                                                                        "كوشوكة اكس خارجية يمين"
                                                                    customDialogFB.s3er_r2s_acx.setText(
                                                                        "5"
                                                                    )
                                                                }
                                                                if (customDialogFB.outsideleft.isChecked) {
                                                                    ch5.text =
                                                                        "كوشوكة اكس خارجية يسار"
                                                                    customDialogFB.s3er_r2s_acx.setText(
                                                                        "5"
                                                                    )
                                                                }

                                                                if (customDialogFB.insideleft.isChecked) {
                                                                    ch5.text =
                                                                        "كوشوكة اكس داخلية يسار"
                                                                    customDialogFB.s3er_r2s_acx.setText(
                                                                        "5"
                                                                    )
                                                                }
                                                                if (customDialogFB.insideright.isChecked) {
                                                                    ch5.text =
                                                                        "كوشوكة اكس داخلية يمين"
                                                                    customDialogFB.s3er_r2s_acx.setText(
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

                    customDialogFB.show()
                }

                customDialogFB.insideright.setOnCheckedChangeListener { _, isChecked2 ->
                    if (customDialogFB.outsideright.isChecked) {
                        ch5.text = "كوشوكة اكس خارجية يمين"
                    } else {
                        ch5.text = "كوشوكة اكس خارجية"
                        customDialogFB.s3er_r2s_acx.setText("")
                    }

                    if (customDialogFB.outsideright.isChecked && customDialogFB.outsideleft.isChecked && customDialogFB.insideright.isChecked && customDialogFB.insideleft.isChecked) {
                        ch5.text = "تغير جميع كوشوكات الأكس الخارجية و الداخلية"
                        customDialogFB.s3er_r2s_acx.setText("20")
                    } else {
                        if (customDialogFB.outsideright.isChecked && customDialogFB.outsideleft.isChecked && customDialogFB.insideright.isChecked) {
                            ch5.text = "كوشوكتين اكس خارجية و الداخلية يمين"
                            customDialogFB.s3er_r2s_acx.setText("15")
                        } else {
                            if (customDialogFB.outsideright.isChecked && customDialogFB.outsideleft.isChecked && customDialogFB.insideleft.isChecked) {
                                ch5.text = "كوشوكتين اكس خارجية و الداخلية يسار"
                                customDialogFB.s3er_r2s_acx.setText("15")
                            } else {
                                if (customDialogFB.outsideright.isChecked && customDialogFB.insideright.isChecked && customDialogFB.insideleft.isChecked) {
                                    ch5.text = "كوشوكة اكس خارجية يمين و الداخليتين"
                                    customDialogFB.s3er_r2s_acx.setText("15")
                                } else {
                                    if (customDialogFB.outsideleft.isChecked && customDialogFB.insideright.isChecked && customDialogFB.insideleft.isChecked) {
                                        ch5.text = "كوشوكة اكس خارجية يسار و الداخليتين"
                                        customDialogFB.s3er_r2s_acx.setText("15")
                                    } else {
                                        if (customDialogFB.outsideright.isChecked && customDialogFB.outsideleft.isChecked) {
                                            ch5.text = "كوشوكة اكس خارجية يمين و يسار"
                                            customDialogFB.s3er_r2s_acx.setText("10")
                                        } else {
                                            if (customDialogFB.outsideright.isChecked && customDialogFB.insideright.isChecked) {
                                                ch5.text = "كوشوكة اكس خارجية يمين و داخلية يمين"
                                                customDialogFB.s3er_r2s_acx.setText("10")
                                            } else {
                                                if (customDialogFB.outsideright.isChecked && customDialogFB.insideleft.isChecked) {
                                                    ch5.text = "كوشوكة اكس خارجية يمين و داخلية يسار"
                                                    customDialogFB.s3er_r2s_acx.setText("10")
                                                } else {
                                                    if (customDialogFB.outsideleft.isChecked && customDialogFB.insideright.isChecked) {
                                                        ch5.text =
                                                            "كوشوكة اكس خارجية يسار و داخلية يمين"
                                                        customDialogFB.s3er_r2s_acx.setText("10")
                                                    } else {
                                                        if (customDialogFB.outsideleft.isChecked && customDialogFB.insideleft.isChecked) {
                                                            ch5.text =
                                                                "كوشوكة اكس خارجية يسار و داخلية يسار"
                                                            customDialogFB.s3er_r2s_acx.setText("10")
                                                        } else {
                                                            if (customDialogFB.insideright.isChecked && customDialogFB.insideleft.isChecked) {
                                                                ch5.text =
                                                                    "كوشوكة اكس داخلية يمين و يسار"
                                                                customDialogFB.s3er_r2s_acx.setText(
                                                                    "5"
                                                                )
                                                            } else {

                                                                if (customDialogFB.outsideright.isChecked) {
                                                                    ch5.text =
                                                                        "كوشوكة اكس خارجية يمين"
                                                                    customDialogFB.s3er_r2s_acx.setText(
                                                                        "5"
                                                                    )
                                                                }
                                                                if (customDialogFB.outsideleft.isChecked) {
                                                                    ch5.text =
                                                                        "كوشوكة اكس خارجية يسار"
                                                                    customDialogFB.s3er_r2s_acx.setText(
                                                                        "5"
                                                                    )
                                                                }

                                                                if (customDialogFB.insideleft.isChecked) {
                                                                    ch5.text =
                                                                        "كوشوكة اكس داخلية يسار"
                                                                    customDialogFB.s3er_r2s_acx.setText(
                                                                        "5"
                                                                    )
                                                                }
                                                                if (customDialogFB.insideright.isChecked) {
                                                                    ch5.text =
                                                                        "كوشوكة اكس داخلية يمين"
                                                                    customDialogFB.s3er_r2s_acx.setText(
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
                    customDialogFB.show()
                }


                customDialogFB.btn_r2s_sav.setOnClickListener {
                    if (!customDialogFB.outsideright.isChecked && !customDialogFB.outsideleft.isChecked
                        && !customDialogFB.insideright.isChecked && !customDialogFB.insideleft.isChecked
                    ) {
                        toast_notempty1.show()
                    } else {
                        if (customDialogFB.s3er_r2s_acx.text.toString().trim().isEmpty()) {
                            toast_notempty.show()
                        } else {
                            pricd5.text = customDialogFB.s3er_r2s_acx.text.toString()
                            viewModel.totalAmount += pricd5.text.toString().toInt()
                            toolbar?.title =  viewModel.totalAmount.toString()
                            customDialogFB.dismiss()
                        }
                    }
                }
                customDialogFB.btn_r2s_can.setOnClickListener {
                    if (pricd5.text.toString().isEmpty()) {
                        ch5.text = "كوشوكة اكس"
                        ch5.isChecked = false
                    }
                    customDialogFB.dismiss()
                }

                customDialogFB.show()
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

        root.ch6.setOnCheckedChangeListener { _, isChecked ->
            if (ch6.isChecked) {
                val customDialogFB = Dialog(activity!!)
                customDialogFB.setContentView(R.layout.front_dailog)
                customDialogFB.setCancelable(false)
                customDialogFB.window?.setLayout(
                    ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT
                )

                customDialogFB.frontright.setOnCheckedChangeListener { _, isChecked1 ->
                    if (customDialogFB.frontright.isChecked) {
                        ch6.text = "اكس امامي يمين"
                    } else {
                        ch6.text = "اكس امامي"
                        customDialogFB.s3er_yadwee.setText("")
                    }
                    if (customDialogFB.frontright.isChecked && customDialogFB.frontleft.isChecked) {
                        ch6.text = "اكس امامي يمين و يسار"
                        customDialogFB.s3er_yadwee.setText("10")
                    } else {
                        if (customDialogFB.frontright.isChecked) {
                            ch6.text = "اكس امامي يمين"
                            customDialogFB.s3er_yadwee.setText("5")
                        }
                        if (customDialogFB.frontleft.isChecked) {
                            ch6.text = "اكس امامي يسار"
                            customDialogFB.s3er_yadwee.setText("5")
                        }
                    }
                }

                customDialogFB.frontleft.setOnCheckedChangeListener { _, isChecked2 ->
                    if (customDialogFB.frontleft.isChecked) {
                        ch6.text = "اكس امامي يسار"
                    } else {
                        ch6.text = "اكس امامي"
                        customDialogFB.s3er_yadwee.setText("")
                    }
                    if (customDialogFB.frontright.isChecked && customDialogFB.frontleft.isChecked) {
                        ch6.text = "اكس امامي يمين و يسار"
                        customDialogFB.s3er_yadwee.setText("10")
                    } else {
                        if (customDialogFB.frontleft.isChecked) {
                            ch6.text = "اكس امامي يسار"
                            customDialogFB.s3er_yadwee.setText("5")
                        }
                        if (customDialogFB.frontright.isChecked) {
                            ch6.text = "اكس امامي يمين"
                            customDialogFB.s3er_yadwee.setText("5")
                        }
                    }
                }

                customDialogFB.button_dailog_save.setOnClickListener {
                    if (!customDialogFB.frontright.isChecked && !customDialogFB.frontleft.isChecked) {
                        toast_notempty1.show()
                    } else {
                        if (customDialogFB.s3er_yadwee.text.toString().trim().isEmpty()) {
                            toast_notempty.show()
                            ch6.isChecked = false
                        } else {
                            pricd6.text = customDialogFB.s3er_yadwee.text.toString()
                            viewModel.totalAmount += pricd6.text.toString().toInt()
                            toolbar?.title =  viewModel.totalAmount.toString()
                            customDialogFB.dismiss()
                        }
                    }
                }
                customDialogFB.button_dailog_cancel.setOnClickListener {
                    ch6.isChecked = false
                    customDialogFB.s3er_yadwee.setText("")
                    customDialogFB.dismiss()
                }
                customDialogFB.show()
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

        root.ch7.setOnCheckedChangeListener { _, isChecked ->
            if (ch7.isChecked) {
                val customDialogFB = Dialog(activity!!)
                customDialogFB.setContentView(R.layout.front_dailog)
                customDialogFB.setCancelable(false)
                customDialogFB.window?.setLayout(
                    ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT
                )

                customDialogFB.lin_f.setOnTouchListener { _, event ->
                    var x = 0f
                    var y = 0f
                    when (event.action) {
                        MotionEvent.ACTION_UP -> {
                            x = event.x
                            y = event.y
                        }
                        MotionEvent.ACTION_MOVE -> {
                            customDialogFB.window?.let {
                                val params: WindowManager.LayoutParams = it.attributes
                                params.x = event.rawX.toInt() - x.toInt()
                                params.y = event.rawY.toInt() - y.toInt()
                                it.attributes = params
                            }
                        }

                        MotionEvent.ACTION_UP -> {
                            customDialogFB.window?.let {
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

                customDialogFB.frontright.setOnCheckedChangeListener { _, isChecked1 ->
                    if (customDialogFB.frontright.isChecked) {
                        ch7.text = "كوشوكة منفاخ يمين"
                    } else {
                        ch7.text = "كوشوكة منفاخ"
                        customDialogFB.s3er_yadwee.setText("")
                    }
                    if (customDialogFB.frontright.isChecked && customDialogFB.frontleft.isChecked) {
                        ch7.text = "كوشوكة منفاخ يمين و يسار"
                        customDialogFB.s3er_yadwee.setText("6")
                    } else {
                        if (customDialogFB.frontright.isChecked) {
                            ch7.text = "كوشوكة منفاخ يمين"
                            customDialogFB.s3er_yadwee.setText("3")
                        }
                        if (customDialogFB.frontleft.isChecked) {
                            ch7.text = "كوشوكة منفاخ يسار"
                            customDialogFB.s3er_yadwee.setText("3")
                        }
                    }
                }

                customDialogFB.frontleft.setOnCheckedChangeListener { _, isChecked2 ->
                    if (customDialogFB.frontleft.isChecked) {
                        ch7.text = "كوشوكة منفاخ يسار"
                    } else {
                        ch7.text = "كوشوكة منفاخ"
                        customDialogFB.s3er_yadwee.setText("")
                    }
                    if (customDialogFB.frontright.isChecked && customDialogFB.frontleft.isChecked) {
                        ch7.text = "كوشوكة منفاخ يمين و يسار"
                        customDialogFB.s3er_yadwee.setText("6")
                    } else {
                        if (customDialogFB.frontleft.isChecked) {
                            ch7.text = "كوشوكة منفاخ يسار"
                            customDialogFB.s3er_yadwee.setText("3")
                        }
                        if (customDialogFB.frontright.isChecked) {
                            ch7.text = "كوشوكة منفاخ يمين"
                            customDialogFB.s3er_yadwee.setText("3")
                        }
                    }
                }

                customDialogFB.button_dailog_save.setOnClickListener {
                    if (!customDialogFB.frontright.isChecked && !customDialogFB.frontleft.isChecked) {
                        toast_notempty1.show()
                    } else {
                        if (customDialogFB.s3er_yadwee.text.toString().trim().isEmpty()) {
                            toast_notempty.show()
                            ch7.isChecked = false
                        } else {
                            pricd7.text = customDialogFB.s3er_yadwee.text.toString()
                            viewModel.totalAmount += pricd7.text.toString().toInt()
                            toolbar?.title =  viewModel.totalAmount.toString()
                            customDialogFB.dismiss()
                        }
                    }
                }
                customDialogFB.button_dailog_cancel.setOnClickListener {
                    ch7.isChecked = false
                    customDialogFB.s3er_yadwee.setText("")
                    customDialogFB.dismiss()
                }
                customDialogFB.show()
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

        root.ch8.setOnCheckedChangeListener { _, isChecked ->
            if (ch8.isChecked) {

                val customDialogFB = Dialog(activity!!)
                customDialogFB.setContentView(R.layout.r2syet_2ks_dailog)
                customDialogFB.setCancelable(false)
                customDialogFB.window?.setLayout(
                    ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT
                )

                customDialogFB.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

                customDialogFB.tit_r2s_out.text="امامي"
                customDialogFB.tit_r2s_in.text="خلفي"

                customDialogFB.card_r2s_2ks.setOnTouchListener { _, event ->
                    var x = 0f
                    var y = 0f
                    when (event.action) {
                        MotionEvent.ACTION_UP -> {
                            x = event.x
                            y = event.y
                        }
                        MotionEvent.ACTION_MOVE -> {
                            customDialogFB.window?.let {
                                val params: WindowManager.LayoutParams = it.attributes
                                params.x = event.rawX.toInt() - x.toInt()
                                params.y = event.rawY.toInt() - y.toInt()
                                it.attributes = params
                            }
                        }

                        MotionEvent.ACTION_UP -> {
                            customDialogFB.window?.let {
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

                customDialogFB.outsideright.setOnCheckedChangeListener { _, isChecked1 ->

                    if (customDialogFB.outsideright.isChecked) {
                        ch8.text = "كوشوكة عمود شيال امامي يمين"
                    } else {
                        ch8.text = "كوشوكة عمود شيال"
                        customDialogFB.s3er_r2s_acx.setText("")
                    }

                    if (customDialogFB.outsideright.isChecked && customDialogFB.outsideleft.isChecked && customDialogFB.insideright.isChecked && customDialogFB.insideleft.isChecked) {
                        ch8.text = "تغير جميع كوشوكات عمود الشيال"
                        customDialogFB.s3er_r2s_acx.setText("30")
                    } else {
                        if (customDialogFB.outsideright.isChecked && customDialogFB.outsideleft.isChecked && customDialogFB.insideright.isChecked) {
                            ch8.text = "كوشوكتين عمود شيال امامي و الخلفي يمين"
                            customDialogFB.s3er_r2s_acx.setText("25")
                        } else {
                            if (customDialogFB.outsideright.isChecked && customDialogFB.outsideleft.isChecked && customDialogFB.insideleft.isChecked) {
                                ch8.text = "كوشوكتين عمود شيال امامي  و الخلفي يسار"
                                customDialogFB.s3er_r2s_acx.setText("25")
                            } else {
                                if (customDialogFB.outsideright.isChecked && customDialogFB.insideright.isChecked && customDialogFB.insideleft.isChecked) {
                                    ch8.text = "كوشوكة عمود شيال امامي يمين و الخلفيتين"
                                    customDialogFB.s3er_r2s_acx.setText("20")
                                } else {
                                    if (customDialogFB.outsideleft.isChecked && customDialogFB.insideright.isChecked && customDialogFB.insideleft.isChecked) {
                                        ch8.text = "كوشوكة عمود شيال امامي يسار و الخلفيتين"
                                        customDialogFB.s3er_r2s_acx.setText("20")
                                    } else {
                                        if (customDialogFB.outsideright.isChecked && customDialogFB.outsideleft.isChecked) {
                                            ch8.text = "كوشوكة عمود شيال امامي يمين و يسار"
                                            customDialogFB.s3er_r2s_acx.setText("20")
                                        } else {
                                            if (customDialogFB.outsideright.isChecked && customDialogFB.insideright.isChecked) {
                                                ch8.text = "كوشوكة عمود شيال امامي يمين و خلفي يمين"
                                                customDialogFB.s3er_r2s_acx.setText("15")
                                            } else {
                                                if (customDialogFB.outsideright.isChecked && customDialogFB.insideleft.isChecked) {
                                                    ch8.text = "كوشوكة عمود شيال امامي يمين و خلفي يسار"
                                                    customDialogFB.s3er_r2s_acx.setText("15")
                                                } else {
                                                    if (customDialogFB.outsideleft.isChecked && customDialogFB.insideright.isChecked) {
                                                        ch8.text =
                                                            "كوشوكة عمود شيال امامي يسار و خلفي يمين"
                                                        customDialogFB.s3er_r2s_acx.setText("15")
                                                    } else {
                                                        if (customDialogFB.outsideleft.isChecked && customDialogFB.insideleft.isChecked) {
                                                            ch8.text =
                                                                "كوشوكة عمود شيال امامي يسار و خلفي يسار"
                                                            customDialogFB.s3er_r2s_acx.setText("15")
                                                        } else {
                                                            if (customDialogFB.insideright.isChecked && customDialogFB.insideleft.isChecked) {
                                                                ch8.text =
                                                                    "كوشوكة عمود شيال خلفي يمين و يسار"
                                                                customDialogFB.s3er_r2s_acx.setText(
                                                                    "10"
                                                                )
                                                            } else {

                                                                if (customDialogFB.outsideright.isChecked) {
                                                                    ch8.text =
                                                                        "كوشوكة عمود شيال امامي يمين"
                                                                    customDialogFB.s3er_r2s_acx.setText(
                                                                        "10"
                                                                    )
                                                                }
                                                                if (customDialogFB.outsideleft.isChecked) {
                                                                    ch8.text =
                                                                        "كوشوكة عمود شيال امامي يسار"
                                                                    customDialogFB.s3er_r2s_acx.setText(
                                                                        "10"
                                                                    )
                                                                }

                                                                if (customDialogFB.insideleft.isChecked) {
                                                                    ch8.text =
                                                                        "كوشوكة عمود شيال خلفي يسار"
                                                                    customDialogFB.s3er_r2s_acx.setText(
                                                                        "5"
                                                                    )
                                                                }
                                                                if (customDialogFB.insideright.isChecked) {
                                                                    ch8.text =
                                                                        "كوشوكة عمود شيال خلفي يمين"
                                                                    customDialogFB.s3er_r2s_acx.setText(
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
                    customDialogFB.show()
                }



                customDialogFB.outsideleft.setOnCheckedChangeListener { _, isChecked2 ->
                    if (customDialogFB.outsideleft.isChecked) {
                        ch8.text = "راسية اكس خارجية يسار"
                    } else {
                        ch8.text = "راسية اكس"
                        customDialogFB.s3er_r2s_acx.setText("")
                    }

                    if (customDialogFB.outsideright.isChecked && customDialogFB.outsideleft.isChecked && customDialogFB.insideright.isChecked && customDialogFB.insideleft.isChecked) {
                        ch8.text = "تغير جميع كوشوكات عمود الشيال"
                        customDialogFB.s3er_r2s_acx.setText("30")
                    } else {
                        if (customDialogFB.outsideright.isChecked && customDialogFB.outsideleft.isChecked && customDialogFB.insideright.isChecked) {
                            ch8.text = "كوشوكتين عمود شيال امامي و الخلفي يمين"
                            customDialogFB.s3er_r2s_acx.setText("25")
                        } else {
                            if (customDialogFB.outsideright.isChecked && customDialogFB.outsideleft.isChecked && customDialogFB.insideleft.isChecked) {
                                ch8.text = "كوشوكتين عمود شيال امامي  و الخلفي يسار"
                                customDialogFB.s3er_r2s_acx.setText("25")
                            } else {
                                if (customDialogFB.outsideright.isChecked && customDialogFB.insideright.isChecked && customDialogFB.insideleft.isChecked) {
                                    ch8.text = "كوشوكة عمود شيال امامي يمين و الخلفيتين"
                                    customDialogFB.s3er_r2s_acx.setText("20")
                                } else {
                                    if (customDialogFB.outsideleft.isChecked && customDialogFB.insideright.isChecked && customDialogFB.insideleft.isChecked) {
                                        ch8.text = "كوشوكة عمود شيال امامي يسار و الخلفيتين"
                                        customDialogFB.s3er_r2s_acx.setText("20")
                                    } else {
                                        if (customDialogFB.outsideright.isChecked && customDialogFB.outsideleft.isChecked) {
                                            ch8.text = "كوشوكة عمود شيال امامي يمين و يسار"
                                            customDialogFB.s3er_r2s_acx.setText("20")
                                        } else {
                                            if (customDialogFB.outsideright.isChecked && customDialogFB.insideright.isChecked) {
                                                ch8.text = "كوشوكة عمود شيال امامي يمين و خلفي يمين"
                                                customDialogFB.s3er_r2s_acx.setText("15")
                                            } else {
                                                if (customDialogFB.outsideright.isChecked && customDialogFB.insideleft.isChecked) {
                                                    ch8.text = "كوشوكة عمود شيال امامي يمين و خلفي يسار"
                                                    customDialogFB.s3er_r2s_acx.setText("15")
                                                } else {
                                                    if (customDialogFB.outsideleft.isChecked && customDialogFB.insideright.isChecked) {
                                                        ch8.text =
                                                            "كوشوكة عمود شيال امامي يسار و خلفي يمين"
                                                        customDialogFB.s3er_r2s_acx.setText("15")
                                                    } else {
                                                        if (customDialogFB.outsideleft.isChecked && customDialogFB.insideleft.isChecked) {
                                                            ch8.text =
                                                                "كوشوكة عمود شيال امامي يسار و خلفي يسار"
                                                            customDialogFB.s3er_r2s_acx.setText("15")
                                                        } else {
                                                            if (customDialogFB.insideright.isChecked && customDialogFB.insideleft.isChecked) {
                                                                ch8.text =
                                                                    "كوشوكة عمود شيال خلفي يمين و يسار"
                                                                customDialogFB.s3er_r2s_acx.setText(
                                                                    "10"
                                                                )
                                                            } else {

                                                                if (customDialogFB.outsideright.isChecked) {
                                                                    ch8.text =
                                                                        "كوشوكة عمود شيال امامي يمين"
                                                                    customDialogFB.s3er_r2s_acx.setText(
                                                                        "10"
                                                                    )
                                                                }
                                                                if (customDialogFB.outsideleft.isChecked) {
                                                                    ch8.text =
                                                                        "كوشوكة عمود شيال امامي يسار"
                                                                    customDialogFB.s3er_r2s_acx.setText(
                                                                        "10"
                                                                    )
                                                                }

                                                                if (customDialogFB.insideleft.isChecked) {
                                                                    ch8.text =
                                                                        "كوشوكة عمود شيال خلفي يسار"
                                                                    customDialogFB.s3er_r2s_acx.setText(
                                                                        "5"
                                                                    )
                                                                }
                                                                if (customDialogFB.insideright.isChecked) {
                                                                    ch8.text =
                                                                        "كوشوكة عمود شيال خلفي يمين"
                                                                    customDialogFB.s3er_r2s_acx.setText(
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
                    customDialogFB.show()
                }



                customDialogFB.insideleft.setOnCheckedChangeListener { _, isChecked2 ->
                    if (customDialogFB.outsideright.isChecked) {
                        ch8.text = "كوشوكة عمود شيال خارجية يمين"
                    } else {
                        ch8.text = "كوشوكة عمود شيال خارجية"
                        customDialogFB.s3er_r2s_acx.setText("")
                    }

                    if (customDialogFB.outsideright.isChecked && customDialogFB.outsideleft.isChecked && customDialogFB.insideright.isChecked && customDialogFB.insideleft.isChecked) {
                        ch8.text = "تغير جميع كوشوكات عمود الشيال"
                        customDialogFB.s3er_r2s_acx.setText("30")
                    } else {
                        if (customDialogFB.outsideright.isChecked && customDialogFB.outsideleft.isChecked && customDialogFB.insideright.isChecked) {
                            ch8.text = "كوشوكتين عمود شيال امامي و الخلفي يمين"
                            customDialogFB.s3er_r2s_acx.setText("25")
                        } else {
                            if (customDialogFB.outsideright.isChecked && customDialogFB.outsideleft.isChecked && customDialogFB.insideleft.isChecked) {
                                ch8.text = "كوشوكتين عمود شيال امامي  و الخلفي يسار"
                                customDialogFB.s3er_r2s_acx.setText("25")
                            } else {
                                if (customDialogFB.outsideright.isChecked && customDialogFB.insideright.isChecked && customDialogFB.insideleft.isChecked) {
                                    ch8.text = "كوشوكة عمود شيال امامي يمين و الخلفيتين"
                                    customDialogFB.s3er_r2s_acx.setText("20")
                                } else {
                                    if (customDialogFB.outsideleft.isChecked && customDialogFB.insideright.isChecked && customDialogFB.insideleft.isChecked) {
                                        ch8.text = "كوشوكة عمود شيال امامي يسار و الخلفيتين"
                                        customDialogFB.s3er_r2s_acx.setText("20")
                                    } else {
                                        if (customDialogFB.outsideright.isChecked && customDialogFB.outsideleft.isChecked) {
                                            ch8.text = "كوشوكة عمود شيال امامي يمين و يسار"
                                            customDialogFB.s3er_r2s_acx.setText("20")
                                        } else {
                                            if (customDialogFB.outsideright.isChecked && customDialogFB.insideright.isChecked) {
                                                ch8.text = "كوشوكة عمود شيال امامي يمين و خلفي يمين"
                                                customDialogFB.s3er_r2s_acx.setText("15")
                                            } else {
                                                if (customDialogFB.outsideright.isChecked && customDialogFB.insideleft.isChecked) {
                                                    ch8.text = "كوشوكة عمود شيال امامي يمين و خلفي يسار"
                                                    customDialogFB.s3er_r2s_acx.setText("15")
                                                } else {
                                                    if (customDialogFB.outsideleft.isChecked && customDialogFB.insideright.isChecked) {
                                                        ch8.text =
                                                            "كوشوكة عمود شيال امامي يسار و خلفي يمين"
                                                        customDialogFB.s3er_r2s_acx.setText("15")
                                                    } else {
                                                        if (customDialogFB.outsideleft.isChecked && customDialogFB.insideleft.isChecked) {
                                                            ch8.text =
                                                                "كوشوكة عمود شيال امامي يسار و خلفي يسار"
                                                            customDialogFB.s3er_r2s_acx.setText("15")
                                                        } else {
                                                            if (customDialogFB.insideright.isChecked && customDialogFB.insideleft.isChecked) {
                                                                ch8.text =
                                                                    "كوشوكة عمود شيال خلفي يمين و يسار"
                                                                customDialogFB.s3er_r2s_acx.setText(
                                                                    "10"
                                                                )
                                                            } else {

                                                                if (customDialogFB.outsideright.isChecked) {
                                                                    ch8.text =
                                                                        "كوشوكة عمود شيال امامي يمين"
                                                                    customDialogFB.s3er_r2s_acx.setText(
                                                                        "10"
                                                                    )
                                                                }
                                                                if (customDialogFB.outsideleft.isChecked) {
                                                                    ch8.text =
                                                                        "كوشوكة عمود شيال امامي يسار"
                                                                    customDialogFB.s3er_r2s_acx.setText(
                                                                        "10"
                                                                    )
                                                                }

                                                                if (customDialogFB.insideleft.isChecked) {
                                                                    ch8.text =
                                                                        "كوشوكة عمود شيال خلفي يسار"
                                                                    customDialogFB.s3er_r2s_acx.setText(
                                                                        "5"
                                                                    )
                                                                }
                                                                if (customDialogFB.insideright.isChecked) {
                                                                    ch8.text =
                                                                        "كوشوكة عمود شيال خلفي يمين"
                                                                    customDialogFB.s3er_r2s_acx.setText(
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

                    customDialogFB.show()
                }

                customDialogFB.insideright.setOnCheckedChangeListener { _, isChecked2 ->
                    if (customDialogFB.outsideright.isChecked) {
                        ch8.text = "كوشوكة عمود شيال خارجية يمين"
                    } else {
                        ch8.text = "كوشوكة عمود شيال خارجية"
                        customDialogFB.s3er_r2s_acx.setText("")
                    }

                    if (customDialogFB.outsideright.isChecked && customDialogFB.outsideleft.isChecked && customDialogFB.insideright.isChecked && customDialogFB.insideleft.isChecked) {
                        ch8.text = "تغير جميع كوشوكات عمود الشيال"
                        customDialogFB.s3er_r2s_acx.setText("30")
                    } else {
                        if (customDialogFB.outsideright.isChecked && customDialogFB.outsideleft.isChecked && customDialogFB.insideright.isChecked) {
                            ch8.text = "كوشوكتين عمود شيال امامي و الخلفي يمين"
                            customDialogFB.s3er_r2s_acx.setText("25")
                        } else {
                            if (customDialogFB.outsideright.isChecked && customDialogFB.outsideleft.isChecked && customDialogFB.insideleft.isChecked) {
                                ch8.text = "كوشوكتين عمود شيال امامي  و الخلفي يسار"
                                customDialogFB.s3er_r2s_acx.setText("25")
                            } else {
                                if (customDialogFB.outsideright.isChecked && customDialogFB.insideright.isChecked && customDialogFB.insideleft.isChecked) {
                                    ch8.text = "كوشوكة عمود شيال امامي يمين و الخلفيتين"
                                    customDialogFB.s3er_r2s_acx.setText("20")
                                } else {
                                    if (customDialogFB.outsideleft.isChecked && customDialogFB.insideright.isChecked && customDialogFB.insideleft.isChecked) {
                                        ch8.text = "كوشوكة عمود شيال امامي يسار و الخلفيتين"
                                        customDialogFB.s3er_r2s_acx.setText("20")
                                    } else {
                                        if (customDialogFB.outsideright.isChecked && customDialogFB.outsideleft.isChecked) {
                                            ch8.text = "كوشوكة عمود شيال امامي يمين و يسار"
                                            customDialogFB.s3er_r2s_acx.setText("20")
                                        } else {
                                            if (customDialogFB.outsideright.isChecked && customDialogFB.insideright.isChecked) {
                                                ch8.text = "كوشوكة عمود شيال امامي يمين و خلفي يمين"
                                                customDialogFB.s3er_r2s_acx.setText("15")
                                            } else {
                                                if (customDialogFB.outsideright.isChecked && customDialogFB.insideleft.isChecked) {
                                                    ch8.text = "كوشوكة عمود شيال امامي يمين و خلفي يسار"
                                                    customDialogFB.s3er_r2s_acx.setText("15")
                                                } else {
                                                    if (customDialogFB.outsideleft.isChecked && customDialogFB.insideright.isChecked) {
                                                        ch8.text =
                                                            "كوشوكة عمود شيال امامي يسار و خلفي يمين"
                                                        customDialogFB.s3er_r2s_acx.setText("15")
                                                    } else {
                                                        if (customDialogFB.outsideleft.isChecked && customDialogFB.insideleft.isChecked) {
                                                            ch8.text =
                                                                "كوشوكة عمود شيال امامي يسار و خلفي يسار"
                                                            customDialogFB.s3er_r2s_acx.setText("15")
                                                        } else {
                                                            if (customDialogFB.insideright.isChecked && customDialogFB.insideleft.isChecked) {
                                                                ch8.text =
                                                                    "كوشوكة عمود شيال خلفي يمين و يسار"
                                                                customDialogFB.s3er_r2s_acx.setText(
                                                                    "10"
                                                                )
                                                            } else {

                                                                if (customDialogFB.outsideright.isChecked) {
                                                                    ch8.text =
                                                                        "كوشوكة عمود شيال امامي يمين"
                                                                    customDialogFB.s3er_r2s_acx.setText(
                                                                        "10"
                                                                    )
                                                                }
                                                                if (customDialogFB.outsideleft.isChecked) {
                                                                    ch8.text =
                                                                        "كوشوكة عمود شيال امامي يسار"
                                                                    customDialogFB.s3er_r2s_acx.setText(
                                                                        "10"
                                                                    )
                                                                }

                                                                if (customDialogFB.insideleft.isChecked) {
                                                                    ch8.text =
                                                                        "كوشوكة عمود شيال خلفي يسار"
                                                                    customDialogFB.s3er_r2s_acx.setText(
                                                                        "5"
                                                                    )
                                                                }
                                                                if (customDialogFB.insideright.isChecked) {
                                                                    ch8.text =
                                                                        "كوشوكة عمود شيال خلفي يمين"
                                                                    customDialogFB.s3er_r2s_acx.setText(
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
                    customDialogFB.show()
                }


                customDialogFB.btn_r2s_sav.setOnClickListener {
                    if (!customDialogFB.outsideright.isChecked && !customDialogFB.outsideleft.isChecked
                        && !customDialogFB.insideright.isChecked && !customDialogFB.insideleft.isChecked
                    ) {
                        toast_notempty1.show()
                    } else {
                        if (customDialogFB.s3er_r2s_acx.text.toString().trim().isEmpty()) {
                            toast_notempty.show()
                        } else {
                            pricd8.text = customDialogFB.s3er_r2s_acx.text.toString()
                            viewModel.totalAmount += pricd8.text.toString().toInt()
                            toolbar?.title =  viewModel.totalAmount.toString()
                            customDialogFB.dismiss()
                        }
                    }
                }
                customDialogFB.btn_r2s_can.setOnClickListener {
                    if (pricd8.text.toString().isEmpty()) {
                        ch8.text = "كوشوكة عمود شيال"
                        ch8.isChecked = false
                    }
                    customDialogFB.dismiss()
                }

                customDialogFB.show()
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

        root.ch9.setOnCheckedChangeListener { _, isChecked ->
            if (ch9.isChecked) {

                val customDialogFB = Dialog(activity!!)
                customDialogFB.setContentView(R.layout.r2syet_2ks_dailog)
                customDialogFB.setCancelable(false)
                customDialogFB.window?.setLayout(
                    ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT
                )

                customDialogFB.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

                customDialogFB.card_r2s_2ks.setOnTouchListener { _, event ->
                    var x = 0f
                    var y = 0f
                    when (event.action) {
                        MotionEvent.ACTION_UP -> {
                            x = event.x
                            y = event.y
                        }
                        MotionEvent.ACTION_MOVE -> {
                            customDialogFB.window?.let {
                                val params: WindowManager.LayoutParams = it.attributes
                                params.x = event.rawX.toInt() - x.toInt()
                                params.y = event.rawY.toInt() - y.toInt()
                                it.attributes = params
                            }
                        }

                        MotionEvent.ACTION_UP -> {
                            customDialogFB.window?.let {
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

                customDialogFB.outsideright.setOnCheckedChangeListener { _, isChecked1 ->

                    if (customDialogFB.outsideright.isChecked) {
                        ch9.text = "جوزة خارجية يمين"
                    } else {
                        ch9.text = "جوزة"
                        customDialogFB.s3er_r2s_acx.setText("")
                    }

                    if (customDialogFB.outsideright.isChecked && customDialogFB.outsideleft.isChecked && customDialogFB.insideright.isChecked && customDialogFB.insideleft.isChecked) {
                        ch9.text = "تغير جميع الجوزات"
                        customDialogFB.s3er_r2s_acx.setText("16")
                    } else {
                        if (customDialogFB.outsideright.isChecked && customDialogFB.outsideleft.isChecked && customDialogFB.insideright.isChecked) {
                            ch9.text = "جوزتين خارجيات و الداخلية يمين"
                            customDialogFB.s3er_r2s_acx.setText("11")
                        } else {
                            if (customDialogFB.outsideright.isChecked && customDialogFB.outsideleft.isChecked && customDialogFB.insideleft.isChecked) {
                                ch9.text = "جوزتين خارجيات و الداخلية يسار"
                                customDialogFB.s3er_r2s_acx.setText("11")
                            } else {
                                if (customDialogFB.outsideright.isChecked && customDialogFB.insideright.isChecked && customDialogFB.insideleft.isChecked) {
                                    ch9.text = "جوزة خارجية يمين و الداخليتين"
                                    customDialogFB.s3er_r2s_acx.setText("13")
                                } else {
                                    if (customDialogFB.outsideleft.isChecked && customDialogFB.insideright.isChecked && customDialogFB.insideleft.isChecked) {
                                        ch9.text = "جوزة خارجية يسار و الداخليتين"
                                        customDialogFB.s3er_r2s_acx.setText("13")
                                    } else {
                                        if (customDialogFB.outsideright.isChecked && customDialogFB.outsideleft.isChecked) {
                                            ch9.text = "جوزة خارجية يمين و يسار"
                                            customDialogFB.s3er_r2s_acx.setText("6")
                                        } else {
                                            if (customDialogFB.outsideright.isChecked && customDialogFB.insideright.isChecked) {
                                                ch9.text = "جوزة خارجية يمين و داخلية يمين"
                                                customDialogFB.s3er_r2s_acx.setText("8")
                                            } else {
                                                if (customDialogFB.outsideright.isChecked && customDialogFB.insideleft.isChecked) {
                                                    ch9.text = "جوزة خارجية يمين و داخلية يسار"
                                                    customDialogFB.s3er_r2s_acx.setText("8")
                                                } else {
                                                    if (customDialogFB.outsideleft.isChecked && customDialogFB.insideright.isChecked) {
                                                        ch9.text =
                                                            "جوزة خارجية يسار و داخلية يمين"
                                                        customDialogFB.s3er_r2s_acx.setText("8")
                                                    } else {
                                                        if (customDialogFB.outsideleft.isChecked && customDialogFB.insideleft.isChecked) {
                                                            ch9.text =
                                                                "جوزة خارجية يسار و داخلية يسار"
                                                            customDialogFB.s3er_r2s_acx.setText("8")
                                                        } else {
                                                            if (customDialogFB.insideright.isChecked && customDialogFB.insideleft.isChecked) {
                                                                ch9.text =
                                                                    "جوزة داخلية يمين و يسار"
                                                                customDialogFB.s3er_r2s_acx.setText(
                                                                    "10"
                                                                )
                                                            } else {

                                                                if (customDialogFB.outsideright.isChecked) {
                                                                    ch9.text =
                                                                        "جوزة خارجية يمين"
                                                                    customDialogFB.s3er_r2s_acx.setText(
                                                                        "3"
                                                                    )
                                                                }
                                                                if (customDialogFB.outsideleft.isChecked) {
                                                                    ch9.text =
                                                                        "جوزة خارجية يسار"
                                                                    customDialogFB.s3er_r2s_acx.setText(
                                                                        "3"
                                                                    )
                                                                }

                                                                if (customDialogFB.insideleft.isChecked) {
                                                                    ch9.text =
                                                                        "جوزة داخلية يسار"
                                                                    customDialogFB.s3er_r2s_acx.setText(
                                                                        "5"
                                                                    )
                                                                }
                                                                if (customDialogFB.insideright.isChecked) {
                                                                    ch9.text =
                                                                        "جوزة داخلية يمين"
                                                                    customDialogFB.s3er_r2s_acx.setText(
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
                    customDialogFB.show()
                }



                customDialogFB.outsideleft.setOnCheckedChangeListener { _, isChecked2 ->
                    if (customDialogFB.outsideleft.isChecked) {
                        ch9.text = "جوزة خارجية يمين"
                    } else {
                        ch9.text = "جوزة"
                        customDialogFB.s3er_r2s_acx.setText("")
                    }

                    if (customDialogFB.outsideright.isChecked && customDialogFB.outsideleft.isChecked && customDialogFB.insideright.isChecked && customDialogFB.insideleft.isChecked) {
                        ch9.text = "تغير جميع الجوزات"
                        customDialogFB.s3er_r2s_acx.setText("16")
                    } else {
                        if (customDialogFB.outsideright.isChecked && customDialogFB.outsideleft.isChecked && customDialogFB.insideright.isChecked) {
                            ch9.text = "جوزتين خارجيات و الداخلية يمين"
                            customDialogFB.s3er_r2s_acx.setText("11")
                        } else {
                            if (customDialogFB.outsideright.isChecked && customDialogFB.outsideleft.isChecked && customDialogFB.insideleft.isChecked) {
                                ch9.text = "جوزتين خارجيات و الداخلية يسار"
                                customDialogFB.s3er_r2s_acx.setText("11")
                            } else {
                                if (customDialogFB.outsideright.isChecked && customDialogFB.insideright.isChecked && customDialogFB.insideleft.isChecked) {
                                    ch9.text = "جوزة خارجية يمين و الداخليتين"
                                    customDialogFB.s3er_r2s_acx.setText("13")
                                } else {
                                    if (customDialogFB.outsideleft.isChecked && customDialogFB.insideright.isChecked && customDialogFB.insideleft.isChecked) {
                                        ch9.text = "جوزة خارجية يسار و الداخليتين"
                                        customDialogFB.s3er_r2s_acx.setText("13")
                                    } else {
                                        if (customDialogFB.outsideright.isChecked && customDialogFB.outsideleft.isChecked) {
                                            ch9.text = "جوزة خارجية يمين و يسار"
                                            customDialogFB.s3er_r2s_acx.setText("6")
                                        } else {
                                            if (customDialogFB.outsideright.isChecked && customDialogFB.insideright.isChecked) {
                                                ch9.text = "جوزة خارجية يمين و داخلية يمين"
                                                customDialogFB.s3er_r2s_acx.setText("8")
                                            } else {
                                                if (customDialogFB.outsideright.isChecked && customDialogFB.insideleft.isChecked) {
                                                    ch9.text = "جوزة خارجية يمين و داخلية يسار"
                                                    customDialogFB.s3er_r2s_acx.setText("8")
                                                } else {
                                                    if (customDialogFB.outsideleft.isChecked && customDialogFB.insideright.isChecked) {
                                                        ch9.text =
                                                            "جوزة خارجية يسار و داخلية يمين"
                                                        customDialogFB.s3er_r2s_acx.setText("8")
                                                    } else {
                                                        if (customDialogFB.outsideleft.isChecked && customDialogFB.insideleft.isChecked) {
                                                            ch9.text =
                                                                "جوزة خارجية يسار و داخلية يسار"
                                                            customDialogFB.s3er_r2s_acx.setText("8")
                                                        } else {
                                                            if (customDialogFB.insideright.isChecked && customDialogFB.insideleft.isChecked) {
                                                                ch9.text =
                                                                    "جوزة داخلية يمين و يسار"
                                                                customDialogFB.s3er_r2s_acx.setText(
                                                                    "10"
                                                                )
                                                            } else {

                                                                if (customDialogFB.outsideright.isChecked) {
                                                                    ch9.text =
                                                                        "جوزة خارجية يمين"
                                                                    customDialogFB.s3er_r2s_acx.setText(
                                                                        "3"
                                                                    )
                                                                }
                                                                if (customDialogFB.outsideleft.isChecked) {
                                                                    ch9.text =
                                                                        "جوزة خارجية يسار"
                                                                    customDialogFB.s3er_r2s_acx.setText(
                                                                        "3"
                                                                    )
                                                                }

                                                                if (customDialogFB.insideleft.isChecked) {
                                                                    ch9.text =
                                                                        "جوزة داخلية يسار"
                                                                    customDialogFB.s3er_r2s_acx.setText(
                                                                        "5"
                                                                    )
                                                                }
                                                                if (customDialogFB.insideright.isChecked) {
                                                                    ch9.text =
                                                                        "جوزة داخلية يمين"
                                                                    customDialogFB.s3er_r2s_acx.setText(
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
                    customDialogFB.show()
                }



                customDialogFB.insideleft.setOnCheckedChangeListener { _, isChecked2 ->
                    if (customDialogFB.outsideright.isChecked) {
                        ch9.text = "جوزة خارجية يمين"
                    } else {
                        ch9.text = "جوزة"
                        customDialogFB.s3er_r2s_acx.setText("")
                    }

                    if (customDialogFB.outsideright.isChecked && customDialogFB.outsideleft.isChecked && customDialogFB.insideright.isChecked && customDialogFB.insideleft.isChecked) {
                        ch9.text = "تغير جميع الجوزات"
                        customDialogFB.s3er_r2s_acx.setText("16")
                    } else {
                        if (customDialogFB.outsideright.isChecked && customDialogFB.outsideleft.isChecked && customDialogFB.insideright.isChecked) {
                            ch9.text = "جوزتين خارجيات و الداخلية يمين"
                            customDialogFB.s3er_r2s_acx.setText("11")
                        } else {
                            if (customDialogFB.outsideright.isChecked && customDialogFB.outsideleft.isChecked && customDialogFB.insideleft.isChecked) {
                                ch9.text = "جوزتين خارجيات و الداخلية يسار"
                                customDialogFB.s3er_r2s_acx.setText("11")
                            } else {
                                if (customDialogFB.outsideright.isChecked && customDialogFB.insideright.isChecked && customDialogFB.insideleft.isChecked) {
                                    ch9.text = "جوزة خارجية يمين و الداخليتين"
                                    customDialogFB.s3er_r2s_acx.setText("13")
                                } else {
                                    if (customDialogFB.outsideleft.isChecked && customDialogFB.insideright.isChecked && customDialogFB.insideleft.isChecked) {
                                        ch9.text = "جوزة خارجية يسار و الداخليتين"
                                        customDialogFB.s3er_r2s_acx.setText("13")
                                    } else {
                                        if (customDialogFB.outsideright.isChecked && customDialogFB.outsideleft.isChecked) {
                                            ch9.text = "جوزة خارجية يمين و يسار"
                                            customDialogFB.s3er_r2s_acx.setText("6")
                                        } else {
                                            if (customDialogFB.outsideright.isChecked && customDialogFB.insideright.isChecked) {
                                                ch9.text = "جوزة خارجية يمين و داخلية يمين"
                                                customDialogFB.s3er_r2s_acx.setText("8")
                                            } else {
                                                if (customDialogFB.outsideright.isChecked && customDialogFB.insideleft.isChecked) {
                                                    ch9.text = "جوزة خارجية يمين و داخلية يسار"
                                                    customDialogFB.s3er_r2s_acx.setText("8")
                                                } else {
                                                    if (customDialogFB.outsideleft.isChecked && customDialogFB.insideright.isChecked) {
                                                        ch9.text =
                                                            "جوزة خارجية يسار و داخلية يمين"
                                                        customDialogFB.s3er_r2s_acx.setText("8")
                                                    } else {
                                                        if (customDialogFB.outsideleft.isChecked && customDialogFB.insideleft.isChecked) {
                                                            ch9.text =
                                                                "جوزة خارجية يسار و داخلية يسار"
                                                            customDialogFB.s3er_r2s_acx.setText("8")
                                                        } else {
                                                            if (customDialogFB.insideright.isChecked && customDialogFB.insideleft.isChecked) {
                                                                ch9.text =
                                                                    "جوزة داخلية يمين و يسار"
                                                                customDialogFB.s3er_r2s_acx.setText(
                                                                    "10"
                                                                )
                                                            } else {

                                                                if (customDialogFB.outsideright.isChecked) {
                                                                    ch9.text =
                                                                        "جوزة خارجية يمين"
                                                                    customDialogFB.s3er_r2s_acx.setText(
                                                                        "3"
                                                                    )
                                                                }
                                                                if (customDialogFB.outsideleft.isChecked) {
                                                                    ch9.text =
                                                                        "جوزة خارجية يسار"
                                                                    customDialogFB.s3er_r2s_acx.setText(
                                                                        "3"
                                                                    )
                                                                }

                                                                if (customDialogFB.insideleft.isChecked) {
                                                                    ch9.text =
                                                                        "جوزة داخلية يسار"
                                                                    customDialogFB.s3er_r2s_acx.setText(
                                                                        "5"
                                                                    )
                                                                }
                                                                if (customDialogFB.insideright.isChecked) {
                                                                    ch9.text =
                                                                        "جوزة داخلية يمين"
                                                                    customDialogFB.s3er_r2s_acx.setText(
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

                    customDialogFB.show()
                }

                customDialogFB.insideright.setOnCheckedChangeListener { _, isChecked2 ->
                    if (customDialogFB.outsideright.isChecked) {
                        ch9.text = "جوزة خارجية يمين"
                    } else {
                        ch9.text = "جوزة"
                        customDialogFB.s3er_r2s_acx.setText("")
                    }

                    if (customDialogFB.outsideright.isChecked && customDialogFB.outsideleft.isChecked && customDialogFB.insideright.isChecked && customDialogFB.insideleft.isChecked) {
                        ch9.text = "تغير جميع الجوزات"
                        customDialogFB.s3er_r2s_acx.setText("16")
                    } else {
                        if (customDialogFB.outsideright.isChecked && customDialogFB.outsideleft.isChecked && customDialogFB.insideright.isChecked) {
                            ch9.text = "جوزتين خارجيات و الداخلية يمين"
                            customDialogFB.s3er_r2s_acx.setText("11")
                        } else {
                            if (customDialogFB.outsideright.isChecked && customDialogFB.outsideleft.isChecked && customDialogFB.insideleft.isChecked) {
                                ch9.text = "جوزتين خارجيات و الداخلية يسار"
                                customDialogFB.s3er_r2s_acx.setText("11")
                            } else {
                                if (customDialogFB.outsideright.isChecked && customDialogFB.insideright.isChecked && customDialogFB.insideleft.isChecked) {
                                    ch9.text = "جوزة خارجية يمين و الداخليتين"
                                    customDialogFB.s3er_r2s_acx.setText("13")
                                } else {
                                    if (customDialogFB.outsideleft.isChecked && customDialogFB.insideright.isChecked && customDialogFB.insideleft.isChecked) {
                                        ch9.text = "جوزة خارجية يسار و الداخليتين"
                                        customDialogFB.s3er_r2s_acx.setText("13")
                                    } else {
                                        if (customDialogFB.outsideright.isChecked && customDialogFB.outsideleft.isChecked) {
                                            ch9.text = "جوزة خارجية يمين و يسار"
                                            customDialogFB.s3er_r2s_acx.setText("6")
                                        } else {
                                            if (customDialogFB.outsideright.isChecked && customDialogFB.insideright.isChecked) {
                                                ch9.text = "جوزة خارجية يمين و داخلية يمين"
                                                customDialogFB.s3er_r2s_acx.setText("8")
                                            } else {
                                                if (customDialogFB.outsideright.isChecked && customDialogFB.insideleft.isChecked) {
                                                    ch9.text = "جوزة خارجية يمين و داخلية يسار"
                                                    customDialogFB.s3er_r2s_acx.setText("8")
                                                } else {
                                                    if (customDialogFB.outsideleft.isChecked && customDialogFB.insideright.isChecked) {
                                                        ch9.text =
                                                            "جوزة خارجية يسار و داخلية يمين"
                                                        customDialogFB.s3er_r2s_acx.setText("8")
                                                    } else {
                                                        if (customDialogFB.outsideleft.isChecked && customDialogFB.insideleft.isChecked) {
                                                            ch9.text =
                                                                "جوزة خارجية يسار و داخلية يسار"
                                                            customDialogFB.s3er_r2s_acx.setText("8")
                                                        } else {
                                                            if (customDialogFB.insideright.isChecked && customDialogFB.insideleft.isChecked) {
                                                                ch9.text =
                                                                    "جوزة داخلية يمين و يسار"
                                                                customDialogFB.s3er_r2s_acx.setText(
                                                                    "10"
                                                                )
                                                            } else {

                                                                if (customDialogFB.outsideright.isChecked) {
                                                                    ch9.text =
                                                                        "جوزة خارجية يمين"
                                                                    customDialogFB.s3er_r2s_acx.setText(
                                                                        "3"
                                                                    )
                                                                }
                                                                if (customDialogFB.outsideleft.isChecked) {
                                                                    ch9.text =
                                                                        "جوزة خارجية يسار"
                                                                    customDialogFB.s3er_r2s_acx.setText(
                                                                        "3"
                                                                    )
                                                                }

                                                                if (customDialogFB.insideleft.isChecked) {
                                                                    ch9.text =
                                                                        "جوزة داخلية يسار"
                                                                    customDialogFB.s3er_r2s_acx.setText(
                                                                        "5"
                                                                    )
                                                                }
                                                                if (customDialogFB.insideright.isChecked) {
                                                                    ch9.text =
                                                                        "جوزة داخلية يمين"
                                                                    customDialogFB.s3er_r2s_acx.setText(
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
                    customDialogFB.show()
                }


                customDialogFB.btn_r2s_sav.setOnClickListener {
                    if (!customDialogFB.outsideright.isChecked && !customDialogFB.outsideleft.isChecked
                        && !customDialogFB.insideright.isChecked && !customDialogFB.insideleft.isChecked
                    ) {
                        toast_notempty1.show()
                    } else {
                        if (customDialogFB.s3er_r2s_acx.text.toString().trim().isEmpty()) {
                            toast_notempty.show()
                        } else {
                            pricd9.text = customDialogFB.s3er_r2s_acx.text.toString()
                            viewModel.totalAmount += pricd9.text.toString().toInt()
                            toolbar?.title =  viewModel.totalAmount.toString()
                            customDialogFB.dismiss()
                        }
                    }
                }
                customDialogFB.btn_r2s_can.setOnClickListener {
                    if (pricd9.text.toString().isEmpty()) {
                        ch9.text = "جوزة"
                        ch9.isChecked = false
                    }
                    customDialogFB.dismiss()
                }

                customDialogFB.show()
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

        root.ch10.setOnCheckedChangeListener { _, isChecked ->
            if (ch10.isChecked) {

                val customDialogFB = Dialog(activity!!)
                customDialogFB.setContentView(R.layout.r2syet_2ks_dailog)
                customDialogFB.setCancelable(false)
                customDialogFB.window?.setLayout(
                    ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT
                )

                customDialogFB.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
                customDialogFB.tit_r2s_out.text="علوية"
                customDialogFB.tit_r2s_in.text="سفلية"

                customDialogFB.card_r2s_2ks.setOnTouchListener { _, event ->
                    var x = 0f
                    var y = 0f
                    when (event.action) {
                        MotionEvent.ACTION_UP -> {
                            x = event.x
                            y = event.y
                        }
                        MotionEvent.ACTION_MOVE -> {
                            customDialogFB.window?.let {
                                val params: WindowManager.LayoutParams = it.attributes
                                params.x = event.rawX.toInt() - x.toInt()
                                params.y = event.rawY.toInt() - y.toInt()
                                it.attributes = params
                            }
                        }

                        MotionEvent.ACTION_UP -> {
                            customDialogFB.window?.let {
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

                customDialogFB.outsideright.setOnCheckedChangeListener { _, isChecked1 ->

                    if (customDialogFB.outsideright.isChecked) {
                        ch10.text = "بيضة علوية يمين"
                    } else {
                        ch10.text = "بيضة"
                        customDialogFB.s3er_r2s_acx.setText("")
                    }

                    if (customDialogFB.outsideright.isChecked && customDialogFB.outsideleft.isChecked && customDialogFB.insideright.isChecked && customDialogFB.insideleft.isChecked) {
                        ch10.text = "تغير جميع البيضات"
                        customDialogFB.s3er_r2s_acx.setText("20")
                    } else {
                        if (customDialogFB.outsideright.isChecked && customDialogFB.outsideleft.isChecked && customDialogFB.insideright.isChecked) {
                            ch10.text = "بيضتين علوية و السفلية يمين"
                            customDialogFB.s3er_r2s_acx.setText("15")
                        } else {
                            if (customDialogFB.outsideright.isChecked && customDialogFB.outsideleft.isChecked && customDialogFB.insideleft.isChecked) {
                                ch10.text = "بيضتين علوية و السفلية يسار"
                                customDialogFB.s3er_r2s_acx.setText("15")
                            } else {
                                if (customDialogFB.outsideright.isChecked && customDialogFB.insideright.isChecked && customDialogFB.insideleft.isChecked) {
                                    ch10.text = "بيضة علوية يمين و السفليتين"
                                    customDialogFB.s3er_r2s_acx.setText("15")
                                } else {
                                    if (customDialogFB.outsideleft.isChecked && customDialogFB.insideright.isChecked && customDialogFB.insideleft.isChecked) {
                                        ch10.text = "بيضة علوية يسار و السفليتين"
                                        customDialogFB.s3er_r2s_acx.setText("15")
                                    } else {
                                        if (customDialogFB.outsideright.isChecked && customDialogFB.outsideleft.isChecked) {
                                            ch10.text = "بيضة علوية يمين و يسار"
                                            customDialogFB.s3er_r2s_acx.setText("10")
                                        } else {
                                            if (customDialogFB.outsideright.isChecked && customDialogFB.insideright.isChecked) {
                                                ch10.text = "بيضة علوية يمين و السفلية يمين"
                                                customDialogFB.s3er_r2s_acx.setText("10")
                                            } else {
                                                if (customDialogFB.outsideright.isChecked && customDialogFB.insideleft.isChecked) {
                                                    ch10.text = "بيضة علوية يمين و السفلية يسار"
                                                    customDialogFB.s3er_r2s_acx.setText("10")
                                                } else {
                                                    if (customDialogFB.outsideleft.isChecked && customDialogFB.insideright.isChecked) {
                                                        ch10.text =
                                                            "بيضة علوية يسار و السفلية يمين"
                                                        customDialogFB.s3er_r2s_acx.setText("10")
                                                    } else {
                                                        if (customDialogFB.outsideleft.isChecked && customDialogFB.insideleft.isChecked) {
                                                            ch10.text =
                                                                "بيضة علوية يسار و السفلية يسار"
                                                            customDialogFB.s3er_r2s_acx.setText("10")
                                                        } else {
                                                            if (customDialogFB.insideright.isChecked && customDialogFB.insideleft.isChecked) {
                                                                ch10.text =
                                                                    "بيضة سفلية يمين و يسار"
                                                                customDialogFB.s3er_r2s_acx.setText(
                                                                    "10"
                                                                )
                                                            } else {

                                                                if (customDialogFB.outsideright.isChecked) {
                                                                    ch10.text =
                                                                        "بيضة علوية يمين"
                                                                    customDialogFB.s3er_r2s_acx.setText(
                                                                        "5"
                                                                    )
                                                                }
                                                                if (customDialogFB.outsideleft.isChecked) {
                                                                    ch10.text =
                                                                        "بيضة علوية يسار"
                                                                    customDialogFB.s3er_r2s_acx.setText(
                                                                        "5"
                                                                    )
                                                                }

                                                                if (customDialogFB.insideleft.isChecked) {
                                                                    ch10.text =
                                                                        "بيضة سفلية يسار"
                                                                    customDialogFB.s3er_r2s_acx.setText(
                                                                        "5"
                                                                    )
                                                                }
                                                                if (customDialogFB.insideright.isChecked) {
                                                                    ch10.text =
                                                                        "بيضة سفلية يمين"
                                                                    customDialogFB.s3er_r2s_acx.setText(
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
                    customDialogFB.show()
                }



                customDialogFB.outsideleft.setOnCheckedChangeListener { _, isChecked2 ->
                    if (customDialogFB.outsideleft.isChecked) {
                        ch10.text = "بيضة علوية يسار"
                    } else {
                        ch10.text = "بيضة"
                        customDialogFB.s3er_r2s_acx.setText("")
                    }

                    if (customDialogFB.outsideright.isChecked && customDialogFB.outsideleft.isChecked && customDialogFB.insideright.isChecked && customDialogFB.insideleft.isChecked) {
                        ch10.text = "تغير جميع البيضات"
                        customDialogFB.s3er_r2s_acx.setText("20")
                    } else {
                        if (customDialogFB.outsideright.isChecked && customDialogFB.outsideleft.isChecked && customDialogFB.insideright.isChecked) {
                            ch10.text = "بيضتين علوية و السفلية يمين"
                            customDialogFB.s3er_r2s_acx.setText("15")
                        } else {
                            if (customDialogFB.outsideright.isChecked && customDialogFB.outsideleft.isChecked && customDialogFB.insideleft.isChecked) {
                                ch10.text = "بيضتين علوية و السفلية يسار"
                                customDialogFB.s3er_r2s_acx.setText("15")
                            } else {
                                if (customDialogFB.outsideright.isChecked && customDialogFB.insideright.isChecked && customDialogFB.insideleft.isChecked) {
                                    ch10.text = "بيضة علوية يمين و السفليتين"
                                    customDialogFB.s3er_r2s_acx.setText("15")
                                } else {
                                    if (customDialogFB.outsideleft.isChecked && customDialogFB.insideright.isChecked && customDialogFB.insideleft.isChecked) {
                                        ch10.text = "بيضة علوية يسار و السفليتين"
                                        customDialogFB.s3er_r2s_acx.setText("15")
                                    } else {
                                        if (customDialogFB.outsideright.isChecked && customDialogFB.outsideleft.isChecked) {
                                            ch10.text = "بيضة علوية يمين و يسار"
                                            customDialogFB.s3er_r2s_acx.setText("10")
                                        } else {
                                            if (customDialogFB.outsideright.isChecked && customDialogFB.insideright.isChecked) {
                                                ch10.text = "بيضة علوية يمين و السفلية يمين"
                                                customDialogFB.s3er_r2s_acx.setText("10")
                                            } else {
                                                if (customDialogFB.outsideright.isChecked && customDialogFB.insideleft.isChecked) {
                                                    ch10.text = "بيضة علوية يمين و السفلية يسار"
                                                    customDialogFB.s3er_r2s_acx.setText("10")
                                                } else {
                                                    if (customDialogFB.outsideleft.isChecked && customDialogFB.insideright.isChecked) {
                                                        ch10.text =
                                                            "بيضة علوية يسار و السفلية يمين"
                                                        customDialogFB.s3er_r2s_acx.setText("10")
                                                    } else {
                                                        if (customDialogFB.outsideleft.isChecked && customDialogFB.insideleft.isChecked) {
                                                            ch10.text =
                                                                "بيضة علوية يسار و السفلية يسار"
                                                            customDialogFB.s3er_r2s_acx.setText("10")
                                                        } else {
                                                            if (customDialogFB.insideright.isChecked && customDialogFB.insideleft.isChecked) {
                                                                ch10.text =
                                                                    "بيضة سفلية يمين و يسار"
                                                                customDialogFB.s3er_r2s_acx.setText(
                                                                    "10"
                                                                )
                                                            } else {

                                                                if (customDialogFB.outsideright.isChecked) {
                                                                    ch10.text =
                                                                        "بيضة علوية يمين"
                                                                    customDialogFB.s3er_r2s_acx.setText(
                                                                        "5"
                                                                    )
                                                                }
                                                                if (customDialogFB.outsideleft.isChecked) {
                                                                    ch10.text =
                                                                        "بيضة علوية يسار"
                                                                    customDialogFB.s3er_r2s_acx.setText(
                                                                        "5"
                                                                    )
                                                                }

                                                                if (customDialogFB.insideleft.isChecked) {
                                                                    ch10.text =
                                                                        "بيضة سفلية يسار"
                                                                    customDialogFB.s3er_r2s_acx.setText(
                                                                        "5"
                                                                    )
                                                                }
                                                                if (customDialogFB.insideright.isChecked) {
                                                                    ch10.text =
                                                                        "بيضة سفلية يمين"
                                                                    customDialogFB.s3er_r2s_acx.setText(
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
                    customDialogFB.show()
                }



                customDialogFB.insideleft.setOnCheckedChangeListener { _, isChecked2 ->
                    if (customDialogFB.outsideright.isChecked) {
                        ch10.text = "بيضة سفلية يمين"
                    } else {
                        ch10.text = "بيضة"
                        customDialogFB.s3er_r2s_acx.setText("")
                    }

                    if (customDialogFB.outsideright.isChecked && customDialogFB.outsideleft.isChecked && customDialogFB.insideright.isChecked && customDialogFB.insideleft.isChecked) {
                        ch10.text = "تغير جميع البيضات"
                        customDialogFB.s3er_r2s_acx.setText("20")
                    } else {
                        if (customDialogFB.outsideright.isChecked && customDialogFB.outsideleft.isChecked && customDialogFB.insideright.isChecked) {
                            ch10.text = "بيضتين علوية و السفلية يمين"
                            customDialogFB.s3er_r2s_acx.setText("15")
                        } else {
                            if (customDialogFB.outsideright.isChecked && customDialogFB.outsideleft.isChecked && customDialogFB.insideleft.isChecked) {
                                ch10.text = "بيضتين علوية و السفلية يسار"
                                customDialogFB.s3er_r2s_acx.setText("15")
                            } else {
                                if (customDialogFB.outsideright.isChecked && customDialogFB.insideright.isChecked && customDialogFB.insideleft.isChecked) {
                                    ch10.text = "بيضة علوية يمين و السفليتين"
                                    customDialogFB.s3er_r2s_acx.setText("15")
                                } else {
                                    if (customDialogFB.outsideleft.isChecked && customDialogFB.insideright.isChecked && customDialogFB.insideleft.isChecked) {
                                        ch10.text = "بيضة علوية يسار و السفليتين"
                                        customDialogFB.s3er_r2s_acx.setText("15")
                                    } else {
                                        if (customDialogFB.outsideright.isChecked && customDialogFB.outsideleft.isChecked) {
                                            ch10.text = "بيضة علوية يمين و يسار"
                                            customDialogFB.s3er_r2s_acx.setText("10")
                                        } else {
                                            if (customDialogFB.outsideright.isChecked && customDialogFB.insideright.isChecked) {
                                                ch10.text = "بيضة علوية يمين و السفلية يمين"
                                                customDialogFB.s3er_r2s_acx.setText("10")
                                            } else {
                                                if (customDialogFB.outsideright.isChecked && customDialogFB.insideleft.isChecked) {
                                                    ch10.text = "بيضة علوية يمين و السفلية يسار"
                                                    customDialogFB.s3er_r2s_acx.setText("10")
                                                } else {
                                                    if (customDialogFB.outsideleft.isChecked && customDialogFB.insideright.isChecked) {
                                                        ch10.text =
                                                            "بيضة علوية يسار و السفلية يمين"
                                                        customDialogFB.s3er_r2s_acx.setText("10")
                                                    } else {
                                                        if (customDialogFB.outsideleft.isChecked && customDialogFB.insideleft.isChecked) {
                                                            ch10.text =
                                                                "بيضة علوية يسار و السفلية يسار"
                                                            customDialogFB.s3er_r2s_acx.setText("10")
                                                        } else {
                                                            if (customDialogFB.insideright.isChecked && customDialogFB.insideleft.isChecked) {
                                                                ch10.text =
                                                                    "بيضة سفلية يمين و يسار"
                                                                customDialogFB.s3er_r2s_acx.setText(
                                                                    "10"
                                                                )
                                                            } else {

                                                                if (customDialogFB.outsideright.isChecked) {
                                                                    ch10.text =
                                                                        "بيضة علوية يمين"
                                                                    customDialogFB.s3er_r2s_acx.setText(
                                                                        "5"
                                                                    )
                                                                }
                                                                if (customDialogFB.outsideleft.isChecked) {
                                                                    ch10.text =
                                                                        "بيضة علوية يسار"
                                                                    customDialogFB.s3er_r2s_acx.setText(
                                                                        "5"
                                                                    )
                                                                }

                                                                if (customDialogFB.insideleft.isChecked) {
                                                                    ch10.text =
                                                                        "بيضة سفلية يسار"
                                                                    customDialogFB.s3er_r2s_acx.setText(
                                                                        "5"
                                                                    )
                                                                }
                                                                if (customDialogFB.insideright.isChecked) {
                                                                    ch10.text =
                                                                        "بيضة سفلية يمين"
                                                                    customDialogFB.s3er_r2s_acx.setText(
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

                    customDialogFB.show()
                }

                customDialogFB.insideright.setOnCheckedChangeListener { _, isChecked2 ->
                    if (customDialogFB.outsideright.isChecked) {
                        ch10.text = "بيضة سفلية يمين"
                    } else {
                        ch10.text = "بيضة"
                        customDialogFB.s3er_r2s_acx.setText("")
                    }

                    if (customDialogFB.outsideright.isChecked && customDialogFB.outsideleft.isChecked && customDialogFB.insideright.isChecked && customDialogFB.insideleft.isChecked) {
                        ch10.text = "تغير جميع البيضات"
                        customDialogFB.s3er_r2s_acx.setText("20")
                    } else {
                        if (customDialogFB.outsideright.isChecked && customDialogFB.outsideleft.isChecked && customDialogFB.insideright.isChecked) {
                            ch10.text = "بيضتين علوية و السفلية يمين"
                            customDialogFB.s3er_r2s_acx.setText("15")
                        } else {
                            if (customDialogFB.outsideright.isChecked && customDialogFB.outsideleft.isChecked && customDialogFB.insideleft.isChecked) {
                                ch10.text = "بيضتين علوية و السفلية يسار"
                                customDialogFB.s3er_r2s_acx.setText("15")
                            } else {
                                if (customDialogFB.outsideright.isChecked && customDialogFB.insideright.isChecked && customDialogFB.insideleft.isChecked) {
                                    ch10.text = "بيضة علوية يمين و السفليتين"
                                    customDialogFB.s3er_r2s_acx.setText("15")
                                } else {
                                    if (customDialogFB.outsideleft.isChecked && customDialogFB.insideright.isChecked && customDialogFB.insideleft.isChecked) {
                                        ch10.text = "بيضة علوية يسار و السفليتين"
                                        customDialogFB.s3er_r2s_acx.setText("15")
                                    } else {
                                        if (customDialogFB.outsideright.isChecked && customDialogFB.outsideleft.isChecked) {
                                            ch10.text = "بيضة علوية يمين و يسار"
                                            customDialogFB.s3er_r2s_acx.setText("10")
                                        } else {
                                            if (customDialogFB.outsideright.isChecked && customDialogFB.insideright.isChecked) {
                                                ch10.text = "بيضة علوية يمين و السفلية يمين"
                                                customDialogFB.s3er_r2s_acx.setText("10")
                                            } else {
                                                if (customDialogFB.outsideright.isChecked && customDialogFB.insideleft.isChecked) {
                                                    ch10.text = "بيضة علوية يمين و السفلية يسار"
                                                    customDialogFB.s3er_r2s_acx.setText("10")
                                                } else {
                                                    if (customDialogFB.outsideleft.isChecked && customDialogFB.insideright.isChecked) {
                                                        ch10.text =
                                                            "بيضة علوية يسار و السفلية يمين"
                                                        customDialogFB.s3er_r2s_acx.setText("10")
                                                    } else {
                                                        if (customDialogFB.outsideleft.isChecked && customDialogFB.insideleft.isChecked) {
                                                            ch10.text =
                                                                "بيضة علوية يسار و السفلية يسار"
                                                            customDialogFB.s3er_r2s_acx.setText("10")
                                                        } else {
                                                            if (customDialogFB.insideright.isChecked && customDialogFB.insideleft.isChecked) {
                                                                ch10.text =
                                                                    "بيضة سفلية يمين و يسار"
                                                                customDialogFB.s3er_r2s_acx.setText(
                                                                    "10"
                                                                )
                                                            } else {

                                                                if (customDialogFB.outsideright.isChecked) {
                                                                    ch10.text =
                                                                        "بيضة علوية يمين"
                                                                    customDialogFB.s3er_r2s_acx.setText(
                                                                        "5"
                                                                    )
                                                                }
                                                                if (customDialogFB.outsideleft.isChecked) {
                                                                    ch10.text =
                                                                        "بيضة علوية يسار"
                                                                    customDialogFB.s3er_r2s_acx.setText(
                                                                        "5"
                                                                    )
                                                                }

                                                                if (customDialogFB.insideleft.isChecked) {
                                                                    ch10.text =
                                                                        "بيضة سفلية يسار"
                                                                    customDialogFB.s3er_r2s_acx.setText(
                                                                        "5"
                                                                    )
                                                                }
                                                                if (customDialogFB.insideright.isChecked) {
                                                                    ch10.text =
                                                                        "بيضة سفلية يمين"
                                                                    customDialogFB.s3er_r2s_acx.setText(
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
                    customDialogFB.show()
                }


                customDialogFB.btn_r2s_sav.setOnClickListener {
                    if (!customDialogFB.outsideright.isChecked && !customDialogFB.outsideleft.isChecked
                        && !customDialogFB.insideright.isChecked && !customDialogFB.insideleft.isChecked
                    ) {
                        toast_notempty1.show()
                    } else {
                        if (customDialogFB.s3er_r2s_acx.text.toString().trim().isEmpty()) {
                            toast_notempty.show()
//                            ch10.isChecked = false
                        } else {
                            editTextNumber10.text = customDialogFB.s3er_r2s_acx.text.toString()
                            viewModel.totalAmount += editTextNumber10.text.toString().toInt()
                            toolbar?.title =  viewModel.totalAmount.toString()
                            customDialogFB.dismiss()
                        }
                    }
                }
                customDialogFB.btn_r2s_can.setOnClickListener {
                    if (editTextNumber10.text.toString().isEmpty()) {
                        ch10.text = "بيضة"
                        ch10.isChecked = false
                    }
                    customDialogFB.dismiss()
                }

                customDialogFB.show()
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

        root.ch11.setOnCheckedChangeListener { _, isChecked ->
            if (ch11.isChecked) {
                val customDialogFB = Dialog(activity!!)
                customDialogFB.setContentView(R.layout.front_dailog)
                customDialogFB.setCancelable(false)
                customDialogFB.window?.setLayout(
                    ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT
                )

                val window = customDialogFB.window
                window?.setGravity(Gravity.TOP)
                val lp = window?.attributes
                lp?.dimAmount = 0.0f
                lp?.flags = lp?.flags?.or(WindowManager.LayoutParams.FLAG_DIM_BEHIND)
                window?.attributes = lp

                customDialogFB.frontright.setOnCheckedChangeListener { _, isChecked1 ->
                    if (customDialogFB.frontright.isChecked) {
                        ch11.text = "شمزة اكس يمين"
                    } else {
                        ch11.text = "شمزة اكس"
                        customDialogFB.s3er_yadwee.setText("")
                    }
                    if (customDialogFB.frontright.isChecked && customDialogFB.frontleft.isChecked) {
                        ch11.text = "شمزة اكس يمين و يسار"
                        customDialogFB.s3er_yadwee.setText("10")
                    } else {
                        if (customDialogFB.frontright.isChecked) {
                            ch11.text = "شمزة اكس يمين"
                            customDialogFB.s3er_yadwee.setText("5")
                        }
                        if (customDialogFB.frontleft.isChecked) {
                            ch11.text = "شمزة اكس يسار"
                            customDialogFB.s3er_yadwee.setText("5")
                        }
                    }
                }

                customDialogFB.frontleft.setOnCheckedChangeListener { _, isChecked2 ->
                    if (customDialogFB.frontleft.isChecked) {
                        ch11.text = "شمزة اكس يسار"
                    } else {
                        ch11.text = "شمزة اكس"
                        customDialogFB.s3er_yadwee.setText("")
                    }
                    if (customDialogFB.frontright.isChecked && customDialogFB.frontleft.isChecked) {
                        ch11.text = "شمزة اكس يمين و يسار"
                        customDialogFB.s3er_yadwee.setText("10")
                    } else {
                        if (customDialogFB.frontleft.isChecked) {
                            ch11.text = "شمزة اكس يسار"
                            customDialogFB.s3er_yadwee.setText("5")
                        }
                        if (customDialogFB.frontright.isChecked) {
                            ch11.text = "شمزة اكس يمين"
                            customDialogFB.s3er_yadwee.setText("5")
                        }
                    }
                }

                customDialogFB.button_dailog_save.setOnClickListener {
                    if (!customDialogFB.frontright.isChecked && !customDialogFB.frontleft.isChecked) {
                        toast_notempty1.show()
                    } else {
                        if (customDialogFB.s3er_yadwee.text.toString().trim().isEmpty()) {
                            toast_notempty.show()
                            ch11.isChecked = false
                        } else {
                            editTextNumber11.text = customDialogFB.s3er_yadwee.text.toString()
                            viewModel.totalAmount += editTextNumber11.text.toString().toInt()
                            toolbar?.title =  viewModel.totalAmount.toString()
                            customDialogFB.dismiss()
                        }
                    }
                }
                customDialogFB.button_dailog_cancel.setOnClickListener {
                    ch11.isChecked = false
                    customDialogFB.s3er_yadwee.setText("")
                    customDialogFB.dismiss()
                }
                customDialogFB.show()
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

        root.ch12.setOnCheckedChangeListener { _, isChecked ->
            if (ch12.isChecked) {

                val customDialogFB = Dialog(activity!!)
                customDialogFB.setContentView(R.layout.r2syet_2ks_dailog)
                customDialogFB.setCancelable(false)
                customDialogFB.window?.setLayout(
                    ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT
                )

                customDialogFB.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

                customDialogFB.card_r2s_2ks.setOnTouchListener { _, event ->
                    var x = 0f
                    var y = 0f
                    when (event.action) {
                        MotionEvent.ACTION_UP -> {
                            x = event.x
                            y = event.y
                        }
                        MotionEvent.ACTION_MOVE -> {
                            customDialogFB.window?.let {
                                val params: WindowManager.LayoutParams = it.attributes
                                params.x = event.rawX.toInt() - x.toInt()
                                params.y = event.rawY.toInt() - y.toInt()
                                it.attributes = params
                            }
                        }

                        MotionEvent.ACTION_UP -> {
                            customDialogFB.window?.let {
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

                customDialogFB.outsideright.setOnCheckedChangeListener { _, isChecked1 ->

                    if (customDialogFB.outsideright.isChecked) {
                        ch12.text = "عمود توازن جوزة امامي يمين"
                    } else {
                        ch12.text = "عمود توازن جوزة"
                        customDialogFB.s3er_r2s_acx.setText("")
                    }

                    if (customDialogFB.outsideright.isChecked && customDialogFB.outsideleft.isChecked && customDialogFB.insideright.isChecked && customDialogFB.insideleft.isChecked) {
                        ch12.text = "تغير جميع عمدان توازن جوزة"
                        customDialogFB.s3er_r2s_acx.setText("12")
                    } else {
                        if (customDialogFB.outsideright.isChecked && customDialogFB.outsideleft.isChecked && customDialogFB.insideright.isChecked) {
                            ch12.text = "عمدان توازن جوزة امامي و الخلفي يمين"
                            customDialogFB.s3er_r2s_acx.setText("9")
                        } else {
                            if (customDialogFB.outsideright.isChecked && customDialogFB.outsideleft.isChecked && customDialogFB.insideleft.isChecked) {
                                ch12.text = "عمدان توازن جوزة امامي و الخلفي يسار"
                                customDialogFB.s3er_r2s_acx.setText("9")
                            } else {
                                if (customDialogFB.outsideright.isChecked && customDialogFB.insideright.isChecked && customDialogFB.insideleft.isChecked) {
                                    ch12.text = "عمود توازن جوزة امامي يمين و الخلفيين"
                                    customDialogFB.s3er_r2s_acx.setText("9")
                                } else {
                                    if (customDialogFB.outsideleft.isChecked && customDialogFB.insideright.isChecked && customDialogFB.insideleft.isChecked) {
                                        ch12.text = "عمود توازن جوزة امامي يسار و الخلفيين"
                                        customDialogFB.s3er_r2s_acx.setText("9")
                                    } else {
                                        if (customDialogFB.outsideright.isChecked && customDialogFB.outsideleft.isChecked) {
                                            ch12.text = "عمود توازن جوزة امامي يمين و يسار"
                                            customDialogFB.s3er_r2s_acx.setText("6")
                                        } else {
                                            if (customDialogFB.outsideright.isChecked && customDialogFB.insideright.isChecked) {
                                                ch12.text = "عمود توازن جوزة امامي يمين و الخلفي يمين"
                                                customDialogFB.s3er_r2s_acx.setText("6")
                                            } else {
                                                if (customDialogFB.outsideright.isChecked && customDialogFB.insideleft.isChecked) {
                                                    ch12.text = "عمود توازن جوزة امامي يمين و الخلفي يسار"
                                                    customDialogFB.s3er_r2s_acx.setText("6")
                                                } else {
                                                    if (customDialogFB.outsideleft.isChecked && customDialogFB.insideright.isChecked) {
                                                        ch12.text =
                                                            "عمود توازن جوزة امامي يسار و الخلفي يمين"
                                                        customDialogFB.s3er_r2s_acx.setText("6")
                                                    } else {
                                                        if (customDialogFB.outsideleft.isChecked && customDialogFB.insideleft.isChecked) {
                                                            ch12.text =
                                                                "عمود توازن جوزة امامي يسار و الخلفي يسار"
                                                            customDialogFB.s3er_r2s_acx.setText("6")
                                                        } else {
                                                            if (customDialogFB.insideright.isChecked && customDialogFB.insideleft.isChecked) {
                                                                ch12.text =
                                                                    "عمود توازن جوزة خلفي يمين و يسار"
                                                                customDialogFB.s3er_r2s_acx.setText(
                                                                    "6"
                                                                )
                                                            } else {

                                                                if (customDialogFB.outsideright.isChecked) {
                                                                    ch12.text =
                                                                        "عمود توازن جوزة امامي يمين"
                                                                    customDialogFB.s3er_r2s_acx.setText(
                                                                        "3"
                                                                    )
                                                                }
                                                                if (customDialogFB.outsideleft.isChecked) {
                                                                    ch12.text =
                                                                        "عمود توازن جوزة امامي يسار"
                                                                    customDialogFB.s3er_r2s_acx.setText(
                                                                        "3"
                                                                    )
                                                                }

                                                                if (customDialogFB.insideleft.isChecked) {
                                                                    ch12.text =
                                                                        "عمود توازن جوزة خلفي يسار"
                                                                    customDialogFB.s3er_r2s_acx.setText(
                                                                        "3"
                                                                    )
                                                                }
                                                                if (customDialogFB.insideright.isChecked) {
                                                                    ch12.text =
                                                                        "عمود توازن جوزة خلفي يمين"
                                                                    customDialogFB.s3er_r2s_acx.setText(
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
                    customDialogFB.show()
                }



                customDialogFB.outsideleft.setOnCheckedChangeListener { _, isChecked2 ->
                    if (customDialogFB.outsideleft.isChecked) {
                        ch12.text = "عمود توازن جوزة امامي يمين"
                    } else {
                        ch12.text = "عمود توازن جوزة"
                        customDialogFB.s3er_r2s_acx.setText("")
                    }

                    if (customDialogFB.outsideright.isChecked && customDialogFB.outsideleft.isChecked && customDialogFB.insideright.isChecked && customDialogFB.insideleft.isChecked) {
                        ch12.text = "تغير جميع عمدان توازن جوزة"
                        customDialogFB.s3er_r2s_acx.setText("12")
                    } else {
                        if (customDialogFB.outsideright.isChecked && customDialogFB.outsideleft.isChecked && customDialogFB.insideright.isChecked) {
                            ch12.text = "عمدان توازن جوزة امامي و الخلفي يمين"
                            customDialogFB.s3er_r2s_acx.setText("9")
                        } else {
                            if (customDialogFB.outsideright.isChecked && customDialogFB.outsideleft.isChecked && customDialogFB.insideleft.isChecked) {
                                ch12.text = "عمدان توازن جوزة امامي و الخلفي يسار"
                                customDialogFB.s3er_r2s_acx.setText("9")
                            } else {
                                if (customDialogFB.outsideright.isChecked && customDialogFB.insideright.isChecked && customDialogFB.insideleft.isChecked) {
                                    ch12.text = "عمود توازن جوزة امامي يمين و الخلفيين"
                                    customDialogFB.s3er_r2s_acx.setText("9")
                                } else {
                                    if (customDialogFB.outsideleft.isChecked && customDialogFB.insideright.isChecked && customDialogFB.insideleft.isChecked) {
                                        ch12.text = "عمود توازن جوزة امامي يسار و الخلفيين"
                                        customDialogFB.s3er_r2s_acx.setText("9")
                                    } else {
                                        if (customDialogFB.outsideright.isChecked && customDialogFB.outsideleft.isChecked) {
                                            ch12.text = "عمود توازن جوزة امامي يمين و يسار"
                                            customDialogFB.s3er_r2s_acx.setText("6")
                                        } else {
                                            if (customDialogFB.outsideright.isChecked && customDialogFB.insideright.isChecked) {
                                                ch12.text = "عمود توازن جوزة امامي يمين و الخلفي يمين"
                                                customDialogFB.s3er_r2s_acx.setText("6")
                                            } else {
                                                if (customDialogFB.outsideright.isChecked && customDialogFB.insideleft.isChecked) {
                                                    ch12.text = "عمود توازن جوزة امامي يمين و الخلفي يسار"
                                                    customDialogFB.s3er_r2s_acx.setText("6")
                                                } else {
                                                    if (customDialogFB.outsideleft.isChecked && customDialogFB.insideright.isChecked) {
                                                        ch12.text =
                                                            "عمود توازن جوزة امامي يسار و الخلفي يمين"
                                                        customDialogFB.s3er_r2s_acx.setText("6")
                                                    } else {
                                                        if (customDialogFB.outsideleft.isChecked && customDialogFB.insideleft.isChecked) {
                                                            ch12.text =
                                                                "عمود توازن جوزة امامي يسار و الخلفي يسار"
                                                            customDialogFB.s3er_r2s_acx.setText("6")
                                                        } else {
                                                            if (customDialogFB.insideright.isChecked && customDialogFB.insideleft.isChecked) {
                                                                ch12.text =
                                                                    "عمود توازن جوزة خلفي يمين و يسار"
                                                                customDialogFB.s3er_r2s_acx.setText(
                                                                    "6"
                                                                )
                                                            } else {

                                                                if (customDialogFB.outsideright.isChecked) {
                                                                    ch12.text =
                                                                        "عمود توازن جوزة امامي يمين"
                                                                    customDialogFB.s3er_r2s_acx.setText(
                                                                        "3"
                                                                    )
                                                                }
                                                                if (customDialogFB.outsideleft.isChecked) {
                                                                    ch12.text =
                                                                        "عمود توازن جوزة امامي يسار"
                                                                    customDialogFB.s3er_r2s_acx.setText(
                                                                        "3"
                                                                    )
                                                                }

                                                                if (customDialogFB.insideleft.isChecked) {
                                                                    ch12.text =
                                                                        "عمود توازن جوزة خلفي يسار"
                                                                    customDialogFB.s3er_r2s_acx.setText(
                                                                        "3"
                                                                    )
                                                                }
                                                                if (customDialogFB.insideright.isChecked) {
                                                                    ch12.text =
                                                                        "عمود توازن جوزة خلفي يمين"
                                                                    customDialogFB.s3er_r2s_acx.setText(
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
                    customDialogFB.show()
                }



                customDialogFB.insideleft.setOnCheckedChangeListener { _, isChecked2 ->
                    if (customDialogFB.outsideright.isChecked) {
                        ch12.text = "عمود توازن جوزة امامي يمين"
                    } else {
                        ch12.text = "عمود توازن جوزة"
                        customDialogFB.s3er_r2s_acx.setText("")
                    }

                    if (customDialogFB.outsideright.isChecked && customDialogFB.outsideleft.isChecked && customDialogFB.insideright.isChecked && customDialogFB.insideleft.isChecked) {
                        ch12.text = "تغير جميع عمدان توازن جوزة"
                        customDialogFB.s3er_r2s_acx.setText("12")
                    } else {
                        if (customDialogFB.outsideright.isChecked && customDialogFB.outsideleft.isChecked && customDialogFB.insideright.isChecked) {
                            ch12.text = "عمدان توازن جوزة امامي و الخلفي يمين"
                            customDialogFB.s3er_r2s_acx.setText("9")
                        } else {
                            if (customDialogFB.outsideright.isChecked && customDialogFB.outsideleft.isChecked && customDialogFB.insideleft.isChecked) {
                                ch12.text = "عمدان توازن جوزة امامي و الخلفي يسار"
                                customDialogFB.s3er_r2s_acx.setText("9")
                            } else {
                                if (customDialogFB.outsideright.isChecked && customDialogFB.insideright.isChecked && customDialogFB.insideleft.isChecked) {
                                    ch12.text = "عمود توازن جوزة امامي يمين و الخلفيين"
                                    customDialogFB.s3er_r2s_acx.setText("9")
                                } else {
                                    if (customDialogFB.outsideleft.isChecked && customDialogFB.insideright.isChecked && customDialogFB.insideleft.isChecked) {
                                        ch12.text = "عمود توازن جوزة امامي يسار و الخلفيين"
                                        customDialogFB.s3er_r2s_acx.setText("9")
                                    } else {
                                        if (customDialogFB.outsideright.isChecked && customDialogFB.outsideleft.isChecked) {
                                            ch12.text = "عمود توازن جوزة امامي يمين و يسار"
                                            customDialogFB.s3er_r2s_acx.setText("6")
                                        } else {
                                            if (customDialogFB.outsideright.isChecked && customDialogFB.insideright.isChecked) {
                                                ch12.text = "عمود توازن جوزة امامي يمين و الخلفي يمين"
                                                customDialogFB.s3er_r2s_acx.setText("6")
                                            } else {
                                                if (customDialogFB.outsideright.isChecked && customDialogFB.insideleft.isChecked) {
                                                    ch12.text = "عمود توازن جوزة امامي يمين و الخلفي يسار"
                                                    customDialogFB.s3er_r2s_acx.setText("6")
                                                } else {
                                                    if (customDialogFB.outsideleft.isChecked && customDialogFB.insideright.isChecked) {
                                                        ch12.text =
                                                            "عمود توازن جوزة امامي يسار و الخلفي يمين"
                                                        customDialogFB.s3er_r2s_acx.setText("6")
                                                    } else {
                                                        if (customDialogFB.outsideleft.isChecked && customDialogFB.insideleft.isChecked) {
                                                            ch12.text =
                                                                "عمود توازن جوزة امامي يسار و الخلفي يسار"
                                                            customDialogFB.s3er_r2s_acx.setText("6")
                                                        } else {
                                                            if (customDialogFB.insideright.isChecked && customDialogFB.insideleft.isChecked) {
                                                                ch12.text =
                                                                    "عمود توازن جوزة خلفي يمين و يسار"
                                                                customDialogFB.s3er_r2s_acx.setText(
                                                                    "6"
                                                                )
                                                            } else {

                                                                if (customDialogFB.outsideright.isChecked) {
                                                                    ch12.text =
                                                                        "عمود توازن جوزة امامي يمين"
                                                                    customDialogFB.s3er_r2s_acx.setText(
                                                                        "3"
                                                                    )
                                                                }
                                                                if (customDialogFB.outsideleft.isChecked) {
                                                                    ch12.text =
                                                                        "عمود توازن جوزة امامي يسار"
                                                                    customDialogFB.s3er_r2s_acx.setText(
                                                                        "3"
                                                                    )
                                                                }

                                                                if (customDialogFB.insideleft.isChecked) {
                                                                    ch12.text =
                                                                        "عمود توازن جوزة خلفي يسار"
                                                                    customDialogFB.s3er_r2s_acx.setText(
                                                                        "3"
                                                                    )
                                                                }
                                                                if (customDialogFB.insideright.isChecked) {
                                                                    ch12.text =
                                                                        "عمود توازن جوزة خلفي يمين"
                                                                    customDialogFB.s3er_r2s_acx.setText(
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

                    customDialogFB.show()
                }

                customDialogFB.insideright.setOnCheckedChangeListener { _, isChecked2 ->
                    if (customDialogFB.outsideright.isChecked) {
                        ch12.text = "عمود توازن جوزة امامي يمين"
                    } else {
                        ch12.text = "عمود توازن جوزة"
                        customDialogFB.s3er_r2s_acx.setText("")
                    }

                    if (customDialogFB.outsideright.isChecked && customDialogFB.outsideleft.isChecked && customDialogFB.insideright.isChecked && customDialogFB.insideleft.isChecked) {
                        ch12.text = "تغير جميع عمدان توازن جوزة"
                        customDialogFB.s3er_r2s_acx.setText("12")
                    } else {
                        if (customDialogFB.outsideright.isChecked && customDialogFB.outsideleft.isChecked && customDialogFB.insideright.isChecked) {
                            ch12.text = "عمدان توازن جوزة امامي و الخلفي يمين"
                            customDialogFB.s3er_r2s_acx.setText("9")
                        } else {
                            if (customDialogFB.outsideright.isChecked && customDialogFB.outsideleft.isChecked && customDialogFB.insideleft.isChecked) {
                                ch12.text = "عمدان توازن جوزة امامي و الخلفي يسار"
                                customDialogFB.s3er_r2s_acx.setText("9")
                            } else {
                                if (customDialogFB.outsideright.isChecked && customDialogFB.insideright.isChecked && customDialogFB.insideleft.isChecked) {
                                    ch12.text = "عمود توازن جوزة امامي يمين و الخلفيين"
                                    customDialogFB.s3er_r2s_acx.setText("9")
                                } else {
                                    if (customDialogFB.outsideleft.isChecked && customDialogFB.insideright.isChecked && customDialogFB.insideleft.isChecked) {
                                        ch12.text = "عمود توازن جوزة امامي يسار و الخلفيين"
                                        customDialogFB.s3er_r2s_acx.setText("9")
                                    } else {
                                        if (customDialogFB.outsideright.isChecked && customDialogFB.outsideleft.isChecked) {
                                            ch12.text = "عمود توازن جوزة امامي يمين و يسار"
                                            customDialogFB.s3er_r2s_acx.setText("6")
                                        } else {
                                            if (customDialogFB.outsideright.isChecked && customDialogFB.insideright.isChecked) {
                                                ch12.text = "عمود توازن جوزة امامي يمين و الخلفي يمين"
                                                customDialogFB.s3er_r2s_acx.setText("6")
                                            } else {
                                                if (customDialogFB.outsideright.isChecked && customDialogFB.insideleft.isChecked) {
                                                    ch12.text = "عمود توازن جوزة امامي يمين و الخلفي يسار"
                                                    customDialogFB.s3er_r2s_acx.setText("6")
                                                } else {
                                                    if (customDialogFB.outsideleft.isChecked && customDialogFB.insideright.isChecked) {
                                                        ch12.text =
                                                            "عمود توازن جوزة امامي يسار و الخلفي يمين"
                                                        customDialogFB.s3er_r2s_acx.setText("6")
                                                    } else {
                                                        if (customDialogFB.outsideleft.isChecked && customDialogFB.insideleft.isChecked) {
                                                            ch12.text =
                                                                "عمود توازن جوزة امامي يسار و الخلفي يسار"
                                                            customDialogFB.s3er_r2s_acx.setText("6")
                                                        } else {
                                                            if (customDialogFB.insideright.isChecked && customDialogFB.insideleft.isChecked) {
                                                                ch12.text =
                                                                    "عمود توازن جوزة خلفي يمين و يسار"
                                                                customDialogFB.s3er_r2s_acx.setText(
                                                                    "6"
                                                                )
                                                            } else {

                                                                if (customDialogFB.outsideright.isChecked) {
                                                                    ch12.text =
                                                                        "عمود توازن جوزة امامي يمين"
                                                                    customDialogFB.s3er_r2s_acx.setText(
                                                                        "3"
                                                                    )
                                                                }
                                                                if (customDialogFB.outsideleft.isChecked) {
                                                                    ch12.text =
                                                                        "عمود توازن جوزة امامي يسار"
                                                                    customDialogFB.s3er_r2s_acx.setText(
                                                                        "3"
                                                                    )
                                                                }

                                                                if (customDialogFB.insideleft.isChecked) {
                                                                    ch12.text =
                                                                        "عمود توازن جوزة خلفي يسار"
                                                                    customDialogFB.s3er_r2s_acx.setText(
                                                                        "3"
                                                                    )
                                                                }
                                                                if (customDialogFB.insideright.isChecked) {
                                                                    ch12.text =
                                                                        "عمود توازن جوزة خلفي يمين"
                                                                    customDialogFB.s3er_r2s_acx.setText(
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
                    customDialogFB.show()
                }


                customDialogFB.btn_r2s_sav.setOnClickListener {
                    if (!customDialogFB.outsideright.isChecked && !customDialogFB.outsideleft.isChecked
                        && !customDialogFB.insideright.isChecked && !customDialogFB.insideleft.isChecked
                    ) {
                        toast_notempty1.show()
                    } else {
                        if (customDialogFB.s3er_r2s_acx.text.toString().trim().isEmpty()) {
                            toast_notempty.show()
                        } else {
                            editTextNumber12.text = customDialogFB.s3er_r2s_acx.text.toString()
                            viewModel.totalAmount += editTextNumber12.text.toString().toInt()
                            toolbar?.title =  viewModel.totalAmount.toString()
                            customDialogFB.dismiss()
                        }
                    }
                }
                customDialogFB.btn_r2s_can.setOnClickListener {
                    if (editTextNumber12.text.toString().isEmpty()) {
                        ch12.text = "عمود توازن جوزة"
                        ch12.isChecked = false
                    }
                    customDialogFB.dismiss()
                }

                customDialogFB.show()
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

        root.ch13.setOnCheckedChangeListener { _, isChecked ->
            if (ch13.isChecked) {
                val customDialogFB = Dialog(activity!!)
                customDialogFB.setContentView(R.layout.dialog_fa7e9)
                customDialogFB.setCancelable(false)
                customDialogFB.window?.setLayout(
                    ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT)

                customDialogFB.s3er_yadwee_fa7.setText("10")

                customDialogFB.btn_sv_dig_fa7.setOnClickListener {
                    if (customDialogFB.s3er_yadwee_fa7.text.toString().isEmpty()) {
                        toast_notempty.show()
                    } else {
                        editTextNumber13.text = customDialogFB.s3er_yadwee_fa7.text.toString()
                        viewModel.totalAmount += editTextNumber13.text.toString().toInt()
                        toolbar?.title =  viewModel.totalAmount.toString()
                        customDialogFB.dismiss()
                    }
                }
                customDialogFB.show()
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

        root.ch14.setOnCheckedChangeListener { _, isChecked ->
            if (ch14.isChecked) {

                val customDialogFB = Dialog(activity!!)
                customDialogFB.setContentView(R.layout.r2syet_2ks_dailog)
                customDialogFB.setCancelable(false)
                customDialogFB.window?.setLayout(
                    ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT
                )

                customDialogFB.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
                customDialogFB.tit_r2s_out.text="امامي"
                customDialogFB.tit_r2s_in.text="خلفي"


                customDialogFB.card_r2s_2ks.setOnTouchListener { _, event ->
                    var x = 0f
                    var y = 0f
                    when (event.action) {
                        MotionEvent.ACTION_UP -> {
                            x = event.x
                            y = event.y
                        }
                        MotionEvent.ACTION_MOVE -> {
                            customDialogFB.window?.let {
                                val params: WindowManager.LayoutParams = it.attributes
                                params.x = event.rawX.toInt() - x.toInt()
                                params.y = event.rawY.toInt() - y.toInt()
                                it.attributes = params
                            }
                        }

                        MotionEvent.ACTION_UP -> {
                            customDialogFB.window?.let {
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

                customDialogFB.outsideright.setOnCheckedChangeListener { _, isChecked1 ->

                    if (customDialogFB.outsideright.isChecked) {
                        ch14.text = "هب امامي يمين"
                    } else {
                        ch14.text = "هب"
                        customDialogFB.s3er_r2s_acx.setText("")
                    }

                    if (customDialogFB.outsideright.isChecked && customDialogFB.outsideleft.isChecked && customDialogFB.insideright.isChecked && customDialogFB.insideleft.isChecked) {
                        ch14.text = "تغير جميع الهبات"
                        customDialogFB.s3er_r2s_acx.setText("40")
                    } else {
                        if (customDialogFB.outsideright.isChecked && customDialogFB.outsideleft.isChecked && customDialogFB.insideright.isChecked) {
                            ch14.text = "هب امامي كامل و الخلفي يمين"
                            customDialogFB.s3er_r2s_acx.setText("30")
                        } else {
                            if (customDialogFB.outsideright.isChecked && customDialogFB.outsideleft.isChecked && customDialogFB.insideleft.isChecked) {
                                ch14.text = "هب امامي كامل و الخلفي يسار"
                                customDialogFB.s3er_r2s_acx.setText("30")
                            } else {
                                if (customDialogFB.outsideright.isChecked && customDialogFB.insideright.isChecked && customDialogFB.insideleft.isChecked) {
                                    ch14.text = "هب امامي يمين و الخلفيين"
                                    customDialogFB.s3er_r2s_acx.setText("30")
                                } else {
                                    if (customDialogFB.outsideleft.isChecked && customDialogFB.insideright.isChecked && customDialogFB.insideleft.isChecked) {
                                        ch14.text = "هب امامي يسار و الخلفيين"
                                        customDialogFB.s3er_r2s_acx.setText("30")
                                    } else {
                                        if (customDialogFB.outsideright.isChecked && customDialogFB.outsideleft.isChecked) {
                                            ch14.text = "هب امامي يمين و يسار"
                                            customDialogFB.s3er_r2s_acx.setText("20")
                                        } else {
                                            if (customDialogFB.outsideright.isChecked && customDialogFB.insideright.isChecked) {
                                                ch14.text = "هب امامي يمين و الخلفي يمين"
                                                customDialogFB.s3er_r2s_acx.setText("20")
                                            } else {
                                                if (customDialogFB.outsideright.isChecked && customDialogFB.insideleft.isChecked) {
                                                    ch14.text = "هب امامي يمين و الخلفي يسار"
                                                    customDialogFB.s3er_r2s_acx.setText("20")
                                                } else {
                                                    if (customDialogFB.outsideleft.isChecked && customDialogFB.insideright.isChecked) {
                                                        ch14.text =
                                                            "هب امامي يسار و الخلفي يمين"
                                                        customDialogFB.s3er_r2s_acx.setText("20")
                                                    } else {
                                                        if (customDialogFB.outsideleft.isChecked && customDialogFB.insideleft.isChecked) {
                                                            ch14.text =
                                                                "هب امامي يسار و الخلفي يسار"
                                                            customDialogFB.s3er_r2s_acx.setText("20")
                                                        } else {
                                                            if (customDialogFB.insideright.isChecked && customDialogFB.insideleft.isChecked) {
                                                                ch14.text =
                                                                    "هب خلفي يمين و يسار"
                                                                customDialogFB.s3er_r2s_acx.setText(
                                                                    "20"
                                                                )
                                                            } else {

                                                                if (customDialogFB.outsideright.isChecked) {
                                                                    ch14.text =
                                                                        "هب امامي يمين"
                                                                    customDialogFB.s3er_r2s_acx.setText(
                                                                        "10"
                                                                    )
                                                                }
                                                                if (customDialogFB.outsideleft.isChecked) {
                                                                    ch14.text =
                                                                        "هب امامي يسار"
                                                                    customDialogFB.s3er_r2s_acx.setText(
                                                                        "10"
                                                                    )
                                                                }

                                                                if (customDialogFB.insideleft.isChecked) {
                                                                    ch14.text =
                                                                        "هب خلفي يسار"
                                                                    customDialogFB.s3er_r2s_acx.setText(
                                                                        "10"
                                                                    )
                                                                }
                                                                if (customDialogFB.insideright.isChecked) {
                                                                    ch14.text =
                                                                        "هب خلفي يمين"
                                                                    customDialogFB.s3er_r2s_acx.setText(
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
                    customDialogFB.show()
                }

                customDialogFB.outsideleft.setOnCheckedChangeListener { _, isChecked2 ->
                    if (customDialogFB.outsideleft.isChecked) {
                        ch14.text = "هب امامي يمين"
                    } else {
                        ch14.text = "هب"
                        customDialogFB.s3er_r2s_acx.setText("")
                    }

                    if (customDialogFB.outsideright.isChecked && customDialogFB.outsideleft.isChecked && customDialogFB.insideright.isChecked && customDialogFB.insideleft.isChecked) {
                        ch14.text = "تغير جميع الهبات"
                        customDialogFB.s3er_r2s_acx.setText("40")
                    } else {
                        if (customDialogFB.outsideright.isChecked && customDialogFB.outsideleft.isChecked && customDialogFB.insideright.isChecked) {
                            ch14.text = "هب امامي كامل و الخلفي يمين"
                            customDialogFB.s3er_r2s_acx.setText("30")
                        } else {
                            if (customDialogFB.outsideright.isChecked && customDialogFB.outsideleft.isChecked && customDialogFB.insideleft.isChecked) {
                                ch14.text = "هب امامي كامل و الخلفي يسار"
                                customDialogFB.s3er_r2s_acx.setText("30")
                            } else {
                                if (customDialogFB.outsideright.isChecked && customDialogFB.insideright.isChecked && customDialogFB.insideleft.isChecked) {
                                    ch14.text = "هب امامي يمين و الخلفيين"
                                    customDialogFB.s3er_r2s_acx.setText("30")
                                } else {
                                    if (customDialogFB.outsideleft.isChecked && customDialogFB.insideright.isChecked && customDialogFB.insideleft.isChecked) {
                                        ch14.text = "هب امامي يسار و الخلفيين"
                                        customDialogFB.s3er_r2s_acx.setText("30")
                                    } else {
                                        if (customDialogFB.outsideright.isChecked && customDialogFB.outsideleft.isChecked) {
                                            ch14.text = "هب امامي يمين و يسار"
                                            customDialogFB.s3er_r2s_acx.setText("20")
                                        } else {
                                            if (customDialogFB.outsideright.isChecked && customDialogFB.insideright.isChecked) {
                                                ch14.text = "هب امامي يمين و الخلفي يمين"
                                                customDialogFB.s3er_r2s_acx.setText("20")
                                            } else {
                                                if (customDialogFB.outsideright.isChecked && customDialogFB.insideleft.isChecked) {
                                                    ch14.text = "هب امامي يمين و الخلفي يسار"
                                                    customDialogFB.s3er_r2s_acx.setText("20")
                                                } else {
                                                    if (customDialogFB.outsideleft.isChecked && customDialogFB.insideright.isChecked) {
                                                        ch14.text =
                                                            "هب امامي يسار و الخلفي يمين"
                                                        customDialogFB.s3er_r2s_acx.setText("20")
                                                    } else {
                                                        if (customDialogFB.outsideleft.isChecked && customDialogFB.insideleft.isChecked) {
                                                            ch14.text =
                                                                "هب امامي يسار و الخلفي يسار"
                                                            customDialogFB.s3er_r2s_acx.setText("20")
                                                        } else {
                                                            if (customDialogFB.insideright.isChecked && customDialogFB.insideleft.isChecked) {
                                                                ch14.text =
                                                                    "هب خلفي يمين و يسار"
                                                                customDialogFB.s3er_r2s_acx.setText(
                                                                    "20"
                                                                )
                                                            } else {

                                                                if (customDialogFB.outsideright.isChecked) {
                                                                    ch14.text =
                                                                        "هب امامي يمين"
                                                                    customDialogFB.s3er_r2s_acx.setText(
                                                                        "10"
                                                                    )
                                                                }
                                                                if (customDialogFB.outsideleft.isChecked) {
                                                                    ch14.text =
                                                                        "هب امامي يسار"
                                                                    customDialogFB.s3er_r2s_acx.setText(
                                                                        "10"
                                                                    )
                                                                }

                                                                if (customDialogFB.insideleft.isChecked) {
                                                                    ch14.text =
                                                                        "هب خلفي يسار"
                                                                    customDialogFB.s3er_r2s_acx.setText(
                                                                        "10"
                                                                    )
                                                                }
                                                                if (customDialogFB.insideright.isChecked) {
                                                                    ch14.text =
                                                                        "هب خلفي يمين"
                                                                    customDialogFB.s3er_r2s_acx.setText(
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
                    customDialogFB.show()
                }



                customDialogFB.insideleft.setOnCheckedChangeListener { _, isChecked2 ->
                    if (customDialogFB.outsideright.isChecked) {
                        ch14.text = "هب امامي يمين"
                    } else {
                        ch14.text = "هب"
                        customDialogFB.s3er_r2s_acx.setText("")
                    }

                    if (customDialogFB.outsideright.isChecked && customDialogFB.outsideleft.isChecked && customDialogFB.insideright.isChecked && customDialogFB.insideleft.isChecked) {
                        ch14.text = "تغير جميع الهبات"
                        customDialogFB.s3er_r2s_acx.setText("40")
                    } else {
                        if (customDialogFB.outsideright.isChecked && customDialogFB.outsideleft.isChecked && customDialogFB.insideright.isChecked) {
                            ch14.text = "هب امامي كامل و الخلفي يمين"
                            customDialogFB.s3er_r2s_acx.setText("30")
                        } else {
                            if (customDialogFB.outsideright.isChecked && customDialogFB.outsideleft.isChecked && customDialogFB.insideleft.isChecked) {
                                ch14.text = "هب امامي كامل و الخلفي يسار"
                                customDialogFB.s3er_r2s_acx.setText("30")
                            } else {
                                if (customDialogFB.outsideright.isChecked && customDialogFB.insideright.isChecked && customDialogFB.insideleft.isChecked) {
                                    ch14.text = "هب امامي يمين و الخلفيين"
                                    customDialogFB.s3er_r2s_acx.setText("30")
                                } else {
                                    if (customDialogFB.outsideleft.isChecked && customDialogFB.insideright.isChecked && customDialogFB.insideleft.isChecked) {
                                        ch14.text = "هب امامي يسار و الخلفيين"
                                        customDialogFB.s3er_r2s_acx.setText("30")
                                    } else {
                                        if (customDialogFB.outsideright.isChecked && customDialogFB.outsideleft.isChecked) {
                                            ch14.text = "هب امامي يمين و يسار"
                                            customDialogFB.s3er_r2s_acx.setText("20")
                                        } else {
                                            if (customDialogFB.outsideright.isChecked && customDialogFB.insideright.isChecked) {
                                                ch14.text = "هب امامي يمين و الخلفي يمين"
                                                customDialogFB.s3er_r2s_acx.setText("20")
                                            } else {
                                                if (customDialogFB.outsideright.isChecked && customDialogFB.insideleft.isChecked) {
                                                    ch14.text = "هب امامي يمين و الخلفي يسار"
                                                    customDialogFB.s3er_r2s_acx.setText("20")
                                                } else {
                                                    if (customDialogFB.outsideleft.isChecked && customDialogFB.insideright.isChecked) {
                                                        ch14.text =
                                                            "هب امامي يسار و الخلفي يمين"
                                                        customDialogFB.s3er_r2s_acx.setText("20")
                                                    } else {
                                                        if (customDialogFB.outsideleft.isChecked && customDialogFB.insideleft.isChecked) {
                                                            ch14.text =
                                                                "هب امامي يسار و الخلفي يسار"
                                                            customDialogFB.s3er_r2s_acx.setText("20")
                                                        } else {
                                                            if (customDialogFB.insideright.isChecked && customDialogFB.insideleft.isChecked) {
                                                                ch14.text =
                                                                    "هب خلفي يمين و يسار"
                                                                customDialogFB.s3er_r2s_acx.setText(
                                                                    "20"
                                                                )
                                                            } else {

                                                                if (customDialogFB.outsideright.isChecked) {
                                                                    ch14.text =
                                                                        "هب امامي يمين"
                                                                    customDialogFB.s3er_r2s_acx.setText(
                                                                        "10"
                                                                    )
                                                                }
                                                                if (customDialogFB.outsideleft.isChecked) {
                                                                    ch14.text =
                                                                        "هب امامي يسار"
                                                                    customDialogFB.s3er_r2s_acx.setText(
                                                                        "10"
                                                                    )
                                                                }

                                                                if (customDialogFB.insideleft.isChecked) {
                                                                    ch14.text =
                                                                        "هب خلفي يسار"
                                                                    customDialogFB.s3er_r2s_acx.setText(
                                                                        "10"
                                                                    )
                                                                }
                                                                if (customDialogFB.insideright.isChecked) {
                                                                    ch14.text =
                                                                        "هب خلفي يمين"
                                                                    customDialogFB.s3er_r2s_acx.setText(
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

                    customDialogFB.show()
                }

                customDialogFB.insideright.setOnCheckedChangeListener { _, isChecked2 ->
                    if (customDialogFB.insideright.isChecked) {
                        ch14.text = "هب امامي يمين"
                    } else {
                        ch14.text = "هب"
                        customDialogFB.s3er_r2s_acx.setText("")
                    }

                    if (customDialogFB.outsideright.isChecked && customDialogFB.outsideleft.isChecked && customDialogFB.insideright.isChecked && customDialogFB.insideleft.isChecked) {
                        ch14.text = "تغير جميع الهبات"
                        customDialogFB.s3er_r2s_acx.setText("40")
                    } else {
                        if (customDialogFB.outsideright.isChecked && customDialogFB.outsideleft.isChecked && customDialogFB.insideright.isChecked) {
                            ch14.text = "هب امامي كامل و الخلفي يمين"
                            customDialogFB.s3er_r2s_acx.setText("30")
                        } else {
                            if (customDialogFB.outsideright.isChecked && customDialogFB.outsideleft.isChecked && customDialogFB.insideleft.isChecked) {
                                ch14.text = "هب امامي كامل و الخلفي يسار"
                                customDialogFB.s3er_r2s_acx.setText("30")
                            } else {
                                if (customDialogFB.outsideright.isChecked && customDialogFB.insideright.isChecked && customDialogFB.insideleft.isChecked) {
                                    ch14.text = "هب امامي يمين و الخلفيين"
                                    customDialogFB.s3er_r2s_acx.setText("30")
                                } else {
                                    if (customDialogFB.outsideleft.isChecked && customDialogFB.insideright.isChecked && customDialogFB.insideleft.isChecked) {
                                        ch14.text = "هب امامي يسار و الخلفيين"
                                        customDialogFB.s3er_r2s_acx.setText("30")
                                    } else {
                                        if (customDialogFB.outsideright.isChecked && customDialogFB.outsideleft.isChecked) {
                                            ch14.text = "هب امامي يمين و يسار"
                                            customDialogFB.s3er_r2s_acx.setText("20")
                                        } else {
                                            if (customDialogFB.outsideright.isChecked && customDialogFB.insideright.isChecked) {
                                                ch14.text = "هب امامي يمين و الخلفي يمين"
                                                customDialogFB.s3er_r2s_acx.setText("20")
                                            } else {
                                                if (customDialogFB.outsideright.isChecked && customDialogFB.insideleft.isChecked) {
                                                    ch14.text = "هب امامي يمين و الخلفي يسار"
                                                    customDialogFB.s3er_r2s_acx.setText("20")
                                                } else {
                                                    if (customDialogFB.outsideleft.isChecked && customDialogFB.insideright.isChecked) {
                                                        ch14.text =
                                                            "هب امامي يسار و الخلفي يمين"
                                                        customDialogFB.s3er_r2s_acx.setText("20")
                                                    } else {
                                                        if (customDialogFB.outsideleft.isChecked && customDialogFB.insideleft.isChecked) {
                                                            ch14.text =
                                                                "هب امامي يسار و الخلفي يسار"
                                                            customDialogFB.s3er_r2s_acx.setText("20")
                                                        } else {
                                                            if (customDialogFB.insideright.isChecked && customDialogFB.insideleft.isChecked) {
                                                                ch14.text =
                                                                    "هب خلفي يمين و يسار"
                                                                customDialogFB.s3er_r2s_acx.setText(
                                                                    "20"
                                                                )
                                                            } else {

                                                                if (customDialogFB.outsideright.isChecked) {
                                                                    ch14.text =
                                                                        "هب امامي يمين"
                                                                    customDialogFB.s3er_r2s_acx.setText(
                                                                        "10"
                                                                    )
                                                                }
                                                                if (customDialogFB.outsideleft.isChecked) {
                                                                    ch14.text =
                                                                        "هب امامي يسار"
                                                                    customDialogFB.s3er_r2s_acx.setText(
                                                                        "10"
                                                                    )
                                                                }

                                                                if (customDialogFB.insideleft.isChecked) {
                                                                    ch14.text =
                                                                        "هب خلفي يسار"
                                                                    customDialogFB.s3er_r2s_acx.setText(
                                                                        "10"
                                                                    )
                                                                }
                                                                if (customDialogFB.insideright.isChecked) {
                                                                    ch14.text =
                                                                        "هب خلفي يمين"
                                                                    customDialogFB.s3er_r2s_acx.setText(
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
                    customDialogFB.show()
                }


                customDialogFB.btn_r2s_sav.setOnClickListener {
                    if (!customDialogFB.outsideright.isChecked && !customDialogFB.outsideleft.isChecked
                        && !customDialogFB.insideright.isChecked && !customDialogFB.insideleft.isChecked
                    ) {
                        toast_notempty1.show()
                    } else {
                        if (customDialogFB.s3er_r2s_acx.text.toString().trim().isEmpty()) {
                            toast_notempty.show()
                        } else {
                            editTextNumber14.text = customDialogFB.s3er_r2s_acx.text.toString()
                            viewModel.totalAmount += editTextNumber14.text.toString().toInt()
                            toolbar?.title =  viewModel.totalAmount.toString()
                            customDialogFB.dismiss()
                        }
                    }
                }
                customDialogFB.btn_r2s_can.setOnClickListener {
                    if (editTextNumber14.text.toString().isEmpty()) {
                        ch14.text = "هب"
                        ch14.isChecked = false
                    }
                    customDialogFB.dismiss()
                }

                customDialogFB.show()
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

        root.ch15.setOnCheckedChangeListener { _, isChecked ->
            if (ch15.isChecked) {
                val customDialogFB = Dialog(activity!!)
                customDialogFB.setContentView(R.layout.dialog_fa7e9)
                customDialogFB.setCancelable(false)
                customDialogFB.window?.setLayout(
                    ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT)

                customDialogFB.s3er_yadwee_fa7.setText("10")

                customDialogFB.btn_sv_dig_fa7.setOnClickListener {
                    if (customDialogFB.s3er_yadwee_fa7.text.toString().isEmpty()) {
                        toast_notempty.show()
                    } else {
                        editTextNumber15.text = customDialogFB.s3er_yadwee_fa7.text.toString()
                        viewModel.totalAmount += editTextNumber15.text.toString().toInt()
                        toolbar?.title =  viewModel.totalAmount.toString()
                        customDialogFB.dismiss()
                    }
                }
                customDialogFB.show()
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

        root.ch16.setOnCheckedChangeListener { _, isChecked ->
            if (ch16.isChecked) {
                val customDialogFB = Dialog(activity!!)
                customDialogFB.setContentView(R.layout.dialog_fa7e9)
                customDialogFB.setCancelable(false)
                customDialogFB.window?.setLayout(
                    ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT)

                customDialogFB.s3er_yadwee_fa7.setText("40")

                customDialogFB.btn_sv_dig_fa7.setOnClickListener {
                    if (customDialogFB.s3er_yadwee_fa7.text.toString().isEmpty()) {
                        toast_notempty.show()
                    } else {
                        editTextNumber16.text = customDialogFB.s3er_yadwee_fa7.text.toString()
                        viewModel.totalAmount += editTextNumber16.text.toString().toInt()
                        toolbar?.title =  viewModel.totalAmount.toString()
                        customDialogFB.dismiss()
                    }
                }
                customDialogFB.show()
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

        root.ch17.setOnCheckedChangeListener { _, isChecked ->
            if (ch17.isChecked) {
                val customDialogFB = Dialog(activity!!)
                customDialogFB.setContentView(R.layout.dialog_fa7e9)
                customDialogFB.setCancelable(false)
                customDialogFB.window?.setLayout(
                    ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT)

                customDialogFB.btn_sv_dig_fa7.setOnClickListener {
                    if (customDialogFB.s3er_yadwee_fa7.text.toString().isEmpty()) {
                        toast_notempty.show()
                    } else {
                        editTextNumber17.text = customDialogFB.s3er_yadwee_fa7.text.toString()
                        viewModel.totalAmount += editTextNumber17.text.toString().toInt()
                        toolbar?.title =  viewModel.totalAmount.toString()
                        customDialogFB.dismiss()
                    }
                }
                customDialogFB.show()
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

        root.ch18.setOnCheckedChangeListener { _, isChecked ->
            if (ch18.isChecked) {
                val customDialogFB = Dialog(activity!!)
                customDialogFB.setContentView(R.layout.dialog_fa7e9)
                customDialogFB.setCancelable(false)
                customDialogFB.window?.setLayout(
                    ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT)

                customDialogFB.s3er_yadwee_fa7.setText("3")

                customDialogFB.btn_sv_dig_fa7.setOnClickListener {
                    if (customDialogFB.s3er_yadwee_fa7.text.toString().isEmpty()) {
                        toast_notempty.show()
                    } else {
                        editTextNumber18.text = customDialogFB.s3er_yadwee_fa7.text.toString()
                        viewModel.totalAmount += editTextNumber18.text.toString().toInt()
                        toolbar?.title =  viewModel.totalAmount.toString()
                        customDialogFB.dismiss()
                    }
                }
                customDialogFB.show()
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

        root.ch19.setOnCheckedChangeListener { _, isChecked ->
            if (ch19.isChecked) {
                val customDialogFB = Dialog(activity!!)
                customDialogFB.setContentView(R.layout.dialog_fa7e9)
                customDialogFB.setCancelable(false)
                customDialogFB.window?.setLayout(
                    ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT)

                customDialogFB.s3er_yadwee_fa7.setText("5")

                customDialogFB.btn_sv_dig_fa7.setOnClickListener {
                    if (customDialogFB.s3er_yadwee_fa7.text.toString().isEmpty()) {
                        toast_notempty.show()
                    } else {
                        editTextNumber19.text = customDialogFB.s3er_yadwee_fa7.text.toString()
                        viewModel.totalAmount += editTextNumber19.text.toString().toInt()
                        toolbar?.title =  viewModel.totalAmount.toString()
                        customDialogFB.dismiss()
                    }
                }
                customDialogFB.show()
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

        root.ch20.setOnCheckedChangeListener { _, isChecked ->
            if (ch20.isChecked) {
                val customDialogFB = Dialog(activity!!)
                customDialogFB.setContentView(R.layout.dialog_fa7e9)
                customDialogFB.setCancelable(false)
                customDialogFB.window?.setLayout(
                    ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT)

                customDialogFB.btn_sv_dig_fa7.setOnClickListener {
                    if (customDialogFB.s3er_yadwee_fa7.text.toString().isEmpty()) {
                        toast_notempty.show()
                    } else {
                        editTextNumber20.text = customDialogFB.s3er_yadwee_fa7.text.toString()
                        viewModel.totalAmount += editTextNumber20.text.toString().toInt()
                        toolbar?.title =  viewModel.totalAmount.toString()
                        customDialogFB.dismiss()
                    }
                }
                customDialogFB.show()
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
        return root
    }
}