package com.jkgug.meli_juanc.data.remote.dto.search


import com.google.gson.annotations.SerializedName

data class Shipping(
    @SerializedName("free_shipping")
    val freeShipping: Boolean
)