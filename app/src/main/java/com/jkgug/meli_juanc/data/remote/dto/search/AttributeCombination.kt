package com.jkgug.meli_juanc.data.remote.dto.search


import com.google.gson.annotations.SerializedName

data class AttributeCombination(
    @SerializedName("id")
    val id: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("value_id")
    val valueId: Any?,
    @SerializedName("value_name")
    val valueName: String,
    @SerializedName("value_struct")
    val valueStruct: Any?,
    @SerializedName("values")
    val values: Any?
)