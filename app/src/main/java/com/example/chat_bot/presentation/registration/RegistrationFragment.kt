package com.example.chat_bot.presentation.registration

import com.hannesdorfmann.mosby3.mvp.MvpFragment
import org.koin.core.KoinComponent
import org.koin.core.get


class RegistrationFragment :
    MvpFragment<RegistrationContract.View, RegistrationContract.Presenter>(),
    RegistrationContract.View,
    KoinComponent {

    override fun createPresenter(): RegistrationContract.Presenter = get()

    override fun register(): Boolean {
        //TODO logic, man
        return true
    }

}