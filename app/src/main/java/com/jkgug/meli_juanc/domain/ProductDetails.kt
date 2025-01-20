package com.jkgug.meli_juanc.domain

data class ProductDetails(
    val id: String = "",
    val title: String = "",
    val thumbnail: String = "",
    val price: ProductPrice,
    val freeShipping: Boolean = false,
    val listAttributes: List<ProductDetailsAttribute> = emptyList(),
    val listVariations: List<ProductDetailsAttribute> = emptyList(),
    val listSaleTerms: List<ProductDetailsAttribute> = emptyList(),
    val listPictures: List<String> = emptyList()
)