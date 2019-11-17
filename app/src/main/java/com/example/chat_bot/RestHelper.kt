package com.example.chat_bot

import android.content.Context
import android.os.AsyncTask
import com.example.chat_bot.model.Institute
import java.lang.Exception
import java.net.HttpURLConnection
import java.net.URL


class RestHelper {


    fun doRequest(context: Context) {
        AsyncTask.execute {
            lateinit var conn: HttpURLConnection
            try {
                val url = URL("${context.getString(R.string.server_base_url)}/catalog/institutes")
                conn = url.openConnection() as HttpURLConnection
                conn.setRequestProperty("Accept",
                    "*/*")
                conn.connectTimeout = 1000
                conn.requestMethod = "GET"
                conn.connect()
                if (conn.responseCode == 200) {
                    val result = ArrayList<Institute>()
                }
            } catch (e: Exception) {
                e.printStackTrace()
            } finally {
                conn.disconnect()
            }
        }
    }
}