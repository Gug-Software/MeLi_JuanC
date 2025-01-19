package com.jkgug.meli_juanc.domain

data class Product(
    val id: String = "",
    val title: String = "",
    val thumbnail: String = "",
    val price: ProductPrice,
    val installments: ProductInstallments,
    val freeShipping: Boolean = false,
)