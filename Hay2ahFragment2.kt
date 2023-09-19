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
import androidx.fragment.app.Fragment
import android.widget.Toast
import androidx.appcompat.widget.Toolbar
import androidx.lifecycle.ViewModelProvider
import com.example.markizalhadidi.R
import com.example.markizalhadidi.databinding.*
import com.example.markizalhadidi.ui.estqbal.EstqbalViewModel
import com.google.firebase.firestore.FieldValue
import com.google.firebase.firestore.FirebaseFirestore

class Hay2ahFragment2 : Fragment() {
    private var _binding: FragmentHay2ah2Binding? = null
    private val binding get() = _binding!!

    private lateinit var bindingtoolbar: ActivityMainBinding

    private lateinit var hy2ahModel: Hay2ahViewModel
    private lateinit var hy2ah2Model: Hy2ah2ViewModel

    private lateinit var viewModeleEstqbal: EstqbalViewModel
    private val firestoreInstance: FirebaseFirestore by lazy { FirebaseFirestore.getInstance() }
    private val chatChannelsCollectionRef = firestoreInstance.collection("chatChannels")

    private val checkBoxList = mutableListOf<CheckBox>()
    private val editTextList = mutableListOf<TextView>()
    private var A = 0
    var totalAmount = 0

    private lateinit var customDialogMZ: Dialog
    private lateinit var customDialogF79: Dialog
    private lateinit var customDialogR2SX: Dialog
    private lateinit var customDialogBRK: Dialog
    private lateinit var customDialogFR: Dialog
    private lateinit var customDialogBL6: Dialog

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        hy2ahModel =
            ViewModelProvider(this).get(Hay2ahViewModel::class.java)

        hy2ah2Model =
            ViewModelProvider(this).get(Hy2ah2ViewModel::class.java)

        viewModeleEstqbal = activity?.run {
            ViewModelProvider(this).get(EstqbalViewModel::class.java)
        } ?: throw Exception("Invalid Activity")

        _binding = FragmentHay2ah2Binding.inflate(inflater, container, false)
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

//        binding.apply{
        binding.chhy2ahtow1.setOnCheckedChangeListener { _ ,  isChecked ->
                if (isChecked) {

//                    customDialogFR.window?.setFlags(WindowManager.LayoutParams.FLAG_SECURE, WindowManager.LayoutParams.FLAG_SECURE)

                    bindingFR.frontright.setOnCheckedChangeListener { _ ,  isChecked1 ->
                        if (bindingFR.frontright.isChecked) {
                            binding.chhy2ahtow1.text =
                                "بكس كفة خلفية عرضية يمين"
                        } else {
                            binding.chhy2ahtow1.text = "بكس كفة خلفية عرضية"
                            bindingFR.s3erYadwee.setText("")
                        }

                        if (bindingFR.frontright.isChecked && bindingFR.frontleft.isChecked) {
                            binding.chhy2ahtow1.text = "بكس كفة خلفية عرضية يمين و يسار"
                            bindingFR.s3erYadwee.setText("20")
                        } else {
                            if (bindingFR.frontright.isChecked) {
                                binding.chhy2ahtow1.text = "بكس كفة خلفية عرضية يمين"
                                bindingFR.s3erYadwee.setText("10")
                            }
                            if (bindingFR.frontleft.isChecked) {
                                binding.chhy2ahtow1.text = "بكس كفة خلفية عرضية يسار"
                                bindingFR.s3erYadwee.setText("10")
                            }
                        }
                    }
                    bindingFR.frontleft.setOnCheckedChangeListener { _ ,  isChecked2 ->
                        if (bindingFR.frontleft.isChecked) {
                            binding.chhy2ahtow1.text ="بكس كفة خلفية عرضية يسار"
                        }else{binding.chhy2ahtow1.text = "بكس كفة خلفية عرضية"
                            bindingFR.s3erYadwee.setText("")}

                        if (bindingFR.frontleft.isChecked && bindingFR.frontright.isChecked){
                            binding.chhy2ahtow1.text = "بكس كفة خلفية عرضية يمين و يسار"
                            bindingFR.s3erYadwee.setText("20")
                        }else {
                            if (bindingFR.frontright.isChecked) {
                                binding.chhy2ahtow1.text = "بكس كفة خلفية عرضية يمين"
                                bindingFR.s3erYadwee.setText("10")
                            }
                            if (bindingFR.frontleft.isChecked) {
                                binding.chhy2ahtow1.text = "بكس كفة خلفية عرضية يسار"
                                bindingFR.s3erYadwee.setText("10")
                            }
                        }
                    }

                    bindingFR.buttonDailogSave.setOnClickListener {
                        if (!bindingFR.frontright.isChecked && !bindingFR.frontleft.isChecked) {
                            toast_notempty1.show()
                        } else {
//                            val  aa=bindingFR.s3erYadwee.text.toString().trim()
                            if (bindingFR.s3erYadwee.text.toString().trim().isEmpty()) {
                                toast_notempty.show()
                            } else {
                                binding.prichy2ahtow1.text = bindingFR.s3erYadwee.text.toString()
                                customDialogFR.dismiss()
                            }
                        }
                    }
                    bindingFR.buttonDailogCancel.setOnClickListener {
                        if (binding.prichy2ahtow1.text.isEmpty()) {
                            binding.chhy2ahtow1.text = "بكس كفة خلفية عرضية"
                            binding.chhy2ahtow1.isChecked = false
                            bindingFR.s3erYadwee.setText("")
                        }
                        customDialogFR.dismiss()
                    }
                    bindingFR.frontleft.isChecked = false
                    bindingFR.frontright.isChecked = false
                    customDialogFR.show()
                }
                else {
                    binding.chhy2ahtow1.text = "بكس كفة خلفية عرضية"
                    binding.prichy2ahtow1.text = ""

                }
            }
//        }

        binding.apply {
            chhy2ahtow2.setOnCheckedChangeListener { _, isChecked ->
                if (chhy2ahtow2.isChecked) {

                    customDialogFR.window?.setFlags(
                        WindowManager.LayoutParams.FLAG_SECURE,
                        WindowManager.LayoutParams.FLAG_SECURE
                    )

                    bindingFR.frontright.setOnCheckedChangeListener { _, isChecked1 ->
                        if (bindingFR.frontright.isChecked) {
                            chhy2ahtow2.text =
                                "بكس كفة معاير خلفي يمين"
                        } else {
                            chhy2ahtow2.text = "بكس كفة معاير خلفي"
                            bindingFR.s3erYadwee.setText("")
                        }

                        if (bindingFR.frontright.isChecked && bindingFR.frontleft.isChecked) {
                            chhy2ahtow2.text = "بكس كفة معاير خلفي يمين و يسار"
                            bindingFR.s3erYadwee.setText("10")
                        } else {
                            if (bindingFR.frontright.isChecked) {
                                chhy2ahtow2.text = "بكس كفة معاير خلفي يمين"
                                bindingFR.s3erYadwee.setText("5")
                            }
                            if (bindingFR.frontleft.isChecked) {
                                chhy2ahtow2.text = "بكس كفة معاير خلفي يسار"
                                bindingFR.s3erYadwee.setText("5")
                            }
                        }
                    }
                    bindingFR.frontleft.setOnCheckedChangeListener { _, isChecked2 ->
                        if (bindingFR.frontleft.isChecked) {
                            chhy2ahtow2.text = "بكس كفة معاير خلفي يسار"
                        } else {
                            chhy2ahtow2.text = "بكس كفة معاير خلفي"
                            bindingFR.s3erYadwee.setText("")
                        }

                        if (bindingFR.frontleft.isChecked && bindingFR.frontright.isChecked) {
                            chhy2ahtow2.text = "بكس كفة معاير خلفي يمين و يسار"
                            bindingFR.s3erYadwee.setText("10")
                        } else {
                            if (bindingFR.frontright.isChecked) {
                                chhy2ahtow2.text = "بكس كفة معاير خلفي يمين"
                                bindingFR.s3erYadwee.setText("5")
                            }
                            if (bindingFR.frontleft.isChecked) {
                                chhy2ahtow2.text = "بكس كفة معاير خلفي يسار"
                                bindingFR.s3erYadwee.setText("5")
                            }
                        }

                    }

                    bindingFR.buttonDailogSave.setOnClickListener {
                        if (!bindingFR.frontright.isChecked && !bindingFR.frontleft.isChecked) {
                            toast_notempty1.show()
                        } else {
                            val aa = bindingFR.s3erYadwee.text.toString().trim()
                            if (aa.isEmpty()) {
                                toast_notempty.show()
                            } else {
                                prichy2ahtow2.text = bindingFR.s3erYadwee.text.toString()
                                customDialogFR.dismiss()
                            }
                        }
                    }
                    bindingFR.buttonDailogCancel.setOnClickListener {
                        chhy2ahtow2.isChecked = false
                        bindingFR.s3erYadwee.setText("")
                        customDialogFR.dismiss()
                    }
                    bindingFR.frontleft.isChecked = false
                    bindingFR.frontright.isChecked = false
                    customDialogFR.show()
                }
                 else {
                    chhy2ahtow2.text = "بكس كفة معاير خلفي"
                    prichy2ahtow2.text = ""
                }
            }

            binding.apply {
                chhy2ahtow3.setOnCheckedChangeListener { _, isChecked ->
                    if (chhy2ahtow3.isChecked) {

                        customDialogFR.window?.setFlags(
                            WindowManager.LayoutParams.FLAG_SECURE,
                            WindowManager.LayoutParams.FLAG_SECURE
                        )

                        bindingFR.frontright.setOnCheckedChangeListener { _, isChecked1 ->
                            if (bindingFR.frontright.isChecked) {
                                chhy2ahtow3.text =
                                    "بكس كفة سفلية الأمامي يمين"
                            } else {
                                chhy2ahtow3.text = "بكس كفة سفلية الأمامي"
                                bindingFR.s3erYadwee.setText("")
                            }
                            if (bindingFR.frontright.isChecked && bindingFR.frontleft.isChecked) {
                                chhy2ahtow3.text = "بكس كفة سفلية الأمامي يمين و يسار"
                                bindingFR.s3erYadwee.setText("16")
                            } else {
                                if (bindingFR.frontright.isChecked) {
                                    chhy2ahtow3.text = "بكس كفة سفلية الأمامي يمين"
                                    bindingFR.s3erYadwee.setText("8")
                                }
                                if (bindingFR.frontleft.isChecked) {
                                    chhy2ahtow3.text = "بكس كفة سفلية الأمامي يسار"
                                    bindingFR.s3erYadwee.setText("8")
                                }
                            }
                        }
                        bindingFR.frontleft.setOnCheckedChangeListener { _, isChecked2 ->
                            if (bindingFR.frontleft.isChecked) {
                                chhy2ahtow3.text = "بكس كفة سفلية الأمامي يسار"
                            } else {
                                chhy2ahtow3.text = "بكس كفة سفلية الأمامي"
                                bindingFR.s3erYadwee.setText("")
                            }
                            if (bindingFR.frontleft.isChecked && bindingFR.frontright.isChecked) {
                                chhy2ahtow3.text = "بكس كفة سفلية الأمامي يمين و يسار"
                                bindingFR.s3erYadwee.setText("16")
                            } else {
                                if (bindingFR.frontright.isChecked) {
                                    chhy2ahtow3.text = "بكس كفة سفلية الأمامي يمين"
                                    bindingFR.s3erYadwee.setText("8")
                                }
                                if (bindingFR.frontleft.isChecked) {
                                    chhy2ahtow3.text = "بكس كفة سفلية الأمامي يسار"
                                    bindingFR.s3erYadwee.setText("8")
                                }
                            }

                        }

                        bindingFR.buttonDailogSave.setOnClickListener {
                            if (!bindingFR.frontright.isChecked && !bindingFR.frontleft.isChecked) {
                                toast_notempty1.show()
                            } else {
                                val aa = bindingFR.s3erYadwee.text.toString().trim()
                                if (aa.isEmpty()) {
                                    toast_notempty.show()
                                } else {
                                    prichy2ahtow3.text = bindingFR.s3erYadwee.text.toString()
                                    customDialogFR.dismiss()
                                }
                            }
                        }
                        bindingFR.buttonDailogCancel.setOnClickListener {
                            chhy2ahtow3.isChecked = false
                            bindingFR.s3erYadwee.setText("")
                            customDialogFR.dismiss()
                        }
                        bindingFR.frontleft.isChecked = false
                        bindingFR.frontright.isChecked = false
                        customDialogFR.show()

                    } else {
                        chhy2ahtow3.text = "بكس كفة سفلية الأمامي"
                        prichy2ahtow3.text = ""
                    }
                }
            }
        }

        binding.apply {
            chhy2ahtow4.setOnCheckedChangeListener { _, isChecked ->
                if (chhy2ahtow4.isChecked) {

                    customDialogFR.window?.setFlags(
                        WindowManager.LayoutParams.FLAG_SECURE,
                        WindowManager.LayoutParams.FLAG_SECURE
                    )

                    bindingFR.frontright.setOnCheckedChangeListener { _, isChecked1 ->
                        if (bindingFR.frontright.isChecked) {
                            chhy2ahtow4.text =
                                "بكس شحمة خلفي يمين"
                        } else {
                            chhy2ahtow4.text = "بكس شحمة خلفي"
                            bindingFR.s3erYadwee.setText("")
                        }
                        if (bindingFR.frontright.isChecked && bindingFR.frontleft.isChecked) {
                            chhy2ahtow4.text = "بكس شحمة خلفي يمين و يسار"
                            bindingFR.s3erYadwee.setText("30")
                        } else {
                            if (bindingFR.frontright.isChecked) {
                                chhy2ahtow4.text = "بكس شحمة خلفي يمين"
                                bindingFR.s3erYadwee.setText("15")
                            }
                            if (bindingFR.frontleft.isChecked) {
                                chhy2ahtow4.text = "بكس شحمة خلفي يسار"
                                bindingFR.s3erYadwee.setText("15")
                            }
                        }
                    }
                    bindingFR.frontleft.setOnCheckedChangeListener { _, isChecked2 ->
                        if (bindingFR.frontleft.isChecked) {
                            chhy2ahtow4.text = "بكس شحمة خلفي يسار"
                        } else {
                            chhy2ahtow4.text = "بكس شحمة خلفي"
                            bindingFR.s3erYadwee.setText("")
                        }
                        if (bindingFR.frontleft.isChecked && bindingFR.frontright.isChecked) {
                            chhy2ahtow4.text = "بكس شحمة خلفي يمين و يسار"
                            bindingFR.s3erYadwee.setText("30")
                        } else {
                            if (bindingFR.frontright.isChecked) {
                                chhy2ahtow4.text = "بكس شحمة خلفي يمين"
                                bindingFR.s3erYadwee.setText("15")
                            }
                            if (bindingFR.frontleft.isChecked) {
                                chhy2ahtow4.text = "بكس شحمة خلفي يسار"
                                bindingFR.s3erYadwee.setText("15")
                            }
                        }
                    }

                    bindingFR.buttonDailogSave.setOnClickListener {
                        if (!bindingFR.frontright.isChecked && !bindingFR.frontleft.isChecked) {
                            toast_notempty1.show()
                        } else {
                            val aa = bindingFR.s3erYadwee.text.toString().trim()
                            if (aa.isEmpty()) {
                                toast_notempty.show()
                            } else {
                                prichy2ahtow4.text = bindingFR.s3erYadwee.text.toString()
                                customDialogFR.dismiss()
                            }
                        }
                    }
                    bindingFR.buttonDailogCancel.setOnClickListener {
                        chhy2ahtow4.isChecked = false
                        bindingFR.s3erYadwee.setText("")
                        customDialogFR.dismiss()
                    }
                    bindingFR.frontleft.isChecked = false
                    bindingFR.frontright.isChecked = false
                    customDialogFR.show()

                } else {
                    chhy2ahtow4.text = "بكس شحمة خلفي"
                    prichy2ahtow4.text = ""
                }
            }
        }

        binding.apply {
            chhy2ahtow5.setOnCheckedChangeListener { _, isChecked ->
                if (chhy2ahtow5.isChecked) {

                    customDialogFR.window?.setFlags(
                        WindowManager.LayoutParams.FLAG_SECURE,
                        WindowManager.LayoutParams.FLAG_SECURE
                    )
                    val window = customDialogFR.window
                    window?.setGravity(Gravity.BOTTOM)
                    val lp = window?.attributes
                    lp?.dimAmount = 0.0f
                    lp?.flags = lp?.flags?.or(WindowManager.LayoutParams.FLAG_DIM_BEHIND)
                    window?.attributes = lp

                    bindingFR.frontright.setOnCheckedChangeListener { _, isChecked1 ->
                        if (bindingFR.frontright.isChecked) {
                            chhy2ahtow5.text =
                                "بكس كفة عرضية المسطرة يمين"
                        } else {
                            chhy2ahtow5.text = "بكس كفة عرضية المسطرة"
                            bindingFR.s3erYadwee.setText("")
                        }

                        if (bindingFR.frontright.isChecked && bindingFR.frontleft.isChecked) {
                            chhy2ahtow5.text = "بكس كفة عرضية المسطرة يمين و يسار"
                            bindingFR.s3erYadwee.setText("14")
                        } else {
                            if (bindingFR.frontright.isChecked) {
                                chhy2ahtow5.text = "بكس كفة عرضية المسطرة يمين"
                                bindingFR.s3erYadwee.setText("7")
                            }
                            if (bindingFR.frontleft.isChecked) {
                                chhy2ahtow5.text = "بكس كفة عرضية المسطرة يسار"
                                bindingFR.s3erYadwee.setText("7")
                            }
                        }
                    }
                    bindingFR.frontleft.setOnCheckedChangeListener { _, isChecked2 ->
                        if (bindingFR.frontleft.isChecked) {
                            chhy2ahtow5.text = "بكس كفة عرضية المسطرة يسار"
                        } else {
                            chhy2ahtow5.text = "بكس كفة عرضية المسطرة"
                            bindingFR.s3erYadwee.setText("")
                        }
                        if (bindingFR.frontleft.isChecked && bindingFR.frontright.isChecked) {
                            chhy2ahtow5.text = "بكس كفة عرضية المسطرة يمين و يسار"
                            bindingFR.s3erYadwee.setText("14")
                        } else {
                            if (bindingFR.frontright.isChecked) {
                                chhy2ahtow5.text = "بكس كفة عرضية المسطرة يمين"
                                bindingFR.s3erYadwee.setText("7")
                            }
                            if (bindingFR.frontleft.isChecked) {
                                chhy2ahtow5.text = "بكس كفة عرضية المسطرة يسار"
                                bindingFR.s3erYadwee.setText("7")
                            }
                        }
                    }

                    bindingFR.buttonDailogSave.setOnClickListener {
                        if (!bindingFR.frontright.isChecked && !bindingFR.frontleft.isChecked) {
                            toast_notempty1.show()
                        } else {
                            val aa = bindingFR.s3erYadwee.text.toString().trim()
                            if (aa.isEmpty()) {
                                toast_notempty.show()
                            } else {
                                prichy2ahtow5.text = bindingFR.s3erYadwee.text.toString()
                                customDialogFR.dismiss()
                            }
                        }
                    }
                    bindingFR.buttonDailogCancel.setOnClickListener {
                        chhy2ahtow5.isChecked = false
                        bindingFR.s3erYadwee.setText("")
                        customDialogFR.dismiss()
                    }
                    bindingFR.frontleft.isChecked = false
                    bindingFR.frontright.isChecked = false
                    customDialogFR.show()

                } else {
                    chhy2ahtow5.text = "بكس كفة عرضية المسطرة"
                    prichy2ahtow5.text = ""
                }
            }
        }

        binding.apply {
            chhy2ahtow6.setOnCheckedChangeListener { _, isChecked ->
                if (chhy2ahtow6.isChecked) {

                    customDialogFR.window?.setFlags(
                        WindowManager.LayoutParams.FLAG_SECURE,
                        WindowManager.LayoutParams.FLAG_SECURE
                    )
                    val window = customDialogFR.window
                    window?.setGravity(Gravity.BOTTOM)
                    val lp = window?.attributes
                    lp?.dimAmount = 0.0f
                    lp?.flags = lp?.flags?.or(WindowManager.LayoutParams.FLAG_DIM_BEHIND)
                    window?.attributes = lp

                    bindingFR.frontright.setOnCheckedChangeListener { _, isChecked1 ->
                        if (bindingFR.frontright.isChecked) {
                            chhy2ahtow6.text =
                                "بكس كفة سفلية أمامية الخلفي يمين"
                        } else {
                            chhy2ahtow6.text = "بكس كفة سفلية أمامية الخلفي"
                            bindingFR.s3erYadwee.setText("")
                        }
                        if (bindingFR.frontright.isChecked && bindingFR.frontleft.isChecked) {
                            chhy2ahtow6.text = "بكس كفة سفلية أمامية الخلفي يمين و يسار"
                            bindingFR.s3erYadwee.setText("16")
                        } else {
                            if (bindingFR.frontright.isChecked) {
                                chhy2ahtow6.text = "بكس كفة سفلية أمامية الخلفي يمين"
                                bindingFR.s3erYadwee.setText("8")
                            }
                            if (bindingFR.frontleft.isChecked) {
                                chhy2ahtow6.text = "بكس كفة سفلية أمامية الخلفي يسار"
                                bindingFR.s3erYadwee.setText("8")
                            }
                        }
                    }
                    bindingFR.frontleft.setOnCheckedChangeListener { _, isChecked2 ->
                        if (bindingFR.frontleft.isChecked) {
                            chhy2ahtow6.text = "بكس كفة سفلية أمامية الخلفي يسار"
                        } else {
                            chhy2ahtow6.text = "بكس كفة سفلية أمامية الخلفي"
                            bindingFR.s3erYadwee.setText("")
                        }

                        if (bindingFR.frontleft.isChecked && bindingFR.frontright.isChecked) {
                            chhy2ahtow6.text = "بكس كفة سفلية أمامية الخلفي يمين و يسار"
                            bindingFR.s3erYadwee.setText("16")
                        } else {
                            if (bindingFR.frontright.isChecked) {
                                chhy2ahtow6.text = "بكس كفة سفلية أمامية الخلفي يمين"
                                bindingFR.s3erYadwee.setText("8")
                            }
                            if (bindingFR.frontleft.isChecked) {
                                chhy2ahtow6.text = "بكس كفة سفلية أمامية الخلفي يسار"
                                bindingFR.s3erYadwee.setText("8")
                            }
                        }

                    }

                    bindingFR.buttonDailogSave.setOnClickListener {
                        if (!bindingFR.frontright.isChecked && !bindingFR.frontleft.isChecked) {
                            toast_notempty1.show()
                        } else {
                            val aa = bindingFR.s3erYadwee.text.toString().trim()
                            if (aa.isEmpty()) {
                                toast_notempty.show()
                            } else {
                                prichy2ahtow6.text = bindingFR.s3erYadwee.text.toString()
                                customDialogFR.dismiss()
                            }
                        }
                    }
                    bindingFR.buttonDailogCancel.setOnClickListener {
                        chhy2ahtow6.isChecked = false
                        bindingFR.s3erYadwee.setText("")
                        customDialogFR.dismiss()
                    }
                    bindingFR.frontleft.isChecked = false
                    bindingFR.frontright.isChecked = false
                    customDialogFR.show()

                } else {
                    chhy2ahtow6.text = "بكس كفة سفلية أمامية الخلفي"
                    prichy2ahtow6.text = ""
                }
            }
        }

