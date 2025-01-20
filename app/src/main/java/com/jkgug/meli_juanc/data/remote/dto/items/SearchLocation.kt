package com.jkgug.meli_juanc.data.remote.dto.items


import com.google.gson.annotations.SerializedName

data class SearchLocation(
    @SerializedName("city")
    val city: City,
    @SerializedName("neighborhood")
    val neighborhood: Neighborhood,
    @SerializedName("state")
    val state: StateX
)