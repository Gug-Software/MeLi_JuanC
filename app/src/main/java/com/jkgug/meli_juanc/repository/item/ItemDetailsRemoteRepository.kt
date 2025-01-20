package com.jkgug.meli_juanc.repository.item

import com.jkgug.meli_juanc.utils.NetworkResult
import kotlinx.coroutines.flow.Flow

interface ItemDetailsRemoteRepository {

    /**
     * Get item details by remote
     *
     * @param productId productId of product to consult
     */
    suspend fun itemDetailsById(
        productId: String,
    ): Flow<NetworkResult<Any?>>

}