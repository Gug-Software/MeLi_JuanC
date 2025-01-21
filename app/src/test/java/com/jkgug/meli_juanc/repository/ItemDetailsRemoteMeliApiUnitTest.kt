package com.jkgug.meli_juanc.repository

import com.jkgug.meli_juanc.data.mapper.Mapper
import com.jkgug.meli_juanc.data.remote.api.items.MeLiAPIItems
import com.jkgug.meli_juanc.data.remote.dto.items.ItemDetailsDtoOut
import com.jkgug.meli_juanc.domain.ProductDetails
import com.jkgug.meli_juanc.helper.itemDetailsDtoOutForTest
import com.jkgug.meli_juanc.helper.productDetailsForTest
import com.jkgug.meli_juanc.repository.item.ItemDetailsRemoteMeliApi
import com.jkgug.meli_juanc.utils.NetworkResult
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito.mock
import org.mockito.Mockito.`when`
import org.mockito.MockitoAnnotations
import org.mockito.kotlin.any
import org.mockito.kotlin.verify
import org.mockito.kotlin.verifyNoInteractions
import org.mockito.kotlin.whenever
import retrofit2.Response

class ItemDetailsRemoteMeliApiUnitTest {

    @Mock
    private lateinit var mockApi: MeLiAPIItems

    @Mock
    private lateinit var mockMapper: Mapper<ItemDetailsDtoOut, ProductDetails>

    private lateinit var repository: ItemDetailsRemoteMeliApi

    private val productId = "12"
    private val mockResponse = mock(Response::class.java)


    @Before
    fun setUp() {
        MockitoAnnotations.openMocks(this)
        repository = ItemDetailsRemoteMeliApi(mockApi, mockMapper)
    }


    @Test
    fun test_itemDetailsById_returnsSuccess_whenApiSuccessfulAndBodyNotNull() = runTest {
        // GIVEN
        `when`(mockResponse.isSuccessful).thenReturn(true)
        `when`(mockResponse.body()).thenReturn(itemDetailsDtoOutForTest)
        `when`(mockApi.itemsById(productId)).thenReturn(mockResponse as Response<ItemDetailsDtoOut>?)
        `when`(mockMapper.mapFrom(itemDetailsDtoOutForTest)).thenReturn(productDetailsForTest)

        // Act
        val results = repository.itemDetailsById(productId)

        results.collect {
            assert(it is NetworkResult.Success)
        }
        verify(mockMapper).mapFrom(any())

    }

    @Test
    fun test_itemDetailsById_returnsError_whenApiUnsuccessful() = runTest {
        // GIVEN
        `when`(mockResponse.isSuccessful).thenReturn(false) // Simulate unsuccessful response
        `when`(mockResponse.message()).thenReturn("Mocked exception message") // Set a custom error message
        `when`(mockApi.itemsById(productId)).thenReturn(mockResponse as Response<ItemDetailsDtoOut>?)
        `when`(mockMapper.mapFrom(itemDetailsDtoOutForTest)).thenReturn(productDetailsForTest)

        val result = repository.itemDetailsById(productId)

        result.collect {
            assert(it is NetworkResult.Error)
        }
        verifyNoInteractions(mockMapper)

    }

    @Test
    fun test_itemDetailsById_returnsError_whenApiThrowsException() = runTest {
        // GIVEN
        val expectedException = RuntimeException("Mocked search error")
        whenever(mockApi.itemsById(productId)).thenThrow(expectedException)

        // Act
        val results = repository.itemDetailsById(productId)

        results.collect {
            assert(it is NetworkResult.Error)
        }
        verifyNoInteractions(mockMapper)

    }

    @Test
    fun test_itemDetailsById_returnsSuccess_withMappedProducts() = runTest {
        // GIVEN
        `when`(mockApi.itemsById(productId)).thenReturn(
            Response.success(itemDetailsDtoOutForTest)
        )
        `when`(mockMapper.mapFrom(itemDetailsDtoOutForTest)).thenReturn(productDetailsForTest)

        // Act
        val results = repository.itemDetailsById(productId)

        results.collect {
            assert(it is NetworkResult.Success)
            assert(it.data is ProductDetails)
        }
        verify(mockMapper).mapFrom(any())

    }
}