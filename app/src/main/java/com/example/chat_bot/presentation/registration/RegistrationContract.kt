package com.example.chat_bot.presentation.registration

import com.example.chat_bot.model.Institute
import com.hannesdorfmann.mosby3.mvp.MvpFragment
import com.hannesdorfmann.mosby3.mvp.MvpPresenter
import com.hannesdorfmann.mosby3.mvp.MvpView
import io.reactivex.Single
import org.koin.core.KoinComponent

class RegistrationContract {
    interface Presenter : KoinComponent, MvpPresenter<View> {
        fun getInstitutes(): Single<List<Institute>>
    }

    interface View : KoinComponent, MvpView {
        fun register():Boolean
    }
}