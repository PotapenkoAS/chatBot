package com.example.chat_bot

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.chat_bot.api.apiImpl.CatalogApiImpl
import com.example.chat_bot.model.Institute

class RegisterActivity : AppCompatActivity() {

    private var instituteList: List<Institute>? = null
    private val catalogApi = CatalogApiImpl()
    private lateinit var instituteFullNameArray: Array<String>
    private lateinit var instituteIdArray: Array<Int>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        RetrofitImpl.init()
        instituteList = catalogApi.getAllInstitutes()

//        instituteFullNameArray = instituteList!!.map { it.fullName }.toTypedArray()
//        instituteIdArray = instituteList!!.map { it.id }.toTypedArray()
//        institute.adapter = ArrayAdapter<String>(
//            this,
//            R.layout.support_simple_spinner_dropdown_item,
//            instituteFullNameArray
//        )
        Log.d("SHIT", "on create finished")
    }

}