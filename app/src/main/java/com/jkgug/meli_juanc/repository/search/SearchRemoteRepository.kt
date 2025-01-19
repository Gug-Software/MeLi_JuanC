package com.jkgug.meli_juanc.repository.search

import com.jkgug.meli_juanc.utils.NetworkResult
import kotlinx.coroutines.flow.Flow

interface SearchRemoteRepository {

    /**
     * Search by query remotely
     *
     * @param query query to search
     */
    suspend fun searchByQuery(
        query: String,
    ): Flow<NetworkResult<Any?>>

}