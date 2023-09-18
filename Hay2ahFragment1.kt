package com.example.markizalhadidi.ui.hay2ah

import android.app.Dialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.net.ConnectivityManager
import android.os.Bundle
import android.text.Editable
import android.text.SpannableString
import android.text.TextWatcher
import android.text.style.AbsoluteSizeSpan
import android.text.style.ForegroundColorSpan
import android.view.*
import android.widget.CheckBox
import android.widget.TextView
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
import com.example.markizalhadidi.ui.estqbal.EstqbalViewModel
import com.google.firebase.firestore.FieldValue
import com.google.firebase.firestore.FirebaseFirestore

class  Hay2ahFragment1 : Fragment() {

    private var _binding: FragmentHay2ah1Binding? = null
    private val binding get() = _binding!!

    private lateinit var bindingtoolbar: ActivityMainBinding

    private lateinit var hy2ahModel: Hay2ahViewModel
    private lateinit var viewModeleEstqbal: EstqbalViewModel
    private val firestoreInstance: FirebaseFirestore by lazy { FirebaseFirestore.getInstance() }
    private val chatChannelsCollectionRef = firestoreInstance.collection("chatChannels")

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
            activity?.run {
                ViewModelProvider(this).get(Hay2ahViewModel::class.java)
            } ?: throw Exception("Invalid Activity")

        viewModeleEstqbal = activity?.run {
            ViewModelProvider(this).get(EstqbalViewModel::class.java)
        } ?: throw Exception("Invalid Activity")

        _binding = FragmentHay2ah1Binding.inflate(inflater, container, false)
        val root: View = binding.root

        bindingtoolbar = ActivityMainBinding.inflate(layoutInflater)

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

