package com.jkgug.meli_juanc.data.remote.dto.items


import com.google.gson.annotations.SerializedName

data class Value(
    @SerializedName("id")
    val id: String?,
    @SerializedName("name")
    val name: String,
    @SerializedName("struct")
    val struct: Struct?
)