package com.jkgug.meli_juanc.repository

import com.jkgug.meli_juanc.data.mapper.Mapper
import com.jkgug.meli_juanc.data.remote.api.search.MeLiAPISearch
import com.jkgug.meli_juanc.data.remote.dto.search.Result
import com.jkgug.meli_juanc.data.remote.dto.search.SearchResultsDtoOut
import com.jkgug.meli_juanc.domain.Product
import com.jkgug.meli_juanc.helper.listProductsForTests
import com.jkgug.meli_juanc.helper.searchResultsDtoOutForTest
import com.jkgug.meli_juanc.repository.search.SearchRemoteMeliApi
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

class SearchRemoteMeliApiUnitTest {

    @Mock
    private lateinit var mockApi: MeLiAPISearch

    @Mock
    private lateinit var mockMapper: Mapper<Result, Product>

    private lateinit var repository: SearchRemoteMeliApi

    private val query = "query"
    private val mockResponse = mock(Response::class.java)

    @Before
    fun setUp() {
        MockitoAnnotations.openMocks(this)
        repository = SearchRemoteMeliApi(mockApi, mockMapper)
    }

    @Test
    fun test_searchByQuery_returnsSuccess_whenApiSuccessfulAndBodyNotNull() = runTest {
        // GIVEN
        `when`(mockResponse.isSuccessful).thenReturn(true)
        `when`(mockResponse.body()).thenReturn(searchResultsDtoOutForTest)
        `when`(mockApi.search(query)).thenReturn(mockResponse as Response<SearchResultsDtoOut>?)
        `when`(mockMapper.mapFrom(searchResultsDtoOutForTest.results[0])).thenReturn(
            listProductsForTests[0]
        )

        // WHEN
        val results = repository.searchByQuery(query)

        // THEN
        results.collect {
            assert(it is NetworkResult.Success)
        }
        verify(mockMapper).mapFrom(searchResultsDtoOutForTest.results[0])
        verify(mockApi).search(query)
    }

    @Test
    fun test_searchByQuery_returnsError_whenApiUnsuccessful() = runTest {
        // GIVEN
        `when`(mockResponse.isSuccessful).thenReturn(false)
        `when`(mockResponse.body()).thenReturn(searchResultsDtoOutForTest)
        `when`(mockResponse.message()).thenReturn("Mocked exception message")
        `when`(mockApi.search(query)).thenReturn(mockResponse as Response<SearchResultsDtoOut>?)

        // WHEN
        val result = repository.searchByQuery(query)

        // THEN
        result.collect {
            assert(it is NetworkResult.Error)
            assert(it.message == "Mocked exception message")
        }
        verify(mockApi).search(query)
        verifyNoInteractions(mockMapper)
    }

    @Test
    fun test_searchByQuery_returnsError_whenApiThrowsException() = runTest {
        // GIVEN
        val expectedException = RuntimeException("Mocked search error")
        whenever(mockApi.search(query)).thenThrow(expectedException)

        // WHEN
        val results = repository.searchByQuery(query)

        // THEN
        results.collect {
            assert(it is NetworkResult.Error)
            assert(it.message == "Mocked search error")
        }
        verify(mockApi).search(query)
        verifyNoInteractions(mockMapper)
    }

    @Test
    fun test_searchByQuery_returnsSuccess_withMappedProducts() = runTest {
        // GIVEN
        `when`(mockResponse.isSuccessful).thenReturn(true)
        `when`(mockResponse.body()).thenReturn(searchResultsDtoOutForTest)
        `when`(mockApi.search(query)).thenReturn(mockResponse as Response<SearchResultsDtoOut>?)
        `when`(mockMapper.mapFrom(searchResultsDtoOutForTest.results[0])).thenReturn(
            listProductsForTests[0]
        )

        // WHEN
        val results = repository.searchByQuery(query)

        // THEN
        results.collect {
            assert(it is NetworkResult.Success)
            assert(it.data is List<*>)
            val data = it.data as List<Product>
            assert(data.size == searchResultsDtoOutForTest.results.size)
        }
        verify(mockApi).search(query)
        verify(mockMapper).mapFrom(any())
    }

}