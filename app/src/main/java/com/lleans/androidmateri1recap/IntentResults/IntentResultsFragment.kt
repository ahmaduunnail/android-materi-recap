package com.lleans.androidmateri1recap.IntentResults

import android.app.Activity.RESULT_OK
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.navigation.NavController
import androidx.navigation.Navigation
import butterknife.BindView
import butterknife.ButterKnife
import butterknife.OnClick
import com.lleans.androidmateri1recap.R

class IntentResultsFragment : Fragment() {

    lateinit var navController: NavController
    val RC_EDIT_NAME: Int = 112

    @BindView(R.id.text_view_result)
    lateinit var TextViewResult: TextView

    @BindView(R.id.btn_edit)
    lateinit var BtnEdit: Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_intent_results, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)
        ButterKnife.bind(this, view)
    }

    @OnClick(R.id.btn_edit)
    fun OnClick() {
        val intent = Intent(activity, EditNameActivity::class.java)
        startActivityForResult(intent, RC_EDIT_NAME)
    }

    @OnClick(R.id.next4)
    fun ChangeFragment() {
        navController.navigate(R.id.action_intentResultsFragment_to_latihanFragment)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if(requestCode == RC_EDIT_NAME && resultCode == RESULT_OK){
            var name = data?.getStringExtra("EXTRA_NAME")
            TextViewResult.setText(name)
        }
    }

}