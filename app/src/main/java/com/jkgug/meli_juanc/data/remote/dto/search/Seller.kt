package com.jkgug.meli_juanc.data.remote.dto.search


import com.google.gson.annotations.SerializedName

data class Seller(
    @SerializedName("id")
    val id: Double,
    @SerializedName("nickname")
    val nickname: String
)