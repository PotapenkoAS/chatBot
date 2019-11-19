package com.example.chat_bot.api.apiImpl

import android.util.Log
import com.example.chat_bot.api.ApiHelper
import com.example.chat_bot.model.Institute
import io.reactivex.Single
import io.reactivex.SingleObserver
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

class CatalogApiImpl {
    private lateinit var singleInstituteList: Single<List<Institute>>
    var instituteList: List<Institute>? = null

    fun getAllInstitutes(): List<Institute>? {

        val apiHelper = RetrofitImpl.retrofit!!.create(ApiHelper::class.java)
        singleInstituteList = apiHelper.getInstitutes()
        singleInstituteList.subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                object : SingleObserver<List<Institute>> {
                    override fun onSuccess(t: List<Institute>) {
                        Log.d("SHIT", "SUCCESS")
                        t.map { Log.d("SHIT", it.fullName.plus(" - ").plus(it.shortName)) }
                        instituteList = t
                    }

                    override fun onSubscribe(d: Disposable) {
                        Log.d("SHIT", "Subscribed")
                    }

                    override fun onError(e: Throwable) {
                        Log.d("SHIT", "ERROR: ".plus(e.message))
                        e.printStackTrace()
                    }
                })
        return instituteList
    }
}