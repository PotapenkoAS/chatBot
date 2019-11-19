package com.example.chat_bot.data.net

import com.example.chat_bot.model.Institute
import io.reactivex.Single
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface CatalogService {

    @GET("catalog/institutes")
    fun getInstitutes(): Single<List<Institute>>

    @POST("catalog/institutes")
    fun postInstitute(@Body model: Institute)
}