package com.nbs.mykotlinlearning.basic

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.nbs.mykotlinlearning.R
import kotlinx.android.synthetic.main.activity_give_back.*

class GiveBackActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_give_back)

        btnSendBackData.setOnClickListener {
            val intent = Intent().putExtra("name", "Arkeenan Farsheed Jusuf Nouvrizky")
            setResult(100, intent)
            finish()
        }
    }
}
