package com.jkgug.meli_juanc.data.mapper

import com.jkgug.meli_juanc.data.mapper.product.ProductMapper
import com.jkgug.meli_juanc.data.remote.dto.search.Installments
import com.jkgug.meli_juanc.data.remote.dto.search.Result
import com.jkgug.meli_juanc.data.remote.dto.search.Shipping
import com.jkgug.meli_juanc.domain.Product
import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertNull
import org.junit.Assert.assertTrue
import org.junit.Test
import org.mockito.Mockito.mock
import org.mockito.kotlin.whenever

class ProductMapperUnitTest {

    private val mapper: Mapper<Result, Product> = ProductMapper()

    @Test
    fun `maps result to product with all fields`() {
        // GIVEN
        val result = mockResult(
            id = "test_id",
            title = "Test Title",
            thumbnail = "https://example.com/thumbnail.jpg",
            price = 100.0,
            originalPrice = 120.0,
            installments = mockInstallments(5, 10, 20.0),
            freeShipping = true
        )

        // WHEN
        val product = mapper.mapFrom(result)

        // THEN
        assertEquals("test_id", product.id)
        assertEquals("Test Title", product.title)
        assertEquals("https://example.com/thumbnail.jpg", product.thumbnail)
        assertEquals(100.0, product.price.price, 0.0)
        assertEquals(120.0, product.price.originalPrice)
        assertEquals(5, product.installments?.quantity)
        assertEquals(10, product.installments?.rate)
        assertEquals(20.0, product.installments?.amount)
        assertTrue(product.freeShipping)
    }

    @Test
    fun `maps result to product with missing installments`() {
        // GIVEN
        val result = mockResult(
            id = "test_id",
            title = "Test Title",
            thumbnail = "https://example.com/thumbnail.jpg",
            price = 100.0,
            originalPrice = null,
            installments = null,
            freeShipping = false
        )

        // WHEN
        val product = mapper.mapFrom(result)

        // THEN
        assertEquals("test_id", product.id)
        assertEquals("Test Title", product.title)
        assertEquals("https://example.com/thumbnail.jpg", product.thumbnail)
        assertEquals(100.0, product.price.price, 0.0)
        assertNull(product.price.originalPrice)
        assertNull(product.installments)
        assertFalse(product.freeShipping)
    }

    private fun mockResult(
        id: String,
        title: String,
        thumbnail: String,
        price: Double,
        originalPrice: Double?,
        installments: Installments?,
        freeShipping: Boolean
    ): Result {
        val mockResult = mock(Result::class.java)
        whenever(mockResult.id).thenReturn(id)
        whenever(mockResult.title).thenReturn(title)
        whenever(mockResult.thumbnail).thenReturn(thumbnail)
        whenever(mockResult.price).thenReturn(price)
        whenever(mockResult.originalPrice).thenReturn(originalPrice)
        whenever(mockResult.installments).thenReturn(installments)
        whenever(mockResult.shipping).thenReturn(mock(Shipping::class.java))
        whenever(mockResult.shipping.freeShipping).thenReturn(freeShipping)
        return mockResult
    }

    private fun mockInstallments(quantity: Int, rate: Int, amount: Double): Installments {
        val mockInstallments = mock(Installments::class.java)
        whenever(mockInstallments.quantity).thenReturn(quantity)
        whenever(mockInstallments.rate).thenReturn(rate)
        whenever(mockInstallments.amount).thenReturn(amount)
        return mockInstallments
    }

}