package com.example.chat_bot.api

import com.example.chat_bot.model.Institute
import io.reactivex.Single
import retrofit2.http.GET

interface ApiHelper {
    @GET("/catalog/institutes")
    fun getInstitutes(): Single<List<Institute>>
}