package com.jkgug.meli_juanc.data.remote.dto.items

import com.google.gson.annotations.SerializedName

data class Picture(
    @SerializedName("url")
    val url: String
)