        binding.ch1.setOnCheckedChangeListener { _, isChecked ->
            if (binding.ch1.isChecked) {
                bindingR2.titR2sOut.text = "خارجية"
                bindingR2.titR2sIn.text = "داخلية"
                bindingR2.outsideright.setOnCheckedChangeListener { _, isChecked1 ->

                    if (bindingR2.outsideright.isChecked) {
                        binding.ch1.text = "راسية اكس خارجية يمين"
                    }else{binding.ch1.text = "راسية اكس"
                        bindingR2.s3erR2sAcx.setText("")}

                    if (bindingR2.outsideright.isChecked && bindingR2.outsideleft.isChecked && bindingR2.insideright.isChecked && bindingR2.insideleft.isChecked) {
                        binding.ch1.text = "تغير جميع الرأسيات الخارجية و الداخلية"
                        bindingR2.s3erR2sAcx.setText("40")
                    } else {
                        if (bindingR2.outsideright.isChecked && bindingR2.outsideleft.isChecked && bindingR2.insideright.isChecked) {
                            binding.ch1.text = "راسيتين اكس خارجية و الداخلية يمين"
                            bindingR2.s3erR2sAcx.setText("30")
                        }else {
                            if (bindingR2.outsideright.isChecked && bindingR2.outsideleft.isChecked && bindingR2.insideleft.isChecked) {
                                binding.ch1.text = "راسيتين اكس خارجية و الداخلية يسار"
                                bindingR2.s3erR2sAcx.setText("30")
                            }else {
                                if (bindingR2.outsideright.isChecked && bindingR2.insideright.isChecked && bindingR2.insideleft.isChecked) {
                                    binding.ch1.text = "راسية اكس خارجية يمين و الداخليتين"
                                    bindingR2.s3erR2sAcx.setText("30")
                                }else {
                                    if (bindingR2.outsideleft.isChecked && bindingR2.insideright.isChecked && bindingR2.insideleft.isChecked) {
                                        binding.ch1.text = "راسية اكس خارجية يسار و الداخليتين"
                                        bindingR2.s3erR2sAcx.setText("30")
                                    }else {
                                        if (bindingR2.outsideright.isChecked && bindingR2.outsideleft.isChecked) {
                                            binding.ch1.text = "راسية اكس خارجية يمين و يسار"
                                            bindingR2.s3erR2sAcx.setText("20")
                                        }else {
                                            if (bindingR2.outsideright.isChecked && bindingR2.insideright.isChecked) {
                                                binding.ch1.text = "راسية اكس خارجية يمين و داخلية يمين"
                                                bindingR2.s3erR2sAcx.setText("20")
                                            }else {
                                                if (bindingR2.outsideright.isChecked && bindingR2.insideleft.isChecked) {
                                                    binding.ch1.text = "راسية اكس خارجية يمين و داخلية يسار"
                                                    bindingR2.s3erR2sAcx.setText("20")
                                                }else {
                                                    if (bindingR2.outsideleft.isChecked && bindingR2.insideright.isChecked) {
                                                        binding.ch1.text = "راسية اكس خارجية يسار و داخلية يمين"
                                                        bindingR2.s3erR2sAcx.setText("20")
                                                    }else {
                                                        if (bindingR2.outsideleft.isChecked && bindingR2.insideleft.isChecked) {
                                                            binding.ch1.text = "راسية اكس خارجية يسار و داخلية يسار"
                                                            bindingR2.s3erR2sAcx.setText("20")
                                                        }else {
                                                            if (bindingR2.insideright.isChecked && bindingR2.insideleft.isChecked) {
                                                                binding.ch1.text = "راسية اكس داخلية يمين و يسار"
                                                                bindingR2.s3erR2sAcx.setText("20")
                                                            } else {

                                                                if (bindingR2.outsideright.isChecked) {
                                                                    binding.ch1.text = "راسية اكس خارجية يمين"
                                                                    bindingR2.s3erR2sAcx.setText("10")
                                                                }
                                                                if (bindingR2.outsideleft.isChecked) {
                                                                    binding.ch1.text = "راسية اكس خارجية يسار"
                                                                    bindingR2.s3erR2sAcx.setText("10")
                                                                }

                                                                if (bindingR2.insideleft.isChecked) {
                                                                    binding.ch1.text = "راسية اكس داخلية يسار"
                                                                    bindingR2.s3erR2sAcx.setText("10")
                                                                }
                                                                if (bindingR2.insideright.isChecked) {
                                                                    binding.ch1.text = "راسية اكس داخلية يمين"
                                                                    bindingR2.s3erR2sAcx.setText("10")
                                                                }
                                                            }
                                                        }
                                                    }}}}}}}}}
                    customDialogR2SX.show()
                }

                bindingR2.outsideleft.setOnCheckedChangeListener { _, isChecked2 ->
                    if (bindingR2.outsideleft.isChecked) {
                        binding.ch1.text = "راسية اكس خارجية يسار"
                    }else{binding.ch1.text = "راسية اكس"
                        bindingR2.s3erR2sAcx.setText("")}

                    if (bindingR2.outsideright.isChecked && bindingR2.outsideleft.isChecked && bindingR2.insideright.isChecked && bindingR2.insideleft.isChecked ) {
                        binding.ch1.text = "تغير جميع الرأسيات الخارجية و الداخلية"
                        bindingR2.s3erR2sAcx.setText("40")
                    }else{
                        if (bindingR2.outsideleft.isChecked && bindingR2.outsideright.isChecked && bindingR2.insideright.isChecked ) {
                            binding.ch1.text = "راسيتين اكس خارجية و الداخلية يمين"
                            bindingR2.s3erR2sAcx.setText("30")
                        }else{
                            if (bindingR2.outsideleft.isChecked && bindingR2.outsideright.isChecked && bindingR2.insideleft.isChecked ) {
                                binding.ch1.text = "راسيتين اكس خارجية و الداخلية يسار"
                                bindingR2.s3erR2sAcx.setText("30")
                            }else{
                                if (bindingR2.outsideright.isChecked && bindingR2.insideright.isChecked && bindingR2.insideleft.isChecked ) {
                                    binding.ch1.text = "راسية اكس خارجية يمين و الداخليتين"
                                    bindingR2.s3erR2sAcx.setText("30")
                                }else{
                                    if (bindingR2.outsideleft.isChecked && bindingR2.insideright.isChecked && bindingR2.insideleft.isChecked ) {
                                        binding.ch1.text = "راسية اكس خارجية يسار و الداخليتين"
                                        bindingR2.s3erR2sAcx.setText("30")
                                    }else{
                                        if (bindingR2.outsideleft.isChecked && bindingR2.outsideright.isChecked) {
                                            binding.ch1.text = "راسية اكس خارجية يمين و يسار"
                                            bindingR2.s3erR2sAcx.setText("20")
                                        }else{
                                            if (bindingR2.outsideright.isChecked && bindingR2.insideright.isChecked) {
                                                binding.ch1.text = "راسية اكس خارجية يمين و داخلية يمين"
                                                bindingR2.s3erR2sAcx.setText("20")
                                            }else{
                                                if (bindingR2.outsideright.isChecked && bindingR2.insideleft.isChecked) {
                                                    binding.ch1.text = "راسية اكس خارجية يمين و داخلية يسار"
                                                    bindingR2.s3erR2sAcx.setText("20")
                                                }else{
                                                    if (bindingR2.outsideleft.isChecked && bindingR2.insideright.isChecked) {
                                                        binding.ch1.text = "راسية اكس خارجية يسار و داخلية يمين"
                                                        bindingR2.s3erR2sAcx.setText("20")
                                                    }else{
                                                        if (bindingR2.outsideleft.isChecked && bindingR2.insideleft.isChecked) {
                                                            binding.ch1.text = "راسية اكس خارجية يسار و داخلية يسار"
                                                            bindingR2.s3erR2sAcx.setText("20")
                                                        }else{
                                                            if (bindingR2.insideright.isChecked && bindingR2.insideleft.isChecked) {
                                                                binding.ch1.text = "راسية اكس داخلية يمين و يسار"
                                                                bindingR2.s3erR2sAcx.setText("20")
                                                            } else {

                                                                if (bindingR2.outsideleft.isChecked) {
                                                                    binding.ch1.text = "راسية اكس خارجية يسار"
                                                                    bindingR2.s3erR2sAcx.setText("10")
                                                                }

                                                                if (bindingR2.outsideright.isChecked) {
                                                                    binding.ch1.text = "راسية اكس خارجية يمين"
                                                                    bindingR2.s3erR2sAcx.setText("10")
                                                                }

                                                                if (bindingR2.insideleft.isChecked) {
                                                                    binding.ch1.text = "راسية اكس داخلية يسار"
                                                                    bindingR2.s3erR2sAcx.setText("10")
                                                                }
                                                                if (bindingR2.insideright.isChecked) {
                                                                    binding.ch1.text = "راسية اكس داخلية يمين"
                                                                    bindingR2.s3erR2sAcx.setText("10")
                                                                }
                                                            }
                                                        }
                                                    }}}}}}}}}
                    customDialogR2SX.show()
                }

                bindingR2.insideleft.setOnCheckedChangeListener { _, isChecked2 ->
                    if (bindingR2.insideleft.isChecked) {
                        binding.ch1.text = "راسية اكس داخلية يسار"
                    }else{binding.ch1.text = "راسية اكس"
                        bindingR2.s3erR2sAcx.setText("")}

                    if (bindingR2.outsideright.isChecked && bindingR2.outsideleft.isChecked && bindingR2.insideright.isChecked && bindingR2.insideleft.isChecked ) {
                        binding.ch1.text = "تغير جميع الرأسيات الخارجية و الداخلية"
                        bindingR2.s3erR2sAcx.setText("40")
                    }else {
                        if (bindingR2.outsideright.isChecked && bindingR2.outsideleft.isChecked && bindingR2.insideright.isChecked ) {
                            binding.ch1.text = "راسيتين اكس خارجية و الداخلية يمين"
                            bindingR2.s3erR2sAcx.setText("30")
                        }else {
                            if (bindingR2.insideleft.isChecked && bindingR2.outsideleft.isChecked && bindingR2.outsideright.isChecked) {
                                binding.ch1.text = "راسيتين اكس خارجية و الداخلية يسار"
                                bindingR2.s3erR2sAcx.setText("30")
                            }else {
                                if (bindingR2.insideleft.isChecked && bindingR2.insideright.isChecked && bindingR2.outsideright.isChecked) {
                                    binding.ch1.text = "راسية اكس خارجية يمين و الداخليتين"
                                    bindingR2.s3erR2sAcx.setText("30")
                                }else {
                                    if (bindingR2.insideleft.isChecked && bindingR2.insideright.isChecked && bindingR2.outsideleft.isChecked) {
                                        binding.ch1.text = "راسية اكس خارجية يسار و الداخليتين"
                                        bindingR2.s3erR2sAcx.setText("30")
                                    }else {
                                        if (bindingR2.outsideright.isChecked && bindingR2.outsideleft.isChecked) {
                                            binding.ch1.text = "راسية اكس خارجية يمين و يسار"
                                            bindingR2.s3erR2sAcx.setText("20")
                                        }else {
                                            if (bindingR2.outsideright.isChecked && bindingR2.insideright.isChecked) {
                                                binding.ch1.text = "راسية اكس خارجية يمين و داخلية يمين"
                                                bindingR2.s3erR2sAcx.setText("20")
                                            }else {
                                                if (bindingR2.insideleft.isChecked && bindingR2.outsideright.isChecked) {
                                                    binding.ch1.text = "راسية اكس خارجية يمين و داخلية يسار"
                                                    bindingR2.s3erR2sAcx.setText("20")
                                                }else {
                                                    if (bindingR2.outsideleft.isChecked && bindingR2.insideright.isChecked) {
                                                        binding.ch1.text = "راسية اكس خارجية يسار و داخلية يمين"
                                                        bindingR2.s3erR2sAcx.setText("20")
                                                    }else {
                                                        if (bindingR2.insideleft.isChecked && bindingR2.outsideleft.isChecked) {
                                                            binding.ch1.text = "راسية اكس خارجية يسار و داخلية يسار"
                                                            bindingR2.s3erR2sAcx.setText("20")
                                                        }else {
                                                            if (bindingR2.insideleft.isChecked && bindingR2.insideright.isChecked) {
                                                                binding.ch1.text = "راسية اكس داخلية يمين و يسار"
                                                                bindingR2.s3erR2sAcx.setText("20")
                                                            } else {
                                                                if (bindingR2.insideright.isChecked) {
                                                                    binding.ch1.text = "راسية اكس داخلية يمين"
                                                                    bindingR2.s3erR2sAcx.setText("10")
                                                                }
                                                                if (bindingR2.outsideright.isChecked) {
                                                                    binding.ch1.text = "راسية اكس خارجية يمين"
                                                                    bindingR2.s3erR2sAcx.setText("10")
                                                                }
                                                                if (bindingR2.outsideleft.isChecked) {
                                                                    binding.ch1.text = "راسية اكس خارجية يسار"
                                                                    bindingR2.s3erR2sAcx.setText("10")
                                                                }

                                                                if (bindingR2.insideleft.isChecked) {
                                                                    binding.ch1.text = "راسية اكس داخلية يسار"
                                                                    bindingR2.s3erR2sAcx.setText("10")
                                                                }
                                                            }
                                                        }
                                                    }}}}}}}}}
                    customDialogR2SX.show()
                }

                bindingR2.insideright.setOnCheckedChangeListener { _, isChecked2 ->
                    if (bindingR2.insideright.isChecked) {
                        binding.ch1.text = "راسية اكس داخلية يمين"
                    }else{binding.ch1.text = "راسية اكس"
                        bindingR2.s3erR2sAcx.setText("")}

                    if (bindingR2.outsideright.isChecked && bindingR2.outsideleft.isChecked && bindingR2.insideright.isChecked && bindingR2.insideleft.isChecked ) {
                        binding.ch1.text = "تغير جميع الرأسيات الخارجية و الداخلية"
                        bindingR2.s3erR2sAcx.setText("40")
                    }else{
                        if (bindingR2.insideright.isChecked && bindingR2.outsideleft.isChecked && bindingR2.outsideright.isChecked ) {
                            binding.ch1.text = "راسيتين اكس خارجية و الداخلية يمين"
                            bindingR2.s3erR2sAcx.setText("30")
                        }else {
                            if (bindingR2.outsideright.isChecked && bindingR2.outsideleft.isChecked && bindingR2.insideleft.isChecked ) {
                                binding.ch1.text = "راسيتين اكس خارجية و الداخلية يسار"
                                bindingR2.s3erR2sAcx.setText("30")
                            }else {
                                if (bindingR2.insideright.isChecked && bindingR2.outsideright.isChecked && bindingR2.insideleft.isChecked ) {
                                    binding.ch1.text = "راسية اكس خارجية يمين و الداخليتين"
                                    bindingR2.s3erR2sAcx.setText("30")
                                }else {
                                    if (bindingR2.insideright.isChecked && bindingR2.outsideleft.isChecked && bindingR2.insideleft.isChecked ) {
                                        binding.ch1.text = "راسية اكس خارجية يسار و الداخليتين"
                                        bindingR2.s3erR2sAcx.setText("30")
                                    }else {
                                        if (bindingR2.outsideright.isChecked && bindingR2.outsideleft.isChecked ) {
                                            binding.ch1.text = "راسية اكس خارجية يمين و يسار"
                                            bindingR2.s3erR2sAcx.setText("20")
                                        }else {
                                            if (bindingR2.insideright.isChecked && bindingR2.outsideright.isChecked ) {
                                                binding.ch1.text = "راسية اكس خارجية يمين و داخلية يمين"
                                                bindingR2.s3erR2sAcx.setText("20")
                                            }else {
                                                if (bindingR2.outsideright.isChecked && bindingR2.insideleft.isChecked ) {
                                                    binding.ch1.text = "راسية اكس خارجية يمين و داخلية يسار"
                                                    bindingR2.s3erR2sAcx.setText("20")
                                                }else {
                                                    if (bindingR2.insideright.isChecked && bindingR2.outsideleft.isChecked) {
                                                        binding.ch1.text = "راسية اكس خارجية يسار و داخلية يمين"
                                                        bindingR2.s3erR2sAcx.setText("20")
                                                    }else {
                                                        if (bindingR2.outsideleft.isChecked && bindingR2.insideleft.isChecked) {
                                                            binding.ch1.text = "راسية اكس خارجية يسار و داخلية يسار"
                                                            bindingR2.s3erR2sAcx.setText("20")
                                                        }else {
                                                            if (bindingR2.insideright.isChecked && bindingR2.insideleft.isChecked) {
                                                                binding.ch1.text = "راسية اكس داخلية يمين و يسار"
                                                                bindingR2.s3erR2sAcx.setText("20")
                                                            } else {
                                                                if (bindingR2.insideright.isChecked) {
                                                                    binding.ch1.text = "راسية اكس داخلية يمين"
                                                                    bindingR2.s3erR2sAcx.setText("10")
                                                                }
                                                                if (bindingR2.insideleft.isChecked) {
                                                                    binding.ch1.text = "راسية اكس داخلية يسار"
                                                                    bindingR2.s3erR2sAcx.setText("10")
                                                                }
                                                                if (bindingR2.outsideleft.isChecked) {
                                                                    binding.ch1.text = "راسية اكس خارجية يسار"
                                                                    bindingR2.s3erR2sAcx.setText("10")
                                                                }
                                                                if (bindingR2.outsideright.isChecked) {
                                                                    binding.ch1.text = "راسية اكس خارجية يمين"
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
                            binding.pric1.text=bindingR2.s3erR2sAcx.text.toString()
                            customDialogR2SX.dismiss()
                        }
                    }
                }
                bindingR2.btnR2sCan.setOnClickListener {
                    if (binding.pric1.text.toString().isEmpty()) {
                        binding.ch1.text = "راسية اكس"
                        binding.ch1.isChecked = false
                    }
                    customDialogR2SX.dismiss()
                }
                bindingR2.outsideright.isChecked = false
                bindingR2.outsideleft.isChecked = false
                bindingR2.insideright.isChecked = false
                bindingR2.insideleft.isChecked = false
                customDialogR2SX.show()

            }
                else{
                    binding.ch1.text = "راسية اكس"
                    binding.pric1.text = ""
                }
            }

        binding.ch2.setOnCheckedChangeListener { _, isChecked ->
            if (binding.ch2.isChecked) {
                customDialogBRK.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

                val window = customDialogBRK.window
                window?.setGravity(Gravity.BOTTOM)
                val lp = window?.attributes
                lp?.dimAmount = 0.0f
                lp?.flags = lp?.flags?.or(WindowManager.LayoutParams.FLAG_DIM_BEHIND)
                window?.attributes = lp

                bindingBRK.dBFront.setOnCheckedChangeListener { _, isChecked1 ->
                    if (bindingBRK.dBFront.isChecked) {
                        binding.ch2.text = "بريك امامي"
                    } else {
                        binding.ch2.text = "بريك"
                        bindingBRK.s3erYadweeBreak.setText("")
                    }
                    if (bindingBRK.dBFront.isChecked && bindingBRK.dBRear.isChecked && bindingBRK.qb8ab.isChecked) {
                        binding.ch2.text = "بريك امامي خلفي و قبقاب خلفي كامل"
                        bindingBRK.s3erYadweeBreak.setText("15")
                    } else {
                        if (bindingBRK.dBRear.isChecked && bindingBRK.dBFront.isChecked && bindingBRK.qb8ab.isChecked) {
                            binding.ch2.text = "بريك امامي خلفي و قبقاب خلفي كامل"
                            bindingBRK.s3erYadweeBreak.setText("15")
                        } else {
                            if (bindingBRK.qb8ab.isChecked && bindingBRK.dBFront.isChecked && bindingBRK.dBRear.isChecked) {
                                binding.ch2.text = "بريك امامي خلفي و قبقاب خلفي كامل"
                                bindingBRK.s3erYadweeBreak.setText("15")
                            } else {
                                if (bindingBRK.qb8ab.isChecked && bindingBRK.dBRear.isChecked && bindingBRK.dBFront.isChecked) {
                                    binding.ch2.text = "بريك امامي خلفي و قبقاب خلفي كامل"
                                    bindingBRK.s3erYadweeBreak.setText("15")
                                } else {
                                    if (bindingBRK.dBFront.isChecked && bindingBRK.dBRear.isChecked) {
                                        binding.ch2.text = "بريك امامي و خلفي"
                                        bindingBRK.s3erYadweeBreak.setText("10")
                                    } else {
                                        if (bindingBRK.dBRear.isChecked && bindingBRK.dBFront.isChecked) {
                                            binding.ch2.text = "بريك امامي و خلفي"
                                            bindingBRK.s3erYadweeBreak.setText("10")
                                        } else {
                                            if (bindingBRK.dBFront.isChecked && bindingBRK.qb8ab.isChecked) {
                                                binding.ch2.text = "بريك امامي و قبقاب خلفي"
                                                bindingBRK.s3erYadweeBreak.setText("10")
                                            } else {
                                                if (bindingBRK.qb8ab.isChecked && bindingBRK.dBFront.isChecked) {
                                                    binding.ch2.text = "بريك امامي و قبقاب خلفي"
                                                    bindingBRK.s3erYadweeBreak.setText("10")
                                                } else {
                                                    if (bindingBRK.qb8ab.isChecked && bindingBRK.dBRear.isChecked) {
                                                        binding.ch2.text = "بريك خلفي و قبقاب خلفي"
                                                        bindingBRK.s3erYadweeBreak.setText("10")
                                                    } else {
                                                        if (bindingBRK.dBRear.isChecked && bindingBRK.qb8ab.isChecked) {
                                                            binding.ch2.text =
                                                                "بريك خلفي و قبقاب خلفي"
                                                            bindingBRK.s3erYadweeBreak.setText(
                                                                "10"
                                                            )
                                                        } else {

                                                            if (bindingBRK.dBFront.isChecked) {
                                                                binding.ch2.text =
                                                                    "بريك امامي"
                                                                bindingBRK.s3erYadweeBreak.setText(
                                                                    "5"
                                                                )
                                                            }
                                                            if (bindingBRK.dBRear.isChecked) {
                                                                binding.ch2.text =
                                                                    "بريك خلفي"
                                                                bindingBRK.s3erYadweeBreak.setText(
                                                                    "5"
                                                                )
                                                            }
                                                            if (bindingBRK.qb8ab.isChecked) {
                                                                binding.ch2.text =
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
                        binding.ch2.text = "بريك خلفي"
                    } else {
                        binding.ch2.text = "بريك"
                        bindingBRK.s3erYadweeBreak.setText("")
                    }
                    if (bindingBRK.dBFront.isChecked && bindingBRK.dBRear.isChecked && bindingBRK.qb8ab.isChecked) {
                        binding.ch2.text = "بريك امامي خلفي و قبقاب خلفي كامل"
                        bindingBRK.s3erYadweeBreak.setText("15")
                    } else {
                        if (bindingBRK.dBRear.isChecked && bindingBRK.dBFront.isChecked && bindingBRK.qb8ab.isChecked) {
                            binding.ch2.text = "بريك امامي خلفي و قبقاب خلفي كامل"
                            bindingBRK.s3erYadweeBreak.setText("15")
                        } else {
                            if (bindingBRK.qb8ab.isChecked && bindingBRK.dBFront.isChecked && bindingBRK.dBRear.isChecked) {
                                binding.ch2.text = "بريك امامي خلفي و قبقاب خلفي كامل"
                                bindingBRK.s3erYadweeBreak.setText("15")
                            } else {
                                if (bindingBRK.qb8ab.isChecked && bindingBRK.dBRear.isChecked && bindingBRK.dBFront.isChecked) {
                                    binding.ch2.text = "بريك امامي خلفي و قبقاب خلفي كامل"
                                    bindingBRK.s3erYadweeBreak.setText("15")
                                } else {
                                    if (bindingBRK.dBFront.isChecked && bindingBRK.dBRear.isChecked) {
                                        binding.ch2.text = "بريك امامي و خلفي"
                                        bindingBRK.s3erYadweeBreak.setText("10")
                                    } else {
                                        if (bindingBRK.dBRear.isChecked && bindingBRK.dBFront.isChecked) {
                                            binding.ch2.text = "بريك امامي و خلفي"
                                            bindingBRK.s3erYadweeBreak.setText("10")
                                        } else {
                                            if (bindingBRK.dBFront.isChecked && bindingBRK.qb8ab.isChecked) {
                                                binding.ch2.text = "بريك امامي و قبقاب خلفي"
                                                bindingBRK.s3erYadweeBreak.setText("10")
                                            } else {
                                                if (bindingBRK.qb8ab.isChecked && bindingBRK.dBFront.isChecked) {
                                                    binding.ch2.text = "بريك امامي و قبقاب خلفي"
                                                    bindingBRK.s3erYadweeBreak.setText("10")
                                                } else {
                                                    if (bindingBRK.qb8ab.isChecked && bindingBRK.dBRear.isChecked) {
                                                        binding.ch2.text = "بريك خلفي و قبقاب خلفي"
                                                        bindingBRK.s3erYadweeBreak.setText("10")
                                                    } else {
                                                        if (bindingBRK.dBRear.isChecked && bindingBRK.qb8ab.isChecked) {
                                                            binding.ch2.text =
                                                                "بريك خلفي و قبقاب خلفي"
                                                            bindingBRK.s3erYadweeBreak.setText(
                                                                "10"
                                                            )
                                                        } else {
                                                            if (bindingBRK.dBFront.isChecked) {
                                                                binding.ch2.text =
                                                                    "بريك امامي"
                                                                bindingBRK.s3erYadweeBreak.setText(
                                                                    "5"
                                                                )
                                                            }
                                                            if (bindingBRK.dBRear.isChecked) {
                                                                binding.ch2.text =
                                                                    "بريك خلفي"
                                                                bindingBRK.s3erYadweeBreak.setText(
                                                                    "5"
                                                                )
                                                            }
                                                            if (bindingBRK.qb8ab.isChecked) {
                                                                binding.ch2.text =
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
                        binding.ch2.text = "بريك قبقاب خلفي"
                    } else {
                        binding.ch2.text = "بريك"
                        bindingBRK.s3erYadweeBreak.setText("")
                    }
                    if (bindingBRK.dBFront.isChecked && bindingBRK.dBRear.isChecked && bindingBRK.qb8ab.isChecked) {
                        binding.ch2.text = "بريك امامي خلفي و قبقاب خلفي كامل"
                        bindingBRK.s3erYadweeBreak.setText("15")
                    } else {
                        if (bindingBRK.dBRear.isChecked && bindingBRK.dBFront.isChecked && bindingBRK.qb8ab.isChecked) {
                            binding.ch2.text = "بريك امامي خلفي و قبقاب خلفي كامل"
                            bindingBRK.s3erYadweeBreak.setText("15")
                        } else {
                            if (bindingBRK.qb8ab.isChecked && bindingBRK.dBFront.isChecked && bindingBRK.dBRear.isChecked) {
                                binding.ch2.text = "بريك امامي خلفي و قبقاب خلفي كامل"
                                bindingBRK.s3erYadweeBreak.setText("15")
                            } else {
                                if (bindingBRK.qb8ab.isChecked && bindingBRK.dBRear.isChecked && bindingBRK.dBFront.isChecked) {
                                    binding.ch2.text = "بريك امامي خلفي و قبقاب خلفي كامل"
                                    bindingBRK.s3erYadweeBreak.setText("15")
                                } else {
                                    if (bindingBRK.dBFront.isChecked && bindingBRK.dBRear.isChecked) {
                                        binding.ch2.text = "بريك امامي و خلفي"
                                        bindingBRK.s3erYadweeBreak.setText("10")
                                    } else {
                                        if (bindingBRK.dBRear.isChecked && bindingBRK.dBFront.isChecked) {
                                            binding.ch2.text = "بريك امامي و خلفي"
                                            bindingBRK.s3erYadweeBreak.setText("10")
                                        } else {
                                            if (bindingBRK.dBFront.isChecked && bindingBRK.qb8ab.isChecked) {
                                                binding.ch2.text = "بريك امامي و قبقاب خلفي"
                                                bindingBRK.s3erYadweeBreak.setText("10")
                                            } else {
                                                if (bindingBRK.qb8ab.isChecked && bindingBRK.dBFront.isChecked) {
                                                    binding.ch2.text = "بريك امامي و قبقاب خلفي"
                                                    bindingBRK.s3erYadweeBreak.setText("10")
                                                } else {
                                                    if (bindingBRK.qb8ab.isChecked && bindingBRK.dBRear.isChecked) {
                                                        binding.ch2.text = "بريك خلفي و قبقاب خلفي"
                                                        bindingBRK.s3erYadweeBreak.setText("10")
                                                    } else {
                                                        if (bindingBRK.dBRear.isChecked && bindingBRK.qb8ab.isChecked) {
                                                            binding.ch2.text =
                                                                "بريك خلفي و قبقاب خلفي"
                                                            bindingBRK.s3erYadweeBreak.setText(
                                                                "10"
                                                            )
                                                        } else {

                                                            if (bindingBRK.dBFront.isChecked) {
                                                                binding.ch2.text =
                                                                    "بريك امامي"
                                                                bindingBRK.s3erYadweeBreak.setText(
                                                                    "5"
                                                                )
                                                            }
                                                            if (bindingBRK.dBRear.isChecked) {
                                                                binding.ch2.text =
                                                                    "بريك خلفي"
                                                                bindingBRK.s3erYadweeBreak.setText(
                                                                    "5"
                                                                )
                                                            }
                                                            if (bindingBRK.qb8ab.isChecked) {
                                                                binding.ch2.text =
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
                            binding.pric2.text = bindingBRK.s3erYadweeBreak.text.toString()
                            customDialogBRK.dismiss()
                        }
                    }
                }

                bindingBRK.btnCnDigBreak.setOnClickListener {
                    if (binding.pric2.text.toString().isEmpty()) {
                        binding.ch2.text = "بريك"
                        binding.ch2.isChecked = false
                    }
                    customDialogBRK.dismiss()
                }
                bindingBRK.dBFront.isChecked = false
                bindingBRK.dBRear.isChecked = false
                bindingBRK.qb8ab.isChecked = false

                customDialogBRK.show()

            }
                else {
                    binding.ch2.text = "بريك"
                    binding.pric2.text = ""
                }
            }

        binding.ch3.setOnCheckedChangeListener { _, isChecked ->
            if (binding.ch3.isChecked) {
                bindingR2.titR2sOut.text = "خارجية"
                bindingR2.titR2sIn.text = "داخلية"
                customDialogR2SX.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
                val window = customDialogR2SX.window
                window?.setGravity(Gravity.BOTTOM)
                val lp = window?.attributes
                lp?.dimAmount = 0.0f
                lp?.flags = lp?.flags?.or(WindowManager.LayoutParams.FLAG_DIM_BEHIND)
                window?.attributes = lp

                bindingR2.outsideright.setOnCheckedChangeListener { _, isChecked1 ->
                    if (bindingR2.outsideright.isChecked) {
                        binding.ch3.text = "كوشوكة اكس خارجية يمين"
                    } else {
                        binding.ch3.text = "كوشوكة اكس خارجية"
                        bindingR2.s3erR2sAcx.setText("")
                    }
                    if (bindingR2.outsideright.isChecked && bindingR2.outsideleft.isChecked && bindingR2.insideright.isChecked && bindingR2.insideleft.isChecked) {
                        binding.ch3.text = "تغير جميع كوشوكات الأكس الخارجية و الداخلية"
                        bindingR2.s3erR2sAcx.setText("20")
                    } else {
                        if (bindingR2.outsideright.isChecked && bindingR2.outsideleft.isChecked && bindingR2.insideright.isChecked) {
                            binding.ch3.text = "كوشوكتين اكس خارجية و الداخلية يمين"
                            bindingR2.s3erR2sAcx.setText("15")
                        } else {
                            if (bindingR2.outsideright.isChecked && bindingR2.outsideleft.isChecked && bindingR2.insideleft.isChecked) {
                                binding.ch3.text = "كوشوكتين اكس خارجية و الداخلية يسار"
                                bindingR2.s3erR2sAcx.setText("15")
                            } else {
                                if (bindingR2.outsideright.isChecked && bindingR2.insideright.isChecked && bindingR2.insideleft.isChecked) {
                                    binding.ch3.text = "كوشوكة اكس خارجية يمين و الداخليتين"
                                    bindingR2.s3erR2sAcx.setText("15")
                                } else {
                                    if (bindingR2.outsideleft.isChecked && bindingR2.insideright.isChecked && bindingR2.insideleft.isChecked) {
                                        binding.ch3.text = "كوشوكة اكس خارجية يسار و الداخليتين"
                                        bindingR2.s3erR2sAcx.setText("15")
                                    } else {
                                        if (bindingR2.outsideright.isChecked && bindingR2.outsideleft.isChecked) {
                                            binding.ch3.text = "كوشوكة اكس خارجية يمين و يسار"
                                            bindingR2.s3erR2sAcx.setText("10")
                                        } else {
                                            if (bindingR2.outsideright.isChecked && bindingR2.insideright.isChecked) {
                                                binding.ch3.text = "كوشوكة اكس خارجية يمين و داخلية يمين"
                                                bindingR2.s3erR2sAcx.setText("10")
                                            } else {
                                                if (bindingR2.outsideright.isChecked && bindingR2.insideleft.isChecked) {
                                                    binding.ch3.text = "كوشوكة اكس خارجية يمين و داخلية يسار"
                                                    bindingR2.s3erR2sAcx.setText("10")
                                                } else {
                                                    if (bindingR2.outsideleft.isChecked && bindingR2.insideright.isChecked) {
                                                        binding.ch3.text =
                                                            "كوشوكة اكس خارجية يسار و داخلية يمين"
                                                        bindingR2.s3erR2sAcx.setText("10")
                                                    } else {
                                                        if (bindingR2.outsideleft.isChecked && bindingR2.insideleft.isChecked) {
                                                            binding.ch3.text =
                                                                "كوشوكة اكس خارجية يسار و داخلية يسار"
                                                            bindingR2.s3erR2sAcx.setText("10")
                                                        } else {
                                                            if (bindingR2.insideright.isChecked && bindingR2.insideleft.isChecked) {
                                                                binding.ch3.text =
                                                                    "كوشوكة اكس داخلية يمين و يسار"
                                                                bindingR2.s3erR2sAcx.setText(
                                                                    "5"
                                                                )
                                                            } else {

                                                                if (bindingR2.outsideright.isChecked) {
                                                                    binding.ch3.text =
                                                                        "كوشوكة اكس خارجية يمين"
                                                                    bindingR2.s3erR2sAcx.setText(
                                                                        "5"
                                                                    )
                                                                }
                                                                if (bindingR2.outsideleft.isChecked) {
                                                                    binding.ch3.text =
                                                                        "كوشوكة اكس خارجية يسار"
                                                                    bindingR2.s3erR2sAcx.setText(
                                                                        "5"
                                                                    )
                                                                }

                                                                if (bindingR2.insideleft.isChecked) {
                                                                    binding.ch3.text =
                                                                        "كوشوكة اكس داخلية يسار"
                                                                    bindingR2.s3erR2sAcx.setText(
                                                                        "5"
                                                                    )
                                                                }
                                                                if (bindingR2.insideright.isChecked) {
                                                                    binding.ch3.text =
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
                        binding.ch3.text = "راسية اكس خارجية يسار"
                    } else {
                        binding.ch3.text = "راسية اكس"
                        bindingR2.s3erR2sAcx.setText("")
                    }
                    if (bindingR2.outsideright.isChecked && bindingR2.outsideleft.isChecked && bindingR2.insideright.isChecked && bindingR2.insideleft.isChecked) {
                        binding.ch3.text = "تغير جميع كوشوكات الأكس الخارجية و الداخلية"
                        bindingR2.s3erR2sAcx.setText("20")
                    } else {
                        if (bindingR2.outsideright.isChecked && bindingR2.outsideleft.isChecked && bindingR2.insideright.isChecked) {
                            binding.ch3.text = "كوشوكتين اكس خارجية و الداخلية يمين"
                            bindingR2.s3erR2sAcx.setText("15")
                        } else {
                            if (bindingR2.outsideright.isChecked && bindingR2.outsideleft.isChecked && bindingR2.insideleft.isChecked) {
                                binding.ch3.text = "كوشوكتين اكس خارجية و الداخلية يسار"
                                bindingR2.s3erR2sAcx.setText("15")
                            } else {
                                if (bindingR2.outsideright.isChecked && bindingR2.insideright.isChecked && bindingR2.insideleft.isChecked) {
                                    binding.ch3.text = "كوشوكة اكس خارجية يمين و الداخليتين"
                                    bindingR2.s3erR2sAcx.setText("15")
                                } else {
                                    if (bindingR2.outsideleft.isChecked && bindingR2.insideright.isChecked && bindingR2.insideleft.isChecked) {
                                        binding.ch3.text = "كوشوكة اكس خارجية يسار و الداخليتين"
                                        bindingR2.s3erR2sAcx.setText("15")
                                    } else {
                                        if (bindingR2.outsideright.isChecked && bindingR2.outsideleft.isChecked) {
                                            binding.ch3.text = "كوشوكة اكس خارجية يمين و يسار"
                                            bindingR2.s3erR2sAcx.setText("10")
                                        } else {
                                            if (bindingR2.outsideright.isChecked && bindingR2.insideright.isChecked) {
                                                binding.ch3.text = "كوشوكة اكس خارجية يمين و داخلية يمين"
                                                bindingR2.s3erR2sAcx.setText("10")
                                            } else {
                                                if (bindingR2.outsideright.isChecked && bindingR2.insideleft.isChecked) {
                                                    binding.ch3.text = "كوشوكة اكس خارجية يمين و داخلية يسار"
                                                    bindingR2.s3erR2sAcx.setText("10")
                                                } else {
                                                    if (bindingR2.outsideleft.isChecked && bindingR2.insideright.isChecked) {
                                                        binding.ch3.text =
                                                            "كوشوكة اكس خارجية يسار و داخلية يمين"
                                                        bindingR2.s3erR2sAcx.setText("10")
                                                    } else {
                                                        if (bindingR2.outsideleft.isChecked && bindingR2.insideleft.isChecked) {
                                                            binding.ch3.text =
                                                                "كوشوكة اكس خارجية يسار و داخلية يسار"
                                                            bindingR2.s3erR2sAcx.setText("10")
                                                        } else {
                                                            if (bindingR2.insideright.isChecked && bindingR2.insideleft.isChecked) {
                                                                binding.ch3.text =
                                                                    "كوشوكة اكس داخلية يمين و يسار"
                                                                bindingR2.s3erR2sAcx.setText(
                                                                    "5"
                                                                )
                                                            } else {

                                                                if (bindingR2.outsideright.isChecked) {
                                                                    binding.ch3.text =
                                                                        "كوشوكة اكس خارجية يمين"
                                                                    bindingR2.s3erR2sAcx.setText(
                                                                        "5"
                                                                    )
                                                                }
                                                                if (bindingR2.outsideleft.isChecked) {
                                                                    binding.ch3.text =
                                                                        "كوشوكة اكس خارجية يسار"
                                                                    bindingR2.s3erR2sAcx.setText(
                                                                        "5"
                                                                    )
                                                                }
                                                                if (bindingR2.insideleft.isChecked) {
                                                                    binding.ch3.text =
                                                                        "كوشوكة اكس داخلية يسار"
                                                                    bindingR2.s3erR2sAcx.setText(
                                                                        "5"
                                                                    )
                                                                }
                                                                if (bindingR2.insideright.isChecked) {
                                                                    binding.ch3.text =
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
                        binding.ch3.text = "كوشوكة اكس خارجية يمين"
                    } else {
                        binding.ch3.text = "كوشوكة اكس خارجية"
                        bindingR2.s3erR2sAcx.setText("")
                    }
                    if (bindingR2.outsideright.isChecked && bindingR2.outsideleft.isChecked && bindingR2.insideright.isChecked && bindingR2.insideleft.isChecked) {
                        binding.ch3.text = "تغير جميع كوشوكات الأكس الخارجية و الداخلية"
                        bindingR2.s3erR2sAcx.setText("20")
                    } else {
                        if (bindingR2.outsideright.isChecked && bindingR2.outsideleft.isChecked && bindingR2.insideright.isChecked) {
                            binding.ch3.text = "كوشوكتين اكس خارجية و الداخلية يمين"
                            bindingR2.s3erR2sAcx.setText("15")
                        } else {
                            if (bindingR2.outsideright.isChecked && bindingR2.outsideleft.isChecked && bindingR2.insideleft.isChecked) {
                                binding.ch3.text = "كوشوكتين اكس خارجية و الداخلية يسار"
                                bindingR2.s3erR2sAcx.setText("15")
                            } else {
                                if (bindingR2.outsideright.isChecked && bindingR2.insideright.isChecked && bindingR2.insideleft.isChecked) {
                                    binding.ch3.text = "كوشوكة اكس خارجية يمين و الداخليتين"
                                    bindingR2.s3erR2sAcx.setText("15")
                                } else {
                                    if (bindingR2.outsideleft.isChecked && bindingR2.insideright.isChecked && bindingR2.insideleft.isChecked) {
                                        binding.ch3.text = "كوشوكة اكس خارجية يسار و الداخليتين"
                                        bindingR2.s3erR2sAcx.setText("15")
                                    } else {
                                        if (bindingR2.outsideright.isChecked && bindingR2.outsideleft.isChecked) {
                                            binding.ch3.text = "كوشوكة اكس خارجية يمين و يسار"
                                            bindingR2.s3erR2sAcx.setText("10")
                                        } else {
                                            if (bindingR2.outsideright.isChecked && bindingR2.insideright.isChecked) {
                                                binding.ch3.text = "كوشوكة اكس خارجية يمين و داخلية يمين"
                                                bindingR2.s3erR2sAcx.setText("10")
                                            } else {
                                                if (bindingR2.outsideright.isChecked && bindingR2.insideleft.isChecked) {
                                                    binding.ch3.text = "كوشوكة اكس خارجية يمين و داخلية يسار"
                                                    bindingR2.s3erR2sAcx.setText("10")
                                                } else {
                                                    if (bindingR2.outsideleft.isChecked && bindingR2.insideright.isChecked) {
                                                        binding.ch3.text =
                                                            "كوشوكة اكس خارجية يسار و داخلية يمين"
                                                        bindingR2.s3erR2sAcx.setText("10")
                                                    } else {
                                                        if (bindingR2.outsideleft.isChecked && bindingR2.insideleft.isChecked) {
                                                            binding.ch3.text =
                                                                "كوشوكة اكس خارجية يسار و داخلية يسار"
                                                            bindingR2.s3erR2sAcx.setText("10")
                                                        } else {
                                                            if (bindingR2.insideright.isChecked && bindingR2.insideleft.isChecked) {
                                                                binding.ch3.text =
                                                                    "كوشوكة اكس داخلية يمين و يسار"
                                                                bindingR2.s3erR2sAcx.setText(
                                                                    "5"
                                                                )
                                                            } else {
                                                                if (bindingR2.outsideright.isChecked) {
                                                                    binding.ch3.text =
                                                                        "كوشوكة اكس خارجية يمين"
                                                                    bindingR2.s3erR2sAcx.setText(
                                                                        "5"
                                                                    )
                                                                }
                                                                if (bindingR2.outsideleft.isChecked) {
                                                                    binding.ch3.text =
                                                                        "كوشوكة اكس خارجية يسار"
                                                                    bindingR2.s3erR2sAcx.setText(
                                                                        "5"
                                                                    )
                                                                }
                                                                if (bindingR2.insideleft.isChecked) {
                                                                    binding.ch3.text =
                                                                        "كوشوكة اكس داخلية يسار"
                                                                    bindingR2.s3erR2sAcx.setText(
                                                                        "5"
                                                                    )
                                                                }
                                                                if (bindingR2.insideright.isChecked) {
                                                                    binding.ch3.text =
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
                        binding.ch3.text = "كوشوكة اكس خارجية يمين"
                    } else {
                        binding.ch3.text = "كوشوكة اكس خارجية"
                        bindingR2.s3erR2sAcx.setText("")
                    }
                    if (bindingR2.outsideright.isChecked && bindingR2.outsideleft.isChecked && bindingR2.insideright.isChecked && bindingR2.insideleft.isChecked) {
                        binding.ch3.text = "تغير جميع كوشوكات الأكس الخارجية و الداخلية"
                        bindingR2.s3erR2sAcx.setText("20")
                    } else {
                        if (bindingR2.outsideright.isChecked && bindingR2.outsideleft.isChecked && bindingR2.insideright.isChecked) {
                            binding.ch3.text = "كوشوكتين اكس خارجية و الداخلية يمين"
                            bindingR2.s3erR2sAcx.setText("15")
                        } else {
                            if (bindingR2.outsideright.isChecked && bindingR2.outsideleft.isChecked && bindingR2.insideleft.isChecked) {
                                binding.ch3.text = "كوشوكتين اكس خارجية و الداخلية يسار"
                                bindingR2.s3erR2sAcx.setText("15")
                            } else {
                                if (bindingR2.outsideright.isChecked && bindingR2.insideright.isChecked && bindingR2.insideleft.isChecked) {
                                    binding.ch3.text = "كوشوكة اكس خارجية يمين و الداخليتين"
                                    bindingR2.s3erR2sAcx.setText("15")
                                } else {
                                    if (bindingR2.outsideleft.isChecked && bindingR2.insideright.isChecked && bindingR2.insideleft.isChecked) {
                                        binding.ch3.text = "كوشوكة اكس خارجية يسار و الداخليتين"
                                        bindingR2.s3erR2sAcx.setText("15")
                                    } else {
                                        if (bindingR2.outsideright.isChecked && bindingR2.outsideleft.isChecked) {
                                            binding.ch3.text = "كوشوكة اكس خارجية يمين و يسار"
                                            bindingR2.s3erR2sAcx.setText("10")
                                        } else {
                                            if (bindingR2.outsideright.isChecked && bindingR2.insideright.isChecked) {
                                                binding.ch3.text = "كوشوكة اكس خارجية يمين و داخلية يمين"
                                                bindingR2.s3erR2sAcx.setText("10")
                                            } else {
                                                if (bindingR2.outsideright.isChecked && bindingR2.insideleft.isChecked) {
                                                    binding.ch3.text = "كوشوكة اكس خارجية يمين و داخلية يسار"
                                                    bindingR2.s3erR2sAcx.setText("10")
                                                } else {
                                                    if (bindingR2.outsideleft.isChecked && bindingR2.insideright.isChecked) {
                                                        binding.ch3.text =
                                                            "كوشوكة اكس خارجية يسار و داخلية يمين"
                                                        bindingR2.s3erR2sAcx.setText("10")
                                                    } else {
                                                        if (bindingR2.outsideleft.isChecked && bindingR2.insideleft.isChecked) {
                                                            binding.ch3.text =
                                                                "كوشوكة اكس خارجية يسار و داخلية يسار"
                                                            bindingR2.s3erR2sAcx.setText("10")
                                                        } else {
                                                            if (bindingR2.insideright.isChecked && bindingR2.insideleft.isChecked) {
                                                                binding.ch3.text =
                                                                    "كوشوكة اكس داخلية يمين و يسار"
                                                                bindingR2.s3erR2sAcx.setText(
                                                                    "5"
                                                                )
                                                            } else {

                                                                if (bindingR2.outsideright.isChecked) {
                                                                    binding.ch3.text =
                                                                        "كوشوكة اكس خارجية يمين"
                                                                    bindingR2.s3erR2sAcx.setText(
                                                                        "5"
                                                                    )
                                                                }
                                                                if (bindingR2.outsideleft.isChecked) {
                                                                    binding.ch3.text =
                                                                        "كوشوكة اكس خارجية يسار"
                                                                    bindingR2.s3erR2sAcx.setText(
                                                                        "5"
                                                                    )
                                                                }
                                                                if (bindingR2.insideleft.isChecked) {
                                                                    binding.ch3.text =
                                                                        "كوشوكة اكس داخلية يسار"
                                                                    bindingR2.s3erR2sAcx.setText(
                                                                        "5"
                                                                    )
                                                                }
                                                                if (bindingR2.insideright.isChecked) {
                                                                    binding.ch3.text =
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
                            binding.pric3.text = bindingR2.s3erR2sAcx.text.toString()
                            customDialogR2SX.dismiss()
                        }
                    }
                }
                bindingR2.btnR2sCan.setOnClickListener {
                    if (binding.pric3.text.toString().isEmpty()) {
                        binding.ch3.text = "كوشوكة اكس"
                        binding.ch3.isChecked = false
                    }
                    customDialogR2SX.dismiss()
                }
                bindingR2.outsideright.isChecked = false
                bindingR2.outsideleft.isChecked = false
                bindingR2.insideright.isChecked = false
                bindingR2.insideleft.isChecked = false

                customDialogR2SX.show()

            }
                else {
                    binding.ch3.text = "كوشوكة اكس"
                    binding.pric3.text = ""
                }
            }

        binding.apply{
            ch4.setOnCheckedChangeListener { _, isChecked ->
                if (ch4.isChecked) {

                    bindingFR.frontright.setOnCheckedChangeListener { _, isChecked1 ->
                        if (bindingFR.frontright.isChecked) {
                            ch4.text = "اكس امامي يمين"
                        } else {
                            ch4.text = "اكس امامي"
                            bindingFR.s3erYadwee.setText("")
                        }
                        if (bindingFR.frontright.isChecked && bindingFR.frontleft.isChecked) {
                            ch4.text = "اكس امامي يمين و يسار"
                            bindingFR.s3erYadwee.setText("10")
                        } else {
                            if (bindingFR.frontright.isChecked) {
                                ch4.text = "اكس امامي يمين"
                                bindingFR.s3erYadwee.setText("5")
                            }
                            if (bindingFR.frontleft.isChecked) {
                                ch4.text = "اكس امامي يسار"
                                bindingFR.s3erYadwee.setText("5")
                            }
                        }
                    }
                    bindingFR.frontleft.setOnCheckedChangeListener { _, isChecked2 ->
                        if (bindingFR.frontleft.isChecked) {
                            ch4.text = "اكس امامي يسار"
                        } else {
                            ch4.text = "اكس امامي"
                            bindingFR.s3erYadwee.setText("")
                        }
                        if (bindingFR.frontright.isChecked && bindingFR.frontleft.isChecked) {
                            ch4.text = "اكس امامي يمين و يسار"
                            bindingFR.s3erYadwee.setText("10")
                        } else {
                            if (bindingFR.frontleft.isChecked) {
                                ch4.text = "اكس امامي يسار"
                                bindingFR.s3erYadwee.setText("5")
                            }
                            if (bindingFR.frontright.isChecked) {
                                ch4.text = "اكس امامي يمين"
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
                                ch4.isChecked = false
                            } else {
                                pric4.text = bindingFR.s3erYadwee.text.toString()
                                customDialogFR.dismiss()
                            }
                        }
                    }
                    bindingFR.buttonDailogCancel.setOnClickListener {
                        ch4.isChecked = false
                        bindingFR.s3erYadwee.setText("")
                        customDialogFR.dismiss()
                    }
                    bindingFR.frontright.isChecked = false
                    bindingFR.frontleft.isChecked = false
                    customDialogFR.show()

                }
                else {
                    ch4.text = "اكس امامي"
                    pric4.text = ""
                }
            }
        }

        binding.apply{
            ch5.setOnCheckedChangeListener { _, isChecked ->
                if (ch5.isChecked) {

                    val window = customDialogFR.window
                    window?.setGravity(Gravity.BOTTOM)
                    val lp = window?.attributes
                    lp?.dimAmount = 0.0f
                    lp?.flags = lp?.flags?.or(WindowManager.LayoutParams.FLAG_DIM_BEHIND)
                    window?.attributes = lp

                    bindingFR.frontright.setOnCheckedChangeListener { _, isChecked1 ->
                        if (bindingFR.frontright.isChecked) {
                            ch5.text = "كوشوكة منفاخ يمين"
                        } else {
                            ch5.text = "كوشوكة منفاخ"
                            bindingFR.s3erYadwee.setText("")
                        }
                        if (bindingFR.frontright.isChecked && bindingFR.frontleft.isChecked) {
                            ch5.text = "كوشوكة منفاخ يمين و يسار"
                            bindingFR.s3erYadwee.setText("6")
                        } else {
                            if (bindingFR.frontright.isChecked) {
                                ch5.text = "كوشوكة منفاخ يمين"
                                bindingFR.s3erYadwee.setText("3")
                            }
                            if (bindingFR.frontleft.isChecked) {
                                ch5.text = "كوشوكة منفاخ يسار"
                                bindingFR.s3erYadwee.setText("3")
                            }
                        }
                    }

                    bindingFR.frontleft.setOnCheckedChangeListener { _, isChecked2 ->
                        if (bindingFR.frontleft.isChecked) {
                            ch5.text = "كوشوكة منفاخ يسار"
                        } else {
                            ch5.text = "كوشوكة منفاخ"
                            bindingFR.s3erYadwee.setText("")
                        }
                        if (bindingFR.frontright.isChecked && bindingFR.frontleft.isChecked) {
                            ch5.text = "كوشوكة منفاخ يمين و يسار"
                            bindingFR.s3erYadwee.setText("6")
                        } else {
                            if (bindingFR.frontleft.isChecked) {
                                ch5.text = "كوشوكة منفاخ يسار"
                                bindingFR.s3erYadwee.setText("3")
                            }
                            if (bindingFR.frontright.isChecked) {
                                ch5.text = "كوشوكة منفاخ يمين"
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
                                ch5.isChecked = false
                            } else {
                                pric5.text = bindingFR.s3erYadwee.text.toString()
                                customDialogFR.dismiss()
                            }
                        }
                    }
                    bindingFR.buttonDailogCancel.setOnClickListener {
                        ch5.isChecked = false
                        bindingFR.s3erYadwee.setText("")
                        customDialogFR.dismiss()
                    }
                    bindingFR.frontright.isChecked = false
                    bindingFR.frontleft.isChecked = false
                    customDialogFR.show()

                }
                else {
                    ch5.text = "كوشوكة منفاخ"
                    pric5.text = ""
                }
            }
        }

        binding.apply{
            ch6.setOnCheckedChangeListener { _, isChecked ->
                if (ch6.isChecked) {

                    customDialogR2SX.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

                    bindingR2.titR2sOut.text="امامي"
                    bindingR2.titR2sIn.text="خلفي"

                    val window = customDialogR2SX.window
                    window?.setGravity(Gravity.BOTTOM)
                    val lp = window?.attributes
                    lp?.dimAmount = 0.0f
                    lp?.flags = lp?.flags?.or(WindowManager.LayoutParams.FLAG_DIM_BEHIND)
                    window?.attributes = lp

                    bindingR2.outsideright.setOnCheckedChangeListener { _, isChecked1 ->
                        if (bindingR2.outsideright.isChecked) {
                            ch6.text = "كوشوكة عمود شيال امامي يمين"
                        } else {
                            ch6.text = "كوشوكة عمود شيال"
                            bindingR2.s3erR2sAcx.setText("")
                        }
                        if (bindingR2.outsideright.isChecked && bindingR2.outsideleft.isChecked && bindingR2.insideright.isChecked && bindingR2.insideleft.isChecked) {
                            ch6.text = "تغير جميع كوشوكات عمود الشيال"
                            bindingR2.s3erR2sAcx.setText("30")
                        } else {
                            if (bindingR2.outsideright.isChecked && bindingR2.outsideleft.isChecked && bindingR2.insideright.isChecked) {
                                ch6.text = "كوشوكتين عمود شيال امامي و الخلفي يمين"
                                bindingR2.s3erR2sAcx.setText("25")
                            } else {
                                if (bindingR2.outsideright.isChecked && bindingR2.outsideleft.isChecked && bindingR2.insideleft.isChecked) {
                                    ch6.text = "كوشوكتين عمود شيال امامي  و الخلفي يسار"
                                    bindingR2.s3erR2sAcx.setText("25")
                                } else {
                                    if (bindingR2.outsideright.isChecked && bindingR2.insideright.isChecked && bindingR2.insideleft.isChecked) {
                                        ch6.text = "كوشوكة عمود شيال امامي يمين و الخلفيتين"
                                        bindingR2.s3erR2sAcx.setText("20")
                                    } else {
                                        if (bindingR2.outsideleft.isChecked && bindingR2.insideright.isChecked && bindingR2.insideleft.isChecked) {
                                            ch6.text = "كوشوكة عمود شيال امامي يسار و الخلفيتين"
                                            bindingR2.s3erR2sAcx.setText("20")
                                        } else {
                                            if (bindingR2.outsideright.isChecked && bindingR2.outsideleft.isChecked) {
                                                ch6.text = "كوشوكة عمود شيال امامي يمين و يسار"
                                                bindingR2.s3erR2sAcx.setText("20")
                                            } else {
                                                if (bindingR2.outsideright.isChecked && bindingR2.insideright.isChecked) {
                                                    ch6.text = "كوشوكة عمود شيال امامي يمين و خلفي يمين"
                                                    bindingR2.s3erR2sAcx.setText("15")
                                                } else {
                                                    if (bindingR2.outsideright.isChecked && bindingR2.insideleft.isChecked) {
                                                        ch6.text = "كوشوكة عمود شيال امامي يمين و خلفي يسار"
                                                        bindingR2.s3erR2sAcx.setText("15")
                                                    } else {
                                                        if (bindingR2.outsideleft.isChecked && bindingR2.insideright.isChecked) {
                                                            ch6.text =
                                                                "كوشوكة عمود شيال امامي يسار و خلفي يمين"
                                                            bindingR2.s3erR2sAcx.setText("15")
                                                        } else {
                                                            if (bindingR2.outsideleft.isChecked && bindingR2.insideleft.isChecked) {
                                                                ch6.text =
                                                                    "كوشوكة عمود شيال امامي يسار و خلفي يسار"
                                                                bindingR2.s3erR2sAcx.setText("15")
                                                            } else {
                                                                if (bindingR2.insideright.isChecked && bindingR2.insideleft.isChecked) {
                                                                    ch6.text =
                                                                        "كوشوكة عمود شيال خلفي يمين و يسار"
                                                                    bindingR2.s3erR2sAcx.setText(
                                                                        "10"
                                                                    )
                                                                } else {

                                                                    if (bindingR2.outsideright.isChecked) {
                                                                        ch6.text =
                                                                            "كوشوكة عمود شيال امامي يمين"
                                                                        bindingR2.s3erR2sAcx.setText(
                                                                            "10"
                                                                        )
                                                                    }
                                                                    if (bindingR2.outsideleft.isChecked) {
                                                                        ch6.text =
                                                                            "كوشوكة عمود شيال امامي يسار"
                                                                        bindingR2.s3erR2sAcx.setText(
                                                                            "10"
                                                                        )
                                                                    }
                                                                    if (bindingR2.insideleft.isChecked) {
                                                                        ch6.text =
                                                                            "كوشوكة عمود شيال خلفي يسار"
                                                                        bindingR2.s3erR2sAcx.setText(
                                                                            "5"
                                                                        )
                                                                    }
                                                                    if (bindingR2.insideright.isChecked) {
                                                                        ch6.text =
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
                            ch6.text = "كوشوكة عمود شيال امامي يسار"
                        } else {
                            ch6.text = "كوشوكة عمود شيال"
                            bindingR2.s3erR2sAcx.setText("")
                        }
                        if (bindingR2.outsideright.isChecked && bindingR2.outsideleft.isChecked && bindingR2.insideright.isChecked && bindingR2.insideleft.isChecked) {
                            ch6.text = "تغير جميع كوشوكات عمود الشيال"
                            bindingR2.s3erR2sAcx.setText("30")
                        } else {
                            if (bindingR2.outsideright.isChecked && bindingR2.outsideleft.isChecked && bindingR2.insideright.isChecked) {
                                ch6.text = "كوشوكتين عمود شيال امامي و الخلفي يمين"
                                bindingR2.s3erR2sAcx.setText("25")
                            } else {
                                if (bindingR2.outsideright.isChecked && bindingR2.outsideleft.isChecked && bindingR2.insideleft.isChecked) {
                                    ch6.text = "كوشوكتين عمود شيال امامي  و الخلفي يسار"
                                    bindingR2.s3erR2sAcx.setText("25")
                                } else {
                                    if (bindingR2.outsideright.isChecked && bindingR2.insideright.isChecked && bindingR2.insideleft.isChecked) {
                                        ch6.text = "كوشوكة عمود شيال امامي يمين و الخلفيتين"
                                        bindingR2.s3erR2sAcx.setText("20")
                                    } else {
                                        if (bindingR2.outsideleft.isChecked && bindingR2.insideright.isChecked && bindingR2.insideleft.isChecked) {
                                            ch6.text = "كوشوكة عمود شيال امامي يسار و الخلفيتين"
                                            bindingR2.s3erR2sAcx.setText("20")
                                        } else {
                                            if (bindingR2.outsideright.isChecked && bindingR2.outsideleft.isChecked) {
                                                ch6.text = "كوشوكة عمود شيال امامي يمين و يسار"
                                                bindingR2.s3erR2sAcx.setText("20")
                                            } else {
                                                if (bindingR2.outsideright.isChecked && bindingR2.insideright.isChecked) {
                                                    ch6.text = "كوشوكة عمود شيال امامي يمين و خلفي يمين"
                                                    bindingR2.s3erR2sAcx.setText("15")
                                                } else {
                                                    if (bindingR2.outsideright.isChecked && bindingR2.insideleft.isChecked) {
                                                        ch6.text = "كوشوكة عمود شيال امامي يمين و خلفي يسار"
                                                        bindingR2.s3erR2sAcx.setText("15")
                                                    } else {
                                                        if (bindingR2.outsideleft.isChecked && bindingR2.insideright.isChecked) {
                                                            ch6.text =
                                                                "كوشوكة عمود شيال امامي يسار و خلفي يمين"
                                                            bindingR2.s3erR2sAcx.setText("15")
                                                        } else {
                                                            if (bindingR2.outsideleft.isChecked && bindingR2.insideleft.isChecked) {
                                                                ch6.text =
                                                                    "كوشوكة عمود شيال امامي يسار و خلفي يسار"
                                                                bindingR2.s3erR2sAcx.setText("15")
                                                            } else {
                                                                if (bindingR2.insideright.isChecked && bindingR2.insideleft.isChecked) {
                                                                    ch6.text =
                                                                        "كوشوكة عمود شيال خلفي يمين و يسار"
                                                                    bindingR2.s3erR2sAcx.setText(
                                                                        "10"
                                                                    )
                                                                } else {
                                                                    if (bindingR2.outsideright.isChecked) {
                                                                        ch6.text =
                                                                            "كوشوكة عمود شيال امامي يمين"
                                                                        bindingR2.s3erR2sAcx.setText(
                                                                            "10"
                                                                        )
                                                                    }
                                                                    if (bindingR2.outsideleft.isChecked) {
                                                                        ch6.text =
                                                                            "كوشوكة عمود شيال امامي يسار"
                                                                        bindingR2.s3erR2sAcx.setText(
                                                                            "10"
                                                                        )
                                                                    }
                                                                    if (bindingR2.insideleft.isChecked) {
                                                                        ch6.text =
                                                                            "كوشوكة عمود شيال خلفي يسار"
                                                                        bindingR2.s3erR2sAcx.setText(
                                                                            "5"
                                                                        )
                                                                    }
                                                                    if (bindingR2.insideright.isChecked) {
                                                                        ch6.text =
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
                            ch6.text = "كوشوكة عمود شيال خلفي يمين"
                        } else {
                            ch6.text = "كوشوكة عمود شيال"
                            bindingR2.s3erR2sAcx.setText("")
                        }
                        if (bindingR2.outsideright.isChecked && bindingR2.outsideleft.isChecked && bindingR2.insideright.isChecked && bindingR2.insideleft.isChecked) {
                            ch6.text = "تغير جميع كوشوكات عمود الشيال"
                            bindingR2.s3erR2sAcx.setText("30")
                        } else {
                            if (bindingR2.outsideright.isChecked && bindingR2.outsideleft.isChecked && bindingR2.insideright.isChecked) {
                                ch6.text = "كوشوكتين عمود شيال امامي و الخلفي يمين"
                                bindingR2.s3erR2sAcx.setText("25")
                            } else {
                                if (bindingR2.outsideright.isChecked && bindingR2.outsideleft.isChecked && bindingR2.insideleft.isChecked) {
                                    ch6.text = "كوشوكتين عمود شيال امامي  و الخلفي يسار"
                                    bindingR2.s3erR2sAcx.setText("25")
                                } else {
                                    if (bindingR2.outsideright.isChecked && bindingR2.insideright.isChecked && bindingR2.insideleft.isChecked) {
                                        ch6.text = "كوشوكة عمود شيال امامي يمين و الخلفيتين"
                                        bindingR2.s3erR2sAcx.setText("20")
                                    } else {
                                        if (bindingR2.outsideleft.isChecked && bindingR2.insideright.isChecked && bindingR2.insideleft.isChecked) {
                                            ch6.text = "كوشوكة عمود شيال امامي يسار و الخلفيتين"
                                            bindingR2.s3erR2sAcx.setText("20")
                                        } else {
                                            if (bindingR2.outsideright.isChecked && bindingR2.outsideleft.isChecked) {
                                                ch6.text = "كوشوكة عمود شيال امامي يمين و يسار"
                                                bindingR2.s3erR2sAcx.setText("20")
                                            } else {
                                                if (bindingR2.outsideright.isChecked && bindingR2.insideright.isChecked) {
                                                    ch6.text = "كوشوكة عمود شيال امامي يمين و خلفي يمين"
                                                    bindingR2.s3erR2sAcx.setText("15")
                                                } else {
                                                    if (bindingR2.outsideright.isChecked && bindingR2.insideleft.isChecked) {
                                                        ch6.text = "كوشوكة عمود شيال امامي يمين و خلفي يسار"
                                                        bindingR2.s3erR2sAcx.setText("15")
                                                    } else {
                                                        if (bindingR2.outsideleft.isChecked && bindingR2.insideright.isChecked) {
                                                            ch6.text =
                                                                "كوشوكة عمود شيال امامي يسار و خلفي يمين"
                                                            bindingR2.s3erR2sAcx.setText("15")
                                                        } else {
                                                            if (bindingR2.outsideleft.isChecked && bindingR2.insideleft.isChecked) {
                                                                ch6.text =
                                                                    "كوشوكة عمود شيال امامي يسار و خلفي يسار"
                                                                bindingR2.s3erR2sAcx.setText("15")
                                                            } else {
                                                                if (bindingR2.insideright.isChecked && bindingR2.insideleft.isChecked) {
                                                                    ch6.text =
                                                                        "كوشوكة عمود شيال خلفي يمين و يسار"
                                                                    bindingR2.s3erR2sAcx.setText(
                                                                        "10"
                                                                    )
                                                                } else {

                                                                    if (bindingR2.outsideright.isChecked) {
                                                                        ch6.text =
                                                                            "كوشوكة عمود شيال امامي يمين"
                                                                        bindingR2.s3erR2sAcx.setText(
                                                                            "10"
                                                                        )
                                                                    }
                                                                    if (bindingR2.outsideleft.isChecked) {
                                                                        ch6.text =
                                                                            "كوشوكة عمود شيال امامي يسار"
                                                                        bindingR2.s3erR2sAcx.setText(
                                                                            "10"
                                                                        )
                                                                    }
                                                                    if (bindingR2.insideleft.isChecked) {
                                                                        ch6.text =
                                                                            "كوشوكة عمود شيال خلفي يسار"
                                                                        bindingR2.s3erR2sAcx.setText(
                                                                            "5"
                                                                        )
                                                                    }
                                                                    if (bindingR2.insideright.isChecked) {
                                                                        ch6.text =
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
                            ch6.text = "كوشوكة عمود شيال خلفي يمين"
                        } else {
                            ch6.text = "كوشوكة عمود شيال "
                            bindingR2.s3erR2sAcx.setText("")
                        }
                        if (bindingR2.outsideright.isChecked && bindingR2.outsideleft.isChecked && bindingR2.insideright.isChecked && bindingR2.insideleft.isChecked) {
                            ch6.text = "تغير جميع كوشوكات عمود الشيال"
                            bindingR2.s3erR2sAcx.setText("30")
                        } else {
                            if (bindingR2.outsideright.isChecked && bindingR2.outsideleft.isChecked && bindingR2.insideright.isChecked) {
                                ch6.text = "كوشوكتين عمود شيال امامي و الخلفي يمين"
                                bindingR2.s3erR2sAcx.setText("25")
                            } else {
                                if (bindingR2.outsideright.isChecked && bindingR2.outsideleft.isChecked && bindingR2.insideleft.isChecked) {
                                    ch6.text = "كوشوكتين عمود شيال امامي  و الخلفي يسار"
                                    bindingR2.s3erR2sAcx.setText("25")
                                } else {
                                    if (bindingR2.outsideright.isChecked && bindingR2.insideright.isChecked && bindingR2.insideleft.isChecked) {
                                        ch6.text = "كوشوكة عمود شيال امامي يمين و الخلفيتين"
                                        bindingR2.s3erR2sAcx.setText("20")
                                    } else {
                                        if (bindingR2.outsideleft.isChecked && bindingR2.insideright.isChecked && bindingR2.insideleft.isChecked) {
                                            ch6.text = "كوشوكة عمود شيال امامي يسار و الخلفيتين"
                                            bindingR2.s3erR2sAcx.setText("20")
                                        } else {
                                            if (bindingR2.outsideright.isChecked && bindingR2.outsideleft.isChecked) {
                                                ch6.text = "كوشوكة عمود شيال امامي يمين و يسار"
                                                bindingR2.s3erR2sAcx.setText("20")
                                            } else {
                                                if (bindingR2.outsideright.isChecked && bindingR2.insideright.isChecked) {
                                                    ch6.text = "كوشوكة عمود شيال امامي يمين و خلفي يمين"
                                                    bindingR2.s3erR2sAcx.setText("15")
                                                } else {
                                                    if (bindingR2.outsideright.isChecked && bindingR2.insideleft.isChecked) {
                                                        ch6.text = "كوشوكة عمود شيال امامي يمين و خلفي يسار"
                                                        bindingR2.s3erR2sAcx.setText("15")
                                                    } else {
                                                        if (bindingR2.outsideleft.isChecked && bindingR2.insideright.isChecked) {
                                                            ch6.text =
                                                                "كوشوكة عمود شيال امامي يسار و خلفي يمين"
                                                            bindingR2.s3erR2sAcx.setText("15")
                                                        } else {
                                                            if (bindingR2.outsideleft.isChecked && bindingR2.insideleft.isChecked) {
                                                                ch6.text =
                                                                    "كوشوكة عمود شيال امامي يسار و خلفي يسار"
                                                                bindingR2.s3erR2sAcx.setText("15")
                                                            } else {
                                                                if (bindingR2.insideright.isChecked && bindingR2.insideleft.isChecked) {
                                                                    ch6.text =
                                                                        "كوشوكة عمود شيال خلفي يمين و يسار"
                                                                    bindingR2.s3erR2sAcx.setText(
                                                                        "10"
                                                                    )
                                                                } else {
                                                                    if (bindingR2.outsideright.isChecked) {
                                                                        ch6.text =
                                                                            "كوشوكة عمود شيال امامي يمين"
                                                                        bindingR2.s3erR2sAcx.setText(
                                                                            "10"
                                                                        )
                                                                    }
                                                                    if (bindingR2.outsideleft.isChecked) {
                                                                        ch6.text =
                                                                            "كوشوكة عمود شيال امامي يسار"
                                                                        bindingR2.s3erR2sAcx.setText(
                                                                            "10"
                                                                        )
                                                                    }
                                                                    if (bindingR2.insideleft.isChecked) {
                                                                        ch6.text =
                                                                            "كوشوكة عمود شيال خلفي يسار"
                                                                        bindingR2.s3erR2sAcx.setText(
                                                                            "5"
                                                                        )
                                                                    }
                                                                    if (bindingR2.insideright.isChecked) {
                                                                        ch6.text =
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
                                pric6.text = bindingR2.s3erR2sAcx.text.toString()
                                customDialogR2SX.dismiss()
                            }
                        }
                    }
                    bindingR2.btnR2sCan.setOnClickListener {
                        if (pric6.text.toString().isEmpty()) {
                            ch6.text = "كوشوكة عمود شيال"
                            ch6.isChecked = false
                        }
                        customDialogR2SX.dismiss()
                    }
                    bindingR2.outsideright.isChecked = false
                    bindingR2.outsideleft.isChecked = false
                    bindingR2.insideright.isChecked = false
                    bindingR2.insideleft.isChecked = false
                    customDialogR2SX.show()

                }
                    else {
                        ch6.text = "كوشوكة عمود شيال"
                        pric6.text = ""
                    }
                }
            }

        binding.apply{
            ch7.setOnCheckedChangeListener { _, isChecked ->
                if (ch7.isChecked) {

                    bindingR2.titR2sOut.text = "خارجية"
                    bindingR2.titR2sIn.text = "داخلية"
                    customDialogR2SX.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

                    val window = customDialogR2SX.window
                    window?.setGravity(Gravity.BOTTOM)
                    val lp = window?.attributes
                    lp?.dimAmount = 0.0f
                    lp?.flags = lp?.flags?.or(WindowManager.LayoutParams.FLAG_DIM_BEHIND)
                    window?.attributes = lp

                    bindingR2.outsideright.setOnCheckedChangeListener { _, isChecked1 ->
                        if (bindingR2.outsideright.isChecked) {
                            ch7.text = "جوزة خارجية يمين"
                        } else {
                            ch7.text = "جوزة"
                            bindingR2.s3erR2sAcx.setText("")
                        }
                        if (bindingR2.outsideright.isChecked && bindingR2.outsideleft.isChecked && bindingR2.insideright.isChecked && bindingR2.insideleft.isChecked) {
                            ch7.text = "تغير جميع الجوزات"
                            bindingR2.s3erR2sAcx.setText("16")
                        } else {
                            if (bindingR2.outsideright.isChecked && bindingR2.outsideleft.isChecked && bindingR2.insideright.isChecked) {
                                ch7.text = "جوزتين خارجيات و الداخلية يمين"
                                bindingR2.s3erR2sAcx.setText("11")
                            } else {
                                if (bindingR2.outsideright.isChecked && bindingR2.outsideleft.isChecked && bindingR2.insideleft.isChecked) {
                                    ch7.text = "جوزتين خارجيات و الداخلية يسار"
                                    bindingR2.s3erR2sAcx.setText("11")
                                } else {
                                    if (bindingR2.outsideright.isChecked && bindingR2.insideright.isChecked && bindingR2.insideleft.isChecked) {
                                        ch7.text = "جوزة خارجية يمين و الداخليتين"
                                        bindingR2.s3erR2sAcx.setText("13")
                                    } else {
                                        if (bindingR2.outsideleft.isChecked && bindingR2.insideright.isChecked && bindingR2.insideleft.isChecked) {
                                            ch7.text = "جوزة خارجية يسار و الداخليتين"
                                            bindingR2.s3erR2sAcx.setText("13")
                                        } else {
                                            if (bindingR2.outsideright.isChecked && bindingR2.outsideleft.isChecked) {
                                                ch7.text = "جوزة خارجية يمين و يسار"
                                                bindingR2.s3erR2sAcx.setText("6")
                                            } else {
                                                if (bindingR2.outsideright.isChecked && bindingR2.insideright.isChecked) {
                                                    ch7.text = "جوزة خارجية يمين و داخلية يمين"
                                                    bindingR2.s3erR2sAcx.setText("8")
                                                } else {
                                                    if (bindingR2.outsideright.isChecked && bindingR2.insideleft.isChecked) {
                                                        ch7.text = "جوزة خارجية يمين و داخلية يسار"
                                                        bindingR2.s3erR2sAcx.setText("8")
                                                    } else {
                                                        if (bindingR2.outsideleft.isChecked && bindingR2.insideright.isChecked) {
                                                            ch7.text =
                                                                "جوزة خارجية يسار و داخلية يمين"
                                                            bindingR2.s3erR2sAcx.setText("8")
                                                        } else {
                                                            if (bindingR2.outsideleft.isChecked && bindingR2.insideleft.isChecked) {
                                                                ch7.text =
                                                                    "جوزة خارجية يسار و داخلية يسار"
                                                                bindingR2.s3erR2sAcx.setText("8")
                                                            } else {
                                                                if (bindingR2.insideright.isChecked && bindingR2.insideleft.isChecked) {
                                                                    ch7.text =
                                                                        "جوزة داخلية يمين و يسار"
                                                                    bindingR2.s3erR2sAcx.setText(
                                                                        "10"
                                                                    )
                                                                } else {

                                                                    if (bindingR2.outsideright.isChecked) {
                                                                        ch7.text =
                                                                            "جوزة خارجية يمين"
                                                                        bindingR2.s3erR2sAcx.setText(
                                                                            "3"
                                                                        )
                                                                    }
                                                                    if (bindingR2.outsideleft.isChecked) {
                                                                        ch7.text =
                                                                            "جوزة خارجية يسار"
                                                                        bindingR2.s3erR2sAcx.setText(
                                                                            "3"
                                                                        )
                                                                    }
                                                                    if (bindingR2.insideleft.isChecked) {
                                                                        ch7.text =
                                                                            "جوزة داخلية يسار"
                                                                        bindingR2.s3erR2sAcx.setText(
                                                                            "5"
                                                                        )
                                                                    }
                                                                    if (bindingR2.insideright.isChecked) {
                                                                        ch7.text =
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
                            ch7.text = "جوزة خارجية يمين"
                        } else {
                            ch7.text = "جوزة"
                            bindingR2.s3erR2sAcx.setText("")
                        }
                        if (bindingR2.outsideright.isChecked && bindingR2.outsideleft.isChecked && bindingR2.insideright.isChecked && bindingR2.insideleft.isChecked) {
                            ch7.text = "تغير جميع الجوزات"
                            bindingR2.s3erR2sAcx.setText("16")
                        } else {
                            if (bindingR2.outsideright.isChecked && bindingR2.outsideleft.isChecked && bindingR2.insideright.isChecked) {
                                ch7.text = "جوزتين خارجيات و الداخلية يمين"
                                bindingR2.s3erR2sAcx.setText("11")
                            } else {
                                if (bindingR2.outsideright.isChecked && bindingR2.outsideleft.isChecked && bindingR2.insideleft.isChecked) {
                                    ch7.text = "جوزتين خارجيات و الداخلية يسار"
                                    bindingR2.s3erR2sAcx.setText("11")
                                } else {
                                    if (bindingR2.outsideright.isChecked && bindingR2.insideright.isChecked && bindingR2.insideleft.isChecked) {
                                        ch7.text = "جوزة خارجية يمين و الداخليتين"
                                        bindingR2.s3erR2sAcx.setText("13")
                                    } else {
                                        if (bindingR2.outsideleft.isChecked && bindingR2.insideright.isChecked && bindingR2.insideleft.isChecked) {
                                            ch7.text = "جوزة خارجية يسار و الداخليتين"
                                            bindingR2.s3erR2sAcx.setText("13")
                                        } else {
                                            if (bindingR2.outsideright.isChecked && bindingR2.outsideleft.isChecked) {
                                                ch7.text = "جوزة خارجية يمين و يسار"
                                                bindingR2.s3erR2sAcx.setText("6")
                                            } else {
                                                if (bindingR2.outsideright.isChecked && bindingR2.insideright.isChecked) {
                                                    ch7.text = "جوزة خارجية يمين و داخلية يمين"
                                                    bindingR2.s3erR2sAcx.setText("8")
                                                } else {
                                                    if (bindingR2.outsideright.isChecked && bindingR2.insideleft.isChecked) {
                                                        ch7.text = "جوزة خارجية يمين و داخلية يسار"
                                                        bindingR2.s3erR2sAcx.setText("8")
                                                    } else {
                                                        if (bindingR2.outsideleft.isChecked && bindingR2.insideright.isChecked) {
                                                            ch7.text =
                                                                "جوزة خارجية يسار و داخلية يمين"
                                                            bindingR2.s3erR2sAcx.setText("8")
                                                        } else {
                                                            if (bindingR2.outsideleft.isChecked && bindingR2.insideleft.isChecked) {
                                                                ch7.text =
                                                                    "جوزة خارجية يسار و داخلية يسار"
                                                                bindingR2.s3erR2sAcx.setText("8")
                                                            } else {
                                                                if (bindingR2.insideright.isChecked && bindingR2.insideleft.isChecked) {
                                                                    ch7.text =
                                                                        "جوزة داخلية يمين و يسار"
                                                                    bindingR2.s3erR2sAcx.setText(
                                                                        "10"
                                                                    )
                                                                } else {

                                                                    if (bindingR2.outsideright.isChecked) {
                                                                        ch7.text =
                                                                            "جوزة خارجية يمين"
                                                                        bindingR2.s3erR2sAcx.setText(
                                                                            "3"
                                                                        )
                                                                    }
                                                                    if (bindingR2.outsideleft.isChecked) {
                                                                        ch7.text =
                                                                            "جوزة خارجية يسار"
                                                                        bindingR2.s3erR2sAcx.setText(
                                                                            "3"
                                                                        )
                                                                    }
                                                                    if (bindingR2.insideleft.isChecked) {
                                                                        ch7.text =
                                                                            "جوزة داخلية يسار"
                                                                        bindingR2.s3erR2sAcx.setText(
                                                                            "5"
                                                                        )
                                                                    }
                                                                    if (bindingR2.insideright.isChecked) {
                                                                        ch7.text =
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
                            ch7.text = "جوزة خارجية يمين"
                        } else {
                            ch7.text = "جوزة"
                            bindingR2.s3erR2sAcx.setText("")
                        }

                        if (bindingR2.outsideright.isChecked && bindingR2.outsideleft.isChecked && bindingR2.insideright.isChecked && bindingR2.insideleft.isChecked) {
                            ch7.text = "تغير جميع الجوزات"
                            bindingR2.s3erR2sAcx.setText("16")
                        } else {
                            if (bindingR2.outsideright.isChecked && bindingR2.outsideleft.isChecked && bindingR2.insideright.isChecked) {
                                ch7.text = "جوزتين خارجيات و الداخلية يمين"
                                bindingR2.s3erR2sAcx.setText("11")
                            } else {
                                if (bindingR2.outsideright.isChecked && bindingR2.outsideleft.isChecked && bindingR2.insideleft.isChecked) {
                                    ch7.text = "جوزتين خارجيات و الداخلية يسار"
                                    bindingR2.s3erR2sAcx.setText("11")
                                } else {
                                    if (bindingR2.outsideright.isChecked && bindingR2.insideright.isChecked && bindingR2.insideleft.isChecked) {
                                        ch7.text = "جوزة خارجية يمين و الداخليتين"
                                        bindingR2.s3erR2sAcx.setText("13")
                                    } else {
                                        if (bindingR2.outsideleft.isChecked && bindingR2.insideright.isChecked && bindingR2.insideleft.isChecked) {
                                            ch7.text = "جوزة خارجية يسار و الداخليتين"
                                            bindingR2.s3erR2sAcx.setText("13")
                                        } else {
                                            if (bindingR2.outsideright.isChecked && bindingR2.outsideleft.isChecked) {
                                                ch7.text = "جوزة خارجية يمين و يسار"
                                                bindingR2.s3erR2sAcx.setText("6")
                                            } else {
                                                if (bindingR2.outsideright.isChecked && bindingR2.insideright.isChecked) {
                                                    ch7.text = "جوزة خارجية يمين و داخلية يمين"
                                                    bindingR2.s3erR2sAcx.setText("8")
                                                } else {
                                                    if (bindingR2.outsideright.isChecked && bindingR2.insideleft.isChecked) {
                                                        ch7.text = "جوزة خارجية يمين و داخلية يسار"
                                                        bindingR2.s3erR2sAcx.setText("8")
                                                    } else {
                                                        if (bindingR2.outsideleft.isChecked && bindingR2.insideright.isChecked) {
                                                            ch7.text =
                                                                "جوزة خارجية يسار و داخلية يمين"
                                                            bindingR2.s3erR2sAcx.setText("8")
                                                        } else {
                                                            if (bindingR2.outsideleft.isChecked && bindingR2.insideleft.isChecked) {
                                                                ch7.text =
                                                                    "جوزة خارجية يسار و داخلية يسار"
                                                                bindingR2.s3erR2sAcx.setText("8")
                                                            } else {
                                                                if (bindingR2.insideright.isChecked && bindingR2.insideleft.isChecked) {
                                                                    ch7.text =
                                                                        "جوزة داخلية يمين و يسار"
                                                                    bindingR2.s3erR2sAcx.setText(
                                                                        "10"
                                                                    )
                                                                } else {

                                                                    if (bindingR2.outsideright.isChecked) {
                                                                        ch7.text =
                                                                            "جوزة خارجية يمين"
                                                                        bindingR2.s3erR2sAcx.setText(
                                                                            "3"
                                                                        )
                                                                    }
                                                                    if (bindingR2.outsideleft.isChecked) {
                                                                        ch7.text =
                                                                            "جوزة خارجية يسار"
                                                                        bindingR2.s3erR2sAcx.setText(
                                                                            "3"
                                                                        )
                                                                    }
                                                                    if (bindingR2.insideleft.isChecked) {
                                                                        ch7.text =
                                                                            "جوزة داخلية يسار"
                                                                        bindingR2.s3erR2sAcx.setText(
                                                                            "5"
                                                                        )
                                                                    }
                                                                    if (bindingR2.insideright.isChecked) {
                                                                        ch7.text =
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
                            ch7.text = "جوزة خارجية يمين"
                        } else {
                            ch7.text = "جوزة"
                            bindingR2.s3erR2sAcx.setText("")
                        }
                        if (bindingR2.outsideright.isChecked && bindingR2.outsideleft.isChecked && bindingR2.insideright.isChecked && bindingR2.insideleft.isChecked) {
                            ch7.text = "تغير جميع الجوزات"
                            bindingR2.s3erR2sAcx.setText("16")
                        } else {
                            if (bindingR2.outsideright.isChecked && bindingR2.outsideleft.isChecked && bindingR2.insideright.isChecked) {
                                ch7.text = "جوزتين خارجيات و الداخلية يمين"
                                bindingR2.s3erR2sAcx.setText("11")
                            } else {
                                if (bindingR2.outsideright.isChecked && bindingR2.outsideleft.isChecked && bindingR2.insideleft.isChecked) {
                                    ch7.text = "جوزتين خارجيات و الداخلية يسار"
                                    bindingR2.s3erR2sAcx.setText("11")
                                } else {
                                    if (bindingR2.outsideright.isChecked && bindingR2.insideright.isChecked && bindingR2.insideleft.isChecked) {
                                        ch7.text = "جوزة خارجية يمين و الداخليتين"
                                        bindingR2.s3erR2sAcx.setText("13")
                                    } else {
                                        if (bindingR2.outsideleft.isChecked && bindingR2.insideright.isChecked && bindingR2.insideleft.isChecked) {
                                            ch7.text = "جوزة خارجية يسار و الداخليتين"
                                            bindingR2.s3erR2sAcx.setText("13")
                                        } else {
                                            if (bindingR2.outsideright.isChecked && bindingR2.outsideleft.isChecked) {
                                                ch7.text = "جوزة خارجية يمين و يسار"
                                                bindingR2.s3erR2sAcx.setText("6")
                                            } else {
                                                if (bindingR2.outsideright.isChecked && bindingR2.insideright.isChecked) {
                                                    ch7.text = "جوزة خارجية يمين و داخلية يمين"
                                                    bindingR2.s3erR2sAcx.setText("8")
                                                } else {
                                                    if (bindingR2.outsideright.isChecked && bindingR2.insideleft.isChecked) {
                                                        ch7.text = "جوزة خارجية يمين و داخلية يسار"
                                                        bindingR2.s3erR2sAcx.setText("8")
                                                    } else {
                                                        if (bindingR2.outsideleft.isChecked && bindingR2.insideright.isChecked) {
                                                            ch7.text =
                                                                "جوزة خارجية يسار و داخلية يمين"
                                                            bindingR2.s3erR2sAcx.setText("8")
                                                        } else {
                                                            if (bindingR2.outsideleft.isChecked && bindingR2.insideleft.isChecked) {
                                                                ch7.text =
                                                                    "جوزة خارجية يسار و داخلية يسار"
                                                                bindingR2.s3erR2sAcx.setText("8")
                                                            } else {
                                                                if (bindingR2.insideright.isChecked && bindingR2.insideleft.isChecked) {
                                                                    ch7.text =
                                                                        "جوزة داخلية يمين و يسار"
                                                                    bindingR2.s3erR2sAcx.setText(
                                                                        "10"
                                                                    )
                                                                } else {
                                                                    if (bindingR2.outsideright.isChecked) {
                                                                        ch7.text =
                                                                            "جوزة خارجية يمين"
                                                                        bindingR2.s3erR2sAcx.setText(
                                                                            "3"
                                                                        )
                                                                    }
                                                                    if (bindingR2.outsideleft.isChecked) {
                                                                        ch7.text =
                                                                            "جوزة خارجية يسار"
                                                                        bindingR2.s3erR2sAcx.setText(
                                                                            "3"
                                                                        )
                                                                    }
                                                                    if (bindingR2.insideleft.isChecked) {
                                                                        ch7.text =
                                                                            "جوزة داخلية يسار"
                                                                        bindingR2.s3erR2sAcx.setText(
                                                                            "5"
                                                                        )
                                                                    }
                                                                    if (bindingR2.insideright.isChecked) {
                                                                        ch7.text =
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
                                pric7.text = bindingR2.s3erR2sAcx.text.toString()
                                customDialogR2SX.dismiss()
                            }
                        }
                    }
                    bindingR2.btnR2sCan.setOnClickListener {
                        if (pric7.text.toString().isEmpty()) {
                            ch7.text = "جوزة"
                            ch7.isChecked = false
                        }
                        customDialogR2SX.dismiss()
                    }
                    bindingR2.outsideright.isChecked = false
                    bindingR2.outsideleft.isChecked = false
                    bindingR2.insideright.isChecked = false
                    bindingR2.insideleft.isChecked = false
                    customDialogR2SX.show()

                }
                    else {
                        ch7.text = "جوزة"
                        pric7.text = ""
                    }
                }
            }

        binding.apply{
            ch8.setOnCheckedChangeListener { _, isChecked ->
                if (ch8.isChecked) {

                    customDialogR2SX.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
                    bindingR2.titR2sOut.text="علوية"
                    bindingR2.titR2sIn.text="سفلية"

                    val window = customDialogR2SX.window
                    window?.setGravity(Gravity.BOTTOM)
                    val lp = window?.attributes
                    lp?.dimAmount = 0.0f
                    lp?.flags = lp?.flags?.or(WindowManager.LayoutParams.FLAG_DIM_BEHIND)
                    window?.attributes = lp

                    bindingR2.outsideright.setOnCheckedChangeListener { _, isChecked1 ->
                        if (bindingR2.outsideright.isChecked) {
                            ch8.text = "بيضة علوية يمين"
                        } else {
                            ch8.text = "بيضة"
                            bindingR2.s3erR2sAcx.setText("")
                        }
                        if (bindingR2.outsideright.isChecked && bindingR2.outsideleft.isChecked && bindingR2.insideright.isChecked && bindingR2.insideleft.isChecked) {
                            ch8.text = "تغير جميع البيضات"
                            bindingR2.s3erR2sAcx.setText("20")
                        } else {
                            if (bindingR2.outsideright.isChecked && bindingR2.outsideleft.isChecked && bindingR2.insideright.isChecked) {
                                ch8.text = "بيضتين علوية و السفلية يمين"
                                bindingR2.s3erR2sAcx.setText("15")
                            } else {
                                if (bindingR2.outsideright.isChecked && bindingR2.outsideleft.isChecked && bindingR2.insideleft.isChecked) {
                                    ch8.text = "بيضتين علوية و السفلية يسار"
                                    bindingR2.s3erR2sAcx.setText("15")
                                } else {
                                    if (bindingR2.outsideright.isChecked && bindingR2.insideright.isChecked && bindingR2.insideleft.isChecked) {
                                        ch8.text = "بيضة علوية يمين و السفليتين"
                                        bindingR2.s3erR2sAcx.setText("15")
                                    } else {
                                        if (bindingR2.outsideleft.isChecked && bindingR2.insideright.isChecked && bindingR2.insideleft.isChecked) {
                                            ch8.text = "بيضة علوية يسار و السفليتين"
                                            bindingR2.s3erR2sAcx.setText("15")
                                        } else {
                                            if (bindingR2.outsideright.isChecked && bindingR2.outsideleft.isChecked) {
                                                ch8.text = "بيضة علوية يمين و يسار"
                                                bindingR2.s3erR2sAcx.setText("10")
                                            } else {
                                                if (bindingR2.outsideright.isChecked && bindingR2.insideright.isChecked) {
                                                    ch8.text = "بيضة علوية يمين و السفلية يمين"
                                                    bindingR2.s3erR2sAcx.setText("10")
                                                } else {
                                                    if (bindingR2.outsideright.isChecked && bindingR2.insideleft.isChecked) {
                                                        ch8.text = "بيضة علوية يمين و السفلية يسار"
                                                        bindingR2.s3erR2sAcx.setText("10")
                                                    } else {
                                                        if (bindingR2.outsideleft.isChecked && bindingR2.insideright.isChecked) {
                                                            ch8.text =
                                                                "بيضة علوية يسار و السفلية يمين"
                                                            bindingR2.s3erR2sAcx.setText("10")
                                                        } else {
                                                            if (bindingR2.outsideleft.isChecked && bindingR2.insideleft.isChecked) {
                                                                ch8.text =
                                                                    "بيضة علوية يسار و السفلية يسار"
                                                                bindingR2.s3erR2sAcx.setText("10")
                                                            } else {
                                                                if (bindingR2.insideright.isChecked && bindingR2.insideleft.isChecked) {
                                                                    ch8.text =
                                                                        "بيضة سفلية يمين و يسار"
                                                                    bindingR2.s3erR2sAcx.setText(
                                                                        "10"
                                                                    )
                                                                } else {
                                                                    if (bindingR2.outsideright.isChecked) {
                                                                        ch8.text =
                                                                            "بيضة علوية يمين"
                                                                        bindingR2.s3erR2sAcx.setText(
                                                                            "5"
                                                                        )
                                                                    }
                                                                    if (bindingR2.outsideleft.isChecked) {
                                                                        ch8.text =
                                                                            "بيضة علوية يسار"
                                                                        bindingR2.s3erR2sAcx.setText(
                                                                            "5"
                                                                        )
                                                                    }
                                                                    if (bindingR2.insideleft.isChecked) {
                                                                        ch8.text =
                                                                            "بيضة سفلية يسار"
                                                                        bindingR2.s3erR2sAcx.setText(
                                                                            "5"
                                                                        )
                                                                    }
                                                                    if (bindingR2.insideright.isChecked) {
                                                                        ch8.text =
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
                            ch8.text = "بيضة علوية يسار"
                        } else {
                            ch8.text = "بيضة"
                            bindingR2.s3erR2sAcx.setText("")
                        }
                        if (bindingR2.outsideright.isChecked && bindingR2.outsideleft.isChecked && bindingR2.insideright.isChecked && bindingR2.insideleft.isChecked) {
                            ch8.text = "تغير جميع البيضات"
                            bindingR2.s3erR2sAcx.setText("20")
                        } else {
                            if (bindingR2.outsideright.isChecked && bindingR2.outsideleft.isChecked && bindingR2.insideright.isChecked) {
                                ch8.text = "بيضتين علوية و السفلية يمين"
                                bindingR2.s3erR2sAcx.setText("15")
                            } else {
                                if (bindingR2.outsideright.isChecked && bindingR2.outsideleft.isChecked && bindingR2.insideleft.isChecked) {
                                    ch8.text = "بيضتين علوية و السفلية يسار"
                                    bindingR2.s3erR2sAcx.setText("15")
                                } else {
                                    if (bindingR2.outsideright.isChecked && bindingR2.insideright.isChecked && bindingR2.insideleft.isChecked) {
                                        ch8.text = "بيضة علوية يمين و السفليتين"
                                        bindingR2.s3erR2sAcx.setText("15")
                                    } else {
                                        if (bindingR2.outsideleft.isChecked && bindingR2.insideright.isChecked && bindingR2.insideleft.isChecked) {
                                            ch8.text = "بيضة علوية يسار و السفليتين"
                                            bindingR2.s3erR2sAcx.setText("15")
                                        } else {
                                            if (bindingR2.outsideright.isChecked && bindingR2.outsideleft.isChecked) {
                                                ch8.text = "بيضة علوية يمين و يسار"
                                                bindingR2.s3erR2sAcx.setText("10")
                                            } else {
                                                if (bindingR2.outsideright.isChecked && bindingR2.insideright.isChecked) {
                                                    ch8.text = "بيضة علوية يمين و السفلية يمين"
                                                    bindingR2.s3erR2sAcx.setText("10")
                                                } else {
                                                    if (bindingR2.outsideright.isChecked && bindingR2.insideleft.isChecked) {
                                                        ch8.text = "بيضة علوية يمين و السفلية يسار"
                                                        bindingR2.s3erR2sAcx.setText("10")
                                                    } else {
                                                        if (bindingR2.outsideleft.isChecked && bindingR2.insideright.isChecked) {
                                                            ch8.text =
                                                                "بيضة علوية يسار و السفلية يمين"
                                                            bindingR2.s3erR2sAcx.setText("10")
                                                        } else {
                                                            if (bindingR2.outsideleft.isChecked && bindingR2.insideleft.isChecked) {
                                                                ch8.text =
                                                                    "بيضة علوية يسار و السفلية يسار"
                                                                bindingR2.s3erR2sAcx.setText("10")
                                                            } else {
                                                                if (bindingR2.insideright.isChecked && bindingR2.insideleft.isChecked) {
                                                                    ch8.text =
                                                                        "بيضة سفلية يمين و يسار"
                                                                    bindingR2.s3erR2sAcx.setText(
                                                                        "10"
                                                                    )
                                                                } else {
                                                                    if (bindingR2.outsideright.isChecked) {
                                                                        ch8.text =
                                                                            "بيضة علوية يمين"
                                                                        bindingR2.s3erR2sAcx.setText(
                                                                            "5"
                                                                        )
                                                                    }
                                                                    if (bindingR2.outsideleft.isChecked) {
                                                                        ch8.text =
                                                                            "بيضة علوية يسار"
                                                                        bindingR2.s3erR2sAcx.setText(
                                                                            "5"
                                                                        )
                                                                    }
                                                                    if (bindingR2.insideleft.isChecked) {
                                                                        ch8.text =
                                                                            "بيضة سفلية يسار"
                                                                        bindingR2.s3erR2sAcx.setText(
                                                                            "5"
                                                                        )
                                                                    }
                                                                    if (bindingR2.insideright.isChecked) {
                                                                        ch8.text =
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
                            ch8.text = "بيضة سفلية يمين"
                        } else {
                            ch8.text = "بيضة"
                            bindingR2.s3erR2sAcx.setText("")
                        }
                        if (bindingR2.outsideright.isChecked && bindingR2.outsideleft.isChecked && bindingR2.insideright.isChecked && bindingR2.insideleft.isChecked) {
                            ch8.text = "تغير جميع البيضات"
                            bindingR2.s3erR2sAcx.setText("20")
                        } else {
                            if (bindingR2.outsideright.isChecked && bindingR2.outsideleft.isChecked && bindingR2.insideright.isChecked) {
                                ch8.text = "بيضتين علوية و السفلية يمين"
                                bindingR2.s3erR2sAcx.setText("15")
                            } else {
                                if (bindingR2.outsideright.isChecked && bindingR2.outsideleft.isChecked && bindingR2.insideleft.isChecked) {
                                    ch8.text = "بيضتين علوية و السفلية يسار"
                                    bindingR2.s3erR2sAcx.setText("15")
                                } else {
                                    if (bindingR2.outsideright.isChecked && bindingR2.insideright.isChecked && bindingR2.insideleft.isChecked) {
                                        ch8.text = "بيضة علوية يمين و السفليتين"
                                        bindingR2.s3erR2sAcx.setText("15")
                                    } else {
                                        if (bindingR2.outsideleft.isChecked && bindingR2.insideright.isChecked && bindingR2.insideleft.isChecked) {
                                            ch8.text = "بيضة علوية يسار و السفليتين"
                                            bindingR2.s3erR2sAcx.setText("15")
                                        } else {
                                            if (bindingR2.outsideright.isChecked && bindingR2.outsideleft.isChecked) {
                                                ch8.text = "بيضة علوية يمين و يسار"
                                                bindingR2.s3erR2sAcx.setText("10")
                                            } else {
                                                if (bindingR2.outsideright.isChecked && bindingR2.insideright.isChecked) {
                                                    ch8.text = "بيضة علوية يمين و السفلية يمين"
                                                    bindingR2.s3erR2sAcx.setText("10")
                                                } else {
                                                    if (bindingR2.outsideright.isChecked && bindingR2.insideleft.isChecked) {
                                                        ch8.text = "بيضة علوية يمين و السفلية يسار"
                                                        bindingR2.s3erR2sAcx.setText("10")
                                                    } else {
                                                        if (bindingR2.outsideleft.isChecked && bindingR2.insideright.isChecked) {
                                                            ch8.text =
                                                                "بيضة علوية يسار و السفلية يمين"
                                                            bindingR2.s3erR2sAcx.setText("10")
                                                        } else {
                                                            if (bindingR2.outsideleft.isChecked && bindingR2.insideleft.isChecked) {
                                                                ch8.text =
                                                                    "بيضة علوية يسار و السفلية يسار"
                                                                bindingR2.s3erR2sAcx.setText("10")
                                                            } else {
                                                                if (bindingR2.insideright.isChecked && bindingR2.insideleft.isChecked) {
                                                                    ch8.text =
                                                                        "بيضة سفلية يمين و يسار"
                                                                    bindingR2.s3erR2sAcx.setText(
                                                                        "10"
                                                                    )
                                                                } else {
                                                                    if (bindingR2.outsideright.isChecked) {
                                                                        ch8.text =
                                                                            "بيضة علوية يمين"
                                                                        bindingR2.s3erR2sAcx.setText(
                                                                            "5"
                                                                        )
                                                                    }
                                                                    if (bindingR2.outsideleft.isChecked) {
                                                                        ch8.text =
                                                                            "بيضة علوية يسار"
                                                                        bindingR2.s3erR2sAcx.setText(
                                                                            "5"
                                                                        )
                                                                    }
                                                                    if (bindingR2.insideleft.isChecked) {
                                                                        ch8.text =
                                                                            "بيضة سفلية يسار"
                                                                        bindingR2.s3erR2sAcx.setText(
                                                                            "5"
                                                                        )
                                                                    }
                                                                    if (bindingR2.insideright.isChecked) {
                                                                        ch8.text =
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
                            ch8.text = "بيضة سفلية يمين"
                        } else {
                            ch8.text = "بيضة"
                            bindingR2.s3erR2sAcx.setText("")
                        }
                        if (bindingR2.outsideright.isChecked && bindingR2.outsideleft.isChecked && bindingR2.insideright.isChecked && bindingR2.insideleft.isChecked) {
                            ch8.text = "تغير جميع البيضات"
                            bindingR2.s3erR2sAcx.setText("20")
                        } else {
                            if (bindingR2.outsideright.isChecked && bindingR2.outsideleft.isChecked && bindingR2.insideright.isChecked) {
                                ch8.text = "بيضتين علوية و السفلية يمين"
                                bindingR2.s3erR2sAcx.setText("15")
                            } else {
                                if (bindingR2.outsideright.isChecked && bindingR2.outsideleft.isChecked && bindingR2.insideleft.isChecked) {
                                    ch8.text = "بيضتين علوية و السفلية يسار"
                                    bindingR2.s3erR2sAcx.setText("15")
                                } else {
                                    if (bindingR2.outsideright.isChecked && bindingR2.insideright.isChecked && bindingR2.insideleft.isChecked) {
                                        ch8.text = "بيضة علوية يمين و السفليتين"
                                        bindingR2.s3erR2sAcx.setText("15")
                                    } else {
                                        if (bindingR2.outsideleft.isChecked && bindingR2.insideright.isChecked && bindingR2.insideleft.isChecked) {
                                            ch8.text = "بيضة علوية يسار و السفليتين"
                                            bindingR2.s3erR2sAcx.setText("15")
                                        } else {
                                            if (bindingR2.outsideright.isChecked && bindingR2.outsideleft.isChecked) {
                                                ch8.text = "بيضة علوية يمين و يسار"
                                                bindingR2.s3erR2sAcx.setText("10")
                                            } else {
                                                if (bindingR2.outsideright.isChecked && bindingR2.insideright.isChecked) {
                                                    ch8.text = "بيضة علوية يمين و السفلية يمين"
                                                    bindingR2.s3erR2sAcx.setText("10")
                                                } else {
                                                    if (bindingR2.outsideright.isChecked && bindingR2.insideleft.isChecked) {
                                                        ch8.text = "بيضة علوية يمين و السفلية يسار"
                                                        bindingR2.s3erR2sAcx.setText("10")
                                                    } else {
                                                        if (bindingR2.outsideleft.isChecked && bindingR2.insideright.isChecked) {
                                                            ch8.text =
                                                                "بيضة علوية يسار و السفلية يمين"
                                                            bindingR2.s3erR2sAcx.setText("10")
                                                        } else {
                                                            if (bindingR2.outsideleft.isChecked && bindingR2.insideleft.isChecked) {
                                                                ch8.text =
                                                                    "بيضة علوية يسار و السفلية يسار"
                                                                bindingR2.s3erR2sAcx.setText("10")
                                                            } else {
                                                                if (bindingR2.insideright.isChecked && bindingR2.insideleft.isChecked) {
                                                                    ch8.text =
                                                                        "بيضة سفلية يمين و يسار"
                                                                    bindingR2.s3erR2sAcx.setText(
                                                                        "10"
                                                                    )
                                                                } else {
                                                                    if (bindingR2.outsideright.isChecked) {
                                                                        ch8.text =
                                                                            "بيضة علوية يمين"
                                                                        bindingR2.s3erR2sAcx.setText(
                                                                            "5"
                                                                        )
                                                                    }
                                                                    if (bindingR2.outsideleft.isChecked) {
                                                                        ch8.text =
                                                                            "بيضة علوية يسار"
                                                                        bindingR2.s3erR2sAcx.setText(
                                                                            "5"
                                                                        )
                                                                    }
                                                                    if (bindingR2.insideleft.isChecked) {
                                                                        ch8.text =
                                                                            "بيضة سفلية يسار"
                                                                        bindingR2.s3erR2sAcx.setText(
                                                                            "5"
                                                                        )
                                                                    }
                                                                    if (bindingR2.insideright.isChecked) {
                                                                        ch8.text =
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
                                pric8.text = bindingR2.s3erR2sAcx.text.toString()
                                customDialogR2SX.dismiss()
                            }
                        }
                    }
                    bindingR2.btnR2sCan.setOnClickListener {
                        if (pric8.text.toString().isEmpty()) {
                            ch8.text = "بيضة"
                            ch8.isChecked = false
                        }
                        customDialogR2SX.dismiss()
                    }
                    bindingR2.outsideright.isChecked = false
                    bindingR2.outsideleft.isChecked = false
                    bindingR2.insideright.isChecked = false
                    bindingR2.insideleft.isChecked = false
                    customDialogR2SX.show()
                }
                    else {
                        ch8.text = "بيضة"
                        pric8.text = ""
                    }
                }
            }

        binding.apply{
            ch9.setOnCheckedChangeListener { _, isChecked ->
                if (ch9.isChecked) {

                    val window = customDialogFR.window
                    window?.setGravity(Gravity.TOP)
                    val lp = window?.attributes
                    lp?.dimAmount = 0.0f
                    lp?.flags = lp?.flags?.or(WindowManager.LayoutParams.FLAG_DIM_BEHIND)
                    window?.attributes = lp

                    bindingFR.frontright.setOnCheckedChangeListener { _, isChecked1 ->
                        if (bindingFR.frontright.isChecked) {
                            ch9.text = "شمزة اكس يمين"
                        } else {
                            ch9.text = "شمزة اكس"
                            bindingFR.s3erYadwee.setText("")
                        }
                        if (bindingFR.frontright.isChecked && bindingFR.frontleft.isChecked) {
                            ch9.text = "شمزة اكس يمين و يسار"
                            bindingFR.s3erYadwee.setText("10")
                        } else {
                            if (bindingFR.frontright.isChecked) {
                                ch9.text = "شمزة اكس يمين"
                                bindingFR.s3erYadwee.setText("5")
                            }
                            if (bindingFR.frontleft.isChecked) {
                                ch9.text = "شمزة اكس يسار"
                                bindingFR.s3erYadwee.setText("5")
                            }
                        }
                    }

                    bindingFR.frontleft.setOnCheckedChangeListener { _, isChecked2 ->
                        if (bindingFR.frontleft.isChecked) {
                            ch9.text = "شمزة اكس يسار"
                        } else {
                            ch9.text = "شمزة اكس"
                            bindingFR.s3erYadwee.setText("")
                        }
                        if (bindingFR.frontright.isChecked && bindingFR.frontleft.isChecked) {
                            ch9.text = "شمزة اكس يمين و يسار"
                            bindingFR.s3erYadwee.setText("10")
                        } else {
                            if (bindingFR.frontleft.isChecked) {
                                ch9.text = "شمزة اكس يسار"
                                bindingFR.s3erYadwee.setText("5")
                            }
                            if (bindingFR.frontright.isChecked) {
                                ch9.text = "شمزة اكس يمين"
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
                                ch9.isChecked = false
                            } else {
                                pric9.text = bindingFR.s3erYadwee.text.toString()
                                customDialogFR.dismiss()
                            }
                        }
                    }
                    bindingFR.buttonDailogCancel.setOnClickListener {
                        ch9.isChecked = false
                        bindingFR.s3erYadwee.setText("")
                        customDialogFR.dismiss()
                    }
                    bindingFR.frontright.isChecked = false
                    bindingFR.frontleft.isChecked = false
                    customDialogFR.show()

                }
                else {
                    ch9.text = "شمزة اكس"
                    pric9.text = ""
                }
            }
        }

        binding.apply{
            ch10.setOnCheckedChangeListener { _, isChecked ->
                if (ch10.isChecked) {

                    customDialogR2SX.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

                    bindingR2.titR2sOut.text="امامي"
                    bindingR2.titR2sIn.text="خلفي"

                    val window = customDialogR2SX.window
                    window?.setGravity(Gravity.TOP)
                    val lp = window?.attributes
                    lp?.dimAmount = 0.0f
                    lp?.flags = lp?.flags?.or(WindowManager.LayoutParams.FLAG_DIM_BEHIND)
                    window?.attributes = lp

                    bindingR2.outsideright.setOnCheckedChangeListener { _, isChecked1 ->
                        if (bindingR2.outsideright.isChecked) {
                            ch10.text = "عمود توازن جوزة امامي يمين"
                        } else {
                            ch10.text = "عمود توازن جوزة"
                            bindingR2.s3erR2sAcx.setText("")
                        }
                        if (bindingR2.outsideright.isChecked && bindingR2.outsideleft.isChecked && bindingR2.insideright.isChecked && bindingR2.insideleft.isChecked) {
                            ch10.text = "تغير عمود توازن جوزة كامل"
                            bindingR2.s3erR2sAcx.setText("12")
                        } else {
                            if (bindingR2.outsideright.isChecked && bindingR2.outsideleft.isChecked && bindingR2.insideright.isChecked) {
                                ch10.text = "عمودين توازن جوزة امامي و الخلفي يمين"
                                bindingR2.s3erR2sAcx.setText("9")
                            } else {
                                if (bindingR2.outsideright.isChecked && bindingR2.outsideleft.isChecked && bindingR2.insideleft.isChecked) {
                                    ch10.text = "عمودين توازن جوزة امامي  و الخلفي يسار"
                                    bindingR2.s3erR2sAcx.setText("9")
                                } else {
                                    if (bindingR2.outsideright.isChecked && bindingR2.insideright.isChecked && bindingR2.insideleft.isChecked) {
                                        ch10.text = "عمود توازن جوزة امامي يمين و الخلفيتين"
                                        bindingR2.s3erR2sAcx.setText("9")
                                    } else {
                                        if (bindingR2.outsideleft.isChecked && bindingR2.insideright.isChecked && bindingR2.insideleft.isChecked) {
                                            ch10.text = "عمود توازن جوزة امامي يسار و الخلفيتين"
                                            bindingR2.s3erR2sAcx.setText("9")
                                        } else {
                                            if (bindingR2.outsideright.isChecked && bindingR2.outsideleft.isChecked) {
                                                ch10.text = "عمود توازن جوزة امامي يمين و يسار"
                                                bindingR2.s3erR2sAcx.setText("6")
                                            } else {
                                                if (bindingR2.outsideright.isChecked && bindingR2.insideright.isChecked) {
                                                    ch10.text = "عمود توازن جوزة امامي يمين و خلفي يمين"
                                                    bindingR2.s3erR2sAcx.setText("6")
                                                } else {
                                                    if (bindingR2.outsideright.isChecked && bindingR2.insideleft.isChecked) {
                                                        ch10.text = "عمود توازن جوزة امامي يمين و خلفي يسار"
                                                        bindingR2.s3erR2sAcx.setText("6")
                                                    } else {
                                                        if (bindingR2.outsideleft.isChecked && bindingR2.insideright.isChecked) {
                                                            ch10.text =
                                                                "عمود توازن جوزة امامي يسار و خلفي يمين"
                                                            bindingR2.s3erR2sAcx.setText("6")
                                                        } else {
                                                            if (bindingR2.outsideleft.isChecked && bindingR2.insideleft.isChecked) {
                                                                ch10.text =
                                                                    "عمود توازن جوزة امامي يسار و خلفي يسار"
                                                                bindingR2.s3erR2sAcx.setText("6")
                                                            } else {
                                                                if (bindingR2.insideright.isChecked && bindingR2.insideleft.isChecked) {
                                                                    ch10.text =
                                                                        "عمود توازن جوزة خلفي يمين و يسار"
                                                                    bindingR2.s3erR2sAcx.setText(
                                                                        "3"
                                                                    )
                                                                } else {
                                                                    if (bindingR2.outsideright.isChecked) {
                                                                        ch10.text =
                                                                            "عمود توازن جوزة امامي يمين"
                                                                        bindingR2.s3erR2sAcx.setText(
                                                                            "3"
                                                                        )
                                                                    }
                                                                    if (bindingR2.outsideleft.isChecked) {
                                                                        ch10.text =
                                                                            "عمود توازن جوزة امامي يسار"
                                                                        bindingR2.s3erR2sAcx.setText(
                                                                            "3"
                                                                        )
                                                                    }
                                                                    if (bindingR2.insideleft.isChecked) {
                                                                        ch10.text =
                                                                            "عمود توازن جوزة خلفي يسار"
                                                                        bindingR2.s3erR2sAcx.setText(
                                                                            "3"
                                                                        )
                                                                    }
                                                                    if (bindingR2.insideright.isChecked) {
                                                                        ch10.text =
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
                            ch10.text = "عمود توازن جوزة امامي يسار"
                        } else {
                            ch10.text = "عمود توازن جوزة"
                            bindingR2.s3erR2sAcx.setText("")
                        }
                        if (bindingR2.outsideright.isChecked && bindingR2.outsideleft.isChecked && bindingR2.insideright.isChecked && bindingR2.insideleft.isChecked) {
                            ch10.text = "تغير عمود توازن جوزة كامل"
                            bindingR2.s3erR2sAcx.setText("12")
                        } else {
                            if (bindingR2.outsideright.isChecked && bindingR2.outsideleft.isChecked && bindingR2.insideright.isChecked) {
                                ch10.text = "عمودين توازن جوزة امامي و الخلفي يمين"
                                bindingR2.s3erR2sAcx.setText("9")
                            } else {
                                if (bindingR2.outsideright.isChecked && bindingR2.outsideleft.isChecked && bindingR2.insideleft.isChecked) {
                                    ch10.text = "عمودين توازن جوزة امامي  و الخلفي يسار"
                                    bindingR2.s3erR2sAcx.setText("9")
                                } else {
                                    if (bindingR2.outsideright.isChecked && bindingR2.insideright.isChecked && bindingR2.insideleft.isChecked) {
                                        ch10.text = "عمود توازن جوزة امامي يمين و الخلفيتين"
                                        bindingR2.s3erR2sAcx.setText("9")
                                    } else {
                                        if (bindingR2.outsideleft.isChecked && bindingR2.insideright.isChecked && bindingR2.insideleft.isChecked) {
                                            ch10.text = "عمود توازن جوزة امامي يسار و الخلفيتين"
                                            bindingR2.s3erR2sAcx.setText("9")
                                        } else {
                                            if (bindingR2.outsideright.isChecked && bindingR2.outsideleft.isChecked) {
                                                ch10.text = "عمود توازن جوزة امامي يمين و يسار"
                                                bindingR2.s3erR2sAcx.setText("6")
                                            } else {
                                                if (bindingR2.outsideright.isChecked && bindingR2.insideright.isChecked) {
                                                    ch10.text = "عمود توازن جوزة امامي يمين و خلفي يمين"
                                                    bindingR2.s3erR2sAcx.setText("6")
                                                } else {
                                                    if (bindingR2.outsideright.isChecked && bindingR2.insideleft.isChecked) {
                                                        ch10.text = "عمود توازن جوزة امامي يمين و خلفي يسار"
                                                        bindingR2.s3erR2sAcx.setText("6")
                                                    } else {
                                                        if (bindingR2.outsideleft.isChecked && bindingR2.insideright.isChecked) {
                                                            ch10.text =
                                                                "عمود توازن جوزة امامي يسار و خلفي يمين"
                                                            bindingR2.s3erR2sAcx.setText("6")
                                                        } else {
                                                            if (bindingR2.outsideleft.isChecked && bindingR2.insideleft.isChecked) {
                                                                ch10.text =
                                                                    "عمود توازن جوزة امامي يسار و خلفي يسار"
                                                                bindingR2.s3erR2sAcx.setText("6")
                                                            } else {
                                                                if (bindingR2.insideright.isChecked && bindingR2.insideleft.isChecked) {
                                                                    ch10.text =
                                                                        "عمود توازن جوزة خلفي يمين و يسار"
                                                                    bindingR2.s3erR2sAcx.setText(
                                                                        "3"
                                                                    )
                                                                } else {
                                                                    if (bindingR2.outsideright.isChecked) {
                                                                        ch10.text =
                                                                            "عمود توازن جوزة امامي يمين"
                                                                        bindingR2.s3erR2sAcx.setText(
                                                                            "3"
                                                                        )
                                                                    }
                                                                    if (bindingR2.outsideleft.isChecked) {
                                                                        ch10.text =
                                                                            "عمود توازن جوزة امامي يسار"
                                                                        bindingR2.s3erR2sAcx.setText(
                                                                            "3"
                                                                        )
                                                                    }
                                                                    if (bindingR2.insideleft.isChecked) {
                                                                        ch10.text =
                                                                            "عمود توازن جوزة خلفي يسار"
                                                                        bindingR2.s3erR2sAcx.setText(
                                                                            "3"
                                                                        )
                                                                    }
                                                                    if (bindingR2.insideright.isChecked) {
                                                                        ch10.text =
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
                            ch10.text = "عمود توازن جوزة خلفي يمين"
                        } else {
                            ch10.text = "عمود توازن جوزة"
                            bindingR2.s3erR2sAcx.setText("")
                        }
                        if (bindingR2.outsideright.isChecked && bindingR2.outsideleft.isChecked && bindingR2.insideright.isChecked && bindingR2.insideleft.isChecked) {
                            ch10.text = "تغير عمود توازن جوزة كامل"
                            bindingR2.s3erR2sAcx.setText("12")
                        } else {
                            if (bindingR2.outsideright.isChecked && bindingR2.outsideleft.isChecked && bindingR2.insideright.isChecked) {
                                ch10.text = "عمودين توازن جوزة امامي و الخلفي يمين"
                                bindingR2.s3erR2sAcx.setText("9")
                            } else {
                                if (bindingR2.outsideright.isChecked && bindingR2.outsideleft.isChecked && bindingR2.insideleft.isChecked) {
                                    ch10.text = "عمودين توازن جوزة امامي  و الخلفي يسار"
                                    bindingR2.s3erR2sAcx.setText("9")
                                } else {
                                    if (bindingR2.outsideright.isChecked && bindingR2.insideright.isChecked && bindingR2.insideleft.isChecked) {
                                        ch10.text = "عمود توازن جوزة امامي يمين و الخلفيتين"
                                        bindingR2.s3erR2sAcx.setText("9")
                                    } else {
                                        if (bindingR2.outsideleft.isChecked && bindingR2.insideright.isChecked && bindingR2.insideleft.isChecked) {
                                            ch10.text = "عمود توازن جوزة امامي يسار و الخلفيتين"
                                            bindingR2.s3erR2sAcx.setText("9")
                                        } else {
                                            if (bindingR2.outsideright.isChecked && bindingR2.outsideleft.isChecked) {
                                                ch10.text = "عمود توازن جوزة امامي يمين و يسار"
                                                bindingR2.s3erR2sAcx.setText("6")
                                            } else {
                                                if (bindingR2.outsideright.isChecked && bindingR2.insideright.isChecked) {
                                                    ch10.text = "عمود توازن جوزة امامي يمين و خلفي يمين"
                                                    bindingR2.s3erR2sAcx.setText("6")
                                                } else {
                                                    if (bindingR2.outsideright.isChecked && bindingR2.insideleft.isChecked) {
                                                        ch10.text = "عمود توازن جوزة امامي يمين و خلفي يسار"
                                                        bindingR2.s3erR2sAcx.setText("6")
                                                    } else {
                                                        if (bindingR2.outsideleft.isChecked && bindingR2.insideright.isChecked) {
                                                            ch10.text =
                                                                "عمود توازن جوزة امامي يسار و خلفي يمين"
                                                            bindingR2.s3erR2sAcx.setText("6")
                                                        } else {
                                                            if (bindingR2.outsideleft.isChecked && bindingR2.insideleft.isChecked) {
                                                                ch10.text =
                                                                    "عمود توازن جوزة امامي يسار و خلفي يسار"
                                                                bindingR2.s3erR2sAcx.setText("6")
                                                            } else {
                                                                if (bindingR2.insideright.isChecked && bindingR2.insideleft.isChecked) {
                                                                    ch10.text =
                                                                        "عمود توازن جوزة خلفي يمين و يسار"
                                                                    bindingR2.s3erR2sAcx.setText(
                                                                        "3"
                                                                    )
                                                                } else {
                                                                    if (bindingR2.outsideright.isChecked) {
                                                                        ch10.text =
                                                                            "عمود توازن جوزة امامي يمين"
                                                                        bindingR2.s3erR2sAcx.setText(
                                                                            "3"
                                                                        )
                                                                    }
                                                                    if (bindingR2.outsideleft.isChecked) {
                                                                        ch10.text =
                                                                            "عمود توازن جوزة امامي يسار"
                                                                        bindingR2.s3erR2sAcx.setText(
                                                                            "3"
                                                                        )
                                                                    }
                                                                    if (bindingR2.insideleft.isChecked) {
                                                                        ch10.text =
                                                                            "عمود توازن جوزة خلفي يسار"
                                                                        bindingR2.s3erR2sAcx.setText(
                                                                            "3"
                                                                        )
                                                                    }
                                                                    if (bindingR2.insideright.isChecked) {
                                                                        ch10.text =
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
                            ch10.text = "عمود توازن جوزة خلفي يمين"
                        } else {
                            ch10.text = "عمود توازن جوزة "
                            bindingR2.s3erR2sAcx.setText("")
                        }
                        if (bindingR2.outsideright.isChecked && bindingR2.outsideleft.isChecked && bindingR2.insideright.isChecked && bindingR2.insideleft.isChecked) {
                            ch10.text = "تغير عمود توازن جوزة كامل"
                            bindingR2.s3erR2sAcx.setText("12")
                        } else {
                            if (bindingR2.outsideright.isChecked && bindingR2.outsideleft.isChecked && bindingR2.insideright.isChecked) {
                                ch10.text = "عمودين توازن جوزة امامي و الخلفي يمين"
                                bindingR2.s3erR2sAcx.setText("9")
                            } else {
                                if (bindingR2.outsideright.isChecked && bindingR2.outsideleft.isChecked && bindingR2.insideleft.isChecked) {
                                    ch10.text = "عمودين توازن جوزة امامي  و الخلفي يسار"
                                    bindingR2.s3erR2sAcx.setText("9")
                                } else {
                                    if (bindingR2.outsideright.isChecked && bindingR2.insideright.isChecked && bindingR2.insideleft.isChecked) {
                                        ch10.text = "عمود توازن جوزة امامي يمين و الخلفيتين"
                                        bindingR2.s3erR2sAcx.setText("9")
                                    } else {
                                        if (bindingR2.outsideleft.isChecked && bindingR2.insideright.isChecked && bindingR2.insideleft.isChecked) {
                                            ch10.text = "عمود توازن جوزة امامي يسار و الخلفيتين"
                                            bindingR2.s3erR2sAcx.setText("9")
                                        } else {
                                            if (bindingR2.outsideright.isChecked && bindingR2.outsideleft.isChecked) {
                                                ch10.text = "عمود توازن جوزة امامي يمين و يسار"
                                                bindingR2.s3erR2sAcx.setText("6")
                                            } else {
                                                if (bindingR2.outsideright.isChecked && bindingR2.insideright.isChecked) {
                                                    ch10.text = "عمود توازن جوزة امامي يمين و خلفي يمين"
                                                    bindingR2.s3erR2sAcx.setText("6")
                                                } else {
                                                    if (bindingR2.outsideright.isChecked && bindingR2.insideleft.isChecked) {
                                                        ch10.text = "عمود توازن جوزة امامي يمين و خلفي يسار"
                                                        bindingR2.s3erR2sAcx.setText("6")
                                                    } else {
                                                        if (bindingR2.outsideleft.isChecked && bindingR2.insideright.isChecked) {
                                                            ch10.text =
                                                                "عمود توازن جوزة امامي يسار و خلفي يمين"
                                                            bindingR2.s3erR2sAcx.setText("6")
                                                        } else {
                                                            if (bindingR2.outsideleft.isChecked && bindingR2.insideleft.isChecked) {
                                                                ch10.text =
                                                                    "عمود توازن جوزة امامي يسار و خلفي يسار"
                                                                bindingR2.s3erR2sAcx.setText("6")
                                                            } else {
                                                                if (bindingR2.insideright.isChecked && bindingR2.insideleft.isChecked) {
                                                                    ch10.text =
                                                                        "عمود توازن جوزة خلفي يمين و يسار"
                                                                    bindingR2.s3erR2sAcx.setText(
                                                                        "3"
                                                                    )
                                                                } else {
                                                                    if (bindingR2.outsideright.isChecked) {
                                                                        ch10.text =
                                                                            "عمود توازن جوزة امامي يمين"
                                                                        bindingR2.s3erR2sAcx.setText(
                                                                            "3"
                                                                        )
                                                                    }
                                                                    if (bindingR2.outsideleft.isChecked) {
                                                                        ch10.text =
                                                                            "عمود توازن جوزة امامي يسار"
                                                                        bindingR2.s3erR2sAcx.setText(
                                                                            "3"
                                                                        )
                                                                    }
                                                                    if (bindingR2.insideleft.isChecked) {
                                                                        ch10.text =
                                                                            "عمود توازن جوزة خلفي يسار"
                                                                        bindingR2.s3erR2sAcx.setText(
                                                                            "3"
                                                                        )
                                                                    }
                                                                    if (bindingR2.insideright.isChecked) {
                                                                        ch10.text =
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
                                pric10.text = bindingR2.s3erR2sAcx.text.toString()
                                customDialogR2SX.dismiss()
                            }
                        }
                    }
                    bindingR2.btnR2sCan.setOnClickListener {
                        if (pric10.text.toString().isEmpty()) {
                            ch10.text = "عمود توازن جوزة"
                            ch10.isChecked = false
                        }
                        customDialogR2SX.dismiss()
                    }
                    bindingR2.outsideright.isChecked = false
                    bindingR2.outsideleft.isChecked = false
                    bindingR2.insideright.isChecked = false
                    bindingR2.insideleft.isChecked = false
                    customDialogR2SX.show()

                }
                    else {
                        ch10.text = "عمود توازن جوزة"
                        pric10.text = ""
                    }
                }
            }

        binding.apply{
            ch11.setOnCheckedChangeListener { _, isChecked ->
                if (ch11.isChecked) {
                    bindingF79.s3erYadweeFa7.setText("10")
                    bindingF79.btnSvDigFa7.setOnClickListener {
                        if (bindingF79.s3erYadweeFa7.text.toString().isEmpty()) {
                            toast_notempty.show()
                        } else {
                            pric11.text = bindingF79.s3erYadweeFa7.text.toString()
                            customDialogF79.dismiss()
                        }
                    }
                    customDialogF79.show()
                } else {
                    pric11.text = ""
                }
            }
        }

        binding.apply{
            ch12.setOnCheckedChangeListener { _, isChecked ->
                if (ch12.isChecked) {

                    customDialogR2SX.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
                    bindingR2.titR2sOut.text="امامي"
                    bindingR2.titR2sIn.text="خلفي"
                    val window = customDialogR2SX.window
                    window?.setGravity(Gravity.TOP)
                    val lp = window?.attributes
                    lp?.dimAmount = 0.0f
                    lp?.flags = lp?.flags?.or(WindowManager.LayoutParams.FLAG_DIM_BEHIND)
                    window?.attributes = lp

                    bindingR2.outsideright.setOnCheckedChangeListener { _, isChecked1 ->
                        if (bindingR2.outsideright.isChecked) {
                            ch12.text = "هب امامي يمين"
                        } else {
                            ch12.text = "هب"
                            bindingR2.s3erR2sAcx.setText("")
                        }
                        if (bindingR2.outsideright.isChecked && bindingR2.outsideleft.isChecked && bindingR2.insideright.isChecked && bindingR2.insideleft.isChecked) {
                            ch12.text = "تغير جميع الهبات"
                            bindingR2.s3erR2sAcx.setText("40")
                        } else {
                            if (bindingR2.outsideright.isChecked && bindingR2.outsideleft.isChecked && bindingR2.insideright.isChecked) {
                                ch12.text = "هب امامي كامل و الخلفي يمين"
                                bindingR2.s3erR2sAcx.setText("30")
                            } else {
                                if (bindingR2.outsideright.isChecked && bindingR2.outsideleft.isChecked && bindingR2.insideleft.isChecked) {
                                    ch12.text = "هب امامي كامل و الخلفي يسار"
                                    bindingR2.s3erR2sAcx.setText("30")
                                } else {
                                    if (bindingR2.outsideright.isChecked && bindingR2.insideright.isChecked && bindingR2.insideleft.isChecked) {
                                        ch12.text = "هب امامي يمين و الخلفيين"
                                        bindingR2.s3erR2sAcx.setText("30")
                                    } else {
                                        if (bindingR2.outsideleft.isChecked && bindingR2.insideright.isChecked && bindingR2.insideleft.isChecked) {
                                            ch12.text = "هب امامي يسار و الخلفيين"
                                            bindingR2.s3erR2sAcx.setText("30")
                                        } else {
                                            if (bindingR2.outsideright.isChecked && bindingR2.outsideleft.isChecked) {
                                                ch12.text = "هب امامي يمين و يسار"
                                                bindingR2.s3erR2sAcx.setText("20")
                                            } else {
                                                if (bindingR2.outsideright.isChecked && bindingR2.insideright.isChecked) {
                                                    ch12.text = "هب امامي يمين و الخلفي يمين"
                                                    bindingR2.s3erR2sAcx.setText("20")
                                                } else {
                                                    if (bindingR2.outsideright.isChecked && bindingR2.insideleft.isChecked) {
                                                        ch12.text = "هب امامي يمين و الخلفي يسار"
                                                        bindingR2.s3erR2sAcx.setText("20")
                                                    } else {
                                                        if (bindingR2.outsideleft.isChecked && bindingR2.insideright.isChecked) {
                                                            ch12.text =
                                                                "هب امامي يسار و الخلفي يمين"
                                                            bindingR2.s3erR2sAcx.setText("20")
                                                        } else {
                                                            if (bindingR2.outsideleft.isChecked && bindingR2.insideleft.isChecked) {
                                                                ch12.text =
                                                                    "هب امامي يسار و الخلفي يسار"
                                                                bindingR2.s3erR2sAcx.setText("20")
                                                            } else {
                                                                if (bindingR2.insideright.isChecked && bindingR2.insideleft.isChecked) {
                                                                    ch12.text =
                                                                        "هب خلفي يمين و يسار"
                                                                    bindingR2.s3erR2sAcx.setText(
                                                                        "20"
                                                                    )
                                                                } else {
                                                                    if (bindingR2.outsideright.isChecked) {
                                                                        ch12.text =
                                                                            "هب امامي يمين"
                                                                        bindingR2.s3erR2sAcx.setText(
                                                                            "10"
                                                                        )
                                                                    }
                                                                    if (bindingR2.outsideleft.isChecked) {
                                                                        ch12.text =
                                                                            "هب امامي يسار"
                                                                        bindingR2.s3erR2sAcx.setText(
                                                                            "10"
                                                                        )
                                                                    }
                                                                    if (bindingR2.insideleft.isChecked) {
                                                                        ch12.text =
                                                                            "هب خلفي يسار"
                                                                        bindingR2.s3erR2sAcx.setText(
                                                                            "10"
                                                                        )
                                                                    }
                                                                    if (bindingR2.insideright.isChecked) {
                                                                        ch12.text =
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
                            ch12.text = "هب امامي يمين"
                        } else {
                            ch12.text = "هب"
                            bindingR2.s3erR2sAcx.setText("")
                        }
                        if (bindingR2.outsideright.isChecked && bindingR2.outsideleft.isChecked && bindingR2.insideright.isChecked && bindingR2.insideleft.isChecked) {
                            ch12.text = "تغير جميع الهبات"
                            bindingR2.s3erR2sAcx.setText("40")
                        } else {
                            if (bindingR2.outsideright.isChecked && bindingR2.outsideleft.isChecked && bindingR2.insideright.isChecked) {
                                ch12.text = "هب امامي كامل و الخلفي يمين"
                                bindingR2.s3erR2sAcx.setText("30")
                            } else {
                                if (bindingR2.outsideright.isChecked && bindingR2.outsideleft.isChecked && bindingR2.insideleft.isChecked) {
                                    ch12.text = "هب امامي كامل و الخلفي يسار"
                                    bindingR2.s3erR2sAcx.setText("30")
                                } else {
                                    if (bindingR2.outsideright.isChecked && bindingR2.insideright.isChecked && bindingR2.insideleft.isChecked) {
                                        ch12.text = "هب امامي يمين و الخلفيين"
                                        bindingR2.s3erR2sAcx.setText("30")
                                    } else {
                                        if (bindingR2.outsideleft.isChecked && bindingR2.insideright.isChecked && bindingR2.insideleft.isChecked) {
                                            ch12.text = "هب امامي يسار و الخلفيين"
                                            bindingR2.s3erR2sAcx.setText("30")
                                        } else {
                                            if (bindingR2.outsideright.isChecked && bindingR2.outsideleft.isChecked) {
                                                ch12.text = "هب امامي يمين و يسار"
                                                bindingR2.s3erR2sAcx.setText("20")
                                            } else {
                                                if (bindingR2.outsideright.isChecked && bindingR2.insideright.isChecked) {
                                                    ch12.text = "هب امامي يمين و الخلفي يمين"
                                                    bindingR2.s3erR2sAcx.setText("20")
                                                } else {
                                                    if (bindingR2.outsideright.isChecked && bindingR2.insideleft.isChecked) {
                                                        ch12.text = "هب امامي يمين و الخلفي يسار"
                                                        bindingR2.s3erR2sAcx.setText("20")
                                                    } else {
                                                        if (bindingR2.outsideleft.isChecked && bindingR2.insideright.isChecked) {
                                                            ch12.text =
                                                                "هب امامي يسار و الخلفي يمين"
                                                            bindingR2.s3erR2sAcx.setText("20")
                                                        } else {
                                                            if (bindingR2.outsideleft.isChecked && bindingR2.insideleft.isChecked) {
                                                                ch12.text =
                                                                    "هب امامي يسار و الخلفي يسار"
                                                                bindingR2.s3erR2sAcx.setText("20")
                                                            } else {
                                                                if (bindingR2.insideright.isChecked && bindingR2.insideleft.isChecked) {
                                                                    ch12.text =
                                                                        "هب خلفي يمين و يسار"
                                                                    bindingR2.s3erR2sAcx.setText(
                                                                        "20"
                                                                    )
                                                                } else {
                                                                    if (bindingR2.outsideright.isChecked) {
                                                                        ch12.text =
                                                                            "هب امامي يمين"
                                                                        bindingR2.s3erR2sAcx.setText(
                                                                            "10"
                                                                        )
                                                                    }
                                                                    if (bindingR2.outsideleft.isChecked) {
                                                                        ch12.text =
                                                                            "هب امامي يسار"
                                                                        bindingR2.s3erR2sAcx.setText(
                                                                            "10"
                                                                        )
                                                                    }
                                                                    if (bindingR2.insideleft.isChecked) {
                                                                        ch12.text =
                                                                            "هب خلفي يسار"
                                                                        bindingR2.s3erR2sAcx.setText(
                                                                            "10"
                                                                        )
                                                                    }
                                                                    if (bindingR2.insideright.isChecked) {
                                                                        ch12.text =
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
                            ch12.text = "هب امامي يمين"
                        } else {
                            ch12.text = "هب"
                            bindingR2.s3erR2sAcx.setText("")
                        }
                        if (bindingR2.outsideright.isChecked && bindingR2.outsideleft.isChecked && bindingR2.insideright.isChecked && bindingR2.insideleft.isChecked) {
                            ch12.text = "تغير جميع الهبات"
                            bindingR2.s3erR2sAcx.setText("40")
                        } else {
                            if (bindingR2.outsideright.isChecked && bindingR2.outsideleft.isChecked && bindingR2.insideright.isChecked) {
                                ch12.text = "هب امامي كامل و الخلفي يمين"
                                bindingR2.s3erR2sAcx.setText("30")
                            } else {
                                if (bindingR2.outsideright.isChecked && bindingR2.outsideleft.isChecked && bindingR2.insideleft.isChecked) {
                                    ch12.text = "هب امامي كامل و الخلفي يسار"
                                    bindingR2.s3erR2sAcx.setText("30")
                                } else {
                                    if (bindingR2.outsideright.isChecked && bindingR2.insideright.isChecked && bindingR2.insideleft.isChecked) {
                                        ch12.text = "هب امامي يمين و الخلفيين"
                                        bindingR2.s3erR2sAcx.setText("30")
                                    } else {
                                        if (bindingR2.outsideleft.isChecked && bindingR2.insideright.isChecked && bindingR2.insideleft.isChecked) {
                                            ch12.text = "هب امامي يسار و الخلفيين"
                                            bindingR2.s3erR2sAcx.setText("30")
                                        } else {
                                            if (bindingR2.outsideright.isChecked && bindingR2.outsideleft.isChecked) {
                                                ch12.text = "هب امامي يمين و يسار"
                                                bindingR2.s3erR2sAcx.setText("20")
                                            } else {
                                                if (bindingR2.outsideright.isChecked && bindingR2.insideright.isChecked) {
                                                    ch12.text = "هب امامي يمين و الخلفي يمين"
                                                    bindingR2.s3erR2sAcx.setText("20")
                                                } else {
                                                    if (bindingR2.outsideright.isChecked && bindingR2.insideleft.isChecked) {
                                                        ch12.text = "هب امامي يمين و الخلفي يسار"
                                                        bindingR2.s3erR2sAcx.setText("20")
                                                    } else {
                                                        if (bindingR2.outsideleft.isChecked && bindingR2.insideright.isChecked) {
                                                            ch12.text =
                                                                "هب امامي يسار و الخلفي يمين"
                                                            bindingR2.s3erR2sAcx.setText("20")
                                                        } else {
                                                            if (bindingR2.outsideleft.isChecked && bindingR2.insideleft.isChecked) {
                                                                ch12.text =
                                                                    "هب امامي يسار و الخلفي يسار"
                                                                bindingR2.s3erR2sAcx.setText("20")
                                                            } else {
                                                                if (bindingR2.insideright.isChecked && bindingR2.insideleft.isChecked) {
                                                                    ch12.text =
                                                                        "هب خلفي يمين و يسار"
                                                                    bindingR2.s3erR2sAcx.setText(
                                                                        "20"
                                                                    )
                                                                } else {
                                                                    if (bindingR2.outsideright.isChecked) {
                                                                        ch12.text =
                                                                            "هب امامي يمين"
                                                                        bindingR2.s3erR2sAcx.setText(
                                                                            "10"
                                                                        )
                                                                    }
                                                                    if (bindingR2.outsideleft.isChecked) {
                                                                        ch12.text =
                                                                            "هب امامي يسار"
                                                                        bindingR2.s3erR2sAcx.setText(
                                                                            "10"
                                                                        )
                                                                    }
                                                                    if (bindingR2.insideleft.isChecked) {
                                                                        ch12.text =
                                                                            "هب خلفي يسار"
                                                                        bindingR2.s3erR2sAcx.setText(
                                                                            "10"
                                                                        )
                                                                    }
                                                                    if (bindingR2.insideright.isChecked) {
                                                                        ch12.text =
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
                            ch12.text = "هب امامي يمين"
                        } else {
                            ch12.text = "هب"
                            bindingR2.s3erR2sAcx.setText("")
                        }
                        if (bindingR2.outsideright.isChecked && bindingR2.outsideleft.isChecked && bindingR2.insideright.isChecked && bindingR2.insideleft.isChecked) {
                            ch12.text = "تغير جميع الهبات"
                            bindingR2.s3erR2sAcx.setText("40")
                        } else {
                            if (bindingR2.outsideright.isChecked && bindingR2.outsideleft.isChecked && bindingR2.insideright.isChecked) {
                                ch12.text = "هب امامي كامل و الخلفي يمين"
                                bindingR2.s3erR2sAcx.setText("30")
                            } else {
                                if (bindingR2.outsideright.isChecked && bindingR2.outsideleft.isChecked && bindingR2.insideleft.isChecked) {
                                    ch12.text = "هب امامي كامل و الخلفي يسار"
                                    bindingR2.s3erR2sAcx.setText("30")
                                } else {
                                    if (bindingR2.outsideright.isChecked && bindingR2.insideright.isChecked && bindingR2.insideleft.isChecked) {
                                        ch12.text = "هب امامي يمين و الخلفيين"
                                        bindingR2.s3erR2sAcx.setText("30")
                                    } else {
                                        if (bindingR2.outsideleft.isChecked && bindingR2.insideright.isChecked && bindingR2.insideleft.isChecked) {
                                            ch12.text = "هب امامي يسار و الخلفيين"
                                            bindingR2.s3erR2sAcx.setText("30")
                                        } else {
                                            if (bindingR2.outsideright.isChecked && bindingR2.outsideleft.isChecked) {
                                                ch12.text = "هب امامي يمين و يسار"
                                                bindingR2.s3erR2sAcx.setText("20")
                                            } else {
                                                if (bindingR2.outsideright.isChecked && bindingR2.insideright.isChecked) {
                                                    ch12.text = "هب امامي يمين و الخلفي يمين"
                                                    bindingR2.s3erR2sAcx.setText("20")
                                                } else {
                                                    if (bindingR2.outsideright.isChecked && bindingR2.insideleft.isChecked) {
                                                        ch12.text = "هب امامي يمين و الخلفي يسار"
                                                        bindingR2.s3erR2sAcx.setText("20")
                                                    } else {
                                                        if (bindingR2.outsideleft.isChecked && bindingR2.insideright.isChecked) {
                                                            ch12.text =
                                                                "هب امامي يسار و الخلفي يمين"
                                                            bindingR2.s3erR2sAcx.setText("20")
                                                        } else {
                                                            if (bindingR2.outsideleft.isChecked && bindingR2.insideleft.isChecked) {
                                                                ch12.text =
                                                                    "هب امامي يسار و الخلفي يسار"
                                                                bindingR2.s3erR2sAcx.setText("20")
                                                            } else {
                                                                if (bindingR2.insideright.isChecked && bindingR2.insideleft.isChecked) {
                                                                    ch12.text =
                                                                        "هب خلفي يمين و يسار"
                                                                    bindingR2.s3erR2sAcx.setText(
                                                                        "20"
                                                                    )
                                                                } else {
                                                                    if (bindingR2.outsideright.isChecked) {
                                                                        ch12.text =
                                                                            "هب امامي يمين"
                                                                        bindingR2.s3erR2sAcx.setText(
                                                                            "10"
                                                                        )
                                                                    }
                                                                    if (bindingR2.outsideleft.isChecked) {
                                                                        ch12.text =
                                                                            "هب امامي يسار"
                                                                        bindingR2.s3erR2sAcx.setText(
                                                                            "10"
                                                                        )
                                                                    }
                                                                    if (bindingR2.insideleft.isChecked) {
                                                                        ch12.text =
                                                                            "هب خلفي يسار"
                                                                        bindingR2.s3erR2sAcx.setText(
                                                                            "10"
                                                                        )
                                                                    }
                                                                    if (bindingR2.insideright.isChecked) {
                                                                        ch12.text =
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
                                pric12.text = bindingR2.s3erR2sAcx.text.toString()
                                customDialogR2SX.dismiss()
                            }
                        }
                    }
                    bindingR2.btnR2sCan.setOnClickListener {
                        if (pric12.text.toString().isEmpty()) {
                            ch12.text = "هب"
                            ch12.isChecked = false
                        }
                        customDialogR2SX.dismiss()
                    }
                    bindingR2.outsideright.isChecked = false
                    bindingR2.outsideleft.isChecked = false
                    bindingR2.insideright.isChecked = false
                    bindingR2.insideleft.isChecked = false
                    customDialogR2SX.show()

                }
                    else {
                        ch12.text = "هب"
                        pric12.text = ""
                    }
                }
            }

        binding.apply{
            ch13.setOnCheckedChangeListener { _, isChecked ->
                if (ch13.isChecked) {
                    customDialogBL6.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

                    val window = customDialogBL6.window
                    window?.setGravity(Gravity.TOP)
                    val lp = window?.attributes
                    lp?.dimAmount = 0.0f
                    lp?.flags = lp?.flags?.or(WindowManager.LayoutParams.FLAG_DIM_BEHIND)
                    window?.attributes = lp
                    bindingBL6.gyarBala6at2mamy.setOnCheckedChangeListener { _, isChecked1 ->
                        if (bindingBL6.gyarBala6at2mamy.isChecked) {
                            bindingBL6.fakBala6at2mamy.isEnabled=false
                            ch13.text = "غيار بلاطات امامية"
                        } else {
                            bindingBL6.fakBala6at2mamy.isEnabled=true
                            ch13.text = "غيار بلاطات"
                            bindingBL6.s3erBala6at.setText("")
                        }
                        if (bindingBL6.gyarBala6at2mamy.isChecked && bindingBL6.gyarBala6at5alfy.isChecked) {
                            ch13.text = "غيار بلاطات امامي و خلفي"
                            bindingBL6.s3erBala6at.setText("20")
                        } else {
                            if (bindingBL6.gyarBala6at2mamy.isChecked && bindingBL6.fakBala6at5alfy.isChecked) {
                                ch13.text = "غيار بلاطات امامي و فك خلفي"
                                bindingBL6.s3erBala6at.setText("20")
                            } else {
                                if (bindingBL6.gyarBala6at2mamy.isChecked) {
                                    ch13.text = "غيار بلاطات امامي"
                                    bindingBL6.s3erBala6at.setText("10")
                                }
                                if (bindingBL6.gyarBala6at5alfy.isChecked) {
                                    ch13.text = "غيار بلاطات خلفي"
                                    bindingBL6.s3erBala6at.setText("10")
                                }
                            }
                        }
                    }

                    bindingBL6.gyarBala6at5alfy.setOnCheckedChangeListener { _, isChecked2 ->
                        if (bindingBL6.gyarBala6at5alfy.isChecked) {
                            bindingBL6.fakBala6at5alfy.isEnabled = false
                            ch13.text = "غيار بلاطات خلفي"
                        } else {
                            bindingBL6.fakBala6at5alfy.isEnabled = true
                            ch13.text = "غيار بلاطات"
                            bindingBL6.s3erBala6at.setText("")
                        }
                        if (bindingBL6.gyarBala6at2mamy.isChecked && bindingBL6.gyarBala6at5alfy.isChecked) {
                            ch13.text = "غيار بلاطات امامي و خلفي"
                            bindingBL6.s3erBala6at.setText("20")
                        } else {
                            if (bindingBL6.gyarBala6at5alfy.isChecked && bindingBL6.fakBala6at2mamy.isChecked) {
                                ch13.text = "غيار بلاطات خلفي و فك امامي"
                                bindingBL6.s3erBala6at.setText("20")
                            } else {
                                if (bindingBL6.gyarBala6at5alfy.isChecked) {
                                    ch13.text = "غيار بلاطات خلفي"
                                    bindingBL6.s3erBala6at.setText("10")
                                }
                                if (bindingBL6.gyarBala6at2mamy.isChecked) {
                                    ch13.text = "غيار بلاطات امامي"
                                    bindingBL6.s3erBala6at.setText("10")
                                }
                            }
                        }
                    }

                    bindingBL6.fakBala6at2mamy.setOnCheckedChangeListener { _, isChecked1 ->
                        if (bindingBL6.fakBala6at2mamy.isChecked) {
                            bindingBL6.gyarBala6at2mamy.isEnabled=false
                            ch13.text = "فك بلاطات امامية"
                        } else {
                            bindingBL6.gyarBala6at2mamy.isEnabled=true
                            ch13.text = "بلاطات"
                            bindingBL6.s3erBala6at.setText("")
                        }
                        if (bindingBL6.fakBala6at2mamy.isChecked && bindingBL6.fakBala6at5alfy.isChecked) {
                            ch13.text = "فك بلاطات امامي و خلفي"
                            bindingBL6.s3erBala6at.setText("20")
                        } else {
                            if (bindingBL6.fakBala6at2mamy.isChecked && bindingBL6.gyarBala6at5alfy.isChecked) {
                                ch13.text = "فك بلاطات امامي و غيار خلفي"
                                bindingBL6.s3erBala6at.setText("20")
                            } else {
                                if (bindingBL6.fakBala6at2mamy.isChecked) {
                                    ch13.text = "فك بلاطات امامي"
                                    bindingBL6.s3erBala6at.setText("10")
                                }
                                if (bindingBL6.fakBala6at5alfy.isChecked) {
                                    ch13.text = "فك بلاطات خلفي"
                                    bindingBL6.s3erBala6at.setText("10")
                                }
                            }
                        }
                    }

                    bindingBL6.fakBala6at5alfy.setOnCheckedChangeListener { _, isChecked2 ->
                        if (bindingBL6.fakBala6at5alfy.isChecked) {
                            bindingBL6.gyarBala6at5alfy.isEnabled=false
                            ch13.text = "فك بلاطات خلفي"
                        } else {
                            bindingBL6.gyarBala6at5alfy.isEnabled=true
                            ch13.text = "بلاطات"
                            bindingBL6.s3erBala6at.setText("")
                        }
                        if (bindingBL6.fakBala6at2mamy.isChecked && bindingBL6.fakBala6at5alfy.isChecked) {
                            ch13.text = "فك بلاطات امامي و خلفي"
                            bindingBL6.s3erBala6at.setText("20")
                        } else {
                            if (bindingBL6.fakBala6at5alfy.isChecked && bindingBL6.gyarBala6at2mamy.isChecked) {
                                ch13.text = "فك بلاطات خلفي و غيار امامي"
                                bindingBL6.s3erBala6at.setText("20")
                            } else {
                                if (bindingBL6.fakBala6at5alfy.isChecked) {
                                    ch13.text = "فك بلاطات خلفي"
                                    bindingBL6.s3erBala6at.setText("10")
                                }
                                if (bindingBL6.fakBala6at2mamy.isChecked) {
                                    ch13.text = "فك بلاطات امامي"
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
                                pric13.text =
                                    bindingBL6.s3erBala6at.text.toString()
                                bindingBL6.gyarBala6at2mamy.isEnabled=true
                                bindingBL6.gyarBala6at5alfy.isEnabled=true
                                bindingBL6.fakBala6at5alfy.isEnabled=true
                                bindingBL6.fakBala6at2mamy.isEnabled=true

                                customDialogBL6.dismiss()
                            }
                        }
                    }
                    bindingBL6.btnBala6atCan.setOnClickListener {
                        if (pric13.text.toString().isEmpty()) {
                            ch13.text = "بلاطات"
                            ch13.isChecked = false
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

                }
                    else {
                        ch13.text = "بلاطات"
                        pric13.text = ""
                    }
                }
            }

        binding.apply{
            ch14.setOnCheckedChangeListener { _, isChecked ->
                if (ch14.isChecked) {
                    bindingF79.s3erYadweeFa7.setText("40")
                    bindingF79.btnSvDigFa7.setOnClickListener {
                        if (bindingF79.s3erYadweeFa7.text.toString().isEmpty()) {
                            toast_notempty.show()
                        } else {
                            pric14.text = bindingF79.s3erYadweeFa7.text.toString()
                            customDialogF79.dismiss()
                        }
                    }
                    customDialogF79.show()
                } else {
                    pric14.text = ""
                }
            }
        }

        binding.apply {
            ch15.setOnCheckedChangeListener { _, isChecked ->
                if (ch15.isChecked) {
                    bindingF79.s3erYadweeFa7.setText("3")
                    bindingF79.btnSvDigFa7.setOnClickListener {
                        if (bindingF79.s3erYadweeFa7.text.toString().isEmpty()) {
                            toast_notempty.show()
                        } else {
                            pric15.text = bindingF79.s3erYadweeFa7.text.toString()
                            customDialogF79.dismiss()
                        }
                    }
                    customDialogF79.show()
                } else {
                    pric15.text = ""
                }
            }
        }

        binding.apply{
            ch16.setOnCheckedChangeListener { _, isChecked ->
                if (ch16.isChecked) {
                    bindingF79.s3erYadweeFa7.setText("3")
                    bindingF79.btnSvDigFa7.setOnClickListener {
                        if (bindingF79.s3erYadweeFa7.text.toString().isEmpty()) {
                            toast_notempty.show()
                        } else {
                            pric16.text = bindingF79.s3erYadweeFa7.text.toString()
                            customDialogF79.dismiss()
                        }
                    }
                    customDialogF79.show()

                } else {
                    pric16.text = ""
                }
            }
        }

        binding.apply{
            ch17.setOnCheckedChangeListener { _, isChecked ->
                if (ch17.isChecked) {

                    customDialogR2SX.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
                    bindingR2.titR2sOut.text="امامي"
                    bindingR2.titR2sIn.text="خلفي"
                    val window = customDialogR2SX.window
                    window?.setGravity(Gravity.TOP)
                    val lp = window?.attributes
                    lp?.dimAmount = 0.0f
                    lp?.flags = lp?.flags?.or(WindowManager.LayoutParams.FLAG_DIM_BEHIND)
                    window?.attributes = lp

                    bindingR2.outsideright.setOnCheckedChangeListener { _, isChecked1 ->
                        if (bindingR2.outsideright.isChecked) {
                            ch17.text = "حساس (ABS) امامي يمين"
                        } else {
                            ch17.text = "حساس (ABS)"
                            bindingR2.s3erR2sAcx.setText("")
                        }
                        if (bindingR2.outsideright.isChecked && bindingR2.outsideleft.isChecked && bindingR2.insideright.isChecked && bindingR2.insideleft.isChecked) {
                            ch17.text = "تغير جميع حساسات (ABS) "
                            bindingR2.s3erR2sAcx.setText("12")
                        } else {
                            if (bindingR2.outsideright.isChecked && bindingR2.outsideleft.isChecked && bindingR2.insideright.isChecked) {
                                ch17.text = "حساس (ABS) امامي كامل و الخلفي يمين"
                                bindingR2.s3erR2sAcx.setText("9")
                            } else {
                                if (bindingR2.outsideright.isChecked && bindingR2.outsideleft.isChecked && bindingR2.insideleft.isChecked) {
                                    ch17.text = "حساس (ABS) امامي كامل و الخلفي يسار"
                                    bindingR2.s3erR2sAcx.setText("9")
                                } else {
                                    if (bindingR2.outsideright.isChecked && bindingR2.insideright.isChecked && bindingR2.insideleft.isChecked) {
                                        ch17.text = "حساس (ABS) امامي يمين و الخلفيين"
                                        bindingR2.s3erR2sAcx.setText("9")
                                    } else {
                                        if (bindingR2.outsideleft.isChecked && bindingR2.insideright.isChecked && bindingR2.insideleft.isChecked) {
                                            ch17.text = "حساس (ABS) امامي يسار و الخلفيين"
                                            bindingR2.s3erR2sAcx.setText("9")
                                        } else {
                                            if (bindingR2.outsideright.isChecked && bindingR2.outsideleft.isChecked) {
                                                ch17.text = "حساس (ABS) امامي يمين و يسار"
                                                bindingR2.s3erR2sAcx.setText("6")
                                            } else {
                                                if (bindingR2.outsideright.isChecked && bindingR2.insideright.isChecked) {
                                                    ch17.text = "حساس (ABS) امامي يمين و الخلفي يمين"
                                                    bindingR2.s3erR2sAcx.setText("6")
                                                } else {
                                                    if (bindingR2.outsideright.isChecked && bindingR2.insideleft.isChecked) {
                                                        ch17.text = "حساس (ABS) امامي يمين و الخلفي يسار"
                                                        bindingR2.s3erR2sAcx.setText("6")
                                                    } else {
                                                        if (bindingR2.outsideleft.isChecked && bindingR2.insideright.isChecked) {
                                                            ch17.text =
                                                                "حساس (ABS) امامي يسار و الخلفي يمين"
                                                            bindingR2.s3erR2sAcx.setText("6")
                                                        } else {
                                                            if (bindingR2.outsideleft.isChecked && bindingR2.insideleft.isChecked) {
                                                                ch17.text =
                                                                    "حساس (ABS) امامي يسار و الخلفي يسار"
                                                                bindingR2.s3erR2sAcx.setText("6")
                                                            } else {
                                                                if (bindingR2.insideright.isChecked && bindingR2.insideleft.isChecked) {
                                                                    ch17.text =
                                                                        "حساس (ABS) خلفي يمين و يسار"
                                                                    bindingR2.s3erR2sAcx.setText(
                                                                        "6"
                                                                    )
                                                                } else {
                                                                    if (bindingR2.outsideright.isChecked) {
                                                                        ch17.text =
                                                                            "حساس (ABS) امامي يمين"
                                                                        bindingR2.s3erR2sAcx.setText(
                                                                            "3"
                                                                        )
                                                                    }
                                                                    if (bindingR2.outsideleft.isChecked) {
                                                                        ch17.text =
                                                                            "حساس (ABS) امامي يسار"
                                                                        bindingR2.s3erR2sAcx.setText(
                                                                            "3"
                                                                        )
                                                                    }
                                                                    if (bindingR2.insideleft.isChecked) {
                                                                        ch17.text =
                                                                            "حساس (ABS) خلفي يسار"
                                                                        bindingR2.s3erR2sAcx.setText(
                                                                            "3"
                                                                        )
                                                                    }
                                                                    if (bindingR2.insideright.isChecked) {
                                                                        ch17.text =
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
                            ch17.text = "حساس (ABS) امامي يمين"
                        } else {
                            ch17.text = "حساس (ABS)"
                            bindingR2.s3erR2sAcx.setText("")
                        }
                        if (bindingR2.outsideright.isChecked && bindingR2.outsideleft.isChecked && bindingR2.insideright.isChecked && bindingR2.insideleft.isChecked) {
                            ch17.text = "تغير جميع حساسات (ABS) "
                            bindingR2.s3erR2sAcx.setText("12")
                        } else {
                            if (bindingR2.outsideright.isChecked && bindingR2.outsideleft.isChecked && bindingR2.insideright.isChecked) {
                                ch17.text = "حساس (ABS) امامي كامل و الخلفي يمين"
                                bindingR2.s3erR2sAcx.setText("9")
                            } else {
                                if (bindingR2.outsideright.isChecked && bindingR2.outsideleft.isChecked && bindingR2.insideleft.isChecked) {
                                    ch17.text = "حساس (ABS) امامي كامل و الخلفي يسار"
                                    bindingR2.s3erR2sAcx.setText("9")
                                } else {
                                    if (bindingR2.outsideright.isChecked && bindingR2.insideright.isChecked && bindingR2.insideleft.isChecked) {
                                        ch17.text = "حساس (ABS) امامي يمين و الخلفيين"
                                        bindingR2.s3erR2sAcx.setText("9")
                                    } else {
                                        if (bindingR2.outsideleft.isChecked && bindingR2.insideright.isChecked && bindingR2.insideleft.isChecked) {
                                            ch17.text = "حساس (ABS) امامي يسار و الخلفيين"
                                            bindingR2.s3erR2sAcx.setText("9")
                                        } else {
                                            if (bindingR2.outsideright.isChecked && bindingR2.outsideleft.isChecked) {
                                                ch17.text = "حساس (ABS) امامي يمين و يسار"
                                                bindingR2.s3erR2sAcx.setText("6")
                                            } else {
                                                if (bindingR2.outsideright.isChecked && bindingR2.insideright.isChecked) {
                                                    ch17.text = "حساس (ABS) امامي يمين و الخلفي يمين"
                                                    bindingR2.s3erR2sAcx.setText("6")
                                                } else {
                                                    if (bindingR2.outsideright.isChecked && bindingR2.insideleft.isChecked) {
                                                        ch17.text = "حساس (ABS) امامي يمين و الخلفي يسار"
                                                        bindingR2.s3erR2sAcx.setText("6")
                                                    } else {
                                                        if (bindingR2.outsideleft.isChecked && bindingR2.insideright.isChecked) {
                                                            ch17.text =
                                                                "حساس (ABS) امامي يسار و الخلفي يمين"
                                                            bindingR2.s3erR2sAcx.setText("6")
                                                        } else {
                                                            if (bindingR2.outsideleft.isChecked && bindingR2.insideleft.isChecked) {
                                                                ch17.text =
                                                                    "حساس (ABS) امامي يسار و الخلفي يسار"
                                                                bindingR2.s3erR2sAcx.setText("6")
                                                            } else {
                                                                if (bindingR2.insideright.isChecked && bindingR2.insideleft.isChecked) {
                                                                    ch17.text =
                                                                        "حساس (ABS) خلفي يمين و يسار"
                                                                    bindingR2.s3erR2sAcx.setText(
                                                                        "6"
                                                                    )
                                                                } else {
                                                                    if (bindingR2.outsideright.isChecked) {
                                                                        ch17.text =
                                                                            "حساس (ABS) امامي يمين"
                                                                        bindingR2.s3erR2sAcx.setText(
                                                                            "3"
                                                                        )
                                                                    }
                                                                    if (bindingR2.outsideleft.isChecked) {
                                                                        ch17.text =
                                                                            "حساس (ABS) امامي يسار"
                                                                        bindingR2.s3erR2sAcx.setText(
                                                                            "3"
                                                                        )
                                                                    }
                                                                    if (bindingR2.insideleft.isChecked) {
                                                                        ch17.text =
                                                                            "حساس (ABS) خلفي يسار"
                                                                        bindingR2.s3erR2sAcx.setText(
                                                                            "3"
                                                                        )
                                                                    }
                                                                    if (bindingR2.insideright.isChecked) {
                                                                        ch17.text =
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
                            ch17.text = "حساس (ABS) امامي يمين"
                        } else {
                            ch17.text = "حساس (ABS)"
                            bindingR2.s3erR2sAcx.setText("")
                        }
                        if (bindingR2.outsideright.isChecked && bindingR2.outsideleft.isChecked && bindingR2.insideright.isChecked && bindingR2.insideleft.isChecked) {
                            ch17.text = "تغير جميع حساسات (ABS) "
                            bindingR2.s3erR2sAcx.setText("12")
                        } else {
                            if (bindingR2.outsideright.isChecked && bindingR2.outsideleft.isChecked && bindingR2.insideright.isChecked) {
                                ch17.text = "حساس (ABS) امامي كامل و الخلفي يمين"
                                bindingR2.s3erR2sAcx.setText("9")
                            } else {
                                if (bindingR2.outsideright.isChecked && bindingR2.outsideleft.isChecked && bindingR2.insideleft.isChecked) {
                                    ch17.text = "حساس (ABS) امامي كامل و الخلفي يسار"
                                    bindingR2.s3erR2sAcx.setText("9")
                                } else {
                                    if (bindingR2.outsideright.isChecked && bindingR2.insideright.isChecked && bindingR2.insideleft.isChecked) {
                                        ch17.text = "حساس (ABS) امامي يمين و الخلفيين"
                                        bindingR2.s3erR2sAcx.setText("9")
                                    } else {
                                        if (bindingR2.outsideleft.isChecked && bindingR2.insideright.isChecked && bindingR2.insideleft.isChecked) {
                                            ch17.text = "حساس (ABS) امامي يسار و الخلفيين"
                                            bindingR2.s3erR2sAcx.setText("9")
                                        } else {
                                            if (bindingR2.outsideright.isChecked && bindingR2.outsideleft.isChecked) {
                                                ch17.text = "حساس (ABS) امامي يمين و يسار"
                                                bindingR2.s3erR2sAcx.setText("6")
                                            } else {
                                                if (bindingR2.outsideright.isChecked && bindingR2.insideright.isChecked) {
                                                    ch17.text = "حساس (ABS) امامي يمين و الخلفي يمين"
                                                    bindingR2.s3erR2sAcx.setText("6")
                                                } else {
                                                    if (bindingR2.outsideright.isChecked && bindingR2.insideleft.isChecked) {
                                                        ch17.text = "حساس (ABS) امامي يمين و الخلفي يسار"
                                                        bindingR2.s3erR2sAcx.setText("6")
                                                    } else {
                                                        if (bindingR2.outsideleft.isChecked && bindingR2.insideright.isChecked) {
                                                            ch17.text =
                                                                "حساس (ABS) امامي يسار و الخلفي يمين"
                                                            bindingR2.s3erR2sAcx.setText("6")
                                                        } else {
                                                            if (bindingR2.outsideleft.isChecked && bindingR2.insideleft.isChecked) {
                                                                ch17.text =
                                                                    "حساس (ABS) امامي يسار و الخلفي يسار"
                                                                bindingR2.s3erR2sAcx.setText("6")
                                                            } else {
                                                                if (bindingR2.insideright.isChecked && bindingR2.insideleft.isChecked) {
                                                                    ch17.text =
                                                                        "حساس (ABS) خلفي يمين و يسار"
                                                                    bindingR2.s3erR2sAcx.setText(
                                                                        "6"
                                                                    )
                                                                } else {
                                                                    if (bindingR2.outsideright.isChecked) {
                                                                        ch17.text =
                                                                            "حساس (ABS) امامي يمين"
                                                                        bindingR2.s3erR2sAcx.setText(
                                                                            "3"
                                                                        )
                                                                    }
                                                                    if (bindingR2.outsideleft.isChecked) {
                                                                        ch17.text =
                                                                            "حساس (ABS) امامي يسار"
                                                                        bindingR2.s3erR2sAcx.setText(
                                                                            "3"
                                                                        )
                                                                    }
                                                                    if (bindingR2.insideleft.isChecked) {
                                                                        ch17.text =
                                                                            "حساس (ABS) خلفي يسار"
                                                                        bindingR2.s3erR2sAcx.setText(
                                                                            "3"
                                                                        )
                                                                    }
                                                                    if (bindingR2.insideright.isChecked) {
                                                                        ch17.text =
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
                            ch17.text = "حساس (ABS) امامي يمين"
                        } else {
                            ch17.text = "حساس (ABS)"
                            bindingR2.s3erR2sAcx.setText("")
                        }
                        if (bindingR2.outsideright.isChecked && bindingR2.outsideleft.isChecked && bindingR2.insideright.isChecked && bindingR2.insideleft.isChecked) {
                            ch17.text = "تغير جميع حساسات (ABS) "
                            bindingR2.s3erR2sAcx.setText("12")
                        } else {
                            if (bindingR2.outsideright.isChecked && bindingR2.outsideleft.isChecked && bindingR2.insideright.isChecked) {
                                ch17.text = "حساس (ABS) امامي كامل و الخلفي يمين"
                                bindingR2.s3erR2sAcx.setText("9")
                            } else {
                                if (bindingR2.outsideright.isChecked && bindingR2.outsideleft.isChecked && bindingR2.insideleft.isChecked) {
                                    ch17.text = "حساس (ABS) امامي كامل و الخلفي يسار"
                                    bindingR2.s3erR2sAcx.setText("9")
                                } else {
                                    if (bindingR2.outsideright.isChecked && bindingR2.insideright.isChecked && bindingR2.insideleft.isChecked) {
                                        ch17.text = "حساس (ABS) امامي يمين و الخلفيين"
                                        bindingR2.s3erR2sAcx.setText("9")
                                    } else {
                                        if (bindingR2.outsideleft.isChecked && bindingR2.insideright.isChecked && bindingR2.insideleft.isChecked) {
                                            ch17.text = "حساس (ABS) امامي يسار و الخلفيين"
                                            bindingR2.s3erR2sAcx.setText("9")
                                        } else {
                                            if (bindingR2.outsideright.isChecked && bindingR2.outsideleft.isChecked) {
                                                ch17.text = "حساس (ABS) امامي يمين و يسار"
                                                bindingR2.s3erR2sAcx.setText("6")
                                            } else {
                                                if (bindingR2.outsideright.isChecked && bindingR2.insideright.isChecked) {
                                                    ch17.text = "حساس (ABS) امامي يمين و الخلفي يمين"
                                                    bindingR2.s3erR2sAcx.setText("6")
                                                } else {
                                                    if (bindingR2.outsideright.isChecked && bindingR2.insideleft.isChecked) {
                                                        ch17.text = "حساس (ABS) امامي يمين و الخلفي يسار"
                                                        bindingR2.s3erR2sAcx.setText("6")
                                                    } else {
                                                        if (bindingR2.outsideleft.isChecked && bindingR2.insideright.isChecked) {
                                                            ch17.text =
                                                                "حساس (ABS) امامي يسار و الخلفي يمين"
                                                            bindingR2.s3erR2sAcx.setText("6")
                                                        } else {
                                                            if (bindingR2.outsideleft.isChecked && bindingR2.insideleft.isChecked) {
                                                                ch17.text =
                                                                    "حساس (ABS) امامي يسار و الخلفي يسار"
                                                                bindingR2.s3erR2sAcx.setText("6")
                                                            } else {
                                                                if (bindingR2.insideright.isChecked && bindingR2.insideleft.isChecked) {
                                                                    ch17.text =
                                                                        "حساس (ABS) خلفي يمين و يسار"
                                                                    bindingR2.s3erR2sAcx.setText(
                                                                        "6"
                                                                    )
                                                                } else {
                                                                    if (bindingR2.outsideright.isChecked) {
                                                                        ch17.text =
                                                                            "حساس (ABS) امامي يمين"
                                                                        bindingR2.s3erR2sAcx.setText(
                                                                            "3"
                                                                        )
                                                                    }
                                                                    if (bindingR2.outsideleft.isChecked) {
                                                                        ch17.text =
                                                                            "حساس (ABS) امامي يسار"
                                                                        bindingR2.s3erR2sAcx.setText(
                                                                            "3"
                                                                        )
                                                                    }
                                                                    if (bindingR2.insideleft.isChecked) {
                                                                        ch17.text =
                                                                            "حساس (ABS) خلفي يسار"
                                                                        bindingR2.s3erR2sAcx.setText(
                                                                            "3"
                                                                        )
                                                                    }
                                                                    if (bindingR2.insideright.isChecked) {
                                                                        ch17.text =
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
                                pric17.text = bindingR2.s3erR2sAcx.text.toString()
                                customDialogR2SX.dismiss()
                            }
                        }
                    }
                    bindingR2.btnR2sCan.setOnClickListener {
                        if (pric17.text.toString().isEmpty()) {
                            ch17.text = "حساس (ABS)"
                            ch17.isChecked = false
                        }
                        customDialogR2SX.dismiss()
                    }
                    bindingR2.outsideright.isChecked = false
                    bindingR2.outsideleft.isChecked = false
                    bindingR2.insideright.isChecked = false
                    bindingR2.insideleft.isChecked = false
                    customDialogR2SX.show()

                }
                    else {
                        ch17.text = "حساس (ABS)"
                        pric17.text = ""
                    }
                }
            }

        val editTextList = mutableListOf<TextView>()
        val checkBoxList = mutableListOf<CheckBox>()
        for (i in 1..17) {
            val editTextName = "pric$i"
            val editText =
                binding::class.java.getDeclaredField(editTextName).get(binding) as TextView
            editTextList.add(editText)
            val checkBoxName = "ch$i"
            val checkBox =
                binding::class.java.getDeclaredField(checkBoxName).get(binding) as CheckBox
            checkBoxList.add(checkBox)

                binding.btnsavhy2ah1.setOnClickListener {
                    if (!isNetworkAvailable(requireContext())) {
                        Toast.makeText(
                            requireContext(),
                            "خدمة الانترنت غير متوفرة",
                            Toast.LENGTH_LONG
                        ).apply {
                            setGravity(Gravity.CENTER, 0, 0)
                            show()
                        }
                    } else {
                        val contentMessage2 = mutableMapOf<String, Any>()
                        for (i in 0 until editTextList.size) {
                            if (editTextList[i].text.isNotEmpty()) {
                                val variableNamepric = "pric${i + 1}"
                                contentMessage2[variableNamepric] = editTextList[i].text.toString()
                                contentMessage2["totalhy2ah1"] = hy2ahModel.totalAmount
                                chatChannelsCollectionRef.document(viewModeleEstqbal.myData1)
                                    .collection("messages")
                                    .document(viewModeleEstqbal.myData2)
                                    .update(contentMessage2)
                            }
                            else{
                                val variableDelNamepric =hashMapOf<String, Any>( "pric${i + 1}" to FieldValue.delete())
                                chatChannelsCollectionRef.document(viewModeleEstqbal.myData1)
                                    .collection("messages")
                                    .document(viewModeleEstqbal.myData2)
                                    .update(variableDelNamepric)
                            }
                        }

                        for (i in 0 until checkBoxList.size) {
                            if (checkBoxList[i].isChecked) {
                                val variableName = "ch${i + 1}"
                                contentMessage2[variableName] = checkBoxList[i].text.toString()
                                chatChannelsCollectionRef.document(viewModeleEstqbal.myData1)
                                    .collection("messages")
                                    .document(viewModeleEstqbal.myData2)
                                    .update(contentMessage2)
                            }
                            else{
                                val variableDelName =hashMapOf<String, Any>( "ch${i + 1}" to FieldValue.delete())
                                chatChannelsCollectionRef.document(viewModeleEstqbal.myData1)
                                    .collection("messages")
                                    .document(viewModeleEstqbal.myData2)
                                    .update(variableDelName)
                            }
                        }
                    }
                }
            }

        for (i in editTextList.indices) {
            editTextList[i].addTextChangedListener(object : TextWatcher {
                override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
                override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                }
                override fun afterTextChanged(s: Editable?) {
                if (s!!.isNotEmpty()){
                    val totalAmount = editTextList.filter { it.text.isNotEmpty() }.sumOf { it.text.toString().toInt() }
                    hy2ahModel.totalAmount = totalAmount.toString()
                    toolbar?.title = "مجموع قائمة الهيئة1 : " + hy2ahModel.totalAmount
                }else{
                    val totalAmount = editTextList.filter { it.text.isNotEmpty() }.sumOf { it.text.toString().toInt() }
                    hy2ahModel.totalAmount = totalAmount.toString()
                    toolbar?.title = "مجموع قائمة الهيئة1 : " + hy2ahModel.totalAmount
                }
                }
            })
        }

        return root
    }

    private fun isNetworkAvailable(context: Context): Boolean {
        val connectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val activeNetworkInfo = connectivityManager.activeNetworkInfo
        return activeNetworkInfo != null && activeNetworkInfo.isConnected
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}