package com.jkgug.meli_juanc.data.remote.dto.search


import com.google.gson.annotations.SerializedName

data class Result(
    @SerializedName("id")
    val id: String,
    @SerializedName("title")
    val title: String,
    @SerializedName("thumbnail")
    val thumbnail: String,
    @SerializedName("price")
    val price: Double,
    @SerializedName("original_price")
    val originalPrice: Double?,
    @SerializedName("installments")
    val installments: Installments?,
    @SerializedName("shipping")
    val shipping: Shipping,
)