package com.jkgug.meli_juanc.di

import com.jkgug.meli_juanc.ui.screen.search.SearchViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

class ViewModelModule {

    companion object {

        val viewModelModule = module {

            // viewmodel
            viewModel {
                SearchViewModel()
            }

        }

    }

}