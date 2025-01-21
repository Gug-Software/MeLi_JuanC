package com.jkgug.meli_juanc.usecase

import com.jkgug.meli_juanc.repository.search.SearchRemoteRepository
import com.jkgug.meli_juanc.utils.NetworkResult
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext

interface SearchProductsUseCase {

    suspend operator fun invoke(
        query: String
    ): Flow<NetworkResult<Any?>>

}

class SearchProductsUseCaseImpl(
    private val searchRemoteRepository: SearchRemoteRepository,
    private val defaultDispatcher: CoroutineDispatcher = Dispatchers.Default
) : SearchProductsUseCase {

    override suspend fun invoke(query: String): Flow<NetworkResult<Any?>> {
        return withContext(defaultDispatcher) {
            searchRemoteRepository.searchByQuery(query)
        }
    }

}