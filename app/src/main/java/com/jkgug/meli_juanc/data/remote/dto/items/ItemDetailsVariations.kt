package com.jkgug.meli_juanc.data.remote.dto.items

import com.google.gson.annotations.SerializedName

data class ItemDetailsVariations(
    @SerializedName("attribute_combinations")
    val attributeCombinations: List<AttributeCombination>,
)