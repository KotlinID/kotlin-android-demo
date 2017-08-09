package com.nbs.mykotlinlearning.viewgroup

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import com.nbs.mykotlinlearning.R
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_movie.*

class DetilMovieActivity : AppCompatActivity() {

    companion object {
        val KEY_MOVIE = "movie"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detil_movie)

        supportActionBar?.apply {
            title = "Detail Movie"
            setDisplayHomeAsUpEnabled(true)
        }

        val movie: Movie = intent.getParcelableExtra(KEY_MOVIE)
        with(movie){
            val text = "$name - $year"
            tvTitle.setText(text)
            Picasso.with(baseContext).load(imageUrl).into(imgMovie)
        }
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        if(item?.itemId == android.R.id.home)finish()
        return super.onOptionsItemSelected(item)
    }
}
