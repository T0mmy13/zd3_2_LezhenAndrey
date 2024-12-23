package com.example.mytvbelozerovklim.data

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.mytvbelozerovklim.R
import com.squareup.picasso.Picasso

class FilmAdapter(private val films: List<FilmOmdb>) : RecyclerView.Adapter<FilmAdapter.FilmViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FilmViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.film_item, parent, false)
        return FilmViewHolder(view)
    }
    override fun onBindViewHolder(holder: FilmViewHolder, position: Int) {
        val film = films[position]
        holder.filmTitle.text = film.Title
        Picasso.get().load(film.Poster).into(holder.filmImage)
        holder.itemView.setOnClickListener {
            val fragment = FilmDetailFragment(film.imdbID)
            val transaction = (holder.itemView.context as AppCompatActivity).supportFragmentManager.beginTransaction()
            transaction.setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out)
            transaction.addToBackStack(null)
            transaction.add(R.id.fragment_container,fragment)
            transaction.commit()
        }
    }
    override fun getItemCount(): Int = films.size
    class FilmViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val filmTitle: TextView = itemView.findViewById(R.id.film_title)
        val filmImage: ImageView = itemView.findViewById(R.id.film_image)
    }
}