package com.jkgug.meli_juanc.ui.screen.search

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.jkgug.meli_juanc.domain.Product
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
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito.mock
import org.mockito.MockitoAnnotations
import org.mockito.kotlin.any
import org.mockito.kotlin.whenever

@ExperimentalCoroutinesApi
class SearchViewModelUnitTest {

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    private val testDispatcher = TestCoroutineDispatcher()

    @Mock
    private lateinit var mockUseCase: SearchProductsUseCase

    private lateinit var viewModel: SearchViewModel

    @Before
    fun setUp() {
        Dispatchers.setMain(testDispatcher)
        MockitoAnnotations.openMocks(this)
        viewModel = SearchViewModel(mockUseCase)
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }

    @Test
    fun `initial state is starting and not loading or errored`() {
        assert(viewModel.uiState.value.starting)
        assertFalse(viewModel.uiState.value.loading)
        assertFalse(viewModel.uiState.value.error)
    }

    @Test
    fun `searchByKey with success updates results and hides loading`() = runBlockingTest {
        val mockListProducts = listOf(mock<Product>())
        whenever(mockUseCase.invoke(any())).thenReturn(flowOf(NetworkResult.Success(mockListProducts)))

        viewModel.onSearchChanged("test")
        advanceUntilIdle()

        assert(viewModel.uiState.value.results == mockListProducts)
        assertFalse(viewModel.uiState.value.loading)
    }

    @Test
    fun `searchByKey with error updates message and hides loading`() = runBlockingTest {
        val errorMessage = "Error message"
        whenever(mockUseCase.invoke(any())).thenReturn(flowOf(NetworkResult.Error(errorMessage)))

        viewModel.onSearchChanged("test")
        advanceUntilIdle()

        assert(viewModel.uiState.value.messageForUser == errorMessage)
        assertFalse(viewModel.uiState.value.loading)
    }

}