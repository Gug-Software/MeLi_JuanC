package com.jkgug.meli_juanc.data.mapper.detail

import com.jkgug.meli_juanc.data.mapper.Mapper
import com.jkgug.meli_juanc.data.mapper.product.detail.ProductDetailMapper
import com.jkgug.meli_juanc.data.remote.dto.items.Attribute
import com.jkgug.meli_juanc.data.remote.dto.items.AttributeCombination
import com.jkgug.meli_juanc.data.remote.dto.items.ItemDetailsDtoOut
import com.jkgug.meli_juanc.data.remote.dto.items.ItemDetailsVariations
import com.jkgug.meli_juanc.data.remote.dto.items.Picture
import com.jkgug.meli_juanc.data.remote.dto.items.SaleTerm
import com.jkgug.meli_juanc.data.remote.dto.search.Shipping
import com.jkgug.meli_juanc.domain.ProductDetails
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNull
import org.junit.Assert.assertTrue
import org.junit.Test
import org.mockito.Mockito.mock
import org.mockito.kotlin.whenever

class ProductDetailMapperUnitTest {

    private val mapper: Mapper<ItemDetailsDtoOut, ProductDetails> = ProductDetailMapper()

    @Test
    fun `maps item details with all fields to product details`() {
        // GIVEN
        val itemDetails = mockItemDetails(
            id = "test_id",
            title = "Test Title",
            thumbnail = "https://example.com/thumbnail.jpg",
            price = 100.0,
            originalPrice = 120.0,
            attributes = listOf(
                Attribute("Color", "Red"),
                Attribute("Size", "M")
            ),
            variations = listOf(
                ItemDetailsVariations(
                    attributeCombinations = listOf(
                        AttributeCombination("Color", "Blue"),
                        AttributeCombination("Size", "L")
                    )
                )
            ),
            saleTerms = listOf(
                SaleTerm("Warranty", "1 year")
            ),
            pictures = listOf(
                Picture("https://example.com/picture1.jpg"),
                Picture("https://example.com/picture2.jpg"),
            ),
            shipping = Shipping(true)
        )

        // WHEN
        val productDetails = mapper.mapFrom(itemDetails)

        // THEN
        assertEquals("test_id", productDetails.id)
        assertEquals("Test Title", productDetails.title)
        assertEquals("https://example.com/thumbnail.jpg", productDetails.thumbnail)
        assertEquals(100.0, productDetails.price.price, 0.0)
        assertEquals(120.0, productDetails.price.originalPrice)
        assertEquals(2, productDetails.listAttributes.size)
        assertEquals("Color", productDetails.listAttributes[0].name)
        assertEquals("Red", productDetails.listAttributes[0].value)
        assertEquals("Size", productDetails.listAttributes[1].name)
        assertEquals("M", productDetails.listAttributes[1].value)
        assertEquals(2, productDetails.listVariations.size)
        assertEquals("Color", productDetails.listVariations[0].name)
        assertEquals("Blue", productDetails.listVariations[0].value)
        assertEquals(1, productDetails.listSaleTerms.size)
        assertEquals("Warranty", productDetails.listSaleTerms[0].name)
        assertEquals("1 year", productDetails.listSaleTerms[0].value)
        assertEquals(2, productDetails.listPictures.size)
        assertEquals("https://example.com/picture1.jpg", productDetails.listPictures[0])
        assertEquals("https://example.com/picture2.jpg", productDetails.listPictures[1])
    }

    @Test
    fun `maps item details with missing fields to product details`() {
        // GIVEN
        val itemDetails = mockItemDetails(
            id = "test_id",
            title = "Test Title",
            thumbnail = "https://example.com/thumbnail.jpg",
            price = 100.0,
            originalPrice = null,
            attributes = null,
            variations = emptyList(),
            saleTerms = emptyList(),
            pictures = emptyList(),
            shipping = Shipping(true)
        )

        // WHEN
        val productDetails = mapper.mapFrom(itemDetails)

        // THEN
        assertEquals("test_id", productDetails.id)
        assertEquals("Test Title", productDetails.title)
        assertEquals("https://example.com/thumbnail.jpg", productDetails.thumbnail)
        assertEquals(100.0, productDetails.price.price, 0.0)
        assertNull(productDetails.price.originalPrice)
        assertTrue(productDetails.listAttributes.isEmpty())
        assertTrue(productDetails.listVariations.isEmpty())
        assertTrue(productDetails.listSaleTerms.isEmpty())
        assertTrue(productDetails.listPictures.isEmpty())
    }

    private fun mockItemDetails(
        id: String,
        title: String,
        thumbnail: String,
        price: Double,
        originalPrice: Double?,
        attributes: List<Attribute>?,
        variations: List<ItemDetailsVariations>?,
        saleTerms: List<SaleTerm>?,
        pictures: List<Picture>,
        shipping: Shipping
    ): ItemDetailsDtoOut {
        val mockItemDetails = mock(ItemDetailsDtoOut::class.java)
        whenever(mockItemDetails.id).thenReturn(id)
        whenever(mockItemDetails.title).thenReturn(title)
        whenever(mockItemDetails.thumbnail).thenReturn(thumbnail)
        whenever(mockItemDetails.price).thenReturn(price)
        whenever(mockItemDetails.originalPrice).thenReturn(originalPrice)
        whenever(mockItemDetails.attributes).thenReturn(attributes)
        whenever(mockItemDetails.variations).thenReturn(variations)
        whenever(mockItemDetails.saleTerms).thenReturn(saleTerms)
        whenever(mockItemDetails.pictures).thenReturn(pictures)
        whenever(mockItemDetails.shipping).thenReturn(shipping)
        return mockItemDetails
    }
}