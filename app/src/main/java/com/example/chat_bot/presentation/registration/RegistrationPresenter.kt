package com.example.chat_bot.presentation.registration

import com.example.chat_bot.data.net.CatalogService
import com.example.chat_bot.model.Institute
import com.hannesdorfmann.mosby3.mvp.MvpBasePresenter
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import org.koin.core.KoinComponent
import org.koin.core.inject

class RegistrationPresenter : MvpBasePresenter<RegistrationContract.View>(),
    RegistrationContract.Presenter,
    KoinComponent {
    private val api by inject<CatalogService>()

    override fun getInstitutes(): Single<List<Institute>> {
        return api.getInstitutes()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())

    }

}