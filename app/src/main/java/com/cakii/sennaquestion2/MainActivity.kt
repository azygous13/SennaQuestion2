package com.cakii.sennaquestion2

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.util.Patterns
import android.widget.ArrayAdapter
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.toolbar.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        spinner_gender.adapter = ArrayAdapter<String>(
            this,
            android.R.layout.simple_spinner_dropdown_item,
            arrayListOf("Please select your gender", "Male", "Female")
        )

        btn_next.setOnClickListener {
            var isValid = true
            if (spinner_gender.selectedItemPosition == 0) {
                isValid = false
                val errorText = spinner_gender.selectedView as TextView
                errorText.setTextColor(Color.RED)
                errorText.text = getString(R.string.please_select_your_gender)

            }
            if (et_first_name.text.isEmpty()) {
                isValid = false
                et_first_name.error = getString(R.string.first_name_cannot_be_empty)
            }
            if (et_last_name.text.isEmpty()) {
                isValid = false
                et_last_name.error = getString(R.string.last_name_cannot_be_empty)
            }
            if (et_email.text.isEmpty()) {
                isValid = false
                et_email.error = getString(R.string.email_cannot_be_empty)
            } else if (!Patterns.EMAIL_ADDRESS.matcher(et_email.text).matches()) {
                isValid = false
                et_email.error = getString(R.string.invalid_email_format)
            }
            if (isValid) {
                val intent = Intent(this, DetailActivity::class.java)
                intent.putExtra("gender", spinner_gender.selectedItem.toString())
                intent.putExtra("first_name", et_first_name.text.toString())
                intent.putExtra("last_name", et_last_name.text.toString())
                intent.putExtra("email", et_email.text.toString())
                startActivity(intent)
            }
        }
    }
}
