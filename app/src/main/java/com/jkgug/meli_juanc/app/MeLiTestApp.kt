package com.jkgug.meli_juanc.app

import android.app.Application
import com.jkgug.meli_juanc.di.mapper.MapperModule.Companion.mapperModule
import com.jkgug.meli_juanc.di.repository.remote.RemoteRepositoriesModule.Companion.remoteRepositoriesModule
import com.jkgug.meli_juanc.di.viewmodel.ViewModelModule.Companion.viewModelModule
import com.jkgug.meli_juanc.di.remote.retrofit.RemoteMeliApiModule.Companion.meliSearchApi
import com.jkgug.meli_juanc.di.remote.retrofit.RetrofitModule.Companion.networkModule
import com.jkgug.meli_juanc.di.usecase.UseCaseModule.Companion.useCaseModule
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
                viewModelModule,
                networkModule,
                meliSearchApi,
                remoteRepositoriesModule,
                useCaseModule,
                mapperModule
            )
        }
    }

}