package com.example.mytvbelozerovklim.data

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface OmdbApi {
    @GET("/")
    fun searchFilms(
        @Query("s") title: String,
        @Query("type") type: String,
        @Query("apikey") apiKey: String = "899009ce"
    ): Call<FilmResponse>
    @GET("/")
    fun getFilmDetail(
        @Query("i") imdbID: String,
        @Query("apikey") apiKey: String = "899009ce"
    ): Call<FilmDetail>
}