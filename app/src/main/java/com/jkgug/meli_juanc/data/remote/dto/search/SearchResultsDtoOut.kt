package com.jkgug.meli_juanc.data.remote.dto.search


import com.google.gson.annotations.SerializedName

data class SearchResultsDtoOut(
    @SerializedName("available_filters")
    val availableFilters: List<AvailableFilter>,
    @SerializedName("available_sorts")
    val availableSorts: List<AvailableSort>,
    @SerializedName("country_default_time_zone")
    val countryDefaultTimeZone: String,
    @SerializedName("filters")
    val filters: List<Any?>,
    @SerializedName("paging")
    val paging: Paging,
    @SerializedName("pdp_tracking")
    val pdpTracking: PdpTracking,
    @SerializedName("query")
    val query: String,
    @SerializedName("results")
    val results: List<Result>,
    @SerializedName("site_id")
    val siteId: String,
    @SerializedName("sort")
    val sort: Sort,
    @SerializedName("user_context")
    val userContext: Any?
)