package com.jkgug.meli_juanc.di.remote.retrofit

import com.jkgug.meli_juanc.data.remote.api.items.MeLiAPIItems
import com.jkgug.meli_juanc.data.remote.api.search.MeLiAPISearch
import org.koin.dsl.module
import retrofit2.Retrofit

fun provideMeliSearchApi(
    retrofit: Retrofit
): MeLiAPISearch = retrofit.create(MeLiAPISearch::class.java)

fun provideMeliItemsApi(
    retrofit: Retrofit
): MeLiAPIItems = retrofit.create(MeLiAPIItems::class.java)


class RemoteMeliApiModule {

    companion object {

        val meliApis = module {
            single { provideMeliSearchApi(get()) }
            single { provideMeliItemsApi(get()) }
        }

    }

}