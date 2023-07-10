package com.example.mizanalnasr.ui.m5r6ah

import android.app.Dialog
import android.arch.lifecycle.ViewModelProviders
import android.content.Context
import android.content.SharedPreferences
import android.graphics.Color
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.Toolbar
import android.text.SpannableString
import android.text.style.AbsoluteSizeSpan
import android.text.style.ForegroundColorSpan
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.mizanalnasr.R
import com.example.mizanalnasr.databinding.FragmentM5r6ahBinding
import com.example.mizanalnasr.ui.first.FirstViewModel
import kotlinx.android.synthetic.main.dailog_m5r6ah_1.*
import kotlinx.android.synthetic.main.fragment_m5r6ah.*
import kotlinx.android.synthetic.main.fragment_m5r6ah.view.*


class M5r6ahFragment : Fragment() {
    private lateinit var viewModel: FirstViewModel

    private var _binding: FragmentM5r6ahBinding? = null

    private val binding get() = _binding!!

    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentM5r6ahBinding.inflate(inflater, container, false)
        val root: View = binding.root

        viewModel = activity?.run {
            ViewModelProviders.of(this).get(FirstViewModel::class.java)
        } ?: throw Exception("Invalid Activity")

        val toolbar = activity?.findViewById<Toolbar>(R.id.toolbar)
        toolbar?.setTitleTextAppearance(this.context, R.style.boldText)

        val spannableString = SpannableString("يجب عدم ترك خانة العدد فارغة")
        spannableString.setSpan(
            ForegroundColorSpan(Color.GREEN), 0, spannableString.length, 0
        )
        spannableString.setSpan(
            AbsoluteSizeSpan(60), 0, spannableString.length, 0
        )
        val toast_notempty = Toast.makeText(context, spannableString, Toast.LENGTH_SHORT)

        val customDialogFB = Dialog(activity!!)
        customDialogFB.setContentView(R.layout.dailog_m5r6ah_1)
        customDialogFB.setCancelable(false)
        customDialogFB.window?.setLayout(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.WRAP_CONTENT)

        sharedPreferences = requireActivity().getSharedPreferences("sharedPrefs", Context.MODE_PRIVATE)

        root.ch_3_1.setOnCheckedChangeListener { _, isChecked ->
            if (ch_3_1.isChecked) {
                customDialogFB.dail_m5_pric.setText("3")

                customDialogFB.btn_sav_m5r6ah.setOnClickListener {
                    if (customDialogFB.dail_m5_num.text.toString().isEmpty()) {
                        toast_notempty.show()
                    } else {
                        customDialogFB.dail_m5_total.text =
                            (customDialogFB.dail_m5_num.text.toString().toInt() * customDialogFB.dail_m5_pric.text.toString().toInt()).toString()
                        p_p_3_1.text = customDialogFB.dail_m5_total.text.toString()
                        viewModel.totalAmount += p_p_3_1.text.toString().toInt()
                        toolbar?.title =  viewModel.totalAmount.toString()
                        customDialogFB.dismiss()
                    }
                }
                customDialogFB.show()
            } else {
                viewModel.totalAmount -= p_p_3_1.text.toString().toInt()
                toolbar?.title =  viewModel.totalAmount.toString()
                p_p_3_1.text = ""
            }
        }

        root.ch_3_2.setOnCheckedChangeListener { _, isChecked ->
            if (ch_3_2.isChecked) {
                customDialogFB.dail_m5_pric.setText("3")

                customDialogFB.btn_sav_m5r6ah.setOnClickListener {
                    if (customDialogFB.dail_m5_num.text.toString().isEmpty()) {
                        toast_notempty.show()
                    } else {
                        customDialogFB.dail_m5_total.text =
                            (customDialogFB.dail_m5_num.text.toString().toInt() * customDialogFB.dail_m5_pric.text.toString().toInt()).toString()
                        p_p_3_2.text = customDialogFB.dail_m5_total.text.toString()
                        viewModel.totalAmount += p_p_3_2.text.toString().toInt()
                        toolbar?.title =  viewModel.totalAmount.toString()
                        customDialogFB.dismiss()
                    }
                }
                customDialogFB.show()
            } else {
                viewModel.totalAmount -= p_p_3_2.text.toString().toInt()
                toolbar?.title =  viewModel.totalAmount.toString()
                p_p_3_2.text = ""
            }
        }

