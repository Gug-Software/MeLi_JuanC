package com.jkgug.meli_juanc.domain

import com.jkgug.meli_juanc.utils.formatDoubleWithThousandsSeparator

data class ProductInstallments(
    val quantity: Int,
    val rate: Int,
    val amount: Double
) {

    val amountString = "$${formatDoubleWithThousandsSeparator(amount)}"
}