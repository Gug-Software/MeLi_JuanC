package com.jkgug.meli_juanc.data.remote.dto.search


import com.google.gson.annotations.SerializedName

data class Installments(
    @SerializedName("amount")
    val amount: Double,
    @SerializedName("currency_id")
    val currencyId: String,
    @SerializedName("metadata")
    val metadata: Metadata,
    @SerializedName("quantity")
    val quantity: Int,
    @SerializedName("rate")
    val rate: Int
)