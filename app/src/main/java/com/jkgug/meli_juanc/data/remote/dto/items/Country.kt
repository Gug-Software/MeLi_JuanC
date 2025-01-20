package com.jkgug.meli_juanc.data.remote.dto.items


import com.google.gson.annotations.SerializedName

data class Country(
    @SerializedName("id")
    val id: String,
    @SerializedName("name")
    val name: String
)