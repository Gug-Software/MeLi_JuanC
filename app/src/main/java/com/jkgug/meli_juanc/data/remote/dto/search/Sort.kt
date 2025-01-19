package com.jkgug.meli_juanc.data.remote.dto.search


import com.google.gson.annotations.SerializedName

data class Sort(
    @SerializedName("id")
    val id: String,
    @SerializedName("name")
    val name: String
)