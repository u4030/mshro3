package com.example.markizalhadidi.ui.fa79computer

import android.app.Activity.RESULT_OK
import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import android.net.ConnectivityManager
import android.os.Bundle
import android.provider.MediaStore
import android.text.Editable
import android.text.TextWatcher
import android.view.Gravity
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.widget.Toolbar
import androidx.lifecycle.ViewModelProvider
import com.example.markizalhadidi.R
import com.example.markizalhadidi.databinding.ActivityMainBinding
import com.example.markizalhadidi.databinding.FragmentFa79ComputerBinding
import com.example.markizalhadidi.ui.estqbal.EstqbalViewModel
import com.google.firebase.firestore.FieldValue
import com.google.firebase.firestore.FirebaseFirestore

class Fa79ComputerFragment : Fragment() {

    private var _binding: FragmentFa79ComputerBinding? = null
    private val binding get() = _binding!!

    private lateinit var viewModelFa79Com: Fa79ComputerViewModel

    private lateinit var bindingtoolbar: ActivityMainBinding

    private lateinit var viewModeleEstqbal: EstqbalViewModel

    private val firestoreInstance: FirebaseFirestore by lazy { FirebaseFirestore.getInstance() }
    private val chatChannelsCollectionRef = firestoreInstance.collection("chatChannels")

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentFa79ComputerBinding.inflate(inflater, container, false)
        val root: View = binding.root

        viewModeleEstqbal = activity?.run {
            ViewModelProvider(this).get(EstqbalViewModel::class.java)
        } ?: throw Exception("Invalid Activity")

        viewModelFa79Com = activity?.run {
            ViewModelProvider(this).get(Fa79ComputerViewModel::class.java)
        } ?: throw Exception("Invalid Activity")

        bindingtoolbar = ActivityMainBinding.inflate(layoutInflater)
        val toolbar = activity?.findViewById<Toolbar>(R.id.toolbar)
        toolbar?.setTitleTextAppearance(this.context, R.style.boldText)

        val imageList = mutableListOf<ImageView>()
        for (i in 1..4) {
            val editImageName = "imgfa79com$i"
            val editImage =
                binding::class.java.getDeclaredField(editImageName).get(binding) as ImageView
            imageList.add(editImage)
            editImage.setOnClickListener {
                val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
                startActivityForResult(intent, 0)
            }
                    }

        val editTextList = mutableListOf<EditText>()
        val checkBoxList = mutableListOf<CheckBox>()
        for (i in 1..6) {
            val editTextName = "pricfa79com$i"
            val editText =
                binding::class.java.getDeclaredField(editTextName).get(binding) as EditText
            editTextList.add(editText)
            val checkBoxName = "chfa79com$i"
            val checkBox =
                binding::class.java.getDeclaredField(checkBoxName).get(binding) as CheckBox
            checkBoxList.add(checkBox)
            checkBox.setOnCheckedChangeListener { _, isChecked ->
                if (isChecked && editText.text.isEmpty()) {
                    checkBox.isChecked = false
                    Toast.makeText(activity, "يجب إدخال السعر اولا", Toast.LENGTH_LONG).apply {
//                        setBackgroundTintList(ColorStateList.valueOf(Color.RED))
                        setGravity(5, 100, -400)
                        show()
                    }
                } else {
                    if (!checkBox.isChecked){
                        editText.text = null
                        val totalAmount = editTextList.filter { it.text.isNotEmpty() }.sumOf { it.text.toString().toInt() }
                        viewModelFa79Com.totalAmount = totalAmount.toString()
                        toolbar?.title = "مجموع قائمة فحص الكمبيوتر: " + viewModelFa79Com.totalAmount
                    }
                    else{
                        val totalAmount = editTextList.filter { it.text.isNotEmpty() }.sumOf { it.text.toString().toInt() }
                        viewModelFa79Com.totalAmount = totalAmount.toString()
                        toolbar?.title = "مجموع قائمة فحص الكمبيوتر: " + viewModelFa79Com.totalAmount
                    }
                }
            }
            binding.savfa79.setOnClickListener {
                for (i in 0 until editTextList.size) {
                    if (editTextList[i].text.isNotEmpty() && !checkBoxList[i].isChecked) {
                        checkBoxList[i].error ="رسالة خطأ"
                        return@setOnClickListener
                    }else{
                        checkBoxList[i].error = null
                    }
                }
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
                            val variableNamepric = "pricfa79com${i + 1}"
                            contentMessage2[variableNamepric] = editTextList[i].text.toString()
                            contentMessage2["totalmo7arek"] = viewModeleEstqbal.totalAmount
                            chatChannelsCollectionRef.document(viewModeleEstqbal.myData1)
                                .collection("messages")
                                .document(viewModeleEstqbal.myData2)
                                .update(contentMessage2)
                        }
                        else{
                            val variableDelNamepric =hashMapOf<String, Any>( "pricfa79com${i + 1}" to FieldValue.delete())
                            chatChannelsCollectionRef.document(viewModeleEstqbal.myData1)
                                .collection("messages")
                                .document(viewModeleEstqbal.myData2)
                                .update(variableDelNamepric)
                        }
                    }

                    for (i in 0 until checkBoxList.size) {
                        if (checkBoxList[i].isChecked) {
                            val variableName = "chfa79com${i + 1}"
                            contentMessage2[variableName] = checkBoxList[i].text.toString()
                            chatChannelsCollectionRef.document(viewModeleEstqbal.myData1)
                                .collection("messages")
                                .document(viewModeleEstqbal.myData2)
                                .update(contentMessage2)
                        }
                        else{
                            val variableDelName =hashMapOf<String, Any>( "chfa79com${i + 1}" to FieldValue.delete())
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

                override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}

                override fun afterTextChanged(s: Editable?) {
//                    checkBoxList[i].isChecked = !s.isNullOrEmpty()
                    if (s.isNullOrEmpty()) {
                        checkBoxList[i].isChecked = false
                    }
                }
            })
        }

        return root
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == RESULT_OK && requestCode == 0) {
            val imageBitmap = data?.extras?.get("data") as Bitmap
            imageList[i].setImageBitmap(imageBitmap)
        }
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


