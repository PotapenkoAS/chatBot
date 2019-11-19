package com.example.chat_bot

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        signUp.setOnClickListener {
            val email = email.text.toString()
            val password = password.text.toString()
            Log.d("MainActivity", "Email is $email, password is $password")
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }
    }
}
