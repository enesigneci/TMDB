package com.enesigneci.tmdb.network

import com.enesigneci.tmdb.network.model.SearchResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface TMDBService {
    @GET("/3/search/movie")
    fun searchInAPI(@Query("api_key") apiKey: String = "6fe1e307f82cb96da47b28c679473a2d", @Query("query") searchTerm: String, @Query("page") page: Int = 1): Call<SearchResponse>
}