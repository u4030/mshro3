package com.example.markizalhadidi.ui.hay2ah

import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.text.SpannableString
import android.text.style.AbsoluteSizeSpan
import android.text.style.ForegroundColorSpan
import android.view.*
import android.widget.Toast
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.markizalhadidi.R
import com.example.markizalhadidi.databinding.ActivityMainBinding
import com.example.markizalhadidi.databinding.DialogBala6atBinding
import com.example.markizalhadidi.databinding.DialogBreakBinding
import com.example.markizalhadidi.databinding.DialogFa7e9Binding
import com.example.markizalhadidi.databinding.DialogMezanBinding
import com.example.markizalhadidi.databinding.FragmentHay2ah1Binding
import com.example.markizalhadidi.databinding.FrontDailogBinding
import com.example.markizalhadidi.databinding.PayingDailogBinding
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

        val bindingpaying = PayingDailogBinding.inflate(layoutInflater)
        customDialogFB_paying = Dialog(activity!!)
        customDialogFB_paying.setContentView(bindingpaying.root)
        customDialogFB_paying.setCancelable(false)
        customDialogFB_paying.window?.setLayout(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )
        customDialogFB_paying.window?.setFlags(WindowManager.LayoutParams.FLAG_SECURE, WindowManager.LayoutParams.FLAG_SECURE)

        val bindingMZ = DialogMezanBinding.inflate(layoutInflater)
        customDialogMZ = Dialog(activity!!)
        customDialogMZ.setContentView(bindingMZ.root)
        customDialogMZ.setCancelable(false)
        customDialogMZ.window?.setLayout(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.WRAP_CONTENT)
        customDialogMZ.window?.setFlags(WindowManager.LayoutParams.FLAG_SECURE, WindowManager.LayoutParams.FLAG_SECURE)

        val bindingF79 = DialogFa7e9Binding.inflate(layoutInflater)
        customDialogF79 = Dialog(activity!!)
        customDialogF79.setContentView(bindingF79.root)
        customDialogF79.setCancelable(false)
        customDialogF79.window?.setLayout(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.WRAP_CONTENT)
        customDialogF79.window?.setFlags(WindowManager.LayoutParams.FLAG_SECURE, WindowManager.LayoutParams.FLAG_SECURE)

        val bindingR2 = R2syet2ksDailogBinding.inflate(layoutInflater)
        customDialogR2SX = Dialog(requireContext())
        customDialogR2SX.setContentView(bindingR2.root)
        customDialogR2SX.setCancelable(false)
        customDialogR2SX.window?.setLayout(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )
        customDialogR2SX.window?.setFlags(WindowManager.LayoutParams.FLAG_SECURE, WindowManager.LayoutParams.FLAG_SECURE)

        val bindingBRK = DialogBreakBinding.inflate(layoutInflater)
        customDialogBRK = Dialog(activity!!)
        customDialogBRK.setContentView(bindingBRK.root)
        customDialogBRK.setCancelable(false)
        customDialogBRK.window?.setLayout(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )
        customDialogBRK.window?.setFlags(WindowManager.LayoutParams.FLAG_SECURE, WindowManager.LayoutParams.FLAG_SECURE)

        val bindingFR = FrontDailogBinding.inflate(layoutInflater)
        customDialogFR = Dialog(activity!!)
        customDialogFR.setContentView(bindingFR.root)
        customDialogFR.setCancelable(false)
        customDialogFR.window?.setLayout(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )
        customDialogFR.window?.setFlags(WindowManager.LayoutParams.FLAG_SECURE, WindowManager.LayoutParams.FLAG_SECURE)

        val bindingBL6 = DialogBala6atBinding.inflate(layoutInflater)
        customDialogBL6 = Dialog(activity!!)
        customDialogBL6.setContentView(bindingBL6.root)
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
                            toolbar?.title =  hy2ahModel.totalAmount.toString()
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
                    toolbar?.title =  hy2ahModel.totalAmount.toString()
                    binding.ch3.text = "راسية اكس"
                    binding.pric3.text = ""
                    hy2ahModel.ch1 =  ""
                    hy2ahModel.pric3 =  ""
                }else{binding.ch3.text = "راسية اكس"}
            }
        }

        binding.ch4.setOnCheckedChangeListener { _, isChecked ->
            if (binding.ch4.isChecked) {

                customDialogBRK.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

                bindingBRK.lDBrek.setOnTouchListener { _, event ->
                    var x = 0f
                    var y = 0f
                    when (event.action) {
                        MotionEvent.ACTION_UP -> {
                            x = event.x
                            y = event.y
                        }
                        MotionEvent.ACTION_MOVE -> {
                            customDialogBRK.window?.let {
                                val params: WindowManager.LayoutParams = it.attributes
                                params.x = event.rawX.toInt() - x.toInt()
                                params.y = event.rawY.toInt() - y.toInt()
                                it.attributes = params
                            }
                        }

                        MotionEvent.ACTION_UP -> {
                            customDialogBRK.window?.let {
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

                bindingBRK.dBFront.setOnCheckedChangeListener { _, isChecked1 ->

                    if (bindingBRK.dBFront.isChecked) {
                        binding.ch4.text = "بريك امامي"
                    } else {
                        binding.ch4.text = "بريك"
                        bindingBRK.s3erYadweeBreak.setText("")
                    }


                    if (bindingBRK.dBFront.isChecked && bindingBRK.dBRear.isChecked && bindingBRK.qb8ab.isChecked) {
                        binding.ch4.text = "بريك امامي خلفي و قبقاب خلفي كامل"
                        bindingBRK.s3erYadweeBreak.setText("15")
                    } else {

                        if (bindingBRK.dBRear.isChecked && bindingBRK.dBFront.isChecked && bindingBRK.qb8ab.isChecked) {
                            binding.ch4.text = "بريك امامي خلفي و قبقاب خلفي كامل"
                            bindingBRK.s3erYadweeBreak.setText("15")
                        } else {
                            if (bindingBRK.qb8ab.isChecked && bindingBRK.dBFront.isChecked && bindingBRK.dBRear.isChecked) {
                                binding.ch4.text = "بريك امامي خلفي و قبقاب خلفي كامل"
                                bindingBRK.s3erYadweeBreak.setText("15")
                            } else {
                                if (bindingBRK.qb8ab.isChecked && bindingBRK.dBRear.isChecked && bindingBRK.dBFront.isChecked) {
                                    binding.ch4.text = "بريك امامي خلفي و قبقاب خلفي كامل"
                                    bindingBRK.s3erYadweeBreak.setText("15")
                                } else {
                                    if (bindingBRK.dBFront.isChecked && bindingBRK.dBRear.isChecked) {
                                        binding.ch4.text = "بريك امامي و خلفي"
                                        bindingBRK.s3erYadweeBreak.setText("10")
                                    } else {
                                        if (bindingBRK.dBRear.isChecked && bindingBRK.dBFront.isChecked) {
                                            binding.ch4.text = "بريك امامي و خلفي"
                                            bindingBRK.s3erYadweeBreak.setText("10")
                                        } else {
                                            if (bindingBRK.dBFront.isChecked && bindingBRK.qb8ab.isChecked) {
                                                binding.ch4.text = "بريك امامي و قبقاب خلفي"
                                                bindingBRK.s3erYadweeBreak.setText("10")
                                            } else {
                                                if (bindingBRK.qb8ab.isChecked && bindingBRK.dBFront.isChecked) {
                                                    binding.ch4.text = "بريك امامي و قبقاب خلفي"
                                                    bindingBRK.s3erYadweeBreak.setText("10")
                                                } else {
                                                    if (bindingBRK.qb8ab.isChecked && bindingBRK.dBRear.isChecked) {
                                                        binding.ch4.text = "بريك خلفي و قبقاب خلفي"
                                                        bindingBRK.s3erYadweeBreak.setText("10")
                                                    } else {
                                                        if (bindingBRK.dBRear.isChecked && bindingBRK.qb8ab.isChecked) {
                                                            binding.ch4.text =
                                                                "بريك خلفي و قبقاب خلفي"
                                                            bindingBRK.s3erYadweeBreak.setText(
                                                                "10"
                                                            )
                                                        } else {

                                                            if (bindingBRK.dBFront.isChecked) {
                                                                binding.ch4.text =
                                                                    "بريك امامي"
                                                                bindingBRK.s3erYadweeBreak.setText(
                                                                    "5"
                                                                )
                                                            }
                                                            if (bindingBRK.dBRear.isChecked) {
                                                                binding.ch4.text =
                                                                    "بريك خلفي"
                                                                bindingBRK.s3erYadweeBreak.setText(
                                                                    "5"
                                                                )
                                                            }


                                                            if (bindingBRK.qb8ab.isChecked) {
                                                                binding.ch4.text =
                                                                    "قبقاب خلفي"
                                                                bindingBRK.s3erYadweeBreak.setText(
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

                    customDialogBRK.show()
                }

                bindingBRK.dBRear.setOnCheckedChangeListener { _, isChecked2 ->
                    if (bindingBRK.dBRear.isChecked) {
                        binding.ch4.text = "بريك خلفي"
                    } else {
                        binding.ch4.text = "بريك"
                        bindingBRK.s3erYadweeBreak.setText("")
                    }


                    if (bindingBRK.dBFront.isChecked && bindingBRK.dBRear.isChecked && bindingBRK.qb8ab.isChecked) {
                        binding.ch4.text = "بريك امامي خلفي و قبقاب خلفي كامل"
                        bindingBRK.s3erYadweeBreak.setText("15")
                    } else {

                        if (bindingBRK.dBRear.isChecked && bindingBRK.dBFront.isChecked && bindingBRK.qb8ab.isChecked) {
                            binding.ch4.text = "بريك امامي خلفي و قبقاب خلفي كامل"
                            bindingBRK.s3erYadweeBreak.setText("15")
                        } else {
                            if (bindingBRK.qb8ab.isChecked && bindingBRK.dBFront.isChecked && bindingBRK.dBRear.isChecked) {
                                binding.ch4.text = "بريك امامي خلفي و قبقاب خلفي كامل"
                                bindingBRK.s3erYadweeBreak.setText("15")
                            } else {
                                if (bindingBRK.qb8ab.isChecked && bindingBRK.dBRear.isChecked && bindingBRK.dBFront.isChecked) {
                                    binding.ch4.text = "بريك امامي خلفي و قبقاب خلفي كامل"
                                    bindingBRK.s3erYadweeBreak.setText("15")
                                } else {
                                    if (bindingBRK.dBFront.isChecked && bindingBRK.dBRear.isChecked) {
                                        binding.ch4.text = "بريك امامي و خلفي"
                                        bindingBRK.s3erYadweeBreak.setText("10")
                                    } else {
                                        if (bindingBRK.dBRear.isChecked && bindingBRK.dBFront.isChecked) {
                                            binding.ch4.text = "بريك امامي و خلفي"
                                            bindingBRK.s3erYadweeBreak.setText("10")
                                        } else {
                                            if (bindingBRK.dBFront.isChecked && bindingBRK.qb8ab.isChecked) {
                                                binding.ch4.text = "بريك امامي و قبقاب خلفي"
                                                bindingBRK.s3erYadweeBreak.setText("10")
                                            } else {
                                                if (bindingBRK.qb8ab.isChecked && bindingBRK.dBFront.isChecked) {
                                                    binding.ch4.text = "بريك امامي و قبقاب خلفي"
                                                    bindingBRK.s3erYadweeBreak.setText("10")
                                                } else {
                                                    if (bindingBRK.qb8ab.isChecked && bindingBRK.dBRear.isChecked) {
                                                        binding.ch4.text = "بريك خلفي و قبقاب خلفي"
                                                        bindingBRK.s3erYadweeBreak.setText("10")
                                                    } else {
                                                        if (bindingBRK.dBRear.isChecked && bindingBRK.qb8ab.isChecked) {
                                                            binding.ch4.text =
                                                                "بريك خلفي و قبقاب خلفي"
                                                            bindingBRK.s3erYadweeBreak.setText(
                                                                "10"
                                                            )
                                                        } else {

                                                            if (bindingBRK.dBFront.isChecked) {
                                                                binding.ch4.text =
                                                                    "بريك امامي"
                                                                bindingBRK.s3erYadweeBreak.setText(
                                                                    "5"
                                                                )
                                                            }
                                                            if (bindingBRK.dBRear.isChecked) {
                                                                binding.ch4.text =
                                                                    "بريك خلفي"
                                                                bindingBRK.s3erYadweeBreak.setText(
                                                                    "5"
                                                                )
                                                            }


                                                            if (bindingBRK.qb8ab.isChecked) {
                                                                binding.ch4.text =
                                                                    "قبقاب خلفي"
                                                                bindingBRK.s3erYadweeBreak.setText(
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

                    customDialogBRK.show()
                }




                bindingBRK.qb8ab.setOnCheckedChangeListener { _, isChecked2 ->
                    if (bindingBRK.qb8ab.isChecked) {
                        binding.ch4.text = "بريك قبقاب خلفي"
                    } else {
                        binding.ch4.text = "بريك"
                        bindingBRK.s3erYadweeBreak.setText("")
                    }


                    if (bindingBRK.dBFront.isChecked && bindingBRK.dBRear.isChecked && bindingBRK.qb8ab.isChecked) {
                        binding.ch4.text = "بريك امامي خلفي و قبقاب خلفي كامل"
                        bindingBRK.s3erYadweeBreak.setText("15")
                    } else {

                        if (bindingBRK.dBRear.isChecked && bindingBRK.dBFront.isChecked && bindingBRK.qb8ab.isChecked) {
                            binding.ch4.text = "بريك امامي خلفي و قبقاب خلفي كامل"
                            bindingBRK.s3erYadweeBreak.setText("15")
                        } else {
                            if (bindingBRK.qb8ab.isChecked && bindingBRK.dBFront.isChecked && bindingBRK.dBRear.isChecked) {
                                binding.ch4.text = "بريك امامي خلفي و قبقاب خلفي كامل"
                                bindingBRK.s3erYadweeBreak.setText("15")
                            } else {
                                if (bindingBRK.qb8ab.isChecked && bindingBRK.dBRear.isChecked && bindingBRK.dBFront.isChecked) {
                                    binding.ch4.text = "بريك امامي خلفي و قبقاب خلفي كامل"
                                    bindingBRK.s3erYadweeBreak.setText("15")
                                } else {
                                    if (bindingBRK.dBFront.isChecked && bindingBRK.dBRear.isChecked) {
                                        binding.ch4.text = "بريك امامي و خلفي"
                                        bindingBRK.s3erYadweeBreak.setText("10")
                                    } else {
                                        if (bindingBRK.dBRear.isChecked && bindingBRK.dBFront.isChecked) {
                                            binding.ch4.text = "بريك امامي و خلفي"
                                            bindingBRK.s3erYadweeBreak.setText("10")
                                        } else {
                                            if (bindingBRK.dBFront.isChecked && bindingBRK.qb8ab.isChecked) {
                                                binding.ch4.text = "بريك امامي و قبقاب خلفي"
                                                bindingBRK.s3erYadweeBreak.setText("10")
                                            } else {
                                                if (bindingBRK.qb8ab.isChecked && bindingBRK.dBFront.isChecked) {
                                                    binding.ch4.text = "بريك امامي و قبقاب خلفي"
                                                    bindingBRK.s3erYadweeBreak.setText("10")
                                                } else {
                                                    if (bindingBRK.qb8ab.isChecked && bindingBRK.dBRear.isChecked) {
                                                        binding.ch4.text = "بريك خلفي و قبقاب خلفي"
                                                        bindingBRK.s3erYadweeBreak.setText("10")
                                                    } else {
                                                        if (bindingBRK.dBRear.isChecked && bindingBRK.qb8ab.isChecked) {
                                                            binding.ch4.text =
                                                                "بريك خلفي و قبقاب خلفي"
                                                            bindingBRK.s3erYadweeBreak.setText(
                                                                "10"
                                                            )
                                                        } else {

                                                            if (bindingBRK.dBFront.isChecked) {
                                                                binding.ch4.text =
                                                                    "بريك امامي"
                                                                bindingBRK.s3erYadweeBreak.setText(
                                                                    "5"
                                                                )
                                                            }
                                                            if (bindingBRK.dBRear.isChecked) {
                                                                binding.ch4.text =
                                                                    "بريك خلفي"
                                                                bindingBRK.s3erYadweeBreak.setText(
                                                                    "5"
                                                                )
                                                            }


                                                            if (bindingBRK.qb8ab.isChecked) {
                                                                binding.ch4.text =
                                                                    "قبقاب خلفي"
                                                                bindingBRK.s3erYadweeBreak.setText(
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

                    customDialogBRK.show()
                }

                bindingBRK.btnSvDigBreak.setOnClickListener {
                    if (!bindingBRK.dBFront.isChecked && !bindingBRK.dBRear.isChecked
                        && !bindingBRK.qb8ab.isChecked
                    ) {
                        toast_notempty1.show()
                    } else {
                        if (bindingBRK.s3erYadweeBreak.text.toString().trim().isEmpty()) {
                            toast_notempty.show()
                        } else {
                            binding.pric4.text = bindingBRK.s3erYadweeBreak.text.toString()
                            hy2ahModel.totalAmount += binding.pric4.text.toString().toInt()
                            toolbar?.title =  hy2ahModel.totalAmount.toString()
                            hy2ahModel.ch4 = binding.ch4.text.toString().trim()
                            hy2ahModel.pric4 = binding.pric4.text.toString().trim()
                            customDialogBRK.dismiss()
                        }
                    }
                }

                bindingBRK.btnCnDigBreak.setOnClickListener {
                    if (binding.pric4.text.toString().isEmpty()) {
                        binding.ch4.text = "بريك"
                        binding.ch4.isChecked = false
                    }
                    customDialogBRK.dismiss()
                }
                bindingBRK.dBFront.isChecked = false
                bindingBRK.dBRear.isChecked = false
                bindingBRK.qb8ab.isChecked = false

                customDialogBRK.show()

            } else {
                if (binding.pric4.text.toString().isNotEmpty()) {
                    hy2ahModel.totalAmount -= binding.pric4.text.toString().toInt()
                    toolbar?.title =  hy2ahModel.totalAmount.toString()
                    binding.ch4.text = "بريك"
                    binding.pric4.setText("")
                    hy2ahModel.ch4 =  ""
                    hy2ahModel.pric4 =  ""
                } else {
                    binding.ch4.text = "بريك"
                }
            }
        }

        binding.ch5.setOnCheckedChangeListener { _, isChecked ->
            if (binding.ch5.isChecked) {
                bindingR2.titR2sOut.text = "خارجية"
                bindingR2.titR2sIn.text = "داخلية"
                customDialogR2SX.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

                bindingR2.cardR2s2ks.setOnTouchListener { _, event ->
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

                bindingR2.outsideright.setOnCheckedChangeListener { _, isChecked1 ->

                    if (bindingR2.outsideright.isChecked) {
                        binding.ch5.text = "كوشوكة اكس خارجية يمين"
                    } else {
                        binding.ch5.text = "كوشوكة اكس خارجية"
                        bindingR2.s3erR2sAcx.setText("")
                    }

                    if (bindingR2.outsideright.isChecked && bindingR2.outsideleft.isChecked && bindingR2.insideright.isChecked && bindingR2.insideleft.isChecked) {
                        binding.ch5.text = "تغير جميع كوشوكات الأكس الخارجية و الداخلية"
                        bindingR2.s3erR2sAcx.setText("20")
                    } else {
                        if (bindingR2.outsideright.isChecked && bindingR2.outsideleft.isChecked && bindingR2.insideright.isChecked) {
                            binding.ch5.text = "كوشوكتين اكس خارجية و الداخلية يمين"
                            bindingR2.s3erR2sAcx.setText("15")
                        } else {
                            if (bindingR2.outsideright.isChecked && bindingR2.outsideleft.isChecked && bindingR2.insideleft.isChecked) {
                                binding.ch5.text = "كوشوكتين اكس خارجية و الداخلية يسار"
                                bindingR2.s3erR2sAcx.setText("15")
                            } else {
                                if (bindingR2.outsideright.isChecked && bindingR2.insideright.isChecked && bindingR2.insideleft.isChecked) {
                                    binding.ch5.text = "كوشوكة اكس خارجية يمين و الداخليتين"
                                    bindingR2.s3erR2sAcx.setText("15")
                                } else {
                                    if (bindingR2.outsideleft.isChecked && bindingR2.insideright.isChecked && bindingR2.insideleft.isChecked) {
                                        binding.ch5.text = "كوشوكة اكس خارجية يسار و الداخليتين"
                                        bindingR2.s3erR2sAcx.setText("15")
                                    } else {
                                        if (bindingR2.outsideright.isChecked && bindingR2.outsideleft.isChecked) {
                                            binding.ch5.text = "كوشوكة اكس خارجية يمين و يسار"
                                            bindingR2.s3erR2sAcx.setText("10")
                                        } else {
                                            if (bindingR2.outsideright.isChecked && bindingR2.insideright.isChecked) {
                                                binding.ch5.text = "كوشوكة اكس خارجية يمين و داخلية يمين"
                                                bindingR2.s3erR2sAcx.setText("10")
                                            } else {
                                                if (bindingR2.outsideright.isChecked && bindingR2.insideleft.isChecked) {
                                                    binding.ch5.text = "كوشوكة اكس خارجية يمين و داخلية يسار"
                                                    bindingR2.s3erR2sAcx.setText("10")
                                                } else {
                                                    if (bindingR2.outsideleft.isChecked && bindingR2.insideright.isChecked) {
                                                        binding.ch5.text =
                                                            "كوشوكة اكس خارجية يسار و داخلية يمين"
                                                        bindingR2.s3erR2sAcx.setText("10")
                                                    } else {
                                                        if (bindingR2.outsideleft.isChecked && bindingR2.insideleft.isChecked) {
                                                            binding.ch5.text =
                                                                "كوشوكة اكس خارجية يسار و داخلية يسار"
                                                            bindingR2.s3erR2sAcx.setText("10")
                                                        } else {
                                                            if (bindingR2.insideright.isChecked && bindingR2.insideleft.isChecked) {
                                                                binding.ch5.text =
                                                                    "كوشوكة اكس داخلية يمين و يسار"
                                                                bindingR2.s3erR2sAcx.setText(
                                                                    "5"
                                                                )
                                                            } else {

                                                                if (bindingR2.outsideright.isChecked) {
                                                                    binding.ch5.text =
                                                                        "كوشوكة اكس خارجية يمين"
                                                                    bindingR2.s3erR2sAcx.setText(
                                                                        "5"
                                                                    )
                                                                }
                                                                if (bindingR2.outsideleft.isChecked) {
                                                                    binding.ch5.text =
                                                                        "كوشوكة اكس خارجية يسار"
                                                                    bindingR2.s3erR2sAcx.setText(
                                                                        "5"
                                                                    )
                                                                }

                                                                if (bindingR2.insideleft.isChecked) {
                                                                    binding.ch5.text =
                                                                        "كوشوكة اكس داخلية يسار"
                                                                    bindingR2.s3erR2sAcx.setText(
                                                                        "5"
                                                                    )
                                                                }
                                                                if (bindingR2.insideright.isChecked) {
                                                                    binding.ch5.text =
                                                                        "كوشوكة اكس داخلية يمين"
                                                                    bindingR2.s3erR2sAcx.setText(
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



                bindingR2.outsideleft.setOnCheckedChangeListener { _, isChecked2 ->
                    if (bindingR2.outsideleft.isChecked) {
                        binding.ch5.text = "راسية اكس خارجية يسار"
                    } else {
                        binding.ch5.text = "راسية اكس"
                        bindingR2.s3erR2sAcx.setText("")
                    }

                    if (bindingR2.outsideright.isChecked && bindingR2.outsideleft.isChecked && bindingR2.insideright.isChecked && bindingR2.insideleft.isChecked) {
                        binding.ch5.text = "تغير جميع كوشوكات الأكس الخارجية و الداخلية"
                        bindingR2.s3erR2sAcx.setText("20")
                    } else {
                        if (bindingR2.outsideright.isChecked && bindingR2.outsideleft.isChecked && bindingR2.insideright.isChecked) {
                            binding.ch5.text = "كوشوكتين اكس خارجية و الداخلية يمين"
                            bindingR2.s3erR2sAcx.setText("15")
                        } else {
                            if (bindingR2.outsideright.isChecked && bindingR2.outsideleft.isChecked && bindingR2.insideleft.isChecked) {
                                binding.ch5.text = "كوشوكتين اكس خارجية و الداخلية يسار"
                                bindingR2.s3erR2sAcx.setText("15")
                            } else {
                                if (bindingR2.outsideright.isChecked && bindingR2.insideright.isChecked && bindingR2.insideleft.isChecked) {
                                    binding.ch5.text = "كوشوكة اكس خارجية يمين و الداخليتين"
                                    bindingR2.s3erR2sAcx.setText("15")
                                } else {
                                    if (bindingR2.outsideleft.isChecked && bindingR2.insideright.isChecked && bindingR2.insideleft.isChecked) {
                                        binding.ch5.text = "كوشوكة اكس خارجية يسار و الداخليتين"
                                        bindingR2.s3erR2sAcx.setText("15")
                                    } else {
                                        if (bindingR2.outsideright.isChecked && bindingR2.outsideleft.isChecked) {
                                            binding.ch5.text = "كوشوكة اكس خارجية يمين و يسار"
                                            bindingR2.s3erR2sAcx.setText("10")
                                        } else {
                                            if (bindingR2.outsideright.isChecked && bindingR2.insideright.isChecked) {
                                                binding.ch5.text = "كوشوكة اكس خارجية يمين و داخلية يمين"
                                                bindingR2.s3erR2sAcx.setText("10")
                                            } else {
                                                if (bindingR2.outsideright.isChecked && bindingR2.insideleft.isChecked) {
                                                    binding.ch5.text = "كوشوكة اكس خارجية يمين و داخلية يسار"
                                                    bindingR2.s3erR2sAcx.setText("10")
                                                } else {
                                                    if (bindingR2.outsideleft.isChecked && bindingR2.insideright.isChecked) {
                                                        binding.ch5.text =
                                                            "كوشوكة اكس خارجية يسار و داخلية يمين"
                                                        bindingR2.s3erR2sAcx.setText("10")
                                                    } else {
                                                        if (bindingR2.outsideleft.isChecked && bindingR2.insideleft.isChecked) {
                                                            binding.ch5.text =
                                                                "كوشوكة اكس خارجية يسار و داخلية يسار"
                                                            bindingR2.s3erR2sAcx.setText("10")
                                                        } else {
                                                            if (bindingR2.insideright.isChecked && bindingR2.insideleft.isChecked) {
                                                                binding.ch5.text =
                                                                    "كوشوكة اكس داخلية يمين و يسار"
                                                                bindingR2.s3erR2sAcx.setText(
                                                                    "5"
                                                                )
                                                            } else {

                                                                if (bindingR2.outsideright.isChecked) {
                                                                    binding.ch5.text =
                                                                        "كوشوكة اكس خارجية يمين"
                                                                    bindingR2.s3erR2sAcx.setText(
                                                                        "5"
                                                                    )
                                                                }
                                                                if (bindingR2.outsideleft.isChecked) {
                                                                    binding.ch5.text =
                                                                        "كوشوكة اكس خارجية يسار"
                                                                    bindingR2.s3erR2sAcx.setText(
                                                                        "5"
                                                                    )
                                                                }

                                                                if (bindingR2.insideleft.isChecked) {
                                                                    binding.ch5.text =
                                                                        "كوشوكة اكس داخلية يسار"
                                                                    bindingR2.s3erR2sAcx.setText(
                                                                        "5"
                                                                    )
                                                                }
                                                                if (bindingR2.insideright.isChecked) {
                                                                    binding.ch5.text =
                                                                        "كوشوكة اكس داخلية يمين"
                                                                    bindingR2.s3erR2sAcx.setText(
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



                bindingR2.insideleft.setOnCheckedChangeListener { _, isChecked2 ->
                    if (bindingR2.outsideright.isChecked) {
                        binding.ch5.text = "كوشوكة اكس خارجية يمين"
                    } else {
                        binding.ch5.text = "كوشوكة اكس خارجية"
                        bindingR2.s3erR2sAcx.setText("")
                    }

                    if (bindingR2.outsideright.isChecked && bindingR2.outsideleft.isChecked && bindingR2.insideright.isChecked && bindingR2.insideleft.isChecked) {
                        binding.ch5.text = "تغير جميع كوشوكات الأكس الخارجية و الداخلية"
                        bindingR2.s3erR2sAcx.setText("20")
                    } else {
                        if (bindingR2.outsideright.isChecked && bindingR2.outsideleft.isChecked && bindingR2.insideright.isChecked) {
                            binding.ch5.text = "كوشوكتين اكس خارجية و الداخلية يمين"
                            bindingR2.s3erR2sAcx.setText("15")
                        } else {
                            if (bindingR2.outsideright.isChecked && bindingR2.outsideleft.isChecked && bindingR2.insideleft.isChecked) {
                                binding.ch5.text = "كوشوكتين اكس خارجية و الداخلية يسار"
                                bindingR2.s3erR2sAcx.setText("15")
                            } else {
                                if (bindingR2.outsideright.isChecked && bindingR2.insideright.isChecked && bindingR2.insideleft.isChecked) {
                                    binding.ch5.text = "كوشوكة اكس خارجية يمين و الداخليتين"
                                    bindingR2.s3erR2sAcx.setText("15")
                                } else {
                                    if (bindingR2.outsideleft.isChecked && bindingR2.insideright.isChecked && bindingR2.insideleft.isChecked) {
                                        binding.ch5.text = "كوشوكة اكس خارجية يسار و الداخليتين"
                                        bindingR2.s3erR2sAcx.setText("15")
                                    } else {
                                        if (bindingR2.outsideright.isChecked && bindingR2.outsideleft.isChecked) {
                                            binding.ch5.text = "كوشوكة اكس خارجية يمين و يسار"
                                            bindingR2.s3erR2sAcx.setText("10")
                                        } else {
                                            if (bindingR2.outsideright.isChecked && bindingR2.insideright.isChecked) {
                                                binding.ch5.text = "كوشوكة اكس خارجية يمين و داخلية يمين"
                                                bindingR2.s3erR2sAcx.setText("10")
                                            } else {
                                                if (bindingR2.outsideright.isChecked && bindingR2.insideleft.isChecked) {
                                                    binding.ch5.text = "كوشوكة اكس خارجية يمين و داخلية يسار"
                                                    bindingR2.s3erR2sAcx.setText("10")
                                                } else {
                                                    if (bindingR2.outsideleft.isChecked && bindingR2.insideright.isChecked) {
                                                        binding.ch5.text =
                                                            "كوشوكة اكس خارجية يسار و داخلية يمين"
                                                        bindingR2.s3erR2sAcx.setText("10")
                                                    } else {
                                                        if (bindingR2.outsideleft.isChecked && bindingR2.insideleft.isChecked) {
                                                            binding.ch5.text =
                                                                "كوشوكة اكس خارجية يسار و داخلية يسار"
                                                            bindingR2.s3erR2sAcx.setText("10")
                                                        } else {
                                                            if (bindingR2.insideright.isChecked && bindingR2.insideleft.isChecked) {
                                                                binding.ch5.text =
                                                                    "كوشوكة اكس داخلية يمين و يسار"
                                                                bindingR2.s3erR2sAcx.setText(
                                                                    "5"
                                                                )
                                                            } else {

                                                                if (bindingR2.outsideright.isChecked) {
                                                                    binding.ch5.text =
                                                                        "كوشوكة اكس خارجية يمين"
                                                                    bindingR2.s3erR2sAcx.setText(
                                                                        "5"
                                                                    )
                                                                }
                                                                if (bindingR2.outsideleft.isChecked) {
                                                                    binding.ch5.text =
                                                                        "كوشوكة اكس خارجية يسار"
                                                                    bindingR2.s3erR2sAcx.setText(
                                                                        "5"
                                                                    )
                                                                }

                                                                if (bindingR2.insideleft.isChecked) {
                                                                    binding.ch5.text =
                                                                        "كوشوكة اكس داخلية يسار"
                                                                    bindingR2.s3erR2sAcx.setText(
                                                                        "5"
                                                                    )
                                                                }
                                                                if (bindingR2.insideright.isChecked) {
                                                                    binding.ch5.text =
                                                                        "كوشوكة اكس داخلية يمين"
                                                                    bindingR2.s3erR2sAcx.setText(
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

                bindingR2.insideright.setOnCheckedChangeListener { _, isChecked2 ->
                    if (bindingR2.outsideright.isChecked) {
                        binding.ch5.text = "كوشوكة اكس خارجية يمين"
                    } else {
                        binding.ch5.text = "كوشوكة اكس خارجية"
                        bindingR2.s3erR2sAcx.setText("")
                    }

                    if (bindingR2.outsideright.isChecked && bindingR2.outsideleft.isChecked && bindingR2.insideright.isChecked && bindingR2.insideleft.isChecked) {
                        binding.ch5.text = "تغير جميع كوشوكات الأكس الخارجية و الداخلية"
                        bindingR2.s3erR2sAcx.setText("20")
                    } else {
                        if (bindingR2.outsideright.isChecked && bindingR2.outsideleft.isChecked && bindingR2.insideright.isChecked) {
                            binding.ch5.text = "كوشوكتين اكس خارجية و الداخلية يمين"
                            bindingR2.s3erR2sAcx.setText("15")
                        } else {
                            if (bindingR2.outsideright.isChecked && bindingR2.outsideleft.isChecked && bindingR2.insideleft.isChecked) {
                                binding.ch5.text = "كوشوكتين اكس خارجية و الداخلية يسار"
                                bindingR2.s3erR2sAcx.setText("15")
                            } else {
                                if (bindingR2.outsideright.isChecked && bindingR2.insideright.isChecked && bindingR2.insideleft.isChecked) {
                                    binding.ch5.text = "كوشوكة اكس خارجية يمين و الداخليتين"
                                    bindingR2.s3erR2sAcx.setText("15")
                                } else {
                                    if (bindingR2.outsideleft.isChecked && bindingR2.insideright.isChecked && bindingR2.insideleft.isChecked) {
                                        binding.ch5.text = "كوشوكة اكس خارجية يسار و الداخليتين"
                                        bindingR2.s3erR2sAcx.setText("15")
                                    } else {
                                        if (bindingR2.outsideright.isChecked && bindingR2.outsideleft.isChecked) {
                                            binding.ch5.text = "كوشوكة اكس خارجية يمين و يسار"
                                            bindingR2.s3erR2sAcx.setText("10")
                                        } else {
                                            if (bindingR2.outsideright.isChecked && bindingR2.insideright.isChecked) {
                                                binding.ch5.text = "كوشوكة اكس خارجية يمين و داخلية يمين"
                                                bindingR2.s3erR2sAcx.setText("10")
                                            } else {
                                                if (bindingR2.outsideright.isChecked && bindingR2.insideleft.isChecked) {
                                                    binding.ch5.text = "كوشوكة اكس خارجية يمين و داخلية يسار"
                                                    bindingR2.s3erR2sAcx.setText("10")
                                                } else {
                                                    if (bindingR2.outsideleft.isChecked && bindingR2.insideright.isChecked) {
                                                        binding.ch5.text =
                                                            "كوشوكة اكس خارجية يسار و داخلية يمين"
                                                        bindingR2.s3erR2sAcx.setText("10")
                                                    } else {
                                                        if (bindingR2.outsideleft.isChecked && bindingR2.insideleft.isChecked) {
                                                            binding.ch5.text =
                                                                "كوشوكة اكس خارجية يسار و داخلية يسار"
                                                            bindingR2.s3erR2sAcx.setText("10")
                                                        } else {
                                                            if (bindingR2.insideright.isChecked && bindingR2.insideleft.isChecked) {
                                                                binding.ch5.text =
                                                                    "كوشوكة اكس داخلية يمين و يسار"
                                                                bindingR2.s3erR2sAcx.setText(
                                                                    "5"
                                                                )
                                                            } else {

                                                                if (bindingR2.outsideright.isChecked) {
                                                                    binding.ch5.text =
                                                                        "كوشوكة اكس خارجية يمين"
                                                                    bindingR2.s3erR2sAcx.setText(
                                                                        "5"
                                                                    )
                                                                }
                                                                if (bindingR2.outsideleft.isChecked) {
                                                                    binding.ch5.text =
                                                                        "كوشوكة اكس خارجية يسار"
                                                                    bindingR2.s3erR2sAcx.setText(
                                                                        "5"
                                                                    )
                                                                }

                                                                if (bindingR2.insideleft.isChecked) {
                                                                    binding.ch5.text =
                                                                        "كوشوكة اكس داخلية يسار"
                                                                    bindingR2.s3erR2sAcx.setText(
                                                                        "5"
                                                                    )
                                                                }
                                                                if (bindingR2.insideright.isChecked) {
                                                                    binding.ch5.text =
                                                                        "كوشوكة اكس داخلية يمين"
                                                                    bindingR2.s3erR2sAcx.setText(
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


                bindingR2.btnR2sSav.setOnClickListener {
                    if (!bindingR2.outsideright.isChecked && !bindingR2.outsideleft.isChecked
                        && !bindingR2.insideright.isChecked && !bindingR2.insideleft.isChecked
                    ) {
                        toast_notempty1.show()
                    } else {
                        if (bindingR2.s3erR2sAcx.text.toString().trim().isEmpty()) {
                            toast_notempty.show()
                        } else {
                            binding.pric5.text = bindingR2.s3erR2sAcx.text.toString()
                            hy2ahModel.totalAmount += binding.pric5.text.toString().toInt()
                            toolbar?.title =  hy2ahModel.totalAmount.toString()
                            hy2ahModel.ch5 = binding.ch5.text.toString().trim()
                            hy2ahModel.pric5 = binding.pric5.text.toString().trim()
                            customDialogR2SX.dismiss()
                        }
                    }
                }
                bindingR2.btnR2sCan.setOnClickListener {
                    if (binding.pric5.text.toString().isEmpty()) {
                        binding.ch5.text = "كوشوكة اكس"
                        binding.ch5.isChecked = false
                    }
                    customDialogR2SX.dismiss()
                }
                bindingR2.outsideright.isChecked = false
                bindingR2.outsideleft.isChecked = false
                bindingR2.insideright.isChecked = false
                bindingR2.insideleft.isChecked = false

                customDialogR2SX.show()

            } else {
                if (binding.pric5.text.toString().isNotEmpty()) {
                    hy2ahModel.totalAmount -= binding.pric5.text.toString().toInt()
                    toolbar?.title =  hy2ahModel.totalAmount.toString()
                    binding.ch5.text = "كوشوكة اكس"
                    binding.pric5.setText("")
                    hy2ahModel.ch5 =  ""
                    hy2ahModel.pric5 =  ""
                } else {
                    binding.ch5.text = "كوشوكة اكس"
                }
            }
        }


        binding.apply{
            ch6.setOnCheckedChangeListener { _, isChecked ->
                if (ch6.isChecked) {

                    bindingFR.frontright.setOnCheckedChangeListener { _, isChecked1 ->
                        if (bindingFR.frontright.isChecked) {
                            ch6.text = "اكس امامي يمين"
                        } else {
                            ch6.text = "اكس امامي"
                            bindingFR.s3erYadwee.setText("")
                        }
                        if (bindingFR.frontright.isChecked && bindingFR.frontleft.isChecked) {
                            ch6.text = "اكس امامي يمين و يسار"
                            bindingFR.s3erYadwee.setText("10")
                        } else {
                            if (bindingFR.frontright.isChecked) {
                                ch6.text = "اكس امامي يمين"
                                bindingFR.s3erYadwee.setText("5")
                            }
                            if (bindingFR.frontleft.isChecked) {
                                ch6.text = "اكس امامي يسار"
                                bindingFR.s3erYadwee.setText("5")
                            }
                        }
                    }

                    bindingFR.frontleft.setOnCheckedChangeListener { _, isChecked2 ->
                        if (bindingFR.frontleft.isChecked) {
                            ch6.text = "اكس امامي يسار"
                        } else {
                            ch6.text = "اكس امامي"
                            bindingFR.s3erYadwee.setText("")
                        }
                        if (bindingFR.frontright.isChecked && bindingFR.frontleft.isChecked) {
                            ch6.text = "اكس امامي يمين و يسار"
                            bindingFR.s3erYadwee.setText("10")
                        } else {
                            if (bindingFR.frontleft.isChecked) {
                                ch6.text = "اكس امامي يسار"
                                bindingFR.s3erYadwee.setText("5")
                            }
                            if (bindingFR.frontright.isChecked) {
                                ch6.text = "اكس امامي يمين"
                                bindingFR.s3erYadwee.setText("5")
                            }
                        }
                    }

                    bindingFR.buttonDailogSave.setOnClickListener {
                        if (!bindingFR.frontright.isChecked && !bindingFR.frontleft.isChecked) {
                            toast_notempty1.show()
                        } else {
                            if (bindingFR.s3erYadwee.text.toString().trim().isEmpty()) {
                                toast_notempty.show()
                                ch6.isChecked = false
                            } else {
                                pric6.text = bindingFR.s3erYadwee.text.toString()
                                hy2ahModel.totalAmount += pric6.text.toString().toInt()
                                toolbar?.title =  hy2ahModel.totalAmount.toString()
                                hy2ahModel.ch6 = ch6.text.toString().trim()
                                hy2ahModel.pric6 = pric6.text.toString().trim()
                                customDialogFR.dismiss()
                            }
                        }
                    }
                    bindingFR.buttonDailogCancel.setOnClickListener {
                        ch6.isChecked = false
                        bindingFR.s3erYadwee.setText("")
                        customDialogFR.dismiss()
                    }
                    bindingFR.frontright.isChecked = false
                    bindingFR.frontleft.isChecked = false
                    customDialogFR.show()

                }
                else {
                    if (pric6.text.toString().isNotEmpty()){
                        hy2ahModel.totalAmount -= pric6.text.toString().toInt()
                        toolbar?.title =  hy2ahModel.totalAmount.toString()
                        pric6.text = ""
                        hy2ahModel.ch6 =  ""
                        hy2ahModel.pric6 =  ""
                    }
                    ch6.text = "اكس امامي"
                }
            }
        }

        binding.apply{
            ch7.setOnCheckedChangeListener { _, isChecked ->
                if (ch7.isChecked) {

                    bindingFR.linF.setOnTouchListener { _, event ->
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

                    bindingFR.frontright.setOnCheckedChangeListener { _, isChecked1 ->
                        if (bindingFR.frontright.isChecked) {
                            ch7.text = "كوشوكة منفاخ يمين"
                        } else {
                            ch7.text = "كوشوكة منفاخ"
                            bindingFR.s3erYadwee.setText("")
                        }
                        if (bindingFR.frontright.isChecked && bindingFR.frontleft.isChecked) {
                            ch7.text = "كوشوكة منفاخ يمين و يسار"
                            bindingFR.s3erYadwee.setText("6")
                        } else {
                            if (bindingFR.frontright.isChecked) {
                                ch7.text = "كوشوكة منفاخ يمين"
                                bindingFR.s3erYadwee.setText("3")
                            }
                            if (bindingFR.frontleft.isChecked) {
                                ch7.text = "كوشوكة منفاخ يسار"
                                bindingFR.s3erYadwee.setText("3")
                            }
                        }
                    }

                    bindingFR.frontleft.setOnCheckedChangeListener { _, isChecked2 ->
                        if (bindingFR.frontleft.isChecked) {
                            ch7.text = "كوشوكة منفاخ يسار"
                        } else {
                            ch7.text = "كوشوكة منفاخ"
                            bindingFR.s3erYadwee.setText("")
                        }
                        if (bindingFR.frontright.isChecked && bindingFR.frontleft.isChecked) {
                            ch7.text = "كوشوكة منفاخ يمين و يسار"
                            bindingFR.s3erYadwee.setText("6")
                        } else {
                            if (bindingFR.frontleft.isChecked) {
                                ch7.text = "كوشوكة منفاخ يسار"
                                bindingFR.s3erYadwee.setText("3")
                            }
                            if (bindingFR.frontright.isChecked) {
                                ch7.text = "كوشوكة منفاخ يمين"
                                bindingFR.s3erYadwee.setText("3")
                            }
                        }
                    }

                    bindingFR.buttonDailogSave.setOnClickListener {
                        if (!bindingFR.frontright.isChecked && !bindingFR.frontleft.isChecked) {
                            toast_notempty1.show()
                        } else {
                            if (bindingFR.s3erYadwee.text.toString().trim().isEmpty()) {
                                toast_notempty.show()
                                ch7.isChecked = false
                            } else {
                                pric7.text = bindingFR.s3erYadwee.text.toString()
                                hy2ahModel.totalAmount += pric7.text.toString().toInt()
                                toolbar?.title =  hy2ahModel.totalAmount.toString()
                                hy2ahModel.ch7 = ch7.text.toString().trim()
                                hy2ahModel.pric7 = pric7.text.toString().trim()
                                customDialogFR.dismiss()
                            }
                        }
                    }
                    bindingFR.buttonDailogCancel.setOnClickListener {
                        ch7.isChecked = false
                        bindingFR.s3erYadwee.setText("")
                        customDialogFR.dismiss()
                    }
                    bindingFR.frontright.isChecked = false
                    bindingFR.frontleft.isChecked = false
                    customDialogFR.show()

                }
                else {
                    if (pric7.text.toString().isNotEmpty()){
                        hy2ahModel.totalAmount -= pric7.text.toString().toInt()
                        toolbar?.title =  hy2ahModel.totalAmount.toString()
                        pric7.text = ""
                        hy2ahModel.ch7 =  ""
                        hy2ahModel.pric7 =  ""
                    }
                    ch7.text = "كوشوكة منفاخ"
                }
            }
        }

        binding.apply{
            ch8.setOnCheckedChangeListener { _, isChecked ->
                if (ch8.isChecked) {

                    customDialogR2SX.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

                    bindingR2.titR2sOut.text="امامي"
                    bindingR2.titR2sIn.text="خلفي"

                    bindingR2.cardR2s2ks.setOnTouchListener { _, event ->
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

                    bindingR2.outsideright.setOnCheckedChangeListener { _, isChecked1 ->

                        if (bindingR2.outsideright.isChecked) {
                            ch8.text = "كوشوكة عمود شيال امامي يمين"
                        } else {
                            ch8.text = "كوشوكة عمود شيال"
                            bindingR2.s3erR2sAcx.setText("")
                        }

                        if (bindingR2.outsideright.isChecked && bindingR2.outsideleft.isChecked && bindingR2.insideright.isChecked && bindingR2.insideleft.isChecked) {
                            ch8.text = "تغير جميع كوشوكات عمود الشيال"
                            bindingR2.s3erR2sAcx.setText("30")
                        } else {
                            if (bindingR2.outsideright.isChecked && bindingR2.outsideleft.isChecked && bindingR2.insideright.isChecked) {
                                ch8.text = "كوشوكتين عمود شيال امامي و الخلفي يمين"
                                bindingR2.s3erR2sAcx.setText("25")
                            } else {
                                if (bindingR2.outsideright.isChecked && bindingR2.outsideleft.isChecked && bindingR2.insideleft.isChecked) {
                                    ch8.text = "كوشوكتين عمود شيال امامي  و الخلفي يسار"
                                    bindingR2.s3erR2sAcx.setText("25")
                                } else {
                                    if (bindingR2.outsideright.isChecked && bindingR2.insideright.isChecked && bindingR2.insideleft.isChecked) {
                                        ch8.text = "كوشوكة عمود شيال امامي يمين و الخلفيتين"
                                        bindingR2.s3erR2sAcx.setText("20")
                                    } else {
                                        if (bindingR2.outsideleft.isChecked && bindingR2.insideright.isChecked && bindingR2.insideleft.isChecked) {
                                            ch8.text = "كوشوكة عمود شيال امامي يسار و الخلفيتين"
                                            bindingR2.s3erR2sAcx.setText("20")
                                        } else {
                                            if (bindingR2.outsideright.isChecked && bindingR2.outsideleft.isChecked) {
                                                ch8.text = "كوشوكة عمود شيال امامي يمين و يسار"
                                                bindingR2.s3erR2sAcx.setText("20")
                                            } else {
                                                if (bindingR2.outsideright.isChecked && bindingR2.insideright.isChecked) {
                                                    ch8.text = "كوشوكة عمود شيال امامي يمين و خلفي يمين"
                                                    bindingR2.s3erR2sAcx.setText("15")
                                                } else {
                                                    if (bindingR2.outsideright.isChecked && bindingR2.insideleft.isChecked) {
                                                        ch8.text = "كوشوكة عمود شيال امامي يمين و خلفي يسار"
                                                        bindingR2.s3erR2sAcx.setText("15")
                                                    } else {
                                                        if (bindingR2.outsideleft.isChecked && bindingR2.insideright.isChecked) {
                                                            ch8.text =
                                                                "كوشوكة عمود شيال امامي يسار و خلفي يمين"
                                                            bindingR2.s3erR2sAcx.setText("15")
                                                        } else {
                                                            if (bindingR2.outsideleft.isChecked && bindingR2.insideleft.isChecked) {
                                                                ch8.text =
                                                                    "كوشوكة عمود شيال امامي يسار و خلفي يسار"
                                                                bindingR2.s3erR2sAcx.setText("15")
                                                            } else {
                                                                if (bindingR2.insideright.isChecked && bindingR2.insideleft.isChecked) {
                                                                    ch8.text =
                                                                        "كوشوكة عمود شيال خلفي يمين و يسار"
                                                                    bindingR2.s3erR2sAcx.setText(
                                                                        "10"
                                                                    )
                                                                } else {

                                                                    if (bindingR2.outsideright.isChecked) {
                                                                        ch8.text =
                                                                            "كوشوكة عمود شيال امامي يمين"
                                                                        bindingR2.s3erR2sAcx.setText(
                                                                            "10"
                                                                        )
                                                                    }
                                                                    if (bindingR2.outsideleft.isChecked) {
                                                                        ch8.text =
                                                                            "كوشوكة عمود شيال امامي يسار"
                                                                        bindingR2.s3erR2sAcx.setText(
                                                                            "10"
                                                                        )
                                                                    }

                                                                    if (bindingR2.insideleft.isChecked) {
                                                                        ch8.text =
                                                                            "كوشوكة عمود شيال خلفي يسار"
                                                                        bindingR2.s3erR2sAcx.setText(
                                                                            "5"
                                                                        )
                                                                    }
                                                                    if (bindingR2.insideright.isChecked) {
                                                                        ch8.text =
                                                                            "كوشوكة عمود شيال خلفي يمين"
                                                                        bindingR2.s3erR2sAcx.setText(
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



                    bindingR2.outsideleft.setOnCheckedChangeListener { _, isChecked2 ->
                        if (bindingR2.outsideleft.isChecked) {
                            ch8.text = "كوشوكة عمود شيال امامي يسار"
                        } else {
                            ch8.text = "كوشوكة عمود شيال"
                            bindingR2.s3erR2sAcx.setText("")
                        }

                        if (bindingR2.outsideright.isChecked && bindingR2.outsideleft.isChecked && bindingR2.insideright.isChecked && bindingR2.insideleft.isChecked) {
                            ch8.text = "تغير جميع كوشوكات عمود الشيال"
                            bindingR2.s3erR2sAcx.setText("30")
                        } else {
                            if (bindingR2.outsideright.isChecked && bindingR2.outsideleft.isChecked && bindingR2.insideright.isChecked) {
                                ch8.text = "كوشوكتين عمود شيال امامي و الخلفي يمين"
                                bindingR2.s3erR2sAcx.setText("25")
                            } else {
                                if (bindingR2.outsideright.isChecked && bindingR2.outsideleft.isChecked && bindingR2.insideleft.isChecked) {
                                    ch8.text = "كوشوكتين عمود شيال امامي  و الخلفي يسار"
                                    bindingR2.s3erR2sAcx.setText("25")
                                } else {
                                    if (bindingR2.outsideright.isChecked && bindingR2.insideright.isChecked && bindingR2.insideleft.isChecked) {
                                        ch8.text = "كوشوكة عمود شيال امامي يمين و الخلفيتين"
                                        bindingR2.s3erR2sAcx.setText("20")
                                    } else {
                                        if (bindingR2.outsideleft.isChecked && bindingR2.insideright.isChecked && bindingR2.insideleft.isChecked) {
                                            ch8.text = "كوشوكة عمود شيال امامي يسار و الخلفيتين"
                                            bindingR2.s3erR2sAcx.setText("20")
                                        } else {
                                            if (bindingR2.outsideright.isChecked && bindingR2.outsideleft.isChecked) {
                                                ch8.text = "كوشوكة عمود شيال امامي يمين و يسار"
                                                bindingR2.s3erR2sAcx.setText("20")
                                            } else {
                                                if (bindingR2.outsideright.isChecked && bindingR2.insideright.isChecked) {
                                                    ch8.text = "كوشوكة عمود شيال امامي يمين و خلفي يمين"
                                                    bindingR2.s3erR2sAcx.setText("15")
                                                } else {
                                                    if (bindingR2.outsideright.isChecked && bindingR2.insideleft.isChecked) {
                                                        ch8.text = "كوشوكة عمود شيال امامي يمين و خلفي يسار"
                                                        bindingR2.s3erR2sAcx.setText("15")
                                                    } else {
                                                        if (bindingR2.outsideleft.isChecked && bindingR2.insideright.isChecked) {
                                                            ch8.text =
                                                                "كوشوكة عمود شيال امامي يسار و خلفي يمين"
                                                            bindingR2.s3erR2sAcx.setText("15")
                                                        } else {
                                                            if (bindingR2.outsideleft.isChecked && bindingR2.insideleft.isChecked) {
                                                                ch8.text =
                                                                    "كوشوكة عمود شيال امامي يسار و خلفي يسار"
                                                                bindingR2.s3erR2sAcx.setText("15")
                                                            } else {
                                                                if (bindingR2.insideright.isChecked && bindingR2.insideleft.isChecked) {
                                                                    ch8.text =
                                                                        "كوشوكة عمود شيال خلفي يمين و يسار"
                                                                    bindingR2.s3erR2sAcx.setText(
                                                                        "10"
                                                                    )
                                                                } else {

                                                                    if (bindingR2.outsideright.isChecked) {
                                                                        ch8.text =
                                                                            "كوشوكة عمود شيال امامي يمين"
                                                                        bindingR2.s3erR2sAcx.setText(
                                                                            "10"
                                                                        )
                                                                    }
                                                                    if (bindingR2.outsideleft.isChecked) {
                                                                        ch8.text =
                                                                            "كوشوكة عمود شيال امامي يسار"
                                                                        bindingR2.s3erR2sAcx.setText(
                                                                            "10"
                                                                        )
                                                                    }

                                                                    if (bindingR2.insideleft.isChecked) {
                                                                        ch8.text =
                                                                            "كوشوكة عمود شيال خلفي يسار"
                                                                        bindingR2.s3erR2sAcx.setText(
                                                                            "5"
                                                                        )
                                                                    }
                                                                    if (bindingR2.insideright.isChecked) {
                                                                        ch8.text =
                                                                            "كوشوكة عمود شيال خلفي يمين"
                                                                        bindingR2.s3erR2sAcx.setText(
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



                    bindingR2.insideleft.setOnCheckedChangeListener { _, isChecked2 ->
                        if (bindingR2.outsideright.isChecked) {
                            ch8.text = "كوشوكة عمود شيال خلفي يمين"
                        } else {
                            ch8.text = "كوشوكة عمود شيال"
                            bindingR2.s3erR2sAcx.setText("")
                        }

                        if (bindingR2.outsideright.isChecked && bindingR2.outsideleft.isChecked && bindingR2.insideright.isChecked && bindingR2.insideleft.isChecked) {
                            ch8.text = "تغير جميع كوشوكات عمود الشيال"
                            bindingR2.s3erR2sAcx.setText("30")
                        } else {
                            if (bindingR2.outsideright.isChecked && bindingR2.outsideleft.isChecked && bindingR2.insideright.isChecked) {
                                ch8.text = "كوشوكتين عمود شيال امامي و الخلفي يمين"
                                bindingR2.s3erR2sAcx.setText("25")
                            } else {
                                if (bindingR2.outsideright.isChecked && bindingR2.outsideleft.isChecked && bindingR2.insideleft.isChecked) {
                                    ch8.text = "كوشوكتين عمود شيال امامي  و الخلفي يسار"
                                    bindingR2.s3erR2sAcx.setText("25")
                                } else {
                                    if (bindingR2.outsideright.isChecked && bindingR2.insideright.isChecked && bindingR2.insideleft.isChecked) {
                                        ch8.text = "كوشوكة عمود شيال امامي يمين و الخلفيتين"
                                        bindingR2.s3erR2sAcx.setText("20")
                                    } else {
                                        if (bindingR2.outsideleft.isChecked && bindingR2.insideright.isChecked && bindingR2.insideleft.isChecked) {
                                            ch8.text = "كوشوكة عمود شيال امامي يسار و الخلفيتين"
                                            bindingR2.s3erR2sAcx.setText("20")
                                        } else {
                                            if (bindingR2.outsideright.isChecked && bindingR2.outsideleft.isChecked) {
                                                ch8.text = "كوشوكة عمود شيال امامي يمين و يسار"
                                                bindingR2.s3erR2sAcx.setText("20")
                                            } else {
                                                if (bindingR2.outsideright.isChecked && bindingR2.insideright.isChecked) {
                                                    ch8.text = "كوشوكة عمود شيال امامي يمين و خلفي يمين"
                                                    bindingR2.s3erR2sAcx.setText("15")
                                                } else {
                                                    if (bindingR2.outsideright.isChecked && bindingR2.insideleft.isChecked) {
                                                        ch8.text = "كوشوكة عمود شيال امامي يمين و خلفي يسار"
                                                        bindingR2.s3erR2sAcx.setText("15")
                                                    } else {
                                                        if (bindingR2.outsideleft.isChecked && bindingR2.insideright.isChecked) {
                                                            ch8.text =
                                                                "كوشوكة عمود شيال امامي يسار و خلفي يمين"
                                                            bindingR2.s3erR2sAcx.setText("15")
                                                        } else {
                                                            if (bindingR2.outsideleft.isChecked && bindingR2.insideleft.isChecked) {
                                                                ch8.text =
                                                                    "كوشوكة عمود شيال امامي يسار و خلفي يسار"
                                                                bindingR2.s3erR2sAcx.setText("15")
                                                            } else {
                                                                if (bindingR2.insideright.isChecked && bindingR2.insideleft.isChecked) {
                                                                    ch8.text =
                                                                        "كوشوكة عمود شيال خلفي يمين و يسار"
                                                                    bindingR2.s3erR2sAcx.setText(
                                                                        "10"
                                                                    )
                                                                } else {

                                                                    if (bindingR2.outsideright.isChecked) {
                                                                        ch8.text =
                                                                            "كوشوكة عمود شيال امامي يمين"
                                                                        bindingR2.s3erR2sAcx.setText(
                                                                            "10"
                                                                        )
                                                                    }
                                                                    if (bindingR2.outsideleft.isChecked) {
                                                                        ch8.text =
                                                                            "كوشوكة عمود شيال امامي يسار"
                                                                        bindingR2.s3erR2sAcx.setText(
                                                                            "10"
                                                                        )
                                                                    }

                                                                    if (bindingR2.insideleft.isChecked) {
                                                                        ch8.text =
                                                                            "كوشوكة عمود شيال خلفي يسار"
                                                                        bindingR2.s3erR2sAcx.setText(
                                                                            "5"
                                                                        )
                                                                    }
                                                                    if (bindingR2.insideright.isChecked) {
                                                                        ch8.text =
                                                                            "كوشوكة عمود شيال خلفي يمين"
                                                                        bindingR2.s3erR2sAcx.setText(
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

                    bindingR2.insideright.setOnCheckedChangeListener { _, isChecked2 ->
                        if (bindingR2.outsideright.isChecked) {
                            ch8.text = "كوشوكة عمود شيال خلفي يمين"
                        } else {
                            ch8.text = "كوشوكة عمود شيال "
                            bindingR2.s3erR2sAcx.setText("")
                        }

                        if (bindingR2.outsideright.isChecked && bindingR2.outsideleft.isChecked && bindingR2.insideright.isChecked && bindingR2.insideleft.isChecked) {
                            ch8.text = "تغير جميع كوشوكات عمود الشيال"
                            bindingR2.s3erR2sAcx.setText("30")
                        } else {
                            if (bindingR2.outsideright.isChecked && bindingR2.outsideleft.isChecked && bindingR2.insideright.isChecked) {
                                ch8.text = "كوشوكتين عمود شيال امامي و الخلفي يمين"
                                bindingR2.s3erR2sAcx.setText("25")
                            } else {
                                if (bindingR2.outsideright.isChecked && bindingR2.outsideleft.isChecked && bindingR2.insideleft.isChecked) {
                                    ch8.text = "كوشوكتين عمود شيال امامي  و الخلفي يسار"
                                    bindingR2.s3erR2sAcx.setText("25")
                                } else {
                                    if (bindingR2.outsideright.isChecked && bindingR2.insideright.isChecked && bindingR2.insideleft.isChecked) {
                                        ch8.text = "كوشوكة عمود شيال امامي يمين و الخلفيتين"
                                        bindingR2.s3erR2sAcx.setText("20")
                                    } else {
                                        if (bindingR2.outsideleft.isChecked && bindingR2.insideright.isChecked && bindingR2.insideleft.isChecked) {
                                            ch8.text = "كوشوكة عمود شيال امامي يسار و الخلفيتين"
                                            bindingR2.s3erR2sAcx.setText("20")
                                        } else {
                                            if (bindingR2.outsideright.isChecked && bindingR2.outsideleft.isChecked) {
                                                ch8.text = "كوشوكة عمود شيال امامي يمين و يسار"
                                                bindingR2.s3erR2sAcx.setText("20")
                                            } else {
                                                if (bindingR2.outsideright.isChecked && bindingR2.insideright.isChecked) {
                                                    ch8.text = "كوشوكة عمود شيال امامي يمين و خلفي يمين"
                                                    bindingR2.s3erR2sAcx.setText("15")
                                                } else {
                                                    if (bindingR2.outsideright.isChecked && bindingR2.insideleft.isChecked) {
                                                        ch8.text = "كوشوكة عمود شيال امامي يمين و خلفي يسار"
                                                        bindingR2.s3erR2sAcx.setText("15")
                                                    } else {
                                                        if (bindingR2.outsideleft.isChecked && bindingR2.insideright.isChecked) {
                                                            ch8.text =
                                                                "كوشوكة عمود شيال امامي يسار و خلفي يمين"
                                                            bindingR2.s3erR2sAcx.setText("15")
                                                        } else {
                                                            if (bindingR2.outsideleft.isChecked && bindingR2.insideleft.isChecked) {
                                                                ch8.text =
                                                                    "كوشوكة عمود شيال امامي يسار و خلفي يسار"
                                                                bindingR2.s3erR2sAcx.setText("15")
                                                            } else {
                                                                if (bindingR2.insideright.isChecked && bindingR2.insideleft.isChecked) {
                                                                    ch8.text =
                                                                        "كوشوكة عمود شيال خلفي يمين و يسار"
                                                                    bindingR2.s3erR2sAcx.setText(
                                                                        "10"
                                                                    )
                                                                } else {

                                                                    if (bindingR2.outsideright.isChecked) {
                                                                        ch8.text =
                                                                            "كوشوكة عمود شيال امامي يمين"
                                                                        bindingR2.s3erR2sAcx.setText(
                                                                            "10"
                                                                        )
                                                                    }
                                                                    if (bindingR2.outsideleft.isChecked) {
                                                                        ch8.text =
                                                                            "كوشوكة عمود شيال امامي يسار"
                                                                        bindingR2.s3erR2sAcx.setText(
                                                                            "10"
                                                                        )
                                                                    }

                                                                    if (bindingR2.insideleft.isChecked) {
                                                                        ch8.text =
                                                                            "كوشوكة عمود شيال خلفي يسار"
                                                                        bindingR2.s3erR2sAcx.setText(
                                                                            "5"
                                                                        )
                                                                    }
                                                                    if (bindingR2.insideright.isChecked) {
                                                                        ch8.text =
                                                                            "كوشوكة عمود شيال خلفي يمين"
                                                                        bindingR2.s3erR2sAcx.setText(
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


                    bindingR2.btnR2sSav.setOnClickListener {
                        if (!bindingR2.outsideright.isChecked && !bindingR2.outsideleft.isChecked
                            && !bindingR2.insideright.isChecked && !bindingR2.insideleft.isChecked
                        ) {
                            toast_notempty1.show()
                        } else {
                            if (bindingR2.s3erR2sAcx.text.toString().trim().isEmpty()) {
                                toast_notempty.show()
                            } else {
                                pric8.text = bindingR2.s3erR2sAcx.text.toString()
                                hy2ahModel.totalAmount += pric8.text.toString().toInt()
                                toolbar?.title =  hy2ahModel.totalAmount.toString()
                                hy2ahModel.ch8 = ch8.text.toString().trim()
                                hy2ahModel.pric8 = pric8.text.toString().trim()
                                customDialogR2SX.dismiss()
                            }
                        }
                    }
                    bindingR2.btnR2sCan.setOnClickListener {
                        if (pric8.text.toString().isEmpty()) {
                            ch8.text = "كوشوكة عمود شيال"
                            ch8.isChecked = false
                        }
                        customDialogR2SX.dismiss()
                    }
                    bindingR2.outsideright.isChecked = false
                    bindingR2.outsideleft.isChecked = false
                    bindingR2.insideright.isChecked = false
                    bindingR2.insideleft.isChecked = false
                    customDialogR2SX.show()

                } else {
                    if (pric8.text.toString().isNotEmpty()) {
                        hy2ahModel.totalAmount -= pric8.text.toString().toInt()
                        toolbar?.title =  hy2ahModel.totalAmount.toString()
                        ch8.text = "كوشوكة عمود شيال"
                        pric8.setText("")
                        hy2ahModel.ch8 =  ""
                        hy2ahModel.pric8 =  ""
                    } else {
                        ch8.text = "كوشوكة عمود شيال"
                    }
                }
            }
        }


        binding.apply{
            ch9.setOnCheckedChangeListener { _, isChecked ->
                if (ch9.isChecked) {

                    bindingR2.titR2sOut.text = "خارجية"
                    bindingR2.titR2sIn.text = "داخلية"
                    customDialogR2SX.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

                    bindingR2.cardR2s2ks.setOnTouchListener { _, event ->
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

                    bindingR2.outsideright.setOnCheckedChangeListener { _, isChecked1 ->

                        if (bindingR2.outsideright.isChecked) {
                            ch9.text = "جوزة خارجية يمين"
                        } else {
                            ch9.text = "جوزة"
                            bindingR2.s3erR2sAcx.setText("")
                        }

                        if (bindingR2.outsideright.isChecked && bindingR2.outsideleft.isChecked && bindingR2.insideright.isChecked && bindingR2.insideleft.isChecked) {
                            ch9.text = "تغير جميع الجوزات"
                            bindingR2.s3erR2sAcx.setText("16")
                        } else {
                            if (bindingR2.outsideright.isChecked && bindingR2.outsideleft.isChecked && bindingR2.insideright.isChecked) {
                                ch9.text = "جوزتين خارجيات و الداخلية يمين"
                                bindingR2.s3erR2sAcx.setText("11")
                            } else {
                                if (bindingR2.outsideright.isChecked && bindingR2.outsideleft.isChecked && bindingR2.insideleft.isChecked) {
                                    ch9.text = "جوزتين خارجيات و الداخلية يسار"
                                    bindingR2.s3erR2sAcx.setText("11")
                                } else {
                                    if (bindingR2.outsideright.isChecked && bindingR2.insideright.isChecked && bindingR2.insideleft.isChecked) {
                                        ch9.text = "جوزة خارجية يمين و الداخليتين"
                                        bindingR2.s3erR2sAcx.setText("13")
                                    } else {
                                        if (bindingR2.outsideleft.isChecked && bindingR2.insideright.isChecked && bindingR2.insideleft.isChecked) {
                                            ch9.text = "جوزة خارجية يسار و الداخليتين"
                                            bindingR2.s3erR2sAcx.setText("13")
                                        } else {
                                            if (bindingR2.outsideright.isChecked && bindingR2.outsideleft.isChecked) {
                                                ch9.text = "جوزة خارجية يمين و يسار"
                                                bindingR2.s3erR2sAcx.setText("6")
                                            } else {
                                                if (bindingR2.outsideright.isChecked && bindingR2.insideright.isChecked) {
                                                    ch9.text = "جوزة خارجية يمين و داخلية يمين"
                                                    bindingR2.s3erR2sAcx.setText("8")
                                                } else {
                                                    if (bindingR2.outsideright.isChecked && bindingR2.insideleft.isChecked) {
                                                        ch9.text = "جوزة خارجية يمين و داخلية يسار"
                                                        bindingR2.s3erR2sAcx.setText("8")
                                                    } else {
                                                        if (bindingR2.outsideleft.isChecked && bindingR2.insideright.isChecked) {
                                                            ch9.text =
                                                                "جوزة خارجية يسار و داخلية يمين"
                                                            bindingR2.s3erR2sAcx.setText("8")
                                                        } else {
                                                            if (bindingR2.outsideleft.isChecked && bindingR2.insideleft.isChecked) {
                                                                ch9.text =
                                                                    "جوزة خارجية يسار و داخلية يسار"
                                                                bindingR2.s3erR2sAcx.setText("8")
                                                            } else {
                                                                if (bindingR2.insideright.isChecked && bindingR2.insideleft.isChecked) {
                                                                    ch9.text =
                                                                        "جوزة داخلية يمين و يسار"
                                                                    bindingR2.s3erR2sAcx.setText(
                                                                        "10"
                                                                    )
                                                                } else {

                                                                    if (bindingR2.outsideright.isChecked) {
                                                                        ch9.text =
                                                                            "جوزة خارجية يمين"
                                                                        bindingR2.s3erR2sAcx.setText(
                                                                            "3"
                                                                        )
                                                                    }
                                                                    if (bindingR2.outsideleft.isChecked) {
                                                                        ch9.text =
                                                                            "جوزة خارجية يسار"
                                                                        bindingR2.s3erR2sAcx.setText(
                                                                            "3"
                                                                        )
                                                                    }

                                                                    if (bindingR2.insideleft.isChecked) {
                                                                        ch9.text =
                                                                            "جوزة داخلية يسار"
                                                                        bindingR2.s3erR2sAcx.setText(
                                                                            "5"
                                                                        )
                                                                    }
                                                                    if (bindingR2.insideright.isChecked) {
                                                                        ch9.text =
                                                                            "جوزة داخلية يمين"
                                                                        bindingR2.s3erR2sAcx.setText(
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



                    bindingR2.outsideleft.setOnCheckedChangeListener { _, isChecked2 ->
                        if (bindingR2.outsideleft.isChecked) {
                            ch9.text = "جوزة خارجية يمين"
                        } else {
                            ch9.text = "جوزة"
                            bindingR2.s3erR2sAcx.setText("")
                        }

                        if (bindingR2.outsideright.isChecked && bindingR2.outsideleft.isChecked && bindingR2.insideright.isChecked && bindingR2.insideleft.isChecked) {
                            ch9.text = "تغير جميع الجوزات"
                            bindingR2.s3erR2sAcx.setText("16")
                        } else {
                            if (bindingR2.outsideright.isChecked && bindingR2.outsideleft.isChecked && bindingR2.insideright.isChecked) {
                                ch9.text = "جوزتين خارجيات و الداخلية يمين"
                                bindingR2.s3erR2sAcx.setText("11")
                            } else {
                                if (bindingR2.outsideright.isChecked && bindingR2.outsideleft.isChecked && bindingR2.insideleft.isChecked) {
                                    ch9.text = "جوزتين خارجيات و الداخلية يسار"
                                    bindingR2.s3erR2sAcx.setText("11")
                                } else {
                                    if (bindingR2.outsideright.isChecked && bindingR2.insideright.isChecked && bindingR2.insideleft.isChecked) {
                                        ch9.text = "جوزة خارجية يمين و الداخليتين"
                                        bindingR2.s3erR2sAcx.setText("13")
                                    } else {
                                        if (bindingR2.outsideleft.isChecked && bindingR2.insideright.isChecked && bindingR2.insideleft.isChecked) {
                                            ch9.text = "جوزة خارجية يسار و الداخليتين"
                                            bindingR2.s3erR2sAcx.setText("13")
                                        } else {
                                            if (bindingR2.outsideright.isChecked && bindingR2.outsideleft.isChecked) {
                                                ch9.text = "جوزة خارجية يمين و يسار"
                                                bindingR2.s3erR2sAcx.setText("6")
                                            } else {
                                                if (bindingR2.outsideright.isChecked && bindingR2.insideright.isChecked) {
                                                    ch9.text = "جوزة خارجية يمين و داخلية يمين"
                                                    bindingR2.s3erR2sAcx.setText("8")
                                                } else {
                                                    if (bindingR2.outsideright.isChecked && bindingR2.insideleft.isChecked) {
                                                        ch9.text = "جوزة خارجية يمين و داخلية يسار"
                                                        bindingR2.s3erR2sAcx.setText("8")
                                                    } else {
                                                        if (bindingR2.outsideleft.isChecked && bindingR2.insideright.isChecked) {
                                                            ch9.text =
                                                                "جوزة خارجية يسار و داخلية يمين"
                                                            bindingR2.s3erR2sAcx.setText("8")
                                                        } else {
                                                            if (bindingR2.outsideleft.isChecked && bindingR2.insideleft.isChecked) {
                                                                ch9.text =
                                                                    "جوزة خارجية يسار و داخلية يسار"
                                                                bindingR2.s3erR2sAcx.setText("8")
                                                            } else {
                                                                if (bindingR2.insideright.isChecked && bindingR2.insideleft.isChecked) {
                                                                    ch9.text =
                                                                        "جوزة داخلية يمين و يسار"
                                                                    bindingR2.s3erR2sAcx.setText(
                                                                        "10"
                                                                    )
                                                                } else {

                                                                    if (bindingR2.outsideright.isChecked) {
                                                                        ch9.text =
                                                                            "جوزة خارجية يمين"
                                                                        bindingR2.s3erR2sAcx.setText(
                                                                            "3"
                                                                        )
                                                                    }
                                                                    if (bindingR2.outsideleft.isChecked) {
                                                                        ch9.text =
                                                                            "جوزة خارجية يسار"
                                                                        bindingR2.s3erR2sAcx.setText(
                                                                            "3"
                                                                        )
                                                                    }

                                                                    if (bindingR2.insideleft.isChecked) {
                                                                        ch9.text =
                                                                            "جوزة داخلية يسار"
                                                                        bindingR2.s3erR2sAcx.setText(
                                                                            "5"
                                                                        )
                                                                    }
                                                                    if (bindingR2.insideright.isChecked) {
                                                                        ch9.text =
                                                                            "جوزة داخلية يمين"
                                                                        bindingR2.s3erR2sAcx.setText(
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



                    bindingR2.insideleft.setOnCheckedChangeListener { _, isChecked2 ->
                        if (bindingR2.outsideright.isChecked) {
                            ch9.text = "جوزة خارجية يمين"
                        } else {
                            ch9.text = "جوزة"
                            bindingR2.s3erR2sAcx.setText("")
                        }

                        if (bindingR2.outsideright.isChecked && bindingR2.outsideleft.isChecked && bindingR2.insideright.isChecked && bindingR2.insideleft.isChecked) {
                            ch9.text = "تغير جميع الجوزات"
                            bindingR2.s3erR2sAcx.setText("16")
                        } else {
                            if (bindingR2.outsideright.isChecked && bindingR2.outsideleft.isChecked && bindingR2.insideright.isChecked) {
                                ch9.text = "جوزتين خارجيات و الداخلية يمين"
                                bindingR2.s3erR2sAcx.setText("11")
                            } else {
                                if (bindingR2.outsideright.isChecked && bindingR2.outsideleft.isChecked && bindingR2.insideleft.isChecked) {
                                    ch9.text = "جوزتين خارجيات و الداخلية يسار"
                                    bindingR2.s3erR2sAcx.setText("11")
                                } else {
                                    if (bindingR2.outsideright.isChecked && bindingR2.insideright.isChecked && bindingR2.insideleft.isChecked) {
                                        ch9.text = "جوزة خارجية يمين و الداخليتين"
                                        bindingR2.s3erR2sAcx.setText("13")
                                    } else {
                                        if (bindingR2.outsideleft.isChecked && bindingR2.insideright.isChecked && bindingR2.insideleft.isChecked) {
                                            ch9.text = "جوزة خارجية يسار و الداخليتين"
                                            bindingR2.s3erR2sAcx.setText("13")
                                        } else {
                                            if (bindingR2.outsideright.isChecked && bindingR2.outsideleft.isChecked) {
                                                ch9.text = "جوزة خارجية يمين و يسار"
                                                bindingR2.s3erR2sAcx.setText("6")
                                            } else {
                                                if (bindingR2.outsideright.isChecked && bindingR2.insideright.isChecked) {
                                                    ch9.text = "جوزة خارجية يمين و داخلية يمين"
                                                    bindingR2.s3erR2sAcx.setText("8")
                                                } else {
                                                    if (bindingR2.outsideright.isChecked && bindingR2.insideleft.isChecked) {
                                                        ch9.text = "جوزة خارجية يمين و داخلية يسار"
                                                        bindingR2.s3erR2sAcx.setText("8")
                                                    } else {
                                                        if (bindingR2.outsideleft.isChecked && bindingR2.insideright.isChecked) {
                                                            ch9.text =
                                                                "جوزة خارجية يسار و داخلية يمين"
                                                            bindingR2.s3erR2sAcx.setText("8")
                                                        } else {
                                                            if (bindingR2.outsideleft.isChecked && bindingR2.insideleft.isChecked) {
                                                                ch9.text =
                                                                    "جوزة خارجية يسار و داخلية يسار"
                                                                bindingR2.s3erR2sAcx.setText("8")
                                                            } else {
                                                                if (bindingR2.insideright.isChecked && bindingR2.insideleft.isChecked) {
                                                                    ch9.text =
                                                                        "جوزة داخلية يمين و يسار"
                                                                    bindingR2.s3erR2sAcx.setText(
                                                                        "10"
                                                                    )
                                                                } else {

                                                                    if (bindingR2.outsideright.isChecked) {
                                                                        ch9.text =
                                                                            "جوزة خارجية يمين"
                                                                        bindingR2.s3erR2sAcx.setText(
                                                                            "3"
                                                                        )
                                                                    }
                                                                    if (bindingR2.outsideleft.isChecked) {
                                                                        ch9.text =
                                                                            "جوزة خارجية يسار"
                                                                        bindingR2.s3erR2sAcx.setText(
                                                                            "3"
                                                                        )
                                                                    }

                                                                    if (bindingR2.insideleft.isChecked) {
                                                                        ch9.text =
                                                                            "جوزة داخلية يسار"
                                                                        bindingR2.s3erR2sAcx.setText(
                                                                            "5"
                                                                        )
                                                                    }
                                                                    if (bindingR2.insideright.isChecked) {
                                                                        ch9.text =
                                                                            "جوزة داخلية يمين"
                                                                        bindingR2.s3erR2sAcx.setText(
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

                    bindingR2.insideright.setOnCheckedChangeListener { _, isChecked2 ->
                        if (bindingR2.outsideright.isChecked) {
                            ch9.text = "جوزة خارجية يمين"
                        } else {
                            ch9.text = "جوزة"
                            bindingR2.s3erR2sAcx.setText("")
                        }

                        if (bindingR2.outsideright.isChecked && bindingR2.outsideleft.isChecked && bindingR2.insideright.isChecked && bindingR2.insideleft.isChecked) {
                            ch9.text = "تغير جميع الجوزات"
                            bindingR2.s3erR2sAcx.setText("16")
                        } else {
                            if (bindingR2.outsideright.isChecked && bindingR2.outsideleft.isChecked && bindingR2.insideright.isChecked) {
                                ch9.text = "جوزتين خارجيات و الداخلية يمين"
                                bindingR2.s3erR2sAcx.setText("11")
                            } else {
                                if (bindingR2.outsideright.isChecked && bindingR2.outsideleft.isChecked && bindingR2.insideleft.isChecked) {
                                    ch9.text = "جوزتين خارجيات و الداخلية يسار"
                                    bindingR2.s3erR2sAcx.setText("11")
                                } else {
                                    if (bindingR2.outsideright.isChecked && bindingR2.insideright.isChecked && bindingR2.insideleft.isChecked) {
                                        ch9.text = "جوزة خارجية يمين و الداخليتين"
                                        bindingR2.s3erR2sAcx.setText("13")
                                    } else {
                                        if (bindingR2.outsideleft.isChecked && bindingR2.insideright.isChecked && bindingR2.insideleft.isChecked) {
                                            ch9.text = "جوزة خارجية يسار و الداخليتين"
                                            bindingR2.s3erR2sAcx.setText("13")
                                        } else {
                                            if (bindingR2.outsideright.isChecked && bindingR2.outsideleft.isChecked) {
                                                ch9.text = "جوزة خارجية يمين و يسار"
                                                bindingR2.s3erR2sAcx.setText("6")
                                            } else {
                                                if (bindingR2.outsideright.isChecked && bindingR2.insideright.isChecked) {
                                                    ch9.text = "جوزة خارجية يمين و داخلية يمين"
                                                    bindingR2.s3erR2sAcx.setText("8")
                                                } else {
                                                    if (bindingR2.outsideright.isChecked && bindingR2.insideleft.isChecked) {
                                                        ch9.text = "جوزة خارجية يمين و داخلية يسار"
                                                        bindingR2.s3erR2sAcx.setText("8")
                                                    } else {
                                                        if (bindingR2.outsideleft.isChecked && bindingR2.insideright.isChecked) {
                                                            ch9.text =
                                                                "جوزة خارجية يسار و داخلية يمين"
                                                            bindingR2.s3erR2sAcx.setText("8")
                                                        } else {
                                                            if (bindingR2.outsideleft.isChecked && bindingR2.insideleft.isChecked) {
                                                                ch9.text =
                                                                    "جوزة خارجية يسار و داخلية يسار"
                                                                bindingR2.s3erR2sAcx.setText("8")
                                                            } else {
                                                                if (bindingR2.insideright.isChecked && bindingR2.insideleft.isChecked) {
                                                                    ch9.text =
                                                                        "جوزة داخلية يمين و يسار"
                                                                    bindingR2.s3erR2sAcx.setText(
                                                                        "10"
                                                                    )
                                                                } else {

                                                                    if (bindingR2.outsideright.isChecked) {
                                                                        ch9.text =
                                                                            "جوزة خارجية يمين"
                                                                        bindingR2.s3erR2sAcx.setText(
                                                                            "3"
                                                                        )
                                                                    }
                                                                    if (bindingR2.outsideleft.isChecked) {
                                                                        ch9.text =
                                                                            "جوزة خارجية يسار"
                                                                        bindingR2.s3erR2sAcx.setText(
                                                                            "3"
                                                                        )
                                                                    }

                                                                    if (bindingR2.insideleft.isChecked) {
                                                                        ch9.text =
                                                                            "جوزة داخلية يسار"
                                                                        bindingR2.s3erR2sAcx.setText(
                                                                            "5"
                                                                        )
                                                                    }
                                                                    if (bindingR2.insideright.isChecked) {
                                                                        ch9.text =
                                                                            "جوزة داخلية يمين"
                                                                        bindingR2.s3erR2sAcx.setText(
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


                    bindingR2.btnR2sSav.setOnClickListener {
                        if (!bindingR2.outsideright.isChecked && !bindingR2.outsideleft.isChecked
                            && !bindingR2.insideright.isChecked && !bindingR2.insideleft.isChecked
                        ) {
                            toast_notempty1.show()
                        } else {
                            if (bindingR2.s3erR2sAcx.text.toString().trim().isEmpty()) {
                                toast_notempty.show()
                            } else {
                                pric9.text = bindingR2.s3erR2sAcx.text.toString()
                                hy2ahModel.totalAmount += pric9.text.toString().toInt()
                                toolbar?.title =  hy2ahModel.totalAmount.toString()
                                hy2ahModel.ch9 = ch9.text.toString().trim()
                                hy2ahModel.pric9 = pric9.text.toString().trim()
                                customDialogR2SX.dismiss()
                            }
                        }
                    }
                    bindingR2.btnR2sCan.setOnClickListener {
                        if (pric9.text.toString().isEmpty()) {
                            ch9.text = "جوزة"
                            ch9.isChecked = false
                        }
                        customDialogR2SX.dismiss()
                    }
                    bindingR2.outsideright.isChecked = false
                    bindingR2.outsideleft.isChecked = false
                    bindingR2.insideright.isChecked = false
                    bindingR2.insideleft.isChecked = false
                    customDialogR2SX.show()

                } else {
                    if (pric9.text.toString().isNotEmpty()) {
                        hy2ahModel.totalAmount -= pric9.text.toString().toInt()
                        toolbar?.title =  hy2ahModel.totalAmount.toString()
                        ch9.text = "جوزة"
                        pric9.setText("")
                        hy2ahModel.ch9 =  ""
                        hy2ahModel.pric9 =  ""
                    } else {
                        ch9.text = "جوزة"
                    }
                }
            }
        }

        binding.apply{
            ch10.setOnCheckedChangeListener { _, isChecked ->
                if (ch10.isChecked) {

                    customDialogR2SX.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
                    bindingR2.titR2sOut.text="علوية"
                    bindingR2.titR2sIn.text="سفلية"

                    bindingR2.cardR2s2ks.setOnTouchListener { _, event ->
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

                    bindingR2.outsideright.setOnCheckedChangeListener { _, isChecked1 ->

                        if (bindingR2.outsideright.isChecked) {
                            ch10.text = "بيضة علوية يمين"
                        } else {
                            ch10.text = "بيضة"
                            bindingR2.s3erR2sAcx.setText("")
                        }

                        if (bindingR2.outsideright.isChecked && bindingR2.outsideleft.isChecked && bindingR2.insideright.isChecked && bindingR2.insideleft.isChecked) {
                            ch10.text = "تغير جميع البيضات"
                            bindingR2.s3erR2sAcx.setText("20")
                        } else {
                            if (bindingR2.outsideright.isChecked && bindingR2.outsideleft.isChecked && bindingR2.insideright.isChecked) {
                                ch10.text = "بيضتين علوية و السفلية يمين"
                                bindingR2.s3erR2sAcx.setText("15")
                            } else {
                                if (bindingR2.outsideright.isChecked && bindingR2.outsideleft.isChecked && bindingR2.insideleft.isChecked) {
                                    ch10.text = "بيضتين علوية و السفلية يسار"
                                    bindingR2.s3erR2sAcx.setText("15")
                                } else {
                                    if (bindingR2.outsideright.isChecked && bindingR2.insideright.isChecked && bindingR2.insideleft.isChecked) {
                                        ch10.text = "بيضة علوية يمين و السفليتين"
                                        bindingR2.s3erR2sAcx.setText("15")
                                    } else {
                                        if (bindingR2.outsideleft.isChecked && bindingR2.insideright.isChecked && bindingR2.insideleft.isChecked) {
                                            ch10.text = "بيضة علوية يسار و السفليتين"
                                            bindingR2.s3erR2sAcx.setText("15")
                                        } else {
                                            if (bindingR2.outsideright.isChecked && bindingR2.outsideleft.isChecked) {
                                                ch10.text = "بيضة علوية يمين و يسار"
                                                bindingR2.s3erR2sAcx.setText("10")
                                            } else {
                                                if (bindingR2.outsideright.isChecked && bindingR2.insideright.isChecked) {
                                                    ch10.text = "بيضة علوية يمين و السفلية يمين"
                                                    bindingR2.s3erR2sAcx.setText("10")
                                                } else {
                                                    if (bindingR2.outsideright.isChecked && bindingR2.insideleft.isChecked) {
                                                        ch10.text = "بيضة علوية يمين و السفلية يسار"
                                                        bindingR2.s3erR2sAcx.setText("10")
                                                    } else {
                                                        if (bindingR2.outsideleft.isChecked && bindingR2.insideright.isChecked) {
                                                            ch10.text =
                                                                "بيضة علوية يسار و السفلية يمين"
                                                            bindingR2.s3erR2sAcx.setText("10")
                                                        } else {
                                                            if (bindingR2.outsideleft.isChecked && bindingR2.insideleft.isChecked) {
                                                                ch10.text =
                                                                    "بيضة علوية يسار و السفلية يسار"
                                                                bindingR2.s3erR2sAcx.setText("10")
                                                            } else {
                                                                if (bindingR2.insideright.isChecked && bindingR2.insideleft.isChecked) {
                                                                    ch10.text =
                                                                        "بيضة سفلية يمين و يسار"
                                                                    bindingR2.s3erR2sAcx.setText(
                                                                        "10"
                                                                    )
                                                                } else {

                                                                    if (bindingR2.outsideright.isChecked) {
                                                                        ch10.text =
                                                                            "بيضة علوية يمين"
                                                                        bindingR2.s3erR2sAcx.setText(
                                                                            "5"
                                                                        )
                                                                    }
                                                                    if (bindingR2.outsideleft.isChecked) {
                                                                        ch10.text =
                                                                            "بيضة علوية يسار"
                                                                        bindingR2.s3erR2sAcx.setText(
                                                                            "5"
                                                                        )
                                                                    }

                                                                    if (bindingR2.insideleft.isChecked) {
                                                                        ch10.text =
                                                                            "بيضة سفلية يسار"
                                                                        bindingR2.s3erR2sAcx.setText(
                                                                            "5"
                                                                        )
                                                                    }
                                                                    if (bindingR2.insideright.isChecked) {
                                                                        ch10.text =
                                                                            "بيضة سفلية يمين"
                                                                        bindingR2.s3erR2sAcx.setText(
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



                    bindingR2.outsideleft.setOnCheckedChangeListener { _, isChecked2 ->
                        if (bindingR2.outsideleft.isChecked) {
                            ch10.text = "بيضة علوية يسار"
                        } else {
                            ch10.text = "بيضة"
                            bindingR2.s3erR2sAcx.setText("")
                        }

                        if (bindingR2.outsideright.isChecked && bindingR2.outsideleft.isChecked && bindingR2.insideright.isChecked && bindingR2.insideleft.isChecked) {
                            ch10.text = "تغير جميع البيضات"
                            bindingR2.s3erR2sAcx.setText("20")
                        } else {
                            if (bindingR2.outsideright.isChecked && bindingR2.outsideleft.isChecked && bindingR2.insideright.isChecked) {
                                ch10.text = "بيضتين علوية و السفلية يمين"
                                bindingR2.s3erR2sAcx.setText("15")
                            } else {
                                if (bindingR2.outsideright.isChecked && bindingR2.outsideleft.isChecked && bindingR2.insideleft.isChecked) {
                                    ch10.text = "بيضتين علوية و السفلية يسار"
                                    bindingR2.s3erR2sAcx.setText("15")
                                } else {
                                    if (bindingR2.outsideright.isChecked && bindingR2.insideright.isChecked && bindingR2.insideleft.isChecked) {
                                        ch10.text = "بيضة علوية يمين و السفليتين"
                                        bindingR2.s3erR2sAcx.setText("15")
                                    } else {
                                        if (bindingR2.outsideleft.isChecked && bindingR2.insideright.isChecked && bindingR2.insideleft.isChecked) {
                                            ch10.text = "بيضة علوية يسار و السفليتين"
                                            bindingR2.s3erR2sAcx.setText("15")
                                        } else {
                                            if (bindingR2.outsideright.isChecked && bindingR2.outsideleft.isChecked) {
                                                ch10.text = "بيضة علوية يمين و يسار"
                                                bindingR2.s3erR2sAcx.setText("10")
                                            } else {
                                                if (bindingR2.outsideright.isChecked && bindingR2.insideright.isChecked) {
                                                    ch10.text = "بيضة علوية يمين و السفلية يمين"
                                                    bindingR2.s3erR2sAcx.setText("10")
                                                } else {
                                                    if (bindingR2.outsideright.isChecked && bindingR2.insideleft.isChecked) {
                                                        ch10.text = "بيضة علوية يمين و السفلية يسار"
                                                        bindingR2.s3erR2sAcx.setText("10")
                                                    } else {
                                                        if (bindingR2.outsideleft.isChecked && bindingR2.insideright.isChecked) {
                                                            ch10.text =
                                                                "بيضة علوية يسار و السفلية يمين"
                                                            bindingR2.s3erR2sAcx.setText("10")
                                                        } else {
                                                            if (bindingR2.outsideleft.isChecked && bindingR2.insideleft.isChecked) {
                                                                ch10.text =
                                                                    "بيضة علوية يسار و السفلية يسار"
                                                                bindingR2.s3erR2sAcx.setText("10")
                                                            } else {
                                                                if (bindingR2.insideright.isChecked && bindingR2.insideleft.isChecked) {
                                                                    ch10.text =
                                                                        "بيضة سفلية يمين و يسار"
                                                                    bindingR2.s3erR2sAcx.setText(
                                                                        "10"
                                                                    )
                                                                } else {

                                                                    if (bindingR2.outsideright.isChecked) {
                                                                        ch10.text =
                                                                            "بيضة علوية يمين"
                                                                        bindingR2.s3erR2sAcx.setText(
                                                                            "5"
                                                                        )
                                                                    }
                                                                    if (bindingR2.outsideleft.isChecked) {
                                                                        ch10.text =
                                                                            "بيضة علوية يسار"
                                                                        bindingR2.s3erR2sAcx.setText(
                                                                            "5"
                                                                        )
                                                                    }

                                                                    if (bindingR2.insideleft.isChecked) {
                                                                        ch10.text =
                                                                            "بيضة سفلية يسار"
                                                                        bindingR2.s3erR2sAcx.setText(
                                                                            "5"
                                                                        )
                                                                    }
                                                                    if (bindingR2.insideright.isChecked) {
                                                                        ch10.text =
                                                                            "بيضة سفلية يمين"
                                                                        bindingR2.s3erR2sAcx.setText(
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



                    bindingR2.insideleft.setOnCheckedChangeListener { _, isChecked2 ->
                        if (bindingR2.outsideright.isChecked) {
                            ch10.text = "بيضة سفلية يمين"
                        } else {
                            ch10.text = "بيضة"
                            bindingR2.s3erR2sAcx.setText("")
                        }

                        if (bindingR2.outsideright.isChecked && bindingR2.outsideleft.isChecked && bindingR2.insideright.isChecked && bindingR2.insideleft.isChecked) {
                            ch10.text = "تغير جميع البيضات"
                            bindingR2.s3erR2sAcx.setText("20")
                        } else {
                            if (bindingR2.outsideright.isChecked && bindingR2.outsideleft.isChecked && bindingR2.insideright.isChecked) {
                                ch10.text = "بيضتين علوية و السفلية يمين"
                                bindingR2.s3erR2sAcx.setText("15")
                            } else {
                                if (bindingR2.outsideright.isChecked && bindingR2.outsideleft.isChecked && bindingR2.insideleft.isChecked) {
                                    ch10.text = "بيضتين علوية و السفلية يسار"
                                    bindingR2.s3erR2sAcx.setText("15")
                                } else {
                                    if (bindingR2.outsideright.isChecked && bindingR2.insideright.isChecked && bindingR2.insideleft.isChecked) {
                                        ch10.text = "بيضة علوية يمين و السفليتين"
                                        bindingR2.s3erR2sAcx.setText("15")
                                    } else {
                                        if (bindingR2.outsideleft.isChecked && bindingR2.insideright.isChecked && bindingR2.insideleft.isChecked) {
                                            ch10.text = "بيضة علوية يسار و السفليتين"
                                            bindingR2.s3erR2sAcx.setText("15")
                                        } else {
                                            if (bindingR2.outsideright.isChecked && bindingR2.outsideleft.isChecked) {
                                                ch10.text = "بيضة علوية يمين و يسار"
                                                bindingR2.s3erR2sAcx.setText("10")
                                            } else {
                                                if (bindingR2.outsideright.isChecked && bindingR2.insideright.isChecked) {
                                                    ch10.text = "بيضة علوية يمين و السفلية يمين"
                                                    bindingR2.s3erR2sAcx.setText("10")
                                                } else {
                                                    if (bindingR2.outsideright.isChecked && bindingR2.insideleft.isChecked) {
                                                        ch10.text = "بيضة علوية يمين و السفلية يسار"
                                                        bindingR2.s3erR2sAcx.setText("10")
                                                    } else {
                                                        if (bindingR2.outsideleft.isChecked && bindingR2.insideright.isChecked) {
                                                            ch10.text =
                                                                "بيضة علوية يسار و السفلية يمين"
                                                            bindingR2.s3erR2sAcx.setText("10")
                                                        } else {
                                                            if (bindingR2.outsideleft.isChecked && bindingR2.insideleft.isChecked) {
                                                                ch10.text =
                                                                    "بيضة علوية يسار و السفلية يسار"
                                                                bindingR2.s3erR2sAcx.setText("10")
                                                            } else {
                                                                if (bindingR2.insideright.isChecked && bindingR2.insideleft.isChecked) {
                                                                    ch10.text =
                                                                        "بيضة سفلية يمين و يسار"
                                                                    bindingR2.s3erR2sAcx.setText(
                                                                        "10"
                                                                    )
                                                                } else {

                                                                    if (bindingR2.outsideright.isChecked) {
                                                                        ch10.text =
                                                                            "بيضة علوية يمين"
                                                                        bindingR2.s3erR2sAcx.setText(
                                                                            "5"
                                                                        )
                                                                    }
                                                                    if (bindingR2.outsideleft.isChecked) {
                                                                        ch10.text =
                                                                            "بيضة علوية يسار"
                                                                        bindingR2.s3erR2sAcx.setText(
                                                                            "5"
                                                                        )
                                                                    }

                                                                    if (bindingR2.insideleft.isChecked) {
                                                                        ch10.text =
                                                                            "بيضة سفلية يسار"
                                                                        bindingR2.s3erR2sAcx.setText(
                                                                            "5"
                                                                        )
                                                                    }
                                                                    if (bindingR2.insideright.isChecked) {
                                                                        ch10.text =
                                                                            "بيضة سفلية يمين"
                                                                        bindingR2.s3erR2sAcx.setText(
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

                    bindingR2.insideright.setOnCheckedChangeListener { _, isChecked2 ->
                        if (bindingR2.outsideright.isChecked) {
                            ch10.text = "بيضة سفلية يمين"
                        } else {
                            ch10.text = "بيضة"
                            bindingR2.s3erR2sAcx.setText("")
                        }

                        if (bindingR2.outsideright.isChecked && bindingR2.outsideleft.isChecked && bindingR2.insideright.isChecked && bindingR2.insideleft.isChecked) {
                            ch10.text = "تغير جميع البيضات"
                            bindingR2.s3erR2sAcx.setText("20")
                        } else {
                            if (bindingR2.outsideright.isChecked && bindingR2.outsideleft.isChecked && bindingR2.insideright.isChecked) {
                                ch10.text = "بيضتين علوية و السفلية يمين"
                                bindingR2.s3erR2sAcx.setText("15")
                            } else {
                                if (bindingR2.outsideright.isChecked && bindingR2.outsideleft.isChecked && bindingR2.insideleft.isChecked) {
                                    ch10.text = "بيضتين علوية و السفلية يسار"
                                    bindingR2.s3erR2sAcx.setText("15")
                                } else {
                                    if (bindingR2.outsideright.isChecked && bindingR2.insideright.isChecked && bindingR2.insideleft.isChecked) {
                                        ch10.text = "بيضة علوية يمين و السفليتين"
                                        bindingR2.s3erR2sAcx.setText("15")
                                    } else {
                                        if (bindingR2.outsideleft.isChecked && bindingR2.insideright.isChecked && bindingR2.insideleft.isChecked) {
                                            ch10.text = "بيضة علوية يسار و السفليتين"
                                            bindingR2.s3erR2sAcx.setText("15")
                                        } else {
                                            if (bindingR2.outsideright.isChecked && bindingR2.outsideleft.isChecked) {
                                                ch10.text = "بيضة علوية يمين و يسار"
                                                bindingR2.s3erR2sAcx.setText("10")
                                            } else {
                                                if (bindingR2.outsideright.isChecked && bindingR2.insideright.isChecked) {
                                                    ch10.text = "بيضة علوية يمين و السفلية يمين"
                                                    bindingR2.s3erR2sAcx.setText("10")
                                                } else {
                                                    if (bindingR2.outsideright.isChecked && bindingR2.insideleft.isChecked) {
                                                        ch10.text = "بيضة علوية يمين و السفلية يسار"
                                                        bindingR2.s3erR2sAcx.setText("10")
                                                    } else {
                                                        if (bindingR2.outsideleft.isChecked && bindingR2.insideright.isChecked) {
                                                            ch10.text =
                                                                "بيضة علوية يسار و السفلية يمين"
                                                            bindingR2.s3erR2sAcx.setText("10")
                                                        } else {
                                                            if (bindingR2.outsideleft.isChecked && bindingR2.insideleft.isChecked) {
                                                                ch10.text =
                                                                    "بيضة علوية يسار و السفلية يسار"
                                                                bindingR2.s3erR2sAcx.setText("10")
                                                            } else {
                                                                if (bindingR2.insideright.isChecked && bindingR2.insideleft.isChecked) {
                                                                    ch10.text =
                                                                        "بيضة سفلية يمين و يسار"
                                                                    bindingR2.s3erR2sAcx.setText(
                                                                        "10"
                                                                    )
                                                                } else {

                                                                    if (bindingR2.outsideright.isChecked) {
                                                                        ch10.text =
                                                                            "بيضة علوية يمين"
                                                                        bindingR2.s3erR2sAcx.setText(
                                                                            "5"
                                                                        )
                                                                    }
                                                                    if (bindingR2.outsideleft.isChecked) {
                                                                        ch10.text =
                                                                            "بيضة علوية يسار"
                                                                        bindingR2.s3erR2sAcx.setText(
                                                                            "5"
                                                                        )
                                                                    }

                                                                    if (bindingR2.insideleft.isChecked) {
                                                                        ch10.text =
                                                                            "بيضة سفلية يسار"
                                                                        bindingR2.s3erR2sAcx.setText(
                                                                            "5"
                                                                        )
                                                                    }
                                                                    if (bindingR2.insideright.isChecked) {
                                                                        ch10.text =
                                                                            "بيضة سفلية يمين"
                                                                        bindingR2.s3erR2sAcx.setText(
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


                    bindingR2.btnR2sSav.setOnClickListener {
                        if (!bindingR2.outsideright.isChecked && !bindingR2.outsideleft.isChecked
                            && !bindingR2.insideright.isChecked && !bindingR2.insideleft.isChecked
                        ) {
                            toast_notempty1.show()
                        } else {
                            if (bindingR2.s3erR2sAcx.text.toString().trim().isEmpty()) {
                                toast_notempty.show()
                            } else {
                                pric10.text = bindingR2.s3erR2sAcx.text.toString()
                                hy2ahModel.totalAmount += pric10.text.toString().toInt()
                                toolbar?.title =  hy2ahModel.totalAmount.toString()
                                hy2ahModel.ch10 = ch10.text.toString().trim()
                                hy2ahModel.pric10 = pric10.text.toString().trim()
                                customDialogR2SX.dismiss()
                            }
                        }
                    }
                    bindingR2.btnR2sCan.setOnClickListener {
                        if (pric10.text.toString().isEmpty()) {
                            ch10.text = "بيضة"
                            ch10.isChecked = false
                        }
                        customDialogR2SX.dismiss()
                    }
                    bindingR2.outsideright.isChecked = false
                    bindingR2.outsideleft.isChecked = false
                    bindingR2.insideright.isChecked = false
                    bindingR2.insideleft.isChecked = false
                    customDialogR2SX.show()

                } else {
                    if (pric10.text.toString().isNotEmpty()) {
                        hy2ahModel.totalAmount -= pric10.text.toString().toInt()
                        toolbar?.title =  hy2ahModel.totalAmount.toString()
                        ch10.text = "بيضة"
                        pric10.setText("")
                        hy2ahModel.ch10 =  ""
                        hy2ahModel.pric10 =  ""
                    } else {
                        ch10.text = "بيضة"
                    }
                }
            }
        }

        binding.apply{
            ch11.setOnCheckedChangeListener { _, isChecked ->
                if (ch11.isChecked) {

                    val window = customDialogFR.window
                    window?.setGravity(Gravity.TOP)
                    val lp = window?.attributes
                    lp?.dimAmount = 0.0f
                    lp?.flags = lp?.flags?.or(WindowManager.LayoutParams.FLAG_DIM_BEHIND)
                    window?.attributes = lp

                    bindingFR.frontright.setOnCheckedChangeListener { _, isChecked1 ->
                        if (bindingFR.frontright.isChecked) {
                            ch11.text = "شمزة اكس يمين"
                        } else {
                            ch11.text = "شمزة اكس"
                            bindingFR.s3erYadwee.setText("")
                        }
                        if (bindingFR.frontright.isChecked && bindingFR.frontleft.isChecked) {
                            ch11.text = "شمزة اكس يمين و يسار"
                            bindingFR.s3erYadwee.setText("10")
                        } else {
                            if (bindingFR.frontright.isChecked) {
                                ch11.text = "شمزة اكس يمين"
                                bindingFR.s3erYadwee.setText("5")
                            }
                            if (bindingFR.frontleft.isChecked) {
                                ch11.text = "شمزة اكس يسار"
                                bindingFR.s3erYadwee.setText("5")
                            }
                        }
                    }

                    bindingFR.frontleft.setOnCheckedChangeListener { _, isChecked2 ->
                        if (bindingFR.frontleft.isChecked) {
                            ch11.text = "شمزة اكس يسار"
                        } else {
                            ch11.text = "شمزة اكس"
                            bindingFR.s3erYadwee.setText("")
                        }
                        if (bindingFR.frontright.isChecked && bindingFR.frontleft.isChecked) {
                            ch11.text = "شمزة اكس يمين و يسار"
                            bindingFR.s3erYadwee.setText("10")
                        } else {
                            if (bindingFR.frontleft.isChecked) {
                                ch11.text = "شمزة اكس يسار"
                                bindingFR.s3erYadwee.setText("5")
                            }
                            if (bindingFR.frontright.isChecked) {
                                ch11.text = "شمزة اكس يمين"
                                bindingFR.s3erYadwee.setText("5")
                            }
                        }
                    }

                    bindingFR.buttonDailogSave.setOnClickListener {
                        if (!bindingFR.frontright.isChecked && !bindingFR.frontleft.isChecked) {
                            toast_notempty1.show()
                        } else {
                            if (bindingFR.s3erYadwee.text.toString().trim().isEmpty()) {
                                toast_notempty.show()
                                ch11.isChecked = false
                            } else {
                                pric11.text = bindingFR.s3erYadwee.text.toString()
                                hy2ahModel.totalAmount += pric11.text.toString().toInt()
                                toolbar?.title =  hy2ahModel.totalAmount.toString()
                                hy2ahModel.ch11 = ch11.text.toString().trim()
                                hy2ahModel.pric11 = pric11.text.toString().trim()
                                customDialogFR.dismiss()
                            }
                        }
                    }
                    bindingFR.buttonDailogCancel.setOnClickListener {
                        ch11.isChecked = false
                        bindingFR.s3erYadwee.setText("")
                        customDialogFR.dismiss()
                    }
                    bindingFR.frontright.isChecked = false
                    bindingFR.frontleft.isChecked = false
                    customDialogFR.show()

                }
                else {
                    if (pric11.text.toString().isNotEmpty()){
                        hy2ahModel.totalAmount -= pric11.text.toString().toInt()
                        toolbar?.title =  hy2ahModel.totalAmount.toString()
                        pric11.text = ""
                        hy2ahModel.ch11 =  ""
                        hy2ahModel.pric11 =  ""
                    }
                    ch11.text = "شمزة اكس"
                }
            }
        }

        binding.apply{
            ch12.setOnCheckedChangeListener { _, isChecked ->
                if (ch12.isChecked) {

                    customDialogR2SX.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

                    bindingR2.titR2sOut.text="امامي"
                    bindingR2.titR2sIn.text="خلفي"

                    bindingR2.cardR2s2ks.setOnTouchListener { _, event ->
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

                    bindingR2.outsideright.setOnCheckedChangeListener { _, isChecked1 ->

                        if (bindingR2.outsideright.isChecked) {
                            ch12.text = "عمود توازن جوزة امامي يمين"
                        } else {
                            ch12.text = "عمود توازن جوزة"
                            bindingR2.s3erR2sAcx.setText("")
                        }

                        if (bindingR2.outsideright.isChecked && bindingR2.outsideleft.isChecked && bindingR2.insideright.isChecked && bindingR2.insideleft.isChecked) {
                            ch12.text = "تغير عمود توازن جوزة كامل"
                            bindingR2.s3erR2sAcx.setText("12")
                        } else {
                            if (bindingR2.outsideright.isChecked && bindingR2.outsideleft.isChecked && bindingR2.insideright.isChecked) {
                                ch12.text = "عمودين توازن جوزة امامي و الخلفي يمين"
                                bindingR2.s3erR2sAcx.setText("9")
                            } else {
                                if (bindingR2.outsideright.isChecked && bindingR2.outsideleft.isChecked && bindingR2.insideleft.isChecked) {
                                    ch12.text = "عمودين توازن جوزة امامي  و الخلفي يسار"
                                    bindingR2.s3erR2sAcx.setText("9")
                                } else {
                                    if (bindingR2.outsideright.isChecked && bindingR2.insideright.isChecked && bindingR2.insideleft.isChecked) {
                                        ch12.text = "عمود توازن جوزة امامي يمين و الخلفيتين"
                                        bindingR2.s3erR2sAcx.setText("9")
                                    } else {
                                        if (bindingR2.outsideleft.isChecked && bindingR2.insideright.isChecked && bindingR2.insideleft.isChecked) {
                                            ch12.text = "عمود توازن جوزة امامي يسار و الخلفيتين"
                                            bindingR2.s3erR2sAcx.setText("9")
                                        } else {
                                            if (bindingR2.outsideright.isChecked && bindingR2.outsideleft.isChecked) {
                                                ch12.text = "عمود توازن جوزة امامي يمين و يسار"
                                                bindingR2.s3erR2sAcx.setText("6")
                                            } else {
                                                if (bindingR2.outsideright.isChecked && bindingR2.insideright.isChecked) {
                                                    ch12.text = "عمود توازن جوزة امامي يمين و خلفي يمين"
                                                    bindingR2.s3erR2sAcx.setText("6")
                                                } else {
                                                    if (bindingR2.outsideright.isChecked && bindingR2.insideleft.isChecked) {
                                                        ch12.text = "عمود توازن جوزة امامي يمين و خلفي يسار"
                                                        bindingR2.s3erR2sAcx.setText("6")
                                                    } else {
                                                        if (bindingR2.outsideleft.isChecked && bindingR2.insideright.isChecked) {
                                                            ch12.text =
                                                                "عمود توازن جوزة امامي يسار و خلفي يمين"
                                                            bindingR2.s3erR2sAcx.setText("6")
                                                        } else {
                                                            if (bindingR2.outsideleft.isChecked && bindingR2.insideleft.isChecked) {
                                                                ch12.text =
                                                                    "عمود توازن جوزة امامي يسار و خلفي يسار"
                                                                bindingR2.s3erR2sAcx.setText("6")
                                                            } else {
                                                                if (bindingR2.insideright.isChecked && bindingR2.insideleft.isChecked) {
                                                                    ch12.text =
                                                                        "عمود توازن جوزة خلفي يمين و يسار"
                                                                    bindingR2.s3erR2sAcx.setText(
                                                                        "3"
                                                                    )
                                                                } else {

                                                                    if (bindingR2.outsideright.isChecked) {
                                                                        ch12.text =
                                                                            "عمود توازن جوزة امامي يمين"
                                                                        bindingR2.s3erR2sAcx.setText(
                                                                            "3"
                                                                        )
                                                                    }
                                                                    if (bindingR2.outsideleft.isChecked) {
                                                                        ch12.text =
                                                                            "عمود توازن جوزة امامي يسار"
                                                                        bindingR2.s3erR2sAcx.setText(
                                                                            "3"
                                                                        )
                                                                    }

                                                                    if (bindingR2.insideleft.isChecked) {
                                                                        ch12.text =
                                                                            "عمود توازن جوزة خلفي يسار"
                                                                        bindingR2.s3erR2sAcx.setText(
                                                                            "3"
                                                                        )
                                                                    }
                                                                    if (bindingR2.insideright.isChecked) {
                                                                        ch12.text =
                                                                            "عمود توازن جوزة خلفي يمين"
                                                                        bindingR2.s3erR2sAcx.setText(
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



                    bindingR2.outsideleft.setOnCheckedChangeListener { _, isChecked2 ->
                        if (bindingR2.outsideleft.isChecked) {
                            ch12.text = "عمود توازن جوزة امامي يسار"
                        } else {
                            ch12.text = "عمود توازن جوزة"
                            bindingR2.s3erR2sAcx.setText("")
                        }

                        if (bindingR2.outsideright.isChecked && bindingR2.outsideleft.isChecked && bindingR2.insideright.isChecked && bindingR2.insideleft.isChecked) {
                            ch12.text = "تغير عمود توازن جوزة كامل"
                            bindingR2.s3erR2sAcx.setText("12")
                        } else {
                            if (bindingR2.outsideright.isChecked && bindingR2.outsideleft.isChecked && bindingR2.insideright.isChecked) {
                                ch12.text = "عمودين توازن جوزة امامي و الخلفي يمين"
                                bindingR2.s3erR2sAcx.setText("9")
                            } else {
                                if (bindingR2.outsideright.isChecked && bindingR2.outsideleft.isChecked && bindingR2.insideleft.isChecked) {
                                    ch12.text = "عمودين توازن جوزة امامي  و الخلفي يسار"
                                    bindingR2.s3erR2sAcx.setText("9")
                                } else {
                                    if (bindingR2.outsideright.isChecked && bindingR2.insideright.isChecked && bindingR2.insideleft.isChecked) {
                                        ch12.text = "عمود توازن جوزة امامي يمين و الخلفيتين"
                                        bindingR2.s3erR2sAcx.setText("9")
                                    } else {
                                        if (bindingR2.outsideleft.isChecked && bindingR2.insideright.isChecked && bindingR2.insideleft.isChecked) {
                                            ch12.text = "عمود توازن جوزة امامي يسار و الخلفيتين"
                                            bindingR2.s3erR2sAcx.setText("9")
                                        } else {
                                            if (bindingR2.outsideright.isChecked && bindingR2.outsideleft.isChecked) {
                                                ch12.text = "عمود توازن جوزة امامي يمين و يسار"
                                                bindingR2.s3erR2sAcx.setText("6")
                                            } else {
                                                if (bindingR2.outsideright.isChecked && bindingR2.insideright.isChecked) {
                                                    ch12.text = "عمود توازن جوزة امامي يمين و خلفي يمين"
                                                    bindingR2.s3erR2sAcx.setText("6")
                                                } else {
                                                    if (bindingR2.outsideright.isChecked && bindingR2.insideleft.isChecked) {
                                                        ch12.text = "عمود توازن جوزة امامي يمين و خلفي يسار"
                                                        bindingR2.s3erR2sAcx.setText("6")
                                                    } else {
                                                        if (bindingR2.outsideleft.isChecked && bindingR2.insideright.isChecked) {
                                                            ch12.text =
                                                                "عمود توازن جوزة امامي يسار و خلفي يمين"
                                                            bindingR2.s3erR2sAcx.setText("6")
                                                        } else {
                                                            if (bindingR2.outsideleft.isChecked && bindingR2.insideleft.isChecked) {
                                                                ch12.text =
                                                                    "عمود توازن جوزة امامي يسار و خلفي يسار"
                                                                bindingR2.s3erR2sAcx.setText("6")
                                                            } else {
                                                                if (bindingR2.insideright.isChecked && bindingR2.insideleft.isChecked) {
                                                                    ch12.text =
                                                                        "عمود توازن جوزة خلفي يمين و يسار"
                                                                    bindingR2.s3erR2sAcx.setText(
                                                                        "3"
                                                                    )
                                                                } else {

                                                                    if (bindingR2.outsideright.isChecked) {
                                                                        ch12.text =
                                                                            "عمود توازن جوزة امامي يمين"
                                                                        bindingR2.s3erR2sAcx.setText(
                                                                            "3"
                                                                        )
                                                                    }
                                                                    if (bindingR2.outsideleft.isChecked) {
                                                                        ch12.text =
                                                                            "عمود توازن جوزة امامي يسار"
                                                                        bindingR2.s3erR2sAcx.setText(
                                                                            "3"
                                                                        )
                                                                    }

                                                                    if (bindingR2.insideleft.isChecked) {
                                                                        ch12.text =
                                                                            "عمود توازن جوزة خلفي يسار"
                                                                        bindingR2.s3erR2sAcx.setText(
                                                                            "3"
                                                                        )
                                                                    }
                                                                    if (bindingR2.insideright.isChecked) {
                                                                        ch12.text =
                                                                            "عمود توازن جوزة خلفي يمين"
                                                                        bindingR2.s3erR2sAcx.setText(
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



                    bindingR2.insideleft.setOnCheckedChangeListener { _, isChecked2 ->
                        if (bindingR2.outsideright.isChecked) {
                            ch12.text = "عمود توازن جوزة خلفي يمين"
                        } else {
                            ch12.text = "عمود توازن جوزة"
                            bindingR2.s3erR2sAcx.setText("")
                        }

                        if (bindingR2.outsideright.isChecked && bindingR2.outsideleft.isChecked && bindingR2.insideright.isChecked && bindingR2.insideleft.isChecked) {
                            ch12.text = "تغير عمود توازن جوزة كامل"
                            bindingR2.s3erR2sAcx.setText("12")
                        } else {
                            if (bindingR2.outsideright.isChecked && bindingR2.outsideleft.isChecked && bindingR2.insideright.isChecked) {
                                ch12.text = "عمودين توازن جوزة امامي و الخلفي يمين"
                                bindingR2.s3erR2sAcx.setText("9")
                            } else {
                                if (bindingR2.outsideright.isChecked && bindingR2.outsideleft.isChecked && bindingR2.insideleft.isChecked) {
                                    ch12.text = "عمودين توازن جوزة امامي  و الخلفي يسار"
                                    bindingR2.s3erR2sAcx.setText("9")
                                } else {
                                    if (bindingR2.outsideright.isChecked && bindingR2.insideright.isChecked && bindingR2.insideleft.isChecked) {
                                        ch12.text = "عمود توازن جوزة امامي يمين و الخلفيتين"
                                        bindingR2.s3erR2sAcx.setText("9")
                                    } else {
                                        if (bindingR2.outsideleft.isChecked && bindingR2.insideright.isChecked && bindingR2.insideleft.isChecked) {
                                            ch12.text = "عمود توازن جوزة امامي يسار و الخلفيتين"
                                            bindingR2.s3erR2sAcx.setText("9")
                                        } else {
                                            if (bindingR2.outsideright.isChecked && bindingR2.outsideleft.isChecked) {
                                                ch12.text = "عمود توازن جوزة امامي يمين و يسار"
                                                bindingR2.s3erR2sAcx.setText("6")
                                            } else {
                                                if (bindingR2.outsideright.isChecked && bindingR2.insideright.isChecked) {
                                                    ch12.text = "عمود توازن جوزة امامي يمين و خلفي يمين"
                                                    bindingR2.s3erR2sAcx.setText("6")
                                                } else {
                                                    if (bindingR2.outsideright.isChecked && bindingR2.insideleft.isChecked) {
                                                        ch12.text = "عمود توازن جوزة امامي يمين و خلفي يسار"
                                                        bindingR2.s3erR2sAcx.setText("6")
                                                    } else {
                                                        if (bindingR2.outsideleft.isChecked && bindingR2.insideright.isChecked) {
                                                            ch12.text =
                                                                "عمود توازن جوزة امامي يسار و خلفي يمين"
                                                            bindingR2.s3erR2sAcx.setText("6")
                                                        } else {
                                                            if (bindingR2.outsideleft.isChecked && bindingR2.insideleft.isChecked) {
                                                                ch12.text =
                                                                    "عمود توازن جوزة امامي يسار و خلفي يسار"
                                                                bindingR2.s3erR2sAcx.setText("6")
                                                            } else {
                                                                if (bindingR2.insideright.isChecked && bindingR2.insideleft.isChecked) {
                                                                    ch12.text =
                                                                        "عمود توازن جوزة خلفي يمين و يسار"
                                                                    bindingR2.s3erR2sAcx.setText(
                                                                        "3"
                                                                    )
                                                                } else {

                                                                    if (bindingR2.outsideright.isChecked) {
                                                                        ch12.text =
                                                                            "عمود توازن جوزة امامي يمين"
                                                                        bindingR2.s3erR2sAcx.setText(
                                                                            "3"
                                                                        )
                                                                    }
                                                                    if (bindingR2.outsideleft.isChecked) {
                                                                        ch12.text =
                                                                            "عمود توازن جوزة امامي يسار"
                                                                        bindingR2.s3erR2sAcx.setText(
                                                                            "3"
                                                                        )
                                                                    }

                                                                    if (bindingR2.insideleft.isChecked) {
                                                                        ch12.text =
                                                                            "عمود توازن جوزة خلفي يسار"
                                                                        bindingR2.s3erR2sAcx.setText(
                                                                            "3"
                                                                        )
                                                                    }
                                                                    if (bindingR2.insideright.isChecked) {
                                                                        ch12.text =
                                                                            "عمود توازن جوزة خلفي يمين"
                                                                        bindingR2.s3erR2sAcx.setText(
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

                    bindingR2.insideright.setOnCheckedChangeListener { _, isChecked2 ->
                        if (bindingR2.outsideright.isChecked) {
                            ch12.text = "عمود توازن جوزة خلفي يمين"
                        } else {
                            ch12.text = "عمود توازن جوزة "
                            bindingR2.s3erR2sAcx.setText("")
                        }

                        if (bindingR2.outsideright.isChecked && bindingR2.outsideleft.isChecked && bindingR2.insideright.isChecked && bindingR2.insideleft.isChecked) {
                            ch12.text = "تغير عمود توازن جوزة كامل"
                            bindingR2.s3erR2sAcx.setText("12")
                        } else {
                            if (bindingR2.outsideright.isChecked && bindingR2.outsideleft.isChecked && bindingR2.insideright.isChecked) {
                                ch12.text = "عمودين توازن جوزة امامي و الخلفي يمين"
                                bindingR2.s3erR2sAcx.setText("9")
                            } else {
                                if (bindingR2.outsideright.isChecked && bindingR2.outsideleft.isChecked && bindingR2.insideleft.isChecked) {
                                    ch12.text = "عمودين توازن جوزة امامي  و الخلفي يسار"
                                    bindingR2.s3erR2sAcx.setText("9")
                                } else {
                                    if (bindingR2.outsideright.isChecked && bindingR2.insideright.isChecked && bindingR2.insideleft.isChecked) {
                                        ch12.text = "عمود توازن جوزة امامي يمين و الخلفيتين"
                                        bindingR2.s3erR2sAcx.setText("9")
                                    } else {
                                        if (bindingR2.outsideleft.isChecked && bindingR2.insideright.isChecked && bindingR2.insideleft.isChecked) {
                                            ch12.text = "عمود توازن جوزة امامي يسار و الخلفيتين"
                                            bindingR2.s3erR2sAcx.setText("9")
                                        } else {
                                            if (bindingR2.outsideright.isChecked && bindingR2.outsideleft.isChecked) {
                                                ch12.text = "عمود توازن جوزة امامي يمين و يسار"
                                                bindingR2.s3erR2sAcx.setText("6")
                                            } else {
                                                if (bindingR2.outsideright.isChecked && bindingR2.insideright.isChecked) {
                                                    ch12.text = "عمود توازن جوزة امامي يمين و خلفي يمين"
                                                    bindingR2.s3erR2sAcx.setText("6")
                                                } else {
                                                    if (bindingR2.outsideright.isChecked && bindingR2.insideleft.isChecked) {
                                                        ch12.text = "عمود توازن جوزة امامي يمين و خلفي يسار"
                                                        bindingR2.s3erR2sAcx.setText("6")
                                                    } else {
                                                        if (bindingR2.outsideleft.isChecked && bindingR2.insideright.isChecked) {
                                                            ch12.text =
                                                                "عمود توازن جوزة امامي يسار و خلفي يمين"
                                                            bindingR2.s3erR2sAcx.setText("6")
                                                        } else {
                                                            if (bindingR2.outsideleft.isChecked && bindingR2.insideleft.isChecked) {
                                                                ch12.text =
                                                                    "عمود توازن جوزة امامي يسار و خلفي يسار"
                                                                bindingR2.s3erR2sAcx.setText("6")
                                                            } else {
                                                                if (bindingR2.insideright.isChecked && bindingR2.insideleft.isChecked) {
                                                                    ch12.text =
                                                                        "عمود توازن جوزة خلفي يمين و يسار"
                                                                    bindingR2.s3erR2sAcx.setText(
                                                                        "3"
                                                                    )
                                                                } else {

                                                                    if (bindingR2.outsideright.isChecked) {
                                                                        ch12.text =
                                                                            "عمود توازن جوزة امامي يمين"
                                                                        bindingR2.s3erR2sAcx.setText(
                                                                            "3"
                                                                        )
                                                                    }
                                                                    if (bindingR2.outsideleft.isChecked) {
                                                                        ch12.text =
                                                                            "عمود توازن جوزة امامي يسار"
                                                                        bindingR2.s3erR2sAcx.setText(
                                                                            "3"
                                                                        )
                                                                    }

                                                                    if (bindingR2.insideleft.isChecked) {
                                                                        ch12.text =
                                                                            "عمود توازن جوزة خلفي يسار"
                                                                        bindingR2.s3erR2sAcx.setText(
                                                                            "3"
                                                                        )
                                                                    }
                                                                    if (bindingR2.insideright.isChecked) {
                                                                        ch12.text =
                                                                            "عمود توازن جوزة خلفي يمين"
                                                                        bindingR2.s3erR2sAcx.setText(
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


                    bindingR2.btnR2sSav.setOnClickListener {
                        if (!bindingR2.outsideright.isChecked && !bindingR2.outsideleft.isChecked
                            && !bindingR2.insideright.isChecked && !bindingR2.insideleft.isChecked
                        ) {
                            toast_notempty1.show()
                        } else {
                            if (bindingR2.s3erR2sAcx.text.toString().trim().isEmpty()) {
                                toast_notempty.show()
                            } else {
                                pric12.text = bindingR2.s3erR2sAcx.text.toString()
                                hy2ahModel.totalAmount += pric12.text.toString().toInt()
                                toolbar?.title =  hy2ahModel.totalAmount.toString()
                                hy2ahModel.ch12 = ch12.text.toString().trim()
                                hy2ahModel.pric12 = pric12.text.toString().trim()
                                customDialogR2SX.dismiss()
                            }
                        }
                    }
                    bindingR2.btnR2sCan.setOnClickListener {
                        if (pric12.text.toString().isEmpty()) {
                            ch12.text = "عمود توازن جوزة"
                            ch12.isChecked = false
                        }
                        customDialogR2SX.dismiss()
                    }
                    bindingR2.outsideright.isChecked = false
                    bindingR2.outsideleft.isChecked = false
                    bindingR2.insideright.isChecked = false
                    bindingR2.insideleft.isChecked = false
                    customDialogR2SX.show()

                } else {
                    if (pric12.text.toString().isNotEmpty()) {
                        hy2ahModel.totalAmount -= pric12.text.toString().toInt()
                        toolbar?.title =  hy2ahModel.totalAmount.toString()
                        ch12.text = "عمود توازن جوزة"
                        pric12.setText("")
                        hy2ahModel.ch12 =  ""
                        hy2ahModel.pric12 =  ""
                    } else {
                        ch12.text = "عمود توازن جوزة"
                    }
                }
            }
        }

        binding.apply{
            ch13.setOnCheckedChangeListener { _, isChecked ->
                if (ch13.isChecked) {

                    bindingF79.s3erYadweeFa7.setText("10")

                    bindingF79.btnSvDigFa7.setOnClickListener {
                        if (bindingF79.s3erYadweeFa7.text.toString().isEmpty()) {
                            toast_notempty.show()
                        } else {
                            pric13.text = bindingF79.s3erYadweeFa7.text.toString()
                            hy2ahModel.totalAmount += pric13.text.toString().toInt()
                            toolbar?.title =  hy2ahModel.totalAmount.toString()
                            hy2ahModel.ch13 = ch13.text.toString().trim()
                            hy2ahModel.pric13 = pric13.text.toString().trim()
                            customDialogF79.dismiss()
                        }
                    }

                    customDialogF79.show()

                } else {
                    hy2ahModel.totalAmount -= pric13.text.toString().toInt()
                    toolbar?.title =  hy2ahModel.totalAmount.toString()
                    pric13.text = ""
                    hy2ahModel.ch13 =  ""
                    hy2ahModel.pric13 =  ""
                }
            }
        }

        binding.apply{
            ch14.setOnCheckedChangeListener { _, isChecked ->
                if (ch14.isChecked) {

                    customDialogR2SX.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
                    bindingR2.titR2sOut.text="امامي"
                    bindingR2.titR2sIn.text="خلفي"


                    bindingR2.cardR2s2ks.setOnTouchListener { _, event ->
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

                    bindingR2.outsideright.setOnCheckedChangeListener { _, isChecked1 ->

                        if (bindingR2.outsideright.isChecked) {
                            ch14.text = "هب امامي يمين"
                        } else {
                            ch14.text = "هب"
                            bindingR2.s3erR2sAcx.setText("")
                        }

                        if (bindingR2.outsideright.isChecked && bindingR2.outsideleft.isChecked && bindingR2.insideright.isChecked && bindingR2.insideleft.isChecked) {
                            ch14.text = "تغير جميع الهبات"
                            bindingR2.s3erR2sAcx.setText("40")
                        } else {
                            if (bindingR2.outsideright.isChecked && bindingR2.outsideleft.isChecked && bindingR2.insideright.isChecked) {
                                ch14.text = "هب امامي كامل و الخلفي يمين"
                                bindingR2.s3erR2sAcx.setText("30")
                            } else {
                                if (bindingR2.outsideright.isChecked && bindingR2.outsideleft.isChecked && bindingR2.insideleft.isChecked) {
                                    ch14.text = "هب امامي كامل و الخلفي يسار"
                                    bindingR2.s3erR2sAcx.setText("30")
                                } else {
                                    if (bindingR2.outsideright.isChecked && bindingR2.insideright.isChecked && bindingR2.insideleft.isChecked) {
                                        ch14.text = "هب امامي يمين و الخلفيين"
                                        bindingR2.s3erR2sAcx.setText("30")
                                    } else {
                                        if (bindingR2.outsideleft.isChecked && bindingR2.insideright.isChecked && bindingR2.insideleft.isChecked) {
                                            ch14.text = "هب امامي يسار و الخلفيين"
                                            bindingR2.s3erR2sAcx.setText("30")
                                        } else {
                                            if (bindingR2.outsideright.isChecked && bindingR2.outsideleft.isChecked) {
                                                ch14.text = "هب امامي يمين و يسار"
                                                bindingR2.s3erR2sAcx.setText("20")
                                            } else {
                                                if (bindingR2.outsideright.isChecked && bindingR2.insideright.isChecked) {
                                                    ch14.text = "هب امامي يمين و الخلفي يمين"
                                                    bindingR2.s3erR2sAcx.setText("20")
                                                } else {
                                                    if (bindingR2.outsideright.isChecked && bindingR2.insideleft.isChecked) {
                                                        ch14.text = "هب امامي يمين و الخلفي يسار"
                                                        bindingR2.s3erR2sAcx.setText("20")
                                                    } else {
                                                        if (bindingR2.outsideleft.isChecked && bindingR2.insideright.isChecked) {
                                                            ch14.text =
                                                                "هب امامي يسار و الخلفي يمين"
                                                            bindingR2.s3erR2sAcx.setText("20")
                                                        } else {
                                                            if (bindingR2.outsideleft.isChecked && bindingR2.insideleft.isChecked) {
                                                                ch14.text =
                                                                    "هب امامي يسار و الخلفي يسار"
                                                                bindingR2.s3erR2sAcx.setText("20")
                                                            } else {
                                                                if (bindingR2.insideright.isChecked && bindingR2.insideleft.isChecked) {
                                                                    ch14.text =
                                                                        "هب خلفي يمين و يسار"
                                                                    bindingR2.s3erR2sAcx.setText(
                                                                        "20"
                                                                    )
                                                                } else {

                                                                    if (bindingR2.outsideright.isChecked) {
                                                                        ch14.text =
                                                                            "هب امامي يمين"
                                                                        bindingR2.s3erR2sAcx.setText(
                                                                            "10"
                                                                        )
                                                                    }
                                                                    if (bindingR2.outsideleft.isChecked) {
                                                                        ch14.text =
                                                                            "هب امامي يسار"
                                                                        bindingR2.s3erR2sAcx.setText(
                                                                            "10"
                                                                        )
                                                                    }

                                                                    if (bindingR2.insideleft.isChecked) {
                                                                        ch14.text =
                                                                            "هب خلفي يسار"
                                                                        bindingR2.s3erR2sAcx.setText(
                                                                            "10"
                                                                        )
                                                                    }
                                                                    if (bindingR2.insideright.isChecked) {
                                                                        ch14.text =
                                                                            "هب خلفي يمين"
                                                                        bindingR2.s3erR2sAcx.setText(
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

                    bindingR2.outsideleft.setOnCheckedChangeListener { _, isChecked2 ->
                        if (bindingR2.outsideleft.isChecked) {
                            ch14.text = "هب امامي يمين"
                        } else {
                            ch14.text = "هب"
                            bindingR2.s3erR2sAcx.setText("")
                        }

                        if (bindingR2.outsideright.isChecked && bindingR2.outsideleft.isChecked && bindingR2.insideright.isChecked && bindingR2.insideleft.isChecked) {
                            ch14.text = "تغير جميع الهبات"
                            bindingR2.s3erR2sAcx.setText("40")
                        } else {
                            if (bindingR2.outsideright.isChecked && bindingR2.outsideleft.isChecked && bindingR2.insideright.isChecked) {
                                ch14.text = "هب امامي كامل و الخلفي يمين"
                                bindingR2.s3erR2sAcx.setText("30")
                            } else {
                                if (bindingR2.outsideright.isChecked && bindingR2.outsideleft.isChecked && bindingR2.insideleft.isChecked) {
                                    ch14.text = "هب امامي كامل و الخلفي يسار"
                                    bindingR2.s3erR2sAcx.setText("30")
                                } else {
                                    if (bindingR2.outsideright.isChecked && bindingR2.insideright.isChecked && bindingR2.insideleft.isChecked) {
                                        ch14.text = "هب امامي يمين و الخلفيين"
                                        bindingR2.s3erR2sAcx.setText("30")
                                    } else {
                                        if (bindingR2.outsideleft.isChecked && bindingR2.insideright.isChecked && bindingR2.insideleft.isChecked) {
                                            ch14.text = "هب امامي يسار و الخلفيين"
                                            bindingR2.s3erR2sAcx.setText("30")
                                        } else {
                                            if (bindingR2.outsideright.isChecked && bindingR2.outsideleft.isChecked) {
                                                ch14.text = "هب امامي يمين و يسار"
                                                bindingR2.s3erR2sAcx.setText("20")
                                            } else {
                                                if (bindingR2.outsideright.isChecked && bindingR2.insideright.isChecked) {
                                                    ch14.text = "هب امامي يمين و الخلفي يمين"
                                                    bindingR2.s3erR2sAcx.setText("20")
                                                } else {
                                                    if (bindingR2.outsideright.isChecked && bindingR2.insideleft.isChecked) {
                                                        ch14.text = "هب امامي يمين و الخلفي يسار"
                                                        bindingR2.s3erR2sAcx.setText("20")
                                                    } else {
                                                        if (bindingR2.outsideleft.isChecked && bindingR2.insideright.isChecked) {
                                                            ch14.text =
                                                                "هب امامي يسار و الخلفي يمين"
                                                            bindingR2.s3erR2sAcx.setText("20")
                                                        } else {
                                                            if (bindingR2.outsideleft.isChecked && bindingR2.insideleft.isChecked) {
                                                                ch14.text =
                                                                    "هب امامي يسار و الخلفي يسار"
                                                                bindingR2.s3erR2sAcx.setText("20")
                                                            } else {
                                                                if (bindingR2.insideright.isChecked && bindingR2.insideleft.isChecked) {
                                                                    ch14.text =
                                                                        "هب خلفي يمين و يسار"
                                                                    bindingR2.s3erR2sAcx.setText(
                                                                        "20"
                                                                    )
                                                                } else {

                                                                    if (bindingR2.outsideright.isChecked) {
                                                                        ch14.text =
                                                                            "هب امامي يمين"
                                                                        bindingR2.s3erR2sAcx.setText(
                                                                            "10"
                                                                        )
                                                                    }
                                                                    if (bindingR2.outsideleft.isChecked) {
                                                                        ch14.text =
                                                                            "هب امامي يسار"
                                                                        bindingR2.s3erR2sAcx.setText(
                                                                            "10"
                                                                        )
                                                                    }

                                                                    if (bindingR2.insideleft.isChecked) {
                                                                        ch14.text =
                                                                            "هب خلفي يسار"
                                                                        bindingR2.s3erR2sAcx.setText(
                                                                            "10"
                                                                        )
                                                                    }
                                                                    if (bindingR2.insideright.isChecked) {
                                                                        ch14.text =
                                                                            "هب خلفي يمين"
                                                                        bindingR2.s3erR2sAcx.setText(
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



                    bindingR2.insideleft.setOnCheckedChangeListener { _, isChecked2 ->
                        if (bindingR2.outsideright.isChecked) {
                            ch14.text = "هب امامي يمين"
                        } else {
                            ch14.text = "هب"
                            bindingR2.s3erR2sAcx.setText("")
                        }

                        if (bindingR2.outsideright.isChecked && bindingR2.outsideleft.isChecked && bindingR2.insideright.isChecked && bindingR2.insideleft.isChecked) {
                            ch14.text = "تغير جميع الهبات"
                            bindingR2.s3erR2sAcx.setText("40")
                        } else {
                            if (bindingR2.outsideright.isChecked && bindingR2.outsideleft.isChecked && bindingR2.insideright.isChecked) {
                                ch14.text = "هب امامي كامل و الخلفي يمين"
                                bindingR2.s3erR2sAcx.setText("30")
                            } else {
                                if (bindingR2.outsideright.isChecked && bindingR2.outsideleft.isChecked && bindingR2.insideleft.isChecked) {
                                    ch14.text = "هب امامي كامل و الخلفي يسار"
                                    bindingR2.s3erR2sAcx.setText("30")
                                } else {
                                    if (bindingR2.outsideright.isChecked && bindingR2.insideright.isChecked && bindingR2.insideleft.isChecked) {
                                        ch14.text = "هب امامي يمين و الخلفيين"
                                        bindingR2.s3erR2sAcx.setText("30")
                                    } else {
                                        if (bindingR2.outsideleft.isChecked && bindingR2.insideright.isChecked && bindingR2.insideleft.isChecked) {
                                            ch14.text = "هب امامي يسار و الخلفيين"
                                            bindingR2.s3erR2sAcx.setText("30")
                                        } else {
                                            if (bindingR2.outsideright.isChecked && bindingR2.outsideleft.isChecked) {
                                                ch14.text = "هب امامي يمين و يسار"
                                                bindingR2.s3erR2sAcx.setText("20")
                                            } else {
                                                if (bindingR2.outsideright.isChecked && bindingR2.insideright.isChecked) {
                                                    ch14.text = "هب امامي يمين و الخلفي يمين"
                                                    bindingR2.s3erR2sAcx.setText("20")
                                                } else {
                                                    if (bindingR2.outsideright.isChecked && bindingR2.insideleft.isChecked) {
                                                        ch14.text = "هب امامي يمين و الخلفي يسار"
                                                        bindingR2.s3erR2sAcx.setText("20")
                                                    } else {
                                                        if (bindingR2.outsideleft.isChecked && bindingR2.insideright.isChecked) {
                                                            ch14.text =
                                                                "هب امامي يسار و الخلفي يمين"
                                                            bindingR2.s3erR2sAcx.setText("20")
                                                        } else {
                                                            if (bindingR2.outsideleft.isChecked && bindingR2.insideleft.isChecked) {
                                                                ch14.text =
                                                                    "هب امامي يسار و الخلفي يسار"
                                                                bindingR2.s3erR2sAcx.setText("20")
                                                            } else {
                                                                if (bindingR2.insideright.isChecked && bindingR2.insideleft.isChecked) {
                                                                    ch14.text =
                                                                        "هب خلفي يمين و يسار"
                                                                    bindingR2.s3erR2sAcx.setText(
                                                                        "20"
                                                                    )
                                                                } else {

                                                                    if (bindingR2.outsideright.isChecked) {
                                                                        ch14.text =
                                                                            "هب امامي يمين"
                                                                        bindingR2.s3erR2sAcx.setText(
                                                                            "10"
                                                                        )
                                                                    }
                                                                    if (bindingR2.outsideleft.isChecked) {
                                                                        ch14.text =
                                                                            "هب امامي يسار"
                                                                        bindingR2.s3erR2sAcx.setText(
                                                                            "10"
                                                                        )
                                                                    }

                                                                    if (bindingR2.insideleft.isChecked) {
                                                                        ch14.text =
                                                                            "هب خلفي يسار"
                                                                        bindingR2.s3erR2sAcx.setText(
                                                                            "10"
                                                                        )
                                                                    }
                                                                    if (bindingR2.insideright.isChecked) {
                                                                        ch14.text =
                                                                            "هب خلفي يمين"
                                                                        bindingR2.s3erR2sAcx.setText(
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

                    bindingR2.insideright.setOnCheckedChangeListener { _, isChecked2 ->
                        if (bindingR2.insideright.isChecked) {
                            ch14.text = "هب امامي يمين"
                        } else {
                            ch14.text = "هب"
                            bindingR2.s3erR2sAcx.setText("")
                        }

                        if (bindingR2.outsideright.isChecked && bindingR2.outsideleft.isChecked && bindingR2.insideright.isChecked && bindingR2.insideleft.isChecked) {
                            ch14.text = "تغير جميع الهبات"
                            bindingR2.s3erR2sAcx.setText("40")
                        } else {
                            if (bindingR2.outsideright.isChecked && bindingR2.outsideleft.isChecked && bindingR2.insideright.isChecked) {
                                ch14.text = "هب امامي كامل و الخلفي يمين"
                                bindingR2.s3erR2sAcx.setText("30")
                            } else {
                                if (bindingR2.outsideright.isChecked && bindingR2.outsideleft.isChecked && bindingR2.insideleft.isChecked) {
                                    ch14.text = "هب امامي كامل و الخلفي يسار"
                                    bindingR2.s3erR2sAcx.setText("30")
                                } else {
                                    if (bindingR2.outsideright.isChecked && bindingR2.insideright.isChecked && bindingR2.insideleft.isChecked) {
                                        ch14.text = "هب امامي يمين و الخلفيين"
                                        bindingR2.s3erR2sAcx.setText("30")
                                    } else {
                                        if (bindingR2.outsideleft.isChecked && bindingR2.insideright.isChecked && bindingR2.insideleft.isChecked) {
                                            ch14.text = "هب امامي يسار و الخلفيين"
                                            bindingR2.s3erR2sAcx.setText("30")
                                        } else {
                                            if (bindingR2.outsideright.isChecked && bindingR2.outsideleft.isChecked) {
                                                ch14.text = "هب امامي يمين و يسار"
                                                bindingR2.s3erR2sAcx.setText("20")
                                            } else {
                                                if (bindingR2.outsideright.isChecked && bindingR2.insideright.isChecked) {
                                                    ch14.text = "هب امامي يمين و الخلفي يمين"
                                                    bindingR2.s3erR2sAcx.setText("20")
                                                } else {
                                                    if (bindingR2.outsideright.isChecked && bindingR2.insideleft.isChecked) {
                                                        ch14.text = "هب امامي يمين و الخلفي يسار"
                                                        bindingR2.s3erR2sAcx.setText("20")
                                                    } else {
                                                        if (bindingR2.outsideleft.isChecked && bindingR2.insideright.isChecked) {
                                                            ch14.text =
                                                                "هب امامي يسار و الخلفي يمين"
                                                            bindingR2.s3erR2sAcx.setText("20")
                                                        } else {
                                                            if (bindingR2.outsideleft.isChecked && bindingR2.insideleft.isChecked) {
                                                                ch14.text =
                                                                    "هب امامي يسار و الخلفي يسار"
                                                                bindingR2.s3erR2sAcx.setText("20")
                                                            } else {
                                                                if (bindingR2.insideright.isChecked && bindingR2.insideleft.isChecked) {
                                                                    ch14.text =
                                                                        "هب خلفي يمين و يسار"
                                                                    bindingR2.s3erR2sAcx.setText(
                                                                        "20"
                                                                    )
                                                                } else {

                                                                    if (bindingR2.outsideright.isChecked) {
                                                                        ch14.text =
                                                                            "هب امامي يمين"
                                                                        bindingR2.s3erR2sAcx.setText(
                                                                            "10"
                                                                        )
                                                                    }
                                                                    if (bindingR2.outsideleft.isChecked) {
                                                                        ch14.text =
                                                                            "هب امامي يسار"
                                                                        bindingR2.s3erR2sAcx.setText(
                                                                            "10"
                                                                        )
                                                                    }

                                                                    if (bindingR2.insideleft.isChecked) {
                                                                        ch14.text =
                                                                            "هب خلفي يسار"
                                                                        bindingR2.s3erR2sAcx.setText(
                                                                            "10"
                                                                        )
                                                                    }
                                                                    if (bindingR2.insideright.isChecked) {
                                                                        ch14.text =
                                                                            "هب خلفي يمين"
                                                                        bindingR2.s3erR2sAcx.setText(
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


                    bindingR2.btnR2sSav.setOnClickListener {
                        if (!bindingR2.outsideright.isChecked && !bindingR2.outsideleft.isChecked
                            && !bindingR2.insideright.isChecked && !bindingR2.insideleft.isChecked
                        ) {
                            toast_notempty1.show()
                        } else {
                            if (bindingR2.s3erR2sAcx.text.toString().trim().isEmpty()) {
                                toast_notempty.show()
                            } else {
                                pric14.text = bindingR2.s3erR2sAcx.text.toString()
                                hy2ahModel.totalAmount += pric14.text.toString().toInt()
                                toolbar?.title =  hy2ahModel.totalAmount.toString()
                                hy2ahModel.ch14 = ch14.text.toString().trim()
                                hy2ahModel.pric14 = pric14.text.toString().trim()
                                customDialogR2SX.dismiss()
                            }
                        }
                    }
                    bindingR2.btnR2sCan.setOnClickListener {
                        if (pric14.text.toString().isEmpty()) {
                            ch14.text = "هب"
                            ch14.isChecked = false
                        }
                        customDialogR2SX.dismiss()
                    }
                    bindingR2.outsideright.isChecked = false
                    bindingR2.outsideleft.isChecked = false
                    bindingR2.insideright.isChecked = false
                    bindingR2.insideleft.isChecked = false
                    customDialogR2SX.show()

                } else {
                    if (pric14.text.toString().isNotEmpty()) {
                        hy2ahModel.totalAmount -= pric14.text.toString().toInt()
                        toolbar?.title =  hy2ahModel.totalAmount.toString()
                        ch14.text = "هب"
                        pric14.setText("")
                        hy2ahModel.ch14 =  ""
                        hy2ahModel.pric14 =  ""
                    } else {
                        ch14.text = "هب"
                    }
                }
            }
        }

        binding.apply{
            ch15.setOnCheckedChangeListener { _, isChecked ->
                if (ch15.isChecked) {
                    customDialogBL6.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
//                bindingBL6.card_bala6at.setOnTouchListener { _, event ->
//                    var x = 0f
//                    var y = 0f
//                    when (event.action) {
//                        MotionEvent.ACTION_UP -> {
//                            x = event.x
//                            y = event.y
//                        }
//                        MotionEvent.ACTION_MOVE -> {
//                            bindingBL6.window?.let {
//                                val params: WindowManager.LayoutParams = it.attributes
//                                params.x = event.rawX.toInt() - x.toInt()
//                                params.y = event.rawY.toInt() - y.toInt()
//                                it.attributes = params
//                            }
//                        }
//
//                        MotionEvent.ACTION_UP -> {
//                            bindingBL6.window?.let {
//                                val params: WindowManager.LayoutParams = it.attributes
//                                if (params.y < 0) {
//                                    params.y = 0
//                                    it.attributes = params
//                                } else if (params.y > 2000) { // change this value to move up more
//                                    params.y = 2000 // change this value to move up more
//                                    it.attributes = params
//                                }
//                            }
//                        }
//
//                    }
//                    true
//                }

                    bindingBL6.gyarBala6at2mamy.setOnCheckedChangeListener { _, isChecked1 ->

                        if (bindingBL6.gyarBala6at2mamy.isChecked) {
                            bindingBL6.fakBala6at2mamy.isEnabled=false
                            ch15.text = "غيار بلاطات امامية"
                        } else {
                            bindingBL6.fakBala6at2mamy.isEnabled=true
                            ch15.text = "غيار بلاطات"
                            bindingBL6.s3erBala6at.setText("")
                        }
                        if (bindingBL6.gyarBala6at2mamy.isChecked && bindingBL6.gyarBala6at5alfy.isChecked) {
                            ch15.text = "غيار بلاطات امامي و خلفي"
                            bindingBL6.s3erBala6at.setText("20")
                        } else {
                            if (bindingBL6.gyarBala6at2mamy.isChecked && bindingBL6.fakBala6at5alfy.isChecked) {
                                ch15.text = "غيار بلاطات امامي و فك خلفي"
                                bindingBL6.s3erBala6at.setText("20")
                            } else {
                                if (bindingBL6.gyarBala6at2mamy.isChecked) {
                                    ch15.text = "غيار بلاطات امامي"
                                    bindingBL6.s3erBala6at.setText("10")
                                }
                                if (bindingBL6.gyarBala6at5alfy.isChecked) {
                                    ch15.text = "غيار بلاطات خلفي"
                                    bindingBL6.s3erBala6at.setText("10")
                                }
                            }
                        }
                    }

                    bindingBL6.gyarBala6at5alfy.setOnCheckedChangeListener { _, isChecked2 ->

                        if (bindingBL6.gyarBala6at5alfy.isChecked) {
                            bindingBL6.fakBala6at5alfy.isEnabled = false
                            ch15.text = "غيار بلاطات خلفي"
                        } else {
                            bindingBL6.fakBala6at5alfy.isEnabled = true
                            ch15.text = "غيار بلاطات"
                            bindingBL6.s3erBala6at.setText("")
                        }
                        if (bindingBL6.gyarBala6at2mamy.isChecked && bindingBL6.gyarBala6at5alfy.isChecked) {
                            ch15.text = "غيار بلاطات امامي و خلفي"
                            bindingBL6.s3erBala6at.setText("20")
                        } else {
                            if (bindingBL6.gyarBala6at5alfy.isChecked && bindingBL6.fakBala6at2mamy.isChecked) {
                                ch15.text = "غيار بلاطات خلفي و فك امامي"
                                bindingBL6.s3erBala6at.setText("20")
                            } else {

                                if (bindingBL6.gyarBala6at5alfy.isChecked) {
                                    ch15.text = "غيار بلاطات خلفي"
                                    bindingBL6.s3erBala6at.setText("10")
                                }
                                if (bindingBL6.gyarBala6at2mamy.isChecked) {
                                    ch15.text = "غيار بلاطات امامي"
                                    bindingBL6.s3erBala6at.setText("10")
                                }
                            }
                        }
                    }



                    bindingBL6.fakBala6at2mamy.setOnCheckedChangeListener { _, isChecked1 ->
                        if (bindingBL6.fakBala6at2mamy.isChecked) {
                            bindingBL6.gyarBala6at2mamy.isEnabled=false
                            ch15.text = "فك بلاطات امامية"
                        } else {
                            bindingBL6.gyarBala6at2mamy.isEnabled=true
                            ch15.text = "بلاطات"
                            bindingBL6.s3erBala6at.setText("")
                        }
                        if (bindingBL6.fakBala6at2mamy.isChecked && bindingBL6.fakBala6at5alfy.isChecked) {
                            ch15.text = "فك بلاطات امامي و خلفي"
                            bindingBL6.s3erBala6at.setText("20")
                        } else {

                            if (bindingBL6.fakBala6at2mamy.isChecked && bindingBL6.gyarBala6at5alfy.isChecked) {
                                ch15.text = "فك بلاطات امامي و غيار خلفي"
                                bindingBL6.s3erBala6at.setText("20")
                            } else {
                                if (bindingBL6.fakBala6at2mamy.isChecked) {
                                    ch15.text = "فك بلاطات امامي"
                                    bindingBL6.s3erBala6at.setText("10")
                                }
                                if (bindingBL6.fakBala6at5alfy.isChecked) {
                                    ch15.text = "فك بلاطات خلفي"
                                    bindingBL6.s3erBala6at.setText("10")
                                }
                            }
                        }
                    }

                    bindingBL6.fakBala6at5alfy.setOnCheckedChangeListener { _, isChecked2 ->
                        if (bindingBL6.fakBala6at5alfy.isChecked) {
                            bindingBL6.gyarBala6at5alfy.isEnabled=false
                            ch15.text = "فك بلاطات خلفي"
                        } else {
                            bindingBL6.gyarBala6at5alfy.isEnabled=true
                            ch15.text = "بلاطات"
                            bindingBL6.s3erBala6at.setText("")
                        }
                        if (bindingBL6.fakBala6at2mamy.isChecked && bindingBL6.fakBala6at5alfy.isChecked) {
                            ch15.text = "فك بلاطات امامي و خلفي"
                            bindingBL6.s3erBala6at.setText("20")
                        } else {

                            if (bindingBL6.fakBala6at5alfy.isChecked && bindingBL6.gyarBala6at2mamy.isChecked) {
                                ch15.text = "فك بلاطات خلفي و غيار امامي"
                                bindingBL6.s3erBala6at.setText("20")
                            } else {
                                if (bindingBL6.fakBala6at5alfy.isChecked) {
                                    ch15.text = "فك بلاطات خلفي"
                                    bindingBL6.s3erBala6at.setText("10")
                                }
                                if (bindingBL6.fakBala6at2mamy.isChecked) {
                                    ch15.text = "فك بلاطات امامي"
                                    bindingBL6.s3erBala6at.setText("10")
                                }
                            }
                        }
                    }


                    bindingBL6.btnBala6atSav.setOnClickListener {
                        if (!bindingBL6.gyarBala6at2mamy.isChecked && !bindingBL6.gyarBala6at5alfy.isChecked
                            && !bindingBL6.fakBala6at2mamy.isChecked && !bindingBL6.fakBala6at5alfy.isChecked
                        ) {
                            toast_notempty1.show()
                        } else {
                            if (bindingBL6.s3erBala6at.text.toString().trim()
                                    .isEmpty()
                            ) {
                                toast_notempty.show()
                            } else {
                                pric15.text =
                                    bindingBL6.s3erBala6at.text.toString()
                                hy2ahModel.totalAmount += pric15.text.toString()
                                    .toInt()
                                toolbar?.title = hy2ahModel.totalAmount.toString()
                                hy2ahModel.ch15 = ch15.text.toString().trim()
                                hy2ahModel.pric15 = pric15.text.toString().trim()
                                bindingBL6.gyarBala6at2mamy.isEnabled=true
                                bindingBL6.gyarBala6at5alfy.isEnabled=true
                                bindingBL6.fakBala6at5alfy.isEnabled=true
                                bindingBL6.fakBala6at2mamy.isEnabled=true

                                customDialogBL6.dismiss()
                            }
                        }
                    }
                    bindingBL6.btnBala6atCan.setOnClickListener {
                        if (pric15.text.toString().isEmpty()) {
                            ch15.text = "بلاطات"
                            ch15.isChecked = false
                        }
                        customDialogBL6.dismiss()
                    }


                    bindingBL6.gyarBala6at2mamy.isChecked = false
                    bindingBL6.gyarBala6at5alfy.isChecked = false
                    bindingBL6.fakBala6at2mamy.isChecked = false
                    bindingBL6.fakBala6at5alfy.isChecked = false
                    bindingBL6.gyarBala6at2mamy.isEnabled=true
                    bindingBL6.gyarBala6at5alfy.isEnabled=true
                    bindingBL6.fakBala6at5alfy.isEnabled=true
                    bindingBL6.fakBala6at2mamy.isEnabled=true

                    customDialogBL6.show()


                } else {
                    if (pric15.text.toString().isNotEmpty()) {
                        hy2ahModel.totalAmount -= pric15.text.toString().toInt()
                        toolbar?.title = hy2ahModel.totalAmount.toString()
                        ch15.text = "بلاطات"
                        pric15.setText("")
                        hy2ahModel.ch15 = ""
                        hy2ahModel.pric15 = ""
                    } else {
                        ch15.text = "بلاطات"
                    }
                }
            }
        }


        binding.apply{
            ch16.setOnCheckedChangeListener { _, isChecked ->
                if (ch16.isChecked) {

                    bindingF79.s3erYadweeFa7.setText("40")

                    bindingF79.btnSvDigFa7.setOnClickListener {
                        if (bindingF79.s3erYadweeFa7.text.toString().isEmpty()) {
                            toast_notempty.show()
                        } else {
                            pric16.text = bindingF79.s3erYadweeFa7.text.toString()
                            hy2ahModel.totalAmount += pric16.text.toString().toInt()
                            toolbar?.title =  hy2ahModel.totalAmount.toString()
                            hy2ahModel.ch16 = ch16.text.toString().trim()
                            hy2ahModel.pric16 = pric16.text.toString().trim()
                            customDialogF79.dismiss()
                        }
                    }

                    customDialogF79.show()

                } else {
                    hy2ahModel.totalAmount -= pric16.text.toString().toInt()
                    toolbar?.title =  hy2ahModel.totalAmount.toString()
                    pric16.text = ""
                    hy2ahModel.ch16 =  ""
                    hy2ahModel.pric16 =  ""
                }
            }
        }

       binding.apply {
           ch17.setOnCheckedChangeListener { _, isChecked ->
               if (ch17.isChecked) {
                   bindingF79.s3erYadweeFa7.setText("3")
                   bindingF79.btnSvDigFa7.setOnClickListener {
                       if (bindingF79.s3erYadweeFa7.text.toString().isEmpty()) {
                           toast_notempty.show()
                       } else {
                           pric17.text = bindingF79.s3erYadweeFa7.text.toString()
                           hy2ahModel.totalAmount += pric17.text.toString().toInt()
                           toolbar?.title = hy2ahModel.totalAmount.toString()
                           hy2ahModel.ch17 = ch17.text.toString().trim()
                           hy2ahModel.pric17 = pric17.text.toString().trim()
                           customDialogF79.dismiss()
                       }
                   }
                   customDialogF79.show()

               } else {
                   hy2ahModel.totalAmount -= pric17.text.toString().toInt()
                   toolbar?.title = hy2ahModel.totalAmount.toString()
                   pric17.text = ""
                   hy2ahModel.ch17 = ""
                   hy2ahModel.pric17 = ""
               }
           }
       }

        binding.apply{
            ch18.setOnCheckedChangeListener { _, isChecked ->
                if (ch18.isChecked) {

                    bindingF79.s3erYadweeFa7.setText("3")

                    bindingF79.btnSvDigFa7.setOnClickListener {
                        if (bindingF79.s3erYadweeFa7.text.toString().isEmpty()) {
                            toast_notempty.show()
                        } else {
                            pric18.text = bindingF79.s3erYadweeFa7.text.toString()
                            hy2ahModel.totalAmount += pric18.text.toString().toInt()
                            toolbar?.title =  hy2ahModel.totalAmount.toString()
                            hy2ahModel.ch18 = ch18.text.toString().trim()
                            hy2ahModel.pric18 = pric18.text.toString().trim()
                            customDialogF79.dismiss()
                        }
                    }
                    customDialogF79.show()

                } else {
                    hy2ahModel.totalAmount -= pric18.text.toString().toInt()
                    toolbar?.title =  hy2ahModel.totalAmount.toString()
                    pric18.text = ""
                    hy2ahModel.ch18 =  ""
                    hy2ahModel.pric18 =  ""
                }
            }
        }

        binding.apply{
            ch19.setOnCheckedChangeListener { _, isChecked ->
                if (ch19.isChecked) {

                    customDialogR2SX.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
                    bindingR2.titR2sOut.text="امامي"
                    bindingR2.titR2sIn.text="خلفي"


                    bindingR2.cardR2s2ks.setOnTouchListener { _, event ->
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

                    bindingR2.outsideright.setOnCheckedChangeListener { _, isChecked1 ->

                        if (bindingR2.outsideright.isChecked) {
                            ch19.text = "حساس (ABS) امامي يمين"
                        } else {
                            ch19.text = "حساس (ABS)"
                            bindingR2.s3erR2sAcx.setText("")
                        }

                        if (bindingR2.outsideright.isChecked && bindingR2.outsideleft.isChecked && bindingR2.insideright.isChecked && bindingR2.insideleft.isChecked) {
                            ch19.text = "تغير جميع حساسات (ABS) "
                            bindingR2.s3erR2sAcx.setText("12")
                        } else {
                            if (bindingR2.outsideright.isChecked && bindingR2.outsideleft.isChecked && bindingR2.insideright.isChecked) {
                                ch19.text = "حساس (ABS) امامي كامل و الخلفي يمين"
                                bindingR2.s3erR2sAcx.setText("9")
                            } else {
                                if (bindingR2.outsideright.isChecked && bindingR2.outsideleft.isChecked && bindingR2.insideleft.isChecked) {
                                    ch19.text = "حساس (ABS) امامي كامل و الخلفي يسار"
                                    bindingR2.s3erR2sAcx.setText("9")
                                } else {
                                    if (bindingR2.outsideright.isChecked && bindingR2.insideright.isChecked && bindingR2.insideleft.isChecked) {
                                        ch19.text = "حساس (ABS) امامي يمين و الخلفيين"
                                        bindingR2.s3erR2sAcx.setText("9")
                                    } else {
                                        if (bindingR2.outsideleft.isChecked && bindingR2.insideright.isChecked && bindingR2.insideleft.isChecked) {
                                            ch19.text = "حساس (ABS) امامي يسار و الخلفيين"
                                            bindingR2.s3erR2sAcx.setText("9")
                                        } else {
                                            if (bindingR2.outsideright.isChecked && bindingR2.outsideleft.isChecked) {
                                                ch19.text = "حساس (ABS) امامي يمين و يسار"
                                                bindingR2.s3erR2sAcx.setText("6")
                                            } else {
                                                if (bindingR2.outsideright.isChecked && bindingR2.insideright.isChecked) {
                                                    ch19.text = "حساس (ABS) امامي يمين و الخلفي يمين"
                                                    bindingR2.s3erR2sAcx.setText("6")
                                                } else {
                                                    if (bindingR2.outsideright.isChecked && bindingR2.insideleft.isChecked) {
                                                        ch19.text = "حساس (ABS) امامي يمين و الخلفي يسار"
                                                        bindingR2.s3erR2sAcx.setText("6")
                                                    } else {
                                                        if (bindingR2.outsideleft.isChecked && bindingR2.insideright.isChecked) {
                                                            ch19.text =
                                                                "حساس (ABS) امامي يسار و الخلفي يمين"
                                                            bindingR2.s3erR2sAcx.setText("6")
                                                        } else {
                                                            if (bindingR2.outsideleft.isChecked && bindingR2.insideleft.isChecked) {
                                                                ch19.text =
                                                                    "حساس (ABS) امامي يسار و الخلفي يسار"
                                                                bindingR2.s3erR2sAcx.setText("6")
                                                            } else {
                                                                if (bindingR2.insideright.isChecked && bindingR2.insideleft.isChecked) {
                                                                    ch19.text =
                                                                        "حساس (ABS) خلفي يمين و يسار"
                                                                    bindingR2.s3erR2sAcx.setText(
                                                                        "6"
                                                                    )
                                                                } else {

                                                                    if (bindingR2.outsideright.isChecked) {
                                                                        ch19.text =
                                                                            "حساس (ABS) امامي يمين"
                                                                        bindingR2.s3erR2sAcx.setText(
                                                                            "3"
                                                                        )
                                                                    }
                                                                    if (bindingR2.outsideleft.isChecked) {
                                                                        ch19.text =
                                                                            "حساس (ABS) امامي يسار"
                                                                        bindingR2.s3erR2sAcx.setText(
                                                                            "3"
                                                                        )
                                                                    }

                                                                    if (bindingR2.insideleft.isChecked) {
                                                                        ch19.text =
                                                                            "حساس (ABS) خلفي يسار"
                                                                        bindingR2.s3erR2sAcx.setText(
                                                                            "3"
                                                                        )
                                                                    }
                                                                    if (bindingR2.insideright.isChecked) {
                                                                        ch19.text =
                                                                            "حساس (ABS) خلفي يمين"
                                                                        bindingR2.s3erR2sAcx.setText(
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

                    bindingR2.outsideleft.setOnCheckedChangeListener { _, isChecked2 ->
                        if (bindingR2.outsideleft.isChecked) {
                            ch19.text = "حساس (ABS) امامي يمين"
                        } else {
                            ch19.text = "حساس (ABS)"
                            bindingR2.s3erR2sAcx.setText("")
                        }

                        if (bindingR2.outsideright.isChecked && bindingR2.outsideleft.isChecked && bindingR2.insideright.isChecked && bindingR2.insideleft.isChecked) {
                            ch19.text = "تغير جميع حساسات (ABS) "
                            bindingR2.s3erR2sAcx.setText("12")
                        } else {
                            if (bindingR2.outsideright.isChecked && bindingR2.outsideleft.isChecked && bindingR2.insideright.isChecked) {
                                ch19.text = "حساس (ABS) امامي كامل و الخلفي يمين"
                                bindingR2.s3erR2sAcx.setText("9")
                            } else {
                                if (bindingR2.outsideright.isChecked && bindingR2.outsideleft.isChecked && bindingR2.insideleft.isChecked) {
                                    ch19.text = "حساس (ABS) امامي كامل و الخلفي يسار"
                                    bindingR2.s3erR2sAcx.setText("9")
                                } else {
                                    if (bindingR2.outsideright.isChecked && bindingR2.insideright.isChecked && bindingR2.insideleft.isChecked) {
                                        ch19.text = "حساس (ABS) امامي يمين و الخلفيين"
                                        bindingR2.s3erR2sAcx.setText("9")
                                    } else {
                                        if (bindingR2.outsideleft.isChecked && bindingR2.insideright.isChecked && bindingR2.insideleft.isChecked) {
                                            ch19.text = "حساس (ABS) امامي يسار و الخلفيين"
                                            bindingR2.s3erR2sAcx.setText("9")
                                        } else {
                                            if (bindingR2.outsideright.isChecked && bindingR2.outsideleft.isChecked) {
                                                ch19.text = "حساس (ABS) امامي يمين و يسار"
                                                bindingR2.s3erR2sAcx.setText("6")
                                            } else {
                                                if (bindingR2.outsideright.isChecked && bindingR2.insideright.isChecked) {
                                                    ch19.text = "حساس (ABS) امامي يمين و الخلفي يمين"
                                                    bindingR2.s3erR2sAcx.setText("6")
                                                } else {
                                                    if (bindingR2.outsideright.isChecked && bindingR2.insideleft.isChecked) {
                                                        ch19.text = "حساس (ABS) امامي يمين و الخلفي يسار"
                                                        bindingR2.s3erR2sAcx.setText("6")
                                                    } else {
                                                        if (bindingR2.outsideleft.isChecked && bindingR2.insideright.isChecked) {
                                                            ch19.text =
                                                                "حساس (ABS) امامي يسار و الخلفي يمين"
                                                            bindingR2.s3erR2sAcx.setText("6")
                                                        } else {
                                                            if (bindingR2.outsideleft.isChecked && bindingR2.insideleft.isChecked) {
                                                                ch19.text =
                                                                    "حساس (ABS) امامي يسار و الخلفي يسار"
                                                                bindingR2.s3erR2sAcx.setText("6")
                                                            } else {
                                                                if (bindingR2.insideright.isChecked && bindingR2.insideleft.isChecked) {
                                                                    ch19.text =
                                                                        "حساس (ABS) خلفي يمين و يسار"
                                                                    bindingR2.s3erR2sAcx.setText(
                                                                        "6"
                                                                    )
                                                                } else {

                                                                    if (bindingR2.outsideright.isChecked) {
                                                                        ch19.text =
                                                                            "حساس (ABS) امامي يمين"
                                                                        bindingR2.s3erR2sAcx.setText(
                                                                            "3"
                                                                        )
                                                                    }
                                                                    if (bindingR2.outsideleft.isChecked) {
                                                                        ch19.text =
                                                                            "حساس (ABS) امامي يسار"
                                                                        bindingR2.s3erR2sAcx.setText(
                                                                            "3"
                                                                        )
                                                                    }

                                                                    if (bindingR2.insideleft.isChecked) {
                                                                        ch19.text =
                                                                            "حساس (ABS) خلفي يسار"
                                                                        bindingR2.s3erR2sAcx.setText(
                                                                            "3"
                                                                        )
                                                                    }
                                                                    if (bindingR2.insideright.isChecked) {
                                                                        ch19.text =
                                                                            "حساس (ABS) خلفي يمين"
                                                                        bindingR2.s3erR2sAcx.setText(
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



                    bindingR2.insideleft.setOnCheckedChangeListener { _, isChecked2 ->
                        if (bindingR2.outsideright.isChecked) {
                            ch19.text = "حساس (ABS) امامي يمين"
                        } else {
                            ch19.text = "حساس (ABS)"
                            bindingR2.s3erR2sAcx.setText("")
                        }

                        if (bindingR2.outsideright.isChecked && bindingR2.outsideleft.isChecked && bindingR2.insideright.isChecked && bindingR2.insideleft.isChecked) {
                            ch19.text = "تغير جميع حساسات (ABS) "
                            bindingR2.s3erR2sAcx.setText("12")
                        } else {
                            if (bindingR2.outsideright.isChecked && bindingR2.outsideleft.isChecked && bindingR2.insideright.isChecked) {
                                ch19.text = "حساس (ABS) امامي كامل و الخلفي يمين"
                                bindingR2.s3erR2sAcx.setText("9")
                            } else {
                                if (bindingR2.outsideright.isChecked && bindingR2.outsideleft.isChecked && bindingR2.insideleft.isChecked) {
                                    ch19.text = "حساس (ABS) امامي كامل و الخلفي يسار"
                                    bindingR2.s3erR2sAcx.setText("9")
                                } else {
                                    if (bindingR2.outsideright.isChecked && bindingR2.insideright.isChecked && bindingR2.insideleft.isChecked) {
                                        ch19.text = "حساس (ABS) امامي يمين و الخلفيين"
                                        bindingR2.s3erR2sAcx.setText("9")
                                    } else {
                                        if (bindingR2.outsideleft.isChecked && bindingR2.insideright.isChecked && bindingR2.insideleft.isChecked) {
                                            ch19.text = "حساس (ABS) امامي يسار و الخلفيين"
                                            bindingR2.s3erR2sAcx.setText("9")
                                        } else {
                                            if (bindingR2.outsideright.isChecked && bindingR2.outsideleft.isChecked) {
                                                ch19.text = "حساس (ABS) امامي يمين و يسار"
                                                bindingR2.s3erR2sAcx.setText("6")
                                            } else {
                                                if (bindingR2.outsideright.isChecked && bindingR2.insideright.isChecked) {
                                                    ch19.text = "حساس (ABS) امامي يمين و الخلفي يمين"
                                                    bindingR2.s3erR2sAcx.setText("6")
                                                } else {
                                                    if (bindingR2.outsideright.isChecked && bindingR2.insideleft.isChecked) {
                                                        ch19.text = "حساس (ABS) امامي يمين و الخلفي يسار"
                                                        bindingR2.s3erR2sAcx.setText("6")
                                                    } else {
                                                        if (bindingR2.outsideleft.isChecked && bindingR2.insideright.isChecked) {
                                                            ch19.text =
                                                                "حساس (ABS) امامي يسار و الخلفي يمين"
                                                            bindingR2.s3erR2sAcx.setText("6")
                                                        } else {
                                                            if (bindingR2.outsideleft.isChecked && bindingR2.insideleft.isChecked) {
                                                                ch19.text =
                                                                    "حساس (ABS) امامي يسار و الخلفي يسار"
                                                                bindingR2.s3erR2sAcx.setText("6")
                                                            } else {
                                                                if (bindingR2.insideright.isChecked && bindingR2.insideleft.isChecked) {
                                                                    ch19.text =
                                                                        "حساس (ABS) خلفي يمين و يسار"
                                                                    bindingR2.s3erR2sAcx.setText(
                                                                        "6"
                                                                    )
                                                                } else {

                                                                    if (bindingR2.outsideright.isChecked) {
                                                                        ch19.text =
                                                                            "حساس (ABS) امامي يمين"
                                                                        bindingR2.s3erR2sAcx.setText(
                                                                            "3"
                                                                        )
                                                                    }
                                                                    if (bindingR2.outsideleft.isChecked) {
                                                                        ch19.text =
                                                                            "حساس (ABS) امامي يسار"
                                                                        bindingR2.s3erR2sAcx.setText(
                                                                            "3"
                                                                        )
                                                                    }

                                                                    if (bindingR2.insideleft.isChecked) {
                                                                        ch19.text =
                                                                            "حساس (ABS) خلفي يسار"
                                                                        bindingR2.s3erR2sAcx.setText(
                                                                            "3"
                                                                        )
                                                                    }
                                                                    if (bindingR2.insideright.isChecked) {
                                                                        ch19.text =
                                                                            "حساس (ABS) خلفي يمين"
                                                                        bindingR2.s3erR2sAcx.setText(
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

                    bindingR2.insideright.setOnCheckedChangeListener { _, isChecked2 ->
                        if (bindingR2.insideright.isChecked) {
                            ch19.text = "حساس (ABS) امامي يمين"
                        } else {
                            ch19.text = "حساس (ABS)"
                            bindingR2.s3erR2sAcx.setText("")
                        }

                        if (bindingR2.outsideright.isChecked && bindingR2.outsideleft.isChecked && bindingR2.insideright.isChecked && bindingR2.insideleft.isChecked) {
                            ch19.text = "تغير جميع حساسات (ABS) "
                            bindingR2.s3erR2sAcx.setText("12")
                        } else {
                            if (bindingR2.outsideright.isChecked && bindingR2.outsideleft.isChecked && bindingR2.insideright.isChecked) {
                                ch19.text = "حساس (ABS) امامي كامل و الخلفي يمين"
                                bindingR2.s3erR2sAcx.setText("9")
                            } else {
                                if (bindingR2.outsideright.isChecked && bindingR2.outsideleft.isChecked && bindingR2.insideleft.isChecked) {
                                    ch19.text = "حساس (ABS) امامي كامل و الخلفي يسار"
                                    bindingR2.s3erR2sAcx.setText("9")
                                } else {
                                    if (bindingR2.outsideright.isChecked && bindingR2.insideright.isChecked && bindingR2.insideleft.isChecked) {
                                        ch19.text = "حساس (ABS) امامي يمين و الخلفيين"
                                        bindingR2.s3erR2sAcx.setText("9")
                                    } else {
                                        if (bindingR2.outsideleft.isChecked && bindingR2.insideright.isChecked && bindingR2.insideleft.isChecked) {
                                            ch19.text = "حساس (ABS) امامي يسار و الخلفيين"
                                            bindingR2.s3erR2sAcx.setText("9")
                                        } else {
                                            if (bindingR2.outsideright.isChecked && bindingR2.outsideleft.isChecked) {
                                                ch19.text = "حساس (ABS) امامي يمين و يسار"
                                                bindingR2.s3erR2sAcx.setText("6")
                                            } else {
                                                if (bindingR2.outsideright.isChecked && bindingR2.insideright.isChecked) {
                                                    ch19.text = "حساس (ABS) امامي يمين و الخلفي يمين"
                                                    bindingR2.s3erR2sAcx.setText("6")
                                                } else {
                                                    if (bindingR2.outsideright.isChecked && bindingR2.insideleft.isChecked) {
                                                        ch19.text = "حساس (ABS) امامي يمين و الخلفي يسار"
                                                        bindingR2.s3erR2sAcx.setText("6")
                                                    } else {
                                                        if (bindingR2.outsideleft.isChecked && bindingR2.insideright.isChecked) {
                                                            ch19.text =
                                                                "حساس (ABS) امامي يسار و الخلفي يمين"
                                                            bindingR2.s3erR2sAcx.setText("6")
                                                        } else {
                                                            if (bindingR2.outsideleft.isChecked && bindingR2.insideleft.isChecked) {
                                                                ch19.text =
                                                                    "حساس (ABS) امامي يسار و الخلفي يسار"
                                                                bindingR2.s3erR2sAcx.setText("6")
                                                            } else {
                                                                if (bindingR2.insideright.isChecked && bindingR2.insideleft.isChecked) {
                                                                    ch19.text =
                                                                        "حساس (ABS) خلفي يمين و يسار"
                                                                    bindingR2.s3erR2sAcx.setText(
                                                                        "6"
                                                                    )
                                                                } else {

                                                                    if (bindingR2.outsideright.isChecked) {
                                                                        ch19.text =
                                                                            "حساس (ABS) امامي يمين"
                                                                        bindingR2.s3erR2sAcx.setText(
                                                                            "3"
                                                                        )
                                                                    }
                                                                    if (bindingR2.outsideleft.isChecked) {
                                                                        ch19.text =
                                                                            "حساس (ABS) امامي يسار"
                                                                        bindingR2.s3erR2sAcx.setText(
                                                                            "3"
                                                                        )
                                                                    }

                                                                    if (bindingR2.insideleft.isChecked) {
                                                                        ch19.text =
                                                                            "حساس (ABS) خلفي يسار"
                                                                        bindingR2.s3erR2sAcx.setText(
                                                                            "3"
                                                                        )
                                                                    }
                                                                    if (bindingR2.insideright.isChecked) {
                                                                        ch19.text =
                                                                            "حساس (ABS) خلفي يمين"
                                                                        bindingR2.s3erR2sAcx.setText(
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


                    bindingR2.btnR2sSav.setOnClickListener {
                        if (!bindingR2.outsideright.isChecked && !bindingR2.outsideleft.isChecked
                            && !bindingR2.insideright.isChecked && !bindingR2.insideleft.isChecked
                        ) {
                            toast_notempty1.show()
                        } else {
                            if (bindingR2.s3erR2sAcx.text.toString().trim().isEmpty()) {
                                toast_notempty.show()
                            } else {
                                pric19.text = bindingR2.s3erR2sAcx.text.toString()
                                hy2ahModel.totalAmount += pric19.text.toString().toInt()
                                toolbar?.title =  hy2ahModel.totalAmount.toString()
                                hy2ahModel.ch19 = ch19.text.toString().trim()
                                hy2ahModel.pric19 = pric19.text.toString().trim()
                                customDialogR2SX.dismiss()
                            }
                        }
                    }
                    bindingR2.btnR2sCan.setOnClickListener {
                        if (pric19.text.toString().isEmpty()) {
                            ch19.text = "حساس (ABS)"
                            ch19.isChecked = false
                        }
                        customDialogR2SX.dismiss()
                    }
                    bindingR2.outsideright.isChecked = false
                    bindingR2.outsideleft.isChecked = false
                    bindingR2.insideright.isChecked = false
                    bindingR2.insideleft.isChecked = false
                    customDialogR2SX.show()

                } else {
                    if (pric19.text.toString().isNotEmpty()) {
                        hy2ahModel.totalAmount -= pric19.text.toString().toInt()
                        toolbar?.title =  hy2ahModel.totalAmount.toString()
                        ch19.text = "حساس (ABS)"
                        pric19.setText("")
                        hy2ahModel.ch19 =  ""
                        hy2ahModel.pric19 =  ""
                    } else {
                        ch19.text = "حساس (ABS)"
                    }
                }
            }
        }

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}