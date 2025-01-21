package com.jkgug.meli_juanc.data.remote.dto.items


import com.google.gson.annotations.SerializedName
import com.jkgug.meli_juanc.data.remote.dto.search.Shipping

data class ItemDetailsDtoOut(

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
    @SerializedName("shipping")
    val shipping: Shipping,
    @SerializedName("attributes")
    val attributes: List<Attribute>?,
    @SerializedName("variations")
    val variations: List<ItemDetailsVariations>?,
    @SerializedName("sale_terms")
    val saleTerms: List<SaleTerm>,
    @SerializedName("pictures")
    val pictures: List<Picture>,
)