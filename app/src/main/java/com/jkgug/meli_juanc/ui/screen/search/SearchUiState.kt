package com.jkgug.meli_juanc.ui.screen.search

import com.jkgug.meli_juanc.domain.Product

data class SearchUiState(
    val starting: Boolean = false,
    val loading: Boolean = false,
    val error: Boolean = false,
    val results: List<Product> = listOf(),
    val messageForUser: String? = null,
)