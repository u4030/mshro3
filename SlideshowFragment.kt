package com.example.mizanalnasr.ui.slideshow

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
import android.widget.Toast
import com.example.mizanalnasr.R
import com.example.mizanalnasr.databinding.FragmentSlideshowBinding
import com.example.mizanalnasr.ui.first.FirstViewModel
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.dialog_mezan.*
import kotlinx.android.synthetic.main.fragment_slideshow.*
import kotlinx.android.synthetic.main.fragment_slideshow.view.*
import kotlinx.android.synthetic.main.front_dailog.*
import kotlinx.android.synthetic.main.r2syet_2ks_dailog.*

class SlideshowFragment : Fragment() {
    private lateinit var viewModel: FirstViewModel

    private var _binding: FragmentSlideshowBinding? = null

    private val binding get() = _binding!!

    private val firestoreInstance: FirebaseFirestore by lazy { FirebaseFirestore.getInstance()}
    private val chatChannelsCollectionRef = firestoreInstance.collection("chatChannels")

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentSlideshowBinding.inflate(inflater, container, false)
        val root: View = binding.root

        viewModel = activity?.run {
            ViewModelProviders.of(this).get(FirstViewModel::class.java)
        } ?: throw Exception("Invalid Activity")

        var cash_paying1 = ""
        var cash_price11 = ""
        var wallet1 = ""
        var wallet_price1 = ""
        var credit1 = ""
        var credit_price1 = ""
        var Discount1 = ""
        var Discount_pricec1 = ""
        var receivables1 = ""
        var receivables_price1 = ""

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

        root.ch_2_1.setOnCheckedChangeListener { _, isChecked ->
            if (ch_2_1.isChecked) {
                val customDialogFB = Dialog(activity!!)
                customDialogFB.setContentView(R.layout.front_dailog)
                customDialogFB.setCancelable(false)
                customDialogFB.window?.setLayout(
                    ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT)

                customDialogFB.frontright.setOnCheckedChangeListener { _, isChecked1 ->
                    if (customDialogFB.frontright.isChecked) {
                        ch_2_1.text =
                            "بكس كفة خلفية عرضية يمين"
                    } else {
                        ch_2_1.text = "بكس كفة خلفية عرضية"
                        customDialogFB.s3er_yadwee.setText("")
                    }

                    if (customDialogFB.frontright.isChecked && customDialogFB.frontleft.isChecked) {
                        ch_2_1.text = "بكس كفة خلفية عرضية يمين و يسار"
                        customDialogFB.s3er_yadwee.setText("20")
                    } else {
                        if (customDialogFB.frontright.isChecked) {
                            ch_2_1.text = "بكس كفة خلفية عرضية يمين"
                            customDialogFB.s3er_yadwee.setText("10")
                        }
                        if (customDialogFB.frontleft.isChecked) {
                            ch_2_1.text = "بكس كفة خلفية عرضية يسار"
                            customDialogFB.s3er_yadwee.setText("10")
                        }
                    }
                }
                customDialogFB.frontleft.setOnCheckedChangeListener { _, isChecked2 ->
                    if (customDialogFB.frontleft.isChecked) {
                        ch_2_1.text ="بكس كفة خلفية عرضية يسار"
                    }else{ch_2_1.text = "بكس كفة خلفية عرضية"
                        customDialogFB.s3er_yadwee.setText("")}

                    if (customDialogFB.frontleft.isChecked && customDialogFB.frontright.isChecked){
                        ch_2_1.text = "بكس كفة خلفية عرضية يمين و يسار"
                        customDialogFB.s3er_yadwee.setText("20")
                    }else {
                        if (customDialogFB.frontright.isChecked) {
                            ch_2_1.text = "بكس كفة خلفية عرضية يمين"
                            customDialogFB.s3er_yadwee.setText("10")
                        }
                        if (customDialogFB.frontleft.isChecked) {
                            ch_2_1.text = "بكس كفة خلفية عرضية يسار"
                            customDialogFB.s3er_yadwee.setText("10")
                        }
                    }

                }

                customDialogFB.button_dailog_save.setOnClickListener {
                    if (!customDialogFB.frontright.isChecked && !customDialogFB.frontleft.isChecked) {
                        toast_notempty1.show()
                    } else {
                        val  aa=customDialogFB.s3er_yadwee.text.toString().trim()
                        if (aa.isEmpty()) {
                            toast_notempty.show()
                        } else {
                            p_p_2_1.text = customDialogFB.s3er_yadwee.text.toString()
                            viewModel.totalAmount += p_p_2_1.text.toString().toInt()
                            toolbar?.title = "المجموع " + viewModel.totalAmount.toString()
                            customDialogFB.dismiss()
                        }
                    }
                }
                customDialogFB.button_dailog_cancel.setOnClickListener {
                    ch_2_1.isChecked = false
                    customDialogFB.button_dailog_cancel.setText("")
                    customDialogFB.dismiss()
                }
                customDialogFB.show()
            }
            else {
                if (p_p_2_1.text.toString().isNotEmpty()){
                    viewModel.totalAmount -= p_p_2_1.text.toString().toInt()
                    toolbar?.title = "المجموع " + viewModel.totalAmount.toString()
                    p_p_2_1.text = ""}
                ch_2_1.text = "بكس كفة خلفية عرضية"
            }
        }

        root.ch_2_2.setOnCheckedChangeListener { _, isChecked ->
            if (ch_2_2.isChecked) {
                val customDialogFB = Dialog(activity!!)
                customDialogFB.setContentView(R.layout.front_dailog)
                customDialogFB.setCancelable(false)
                customDialogFB.window?.setLayout(
                    ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT)

                customDialogFB.frontright.setOnCheckedChangeListener { _, isChecked1 ->
                    if (customDialogFB.frontright.isChecked) {
                        ch_2_2.text =
                            "بكس كفة معاير خلفي يمين"
                    } else {
                        ch_2_2.text = "بكس كفة معاير خلفي"
                        customDialogFB.s3er_yadwee.setText("")
                    }

                    if (customDialogFB.frontright.isChecked && customDialogFB.frontleft.isChecked) {
                        ch_2_2.text = "بكس كفة معاير خلفي يمين و يسار"
                        customDialogFB.s3er_yadwee.setText("10")
                    } else {
                        if (customDialogFB.frontright.isChecked) {
                            ch_2_2.text = "بكس كفة معاير خلفي يمين"
                            customDialogFB.s3er_yadwee.setText("5")
                        }
                        if (customDialogFB.frontleft.isChecked) {
                            ch_2_2.text = "بكس كفة معاير خلفي يسار"
                            customDialogFB.s3er_yadwee.setText("5")
                        }
                    }
                }
                customDialogFB.frontleft.setOnCheckedChangeListener { _, isChecked2 ->
                    if (customDialogFB.frontleft.isChecked) {
                        ch_2_2.text ="بكس كفة معاير خلفي يسار"
                    }else{ch_2_2.text = "بكس كفة معاير خلفي"
                        customDialogFB.s3er_yadwee.setText("")}

                    if (customDialogFB.frontleft.isChecked && customDialogFB.frontright.isChecked){
                        ch_2_2.text = "بكس كفة معاير خلفي يمين و يسار"
                        customDialogFB.s3er_yadwee.setText("10")
                    }else {
                        if (customDialogFB.frontright.isChecked) {
                            ch_2_2.text = "بكس كفة معاير خلفي يمين"
                            customDialogFB.s3er_yadwee.setText("5")
                        }
                        if (customDialogFB.frontleft.isChecked) {
                            ch_2_2.text = "بكس كفة معاير خلفي يسار"
                            customDialogFB.s3er_yadwee.setText("5")
                        }
                    }

                }

                customDialogFB.button_dailog_save.setOnClickListener {
                    if (!customDialogFB.frontright.isChecked && !customDialogFB.frontleft.isChecked) {
                        toast_notempty1.show()
                    } else {
                        val  aa=customDialogFB.s3er_yadwee.text.toString().trim()
                        if (aa.isEmpty()) {
                            toast_notempty.show()
                        } else {
                            p_p_2_2.text = customDialogFB.s3er_yadwee.text.toString()
                            viewModel.totalAmount += p_p_2_2.text.toString().toInt()
                            toolbar?.title = "المجموع " + viewModel.totalAmount.toString()
                            customDialogFB.dismiss()
                        }
                    }
                }
                customDialogFB.button_dailog_cancel.setOnClickListener {
                    ch_2_2.isChecked = false
                    customDialogFB.button_dailog_cancel.setText("")
                    customDialogFB.dismiss()
                }
                customDialogFB.show()
            }
            else {
                if (p_p_2_2.text.toString().isNotEmpty()){
                    viewModel.totalAmount -= p_p_2_2.text.toString().toInt()
                    toolbar?.title = "المجموع " + viewModel.totalAmount.toString()
                    p_p_2_2.text = ""}
                ch_2_2.text = "بكس كفة معاير خلفي"
            }
        }

        root.ch_2_3.setOnCheckedChangeListener { _, isChecked ->
            if (ch_2_3.isChecked) {
                val customDialogFB = Dialog(activity!!)
                customDialogFB.setContentView(R.layout.front_dailog)
                customDialogFB.setCancelable(false)
                customDialogFB.window?.setLayout(
                    ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT)

                customDialogFB.frontright.setOnCheckedChangeListener { _, isChecked1 ->
                    if (customDialogFB.frontright.isChecked) {
                        ch_2_3.text =
                            "بكس كفة سفلية الأمامي يمين"
                    } else {
                        ch_2_3.text = "بكس كفة سفلية الأمامي"
                        customDialogFB.s3er_yadwee.setText("")
                    }

                    if (customDialogFB.frontright.isChecked && customDialogFB.frontleft.isChecked) {
                        ch_2_3.text = "بكس كفة سفلية الأمامي يمين و يسار"
                        customDialogFB.s3er_yadwee.setText("16")
                    } else {
                        if (customDialogFB.frontright.isChecked) {
                            ch_2_3.text = "بكس كفة سفلية الأمامي يمين"
                            customDialogFB.s3er_yadwee.setText("8")
                        }
                        if (customDialogFB.frontleft.isChecked) {
                            ch_2_3.text = "بكس كفة سفلية الأمامي يسار"
                            customDialogFB.s3er_yadwee.setText("8")
                        }
                    }
                }
                customDialogFB.frontleft.setOnCheckedChangeListener { _, isChecked2 ->
                    if (customDialogFB.frontleft.isChecked) {
                        ch_2_3.text ="بكس كفة سفلية الأمامي يسار"
                    }else{ch_2_3.text = "بكس كفة سفلية الأمامي"
                        customDialogFB.s3er_yadwee.setText("")}

                    if (customDialogFB.frontleft.isChecked && customDialogFB.frontright.isChecked){
                        ch_2_3.text = "بكس كفة سفلية الأمامي يمين و يسار"
                        customDialogFB.s3er_yadwee.setText("16")
                    }else {
                        if (customDialogFB.frontright.isChecked) {
                            ch_2_3.text = "بكس كفة سفلية الأمامي يمين"
                            customDialogFB.s3er_yadwee.setText("8")
                        }
                        if (customDialogFB.frontleft.isChecked) {
                            ch_2_3.text = "بكس كفة سفلية الأمامي يسار"
                            customDialogFB.s3er_yadwee.setText("8")
                        }
                    }

                }

                customDialogFB.button_dailog_save.setOnClickListener {
                    if (!customDialogFB.frontright.isChecked && !customDialogFB.frontleft.isChecked) {
                        toast_notempty1.show()
                    } else {
                        val  aa=customDialogFB.s3er_yadwee.text.toString().trim()
                        if (aa.isEmpty()) {
                            toast_notempty.show()
                        } else {
                            p_p_2_3.text = customDialogFB.s3er_yadwee.text.toString()
                            viewModel.totalAmount += p_p_2_3.text.toString().toInt()
                            toolbar?.title = "المجموع " + viewModel.totalAmount.toString()
                            customDialogFB.dismiss()
                        }
                    }
                }
                customDialogFB.button_dailog_cancel.setOnClickListener {
                    ch_2_3.isChecked = false
                    customDialogFB.button_dailog_cancel.setText("")
                    customDialogFB.dismiss()
                }
                customDialogFB.show()
            }
            else {
                if (p_p_2_3.text.toString().isNotEmpty()){
                    viewModel.totalAmount -= p_p_2_3.text.toString().toInt()
                    toolbar?.title = "المجموع " + viewModel.totalAmount.toString()
                    p_p_2_3.text = ""}
                ch_2_3.text = "بكس كفة سفلية الأمامي "
            }
        }

        root.ch_2_4.setOnCheckedChangeListener { _, isChecked ->
            if (ch_2_4.isChecked) {
                val customDialogFB = Dialog(activity!!)
                customDialogFB.setContentView(R.layout.front_dailog)
                customDialogFB.setCancelable(false)
                customDialogFB.window?.setLayout(
                    ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT)

                customDialogFB.frontright.setOnCheckedChangeListener { _, isChecked1 ->
                    if (customDialogFB.frontright.isChecked) {
                        ch_2_4.text =
                            "بكس شحمة خلفي يمين"
                    } else {
                        ch_2_4.text = "بكس شحمة خلفي"
                        customDialogFB.s3er_yadwee.setText("")
                    }

                    if (customDialogFB.frontright.isChecked && customDialogFB.frontleft.isChecked) {
                        ch_2_4.text = "بكس شحمة خلفي يمين و يسار"
                        customDialogFB.s3er_yadwee.setText("30")
                    } else {
                        if (customDialogFB.frontright.isChecked) {
                            ch_2_4.text = "بكس شحمة خلفي يمين"
                            customDialogFB.s3er_yadwee.setText("15")
                        }
                        if (customDialogFB.frontleft.isChecked) {
                            ch_2_4.text = "بكس شحمة خلفي يسار"
                            customDialogFB.s3er_yadwee.setText("15")
                        }
                    }
                }
                customDialogFB.frontleft.setOnCheckedChangeListener { _, isChecked2 ->
                    if (customDialogFB.frontleft.isChecked) {
                        ch_2_4.text ="بكس شحمة خلفي يسار"
                    }else{ch_2_4.text =  "بكس شحمة خلفي"
                        customDialogFB.s3er_yadwee.setText("")}

                    if (customDialogFB.frontleft.isChecked && customDialogFB.frontright.isChecked){
                        ch_2_4.text = "بكس شحمة خلفي يمين و يسار"
                        customDialogFB.s3er_yadwee.setText("30")
                    }else {
                        if (customDialogFB.frontright.isChecked) {
                            ch_2_4.text = "بكس شحمة خلفي يمين"
                            customDialogFB.s3er_yadwee.setText("15")
                        }
                        if (customDialogFB.frontleft.isChecked) {
                            ch_2_4.text = "بكس شحمة خلفي يسار"
                            customDialogFB.s3er_yadwee.setText("15")
                        }
                    }

                }

                customDialogFB.button_dailog_save.setOnClickListener {
                    if (!customDialogFB.frontright.isChecked && !customDialogFB.frontleft.isChecked) {
                        toast_notempty1.show()
                    } else {
                        val  aa=customDialogFB.s3er_yadwee.text.toString().trim()
                        if (aa.isEmpty()) {
                            toast_notempty.show()
                        } else {
                            p_p_2_4.text = customDialogFB.s3er_yadwee.text.toString()
                            viewModel.totalAmount += p_p_2_4.text.toString().toInt()
                            toolbar?.title = "المجموع " + viewModel.totalAmount.toString()
                            customDialogFB.dismiss()
                        }
                    }
                }
                customDialogFB.button_dailog_cancel.setOnClickListener {
                    ch_2_4.isChecked = false
                    customDialogFB.button_dailog_cancel.setText("")
                    customDialogFB.dismiss()
                }
                customDialogFB.show()
            }
            else {
                if (p_p_2_4.text.toString().isNotEmpty()){
                    viewModel.totalAmount -= p_p_2_4.text.toString().toInt()
                    toolbar?.title = "المجموع " + viewModel.totalAmount.toString()
                    p_p_2_4.text = ""}
                ch_2_4.text = "بكس شحمة خلفي"
            }
        }

        root.ch_2_5.setOnCheckedChangeListener { _, isChecked ->
            if (ch_2_5.isChecked) {
                val customDialogFB = Dialog(activity!!)
                customDialogFB.setContentView(R.layout.front_dailog)
                customDialogFB.setCancelable(false)
                customDialogFB.window?.setLayout(
                    ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT)

                customDialogFB.frontright.setOnCheckedChangeListener { _, isChecked1 ->
                    if (customDialogFB.frontright.isChecked) {
                        ch_2_5.text =
                            "بكس كفة عرضية المسطرة يمين"
                    } else {
                        ch_2_5.text = "بكس كفة عرضية المسطرة"
                        customDialogFB.s3er_yadwee.setText("")
                    }

                    if (customDialogFB.frontright.isChecked && customDialogFB.frontleft.isChecked) {
                        ch_2_5.text = "بكس كفة عرضية المسطرة يمين و يسار"
                        customDialogFB.s3er_yadwee.setText("14")
                    } else {
                        if (customDialogFB.frontright.isChecked) {
                            ch_2_5.text = "بكس كفة عرضية المسطرة يمين"
                            customDialogFB.s3er_yadwee.setText("7")
                        }
                        if (customDialogFB.frontleft.isChecked) {
                            ch_2_5.text = "بكس كفة عرضية المسطرة يسار"
                            customDialogFB.s3er_yadwee.setText("7")
                        }
                    }
                }
                customDialogFB.frontleft.setOnCheckedChangeListener { _, isChecked2 ->
                    if (customDialogFB.frontleft.isChecked) {
                        ch_2_5.text ="بكس كفة عرضية المسطرة يسار"
                    }else{ch_2_5.text =  "بكس كفة عرضية المسطرة"
                        customDialogFB.s3er_yadwee.setText("")}

                    if (customDialogFB.frontleft.isChecked && customDialogFB.frontright.isChecked){
                        ch_2_5.text = "بكس كفة عرضية المسطرة يمين و يسار"
                        customDialogFB.s3er_yadwee.setText("14")
                    }else {
                        if (customDialogFB.frontright.isChecked) {
                            ch_2_5.text = "بكس كفة عرضية المسطرة يمين"
                            customDialogFB.s3er_yadwee.setText("7")
                        }
                        if (customDialogFB.frontleft.isChecked) {
                            ch_2_5.text = "بكس كفة عرضية المسطرة يسار"
                            customDialogFB.s3er_yadwee.setText("7")
                        }
                    }

                }

                customDialogFB.button_dailog_save.setOnClickListener {
                    if (!customDialogFB.frontright.isChecked && !customDialogFB.frontleft.isChecked) {
                        toast_notempty1.show()
                    } else {
                        val  aa=customDialogFB.s3er_yadwee.text.toString().trim()
                        if (aa.isEmpty()) {
                            toast_notempty.show()
                        } else {
                            p_p_2_5.text = customDialogFB.s3er_yadwee.text.toString()
                            viewModel.totalAmount += p_p_2_5.text.toString().toInt()
                            toolbar?.title = "المجموع " + viewModel.totalAmount.toString()
                            customDialogFB.dismiss()
                        }
                    }
                }
                customDialogFB.button_dailog_cancel.setOnClickListener {
                    ch_2_5.isChecked = false
                    customDialogFB.button_dailog_cancel.setText("")
                    customDialogFB.dismiss()
                }
                customDialogFB.show()
            }
            else {
                if (p_p_2_5.text.toString().isNotEmpty()){
                    viewModel.totalAmount -= p_p_2_5.text.toString().toInt()
                    toolbar?.title = "المجموع " + viewModel.totalAmount.toString()
                    p_p_2_5.text = ""}
                ch_2_5.text = "بكس كفة عرضية المسطرة"
            }
        }

