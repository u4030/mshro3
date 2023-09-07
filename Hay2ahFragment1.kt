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
import android.widget.Toast
import android.widget.Toolbar
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.markizalhadidi.R
import com.example.markizalhadidi.databinding.ActivityMainBinding
import com.example.markizalhadidi.databinding.FragmentHay2ah1Binding
import com.example.markizalhadidi.databinding.R2syet2ksDailogBinding

class  Hay2ahFragment1 : Fragment() {

    private var _binding: FragmentHay2ah1Binding? = null
    private val binding get() = _binding!!

    private lateinit var bindingtoolbar: ActivityMainBinding

    private lateinit var hy2ahModel: Hay2ahViewModel

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
        hy2ahModel =
            ViewModelProvider(this).get(Hay2ahViewModel::class.java)

        _binding = FragmentHay2ah1Binding.inflate(inflater, container, false)
        val root: View = binding.root

        bindingtoolbar = ActivityMainBinding.inflate(layoutInflater)

        val bindingR2 = R2syet2ksDailogBinding.inflate(layoutInflater)
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


        customDialogR2SX = Dialog(requireContext())
        customDialogR2SX.setContentView(bindingR2.root)
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

        val toolbar = bindingtoolbar.appBarMain.toolbar
        toolbar?.setTitleTextAppearance(this.context, R.style.boldText)


