package com.jkgug.meli_juanc.utils

import java.text.NumberFormat
import java.util.Locale

fun formatDoubleWithThousandsSeparator(
    number: Double,
    locale: Locale = Locale.getDefault()
): String {
    val numberFormat = NumberFormat.getNumberInstance(locale)
    return numberFormat.format(number)
}

fun calculatePercentDiscount(price: Double, originalPrice: Double): Int {
    return 100 - ((price / originalPrice) * 100).toInt()
}