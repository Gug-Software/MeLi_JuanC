package com.jkgug.meli_juanc.ui.screen.product

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jkgug.meli_juanc.domain.ProductDetails
import com.jkgug.meli_juanc.ui.navigation.ProductDetails.PRODUCT_ID_ARG
import com.jkgug.meli_juanc.usecase.ProductDetailsUseCase
import com.jkgug.meli_juanc.utils.NetworkResult
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class ProductDetailsViewModel(
    private val savedStateHandle: SavedStateHandle,
    private val useCase: ProductDetailsUseCase
) : ViewModel() {

    private val _uiState = MutableStateFlow(ProductDetailUiState())
    val uiState: StateFlow<ProductDetailUiState> = _uiState.asStateFlow()

    init {
        initScreen()
        getProductDetails()
    }

    fun getProductDetails() {
        val taskId = savedStateHandle.get<String>(PRODUCT_ID_ARG)
        taskId?.let { productId ->
            updateStateAsInit()
            viewModelScope.launch(Dispatchers.IO) {
                useCase(productId)
                    .catch { updateMessageErrorForUser(it.message) }
                    .collect { networkResult ->
                        when (networkResult) {
                            is NetworkResult.Error -> updateMessageErrorForUser(networkResult.message)
                            is NetworkResult.Success -> setProductDetailInUi(networkResult)
                        }
                    }
            }
        }
    }

    private fun setProductDetailInUi(networkResult: NetworkResult<Any?>) {
        val productDetails = networkResult.data as ProductDetails
        _uiState.update { it.copy(productDetails = productDetails, loading = false) }
    }

    private fun updateStateAsInit() {
        _uiState.update {
            it.copy(
                productDetails = null,
                loading = true,
                messageForUser = null
            )
        }
    }

    fun snackBarMessageShown() {
        _uiState.update { it.copy(messageForUser = null) }
    }

    private fun initScreen() {
        _uiState.value = ProductDetailUiState(loading = false)
    }

    private fun updateMessageErrorForUser(message: String?) {
        message?.let { messageUser ->
            _uiState.update { it.copy(messageForUser = messageUser, loading = false, error = true) }
        }
    }


}