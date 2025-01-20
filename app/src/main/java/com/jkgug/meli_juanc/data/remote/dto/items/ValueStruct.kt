package com.jkgug.meli_juanc.data.remote.dto.items


import com.google.gson.annotations.SerializedName

data class ValueStruct(
    @SerializedName("number")
    val number: Int,
    @SerializedName("unit")
    val unit: String
)