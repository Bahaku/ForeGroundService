package com.example.fitnes.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.fitnes.R
import com.example.fitnes.ViewPagerAdapter
import com.example.fitnes.fragments.FragmentOne
import com.example.fitnes.fragments.FragmentThree
import com.example.fitnes.fragments.FragmentTwo
import kotlinx.android.synthetic.main.on_boarding_activiry.*

class OnBoardingActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.on_boarding_activiry)

        setupViewPager()
    }

    private fun setupViewPager(){
        val adapter = ViewPagerAdapter(supportFragmentManager)
        viewPager.adapter = adapter
        adapter.update(FragmentOne(), "Первое")
        adapter.update(FragmentTwo(), "Второе")
        adapter.update(FragmentThree(), "Третье")
        tLay.setupWithViewPager(viewPager)
    }
}
