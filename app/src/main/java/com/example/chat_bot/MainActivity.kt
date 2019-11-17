package com.example.chat_bot

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.JsonReader
import android.util.Log
import android.view.View
import com.example.chat_bot.model.Institute
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.Exception
import java.net.HttpURLConnection
import java.net.URL

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        getInstitutesFromServer(this)
        signUp.setOnClickListener {
            val email = email.text.toString()
            val password = password.text.toString()
            Log.d("MainActivity", "Email is $email, password is $password")
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }
    }


    fun getInstitutesFromServer(context: Context): List<Institute> {
        val restHelper = RestHelper()
        restHelper.doRequest(context)
        return ArrayList()
    }
}
