package com.jkgug.meli_juanc.data.remote.dto.search


import com.google.gson.annotations.SerializedName

data class X179845806648(
    @SerializedName("attribute_combinations")
    val attributeCombinations: List<AttributeCombination>,
    @SerializedName("attributes")
    val attributes: List<Any?>,
    @SerializedName("name")
    val name: String,
    @SerializedName("pictures_qty")
    val picturesQty: Int,
    @SerializedName("price")
    val price: Int,
    @SerializedName("ratio")
    val ratio: String,
    @SerializedName("thumbnail")
    val thumbnail: String,
    @SerializedName("user_product_id")
    val userProductId: String
)