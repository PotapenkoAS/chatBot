package com.example.chat_bot

import android.app.Application
import com.example.chat_bot.di.netModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class ChatBotApplication : Application(){
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@ChatBotApplication)
            modules(modules = netModule)
        }
    }
}