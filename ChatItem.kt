package com.example.markizalhadidi.recyclerview

import android.content.Context
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.markizalhadidi.R
import com.example.markizalhadidi.databinding.RecyclerViewItem1Binding
import com.example.markizalhadidi.model.TextMessage
import com.example.markizalhadidi.model.User
import com.google.firebase.storage.FirebaseStorage
import com.xwray.groupie.Item

// هذا الكلاس المسؤول عن تمرير البنات الى الرسايكل فيو
class ChatItem(
    val uid: String,
    val user: User,
    val textMessage: TextMessage,
    val context: Context,
) : Item<ChatItem.ViewHolder>() {

    private val storageInstance: FirebaseStorage by lazy {
        FirebaseStorage.getInstance()
    }
    override fun getLayout(): Int {
        return R.layout.recycler_view_item_1
    }

    override fun createViewHolder(itemView: View): ViewHolder {
        return ViewHolder(itemView)
    }

    override fun bind(viewHolder: ViewHolder, position: Int) {
        viewHolder.binding.textView11.text = user.name

        if (user.profileImage.isNotEmpty()) {
//            GlideApp.with(context)
//                .load(storageInstance.getReference(user.profileImage))
//                .into(viewHolder.binding.imageView1)
//        } else {
            viewHolder.binding.imageView1.setImageResource(R.drawable.ic_account_circle)
        }
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val binding = RecyclerViewItem1Binding.bind(itemView)
    }
}