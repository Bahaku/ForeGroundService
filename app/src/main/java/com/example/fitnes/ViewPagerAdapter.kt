package com.example.fitnes

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter

class ViewPagerAdapter(fragmentManager: FragmentManager): FragmentStatePagerAdapter(fragmentManager) {

    private var list =  arrayListOf<Fragment>()
    private var title =  arrayListOf<String>()



    fun update(fragment: Fragment, titles: String) {
        list.add(fragment)
        title.add(titles)
        notifyDataSetChanged()

    }

    override fun getPageTitle(position: Int) = title[position]
    override fun getItem(position: Int) = list[position]
    override fun getCount(): Int = list.size

}