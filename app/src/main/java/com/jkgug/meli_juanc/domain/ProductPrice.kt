package com.jkgug.meli_juanc.domain

import com.jkgug.meli_juanc.utils.formatDoubleWithThousandsSeparator

data class ProductPrice(
    val price: Double = 0.0,
    val originalPrice: Double? = null,
) {

    val priceString = "$${formatDoubleWithThousandsSeparator(price)}"

    val originalPriceString = originalPrice?.let {
        "$${formatDoubleWithThousandsSeparator(it)}"
    } ?: run { "" }

    val percentDiscount = originalPrice?.let {
        "${100 - ((price / it) * 100).toInt()}% OFF"
    } ?: run { "" }
}

