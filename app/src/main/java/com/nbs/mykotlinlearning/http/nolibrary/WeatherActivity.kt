package com.nbs.mykotlinlearning.http.nolibrary

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.TextView
import com.nbs.mykotlinlearning.R
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.find
import org.jetbrains.anko.uiThread
import java.net.URL

class WeatherActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_weather)

        val tvResult = find<TextView>(R.id.tvResult)

        supportActionBar?.apply {
            title = "Simple Network"
            setDisplayHomeAsUpEnabled(true)
        }

        val apiUrl = "http://api.openweathermap.org/data/2.5/weather?q=Jakarta&appid=694e890a8ba8a09429fadd5361f4a163"

        doAsync {
            val result = URL(apiUrl).readText()
            uiThread {
                tvResult.text = result
            }
        }

    }
}
