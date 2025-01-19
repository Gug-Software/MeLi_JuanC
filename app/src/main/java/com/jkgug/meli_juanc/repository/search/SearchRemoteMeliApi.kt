package com.jkgug.meli_juanc.repository.search

import com.jkgug.meli_juanc.data.remote.api.search.MeLiAPISearch
import com.jkgug.meli_juanc.utils.NetworkResult
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class SearchRemoteMeliApi(
    private val meLiSearchAPI: MeLiAPISearch
) : SearchRemoteRepository {

    override suspend fun searchByQuery(
        query: String
    ): Flow<NetworkResult<Any?>> = flow {
        val response = meLiSearchAPI.search(query)
        if (response.isSuccessful) {
            response.body()?.let {
                emit(NetworkResult.Success(it))
            }
        } else {
            emit(NetworkResult.Error(response.message()))
        }
    }

}

