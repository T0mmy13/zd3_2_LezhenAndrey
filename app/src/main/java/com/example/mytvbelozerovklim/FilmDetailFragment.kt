package com.example.mytvbelozerovklim.data

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.mytvbelozerovklim.R
import com.squareup.picasso.Picasso
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class FilmDetailFragment(private val filmId: String): Fragment() {

    private lateinit var filmTitle: TextView
    private lateinit var filmPoster: ImageView
    private lateinit var filmYear: TextView
    private lateinit var filmRated: TextView
    private lateinit var filmReleased: TextView
    private lateinit var filmRuntime: TextView
    private lateinit var filmGenre: TextView
    private lateinit var filmDirector: TextView
    private lateinit var filmActors: TextView
    private lateinit var filmPlot: TextView
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_film_detail, container, false)
        filmTitle = view.findViewById(R.id.film_title)
        filmPoster = view.findViewById(R.id.film_poster)
        filmYear = view.findViewById(R.id.film_year)
        filmRated = view.findViewById(R.id.film_rated)
        filmReleased = view.findViewById(R.id.film_released)
        filmRuntime = view.findViewById(R.id.film_runtime)
        filmGenre = view.findViewById(R.id.film_genre)
        filmDirector = view.findViewById(R.id.film_director)
        filmActors = view.findViewById(R.id.film_actors)
        filmPlot = view.findViewById(R.id.film_plot)
        getFilmDetails()
        return view
    }
    private fun getFilmDetails() {
        val api = RetrofitInstance.api
        api.getFilmDetail(filmId).enqueue(object : Callback<FilmDetail> {
            override fun onResponse(call: Call<FilmDetail>, response: Response<FilmDetail>) {
                if (response.isSuccessful){
                    val filmDetail = response.body()
                    if (filmDetail != null) {
                        updateUI(filmDetail)
                    }
                    else {
                        Log.d("MyLog", "Film detail not found")
                    }
                }
                else {
                    Log.d("MyLog", "Request failed: ${response.code()}")
                }
            }
            override fun onFailure(call: Call<FilmDetail>, t: Throwable) {
                Log.d("MyLog", "Error: " + t.message)
            }
        })
    }
    private fun updateUI(filmDetail: FilmDetail){
        filmTitle.text = filmDetail.Title
        Picasso.get().load(filmDetail.Poster).into(filmPoster)
        filmYear.text = "Год: ${filmDetail.Year}"
        filmRated.text = "Рейтинг: ${filmDetail.Rated}"
        filmReleased.text = "Релиз: ${filmDetail.Released}"
        filmRuntime.text = "Длительность: ${filmDetail.Runtime}"
        filmGenre.text = "Жанр: ${filmDetail.Genre}"
        filmDirector.text = "Режисер: ${filmDetail.Director}"
        filmActors.text = "Актеры: ${filmDetail.Actors}"
        filmPlot.text = "Сюжет: ${filmDetail.Plot}"
    }
}