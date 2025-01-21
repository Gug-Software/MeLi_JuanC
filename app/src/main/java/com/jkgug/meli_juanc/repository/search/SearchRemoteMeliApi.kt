package com.jkgug.meli_juanc.repository.search

import com.jkgug.meli_juanc.data.mapper.Mapper
import com.jkgug.meli_juanc.data.remote.api.search.MeLiAPISearch
import com.jkgug.meli_juanc.data.remote.dto.search.Result
import com.jkgug.meli_juanc.domain.Product
import com.jkgug.meli_juanc.utils.NetworkResult
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class SearchRemoteMeliApi(
    private val meLiSearchAPI: MeLiAPISearch,
    private val productMapper: Mapper<Result, Product>
) : SearchRemoteRepository {

    override suspend fun searchByQuery(
        query: String
    ): Flow<NetworkResult<Any?>> = flow {
        try {
            val response = meLiSearchAPI.search(query)
            if (response.isSuccessful) {
                response.body()?.let {
                    val products = it.results.map { result -> productMapper.mapFrom(result) }
                    emit(NetworkResult.Success(products))
                } ?: run {
                    emit(NetworkResult.Error("Error"))
                }
            } else {
                emit(NetworkResult.Error(response.message()))
            }
        } catch (exception: Exception) {
            emit(NetworkResult.Error(exception.message))
        }
    }

}

