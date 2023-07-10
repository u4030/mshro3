package com.example.mizanalnasr.ui.gallery

import android.os.Bundle
import android.support.design.widget.FloatingActionButton
import android.support.design.widget.TabLayout
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.Menu
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.navigation.ui.AppBarConfiguration
import com.example.mizanalnasr.R
import com.example.mizanalnasr.databinding.FragmentGalleryBinding
import com.example.mizanalnasr.ui.home.HomeFragment
import com.example.mizanalnasr.ui.m5r6ah.M5r6ahFragment
import com.example.mizanalnasr.ui.slideshow.SlideshowFragment
import kotlinx.android.synthetic.main.app_bar_main.*
import kotlinx.android.synthetic.main.fragment_gallery.view.*

class GalleryFragment : Fragment() {
    private var _binding: FragmentGalleryBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentGalleryBinding.inflate(inflater, container, false)
        val root: View = binding.root

        setHasOptionsMenu(true)

        val fab = activity?.findViewById<FloatingActionButton>(R.id.fab)
        fab!!.setImageDrawable(resources.getDrawable(android.R.drawable.ic_menu_add))
        fab.show()

    val fragmentadapter = FragmentAdapter(fragmentManager!!)
    fragmentadapter.addFragment(HomeFragment(),"صيانة الهيئة 1")
    fragmentadapter.addFragment(SlideshowFragment(),"صيانة الهيئة 2")
        fragmentadapter.addFragment(M5r6ahFragment(),"مخرطة")

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