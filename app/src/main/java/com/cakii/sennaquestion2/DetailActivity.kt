package com.cakii.sennaquestion2

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        intent?.let {
            val gender = it.getStringExtra("gender")
            val firstName = it.getStringExtra("first_name")
            val lastName = it.getStringExtra("last_name")
            val email = it.getStringExtra("email")

            tv_gender.text = "Gender: $gender"
            tv_name.text = "Name: $firstName $lastName"
            tv_email.text = "Email: $email"
        }
    }
}