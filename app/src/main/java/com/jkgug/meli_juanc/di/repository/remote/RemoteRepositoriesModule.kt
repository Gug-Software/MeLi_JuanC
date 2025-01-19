package com.jkgug.meli_juanc.di.repository.remote

import com.jkgug.meli_juanc.repository.search.SearchRemoteMeliApi
import com.jkgug.meli_juanc.repository.search.SearchRemoteRepository
import org.koin.dsl.module

class RemoteRepositoriesModule {

    companion object {

        val remoteRepositoriesModule = module {

            single<SearchRemoteRepository> {
                SearchRemoteMeliApi(get())
            }

        }

    }

}