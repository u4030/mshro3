package com.example.markizalhadidi

import android.app.Dialog
import android.content.Context
import android.net.ConnectivityManager
import android.text.Editable
import android.text.TextWatcher
import android.util.AttributeSet
import android.view.*
import android.widget.EditText
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelStoreOwner
import com.example.markizalhadidi.databinding.DialogAddBinding
import com.example.markizalhadidi.ui.estqbal.EstqbalViewModel
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.textfield.TextInputEditText
import com.google.firebase.firestore.FieldValue
import com.google.firebase.firestore.FirebaseFirestore

class MovableFloatingActionButton(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : FloatingActionButton(context, attrs, defStyleAttr), View.OnTouchListener {
    private val CLICK_DRAG_TOLERANCE = 10f
    private var downRawX = 0f
    private var downRawY = 0f
    private var dX = 0f
    private var dY = 0f

    private lateinit var customDialogADDM : Dialog

    private var viewModeleEstqbal: EstqbalViewModel
    private val firestoreInstance: FirebaseFirestore by lazy { FirebaseFirestore.getInstance() }
    private val chatChannelsCollectionRef = firestoreInstance.collection("chatChannels")

    constructor(context: Context, attrs: AttributeSet?) : this(context, attrs, 0)

    constructor(context: Context) : this(context, null)

    init {
        setOnTouchListener(this)
        viewModeleEstqbal = ViewModelProvider(context as ViewModelStoreOwner).get(EstqbalViewModel::class.java)
    }

    override fun onTouch(view: View, motionEvent: MotionEvent): Boolean {
        val layoutParams = view.layoutParams as ViewGroup.MarginLayoutParams
        val action = motionEvent.action
        if (action == MotionEvent.ACTION_DOWN) {
            downRawX = motionEvent.rawX
            downRawY = motionEvent.rawY
            dX = view.x - downRawX
            dY = view.y - downRawY
            return true // Consumed
        } else if (action == MotionEvent.ACTION_MOVE) {
            val viewWidth = view.width
            val viewHeight = view.height
            val viewParent = view.parent as View
            val parentWidth = viewParent.width
            val parentHeight = viewParent.height
            var newX = motionEvent.rawX + dX
            newX = Math.max(layoutParams.leftMargin.toFloat(), newX)
            newX = Math.min(parentWidth - viewWidth - layoutParams.rightMargin.toFloat(), newX)
            var newY = motionEvent.rawY + dY
            newY = Math.max(layoutParams.topMargin.toFloat(), newY)
            newY = Math.min(parentHeight - viewHeight - layoutParams.bottomMargin.toFloat(), newY)
            view.animate()
                .x(newX)
                .y(newY)
                .setDuration(0)
                .start()
            return true // Consumed
        } else if (action == MotionEvent.ACTION_UP) {
            val upRawX = motionEvent.rawX
            val upRawY = motionEvent.rawY
            val upDX = upRawX - downRawX
            val upDY = upRawY - downRawY

            if (Math.abs(upDX) < CLICK_DRAG_TOLERANCE && Math.abs(upDY) < CLICK_DRAG_TOLERANCE) {
                // Handle the click event

                val customDialogadd = DialogAddBinding.inflate(LayoutInflater.from(context))
                customDialogADDM = Dialog(context)
                customDialogADDM.setContentView(customDialogadd.root)
                customDialogADDM.setCancelable(false)
                customDialogADDM.window?.setLayout(
                    ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT)
                customDialogADDM.window?.setFlags(WindowManager.LayoutParams.FLAG_SECURE, WindowManager.LayoutParams.FLAG_SECURE)

                val editTextListpric = mutableListOf<EditText>()
                val inputEditTextList = mutableListOf<TextInputEditText>()
                for (i in 1..9) {
                    val editTextName = "pricadd$i"
                    val editText =
                        customDialogadd::class.java.getDeclaredField(editTextName).get(customDialogadd) as EditText
                    editTextListpric.add(editText)

                    val inputEditName = "tproced$i"
                    val inputEdit =
                        customDialogadd::class.java.getDeclaredField(inputEditName).get(customDialogadd) as TextInputEditText
                    inputEditTextList.add(inputEdit)

//                                val totalAmount = editTextList.filter { it.text.isNotEmpty() }.sumOf { it.text.toString().toInt() }
//                                viewModeleMo7arek.totalAmount = totalAmount.toString()
//                                toolbar?.title = "مجموع قائمة المحرك: " + viewModeleMo7arek.totalAmount
//
//                                val totalAmount = editTextList.filter { it.text.isNotEmpty() }.sumOf { it.text.toString().toInt() }
//                                viewModeleMo7arek.totalAmount = totalAmount.toString()
//                                toolbar?.title = "مجموع قائمة المحرك: " + viewModeleMo7arek.totalAmount


                        customDialogadd.btnsavadd.setOnClickListener {
                            if (!isNetworkAvailable(context)) {
                                Toast.makeText(
                                    context,
                                    "خدمة الانترنت غير متوفرة",
                                    Toast.LENGTH_LONG
                                ).apply {
                                    setGravity(Gravity.CENTER, 0, 0)
                                    show()
                                }
                            } else {

                                val contentMessage2 = mutableMapOf<String, Any>()
                                for (i in 0 until editTextListpric.size) {
                                    if (editTextListpric[i].text.isNotEmpty()) {
                                        val variableNamepric = "pricadd${i + 1}"
                                        contentMessage2[variableNamepric] = editTextListpric[i].text.toString()
                                        contentMessage2["totaladdman"] = viewModeleEstqbal.totalAmount
                                        chatChannelsCollectionRef.document(viewModeleEstqbal.myData1)
                                            .collection("messages")
                                            .document(viewModeleEstqbal.myData2)
                                            .update(contentMessage2)
                                    }
                                    else{
                                        val variableDelNamepric =hashMapOf<String, Any>( "pricadd${i + 1}" to FieldValue.delete())
                                        chatChannelsCollectionRef.document(viewModeleEstqbal.myData1)
                                            .collection("messages")
                                            .document(viewModeleEstqbal.myData2)
                                            .update(variableDelNamepric)
                                    }
                                }

                                for (i in 0 until inputEditTextList.size) {
                                    if (inputEditTextList[i].text!!.isNotEmpty()) {
                                        val variableName = "tproced${i + 1}"
                                        contentMessage2[variableName] = inputEditTextList[i].text.toString()
                                        chatChannelsCollectionRef.document(viewModeleEstqbal.myData1)
                                            .collection("messages")
                                            .document(viewModeleEstqbal.myData2)
                                            .update(contentMessage2)
                                    }
                                    else{
                                        val variableDelName =hashMapOf<String, Any>( "tproced${i + 1}" to FieldValue.delete())
                                        chatChannelsCollectionRef.document(viewModeleEstqbal.myData1)
                                            .collection("messages")
                                            .document(viewModeleEstqbal.myData2)
                                            .update(variableDelName)
                                    }
                                }
                            }
                            customDialogADDM.dismiss()
                        }

                    customDialogADDM.show()
                }

                for (i in editTextListpric.indices) {
                    editTextListpric[i].addTextChangedListener(object : TextWatcher {
                        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

                        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}

                        override fun afterTextChanged(s: Editable?) {
                            if (s.isNullOrEmpty()) {
//                                inputEditTextList[i].isChecked = false
                            }
                        }
                    })
                }
//                customDialogADDM.show()

            } else if (view.isLongClickable) {
                // Handle the long press event
                // ...
            }
        }
        return false // Not consumed
    }
    private fun isNetworkAvailable(context: Context): Boolean {
        val connectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val activeNetworkInfo = connectivityManager.activeNetworkInfo
        return activeNetworkInfo != null && activeNetworkInfo.isConnected
    }

}
