package com.example.mytvbelozerovklim.data

data class FilmResponse(
    val Search: List<FilmOmdb>?,
    val totalResults: String?,
    val Response: String,
    val Error: String?
)