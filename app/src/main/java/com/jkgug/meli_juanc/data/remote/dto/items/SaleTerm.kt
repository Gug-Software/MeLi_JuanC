package com.jkgug.meli_juanc.data.remote.dto.items


import com.google.gson.annotations.SerializedName

data class SaleTerm(
    @SerializedName("id")
    val id: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("value_id")
    val valueId: String?,
    @SerializedName("value_name")
    val valueName: String,
    @SerializedName("value_struct")
    val valueStruct: ValueStruct?,
    @SerializedName("value_type")
    val valueType: String,
    @SerializedName("values")
    val values: List<ValueX>
)