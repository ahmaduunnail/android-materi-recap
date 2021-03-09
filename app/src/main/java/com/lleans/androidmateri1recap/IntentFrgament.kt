package com.lleans.androidmateri1recap

import android.content.Intent
import android.nfc.NfcAdapter.EXTRA_DATA
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.navigation.NavController
import androidx.navigation.Navigation

class IntentFrgament : Fragment(), View.OnClickListener {

    lateinit var navController: NavController

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_intent_frgament, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)
        view.findViewById<Button>(R.id.simpan).setOnClickListener(this)
        view.findViewById<Button>(R.id.next3).setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when(v!!.id){
            R.id.simpan -> simpan()
            R.id.next3 -> pindahfrgament()
        }
    }

    private fun pindahfrgament() {
        navController.navigate(R.id.action_intentFrgament_to_intentResultsFragment)
    }

    fun simpan(){
        val MoveData = Intent(activity, TargetActivity::class.java)
        val editText = view?.findViewById(R.id.edtNama) as EditText
        MoveData.putExtra(TargetActivity.EXTRA_DATA, editText.text.toString())
        startActivity(MoveData)
    }
}