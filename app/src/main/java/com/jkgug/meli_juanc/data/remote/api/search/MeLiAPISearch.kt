package com.jkgug.meli_juanc.data.remote.api.search

import com.jkgug.meli_juanc.data.remote.dto.search.SearchResultsDtoOut
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

const val MELI_SEARCH_ENDPOINT = "sites/MCO/search"

interface MeLiAPISearch {

    @GET(MELI_SEARCH_ENDPOINT)
    suspend fun search(
        @Query("q") searchKye: String,
    ): Response<SearchResultsDtoOut>
}