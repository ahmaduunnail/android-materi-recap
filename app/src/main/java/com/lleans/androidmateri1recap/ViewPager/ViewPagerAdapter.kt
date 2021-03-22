package com.lleans.androidmateri1recap.ViewPager

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import com.lleans.androidmateri1recap.LatihanFragment.FirstFragment
import com.lleans.androidmateri1recap.LatihanFragment.SecondFragment

class ViewPagerAdapter(fm: FragmentManager): FragmentStatePagerAdapter(fm) {

    override fun getItem(position: Int): Fragment {
        if (position == 0){
            return FirstFragment()
        }else if (position == 1){
            return SecondFragment()
        }
        throw IllegalStateException("Position is not valid")
    }

    override fun getCount(): Int {
        return 2
    }

    override fun getPageTitle(position: Int): CharSequence? {
        if (position == 0 || position % 2 == 0){
            return "first"
        }else if (position % 2 == 1){
            return "second"
        }
        throw IllegalStateException("Position is not valid")
    }

}