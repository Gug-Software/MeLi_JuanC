package com.jkgug.meli_juanc.data.remote.dto.items

import com.google.gson.annotations.SerializedName

data class AttributeCombination(
    @SerializedName("name")
    val name: String,
    @SerializedName("value_name")
    val valueName: String,
)