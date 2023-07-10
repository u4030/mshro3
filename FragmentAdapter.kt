package com.example.mizanalnasr.ui.gallery

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import android.support.v4.app.FragmentStatePagerAdapter

class FragmentAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {

var fragmentList : ArrayList<Fragment> = ArrayList()
    var fragmentTitel : ArrayList<String> = ArrayList()
    override fun getCount(): Int {
        return  fragmentList.size
    }

    override fun getItem(p0: Int): Fragment {
        return  fragmentList[p0]
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return fragmentTitel[position]
    }
    fun addFragment (fragment: Fragment,title: String){
        fragmentList.add(fragment)
        fragmentTitel.add(title)
    }
    override fun getItemPosition(`object`: Any): Int {
        return POSITION_UNCHANGED
    }
}