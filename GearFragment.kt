package com.example.markizalhadidi.ui.gear

import android.content.Context
import android.net.ConnectivityManager
import android.os.Bundle
import android.os.Handler
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.markizalhadidi.R
import com.example.markizalhadidi.databinding.ActivityMainBinding
import com.example.markizalhadidi.databinding.FragmentGearBinding
import com.example.markizalhadidi.ui.estqbal.EstqbalViewModel
import com.google.firebase.firestore.FieldValue
import com.google.firebase.firestore.FirebaseFirestore

class GearFragment : Fragment() {

    private var _binding: FragmentGearBinding? = null
    private val binding get() = _binding!!

    private lateinit var bindingtoolbar: ActivityMainBinding

    private lateinit var viewModeleEstqbal: EstqbalViewModel
    private lateinit var viewModeleGear: GearViewModel

    private val firestoreInstance: FirebaseFirestore by lazy { FirebaseFirestore.getInstance() }
    private val chatChannelsCollectionRef = firestoreInstance.collection("chatChannels")

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentGearBinding.inflate(inflater, container, false)
        val root: View = binding.root

        viewModeleEstqbal = activity?.run {
            ViewModelProvider(this).get(EstqbalViewModel::class.java)
        } ?: throw Exception("Invalid Activity")

        viewModeleGear = activity?.run {
            ViewModelProvider(this).get(GearViewModel::class.java)
        } ?: throw Exception("Invalid Activity")

        bindingtoolbar = ActivityMainBinding.inflate(layoutInflater)
        val toolbar = activity?.findViewById<Toolbar>(R.id.toolbar)
        toolbar?.setTitleTextAppearance(this.context, R.style.boldText)

        val editTextList = mutableListOf<EditText>()
        val checkBoxList = mutableListOf<CheckBox>()
        for (i in 1..22) {
            val editTextName = "pricgear$i"
            val editText =
                binding::class.java.getDeclaredField(editTextName).get(binding) as EditText
            editTextList.add(editText)
            val checkBoxName = "chgear$i"
            val checkBox =
                binding::class.java.getDeclaredField(checkBoxName).get(binding) as CheckBox
            checkBoxList.add(checkBox)
            checkBox.setOnCheckedChangeListener { _, isChecked ->
                if (isChecked && editText.text.isEmpty()) {
                    checkBox.isChecked = false
                    Toast.makeText(activity, "يجب إدخال السعر اولا", Toast.LENGTH_LONG).apply {
                        show()
                    }
                } else {
                    if (!checkBox.isChecked){
                        editText.text = null
                        val totalAmount = editTextList.filter { it.text.isNotEmpty() }.sumOf { it.text.toString().toIntOrNull() ?: 0 }
                        viewModeleGear.totalAmount = totalAmount.toString()
                        toolbar?.title = "مجموع قائمة الجير: " + viewModeleGear.totalAmount
                    }
                    else{
                        val totalAmount = editTextList.filter { it.text.isNotEmpty() }.sumOf { it.text.toString().toIntOrNull() ?: 0 }
                        viewModeleGear.totalAmount = totalAmount.toString()
                        toolbar?.title = "مجموع قائمة الجير: " + viewModeleGear.totalAmount
                    }
                }
            }
            binding.savgear.setOnClickListener {
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
                            val variableNamepric = "pricgear${i + 1}"
                            contentMessage2[variableNamepric] = editTextList[i].text.toString()
                            contentMessage2["totalgear"] = viewModeleGear.totalAmount
                            chatChannelsCollectionRef.document(viewModeleEstqbal.myData1)
                                .collection("messages")
                                .document(viewModeleEstqbal.myData2)
                                .update(contentMessage2)
                        }
                        else{
                            val variableDelNamepric =hashMapOf<String, Any>( "pricgear${i + 1}" to FieldValue.delete())
                            chatChannelsCollectionRef.document(viewModeleEstqbal.myData1)
                                .collection("messages")
                                .document(viewModeleEstqbal.myData2)
                                .update(variableDelNamepric)
                        }
                    }

                    for (i in 0 until checkBoxList.size) {
                        if (checkBoxList[i].isChecked) {
                            val variableName = "chgear${i + 1}"
                            contentMessage2[variableName] = checkBoxList[i].text.toString()
                            chatChannelsCollectionRef.document(viewModeleEstqbal.myData1)
                                .collection("messages")
                                .document(viewModeleEstqbal.myData2)
                                .update(contentMessage2)
                        }
                        else{
                            val variableDelName =hashMapOf<String, Any>( "chgear${i + 1}" to FieldValue.delete())
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
                    if (s.isNullOrEmpty()) {
                        checkBoxList[i].isChecked = false
                    }
                }
                override fun afterTextChanged(s: Editable?) {

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