package com.jkgug.meli_juanc.data.remote.dto.search


import com.google.gson.annotations.SerializedName

data class X181239398344(
    @SerializedName("attribute_combinations")
    val attributeCombinations: List<AttributeCombination>,
    @SerializedName("attributes")
    val attributes: List<AttributeX>,
    @SerializedName("name")
    val name: String,
    @SerializedName("pictures_qty")
    val picturesQty: Int,
    @SerializedName("price")
    val price: Int,
    @SerializedName("ratio")
    val ratio: String,
    @SerializedName("thumbnail")
    val thumbnail: String
)