package com.example.chat_bot

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_register_step_one.*

class RegistrationFirstStepActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register_step_one)
        // Android Navigation Component
        next.setOnClickListener{val intent = Intent(this, RegistrationSecondStepActivity::class.java)
        startActivity(intent)}
    }
}