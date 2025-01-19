package com.jkgug.meli_juanc.data.remote.dto.search


import com.google.gson.annotations.SerializedName

data class PdpTracking(
    @SerializedName("group")
    val group: Boolean,
    @SerializedName("product_info")
    val productInfo: List<ProductInfo>
)