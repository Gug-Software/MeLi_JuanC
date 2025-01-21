package com.jkgug.meli_juanc.usecase

import com.jkgug.meli_juanc.helper.productDetailsForTest
import com.jkgug.meli_juanc.repository.item.ItemDetailsRemoteRepository
import com.jkgug.meli_juanc.utils.NetworkResult
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.Mockito.`when`
import org.mockito.MockitoAnnotations

class ProductDetailsUseCaseUnitTest {

    @Mock
    private lateinit var mockRepository: ItemDetailsRemoteRepository

    private lateinit var useCase: ProductDetailsUseCaseImpl

    private val productId = "some"
    private val messageError = "message error"

    @Before
    fun setUp() {
        MockitoAnnotations.openMocks(this)
        useCase = ProductDetailsUseCaseImpl(mockRepository)
    }

    @Test
    fun test_invoke_verifiesRepositoryCall() = runTest {
        // GIVEN
        `when`(mockRepository.itemDetailsById(productId)).thenReturn(
            flow { emit(NetworkResult.Success(productDetailsForTest)) }
        )

        // WHEN
        useCase.invoke(productId)

        // THEN
        Mockito.verify(mockRepository).itemDetailsById(productId)
    }

    @Test
    fun test_invoke_verifiesRepositoryCall_onApiError() = runTest {
        // GIVEN
        `when`(mockRepository.itemDetailsById(productId)).thenReturn(
            flow { NetworkResult.Error(message = messageError, data = null) }
        )
        // Act
        useCase.invoke(productId)

        // Assert
        Mockito.verify(mockRepository).itemDetailsById(productId)
    }

    @Test
    fun `test_invoke_success_emitsProductDetails is success`(): Unit = runTest {
        // GIVEN
        `when`(mockRepository.itemDetailsById(productId)).thenReturn(
            flow { emit(NetworkResult.Success(productDetailsForTest)) }
        )
        // WHEN
        val flow = useCase.invoke(productId)

        // THEN
        flow.collect { result ->
            assert(result is NetworkResult.Success)
            assert(result.data == productDetailsForTest)
        }
    }

    @Test
    fun `test_invoke_error_when_itemDetails_fails is error`(): Unit = runTest {
        // GIVEN
        `when`(mockRepository.itemDetailsById(productId)).thenReturn(
            flow { NetworkResult.Error(message = messageError, data = null) }
        )
        // WHEN
        val flow = useCase.invoke(productId)

        // THEN
        flow.collect { result ->
            assert(result is NetworkResult.Error)
            assert(result.message == messageError)
        }
    }


}