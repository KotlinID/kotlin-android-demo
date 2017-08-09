package com.nbs.mykotlinlearning.basic

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.nbs.mykotlinlearning.R
import kotlinx.android.synthetic.main.activity_parcelable_receiver.*

class ParcelableReceiverActivity : AppCompatActivity() {

    companion object {
        val BOOK = "book"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_parcelable_receiver)

        val book: Book = intent.getParcelableExtra(BOOK)
        with(book){
            val text = "$title was written by $author on $year"
            tvParcelableObject.text = text
        }
    }
}
