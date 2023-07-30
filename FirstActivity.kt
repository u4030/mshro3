package com.example.mizanalnasr.main

import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.ViewGroup
import android.view.WindowManager
import android.widget.LinearLayout
import com.example.mizanalnasr.R
import com.example.mizanalnasr.model.CheckMainData
import com.example.mizanalnasr.model.CheckMdata
import com.example.mizanalnasr.model.User
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.activity_first.*
import kotlinx.android.synthetic.main.edit_dailog.*

class FirstActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_first)
        window.setFlags(
            WindowManager.LayoutParams.FLAG_SECURE,
            WindowManager.LayoutParams.FLAG_SECURE
        )

        if (item.checkData.check1.isNotEmpty()){
            customDialogFB.apply {
                checkBoxauto1.setText(item.checkData.check1)
                checkBoxauto1.setTextColor(Color.parseColor("#000000"))
                checkBoxauto1.layoutParams = LinearLayout.LayoutParams(
                    ViewGroup.LayoutParams.WRAP_CONTENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT, Float.MIN_VALUE)
                viewtext1.setText(item.checkData.price1)
                viewtext1.setTextColor(Color.parseColor("#000000"))
                p1.addView(viewtext1)
                L_c1.addView(checkBoxauto1)
                checkBoxauto1.setSelectAllOnFocus(true)
                viewtext1.setSelectAllOnFocus(true)
                checkBoxauto1.textSize = 14f
                checkBoxauto1.setTypeface(null, Typeface.BOLD)
                checkBoxauto1.setSingleLine(true)
                viewtext1.setSingleLine(true)
                checkBoxauto1.textSize = 14f
                viewtext1.textSize = 14f

                val viewTextValue = viewtext1.text.toString().toInt()
                val editReceivabelPriceValue = edit_receivabel_price.text.toString().toIntOrNull() ?:0
                viewtext1.addTextChangedListener(object : TextWatcher {
                    override fun beforeTextChanged(
                        s: CharSequence?,
                        start: Int,
                        count: Int,
                        after: Int
                    ) {
                    }

                    override fun onTextChanged(
                        s: CharSequence?,
                        start: Int,
                        before: Int,
                        count: Int
                    ) {
                        if (edit_receivabel_price.text.toString().isNotEmpty()) {
                            val newViewTextValue = s.toString().toIntOrNull() ?: 0
                            if (newViewTextValue > viewTextValue) {
                                val difference = newViewTextValue - viewTextValue
                                val newEditReceivabelPrice =
                                    editReceivabelPriceValue.plus(difference)
                                edit_receivabel_price.text =
                                    (newEditReceivabelPrice.toString())
                            }
                            else{
                                if (newViewTextValue < viewTextValue) {
                                    val difference = viewTextValue - newViewTextValue
                                    val newEditReceivabelPrice =
                                        editReceivabelPriceValue.minus(difference)
                                    edit_receivabel_price.text =
                                        (newEditReceivabelPrice.toString())
                                }
                            }
                        }
                    }

                    override fun afterTextChanged(s: Editable?) {
                    }
                })
            }}

        if (item.checkData.check2.isNotEmpty()){
            customDialogFB.apply {
                checkBoxauto2.setText(item.checkData.check2)
                checkBoxauto2.setTextColor(Color.parseColor("#000000"))
                checkBoxauto2.layoutParams = LinearLayout.LayoutParams(
                    ViewGroup.LayoutParams.WRAP_CONTENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT, Float.MIN_VALUE)
                viewtext2.setText(item.checkData.price2)
                viewtext2.setTextColor(Color.parseColor("#000000"))
                p2.addView(viewtext2)
                L_c2.addView(checkBoxauto2)
                viewtext2.setSelectAllOnFocus(true)
                checkBoxauto2.setSelectAllOnFocus(true)
                checkBoxauto2.textSize = 14f
                checkBoxauto2.setTypeface(null, Typeface.BOLD)
                checkBoxauto2.setSingleLine(true)
                viewtext2.setSingleLine(true)
                viewtext2.textSize = 14f

                val viewTextValue = viewtext2.text.toString().toInt()
                val editReceivabelPriceValue = edit_receivabel_price.text.toString().toIntOrNull() ?: 0
                viewtext2.addTextChangedListener(object : TextWatcher {
                    override fun beforeTextChanged(
                        s: CharSequence?,
                        start: Int,
                        count: Int,
                        after: Int
                    ) {
                    }
                    override fun onTextChanged(
                        s: CharSequence?,
                        start: Int,
                        before: Int,
                        count: Int
                    ) {
                        if (edit_receivabel_price.text.toString().isNotEmpty()) {
                            val newViewTextValue = s.toString().toIntOrNull() ?: 0
                            if (newViewTextValue > viewTextValue) {
                                val difference = newViewTextValue - viewTextValue
                                val newEditReceivabelPrice =
                                    editReceivabelPriceValue.plus(difference)
                                edit_receivabel_price.text =
                                    (newEditReceivabelPrice.toString())
                            }
                            else{
                                if (newViewTextValue < viewTextValue) {
                                    val difference = viewTextValue - newViewTextValue
                                    val newEditReceivabelPrice =
                                        editReceivabelPriceValue.minus(difference)
                                    edit_receivabel_price.text =
                                        (newEditReceivabelPrice.toString())
                                }
                            }
                        }
                    }
                    override fun afterTextChanged(s: Editable?) {
                    }
                })

            }}
    }
}