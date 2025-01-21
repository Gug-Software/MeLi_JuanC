package com.jkgug.meli_juanc.usecase

import com.jkgug.meli_juanc.helper.listProductsForTests
import com.jkgug.meli_juanc.repository.search.SearchRemoteRepository
import com.jkgug.meli_juanc.utils.NetworkResult
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.Mockito.`when`
import org.mockito.MockitoAnnotations

class SearchProductsUseCaseUnitTest {

    @Mock
    private lateinit var mockRepository: SearchRemoteRepository

    private lateinit var useCase: SearchProductsUseCaseImpl

    private val query = "query"
    private val messageError = "message error"

    @Before
    fun setUp() {
        MockitoAnnotations.openMocks(this)
        useCase = SearchProductsUseCaseImpl(mockRepository)
    }

    @Test
    fun test_invoke_verifies_repository_call_on_success() = runTest {
        // GIVEN
        `when`(mockRepository.searchByQuery(query)).thenReturn(
            flow { emit(NetworkResult.Success(listProductsForTests)) }
        )
        // WHEN
        useCase(query)

        // THEN
        Mockito.verify(mockRepository).searchByQuery(query)
    }

    @Test
    fun test_invoke_verifies_repository_call_on_error() = runTest {
        // GIVEN
        `when`(mockRepository.searchByQuery(query)).thenReturn(
            flow { NetworkResult.Error(message = messageError, data = null) }
        )
        // WHEN
        useCase(query)

        // THEN
        Mockito.verify(mockRepository).searchByQuery(query)
    }

    @Test
    fun test_invoke_success_emits_product_list(): Unit = runTest {
        // GIVEN
        `when`(mockRepository.searchByQuery(query)).thenReturn(
            flow { emit(NetworkResult.Success(listProductsForTests)) }
        )
        // WHEN
        val flow = useCase(query)

        // THEN
        flow.collect { result ->
            assert(result is NetworkResult.Success)
            assert(result.data == listProductsForTests)
        }
    }

    @Test
    fun test_invoke_emits_error_on_search_failure(): Unit = runTest {
        // GIVEN
        `when`(mockRepository.searchByQuery(query)).thenReturn(
            flow { NetworkResult.Error(message = messageError, data = null) }
        )
        // Act
        val flow = useCase(query)

        // THEN
        flow.collect { result ->
            assert(result is NetworkResult.Error)
            assert(result.message == messageError)
        }
    }

}