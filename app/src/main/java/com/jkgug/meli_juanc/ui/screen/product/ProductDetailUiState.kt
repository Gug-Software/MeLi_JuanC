package com.jkgug.meli_juanc.ui.screen.product

import com.jkgug.meli_juanc.domain.ProductDetails

data class ProductDetailUiState(
    val loading: Boolean = false,
    val error: Boolean = false,
    val productDetails: ProductDetails? = null,
    val messageForUser: String? = null,
)