        binding.apply {
            chhy2ahtow7.setOnCheckedChangeListener { _, isChecked ->
                if (chhy2ahtow7.isChecked) {

                    customDialogFR.window?.setFlags(
                        WindowManager.LayoutParams.FLAG_SECURE,
                        WindowManager.LayoutParams.FLAG_SECURE
                    )
                    customDialogFR
                    
                    bindingFR.frontright.setOnCheckedChangeListener { _, isChecked1 ->
                        if (bindingFR.frontright.isChecked) {
                            chhy2ahtow7.text =
                                "بكس هب سفلي خلفي يمين"
                        } else {
                            chhy2ahtow7.text = "بكس هب سفلي خلفي"
                            bindingFR.s3erYadwee.setText("")
                        }
                        if (bindingFR.frontright.isChecked && bindingFR.frontleft.isChecked) {
                            chhy2ahtow7.text = "بكس هب سفلي خلفي يمين و يسار"
                            bindingFR.s3erYadwee.setText("20")
                        } else {
                            if (bindingFR.frontright.isChecked) {
                                chhy2ahtow7.text = "بكس هب سفلي خلفي يمين"
                                bindingFR.s3erYadwee.setText("10")
                            }
                            if (bindingFR.frontleft.isChecked) {
                                chhy2ahtow7.text = "بكس هب سفلي خلفي يسار"
                                bindingFR.s3erYadwee.setText("10")
                            }
                        }
                    }
                    bindingFR.frontleft.setOnCheckedChangeListener { _, isChecked2 ->
                        if (bindingFR.frontleft.isChecked) {
                            chhy2ahtow7.text = "بكس هب سفلي خلفي يسار"
                        } else {
                            chhy2ahtow7.text = "بكس هب سفلي خلفي"
                            bindingFR.s3erYadwee.setText("")
                        }
                        if (bindingFR.frontleft.isChecked && bindingFR.frontright.isChecked) {
                            chhy2ahtow7.text = "بكس هب سفلي خلفي يمين و يسار"
                            bindingFR.s3erYadwee.setText("20")
                        } else {
                            if (bindingFR.frontright.isChecked) {
                                chhy2ahtow7.text = "بكس هب سفلي خلفي يمين"
                                bindingFR.s3erYadwee.setText("10")
                            }
                            if (bindingFR.frontleft.isChecked) {
                                chhy2ahtow7.text = "بكس هب سفلي خلفي يسار"
                                bindingFR.s3erYadwee.setText("10")
                            }
                        }
                    }

                    bindingFR.buttonDailogSave.setOnClickListener {
                        if (!bindingFR.frontright.isChecked && !bindingFR.frontleft.isChecked) {
                            toast_notempty1.show()
                        } else {
                            val aa = bindingFR.s3erYadwee.text.toString().trim()
                            if (aa.isEmpty()) {
                                toast_notempty.show()
                            } else {
                                prichy2ahtow7.text = bindingFR.s3erYadwee.text.toString()
                                customDialogFR.dismiss()
                            }
                        }
                    }
                    bindingFR.buttonDailogCancel.setOnClickListener {
                        chhy2ahtow7.isChecked = false
                        bindingFR.s3erYadwee.setText("")
                        customDialogFR.dismiss()
                    }
                    bindingFR.frontleft.isChecked = false
                    bindingFR.frontright.isChecked = false
                    customDialogFR.show()

                } else {
                    chhy2ahtow7.text = "بكس هب سفلي خلفي"
                    prichy2ahtow7.text = ""
                }
            }
        }