        root.ch_2_6.setOnCheckedChangeListener { _, isChecked ->
            if (ch_2_6.isChecked) {
                val customDialogFB = Dialog(activity!!)
                customDialogFB.setContentView(R.layout.front_dailog)
                customDialogFB.setCancelable(false)
                customDialogFB.window?.setLayout(
                    ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT)

                customDialogFB.frontright.setOnCheckedChangeListener { _, isChecked1 ->
                    if (customDialogFB.frontright.isChecked) {
                        ch_2_6.text =
                            "بكس كفة سفلية أمامية الخلفي يمين"
                    } else {
                        ch_2_6.text = "بكس كفة سفلية أمامية الخلفي"
                        customDialogFB.s3er_yadwee.setText("")
                    }

                    if (customDialogFB.frontright.isChecked && customDialogFB.frontleft.isChecked) {
                        ch_2_6.text = "بكس كفة سفلية أمامية الخلفي يمين و يسار"
                        customDialogFB.s3er_yadwee.setText("16")
                    } else {
                        if (customDialogFB.frontright.isChecked) {
                            ch_2_6.text = "بكس كفة سفلية أمامية الخلفي يمين"
                            customDialogFB.s3er_yadwee.setText("8")
                        }
                        if (customDialogFB.frontleft.isChecked) {
                            ch_2_6.text = "بكس كفة سفلية أمامية الخلفي يسار"
                            customDialogFB.s3er_yadwee.setText("8")
                        }
                    }
                }
                customDialogFB.frontleft.setOnCheckedChangeListener { _, isChecked2 ->
                    if (customDialogFB.frontleft.isChecked) {
                        ch_2_6.text ="بكس كفة سفلية أمامية الخلفي يسار"
                    }else{ch_2_6.text =  "بكس كفة سفلية أمامية الخلفي"
                        customDialogFB.s3er_yadwee.setText("")}

                    if (customDialogFB.frontleft.isChecked && customDialogFB.frontright.isChecked){
                        ch_2_6.text = "بكس كفة سفلية أمامية الخلفي يمين و يسار"
                        customDialogFB.s3er_yadwee.setText("16")
                    }else {
                        if (customDialogFB.frontright.isChecked) {
                            ch_2_6.text = "بكس كفة سفلية أمامية الخلفي يمين"
                            customDialogFB.s3er_yadwee.setText("8")
                        }
                        if (customDialogFB.frontleft.isChecked) {
                            ch_2_6.text = "بكس كفة سفلية أمامية الخلفي يسار"
                            customDialogFB.s3er_yadwee.setText("8")
                        }
                    }

                }

                customDialogFB.button_dailog_save.setOnClickListener {
                    if (!customDialogFB.frontright.isChecked && !customDialogFB.frontleft.isChecked) {
                        toast_notempty1.show()
                    } else {
                        val  aa=customDialogFB.s3er_yadwee.text.toString().trim()
                        if (aa.isEmpty()) {
                            toast_notempty.show()
                        } else {
                            p_p_2_6.text = customDialogFB.s3er_yadwee.text.toString()
                            viewModel.totalAmount += p_p_2_6.text.toString().toInt()
                            toolbar?.title = "المجموع " + viewModel.totalAmount.toString()
                            customDialogFB.dismiss()
                        }
                    }
                }
                customDialogFB.button_dailog_cancel.setOnClickListener {
                    ch_2_6.isChecked = false
                    customDialogFB.button_dailog_cancel.setText("")
                    customDialogFB.dismiss()
                }
                customDialogFB.show()
            }
            else {
                if (p_p_2_6.text.toString().isNotEmpty()){
                    viewModel.totalAmount -= p_p_2_6.text.toString().toInt()
                    toolbar?.title = "المجموع " + viewModel.totalAmount.toString()
                    p_p_2_6.text = ""}
                ch_2_6.text = "بكس كفة سفلية أمامية الخلفي"
            }
        }

        root.ch_2_7.setOnCheckedChangeListener { _, isChecked ->
            if (ch_2_7.isChecked) {
                val customDialogFB = Dialog(activity!!)
                customDialogFB.setContentView(R.layout.front_dailog)
                customDialogFB.setCancelable(false)
                customDialogFB.window?.setLayout(
                    ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT)

                customDialogFB.frontright.setOnCheckedChangeListener { _, isChecked1 ->
                    if (customDialogFB.frontright.isChecked) {
                        ch_2_7.text =
                            "بكس هب سفلي خلفي يمين"
                    } else {
                        ch_2_7.text = "بكس هب سفلي خلفي"
                        customDialogFB.s3er_yadwee.setText("")
                    }

                    if (customDialogFB.frontright.isChecked && customDialogFB.frontleft.isChecked) {
                        ch_2_7.text = "بكس هب سفلي خلفي يمين و يسار"
                        customDialogFB.s3er_yadwee.setText("20")
                    } else {
                        if (customDialogFB.frontright.isChecked) {
                            ch_2_7.text = "بكس هب سفلي خلفي يمين"
                            customDialogFB.s3er_yadwee.setText("10")
                        }
                        if (customDialogFB.frontleft.isChecked) {
                            ch_2_7.text = "بكس هب سفلي خلفي يسار"
                            customDialogFB.s3er_yadwee.setText("10")
                        }
                    }
                }
                customDialogFB.frontleft.setOnCheckedChangeListener { _, isChecked2 ->
                    if (customDialogFB.frontleft.isChecked) {
                        ch_2_7.text ="بكس هب سفلي خلفي يسار"
                    }else{ch_2_7.text =  "بكس هب سفلي خلفي"
                        customDialogFB.s3er_yadwee.setText("")}

                    if (customDialogFB.frontleft.isChecked && customDialogFB.frontright.isChecked){
                        ch_2_7.text = "بكس هب سفلي خلفي يمين و يسار"
                        customDialogFB.s3er_yadwee.setText("20")
                    }else {
                        if (customDialogFB.frontright.isChecked) {
                            ch_2_7.text = "بكس هب سفلي خلفي يمين"
                            customDialogFB.s3er_yadwee.setText("10")
                        }
                        if (customDialogFB.frontleft.isChecked) {
                            ch_2_7.text = "بكس هب سفلي خلفي يسار"
                            customDialogFB.s3er_yadwee.setText("10")
                        }
                    }

                }

                customDialogFB.button_dailog_save.setOnClickListener {
                    if (!customDialogFB.frontright.isChecked && !customDialogFB.frontleft.isChecked) {
                        toast_notempty1.show()
                    } else {
                        val  aa=customDialogFB.s3er_yadwee.text.toString().trim()
                        if (aa.isEmpty()) {
                            toast_notempty.show()
                        } else {
                            p_p_2_7.text = customDialogFB.s3er_yadwee.text.toString()
                            viewModel.totalAmount += p_p_2_7.text.toString().toInt()
                            toolbar?.title = "المجموع " + viewModel.totalAmount.toString()
                            customDialogFB.dismiss()
                        }
                    }
                }
                customDialogFB.button_dailog_cancel.setOnClickListener {
                    ch_2_7.isChecked = false
                    customDialogFB.button_dailog_cancel.setText("")
                    customDialogFB.dismiss()
                }
                customDialogFB.show()
            }
            else {
                if (p_p_2_7.text.toString().isNotEmpty()){
                    viewModel.totalAmount -= p_p_2_7.text.toString().toInt()
                    toolbar?.title = "المجموع " + viewModel.totalAmount.toString()
                    p_p_2_7.text = ""}
                ch_2_7.text = "بكس هب سفلي خلفي"
            }
        }

