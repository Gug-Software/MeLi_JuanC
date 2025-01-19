package com.jkgug.meli_juanc.usecase

import com.jkgug.meli_juanc.data.mapper.Mapper
import com.jkgug.meli_juanc.data.remote.dto.search.Result
import com.jkgug.meli_juanc.data.remote.dto.search.SearchResultsDtoOut
import com.jkgug.meli_juanc.domain.Product
import com.jkgug.meli_juanc.repository.search.SearchRemoteRepository
import com.jkgug.meli_juanc.utils.NetworkResult
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.withContext

interface SearchProductsUseCase {

    suspend operator fun invoke(query: String): Flow<NetworkResult<Any?>>

}

class SearchProductsUseCaseImpl(
    private val searchRemoteRepository: SearchRemoteRepository,
    private val productMapper: Mapper<Result, Product>,
    private val defaultDispatcher: CoroutineDispatcher = Dispatchers.Default
) : SearchProductsUseCase {

    override suspend fun invoke(query: String): Flow<NetworkResult<Any?>> {
        return withContext(defaultDispatcher) {
            searchRemoteRepository.searchByQuery(query).map { networkResult ->
                val resultSearch = networkResult.data as SearchResultsDtoOut
                val products = resultSearch.results.map { result ->
                    productMapper.mapFrom(result)
                }
                NetworkResult.Success(products)
            }
        }
    }

}