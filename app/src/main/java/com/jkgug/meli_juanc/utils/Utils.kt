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