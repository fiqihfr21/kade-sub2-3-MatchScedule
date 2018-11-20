package com.fiqih.matchschedulekotlin.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.fiqih.matchschedulekotlin.R
import com.fiqih.matchschedulekotlin.adapter.SectionPageAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var pagerAdapter: SectionPageAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setFragment()
    }

    private fun setFragment(){

        pagerAdapter = SectionPageAdapter(supportFragmentManager)
        viewPager.adapter = pagerAdapter
        tabLayout.setupWithViewPager(viewPager)
    }
}