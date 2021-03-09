package com.lleans.androidmateri1recap

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.PagerAdapter
import androidx.viewpager.widget.ViewPager
import butterknife.BindView
import butterknife.ButterKnife
import com.google.android.material.tabs.TabLayout

// TODO: Rename parameter arguments, choose names that match

class ViewPager : Fragment() {

    @BindView(R.id.Pager)
    lateinit var pager: ViewPager
    @BindView(R.id.Tab)
    lateinit var tab: TabLayout

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_view_pager, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        ButterKnife.bind(this, view)

        pager.adapter = activity?.let { ViewPagerAdapter(it.supportFragmentManager) }
        tab.setupWithViewPager(pager)
    }
}