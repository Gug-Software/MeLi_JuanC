package com.jkgug.meli_juanc.data.remote.dto.search

import com.google.gson.annotations.SerializedName

data class SearchResultsDtoOut(
    @SerializedName("results")
    val results: List<Result>
)