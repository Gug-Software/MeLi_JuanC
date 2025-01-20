package com.jkgug.meli_juanc.ui.screen.search

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jkgug.meli_juanc.domain.Product
import com.jkgug.meli_juanc.usecase.SearchProductsUseCase
import com.jkgug.meli_juanc.utils.NetworkResult
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class SearchViewModel(
    private val useCase: SearchProductsUseCase
) : ViewModel() {

    private val _uiState = MutableStateFlow(SearchUiState())
    val uiState: StateFlow<SearchUiState> = _uiState.asStateFlow()

    var searchKey by mutableStateOf("zidane")
        private set

    private var searchJob: Job? = null

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

    fun snackBarMessageShown() {
        _uiState.update { it.copy(messageForUser = null) }
    }

    fun searchByKey() {

        _uiState.update { it.copy(starting = false, loading = true, error = false) }
        searchJob?.cancel()

        searchJob = viewModelScope.launch(Dispatchers.IO) {
            useCase.invoke(searchKey)
                .catch { updateMessageErrorForUser(it.message) }
                .collect { networkResult ->
                    when (networkResult) {
                        is NetworkResult.Success -> updateResults(networkResult)
                        is NetworkResult.Error -> updateMessageErrorForUser(networkResult.message)
                    }
                }
        }
    }

    private fun updateResults(networkResult: NetworkResult.Success<Any?>) {
        val listProducts = networkResult.data as List<Product>
        _uiState.update { it.copy(starting = false, loading = false, results = listProducts) }
    }

    private fun initScreen() {
        _uiState.value = SearchUiState(starting = true, loading = false)
    }

    private fun updateMessageErrorForUser(message: String?) {
        message?.let { messageUser ->
            _uiState.update { it.copy(messageForUser = messageUser, loading = false, error = true) }
        }
    }


}