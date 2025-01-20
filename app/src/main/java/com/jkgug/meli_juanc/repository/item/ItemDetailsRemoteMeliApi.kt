package com.jkgug.meli_juanc.repository.item

import com.jkgug.meli_juanc.data.remote.api.items.MeLiAPIItems
import com.jkgug.meli_juanc.utils.NetworkResult
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class ItemDetailsRemoteMeliApi(
    private val meLiAPIItems: MeLiAPIItems
) : ItemDetailsRemoteRepository {

    override suspend fun itemDetailsById(
        productId: String
    ): Flow<NetworkResult<Any?>> = flow {
        val response = meLiAPIItems.itemsById(productId)
        if (response.isSuccessful) {
            response.body()?.let {
                emit(NetworkResult.Success(it))
            }
        } else {
            emit(NetworkResult.Error(response.message()))
        }
    }
}