        binding.ch3.setOnCheckedChangeListener { _, isChecked ->
            if (binding.ch3.isChecked) {
                bindingR2.titR2sOut.text = "خارجية"
                bindingR2.titR2sIn.text = "داخلية"
                bindingR2.outsideright.setOnCheckedChangeListener { _, isChecked1 ->

                    if (bindingR2.outsideright.isChecked) {
                        binding.ch3.text = "راسية اكس خارجية يمين"
                    }else{binding.ch3.text = "راسية اكس"
                        bindingR2.s3erR2sAcx.setText("")}

                    if (bindingR2.outsideright.isChecked && bindingR2.outsideleft.isChecked && bindingR2.insideright.isChecked && bindingR2.insideleft.isChecked) {
                        binding.ch3.text = "تغير جميع الرأسيات الخارجية و الداخلية"
                        bindingR2.s3erR2sAcx.setText("40")
                    } else {
                        if (bindingR2.outsideright.isChecked && bindingR2.outsideleft.isChecked && bindingR2.insideright.isChecked) {
                            binding.ch3.text = "راسيتين اكس خارجية و الداخلية يمين"
                            bindingR2.s3erR2sAcx.setText("30")
                        }else {
                            if (bindingR2.outsideright.isChecked && bindingR2.outsideleft.isChecked && bindingR2.insideleft.isChecked) {
                                binding.ch3.text = "راسيتين اكس خارجية و الداخلية يسار"
                                bindingR2.s3erR2sAcx.setText("30")
                            }else {
                                if (bindingR2.outsideright.isChecked && bindingR2.insideright.isChecked && bindingR2.insideleft.isChecked) {
                                    binding.ch3.text = "راسية اكس خارجية يمين و الداخليتين"
                                    bindingR2.s3erR2sAcx.setText("30")
                                }else {
                                    if (bindingR2.outsideleft.isChecked && bindingR2.insideright.isChecked && bindingR2.insideleft.isChecked) {
                                        binding.ch3.text = "راسية اكس خارجية يسار و الداخليتين"
                                        bindingR2.s3erR2sAcx.setText("30")
                                    }else {
                                        if (bindingR2.outsideright.isChecked && bindingR2.outsideleft.isChecked) {
                                            binding.ch3.text = "راسية اكس خارجية يمين و يسار"
                                            bindingR2.s3erR2sAcx.setText("20")
                                        }else {
                                            if (bindingR2.outsideright.isChecked && bindingR2.insideright.isChecked) {
                                                binding.ch3.text = "راسية اكس خارجية يمين و داخلية يمين"
                                                bindingR2.s3erR2sAcx.setText("20")
                                            }else {
                                                if (bindingR2.outsideright.isChecked && bindingR2.insideleft.isChecked) {
                                                    binding.ch3.text = "راسية اكس خارجية يمين و داخلية يسار"
                                                    bindingR2.s3erR2sAcx.setText("20")
                                                }else {
                                                    if (bindingR2.outsideleft.isChecked && bindingR2.insideright.isChecked) {
                                                        binding.ch3.text = "راسية اكس خارجية يسار و داخلية يمين"
                                                        bindingR2.s3erR2sAcx.setText("20")
                                                    }else {
                                                        if (bindingR2.outsideleft.isChecked && bindingR2.insideleft.isChecked) {
                                                            binding.ch3.text = "راسية اكس خارجية يسار و داخلية يسار"
                                                            bindingR2.s3erR2sAcx.setText("20")
                                                        }else {
                                                            if (bindingR2.insideright.isChecked && bindingR2.insideleft.isChecked) {
                                                                binding.ch3.text = "راسية اكس داخلية يمين و يسار"
                                                                bindingR2.s3erR2sAcx.setText("20")
                                                            } else {

                                                                if (bindingR2.outsideright.isChecked) {
                                                                    binding.ch3.text = "راسية اكس خارجية يمين"
                                                                    bindingR2.s3erR2sAcx.setText("10")
                                                                }
                                                                if (bindingR2.outsideleft.isChecked) {
                                                                    binding.ch3.text = "راسية اكس خارجية يسار"
                                                                    bindingR2.s3erR2sAcx.setText("10")
                                                                }

                                                                if (bindingR2.insideleft.isChecked) {
                                                                    binding.ch3.text = "راسية اكس داخلية يسار"
                                                                    bindingR2.s3erR2sAcx.setText("10")
                                                                }
                                                                if (bindingR2.insideright.isChecked) {
                                                                    binding.ch3.text = "راسية اكس داخلية يمين"
                                                                    bindingR2.s3erR2sAcx.setText("10")
                                                                }
                                                            }
                                                        }
                                                    }}}}}}}}}
                    customDialogR2SX.show()
                }

                bindingR2.outsideleft.setOnCheckedChangeListener { _, isChecked2 ->
                    if (bindingR2.outsideleft.isChecked) {
                        binding.ch3.text = "راسية اكس خارجية يسار"
                    }else{binding.ch3.text = "راسية اكس"
                        bindingR2.s3erR2sAcx.setText("")}

                    if (bindingR2.outsideright.isChecked && bindingR2.outsideleft.isChecked && bindingR2.insideright.isChecked && bindingR2.insideleft.isChecked ) {
                        binding.ch3.text = "تغير جميع الرأسيات الخارجية و الداخلية"
                        bindingR2.s3erR2sAcx.setText("40")
                    }else{
                        if (bindingR2.outsideleft.isChecked && bindingR2.outsideright.isChecked && bindingR2.insideright.isChecked ) {
                            binding.ch3.text = "راسيتين اكس خارجية و الداخلية يمين"
                            bindingR2.s3erR2sAcx.setText("30")
                        }else{
                            if (bindingR2.outsideleft.isChecked && bindingR2.outsideright.isChecked && bindingR2.insideleft.isChecked ) {
                                binding.ch3.text = "راسيتين اكس خارجية و الداخلية يسار"
                                bindingR2.s3erR2sAcx.setText("30")
                            }else{
                                if (bindingR2.outsideright.isChecked && bindingR2.insideright.isChecked && bindingR2.insideleft.isChecked ) {
                                    binding.ch3.text = "راسية اكس خارجية يمين و الداخليتين"
                                    bindingR2.s3erR2sAcx.setText("30")
                                }else{
                                    if (bindingR2.outsideleft.isChecked && bindingR2.insideright.isChecked && bindingR2.insideleft.isChecked ) {
                                        binding.ch3.text = "راسية اكس خارجية يسار و الداخليتين"
                                        bindingR2.s3erR2sAcx.setText("30")
                                    }else{
//                                else {
                                        if (bindingR2.outsideleft.isChecked && bindingR2.outsideright.isChecked) {
                                            binding.ch3.text = "راسية اكس خارجية يمين و يسار"
                                            bindingR2.s3erR2sAcx.setText("20")
                                        }else{
                                            if (bindingR2.outsideright.isChecked && bindingR2.insideright.isChecked) {
                                                binding.ch3.text = "راسية اكس خارجية يمين و داخلية يمين"
                                                bindingR2.s3erR2sAcx.setText("20")
                                            }else{
                                                if (bindingR2.outsideright.isChecked && bindingR2.insideleft.isChecked) {
                                                    binding.ch3.text = "راسية اكس خارجية يمين و داخلية يسار"
                                                    bindingR2.s3erR2sAcx.setText("20")
                                                }else{
                                                    if (bindingR2.outsideleft.isChecked && bindingR2.insideright.isChecked) {
                                                        binding.ch3.text = "راسية اكس خارجية يسار و داخلية يمين"
                                                        bindingR2.s3erR2sAcx.setText("20")
                                                    }else{
                                                        if (bindingR2.outsideleft.isChecked && bindingR2.insideleft.isChecked) {
                                                            binding.ch3.text = "راسية اكس خارجية يسار و داخلية يسار"
                                                            bindingR2.s3erR2sAcx.setText("20")
                                                        }else{
                                                            if (bindingR2.insideright.isChecked && bindingR2.insideleft.isChecked) {
                                                                binding.ch3.text = "راسية اكس داخلية يمين و يسار"
                                                                bindingR2.s3erR2sAcx.setText("20")
                                                            } else {

                                                                if (bindingR2.outsideleft.isChecked) {
                                                                    binding.ch3.text = "راسية اكس خارجية يسار"
                                                                    bindingR2.s3erR2sAcx.setText("10")
                                                                }

                                                                if (bindingR2.outsideright.isChecked) {
                                                                    binding.ch3.text = "راسية اكس خارجية يمين"
                                                                    bindingR2.s3erR2sAcx.setText("10")
                                                                }

                                                                if (bindingR2.insideleft.isChecked) {
                                                                    binding.ch3.text = "راسية اكس داخلية يسار"
                                                                    bindingR2.s3erR2sAcx.setText("10")
                                                                }
                                                                if (bindingR2.insideright.isChecked) {
                                                                    binding.ch3.text = "راسية اكس داخلية يمين"
                                                                    bindingR2.s3erR2sAcx.setText("10")
                                                                }
                                                            }
                                                        }
                                                    }}}}}}}}}
                    customDialogR2SX.show()
                }



                bindingR2.insideleft.setOnCheckedChangeListener { _, isChecked2 ->
                    if (bindingR2.insideleft.isChecked) {
                        binding.ch3.text = "راسية اكس داخلية يسار"
                    }else{binding.ch3.text = "راسية اكس"
                        bindingR2.s3erR2sAcx.setText("")}

                    if (bindingR2.outsideright.isChecked && bindingR2.outsideleft.isChecked && bindingR2.insideright.isChecked && bindingR2.insideleft.isChecked ) {
                        binding.ch3.text = "تغير جميع الرأسيات الخارجية و الداخلية"
                        bindingR2.s3erR2sAcx.setText("40")
                    }else {
                        if (bindingR2.outsideright.isChecked && bindingR2.outsideleft.isChecked && bindingR2.insideright.isChecked ) {
                            binding.ch3.text = "راسيتين اكس خارجية و الداخلية يمين"
                            bindingR2.s3erR2sAcx.setText("30")
                        }else {
                            if (bindingR2.insideleft.isChecked && bindingR2.outsideleft.isChecked && bindingR2.outsideright.isChecked) {
                                binding.ch3.text = "راسيتين اكس خارجية و الداخلية يسار"
                                bindingR2.s3erR2sAcx.setText("30")
                            }else {
                                if (bindingR2.insideleft.isChecked && bindingR2.insideright.isChecked && bindingR2.outsideright.isChecked) {
                                    binding.ch3.text = "راسية اكس خارجية يمين و الداخليتين"
                                    bindingR2.s3erR2sAcx.setText("30")
                                }else {
                                    if (bindingR2.insideleft.isChecked && bindingR2.insideright.isChecked && bindingR2.outsideleft.isChecked) {
                                        binding.ch3.text = "راسية اكس خارجية يسار و الداخليتين"
                                        bindingR2.s3erR2sAcx.setText("30")
                                    }else {
                                        if (bindingR2.outsideright.isChecked && bindingR2.outsideleft.isChecked) {
                                            binding.ch3.text = "راسية اكس خارجية يمين و يسار"
                                            bindingR2.s3erR2sAcx.setText("20")
                                        }else {
                                            if (bindingR2.outsideright.isChecked && bindingR2.insideright.isChecked) {
                                                binding.ch3.text = "راسية اكس خارجية يمين و داخلية يمين"
                                                bindingR2.s3erR2sAcx.setText("20")
                                            }else {
                                                if (bindingR2.insideleft.isChecked && bindingR2.outsideright.isChecked) {
                                                    binding.ch3.text = "راسية اكس خارجية يمين و داخلية يسار"
                                                    bindingR2.s3erR2sAcx.setText("20")
                                                }else {
                                                    if (bindingR2.outsideleft.isChecked && bindingR2.insideright.isChecked) {
                                                        binding.ch3.text = "راسية اكس خارجية يسار و داخلية يمين"
                                                        bindingR2.s3erR2sAcx.setText("20")
                                                    }else {
                                                        if (bindingR2.insideleft.isChecked && bindingR2.outsideleft.isChecked) {
                                                            binding.ch3.text = "راسية اكس خارجية يسار و داخلية يسار"
                                                            bindingR2.s3erR2sAcx.setText("20")
                                                        }else {
                                                            if (bindingR2.insideleft.isChecked && bindingR2.insideright.isChecked) {
                                                                binding.ch3.text = "راسية اكس داخلية يمين و يسار"
                                                                bindingR2.s3erR2sAcx.setText("20")
                                                            } else {
                                                                if (bindingR2.insideright.isChecked) {
                                                                    binding.ch3.text = "راسية اكس داخلية يمين"
                                                                    bindingR2.s3erR2sAcx.setText("10")
                                                                }
                                                                if (bindingR2.outsideright.isChecked) {
                                                                    binding.ch3.text = "راسية اكس خارجية يمين"
                                                                    bindingR2.s3erR2sAcx.setText("10")
                                                                }
                                                                if (bindingR2.outsideleft.isChecked) {
                                                                    binding.ch3.text = "راسية اكس خارجية يسار"
                                                                    bindingR2.s3erR2sAcx.setText("10")
                                                                }

                                                                if (bindingR2.insideleft.isChecked) {
                                                                    binding.ch3.text = "راسية اكس داخلية يسار"
                                                                    bindingR2.s3erR2sAcx.setText("10")
                                                                }
                                                            }
                                                        }
                                                    }}}}}}}}}

                    customDialogR2SX.show()
                }

                bindingR2.insideright.setOnCheckedChangeListener { _, isChecked2 ->
                    if (bindingR2.insideright.isChecked) {
                        binding.ch3.text = "راسية اكس داخلية يمين"
                    }else{binding.ch3.text = "راسية اكس"
                        bindingR2.s3erR2sAcx.setText("")}

                    if (bindingR2.outsideright.isChecked && bindingR2.outsideleft.isChecked && bindingR2.insideright.isChecked && bindingR2.insideleft.isChecked ) {
                        binding.ch3.text = "تغير جميع الرأسيات الخارجية و الداخلية"
                        bindingR2.s3erR2sAcx.setText("40")
                    }else{
                        if (bindingR2.insideright.isChecked && bindingR2.outsideleft.isChecked && bindingR2.outsideright.isChecked ) {
                            binding.ch3.text = "راسيتين اكس خارجية و الداخلية يمين"
                            bindingR2.s3erR2sAcx.setText("30")
                        }else {
                            if (bindingR2.outsideright.isChecked && bindingR2.outsideleft.isChecked && bindingR2.insideleft.isChecked ) {
                                binding.ch3.text = "راسيتين اكس خارجية و الداخلية يسار"
                                bindingR2.s3erR2sAcx.setText("30")
                            }else {
                                if (bindingR2.insideright.isChecked && bindingR2.outsideright.isChecked && bindingR2.insideleft.isChecked ) {
                                    binding.ch3.text = "راسية اكس خارجية يمين و الداخليتين"
                                    bindingR2.s3erR2sAcx.setText("30")
                                }else {
                                    if (bindingR2.insideright.isChecked && bindingR2.outsideleft.isChecked && bindingR2.insideleft.isChecked ) {
                                        binding.ch3.text = "راسية اكس خارجية يسار و الداخليتين"
                                        bindingR2.s3erR2sAcx.setText("30")
                                    }else {
                                        if (bindingR2.outsideright.isChecked && bindingR2.outsideleft.isChecked ) {
                                            binding.ch3.text = "راسية اكس خارجية يمين و يسار"
                                            bindingR2.s3erR2sAcx.setText("20")
                                        }else {
                                            if (bindingR2.insideright.isChecked && bindingR2.outsideright.isChecked ) {
                                                binding.ch3.text = "راسية اكس خارجية يمين و داخلية يمين"
                                                bindingR2.s3erR2sAcx.setText("20")
                                            }else {
                                                if (bindingR2.outsideright.isChecked && bindingR2.insideleft.isChecked ) {
                                                    binding.ch3.text = "راسية اكس خارجية يمين و داخلية يسار"
                                                    bindingR2.s3erR2sAcx.setText("20")
                                                }else {
                                                    if (bindingR2.insideright.isChecked && bindingR2.outsideleft.isChecked) {
                                                        binding.ch3.text = "راسية اكس خارجية يسار و داخلية يمين"
                                                        bindingR2.s3erR2sAcx.setText("20")
                                                    }else {
                                                        if (bindingR2.outsideleft.isChecked && bindingR2.insideleft.isChecked) {
                                                            binding.ch3.text = "راسية اكس خارجية يسار و داخلية يسار"
                                                            bindingR2.s3erR2sAcx.setText("20")
                                                        }else {
                                                            if (bindingR2.insideright.isChecked && bindingR2.insideleft.isChecked) {
                                                                binding.ch3.text = "راسية اكس داخلية يمين و يسار"
                                                                bindingR2.s3erR2sAcx.setText("20")
                                                            } else {
                                                                if (bindingR2.insideright.isChecked) {
                                                                    binding.ch3.text = "راسية اكس داخلية يمين"
                                                                    bindingR2.s3erR2sAcx.setText("10")
                                                                }
                                                                if (bindingR2.insideleft.isChecked) {
                                                                    binding.ch3.text = "راسية اكس داخلية يسار"
                                                                    bindingR2.s3erR2sAcx.setText("10")
                                                                }
                                                                if (bindingR2.outsideleft.isChecked) {
                                                                    binding.ch3.text = "راسية اكس خارجية يسار"
                                                                    bindingR2.s3erR2sAcx.setText("10")
                                                                }
                                                                if (bindingR2.outsideright.isChecked) {
                                                                    binding.ch3.text = "راسية اكس خارجية يمين"
                                                                    bindingR2.s3erR2sAcx.setText("10")
                                                                }
                                                            }
                                                        }
                                                    }}}}}}}}}
                    customDialogR2SX.show()
                }


                bindingR2.btnR2sSav.setOnClickListener {
                    if (!bindingR2.outsideright.isChecked && !bindingR2.outsideleft.isChecked
                        && !bindingR2.insideright.isChecked && !bindingR2.insideleft.isChecked ) {
                        toast_notempty1.show()}else{
                        if (bindingR2.s3erR2sAcx.text.toString().trim().isEmpty()){
                            toast_notempty.show()
                        }else{
                            binding.pric3.text=bindingR2.s3erR2sAcx.text.toString()
                            hy2ahModel.totalAmount += binding.pric3.text.toString().toInt()
                            toolbar.title =  "hy2ahModel.totalAmount.toString()"
                            hy2ahModel.ch1 = binding.ch3.text.toString().trim()
                            hy2ahModel.pric3 = binding.pric3.text.toString().trim()
                            customDialogR2SX.dismiss()
                        }
                    }
                }
                bindingR2.btnR2sCan.setOnClickListener {
                    if (binding.pric3.text.toString().isEmpty()) {
                        binding.ch3.text = "راسية اكس"
                        binding.ch3.isChecked = false
                    }

                    customDialogR2SX.dismiss()
                }
                bindingR2.outsideright.isChecked = false
                bindingR2.outsideleft.isChecked = false
                bindingR2.insideright.isChecked = false
                bindingR2.insideleft.isChecked = false
                customDialogR2SX.show()

            } else {
                if (binding.pric3.text.toString().isNotEmpty()) {
                    hy2ahModel.totalAmount -= binding.pric3.text.toString().toInt()
                    toolbar.title =  hy2ahModel.totalAmount.toString()
                    binding.ch3.text = "راسية اكس"
                    binding.pric3.text = ""
                    hy2ahModel.ch1 =  ""
                    hy2ahModel.pric3 =  ""
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