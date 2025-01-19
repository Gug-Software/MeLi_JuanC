package com.jkgug.meli_juanc.di.usecase

import com.jkgug.meli_juanc.usecase.SearchProductsUseCase
import com.jkgug.meli_juanc.usecase.SearchProductsUseCaseImpl
import org.koin.dsl.module

class UseCaseModule {

    companion object {

        val useCaseModule = module {

            single<SearchProductsUseCase> {
                SearchProductsUseCaseImpl(
                    searchRemoteRepository = get(), productMapper = get()
                )
            }

        }

    }
}