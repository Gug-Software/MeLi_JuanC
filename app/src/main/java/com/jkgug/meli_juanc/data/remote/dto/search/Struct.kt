package com.jkgug.meli_juanc.data.remote.dto.search


import com.google.gson.annotations.SerializedName

data class Struct(
    @SerializedName("number")
    val number: Double,
    @SerializedName("unit")
    val unit: String
)