        binding.apply{
            chhy2ahtow8.setOnCheckedChangeListener { _ ,  isChecked ->
            if (chhy2ahtow8.isChecked) {

                customDialogR2SX.window?.setFlags(WindowManager.LayoutParams.FLAG_SECURE, WindowManager.LayoutParams.FLAG_SECURE)

                customDialogR2SX.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
                bindingR2.titR2sOut.text="امامي"
                bindingR2.titR2sIn.text="خلفي"

                val window = customDialogR2SX.window
                window?.setGravity(Gravity.BOTTOM)
                val lp = window?.attributes
                lp?.dimAmount = 0.0f
                lp?.flags = lp?.flags?.or(WindowManager.LayoutParams.FLAG_DIM_BEHIND)
                window?.attributes = lp

                bindingR2.outsideright.setOnCheckedChangeListener { _ ,  isChecked1 ->

                    if (bindingR2.outsideright.isChecked) {
                        chhy2ahtow8.text = "صنوبرص امامي يمين"
                    } else {
                        chhy2ahtow8.text = "صنوبرص"
                        bindingR2.s3erR2sAcx.setText("")
                    }
                    if (bindingR2.outsideright.isChecked && bindingR2.outsideleft.isChecked && bindingR2.insideright.isChecked && bindingR2.insideleft.isChecked) {
                        chhy2ahtow8.text = "تغير جميع الصنوبرصات"
                        bindingR2.s3erR2sAcx.setText("60")
                    } else {
                        if (bindingR2.outsideright.isChecked && bindingR2.outsideleft.isChecked && bindingR2.insideright.isChecked) {
                            chhy2ahtow8.text = "صنوبرص امامي كامل و الخلفي يمين"
                            bindingR2.s3erR2sAcx.setText("45")
                        } else {
                            if (bindingR2.outsideright.isChecked && bindingR2.outsideleft.isChecked && bindingR2.insideleft.isChecked) {
                                chhy2ahtow8.text = "صنوبرص امامي كامل و الخلفي يسار"
                                bindingR2.s3erR2sAcx.setText("45")
                            } else {
                                if (bindingR2.outsideright.isChecked && bindingR2.insideright.isChecked && bindingR2.insideleft.isChecked) {
                                    chhy2ahtow8.text = "صنوبرص امامي يمين و الخلفيين"
                                    bindingR2.s3erR2sAcx.setText("45")
                                } else {
                                    if (bindingR2.outsideleft.isChecked && bindingR2.insideright.isChecked && bindingR2.insideleft.isChecked) {
                                        chhy2ahtow8.text = "صنوبرص امامي يسار و الخلفيين"
                                        bindingR2.s3erR2sAcx.setText("45")
                                    } else {
                                        if (bindingR2.outsideright.isChecked && bindingR2.outsideleft.isChecked) {
                                            chhy2ahtow8.text = "صنوبرص امامي يمين و يسار"
                                            bindingR2.s3erR2sAcx.setText("30")
                                        } else {
                                            if (bindingR2.outsideright.isChecked && bindingR2.insideright.isChecked) {
                                                chhy2ahtow8.text = "صنوبرص امامي يمين و الخلفي يمين"
                                                bindingR2.s3erR2sAcx.setText("30")
                                            } else {
                                                if (bindingR2.outsideright.isChecked && bindingR2.insideleft.isChecked) {
                                                    chhy2ahtow8.text = "صنوبرص امامي يمين و الخلفي يسار"
                                                    bindingR2.s3erR2sAcx.setText("30")
                                                } else {
                                                    if (bindingR2.outsideleft.isChecked && bindingR2.insideright.isChecked) {
                                                        chhy2ahtow8.text =
                                                            "صنوبرص امامي يسار و الخلفي يمين"
                                                        bindingR2.s3erR2sAcx.setText("30")
                                                    } else {
                                                        if (bindingR2.outsideleft.isChecked && bindingR2.insideleft.isChecked) {
                                                            chhy2ahtow8.text =
                                                                "صنوبرص امامي يسار و الخلفي يسار"
                                                            bindingR2.s3erR2sAcx.setText("30")
                                                        } else {
                                                            if (bindingR2.insideright.isChecked && bindingR2.insideleft.isChecked) {
                                                                chhy2ahtow8.text =
                                                                    "صنوبرص خلفي يمين و يسار"
                                                                bindingR2.s3erR2sAcx.setText(
                                                                    "30"
                                                                )
                                                            } else {
                                                                if (bindingR2.outsideright.isChecked) {
                                                                    chhy2ahtow8.text =
                                                                        "صنوبرص امامي يمين"
                                                                    bindingR2.s3erR2sAcx.setText(
                                                                        "15"
                                                                    )
                                                                }
                                                                if (bindingR2.outsideleft.isChecked) {
                                                                    chhy2ahtow8.text =
                                                                        "صنوبرص امامي يسار"
                                                                    bindingR2.s3erR2sAcx.setText(
                                                                        "15"
                                                                    )
                                                                }
                                                                if (bindingR2.insideleft.isChecked) {
                                                                    chhy2ahtow8.text =
                                                                        "صنوبرص خلفي يسار"
                                                                    bindingR2.s3erR2sAcx.setText(
                                                                        "15"
                                                                    )
                                                                }
                                                                if (bindingR2.insideright.isChecked) {
                                                                    chhy2ahtow8.text =
                                                                        "صنوبرص خلفي يمين"
                                                                    bindingR2.s3erR2sAcx.setText(
                                                                        "15"
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

                bindingR2.outsideleft.setOnCheckedChangeListener { _ ,  isChecked2 ->
                    if (bindingR2.outsideleft.isChecked) {
                        chhy2ahtow8.text = "صنوبرص امامي يسار"
                    } else {
                        chhy2ahtow8.text = "صنوبرص"
                        bindingR2.s3erR2sAcx.setText("")
                    }
                    if (bindingR2.outsideright.isChecked && bindingR2.outsideleft.isChecked && bindingR2.insideright.isChecked && bindingR2.insideleft.isChecked) {
                        chhy2ahtow8.text = "تغير جميع الصنوبرصات"
                        bindingR2.s3erR2sAcx.setText("60")
                    } else {
                        if (bindingR2.outsideright.isChecked && bindingR2.outsideleft.isChecked && bindingR2.insideright.isChecked) {
                            chhy2ahtow8.text = "صنوبرص امامي كامل و الخلفي يمين"
                            bindingR2.s3erR2sAcx.setText("45")
                        } else {
                            if (bindingR2.outsideright.isChecked && bindingR2.outsideleft.isChecked && bindingR2.insideleft.isChecked) {
                                chhy2ahtow8.text = "صنوبرص امامي كامل و الخلفي يسار"
                                bindingR2.s3erR2sAcx.setText("45")
                            } else {
                                if (bindingR2.outsideright.isChecked && bindingR2.insideright.isChecked && bindingR2.insideleft.isChecked) {
                                    chhy2ahtow8.text = "صنوبرص امامي يمين و الخلفيين"
                                    bindingR2.s3erR2sAcx.setText("45")
                                } else {
                                    if (bindingR2.outsideleft.isChecked && bindingR2.insideright.isChecked && bindingR2.insideleft.isChecked) {
                                        chhy2ahtow8.text = "صنوبرص امامي يسار و الخلفيين"
                                        bindingR2.s3erR2sAcx.setText("45")
                                    } else {
                                        if (bindingR2.outsideright.isChecked && bindingR2.outsideleft.isChecked) {
                                            chhy2ahtow8.text = "صنوبرص امامي يمين و يسار"
                                            bindingR2.s3erR2sAcx.setText("30")
                                        } else {
                                            if (bindingR2.outsideright.isChecked && bindingR2.insideright.isChecked) {
                                                chhy2ahtow8.text = "صنوبرص امامي يمين و الخلفي يمين"
                                                bindingR2.s3erR2sAcx.setText("30")
                                            } else {
                                                if (bindingR2.outsideright.isChecked && bindingR2.insideleft.isChecked) {
                                                    chhy2ahtow8.text = "صنوبرص امامي يمين و الخلفي يسار"
                                                    bindingR2.s3erR2sAcx.setText("30")
                                                } else {
                                                    if (bindingR2.outsideleft.isChecked && bindingR2.insideright.isChecked) {
                                                        chhy2ahtow8.text =
                                                            "صنوبرص امامي يسار و الخلفي يمين"
                                                        bindingR2.s3erR2sAcx.setText("30")
                                                    } else {
                                                        if (bindingR2.outsideleft.isChecked && bindingR2.insideleft.isChecked) {
                                                            chhy2ahtow8.text =
                                                                "صنوبرص امامي يسار و الخلفي يسار"
                                                            bindingR2.s3erR2sAcx.setText("30")
                                                        } else {
                                                            if (bindingR2.insideright.isChecked && bindingR2.insideleft.isChecked) {
                                                                chhy2ahtow8.text =
                                                                    "صنوبرص خلفي يمين و يسار"
                                                                bindingR2.s3erR2sAcx.setText(
                                                                    "30"
                                                                )
                                                            } else {
                                                                if (bindingR2.outsideright.isChecked) {
                                                                    chhy2ahtow8.text =
                                                                        "صنوبرص امامي يمين"
                                                                    bindingR2.s3erR2sAcx.setText(
                                                                        "15"
                                                                    )
                                                                }
                                                                if (bindingR2.outsideleft.isChecked) {
                                                                    chhy2ahtow8.text =
                                                                        "صنوبرص امامي يسار"
                                                                    bindingR2.s3erR2sAcx.setText(
                                                                        "15"
                                                                    )
                                                                }
                                                                if (bindingR2.insideleft.isChecked) {
                                                                    chhy2ahtow8.text =
                                                                        "صنوبرص خلفي يسار"
                                                                    bindingR2.s3erR2sAcx.setText(
                                                                        "15"
                                                                    )
                                                                }
                                                                if (bindingR2.insideright.isChecked) {
                                                                    chhy2ahtow8.text =
                                                                        "صنوبرص خلفي يمين"
                                                                    bindingR2.s3erR2sAcx.setText(
                                                                        "15"
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

                bindingR2.insideleft.setOnCheckedChangeListener { _ ,  isChecked2 ->
                    if (bindingR2.outsideright.isChecked) {
                        chhy2ahtow8.text = "صنوبرص خلفي يمين"
                    } else {
                        chhy2ahtow8.text = "صنوبرص"
                        bindingR2.s3erR2sAcx.setText("")
                    }
                    if (bindingR2.outsideright.isChecked && bindingR2.outsideleft.isChecked && bindingR2.insideright.isChecked && bindingR2.insideleft.isChecked) {
                        chhy2ahtow8.text = "تغير جميع الصنوبرصات"
                        bindingR2.s3erR2sAcx.setText("60")
                    } else {
                        if (bindingR2.outsideright.isChecked && bindingR2.outsideleft.isChecked && bindingR2.insideright.isChecked) {
                            chhy2ahtow8.text = "صنوبرص امامي كامل و الخلفي يمين"
                            bindingR2.s3erR2sAcx.setText("45")
                        } else {
                            if (bindingR2.outsideright.isChecked && bindingR2.outsideleft.isChecked && bindingR2.insideleft.isChecked) {
                                chhy2ahtow8.text = "صنوبرص امامي كامل و الخلفي يسار"
                                bindingR2.s3erR2sAcx.setText("45")
                            } else {
                                if (bindingR2.outsideright.isChecked && bindingR2.insideright.isChecked && bindingR2.insideleft.isChecked) {
                                    chhy2ahtow8.text = "صنوبرص امامي يمين و الخلفيين"
                                    bindingR2.s3erR2sAcx.setText("45")
                                } else {
                                    if (bindingR2.outsideleft.isChecked && bindingR2.insideright.isChecked && bindingR2.insideleft.isChecked) {
                                        chhy2ahtow8.text = "صنوبرص امامي يسار و الخلفيين"
                                        bindingR2.s3erR2sAcx.setText("45")
                                    } else {
                                        if (bindingR2.outsideright.isChecked && bindingR2.outsideleft.isChecked) {
                                            chhy2ahtow8.text = "صنوبرص امامي يمين و يسار"
                                            bindingR2.s3erR2sAcx.setText("30")
                                        } else {
                                            if (bindingR2.outsideright.isChecked && bindingR2.insideright.isChecked) {
                                                chhy2ahtow8.text = "صنوبرص امامي يمين و الخلفي يمين"
                                                bindingR2.s3erR2sAcx.setText("30")
                                            } else {
                                                if (bindingR2.outsideright.isChecked && bindingR2.insideleft.isChecked) {
                                                    chhy2ahtow8.text = "صنوبرص امامي يمين و الخلفي يسار"
                                                    bindingR2.s3erR2sAcx.setText("30")
                                                } else {
                                                    if (bindingR2.outsideleft.isChecked && bindingR2.insideright.isChecked) {
                                                        chhy2ahtow8.text =
                                                            "صنوبرص امامي يسار و الخلفي يمين"
                                                        bindingR2.s3erR2sAcx.setText("30")
                                                    } else {
                                                        if (bindingR2.outsideleft.isChecked && bindingR2.insideleft.isChecked) {
                                                            chhy2ahtow8.text =
                                                                "صنوبرص امامي يسار و الخلفي يسار"
                                                            bindingR2.s3erR2sAcx.setText("30")
                                                        } else {
                                                            if (bindingR2.insideright.isChecked && bindingR2.insideleft.isChecked) {
                                                                chhy2ahtow8.text =
                                                                    "صنوبرص خلفي يمين و يسار"
                                                                bindingR2.s3erR2sAcx.setText(
                                                                    "30"
                                                                )
                                                            } else {

                                                                if (bindingR2.outsideright.isChecked) {
                                                                    chhy2ahtow8.text =
                                                                        "صنوبرص امامي يمين"
                                                                    bindingR2.s3erR2sAcx.setText(
                                                                        "15"
                                                                    )
                                                                }
                                                                if (bindingR2.outsideleft.isChecked) {
                                                                    chhy2ahtow8.text =
                                                                        "صنوبرص امامي يسار"
                                                                    bindingR2.s3erR2sAcx.setText(
                                                                        "15"
                                                                    )
                                                                }
                                                                if (bindingR2.insideleft.isChecked) {
                                                                    chhy2ahtow8.text =
                                                                        "صنوبرص خلفي يسار"
                                                                    bindingR2.s3erR2sAcx.setText(
                                                                        "15"
                                                                    )
                                                                }
                                                                if (bindingR2.insideright.isChecked) {
                                                                    chhy2ahtow8.text =
                                                                        "صنوبرص خلفي يمين"
                                                                    bindingR2.s3erR2sAcx.setText(
                                                                        "15"
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

                bindingR2.insideright.setOnCheckedChangeListener { _ ,  isChecked2 ->
                    if (bindingR2.insideright.isChecked) {
                        chhy2ahtow8.text = "صنوبرص خلفي يسار"
                    } else {
                        chhy2ahtow8.text = "صنوبرص"
                        bindingR2.s3erR2sAcx.setText("")
                    }
                    if (bindingR2.outsideright.isChecked && bindingR2.outsideleft.isChecked && bindingR2.insideright.isChecked && bindingR2.insideleft.isChecked) {
                        chhy2ahtow8.text = "تغير جميع الصنوبرصات"
                        bindingR2.s3erR2sAcx.setText("60")
                    } else {
                        if (bindingR2.outsideright.isChecked && bindingR2.outsideleft.isChecked && bindingR2.insideright.isChecked) {
                            chhy2ahtow8.text = "صنوبرص امامي كامل و الخلفي يمين"
                            bindingR2.s3erR2sAcx.setText("45")
                        } else {
                            if (bindingR2.outsideright.isChecked && bindingR2.outsideleft.isChecked && bindingR2.insideleft.isChecked) {
                                chhy2ahtow8.text = "صنوبرص امامي كامل و الخلفي يسار"
                                bindingR2.s3erR2sAcx.setText("45")
                            } else {
                                if (bindingR2.outsideright.isChecked && bindingR2.insideright.isChecked && bindingR2.insideleft.isChecked) {
                                    chhy2ahtow8.text = "صنوبرص امامي يمين و الخلفيين"
                                    bindingR2.s3erR2sAcx.setText("45")
                                } else {
                                    if (bindingR2.outsideleft.isChecked && bindingR2.insideright.isChecked && bindingR2.insideleft.isChecked) {
                                        chhy2ahtow8.text = "صنوبرص امامي يسار و الخلفيين"
                                        bindingR2.s3erR2sAcx.setText("45")
                                    } else {
                                        if (bindingR2.outsideright.isChecked && bindingR2.outsideleft.isChecked) {
                                            chhy2ahtow8.text = "صنوبرص امامي يمين و يسار"
                                            bindingR2.s3erR2sAcx.setText("30")
                                        } else {
                                            if (bindingR2.outsideright.isChecked && bindingR2.insideright.isChecked) {
                                                chhy2ahtow8.text = "صنوبرص امامي يمين و الخلفي يمين"
                                                bindingR2.s3erR2sAcx.setText("30")
                                            } else {
                                                if (bindingR2.outsideright.isChecked && bindingR2.insideleft.isChecked) {
                                                    chhy2ahtow8.text = "صنوبرص امامي يمين و الخلفي يسار"
                                                    bindingR2.s3erR2sAcx.setText("30")
                                                } else {
                                                    if (bindingR2.outsideleft.isChecked && bindingR2.insideright.isChecked) {
                                                        chhy2ahtow8.text =
                                                            "صنوبرص امامي يسار و الخلفي يمين"
                                                        bindingR2.s3erR2sAcx.setText("30")
                                                    } else {
                                                        if (bindingR2.outsideleft.isChecked && bindingR2.insideleft.isChecked) {
                                                            chhy2ahtow8.text =
                                                                "صنوبرص امامي يسار و الخلفي يسار"
                                                            bindingR2.s3erR2sAcx.setText("30")
                                                        } else {
                                                            if (bindingR2.insideright.isChecked && bindingR2.insideleft.isChecked) {
                                                                chhy2ahtow8.text =
                                                                    "صنوبرص خلفي يمين و يسار"
                                                                bindingR2.s3erR2sAcx.setText(
                                                                    "30"
                                                                )
                                                            } else {

                                                                if (bindingR2.outsideright.isChecked) {
                                                                    chhy2ahtow8.text =
                                                                        "صنوبرص امامي يمين"
                                                                    bindingR2.s3erR2sAcx.setText(
                                                                        "15"
                                                                    )
                                                                }
                                                                if (bindingR2.outsideleft.isChecked) {
                                                                    chhy2ahtow8.text =
                                                                        "صنوبرص امامي يسار"
                                                                    bindingR2.s3erR2sAcx.setText(
                                                                        "15"
                                                                    )
                                                                }
                                                                if (bindingR2.insideleft.isChecked) {
                                                                    chhy2ahtow8.text =
                                                                        "صنوبرص خلفي يسار"
                                                                    bindingR2.s3erR2sAcx.setText(
                                                                        "15"
                                                                    )
                                                                }
                                                                if (bindingR2.insideright.isChecked) {
                                                                    chhy2ahtow8.text =
                                                                        "صنوبرص خلفي يمين"
                                                                    bindingR2.s3erR2sAcx.setText(
                                                                        "15"
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
                            prichy2ahtow8.text = bindingR2.s3erR2sAcx.text.toString()
                            customDialogR2SX.dismiss()
                        }
                    }
                }
                bindingR2.btnR2sCan.setOnClickListener {
                    if (prichy2ahtow8.text.toString().isEmpty()) {
                        chhy2ahtow8.text = "صنوبرص"
                        chhy2ahtow8.isChecked = false
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
                    chhy2ahtow8.text = "صنوبرص"
                    prichy2ahtow8.text = ""
                }
        }
        }

        binding.apply{
            chhy2ahtow9.setOnCheckedChangeListener { _ ,  isChecked ->
            if (chhy2ahtow9.isChecked) {

                customDialogR2SX.window?.setFlags(WindowManager.LayoutParams.FLAG_SECURE, WindowManager.LayoutParams.FLAG_SECURE)

                customDialogR2SX.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
                bindingR2.titR2sOut.text="امامي"
                bindingR2.titR2sIn.text="خلفي"

                val window = customDialogR2SX.window
                window?.setGravity(Gravity.BOTTOM)
                val lp = window?.attributes
                lp?.dimAmount = 0.0f
                lp?.flags = lp?.flags?.or(WindowManager.LayoutParams.FLAG_DIM_BEHIND)
                window?.attributes = lp

                bindingR2.outsideright.setOnCheckedChangeListener { _ ,  isChecked1 ->

                    if (bindingR2.outsideright.isChecked) {
                        chhy2ahtow9.text = "بيلية عجل امامي يمين"
                    } else {
                        chhy2ahtow9.text = "بيلية عجل"
                        bindingR2.s3erR2sAcx.setText("")
                    }
                    if (bindingR2.outsideright.isChecked && bindingR2.outsideleft.isChecked && bindingR2.insideright.isChecked && bindingR2.insideleft.isChecked) {
                        chhy2ahtow9.text = "تغير جميع بيل العجلات"
                        bindingR2.s3erR2sAcx.setText("50")
                    } else {
                        if (bindingR2.outsideright.isChecked && bindingR2.outsideleft.isChecked && bindingR2.insideright.isChecked) {
                            chhy2ahtow9.text = "بيلية عجل امامي كامل و الخلفي يمين"
                            bindingR2.s3erR2sAcx.setText("35")
                        } else {
                            if (bindingR2.outsideright.isChecked && bindingR2.outsideleft.isChecked && bindingR2.insideleft.isChecked) {
                                chhy2ahtow9.text = "بيلية عجل امامي كامل و الخلفي يسار"
                                bindingR2.s3erR2sAcx.setText("35")
                            } else {
                                if (bindingR2.outsideright.isChecked && bindingR2.insideright.isChecked && bindingR2.insideleft.isChecked) {
                                    chhy2ahtow9.text = "بيلية عجل امامي يمين و الخلفيين"
                                    bindingR2.s3erR2sAcx.setText("40")
                                } else {
                                    if (bindingR2.outsideleft.isChecked && bindingR2.insideright.isChecked && bindingR2.insideleft.isChecked) {
                                        chhy2ahtow9.text = "بيلية عجل امامي يسار و الخلفيين"
                                        bindingR2.s3erR2sAcx.setText("40")
                                    } else {
                                        if (bindingR2.outsideright.isChecked && bindingR2.outsideleft.isChecked) {
                                            chhy2ahtow9.text = "بيلية عجل امامي يمين و يسار"
                                            bindingR2.s3erR2sAcx.setText("20")
                                        } else {
                                            if (bindingR2.outsideright.isChecked && bindingR2.insideright.isChecked) {
                                                chhy2ahtow9.text = "بيلية عجل امامي يمين و الخلفي يمين"
                                                bindingR2.s3erR2sAcx.setText("25")
                                            } else {
                                                if (bindingR2.outsideright.isChecked && bindingR2.insideleft.isChecked) {
                                                    chhy2ahtow9.text = "بيلية عجل امامي يمين و الخلفي يسار"
                                                    bindingR2.s3erR2sAcx.setText("25")
                                                } else {
                                                    if (bindingR2.outsideleft.isChecked && bindingR2.insideright.isChecked) {
                                                        chhy2ahtow9.text =
                                                            "بيلية عجل امامي يسار و الخلفي يمين"
                                                        bindingR2.s3erR2sAcx.setText("25")
                                                    } else {
                                                        if (bindingR2.outsideleft.isChecked && bindingR2.insideleft.isChecked) {
                                                            chhy2ahtow9.text =
                                                                "بيلية عجل امامي يسار و الخلفي يسار"
                                                            bindingR2.s3erR2sAcx.setText("25")
                                                        } else {
                                                            if (bindingR2.insideright.isChecked && bindingR2.insideleft.isChecked) {
                                                                chhy2ahtow9.text =
                                                                    "بيلية عجل خلفي يمين و يسار"
                                                                bindingR2.s3erR2sAcx.setText(
                                                                    "30"
                                                                )
                                                            } else {
                                                                if (bindingR2.outsideright.isChecked) {
                                                                    chhy2ahtow9.text =
                                                                        "بيلية عجل امامي يمين"
                                                                    bindingR2.s3erR2sAcx.setText(
                                                                        "10"
                                                                    )
                                                                }
                                                                if (bindingR2.outsideleft.isChecked) {
                                                                    chhy2ahtow9.text =
                                                                        "بيلية عجل امامي يسار"
                                                                    bindingR2.s3erR2sAcx.setText(
                                                                        "10"
                                                                    )
                                                                }
                                                                if (bindingR2.insideleft.isChecked) {
                                                                    chhy2ahtow9.text =
                                                                        "بيلية عجل خلفي يسار"
                                                                    bindingR2.s3erR2sAcx.setText(
                                                                        "15"
                                                                    )
                                                                }
                                                                if (bindingR2.insideright.isChecked) {
                                                                    chhy2ahtow9.text =
                                                                        "بيلية عجل خلفي يمين"
                                                                    bindingR2.s3erR2sAcx.setText(
                                                                        "15"
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

                bindingR2.outsideleft.setOnCheckedChangeListener { _ ,  isChecked2 ->
                    if (bindingR2.outsideleft.isChecked) {
                        chhy2ahtow9.text = "بيلية عجل امامي يمين"
                    } else {
                        chhy2ahtow9.text = "بيلية عجل"
                        bindingR2.s3erR2sAcx.setText("")
                    }
                    if (bindingR2.outsideright.isChecked && bindingR2.outsideleft.isChecked && bindingR2.insideright.isChecked && bindingR2.insideleft.isChecked) {
                        chhy2ahtow9.text = "تغير جميع بيل العجلات"
                        bindingR2.s3erR2sAcx.setText("50")
                    } else {
                        if (bindingR2.outsideright.isChecked && bindingR2.outsideleft.isChecked && bindingR2.insideright.isChecked) {
                            chhy2ahtow9.text = "بيلية عجل امامي كامل و الخلفي يمين"
                            bindingR2.s3erR2sAcx.setText("35")
                        } else {
                            if (bindingR2.outsideright.isChecked && bindingR2.outsideleft.isChecked && bindingR2.insideleft.isChecked) {
                                chhy2ahtow9.text = "بيلية عجل امامي كامل و الخلفي يسار"
                                bindingR2.s3erR2sAcx.setText("35")
                            } else {
                                if (bindingR2.outsideright.isChecked && bindingR2.insideright.isChecked && bindingR2.insideleft.isChecked) {
                                    chhy2ahtow9.text = "بيلية عجل امامي يمين و الخلفيين"
                                    bindingR2.s3erR2sAcx.setText("40")
                                } else {
                                    if (bindingR2.outsideleft.isChecked && bindingR2.insideright.isChecked && bindingR2.insideleft.isChecked) {
                                        chhy2ahtow9.text = "بيلية عجل امامي يسار و الخلفيين"
                                        bindingR2.s3erR2sAcx.setText("40")
                                    } else {
                                        if (bindingR2.outsideright.isChecked && bindingR2.outsideleft.isChecked) {
                                            chhy2ahtow9.text = "بيلية عجل امامي يمين و يسار"
                                            bindingR2.s3erR2sAcx.setText("20")
                                        } else {
                                            if (bindingR2.outsideright.isChecked && bindingR2.insideright.isChecked) {
                                                chhy2ahtow9.text = "بيلية عجل امامي يمين و الخلفي يمين"
                                                bindingR2.s3erR2sAcx.setText("25")
                                            } else {
                                                if (bindingR2.outsideright.isChecked && bindingR2.insideleft.isChecked) {
                                                    chhy2ahtow9.text = "بيلية عجل امامي يمين و الخلفي يسار"
                                                    bindingR2.s3erR2sAcx.setText("25")
                                                } else {
                                                    if (bindingR2.outsideleft.isChecked && bindingR2.insideright.isChecked) {
                                                        chhy2ahtow9.text =
                                                            "بيلية عجل امامي يسار و الخلفي يمين"
                                                        bindingR2.s3erR2sAcx.setText("25")
                                                    } else {
                                                        if (bindingR2.outsideleft.isChecked && bindingR2.insideleft.isChecked) {
                                                            chhy2ahtow9.text =
                                                                "بيلية عجل امامي يسار و الخلفي يسار"
                                                            bindingR2.s3erR2sAcx.setText("25")
                                                        } else {
                                                            if (bindingR2.insideright.isChecked && bindingR2.insideleft.isChecked) {
                                                                chhy2ahtow9.text =
                                                                    "بيلية عجل خلفي يمين و يسار"
                                                                bindingR2.s3erR2sAcx.setText(
                                                                    "30"
                                                                )
                                                            } else {
                                                                if (bindingR2.outsideright.isChecked) {
                                                                    chhy2ahtow9.text =
                                                                        "بيلية عجل امامي يمين"
                                                                    bindingR2.s3erR2sAcx.setText(
                                                                        "10"
                                                                    )
                                                                }
                                                                if (bindingR2.outsideleft.isChecked) {
                                                                    chhy2ahtow9.text =
                                                                        "بيلية عجل امامي يسار"
                                                                    bindingR2.s3erR2sAcx.setText(
                                                                        "10"
                                                                    )
                                                                }
                                                                if (bindingR2.insideleft.isChecked) {
                                                                    chhy2ahtow9.text =
                                                                        "بيلية عجل خلفي يسار"
                                                                    bindingR2.s3erR2sAcx.setText(
                                                                        "15"
                                                                    )
                                                                }
                                                                if (bindingR2.insideright.isChecked) {
                                                                    chhy2ahtow9.text =
                                                                        "بيلية عجل خلفي يمين"
                                                                    bindingR2.s3erR2sAcx.setText(
                                                                        "15"
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

                bindingR2.insideleft.setOnCheckedChangeListener { _ ,  isChecked2 ->
                    if (bindingR2.outsideright.isChecked) {
                        chhy2ahtow9.text = "بيلية عجل امامي يمين"
                    } else {
                        chhy2ahtow9.text = "بيلية عجل"
                        bindingR2.s3erR2sAcx.setText("")
                    }
                    if (bindingR2.outsideright.isChecked && bindingR2.outsideleft.isChecked && bindingR2.insideright.isChecked && bindingR2.insideleft.isChecked) {
                        chhy2ahtow9.text = "تغير جميع بيل العجلات"
                        bindingR2.s3erR2sAcx.setText("50")
                    } else {
                        if (bindingR2.outsideright.isChecked && bindingR2.outsideleft.isChecked && bindingR2.insideright.isChecked) {
                            chhy2ahtow9.text = "بيلية عجل امامي كامل و الخلفي يمين"
                            bindingR2.s3erR2sAcx.setText("35")
                        } else {
                            if (bindingR2.outsideright.isChecked && bindingR2.outsideleft.isChecked && bindingR2.insideleft.isChecked) {
                                chhy2ahtow9.text = "بيلية عجل امامي كامل و الخلفي يسار"
                                bindingR2.s3erR2sAcx.setText("35")
                            } else {
                                if (bindingR2.outsideright.isChecked && bindingR2.insideright.isChecked && bindingR2.insideleft.isChecked) {
                                    chhy2ahtow9.text = "بيلية عجل امامي يمين و الخلفيين"
                                    bindingR2.s3erR2sAcx.setText("40")
                                } else {
                                    if (bindingR2.outsideleft.isChecked && bindingR2.insideright.isChecked && bindingR2.insideleft.isChecked) {
                                        chhy2ahtow9.text = "بيلية عجل امامي يسار و الخلفيين"
                                        bindingR2.s3erR2sAcx.setText("40")
                                    } else {
                                        if (bindingR2.outsideright.isChecked && bindingR2.outsideleft.isChecked) {
                                            chhy2ahtow9.text = "بيلية عجل امامي يمين و يسار"
                                            bindingR2.s3erR2sAcx.setText("20")
                                        } else {
                                            if (bindingR2.outsideright.isChecked && bindingR2.insideright.isChecked) {
                                                chhy2ahtow9.text = "بيلية عجل امامي يمين و الخلفي يمين"
                                                bindingR2.s3erR2sAcx.setText("25")
                                            } else {
                                                if (bindingR2.outsideright.isChecked && bindingR2.insideleft.isChecked) {
                                                    chhy2ahtow9.text = "بيلية عجل امامي يمين و الخلفي يسار"
                                                    bindingR2.s3erR2sAcx.setText("25")
                                                } else {
                                                    if (bindingR2.outsideleft.isChecked && bindingR2.insideright.isChecked) {
                                                        chhy2ahtow9.text =
                                                            "بيلية عجل امامي يسار و الخلفي يمين"
                                                        bindingR2.s3erR2sAcx.setText("25")
                                                    } else {
                                                        if (bindingR2.outsideleft.isChecked && bindingR2.insideleft.isChecked) {
                                                            chhy2ahtow9.text =
                                                                "بيلية عجل امامي يسار و الخلفي يسار"
                                                            bindingR2.s3erR2sAcx.setText("25")
                                                        } else {
                                                            if (bindingR2.insideright.isChecked && bindingR2.insideleft.isChecked) {
                                                                chhy2ahtow9.text =
                                                                    "بيلية عجل خلفي يمين و يسار"
                                                                bindingR2.s3erR2sAcx.setText(
                                                                    "30"
                                                                )
                                                            } else {
                                                                if (bindingR2.outsideright.isChecked) {
                                                                    chhy2ahtow9.text =
                                                                        "بيلية عجل امامي يمين"
                                                                    bindingR2.s3erR2sAcx.setText(
                                                                        "10"
                                                                    )
                                                                }
                                                                if (bindingR2.outsideleft.isChecked) {
                                                                    chhy2ahtow9.text =
                                                                        "بيلية عجل امامي يسار"
                                                                    bindingR2.s3erR2sAcx.setText(
                                                                        "10"
                                                                    )
                                                                }
                                                                if (bindingR2.insideleft.isChecked) {
                                                                    chhy2ahtow9.text =
                                                                        "بيلية عجل خلفي يسار"
                                                                    bindingR2.s3erR2sAcx.setText(
                                                                        "15"
                                                                    )
                                                                }
                                                                if (bindingR2.insideright.isChecked) {
                                                                    chhy2ahtow9.text =
                                                                        "بيلية عجل خلفي يمين"
                                                                    bindingR2.s3erR2sAcx.setText(
                                                                        "15"
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

                bindingR2.insideright.setOnCheckedChangeListener { _ ,  isChecked2 ->
                    if (bindingR2.insideright.isChecked) {
                        chhy2ahtow9.text = "بيلية عجل امامي يمين"
                    } else {
                        chhy2ahtow9.text = "بيلية عجل"
                        bindingR2.s3erR2sAcx.setText("")
                    }

                    if (bindingR2.outsideright.isChecked && bindingR2.outsideleft.isChecked && bindingR2.insideright.isChecked && bindingR2.insideleft.isChecked) {
                        chhy2ahtow9.text = "تغير جميع بيل العجلات"
                        bindingR2.s3erR2sAcx.setText("50")
                    } else {
                        if (bindingR2.outsideright.isChecked && bindingR2.outsideleft.isChecked && bindingR2.insideright.isChecked) {
                            chhy2ahtow9.text = "بيلية عجل امامي كامل و الخلفي يمين"
                            bindingR2.s3erR2sAcx.setText("35")
                        } else {
                            if (bindingR2.outsideright.isChecked && bindingR2.outsideleft.isChecked && bindingR2.insideleft.isChecked) {
                                chhy2ahtow9.text = "بيلية عجل امامي كامل و الخلفي يسار"
                                bindingR2.s3erR2sAcx.setText("35")
                            } else {
                                if (bindingR2.outsideright.isChecked && bindingR2.insideright.isChecked && bindingR2.insideleft.isChecked) {
                                    chhy2ahtow9.text = "بيلية عجل امامي يمين و الخلفيين"
                                    bindingR2.s3erR2sAcx.setText("40")
                                } else {
                                    if (bindingR2.outsideleft.isChecked && bindingR2.insideright.isChecked && bindingR2.insideleft.isChecked) {
                                        chhy2ahtow9.text = "بيلية عجل امامي يسار و الخلفيين"
                                        bindingR2.s3erR2sAcx.setText("40")
                                    } else {
                                        if (bindingR2.outsideright.isChecked && bindingR2.outsideleft.isChecked) {
                                            chhy2ahtow9.text = "بيلية عجل امامي يمين و يسار"
                                            bindingR2.s3erR2sAcx.setText("20")
                                        } else {
                                            if (bindingR2.outsideright.isChecked && bindingR2.insideright.isChecked) {
                                                chhy2ahtow9.text = "بيلية عجل امامي يمين و الخلفي يمين"
                                                bindingR2.s3erR2sAcx.setText("25")
                                            } else {
                                                if (bindingR2.outsideright.isChecked && bindingR2.insideleft.isChecked) {
                                                    chhy2ahtow9.text = "بيلية عجل امامي يمين و الخلفي يسار"
                                                    bindingR2.s3erR2sAcx.setText("25")
                                                } else {
                                                    if (bindingR2.outsideleft.isChecked && bindingR2.insideright.isChecked) {
                                                        chhy2ahtow9.text =
                                                            "بيلية عجل امامي يسار و الخلفي يمين"
                                                        bindingR2.s3erR2sAcx.setText("25")
                                                    } else {
                                                        if (bindingR2.outsideleft.isChecked && bindingR2.insideleft.isChecked) {
                                                            chhy2ahtow9.text =
                                                                "بيلية عجل امامي يسار و الخلفي يسار"
                                                            bindingR2.s3erR2sAcx.setText("25")
                                                        } else {
                                                            if (bindingR2.insideright.isChecked && bindingR2.insideleft.isChecked) {
                                                                chhy2ahtow9.text =
                                                                    "بيلية عجل خلفي يمين و يسار"
                                                                bindingR2.s3erR2sAcx.setText(
                                                                    "30"
                                                                )
                                                            } else {
                                                                if (bindingR2.outsideright.isChecked) {
                                                                    chhy2ahtow9.text =
                                                                        "بيلية عجل امامي يمين"
                                                                    bindingR2.s3erR2sAcx.setText(
                                                                        "10"
                                                                    )
                                                                }
                                                                if (bindingR2.outsideleft.isChecked) {
                                                                    chhy2ahtow9.text =
                                                                        "بيلية عجل امامي يسار"
                                                                    bindingR2.s3erR2sAcx.setText(
                                                                        "10"
                                                                    )
                                                                }
                                                                if (bindingR2.insideleft.isChecked) {
                                                                    chhy2ahtow9.text =
                                                                        "بيلية عجل خلفي يسار"
                                                                    bindingR2.s3erR2sAcx.setText(
                                                                        "15"
                                                                    )
                                                                }
                                                                if (bindingR2.insideright.isChecked) {
                                                                    chhy2ahtow9.text =
                                                                        "بيلية عجل خلفي يمين"
                                                                    bindingR2.s3erR2sAcx.setText(
                                                                        "15"
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
                            prichy2ahtow9.text = bindingR2.s3erR2sAcx.text.toString()
                            customDialogR2SX.dismiss()
                        }
                    }
                }
                bindingR2.btnR2sCan.setOnClickListener {
                    if (prichy2ahtow9.text.toString().isEmpty()) {
                        chhy2ahtow9.text = "بيلية عجل"
                        chhy2ahtow9.isChecked = false
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
                    chhy2ahtow9.text = "بيلية عجل"
                    prichy2ahtow9.text = ""
                }
        }
        }

        binding.apply{
            chhy2ahtow10.setOnCheckedChangeListener { _ ,  isChecked ->
            if (chhy2ahtow10.isChecked) {

                customDialogR2SX.window?.setFlags(WindowManager.LayoutParams.FLAG_SECURE, WindowManager.LayoutParams.FLAG_SECURE)

                customDialogR2SX.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
                bindingR2.titR2sOut.text="امامي"
                bindingR2.titR2sIn.text="خلفي"

                val window = customDialogR2SX.window
                window?.setGravity(Gravity.BOTTOM)
                val lp = window?.attributes
                lp?.dimAmount = 0.0f
                lp?.flags = lp?.flags?.or(WindowManager.LayoutParams.FLAG_DIM_BEHIND)
                window?.attributes = lp

                bindingR2.outsideright.setOnCheckedChangeListener { _ ,  isChecked1 ->

                    if (bindingR2.outsideright.isChecked) {
                        chhy2ahtow10.text = "قاعدة صنوبرص علوية امامي يمين"
                    } else {
                        chhy2ahtow10.text = "قاعدة صنوبرص علوية"
                        bindingR2.s3erR2sAcx.setText("")
                    }
                    if (bindingR2.outsideright.isChecked && bindingR2.outsideleft.isChecked && bindingR2.insideright.isChecked && bindingR2.insideleft.isChecked) {
                        chhy2ahtow10.text = "تغير جميع القواعد  العلوية للصنوبرصات"
                        bindingR2.s3erR2sAcx.setText("20")
                    } else {
                        if (bindingR2.outsideright.isChecked && bindingR2.outsideleft.isChecked && bindingR2.insideright.isChecked) {
                            chhy2ahtow10.text = "قاعدة صنوبرص علوية امامي كامل و الخلفي يمين"
                            bindingR2.s3erR2sAcx.setText("15")
                        } else {
                            if (bindingR2.outsideright.isChecked && bindingR2.outsideleft.isChecked && bindingR2.insideleft.isChecked) {
                                chhy2ahtow10.text = "قاعدة صنوبرص علوية امامي كامل و الخلفي يسار"
                                bindingR2.s3erR2sAcx.setText("15")
                            } else {
                                if (bindingR2.outsideright.isChecked && bindingR2.insideright.isChecked && bindingR2.insideleft.isChecked) {
                                    chhy2ahtow10.text = "قاعدة صنوبرص علوية امامي يمين و الخلفيين"
                                    bindingR2.s3erR2sAcx.setText("15")
                                } else {
                                    if (bindingR2.outsideleft.isChecked && bindingR2.insideright.isChecked && bindingR2.insideleft.isChecked) {
                                        chhy2ahtow10.text = "قاعدة صنوبرص علوية امامي يسار و الخلفيين"
                                        bindingR2.s3erR2sAcx.setText("15")
                                    } else {
                                        if (bindingR2.outsideright.isChecked && bindingR2.outsideleft.isChecked) {
                                            chhy2ahtow10.text = "قاعدة صنوبرص علوية امامي يمين و يسار"
                                            bindingR2.s3erR2sAcx.setText("10")
                                        } else {
                                            if (bindingR2.outsideright.isChecked && bindingR2.insideright.isChecked) {
                                                chhy2ahtow10.text = "قاعدة صنوبرص علوية امامي يمين و الخلفي يمين"
                                                bindingR2.s3erR2sAcx.setText("10")
                                            } else {
                                                if (bindingR2.outsideright.isChecked && bindingR2.insideleft.isChecked) {
                                                    chhy2ahtow10.text = "قاعدة صنوبرص علوية امامي يمين و الخلفي يسار"
                                                    bindingR2.s3erR2sAcx.setText("10")
                                                } else {
                                                    if (bindingR2.outsideleft.isChecked && bindingR2.insideright.isChecked) {
                                                        chhy2ahtow10.text =
                                                            "قاعدة صنوبرص علوية امامي يسار و الخلفي يمين"
                                                        bindingR2.s3erR2sAcx.setText("10")
                                                    } else {
                                                        if (bindingR2.outsideleft.isChecked && bindingR2.insideleft.isChecked) {
                                                            chhy2ahtow10.text =
                                                                "قاعدة صنوبرص علوية امامي يسار و الخلفي يسار"
                                                            bindingR2.s3erR2sAcx.setText("10")
                                                        } else {
                                                            if (bindingR2.insideright.isChecked && bindingR2.insideleft.isChecked) {
                                                                chhy2ahtow10.text =
                                                                    "قاعدة صنوبرص علوية خلفي يمين و يسار"
                                                                bindingR2.s3erR2sAcx.setText(
                                                                    "10"
                                                                )
                                                            } else {
                                                                if (bindingR2.outsideright.isChecked) {
                                                                    chhy2ahtow10.text =
                                                                        "قاعدة صنوبرص علوية امامي يمين"
                                                                    bindingR2.s3erR2sAcx.setText(
                                                                        "5"
                                                                    )
                                                                }
                                                                if (bindingR2.outsideleft.isChecked) {
                                                                    chhy2ahtow10.text =
                                                                        "قاعدة صنوبرص علوية امامي يسار"
                                                                    bindingR2.s3erR2sAcx.setText(
                                                                        "5"
                                                                    )
                                                                }
                                                                if (bindingR2.insideleft.isChecked) {
                                                                    chhy2ahtow10.text =
                                                                        "قاعدة صنوبرص علوية خلفي يسار"
                                                                    bindingR2.s3erR2sAcx.setText(
                                                                        "5"
                                                                    )
                                                                }
                                                                if (bindingR2.insideright.isChecked) {
                                                                    chhy2ahtow10.text =
                                                                        "قاعدة صنوبرص علوية خلفي يمين"
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

                bindingR2.outsideleft.setOnCheckedChangeListener { _ ,  isChecked2 ->
                    if (bindingR2.outsideleft.isChecked) {
                        chhy2ahtow10.text = "قاعدة صنوبرص علوية امامي يسار"
                    } else {
                        chhy2ahtow10.text = "قاعدة صنوبرص علوية"
                        bindingR2.s3erR2sAcx.setText("")
                    }
                    if (bindingR2.outsideright.isChecked && bindingR2.outsideleft.isChecked && bindingR2.insideright.isChecked && bindingR2.insideleft.isChecked) {
                        chhy2ahtow10.text = "تغير جميع القواعد  العلوية للصنوبرصات"
                        bindingR2.s3erR2sAcx.setText("20")
                    } else {
                        if (bindingR2.outsideright.isChecked && bindingR2.outsideleft.isChecked && bindingR2.insideright.isChecked) {
                            chhy2ahtow10.text = "قاعدة صنوبرص علوية امامي كامل و الخلفي يمين"
                            bindingR2.s3erR2sAcx.setText("15")
                        } else {
                            if (bindingR2.outsideright.isChecked && bindingR2.outsideleft.isChecked && bindingR2.insideleft.isChecked) {
                                chhy2ahtow10.text = "قاعدة صنوبرص علوية امامي كامل و الخلفي يسار"
                                bindingR2.s3erR2sAcx.setText("15")
                            } else {
                                if (bindingR2.outsideright.isChecked && bindingR2.insideright.isChecked && bindingR2.insideleft.isChecked) {
                                    chhy2ahtow10.text = "قاعدة صنوبرص علوية امامي يمين و الخلفيين"
                                    bindingR2.s3erR2sAcx.setText("15")
                                } else {
                                    if (bindingR2.outsideleft.isChecked && bindingR2.insideright.isChecked && bindingR2.insideleft.isChecked) {
                                        chhy2ahtow10.text = "قاعدة صنوبرص علوية امامي يسار و الخلفيين"
                                        bindingR2.s3erR2sAcx.setText("15")
                                    } else {
                                        if (bindingR2.outsideright.isChecked && bindingR2.outsideleft.isChecked) {
                                            chhy2ahtow10.text = "قاعدة صنوبرص علوية امامي يمين و يسار"
                                            bindingR2.s3erR2sAcx.setText("10")
                                        } else {
                                            if (bindingR2.outsideright.isChecked && bindingR2.insideright.isChecked) {
                                                chhy2ahtow10.text = "قاعدة صنوبرص علوية امامي يمين و الخلفي يمين"
                                                bindingR2.s3erR2sAcx.setText("10")
                                            } else {
                                                if (bindingR2.outsideright.isChecked && bindingR2.insideleft.isChecked) {
                                                    chhy2ahtow10.text = "قاعدة صنوبرص علوية امامي يمين و الخلفي يسار"
                                                    bindingR2.s3erR2sAcx.setText("10")
                                                } else {
                                                    if (bindingR2.outsideleft.isChecked && bindingR2.insideright.isChecked) {
                                                        chhy2ahtow10.text =
                                                            "قاعدة صنوبرص علوية امامي يسار و الخلفي يمين"
                                                        bindingR2.s3erR2sAcx.setText("10")
                                                    } else {
                                                        if (bindingR2.outsideleft.isChecked && bindingR2.insideleft.isChecked) {
                                                            chhy2ahtow10.text =
                                                                "قاعدة صنوبرص علوية امامي يسار و الخلفي يسار"
                                                            bindingR2.s3erR2sAcx.setText("10")
                                                        } else {
                                                            if (bindingR2.insideright.isChecked && bindingR2.insideleft.isChecked) {
                                                                chhy2ahtow10.text =
                                                                    "قاعدة صنوبرص علوية خلفي يمين و يسار"
                                                                bindingR2.s3erR2sAcx.setText(
                                                                    "10"
                                                                )
                                                            } else {
                                                                if (bindingR2.outsideright.isChecked) {
                                                                    chhy2ahtow10.text =
                                                                        "قاعدة صنوبرص علوية امامي يمين"
                                                                    bindingR2.s3erR2sAcx.setText(
                                                                        "5"
                                                                    )
                                                                }
                                                                if (bindingR2.outsideleft.isChecked) {
                                                                    chhy2ahtow10.text =
                                                                        "قاعدة صنوبرص علوية امامي يسار"
                                                                    bindingR2.s3erR2sAcx.setText(
                                                                        "5"
                                                                    )
                                                                }
                                                                if (bindingR2.insideleft.isChecked) {
                                                                    chhy2ahtow10.text =
                                                                        "قاعدة صنوبرص علوية خلفي يسار"
                                                                    bindingR2.s3erR2sAcx.setText(
                                                                        "5"
                                                                    )
                                                                }
                                                                if (bindingR2.insideright.isChecked) {
                                                                    chhy2ahtow10.text =
                                                                        "قاعدة صنوبرص علوية خلفي يمين"
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

                bindingR2.insideleft.setOnCheckedChangeListener { _ ,  isChecked2 ->
                    if (bindingR2.outsideright.isChecked) {
                        chhy2ahtow10.text = "قاعدة صنوبرص علوية خلفي يمين"
                    } else {
                        chhy2ahtow10.text = "قاعدة صنوبرص علوية"
                        bindingR2.s3erR2sAcx.setText("")
                    }
                    if (bindingR2.outsideright.isChecked && bindingR2.outsideleft.isChecked && bindingR2.insideright.isChecked && bindingR2.insideleft.isChecked) {
                        chhy2ahtow10.text = "تغير جميع القواعد  العلوية للصنوبرصات"
                        bindingR2.s3erR2sAcx.setText("20")
                    } else {
                        if (bindingR2.outsideright.isChecked && bindingR2.outsideleft.isChecked && bindingR2.insideright.isChecked) {
                            chhy2ahtow10.text = "قاعدة صنوبرص علوية امامي كامل و الخلفي يمين"
                            bindingR2.s3erR2sAcx.setText("15")
                        } else {
                            if (bindingR2.outsideright.isChecked && bindingR2.outsideleft.isChecked && bindingR2.insideleft.isChecked) {
                                chhy2ahtow10.text = "قاعدة صنوبرص علوية امامي كامل و الخلفي يسار"
                                bindingR2.s3erR2sAcx.setText("15")
                            } else {
                                if (bindingR2.outsideright.isChecked && bindingR2.insideright.isChecked && bindingR2.insideleft.isChecked) {
                                    chhy2ahtow10.text = "قاعدة صنوبرص علوية امامي يمين و الخلفيين"
                                    bindingR2.s3erR2sAcx.setText("15")
                                } else {
                                    if (bindingR2.outsideleft.isChecked && bindingR2.insideright.isChecked && bindingR2.insideleft.isChecked) {
                                        chhy2ahtow10.text = "قاعدة صنوبرص علوية امامي يسار و الخلفيين"
                                        bindingR2.s3erR2sAcx.setText("15")
                                    } else {
                                        if (bindingR2.outsideright.isChecked && bindingR2.outsideleft.isChecked) {
                                            chhy2ahtow10.text = "قاعدة صنوبرص علوية امامي يمين و يسار"
                                            bindingR2.s3erR2sAcx.setText("10")
                                        } else {
                                            if (bindingR2.outsideright.isChecked && bindingR2.insideright.isChecked) {
                                                chhy2ahtow10.text = "قاعدة صنوبرص علوية امامي يمين و الخلفي يمين"
                                                bindingR2.s3erR2sAcx.setText("10")
                                            } else {
                                                if (bindingR2.outsideright.isChecked && bindingR2.insideleft.isChecked) {
                                                    chhy2ahtow10.text = "قاعدة صنوبرص علوية امامي يمين و الخلفي يسار"
                                                    bindingR2.s3erR2sAcx.setText("10")
                                                } else {
                                                    if (bindingR2.outsideleft.isChecked && bindingR2.insideright.isChecked) {
                                                        chhy2ahtow10.text =
                                                            "قاعدة صنوبرص علوية امامي يسار و الخلفي يمين"
                                                        bindingR2.s3erR2sAcx.setText("10")
                                                    } else {
                                                        if (bindingR2.outsideleft.isChecked && bindingR2.insideleft.isChecked) {
                                                            chhy2ahtow10.text =
                                                                "قاعدة صنوبرص علوية امامي يسار و الخلفي يسار"
                                                            bindingR2.s3erR2sAcx.setText("10")
                                                        } else {
                                                            if (bindingR2.insideright.isChecked && bindingR2.insideleft.isChecked) {
                                                                chhy2ahtow10.text =
                                                                    "قاعدة صنوبرص علوية خلفي يمين و يسار"
                                                                bindingR2.s3erR2sAcx.setText(
                                                                    "10"
                                                                )
                                                            } else {
                                                                if (bindingR2.outsideright.isChecked) {
                                                                    chhy2ahtow10.text =
                                                                        "قاعدة صنوبرص علوية امامي يمين"
                                                                    bindingR2.s3erR2sAcx.setText(
                                                                        "5"
                                                                    )
                                                                }
                                                                if (bindingR2.outsideleft.isChecked) {
                                                                    chhy2ahtow10.text =
                                                                        "قاعدة صنوبرص علوية امامي يسار"
                                                                    bindingR2.s3erR2sAcx.setText(
                                                                        "5"
                                                                    )
                                                                }
                                                                if (bindingR2.insideleft.isChecked) {
                                                                    chhy2ahtow10.text =
                                                                        "قاعدة صنوبرص علوية خلفي يسار"
                                                                    bindingR2.s3erR2sAcx.setText(
                                                                        "5"
                                                                    )
                                                                }
                                                                if (bindingR2.insideright.isChecked) {
                                                                    chhy2ahtow10.text =
                                                                        "قاعدة صنوبرص علوية خلفي يمين"
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

                bindingR2.insideright.setOnCheckedChangeListener { _ ,  isChecked2 ->
                    if (bindingR2.insideright.isChecked) {
                        chhy2ahtow10.text = "قاعدة صنوبرص علوية خلفي يسار"
                    } else {
                        chhy2ahtow10.text = "قاعدة صنوبرص علوية"
                        bindingR2.s3erR2sAcx.setText("")
                    }
                    if (bindingR2.outsideright.isChecked && bindingR2.outsideleft.isChecked && bindingR2.insideright.isChecked && bindingR2.insideleft.isChecked) {
                        chhy2ahtow10.text = "تغير جميع القواعد  العلوية للصنوبرصات"
                        bindingR2.s3erR2sAcx.setText("20")
                    } else {
                        if (bindingR2.outsideright.isChecked && bindingR2.outsideleft.isChecked && bindingR2.insideright.isChecked) {
                            chhy2ahtow10.text = "قاعدة صنوبرص علوية امامي كامل و الخلفي يمين"
                            bindingR2.s3erR2sAcx.setText("15")
                        } else {
                            if (bindingR2.outsideright.isChecked && bindingR2.outsideleft.isChecked && bindingR2.insideleft.isChecked) {
                                chhy2ahtow10.text = "قاعدة صنوبرص علوية امامي كامل و الخلفي يسار"
                                bindingR2.s3erR2sAcx.setText("15")
                            } else {
                                if (bindingR2.outsideright.isChecked && bindingR2.insideright.isChecked && bindingR2.insideleft.isChecked) {
                                    chhy2ahtow10.text = "قاعدة صنوبرص علوية امامي يمين و الخلفيين"
                                    bindingR2.s3erR2sAcx.setText("15")
                                } else {
                                    if (bindingR2.outsideleft.isChecked && bindingR2.insideright.isChecked && bindingR2.insideleft.isChecked) {
                                        chhy2ahtow10.text = "قاعدة صنوبرص علوية امامي يسار و الخلفيين"
                                        bindingR2.s3erR2sAcx.setText("15")
                                    } else {
                                        if (bindingR2.outsideright.isChecked && bindingR2.outsideleft.isChecked) {
                                            chhy2ahtow10.text = "قاعدة صنوبرص علوية امامي يمين و يسار"
                                            bindingR2.s3erR2sAcx.setText("10")
                                        } else {
                                            if (bindingR2.outsideright.isChecked && bindingR2.insideright.isChecked) {
                                                chhy2ahtow10.text = "قاعدة صنوبرص علوية امامي يمين و الخلفي يمين"
                                                bindingR2.s3erR2sAcx.setText("10")
                                            } else {
                                                if (bindingR2.outsideright.isChecked && bindingR2.insideleft.isChecked) {
                                                    chhy2ahtow10.text = "قاعدة صنوبرص علوية امامي يمين و الخلفي يسار"
                                                    bindingR2.s3erR2sAcx.setText("10")
                                                } else {
                                                    if (bindingR2.outsideleft.isChecked && bindingR2.insideright.isChecked) {
                                                        chhy2ahtow10.text =
                                                            "قاعدة صنوبرص علوية امامي يسار و الخلفي يمين"
                                                        bindingR2.s3erR2sAcx.setText("10")
                                                    } else {
                                                        if (bindingR2.outsideleft.isChecked && bindingR2.insideleft.isChecked) {
                                                            chhy2ahtow10.text =
                                                                "قاعدة صنوبرص علوية امامي يسار و الخلفي يسار"
                                                            bindingR2.s3erR2sAcx.setText("10")
                                                        } else {
                                                            if (bindingR2.insideright.isChecked && bindingR2.insideleft.isChecked) {
                                                                chhy2ahtow10.text =
                                                                    "قاعدة صنوبرص علوية خلفي يمين و يسار"
                                                                bindingR2.s3erR2sAcx.setText(
                                                                    "10"
                                                                )
                                                            } else {

                                                                if (bindingR2.outsideright.isChecked) {
                                                                    chhy2ahtow10.text =
                                                                        "قاعدة صنوبرص علوية امامي يمين"
                                                                    bindingR2.s3erR2sAcx.setText(
                                                                        "5"
                                                                    )
                                                                }
                                                                if (bindingR2.outsideleft.isChecked) {
                                                                    chhy2ahtow10.text =
                                                                        "قاعدة صنوبرص علوية امامي يسار"
                                                                    bindingR2.s3erR2sAcx.setText(
                                                                        "5"
                                                                    )
                                                                }

                                                                if (bindingR2.insideleft.isChecked) {
                                                                    chhy2ahtow10.text =
                                                                        "قاعدة صنوبرص علوية خلفي يسار"
                                                                    bindingR2.s3erR2sAcx.setText(
                                                                        "5"
                                                                    )
                                                                }
                                                                if (bindingR2.insideright.isChecked) {
                                                                    chhy2ahtow10.text =
                                                                        "قاعدة صنوبرص علوية خلفي يمين"
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
                            prichy2ahtow10.text = bindingR2.s3erR2sAcx.text.toString()
                            customDialogR2SX.dismiss()
                        }
                    }
                }
                bindingR2.btnR2sCan.setOnClickListener {
                    if (prichy2ahtow10.text.toString().isEmpty()) {
                        chhy2ahtow10.text = "قاعدة صنوبرص علوية"
                        chhy2ahtow10.isChecked = false
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
                    chhy2ahtow10.text = "قاعدة صنوبرص علوية"
                    prichy2ahtow10.text = ""
                }
        }
        }

        binding.apply{
            chhy2ahtow11.setOnCheckedChangeListener { _ ,  isChecked ->
            if (chhy2ahtow11.isChecked) {

                customDialogR2SX.window?.setFlags(WindowManager.LayoutParams.FLAG_SECURE, WindowManager.LayoutParams.FLAG_SECURE)

                customDialogR2SX.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
                bindingR2.titR2sOut.text="امامي"
                bindingR2.titR2sIn.text="خلفي"

                val window = customDialogR2SX.window
                window?.setGravity(Gravity.BOTTOM)
                val lp = window?.attributes
                lp?.dimAmount = 0.0f
                lp?.flags = lp?.flags?.or(WindowManager.LayoutParams.FLAG_DIM_BEHIND)
                window?.attributes = lp

                bindingR2.outsideright.setOnCheckedChangeListener { _ ,  isChecked1 ->

                    if (bindingR2.outsideright.isChecked) {
                        chhy2ahtow11.text = "تحشير لقم بريك امامي يمين"
                    } else {
                        chhy2ahtow11.text = "تحشير لقم بريك"
                        bindingR2.s3erR2sAcx.setText("")
                    }
                    if (bindingR2.outsideright.isChecked && bindingR2.outsideleft.isChecked && bindingR2.insideright.isChecked && bindingR2.insideleft.isChecked) {
                        chhy2ahtow11.text = "تحشير جميع لقم البريك"
                        bindingR2.s3erR2sAcx.setText("20")
                    } else {
                        if (bindingR2.outsideright.isChecked && bindingR2.outsideleft.isChecked && bindingR2.insideright.isChecked) {
                            chhy2ahtow11.text = "تحشير لقم بريك امامي كامل و الخلفي يمين"
                            bindingR2.s3erR2sAcx.setText("15")
                        } else {
                            if (bindingR2.outsideright.isChecked && bindingR2.outsideleft.isChecked && bindingR2.insideleft.isChecked) {
                                chhy2ahtow11.text = "تحشير لقم بريك امامي كامل و الخلفي يسار"
                                bindingR2.s3erR2sAcx.setText("15")
                            } else {
                                if (bindingR2.outsideright.isChecked && bindingR2.insideright.isChecked && bindingR2.insideleft.isChecked) {
                                    chhy2ahtow11.text = "تحشير لقم بريك امامي يمين و الخلفيين"
                                    bindingR2.s3erR2sAcx.setText("15")
                                } else {
                                    if (bindingR2.outsideleft.isChecked && bindingR2.insideright.isChecked && bindingR2.insideleft.isChecked) {
                                        chhy2ahtow11.text = "تحشير لقم بريك امامي يسار و الخلفيين"
                                        bindingR2.s3erR2sAcx.setText("15")
                                    } else {
                                        if (bindingR2.outsideright.isChecked && bindingR2.outsideleft.isChecked) {
                                            chhy2ahtow11.text = "تحشير لقم بريك امامي يمين و يسار"
                                            bindingR2.s3erR2sAcx.setText("10")
                                        } else {
                                            if (bindingR2.outsideright.isChecked && bindingR2.insideright.isChecked) {
                                                chhy2ahtow11.text = "تحشير لقم بريك امامي يمين و الخلفي يمين"
                                                bindingR2.s3erR2sAcx.setText("10")
                                            } else {
                                                if (bindingR2.outsideright.isChecked && bindingR2.insideleft.isChecked) {
                                                    chhy2ahtow11.text = "تحشير لقم بريك امامي يمين و الخلفي يسار"
                                                    bindingR2.s3erR2sAcx.setText("10")
                                                } else {
                                                    if (bindingR2.outsideleft.isChecked && bindingR2.insideright.isChecked) {
                                                        chhy2ahtow11.text =
                                                            "تحشير لقم بريك امامي يسار و الخلفي يمين"
                                                        bindingR2.s3erR2sAcx.setText("10")
                                                    } else {
                                                        if (bindingR2.outsideleft.isChecked && bindingR2.insideleft.isChecked) {
                                                            chhy2ahtow11.text =
                                                                "تحشير لقم بريك امامي يسار و الخلفي يسار"
                                                            bindingR2.s3erR2sAcx.setText("10")
                                                        } else {
                                                            if (bindingR2.insideright.isChecked && bindingR2.insideleft.isChecked) {
                                                                chhy2ahtow11.text =
                                                                    "تحشير لقم بريك خلفي يمين و يسار"
                                                                bindingR2.s3erR2sAcx.setText(
                                                                    "10"
                                                                )
                                                            } else {
                                                                if (bindingR2.outsideright.isChecked) {
                                                                    chhy2ahtow11.text =
                                                                        "تحشير لقم بريك امامي يمين"
                                                                    bindingR2.s3erR2sAcx.setText(
                                                                        "5"
                                                                    )
                                                                }
                                                                if (bindingR2.outsideleft.isChecked) {
                                                                    chhy2ahtow11.text =
                                                                        "تحشير لقم بريك امامي يسار"
                                                                    bindingR2.s3erR2sAcx.setText(
                                                                        "5"
                                                                    )
                                                                }
                                                                if (bindingR2.insideleft.isChecked) {
                                                                    chhy2ahtow11.text =
                                                                        "تحشير لقم بريك خلفي يسار"
                                                                    bindingR2.s3erR2sAcx.setText(
                                                                        "5"
                                                                    )
                                                                }
                                                                if (bindingR2.insideright.isChecked) {
                                                                    chhy2ahtow11.text =
                                                                        "تحشير لقم بريك خلفي يمين"
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

                bindingR2.outsideleft.setOnCheckedChangeListener { _ ,  isChecked2 ->
                    if (bindingR2.outsideleft.isChecked) {
                        chhy2ahtow11.text = "تحشير لقم بريك امامي يسار"
                    } else {
                        chhy2ahtow11.text = "تحشير لقم بريك"
                        bindingR2.s3erR2sAcx.setText("")
                    }
                    if (bindingR2.outsideright.isChecked && bindingR2.outsideleft.isChecked && bindingR2.insideright.isChecked && bindingR2.insideleft.isChecked) {
                        chhy2ahtow11.text = "تحشير جميع لقم البريك"
                        bindingR2.s3erR2sAcx.setText("20")
                    } else {
                        if (bindingR2.outsideright.isChecked && bindingR2.outsideleft.isChecked && bindingR2.insideright.isChecked) {
                            chhy2ahtow11.text = "تحشير لقم بريك امامي كامل و الخلفي يمين"
                            bindingR2.s3erR2sAcx.setText("15")
                        } else {
                            if (bindingR2.outsideright.isChecked && bindingR2.outsideleft.isChecked && bindingR2.insideleft.isChecked) {
                                chhy2ahtow11.text = "تحشير لقم بريك امامي كامل و الخلفي يسار"
                                bindingR2.s3erR2sAcx.setText("15")
                            } else {
                                if (bindingR2.outsideright.isChecked && bindingR2.insideright.isChecked && bindingR2.insideleft.isChecked) {
                                    chhy2ahtow11.text = "تحشير لقم بريك امامي يمين و الخلفيين"
                                    bindingR2.s3erR2sAcx.setText("15")
                                } else {
                                    if (bindingR2.outsideleft.isChecked && bindingR2.insideright.isChecked && bindingR2.insideleft.isChecked) {
                                        chhy2ahtow11.text = "تحشير لقم بريك امامي يسار و الخلفيين"
                                        bindingR2.s3erR2sAcx.setText("15")
                                    } else {
                                        if (bindingR2.outsideright.isChecked && bindingR2.outsideleft.isChecked) {
                                            chhy2ahtow11.text = "تحشير لقم بريك امامي يمين و يسار"
                                            bindingR2.s3erR2sAcx.setText("10")
                                        } else {
                                            if (bindingR2.outsideright.isChecked && bindingR2.insideright.isChecked) {
                                                chhy2ahtow11.text = "تحشير لقم بريك امامي يمين و الخلفي يمين"
                                                bindingR2.s3erR2sAcx.setText("10")
                                            } else {
                                                if (bindingR2.outsideright.isChecked && bindingR2.insideleft.isChecked) {
                                                    chhy2ahtow11.text = "تحشير لقم بريك امامي يمين و الخلفي يسار"
                                                    bindingR2.s3erR2sAcx.setText("10")
                                                } else {
                                                    if (bindingR2.outsideleft.isChecked && bindingR2.insideright.isChecked) {
                                                        chhy2ahtow11.text =
                                                            "تحشير لقم بريك امامي يسار و الخلفي يمين"
                                                        bindingR2.s3erR2sAcx.setText("10")
                                                    } else {
                                                        if (bindingR2.outsideleft.isChecked && bindingR2.insideleft.isChecked) {
                                                            chhy2ahtow11.text =
                                                                "تحشير لقم بريك امامي يسار و الخلفي يسار"
                                                            bindingR2.s3erR2sAcx.setText("10")
                                                        } else {
                                                            if (bindingR2.insideright.isChecked && bindingR2.insideleft.isChecked) {
                                                                chhy2ahtow11.text =
                                                                    "تحشير لقم بريك خلفي يمين و يسار"
                                                                bindingR2.s3erR2sAcx.setText(
                                                                    "10"
                                                                )
                                                            } else {

                                                                if (bindingR2.outsideright.isChecked) {
                                                                    chhy2ahtow11.text =
                                                                        "تحشير لقم بريك امامي يمين"
                                                                    bindingR2.s3erR2sAcx.setText(
                                                                        "5"
                                                                    )
                                                                }
                                                                if (bindingR2.outsideleft.isChecked) {
                                                                    chhy2ahtow11.text =
                                                                        "تحشير لقم بريك امامي يسار"
                                                                    bindingR2.s3erR2sAcx.setText(
                                                                        "5"
                                                                    )
                                                                }
                                                                if (bindingR2.insideleft.isChecked) {
                                                                    chhy2ahtow11.text =
                                                                        "تحشير لقم بريك خلفي يسار"
                                                                    bindingR2.s3erR2sAcx.setText(
                                                                        "5"
                                                                    )
                                                                }
                                                                if (bindingR2.insideright.isChecked) {
                                                                    chhy2ahtow11.text =
                                                                        "تحشير لقم بريك خلفي يمين"
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

                bindingR2.insideleft.setOnCheckedChangeListener { _ ,  isChecked2 ->
                    if (bindingR2.outsideright.isChecked) {
                        chhy2ahtow11.text = "تحشير لقم بريك خلفي يسار"
                    } else {
                        chhy2ahtow11.text = "تحشير لقم بريك"
                        bindingR2.s3erR2sAcx.setText("")
                    }
                    if (bindingR2.outsideright.isChecked && bindingR2.outsideleft.isChecked && bindingR2.insideright.isChecked && bindingR2.insideleft.isChecked) {
                        chhy2ahtow11.text = "تحشير جميع لقم البريك"
                        bindingR2.s3erR2sAcx.setText("20")
                    } else {
                        if (bindingR2.outsideright.isChecked && bindingR2.outsideleft.isChecked && bindingR2.insideright.isChecked) {
                            chhy2ahtow11.text = "تحشير لقم بريك امامي كامل و الخلفي يمين"
                            bindingR2.s3erR2sAcx.setText("15")
                        } else {
                            if (bindingR2.outsideright.isChecked && bindingR2.outsideleft.isChecked && bindingR2.insideleft.isChecked) {
                                chhy2ahtow11.text = "تحشير لقم بريك امامي كامل و الخلفي يسار"
                                bindingR2.s3erR2sAcx.setText("15")
                            } else {
                                if (bindingR2.outsideright.isChecked && bindingR2.insideright.isChecked && bindingR2.insideleft.isChecked) {
                                    chhy2ahtow11.text = "تحشير لقم بريك امامي يمين و الخلفيين"
                                    bindingR2.s3erR2sAcx.setText("15")
                                } else {
                                    if (bindingR2.outsideleft.isChecked && bindingR2.insideright.isChecked && bindingR2.insideleft.isChecked) {
                                        chhy2ahtow11.text = "تحشير لقم بريك امامي يسار و الخلفيين"
                                        bindingR2.s3erR2sAcx.setText("15")
                                    } else {
                                        if (bindingR2.outsideright.isChecked && bindingR2.outsideleft.isChecked) {
                                            chhy2ahtow11.text = "تحشير لقم بريك امامي يمين و يسار"
                                            bindingR2.s3erR2sAcx.setText("10")
                                        } else {
                                            if (bindingR2.outsideright.isChecked && bindingR2.insideright.isChecked) {
                                                chhy2ahtow11.text = "تحشير لقم بريك امامي يمين و الخلفي يمين"
                                                bindingR2.s3erR2sAcx.setText("10")
                                            } else {
                                                if (bindingR2.outsideright.isChecked && bindingR2.insideleft.isChecked) {
                                                    chhy2ahtow11.text = "تحشير لقم بريك امامي يمين و الخلفي يسار"
                                                    bindingR2.s3erR2sAcx.setText("10")
                                                } else {
                                                    if (bindingR2.outsideleft.isChecked && bindingR2.insideright.isChecked) {
                                                        chhy2ahtow11.text =
                                                            "تحشير لقم بريك امامي يسار و الخلفي يمين"
                                                        bindingR2.s3erR2sAcx.setText("10")
                                                    } else {
                                                        if (bindingR2.outsideleft.isChecked && bindingR2.insideleft.isChecked) {
                                                            chhy2ahtow11.text =
                                                                "تحشير لقم بريك امامي يسار و الخلفي يسار"
                                                            bindingR2.s3erR2sAcx.setText("10")
                                                        } else {
                                                            if (bindingR2.insideright.isChecked && bindingR2.insideleft.isChecked) {
                                                                chhy2ahtow11.text =
                                                                    "تحشير لقم بريك خلفي يمين و يسار"
                                                                bindingR2.s3erR2sAcx.setText(
                                                                    "10"
                                                                )
                                                            } else {
                                                                if (bindingR2.outsideright.isChecked) {
                                                                    chhy2ahtow11.text =
                                                                        "تحشير لقم بريك امامي يمين"
                                                                    bindingR2.s3erR2sAcx.setText(
                                                                        "5"
                                                                    )
                                                                }
                                                                if (bindingR2.outsideleft.isChecked) {
                                                                    chhy2ahtow11.text =
                                                                        "تحشير لقم بريك امامي يسار"
                                                                    bindingR2.s3erR2sAcx.setText(
                                                                        "5"
                                                                    )
                                                                }
                                                                if (bindingR2.insideleft.isChecked) {
                                                                    chhy2ahtow11.text =
                                                                        "تحشير لقم بريك خلفي يسار"
                                                                    bindingR2.s3erR2sAcx.setText(
                                                                        "5"
                                                                    )
                                                                }
                                                                if (bindingR2.insideright.isChecked) {
                                                                    chhy2ahtow11.text =
                                                                        "تحشير لقم بريك خلفي يمين"
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

                bindingR2.insideright.setOnCheckedChangeListener { _ ,  isChecked2 ->
                    if (bindingR2.insideright.isChecked) {
                        chhy2ahtow11.text = "تحشير لقم بريك خلفي يمين"
                    } else {
                        chhy2ahtow11.text = "تحشير لقم بريك"
                        bindingR2.s3erR2sAcx.setText("")
                    }
                    if (bindingR2.outsideright.isChecked && bindingR2.outsideleft.isChecked && bindingR2.insideright.isChecked && bindingR2.insideleft.isChecked) {
                        chhy2ahtow11.text = "تحشير جميع لقم البريك"
                        bindingR2.s3erR2sAcx.setText("20")
                    } else {
                        if (bindingR2.outsideright.isChecked && bindingR2.outsideleft.isChecked && bindingR2.insideright.isChecked) {
                            chhy2ahtow11.text = "تحشير لقم بريك امامي كامل و الخلفي يمين"
                            bindingR2.s3erR2sAcx.setText("15")
                        } else {
                            if (bindingR2.outsideright.isChecked && bindingR2.outsideleft.isChecked && bindingR2.insideleft.isChecked) {
                                chhy2ahtow11.text = "تحشير لقم بريك امامي كامل و الخلفي يسار"
                                bindingR2.s3erR2sAcx.setText("15")
                            } else {
                                if (bindingR2.outsideright.isChecked && bindingR2.insideright.isChecked && bindingR2.insideleft.isChecked) {
                                    chhy2ahtow11.text = "تحشير لقم بريك امامي يمين و الخلفيين"
                                    bindingR2.s3erR2sAcx.setText("15")
                                } else {
                                    if (bindingR2.outsideleft.isChecked && bindingR2.insideright.isChecked && bindingR2.insideleft.isChecked) {
                                        chhy2ahtow11.text = "تحشير لقم بريك امامي يسار و الخلفيين"
                                        bindingR2.s3erR2sAcx.setText("15")
                                    } else {
                                        if (bindingR2.outsideright.isChecked && bindingR2.outsideleft.isChecked) {
                                            chhy2ahtow11.text = "تحشير لقم بريك امامي يمين و يسار"
                                            bindingR2.s3erR2sAcx.setText("10")
                                        } else {
                                            if (bindingR2.outsideright.isChecked && bindingR2.insideright.isChecked) {
                                                chhy2ahtow11.text = "تحشير لقم بريك امامي يمين و الخلفي يمين"
                                                bindingR2.s3erR2sAcx.setText("10")
                                            } else {
                                                if (bindingR2.outsideright.isChecked && bindingR2.insideleft.isChecked) {
                                                    chhy2ahtow11.text = "تحشير لقم بريك امامي يمين و الخلفي يسار"
                                                    bindingR2.s3erR2sAcx.setText("10")
                                                } else {
                                                    if (bindingR2.outsideleft.isChecked && bindingR2.insideright.isChecked) {
                                                        chhy2ahtow11.text =
                                                            "تحشير لقم بريك امامي يسار و الخلفي يمين"
                                                        bindingR2.s3erR2sAcx.setText("10")
                                                    } else {
                                                        if (bindingR2.outsideleft.isChecked && bindingR2.insideleft.isChecked) {
                                                            chhy2ahtow11.text =
                                                                "تحشير لقم بريك امامي يسار و الخلفي يسار"
                                                            bindingR2.s3erR2sAcx.setText("10")
                                                        } else {
                                                            if (bindingR2.insideright.isChecked && bindingR2.insideleft.isChecked) {
                                                                chhy2ahtow11.text =
                                                                    "تحشير لقم بريك خلفي يمين و يسار"
                                                                bindingR2.s3erR2sAcx.setText(
                                                                    "10"
                                                                )
                                                            } else {
                                                                if (bindingR2.outsideright.isChecked) {
                                                                    chhy2ahtow11.text =
                                                                        "تحشير لقم بريك امامي يمين"
                                                                    bindingR2.s3erR2sAcx.setText(
                                                                        "5"
                                                                    )
                                                                }
                                                                if (bindingR2.outsideleft.isChecked) {
                                                                    chhy2ahtow11.text =
                                                                        "تحشير لقم بريك امامي يسار"
                                                                    bindingR2.s3erR2sAcx.setText(
                                                                        "5"
                                                                    )
                                                                }
                                                                if (bindingR2.insideleft.isChecked) {
                                                                    chhy2ahtow11.text =
                                                                        "تحشير لقم بريك خلفي يسار"
                                                                    bindingR2.s3erR2sAcx.setText(
                                                                        "5"
                                                                    )
                                                                }
                                                                if (bindingR2.insideright.isChecked) {
                                                                    chhy2ahtow11.text =
                                                                        "تحشير لقم بريك خلفي يمين"
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
                            prichy2ahtow11.text = bindingR2.s3erR2sAcx.text.toString()
                            customDialogR2SX.dismiss()
                        }
                    }
                }
                bindingR2.btnR2sCan.setOnClickListener {
                    if (prichy2ahtow11.text.toString().isEmpty()) {
                        chhy2ahtow11.text = "تحشير لقم بريك"
                        chhy2ahtow11.isChecked = false
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
                    chhy2ahtow11.text = "تحشير لقم بريك"
                    prichy2ahtow11.text = ""
                }
        }
        }

        binding.apply{
            chhy2ahtow12.setOnCheckedChangeListener { _ ,  isChecked ->
                if (chhy2ahtow12.isChecked) {

                    customDialogFR.window?.setFlags(WindowManager.LayoutParams.FLAG_SECURE, WindowManager.LayoutParams.FLAG_SECURE)

                    val window = customDialogFR.window
                    window?.setGravity(Gravity.BOTTOM)
                    val lp = window?.attributes
                    lp?.dimAmount = 0.0f
                    lp?.flags = lp?.flags?.or(WindowManager.LayoutParams.FLAG_DIM_BEHIND)
                    window?.attributes = lp

                    bindingFR.frontright.setOnCheckedChangeListener { _ ,  isChecked1 ->
                        if (bindingFR.frontright.isChecked) {
                            chhy2ahtow12.text =
                                "بيلية قاعدة صنوبرص امامي يمين"
                        } else {
                            chhy2ahtow12.text = "بيلية قاعدة صنوبرص"
                            bindingFR.s3erYadwee.setText("")
                        }
                        if (bindingFR.frontright.isChecked && bindingFR.frontleft.isChecked) {
                            chhy2ahtow12.text = "بيلية قاعدة صنوبرص امامي يمين و يسار"
                            bindingFR.s3erYadwee.setText("10")
                        } else {
                            if (bindingFR.frontright.isChecked) {
                                chhy2ahtow12.text = "بيلية قاعدة صنوبرص امامي يمين"
                                bindingFR.s3erYadwee.setText("5")
                            }
                            if (bindingFR.frontleft.isChecked) {
                                chhy2ahtow12.text = "بيلية قاعدة صنوبرص امامي يسار"
                                bindingFR.s3erYadwee.setText("5")
                            }
                        }
                    }
                    bindingFR.frontleft.setOnCheckedChangeListener { _ ,  isChecked2 ->
                        if (bindingFR.frontleft.isChecked) {
                            chhy2ahtow12.text ="بيلية قاعدة صنوبرص امامي يسار"
                        }else{chhy2ahtow12.text = "بيلية قاعدة صنوبرص"
                            bindingFR.s3erYadwee.setText("")}

                        if (bindingFR.frontleft.isChecked && bindingFR.frontright.isChecked){
                            chhy2ahtow12.text = "بيلية قاعدة صنوبرص امامي يمين و يسار"
                            bindingFR.s3erYadwee.setText("10")
                        }else {
                            if (bindingFR.frontright.isChecked) {
                                chhy2ahtow12.text = "بيلية قاعدة صنوبرص امامي يمين"
                                bindingFR.s3erYadwee.setText("5")
                            }
                            if (bindingFR.frontleft.isChecked) {
                                chhy2ahtow12.text = "بيلية قاعدة صنوبرص امامي يسار"
                                bindingFR.s3erYadwee.setText("5")
                            }
                        }
                    }

                    bindingFR.buttonDailogSave.setOnClickListener {
                        if (!bindingFR.frontright.isChecked && !bindingFR.frontleft.isChecked) {
                            toast_notempty1.show()
                        } else {
                            val  aa=bindingFR.s3erYadwee.text.toString().trim()
                            if (aa.isEmpty()) {
                                toast_notempty.show()
                            } else {
                                prichy2ahtow12.text = bindingFR.s3erYadwee.text.toString()
                                customDialogFR.dismiss()
                            }
                        }
                    }
                    bindingFR.buttonDailogCancel.setOnClickListener {
                        chhy2ahtow12.isChecked = false
                        bindingFR.s3erYadwee.setText("")
                        customDialogFR.dismiss()
                    }
                    bindingFR.frontright.isChecked = false
                    bindingFR.frontleft.isChecked = false
                    customDialogFR.show()
                }
                else {
                    chhy2ahtow12.text = "بيلية قاعدة صنوبرص"
                    prichy2ahtow12.text = ""
                }
            }
        }

        binding.apply{chhy2ahtow13.setOnCheckedChangeListener { _ ,  isChecked ->
            if (chhy2ahtow13.isChecked) {

                val window = customDialogMZ.window
                window?.setGravity(Gravity.TOP)
                val lp = window?.attributes
                lp?.dimAmount = 0.0f
                lp?.flags = lp?.flags?.or(WindowManager.LayoutParams.FLAG_DIM_BEHIND)
                window?.attributes = lp
                customDialogMZ.window?.setFlags(WindowManager.LayoutParams.FLAG_SECURE, WindowManager.LayoutParams.FLAG_SECURE)

                bindingMZ.front.text="علوي"
                bindingMZ.rear.text="سفلي"

                bindingMZ.front.setOnCheckedChangeListener { _ ,  isChecked1 ->
                    if (bindingMZ.front.isChecked) {
                        chhy2ahtow13.text =
                            chhy2ahtow13.text.toString() + " " + bindingMZ.front.text.toString()
                    } else {
                        chhy2ahtow13.text = "طقم اصلاح مجموعة ستيرنج"
                        bindingMZ.s3erYadweeFa7.setText("")
                    }

                    if (bindingMZ.front.isChecked && bindingMZ.rear.isChecked) {
                        chhy2ahtow13.text = "طقم اصلاح مجموعة ستيرنج علوي و سفلي"
                        bindingMZ.s3erYadweeFa7.setText("60")
                    } else {
                        if (bindingMZ.front.isChecked) {
                            chhy2ahtow13.text = "طقم اصلاح مجموعة ستيرنج علوي"
                            bindingMZ.s3erYadweeFa7.setText("25")
                        }
                        if (bindingMZ.rear.isChecked) {
                            chhy2ahtow13.text = "طقم اصلاح مجموعة ستيرنج سفلي"
                            bindingMZ.s3erYadweeFa7.setText("35")
                        }
                    }
                }
                bindingMZ.rear.setOnCheckedChangeListener { _ ,  isChecked2 ->
                    if (bindingMZ.rear.isChecked) {
                        chhy2ahtow13.text = chhy2ahtow13.text.toString() + " " +
                                bindingMZ.rear.text.toString()
                    }else{chhy2ahtow13.text = "طقم اصلاح مجموعة ستيرنج"
                        bindingMZ.s3erYadweeFa7.setText("")}

                    if (bindingMZ.rear.isChecked && bindingMZ.front.isChecked){
                        chhy2ahtow13.text = "طقم اصلاح مجموعة ستيرنج علوي و سفلي"
                        bindingMZ.s3erYadweeFa7.setText("60")
                    }else {
                        if (bindingMZ.front.isChecked) {
                            chhy2ahtow13.text = "طقم اصلاح مجموعة ستيرنج علوي"
                            bindingMZ.s3erYadweeFa7.setText("25")
                        }
                        if (bindingMZ.rear.isChecked) {
                            chhy2ahtow13.text = "طقم اصلاح مجموعة ستيرنج سفلي"
                            bindingMZ.s3erYadweeFa7.setText("35")
                        }
                    }
                }

                bindingMZ.btnSvDigFa7.setOnClickListener {
                    if (!bindingMZ.front.isChecked && !bindingMZ.rear.isChecked) {
                        toast_notempty1.show()
                    } else {
                        val  aa=bindingMZ.s3erYadweeFa7.text.toString().trim()
                        if (aa.isEmpty()) {
                            toast_notempty.show()
                        } else {
                            prichy2ahtow13.text = bindingMZ.s3erYadweeFa7.text.toString()
                            customDialogMZ.dismiss()
                        }
                    }
                }
                bindingMZ.btnCnDigMz.setOnClickListener {
                    chhy2ahtow13.isChecked = false
                    bindingMZ.s3erYadweeFa7.setText("")
                    customDialogMZ.dismiss()
                }
                bindingMZ.front.isChecked = false
                bindingMZ.rear.isChecked = false
                customDialogMZ.show()
            }
            else {
                chhy2ahtow13.text = "طقم اصلاح مجموعة ستيرنج"
                prichy2ahtow13.text = ""
            }
        }
        }

        binding.apply{
            chhy2ahtow14.setOnCheckedChangeListener { _ ,  isChecked ->
            if (chhy2ahtow14.isChecked) {

                val window = customDialogMZ.window
                window?.setGravity(Gravity.TOP)
                val lp = window?.attributes
                lp?.dimAmount = 0.0f
                lp?.flags = lp?.flags?.or(WindowManager.LayoutParams.FLAG_DIM_BEHIND)
                window?.attributes = lp
                customDialogMZ.window?.setFlags(WindowManager.LayoutParams.FLAG_SECURE, WindowManager.LayoutParams.FLAG_SECURE)

                bindingMZ.front.setOnCheckedChangeListener { _ ,  isChecked1 ->
                    if (bindingMZ.front.isChecked) {
                        chhy2ahtow14.text =
                            chhy2ahtow14.text.toString() + " " + bindingMZ.front.text.toString()
                    } else {
                        chhy2ahtow14.text = "بكسات الدنجل"
                        bindingMZ.s3erYadweeFa7.setText("")
                    }
                    if (bindingMZ.front.isChecked && bindingMZ.rear.isChecked) {
                        chhy2ahtow14.text = "بكسات الدنجل الامامي و الخلفي"
                        bindingMZ.s3erYadweeFa7.setText("90")
                    } else {
                        if (bindingMZ.front.isChecked) {
                            chhy2ahtow14.text = "بكسات الدنجل الامامي"
                            bindingMZ.s3erYadweeFa7.setText("60")
                        }
                        if (bindingMZ.rear.isChecked) {
                            chhy2ahtow14.text = "بكسات الدنجل الخلفي"
                            bindingMZ.s3erYadweeFa7.setText("30")
                        }
                    }
                }
                bindingMZ.rear.setOnCheckedChangeListener { _ ,  isChecked2 ->
                    if (bindingMZ.rear.isChecked) {
                        chhy2ahtow14.text = chhy2ahtow14.text.toString() + " " +
                                bindingMZ.rear.text.toString()
                    }else{chhy2ahtow14.text = "بكسات الدنجل"
                        bindingMZ.s3erYadweeFa7.setText("")}

                    if (bindingMZ.rear.isChecked && bindingMZ.front.isChecked){
                        chhy2ahtow14.text = "بكسات الدنجل الامامي و الخلفي"
                        bindingMZ.s3erYadweeFa7.setText("90")
                    }else {
                        if (bindingMZ.front.isChecked) {
                            chhy2ahtow14.text = "بكسات الدنجل الامامي"
                            bindingMZ.s3erYadweeFa7.setText("60")
                        }
                        if (bindingMZ.rear.isChecked) {
                            chhy2ahtow14.text = "بكسات الدنجل الخلفي"
                            bindingMZ.s3erYadweeFa7.setText("30")
                        }
                    }
                }

                bindingMZ.btnSvDigFa7.setOnClickListener {
                    if (!bindingMZ.front.isChecked && !bindingMZ.rear.isChecked) {
                        toast_notempty1.show()
                    } else {
                        val  aa=bindingMZ.s3erYadweeFa7.text.toString().trim()
                        if (aa.isEmpty()) {
                            toast_notempty.show()
                        } else {
                            prichy2ahtow14.text = bindingMZ.s3erYadweeFa7.text.toString()
                          customDialogMZ.dismiss()
                        }
                    }
                }
                bindingMZ.btnCnDigMz.setOnClickListener {
                    chhy2ahtow14.isChecked = false
                    bindingMZ.s3erYadweeFa7.setText("")
                    customDialogMZ.dismiss()
                }
                bindingMZ.front.isChecked = false
                bindingMZ.rear.isChecked = false
                customDialogMZ.show()
            }
            else {
               chhy2ahtow14.text = "بكسات الدنجل"
                prichy2ahtow14.text = ""
            }
        }
        }

        binding.apply{
            chhy2ahtow15.setOnCheckedChangeListener { _ ,  isChecked ->
            if (chhy2ahtow15.isChecked) {

                customDialogR2SX.window?.setFlags(WindowManager.LayoutParams.FLAG_SECURE, WindowManager.LayoutParams.FLAG_SECURE)
                customDialogR2SX.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

                bindingR2.titR2sOut.visibility = View.INVISIBLE
                bindingR2.titR2sIn.visibility = View.INVISIBLE
                bindingR2.outsideright.text="امامية"
                bindingR2.outsideleft.text="خلفية"
                bindingR2.insideright.text="علوية يمين"
                bindingR2.insideleft.text="علوية يسار"

                val window = customDialogR2SX.window
                window?.setGravity(Gravity.TOP)
                val lp = window?.attributes
                lp?.dimAmount = 0.0f
                lp?.flags = lp?.flags?.or(WindowManager.LayoutParams.FLAG_DIM_BEHIND)
                window?.attributes = lp

                bindingR2.outsideright.setOnCheckedChangeListener { _ ,  isChecked1 ->

                    if (bindingR2.outsideright.isChecked) {
                        chhy2ahtow15.text = "قاعدة محرك امامية"
                    } else {
                        chhy2ahtow15.text = "قاعدة محرك"
                        bindingR2.s3erR2sAcx.setText("")
                    }
                    if (bindingR2.outsideright.isChecked && bindingR2.outsideleft.isChecked && bindingR2.insideright.isChecked && bindingR2.insideleft.isChecked) {
                        chhy2ahtow15.text = "تغير جميع قواعد المحرك"
                        bindingR2.s3erR2sAcx.setText("30")
                    } else {
                        if (bindingR2.outsideright.isChecked && bindingR2.outsideleft.isChecked && bindingR2.insideright.isChecked) {
                            chhy2ahtow15.text = "قاعدة محرك امامية و خلفية و علوية يمين"
                            bindingR2.s3erR2sAcx.setText("20")
                        } else {
                            if (bindingR2.outsideright.isChecked && bindingR2.outsideleft.isChecked && bindingR2.insideleft.isChecked) {
                                chhy2ahtow15.text = "قاعدة محرك امامية و خلفية و علوية يسار"
                                bindingR2.s3erR2sAcx.setText("20")
                            } else {
                                if (bindingR2.outsideright.isChecked && bindingR2.insideright.isChecked && bindingR2.insideleft.isChecked) {
                                    chhy2ahtow15.text = "قاعدة محرك امامية و علويتين"
                                    bindingR2.s3erR2sAcx.setText("25")
                                } else {
                                    if (bindingR2.outsideleft.isChecked && bindingR2.insideright.isChecked && bindingR2.insideleft.isChecked) {
                                        chhy2ahtow15.text = "قاعدة محرك خلفية و علويتين"
                                        bindingR2.s3erR2sAcx.setText("25")
                                    } else {
                                        if (bindingR2.outsideright.isChecked && bindingR2.outsideleft.isChecked) {
                                            chhy2ahtow15.text = "قاعدة محرك امامي و خلفي"
                                            bindingR2.s3erR2sAcx.setText("10")
                                        } else {
                                            if (bindingR2.outsideright.isChecked && bindingR2.insideright.isChecked) {
                                                chhy2ahtow15.text = "قاعدة محرك امامي و علوية يمين"
                                                bindingR2.s3erR2sAcx.setText("15")
                                            } else {
                                                if (bindingR2.outsideright.isChecked && bindingR2.insideleft.isChecked) {
                                                    chhy2ahtow15.text = "قاعدة محرك امامي و علوية يسار"
                                                    bindingR2.s3erR2sAcx.setText("15")
                                                } else {
                                                    if (bindingR2.outsideleft.isChecked && bindingR2.insideright.isChecked) {
                                                        chhy2ahtow15.text =
                                                            "قاعدة محرك خلفي و علوية يمين"
                                                        bindingR2.s3erR2sAcx.setText("15")
                                                    } else {
                                                        if (bindingR2.outsideleft.isChecked && bindingR2.insideleft.isChecked) {
                                                            chhy2ahtow15.text =
                                                                "قاعدة محرك خلفي و علوية يسار"
                                                            bindingR2.s3erR2sAcx.setText("15")
                                                        } else {
                                                            if (bindingR2.insideright.isChecked && bindingR2.insideleft.isChecked) {
                                                                chhy2ahtow15.text =
                                                                    "قاعدة محرك علوية يمين و يسار"
                                                                bindingR2.s3erR2sAcx.setText(
                                                                    "20"
                                                                )
                                                            } else {
                                                                if (bindingR2.outsideright.isChecked) {
                                                                    chhy2ahtow15.text =
                                                                        "قاعدة محرك امامي "
                                                                    bindingR2.s3erR2sAcx.setText(
                                                                        "5"
                                                                    )
                                                                }
                                                                if (bindingR2.outsideleft.isChecked) {
                                                                    chhy2ahtow15.text =
                                                                        "قاعدة محرك خلفي "
                                                                    bindingR2.s3erR2sAcx.setText(
                                                                        "5"
                                                                    )
                                                                }
                                                                if (bindingR2.insideleft.isChecked) {
                                                                    chhy2ahtow15.text =
                                                                        "قاعدة محرك علوية يسار "
                                                                    bindingR2.s3erR2sAcx.setText(
                                                                        "10"
                                                                    )
                                                                }
                                                                if (bindingR2.insideright.isChecked) {
                                                                    chhy2ahtow15.text =
                                                                        "قاعدة محرك علوية يمين "
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

                bindingR2.outsideleft.setOnCheckedChangeListener { _ ,  isChecked2 ->
                    if (bindingR2.outsideleft.isChecked) {
                        chhy2ahtow15.text = "قاعدة محرك خلفي "
                    } else {
                        chhy2ahtow15.text = "قاعدة محرك"
                        bindingR2.s3erR2sAcx.setText("")
                    }
                    if (bindingR2.outsideright.isChecked && bindingR2.outsideleft.isChecked && bindingR2.insideright.isChecked && bindingR2.insideleft.isChecked) {
                        chhy2ahtow15.text = "تغير جميع قواعد المحرك"
                        bindingR2.s3erR2sAcx.setText("30")
                    } else {
                        if (bindingR2.outsideright.isChecked && bindingR2.outsideleft.isChecked && bindingR2.insideright.isChecked) {
                            chhy2ahtow15.text = "قاعدة محرك امامية و خلفية و علوية يمين"
                            bindingR2.s3erR2sAcx.setText("20")
                        } else {
                            if (bindingR2.outsideright.isChecked && bindingR2.outsideleft.isChecked && bindingR2.insideleft.isChecked) {
                                chhy2ahtow15.text = "قاعدة محرك امامية و خلفية و علوية يسار"
                                bindingR2.s3erR2sAcx.setText("20")
                            } else {
                                if (bindingR2.outsideright.isChecked && bindingR2.insideright.isChecked && bindingR2.insideleft.isChecked) {
                                    chhy2ahtow15.text = "قاعدة محرك امامية و علويتين"
                                    bindingR2.s3erR2sAcx.setText("25")
                                } else {
                                    if (bindingR2.outsideleft.isChecked && bindingR2.insideright.isChecked && bindingR2.insideleft.isChecked) {
                                        chhy2ahtow15.text = "قاعدة محرك خلفية و علويتين"
                                        bindingR2.s3erR2sAcx.setText("25")
                                    } else {
                                        if (bindingR2.outsideright.isChecked && bindingR2.outsideleft.isChecked) {
                                            chhy2ahtow15.text = "قاعدة محرك امامي و خلفي"
                                            bindingR2.s3erR2sAcx.setText("10")
                                        } else {
                                            if (bindingR2.outsideright.isChecked && bindingR2.insideright.isChecked) {
                                                chhy2ahtow15.text = "قاعدة محرك امامي و علوية يمين"
                                                bindingR2.s3erR2sAcx.setText("15")
                                            } else {
                                                if (bindingR2.outsideright.isChecked && bindingR2.insideleft.isChecked) {
                                                    chhy2ahtow15.text = "قاعدة محرك امامي و علوية يسار"
                                                    bindingR2.s3erR2sAcx.setText("15")
                                                } else {
                                                    if (bindingR2.outsideleft.isChecked && bindingR2.insideright.isChecked) {
                                                        chhy2ahtow15.text =
                                                            "قاعدة محرك خلفي و علوية يمين"
                                                        bindingR2.s3erR2sAcx.setText("15")
                                                    } else {
                                                        if (bindingR2.outsideleft.isChecked && bindingR2.insideleft.isChecked) {
                                                            chhy2ahtow15.text =
                                                                "قاعدة محرك خلفي و علوية يسار"
                                                            bindingR2.s3erR2sAcx.setText("15")
                                                        } else {
                                                            if (bindingR2.insideright.isChecked && bindingR2.insideleft.isChecked) {
                                                                chhy2ahtow15.text =
                                                                    "قاعدة محرك علوية يمين و يسار"
                                                                bindingR2.s3erR2sAcx.setText(
                                                                    "20"
                                                                )
                                                            } else {
                                                                if (bindingR2.outsideright.isChecked) {
                                                                    chhy2ahtow15.text =
                                                                        "قاعدة محرك امامي "
                                                                    bindingR2.s3erR2sAcx.setText(
                                                                        "5"
                                                                    )
                                                                }
                                                                if (bindingR2.outsideleft.isChecked) {
                                                                    chhy2ahtow15.text =
                                                                        "قاعدة محرك خلفي "
                                                                    bindingR2.s3erR2sAcx.setText(
                                                                        "5"
                                                                    )
                                                                }
                                                                if (bindingR2.insideleft.isChecked) {
                                                                    chhy2ahtow15.text =
                                                                        "قاعدة محرك علوية يسار "
                                                                    bindingR2.s3erR2sAcx.setText(
                                                                        "10"
                                                                    )
                                                                }
                                                                if (bindingR2.insideright.isChecked) {
                                                                    chhy2ahtow15.text =
                                                                        "قاعدة محرك علوية يمين "
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

                bindingR2.insideleft.setOnCheckedChangeListener { _ ,  isChecked2 ->
                    if (bindingR2.outsideright.isChecked) {
                        chhy2ahtow15.text = "قاعدة محرك علوية يسار "
                    } else {
                        chhy2ahtow15.text = "قاعدة محرك"
                        bindingR2.s3erR2sAcx.setText("")
                    }
                    if (bindingR2.outsideright.isChecked && bindingR2.outsideleft.isChecked && bindingR2.insideright.isChecked && bindingR2.insideleft.isChecked) {
                        chhy2ahtow15.text = "تغير جميع قواعد المحرك"
                        bindingR2.s3erR2sAcx.setText("30")
                    } else {
                        if (bindingR2.outsideright.isChecked && bindingR2.outsideleft.isChecked && bindingR2.insideright.isChecked) {
                            chhy2ahtow15.text = "قاعدة محرك امامية و خلفية و علوية يمين"
                            bindingR2.s3erR2sAcx.setText("20")
                        } else {
                            if (bindingR2.outsideright.isChecked && bindingR2.outsideleft.isChecked && bindingR2.insideleft.isChecked) {
                                chhy2ahtow15.text = "قاعدة محرك امامية و خلفية و علوية يسار"
                                bindingR2.s3erR2sAcx.setText("20")
                            } else {
                                if (bindingR2.outsideright.isChecked && bindingR2.insideright.isChecked && bindingR2.insideleft.isChecked) {
                                    chhy2ahtow15.text = "قاعدة محرك امامية و علويتين"
                                    bindingR2.s3erR2sAcx.setText("25")
                                } else {
                                    if (bindingR2.outsideleft.isChecked && bindingR2.insideright.isChecked && bindingR2.insideleft.isChecked) {
                                        chhy2ahtow15.text = "قاعدة محرك خلفية و علويتين"
                                        bindingR2.s3erR2sAcx.setText("25")
                                    } else {
                                        if (bindingR2.outsideright.isChecked && bindingR2.outsideleft.isChecked) {
                                            chhy2ahtow15.text = "قاعدة محرك امامي و خلفي"
                                            bindingR2.s3erR2sAcx.setText("10")
                                        } else {
                                            if (bindingR2.outsideright.isChecked && bindingR2.insideright.isChecked) {
                                                chhy2ahtow15.text = "قاعدة محرك امامي و علوية يمين"
                                                bindingR2.s3erR2sAcx.setText("15")
                                            } else {
                                                if (bindingR2.outsideright.isChecked && bindingR2.insideleft.isChecked) {
                                                    chhy2ahtow15.text = "قاعدة محرك امامي و علوية يسار"
                                                    bindingR2.s3erR2sAcx.setText("15")
                                                } else {
                                                    if (bindingR2.outsideleft.isChecked && bindingR2.insideright.isChecked) {
                                                        chhy2ahtow15.text =
                                                            "قاعدة محرك خلفي و علوية يمين"
                                                        bindingR2.s3erR2sAcx.setText("15")
                                                    } else {
                                                        if (bindingR2.outsideleft.isChecked && bindingR2.insideleft.isChecked) {
                                                            chhy2ahtow15.text =
                                                                "قاعدة محرك خلفي و علوية يسار"
                                                            bindingR2.s3erR2sAcx.setText("15")
                                                        } else {
                                                            if (bindingR2.insideright.isChecked && bindingR2.insideleft.isChecked) {
                                                                chhy2ahtow15.text =
                                                                    "قاعدة محرك علوية يمين و يسار"
                                                                bindingR2.s3erR2sAcx.setText(
                                                                    "20"
                                                                )
                                                            } else {
                                                                if (bindingR2.outsideright.isChecked) {
                                                                    chhy2ahtow15.text =
                                                                        "قاعدة محرك امامي "
                                                                    bindingR2.s3erR2sAcx.setText(
                                                                        "5"
                                                                    )
                                                                }
                                                                if (bindingR2.outsideleft.isChecked) {
                                                                    chhy2ahtow15.text =
                                                                        "قاعدة محرك خلفي "
                                                                    bindingR2.s3erR2sAcx.setText(
                                                                        "5"
                                                                    )
                                                                }
                                                                if (bindingR2.insideleft.isChecked) {
                                                                    chhy2ahtow15.text =
                                                                        "قاعدة محرك علوية يسار "
                                                                    bindingR2.s3erR2sAcx.setText(
                                                                        "10"
                                                                    )
                                                                }
                                                                if (bindingR2.insideright.isChecked) {
                                                                    chhy2ahtow15.text =
                                                                        "قاعدة محرك علوية يمين "
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

                bindingR2.insideright.setOnCheckedChangeListener { _ ,  isChecked2 ->
                    if (bindingR2.insideright.isChecked) {
                        chhy2ahtow15.text = "قاعدة محرك علوية يمين "
                    } else {
                        chhy2ahtow15.text = "قاعدة محرك"
                        bindingR2.s3erR2sAcx.setText("")
                    }
                    if (bindingR2.outsideright.isChecked && bindingR2.outsideleft.isChecked && bindingR2.insideright.isChecked && bindingR2.insideleft.isChecked) {
                        chhy2ahtow15.text = "تغير جميع قواعد المحرك"
                        bindingR2.s3erR2sAcx.setText("30")
                    } else {
                        if (bindingR2.outsideright.isChecked && bindingR2.outsideleft.isChecked && bindingR2.insideright.isChecked) {
                            chhy2ahtow15.text = "قاعدة محرك امامية و خلفية و علوية يمين"
                            bindingR2.s3erR2sAcx.setText("20")
                        } else {
                            if (bindingR2.outsideright.isChecked && bindingR2.outsideleft.isChecked && bindingR2.insideleft.isChecked) {
                                chhy2ahtow15.text = "قاعدة محرك امامية و خلفية و علوية يسار"
                                bindingR2.s3erR2sAcx.setText("20")
                            } else {
                                if (bindingR2.outsideright.isChecked && bindingR2.insideright.isChecked && bindingR2.insideleft.isChecked) {
                                    chhy2ahtow15.text = "قاعدة محرك امامية و علويتين"
                                    bindingR2.s3erR2sAcx.setText("25")
                                } else {
                                    if (bindingR2.outsideleft.isChecked && bindingR2.insideright.isChecked && bindingR2.insideleft.isChecked) {
                                        chhy2ahtow15.text = "قاعدة محرك خلفية و علويتين"
                                        bindingR2.s3erR2sAcx.setText("25")
                                    } else {
                                        if (bindingR2.outsideright.isChecked && bindingR2.outsideleft.isChecked) {
                                            chhy2ahtow15.text = "قاعدة محرك امامي و خلفي"
                                            bindingR2.s3erR2sAcx.setText("10")
                                        } else {
                                            if (bindingR2.outsideright.isChecked && bindingR2.insideright.isChecked) {
                                                chhy2ahtow15.text = "قاعدة محرك امامي و علوية يمين"
                                                bindingR2.s3erR2sAcx.setText("15")
                                            } else {
                                                if (bindingR2.outsideright.isChecked && bindingR2.insideleft.isChecked) {
                                                    chhy2ahtow15.text = "قاعدة محرك امامي و علوية يسار"
                                                    bindingR2.s3erR2sAcx.setText("15")
                                                } else {
                                                    if (bindingR2.outsideleft.isChecked && bindingR2.insideright.isChecked) {
                                                        chhy2ahtow15.text =
                                                            "قاعدة محرك خلفي و علوية يمين"
                                                        bindingR2.s3erR2sAcx.setText("15")
                                                    } else {
                                                        if (bindingR2.outsideleft.isChecked && bindingR2.insideleft.isChecked) {
                                                            chhy2ahtow15.text =
                                                                "قاعدة محرك خلفي و علوية يسار"
                                                            bindingR2.s3erR2sAcx.setText("15")
                                                        } else {
                                                            if (bindingR2.insideright.isChecked && bindingR2.insideleft.isChecked) {
                                                                chhy2ahtow15.text =
                                                                    "قاعدة محرك علوية يمين و يسار"
                                                                bindingR2.s3erR2sAcx.setText(
                                                                    "20"
                                                                )
                                                            } else {
                                                                if (bindingR2.outsideright.isChecked) {
                                                                    chhy2ahtow15.text =
                                                                        "قاعدة محرك امامي "
                                                                    bindingR2.s3erR2sAcx.setText(
                                                                        "5"
                                                                    )
                                                                }
                                                                if (bindingR2.outsideleft.isChecked) {
                                                                    chhy2ahtow15.text =
                                                                        "قاعدة محرك خلفي "
                                                                    bindingR2.s3erR2sAcx.setText(
                                                                        "5"
                                                                    )
                                                                }
                                                                if (bindingR2.insideleft.isChecked) {
                                                                    chhy2ahtow15.text =
                                                                        "قاعدة محرك علوية يسار "
                                                                    bindingR2.s3erR2sAcx.setText(
                                                                        "10"
                                                                    )
                                                                }
                                                                if (bindingR2.insideright.isChecked) {
                                                                    chhy2ahtow15.text =
                                                                        "قاعدة محرك علوية يمين "
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
                            prichy2ahtow15.text = bindingR2.s3erR2sAcx.text.toString()
                           customDialogR2SX.dismiss()
                        }
                    }
                }
                bindingR2.btnR2sCan.setOnClickListener {
                    if (prichy2ahtow15.text.toString().isEmpty()) {
                        chhy2ahtow15.text = "قاعدة محرك"
                        chhy2ahtow15.isChecked = false
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
                    chhy2ahtow15.text = "قاعدة محرك"
                    prichy2ahtow15.text = ""
                }
        }
        }

        binding.apply{
            chhy2ahtow16.setOnCheckedChangeListener { _ ,  isChecked ->
                if (chhy2ahtow16.isChecked) {

                    val window = customDialogMZ.window
                    window?.setGravity(Gravity.TOP)
                    val lp = window?.attributes
                    lp?.dimAmount = 0.0f
                    lp?.flags = lp?.flags?.or(WindowManager.LayoutParams.FLAG_DIM_BEHIND)
                    window?.attributes = lp
                    customDialogMZ.window?.setFlags(WindowManager.LayoutParams.FLAG_SECURE, WindowManager.LayoutParams.FLAG_SECURE)

                    bindingMZ.front.setOnCheckedChangeListener { _ ,  isChecked1 ->
                        if (bindingMZ.front.isChecked) {
                            chhy2ahtow16.text =
                                "قشرة دنجل امامية"
                        } else {
                            chhy2ahtow16.text = "قشرة دنجل"
                            bindingMZ.s3erYadweeFa7.setText("")
                        }
                        if (bindingMZ.front.isChecked && bindingMZ.rear.isChecked) {
                            chhy2ahtow16.text = "قشرة دنجل امامية و خلفية"
                            bindingMZ.s3erYadweeFa7.setText("75")
                        } else {
                            if (bindingMZ.front.isChecked) {
                                chhy2ahtow16.text = "قشرة دنجل امامية"
                                bindingMZ.s3erYadweeFa7.setText("40")
                            }
                            if (bindingMZ.rear.isChecked) {
                                chhy2ahtow16.text = "قشرة دنجل خلفية"
                                bindingMZ.s3erYadweeFa7.setText("35")
                            }
                        }
                    }
                    bindingMZ.rear.setOnCheckedChangeListener { _ ,  isChecked2 ->
                        if (bindingMZ.rear.isChecked) {
                            chhy2ahtow16.text = "قشرة دنجل خلفية"
                        }else{chhy2ahtow16.text = "قشرة دنجل"
                            bindingMZ.s3erYadweeFa7.setText("")}

                        if (bindingMZ.rear.isChecked && bindingMZ.front.isChecked){
                            chhy2ahtow16.text = "قشرة دنجل امامية و خلفية"
                            bindingMZ.s3erYadweeFa7.setText("75")
                        }else {
                            if (bindingMZ.front.isChecked) {
                                chhy2ahtow16.text = "قشرة دنجل امامية"
                                bindingMZ.s3erYadweeFa7.setText("40")
                            }
                            if (bindingMZ.rear.isChecked) {
                                chhy2ahtow16.text = "قشرة دنجل خلفية"
                                bindingMZ.s3erYadweeFa7.setText("35")
                            }
                        }
                    }

                    bindingMZ.btnSvDigFa7.setOnClickListener {
                        if (!bindingMZ.front.isChecked && !bindingMZ.rear.isChecked) {
                            toast_notempty1.show()
                        } else {
                            val  aa=bindingMZ.s3erYadweeFa7.text.toString().trim()
                            if (aa.isEmpty()) {
                                toast_notempty.show()
                            } else {
                                prichy2ahtow16.text = bindingMZ.s3erYadweeFa7.text.toString()
                               customDialogMZ.dismiss()
                            }
                        }
                    }
                    bindingMZ.btnCnDigMz.setOnClickListener {
                        chhy2ahtow16.isChecked = false
                        bindingMZ.s3erYadweeFa7.setText("")
                        customDialogMZ.dismiss()
                    }
                    bindingMZ.front.isChecked = false
                    bindingMZ.rear.isChecked = false
                    customDialogMZ.show()
                }
                else {
                    chhy2ahtow16.text = "قشرة دنجل"
                    prichy2ahtow16.text = ""
                }
            }
        }

        binding.apply{
            chhy2ahtow17.setOnCheckedChangeListener { _ ,  isChecked ->
                if (chhy2ahtow17.isChecked) {

                    customDialogR2SX.window?.setFlags(WindowManager.LayoutParams.FLAG_SECURE, WindowManager.LayoutParams.FLAG_SECURE)

                    customDialogR2SX.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
                    bindingR2.titR2sOut.text="علوية"
                    bindingR2.titR2sIn.text="سفلية"

                    val window = customDialogR2SX.window
                    window?.setGravity(Gravity.TOP)
                    val lp = window?.attributes
                    lp?.dimAmount = 0.0f
                    lp?.flags = lp?.flags?.or(WindowManager.LayoutParams.FLAG_DIM_BEHIND)
                    window?.attributes = lp

                    bindingR2.outsideright.setOnCheckedChangeListener { _ ,  isChecked1 ->

                        if (bindingR2.outsideright.isChecked) {
                            chhy2ahtow17.text = "كفة علوية يمين"
                        } else {
                            chhy2ahtow17.text = "كفة علوية"
                            bindingR2.s3erR2sAcx.setText("")
                        }

                        if (bindingR2.outsideright.isChecked && bindingR2.outsideleft.isChecked && bindingR2.insideright.isChecked && bindingR2.insideleft.isChecked) {
                            chhy2ahtow17.text = "تغير جميع الكفات العلويه و السفليه"
                            bindingR2.s3erR2sAcx.setText("40")
                        } else {
                            if (bindingR2.outsideright.isChecked && bindingR2.outsideleft.isChecked && bindingR2.insideright.isChecked) {
                                chhy2ahtow17.text = "كفة علوية كامل و السفلية يمين"
                                bindingR2.s3erR2sAcx.setText("30")
                            } else {
                                if (bindingR2.outsideright.isChecked && bindingR2.outsideleft.isChecked && bindingR2.insideleft.isChecked) {
                                    chhy2ahtow17.text = "كفة علوية كامل و السفلية يسار"
                                    bindingR2.s3erR2sAcx.setText("30")
                                } else {
                                    if (bindingR2.outsideright.isChecked && bindingR2.insideright.isChecked && bindingR2.insideleft.isChecked) {
                                        chhy2ahtow17.text = "كفة علوية يمين و السفلي كامل"
                                        bindingR2.s3erR2sAcx.setText("30")
                                    } else {
                                        if (bindingR2.outsideleft.isChecked && bindingR2.insideright.isChecked && bindingR2.insideleft.isChecked) {
                                            chhy2ahtow17.text = "كفة علوية يسار و السفلي كامل"
                                            bindingR2.s3erR2sAcx.setText("30")
                                        } else {
                                            if (bindingR2.outsideright.isChecked && bindingR2.outsideleft.isChecked) {
                                                chhy2ahtow17.text = "كفة علوية يمين و يسار"
                                                bindingR2.s3erR2sAcx.setText("20")
                                            } else {
                                                if (bindingR2.outsideright.isChecked && bindingR2.insideright.isChecked) {
                                                    chhy2ahtow17.text = "كفة علوية يمين و السفلي يمين"
                                                    bindingR2.s3erR2sAcx.setText("20")
                                                } else {
                                                    if (bindingR2.outsideright.isChecked && bindingR2.insideleft.isChecked) {
                                                        chhy2ahtow17.text = "كفة علوية يمين و السفلي يسار"
                                                        bindingR2.s3erR2sAcx.setText("20")
                                                    } else {
                                                        if (bindingR2.outsideleft.isChecked && bindingR2.insideright.isChecked) {
                                                            chhy2ahtow17.text =
                                                                "كفة علوية يسار و السفلي يمين"
                                                            bindingR2.s3erR2sAcx.setText("20")
                                                        } else {
                                                            if (bindingR2.outsideleft.isChecked && bindingR2.insideleft.isChecked) {
                                                                chhy2ahtow17.text =
                                                                    "كفة علوية يسار و السفلي يسار"
                                                                bindingR2.s3erR2sAcx.setText("20")
                                                            } else {
                                                                if (bindingR2.insideright.isChecked && bindingR2.insideleft.isChecked) {
                                                                    chhy2ahtow17.text =
                                                                        "كفة سفلي يمين و يسار"
                                                                    bindingR2.s3erR2sAcx.setText(
                                                                        "20"
                                                                    )
                                                                } else {
                                                                    if (bindingR2.outsideright.isChecked) {
                                                                        chhy2ahtow17.text =
                                                                            "كفة علوية يمين"
                                                                        bindingR2.s3erR2sAcx.setText(
                                                                            "10"
                                                                        )
                                                                    }
                                                                    if (bindingR2.outsideleft.isChecked) {
                                                                        chhy2ahtow17.text =
                                                                            "كفة علوية يسار"
                                                                        bindingR2.s3erR2sAcx.setText(
                                                                            "10"
                                                                        )
                                                                    }
                                                                    if (bindingR2.insideleft.isChecked) {
                                                                        chhy2ahtow17.text =
                                                                            "كفة سفلي يسار"
                                                                        bindingR2.s3erR2sAcx.setText(
                                                                            "10"
                                                                        )
                                                                    }
                                                                    if (bindingR2.insideright.isChecked) {
                                                                        chhy2ahtow17.text =
                                                                            "كفة سفلي يمين"
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

                    bindingR2.outsideleft.setOnCheckedChangeListener { _ ,  isChecked2 ->
                        if (bindingR2.outsideleft.isChecked) {
                            chhy2ahtow17.text = "كفة سفلية يسار"
                        } else {
                            chhy2ahtow17.text = "كفة سفلية"
                            bindingR2.s3erR2sAcx.setText("")
                        }

                        if (bindingR2.outsideright.isChecked && bindingR2.outsideleft.isChecked && bindingR2.insideright.isChecked && bindingR2.insideleft.isChecked) {
                            chhy2ahtow17.text = "تغير جميع الكفات العلويه و السفليه"
                            bindingR2.s3erR2sAcx.setText("40")
                        } else {
                            if (bindingR2.outsideright.isChecked && bindingR2.outsideleft.isChecked && bindingR2.insideright.isChecked) {
                                chhy2ahtow17.text = "كفة علوية كامل و السفلية يمين"
                                bindingR2.s3erR2sAcx.setText("30")
                            } else {
                                if (bindingR2.outsideright.isChecked && bindingR2.outsideleft.isChecked && bindingR2.insideleft.isChecked) {
                                    chhy2ahtow17.text = "كفة علوية كامل و السفلية يسار"
                                    bindingR2.s3erR2sAcx.setText("30")
                                } else {
                                    if (bindingR2.outsideright.isChecked && bindingR2.insideright.isChecked && bindingR2.insideleft.isChecked) {
                                        chhy2ahtow17.text = "كفة علوية يمين و السفلي كامل"
                                        bindingR2.s3erR2sAcx.setText("30")
                                    } else {
                                        if (bindingR2.outsideleft.isChecked && bindingR2.insideright.isChecked && bindingR2.insideleft.isChecked) {
                                            chhy2ahtow17.text = "كفة علوية يسار و السفلي كامل"
                                            bindingR2.s3erR2sAcx.setText("30")
                                        } else {
                                            if (bindingR2.outsideright.isChecked && bindingR2.outsideleft.isChecked) {
                                                chhy2ahtow17.text = "كفة علوية يمين و يسار"
                                                bindingR2.s3erR2sAcx.setText("20")
                                            } else {
                                                if (bindingR2.outsideright.isChecked && bindingR2.insideright.isChecked) {
                                                    chhy2ahtow17.text = "كفة علوية يمين و السفلي يمين"
                                                    bindingR2.s3erR2sAcx.setText("20")
                                                } else {
                                                    if (bindingR2.outsideright.isChecked && bindingR2.insideleft.isChecked) {
                                                        chhy2ahtow17.text = "كفة علوية يمين و السفلي يسار"
                                                        bindingR2.s3erR2sAcx.setText("20")
                                                    } else {
                                                        if (bindingR2.outsideleft.isChecked && bindingR2.insideright.isChecked) {
                                                            chhy2ahtow17.text =
                                                                "كفة علوية يسار و السفلي يمين"
                                                            bindingR2.s3erR2sAcx.setText("20")
                                                        } else {
                                                            if (bindingR2.outsideleft.isChecked && bindingR2.insideleft.isChecked) {
                                                                chhy2ahtow17.text =
                                                                    "كفة علوية يسار و السفلي يسار"
                                                                bindingR2.s3erR2sAcx.setText("20")
                                                            } else {
                                                                if (bindingR2.insideright.isChecked && bindingR2.insideleft.isChecked) {
                                                                    chhy2ahtow17.text =
                                                                        "كفة سفلي يمين و يسار"
                                                                    bindingR2.s3erR2sAcx.setText(
                                                                        "20"
                                                                    )
                                                                } else {
                                                                    if (bindingR2.outsideright.isChecked) {
                                                                        chhy2ahtow17.text =
                                                                            "كفة علوية يمين"
                                                                        bindingR2.s3erR2sAcx.setText(
                                                                            "10"
                                                                        )
                                                                    }
                                                                    if (bindingR2.outsideleft.isChecked) {
                                                                        chhy2ahtow17.text =
                                                                            "كفة علوية يسار"
                                                                        bindingR2.s3erR2sAcx.setText(
                                                                            "10"
                                                                        )
                                                                    }
                                                                    if (bindingR2.insideleft.isChecked) {
                                                                        chhy2ahtow17.text =
                                                                            "كفة سفلي يسار"
                                                                        bindingR2.s3erR2sAcx.setText(
                                                                            "10"
                                                                        )
                                                                    }
                                                                    if (bindingR2.insideright.isChecked) {
                                                                        chhy2ahtow17.text =
                                                                            "كفة سفلي يمين"
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

                    bindingR2.insideleft.setOnCheckedChangeListener { _ ,  isChecked2 ->
                        if (bindingR2.outsideright.isChecked) {
                            chhy2ahtow17.text = "كفة سفلي يمين"
                        } else {
                            chhy2ahtow17.text = "كفة سفلية"
                            bindingR2.s3erR2sAcx.setText("")
                        }
                        if (bindingR2.outsideright.isChecked && bindingR2.outsideleft.isChecked && bindingR2.insideright.isChecked && bindingR2.insideleft.isChecked) {
                            chhy2ahtow17.text = "تغير جميع الكفات العلويه و السفليه"
                            bindingR2.s3erR2sAcx.setText("40")
                        } else {
                            if (bindingR2.outsideright.isChecked && bindingR2.outsideleft.isChecked && bindingR2.insideright.isChecked) {
                                chhy2ahtow17.text = "كفة علوية كامل و السفلية يمين"
                                bindingR2.s3erR2sAcx.setText("30")
                            } else {
                                if (bindingR2.outsideright.isChecked && bindingR2.outsideleft.isChecked && bindingR2.insideleft.isChecked) {
                                    chhy2ahtow17.text = "كفة علوية كامل و السفلية يسار"
                                    bindingR2.s3erR2sAcx.setText("30")
                                } else {
                                    if (bindingR2.outsideright.isChecked && bindingR2.insideright.isChecked && bindingR2.insideleft.isChecked) {
                                        chhy2ahtow17.text = "كفة علوية يمين و السفلي كامل"
                                        bindingR2.s3erR2sAcx.setText("30")
                                    } else {
                                        if (bindingR2.outsideleft.isChecked && bindingR2.insideright.isChecked && bindingR2.insideleft.isChecked) {
                                            chhy2ahtow17.text = "كفة علوية يسار و السفلي كامل"
                                            bindingR2.s3erR2sAcx.setText("30")
                                        } else {
                                            if (bindingR2.outsideright.isChecked && bindingR2.outsideleft.isChecked) {
                                                chhy2ahtow17.text = "كفة علوية يمين و يسار"
                                                bindingR2.s3erR2sAcx.setText("20")
                                            } else {
                                                if (bindingR2.outsideright.isChecked && bindingR2.insideright.isChecked) {
                                                    chhy2ahtow17.text = "كفة علوية يمين و السفلي يمين"
                                                    bindingR2.s3erR2sAcx.setText("20")
                                                } else {
                                                    if (bindingR2.outsideright.isChecked && bindingR2.insideleft.isChecked) {
                                                        chhy2ahtow17.text = "كفة علوية يمين و السفلي يسار"
                                                        bindingR2.s3erR2sAcx.setText("20")
                                                    } else {
                                                        if (bindingR2.outsideleft.isChecked && bindingR2.insideright.isChecked) {
                                                            chhy2ahtow17.text =
                                                                "كفة علوية يسار و السفلي يمين"
                                                            bindingR2.s3erR2sAcx.setText("20")
                                                        } else {
                                                            if (bindingR2.outsideleft.isChecked && bindingR2.insideleft.isChecked) {
                                                                chhy2ahtow17.text =
                                                                    "كفة علوية يسار و السفلي يسار"
                                                                bindingR2.s3erR2sAcx.setText("20")
                                                            } else {
                                                                if (bindingR2.insideright.isChecked && bindingR2.insideleft.isChecked) {
                                                                    chhy2ahtow17.text =
                                                                        "كفة سفلي يمين و يسار"
                                                                    bindingR2.s3erR2sAcx.setText(
                                                                        "20"
                                                                    )
                                                                } else {
                                                                    if (bindingR2.outsideright.isChecked) {
                                                                        chhy2ahtow17.text =
                                                                            "كفة علوية يمين"
                                                                        bindingR2.s3erR2sAcx.setText(
                                                                            "10"
                                                                        )
                                                                    }
                                                                    if (bindingR2.outsideleft.isChecked) {
                                                                        chhy2ahtow17.text =
                                                                            "كفة علوية يسار"
                                                                        bindingR2.s3erR2sAcx.setText(
                                                                            "10"
                                                                        )
                                                                    }
                                                                    if (bindingR2.insideleft.isChecked) {
                                                                        chhy2ahtow17.text =
                                                                            "كفة سفلي يسار"
                                                                        bindingR2.s3erR2sAcx.setText(
                                                                            "10"
                                                                        )
                                                                    }
                                                                    if (bindingR2.insideright.isChecked) {
                                                                        chhy2ahtow17.text =
                                                                            "كفة سفلي يمين"
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

                    bindingR2.insideright.setOnCheckedChangeListener { _ ,  isChecked2 ->
                        if (bindingR2.insideright.isChecked) {
                            chhy2ahtow17.text = "كفة سفلي يسار"
                        } else {
                            chhy2ahtow17.text = "كفة علوية"
                            bindingR2.s3erR2sAcx.setText("")
                        }

                        if (bindingR2.outsideright.isChecked && bindingR2.outsideleft.isChecked && bindingR2.insideright.isChecked && bindingR2.insideleft.isChecked) {
                            chhy2ahtow17.text = "تغير جميع الكفات العلويه و السفليه"
                            bindingR2.s3erR2sAcx.setText("40")
                        } else {
                            if (bindingR2.outsideright.isChecked && bindingR2.outsideleft.isChecked && bindingR2.insideright.isChecked) {
                                chhy2ahtow17.text = "كفة علوية كامل و السفلية يمين"
                                bindingR2.s3erR2sAcx.setText("30")
                            } else {
                                if (bindingR2.outsideright.isChecked && bindingR2.outsideleft.isChecked && bindingR2.insideleft.isChecked) {
                                    chhy2ahtow17.text = "كفة علوية كامل و السفلية يسار"
                                    bindingR2.s3erR2sAcx.setText("30")
                                } else {
                                    if (bindingR2.outsideright.isChecked && bindingR2.insideright.isChecked && bindingR2.insideleft.isChecked) {
                                        chhy2ahtow17.text = "كفة علوية يمين و السفلي كامل"
                                        bindingR2.s3erR2sAcx.setText("30")
                                    } else {
                                        if (bindingR2.outsideleft.isChecked && bindingR2.insideright.isChecked && bindingR2.insideleft.isChecked) {
                                            chhy2ahtow17.text = "كفة علوية يسار و السفلي كامل"
                                            bindingR2.s3erR2sAcx.setText("30")
                                        } else {
                                            if (bindingR2.outsideright.isChecked && bindingR2.outsideleft.isChecked) {
                                                chhy2ahtow17.text = "كفة علوية يمين و يسار"
                                                bindingR2.s3erR2sAcx.setText("20")
                                            } else {
                                                if (bindingR2.outsideright.isChecked && bindingR2.insideright.isChecked) {
                                                    chhy2ahtow17.text = "كفة علوية يمين و السفلي يمين"
                                                    bindingR2.s3erR2sAcx.setText("20")
                                                } else {
                                                    if (bindingR2.outsideright.isChecked && bindingR2.insideleft.isChecked) {
                                                        chhy2ahtow17.text = "كفة علوية يمين و السفلي يسار"
                                                        bindingR2.s3erR2sAcx.setText("20")
                                                    } else {
                                                        if (bindingR2.outsideleft.isChecked && bindingR2.insideright.isChecked) {
                                                            chhy2ahtow17.text =
                                                                "كفة علوية يسار و السفلي يمين"
                                                            bindingR2.s3erR2sAcx.setText("20")
                                                        } else {
                                                            if (bindingR2.outsideleft.isChecked && bindingR2.insideleft.isChecked) {
                                                                chhy2ahtow17.text =
                                                                    "كفة علوية يسار و السفلي يسار"
                                                                bindingR2.s3erR2sAcx.setText("20")
                                                            } else {
                                                                if (bindingR2.insideright.isChecked && bindingR2.insideleft.isChecked) {
                                                                    chhy2ahtow17.text =
                                                                        "كفة سفلي يمين و يسار"
                                                                    bindingR2.s3erR2sAcx.setText(
                                                                        "20"
                                                                    )
                                                                } else {
                                                                    if (bindingR2.outsideright.isChecked) {
                                                                        chhy2ahtow17.text =
                                                                            "كفة علوية يمين"
                                                                        bindingR2.s3erR2sAcx.setText(
                                                                            "10"
                                                                        )
                                                                    }
                                                                    if (bindingR2.outsideleft.isChecked) {
                                                                        chhy2ahtow17.text =
                                                                            "كفة علوية يسار"
                                                                        bindingR2.s3erR2sAcx.setText(
                                                                            "10"
                                                                        )
                                                                    }
                                                                    if (bindingR2.insideleft.isChecked) {
                                                                        chhy2ahtow17.text =
                                                                            "كفة سفلي يسار"
                                                                        bindingR2.s3erR2sAcx.setText(
                                                                            "10"
                                                                        )
                                                                    }
                                                                    if (bindingR2.insideright.isChecked) {
                                                                        chhy2ahtow17.text =
                                                                            "كفة سفلي يمين"
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
                                prichy2ahtow17.text = bindingR2.s3erR2sAcx.text.toString()
                               customDialogR2SX.dismiss()
                            }
                        }
                    }
                    bindingR2.btnR2sCan.setOnClickListener {
                        if (prichy2ahtow17.text.toString().isEmpty()) {
                            chhy2ahtow17.text = "كفة"
                            chhy2ahtow17.isChecked = false
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
                        chhy2ahtow17.text = "كفة"
                        prichy2ahtow17.text = ""
                    }
            }
        }

        binding.apply{
            chhy2ahtow18.setOnCheckedChangeListener { _ ,  isChecked ->
                if (chhy2ahtow18.isChecked) {

                    val window = customDialogFR.window
                    window?.setGravity(Gravity.TOP)
                    val lp = window?.attributes
                    lp?.dimAmount = 0.0f
                    lp?.flags = lp?.flags?.or(WindowManager.LayoutParams.FLAG_DIM_BEHIND)
                    window?.attributes = lp

                    customDialogFR.window?.setFlags(WindowManager.LayoutParams.FLAG_SECURE, WindowManager.LayoutParams.FLAG_SECURE)

                    bindingFR.frontright.setOnCheckedChangeListener { _ ,  isChecked1 ->
                        if (bindingFR.frontright.isChecked) {
                            chhy2ahtow18.text =
                                "كفة H خلفية يمين"
                        } else {
                            chhy2ahtow18.text = "كفة H خلفية"
                            bindingFR.s3erYadwee.setText("")
                        }
                        if (bindingFR.frontright.isChecked && bindingFR.frontleft.isChecked) {
                            chhy2ahtow18.text = "كفة H خلفية يمين و يسار"
                            bindingFR.s3erYadwee.setText("40")
                        } else {
                            if (bindingFR.frontright.isChecked) {
                                chhy2ahtow18.text = "كفة H خلفية يمين"
                                bindingFR.s3erYadwee.setText("20")
                            }
                            if (bindingFR.frontleft.isChecked) {
                                chhy2ahtow18.text = "كفة H خلفية يسار"
                                bindingFR.s3erYadwee.setText("20")
                            }
                        }
                    }
                    bindingFR.frontleft.setOnCheckedChangeListener { _ ,  isChecked2 ->
                        if (bindingFR.frontleft.isChecked) {
                            chhy2ahtow18.text ="كفة H خلفية يسار"
                        }else{chhy2ahtow18.text =  "كفة H خلفية"
                            bindingFR.s3erYadwee.setText("")}
                        if (bindingFR.frontleft.isChecked && bindingFR.frontright.isChecked){
                            chhy2ahtow18.text = "كفة H خلفية يمين و يسار"
                            bindingFR.s3erYadwee.setText("40")
                        }else {
                            if (bindingFR.frontright.isChecked) {
                                chhy2ahtow18.text = "كفة H خلفية يمين"
                                bindingFR.s3erYadwee.setText("20")
                            }
                            if (bindingFR.frontleft.isChecked) {
                                chhy2ahtow18.text = "كفة H خلفية يسار"
                                bindingFR.s3erYadwee.setText("20")
                            }
                        }
                    }

                    bindingFR.buttonDailogSave.setOnClickListener {
                        if (!bindingFR.frontright.isChecked && !bindingFR.frontleft.isChecked) {
                            toast_notempty1.show()
                        } else {
                            val  aa=bindingFR.s3erYadwee.text.toString().trim()
                            if (aa.isEmpty()) {
                                toast_notempty.show()
                            } else {
                                prichy2ahtow18.text = bindingFR.s3erYadwee.text.toString()
                                customDialogFR.dismiss()
                            }
                        }
                    }
                    bindingFR.buttonDailogCancel.setOnClickListener {
                        chhy2ahtow18.isChecked = false
                        bindingFR.s3erYadwee.setText("")
                        customDialogFR.dismiss()
                    }
                    bindingFR.frontright.isChecked = false
                    bindingFR.frontleft.isChecked = false
                    customDialogFR.show()
                }
                else {
                    chhy2ahtow18.text = "كفة H خلفية"
                    prichy2ahtow18.text = ""
                }
            }
        }

        binding.apply{
            chhy2ahtow19.setOnCheckedChangeListener { _ ,  isChecked ->
                if (chhy2ahtow19.isChecked) {

                    val window = customDialogFR.window
                    window?.setGravity(Gravity.TOP)
                    val lp = window?.attributes
                    lp?.dimAmount = 0.0f
                    lp?.flags = lp?.flags?.or(WindowManager.LayoutParams.FLAG_DIM_BEHIND)
                    window?.attributes = lp

                    customDialogFR.window?.setFlags(WindowManager.LayoutParams.FLAG_SECURE, WindowManager.LayoutParams.FLAG_SECURE)

                    bindingFR.frontright.setOnCheckedChangeListener { _ ,  isChecked1 ->
                        if (bindingFR.frontright.isChecked) {
                            chhy2ahtow19.text =
                                "كفة خلفية عرضية يمين"
                        } else {
                            chhy2ahtow19.text = "كفة خلفية عرضية"
                            bindingFR.s3erYadwee.setText("")
                        }
                        if (bindingFR.frontright.isChecked && bindingFR.frontleft.isChecked) {
                            chhy2ahtow19.text = "كفة خلفية عرضية يمين و يسار"
                            bindingFR.s3erYadwee.setText("20")
                        } else {
                            if (bindingFR.frontright.isChecked) {
                                chhy2ahtow19.text = "كفة خلفية عرضية يمين"
                                bindingFR.s3erYadwee.setText("10")
                            }
                            if (bindingFR.frontleft.isChecked) {
                                chhy2ahtow19.text = "كفة خلفية عرضية يسار"
                                bindingFR.s3erYadwee.setText("10")
                            }
                        }
                    }
                    bindingFR.frontleft.setOnCheckedChangeListener { _ ,  isChecked2 ->
                        if (bindingFR.frontleft.isChecked) {
                            chhy2ahtow19.text ="كفة خلفية عرضية يسار"
                        }else{chhy2ahtow19.text =  "كفة خلفية عرضية"
                            bindingFR.s3erYadwee.setText("")}
                        if (bindingFR.frontleft.isChecked && bindingFR.frontright.isChecked){
                            chhy2ahtow19.text = "كفة خلفية عرضية يمين و يسار"
                            bindingFR.s3erYadwee.setText("20")
                        }else {
                            if (bindingFR.frontright.isChecked) {
                                chhy2ahtow19.text = "كفة خلفية عرضية يمين"
                                bindingFR.s3erYadwee.setText("10")
                            }
                            if (bindingFR.frontleft.isChecked) {
                                chhy2ahtow19.text = "كفة خلفية عرضية يسار"
                                bindingFR.s3erYadwee.setText("10")
                            }
                        }
                    }

                    bindingFR.buttonDailogSave.setOnClickListener {
                        if (!bindingFR.frontright.isChecked && !bindingFR.frontleft.isChecked) {
                            toast_notempty1.show()
                        } else {
                            val  aa=bindingFR.s3erYadwee.text.toString().trim()
                            if (aa.isEmpty()) {
                                toast_notempty.show()
                            } else {
                                prichy2ahtow19.text = bindingFR.s3erYadwee.text.toString()
                               customDialogFR.dismiss()
                            }
                        }
                    }
                    bindingFR.buttonDailogCancel.setOnClickListener {
                        chhy2ahtow19.isChecked = false
                        bindingFR.s3erYadwee.setText("")
                        customDialogFR.dismiss()
                    }
                    bindingFR.frontright.isChecked = false
                    bindingFR.frontleft.isChecked = false
                    customDialogFR.show()
                }
                else {
                   chhy2ahtow19.text = "كفة خلفية عرضية"
                    prichy2ahtow19.text = ""
                }
            }
        }

        binding.apply{
            chhy2ahtow20.setOnCheckedChangeListener { _ ,  isChecked ->
                if (chhy2ahtow20.isChecked) {
                    val window = customDialogFR.window
                    window?.setGravity(Gravity.TOP)
                    val lp = window?.attributes
                    lp?.dimAmount = 0.0f
                    lp?.flags = lp?.flags?.or(WindowManager.LayoutParams.FLAG_DIM_BEHIND)
                    window?.attributes = lp

                    customDialogFR.window?.setFlags(WindowManager.LayoutParams.FLAG_SECURE, WindowManager.LayoutParams.FLAG_SECURE)

                    bindingFR.frontright.setOnCheckedChangeListener { _ ,  isChecked1 ->
                        if (bindingFR.frontright.isChecked) {
                            chhy2ahtow20.text =
                                "كفة قرن علوية خلفية يمين"
                        } else {
                            chhy2ahtow20.text = "كفة قرن علوية خلفية"
                            bindingFR.s3erYadwee.setText("")
                        }
                        if (bindingFR.frontright.isChecked && bindingFR.frontleft.isChecked) {
                            chhy2ahtow20.text = "كفة قرن علوية خلفية يمين و يسار"
                            bindingFR.s3erYadwee.setText("20")
                        } else {
                            if (bindingFR.frontright.isChecked) {
                                chhy2ahtow20.text = "كفة قرن علوية خلفية يمين"
                                bindingFR.s3erYadwee.setText("10")
                            }
                            if (bindingFR.frontleft.isChecked) {
                                chhy2ahtow20.text = "كفة قرن علوية خلفية يسار"
                                bindingFR.s3erYadwee.setText("10")
                            }
                        }
                    }
                    bindingFR.frontleft.setOnCheckedChangeListener { _ ,  isChecked2 ->
                        if (bindingFR.frontleft.isChecked) {
                            chhy2ahtow20.text ="كفة قرن علوية خلفية يسار"
                        }else{chhy2ahtow20.text =  "كفة قرن علوية خلفية"
                            bindingFR.s3erYadwee.setText("")}

                        if (bindingFR.frontleft.isChecked && bindingFR.frontright.isChecked){
                            chhy2ahtow20.text = "كفة قرن علوية خلفية يمين و يسار"
                            bindingFR.s3erYadwee.setText("20")
                        }else {
                            if (bindingFR.frontright.isChecked) {
                                chhy2ahtow20.text = "كفة قرن علوية خلفية يمين"
                                bindingFR.s3erYadwee.setText("10")
                            }
                            if (bindingFR.frontleft.isChecked) {
                                chhy2ahtow20.text = "كفة قرن علوية خلفية يسار"
                                bindingFR.s3erYadwee.setText("10")
                            }
                        }
                    }

                    bindingFR.buttonDailogSave.setOnClickListener {
                        if (!bindingFR.frontright.isChecked && !bindingFR.frontleft.isChecked) {
                            toast_notempty1.show()
                        } else {
                            val  aa=bindingFR.s3erYadwee.text.toString().trim()
                            if (aa.isEmpty()) {
                                toast_notempty.show()
                            } else {
                                prichy2ahtow20.text = bindingFR.s3erYadwee.text.toString()
                               customDialogFR.dismiss()
                            }
                        }
                    }
                    bindingFR.buttonDailogCancel.setOnClickListener {
                        chhy2ahtow20.isChecked = false
                        bindingFR.s3erYadwee.setText("")
                        customDialogFR.dismiss()
                    }
                    bindingFR.frontright.isChecked = false
                    bindingFR.frontleft.isChecked = false
                    customDialogFR.show()
                }
                else {
                   chhy2ahtow20.text = "كفة قرن علوية خلفية"
                    prichy2ahtow20.text = ""
                }
            }
        }

        binding.apply{
            chhy2ahtow21.setOnCheckedChangeListener { _ ,  isChecked ->
                if (chhy2ahtow21.isChecked) {

                    customDialogMZ.window?.setFlags(WindowManager.LayoutParams.FLAG_SECURE, WindowManager.LayoutParams.FLAG_SECURE)
                    bindingMZ.s3erYadweeFa7.setText("5")
                    bindingMZ.btnSvDigFa7.setOnClickListener {
                        if (bindingMZ.s3erYadweeFa7.text.toString().isEmpty()) {
                            toast_notempty.show()
                        } else {
                            prichy2ahtow21.text = bindingMZ.s3erYadweeFa7.text.toString()
                           customDialogMZ.dismiss()
                        }
                    }
                    bindingMZ.btnCnDigMz.setOnClickListener {
                        chhy2ahtow21.isChecked = false
                        bindingMZ.s3erYadweeFa7.setText("")
                        customDialogMZ.dismiss()
                    }
                    bindingMZ.front.isChecked = false
                    bindingMZ.rear.isChecked = false
                    customDialogMZ.show()
                } else {
                   prichy2ahtow21.text = ""
                }
            }
        }

        binding.apply {
            chhy2ahtow22.setOnCheckedChangeListener { _, isChecked ->
                if (chhy2ahtow22.isChecked) {

                    customDialogMZ.window?.setFlags(
                        WindowManager.LayoutParams.FLAG_SECURE,
                        WindowManager.LayoutParams.FLAG_SECURE
                    )
                    bindingMZ.s3erYadweeFa7.setText("5")
                    bindingMZ.btnSvDigFa7.setOnClickListener {
                        if (bindingMZ.s3erYadweeFa7.text.toString().isEmpty()) {
                            toast_notempty.show()
                        } else {
                            prichy2ahtow22.text = bindingMZ.s3erYadweeFa7.text.toString()
                           customDialogMZ.dismiss()
                        }
                    }
                    bindingMZ.btnCnDigMz.setOnClickListener {
                        chhy2ahtow22.isChecked = false
                        bindingMZ.s3erYadweeFa7.setText("")
                        customDialogMZ.dismiss()
                    }
                    bindingMZ.front.isChecked = false
                    bindingMZ.rear.isChecked = false
                    customDialogMZ.show()
                } else {
                   prichy2ahtow22.text = ""
                }
            }
        }

        for (i in 1..22) {
            val editTextName = "prichy2ahtow$i"
            val editText =
                binding::class.java.getDeclaredField(editTextName).get(binding) as TextView
            editTextList.add(editText)
            val checkBoxName = "chhy2ahtow$i"
            val checkBox =
                binding::class.java.getDeclaredField(checkBoxName).get(binding) as CheckBox
            checkBoxList.add(checkBox)
            A = i - 1
            binding.savehy2ah2.setOnClickListener {
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
                            val variableNamepric = "prichy2ahtow${i + 1}"
                            contentMessage2[variableNamepric] = editTextList[i].text.toString()
                            contentMessage2["totalhy2ah2"] = hy2ahModel.totalAmount2
                            chatChannelsCollectionRef.document(viewModeleEstqbal.myData1)
                                .collection("messages")
                                .document(viewModeleEstqbal.myData2)
                                .update(contentMessage2)
                        }
                        else{
                            val variableDelNamepric =hashMapOf<String, Any>( "prichy2ahtow${i + 1}" to FieldValue.delete())
                            chatChannelsCollectionRef.document(viewModeleEstqbal.myData1)
                                .collection("messages")
                                .document(viewModeleEstqbal.myData2)
                                .update(variableDelNamepric)
                        }
                    }

                    for (i in 0 until checkBoxList.size) {
                        if (checkBoxList[i].isChecked) {
                            val variableName = "chhy2ahtow${i + 1}"
                            contentMessage2[variableName] = checkBoxList[i].text.toString()
                            chatChannelsCollectionRef.document(viewModeleEstqbal.myData1)
                                .collection("messages")
                                .document(viewModeleEstqbal.myData2)
                                .update(contentMessage2)
                        }
                        else{
                            val variableDelName =hashMapOf<String, Any>( "chhy2ahtow${i + 1}" to FieldValue.delete())
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
                        totalAmount = editTextList.filter { it.text.isNotEmpty() }.sumOf { it.text.toString().toInt() }
                        hy2ahModel.totalAmount2 = totalAmount.toString()
                        toolbar?.title = "مجموع قائمة الهيئة2 : " + hy2ahModel.totalAmount2
                    }else{
                        totalAmount = editTextList.filter { it.text.isNotEmpty() }.sumOf { it.text.toString().toInt() }
                        hy2ahModel.totalAmount2 = totalAmount.toString()
                        toolbar?.title = "مجموع قائمة الهيئة2 : " + hy2ahModel.totalAmount2
                    }
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

        hy2ah2Model.chhy2ahtow1 = binding.chhy2ahtow1.isChecked
        hy2ah2Model.chhy2ahtow2 = binding.chhy2ahtow2.isChecked
        hy2ah2Model.chhy2ahtow3 = binding.chhy2ahtow3.isChecked
        hy2ah2Model.chhy2ahtow4 = binding.chhy2ahtow4.isChecked
        hy2ah2Model.chhy2ahtow5 = binding.chhy2ahtow5.isChecked
        hy2ah2Model.chhy2ahtow6 = binding.chhy2ahtow6.isChecked
        hy2ah2Model.chhy2ahtow7 = binding.chhy2ahtow7.isChecked
        hy2ah2Model.chhy2ahtow8 = binding.chhy2ahtow8.isChecked
        hy2ah2Model.chhy2ahtow9 = binding.chhy2ahtow9.isChecked
        hy2ah2Model.chhy2ahtow10 = binding.chhy2ahtow10.isChecked
        hy2ah2Model.chhy2ahtow11 = binding.chhy2ahtow11.isChecked
        hy2ah2Model.chhy2ahtow12 = binding.chhy2ahtow12.isChecked
        hy2ah2Model.chhy2ahtow13 = binding.chhy2ahtow13.isChecked
        hy2ah2Model.chhy2ahtow14 = binding.chhy2ahtow14.isChecked
        hy2ah2Model.chhy2ahtow15 = binding.chhy2ahtow15.isChecked
        hy2ah2Model.chhy2ahtow16 = binding.chhy2ahtow16.isChecked
        hy2ah2Model.chhy2ahtow17 = binding.chhy2ahtow17.isChecked
        hy2ah2Model.chhy2ahtow18 = binding.chhy2ahtow18.isChecked
        hy2ah2Model.chhy2ahtow19 = binding.chhy2ahtow19.isChecked
        hy2ah2Model.chhy2ahtow20 = binding.chhy2ahtow20.isChecked
        hy2ah2Model.chhy2ahtow21 = binding.chhy2ahtow21.isChecked
        hy2ah2Model.chhy2ahtow22 = binding.chhy2ahtow22.isChecked

//
        hy2ah2Model.chtext1 = binding.chhy2ahtow1.text.toString()
        hy2ah2Model.chtext2 = binding.chhy2ahtow2.text.toString()
        hy2ah2Model.chtext3 = binding.chhy2ahtow3.text.toString()
        hy2ah2Model.chtext4 = binding.chhy2ahtow4.text.toString()
        hy2ah2Model.chtext5 = binding.chhy2ahtow5.text.toString()
        hy2ah2Model.chtext6 = binding.chhy2ahtow6.text.toString()
        hy2ah2Model.chtext7 = binding.chhy2ahtow7.text.toString()
        hy2ah2Model.chtext8 = binding.chhy2ahtow8.text.toString()
        hy2ah2Model.chtext9 = binding.chhy2ahtow9.text.toString()
        hy2ah2Model.chtext10 = binding.chhy2ahtow10.text.toString()
        hy2ah2Model.chtext11 = binding.chhy2ahtow11.text.toString()
        hy2ah2Model.chtext12 = binding.chhy2ahtow12.text.toString()
        hy2ah2Model.chtext13 = binding.chhy2ahtow13.text.toString()
        hy2ah2Model.chtext14 = binding.chhy2ahtow14.text.toString()
        hy2ah2Model.chtext15 = binding.chhy2ahtow15.text.toString()
        hy2ah2Model.chtext16 = binding.chhy2ahtow16.text.toString()
        hy2ah2Model.chtext17 = binding.chhy2ahtow17.text.toString()
        hy2ah2Model.chtext18 = binding.chhy2ahtow18.text.toString()
        hy2ah2Model.chtext19 = binding.chhy2ahtow19.text.toString()
        hy2ah2Model.chtext20 = binding.chhy2ahtow20.text.toString()
        hy2ah2Model.chtext21 = binding.chhy2ahtow21.text.toString()
        hy2ah2Model.chtext22 = binding.chhy2ahtow22.text.toString()

        hy2ah2Model.prichy2ahtow1 = binding.prichy2ahtow1.text.toString()
        hy2ah2Model.prichy2ahtow2 = binding.prichy2ahtow2.text.toString()
        hy2ah2Model.prichy2ahtow3 = binding.prichy2ahtow3.text.toString()
        hy2ah2Model.prichy2ahtow4 = binding.prichy2ahtow4.text.toString()
        hy2ah2Model.prichy2ahtow5 = binding.prichy2ahtow5.text.toString()
        hy2ah2Model.prichy2ahtow6 = binding.prichy2ahtow6.text.toString()
        hy2ah2Model.prichy2ahtow7 = binding.prichy2ahtow7.text.toString()
        hy2ah2Model.prichy2ahtow8 = binding.prichy2ahtow8.text.toString()
        hy2ah2Model.prichy2ahtow9 = binding.prichy2ahtow9.text.toString()
        hy2ah2Model.prichy2ahtow10 = binding.prichy2ahtow10.text.toString()
        hy2ah2Model.prichy2ahtow11 = binding.prichy2ahtow11.text.toString()
        hy2ah2Model.prichy2ahtow12 = binding.prichy2ahtow12.text.toString()
        hy2ah2Model.prichy2ahtow13 = binding.prichy2ahtow13.text.toString()
        hy2ah2Model.prichy2ahtow14 = binding.prichy2ahtow14.text.toString()
        hy2ah2Model.prichy2ahtow15 = binding.prichy2ahtow15.text.toString()
        hy2ah2Model.prichy2ahtow16 = binding.prichy2ahtow16.text.toString()
        hy2ah2Model.prichy2ahtow17 = binding.prichy2ahtow17.text.toString()
        hy2ah2Model.prichy2ahtow18 = binding.prichy2ahtow18.text.toString()
        hy2ah2Model.prichy2ahtow19 = binding.prichy2ahtow19.text.toString()
        hy2ah2Model.prichy2ahtow20 = binding.prichy2ahtow20.text.toString()
        hy2ah2Model.prichy2ahtow21 = binding.prichy2ahtow21.text.toString()
        hy2ah2Model.prichy2ahtow22 = binding.prichy2ahtow22.text.toString()
        hy2ahModel.totalAmount2 = totalAmount.toString()
//        for (i in 0 until 22) {
//            hy2ah2Model.chtexts[i] = checkBoxList[A].text.toString()
//        }
    }

    private fun loadCheckBoxes() {


        binding.chhy2ahtow1.isChecked = hy2ah2Model.chhy2ahtow1
        binding.chhy2ahtow2.isChecked = hy2ah2Model.chhy2ahtow2
        binding.chhy2ahtow3.isChecked = hy2ah2Model.chhy2ahtow3
        binding.chhy2ahtow4.isChecked = hy2ah2Model.chhy2ahtow4
        binding.chhy2ahtow5.isChecked = hy2ah2Model.chhy2ahtow5
        binding.chhy2ahtow6.isChecked = hy2ah2Model.chhy2ahtow6
        binding.chhy2ahtow7.isChecked = hy2ah2Model.chhy2ahtow7
        binding.chhy2ahtow8.isChecked = hy2ah2Model.chhy2ahtow8
        binding.chhy2ahtow9.isChecked = hy2ah2Model.chhy2ahtow9
        binding.chhy2ahtow10.isChecked = hy2ah2Model.chhy2ahtow10
        binding.chhy2ahtow11.isChecked = hy2ah2Model.chhy2ahtow11
        binding.chhy2ahtow12.isChecked = hy2ah2Model.chhy2ahtow12
        binding.chhy2ahtow13.isChecked = hy2ah2Model.chhy2ahtow13
        binding.chhy2ahtow14.isChecked = hy2ah2Model.chhy2ahtow14
        binding.chhy2ahtow15.isChecked = hy2ah2Model.chhy2ahtow15
        binding.chhy2ahtow16.isChecked = hy2ah2Model.chhy2ahtow16
        binding.chhy2ahtow17.isChecked = hy2ah2Model.chhy2ahtow17
        binding.chhy2ahtow18.isChecked = hy2ah2Model.chhy2ahtow18
        binding.chhy2ahtow19.isChecked = hy2ah2Model.chhy2ahtow19
        binding.chhy2ahtow20.isChecked = hy2ah2Model.chhy2ahtow20
        binding.chhy2ahtow21.isChecked = hy2ah2Model.chhy2ahtow21
        binding.chhy2ahtow22.isChecked = hy2ah2Model.chhy2ahtow22


        binding.chhy2ahtow1.text = hy2ah2Model.chtext1
        binding.chhy2ahtow2.text = hy2ah2Model.chtext2
        binding.chhy2ahtow3.text = hy2ah2Model.chtext3
        binding.chhy2ahtow4.text = hy2ah2Model.chtext4
        binding.chhy2ahtow5.text = hy2ah2Model.chtext5
        binding.chhy2ahtow6.text = hy2ah2Model.chtext6
        binding.chhy2ahtow7.text = hy2ah2Model.chtext7
        binding.chhy2ahtow8.text = hy2ah2Model.chtext8
        binding.chhy2ahtow9.text = hy2ah2Model.chtext9
        binding.chhy2ahtow10.text = hy2ah2Model.chtext10
        binding.chhy2ahtow11.text = hy2ah2Model.chtext11
        binding.chhy2ahtow12.text = hy2ah2Model.chtext12
        binding.chhy2ahtow13.text = hy2ah2Model.chtext13
        binding.chhy2ahtow14.text = hy2ah2Model.chtext14
        binding.chhy2ahtow15.text = hy2ah2Model.chtext15
        binding.chhy2ahtow16.text = hy2ah2Model.chtext16
        binding.chhy2ahtow17.text = hy2ah2Model.chtext17
        binding.chhy2ahtow18.text = hy2ah2Model.chtext18
        binding.chhy2ahtow19.text = hy2ah2Model.chtext19
        binding.chhy2ahtow20.text = hy2ah2Model.chtext20
        binding.chhy2ahtow21.text = hy2ah2Model.chtext21
        binding.chhy2ahtow22.text = hy2ah2Model.chtext22

//
//        for (i in 0 until 22) {
//            editTextList[A].text = hy2ah2Model.prichy2ahtow[i]
//        }

        binding.prichy2ahtow1.text = hy2ah2Model.prichy2ahtow1
        binding.prichy2ahtow2.text = hy2ah2Model.prichy2ahtow2
        binding.prichy2ahtow3.text = hy2ah2Model.prichy2ahtow3
        binding.prichy2ahtow4.text = hy2ah2Model.prichy2ahtow4
        binding.prichy2ahtow5.text = hy2ah2Model.prichy2ahtow5
        binding.prichy2ahtow6.text = hy2ah2Model.prichy2ahtow6
        binding.prichy2ahtow7.text = hy2ah2Model.prichy2ahtow7
        binding.prichy2ahtow8.text = hy2ah2Model.prichy2ahtow8
        binding.prichy2ahtow9.text = hy2ah2Model.prichy2ahtow9
        binding.prichy2ahtow10.text = hy2ah2Model.prichy2ahtow10
        binding.prichy2ahtow11.text = hy2ah2Model.prichy2ahtow11
        binding.prichy2ahtow12.text = hy2ah2Model.prichy2ahtow12
        binding.prichy2ahtow13.text = hy2ah2Model.prichy2ahtow13
        binding.prichy2ahtow14.text = hy2ah2Model.prichy2ahtow14
        binding.prichy2ahtow15.text = hy2ah2Model.prichy2ahtow15
        binding.prichy2ahtow16.text = hy2ah2Model.prichy2ahtow16
        binding.prichy2ahtow17.text = hy2ah2Model.prichy2ahtow17
        binding.prichy2ahtow18.text = hy2ah2Model.prichy2ahtow18
        binding.prichy2ahtow19.text = hy2ah2Model.prichy2ahtow19
        binding.prichy2ahtow20.text = hy2ah2Model.prichy2ahtow20
        binding.prichy2ahtow21.text = hy2ah2Model.prichy2ahtow21
        binding.prichy2ahtow22.text = hy2ah2Model.prichy2ahtow22

        val toolbar = activity?.findViewById<Toolbar>(R.id.toolbar)
        toolbar?.setTitleTextAppearance(this.context, R.style.boldText)
        toolbar?.title = hy2ahModel.totalAmount2

//        for (i in 0 until 22) {
//            checkBoxList[A].text = hy2ah2Model.chtexts[i]
//        }

        customDialogMZ.dismiss()
        customDialogF79.dismiss()
        customDialogR2SX.dismiss()
        customDialogBRK.dismiss()
        customDialogFR.dismiss()
        customDialogBL6.dismiss()
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