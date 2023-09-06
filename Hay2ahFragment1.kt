package com.example.markizalhadidi.ui.hay2ah

import android.app.Dialog
import android.graphics.Color
import android.os.Bundle
import android.text.SpannableString
import android.text.style.AbsoluteSizeSpan
import android.text.style.ForegroundColorSpan
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import android.widget.TextView
import android.widget.Toast
import android.widget.Toolbar
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.example.markizalhadidi.R
import com.example.markizalhadidi.databinding.FragmentHay2ah1Binding

class  Hay2ahFragment1 : Fragment() {

    private var _binding: FragmentHay2ah1Binding? = null
    private val binding get() = _binding!!

    private lateinit var customDialogFB_paying: Dialog
    private lateinit var customDialogMZ: Dialog
    private lateinit var customDialogF79: Dialog
    private lateinit var customDialogR2SX: Dialog
    private lateinit var customDialogBRK: Dialog
    private lateinit var customDialogFR: Dialog
    private lateinit var customDialogBL6: Dialog

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val homeViewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)

        _binding = FragmentHay2ah1Binding.inflate(inflater, container, false)
        val root: View = binding.root

        customDialogFB_paying = Dialog(activity!!)
        customDialogFB_paying.setContentView(R.layout.paying_dailog)
        customDialogFB_paying.setCancelable(false)
        customDialogFB_paying.window?.setLayout(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )
        customDialogFB_paying.window?.setFlags(WindowManager.LayoutParams.FLAG_SECURE, WindowManager.LayoutParams.FLAG_SECURE)

        customDialogMZ = Dialog(activity!!)
        customDialogMZ.setContentView(R.layout.dialog_mezan)
        customDialogMZ.setCancelable(false)
        customDialogMZ.window?.setLayout(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.WRAP_CONTENT)
        customDialogMZ.window?.setFlags(WindowManager.LayoutParams.FLAG_SECURE, WindowManager.LayoutParams.FLAG_SECURE)

        customDialogF79 = Dialog(activity!!)
        customDialogF79.setContentView(R.layout.dialog_fa7e9)
        customDialogF79.setCancelable(false)
        customDialogF79.window?.setLayout(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.WRAP_CONTENT)
        customDialogF79.window?.setFlags(WindowManager.LayoutParams.FLAG_SECURE, WindowManager.LayoutParams.FLAG_SECURE)

        customDialogR2SX = Dialog(activity!!)
        customDialogR2SX.setContentView(R.layout.r2syet_2ks_dailog)
        customDialogR2SX.setCancelable(false)
        customDialogR2SX.window?.setLayout(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )
        customDialogR2SX.window?.setFlags(WindowManager.LayoutParams.FLAG_SECURE, WindowManager.LayoutParams.FLAG_SECURE)

        customDialogBRK = Dialog(activity!!)
        customDialogBRK.setContentView(R.layout.dialog_break)
        customDialogBRK.setCancelable(false)
        customDialogBRK.window?.setLayout(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )
        customDialogBRK.window?.setFlags(WindowManager.LayoutParams.FLAG_SECURE, WindowManager.LayoutParams.FLAG_SECURE)

        customDialogFR = Dialog(activity!!)
        customDialogFR.setContentView(R.layout.front_dailog)
        customDialogFR.setCancelable(false)
        customDialogFR.window?.setLayout(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )
        customDialogFR.window?.setFlags(WindowManager.LayoutParams.FLAG_SECURE, WindowManager.LayoutParams.FLAG_SECURE)

        customDialogBL6 = Dialog(activity!!)
        customDialogBL6.setContentView(R.layout.dialog_bala6at)
        customDialogBL6.setCancelable(false)
        customDialogBL6.window?.setLayout(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )
        customDialogBL6.window?.setFlags(WindowManager.LayoutParams.FLAG_SECURE, WindowManager.LayoutParams.FLAG_SECURE)

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


        binding.ch3.setOnCheckedChangeListener { _, isChecked ->
            if (binding.ch3.isChecked) {
                customDialogR2SX.tit_r2s_out.text = "خارجية"
                customDialogR2SX.tit_r2s_in.text = "داخلية"
                customDialogR2SX.outsideright.setOnCheckedChangeListener { _, isChecked1 ->

                    if (customDialogR2SX.outsideright.isChecked) {
                        binding.ch3.text = "راسية اكس خارجية يمين"
                    }else{binding.ch3.text = "راسية اكس"
                        customDialogR2SX.s3er_r2s_acx.setText("")}

                    if (customDialogR2SX.outsideright.isChecked && customDialogR2SX.outsideleft.isChecked && customDialogR2SX.insideright.isChecked && customDialogR2SX.insideleft.isChecked) {
                        binding.ch3.text = "تغير جميع الرأسيات الخارجية و الداخلية"
                        customDialogR2SX.s3er_r2s_acx.setText("40")
                    } else {
                        if (customDialogR2SX.outsideright.isChecked && customDialogR2SX.outsideleft.isChecked && customDialogR2SX.insideright.isChecked) {
                            binding.ch3.text = "راسيتين اكس خارجية و الداخلية يمين"
                            customDialogR2SX.s3er_r2s_acx.setText("30")
                        }else {
                            if (customDialogR2SX.outsideright.isChecked && customDialogR2SX.outsideleft.isChecked && customDialogR2SX.insideleft.isChecked) {
                                binding.ch3.text = "راسيتين اكس خارجية و الداخلية يسار"
                                customDialogR2SX.s3er_r2s_acx.setText("30")
                            }else {
                                if (customDialogR2SX.outsideright.isChecked && customDialogR2SX.insideright.isChecked && customDialogR2SX.insideleft.isChecked) {
                                    binding.ch3.text = "راسية اكس خارجية يمين و الداخليتين"
                                    customDialogR2SX.s3er_r2s_acx.setText("30")
                                }else {
                                    if (customDialogR2SX.outsideleft.isChecked && customDialogR2SX.insideright.isChecked && customDialogR2SX.insideleft.isChecked) {
                                        binding.ch3.text = "راسية اكس خارجية يسار و الداخليتين"
                                        customDialogR2SX.s3er_r2s_acx.setText("30")
                                    }else {
                                        if (customDialogR2SX.outsideright.isChecked && customDialogR2SX.outsideleft.isChecked) {
                                            binding.ch3.text = "راسية اكس خارجية يمين و يسار"
                                            customDialogR2SX.s3er_r2s_acx.setText("20")
                                        }else {
                                            if (customDialogR2SX.outsideright.isChecked && customDialogR2SX.insideright.isChecked) {
                                                binding.ch3.text = "راسية اكس خارجية يمين و داخلية يمين"
                                                customDialogR2SX.s3er_r2s_acx.setText("20")
                                            }else {
                                                if (customDialogR2SX.outsideright.isChecked && customDialogR2SX.insideleft.isChecked) {
                                                    binding.ch3.text = "راسية اكس خارجية يمين و داخلية يسار"
                                                    customDialogR2SX.s3er_r2s_acx.setText("20")
                                                }else {
                                                    if (customDialogR2SX.outsideleft.isChecked && customDialogR2SX.insideright.isChecked) {
                                                        binding.ch3.text = "راسية اكس خارجية يسار و داخلية يمين"
                                                        customDialogR2SX.s3er_r2s_acx.setText("20")
                                                    }else {
                                                        if (customDialogR2SX.outsideleft.isChecked && customDialogR2SX.insideleft.isChecked) {
                                                            binding.ch3.text = "راسية اكس خارجية يسار و داخلية يسار"
                                                            customDialogR2SX.s3er_r2s_acx.setText("20")
                                                        }else {
                                                            if (customDialogR2SX.insideright.isChecked && customDialogR2SX.insideleft.isChecked) {
                                                                binding.ch3.text = "راسية اكس داخلية يمين و يسار"
                                                                customDialogR2SX.s3er_r2s_acx.setText("20")
                                                            } else {

                                                                if (customDialogR2SX.outsideright.isChecked) {
                                                                    binding.ch3.text = "راسية اكس خارجية يمين"
                                                                    customDialogR2SX.s3er_r2s_acx.setText("10")
                                                                }
                                                                if (customDialogR2SX.outsideleft.isChecked) {
                                                                    binding.ch3.text = "راسية اكس خارجية يسار"
                                                                    customDialogR2SX.s3er_r2s_acx.setText("10")
                                                                }

                                                                if (customDialogR2SX.insideleft.isChecked) {
                                                                    binding.ch3.text = "راسية اكس داخلية يسار"
                                                                    customDialogR2SX.s3er_r2s_acx.setText("10")
                                                                }
                                                                if (customDialogR2SX.insideright.isChecked) {
                                                                    binding.ch3.text = "راسية اكس داخلية يمين"
                                                                    customDialogR2SX.s3er_r2s_acx.setText("10")
                                                                }
                                                            }
                                                        }
                                                    }}}}}}}}}
                    customDialogR2SX.show()
                }

                customDialogR2SX.outsideleft.setOnCheckedChangeListener { _, isChecked2 ->
                    if (customDialogR2SX.outsideleft.isChecked) {
                        binding.ch3.text = "راسية اكس خارجية يسار"
                    }else{binding.ch3.text = "راسية اكس"
                        customDialogR2SX.s3er_r2s_acx.setText("")}

                    if (customDialogR2SX.outsideright.isChecked && customDialogR2SX.outsideleft.isChecked && customDialogR2SX.insideright.isChecked && customDialogR2SX.insideleft.isChecked ) {
                        binding.ch3.text = "تغير جميع الرأسيات الخارجية و الداخلية"
                        customDialogR2SX.s3er_r2s_acx.setText("40")
                    }else{
                        if (customDialogR2SX.outsideleft.isChecked && customDialogR2SX.outsideright.isChecked && customDialogR2SX.insideright.isChecked ) {
                            binding.ch3.text = "راسيتين اكس خارجية و الداخلية يمين"
                            customDialogR2SX.s3er_r2s_acx.setText("30")
                        }else{
                            if (customDialogR2SX.outsideleft.isChecked && customDialogR2SX.outsideright.isChecked && customDialogR2SX.insideleft.isChecked ) {
                                binding.ch3.text = "راسيتين اكس خارجية و الداخلية يسار"
                                customDialogR2SX.s3er_r2s_acx.setText("30")
                            }else{
                                if (customDialogR2SX.outsideright.isChecked && customDialogR2SX.insideright.isChecked && customDialogR2SX.insideleft.isChecked ) {
                                    binding.ch3.text = "راسية اكس خارجية يمين و الداخليتين"
                                    customDialogR2SX.s3er_r2s_acx.setText("30")
                                }else{
                                    if (customDialogR2SX.outsideleft.isChecked && customDialogR2SX.insideright.isChecked && customDialogR2SX.insideleft.isChecked ) {
                                        binding.ch3.text = "راسية اكس خارجية يسار و الداخليتين"
                                        customDialogR2SX.s3er_r2s_acx.setText("30")
                                    }else{
//                                else {
                                        if (customDialogR2SX.outsideleft.isChecked && customDialogR2SX.outsideright.isChecked) {
                                            binding.ch3.text = "راسية اكس خارجية يمين و يسار"
                                            customDialogR2SX.s3er_r2s_acx.setText("20")
                                        }else{
                                            if (customDialogR2SX.outsideright.isChecked && customDialogR2SX.insideright.isChecked) {
                                                binding.ch3.text = "راسية اكس خارجية يمين و داخلية يمين"
                                                customDialogR2SX.s3er_r2s_acx.setText("20")
                                            }else{
                                                if (customDialogR2SX.outsideright.isChecked && customDialogR2SX.insideleft.isChecked) {
                                                    binding.ch3.text = "راسية اكس خارجية يمين و داخلية يسار"
                                                    customDialogR2SX.s3er_r2s_acx.setText("20")
                                                }else{
                                                    if (customDialogR2SX.outsideleft.isChecked && customDialogR2SX.insideright.isChecked) {
                                                        binding.ch3.text = "راسية اكس خارجية يسار و داخلية يمين"
                                                        customDialogR2SX.s3er_r2s_acx.setText("20")
                                                    }else{
                                                        if (customDialogR2SX.outsideleft.isChecked && customDialogR2SX.insideleft.isChecked) {
                                                            binding.ch3.text = "راسية اكس خارجية يسار و داخلية يسار"
                                                            customDialogR2SX.s3er_r2s_acx.setText("20")
                                                        }else{
                                                            if (customDialogR2SX.insideright.isChecked && customDialogR2SX.insideleft.isChecked) {
                                                                binding.ch3.text = "راسية اكس داخلية يمين و يسار"
                                                                customDialogR2SX.s3er_r2s_acx.setText("20")
                                                            } else {

                                                                if (customDialogR2SX.outsideleft.isChecked) {
                                                                    binding.ch3.text = "راسية اكس خارجية يسار"
                                                                    customDialogR2SX.s3er_r2s_acx.setText("10")
                                                                }

                                                                if (customDialogR2SX.outsideright.isChecked) {
                                                                    binding.ch3.text = "راسية اكس خارجية يمين"
                                                                    customDialogR2SX.s3er_r2s_acx.setText("10")
                                                                }

                                                                if (customDialogR2SX.insideleft.isChecked) {
                                                                    binding.ch3.text = "راسية اكس داخلية يسار"
                                                                    customDialogR2SX.s3er_r2s_acx.setText("10")
                                                                }
                                                                if (customDialogR2SX.insideright.isChecked) {
                                                                    binding.ch3.text = "راسية اكس داخلية يمين"
                                                                    customDialogR2SX.s3er_r2s_acx.setText("10")
                                                                }
                                                            }
                                                        }
                                                    }}}}}}}}}
                    customDialogR2SX.show()
                }



                customDialogR2SX.insideleft.setOnCheckedChangeListener { _, isChecked2 ->
                    if (customDialogR2SX.insideleft.isChecked) {
                        binding.ch3.text = "راسية اكس داخلية يسار"
                    }else{binding.ch3.text = "راسية اكس"
                        customDialogR2SX.s3er_r2s_acx.setText("")}

                    if (customDialogR2SX.outsideright.isChecked && customDialogR2SX.outsideleft.isChecked && customDialogR2SX.insideright.isChecked && customDialogR2SX.insideleft.isChecked ) {
                        binding.ch3.text = "تغير جميع الرأسيات الخارجية و الداخلية"
                        customDialogR2SX.s3er_r2s_acx.setText("40")
                    }else {
                        if (customDialogR2SX.outsideright.isChecked && customDialogR2SX.outsideleft.isChecked && customDialogR2SX.insideright.isChecked ) {
                            binding.ch3.text = "راسيتين اكس خارجية و الداخلية يمين"
                            customDialogR2SX.s3er_r2s_acx.setText("30")
                        }else {
                            if (customDialogR2SX.insideleft.isChecked && customDialogR2SX.outsideleft.isChecked && customDialogR2SX.outsideright.isChecked) {
                                binding.ch3.text = "راسيتين اكس خارجية و الداخلية يسار"
                                customDialogR2SX.s3er_r2s_acx.setText("30")
                            }else {
                                if (customDialogR2SX.insideleft.isChecked && customDialogR2SX.insideright.isChecked && customDialogR2SX.outsideright.isChecked) {
                                    binding.ch3.text = "راسية اكس خارجية يمين و الداخليتين"
                                    customDialogR2SX.s3er_r2s_acx.setText("30")
                                }else {
                                    if (customDialogR2SX.insideleft.isChecked && customDialogR2SX.insideright.isChecked && customDialogR2SX.outsideleft.isChecked) {
                                        binding.ch3.text = "راسية اكس خارجية يسار و الداخليتين"
                                        customDialogR2SX.s3er_r2s_acx.setText("30")
                                    }else {
                                        if (customDialogR2SX.outsideright.isChecked && customDialogR2SX.outsideleft.isChecked) {
                                            binding.ch3.text = "راسية اكس خارجية يمين و يسار"
                                            customDialogR2SX.s3er_r2s_acx.setText("20")
                                        }else {
                                            if (customDialogR2SX.outsideright.isChecked && customDialogR2SX.insideright.isChecked) {
                                                binding.ch3.text = "راسية اكس خارجية يمين و داخلية يمين"
                                                customDialogR2SX.s3er_r2s_acx.setText("20")
                                            }else {
                                                if (customDialogR2SX.insideleft.isChecked && customDialogR2SX.outsideright.isChecked) {
                                                    binding.ch3.text = "راسية اكس خارجية يمين و داخلية يسار"
                                                    customDialogR2SX.s3er_r2s_acx.setText("20")
                                                }else {
                                                    if (customDialogR2SX.outsideleft.isChecked && customDialogR2SX.insideright.isChecked) {
                                                        binding.ch3.text = "راسية اكس خارجية يسار و داخلية يمين"
                                                        customDialogR2SX.s3er_r2s_acx.setText("20")
                                                    }else {
                                                        if (customDialogR2SX.insideleft.isChecked && customDialogR2SX.outsideleft.isChecked) {
                                                            binding.ch3.text = "راسية اكس خارجية يسار و داخلية يسار"
                                                            customDialogR2SX.s3er_r2s_acx.setText("20")
                                                        }else {
                                                            if (customDialogR2SX.insideleft.isChecked && customDialogR2SX.insideright.isChecked) {
                                                                binding.ch3.text = "راسية اكس داخلية يمين و يسار"
                                                                customDialogR2SX.s3er_r2s_acx.setText("20")
                                                            } else {
                                                                if (customDialogR2SX.insideright.isChecked) {
                                                                    binding.ch3.text = "راسية اكس داخلية يمين"
                                                                    customDialogR2SX.s3er_r2s_acx.setText("10")
                                                                }
                                                                if (customDialogR2SX.outsideright.isChecked) {
                                                                    binding.ch3.text = "راسية اكس خارجية يمين"
                                                                    customDialogR2SX.s3er_r2s_acx.setText("10")
                                                                }
                                                                if (customDialogR2SX.outsideleft.isChecked) {
                                                                    binding.ch3.text = "راسية اكس خارجية يسار"
                                                                    customDialogR2SX.s3er_r2s_acx.setText("10")
                                                                }

                                                                if (customDialogR2SX.insideleft.isChecked) {
                                                                    binding.ch3.text = "راسية اكس داخلية يسار"
                                                                    customDialogR2SX.s3er_r2s_acx.setText("10")
                                                                }
                                                            }
                                                        }
                                                    }}}}}}}}}

                    customDialogR2SX.show()
                }

                customDialogR2SX.insideright.setOnCheckedChangeListener { _, isChecked2 ->
                    if (customDialogR2SX.insideright.isChecked) {
                        binding.ch3.text = "راسية اكس داخلية يمين"
                    }else{binding.ch3.text = "راسية اكس"
                        customDialogR2SX.s3er_r2s_acx.setText("")}

                    if (customDialogR2SX.outsideright.isChecked && customDialogR2SX.outsideleft.isChecked && customDialogR2SX.insideright.isChecked && customDialogR2SX.insideleft.isChecked ) {
                        binding.ch3.text = "تغير جميع الرأسيات الخارجية و الداخلية"
                        customDialogR2SX.s3er_r2s_acx.setText("40")
                    }else{
                        if (customDialogR2SX.insideright.isChecked && customDialogR2SX.outsideleft.isChecked && customDialogR2SX.outsideright.isChecked ) {
                            binding.ch3.text = "راسيتين اكس خارجية و الداخلية يمين"
                            customDialogR2SX.s3er_r2s_acx.setText("30")
                        }else {
                            if (customDialogR2SX.outsideright.isChecked && customDialogR2SX.outsideleft.isChecked && customDialogR2SX.insideleft.isChecked ) {
                                binding.ch3.text = "راسيتين اكس خارجية و الداخلية يسار"
                                customDialogR2SX.s3er_r2s_acx.setText("30")
                            }else {
                                if (customDialogR2SX.insideright.isChecked && customDialogR2SX.outsideright.isChecked && customDialogR2SX.insideleft.isChecked ) {
                                    binding.ch3.text = "راسية اكس خارجية يمين و الداخليتين"
                                    customDialogR2SX.s3er_r2s_acx.setText("30")
                                }else {
                                    if (customDialogR2SX.insideright.isChecked && customDialogR2SX.outsideleft.isChecked && customDialogR2SX.insideleft.isChecked ) {
                                        binding.ch3.text = "راسية اكس خارجية يسار و الداخليتين"
                                        customDialogR2SX.s3er_r2s_acx.setText("30")
                                    }else {
                                        if (customDialogR2SX.outsideright.isChecked && customDialogR2SX.outsideleft.isChecked ) {
                                            binding.ch3.text = "راسية اكس خارجية يمين و يسار"
                                            customDialogR2SX.s3er_r2s_acx.setText("20")
                                        }else {
                                            if (customDialogR2SX.insideright.isChecked && customDialogR2SX.outsideright.isChecked ) {
                                                binding.ch3.text = "راسية اكس خارجية يمين و داخلية يمين"
                                                customDialogR2SX.s3er_r2s_acx.setText("20")
                                            }else {
                                                if (customDialogR2SX.outsideright.isChecked && customDialogR2SX.insideleft.isChecked ) {
                                                    binding.ch3.text = "راسية اكس خارجية يمين و داخلية يسار"
                                                    customDialogR2SX.s3er_r2s_acx.setText("20")
                                                }else {
                                                    if (customDialogR2SX.insideright.isChecked && customDialogR2SX.outsideleft.isChecked) {
                                                        binding.ch3.text = "راسية اكس خارجية يسار و داخلية يمين"
                                                        customDialogR2SX.s3er_r2s_acx.setText("20")
                                                    }else {
                                                        if (customDialogR2SX.outsideleft.isChecked && customDialogR2SX.insideleft.isChecked) {
                                                            binding.ch3.text = "راسية اكس خارجية يسار و داخلية يسار"
                                                            customDialogR2SX.s3er_r2s_acx.setText("20")
                                                        }else {
                                                            if (customDialogR2SX.insideright.isChecked && customDialogR2SX.insideleft.isChecked) {
                                                                binding.ch3.text = "راسية اكس داخلية يمين و يسار"
                                                                customDialogR2SX.s3er_r2s_acx.setText("20")
                                                            } else {
                                                                if (customDialogR2SX.insideright.isChecked) {
                                                                    binding.ch3.text = "راسية اكس داخلية يمين"
                                                                    customDialogR2SX.s3er_r2s_acx.setText("10")
                                                                }
                                                                if (customDialogR2SX.insideleft.isChecked) {
                                                                    binding.ch3.text = "راسية اكس داخلية يسار"
                                                                    customDialogR2SX.s3er_r2s_acx.setText("10")
                                                                }
                                                                if (customDialogR2SX.outsideleft.isChecked) {
                                                                    binding.ch3.text = "راسية اكس خارجية يسار"
                                                                    customDialogR2SX.s3er_r2s_acx.setText("10")
                                                                }
                                                                if (customDialogR2SX.outsideright.isChecked) {
                                                                    binding.ch3.text = "راسية اكس خارجية يمين"
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
                            editTextNumber3.text=customDialogR2SX.s3er_r2s_acx.text.toString()
                            viewModel.totalAmount += editTextNumber3.text.toString().toInt()
                            toolbar?.title =  viewModel.totalAmount.toString()
                            homeModel.checkname3 = binding.ch3.text.toString().trim()
                            homeModel.editname3 = editTextNumber3.text.toString().trim()
                            customDialogR2SX.dismiss()
                        }
                    }
                }
                customDialogR2SX.btn_r2s_can.setOnClickListener {
                    if (editTextNumber3.text.toString().isEmpty()) {
                        binding.ch3.text = "راسية اكس"
                        binding.ch3.isChecked = false
                    }

                    customDialogR2SX.dismiss()
                }
                customDialogR2SX.outsideright.isChecked = false
                customDialogR2SX.outsideleft.isChecked = false
                customDialogR2SX.insideright.isChecked = false
                customDialogR2SX.insideleft.isChecked = false
                customDialogR2SX.show()

            } else {
                if (editTextNumber3.text.toString().isNotEmpty()) {
                    viewModel.totalAmount -= editTextNumber3.text.toString().toInt()
                    toolbar?.title =  viewModel.totalAmount.toString()
                    binding.ch3.text = "راسية اكس"
                    editTextNumber3.text = ""
                    homeModel.checkname3 =  ""
                    homeModel.editname3 =  ""
                }else{binding.ch3.text = "راسية اكس"}
            }
        }

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}