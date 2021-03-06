package com.lleans.androidmateri1recap.LatihanFragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.FrameLayout
import androidx.navigation.NavController
import androidx.navigation.Navigation
import butterknife.BindView
import butterknife.ButterKnife
import butterknife.OnClick
import com.lleans.androidmateri1recap.R

class LatihanFragment : Fragment(), View.OnClickListener {

    lateinit var navController: NavController

    @BindView(R.id.frame_container)
    lateinit var frameContainer: FrameLayout

    @BindView(R.id.btn_fragment1)
    lateinit var btnFragment1: Button

    @BindView(R.id.btn_fragment2)
    lateinit var btnFragment2: Button

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)
        view.findViewById<Button>(R.id.btnPager).setOnClickListener(this)
        ButterKnife.bind(this, view)

        val transaction = activity?.supportFragmentManager?.beginTransaction()
        transaction?.add(R.id.frame_container, FirstFragment())
        transaction?.add(R.id.frame_container, SecondFragment())
        transaction?.disallowAddToBackStack()
        transaction?.commit()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_latihan, container, false)
    }

    override fun onClick(v: View?) {
        when(v!!.id){
            R.id.btnPager -> navController.navigate(R.id.action_latihanFragment_to_viewPager)
        }
    }

    @OnClick(R.id.btn_fragment1)
    fun onBtnFragmentClicked() {
        val transaction = activity?.supportFragmentManager?.beginTransaction()
        transaction?.replace(R.id.frame_container, FirstFragment())
        transaction?.commit()
    }

    @OnClick(R.id.btn_fragment2)
    fun onBtnFragment2Clicked() {
        val transaction = activity?.supportFragmentManager?.beginTransaction()
        transaction?.replace(R.id.frame_container, SecondFragment())
        transaction?.commit()
    }
}