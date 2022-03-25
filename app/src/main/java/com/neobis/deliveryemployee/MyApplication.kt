package com.neobis.deliveryemployee

import android.app.Application

import com.neobis.deliveryemployee.koin.repositoryModule
import com.neobis.deliveryemployee.koin.retrofitModule
import com.neobis.deliveryemployee.koin.viewModels
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin


class MyApplication: Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            modules(listOf(retrofitModule, repositoryModule, viewModels))
            androidContext(this@MyApplication)
        }
    }
}