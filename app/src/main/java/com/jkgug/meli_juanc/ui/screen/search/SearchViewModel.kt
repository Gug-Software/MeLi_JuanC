package com.jkgug.meli_juanc.ui.screen.search

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jkgug.meli_juanc.domain.Product
import com.jkgug.meli_juanc.domain.ProductInstallments
import com.jkgug.meli_juanc.domain.ProductPrice
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class SearchViewModel(
) : ViewModel() {

    private val _uiState = MutableStateFlow(SearchUiState())
    val uiState: StateFlow<SearchUiState> = _uiState.asStateFlow()

    var searchKey by mutableStateOf("")
        private set

    init {
        initScreen()
    }

    fun onSearchChanged(searchKey: String) {
        this.searchKey = searchKey
        if (searchKey.isEmpty()) {
            initScreen()
        } else {
            searchByKey()
        }
    }

    private fun initScreen() {
        _uiState.value = SearchUiState(starting = true, loading = false)
    }

    private fun searchByKey() {

        _uiState.update { it.copy(starting = false, loading = true) }

        viewModelScope.launch(Dispatchers.IO) {
            delay(3000)
            // Simulate an API call
            withContext(Dispatchers.Main) {
                // Update UI on the main thread
                _uiState.update {
                    it.copy(
                        loading = false, results = listOf(
                            Product(
                                id = "qualisque",
                                title = "deterruisset",
                                thumbnail = "maiorum",
                                price = ProductPrice(price = 45000.0, originalPrice = 60000.0),
                                installments = ProductInstallments(
                                    quantity = 3,
                                    rate = 0,
                                    amount = 45000.0
                                ),
                                freeShipping = true
                            ),
                            Product(
                                id = "qualisque2",
                                title = "deterruisset",
                                thumbnail = "maiorum",
                                price = ProductPrice(price = 45000.0, originalPrice = null),
                                installments = ProductInstallments(
                                    quantity = 3,
                                    rate = 0,
                                    amount = 45000.0
                                ),
                                freeShipping = true
                            ),
                            Product(
                                id = "qualisque2",
                                title = "deterruisset",
                                thumbnail = "maiorum",
                                price = ProductPrice(price = 45000.0, originalPrice = 60000.0),
                                installments = ProductInstallments(
                                    quantity = 3,
                                    rate = 0,
                                    amount = 45000.0
                                ),
                                freeShipping = false
                            ),
                            Product(
                                id = "qualisque2",
                                title = "deterruisset",
                                thumbnail = "maiorum",
                                price = ProductPrice(price = 45000.0, originalPrice = 60000.0),
                                installments = ProductInstallments(
                                    quantity = 3,
                                    rate = 0,
                                    amount = 45000.0
                                ),
                                freeShipping = true
                            ),
                            Product(
                                id = "qualisque2",
                                title = "deterruisset",
                                thumbnail = "maiorum",
                                price = ProductPrice(price = 45000.0, originalPrice = 60000.0),
                                installments = ProductInstallments(
                                    quantity = 3,
                                    rate = 0,
                                    amount = 45000.0
                                ),
                                freeShipping = true
                            ),
                            Product(
                                id = "qualisque2",
                                title = "deterruisset",
                                thumbnail = "maiorum",
                                price = ProductPrice(price = 45000.0, originalPrice = 60000.0),
                                installments = ProductInstallments(
                                    quantity = 3,
                                    rate = 0,
                                    amount = 45000.0
                                ),
                                freeShipping = true
                            ),
                            Product(
                                id = "qualisque2",
                                title = "deterruisset",
                                thumbnail = "maiorum",
                                price = ProductPrice(price = 45000.0, originalPrice = 60000.0),
                                installments = ProductInstallments(
                                    quantity = 3,
                                    rate = 0,
                                    amount = 45000.0
                                ),
                                freeShipping = true
                            ),
                            Product(
                                id = "qualisque2",
                                title = "deterruisset",
                                thumbnail = "maiorum",
                                price = ProductPrice(price = 45000.0, originalPrice = 60000.0),
                                installments = ProductInstallments(
                                    quantity = 3,
                                    rate = 0,
                                    amount = 45000.0
                                ),
                                freeShipping = true
                            )
                        )
                    )
                }
            }
        }
    }


}