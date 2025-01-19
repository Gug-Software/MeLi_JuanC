package com.jkgug.meli_juanc.data.remote.dto.search


import com.google.gson.annotations.SerializedName

data class Conditions(
    @SerializedName("context_restrictions")
    val contextRestrictions: List<String>,
    @SerializedName("eligible")
    val eligible: Boolean,
    @SerializedName("end_time")
    val endTime: String?,
    @SerializedName("start_time")
    val startTime: String?
)