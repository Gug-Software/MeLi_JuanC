package com.jkgug.meli_juanc.repository.item

import com.jkgug.meli_juanc.data.mapper.Mapper
import com.jkgug.meli_juanc.data.remote.api.items.MeLiAPIItems
import com.jkgug.meli_juanc.data.remote.dto.items.ItemDetailsDtoOut
import com.jkgug.meli_juanc.domain.ProductDetails
import com.jkgug.meli_juanc.utils.NetworkResult
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class ItemDetailsRemoteMeliApi(
    private val meLiAPIItems: MeLiAPIItems,
    private val productDetailMapper: Mapper<ItemDetailsDtoOut, ProductDetails>,
) : ItemDetailsRemoteRepository {

    override suspend fun itemDetailsById(
        productId: String
    ): Flow<NetworkResult<Any?>> = flow {
        try {
            val response = meLiAPIItems.itemsById(productId)
            if (response.isSuccessful) {
                response.body()?.let {
                    emit(NetworkResult.Success(productDetailMapper.mapFrom(it)))
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

