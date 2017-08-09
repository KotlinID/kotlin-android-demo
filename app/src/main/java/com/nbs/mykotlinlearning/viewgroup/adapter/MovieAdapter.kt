package com.nbs.mykotlinlearning.viewgroup.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.nbs.mykotlinlearning.R
import com.nbs.mykotlinlearning.viewgroup.Movie
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_movie.view.*

/**
 * Created by sidiqpermana on 8/5/17.
 */
class MovieAdapter(val items: ArrayList<Movie>, val onItemClickListener: (Movie) -> Unit): RecyclerView.Adapter<MovieAdapter.MovieViewHolder>() {

    override fun onBindViewHolder(holder: MovieViewHolder?, position: Int) {
        holder?.bindData(items[position])
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): MovieViewHolder {
        val view = LayoutInflater.from(parent?.context).inflate(R.layout.item_movie, parent, false)
        return MovieViewHolder(onItemClickListener, view)
    }

    override fun getItemCount(): Int {
        return items.size
    }


    class MovieViewHolder(val onItemClickListener: (Movie)->Unit, itemView: View?): RecyclerView.ViewHolder(itemView) {
        fun bindData(movie: Movie){
            with(movie){
                Picasso.with(itemView.context).load(imageUrl).into(itemView.imgMovie)
                val text = "$name on $year"
                itemView.tvTitle.text = text
                itemView.imgMovie.setOnClickListener { onItemClickListener.invoke(movie) }
            }
        }
    }
}

