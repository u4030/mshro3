package com.example.mizanalnasr.recycler

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Color
import android.graphics.Typeface
import android.text.format.DateFormat
import android.view.Gravity
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import com.example.mizanalnasr.R
import com.example.neprotest.glide.GlideApp
import com.example.neprotest.model.CheckData
import com.google.firebase.storage.FirebaseStorage
import com.xwray.groupie.kotlinandroidextensions.Item
import com.xwray.groupie.kotlinandroidextensions.ViewHolder

import kotlinx.android.synthetic.main.recyclerbox.*

class SenderTextMessageItem(
          val messageId: String,
          val checkData : CheckData,
          val context: Context,
    ) : Item() {

    private val storageInstance: FirebaseStorage by lazy {
        FirebaseStorage.getInstance()
    }

    @SuppressLint("SetTextI18n")
    override fun bind(viewHolder: ViewHolder, position: Int) {
        viewHolder.nameD.text = checkData.cusname
        viewHolder.phoneD.text = checkData.cusphone
        viewHolder.plateD.text = checkData.numcar
        viewHolder.totalall.text ="المجموع " + checkData.total
        viewHolder.totalall.setTextColor(Color.parseColor("#0637ED"))

        if (checkData.customerImage.isNotEmpty()) {
            GlideApp.with(context)
                .load(storageInstance.getReference(checkData.customerImage))
                .into(viewHolder.img_incom)
        }

        if (checkData.ojor2ed.isNotEmpty()){
            viewHolder.apply {
                textView6.setText("اجور ايد  " + checkData.ojor2ed)
            }
        }

        if (checkData.ojorm5r6ah.isNotEmpty()){
            viewHolder.apply {
                textView5.setText("اجور مخرطة  " + checkData.ojorm5r6ah)
            }
        }

        if (checkData.mjmo3came > 0.toString()){
            viewHolder.apply {
                textView4.setText("مجوع الاجور  " + checkData.mjmo3came)
            }
        }

        if (checkData.cash_paying1.isNotEmpty()){
            val checkBoxauto1 = TextView(this.context)
            val viewtext = TextView(this.context)
            viewHolder.apply {
                checkBoxauto1.text=checkData.cash_paying1
                checkBoxauto1.setTextColor(Color.parseColor("#03C30A"))
                checkBoxauto1.layoutParams = LinearLayout.LayoutParams(
                        ViewGroup.LayoutParams.WRAP_CONTENT,
                        ViewGroup.LayoutParams.WRAP_CONTENT, Float.MIN_VALUE)
                viewtext.text=checkData.cash_price11
                viewtext.setTextColor(Color.parseColor("#03C30A"))
                viewtext.gravity = Gravity.RIGHT
                viewtext.layoutParams = LinearLayout.LayoutParams(
                    ViewGroup.LayoutParams.WRAP_CONTENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT, Float.MIN_VALUE)
                payment_status.addView(viewtext)
                payment_status.addView(checkBoxauto1)
            }}
        if (checkData.wallet1.isNotEmpty()){
            val checkBoxauto1 = TextView(this.context)
            val viewtext = TextView(this.context)
            viewHolder.apply {
                checkBoxauto1.text=checkData.wallet1
                checkBoxauto1.setTextColor(Color.parseColor("#03C30A"))
                checkBoxauto1.layoutParams = LinearLayout.LayoutParams(
                        ViewGroup.LayoutParams.WRAP_CONTENT,
                        ViewGroup.LayoutParams.WRAP_CONTENT, Float.MIN_VALUE)
                viewtext.text=checkData.wallet_price1
                viewtext.setTextColor(Color.parseColor("#03C30A"))
                viewtext.gravity = Gravity.RIGHT
                viewtext.layoutParams = LinearLayout.LayoutParams(
                    ViewGroup.LayoutParams.WRAP_CONTENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT, Float.MIN_VALUE)
                payment_status.addView(viewtext)
                payment_status.addView(checkBoxauto1)
            }}
        if (checkData.credit1.isNotEmpty()){
            val checkBoxauto1 = TextView(this.context)
            val viewtext = TextView(this.context)
            viewHolder.apply {
                checkBoxauto1.text=checkData.credit1
                checkBoxauto1.setTextColor(Color.parseColor("#000000"))
                checkBoxauto1.layoutParams = LinearLayout.LayoutParams(
                        ViewGroup.LayoutParams.WRAP_CONTENT,
                        ViewGroup.LayoutParams.WRAP_CONTENT, Float.MIN_VALUE)
                viewtext.apply {
                text=checkData.credit_price1
                setTextColor(Color.parseColor("#000000"))
                gravity = Gravity.RIGHT
                    layoutParams = LinearLayout.LayoutParams(
                        ViewGroup.LayoutParams.WRAP_CONTENT,
                        ViewGroup.LayoutParams.WRAP_CONTENT, Float.MIN_VALUE)
                }
                payment_status.addView(viewtext)
                payment_status.addView(checkBoxauto1)
            }}
        if (checkData.discount1.isNotEmpty()){
            val checkBoxauto1 = TextView(this.context)
            val viewtext = TextView(this.context)
            viewHolder.apply {
                checkBoxauto1.text=checkData.discount1
                checkBoxauto1.setTextColor(Color.parseColor("#000000"))
                checkBoxauto1.layoutParams = LinearLayout.LayoutParams(
                        ViewGroup.LayoutParams.WRAP_CONTENT,
                        ViewGroup.LayoutParams.WRAP_CONTENT, Float.MIN_VALUE)
                viewtext.text=checkData.discount_price1
                viewtext.setTextColor(Color.parseColor("#000000"))
                viewtext.gravity = Gravity.RIGHT
                viewtext.layoutParams = LinearLayout.LayoutParams(
                    ViewGroup.LayoutParams.WRAP_CONTENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT, Float.MIN_VALUE)

                payment_status.addView(viewtext)
                payment_status.addView(checkBoxauto1)
            }}
        if (checkData.receivables_price1.isNotEmpty()){
            val checkreceivables = TextView(this.context)
            val viewtextreceivables = TextView(this.context)
            viewHolder.apply {

                checkreceivables.apply {
                    text=checkData.receivables1
                    setTextColor(Color.parseColor("#EC0808"))
                    setTypeface(typeface, Typeface.BOLD)
                    layoutParams = LinearLayout.LayoutParams(
                            ViewGroup.LayoutParams.WRAP_CONTENT,
                            ViewGroup.LayoutParams.WRAP_CONTENT, Float.MIN_VALUE)
                }

                viewtextreceivables.apply {
                    text=checkData.receivables_price1
                    setTextColor(Color.parseColor("#EC0808"))
                    setTypeface(typeface, Typeface.BOLD)
                    gravity = Gravity.RIGHT
                    layoutParams = LinearLayout.LayoutParams(
                            ViewGroup.LayoutParams.WRAP_CONTENT,
                            ViewGroup.LayoutParams.WRAP_CONTENT, Float.MIN_VALUE)
                }

                payment_status.addView(viewtextreceivables)
                payment_status.addView(checkreceivables)
            }}

        viewHolder.texttime.text = DateFormat.format("MM/dd/yyy hh:mm a", checkData.date).toString()
        viewHolder.text_reg_name.text = checkData.senderName

    }

    override fun getLayout():Int{
        return R.layout.recyclerbox

    }
}