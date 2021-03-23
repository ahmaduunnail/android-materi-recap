package com.lleans.androidmateri1recap.IntentResults

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import butterknife.BindView
import butterknife.ButterKnife
import butterknife.OnClick
import com.google.android.material.textfield.TextInputEditText
import com.lleans.androidmateri1recap.R

class EditNameActivity : AppCompatActivity() {

    val EXTRA_NAME: String = "EXTRA_NAME"

    @BindView(R.id.editText2)
    lateinit var editTextView: TextInputEditText
    @BindView(R.id.btn_save)
    lateinit var button: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_name)
        ButterKnife.bind(this)
    }

    @OnClick(R.id.btn_save)
    fun OnClick(){
        val intent = Intent(this, IntentResultsFragment::class.java)
        intent.putExtra(EXTRA_NAME, editTextView.text.toString())
        setResult(RESULT_OK, intent)
        finish()
    }
}