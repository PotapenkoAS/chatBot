package com.example.chat_bot.di

import com.example.chat_bot.SERVER_BASE_URL
import com.example.chat_bot.data.net.CatalogService
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

val netModule = module {
    single {
        Retrofit.Builder()
            .baseUrl(SERVER_BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
            .create(CatalogService::class.java)
    }
}