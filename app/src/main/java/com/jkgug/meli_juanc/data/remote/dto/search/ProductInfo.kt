package com.jkgug.meli_juanc.data.remote.dto.search


import com.google.gson.annotations.SerializedName

data class ProductInfo(
    @SerializedName("id")
    val id: String,
    @SerializedName("score")
    val score: Int,
    @SerializedName("status")
    val status: String
)