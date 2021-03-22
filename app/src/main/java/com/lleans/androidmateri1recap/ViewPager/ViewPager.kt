package com.lleans.androidmateri1recap.ViewPager

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.viewpager.widget.ViewPager
import butterknife.BindView
import butterknife.ButterKnife
import com.google.android.material.tabs.TabLayout
import com.lleans.androidmateri1recap.R

// TODO: Rename parameter arguments, choose names that match

class ViewPager : Fragment(), View.OnClickListener{
    lateinit var navController: NavController

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
        view.findViewById<Button>(R.id.btnAPI).setOnClickListener(this)
        navController = Navigation.findNavController(view)

        pager.adapter = activity?.let { ViewPagerAdapter(it.supportFragmentManager) }
        tab.setupWithViewPager(pager)
    }

    override fun onClick(v: View?) {
        when(v!!.id){
            R.id.btnAPI -> navController.navigate(R.id.action_viewPager_to_retrofitFragment)
        }
    }
}