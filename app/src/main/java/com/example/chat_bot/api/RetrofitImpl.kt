package com.example.chat_bot.api

import android.util.Log
import com.example.chat_bot.model.Institute
import io.reactivex.Single
import io.reactivex.SingleObserver
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory


object RetrofitImpl {

    private lateinit var instituteList: Single<List<Institute>>

    fun init() {
        val rxTutorialRetrofit = Retrofit.Builder()
            .baseUrl(SERVER_BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
        val apiHelper = rxTutorialRetrofit.create(ApiHelper::class.java)
        instituteList = apiHelper.getInstitutes()
        instituteList.subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : SingleObserver<List<Institute>> {
                override fun onSuccess(t: List<Institute>) {
                    t.map { Log.d("SHIT", it.fullName.plus(" - ").plus(it.shortName)) }
                }

                override fun onSubscribe(d: Disposable) {

                }

                override fun onError(e: Throwable) {
                }

            })
    }
}