        root.ch_3_3.setOnCheckedChangeListener { _, isChecked ->
            if (ch_3_3.isChecked) {
                customDialogFB.dail_m5_pric.setText("5")

                customDialogFB.btn_sav_m5r6ah.setOnClickListener {
                    if (customDialogFB.dail_m5_num.text.toString().isEmpty()) {
                        toast_notempty.show()
                    } else {
                        customDialogFB.dail_m5_total.text =
                            (customDialogFB.dail_m5_num.text.toString().toInt() * customDialogFB.dail_m5_pric.text.toString().toInt()).toString()
                        p_p_3_3.text = customDialogFB.dail_m5_total.text.toString()
                        viewModel.totalAmount += p_p_3_3.text.toString().toInt()
                        toolbar?.title =  viewModel.totalAmount.toString()
                        customDialogFB.dismiss()
                    }
                }
                customDialogFB.show()
            } else {
                viewModel.totalAmount -= p_p_3_3.text.toString().toInt()
                toolbar?.title =  viewModel.totalAmount.toString()
                p_p_3_3.text = ""
            }
        }

        root.ch_3_4.setOnCheckedChangeListener { _, isChecked ->
            if (ch_3_4.isChecked) {
                customDialogFB.dail_m5_pric.setText("5")

                customDialogFB.btn_sav_m5r6ah.setOnClickListener {
                    if (customDialogFB.dail_m5_num.text.toString().isEmpty()) {
                        toast_notempty.show()
                    } else {
                        customDialogFB.dail_m5_total.text =
                            (customDialogFB.dail_m5_num.text.toString().toInt() * customDialogFB.dail_m5_pric.text.toString().toInt()).toString()
                        p_p_3_4.text = customDialogFB.dail_m5_total.text.toString()
                        viewModel.totalAmount += p_p_3_4.text.toString().toInt()
                        toolbar?.title =  viewModel.totalAmount.toString()
                        customDialogFB.dismiss()
                    }
                }
                customDialogFB.show()
            } else {
                viewModel.totalAmount -= p_p_3_4.text.toString().toInt()
                toolbar?.title =  viewModel.totalAmount.toString()
                p_p_3_4.text = ""
            }
        }

        root.ch_3_5.setOnCheckedChangeListener { _, isChecked ->
            if (ch_3_5.isChecked) {
                customDialogFB.dail_m5_pric.setText("8")

                customDialogFB.btn_sav_m5r6ah.setOnClickListener {
                    if (customDialogFB.dail_m5_num.text.toString().isEmpty()) {
                        toast_notempty.show()
                    } else {
                        customDialogFB.dail_m5_total.text =
                            (customDialogFB.dail_m5_num.text.toString().toInt() * customDialogFB.dail_m5_pric.text.toString().toInt()).toString()
                        p_p_3_5.text = customDialogFB.dail_m5_total.text.toString()
                        viewModel.totalAmount += p_p_3_5.text.toString().toInt()
                        toolbar?.title =  viewModel.totalAmount.toString()
                        customDialogFB.dismiss()

                    }
                }
                customDialogFB.show()
            } else {
                viewModel.totalAmount -= p_p_3_5.text.toString().toInt()
                toolbar?.title =  viewModel.totalAmount.toString()
                p_p_3_5.text = ""
            }
        }

        root.ch_3_6.setOnCheckedChangeListener { _, isChecked ->
            if (ch_3_6.isChecked) {
                customDialogFB.dail_m5_pric.setText("12")

                customDialogFB.btn_sav_m5r6ah.setOnClickListener {
                    if (customDialogFB.dail_m5_num.text.toString().isEmpty()) {
                        toast_notempty.show()
                    } else {
                        customDialogFB.dail_m5_total.text =
                            (customDialogFB.dail_m5_num.text.toString().toInt() * customDialogFB.dail_m5_pric.text.toString().toInt()).toString()
                        p_p_3_6.text = customDialogFB.dail_m5_total.text.toString()
                        viewModel.totalAmount += p_p_3_6.text.toString().toInt()
                        toolbar?.title =  viewModel.totalAmount.toString()
                        customDialogFB.dismiss()
                    }
                }
                customDialogFB.show()
            } else {
                viewModel.totalAmount -= p_p_3_6.text.toString().toInt()
                toolbar?.title =  viewModel.totalAmount.toString()
                p_p_3_6.text = ""
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
        val editor = sharedPreferences.edit()
        editor.putBoolean("CHECKBOX1", ch_3_1.isChecked)
        editor.putBoolean("CHECKBOX2", ch_3_2.isChecked)
        editor.apply()
    }

    private fun loadCheckBoxes() {
        ch_3_1.isChecked = sharedPreferences.getBoolean("CHECKBOX1", false)
        ch_3_6.isChecked = sharedPreferences.getBoolean("CHECKBOX2", false)
    }
}