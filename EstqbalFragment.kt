package com.example.markizalhadidi.ui.estqbal

import android.content.Context
import android.net.ConnectivityManager
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.Gravity
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.example.markizalhadidi.R
import com.example.markizalhadidi.databinding.FragmentEstqbalBinding
import com.example.markizalhadidi.model.CheckMainData
import com.example.markizalhadidi.model.CheckMdata
import com.example.markizalhadidi.model.User
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore

class EstqbalFragment : Fragment() {
    private var _binding: FragmentEstqbalBinding? = null
    private val binding get() = _binding!!

    private lateinit var mCurrentChatChannelId: String
    private var mCurrentUserId = FirebaseAuth.getInstance().currentUser!!.uid
    private val firestoreInstance: FirebaseFirestore by lazy { FirebaseFirestore.getInstance() }
    private val chatChannelsCollectionRef = firestoreInstance.collection("chatChannels")

    private lateinit var nEwChatCannelId: String
    private lateinit var  otheruserid :String
    private lateinit var currentUser: User
    private lateinit var userName:String

    private lateinit var viewModel: EstqbalViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentEstqbalBinding.inflate(inflater, container, false)
        val root: View = binding.root
        otheruserid = activity?.intent!!.getStringExtra("other_uid").toString()
        userName = activity?.intent!!.getStringExtra("user_name").toString()
//        val fab = activity?.findViewById<FloatingActionButton>(R.id.fab)
//        fab!!.hide()

         viewModel = ViewModelProvider(this).get(EstqbalViewModel::class.java)

        var customer_name = ""
        var customer_phone = ""
        var plate_num_car = ""
        var color_car = ""
        var employee_name = ""
        var model_car = ""

        getUserInfo {user ->
            currentUser = user
        }

        createChatChannel { channelId ->
            mCurrentChatChannelId = channelId

            val color = arrayOf("ابيض", "اسود", "ازرق", "احمر" , "اخضر" , "كحلي" , "سلفر" , "شمباني"
                , "خمري" , "فيراني")
            val adapter = ArrayAdapter(activity!!, android.R.layout.simple_spinner_dropdown_item, color)
//            val autoCompleteTextView = activity!!.findViewById<AutoCompleteTextView>(R.id.text_color_car1)
            binding.textColorCar1.threshold=0
            binding.textColorCar1.setAdapter(adapter)

            val names = arrayOf("ابراهيم ابو راس", "صالح ابو راس", "سالم", "علي ملكاوي"
                , "م.احمد حديدي" , "ليث" , "خراطة")
            val adaptern1 = ArrayAdapter(activity!!, android.R.layout.simple_spinner_dropdown_item, names)
            val autoCompleteTextView1 = activity!!.findViewById<AutoCompleteTextView>(R.id.employeename)
            binding.employeename.threshold=0
            binding.employeename.setAdapter(adaptern1)

            binding.employeename.addTextChangedListener(object : TextWatcher {
                override fun beforeTextChanged(
                    s: CharSequence?,
                    start: Int,
                    count: Int,
                    after: Int
                ) {

                }

                override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                    if (binding.employeename.text.toString() == "خراطة") {
                        binding.textModelCar.setText("غير معروف")
                        binding.textColorCar1.setText("غير معروف")
                        binding.textPlateNumCar1.setText("00-00000")
                        binding.textCustomerPhone1.setText("0799999999")
                    }
                    else{
                        binding.textModelCar.setText("")
                        binding.textColorCar1.setText("")
                        binding.textPlateNumCar1.setText("")
                        binding.textCustomerPhone1.setText("")
                    }
                }

                override fun afterTextChanged(s: Editable?) {
                }
            })

            val mod_car = arrayOf("فيوجن", "كامري", "بريوس", "افلون" , "سكيب" , "لنكولن" , "راف 4" , "افانتي"
                , "نيرو" , "ايونك" , "سوناتا" , "اوبتما" , "سفيا 1" , "HD" , "MD" , "فورتي" , "اكسنت" , "التما"
                , "صني" , "لانسر" , "سبكترا" , "توسان" , "سبورتج" , "فيتو" , "ستركس" , "جراند ستريكس" , "H 100"
                , "باجيرو" , "شيروكي" , "تاهو" , "يوكن" , "باث فايندر" , "هاي لاندر" , "اوت لاندر" , "لكزس RX"
                , "اكاديا")
            val adapter2 = ArrayAdapter(activity!!, android.R.layout.simple_spinner_dropdown_item, mod_car)
            binding.textModelCar.threshold=0
            binding.textModelCar.setAdapter(adapter2)

            binding.textPlateNumCar1.addTextChangedListener(object : TextWatcher {
                override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                }

                override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                    val input = s.toString()
                    if (input.length == 2 && !input.contains("-")) {
                        val newInput = "$input-"
                        binding.textPlateNumCar1.setText(newInput)
                        binding.textPlateNumCar1.setSelection(newInput.length)
                    } else if (input.length > 3 && input.endsWith("-")) {
                        binding.textPlateNumCar1.setText(input.substring(0, input.length - 1))
                        binding.textPlateNumCar1.setSelection(input.substring(0, input.length - 1).length)
                    }
                }

