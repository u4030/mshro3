package com.example.markizalhadidi.ui.mo7arek

import android.content.Context
import android.net.ConnectivityManager
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.widget.Toolbar
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.markizalhadidi.R
import com.example.markizalhadidi.databinding.ActivityMainBinding
import com.example.markizalhadidi.databinding.FragmentMo7arekBinding
import com.example.markizalhadidi.ui.estqbal.EstqbalViewModel
import com.google.firebase.firestore.FirebaseFirestore

class Mo7arekFragment : Fragment() {

    private var _binding: FragmentMo7arekBinding? = null
    private val binding get() = _binding!!

    private lateinit var bindingtoolbar: ActivityMainBinding

    private lateinit var viewModele: EstqbalViewModel

    private val firestoreInstance: FirebaseFirestore by lazy { FirebaseFirestore.getInstance() }
    private val chatChannelsCollectionRef = firestoreInstance.collection("chatChannels")
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val galleryViewModel =
            ViewModelProvider(this).get(GalleryViewModel::class.java)

        _binding = FragmentMo7arekBinding.inflate(inflater, container, false)
        val root: View = binding.root
        viewModele = ViewModelProvider(this).get(EstqbalViewModel::class.java)

        bindingtoolbar = ActivityMainBinding.inflate(layoutInflater)
        val toolbar = activity?.findViewById<Toolbar>(R.id.toolbar)
        toolbar?.setTitleTextAppearance(this.context, R.style.boldText)

        val editTextList = mutableListOf<EditText>()
        val checkBoxList = mutableListOf<CheckBox>()

        for (i in 1..21) {
            val editTextName = "pricmo7arek$i"
            val editText =
                binding::class.java.getDeclaredField(editTextName).get(binding) as EditText
            editTextList.add(editText)
            val checkBoxName = "chmo7arek$i"
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
                    binding.savemo7arek.setOnClickListener {
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

                            var allEditTextsFilled = true
                            var allCheckBoxesChecked = true
                            val editTextValues = mutableListOf<String>()
                            val checkBoxValues = mutableListOf<String>()
                            val contentMessage2 = mutableMapOf<String, Any>()

                        for (i in 0 until editTextList.size) {
                            if (editTextList[i].text.isEmpty()) {
                                allEditTextsFilled = false
                                break
                            } else {
                                editTextValues.add(editTextList[i].text.toString())
                            }
                        }

                        for (i in 0 until checkBoxList.size) {
                            if (!checkBoxList[i].isChecked) {
                                allCheckBoxesChecked = false
                                break
                            } else {
                                checkBoxValues.add(checkBoxList[i].text.toString())
                            }
                        }
                        if (allEditTextsFilled && allCheckBoxesChecked) {
                            for (i in 0 until editTextValues.size) {
                               val variableNamepric = "pricmo7arek${i + 1}"
                               val variableValuepric = editTextValues[i]
                                contentMessage2[variableNamepric] = variableValuepric
                                chatChannelsCollectionRef.document("0NA6NYGueVxXMZbTvf37")
                                    .collection("messages")
                                    .document("hd3XmBTcIwS5yLotIuic")
                                    .update(contentMessage2)
                            }

                            for (i in 0 until checkBoxList.size) {
                                val variableName = "chmo7arek${i + 1}"
                                val variableValue = checkBoxValues[i]
                                contentMessage2[variableName] = variableValue
                                chatChannelsCollectionRef.document("0NA6NYGueVxXMZbTvf37")
                                    .collection("messages")
                                    .document("hd3XmBTcIwS5yLotIuic")
                                    .update(contentMessage2)
                            }
                        }
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
                    if (s.isNullOrEmpty()) {
                        checkBoxList[i].isChecked = false
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