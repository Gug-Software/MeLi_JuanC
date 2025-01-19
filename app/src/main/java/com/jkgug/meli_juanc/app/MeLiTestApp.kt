package com.jkgug.meli_juanc.app

import android.app.Application
import com.jkgug.meli_juanc.di.ViewModelModule.Companion.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class MeLiTestMainApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger()
            androidContext(this@MeLiTestMainApplication)
            modules(
                viewModelModule
            )
        }
    }

}