package com.jkgug.meli_juanc.utils

import org.junit.Assert.assertTrue
import org.junit.Test

class UtilsUnitTest {

    @Test
    fun isValidDiscountPercent() {

        val price = 80.0
        val originalPrice = 100.0

        // Act
        val result = calculatePercentDiscount(price, originalPrice)

        // Assert
        assertTrue(result == 20)
    }
}