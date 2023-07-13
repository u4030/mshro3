package com.example.mizanalnasr.main

import android.app.Activity
import android.content.ContentValues.TAG
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.net.Uri
import android.os.Bundle
import android.os.Environment
import android.provider.MediaStore
import android.support.v4.content.FileProvider
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.DividerItemDecoration
import android.util.Log
import android.view.View
import android.view.WindowManager
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.Toast
import com.example.mizanalnasr.R
import com.example.mizanalnasr.model.TextMessage
import com.example.mizanalnasr.model.User
import com.example.mizanalnasr.recycler.ChatItem
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ListenerRegistration
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.StorageReference
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.OnItemClickListener
import com.xwray.groupie.Section
import com.xwray.groupie.kotlinandroidextensions.Item
import com.xwray.groupie.kotlinandroidextensions.ViewHolder
import kotlinx.android.synthetic.main.activity_users.*
import java.io.ByteArrayOutputStream
import java.io.File
import java.io.IOException
import java.text.SimpleDateFormat
import java.util.*

class Users : AppCompatActivity() {

    private val firestoreInstance: FirebaseFirestore by lazy {
        FirebaseFirestore.getInstance()
    }

    companion object {
        val RC_SELECT_IMAGE = 2
    }

    private lateinit var userName: String

    private val storageInstance: FirebaseStorage by lazy {
        FirebaseStorage.getInstance()
    }

    private val currentUserStorageRef: StorageReference
        get() = storageInstance.reference.child(FirebaseAuth.getInstance().currentUser?.uid.toString())

    private lateinit var chatSection: Section

    private val TAG = "MainActivity"
    private val REQUEST_TAKE_PHOTO = 1
    private var currentPhotoPath: String? = null
    private var photoURI: Uri? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_users)

        window.setFlags(WindowManager.LayoutParams.FLAG_SECURE, WindowManager.LayoutParams.FLAG_SECURE)

     val   imageuser = findViewById<ImageView>(R.id.imageuser)

        imageuser.setOnClickListener {
//            val myIntentImage = Intent().apply {
//                type = "image/*"
//                action = Intent.ACTION_GET_CONTENT
//                putExtra(Intent.EXTRA_MIME_TYPES, arrayOf("image/jpeg", "image/png"))
//            }
//            startActivityForResult(Intent.createChooser(myIntentImage, "Select Image"), RC_SELECT_IMAGE)
            dispatchTakePictureIntent()

        }

        addChatListener(::initRecyclerView)
    }
    private fun dispatchTakePictureIntent() {
        Intent(MediaStore.ACTION_IMAGE_CAPTURE).also { takePictureIntent ->
            // Ensure that there's a camera activity to handle the intent
            takePictureIntent.resolveActivity(packageManager)?.also {
                // Create the File where the photo should go
                val photoFile: File? = try {
                    createImageFile()
                } catch (ex: IOException) {
                    // Error occurred while creating the File
                    null
                }
                // Continue only if the File was successfully created
                photoFile?.also {
                    val photoURI: Uri = FileProvider.getUriForFile(
                        this,
                        "com.example.android.fileprovider",
                        it
                    )
                    takePictureIntent.putExtra(MediaStore.EXTRA_OUTPUT, photoURI)
                    startActivityForResult(takePictureIntent, REQUEST_TAKE_PHOTO)
                }
            }
        }
    }
    private fun createImageFile(): File {
        // Create an image file name
        val timeStamp: String = SimpleDateFormat("yyyyMMdd_HHmmss").format(Date())
        val storageDir: File? = getExternalFilesDir(Environment.DIRECTORY_PICTURES)
        return File.createTempFile(
            "JPEG_${timeStamp}_", /* prefix */
            ".jpg", /* suffix */
            storageDir /* directory */
        ).apply {
            // Save a file: path for use with ACTION_VIEW intents
            currentPhotoPath = absolutePath
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == REQUEST_TAKE_PHOTO && resultCode == RESULT_OK) {
            val imageBitmap = BitmapFactory.decodeFile(currentPhotoPath)
            imageuser.setImageBitmap(imageBitmap)

            val storageRef = currentUserStorageRef.child("images/pic.jpg")
            val uploadTask = storageRef.putFile(photoURI!!)
            uploadTask.continueWithTask { task ->
                if (!task.isSuccessful) {
                    task.exception?.let {
                        throw it
                    }
                }
                storageRef.downloadUrl
            }.addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    val downloadUri = task.result
                    Log.d(TAG, "onComplete: Url: $downloadUri")
                } else {
                    Toast.makeText(this, "upload failed: ${task.exception?.message}", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

//    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
//        super.onActivityResult(requestCode, resultCode, data)
//
//        if (requestCode == RC_SELECT_IMAGE && resultCode == Activity.RESULT_OK &&
//            data != null && data.data != null) {
//
//            progressBar.visibility = View.VISIBLE
//
//            val selectedImagePath = data.data
//            val selectedImageBmp = MediaStore.Images.Media.getBitmap(this.contentResolver, selectedImagePath)
//            val outputStream = ByteArrayOutputStream()
//            selectedImageBmp.compress(Bitmap.CompressFormat.JPEG, 20, outputStream)
//            val selectedImageBytes = outputStream.toByteArray()
//
//            uploadProfileImage(selectedImageBytes) { path ->
//                val userFieldMap = mutableMapOf<String, Any>()
//                userFieldMap["customerImage"] = path
//                firestoreInstance.document("users/${FirebaseAuth.getInstance().currentUser?.uid.toString()}")
//                .update(userFieldMap)
//            }
//        }
//    }

    private fun uploadProfileImage(selectedImageBytes: ByteArray, onSuccess: (imagePath: String) -> Unit) {
        val ref = currentUserStorageRef.child("customerPictures/${UUID.nameUUIDFromBytes(selectedImageBytes)}")
        ref.putBytes(selectedImageBytes).addOnCompleteListener {
            if (it.isSuccessful) {
                onSuccess(ref.path)
                progressBar.visibility = View.GONE
            } else {
                Toast.makeText(this, "Error : ${it.exception?.message.toString()}", Toast.LENGTH_LONG)
                    .show()
            }
        }
    }

    private fun addChatListener(onListen: (List<Item>) -> Unit): ListenerRegistration {
        return firestoreInstance.collection("users")
            .addSnapshotListener { querySnapshot, firebaseFirestoreException ->
                if (firebaseFirestoreException != null) {
                    return@addSnapshotListener
                }
                val items = mutableListOf<Item>()
                querySnapshot!!.documents.forEach { document ->
                    if (document.exists()) {
                        items.add(
                            ChatItem(
                                document.id,
                                document.toObject(User::class.java)!!,
                                document.toObject(TextMessage::class.java)!!,
                                this@Users
                            )
                        )
                    }
                }
                onListen(items)
            }
    }

    private fun initRecyclerView(item: List<Item>) {
        recyclerUsers.apply {
            addItemDecoration(DividerItemDecoration(this.context, DividerItemDecoration.VERTICAL))
            adapter = GroupAdapter<ViewHolder>().apply {
                chatSection = Section(item)
                add(chatSection)
                setOnItemClickListener(onItemClick)
            }
        }
    }
    private val onItemClick = OnItemClickListener { item, view ->
        if (item is ChatItem){
                        val intentChatActivity = Intent(this, MainActivity::class.java)
                        intentChatActivity.putExtra("user_name",item.user.name)
                        intentChatActivity.putExtra("profile_image",item.user.profileImage)
                        intentChatActivity.putExtra("other_uid",item.uid)
                        startActivity(intentChatActivity)
        }
    }
}