package com.neobis.deliveryemployee

import android.app.Application
import android.content.Context
import com.neobis.deliveryemployee.koin.preferencesModule

import com.neobis.deliveryemployee.koin.repositoryModule
import com.neobis.deliveryemployee.koin.retrofitModule
import com.neobis.deliveryemployee.koin.viewModels
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin


class MyApplication: Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            modules(listOf(retrofitModule, repositoryModule, viewModels, preferencesModule))
            androidContext(this@MyApplication)
        }



    }

}