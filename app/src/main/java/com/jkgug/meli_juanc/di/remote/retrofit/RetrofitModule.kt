package com.jkgug.meli_juanc.di.remote.retrofit

import com.jkgug.meli_juanc.di.remote.ErrorInterceptor
import com.jkgug.meli_juanc.di.remote.LoggingInterceptor
import okhttp3.OkHttpClient
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

const val MELI_URL = "https://api.mercadolibre.com/"

fun provideHttpClient(): OkHttpClient {
    return OkHttpClient
        .Builder()
        .addInterceptor(LoggingInterceptor())
        .addInterceptor(ErrorInterceptor())
        .readTimeout(30, TimeUnit.SECONDS)
        .connectTimeout(30, TimeUnit.SECONDS)
        .build()
}

fun provideConverterFactory(): GsonConverterFactory = GsonConverterFactory.create()

fun provideRetrofit(
    okHttpClient: OkHttpClient,
    gsonConverterFactory: GsonConverterFactory
): Retrofit {
    return Retrofit.Builder()
        .baseUrl(MELI_URL)
        .client(okHttpClient)
        .addConverterFactory(gsonConverterFactory)
        .build()
}

class RetrofitModule {
    companion object {
        val networkModule = module {
            single { provideHttpClient() }
            single { provideConverterFactory() }
            single { provideRetrofit(get(), get()) }
        }
    }
}