                override fun afterTextChanged(s: Editable?) {
                }
            })

            binding.btnCompReceive1.setOnClickListener {

                if (binding.textCustomerName1.text.toString().trim().isEmpty()) {
                    binding.textCustomerName1.error = "يجب عدم ترك الخانة فارغة"
                    binding.textCustomerName1.requestFocus()
                    return@setOnClickListener
                }
                if (binding.textCustomerPhone1.length() < 10 ) {
                    binding.textCustomerPhone1.error = "رقم الموبايل اقل من 10"
                    binding.textCustomerPhone1.requestFocus()
                    return@setOnClickListener
                }
                if (!binding.textCustomerPhone1.text.toString().startsWith("077") &&
                    !binding.textCustomerPhone1.text.toString().startsWith("078")
                    && !binding.textCustomerPhone1.text.toString().startsWith("079")
                ) {
                    binding.textCustomerPhone1.error = "بداية الرقم خطأ"
                    binding.textCustomerPhone1.requestFocus()
                    return@setOnClickListener
                }

                if (binding.textPlateNumCar1.text.toString().isEmpty() || binding.textPlateNumCar1.text.toString()=="-") {
                    binding.textPlateNumCar1.error = "يجب عدم ترك الخانة فارغة"
                    binding.textPlateNumCar1.requestFocus()
                    return@setOnClickListener
                }

                if (binding.employeename.text.toString().isEmpty()) {
                    binding.employeename.error = "يجب عدم ترك الخانة فارغة"
                    binding.employeename.requestFocus()
                    return@setOnClickListener
                }

                if (binding.textColorCar1.text.toString().isEmpty()) {
                    binding.textColorCar1.error = "يجب عدم ترك الخانة فارغة"
                    binding.textColorCar1.requestFocus()
                    return@setOnClickListener
                }

                if (binding.textModelCar.text.toString().isEmpty()) {
                    binding.textModelCar.error = "يجب عدم ترك الخانة فارغة"
                    binding.textModelCar.requestFocus()
                    return@setOnClickListener
                }

                customer_name = binding.textCustomerName1.text.toString().trim()
                customer_phone = binding.textCustomerPhone1.text.toString().trim()
                plate_num_car = binding.textPlateNumCar1.text.toString().trim()
                color_car = binding.textColorCar1.text.toString().trim()
                employee_name = binding.employeename.text.toString().trim()
                model_car = binding.textModelCar.text.toString().trim()

                val checksend = CheckMainData(
                    customer_name,
                    customer_phone,
                    plate_num_car,
                    color_car,
                    employee_name,
                    model_car,
                    mCurrentUserId,
                    otheruserid,
                    currentUser.name,
                    userName,
                )

                val imm: InputMethodManager =
                    context!!.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
                if (imm.isActive)
                    imm.hideSoftInputFromWindow(view?.windowToken, 0)

                if (!isNetworkAvailable(requireContext())) {
                    Toast.makeText(requireContext(), "خدمة الانترنت غير متوفرة", Toast.LENGTH_LONG).apply {
                        setGravity(Gravity.CENTER, 0, 0)
                        show()
                    }
                }else {
                    creatdocument(
                        channelId, checksend
                    )

                    viewModel.totalAmount = 0

                    Navigation.findNavController(view!!).navigate(R.id.nav_mainfragment)
                }
            }
        }

        return root
    }
    private fun createChatChannel(onComplete: (channelId: String) -> Unit) {

        firestoreInstance.collection("users")
            .document(mCurrentUserId)
            .collection("sharedChat")
            .document(otheruserid)
            .get()
            .addOnSuccessListener { document ->
                if (document.exists()) {
                    onComplete(document["channelId"] as String)
                    return@addOnSuccessListener
                }
                val newChatChannel =
                    firestoreInstance.collection("users").document()
                firestoreInstance.collection("users")
                    .document(otheruserid)
                    .collection("sharedChat")
                    .document(mCurrentUserId)
                    .set(mapOf("channelId" to newChatChannel.id))
                firestoreInstance.collection("users")
                    .document(mCurrentUserId)
                    .collection("sharedChat")
                    .document(otheruserid)
                    .set(mapOf("channelId" to newChatChannel.id))
            }

    }

    private fun creatdocument(channelId: String, check: CheckMdata) {
        val contentMessage2 = mutableMapOf<String, Any>()
        val ref = chatChannelsCollectionRef.document(channelId).collection("messages")
            .document()

        contentMessage2["cusname"] = check.cusname
        contentMessage2["cusphone"] = check.cusphone
        contentMessage2["numcar"] = check.numcar
        contentMessage2["colorcar"] = check.colorcar
        contentMessage2["employname"] = check.employname
        contentMessage2["modlcare"] = check.modlcare
        contentMessage2["senderId"] = check.senderId
        contentMessage2["recipientId"] = check.recipientId
        contentMessage2["senderName"] = check.senderName
        contentMessage2["recipientName"] = check.recipientName
        ref.set(contentMessage2)
        nEwChatCannelId = ref.id

        viewModel.myData1=mCurrentChatChannelId
        viewModel.myData2=nEwChatCannelId
    }

    private fun isNetworkAvailable(context: Context): Boolean {
        val connectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val activeNetworkInfo = connectivityManager.activeNetworkInfo
        return activeNetworkInfo != null && activeNetworkInfo.isConnected
    }
    private fun getUserInfo(onComplete:(User) -> Unit){
        firestoreInstance.collection("users")
            .document(mCurrentUserId).get().addOnSuccessListener {
                onComplete(it.toObject(User::class.java)!!)
            }
    }
}
