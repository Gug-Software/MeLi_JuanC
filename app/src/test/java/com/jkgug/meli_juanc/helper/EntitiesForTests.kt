package com.jkgug.meli_juanc.helper

import com.jkgug.meli_juanc.data.remote.dto.items.ItemDetailsDtoOut
import com.jkgug.meli_juanc.data.remote.dto.search.Result
import com.jkgug.meli_juanc.data.remote.dto.search.SearchResultsDtoOut
import com.jkgug.meli_juanc.data.remote.dto.search.Shipping
import com.jkgug.meli_juanc.domain.Product
import com.jkgug.meli_juanc.domain.ProductDetails
import com.jkgug.meli_juanc.domain.ProductInstallments
import com.jkgug.meli_juanc.domain.ProductPrice

val itemDetailsDtoOutForTest = ItemDetailsDtoOut(
    attributes = listOf(),
    id = "te",
    originalPrice = null,
    pictures = listOf(),
    price = 6.7,
    saleTerms = listOf(),
    shipping = Shipping(freeShipping = false),
    thumbnail = "morbi",
    title = "ea",
    variations = listOf()
)

val productDetailsForTest = ProductDetails(
    id = "te",
    title = "ea",
    thumbnail = "morbi",
    price = ProductPrice(price = 6.7, originalPrice = null),
    freeShipping = false,
    listAttributes = listOf(),
    listVariations = listOf(),
    listSaleTerms = listOf(),
    listPictures = listOf()
)

val listProductsForTests = listOf(
    Product(
        id = "sagittis",
        title = "assueverit",
        thumbnail = "maecenas",
        price = ProductPrice(price = 14.15, originalPrice = null),
        installments = ProductInstallments(
            quantity = 12, rate = 0, amount = 250000.0
        ),
        freeShipping = false
    ),
    Product(
        id = "sagittis2",
        title = "assueverit",
        thumbnail = "maecenas",
        price = ProductPrice(price = 14.15, originalPrice = null),
        installments = null,
        freeShipping = false
    )
)

val searchResultsDtoOutForTest = SearchResultsDtoOut(
    results = listOf(
        Result(
            id = "sagittis",
            title = "assueverit",
            thumbnail = "maecenas",
            price = 14.15,
            originalPrice = null,
            installments = null,
            shipping = Shipping(freeShipping = false)
        )
    )
)