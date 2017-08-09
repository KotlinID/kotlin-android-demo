package com.nbs.mykotlinlearning.viewgroup

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.GridLayoutManager
import android.view.MenuItem
import com.nbs.mykotlinlearning.R
import com.nbs.mykotlinlearning.viewgroup.adapter.MovieAdapter
import kotlinx.android.synthetic.main.activity_movie.*
import org.jetbrains.anko.intentFor
import org.jetbrains.anko.toast

class MovieActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie)

        supportActionBar?.title = "Movie"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val list = ArrayList<Movie>()
        val jurassicWorld = Movie("Jurassic Word", "https://images-na.ssl-images-amazon.com/images/I/817O-vUusjL._SY550_.jpg", 2016)
        val spiderman = Movie("Spiderman Home Coming", "http://www.joblo.com/posters/images/full/Spiderman-poster-6-large.jpg", 2017)
        val transformers = Movie("Transformers: The Last Knight", "http://cdn1-www.superherohype.com/assets/uploads/gallery/transformers-the-last-knight-official-gallery/tf5ovbb-1.jpg", 2017)
        val minions = Movie("Minions", "http://www.impawards.com/2015/posters/minions.jpg", 2016)
        val ironman3 = Movie("Iron Man 3", "http://www.impawards.com/2013/posters/iron_man_three_ver9_xlg.jpg", 2015)
        val avengers = Movie("Avengers Infinity War", "https://s-media-cache-ak0.pinimg.com/originals/73/01/7e/73017e5afd926224e37c12bcf626baca.jpg", 2018)

        list.add(jurassicWorld)
        list.add(spiderman)
        list.add(transformers)
        list.add(minions)
        list.add(ironman3)
        list.add(avengers)

        rvItems.setHasFixedSize(true)
        rvItems.layoutManager = GridLayoutManager(this, 2)
        rvItems.addItemDecoration(DividerItemDecoration(this, DividerItemDecoration.VERTICAL))
        rvItems.addItemDecoration(DividerItemDecoration(this, DividerItemDecoration.HORIZONTAL))

        rvItems.adapter = MovieAdapter(list){
            with(it){
                val text = "$name on $year"
                startActivity(intentFor<DetilMovieActivity>(DetilMovieActivity.KEY_MOVIE to it))
            }
        }
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        if (item?.itemId == android.R.id.home)finish()
        return super.onOptionsItemSelected(item)
    }
}
