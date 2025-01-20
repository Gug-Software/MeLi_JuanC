package com.jkgug.meli_juanc.data.remote.dto.items


import com.google.gson.annotations.SerializedName

data class ItemDetailsVariations(
    @SerializedName("attribute_combinations")
    val attributeCombinations: List<AttributeCombination>,
    @SerializedName("catalog_product_id")
    val catalogProductId: Any?,
    @SerializedName("id")
    val id: Long,
    @SerializedName("picture_ids")
    val pictureIds: List<String>,
    @SerializedName("price")
    val price: Int,
    @SerializedName("sale_terms")
    val saleTerms: List<Any?>
)