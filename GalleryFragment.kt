package com.example.mizanalnasr.ui.gallery

import android.os.Bundle
import android.support.design.widget.FloatingActionButton
import android.support.design.widget.TabLayout
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.Menu
import android.view.View
import android.view.ViewGroup
import androidx.navigation.ui.AppBarConfiguration
import com.example.mizanalnasr.R
import com.example.mizanalnasr.databinding.FragmentGalleryBinding
import com.example.mizanalnasr.ui.home.HomeFragment
import com.example.mizanalnasr.ui.m5r6ah.M5r6ahFragment
import com.example.mizanalnasr.ui.slideshow.SlideshowFragment
import kotlinx.android.synthetic.main.fragment_gallery.view.*

class GalleryFragment : Fragment() {
    private lateinit var appBarConfiguration: AppBarConfiguration
    private var _binding: FragmentGalleryBinding? = null
    private val binding get() = _binding!!

//    mCurrentUserId,
//    otheruserid,
//    currentUser.name,
//    userName,
//    private lateinit var mCurrentChatChannelId: String
//    private var mCurrentUserId = FirebaseAuth.getInstance().currentUser!!.uid
//    private val firestoreInstance: FirebaseFirestore by lazy { FirebaseFirestore.getInstance()}
//    private val chatChannelsCollectionRef = firestoreInstance.collection("chatChannels")
//
//    private lateinit var  otheruserid :String
//    private lateinit var currentUser: User
//    private lateinit var userName:String
//    private lateinit var nEwChatCannelId : String
    var fabVisible = false
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentGalleryBinding.inflate(inflater, container, false)
        val root: View = binding.root

    val fragmentadapter = FragmentAdapter(fragmentManager!!)
    fragmentadapter.addFragment(HomeFragment(),"صيانة الهيئة 1")
    fragmentadapter.addFragment(SlideshowFragment(),"صيانة الهيئة 2")
        fragmentadapter.addFragment(M5r6ahFragment(),"مخرطة")
//    fabVisible = false
    val fab = activity?.findViewById<FloatingActionButton>(R.id.fab)
//        val fab1 = activity?.findViewById<FloatingActionButton>(R.id.fab1)
//        val fab2 = activity?.findViewById<FloatingActionButton>(R.id.fab2)
    fab!!.setImageDrawable(resources.getDrawable(android.R.drawable.ic_menu_add))
    fab.show()

        setHasOptionsMenu(true)

//    if (!fabVisible) {
//        fab?.show()
//       fab1!!.show()
//        fab2!!.show()
////        fab?.setImageDrawable(resources.getDrawable(android.R.drawable.ic_menu_add))
//        fabVisible = true
//    }else {
//        fab1?.hide()
//        fab2?.hide()
//        fab?.setImageDrawable(resources.getDrawable(android.R.drawable.ic_menu_add))
//        fabVisible = false
//    }

    root.viewpager.adapter= fragmentadapter
    root.tablayout.setupWithViewPager(root.viewpager)

    root.tablayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
        override fun onTabSelected(tab: TabLayout.Tab?) {
            root.viewpager.currentItem = tab!!.position
        }

        override fun onTabUnselected(p0: TabLayout.Tab?) {
        }

        override fun onTabReselected(p0: TabLayout.Tab?) {
        }

    })

        return root

    }
    override fun onPrepareOptionsMenu(menu: Menu) {
        menu.findItem(R.id.action_Save).isVisible = true
        super.onPrepareOptionsMenu(menu)
    }
    }