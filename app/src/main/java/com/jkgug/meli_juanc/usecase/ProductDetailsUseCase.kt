package com.jkgug.meli_juanc.usecase

import com.jkgug.meli_juanc.data.mapper.Mapper
import com.jkgug.meli_juanc.data.remote.dto.items.ItemDetailsDtoOut
import com.jkgug.meli_juanc.domain.ProductDetails
import com.jkgug.meli_juanc.repository.item.ItemDetailsRemoteRepository
import com.jkgug.meli_juanc.utils.NetworkResult
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.withContext

interface ProductDetailsUseCase {

    suspend operator fun invoke(productId: String): Flow<NetworkResult<Any?>>

}

class ProductDetailsUseCaseImpl(
    private val itemDetailsRemoteRepository: ItemDetailsRemoteRepository,
    private val productDetailMapper: Mapper<ItemDetailsDtoOut, ProductDetails>,
    private val defaultDispatcher: CoroutineDispatcher = Dispatchers.Default
) : ProductDetailsUseCase {

    override suspend fun invoke(
        productId: String
    ): Flow<NetworkResult<Any?>> = withContext(defaultDispatcher) {
        itemDetailsRemoteRepository.itemDetailsById(productId).map { networkResult ->
            val resultSearch = networkResult.data as ItemDetailsDtoOut
            NetworkResult.Success(productDetailMapper.mapFrom(resultSearch))
        }
    }

}