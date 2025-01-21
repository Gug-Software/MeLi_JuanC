package com.jkgug.meli_juanc.ui.screen.product

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.SavedStateHandle
import com.jkgug.meli_juanc.domain.ProductDetails
import com.jkgug.meli_juanc.ui.screen.search.SearchViewModel
import com.jkgug.meli_juanc.usecase.ProductDetailsUseCase
import com.jkgug.meli_juanc.usecase.SearchProductsUseCase
import com.jkgug.meli_juanc.utils.NetworkResult
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.test.TestCoroutineDispatcher
import kotlinx.coroutines.test.advanceUntilIdle
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runBlockingTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Assert.assertFalse
import org.junit.Assert.assertNull
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito.mock
import org.mockito.MockitoAnnotations
import org.mockito.kotlin.any
import org.mockito.kotlin.whenever

@ExperimentalCoroutinesApi
class ProductDetailsViewModelUnitTest {

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    private val testDispatcher = TestCoroutineDispatcher()

    @Mock
    private lateinit var mockSavedStateHandle: SavedStateHandle

    @Mock
    private lateinit var mockUseCase: ProductDetailsUseCase

    private lateinit var viewModel: ProductDetailsViewModel

    @Before
    fun setUp() {
        Dispatchers.setMain(testDispatcher)
        MockitoAnnotations.openMocks(this)
        viewModel = ProductDetailsViewModel(mockSavedStateHandle, mockUseCase)
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }

    @Test
    fun `initial state is not loading and has no product details or message`() = runBlockingTest {
        assert(!viewModel.uiState.value.loading)
        assertNull(viewModel.uiState.value.productDetails)
        assertNull(viewModel.uiState.value.messageForUser)
    }

    @Test
    fun `getProductDetails with valid id updates state and fetches data`() = runBlockingTest {
        val mockProductDetails = mock<ProductDetails>()
        whenever(mockUseCase.invoke(any())).thenReturn(
            flowOf(
                NetworkResult.Success(
                    mockProductDetails
                )
            )
        )

        viewModel.getProductDetails()
        advanceUntilIdle()

        assert(viewModel.uiState.value.loading)
        assert(viewModel.uiState.value.productDetails == mockProductDetails)
        assertFalse(viewModel.uiState.value.error)
    }

    @Test
    fun `getProductDetails with error updates state and message`() = runBlockingTest {
        val errorMessage = "Error message"
        whenever(mockUseCase.invoke(any())).thenReturn(flowOf(NetworkResult.Error(errorMessage)))

        viewModel.getProductDetails()
        advanceUntilIdle()

        assert(viewModel.uiState.value.messageForUser == errorMessage)
        assertFalse(viewModel.uiState.value.loading)
        assertTrue(viewModel.uiState.value.error)
    }

}