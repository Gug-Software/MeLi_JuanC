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

    private val productId = "some"
    private val messageError = "message error"

    private lateinit var useCase: ProductDetailsUseCaseImpl

    @Before
    fun setUp() {
        MockitoAnnotations.openMocks(this)
        useCase = ProductDetailsUseCaseImpl(mockRepository)
    }

    @Test
    fun invoke_success() = runTest {
        // GIVEN
        `when`(mockRepository.itemDetailsById(productId)).thenReturn(
            flow { emit(NetworkResult.Success(productDetailsForTest)) }
        )
        // Act
        useCase.invoke(productId)

        // Assert
        Mockito.verify(mockRepository).itemDetailsById(productId)
    }

    @Test
    fun invoke_error() = runTest {
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
    fun `invoke_whenSignInWithEmailAndPasswordSucceeds_flow is success`(): Unit = runTest {
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
    fun `invoke_whenSignInWithEmailAndPasswordSucceeds_flow is error`(): Unit = runTest {
        // GIVEN
        `when`(mockRepository.itemDetailsById(productId)).thenReturn(
            flow { NetworkResult.Error(message = messageError, data = null) }
        )
        // Act
        val flow = useCase.invoke(productId)

        // THEN
        flow.collect { result ->
            assert(result is NetworkResult.Error)
            assert(result.message == messageError)
        }
    }


}