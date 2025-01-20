package com.jkgug.meli_juanc.data.remote.api.items

import com.jkgug.meli_juanc.data.remote.dto.items.ItemDetailsDtoOut
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

const val MELI_ITEMS_ENDPOINT = "items/{productId}"
const val PRODUCT_ID = "productId"

interface MeLiAPIItems {

    @GET(MELI_ITEMS_ENDPOINT)
    suspend fun itemsById(
        @Path(PRODUCT_ID) productId: String,
    ): Response<ItemDetailsDtoOut>
}