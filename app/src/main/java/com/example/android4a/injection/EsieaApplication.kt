package com.example.android4a.injection

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class EsieaApplication: Application() {
    override fun onCreate() {
        super.onCreate()
        //strat koin
        startKoin{
            //Android context
            androidContext(this@EsieaApplication)
            //modules
            modules(presentationModule)
        }
    }
}