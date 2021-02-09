package com.lleans.androidmateri1recap

import android.nfc.NfcAdapter.EXTRA_DATA
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class TargetActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_target)

        val Data: TextView=findViewById(R.id.TextView)

        val tv = intent.getStringExtra(EXTRA_DATA)

        Data.text=tv
    }
    companion object{
        const val EXTRA_DATA = "extra_data"
    }
}