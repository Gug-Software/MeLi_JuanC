package com.jkgug.meli_juanc.data.remote.dto.search


import com.google.gson.annotations.SerializedName

data class MetadataX(
    @SerializedName("promotion_id")
    val promotionId: String?,
    @SerializedName("promotion_type")
    val promotionType: String?
)