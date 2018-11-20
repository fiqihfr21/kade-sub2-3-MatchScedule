package com.fiqih.matchschedulekotlin.adapter

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import com.fiqih.matchschedulekotlin.fragment.FragmentMainLast
import com.fiqih.matchschedulekotlin.fragment.FragmentMainNext

class SectionPageAdapter(fm: FragmentManager)
    : FragmentPagerAdapter(fm) {

    private val count  = 2

    override fun getItem(position: Int): Fragment? {
        var fragment: Fragment? = null
        when (position) {
            0 -> fragment = FragmentMainLast()
            1 -> fragment = FragmentMainNext()
        }
        return fragment
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return if(position == 0){
            "Last Match"
        } else{
            "Next Match"
        }
    }
    override fun getCount(): Int {
        return count
    }

}