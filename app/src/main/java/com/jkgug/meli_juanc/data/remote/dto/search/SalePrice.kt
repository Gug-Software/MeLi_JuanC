package com.jkgug.meli_juanc.data.remote.dto.search


import com.google.gson.annotations.SerializedName

data class SalePrice(
    @SerializedName("amount")
    val amount: Double,
    @SerializedName("conditions")
    val conditions: Conditions,
    @SerializedName("currency_id")
    val currencyId: String,
    @SerializedName("exchange_rate")
    val exchangeRate: Any?,
    @SerializedName("metadata")
    val metadata: MetadataX?,
    @SerializedName("payment_method_prices")
    val paymentMethodPrices: List<Any?>,
    @SerializedName("payment_method_type")
    val paymentMethodType: String,
    @SerializedName("price_id")
    val priceId: String,
    @SerializedName("type")
    val type: String
)