        root.ch_2_8.setOnCheckedChangeListener { _, isChecked ->
            if (ch_2_8.isChecked) {

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
                        ch_2_8.text = "صنوبرص امامي يمين"
                    } else {
                        ch_2_8.text = "صنوبرص"
                        customDialogFB.s3er_r2s_acx.setText("")
                    }

                    if (customDialogFB.outsideright.isChecked && customDialogFB.outsideleft.isChecked && customDialogFB.insideright.isChecked && customDialogFB.insideleft.isChecked) {
                        ch_2_8.text = "تغير جميع الصنوبرصات"
                        customDialogFB.s3er_r2s_acx.setText("60")
                    } else {
                        if (customDialogFB.outsideright.isChecked && customDialogFB.outsideleft.isChecked && customDialogFB.insideright.isChecked) {
                            ch_2_8.text = "صنوبرص امامي كامل و الخلفي يمين"
                            customDialogFB.s3er_r2s_acx.setText("45")
                        } else {
                            if (customDialogFB.outsideright.isChecked && customDialogFB.outsideleft.isChecked && customDialogFB.insideleft.isChecked) {
                                ch_2_8.text = "صنوبرص امامي كامل و الخلفي يسار"
                                customDialogFB.s3er_r2s_acx.setText("45")
                            } else {
                                if (customDialogFB.outsideright.isChecked && customDialogFB.insideright.isChecked && customDialogFB.insideleft.isChecked) {
                                    ch_2_8.text = "صنوبرص امامي يمين و الخلفيين"
                                    customDialogFB.s3er_r2s_acx.setText("45")
                                } else {
                                    if (customDialogFB.outsideleft.isChecked && customDialogFB.insideright.isChecked && customDialogFB.insideleft.isChecked) {
                                        ch_2_8.text = "صنوبرص امامي يسار و الخلفيين"
                                        customDialogFB.s3er_r2s_acx.setText("45")
                                    } else {
                                        if (customDialogFB.outsideright.isChecked && customDialogFB.outsideleft.isChecked) {
                                            ch_2_8.text = "صنوبرص امامي يمين و يسار"
                                            customDialogFB.s3er_r2s_acx.setText("30")
                                        } else {
                                            if (customDialogFB.outsideright.isChecked && customDialogFB.insideright.isChecked) {
                                                ch_2_8.text = "صنوبرص امامي يمين و الخلفي يمين"
                                                customDialogFB.s3er_r2s_acx.setText("30")
                                            } else {
                                                if (customDialogFB.outsideright.isChecked && customDialogFB.insideleft.isChecked) {
                                                    ch_2_8.text = "صنوبرص امامي يمين و الخلفي يسار"
                                                    customDialogFB.s3er_r2s_acx.setText("30")
                                                } else {
                                                    if (customDialogFB.outsideleft.isChecked && customDialogFB.insideright.isChecked) {
                                                        ch_2_8.text =
                                                            "صنوبرص امامي يسار و الخلفي يمين"
                                                        customDialogFB.s3er_r2s_acx.setText("30")
                                                    } else {
                                                        if (customDialogFB.outsideleft.isChecked && customDialogFB.insideleft.isChecked) {
                                                            ch_2_8.text =
                                                                "صنوبرص امامي يسار و الخلفي يسار"
                                                            customDialogFB.s3er_r2s_acx.setText("30")
                                                        } else {
                                                            if (customDialogFB.insideright.isChecked && customDialogFB.insideleft.isChecked) {
                                                                ch_2_8.text =
                                                                    "صنوبرص خلفي يمين و يسار"
                                                                customDialogFB.s3er_r2s_acx.setText(
                                                                    "30"
                                                                )
                                                            } else {

                                                                if (customDialogFB.outsideright.isChecked) {
                                                                    ch_2_8.text =
                                                                        "صنوبرص امامي يمين"
                                                                    customDialogFB.s3er_r2s_acx.setText(
                                                                        "15"
                                                                    )
                                                                }
                                                                if (customDialogFB.outsideleft.isChecked) {
                                                                    ch_2_8.text =
                                                                        "صنوبرص امامي يسار"
                                                                    customDialogFB.s3er_r2s_acx.setText(
                                                                        "15"
                                                                    )
                                                                }

                                                                if (customDialogFB.insideleft.isChecked) {
                                                                    ch_2_8.text =
                                                                        "صنوبرص خلفي يسار"
                                                                    customDialogFB.s3er_r2s_acx.setText(
                                                                        "15"
                                                                    )
                                                                }
                                                                if (customDialogFB.insideright.isChecked) {
                                                                    ch_2_8.text =
                                                                        "صنوبرص خلفي يمين"
                                                                    customDialogFB.s3er_r2s_acx.setText(
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
                    customDialogFB.show()
                }



                customDialogFB.outsideleft.setOnCheckedChangeListener { _, isChecked2 ->
                    if (customDialogFB.outsideleft.isChecked) {
                        ch_2_8.text = "صنوبرص امامي يسار"
                    } else {
                        ch_2_8.text = "صنوبرص"
                        customDialogFB.s3er_r2s_acx.setText("")
                    }

                    if (customDialogFB.outsideright.isChecked && customDialogFB.outsideleft.isChecked && customDialogFB.insideright.isChecked && customDialogFB.insideleft.isChecked) {
                        ch_2_8.text = "تغير جميع الصنوبرصات"
                        customDialogFB.s3er_r2s_acx.setText("60")
                    } else {
                        if (customDialogFB.outsideright.isChecked && customDialogFB.outsideleft.isChecked && customDialogFB.insideright.isChecked) {
                            ch_2_8.text = "صنوبرص امامي كامل و الخلفي يمين"
                            customDialogFB.s3er_r2s_acx.setText("45")
                        } else {
                            if (customDialogFB.outsideright.isChecked && customDialogFB.outsideleft.isChecked && customDialogFB.insideleft.isChecked) {
                                ch_2_8.text = "صنوبرص امامي كامل و الخلفي يسار"
                                customDialogFB.s3er_r2s_acx.setText("45")
                            } else {
                                if (customDialogFB.outsideright.isChecked && customDialogFB.insideright.isChecked && customDialogFB.insideleft.isChecked) {
                                    ch_2_8.text = "صنوبرص امامي يمين و الخلفيين"
                                    customDialogFB.s3er_r2s_acx.setText("45")
                                } else {
                                    if (customDialogFB.outsideleft.isChecked && customDialogFB.insideright.isChecked && customDialogFB.insideleft.isChecked) {
                                        ch_2_8.text = "صنوبرص امامي يسار و الخلفيين"
                                        customDialogFB.s3er_r2s_acx.setText("45")
                                    } else {
                                        if (customDialogFB.outsideright.isChecked && customDialogFB.outsideleft.isChecked) {
                                            ch_2_8.text = "صنوبرص امامي يمين و يسار"
                                            customDialogFB.s3er_r2s_acx.setText("30")
                                        } else {
                                            if (customDialogFB.outsideright.isChecked && customDialogFB.insideright.isChecked) {
                                                ch_2_8.text = "صنوبرص امامي يمين و الخلفي يمين"
                                                customDialogFB.s3er_r2s_acx.setText("30")
                                            } else {
                                                if (customDialogFB.outsideright.isChecked && customDialogFB.insideleft.isChecked) {
                                                    ch_2_8.text = "صنوبرص امامي يمين و الخلفي يسار"
                                                    customDialogFB.s3er_r2s_acx.setText("30")
                                                } else {
                                                    if (customDialogFB.outsideleft.isChecked && customDialogFB.insideright.isChecked) {
                                                        ch_2_8.text =
                                                            "صنوبرص امامي يسار و الخلفي يمين"
                                                        customDialogFB.s3er_r2s_acx.setText("30")
                                                    } else {
                                                        if (customDialogFB.outsideleft.isChecked && customDialogFB.insideleft.isChecked) {
                                                            ch_2_8.text =
                                                                "صنوبرص امامي يسار و الخلفي يسار"
                                                            customDialogFB.s3er_r2s_acx.setText("30")
                                                        } else {
                                                            if (customDialogFB.insideright.isChecked && customDialogFB.insideleft.isChecked) {
                                                                ch_2_8.text =
                                                                    "صنوبرص خلفي يمين و يسار"
                                                                customDialogFB.s3er_r2s_acx.setText(
                                                                    "30"
                                                                )
                                                            } else {

                                                                if (customDialogFB.outsideright.isChecked) {
                                                                    ch_2_8.text =
                                                                        "صنوبرص امامي يمين"
                                                                    customDialogFB.s3er_r2s_acx.setText(
                                                                        "15"
                                                                    )
                                                                }
                                                                if (customDialogFB.outsideleft.isChecked) {
                                                                    ch_2_8.text =
                                                                        "صنوبرص امامي يسار"
                                                                    customDialogFB.s3er_r2s_acx.setText(
                                                                        "15"
                                                                    )
                                                                }

                                                                if (customDialogFB.insideleft.isChecked) {
                                                                    ch_2_8.text =
                                                                        "صنوبرص خلفي يسار"
                                                                    customDialogFB.s3er_r2s_acx.setText(
                                                                        "15"
                                                                    )
                                                                }
                                                                if (customDialogFB.insideright.isChecked) {
                                                                    ch_2_8.text =
                                                                        "صنوبرص خلفي يمين"
                                                                    customDialogFB.s3er_r2s_acx.setText(
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
                    customDialogFB.show()
                }



                customDialogFB.insideleft.setOnCheckedChangeListener { _, isChecked2 ->
                    if (customDialogFB.outsideright.isChecked) {
                        ch_2_8.text = "صنوبرص خلفي يمين"
                    } else {
                        ch_2_8.text = "صنوبرص"
                        customDialogFB.s3er_r2s_acx.setText("")
                    }

                    if (customDialogFB.outsideright.isChecked && customDialogFB.outsideleft.isChecked && customDialogFB.insideright.isChecked && customDialogFB.insideleft.isChecked) {
                        ch_2_8.text = "تغير جميع الصنوبرصات"
                        customDialogFB.s3er_r2s_acx.setText("60")
                    } else {
                        if (customDialogFB.outsideright.isChecked && customDialogFB.outsideleft.isChecked && customDialogFB.insideright.isChecked) {
                            ch_2_8.text = "صنوبرص امامي كامل و الخلفي يمين"
                            customDialogFB.s3er_r2s_acx.setText("45")
                        } else {
                            if (customDialogFB.outsideright.isChecked && customDialogFB.outsideleft.isChecked && customDialogFB.insideleft.isChecked) {
                                ch_2_8.text = "صنوبرص امامي كامل و الخلفي يسار"
                                customDialogFB.s3er_r2s_acx.setText("45")
                            } else {
                                if (customDialogFB.outsideright.isChecked && customDialogFB.insideright.isChecked && customDialogFB.insideleft.isChecked) {
                                    ch_2_8.text = "صنوبرص امامي يمين و الخلفيين"
                                    customDialogFB.s3er_r2s_acx.setText("45")
                                } else {
                                    if (customDialogFB.outsideleft.isChecked && customDialogFB.insideright.isChecked && customDialogFB.insideleft.isChecked) {
                                        ch_2_8.text = "صنوبرص امامي يسار و الخلفيين"
                                        customDialogFB.s3er_r2s_acx.setText("45")
                                    } else {
                                        if (customDialogFB.outsideright.isChecked && customDialogFB.outsideleft.isChecked) {
                                            ch_2_8.text = "صنوبرص امامي يمين و يسار"
                                            customDialogFB.s3er_r2s_acx.setText("30")
                                        } else {
                                            if (customDialogFB.outsideright.isChecked && customDialogFB.insideright.isChecked) {
                                                ch_2_8.text = "صنوبرص امامي يمين و الخلفي يمين"
                                                customDialogFB.s3er_r2s_acx.setText("30")
                                            } else {
                                                if (customDialogFB.outsideright.isChecked && customDialogFB.insideleft.isChecked) {
                                                    ch_2_8.text = "صنوبرص امامي يمين و الخلفي يسار"
                                                    customDialogFB.s3er_r2s_acx.setText("30")
                                                } else {
                                                    if (customDialogFB.outsideleft.isChecked && customDialogFB.insideright.isChecked) {
                                                        ch_2_8.text =
                                                            "صنوبرص امامي يسار و الخلفي يمين"
                                                        customDialogFB.s3er_r2s_acx.setText("30")
                                                    } else {
                                                        if (customDialogFB.outsideleft.isChecked && customDialogFB.insideleft.isChecked) {
                                                            ch_2_8.text =
                                                                "صنوبرص امامي يسار و الخلفي يسار"
                                                            customDialogFB.s3er_r2s_acx.setText("30")
                                                        } else {
                                                            if (customDialogFB.insideright.isChecked && customDialogFB.insideleft.isChecked) {
                                                                ch_2_8.text =
                                                                    "صنوبرص خلفي يمين و يسار"
                                                                customDialogFB.s3er_r2s_acx.setText(
                                                                    "30"
                                                                )
                                                            } else {

                                                                if (customDialogFB.outsideright.isChecked) {
                                                                    ch_2_8.text =
                                                                        "صنوبرص امامي يمين"
                                                                    customDialogFB.s3er_r2s_acx.setText(
                                                                        "15"
                                                                    )
                                                                }
                                                                if (customDialogFB.outsideleft.isChecked) {
                                                                    ch_2_8.text =
                                                                        "صنوبرص امامي يسار"
                                                                    customDialogFB.s3er_r2s_acx.setText(
                                                                        "15"
                                                                    )
                                                                }

                                                                if (customDialogFB.insideleft.isChecked) {
                                                                    ch_2_8.text =
                                                                        "صنوبرص خلفي يسار"
                                                                    customDialogFB.s3er_r2s_acx.setText(
                                                                        "15"
                                                                    )
                                                                }
                                                                if (customDialogFB.insideright.isChecked) {
                                                                    ch_2_8.text =
                                                                        "صنوبرص خلفي يمين"
                                                                    customDialogFB.s3er_r2s_acx.setText(
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

                    customDialogFB.show()
                }

                customDialogFB.insideright.setOnCheckedChangeListener { _, isChecked2 ->
                    if (customDialogFB.insideright.isChecked) {
                        ch_2_8.text = "صنوبرص خلفي يسار"
                    } else {
                        ch_2_8.text = "صنوبرص"
                        customDialogFB.s3er_r2s_acx.setText("")
                    }

                    if (customDialogFB.outsideright.isChecked && customDialogFB.outsideleft.isChecked && customDialogFB.insideright.isChecked && customDialogFB.insideleft.isChecked) {
                        ch_2_8.text = "تغير جميع الصنوبرصات"
                        customDialogFB.s3er_r2s_acx.setText("60")
                    } else {
                        if (customDialogFB.outsideright.isChecked && customDialogFB.outsideleft.isChecked && customDialogFB.insideright.isChecked) {
                            ch_2_8.text = "صنوبرص امامي كامل و الخلفي يمين"
                            customDialogFB.s3er_r2s_acx.setText("45")
                        } else {
                            if (customDialogFB.outsideright.isChecked && customDialogFB.outsideleft.isChecked && customDialogFB.insideleft.isChecked) {
                                ch_2_8.text = "صنوبرص امامي كامل و الخلفي يسار"
                                customDialogFB.s3er_r2s_acx.setText("45")
                            } else {
                                if (customDialogFB.outsideright.isChecked && customDialogFB.insideright.isChecked && customDialogFB.insideleft.isChecked) {
                                    ch_2_8.text = "صنوبرص امامي يمين و الخلفيين"
                                    customDialogFB.s3er_r2s_acx.setText("45")
                                } else {
                                    if (customDialogFB.outsideleft.isChecked && customDialogFB.insideright.isChecked && customDialogFB.insideleft.isChecked) {
                                        ch_2_8.text = "صنوبرص امامي يسار و الخلفيين"
                                        customDialogFB.s3er_r2s_acx.setText("45")
                                    } else {
                                        if (customDialogFB.outsideright.isChecked && customDialogFB.outsideleft.isChecked) {
                                            ch_2_8.text = "صنوبرص امامي يمين و يسار"
                                            customDialogFB.s3er_r2s_acx.setText("30")
                                        } else {
                                            if (customDialogFB.outsideright.isChecked && customDialogFB.insideright.isChecked) {
                                                ch_2_8.text = "صنوبرص امامي يمين و الخلفي يمين"
                                                customDialogFB.s3er_r2s_acx.setText("30")
                                            } else {
                                                if (customDialogFB.outsideright.isChecked && customDialogFB.insideleft.isChecked) {
                                                    ch_2_8.text = "صنوبرص امامي يمين و الخلفي يسار"
                                                    customDialogFB.s3er_r2s_acx.setText("30")
                                                } else {
                                                    if (customDialogFB.outsideleft.isChecked && customDialogFB.insideright.isChecked) {
                                                        ch_2_8.text =
                                                            "صنوبرص امامي يسار و الخلفي يمين"
                                                        customDialogFB.s3er_r2s_acx.setText("30")
                                                    } else {
                                                        if (customDialogFB.outsideleft.isChecked && customDialogFB.insideleft.isChecked) {
                                                            ch_2_8.text =
                                                                "صنوبرص امامي يسار و الخلفي يسار"
                                                            customDialogFB.s3er_r2s_acx.setText("30")
                                                        } else {
                                                            if (customDialogFB.insideright.isChecked && customDialogFB.insideleft.isChecked) {
                                                                ch_2_8.text =
                                                                    "صنوبرص خلفي يمين و يسار"
                                                                customDialogFB.s3er_r2s_acx.setText(
                                                                    "30"
                                                                )
                                                            } else {

                                                                if (customDialogFB.outsideright.isChecked) {
                                                                    ch_2_8.text =
                                                                        "صنوبرص امامي يمين"
                                                                    customDialogFB.s3er_r2s_acx.setText(
                                                                        "15"
                                                                    )
                                                                }
                                                                if (customDialogFB.outsideleft.isChecked) {
                                                                    ch_2_8.text =
                                                                        "صنوبرص امامي يسار"
                                                                    customDialogFB.s3er_r2s_acx.setText(
                                                                        "15"
                                                                    )
                                                                }

                                                                if (customDialogFB.insideleft.isChecked) {
                                                                    ch_2_8.text =
                                                                        "صنوبرص خلفي يسار"
                                                                    customDialogFB.s3er_r2s_acx.setText(
                                                                        "15"
                                                                    )
                                                                }
                                                                if (customDialogFB.insideright.isChecked) {
                                                                    ch_2_8.text =
                                                                        "صنوبرص خلفي يمين"
                                                                    customDialogFB.s3er_r2s_acx.setText(
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
//                            ch_2_8.isChecked = false
                        } else {
                            p_p_2_8.text = customDialogFB.s3er_r2s_acx.text.toString()
                            viewModel.totalAmount += p_p_2_8.text.toString().toInt()
                            toolbar?.title = "المجموع " + viewModel.totalAmount.toString()
                            customDialogFB.dismiss()
                        }
                    }
                }
                customDialogFB.btn_r2s_can.setOnClickListener {
                    if (p_p_2_8.text.toString().isEmpty()) {
                        ch_2_8.text = "صنوبرص"
                        ch_2_8.isChecked = false
                    }
                    customDialogFB.dismiss()
                }

                customDialogFB.show()
            } else {
                if (p_p_2_8.text.toString().isNotEmpty()) {
                    viewModel.totalAmount -= p_p_2_8.text.toString().toInt()
                    toolbar?.title = "المجموع " + viewModel.totalAmount.toString()
                    ch_2_8.text = "صنوبرص"
                    p_p_2_8.setText("")
                } else {
                    ch_2_8.text = "صنوبرص"
                }
            }
        }

        root.ch_2_9.setOnCheckedChangeListener { _, isChecked ->
            if (ch_2_9.isChecked) {

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
                        ch_2_9.text = "بيلية عجل امامي يمين"
                    } else {
                        ch_2_9.text = "بيلية عجل"
                        customDialogFB.s3er_r2s_acx.setText("")
                    }

                    if (customDialogFB.outsideright.isChecked && customDialogFB.outsideleft.isChecked && customDialogFB.insideright.isChecked && customDialogFB.insideleft.isChecked) {
                        ch_2_9.text = "تغير جميع بيل العجلات"
                        customDialogFB.s3er_r2s_acx.setText("50")
                    } else {
                        if (customDialogFB.outsideright.isChecked && customDialogFB.outsideleft.isChecked && customDialogFB.insideright.isChecked) {
                            ch_2_9.text = "بيلية عجل امامي كامل و الخلفي يمين"
                            customDialogFB.s3er_r2s_acx.setText("35")
                        } else {
                            if (customDialogFB.outsideright.isChecked && customDialogFB.outsideleft.isChecked && customDialogFB.insideleft.isChecked) {
                                ch_2_9.text = "بيلية عجل امامي كامل و الخلفي يسار"
                                customDialogFB.s3er_r2s_acx.setText("35")
                            } else {
                                if (customDialogFB.outsideright.isChecked && customDialogFB.insideright.isChecked && customDialogFB.insideleft.isChecked) {
                                    ch_2_9.text = "بيلية عجل امامي يمين و الخلفيين"
                                    customDialogFB.s3er_r2s_acx.setText("40")
                                } else {
                                    if (customDialogFB.outsideleft.isChecked && customDialogFB.insideright.isChecked && customDialogFB.insideleft.isChecked) {
                                        ch_2_9.text = "بيلية عجل امامي يسار و الخلفيين"
                                        customDialogFB.s3er_r2s_acx.setText("40")
                                    } else {
                                        if (customDialogFB.outsideright.isChecked && customDialogFB.outsideleft.isChecked) {
                                            ch_2_9.text = "بيلية عجل امامي يمين و يسار"
                                            customDialogFB.s3er_r2s_acx.setText("20")
                                        } else {
                                            if (customDialogFB.outsideright.isChecked && customDialogFB.insideright.isChecked) {
                                                ch_2_9.text = "بيلية عجل امامي يمين و الخلفي يمين"
                                                customDialogFB.s3er_r2s_acx.setText("25")
                                            } else {
                                                if (customDialogFB.outsideright.isChecked && customDialogFB.insideleft.isChecked) {
                                                    ch_2_9.text = "بيلية عجل امامي يمين و الخلفي يسار"
                                                    customDialogFB.s3er_r2s_acx.setText("25")
                                                } else {
                                                    if (customDialogFB.outsideleft.isChecked && customDialogFB.insideright.isChecked) {
                                                        ch_2_9.text =
                                                            "بيلية عجل امامي يسار و الخلفي يمين"
                                                        customDialogFB.s3er_r2s_acx.setText("25")
                                                    } else {
                                                        if (customDialogFB.outsideleft.isChecked && customDialogFB.insideleft.isChecked) {
                                                            ch_2_9.text =
                                                                "بيلية عجل امامي يسار و الخلفي يسار"
                                                            customDialogFB.s3er_r2s_acx.setText("25")
                                                        } else {
                                                            if (customDialogFB.insideright.isChecked && customDialogFB.insideleft.isChecked) {
                                                                ch_2_9.text =
                                                                    "بيلية عجل خلفي يمين و يسار"
                                                                customDialogFB.s3er_r2s_acx.setText(
                                                                    "30"
                                                                )
                                                            } else {

                                                                if (customDialogFB.outsideright.isChecked) {
                                                                    ch_2_9.text =
                                                                        "بيلية عجل امامي يمين"
                                                                    customDialogFB.s3er_r2s_acx.setText(
                                                                        "10"
                                                                    )
                                                                }
                                                                if (customDialogFB.outsideleft.isChecked) {
                                                                    ch_2_9.text =
                                                                        "بيلية عجل امامي يسار"
                                                                    customDialogFB.s3er_r2s_acx.setText(
                                                                        "10"
                                                                    )
                                                                }

                                                                if (customDialogFB.insideleft.isChecked) {
                                                                    ch_2_9.text =
                                                                        "بيلية عجل خلفي يسار"
                                                                    customDialogFB.s3er_r2s_acx.setText(
                                                                        "15"
                                                                    )
                                                                }
                                                                if (customDialogFB.insideright.isChecked) {
                                                                    ch_2_9.text =
                                                                        "بيلية عجل خلفي يمين"
                                                                    customDialogFB.s3er_r2s_acx.setText(
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
                    customDialogFB.show()
                }



                customDialogFB.outsideleft.setOnCheckedChangeListener { _, isChecked2 ->
                    if (customDialogFB.outsideleft.isChecked) {
                        ch_2_9.text = "بيلية عجل امامي يمين"
                    } else {
                        ch_2_9.text = "بيلية عجل"
                        customDialogFB.s3er_r2s_acx.setText("")
                    }

                    if (customDialogFB.outsideright.isChecked && customDialogFB.outsideleft.isChecked && customDialogFB.insideright.isChecked && customDialogFB.insideleft.isChecked) {
                        ch_2_9.text = "تغير جميع بيل العجلات"
                        customDialogFB.s3er_r2s_acx.setText("50")
                    } else {
                        if (customDialogFB.outsideright.isChecked && customDialogFB.outsideleft.isChecked && customDialogFB.insideright.isChecked) {
                            ch_2_9.text = "بيلية عجل امامي كامل و الخلفي يمين"
                            customDialogFB.s3er_r2s_acx.setText("35")
                        } else {
                            if (customDialogFB.outsideright.isChecked && customDialogFB.outsideleft.isChecked && customDialogFB.insideleft.isChecked) {
                                ch_2_9.text = "بيلية عجل امامي كامل و الخلفي يسار"
                                customDialogFB.s3er_r2s_acx.setText("35")
                            } else {
                                if (customDialogFB.outsideright.isChecked && customDialogFB.insideright.isChecked && customDialogFB.insideleft.isChecked) {
                                    ch_2_9.text = "بيلية عجل امامي يمين و الخلفيين"
                                    customDialogFB.s3er_r2s_acx.setText("40")
                                } else {
                                    if (customDialogFB.outsideleft.isChecked && customDialogFB.insideright.isChecked && customDialogFB.insideleft.isChecked) {
                                        ch_2_9.text = "بيلية عجل امامي يسار و الخلفيين"
                                        customDialogFB.s3er_r2s_acx.setText("40")
                                    } else {
                                        if (customDialogFB.outsideright.isChecked && customDialogFB.outsideleft.isChecked) {
                                            ch_2_9.text = "بيلية عجل امامي يمين و يسار"
                                            customDialogFB.s3er_r2s_acx.setText("20")
                                        } else {
                                            if (customDialogFB.outsideright.isChecked && customDialogFB.insideright.isChecked) {
                                                ch_2_9.text = "بيلية عجل امامي يمين و الخلفي يمين"
                                                customDialogFB.s3er_r2s_acx.setText("25")
                                            } else {
                                                if (customDialogFB.outsideright.isChecked && customDialogFB.insideleft.isChecked) {
                                                    ch_2_9.text = "بيلية عجل امامي يمين و الخلفي يسار"
                                                    customDialogFB.s3er_r2s_acx.setText("25")
                                                } else {
                                                    if (customDialogFB.outsideleft.isChecked && customDialogFB.insideright.isChecked) {
                                                        ch_2_9.text =
                                                            "بيلية عجل امامي يسار و الخلفي يمين"
                                                        customDialogFB.s3er_r2s_acx.setText("25")
                                                    } else {
                                                        if (customDialogFB.outsideleft.isChecked && customDialogFB.insideleft.isChecked) {
                                                            ch_2_9.text =
                                                                "بيلية عجل امامي يسار و الخلفي يسار"
                                                            customDialogFB.s3er_r2s_acx.setText("25")
                                                        } else {
                                                            if (customDialogFB.insideright.isChecked && customDialogFB.insideleft.isChecked) {
                                                                ch_2_9.text =
                                                                    "بيلية عجل خلفي يمين و يسار"
                                                                customDialogFB.s3er_r2s_acx.setText(
                                                                    "30"
                                                                )
                                                            } else {

                                                                if (customDialogFB.outsideright.isChecked) {
                                                                    ch_2_9.text =
                                                                        "بيلية عجل امامي يمين"
                                                                    customDialogFB.s3er_r2s_acx.setText(
                                                                        "10"
                                                                    )
                                                                }
                                                                if (customDialogFB.outsideleft.isChecked) {
                                                                    ch_2_9.text =
                                                                        "بيلية عجل امامي يسار"
                                                                    customDialogFB.s3er_r2s_acx.setText(
                                                                        "10"
                                                                    )
                                                                }

                                                                if (customDialogFB.insideleft.isChecked) {
                                                                    ch_2_9.text =
                                                                        "بيلية عجل خلفي يسار"
                                                                    customDialogFB.s3er_r2s_acx.setText(
                                                                        "15"
                                                                    )
                                                                }
                                                                if (customDialogFB.insideright.isChecked) {
                                                                    ch_2_9.text =
                                                                        "بيلية عجل خلفي يمين"
                                                                    customDialogFB.s3er_r2s_acx.setText(
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
                    customDialogFB.show()
                }



                customDialogFB.insideleft.setOnCheckedChangeListener { _, isChecked2 ->
                    if (customDialogFB.outsideright.isChecked) {
                        ch_2_9.text = "بيلية عجل امامي يمين"
                    } else {
                        ch_2_9.text = "بيلية عجل"
                        customDialogFB.s3er_r2s_acx.setText("")
                    }

                    if (customDialogFB.outsideright.isChecked && customDialogFB.outsideleft.isChecked && customDialogFB.insideright.isChecked && customDialogFB.insideleft.isChecked) {
                        ch_2_9.text = "تغير جميع بيل العجلات"
                        customDialogFB.s3er_r2s_acx.setText("50")
                    } else {
                        if (customDialogFB.outsideright.isChecked && customDialogFB.outsideleft.isChecked && customDialogFB.insideright.isChecked) {
                            ch_2_9.text = "بيلية عجل امامي كامل و الخلفي يمين"
                            customDialogFB.s3er_r2s_acx.setText("35")
                        } else {
                            if (customDialogFB.outsideright.isChecked && customDialogFB.outsideleft.isChecked && customDialogFB.insideleft.isChecked) {
                                ch_2_9.text = "بيلية عجل امامي كامل و الخلفي يسار"
                                customDialogFB.s3er_r2s_acx.setText("35")
                            } else {
                                if (customDialogFB.outsideright.isChecked && customDialogFB.insideright.isChecked && customDialogFB.insideleft.isChecked) {
                                    ch_2_9.text = "بيلية عجل امامي يمين و الخلفيين"
                                    customDialogFB.s3er_r2s_acx.setText("40")
                                } else {
                                    if (customDialogFB.outsideleft.isChecked && customDialogFB.insideright.isChecked && customDialogFB.insideleft.isChecked) {
                                        ch_2_9.text = "بيلية عجل امامي يسار و الخلفيين"
                                        customDialogFB.s3er_r2s_acx.setText("40")
                                    } else {
                                        if (customDialogFB.outsideright.isChecked && customDialogFB.outsideleft.isChecked) {
                                            ch_2_9.text = "بيلية عجل امامي يمين و يسار"
                                            customDialogFB.s3er_r2s_acx.setText("20")
                                        } else {
                                            if (customDialogFB.outsideright.isChecked && customDialogFB.insideright.isChecked) {
                                                ch_2_9.text = "بيلية عجل امامي يمين و الخلفي يمين"
                                                customDialogFB.s3er_r2s_acx.setText("25")
                                            } else {
                                                if (customDialogFB.outsideright.isChecked && customDialogFB.insideleft.isChecked) {
                                                    ch_2_9.text = "بيلية عجل امامي يمين و الخلفي يسار"
                                                    customDialogFB.s3er_r2s_acx.setText("25")
                                                } else {
                                                    if (customDialogFB.outsideleft.isChecked && customDialogFB.insideright.isChecked) {
                                                        ch_2_9.text =
                                                            "بيلية عجل امامي يسار و الخلفي يمين"
                                                        customDialogFB.s3er_r2s_acx.setText("25")
                                                    } else {
                                                        if (customDialogFB.outsideleft.isChecked && customDialogFB.insideleft.isChecked) {
                                                            ch_2_9.text =
                                                                "بيلية عجل امامي يسار و الخلفي يسار"
                                                            customDialogFB.s3er_r2s_acx.setText("25")
                                                        } else {
                                                            if (customDialogFB.insideright.isChecked && customDialogFB.insideleft.isChecked) {
                                                                ch_2_9.text =
                                                                    "بيلية عجل خلفي يمين و يسار"
                                                                customDialogFB.s3er_r2s_acx.setText(
                                                                    "30"
                                                                )
                                                            } else {

                                                                if (customDialogFB.outsideright.isChecked) {
                                                                    ch_2_9.text =
                                                                        "بيلية عجل امامي يمين"
                                                                    customDialogFB.s3er_r2s_acx.setText(
                                                                        "10"
                                                                    )
                                                                }
                                                                if (customDialogFB.outsideleft.isChecked) {
                                                                    ch_2_9.text =
                                                                        "بيلية عجل امامي يسار"
                                                                    customDialogFB.s3er_r2s_acx.setText(
                                                                        "10"
                                                                    )
                                                                }

                                                                if (customDialogFB.insideleft.isChecked) {
                                                                    ch_2_9.text =
                                                                        "بيلية عجل خلفي يسار"
                                                                    customDialogFB.s3er_r2s_acx.setText(
                                                                        "15"
                                                                    )
                                                                }
                                                                if (customDialogFB.insideright.isChecked) {
                                                                    ch_2_9.text =
                                                                        "بيلية عجل خلفي يمين"
                                                                    customDialogFB.s3er_r2s_acx.setText(
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

                    customDialogFB.show()
                }

                customDialogFB.insideright.setOnCheckedChangeListener { _, isChecked2 ->
                    if (customDialogFB.insideright.isChecked) {
                        ch_2_9.text = "بيلية عجل امامي يمين"
                    } else {
                        ch_2_9.text = "بيلية عجل"
                        customDialogFB.s3er_r2s_acx.setText("")
                    }

                    if (customDialogFB.outsideright.isChecked && customDialogFB.outsideleft.isChecked && customDialogFB.insideright.isChecked && customDialogFB.insideleft.isChecked) {
                        ch_2_9.text = "تغير جميع بيل العجلات"
                        customDialogFB.s3er_r2s_acx.setText("50")
                    } else {
                        if (customDialogFB.outsideright.isChecked && customDialogFB.outsideleft.isChecked && customDialogFB.insideright.isChecked) {
                            ch_2_9.text = "بيلية عجل امامي كامل و الخلفي يمين"
                            customDialogFB.s3er_r2s_acx.setText("35")
                        } else {
                            if (customDialogFB.outsideright.isChecked && customDialogFB.outsideleft.isChecked && customDialogFB.insideleft.isChecked) {
                                ch_2_9.text = "بيلية عجل امامي كامل و الخلفي يسار"
                                customDialogFB.s3er_r2s_acx.setText("35")
                            } else {
                                if (customDialogFB.outsideright.isChecked && customDialogFB.insideright.isChecked && customDialogFB.insideleft.isChecked) {
                                    ch_2_9.text = "بيلية عجل امامي يمين و الخلفيين"
                                    customDialogFB.s3er_r2s_acx.setText("40")
                                } else {
                                    if (customDialogFB.outsideleft.isChecked && customDialogFB.insideright.isChecked && customDialogFB.insideleft.isChecked) {
                                        ch_2_9.text = "بيلية عجل امامي يسار و الخلفيين"
                                        customDialogFB.s3er_r2s_acx.setText("40")
                                    } else {
                                        if (customDialogFB.outsideright.isChecked && customDialogFB.outsideleft.isChecked) {
                                            ch_2_9.text = "بيلية عجل امامي يمين و يسار"
                                            customDialogFB.s3er_r2s_acx.setText("20")
                                        } else {
                                            if (customDialogFB.outsideright.isChecked && customDialogFB.insideright.isChecked) {
                                                ch_2_9.text = "بيلية عجل امامي يمين و الخلفي يمين"
                                                customDialogFB.s3er_r2s_acx.setText("25")
                                            } else {
                                                if (customDialogFB.outsideright.isChecked && customDialogFB.insideleft.isChecked) {
                                                    ch_2_9.text = "بيلية عجل امامي يمين و الخلفي يسار"
                                                    customDialogFB.s3er_r2s_acx.setText("25")
                                                } else {
                                                    if (customDialogFB.outsideleft.isChecked && customDialogFB.insideright.isChecked) {
                                                        ch_2_9.text =
                                                            "بيلية عجل امامي يسار و الخلفي يمين"
                                                        customDialogFB.s3er_r2s_acx.setText("25")
                                                    } else {
                                                        if (customDialogFB.outsideleft.isChecked && customDialogFB.insideleft.isChecked) {
                                                            ch_2_9.text =
                                                                "بيلية عجل امامي يسار و الخلفي يسار"
                                                            customDialogFB.s3er_r2s_acx.setText("25")
                                                        } else {
                                                            if (customDialogFB.insideright.isChecked && customDialogFB.insideleft.isChecked) {
                                                                ch_2_9.text =
                                                                    "بيلية عجل خلفي يمين و يسار"
                                                                customDialogFB.s3er_r2s_acx.setText(
                                                                    "30"
                                                                )
                                                            } else {

                                                                if (customDialogFB.outsideright.isChecked) {
                                                                    ch_2_9.text =
                                                                        "بيلية عجل امامي يمين"
                                                                    customDialogFB.s3er_r2s_acx.setText(
                                                                        "10"
                                                                    )
                                                                }
                                                                if (customDialogFB.outsideleft.isChecked) {
                                                                    ch_2_9.text =
                                                                        "بيلية عجل امامي يسار"
                                                                    customDialogFB.s3er_r2s_acx.setText(
                                                                        "10"
                                                                    )
                                                                }

                                                                if (customDialogFB.insideleft.isChecked) {
                                                                    ch_2_9.text =
                                                                        "بيلية عجل خلفي يسار"
                                                                    customDialogFB.s3er_r2s_acx.setText(
                                                                        "15"
                                                                    )
                                                                }
                                                                if (customDialogFB.insideright.isChecked) {
                                                                    ch_2_9.text =
                                                                        "بيلية عجل خلفي يمين"
                                                                    customDialogFB.s3er_r2s_acx.setText(
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
//                            ch_2_9.isChecked = false
                        } else {
                            p_p_2_9.text = customDialogFB.s3er_r2s_acx.text.toString()
                            viewModel.totalAmount += p_p_2_9.text.toString().toInt()
                            toolbar?.title = "المجموع " + viewModel.totalAmount.toString()
                            customDialogFB.dismiss()
                        }
                    }
                }
                customDialogFB.btn_r2s_can.setOnClickListener {
                    if (p_p_2_9.text.toString().isEmpty()) {
                        ch_2_9.text = "بيلية عجل"
                        ch_2_9.isChecked = false
                    }
                    customDialogFB.dismiss()
                }

                customDialogFB.show()
            } else {
                if (p_p_2_9.text.toString().isNotEmpty()) {
                    viewModel.totalAmount -= p_p_2_9.text.toString().toInt()
                    toolbar?.title = "المجموع " + viewModel.totalAmount.toString()
                    ch_2_9.text = "بيلية عجل"
                    p_p_2_9.setText("")
                } else {
                    ch_2_9.text = "بيلية عجل"
                }
            }
        }

        root.ch_2_10.setOnCheckedChangeListener { _, isChecked ->
            if (ch_2_10.isChecked) {

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
                        ch_2_10.text = "قاعدة صنوبرص علوية امامي يمين"
                    } else {
                        ch_2_10.text = "قاعدة صنوبرص علوية"
                        customDialogFB.s3er_r2s_acx.setText("")
                    }

                    if (customDialogFB.outsideright.isChecked && customDialogFB.outsideleft.isChecked && customDialogFB.insideright.isChecked && customDialogFB.insideleft.isChecked) {
                        ch_2_10.text = "تغير جميع القواعد  العلوية للصنوبرصات"
                        customDialogFB.s3er_r2s_acx.setText("20")
                    } else {
                        if (customDialogFB.outsideright.isChecked && customDialogFB.outsideleft.isChecked && customDialogFB.insideright.isChecked) {
                            ch_2_10.text = "قاعدة صنوبرص علوية امامي كامل و الخلفي يمين"
                            customDialogFB.s3er_r2s_acx.setText("15")
                        } else {
                            if (customDialogFB.outsideright.isChecked && customDialogFB.outsideleft.isChecked && customDialogFB.insideleft.isChecked) {
                                ch_2_10.text = "قاعدة صنوبرص علوية امامي كامل و الخلفي يسار"
                                customDialogFB.s3er_r2s_acx.setText("15")
                            } else {
                                if (customDialogFB.outsideright.isChecked && customDialogFB.insideright.isChecked && customDialogFB.insideleft.isChecked) {
                                    ch_2_10.text = "قاعدة صنوبرص علوية امامي يمين و الخلفيين"
                                    customDialogFB.s3er_r2s_acx.setText("15")
                                } else {
                                    if (customDialogFB.outsideleft.isChecked && customDialogFB.insideright.isChecked && customDialogFB.insideleft.isChecked) {
                                        ch_2_10.text = "قاعدة صنوبرص علوية امامي يسار و الخلفيين"
                                        customDialogFB.s3er_r2s_acx.setText("15")
                                    } else {
                                        if (customDialogFB.outsideright.isChecked && customDialogFB.outsideleft.isChecked) {
                                            ch_2_10.text = "قاعدة صنوبرص علوية امامي يمين و يسار"
                                            customDialogFB.s3er_r2s_acx.setText("10")
                                        } else {
                                            if (customDialogFB.outsideright.isChecked && customDialogFB.insideright.isChecked) {
                                                ch_2_10.text = "قاعدة صنوبرص علوية امامي يمين و الخلفي يمين"
                                                customDialogFB.s3er_r2s_acx.setText("10")
                                            } else {
                                                if (customDialogFB.outsideright.isChecked && customDialogFB.insideleft.isChecked) {
                                                    ch_2_10.text = "قاعدة صنوبرص علوية امامي يمين و الخلفي يسار"
                                                    customDialogFB.s3er_r2s_acx.setText("10")
                                                } else {
                                                    if (customDialogFB.outsideleft.isChecked && customDialogFB.insideright.isChecked) {
                                                        ch_2_10.text =
                                                            "قاعدة صنوبرص علوية امامي يسار و الخلفي يمين"
                                                        customDialogFB.s3er_r2s_acx.setText("10")
                                                    } else {
                                                        if (customDialogFB.outsideleft.isChecked && customDialogFB.insideleft.isChecked) {
                                                            ch_2_10.text =
                                                                "قاعدة صنوبرص علوية امامي يسار و الخلفي يسار"
                                                            customDialogFB.s3er_r2s_acx.setText("10")
                                                        } else {
                                                            if (customDialogFB.insideright.isChecked && customDialogFB.insideleft.isChecked) {
                                                                ch_2_10.text =
                                                                    "قاعدة صنوبرص علوية خلفي يمين و يسار"
                                                                customDialogFB.s3er_r2s_acx.setText(
                                                                    "10"
                                                                )
                                                            } else {

                                                                if (customDialogFB.outsideright.isChecked) {
                                                                    ch_2_10.text =
                                                                        "قاعدة صنوبرص علوية امامي يمين"
                                                                    customDialogFB.s3er_r2s_acx.setText(
                                                                        "5"
                                                                    )
                                                                }
                                                                if (customDialogFB.outsideleft.isChecked) {
                                                                    ch_2_10.text =
                                                                        "قاعدة صنوبرص علوية امامي يسار"
                                                                    customDialogFB.s3er_r2s_acx.setText(
                                                                        "5"
                                                                    )
                                                                }

                                                                if (customDialogFB.insideleft.isChecked) {
                                                                    ch_2_10.text =
                                                                        "قاعدة صنوبرص علوية خلفي يسار"
                                                                    customDialogFB.s3er_r2s_acx.setText(
                                                                        "5"
                                                                    )
                                                                }
                                                                if (customDialogFB.insideright.isChecked) {
                                                                    ch_2_10.text =
                                                                        "قاعدة صنوبرص علوية خلفي يمين"
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
                        ch_2_10.text = "قاعدة صنوبرص علوية امامي يسار"
                    } else {
                        ch_2_10.text = "قاعدة صنوبرص علوية"
                        customDialogFB.s3er_r2s_acx.setText("")
                    }

                    if (customDialogFB.outsideright.isChecked && customDialogFB.outsideleft.isChecked && customDialogFB.insideright.isChecked && customDialogFB.insideleft.isChecked) {
                        ch_2_10.text = "تغير جميع القواعد  العلوية للصنوبرصات"
                        customDialogFB.s3er_r2s_acx.setText("20")
                    } else {
                        if (customDialogFB.outsideright.isChecked && customDialogFB.outsideleft.isChecked && customDialogFB.insideright.isChecked) {
                            ch_2_10.text = "قاعدة صنوبرص علوية امامي كامل و الخلفي يمين"
                            customDialogFB.s3er_r2s_acx.setText("15")
                        } else {
                            if (customDialogFB.outsideright.isChecked && customDialogFB.outsideleft.isChecked && customDialogFB.insideleft.isChecked) {
                                ch_2_10.text = "قاعدة صنوبرص علوية امامي كامل و الخلفي يسار"
                                customDialogFB.s3er_r2s_acx.setText("15")
                            } else {
                                if (customDialogFB.outsideright.isChecked && customDialogFB.insideright.isChecked && customDialogFB.insideleft.isChecked) {
                                    ch_2_10.text = "قاعدة صنوبرص علوية امامي يمين و الخلفيين"
                                    customDialogFB.s3er_r2s_acx.setText("15")
                                } else {
                                    if (customDialogFB.outsideleft.isChecked && customDialogFB.insideright.isChecked && customDialogFB.insideleft.isChecked) {
                                        ch_2_10.text = "قاعدة صنوبرص علوية امامي يسار و الخلفيين"
                                        customDialogFB.s3er_r2s_acx.setText("15")
                                    } else {
                                        if (customDialogFB.outsideright.isChecked && customDialogFB.outsideleft.isChecked) {
                                            ch_2_10.text = "قاعدة صنوبرص علوية امامي يمين و يسار"
                                            customDialogFB.s3er_r2s_acx.setText("10")
                                        } else {
                                            if (customDialogFB.outsideright.isChecked && customDialogFB.insideright.isChecked) {
                                                ch_2_10.text = "قاعدة صنوبرص علوية امامي يمين و الخلفي يمين"
                                                customDialogFB.s3er_r2s_acx.setText("10")
                                            } else {
                                                if (customDialogFB.outsideright.isChecked && customDialogFB.insideleft.isChecked) {
                                                    ch_2_10.text = "قاعدة صنوبرص علوية امامي يمين و الخلفي يسار"
                                                    customDialogFB.s3er_r2s_acx.setText("10")
                                                } else {
                                                    if (customDialogFB.outsideleft.isChecked && customDialogFB.insideright.isChecked) {
                                                        ch_2_10.text =
                                                            "قاعدة صنوبرص علوية امامي يسار و الخلفي يمين"
                                                        customDialogFB.s3er_r2s_acx.setText("10")
                                                    } else {
                                                        if (customDialogFB.outsideleft.isChecked && customDialogFB.insideleft.isChecked) {
                                                            ch_2_10.text =
                                                                "قاعدة صنوبرص علوية امامي يسار و الخلفي يسار"
                                                            customDialogFB.s3er_r2s_acx.setText("10")
                                                        } else {
                                                            if (customDialogFB.insideright.isChecked && customDialogFB.insideleft.isChecked) {
                                                                ch_2_10.text =
                                                                    "قاعدة صنوبرص علوية خلفي يمين و يسار"
                                                                customDialogFB.s3er_r2s_acx.setText(
                                                                    "10"
                                                                )
                                                            } else {

                                                                if (customDialogFB.outsideright.isChecked) {
                                                                    ch_2_10.text =
                                                                        "قاعدة صنوبرص علوية امامي يمين"
                                                                    customDialogFB.s3er_r2s_acx.setText(
                                                                        "5"
                                                                    )
                                                                }
                                                                if (customDialogFB.outsideleft.isChecked) {
                                                                    ch_2_10.text =
                                                                        "قاعدة صنوبرص علوية امامي يسار"
                                                                    customDialogFB.s3er_r2s_acx.setText(
                                                                        "5"
                                                                    )
                                                                }

                                                                if (customDialogFB.insideleft.isChecked) {
                                                                    ch_2_10.text =
                                                                        "قاعدة صنوبرص علوية خلفي يسار"
                                                                    customDialogFB.s3er_r2s_acx.setText(
                                                                        "5"
                                                                    )
                                                                }
                                                                if (customDialogFB.insideright.isChecked) {
                                                                    ch_2_10.text =
                                                                        "قاعدة صنوبرص علوية خلفي يمين"
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
                        ch_2_10.text = "قاعدة صنوبرص علوية خلفي يمين"
                    } else {
                        ch_2_10.text = "قاعدة صنوبرص علوية"
                        customDialogFB.s3er_r2s_acx.setText("")
                    }

                    if (customDialogFB.outsideright.isChecked && customDialogFB.outsideleft.isChecked && customDialogFB.insideright.isChecked && customDialogFB.insideleft.isChecked) {
                        ch_2_10.text = "تغير جميع القواعد  العلوية للصنوبرصات"
                        customDialogFB.s3er_r2s_acx.setText("20")
                    } else {
                        if (customDialogFB.outsideright.isChecked && customDialogFB.outsideleft.isChecked && customDialogFB.insideright.isChecked) {
                            ch_2_10.text = "قاعدة صنوبرص علوية امامي كامل و الخلفي يمين"
                            customDialogFB.s3er_r2s_acx.setText("15")
                        } else {
                            if (customDialogFB.outsideright.isChecked && customDialogFB.outsideleft.isChecked && customDialogFB.insideleft.isChecked) {
                                ch_2_10.text = "قاعدة صنوبرص علوية امامي كامل و الخلفي يسار"
                                customDialogFB.s3er_r2s_acx.setText("15")
                            } else {
                                if (customDialogFB.outsideright.isChecked && customDialogFB.insideright.isChecked && customDialogFB.insideleft.isChecked) {
                                    ch_2_10.text = "قاعدة صنوبرص علوية امامي يمين و الخلفيين"
                                    customDialogFB.s3er_r2s_acx.setText("15")
                                } else {
                                    if (customDialogFB.outsideleft.isChecked && customDialogFB.insideright.isChecked && customDialogFB.insideleft.isChecked) {
                                        ch_2_10.text = "قاعدة صنوبرص علوية امامي يسار و الخلفيين"
                                        customDialogFB.s3er_r2s_acx.setText("15")
                                    } else {
                                        if (customDialogFB.outsideright.isChecked && customDialogFB.outsideleft.isChecked) {
                                            ch_2_10.text = "قاعدة صنوبرص علوية امامي يمين و يسار"
                                            customDialogFB.s3er_r2s_acx.setText("10")
                                        } else {
                                            if (customDialogFB.outsideright.isChecked && customDialogFB.insideright.isChecked) {
                                                ch_2_10.text = "قاعدة صنوبرص علوية امامي يمين و الخلفي يمين"
                                                customDialogFB.s3er_r2s_acx.setText("10")
                                            } else {
                                                if (customDialogFB.outsideright.isChecked && customDialogFB.insideleft.isChecked) {
                                                    ch_2_10.text = "قاعدة صنوبرص علوية امامي يمين و الخلفي يسار"
                                                    customDialogFB.s3er_r2s_acx.setText("10")
                                                } else {
                                                    if (customDialogFB.outsideleft.isChecked && customDialogFB.insideright.isChecked) {
                                                        ch_2_10.text =
                                                            "قاعدة صنوبرص علوية امامي يسار و الخلفي يمين"
                                                        customDialogFB.s3er_r2s_acx.setText("10")
                                                    } else {
                                                        if (customDialogFB.outsideleft.isChecked && customDialogFB.insideleft.isChecked) {
                                                            ch_2_10.text =
                                                                "قاعدة صنوبرص علوية امامي يسار و الخلفي يسار"
                                                            customDialogFB.s3er_r2s_acx.setText("10")
                                                        } else {
                                                            if (customDialogFB.insideright.isChecked && customDialogFB.insideleft.isChecked) {
                                                                ch_2_10.text =
                                                                    "قاعدة صنوبرص علوية خلفي يمين و يسار"
                                                                customDialogFB.s3er_r2s_acx.setText(
                                                                    "10"
                                                                )
                                                            } else {

                                                                if (customDialogFB.outsideright.isChecked) {
                                                                    ch_2_10.text =
                                                                        "قاعدة صنوبرص علوية امامي يمين"
                                                                    customDialogFB.s3er_r2s_acx.setText(
                                                                        "5"
                                                                    )
                                                                }
                                                                if (customDialogFB.outsideleft.isChecked) {
                                                                    ch_2_10.text =
                                                                        "قاعدة صنوبرص علوية امامي يسار"
                                                                    customDialogFB.s3er_r2s_acx.setText(
                                                                        "5"
                                                                    )
                                                                }

                                                                if (customDialogFB.insideleft.isChecked) {
                                                                    ch_2_10.text =
                                                                        "قاعدة صنوبرص علوية خلفي يسار"
                                                                    customDialogFB.s3er_r2s_acx.setText(
                                                                        "5"
                                                                    )
                                                                }
                                                                if (customDialogFB.insideright.isChecked) {
                                                                    ch_2_10.text =
                                                                        "قاعدة صنوبرص علوية خلفي يمين"
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
                    if (customDialogFB.insideright.isChecked) {
                        ch_2_10.text = "قاعدة صنوبرص علوية خلفي يسار"
                    } else {
                        ch_2_10.text = "قاعدة صنوبرص علوية"
                        customDialogFB.s3er_r2s_acx.setText("")
                    }

                    if (customDialogFB.outsideright.isChecked && customDialogFB.outsideleft.isChecked && customDialogFB.insideright.isChecked && customDialogFB.insideleft.isChecked) {
                        ch_2_10.text = "تغير جميع القواعد  العلوية للصنوبرصات"
                        customDialogFB.s3er_r2s_acx.setText("20")
                    } else {
                        if (customDialogFB.outsideright.isChecked && customDialogFB.outsideleft.isChecked && customDialogFB.insideright.isChecked) {
                            ch_2_10.text = "قاعدة صنوبرص علوية امامي كامل و الخلفي يمين"
                            customDialogFB.s3er_r2s_acx.setText("15")
                        } else {
                            if (customDialogFB.outsideright.isChecked && customDialogFB.outsideleft.isChecked && customDialogFB.insideleft.isChecked) {
                                ch_2_10.text = "قاعدة صنوبرص علوية امامي كامل و الخلفي يسار"
                                customDialogFB.s3er_r2s_acx.setText("15")
                            } else {
                                if (customDialogFB.outsideright.isChecked && customDialogFB.insideright.isChecked && customDialogFB.insideleft.isChecked) {
                                    ch_2_10.text = "قاعدة صنوبرص علوية امامي يمين و الخلفيين"
                                    customDialogFB.s3er_r2s_acx.setText("15")
                                } else {
                                    if (customDialogFB.outsideleft.isChecked && customDialogFB.insideright.isChecked && customDialogFB.insideleft.isChecked) {
                                        ch_2_10.text = "قاعدة صنوبرص علوية امامي يسار و الخلفيين"
                                        customDialogFB.s3er_r2s_acx.setText("15")
                                    } else {
                                        if (customDialogFB.outsideright.isChecked && customDialogFB.outsideleft.isChecked) {
                                            ch_2_10.text = "قاعدة صنوبرص علوية امامي يمين و يسار"
                                            customDialogFB.s3er_r2s_acx.setText("10")
                                        } else {
                                            if (customDialogFB.outsideright.isChecked && customDialogFB.insideright.isChecked) {
                                                ch_2_10.text = "قاعدة صنوبرص علوية امامي يمين و الخلفي يمين"
                                                customDialogFB.s3er_r2s_acx.setText("10")
                                            } else {
                                                if (customDialogFB.outsideright.isChecked && customDialogFB.insideleft.isChecked) {
                                                    ch_2_10.text = "قاعدة صنوبرص علوية امامي يمين و الخلفي يسار"
                                                    customDialogFB.s3er_r2s_acx.setText("10")
                                                } else {
                                                    if (customDialogFB.outsideleft.isChecked && customDialogFB.insideright.isChecked) {
                                                        ch_2_10.text =
                                                            "قاعدة صنوبرص علوية امامي يسار و الخلفي يمين"
                                                        customDialogFB.s3er_r2s_acx.setText("10")
                                                    } else {
                                                        if (customDialogFB.outsideleft.isChecked && customDialogFB.insideleft.isChecked) {
                                                            ch_2_10.text =
                                                                "قاعدة صنوبرص علوية امامي يسار و الخلفي يسار"
                                                            customDialogFB.s3er_r2s_acx.setText("10")
                                                        } else {
                                                            if (customDialogFB.insideright.isChecked && customDialogFB.insideleft.isChecked) {
                                                                ch_2_10.text =
                                                                    "قاعدة صنوبرص علوية خلفي يمين و يسار"
                                                                customDialogFB.s3er_r2s_acx.setText(
                                                                    "10"
                                                                )
                                                            } else {

                                                                if (customDialogFB.outsideright.isChecked) {
                                                                    ch_2_10.text =
                                                                        "قاعدة صنوبرص علوية امامي يمين"
                                                                    customDialogFB.s3er_r2s_acx.setText(
                                                                        "5"
                                                                    )
                                                                }
                                                                if (customDialogFB.outsideleft.isChecked) {
                                                                    ch_2_10.text =
                                                                        "قاعدة صنوبرص علوية امامي يسار"
                                                                    customDialogFB.s3er_r2s_acx.setText(
                                                                        "5"
                                                                    )
                                                                }

                                                                if (customDialogFB.insideleft.isChecked) {
                                                                    ch_2_10.text =
                                                                        "قاعدة صنوبرص علوية خلفي يسار"
                                                                    customDialogFB.s3er_r2s_acx.setText(
                                                                        "5"
                                                                    )
                                                                }
                                                                if (customDialogFB.insideright.isChecked) {
                                                                    ch_2_10.text =
                                                                        "قاعدة صنوبرص علوية خلفي يمين"
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
//                            ch_2_10.isChecked = false
                        } else {
                            p_p_2_10.text = customDialogFB.s3er_r2s_acx.text.toString()
                            viewModel.totalAmount += p_p_2_10.text.toString().toInt()
                            toolbar?.title = "المجموع " + viewModel.totalAmount.toString()
                            customDialogFB.dismiss()
                        }
                    }
                }
                customDialogFB.btn_r2s_can.setOnClickListener {
                    if (p_p_2_10.text.toString().isEmpty()) {
                        ch_2_10.text = "قاعدة صنوبرص علوية"
                        ch_2_10.isChecked = false
                    }
                    customDialogFB.dismiss()
                }

                customDialogFB.show()
            } else {
                if (p_p_2_10.text.toString().isNotEmpty()) {
                    viewModel.totalAmount -= p_p_2_10.text.toString().toInt()
                    toolbar?.title = "المجموع " + viewModel.totalAmount.toString()
                    ch_2_10.text = "قاعدة صنوبرص علوية"
                    p_p_2_10.setText("")
                } else {
                    ch_2_10.text = "قاعدة صنوبرص علوية"
                }
            }
        }

        root.ch_2_11.setOnCheckedChangeListener { _, isChecked ->
            if (ch_2_11.isChecked) {

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
                        ch_2_11.text = "تحشير لقم بريك امامي يمين"
                    } else {
                        ch_2_11.text = "تحشير لقم بريك"
                        customDialogFB.s3er_r2s_acx.setText("")
                    }

                    if (customDialogFB.outsideright.isChecked && customDialogFB.outsideleft.isChecked && customDialogFB.insideright.isChecked && customDialogFB.insideleft.isChecked) {
                        ch_2_11.text = "تحشير جميع لقم البريك"
                        customDialogFB.s3er_r2s_acx.setText("20")
                    } else {
                        if (customDialogFB.outsideright.isChecked && customDialogFB.outsideleft.isChecked && customDialogFB.insideright.isChecked) {
                            ch_2_11.text = "تحشير لقم بريك امامي كامل و الخلفي يمين"
                            customDialogFB.s3er_r2s_acx.setText("15")
                        } else {
                            if (customDialogFB.outsideright.isChecked && customDialogFB.outsideleft.isChecked && customDialogFB.insideleft.isChecked) {
                                ch_2_11.text = "تحشير لقم بريك امامي كامل و الخلفي يسار"
                                customDialogFB.s3er_r2s_acx.setText("15")
                            } else {
                                if (customDialogFB.outsideright.isChecked && customDialogFB.insideright.isChecked && customDialogFB.insideleft.isChecked) {
                                    ch_2_11.text = "تحشير لقم بريك امامي يمين و الخلفيين"
                                    customDialogFB.s3er_r2s_acx.setText("15")
                                } else {
                                    if (customDialogFB.outsideleft.isChecked && customDialogFB.insideright.isChecked && customDialogFB.insideleft.isChecked) {
                                        ch_2_11.text = "تحشير لقم بريك امامي يسار و الخلفيين"
                                        customDialogFB.s3er_r2s_acx.setText("15")
                                    } else {
                                        if (customDialogFB.outsideright.isChecked && customDialogFB.outsideleft.isChecked) {
                                            ch_2_11.text = "تحشير لقم بريك امامي يمين و يسار"
                                            customDialogFB.s3er_r2s_acx.setText("10")
                                        } else {
                                            if (customDialogFB.outsideright.isChecked && customDialogFB.insideright.isChecked) {
                                                ch_2_11.text = "تحشير لقم بريك امامي يمين و الخلفي يمين"
                                                customDialogFB.s3er_r2s_acx.setText("10")
                                            } else {
                                                if (customDialogFB.outsideright.isChecked && customDialogFB.insideleft.isChecked) {
                                                    ch_2_11.text = "تحشير لقم بريك امامي يمين و الخلفي يسار"
                                                    customDialogFB.s3er_r2s_acx.setText("10")
                                                } else {
                                                    if (customDialogFB.outsideleft.isChecked && customDialogFB.insideright.isChecked) {
                                                        ch_2_11.text =
                                                            "تحشير لقم بريك امامي يسار و الخلفي يمين"
                                                        customDialogFB.s3er_r2s_acx.setText("10")
                                                    } else {
                                                        if (customDialogFB.outsideleft.isChecked && customDialogFB.insideleft.isChecked) {
                                                            ch_2_11.text =
                                                                "تحشير لقم بريك امامي يسار و الخلفي يسار"
                                                            customDialogFB.s3er_r2s_acx.setText("10")
                                                        } else {
                                                            if (customDialogFB.insideright.isChecked && customDialogFB.insideleft.isChecked) {
                                                                ch_2_11.text =
                                                                    "تحشير لقم بريك خلفي يمين و يسار"
                                                                customDialogFB.s3er_r2s_acx.setText(
                                                                    "10"
                                                                )
                                                            } else {

                                                                if (customDialogFB.outsideright.isChecked) {
                                                                    ch_2_11.text =
                                                                        "تحشير لقم بريك امامي يمين"
                                                                    customDialogFB.s3er_r2s_acx.setText(
                                                                        "5"
                                                                    )
                                                                }
                                                                if (customDialogFB.outsideleft.isChecked) {
                                                                    ch_2_11.text =
                                                                        "تحشير لقم بريك امامي يسار"
                                                                    customDialogFB.s3er_r2s_acx.setText(
                                                                        "5"
                                                                    )
                                                                }

                                                                if (customDialogFB.insideleft.isChecked) {
                                                                    ch_2_11.text =
                                                                        "تحشير لقم بريك خلفي يسار"
                                                                    customDialogFB.s3er_r2s_acx.setText(
                                                                        "5"
                                                                    )
                                                                }
                                                                if (customDialogFB.insideright.isChecked) {
                                                                    ch_2_11.text =
                                                                        "تحشير لقم بريك خلفي يمين"
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
                        ch_2_11.text = "تحشير لقم بريك امامي يسار"
                    } else {
                        ch_2_11.text = "تحشير لقم بريك"
                        customDialogFB.s3er_r2s_acx.setText("")
                    }

                    if (customDialogFB.outsideright.isChecked && customDialogFB.outsideleft.isChecked && customDialogFB.insideright.isChecked && customDialogFB.insideleft.isChecked) {
                        ch_2_11.text = "تحشير جميع لقم البريك"
                        customDialogFB.s3er_r2s_acx.setText("20")
                    } else {
                        if (customDialogFB.outsideright.isChecked && customDialogFB.outsideleft.isChecked && customDialogFB.insideright.isChecked) {
                            ch_2_11.text = "تحشير لقم بريك امامي كامل و الخلفي يمين"
                            customDialogFB.s3er_r2s_acx.setText("15")
                        } else {
                            if (customDialogFB.outsideright.isChecked && customDialogFB.outsideleft.isChecked && customDialogFB.insideleft.isChecked) {
                                ch_2_11.text = "تحشير لقم بريك امامي كامل و الخلفي يسار"
                                customDialogFB.s3er_r2s_acx.setText("15")
                            } else {
                                if (customDialogFB.outsideright.isChecked && customDialogFB.insideright.isChecked && customDialogFB.insideleft.isChecked) {
                                    ch_2_11.text = "تحشير لقم بريك امامي يمين و الخلفيين"
                                    customDialogFB.s3er_r2s_acx.setText("15")
                                } else {
                                    if (customDialogFB.outsideleft.isChecked && customDialogFB.insideright.isChecked && customDialogFB.insideleft.isChecked) {
                                        ch_2_11.text = "تحشير لقم بريك امامي يسار و الخلفيين"
                                        customDialogFB.s3er_r2s_acx.setText("15")
                                    } else {
                                        if (customDialogFB.outsideright.isChecked && customDialogFB.outsideleft.isChecked) {
                                            ch_2_11.text = "تحشير لقم بريك امامي يمين و يسار"
                                            customDialogFB.s3er_r2s_acx.setText("10")
                                        } else {
                                            if (customDialogFB.outsideright.isChecked && customDialogFB.insideright.isChecked) {
                                                ch_2_11.text = "تحشير لقم بريك امامي يمين و الخلفي يمين"
                                                customDialogFB.s3er_r2s_acx.setText("10")
                                            } else {
                                                if (customDialogFB.outsideright.isChecked && customDialogFB.insideleft.isChecked) {
                                                    ch_2_11.text = "تحشير لقم بريك امامي يمين و الخلفي يسار"
                                                    customDialogFB.s3er_r2s_acx.setText("10")
                                                } else {
                                                    if (customDialogFB.outsideleft.isChecked && customDialogFB.insideright.isChecked) {
                                                        ch_2_11.text =
                                                            "تحشير لقم بريك امامي يسار و الخلفي يمين"
                                                        customDialogFB.s3er_r2s_acx.setText("10")
                                                    } else {
                                                        if (customDialogFB.outsideleft.isChecked && customDialogFB.insideleft.isChecked) {
                                                            ch_2_11.text =
                                                                "تحشير لقم بريك امامي يسار و الخلفي يسار"
                                                            customDialogFB.s3er_r2s_acx.setText("10")
                                                        } else {
                                                            if (customDialogFB.insideright.isChecked && customDialogFB.insideleft.isChecked) {
                                                                ch_2_11.text =
                                                                    "تحشير لقم بريك خلفي يمين و يسار"
                                                                customDialogFB.s3er_r2s_acx.setText(
                                                                    "10"
                                                                )
                                                            } else {

                                                                if (customDialogFB.outsideright.isChecked) {
                                                                    ch_2_11.text =
                                                                        "تحشير لقم بريك امامي يمين"
                                                                    customDialogFB.s3er_r2s_acx.setText(
                                                                        "5"
                                                                    )
                                                                }
                                                                if (customDialogFB.outsideleft.isChecked) {
                                                                    ch_2_11.text =
                                                                        "تحشير لقم بريك امامي يسار"
                                                                    customDialogFB.s3er_r2s_acx.setText(
                                                                        "5"
                                                                    )
                                                                }

                                                                if (customDialogFB.insideleft.isChecked) {
                                                                    ch_2_11.text =
                                                                        "تحشير لقم بريك خلفي يسار"
                                                                    customDialogFB.s3er_r2s_acx.setText(
                                                                        "5"
                                                                    )
                                                                }
                                                                if (customDialogFB.insideright.isChecked) {
                                                                    ch_2_11.text =
                                                                        "تحشير لقم بريك خلفي يمين"
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
                        ch_2_11.text = "تحشير لقم بريك خلفي يسار"
                    } else {
                        ch_2_11.text = "تحشير لقم بريك"
                        customDialogFB.s3er_r2s_acx.setText("")
                    }

                    if (customDialogFB.outsideright.isChecked && customDialogFB.outsideleft.isChecked && customDialogFB.insideright.isChecked && customDialogFB.insideleft.isChecked) {
                        ch_2_11.text = "تحشير جميع لقم البريك"
                        customDialogFB.s3er_r2s_acx.setText("20")
                    } else {
                        if (customDialogFB.outsideright.isChecked && customDialogFB.outsideleft.isChecked && customDialogFB.insideright.isChecked) {
                            ch_2_11.text = "تحشير لقم بريك امامي كامل و الخلفي يمين"
                            customDialogFB.s3er_r2s_acx.setText("15")
                        } else {
                            if (customDialogFB.outsideright.isChecked && customDialogFB.outsideleft.isChecked && customDialogFB.insideleft.isChecked) {
                                ch_2_11.text = "تحشير لقم بريك امامي كامل و الخلفي يسار"
                                customDialogFB.s3er_r2s_acx.setText("15")
                            } else {
                                if (customDialogFB.outsideright.isChecked && customDialogFB.insideright.isChecked && customDialogFB.insideleft.isChecked) {
                                    ch_2_11.text = "تحشير لقم بريك امامي يمين و الخلفيين"
                                    customDialogFB.s3er_r2s_acx.setText("15")
                                } else {
                                    if (customDialogFB.outsideleft.isChecked && customDialogFB.insideright.isChecked && customDialogFB.insideleft.isChecked) {
                                        ch_2_11.text = "تحشير لقم بريك امامي يسار و الخلفيين"
                                        customDialogFB.s3er_r2s_acx.setText("15")
                                    } else {
                                        if (customDialogFB.outsideright.isChecked && customDialogFB.outsideleft.isChecked) {
                                            ch_2_11.text = "تحشير لقم بريك امامي يمين و يسار"
                                            customDialogFB.s3er_r2s_acx.setText("10")
                                        } else {
                                            if (customDialogFB.outsideright.isChecked && customDialogFB.insideright.isChecked) {
                                                ch_2_11.text = "تحشير لقم بريك امامي يمين و الخلفي يمين"
                                                customDialogFB.s3er_r2s_acx.setText("10")
                                            } else {
                                                if (customDialogFB.outsideright.isChecked && customDialogFB.insideleft.isChecked) {
                                                    ch_2_11.text = "تحشير لقم بريك امامي يمين و الخلفي يسار"
                                                    customDialogFB.s3er_r2s_acx.setText("10")
                                                } else {
                                                    if (customDialogFB.outsideleft.isChecked && customDialogFB.insideright.isChecked) {
                                                        ch_2_11.text =
                                                            "تحشير لقم بريك امامي يسار و الخلفي يمين"
                                                        customDialogFB.s3er_r2s_acx.setText("10")
                                                    } else {
                                                        if (customDialogFB.outsideleft.isChecked && customDialogFB.insideleft.isChecked) {
                                                            ch_2_11.text =
                                                                "تحشير لقم بريك امامي يسار و الخلفي يسار"
                                                            customDialogFB.s3er_r2s_acx.setText("10")
                                                        } else {
                                                            if (customDialogFB.insideright.isChecked && customDialogFB.insideleft.isChecked) {
                                                                ch_2_11.text =
                                                                    "تحشير لقم بريك خلفي يمين و يسار"
                                                                customDialogFB.s3er_r2s_acx.setText(
                                                                    "10"
                                                                )
                                                            } else {

                                                                if (customDialogFB.outsideright.isChecked) {
                                                                    ch_2_11.text =
                                                                        "تحشير لقم بريك امامي يمين"
                                                                    customDialogFB.s3er_r2s_acx.setText(
                                                                        "5"
                                                                    )
                                                                }
                                                                if (customDialogFB.outsideleft.isChecked) {
                                                                    ch_2_11.text =
                                                                        "تحشير لقم بريك امامي يسار"
                                                                    customDialogFB.s3er_r2s_acx.setText(
                                                                        "5"
                                                                    )
                                                                }

                                                                if (customDialogFB.insideleft.isChecked) {
                                                                    ch_2_11.text =
                                                                        "تحشير لقم بريك خلفي يسار"
                                                                    customDialogFB.s3er_r2s_acx.setText(
                                                                        "5"
                                                                    )
                                                                }
                                                                if (customDialogFB.insideright.isChecked) {
                                                                    ch_2_11.text =
                                                                        "تحشير لقم بريك خلفي يمين"
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
                    if (customDialogFB.insideright.isChecked) {
                        ch_2_11.text = "تحشير لقم بريك خلفي يمين"
                    } else {
                        ch_2_11.text = "تحشير لقم بريك"
                        customDialogFB.s3er_r2s_acx.setText("")
                    }

                    if (customDialogFB.outsideright.isChecked && customDialogFB.outsideleft.isChecked && customDialogFB.insideright.isChecked && customDialogFB.insideleft.isChecked) {
                        ch_2_11.text = "تحشير جميع لقم البريك"
                        customDialogFB.s3er_r2s_acx.setText("20")
                    } else {
                        if (customDialogFB.outsideright.isChecked && customDialogFB.outsideleft.isChecked && customDialogFB.insideright.isChecked) {
                            ch_2_11.text = "تحشير لقم بريك امامي كامل و الخلفي يمين"
                            customDialogFB.s3er_r2s_acx.setText("15")
                        } else {
                            if (customDialogFB.outsideright.isChecked && customDialogFB.outsideleft.isChecked && customDialogFB.insideleft.isChecked) {
                                ch_2_11.text = "تحشير لقم بريك امامي كامل و الخلفي يسار"
                                customDialogFB.s3er_r2s_acx.setText("15")
                            } else {
                                if (customDialogFB.outsideright.isChecked && customDialogFB.insideright.isChecked && customDialogFB.insideleft.isChecked) {
                                    ch_2_11.text = "تحشير لقم بريك امامي يمين و الخلفيين"
                                    customDialogFB.s3er_r2s_acx.setText("15")
                                } else {
                                    if (customDialogFB.outsideleft.isChecked && customDialogFB.insideright.isChecked && customDialogFB.insideleft.isChecked) {
                                        ch_2_11.text = "تحشير لقم بريك امامي يسار و الخلفيين"
                                        customDialogFB.s3er_r2s_acx.setText("15")
                                    } else {
                                        if (customDialogFB.outsideright.isChecked && customDialogFB.outsideleft.isChecked) {
                                            ch_2_11.text = "تحشير لقم بريك امامي يمين و يسار"
                                            customDialogFB.s3er_r2s_acx.setText("10")
                                        } else {
                                            if (customDialogFB.outsideright.isChecked && customDialogFB.insideright.isChecked) {
                                                ch_2_11.text = "تحشير لقم بريك امامي يمين و الخلفي يمين"
                                                customDialogFB.s3er_r2s_acx.setText("10")
                                            } else {
                                                if (customDialogFB.outsideright.isChecked && customDialogFB.insideleft.isChecked) {
                                                    ch_2_11.text = "تحشير لقم بريك امامي يمين و الخلفي يسار"
                                                    customDialogFB.s3er_r2s_acx.setText("10")
                                                } else {
                                                    if (customDialogFB.outsideleft.isChecked && customDialogFB.insideright.isChecked) {
                                                        ch_2_11.text =
                                                            "تحشير لقم بريك امامي يسار و الخلفي يمين"
                                                        customDialogFB.s3er_r2s_acx.setText("10")
                                                    } else {
                                                        if (customDialogFB.outsideleft.isChecked && customDialogFB.insideleft.isChecked) {
                                                            ch_2_11.text =
                                                                "تحشير لقم بريك امامي يسار و الخلفي يسار"
                                                            customDialogFB.s3er_r2s_acx.setText("10")
                                                        } else {
                                                            if (customDialogFB.insideright.isChecked && customDialogFB.insideleft.isChecked) {
                                                                ch_2_11.text =
                                                                    "تحشير لقم بريك خلفي يمين و يسار"
                                                                customDialogFB.s3er_r2s_acx.setText(
                                                                    "10"
                                                                )
                                                            } else {

                                                                if (customDialogFB.outsideright.isChecked) {
                                                                    ch_2_11.text =
                                                                        "تحشير لقم بريك امامي يمين"
                                                                    customDialogFB.s3er_r2s_acx.setText(
                                                                        "5"
                                                                    )
                                                                }
                                                                if (customDialogFB.outsideleft.isChecked) {
                                                                    ch_2_11.text =
                                                                        "تحشير لقم بريك امامي يسار"
                                                                    customDialogFB.s3er_r2s_acx.setText(
                                                                        "5"
                                                                    )
                                                                }

                                                                if (customDialogFB.insideleft.isChecked) {
                                                                    ch_2_11.text =
                                                                        "تحشير لقم بريك خلفي يسار"
                                                                    customDialogFB.s3er_r2s_acx.setText(
                                                                        "5"
                                                                    )
                                                                }
                                                                if (customDialogFB.insideright.isChecked) {
                                                                    ch_2_11.text =
                                                                        "تحشير لقم بريك خلفي يمين"
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
//                            ch_2_11.isChecked = false
                        } else {
                            p_p_2_11.text = customDialogFB.s3er_r2s_acx.text.toString()
                            viewModel.totalAmount += p_p_2_11.text.toString().toInt()
                            toolbar?.title = "المجموع " + viewModel.totalAmount.toString()
                            customDialogFB.dismiss()
                        }
                    }
                }
                customDialogFB.btn_r2s_can.setOnClickListener {
                    if (p_p_2_11.text.toString().isEmpty()) {
                        ch_2_11.text = "تحشير لقم بريك"
                        ch_2_11.isChecked = false
                    }
                    customDialogFB.dismiss()
                }

                customDialogFB.show()
            } else {
                if (p_p_2_11.text.toString().isNotEmpty()) {
                    viewModel.totalAmount -= p_p_2_11.text.toString().toInt()
                    toolbar?.title = "المجموع " + viewModel.totalAmount.toString()
                    ch_2_11.text = "تحشير لقم بريك"
                    p_p_2_11.setText("")
                } else {
                    ch_2_11.text = "تحشير لقم بريك"
                }
            }
        }

        root.ch_2_12.setOnCheckedChangeListener { _, isChecked ->
            if (ch_2_12.isChecked) {

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
                        ch_2_12.text = "بيلية قاعدة صنوبرص امامي يمين"
                    } else {
                        ch_2_12.text = "بيلية قاعدة صنوبرص"
                        customDialogFB.s3er_r2s_acx.setText("")
                    }

                    if (customDialogFB.outsideright.isChecked && customDialogFB.outsideleft.isChecked && customDialogFB.insideright.isChecked && customDialogFB.insideleft.isChecked) {
                        ch_2_12.text = "تغير جميع بيل قاعدة صنوبرص"
                        customDialogFB.s3er_r2s_acx.setText("40")
                    } else {
                        if (customDialogFB.outsideright.isChecked && customDialogFB.outsideleft.isChecked && customDialogFB.insideright.isChecked) {
                            ch_2_12.text = "بيلية قاعدة صنوبرص امامي كامل و الخلفي يمين"
                            customDialogFB.s3er_r2s_acx.setText("30")
                        } else {
                            if (customDialogFB.outsideright.isChecked && customDialogFB.outsideleft.isChecked && customDialogFB.insideleft.isChecked) {
                                ch_2_12.text = "بيلية قاعدة صنوبرص امامي كامل و الخلفي يسار"
                                customDialogFB.s3er_r2s_acx.setText("30")
                            } else {
                                if (customDialogFB.outsideright.isChecked && customDialogFB.insideright.isChecked && customDialogFB.insideleft.isChecked) {
                                    ch_2_12.text = "بيلية قاعدة صنوبرص امامي يمين و الخلفيين"
                                    customDialogFB.s3er_r2s_acx.setText("30")
                                } else {
                                    if (customDialogFB.outsideleft.isChecked && customDialogFB.insideright.isChecked && customDialogFB.insideleft.isChecked) {
                                        ch_2_12.text = "بيلية قاعدة صنوبرص امامي يسار و الخلفيين"
                                        customDialogFB.s3er_r2s_acx.setText("30")
                                    } else {
                                        if (customDialogFB.outsideright.isChecked && customDialogFB.outsideleft.isChecked) {
                                            ch_2_12.text = "بيلية قاعدة صنوبرص امامي يمين و يسار"
                                            customDialogFB.s3er_r2s_acx.setText("20")
                                        } else {
                                            if (customDialogFB.outsideright.isChecked && customDialogFB.insideright.isChecked) {
                                                ch_2_12.text = "بيلية قاعدة صنوبرص امامي يمين و الخلفي يمين"
                                                customDialogFB.s3er_r2s_acx.setText("20")
                                            } else {
                                                if (customDialogFB.outsideright.isChecked && customDialogFB.insideleft.isChecked) {
                                                    ch_2_12.text = "بيلية قاعدة صنوبرص امامي يمين و الخلفي يسار"
                                                    customDialogFB.s3er_r2s_acx.setText("20")
                                                } else {
                                                    if (customDialogFB.outsideleft.isChecked && customDialogFB.insideright.isChecked) {
                                                        ch_2_12.text =
                                                            "بيلية قاعدة صنوبرص امامي يسار و الخلفي يمين"
                                                        customDialogFB.s3er_r2s_acx.setText("20")
                                                    } else {
                                                        if (customDialogFB.outsideleft.isChecked && customDialogFB.insideleft.isChecked) {
                                                            ch_2_12.text =
                                                                "بيلية قاعدة صنوبرص امامي يسار و الخلفي يسار"
                                                            customDialogFB.s3er_r2s_acx.setText("20")
                                                        } else {
                                                            if (customDialogFB.insideright.isChecked && customDialogFB.insideleft.isChecked) {
                                                                ch_2_12.text =
                                                                    "بيلية قاعدة صنوبرص خلفي يمين و يسار"
                                                                customDialogFB.s3er_r2s_acx.setText(
                                                                    "20"
                                                                )
                                                            } else {

                                                                if (customDialogFB.outsideright.isChecked) {
                                                                    ch_2_12.text =
                                                                        "بيلية قاعدة صنوبرص امامي يمين"
                                                                    customDialogFB.s3er_r2s_acx.setText(
                                                                        "10"
                                                                    )
                                                                }
                                                                if (customDialogFB.outsideleft.isChecked) {
                                                                    ch_2_12.text =
                                                                        "بيلية قاعدة صنوبرص امامي يسار"
                                                                    customDialogFB.s3er_r2s_acx.setText(
                                                                        "10"
                                                                    )
                                                                }

                                                                if (customDialogFB.insideleft.isChecked) {
                                                                    ch_2_12.text =
                                                                        "بيلية قاعدة صنوبرص خلفي يسار"
                                                                    customDialogFB.s3er_r2s_acx.setText(
                                                                        "10"
                                                                    )
                                                                }
                                                                if (customDialogFB.insideright.isChecked) {
                                                                    ch_2_12.text =
                                                                        "بيلية قاعدة صنوبرص خلفي يمين"
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
                        ch_2_12.text = "بيلية قاعدة صنوبرص امامي يسار"
                    } else {
                        ch_2_12.text = "بيلية قاعدة صنوبرص"
                        customDialogFB.s3er_r2s_acx.setText("")
                    }

                    if (customDialogFB.outsideright.isChecked && customDialogFB.outsideleft.isChecked && customDialogFB.insideright.isChecked && customDialogFB.insideleft.isChecked) {
                        ch_2_12.text = "تغير جميع بيل قاعدة صنوبرص"
                        customDialogFB.s3er_r2s_acx.setText("40")
                    } else {
                        if (customDialogFB.outsideright.isChecked && customDialogFB.outsideleft.isChecked && customDialogFB.insideright.isChecked) {
                            ch_2_12.text = "بيلية قاعدة صنوبرص امامي كامل و الخلفي يمين"
                            customDialogFB.s3er_r2s_acx.setText("30")
                        } else {
                            if (customDialogFB.outsideright.isChecked && customDialogFB.outsideleft.isChecked && customDialogFB.insideleft.isChecked) {
                                ch_2_12.text = "بيلية قاعدة صنوبرص امامي كامل و الخلفي يسار"
                                customDialogFB.s3er_r2s_acx.setText("30")
                            } else {
                                if (customDialogFB.outsideright.isChecked && customDialogFB.insideright.isChecked && customDialogFB.insideleft.isChecked) {
                                    ch_2_12.text = "بيلية قاعدة صنوبرص امامي يمين و الخلفيين"
                                    customDialogFB.s3er_r2s_acx.setText("30")
                                } else {
                                    if (customDialogFB.outsideleft.isChecked && customDialogFB.insideright.isChecked && customDialogFB.insideleft.isChecked) {
                                        ch_2_12.text = "بيلية قاعدة صنوبرص امامي يسار و الخلفيين"
                                        customDialogFB.s3er_r2s_acx.setText("30")
                                    } else {
                                        if (customDialogFB.outsideright.isChecked && customDialogFB.outsideleft.isChecked) {
                                            ch_2_12.text = "بيلية قاعدة صنوبرص امامي يمين و يسار"
                                            customDialogFB.s3er_r2s_acx.setText("20")
                                        } else {
                                            if (customDialogFB.outsideright.isChecked && customDialogFB.insideright.isChecked) {
                                                ch_2_12.text = "بيلية قاعدة صنوبرص امامي يمين و الخلفي يمين"
                                                customDialogFB.s3er_r2s_acx.setText("20")
                                            } else {
                                                if (customDialogFB.outsideright.isChecked && customDialogFB.insideleft.isChecked) {
                                                    ch_2_12.text = "بيلية قاعدة صنوبرص امامي يمين و الخلفي يسار"
                                                    customDialogFB.s3er_r2s_acx.setText("20")
                                                } else {
                                                    if (customDialogFB.outsideleft.isChecked && customDialogFB.insideright.isChecked) {
                                                        ch_2_12.text =
                                                            "بيلية قاعدة صنوبرص امامي يسار و الخلفي يمين"
                                                        customDialogFB.s3er_r2s_acx.setText("20")
                                                    } else {
                                                        if (customDialogFB.outsideleft.isChecked && customDialogFB.insideleft.isChecked) {
                                                            ch_2_12.text =
                                                                "بيلية قاعدة صنوبرص امامي يسار و الخلفي يسار"
                                                            customDialogFB.s3er_r2s_acx.setText("20")
                                                        } else {
                                                            if (customDialogFB.insideright.isChecked && customDialogFB.insideleft.isChecked) {
                                                                ch_2_12.text =
                                                                    "بيلية قاعدة صنوبرص خلفي يمين و يسار"
                                                                customDialogFB.s3er_r2s_acx.setText(
                                                                    "20"
                                                                )
                                                            } else {

                                                                if (customDialogFB.outsideright.isChecked) {
                                                                    ch_2_12.text =
                                                                        "بيلية قاعدة صنوبرص امامي يمين"
                                                                    customDialogFB.s3er_r2s_acx.setText(
                                                                        "10"
                                                                    )
                                                                }
                                                                if (customDialogFB.outsideleft.isChecked) {
                                                                    ch_2_12.text =
                                                                        "بيلية قاعدة صنوبرص امامي يسار"
                                                                    customDialogFB.s3er_r2s_acx.setText(
                                                                        "10"
                                                                    )
                                                                }

                                                                if (customDialogFB.insideleft.isChecked) {
                                                                    ch_2_12.text =
                                                                        "بيلية قاعدة صنوبرص خلفي يسار"
                                                                    customDialogFB.s3er_r2s_acx.setText(
                                                                        "10"
                                                                    )
                                                                }
                                                                if (customDialogFB.insideright.isChecked) {
                                                                    ch_2_12.text =
                                                                        "بيلية قاعدة صنوبرص خلفي يمين"
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
                        ch_2_12.text = "بيلية قاعدة صنوبرص خلفي يسار"
                    } else {
                        ch_2_12.text = "بيلية قاعدة صنوبرص"
                        customDialogFB.s3er_r2s_acx.setText("")
                    }

                    if (customDialogFB.outsideright.isChecked && customDialogFB.outsideleft.isChecked && customDialogFB.insideright.isChecked && customDialogFB.insideleft.isChecked) {
                        ch_2_12.text = "تغير جميع بيل قاعدة صنوبرص"
                        customDialogFB.s3er_r2s_acx.setText("40")
                    } else {
                        if (customDialogFB.outsideright.isChecked && customDialogFB.outsideleft.isChecked && customDialogFB.insideright.isChecked) {
                            ch_2_12.text = "بيلية قاعدة صنوبرص امامي كامل و الخلفي يمين"
                            customDialogFB.s3er_r2s_acx.setText("30")
                        } else {
                            if (customDialogFB.outsideright.isChecked && customDialogFB.outsideleft.isChecked && customDialogFB.insideleft.isChecked) {
                                ch_2_12.text = "بيلية قاعدة صنوبرص امامي كامل و الخلفي يسار"
                                customDialogFB.s3er_r2s_acx.setText("30")
                            } else {
                                if (customDialogFB.outsideright.isChecked && customDialogFB.insideright.isChecked && customDialogFB.insideleft.isChecked) {
                                    ch_2_12.text = "بيلية قاعدة صنوبرص امامي يمين و الخلفيين"
                                    customDialogFB.s3er_r2s_acx.setText("30")
                                } else {
                                    if (customDialogFB.outsideleft.isChecked && customDialogFB.insideright.isChecked && customDialogFB.insideleft.isChecked) {
                                        ch_2_12.text = "بيلية قاعدة صنوبرص امامي يسار و الخلفيين"
                                        customDialogFB.s3er_r2s_acx.setText("30")
                                    } else {
                                        if (customDialogFB.outsideright.isChecked && customDialogFB.outsideleft.isChecked) {
                                            ch_2_12.text = "بيلية قاعدة صنوبرص امامي يمين و يسار"
                                            customDialogFB.s3er_r2s_acx.setText("20")
                                        } else {
                                            if (customDialogFB.outsideright.isChecked && customDialogFB.insideright.isChecked) {
                                                ch_2_12.text = "بيلية قاعدة صنوبرص امامي يمين و الخلفي يمين"
                                                customDialogFB.s3er_r2s_acx.setText("20")
                                            } else {
                                                if (customDialogFB.outsideright.isChecked && customDialogFB.insideleft.isChecked) {
                                                    ch_2_12.text = "بيلية قاعدة صنوبرص امامي يمين و الخلفي يسار"
                                                    customDialogFB.s3er_r2s_acx.setText("20")
                                                } else {
                                                    if (customDialogFB.outsideleft.isChecked && customDialogFB.insideright.isChecked) {
                                                        ch_2_12.text =
                                                            "بيلية قاعدة صنوبرص امامي يسار و الخلفي يمين"
                                                        customDialogFB.s3er_r2s_acx.setText("20")
                                                    } else {
                                                        if (customDialogFB.outsideleft.isChecked && customDialogFB.insideleft.isChecked) {
                                                            ch_2_12.text =
                                                                "بيلية قاعدة صنوبرص امامي يسار و الخلفي يسار"
                                                            customDialogFB.s3er_r2s_acx.setText("20")
                                                        } else {
                                                            if (customDialogFB.insideright.isChecked && customDialogFB.insideleft.isChecked) {
                                                                ch_2_12.text =
                                                                    "بيلية قاعدة صنوبرص خلفي يمين و يسار"
                                                                customDialogFB.s3er_r2s_acx.setText(
                                                                    "20"
                                                                )
                                                            } else {

                                                                if (customDialogFB.outsideright.isChecked) {
                                                                    ch_2_12.text =
                                                                        "بيلية قاعدة صنوبرص امامي يمين"
                                                                    customDialogFB.s3er_r2s_acx.setText(
                                                                        "10"
                                                                    )
                                                                }
                                                                if (customDialogFB.outsideleft.isChecked) {
                                                                    ch_2_12.text =
                                                                        "بيلية قاعدة صنوبرص امامي يسار"
                                                                    customDialogFB.s3er_r2s_acx.setText(
                                                                        "10"
                                                                    )
                                                                }

                                                                if (customDialogFB.insideleft.isChecked) {
                                                                    ch_2_12.text =
                                                                        "بيلية قاعدة صنوبرص خلفي يسار"
                                                                    customDialogFB.s3er_r2s_acx.setText(
                                                                        "10"
                                                                    )
                                                                }
                                                                if (customDialogFB.insideright.isChecked) {
                                                                    ch_2_12.text =
                                                                        "بيلية قاعدة صنوبرص خلفي يمين"
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
                        ch_2_12.text = "بيلية قاعدة صنوبرص خلفي يمين"
                    } else {
                        ch_2_12.text = "بيلية قاعدة صنوبرص"
                        customDialogFB.s3er_r2s_acx.setText("")
                    }

                    if (customDialogFB.outsideright.isChecked && customDialogFB.outsideleft.isChecked && customDialogFB.insideright.isChecked && customDialogFB.insideleft.isChecked) {
                        ch_2_12.text = "تغير جميع بيل قاعدة صنوبرص"
                        customDialogFB.s3er_r2s_acx.setText("40")
                    } else {
                        if (customDialogFB.outsideright.isChecked && customDialogFB.outsideleft.isChecked && customDialogFB.insideright.isChecked) {
                            ch_2_12.text = "بيلية قاعدة صنوبرص امامي كامل و الخلفي يمين"
                            customDialogFB.s3er_r2s_acx.setText("30")
                        } else {
                            if (customDialogFB.outsideright.isChecked && customDialogFB.outsideleft.isChecked && customDialogFB.insideleft.isChecked) {
                                ch_2_12.text = "بيلية قاعدة صنوبرص امامي كامل و الخلفي يسار"
                                customDialogFB.s3er_r2s_acx.setText("30")
                            } else {
                                if (customDialogFB.outsideright.isChecked && customDialogFB.insideright.isChecked && customDialogFB.insideleft.isChecked) {
                                    ch_2_12.text = "بيلية قاعدة صنوبرص امامي يمين و الخلفيين"
                                    customDialogFB.s3er_r2s_acx.setText("30")
                                } else {
                                    if (customDialogFB.outsideleft.isChecked && customDialogFB.insideright.isChecked && customDialogFB.insideleft.isChecked) {
                                        ch_2_12.text = "بيلية قاعدة صنوبرص امامي يسار و الخلفيين"
                                        customDialogFB.s3er_r2s_acx.setText("30")
                                    } else {
                                        if (customDialogFB.outsideright.isChecked && customDialogFB.outsideleft.isChecked) {
                                            ch_2_12.text = "بيلية قاعدة صنوبرص امامي يمين و يسار"
                                            customDialogFB.s3er_r2s_acx.setText("20")
                                        } else {
                                            if (customDialogFB.outsideright.isChecked && customDialogFB.insideright.isChecked) {
                                                ch_2_12.text = "بيلية قاعدة صنوبرص امامي يمين و الخلفي يمين"
                                                customDialogFB.s3er_r2s_acx.setText("20")
                                            } else {
                                                if (customDialogFB.outsideright.isChecked && customDialogFB.insideleft.isChecked) {
                                                    ch_2_12.text = "بيلية قاعدة صنوبرص امامي يمين و الخلفي يسار"
                                                    customDialogFB.s3er_r2s_acx.setText("20")
                                                } else {
                                                    if (customDialogFB.outsideleft.isChecked && customDialogFB.insideright.isChecked) {
                                                        ch_2_12.text =
                                                            "بيلية قاعدة صنوبرص امامي يسار و الخلفي يمين"
                                                        customDialogFB.s3er_r2s_acx.setText("20")
                                                    } else {
                                                        if (customDialogFB.outsideleft.isChecked && customDialogFB.insideleft.isChecked) {
                                                            ch_2_12.text =
                                                                "بيلية قاعدة صنوبرص امامي يسار و الخلفي يسار"
                                                            customDialogFB.s3er_r2s_acx.setText("20")
                                                        } else {
                                                            if (customDialogFB.insideright.isChecked && customDialogFB.insideleft.isChecked) {
                                                                ch_2_12.text =
                                                                    "بيلية قاعدة صنوبرص خلفي يمين و يسار"
                                                                customDialogFB.s3er_r2s_acx.setText(
                                                                    "20"
                                                                )
                                                            } else {

                                                                if (customDialogFB.outsideright.isChecked) {
                                                                    ch_2_12.text =
                                                                        "بيلية قاعدة صنوبرص امامي يمين"
                                                                    customDialogFB.s3er_r2s_acx.setText(
                                                                        "10"
                                                                    )
                                                                }
                                                                if (customDialogFB.outsideleft.isChecked) {
                                                                    ch_2_12.text =
                                                                        "بيلية قاعدة صنوبرص امامي يسار"
                                                                    customDialogFB.s3er_r2s_acx.setText(
                                                                        "10"
                                                                    )
                                                                }

                                                                if (customDialogFB.insideleft.isChecked) {
                                                                    ch_2_12.text =
                                                                        "بيلية قاعدة صنوبرص خلفي يسار"
                                                                    customDialogFB.s3er_r2s_acx.setText(
                                                                        "10"
                                                                    )
                                                                }
                                                                if (customDialogFB.insideright.isChecked) {
                                                                    ch_2_12.text =
                                                                        "بيلية قاعدة صنوبرص خلفي يمين"
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
//                            ch_2_12.isChecked = false
                        } else {
                            p_p_2_12.text = customDialogFB.s3er_r2s_acx.text.toString()
                            viewModel.totalAmount += p_p_2_12.text.toString().toInt()
                            toolbar?.title = "المجموع " + viewModel.totalAmount.toString()
                            customDialogFB.dismiss()
                        }
                    }
                }
                customDialogFB.btn_r2s_can.setOnClickListener {
                    if (p_p_2_12.text.toString().isEmpty()) {
                        ch_2_12.text = "بيلية قاعدة صنوبرص"
                        ch_2_12.isChecked = false
                    }
                    customDialogFB.dismiss()
                }

                customDialogFB.show()
            } else {
                if (p_p_2_12.text.toString().isNotEmpty()) {
                    viewModel.totalAmount -= p_p_2_12.text.toString().toInt()
                    toolbar?.title = "المجموع " + viewModel.totalAmount.toString()
                    ch_2_12.text = "بيلية قاعدة صنوبرص"
                    p_p_2_12.setText("")
                } else {
                    ch_2_12.text = "بيلية قاعدة صنوبرص"
                }
            }
        }

        root.ch_2_13.setOnCheckedChangeListener { _, isChecked ->
            if (ch_2_13.isChecked) {
                val customDialogFB = Dialog(activity!!)
                customDialogFB.setContentView(R.layout.dialog_mezan)
                customDialogFB.setCancelable(false)
                customDialogFB.window?.setLayout(
                    ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT)
                val window = customDialogFB.window
                window?.setGravity(Gravity.TOP)
                val lp = window?.attributes
                lp?.dimAmount = 0.0f
                lp?.flags = lp?.flags?.or(WindowManager.LayoutParams.FLAG_DIM_BEHIND)
                window?.attributes = lp

                customDialogFB.front.setOnCheckedChangeListener { _, isChecked1 ->
                    if (customDialogFB.front.isChecked) {
                        ch_2_13.text =
                            ch_2_13.text.toString() + " " + customDialogFB.front.text.toString()
                    } else {
                        ch_2_13.text = "طقم اصلاح مجموعة ستيرنج"
                        customDialogFB.s3er_yadwee_fa7.setText("")
                    }

                    if (customDialogFB.front.isChecked && customDialogFB.rear.isChecked) {
                        ch_2_13.text = "طقم اصلاح مجموعة ستيرنج علوية و سفلية"
                        customDialogFB.s3er_yadwee_fa7.setText("60")
                    } else {
                        if (customDialogFB.front.isChecked) {
                            ch_2_13.text = "طقم اصلاح مجموعة ستيرنج علوية"
                            customDialogFB.s3er_yadwee_fa7.setText("25")
                        }
                        if (customDialogFB.rear.isChecked) {
                            ch_2_13.text = "طقم اصلاح مجموعة ستيرنج سفلية"
                            customDialogFB.s3er_yadwee_fa7.setText("35")
                        }
                    }
                }
                customDialogFB.rear.setOnCheckedChangeListener { _, isChecked2 ->
                    if (customDialogFB.rear.isChecked) {
                        ch_2_13.text = ch_2_13.text.toString() + " " +
                                customDialogFB.rear.text.toString()
                    }else{ch_2_13.text = "طقم اصلاح مجموعة ستيرنج"
                        customDialogFB.s3er_yadwee_fa7.setText("")}

                    if (customDialogFB.rear.isChecked && customDialogFB.front.isChecked){
                        ch_2_13.text = "طقم اصلاح مجموعة ستيرنج علوية و سفلية"
                        customDialogFB.s3er_yadwee_fa7.setText("60")
                    }else {
                        if (customDialogFB.front.isChecked) {
                            ch_2_13.text = "طقم اصلاح مجموعة ستيرنج علوية"
                            customDialogFB.s3er_yadwee_fa7.setText("25")
                        }
                        if (customDialogFB.rear.isChecked) {
                            ch_2_13.text = "طقم اصلاح مجموعة ستيرنج سفلية"
                            customDialogFB.s3er_yadwee_fa7.setText("35")
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
//                            ch_2_13.isChecked = false
                        } else {
                            p_p_2_13.text = customDialogFB.s3er_yadwee_fa7.text.toString()
                            viewModel.totalAmount += p_p_2_13.text.toString().toInt()

                            toolbar?.title = "المجموع " +  viewModel.totalAmount.toString()
                            customDialogFB.dismiss()
                        }
                    }
                }
                customDialogFB.btn_cn_dig_mz.setOnClickListener {
                    ch_2_13.isChecked = false
                    customDialogFB.s3er_yadwee_fa7.setText("")
                    customDialogFB.dismiss()
                }
                customDialogFB.show()
            }
            else {
                if (p_p_2_13.text.toString().isNotEmpty()){
                    viewModel.totalAmount -= p_p_2_13.text.toString().toInt()
                    toolbar?.title = "المجموع " + viewModel.totalAmount.toString()
                    p_p_2_13.text = ""}
                ch_2_13.text = "طقم اصلاح مجموعة ستيرنج"
            }
        }

        root.ch_2_14.setOnCheckedChangeListener { _, isChecked ->
            if (ch_2_14.isChecked) {
                val customDialogFB = Dialog(activity!!)
                customDialogFB.setContentView(R.layout.dialog_mezan)
                customDialogFB.setCancelable(false)
                customDialogFB.window?.setLayout(
                    ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT)

                val window = customDialogFB.window
                window?.setGravity(Gravity.TOP)
                val lp = window?.attributes
                lp?.dimAmount = 0.0f
                lp?.flags = lp?.flags?.or(WindowManager.LayoutParams.FLAG_DIM_BEHIND)
                window?.attributes = lp

                customDialogFB.front.setOnCheckedChangeListener { _, isChecked1 ->
                    if (customDialogFB.front.isChecked) {
                        ch_2_14.text =
                            ch_2_14.text.toString() + " " + customDialogFB.front.text.toString()
                    } else {
                        ch_2_14.text = "بكسات الدنجل"
                        customDialogFB.s3er_yadwee_fa7.setText("")
                    }

                    if (customDialogFB.front.isChecked && customDialogFB.rear.isChecked) {
                        ch_2_14.text = "بكسات الدنجل الامامي و الخلفي"
                        customDialogFB.s3er_yadwee_fa7.setText("90")
                    } else {
                        if (customDialogFB.front.isChecked) {
                            ch_2_14.text = "بكسات الدنجل الامامي"
                            customDialogFB.s3er_yadwee_fa7.setText("60")
                        }
                        if (customDialogFB.rear.isChecked) {
                            ch_2_14.text = "بكسات الدنجل الخلفي"
                            customDialogFB.s3er_yadwee_fa7.setText("30")
                        }
                    }
                }
                customDialogFB.rear.setOnCheckedChangeListener { _, isChecked2 ->
                    if (customDialogFB.rear.isChecked) {
                        ch_2_14.text = ch_2_14.text.toString() + " " +
                                customDialogFB.rear.text.toString()
                    }else{ch_2_14.text = "بكسات الدنجل"
                        customDialogFB.s3er_yadwee_fa7.setText("")}

                    if (customDialogFB.rear.isChecked && customDialogFB.front.isChecked){
                        ch_2_14.text = "بكسات الدنجل الامامي و الخلفي"
                        customDialogFB.s3er_yadwee_fa7.setText("90")
                    }else {
                        if (customDialogFB.front.isChecked) {
                            ch_2_14.text = "بكسات الدنجل الامامي"
                            customDialogFB.s3er_yadwee_fa7.setText("60")
                        }
                        if (customDialogFB.rear.isChecked) {
                            ch_2_14.text = "بكسات الدنجل الخلفي"
                            customDialogFB.s3er_yadwee_fa7.setText("30")
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
//                            ch_2_14.isChecked = false
                        } else {
                            p_p_2_14.text = customDialogFB.s3er_yadwee_fa7.text.toString()
                            viewModel.totalAmount += p_p_2_14.text.toString().toInt()

                            toolbar?.title = "المجموع " +  viewModel.totalAmount.toString()
                            customDialogFB.dismiss()
                        }
                    }
                }
                customDialogFB.btn_cn_dig_mz.setOnClickListener {
                    ch_2_14.isChecked = false
                    customDialogFB.s3er_yadwee_fa7.setText("")
                    customDialogFB.dismiss()
                }
                customDialogFB.show()
            }
            else {
                if (p_p_2_14.text.toString().isNotEmpty()){
                    viewModel.totalAmount -= p_p_2_14.text.toString().toInt()
                    toolbar?.title = "المجموع " + viewModel.totalAmount.toString()
                    p_p_2_14.text = ""}
                ch_2_14.text = "بكسات الدنجل"
            }
        }

        root.ch_2_15.setOnCheckedChangeListener { _, isChecked ->
            if (ch_2_15.isChecked) {

                val customDialogFB = Dialog(activity!!)
                customDialogFB.setContentView(R.layout.r2syet_2ks_dailog)
                customDialogFB.setCancelable(false)
                customDialogFB.window?.setLayout(
                    ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT
                )

                customDialogFB.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
//                progressBar_sign_up.visibility = View.VISIBLE
                customDialogFB.tit_r2s_out.visibility = View.INVISIBLE
                customDialogFB.tit_r2s_in.visibility = View.INVISIBLE
                customDialogFB.outsideright.text="امامية"
                customDialogFB.outsideleft.text="خلفية"
                customDialogFB.insideright.text="علوية يمين"
                customDialogFB.insideleft.text="علوية يسار"

//                customDialogFB.card_r2s_2ks.setOnTouchListener { _, event ->
//                    var x = 0f
//                    var y = 0f
//                    when (event.action) {
//                        MotionEvent.ACTION_UP -> {
//                            x = event.x
//                            y = event.y
//                        }
//                        MotionEvent.ACTION_MOVE -> {
//                            customDialogFB.window?.let {
//                                val params: WindowManager.LayoutParams = it.attributes
//                                params.x = event.rawX.toInt() - x.toInt()
//                                params.y = event.rawY.toInt() - y.toInt()
//                                it.attributes = params
//                            }
//                        }
//
//                        MotionEvent.ACTION_UP -> {
//                            customDialogFB.window?.let {
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
                val window = customDialogFB.window
                window?.setGravity(Gravity.TOP)
                val lp = window?.attributes
                lp?.dimAmount = 0.0f
                lp?.flags = lp?.flags?.or(WindowManager.LayoutParams.FLAG_DIM_BEHIND)
                window?.attributes = lp

                customDialogFB.outsideright.setOnCheckedChangeListener { _, isChecked1 ->

                    if (customDialogFB.outsideright.isChecked) {
                        ch_2_15.text = "قاعدة محرك امامية"
                    } else {
                        ch_2_15.text = "قاعدة محرك"
                        customDialogFB.s3er_r2s_acx.setText("")
                    }

                    if (customDialogFB.outsideright.isChecked && customDialogFB.outsideleft.isChecked && customDialogFB.insideright.isChecked && customDialogFB.insideleft.isChecked) {
                        ch_2_15.text = "تغير جميع قواعد المحرك"
                        customDialogFB.s3er_r2s_acx.setText("30")
                    } else {
                        if (customDialogFB.outsideright.isChecked && customDialogFB.outsideleft.isChecked && customDialogFB.insideright.isChecked) {
                            ch_2_15.text = "قاعدة محرك امامية و خلفية و علوية يمين"
                            customDialogFB.s3er_r2s_acx.setText("20")
                        } else {
                            if (customDialogFB.outsideright.isChecked && customDialogFB.outsideleft.isChecked && customDialogFB.insideleft.isChecked) {
                                ch_2_15.text = "قاعدة محرك امامية و خلفية و علوية يسار"
                                customDialogFB.s3er_r2s_acx.setText("20")
                            } else {
                                if (customDialogFB.outsideright.isChecked && customDialogFB.insideright.isChecked && customDialogFB.insideleft.isChecked) {
                                    ch_2_15.text = "قاعدة محرك امامية و علويتين"
                                    customDialogFB.s3er_r2s_acx.setText("25")
                                } else {
                                    if (customDialogFB.outsideleft.isChecked && customDialogFB.insideright.isChecked && customDialogFB.insideleft.isChecked) {
                                        ch_2_15.text = "قاعدة محرك خلفية و علويتين"
                                        customDialogFB.s3er_r2s_acx.setText("25")
                                    } else {
                                        if (customDialogFB.outsideright.isChecked && customDialogFB.outsideleft.isChecked) {
                                            ch_2_15.text = "قاعدة محرك امامي و خلفي"
                                            customDialogFB.s3er_r2s_acx.setText("10")
                                        } else {
                                            if (customDialogFB.outsideright.isChecked && customDialogFB.insideright.isChecked) {
                                                ch_2_15.text = "قاعدة محرك امامي و علوية يمين"
                                                customDialogFB.s3er_r2s_acx.setText("15")
                                            } else {
                                                if (customDialogFB.outsideright.isChecked && customDialogFB.insideleft.isChecked) {
                                                    ch_2_15.text = "قاعدة محرك امامي و علوية يسار"
                                                    customDialogFB.s3er_r2s_acx.setText("15")
                                                } else {
                                                    if (customDialogFB.outsideleft.isChecked && customDialogFB.insideright.isChecked) {
                                                        ch_2_15.text =
                                                            "قاعدة محرك خلفي و علوية يمين"
                                                        customDialogFB.s3er_r2s_acx.setText("15")
                                                    } else {
                                                        if (customDialogFB.outsideleft.isChecked && customDialogFB.insideleft.isChecked) {
                                                            ch_2_15.text =
                                                                "قاعدة محرك خلفي و علوية يسار"
                                                            customDialogFB.s3er_r2s_acx.setText("15")
                                                        } else {
                                                            if (customDialogFB.insideright.isChecked && customDialogFB.insideleft.isChecked) {
                                                                ch_2_15.text =
                                                                    "قاعدة محرك علوية يمين و يسار"
                                                                customDialogFB.s3er_r2s_acx.setText(
                                                                    "20"
                                                                )
                                                            } else {

                                                                if (customDialogFB.outsideright.isChecked) {
                                                                    ch_2_15.text =
                                                                        "قاعدة محرك امامي "
                                                                    customDialogFB.s3er_r2s_acx.setText(
                                                                        "5"
                                                                    )
                                                                }
                                                                if (customDialogFB.outsideleft.isChecked) {
                                                                    ch_2_15.text =
                                                                        "قاعدة محرك خلفي "
                                                                    customDialogFB.s3er_r2s_acx.setText(
                                                                        "5"
                                                                    )
                                                                }

                                                                if (customDialogFB.insideleft.isChecked) {
                                                                    ch_2_15.text =
                                                                        "قاعدة محرك علوية يسار "
                                                                    customDialogFB.s3er_r2s_acx.setText(
                                                                        "10"
                                                                    )
                                                                }
                                                                if (customDialogFB.insideright.isChecked) {
                                                                    ch_2_15.text =
                                                                        "قاعدة محرك علوية يمين "
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
                        ch_2_15.text = "قاعدة محرك خلفي "
                    } else {
                        ch_2_15.text = "قاعدة محرك"
                        customDialogFB.s3er_r2s_acx.setText("")
                    }

                    if (customDialogFB.outsideright.isChecked && customDialogFB.outsideleft.isChecked && customDialogFB.insideright.isChecked && customDialogFB.insideleft.isChecked) {
                        ch_2_15.text = "تغير جميع قواعد المحرك"
                        customDialogFB.s3er_r2s_acx.setText("30")
                    } else {
                        if (customDialogFB.outsideright.isChecked && customDialogFB.outsideleft.isChecked && customDialogFB.insideright.isChecked) {
                            ch_2_15.text = "قاعدة محرك امامية و خلفية و علوية يمين"
                            customDialogFB.s3er_r2s_acx.setText("20")
                        } else {
                            if (customDialogFB.outsideright.isChecked && customDialogFB.outsideleft.isChecked && customDialogFB.insideleft.isChecked) {
                                ch_2_15.text = "قاعدة محرك امامية و خلفية و علوية يسار"
                                customDialogFB.s3er_r2s_acx.setText("20")
                            } else {
                                if (customDialogFB.outsideright.isChecked && customDialogFB.insideright.isChecked && customDialogFB.insideleft.isChecked) {
                                    ch_2_15.text = "قاعدة محرك امامية و علويتين"
                                    customDialogFB.s3er_r2s_acx.setText("25")
                                } else {
                                    if (customDialogFB.outsideleft.isChecked && customDialogFB.insideright.isChecked && customDialogFB.insideleft.isChecked) {
                                        ch_2_15.text = "قاعدة محرك خلفية و علويتين"
                                        customDialogFB.s3er_r2s_acx.setText("25")
                                    } else {
                                        if (customDialogFB.outsideright.isChecked && customDialogFB.outsideleft.isChecked) {
                                            ch_2_15.text = "قاعدة محرك امامي و خلفي"
                                            customDialogFB.s3er_r2s_acx.setText("10")
                                        } else {
                                            if (customDialogFB.outsideright.isChecked && customDialogFB.insideright.isChecked) {
                                                ch_2_15.text = "قاعدة محرك امامي و علوية يمين"
                                                customDialogFB.s3er_r2s_acx.setText("15")
                                            } else {
                                                if (customDialogFB.outsideright.isChecked && customDialogFB.insideleft.isChecked) {
                                                    ch_2_15.text = "قاعدة محرك امامي و علوية يسار"
                                                    customDialogFB.s3er_r2s_acx.setText("15")
                                                } else {
                                                    if (customDialogFB.outsideleft.isChecked && customDialogFB.insideright.isChecked) {
                                                        ch_2_15.text =
                                                            "قاعدة محرك خلفي و علوية يمين"
                                                        customDialogFB.s3er_r2s_acx.setText("15")
                                                    } else {
                                                        if (customDialogFB.outsideleft.isChecked && customDialogFB.insideleft.isChecked) {
                                                            ch_2_15.text =
                                                                "قاعدة محرك خلفي و علوية يسار"
                                                            customDialogFB.s3er_r2s_acx.setText("15")
                                                        } else {
                                                            if (customDialogFB.insideright.isChecked && customDialogFB.insideleft.isChecked) {
                                                                ch_2_15.text =
                                                                    "قاعدة محرك علوية يمين و يسار"
                                                                customDialogFB.s3er_r2s_acx.setText(
                                                                    "20"
                                                                )
                                                            } else {

                                                                if (customDialogFB.outsideright.isChecked) {
                                                                    ch_2_15.text =
                                                                        "قاعدة محرك امامي "
                                                                    customDialogFB.s3er_r2s_acx.setText(
                                                                        "5"
                                                                    )
                                                                }
                                                                if (customDialogFB.outsideleft.isChecked) {
                                                                    ch_2_15.text =
                                                                        "قاعدة محرك خلفي "
                                                                    customDialogFB.s3er_r2s_acx.setText(
                                                                        "5"
                                                                    )
                                                                }

                                                                if (customDialogFB.insideleft.isChecked) {
                                                                    ch_2_15.text =
                                                                        "قاعدة محرك علوية يسار "
                                                                    customDialogFB.s3er_r2s_acx.setText(
                                                                        "10"
                                                                    )
                                                                }
                                                                if (customDialogFB.insideright.isChecked) {
                                                                    ch_2_15.text =
                                                                        "قاعدة محرك علوية يمين "
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
                        ch_2_15.text = "قاعدة محرك علوية يسار "
                    } else {
                        ch_2_15.text = "قاعدة محرك"
                        customDialogFB.s3er_r2s_acx.setText("")
                    }

                    if (customDialogFB.outsideright.isChecked && customDialogFB.outsideleft.isChecked && customDialogFB.insideright.isChecked && customDialogFB.insideleft.isChecked) {
                        ch_2_15.text = "تغير جميع قواعد المحرك"
                        customDialogFB.s3er_r2s_acx.setText("30")
                    } else {
                        if (customDialogFB.outsideright.isChecked && customDialogFB.outsideleft.isChecked && customDialogFB.insideright.isChecked) {
                            ch_2_15.text = "قاعدة محرك امامية و خلفية و علوية يمين"
                            customDialogFB.s3er_r2s_acx.setText("20")
                        } else {
                            if (customDialogFB.outsideright.isChecked && customDialogFB.outsideleft.isChecked && customDialogFB.insideleft.isChecked) {
                                ch_2_15.text = "قاعدة محرك امامية و خلفية و علوية يسار"
                                customDialogFB.s3er_r2s_acx.setText("20")
                            } else {
                                if (customDialogFB.outsideright.isChecked && customDialogFB.insideright.isChecked && customDialogFB.insideleft.isChecked) {
                                    ch_2_15.text = "قاعدة محرك امامية و علويتين"
                                    customDialogFB.s3er_r2s_acx.setText("25")
                                } else {
                                    if (customDialogFB.outsideleft.isChecked && customDialogFB.insideright.isChecked && customDialogFB.insideleft.isChecked) {
                                        ch_2_15.text = "قاعدة محرك خلفية و علويتين"
                                        customDialogFB.s3er_r2s_acx.setText("25")
                                    } else {
                                        if (customDialogFB.outsideright.isChecked && customDialogFB.outsideleft.isChecked) {
                                            ch_2_15.text = "قاعدة محرك امامي و خلفي"
                                            customDialogFB.s3er_r2s_acx.setText("10")
                                        } else {
                                            if (customDialogFB.outsideright.isChecked && customDialogFB.insideright.isChecked) {
                                                ch_2_15.text = "قاعدة محرك امامي و علوية يمين"
                                                customDialogFB.s3er_r2s_acx.setText("15")
                                            } else {
                                                if (customDialogFB.outsideright.isChecked && customDialogFB.insideleft.isChecked) {
                                                    ch_2_15.text = "قاعدة محرك امامي و علوية يسار"
                                                    customDialogFB.s3er_r2s_acx.setText("15")
                                                } else {
                                                    if (customDialogFB.outsideleft.isChecked && customDialogFB.insideright.isChecked) {
                                                        ch_2_15.text =
                                                            "قاعدة محرك خلفي و علوية يمين"
                                                        customDialogFB.s3er_r2s_acx.setText("15")
                                                    } else {
                                                        if (customDialogFB.outsideleft.isChecked && customDialogFB.insideleft.isChecked) {
                                                            ch_2_15.text =
                                                                "قاعدة محرك خلفي و علوية يسار"
                                                            customDialogFB.s3er_r2s_acx.setText("15")
                                                        } else {
                                                            if (customDialogFB.insideright.isChecked && customDialogFB.insideleft.isChecked) {
                                                                ch_2_15.text =
                                                                    "قاعدة محرك علوية يمين و يسار"
                                                                customDialogFB.s3er_r2s_acx.setText(
                                                                    "20"
                                                                )
                                                            } else {

                                                                if (customDialogFB.outsideright.isChecked) {
                                                                    ch_2_15.text =
                                                                        "قاعدة محرك امامي "
                                                                    customDialogFB.s3er_r2s_acx.setText(
                                                                        "5"
                                                                    )
                                                                }
                                                                if (customDialogFB.outsideleft.isChecked) {
                                                                    ch_2_15.text =
                                                                        "قاعدة محرك خلفي "
                                                                    customDialogFB.s3er_r2s_acx.setText(
                                                                        "5"
                                                                    )
                                                                }

                                                                if (customDialogFB.insideleft.isChecked) {
                                                                    ch_2_15.text =
                                                                        "قاعدة محرك علوية يسار "
                                                                    customDialogFB.s3er_r2s_acx.setText(
                                                                        "10"
                                                                    )
                                                                }
                                                                if (customDialogFB.insideright.isChecked) {
                                                                    ch_2_15.text =
                                                                        "قاعدة محرك علوية يمين "
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
                        ch_2_15.text = "قاعدة محرك علوية يمين "
                    } else {
                        ch_2_15.text = "قاعدة محرك"
                        customDialogFB.s3er_r2s_acx.setText("")
                    }

                    if (customDialogFB.outsideright.isChecked && customDialogFB.outsideleft.isChecked && customDialogFB.insideright.isChecked && customDialogFB.insideleft.isChecked) {
                        ch_2_15.text = "تغير جميع قواعد المحرك"
                        customDialogFB.s3er_r2s_acx.setText("30")
                    } else {
                        if (customDialogFB.outsideright.isChecked && customDialogFB.outsideleft.isChecked && customDialogFB.insideright.isChecked) {
                            ch_2_15.text = "قاعدة محرك امامية و خلفية و علوية يمين"
                            customDialogFB.s3er_r2s_acx.setText("20")
                        } else {
                            if (customDialogFB.outsideright.isChecked && customDialogFB.outsideleft.isChecked && customDialogFB.insideleft.isChecked) {
                                ch_2_15.text = "قاعدة محرك امامية و خلفية و علوية يسار"
                                customDialogFB.s3er_r2s_acx.setText("20")
                            } else {
                                if (customDialogFB.outsideright.isChecked && customDialogFB.insideright.isChecked && customDialogFB.insideleft.isChecked) {
                                    ch_2_15.text = "قاعدة محرك امامية و علويتين"
                                    customDialogFB.s3er_r2s_acx.setText("25")
                                } else {
                                    if (customDialogFB.outsideleft.isChecked && customDialogFB.insideright.isChecked && customDialogFB.insideleft.isChecked) {
                                        ch_2_15.text = "قاعدة محرك خلفية و علويتين"
                                        customDialogFB.s3er_r2s_acx.setText("25")
                                    } else {
                                        if (customDialogFB.outsideright.isChecked && customDialogFB.outsideleft.isChecked) {
                                            ch_2_15.text = "قاعدة محرك امامي و خلفي"
                                            customDialogFB.s3er_r2s_acx.setText("10")
                                        } else {
                                            if (customDialogFB.outsideright.isChecked && customDialogFB.insideright.isChecked) {
                                                ch_2_15.text = "قاعدة محرك امامي و علوية يمين"
                                                customDialogFB.s3er_r2s_acx.setText("15")
                                            } else {
                                                if (customDialogFB.outsideright.isChecked && customDialogFB.insideleft.isChecked) {
                                                    ch_2_15.text = "قاعدة محرك امامي و علوية يسار"
                                                    customDialogFB.s3er_r2s_acx.setText("15")
                                                } else {
                                                    if (customDialogFB.outsideleft.isChecked && customDialogFB.insideright.isChecked) {
                                                        ch_2_15.text =
                                                            "قاعدة محرك خلفي و علوية يمين"
                                                        customDialogFB.s3er_r2s_acx.setText("15")
                                                    } else {
                                                        if (customDialogFB.outsideleft.isChecked && customDialogFB.insideleft.isChecked) {
                                                            ch_2_15.text =
                                                                "قاعدة محرك خلفي و علوية يسار"
                                                            customDialogFB.s3er_r2s_acx.setText("15")
                                                        } else {
                                                            if (customDialogFB.insideright.isChecked && customDialogFB.insideleft.isChecked) {
                                                                ch_2_15.text =
                                                                    "قاعدة محرك علوية يمين و يسار"
                                                                customDialogFB.s3er_r2s_acx.setText(
                                                                    "20"
                                                                )
                                                            } else {

                                                                if (customDialogFB.outsideright.isChecked) {
                                                                    ch_2_15.text =
                                                                        "قاعدة محرك امامي "
                                                                    customDialogFB.s3er_r2s_acx.setText(
                                                                        "5"
                                                                    )
                                                                }
                                                                if (customDialogFB.outsideleft.isChecked) {
                                                                    ch_2_15.text =
                                                                        "قاعدة محرك خلفي "
                                                                    customDialogFB.s3er_r2s_acx.setText(
                                                                        "5"
                                                                    )
                                                                }

                                                                if (customDialogFB.insideleft.isChecked) {
                                                                    ch_2_15.text =
                                                                        "قاعدة محرك علوية يسار "
                                                                    customDialogFB.s3er_r2s_acx.setText(
                                                                        "10"
                                                                    )
                                                                }
                                                                if (customDialogFB.insideright.isChecked) {
                                                                    ch_2_15.text =
                                                                        "قاعدة محرك علوية يمين "
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
//                            ch_2_15.isChecked = false
                        } else {
                            p_p_2_15.text = customDialogFB.s3er_r2s_acx.text.toString()
                            viewModel.totalAmount += p_p_2_15.text.toString().toInt()
                            toolbar?.title = "المجموع " + viewModel.totalAmount.toString()
                            customDialogFB.dismiss()
                        }
                    }
                }
                customDialogFB.btn_r2s_can.setOnClickListener {
                    if (p_p_2_15.text.toString().isEmpty()) {
                        ch_2_15.text = "قاعدة محرك"
                        ch_2_15.isChecked = false
                    }
                    customDialogFB.dismiss()
                }

                customDialogFB.show()
            } else {
                if (p_p_2_15.text.toString().isNotEmpty()) {
                    viewModel.totalAmount -= p_p_2_15.text.toString().toInt()
                    toolbar?.title = "المجموع " + viewModel.totalAmount.toString()
                    ch_2_15.text = "قاعدة محرك"
                    p_p_2_15.setText("")
                } else {
                    ch_2_15.text = "قاعدة محرك"
                }
            }
        }

        root.ch_2_16.setOnCheckedChangeListener { _, isChecked ->
            if (ch_2_16.isChecked) {
                val customDialogFB = Dialog(activity!!)
                customDialogFB.setContentView(R.layout.dialog_mezan)
                customDialogFB.setCancelable(false)
                customDialogFB.window?.setLayout(
                    ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT)
                val window = customDialogFB.window
                window?.setGravity(Gravity.TOP)
                val lp = window?.attributes
                lp?.dimAmount = 0.0f
                lp?.flags = lp?.flags?.or(WindowManager.LayoutParams.FLAG_DIM_BEHIND)
                window?.attributes = lp

                customDialogFB.front.setOnCheckedChangeListener { _, isChecked1 ->
                    if (customDialogFB.front.isChecked) {
                        ch_2_16.text =
                            "قشرة دنجل امامية"
                    } else {
                        ch_2_16.text = "قشرة دنجل"
                        customDialogFB.s3er_yadwee_fa7.setText("")
                    }

                    if (customDialogFB.front.isChecked && customDialogFB.rear.isChecked) {
                        ch_2_16.text = "قشرة دنجل امامية و خلفية"
                        customDialogFB.s3er_yadwee_fa7.setText("75")
                    } else {
                        if (customDialogFB.front.isChecked) {
                            ch_2_16.text = "قشرة دنجل امامية"
                            customDialogFB.s3er_yadwee_fa7.setText("40")
                        }
                        if (customDialogFB.rear.isChecked) {
                            ch_2_16.text = "قشرة دنجل خلفية"
                            customDialogFB.s3er_yadwee_fa7.setText("35")
                        }
                    }
                }
                customDialogFB.rear.setOnCheckedChangeListener { _, isChecked2 ->
                    if (customDialogFB.rear.isChecked) {
                        ch_2_16.text = "قشرة دنجل خلفية"
                    }else{ch_2_16.text = "قشرة دنجل"
                        customDialogFB.s3er_yadwee_fa7.setText("")}

                    if (customDialogFB.rear.isChecked && customDialogFB.front.isChecked){
                        ch_2_16.text = "قشرة دنجل امامية و خلفية"
                        customDialogFB.s3er_yadwee_fa7.setText("75")
                    }else {
                        if (customDialogFB.front.isChecked) {
                            ch_2_16.text = "قشرة دنجل امامية"
                            customDialogFB.s3er_yadwee_fa7.setText("40")
                        }
                        if (customDialogFB.rear.isChecked) {
                            ch_2_16.text = "قشرة دنجل خلفية"
                            customDialogFB.s3er_yadwee_fa7.setText("35")
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
//                            ch_2_16.isChecked = false
                        } else {
                            p_p_2_16.text = customDialogFB.s3er_yadwee_fa7.text.toString()
                            viewModel.totalAmount += p_p_2_16.text.toString().toInt()

                            toolbar?.title = "المجموع " +  viewModel.totalAmount.toString()
                            customDialogFB.dismiss()
                        }
                    }
                }
                customDialogFB.btn_cn_dig_mz.setOnClickListener {
                    ch_2_16.isChecked = false
                    customDialogFB.s3er_yadwee_fa7.setText("")
                    customDialogFB.dismiss()
                }
                customDialogFB.show()
            }
            else {
                if (p_p_2_16.text.toString().isNotEmpty()){
                    viewModel.totalAmount -= p_p_2_16.text.toString().toInt()
                    toolbar?.title = "المجموع " + viewModel.totalAmount.toString()
                    p_p_2_16.text = ""}
                ch_2_16.text = "قشرة دنجل"
            }
        }

        root.ch_2_17.setOnCheckedChangeListener { _, isChecked ->
            if (ch_2_17.isChecked) {
                val customDialogFB = Dialog(activity!!)
                customDialogFB.setContentView(R.layout.dialog_mezan)
                customDialogFB.setCancelable(false)
                customDialogFB.window?.setLayout(
                    ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT)
                val window = customDialogFB.window
                window?.setGravity(Gravity.TOP)
                val lp = window?.attributes
                lp?.dimAmount = 0.0f
                lp?.flags = lp?.flags?.or(WindowManager.LayoutParams.FLAG_DIM_BEHIND)
                window?.attributes = lp

                customDialogFB.front.text="علوية"
                customDialogFB.rear.text="سفلية"
                customDialogFB.front.setOnCheckedChangeListener { _, isChecked1 ->
                    if (customDialogFB.front.isChecked) {
                        ch_2_17.text =
                            "كفة علوية"
                    } else {
                        ch_2_17.text = "كفة"
                        customDialogFB.s3er_yadwee_fa7.setText("")
                    }

                    if (customDialogFB.front.isChecked && customDialogFB.rear.isChecked) {
                        ch_2_17.text = "كفة علوية و سفلية"
                        customDialogFB.s3er_yadwee_fa7.setText("20")
                    } else {
                        if (customDialogFB.front.isChecked) {
                            ch_2_17.text = "كفة علوية"
                            customDialogFB.s3er_yadwee_fa7.setText("10")
                        }
                        if (customDialogFB.rear.isChecked) {
                            ch_2_17.text = "كفة سفلية"
                            customDialogFB.s3er_yadwee_fa7.setText("10")
                        }
                    }
                }
                customDialogFB.rear.setOnCheckedChangeListener { _, isChecked2 ->
                    if (customDialogFB.rear.isChecked) {
                        ch_2_17.text = "كفة سفلية"
                    }else{ch_2_17.text = "كفة"
                        customDialogFB.s3er_yadwee_fa7.setText("")}

                    if (customDialogFB.rear.isChecked && customDialogFB.front.isChecked){
                        ch_2_17.text = "كفة علوية و سفلية"
                        customDialogFB.s3er_yadwee_fa7.setText("20")
                    }else {
                        if (customDialogFB.front.isChecked) {
                            ch_2_17.text = "كفة علوية"
                            customDialogFB.s3er_yadwee_fa7.setText("10")
                        }
                        if (customDialogFB.rear.isChecked) {
                            ch_2_17.text = "كفة سفلية"
                            customDialogFB.s3er_yadwee_fa7.setText("10")
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
//                            ch_2_17.isChecked = false
                        } else {
                            p_p_2_17.text = customDialogFB.s3er_yadwee_fa7.text.toString()
                            viewModel.totalAmount += p_p_2_17.text.toString().toInt()

                            toolbar?.title = "المجموع " +  viewModel.totalAmount.toString()
                            customDialogFB.dismiss()
                        }
                    }
                }
                customDialogFB.btn_cn_dig_mz.setOnClickListener {
                    ch_2_17.isChecked = false
                    customDialogFB.s3er_yadwee_fa7.setText("")
                    customDialogFB.dismiss()
                }
                customDialogFB.show()
            }
            else {
                if (p_p_2_17.text.toString().isNotEmpty()){
                    viewModel.totalAmount -= p_p_2_17.text.toString().toInt()
                    toolbar?.title = "المجموع " + viewModel.totalAmount.toString()
                    p_p_2_17.text = ""}
                ch_2_17.text = "كفة"
            }
        }

        root.ch_2_18.setOnCheckedChangeListener { _, isChecked ->
            if (ch_2_18.isChecked) {
                val customDialogFB = Dialog(activity!!)
                customDialogFB.setContentView(R.layout.dialog_fa7e9)
                customDialogFB.setCancelable(false)
                customDialogFB.window?.setLayout(
                    ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT)

                customDialogFB.s3er_yadwee_fa7.setText("15")

                customDialogFB.btn_sv_dig_fa7.setOnClickListener {
                    if (customDialogFB.s3er_yadwee_fa7.text.toString().isEmpty()) {
                        toast_notempty.show()
                    } else {
                        p_p_2_18.text = customDialogFB.s3er_yadwee_fa7.text.toString()
                        viewModel.totalAmount += p_p_2_18.text.toString().toInt()
                        toolbar?.title = "المجموع " + viewModel.totalAmount.toString()
                        customDialogFB.dismiss()
                    }
                }
                customDialogFB.show()
            } else {
                viewModel.totalAmount -= p_p_2_18.text.toString().toInt()
                toolbar?.title = "المجموع " + viewModel.totalAmount.toString()
                p_p_2_18.text = ""
            }
        }

        root.ch_2_19.setOnCheckedChangeListener { _, isChecked ->
            if (ch_2_19.isChecked) {
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
                        p_p_2_19.text = customDialogFB.s3er_yadwee_fa7.text.toString()
                        viewModel.totalAmount += p_p_2_19.text.toString().toInt()
                        toolbar?.title = "المجموع " + viewModel.totalAmount.toString()
                        customDialogFB.dismiss()
                    }
                }
                customDialogFB.show()
            } else {
                viewModel.totalAmount -= p_p_2_19.text.toString().toInt()
                toolbar?.title = "المجموع " + viewModel.totalAmount.toString()
                p_p_2_19.text = ""
            }
        }

        root.ch_2_20.setOnCheckedChangeListener { _, isChecked ->
            if (ch_2_20.isChecked) {
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
                        p_p_2_20.text = customDialogFB.s3er_yadwee_fa7.text.toString()
                        viewModel.totalAmount += p_p_2_20.text.toString().toInt()
                        toolbar?.title = "المجموع " + viewModel.totalAmount.toString()
                        customDialogFB.dismiss()
                    }
                }
                customDialogFB.show()
            } else {
                viewModel.totalAmount -= p_p_2_20.text.toString().toInt()
                toolbar?.title = "المجموع " + viewModel.totalAmount.toString()
                p_p_2_20.text = ""
            }
        }

        root.ch_2_21.setOnCheckedChangeListener { _, isChecked ->
            if (ch_2_21.isChecked) {
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
                        p_p_2_21.text = customDialogFB.s3er_yadwee_fa7.text.toString()
                        viewModel.totalAmount += p_p_2_21.text.toString().toInt()
                        toolbar?.title = "المجموع " + viewModel.totalAmount.toString()
                        customDialogFB.dismiss()
                    }
                }
                customDialogFB.show()
            } else {
                viewModel.totalAmount -= p_p_2_21.text.toString().toInt()
                toolbar?.title = "المجموع " + viewModel.totalAmount.toString()
                p_p_2_21.text = ""
            }
        }
        root.ch_2_22.setOnCheckedChangeListener { _, isChecked ->
            if (ch_2_22.isChecked) {
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
                        p_p_2_22.text = customDialogFB.s3er_yadwee_fa7.text.toString()
                        viewModel.totalAmount += p_p_2_22.text.toString().toInt()
                        toolbar?.title = "المجموع " + viewModel.totalAmount.toString()
                        customDialogFB.dismiss()
                    }
                }
                customDialogFB.show()
            } else {
                viewModel.totalAmount -= p_p_2_22.text.toString().toInt()
                toolbar?.title = "المجموع " + viewModel.totalAmount.toString()
                p_p_2_22.text = ""
            }
        }


        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}