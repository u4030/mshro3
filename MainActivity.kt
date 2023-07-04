package com.example.mizanalnasr.main

import android.app.Activity
import android.app.Dialog
import android.arch.lifecycle.ViewModelProviders
import android.content.Intent
import android.graphics.Bitmap
import android.os.Build
import android.os.Bundle
import android.provider.MediaStore
import android.support.annotation.RequiresApi
import android.support.design.widget.NavigationView
import android.support.v4.widget.DrawerLayout
import android.support.v7.app.AppCompatActivity
import android.text.Editable
import android.text.TextWatcher
import android.view.*
import android.widget.CheckBox
import android.widget.TextView
import android.widget.Toast
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.mizanalnasr.R
import com.example.mizanalnasr.databinding.ActivityMainBinding
import com.example.mizanalnasr.ui.first.FirstViewModel
import com.example.neprotest.model.CheckData
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.StorageReference
import kotlinx.android.synthetic.main.activity_sign_up.*
import kotlinx.android.synthetic.main.add_dailog.*
import kotlinx.android.synthetic.main.app_bar_main.*
import kotlinx.android.synthetic.main.camera_dailog.*
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.android.synthetic.main.fragment_home.pricd2
import kotlinx.android.synthetic.main.fragment_home.pricd3
import kotlinx.android.synthetic.main.fragment_home.pricd4
import kotlinx.android.synthetic.main.fragment_home.pricd5
import kotlinx.android.synthetic.main.fragment_home.pricd6
import kotlinx.android.synthetic.main.fragment_home.pricd7
import kotlinx.android.synthetic.main.fragment_home.pricd8
import kotlinx.android.synthetic.main.fragment_home.pricd9
import kotlinx.android.synthetic.main.fragment_home.view.*
import kotlinx.android.synthetic.main.fragment_m5r6ah.*
import kotlinx.android.synthetic.main.fragment_m5r6ah.view.*
import kotlinx.android.synthetic.main.fragment_slideshow.*
import kotlinx.android.synthetic.main.paying_dailog.*
import java.io.ByteArrayOutputStream
import java.util.*

class MainActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMainBinding
    companion object {
        private val REQUST_CODE = 2
    }
    private val firestoreInstance: FirebaseFirestore by lazy {
        FirebaseFirestore.getInstance()
    }
    private val storageInstance: FirebaseStorage by lazy {
        FirebaseStorage.getInstance()
    }
    private val currentUserStorageRef: StorageReference
        get() = storageInstance.reference.child(FirebaseAuth.getInstance().currentUser?.uid.toString())

    private lateinit var customDialogCAM: Dialog
    private lateinit var viewModel: FirstViewModel

    var ent2ojoryadwyeh: Int = 0

    var addojoryadwyeh=""
    var addojor5ra6ah=""
    var addtotalcame=""

    var fabVisible = false

    private val chatChannelsCollectionRef = firestoreInstance.collection("chatChannels")

    var editD1 = ""
    var editD2 = ""
    var editD3 = ""
    var editD4 = ""
    var editD5 = ""
    var editD6 = ""
    var editD7 = ""
    var editD8 = ""
    var editD9 = ""

    var pricD1 = ""
    var pricD2 = ""
    var pricD3 = ""
    var pricD4 = ""
    var pricD5 = ""
    var pricD6 = ""
    var pricD7 = ""
    var pricD8 = ""
    var pricD9 = ""

    var cash_paying1 = ""
    var cash_price11 = ""
    var wallet1 = ""
    var wallet_price1 = ""
    var credit1 = ""
    var credit_price1 = ""
    var Discount1 = ""
    var Discount_pricec1 = ""
    var receivables1 = ""
    var receivables_price1 = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        window.setFlags(WindowManager.LayoutParams.FLAG_SECURE, WindowManager.LayoutParams.FLAG_SECURE)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.appBarMain.toolbar)

        viewModel = run {
            ViewModelProviders.of(this).get(FirstViewModel::class.java)
        } ?: throw Exception("Invalid Activity")

        toolbar.setTitleTextAppearance(this, R.style.boldText)
        fabVisible = false

         customDialogCAM = Dialog(this)
        customDialogCAM.setContentView(R.layout.camera_dailog)
        customDialogCAM.setCancelable(false)
        customDialogCAM.window?.setLayout(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.WRAP_CONTENT)

        binding.appBarMain.fab.setOnClickListener {
            if (!fabVisible) {
                binding.appBarMain.fab1.show()
                binding.appBarMain.fab2.show()
                binding.appBarMain.fab.setImageDrawable(resources.getDrawable(android.R.drawable.ic_menu_add))
                fabVisible = true
            }else {
                binding.appBarMain.fab1.hide()
                binding.appBarMain.fab2.hide()
                binding.appBarMain.fab.setImageDrawable(resources.getDrawable(android.R.drawable.ic_menu_add))
                fabVisible = false
            }

            binding.appBarMain.fab1.setOnClickListener {
                if (!fabVisible) {
                    binding.appBarMain.fab1.show()
                    binding.appBarMain.fab2.show()
                    fabVisible = true
                } else {
                    binding.appBarMain.fab1.hide()
                    binding.appBarMain.fab2.hide()
                    binding.appBarMain.fab.setImageDrawable(resources.getDrawable(R.drawable.ic_menu_camera))
                    fabVisible = false

                    customDialogCAM.cam_img.setOnClickListener {
                        val myIntentImage = Intent().apply {
                            type = "image/*"
                            action = Intent.ACTION_GET_CONTENT
                            putExtra(Intent.EXTRA_MIME_TYPES, arrayOf("image/jpeg", "image/png"))
                        }
                        startActivityForResult(Intent.createChooser(myIntentImage, "Select Image"), REQUST_CODE)
                    }
                    customDialogCAM.ojor_yadwyeh.addTextChangedListener(object : TextWatcher {
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
                            if (customDialogCAM.ojor_5ra6ah.text.toString()
                                    .isEmpty() && customDialogCAM.ojor_yadwyeh.text.toString()
                                    .isNotEmpty()
                            ) {
                                customDialogCAM.majmo3_2jra2.text =
                                    customDialogCAM.ojor_yadwyeh.text.toString()
                            }
                            if (customDialogCAM.ojor_5ra6ah.text.toString()
                                    .isNotEmpty() && customDialogCAM.ojor_yadwyeh.text.toString()
                                    .isEmpty()
                            ) {
                                customDialogCAM.majmo3_2jra2.text =
                                    customDialogCAM.ojor_5ra6ah.text.toString()
                            }

                            if (customDialogCAM.ojor_5ra6ah.text.toString()
                                    .isNotEmpty() && customDialogCAM.ojor_yadwyeh.text.toString()
                                    .isNotEmpty()
                            ) {
                                ent2ojoryadwyeh = 0
                                ent2ojoryadwyeh += customDialogCAM.ojor_yadwyeh.text.toString()
                                    .toInt()
                                ent2ojoryadwyeh += customDialogCAM.ojor_5ra6ah.text.toString()
                                    .toInt()
                                customDialogCAM.majmo3_2jra2.text = ent2ojoryadwyeh.toString()
                            }
                            if (customDialogCAM.ojor_5ra6ah.text.toString()
                                    .isEmpty() && customDialogCAM.ojor_yadwyeh.text.toString()
                                    .isEmpty()
                            ) {
                                customDialogCAM.majmo3_2jra2.text = ""
                            }
                        }

                        override fun afterTextChanged(s: Editable?) {
                        }

                    })

                    customDialogCAM.ojor_5ra6ah.addTextChangedListener(object : TextWatcher {
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
                            if (customDialogCAM.ojor_5ra6ah.text.toString()
                                    .isNotEmpty() && customDialogCAM.ojor_yadwyeh.text.toString()
                                    .isNotEmpty()
                            ) {
                                ent2ojoryadwyeh = 0
                                ent2ojoryadwyeh += customDialogCAM.ojor_yadwyeh.text.toString()
                                    .toInt()
                                ent2ojoryadwyeh += customDialogCAM.ojor_5ra6ah.text.toString()
                                    .toInt()
                                customDialogCAM.majmo3_2jra2.text = ent2ojoryadwyeh.toString()
                            }
                            if (customDialogCAM.ojor_5ra6ah.text.toString()
                                    .isNotEmpty() && customDialogCAM.ojor_yadwyeh.text.toString()
                                    .isEmpty()
                            ) {
                                customDialogCAM.majmo3_2jra2.text =
                                    customDialogCAM.ojor_5ra6ah.text.toString()
                            }
                            if (customDialogCAM.ojor_5ra6ah.text.toString()
                                    .isEmpty() && customDialogCAM.ojor_yadwyeh.text.toString()
                                    .isNotEmpty()
                            ) {
                                customDialogCAM.majmo3_2jra2.text =
                                    customDialogCAM.ojor_yadwyeh.text.toString()
                            }
                            if (customDialogCAM.ojor_5ra6ah.text.toString()
                                    .isEmpty() && customDialogCAM.ojor_yadwyeh.text.toString()
                                    .isEmpty()
                            ) {
                                customDialogCAM.majmo3_2jra2.text = ""
                            }
                        }

                        override fun afterTextChanged(s: Editable?) {

                        }

                    })
                    customDialogCAM.show()
                }
            }
        }

        customDialogCAM.cancel_camera.setOnClickListener {
            customDialogCAM.ojor_yadwyeh.setText("")
            customDialogCAM.ojor_5ra6ah.setText("")
            customDialogCAM.cam_img.setImageResource(R.mipmap.logo_foreground)
            binding.appBarMain.fab.setImageDrawable(resources.getDrawable(android.R.drawable.ic_menu_add))
            customDialogCAM.dismiss()
        }

        binding.appBarMain.fab2.setOnClickListener {
            if (!fabVisible) {
                binding.appBarMain.fab1.show()
                binding.appBarMain.fab2.show()
                fabVisible = true
            } else {
                binding.appBarMain.fab1.hide()
                binding.appBarMain.fab2.hide()
                binding.appBarMain.fab.setImageDrawable(resources.getDrawable(R.drawable.ic_menu_camera))
                fabVisible = false

                val customDialogFB = Dialog(this)
                customDialogFB.setContentView(R.layout.add_dailog)
                customDialogFB.setCancelable(false)
                customDialogFB.window?.setLayout(
                    ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.MATCH_PARENT
                )

                customDialogFB.pricd1.addTextChangedListener(object :TextWatcher{
                    override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                    }

                    override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                        customDialogFB.procd2.isEnabled=customDialogFB.procd1.toString().trim().isNotEmpty()
                                && customDialogFB.pricd1.text.toString().trim().isNotEmpty()
                        customDialogFB.pricd2.isEnabled=customDialogFB.procd1.toString().trim().isNotEmpty()
                                && customDialogFB.pricd1.text.toString().trim().isNotEmpty()
                    }

                    override fun afterTextChanged(p0: Editable?) {

                    }

                })
                customDialogFB.pricd2.addTextChangedListener(object :TextWatcher{
                    override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                    }

                    override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                        customDialogFB.procd3.isEnabled=customDialogFB.procd2.toString().trim().isNotEmpty()
                                && customDialogFB.pricd2.text.toString().trim().isNotEmpty()
                        customDialogFB.pricd3.isEnabled=customDialogFB.procd2.toString().trim().isNotEmpty()
                                && customDialogFB.pricd2.text.toString().trim().isNotEmpty()
                    }

                    override fun afterTextChanged(p0: Editable?) {
                    }

                })
                customDialogFB.pricd3.addTextChangedListener(object :TextWatcher{
                    override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                    }

                    override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                        customDialogFB.procd4.isEnabled=customDialogFB.procd3.toString().trim().isNotEmpty()
                                && customDialogFB.pricd3.text.toString().trim().isNotEmpty()
                        customDialogFB.pricd4.isEnabled=customDialogFB.procd3.toString().trim().isNotEmpty()
                                && customDialogFB.pricd3.text.toString().trim().isNotEmpty()
                    }

                    override fun afterTextChanged(p0: Editable?) {
                    }

                })
                customDialogFB.pricd4.addTextChangedListener(object :TextWatcher{
                    override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                    }

                    override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                        customDialogFB.procd5.isEnabled=customDialogFB.procd4.toString().trim().isNotEmpty()
                                && customDialogFB.pricd4.text.toString().trim().isNotEmpty()
                        customDialogFB.pricd5.isEnabled=customDialogFB.procd4.toString().trim().isNotEmpty()
                                && customDialogFB.pricd4.text.toString().trim().isNotEmpty()
                    }

                    override fun afterTextChanged(p0: Editable?) {
                    }

                })
                customDialogFB.pricd5.addTextChangedListener(object :TextWatcher{
                    override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                    }

                    override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                        customDialogFB.procd6.isEnabled=customDialogFB.procd5.toString().trim().isNotEmpty()
                                && customDialogFB.pricd5.text.toString().trim().isNotEmpty()
                        customDialogFB.pricd6.isEnabled=customDialogFB.procd5.toString().trim().isNotEmpty()
                                && customDialogFB.pricd5.text.toString().trim().isNotEmpty()
                    }

                    override fun afterTextChanged(p0: Editable?) {
                    }

                })
                customDialogFB.pricd6.addTextChangedListener(object :TextWatcher{
                    override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                    }

                    override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                        customDialogFB.procd7.isEnabled=customDialogFB.procd6.toString().trim().isNotEmpty()
                                && customDialogFB.pricd6.text.toString().trim().isNotEmpty()
                        customDialogFB.pricd7.isEnabled=customDialogFB.procd6.toString().trim().isNotEmpty()
                                && customDialogFB.pricd6.text.toString().trim().isNotEmpty()
                    }

                    override fun afterTextChanged(p0: Editable?) {
                    }

                })
                customDialogFB.pricd7.addTextChangedListener(object :TextWatcher{
                    override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                    }

                    override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                        customDialogFB.procd8.isEnabled=customDialogFB.procd7.toString().trim().isNotEmpty()
                                && customDialogFB.pricd7.text.toString().trim().isNotEmpty()
                        customDialogFB.pricd8.isEnabled=customDialogFB.procd7.toString().trim().isNotEmpty()
                                && customDialogFB.pricd7.text.toString().trim().isNotEmpty()
                    }

                    override fun afterTextChanged(p0: Editable?) {
                    }

                })
                customDialogFB.pricd8.addTextChangedListener(object :TextWatcher{
                    override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                    }

                    override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                        customDialogFB.procd9.isEnabled=customDialogFB.procd8.toString().trim().isNotEmpty()
                                && customDialogFB.pricd8.text.toString().trim().isNotEmpty()
                        customDialogFB.pricd9.isEnabled=customDialogFB.procd8.toString().trim().isNotEmpty()
                                && customDialogFB.pricd8.text.toString().trim().isNotEmpty()
                    }

                    override fun afterTextChanged(p0: Editable?) {
                    }

                })

                customDialogFB.clos_add_dialog.setOnClickListener {
                    binding.appBarMain.fab.setImageDrawable(resources.getDrawable(android.R.drawable.ic_menu_add))
                    customDialogFB.dismiss()
                }
                customDialogFB.add_d.setOnClickListener {

                    editD1 += customDialogFB.tproced1.text.toString()
                    editD2 += customDialogFB.tproced2.text.toString()
                    editD3 += customDialogFB.tproced3.text.toString()
                    editD4 += customDialogFB.tproced4.text.toString()
                    editD5 += customDialogFB.tproced5.text.toString()
                    editD6 += customDialogFB.tproced6.text.toString()
                    editD7 += customDialogFB.tproced7.text.toString()
                    editD8 += customDialogFB.tproced8.text.toString()
                    editD9 += customDialogFB.tproced9.text.toString()

                    pricD1 += customDialogFB.pricd1.text.toString()
                    if (pricD1.isNotEmpty()){
                        viewModel.totalAmount += customDialogFB.pricd1.text.toString().toInt()
                        toolbar?.title = "المجموع " + viewModel.totalAmount.toString()}
                    pricD2 += customDialogFB.pricd2.text.toString()
                    if (pricD2.isNotEmpty()){
                        viewModel.totalAmount += customDialogFB.pricd2.text.toString().toInt()
                        toolbar?.title = "المجموع " + viewModel.totalAmount.toString()}
                    pricD3 += customDialogFB.pricd3.text.toString()
                    if (pricD3.isNotEmpty()){
                        viewModel.totalAmount += customDialogFB.pricd3.text.toString().toInt()
                        toolbar?.title = "المجموع " + viewModel.totalAmount.toString()}
                    pricD4 += customDialogFB.pricd4.text.toString()
                    if (pricD4.isNotEmpty()){
                        viewModel.totalAmount += customDialogFB.pricd4.text.toString().toInt()
                        toolbar?.title = "المجموع " + viewModel.totalAmount.toString()}
                    pricD5 += customDialogFB.pricd5.text.toString()
                    if (pricD5.isNotEmpty()){
                        viewModel.totalAmount += customDialogFB.pricd5.text.toString().toInt()
                        toolbar.title = "المجموع " + viewModel.totalAmount.toString()}
                    pricD6 += customDialogFB.pricd6.text.toString()
                    if (pricD6.isNotEmpty()){
                        viewModel.totalAmount += customDialogFB.pricd6.text.toString().toInt()
                        toolbar?.title = "المجموع " + viewModel.totalAmount.toString()}
                    pricD7 += customDialogFB.pricd7.text.toString()
                    if (pricD7.isNotEmpty()){
                        viewModel.totalAmount += customDialogFB.pricd7.text.toString().toInt()
                        toolbar?.title = "المجموع " + viewModel.totalAmount.toString()}
                    pricD8 += customDialogFB.pricd8.text.toString()
                    if (pricD8.isNotEmpty()){
                        viewModel.totalAmount += customDialogFB.pricd8.text.toString().toInt()
                        toolbar?.title = "المجموع " + viewModel.totalAmount.toString()}
                    pricD9 += customDialogFB.pricd9.text.toString()
                    if (pricD9.isNotEmpty()){
                        viewModel.totalAmount += customDialogFB.pricd9.text.toString().toInt()
                        toolbar?.title = "المجموع " + viewModel.totalAmount.toString()}
                    customDialogFB.dismiss()
                }
                binding.appBarMain.fab.setImageDrawable(resources.getDrawable(android.R.drawable.ic_menu_add))
                customDialogFB.show()
            }
        }

        val drawerLayout: DrawerLayout = binding.drawerLayout
        val navView: NavigationView = binding.navView
        val navController = findNavController(R.id.nav_host_fragment_content_main)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.nav_first,R.id.nav_gallery,R.id.nav_home,R.id.nav_slideshow,R.id.nav_m5r6ah,R.id.nav_incoming

            ), drawerLayout
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId ==R.id.action_Save) {
            var total1 =""
            total1 += viewModel.totalAmount
            val customDialogFB_paying = Dialog(this)
            customDialogFB_paying.setContentView(R.layout.paying_dailog)
            customDialogFB_paying.setCancelable(false)
            customDialogFB_paying.window?.setLayout(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT)
            customDialogFB_paying.receivables_price.text = viewModel.totalAmount.toString()
            customDialogFB_paying.cash_price.addTextChangedListener(object : TextWatcher {
                override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

                }

                override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                    customDialogFB_paying.cash_paying.isEnabled =
                        customDialogFB_paying.cash_price.toString().trim().isNotEmpty()
                }

                override fun afterTextChanged(p0: Editable?) {
                }
            }

            )
            customDialogFB_paying.wallet_price.addTextChangedListener(object : TextWatcher {
                override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

                }

                override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                    customDialogFB_paying.wallet.isEnabled =
                        customDialogFB_paying.wallet_price.toString().trim().isNotEmpty()
                }

                override fun afterTextChanged(p0: Editable?) {
                }

            })
            customDialogFB_paying.credit_price.addTextChangedListener(object : TextWatcher {
                override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

                }

                override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                    customDialogFB_paying.credit.isEnabled =
                        customDialogFB_paying.credit_price.toString().trim().isNotEmpty()
                }

                override fun afterTextChanged(p0: Editable?) {
                }

            })
            customDialogFB_paying.Discount_price.addTextChangedListener(object : TextWatcher {
                override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

                }

                override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                    customDialogFB_paying.Discount.isEnabled =
                        customDialogFB_paying.Discount_price.toString().trim().isNotEmpty()
                }

                override fun afterTextChanged(p0: Editable?) {
                }

            })

            customDialogFB_paying.cash_paying.setOnCheckedChangeListener { _, b ->
                if (customDialogFB_paying.cash_paying.isChecked) {
                    cash_paying1 += customDialogFB_paying.cash_paying.text.toString()
                    cash_price11 += customDialogFB_paying.cash_price.text.toString()
                    viewModel.totalAmount -= customDialogFB_paying.cash_price.text.toString().toInt()
                    customDialogFB_paying.receivables_price.text = viewModel.totalAmount.toString()
                    customDialogFB_paying.cash_paying.isEnabled = false
                }
            }
            customDialogFB_paying.wallet.setOnCheckedChangeListener { _, b ->
                if (customDialogFB_paying.wallet.isChecked) {
                    wallet1 += customDialogFB_paying.wallet.text.toString()
                    wallet_price1 += customDialogFB_paying.wallet_price.text.toString()
                    viewModel.totalAmount -= customDialogFB_paying.wallet_price.text.toString().toInt()
                    customDialogFB_paying.receivables_price.text = viewModel.totalAmount.toString()
                    customDialogFB_paying.wallet.isEnabled = false
                }
            }

            customDialogFB_paying.credit.setOnCheckedChangeListener { _, b ->
                if (customDialogFB_paying.credit.isChecked) {
                    credit1 += customDialogFB_paying.credit.text.toString()
                    credit_price1 += customDialogFB_paying.credit_price.text.toString()
                    viewModel.totalAmount -= customDialogFB_paying.credit_price.text.toString().toInt()
                    customDialogFB_paying.receivables_price.text = viewModel.totalAmount.toString()
                    customDialogFB_paying.credit.isEnabled = false
                }
            }
            customDialogFB_paying.Discount.setOnCheckedChangeListener { _, b ->
                if (customDialogFB_paying.Discount.isChecked) {
                    Discount1 += customDialogFB_paying.Discount.text.toString()
                    Discount_pricec1 += customDialogFB_paying.Discount_price.text.toString()
                    viewModel.totalAmount -= customDialogFB_paying.Discount_price.text.toString().toInt()
                    customDialogFB_paying.receivables_price.text = viewModel.totalAmount.toString()
                    customDialogFB_paying.Discount.isEnabled = false
                }
            }
            customDialogFB_paying.receivables.setOnCheckedChangeListener { _, b ->
                if (customDialogFB_paying.receivables.isChecked) {
                    receivables1 += customDialogFB_paying.receivables.text.toString()
                    receivables_price1 += customDialogFB_paying.receivables_price.text.toString()
                    customDialogFB_paying.Discount.isEnabled = false
                }
            }

            customDialogFB_paying.button_dailog_cancel_P.setOnClickListener {
                if (customDialogFB_paying.cash_price.text.toString().isNotEmpty()) {
                    cash_paying1 = ""
                    cash_price11 = ""
                    viewModel.totalAmount += customDialogFB_paying.cash_price.text.toString().toInt()
                    customDialogFB_paying.receivables_price.text = viewModel.totalAmount.toString()
                    customDialogFB_paying.cash_price.text = null
                    customDialogFB_paying.cash_paying.isChecked = false
                    customDialogFB_paying.cash_paying.isEnabled = false

                }
                if (customDialogFB_paying.wallet_price.text.toString().isNotEmpty()) {
                    wallet1 = ""
                    wallet_price1 = ""
                    viewModel.totalAmount += customDialogFB_paying.wallet_price.text.toString().toInt()
                    customDialogFB_paying.receivables_price.text = viewModel.totalAmount.toString()
                    customDialogFB_paying.wallet_price.text = null
                    customDialogFB_paying.wallet.isChecked = false
                    customDialogFB_paying.wallet.isEnabled = false
                }
                if (customDialogFB_paying.credit_price.text.toString().isNotEmpty()) {
                    credit1 = ""
                    credit_price1 = ""
                    viewModel.totalAmount += customDialogFB_paying.credit_price.text.toString().toInt()
                    customDialogFB_paying.receivables_price.text = viewModel.totalAmount.toString()
                    customDialogFB_paying.credit_price.text = null
                    customDialogFB_paying.credit.isChecked = false
                    customDialogFB_paying.credit.isEnabled = false
                }
                if (customDialogFB_paying.Discount_price.text.toString().isNotEmpty()) {
                    Discount1 = ""
                    Discount_pricec1 = ""
                    viewModel.totalAmount += customDialogFB_paying.Discount_price.text.toString().toInt()
                    customDialogFB_paying.receivables_price.text = viewModel.totalAmount.toString()
                    customDialogFB_paying.Discount_price.text = null
                    customDialogFB_paying.Discount.isChecked = false
                    customDialogFB_paying.Discount.isEnabled = false
                }

                customDialogFB_paying.dismiss()
            }

            customDialogFB_paying.button_dailog_save_p.setOnClickListener {

                var checkname1 = ""
                var checkname2 = ""
                var checkname3 = ""
                var checkname4 = ""
                var checkname5 = ""
                var checkname6 = ""
                var checkname7 = ""
                var checkname8 = ""
                var checkname9 = ""
                var checkname10 = ""
                var checkname11 = ""
                var checkname12 = ""
                var checkname13 = ""
                var checkname14 = ""
                var checkname15 = ""
                var checkname16 = ""
                var checkname17 = ""
                var checkname18 = ""
                var checkname19 = ""
                var checkname20 = ""

                var checkname2_1 = ""
                var checkname2_2 = ""
                var checkname2_3 = ""
                var checkname2_4 = ""
                var checkname2_5 = ""
                var checkname2_6 = ""
                var checkname2_7 = ""
                var checkname2_8 = ""
                var checkname2_9 = ""
                var checkname2_10 = ""
                var checkname2_11 = ""
                var checkname2_12 = ""
                var checkname2_13 = ""
                var checkname2_14 = ""
                var checkname2_15 = ""
                var checkname2_16 = ""
                var checkname2_17 = ""
                var checkname2_18 = ""
                var checkname2_19 = ""
                var checkname2_20 = ""
                var checkname2_21 = ""
                var checkname2_22 = ""

                var checkname3_1 = ""
                var checkname3_2 = ""
                var checkname3_3 = ""
                var checkname3_4 = ""
                var checkname3_5 = ""
                var checkname3_6 = ""

                var editname1 = ""
                var editname2 = ""
                var editname3 = ""
                var editname4 = ""
                var editname5 = ""
                var editname6 = ""
                var editname7 = ""
                var editname8 = ""
                var editname9 = ""
                var editname10 = ""
                var editname11 = ""
                var editname12 = ""
                var editname13 = ""
                var editname14 = ""
                var editname15 = ""
                var editname16 = ""
                var editname17 = ""
                var editname18 = ""
                var editname19 = ""
                var editname20 = ""

                var editname2_1 = ""
                var editname2_2 = ""
                var editname2_3 = ""
                var editname2_4 = ""
                var editname2_5 = ""
                var editname2_6 = ""
                var editname2_7 = ""
                var editname2_8 = ""
                var editname2_9 = ""
                var editname2_10 = ""
                var editname2_11 = ""
                var editname2_12 = ""
                var editname2_13 = ""
                var editname2_14 = ""
                var editname2_15 = ""
                var editname2_16 = ""
                var editname2_17 = ""
                var editname2_18 = ""
                var editname2_19 = ""
                var editname2_20 = ""
                var editname2_21 = ""
                var editname2_22 = ""

                var editname3_1 = ""
                var editname3_2 = ""
                var editname3_3 = ""
                var editname3_4 = ""
                var editname3_5 = ""
                var editname3_6 = ""

                var total = ""
                total += total1

                val chtest1 = findViewById<CheckBox>(R.id.ch1)
                val texttest1 = findViewById<TextView>(R.id.editTextNumber1)
                chtest1.setOnCheckedChangeListener { buttonView, isChecked ->
                    if (isChecked) {

                        checkname1 += chtest1.text
                        editname1 += texttest1.text
                    }}

//                if (ch1 != null && ch1.isChecked) {
//                    checkname1 += ch1.text
//                    editname1 += editTextNumber1.text
//                }
                if (ch2 != null && ch2.isChecked) {
                    checkname2 += ch2.text
                    editname2 += pricd2.text
                }

                if (ch3 != null && ch3.isChecked) {
                    checkname3 += ch3.text
                    editname3 += pricd3.text
                }

                if (ch4 != null && ch4.isChecked) {
                    checkname4 += ch4.text
                    editname4 += pricd4.text
                }

                if (ch5 != null && ch5.isChecked) {
                    checkname5 += ch5.text
                    editname5 += pricd5.text
                }

                if (ch6 != null && ch6.isChecked) {
                    checkname6 += ch6.text
                    editname6 += pricd6.text
                }

                if (ch7 != null && ch7.isChecked) {
                    checkname7 += ch7.text
                    editname7 += pricd7.text
                }

                if (ch8 != null && ch8.isChecked) {
                    checkname8 += ch8.text
                    editname8 += pricd8.text
                }

                if (ch9 != null && ch9.isChecked) {
                    checkname9 += ch9.text
                    editname9 += pricd9.text
                }

                if (ch10 != null && ch10.isChecked) {
                    checkname10 += ch10.text
                    editname10 += editTextNumber10.text
                }

                if (ch11 != null && ch11.isChecked) {
                    checkname11 += ch11.text
                    editname11 += editTextNumber11.text
                }

                if (ch12 != null && ch12.isChecked) {
                    checkname12 += ch12.text
                    editname12 += editTextNumber12.text
                }

                if (ch13 != null && ch13.isChecked) {
                    checkname13 += ch13.text
                    editname13 += editTextNumber13.text
                }

                if (ch14 != null && ch14.isChecked) {
                    checkname14 += ch14.text
                    editname14 += editTextNumber14.text
                }

                if (ch15 != null && ch15.isChecked) {
                    checkname15 += ch15.text
                    editname15 += editTextNumber15.text
                }

                if (ch16 != null && ch16.isChecked) {
                    checkname16 += ch16.text
                    editname16 += editTextNumber16.text
                }

                if (ch17 != null && ch17.isChecked) {
                    checkname17 += ch17.text
                    editname17 += editTextNumber17.text
                }

                if (ch18 != null && ch18.isChecked) {
                    checkname18 += ch18.text
                    editname18 += editTextNumber18.text
                }

                if (ch19 != null && ch19.isChecked) {
                    checkname19 += ch19.text
                    editname19 += editTextNumber19.text
                }

                if (ch20 != null && ch20.isChecked) {
                    checkname20 += ch20.text
                    editname20 += editTextNumber20.text
                }


                if (ch_2_1 != null && ch_2_1.isChecked) {
                    checkname2_1 += ch_2_1.text
                    editname2_1 += p_p_2_1.text
                }

                if (ch_2_2 != null && ch_2_2.isChecked) {
                    checkname2_2 += ch_2_2.text
                    editname2_2 += p_p_2_2.text
                }

                if (ch_2_3 != null && ch_2_3.isChecked) {
                    checkname2_3 += ch_2_3.text
                    editname2_3 += p_p_2_3.text
                }

                if (ch_2_4 != null && ch_2_4.isChecked) {
                    checkname2_4 += ch_2_4.text
                    editname2_4 += p_p_2_4.text
                }

                if (ch_2_5 != null && ch_2_5.isChecked) {
                    checkname2_5 += ch_2_5.text
                    editname2_5 += p_p_2_5.text
                }

                if (ch_2_6 != null && ch_2_6.isChecked) {
                    checkname2_6 += ch_2_6.text
                    editname2_6 += p_p_2_6.text
                }

                if (ch_2_7 != null && ch_2_7.isChecked) {
                    checkname2_7 += ch_2_7.text
                    editname2_7 += p_p_2_7.text
                }

                if (ch_2_8 != null && ch_2_8.isChecked) {
                    checkname2_8 += ch_2_8.text
                    editname2_8 += p_p_2_8.text
                }

                if (ch_2_9 != null && ch_2_9.isChecked) {
                    checkname2_9 += ch_2_9.text
                    editname2_9 += p_p_2_9.text
                }

                if (ch_2_10 != null && ch_2_10.isChecked) {
                    checkname2_10 += ch_2_10.text
                    editname2_10 += p_p_2_10.text
                }

                if (ch_2_11 != null && ch_2_11.isChecked) {
                    checkname2_11 += ch_2_11.text
                    editname2_11 += p_p_2_11.text
                }

                if (ch_2_12 != null && ch_2_12.isChecked) {
                    checkname2_12 += ch_2_12.text
                    editname2_12 += p_p_2_12.text
                }

                if (ch_2_13 != null && ch_2_13.isChecked) {
                    checkname2_13 += ch_2_13.text
                    editname2_13 += p_p_2_13.text
                }

                if (ch_2_14 != null && ch_2_14.isChecked) {
                    checkname2_14 += ch_2_14.text
                    editname2_14 += p_p_2_14.text
                }

                if (ch_2_15 != null && ch_2_15.isChecked) {
                    checkname2_15 += ch_2_15.text
                    editname2_15 += p_p_2_15.text
                }

                if (ch_2_16 != null && ch_2_16.isChecked) {
                    checkname2_16 += ch_2_16.text
                    editname2_16 += p_p_2_16.text
                }

                if (ch_2_17 != null && ch_2_17.isChecked) {
                    checkname2_17 += ch_2_17.text
                    editname2_17 += p_p_2_17.text
                }

                if (ch_2_18 != null && ch_2_18.isChecked) {
                    checkname2_18 += ch_2_18.text
                    editname2_18 += p_p_2_18.text
                }

                if (ch_2_19 != null && ch_2_19.isChecked) {
                    checkname2_19 += ch_2_19.text
                    editname2_19 += p_p_2_19.text
                }

                if (ch_2_20 != null && ch_2_20.isChecked) {
                    checkname2_20 += ch_2_20.text
                    editname2_20 += p_p_2_20.text
                }

                if (ch_2_21 != null && ch_2_21.isChecked) {
                    checkname2_21 += ch_2_21.text
                    editname2_21 += p_p_2_21.text
                }

                if (ch_2_22 != null && ch_2_22.isChecked) {
                    checkname2_22 += ch_2_22.text
                    editname2_22 += p_p_2_22.text
                }

                val chtest3 = findViewById<CheckBox>(R.id.ch_3_1)
                val texttest3 = findViewById<TextView>(R.id.p_p_3_1)
                chtest3.setOnCheckedChangeListener { buttonView, isChecked ->
                    if (isChecked) {
                        checkname3 += chtest3.text
                        editname3 += texttest3.text
                    }}
//                if (ch_3_1 != null && ch_3_1.isChecked) {
//                    checkname3_1 += ch_3_1.text
//                    editname3_1 += p_p_3_1.text
//                }

                if (ch_3_2 != null && ch_3_2.isChecked) {
                    checkname3_2 += ch_3_2.text
                    editname3_2 += p_p_3_2.text
                }

                if (ch_3_3 != null && ch_3_3.isChecked) {
                    checkname3_3 += ch_3_3.text
                    editname3_3 += p_p_3_3.text
                }

                if (ch_3_4 != null && ch_3_4.isChecked) {
                    checkname3_4 += ch_3_4.text
                    editname3_4 += p_p_3_4.text
                }

                if (ch_3_5 != null && ch_3_5.isChecked) {
                    checkname3_5 += ch_3_5.text
                    editname3_5 += p_p_3_5.text
                }

                if (ch_3_6 != null && ch_3_6.isChecked) {
                    checkname3_6 += ch_3_6.text
                    editname3_6 += p_p_3_6.text
                }


                val checkSend = CheckData(
                    "",
                    "",
                    "",
                    "",
                    checkname1,
                    checkname2,
                    checkname3,
                    checkname4,
                    checkname5,
                    checkname6,
                    checkname7,
                    checkname8,
                    checkname9,
                    checkname10,
                    checkname11,
                    checkname12,
                    checkname13,
                    checkname14,
                    checkname15,
                    checkname16,
                    checkname17,
                    checkname18,
                    checkname19,
                    checkname20,

                    checkname2_1,
                    checkname2_2,
                    checkname2_3,
                    checkname2_4,
                    checkname2_5,
                    checkname2_6,
                    checkname2_7,
                    checkname2_8,
                    checkname2_9,
                    checkname2_10,
                    checkname2_11,
                    checkname2_12,
                    checkname2_13,
                    checkname2_14,
                    checkname2_15,
                    checkname2_16,
                    checkname2_17,
                    checkname2_18,
                    checkname2_19,
                    checkname2_20,
                    checkname2_21,
                    checkname2_22,

                    checkname3_1,
                    checkname3_2,
                    checkname3_3,
                    checkname3_4,
                    checkname3_5,
                    checkname3_6,

                    editname1,
                    editname2,
                    editname3,
                    editname4,
                    editname5,
                    editname6,
                    editname7,
                    editname8,
                    editname9,
                    editname10,
                    editname11,
                    editname12,
                    editname13,
                    editname14,
                    editname15,
                    editname16,
                    editname17,
                    editname18,
                    editname19,
                    editname20,

                    editname2_1,
                    editname2_2,
                    editname2_3,
                    editname2_4,
                    editname2_5,
                    editname2_6,
                    editname2_7,
                    editname2_8,
                    editname2_9,
                    editname2_10,
                    editname2_11,
                    editname2_12,
                    editname2_13,
                    editname2_14,
                    editname2_15,
                    editname2_16,
                    editname2_17,
                    editname2_18,
                    editname2_19,
                    editname2_20,
                    editname2_21,
                    editname2_22,

                    editname3_1,
                    editname3_2,
                    editname3_3,
                    editname3_4,
                    editname3_5,
                    editname3_6,
                    total,
                    "",
                    "",
                    "",
                    "",
                    "",
                    Calendar.getInstance().time,

                    editD1,
                    editD2,
                    editD3,
                    editD4,
                    editD5,
                    editD6,
                    editD7,
                    editD8,
                    editD9,

                    pricD1,
                    pricD2,
                    pricD3,
                    pricD4,
                    pricD5,
                    pricD6,
                    pricD7,
                    pricD8,
                    pricD9,

                    cash_paying1,
                    wallet1,
                    credit1,
                    Discount1,
                    receivables1,
                    cash_price11,
                    wallet_price1,
                    credit_price1,
                    Discount_pricec1,
                    receivables_price1
                )

                sentMessage(checkSend)

                if (ch1 != null) {
                    ch1.isChecked = false}
                if (ch2 != null) {
                    ch2.isChecked = false}
                if (ch3 != null) {
                    ch3.isChecked = false}
                if (ch4 != null) {
                    ch4.isChecked = false}
                if (ch5 != null) {
                    ch5.isChecked = false}
                if (ch6 != null) {
                    ch6.isChecked = false}
                if (ch7 != null) {
                    ch7.isChecked = false}
                if (ch8 != null) {
                    ch8.isChecked = false}
                if (ch9 != null) {
                    ch9.isChecked = false}
                if (ch10 != null) {
                    ch10.isChecked = false}
                if (ch11 != null) {
                    ch11.isChecked = false}
                if (ch12 != null) {
                    ch12.isChecked = false}
                if (ch13 != null) {
                    ch13.isChecked = false}
                if (ch14 != null) {
                    ch14.isChecked = false}
                if (ch15 != null) {
                    ch15.isChecked = false}
                if (ch16 != null) {
                    ch16.isChecked = false}
                if (ch17 != null) {
                    ch17.isChecked = false}
                if (ch18 != null) {
                    ch18.isChecked = false}
                if (ch19 != null) {
                    ch19.isChecked = false}
                if (ch20 != null) {
                    ch20.isChecked = false}

                if (ch_2_1 != null) {
                    ch_2_1.isChecked = false}
                if (ch_2_2 != null) {
                    ch_2_2.isChecked = false}
                if (ch_2_3 != null) {
                    ch_2_3.isChecked = false}
                if (ch_2_4 != null) {
                    ch_2_4.isChecked = false}
                if (ch_2_5 != null) {
                    ch_2_5.isChecked = false}
                if (ch_2_6 != null) {
                    ch_2_6.isChecked = false}
                if (ch_2_7 != null) {
                    ch_2_7.isChecked = false}
                if (ch_2_8 != null) {
                    ch_2_8.isChecked = false}
                if (ch_2_9 != null) {
                    ch_2_9.isChecked = false}
                if (ch_2_10 != null) {
                    ch_2_10.isChecked = false}
                if (ch_2_11 != null) {
                    ch_2_11.isChecked = false}
                if (ch_2_12 != null) {
                    ch_2_12.isChecked = false}
                if (ch_2_13 != null) {
                    ch_2_13.isChecked = false}
                if (ch_2_14 != null) {
                    ch_2_14.isChecked = false}
                if (ch_2_15 != null) {
                    ch_2_15.isChecked = false}
                if (ch_2_16 != null) {
                    ch_2_16.isChecked = false}
                if (ch_2_17 != null) {
                    ch_2_17.isChecked = false}
                if (ch_2_18 != null) {
                    ch_2_18.isChecked = false}
                if (ch_2_19 != null) {
                    ch_2_19.isChecked = false}
                if (ch_2_20 != null) {
                    ch_2_20.isChecked = false}
                if (ch_2_21 != null) {
                    ch_2_21.isChecked = false}
                if (ch_2_22 != null) {
                    ch_2_22.isChecked = false}

                if (ch_3_1 != null) {
                    ch_3_1.isChecked = false
                }

                if (ch_3_2 != null) {
                    ch_3_2.isChecked = false
                }
                if (ch_3_3 != null) {
                    ch_3_3.isChecked = false
                }
                if (ch_3_4 != null) {
                    ch_3_4.isChecked = false
                }
                if (ch_3_5 != null) {
                    ch_3_5.isChecked = false
                }
                if (ch_3_6 != null) {
                    ch_3_6.isChecked = false
                }
                if (editTextNumber1 != null) {
                    editTextNumber1.text = null}
                if (pricd2 != null){
                    pricd2.text = null}
                if (pricd3 != null){
                    pricd3.text = null}
                if (pricd4 != null){
                    pricd4.text = null}
                if (pricd5 != null){
                    pricd5.text = null}
                if (pricd6 != null){
                    pricd6.text = null}
                if (pricd7 != null){
                    pricd7.text = null}
                if (pricd8 != null){
                    pricd8.text = null}
                if (pricd9 != null){
                    pricd9.text = null}
                if (editTextNumber10 != null){
                    editTextNumber10.text = null}
                if (editTextNumber11 != null){
                    editTextNumber11.text = null}
                if (editTextNumber12 != null){
                    editTextNumber12.text = null}
                if (editTextNumber13 != null){
                    editTextNumber13.text = null}
                if (editTextNumber14 != null){
                    editTextNumber14.text = null}
                if (editTextNumber15 != null){
                    editTextNumber15.text = null}
                if (editTextNumber16 != null){
                    editTextNumber16.text = null}
                if (editTextNumber17 != null){
                    editTextNumber17.text = null}
                if (editTextNumber18 != null){
                    editTextNumber18.text = null}
                receivables1 =""
                receivables_price1 =""
                cash_paying1 =""
                cash_price11 =""
                wallet1 =""
                wallet_price1 =""
                credit1 =""
                credit_price1 =""
                Discount1 =""
                Discount_pricec1=""
                toolbar?.title=""

                customDialogFB_paying.dismiss()

//                Navigation.findNavController(this,R.id.nav_host_fragment_content_main).navigate(R.id.nav_first)
                val intent = Intent(this, MainActivity::class.java)
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK)
                startActivity(intent)
                finish()
            }

            customDialogFB_paying.show()

        }
        return super.onOptionsItemSelected(item)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onPrepareOptionsMenu(menu: Menu?): Boolean {
        menu?.findItem(R.id.action_Save)?.isVisible = false
        return super.onPrepareOptionsMenu(menu)
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment_content_main)
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }

    @RequiresApi(Build.VERSION_CODES.R)
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (resultCode==Activity.RESULT_OK && requestCode ==REQUST_CODE &&
            data != null && data.data != null) {
            val selectedImagePath = data.data
            customDialogCAM.cam_img.setImageURI(selectedImagePath)

            customDialogCAM.save_camera.setOnClickListener {
                if (customDialogCAM.ojor_yadwyeh.text.toString().isEmpty() && customDialogCAM.ojor_5ra6ah.text.toString().isEmpty()) {
                    customDialogCAM.ojor_yadwyeh.error = "يجب تعبئة احد الحقلين"
                    customDialogCAM.ojor_yadwyeh.requestFocus()
                    return@setOnClickListener
                }

                addojoryadwyeh +=customDialogCAM.ojor_yadwyeh.text.toString().trim()
                addojor5ra6ah +=customDialogCAM.ojor_5ra6ah.text.toString().trim()
                addtotalcame +=customDialogCAM.majmo3_2jra2.text.toString().trim()

            val contentMessage2 = mutableMapOf<String, Any>()
            val ref1 = firestoreInstance.collection("chatChannels")
                .document(viewModel.myData1).collection("messages")
                .document(viewModel.myData2)

            contentMessage2["ojor2ed"] = addojoryadwyeh
            contentMessage2["ojorm5r6ah"] = addojor5ra6ah
            contentMessage2["mjmo3came"] = addtotalcame
            ref1.update(contentMessage2)


                val selectedImageBmp = MediaStore.Images.Media.getBitmap(this.contentResolver, selectedImagePath)
                val outputStream = ByteArrayOutputStream()
                selectedImageBmp.compress(Bitmap.CompressFormat.JPEG, 20, outputStream)
                val selectedImageBytes = outputStream.toByteArray()
                uploadProfileImage(selectedImageBytes) { path ->
                    val userFieldMap = mutableMapOf<String, Any>()
                    userFieldMap["customerImage"] = path
                    firestoreInstance.collection("chatChannels")
                        .document(viewModel.myData1).collection("messages").document(viewModel.myData2)
                        .update(userFieldMap)
                }

                binding.appBarMain.fab.setImageDrawable(resources.getDrawable(android.R.drawable.ic_menu_add))
                }
            }
        }

    private fun uploadProfileImage(selectedImageBytes: ByteArray, onSuccess: (imagePath: String) -> Unit) {
        val ref = currentUserStorageRef.child("customerPictures/${UUID.nameUUIDFromBytes(selectedImageBytes)}")
        customDialogCAM.progressBar1.visibility = View.VISIBLE
        customDialogCAM.show()

        ref.putBytes(selectedImageBytes).addOnCompleteListener {
            if (it.isSuccessful) {
                onSuccess(ref.path)
            } else {
                Toast.makeText(this, "Error : ${it.exception?.message.toString()}", Toast.LENGTH_LONG)
                    .show()
            }
            customDialogCAM.ojor_yadwyeh.setText("")
            customDialogCAM.ojor_5ra6ah.setText("")
            customDialogCAM.cam_img.setImageResource(R.mipmap.logo_foreground)
            customDialogCAM.dismiss()
        }
    }

    private fun sentMessage( check1: CheckData) {

        val contentMessage = mutableMapOf<String, Any>()

        contentMessage["check1"] = check1.check1
        contentMessage["check2"] = check1.check2
        contentMessage["check3"] = check1.check3
        contentMessage["check4"] = check1.check4
        contentMessage["check5"] = check1.check5
        contentMessage["check6"] = check1.check6
        contentMessage["check7"] = check1.check7
        contentMessage["check8"] = check1.check8
        contentMessage["check9"] = check1.check9
        contentMessage["check10"] = check1.check10
        contentMessage["check11"] = check1.check11
        contentMessage["check12"] = check1.check12
        contentMessage["check13"] = check1.check13
        contentMessage["check14"] = check1.check14
        contentMessage["check15"] = check1.check15
        contentMessage["check16"] = check1.check16
        contentMessage["check17"] = check1.check17
        contentMessage["check18"] = check1.check18
        contentMessage["check19"] = check1.check19
        contentMessage["check20"] = check1.check20

        contentMessage["check2_1"] = check1.check2_1
        contentMessage["check2_2"] = check1.check2_2
        contentMessage["check2_3"] = check1.check2_3
        contentMessage["check2_4"] = check1.check2_4
        contentMessage["check2_5"] = check1.check2_5
        contentMessage["check2_6"] = check1.check2_6
        contentMessage["check2_7"] = check1.check2_7
        contentMessage["check2_8"] = check1.check2_8
        contentMessage["check2_9"] = check1.check2_9
        contentMessage["check2_10"] = check1.check2_10
        contentMessage["check2_11"] = check1.check2_11
        contentMessage["check2_12"] = check1.check2_12
        contentMessage["check2_13"] = check1.check2_13
        contentMessage["check2_14"] = check1.check2_14
        contentMessage["check2_15"] = check1.check2_15
        contentMessage["check2_16"] = check1.check2_16
        contentMessage["check2_17"] = check1.check2_17
        contentMessage["check2_18"] = check1.check2_18
        contentMessage["check2_19"] = check1.check2_19
        contentMessage["check2_20"] = check1.check2_20
        contentMessage["check2_21"] = check1.check2_21
        contentMessage["check2_22"] = check1.check2_22

        contentMessage["check3_1"] = check1.check3_1
        contentMessage["check3_2"] = check1.check3_2
        contentMessage["check3_3"] = check1.check3_3
        contentMessage["check3_4"] = check1.check3_4
        contentMessage["check3_5"] = check1.check3_5
        contentMessage["check3_6"] = check1.check3_6

        contentMessage["price1"] = check1.price1
        contentMessage["price2"] = check1.price2
        contentMessage["price3"] = check1.price3
        contentMessage["price4"] = check1.price4
        contentMessage["price5"] = check1.price5
        contentMessage["price6"] = check1.price6
        contentMessage["price7"] = check1.price7
        contentMessage["price8"] = check1.price8
        contentMessage["price9"] = check1.price9
        contentMessage["price10"] = check1.price10
        contentMessage["price11"] = check1.price11
        contentMessage["price12"] = check1.price12
        contentMessage["price13"] = check1.price13
        contentMessage["price14"] = check1.price14
        contentMessage["price15"] = check1.price15
        contentMessage["price16"] = check1.price16
        contentMessage["price17"] = check1.price17
        contentMessage["price18"] = check1.price18
        contentMessage["price19"] = check1.price19
        contentMessage["price20"] = check1.price20

        contentMessage["price2_1"] = check1.price2_1
        contentMessage["price2_2"] = check1.price2_2
        contentMessage["price2_3"] = check1.price2_3
        contentMessage["price2_4"] = check1.price2_4
        contentMessage["price2_5"] = check1.price2_5
        contentMessage["price2_6"] = check1.price2_6
        contentMessage["price2_7"] = check1.price2_7
        contentMessage["price2_8"] = check1.price2_8
        contentMessage["price2_9"] = check1.price2_9
        contentMessage["price2_10"] = check1.price2_10
        contentMessage["price2_11"] = check1.price2_11
        contentMessage["price2_12"] = check1.price2_12
        contentMessage["price2_13"] = check1.price2_13
        contentMessage["price2_14"] = check1.price2_14
        contentMessage["price2_15"] = check1.price2_15
        contentMessage["price2_16"] = check1.price2_16
        contentMessage["price2_17"] = check1.price2_17
        contentMessage["price2_18"] = check1.price2_18
        contentMessage["price2_19"] = check1.price2_19
        contentMessage["price2_20"] = check1.price2_20
        contentMessage["price2_21"] = check1.price2_21
        contentMessage["price2_22"] = check1.price2_22

        contentMessage["price3_1"] = check1.price3_1
        contentMessage["price3_2"] = check1.price3_2
        contentMessage["price3_3"] = check1.price3_3
        contentMessage["price3_4"] = check1.price3_4
        contentMessage["price3_5"] = check1.price3_5
        contentMessage["price3_6"] = check1.price3_6


        contentMessage["total"] = check1.total
        contentMessage["date"] = check1.date

        contentMessage["editD1"] = check1.editD1
        contentMessage["editD2"] = check1.editD2
        contentMessage["editD3"] = check1.editD3
        contentMessage["editD4"] = check1.editD4
        contentMessage["editD5"] = check1.editD5
        contentMessage["editD6"] = check1.editD6
        contentMessage["editD7"] = check1.editD7
        contentMessage["editD8"] = check1.editD8
        contentMessage["editD9"] = check1.editD9

        contentMessage["pricD1"] = check1.pricD1
        contentMessage["pricD2"] = check1.pricD2
        contentMessage["pricD3"] = check1.pricD3
        contentMessage["pricD4"] = check1.pricD4
        contentMessage["pricD5"] = check1.pricD5
        contentMessage["pricD6"] = check1.pricD6
        contentMessage["pricD7"] = check1.pricD7
        contentMessage["pricD8"] = check1.pricD8
        contentMessage["pricD9"] = check1.pricD9

        contentMessage["cash_paying1"] = check1.cash_paying1
        contentMessage["wallet1"] = check1.wallet1
        contentMessage["credit1"] = check1.credit1
        contentMessage["discount1"] = check1.discount1
        contentMessage["receivables1"] = check1.receivables1
        contentMessage["cash_price11"] = check1.cash_price11
        contentMessage["wallet_price1"] = check1.wallet_price1
        contentMessage["credit_price1"] = check1.credit_price1
        contentMessage["discount_price1"] = check1.discount_price1
        contentMessage["receivables_price1"] = check1.receivables_price1

        chatChannelsCollectionRef.document(viewModel.myData1).collection("messages")
            .document(viewModel.myData2)
            .update(contentMessage)
    }
}