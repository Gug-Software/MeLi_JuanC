package com.jkgug.meli_juanc.di.usecase

import com.jkgug.meli_juanc.usecase.ProductDetailsUseCase
import com.jkgug.meli_juanc.usecase.ProductDetailsUseCaseImpl
import com.jkgug.meli_juanc.usecase.SearchProductsUseCase
import com.jkgug.meli_juanc.usecase.SearchProductsUseCaseImpl
import org.koin.core.qualifier.named
import org.koin.dsl.module

class UseCaseModule {

    companion object {

        val useCaseModule = module {

            single<SearchProductsUseCase> {
                SearchProductsUseCaseImpl(
                    searchRemoteRepository = get(), productMapper = get(named("uno"))
                )
            }

            single<ProductDetailsUseCase> {
                ProductDetailsUseCaseImpl(
                    itemDetailsRemoteRepository = get(), productDetailMapper = get(named("dos"))
                )
            }

        }

    }
}