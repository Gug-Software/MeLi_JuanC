package com.jkgug.meli_juanc.data.remote.dto.items


import com.google.gson.annotations.SerializedName

data class Struct(
    @SerializedName("number")
    val number: Double,
    @SerializedName("unit")
    val unit: String
)