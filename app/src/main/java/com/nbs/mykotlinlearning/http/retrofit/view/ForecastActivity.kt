package com.nbs.mykotlinlearning.http.retrofit.view

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import com.nbs.mykotlinlearning.App
import com.nbs.mykotlinlearning.R
import com.nbs.mykotlinlearning.http.retrofit.data.api.ApiManager
import com.nbs.mykotlinlearning.http.retrofit.data.mapper.CityWeather
import kotlinx.android.synthetic.main.activity_forecast.*
import kotlinx.android.synthetic.main.activity_movie.*
import org.jetbrains.anko.toast
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers
import rx.subscriptions.CompositeSubscription
import javax.inject.Inject

class ForecastActivity : AppCompatActivity() {

    protected var subscriptions = CompositeSubscription()
    @Inject lateinit var apiManager: ApiManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forecast)

        supportActionBar?.apply {
            title = "Forecast"
            setDisplayHomeAsUpEnabled(true)
        }

        App.appComponent.inject(this)

        request()
    }

    override fun onResume() {
        super.onResume()
        subscriptions = CompositeSubscription()
    }

    override fun onPause() {
        super.onPause()
        subscriptions.clear()
    }

    private fun request() {
        val subscription = apiManager.getWeeklyForecast("Jakarta")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe( {
                    t: CityWeather? -> showData(t)
                }, {
                    t: Throwable? -> toast(t?.message.toString())
                })
        subscriptions.add(subscription)
    }

    private fun  showData(t: CityWeather?) {
        val temp = t?.weathers?: t?.weathers
        rvWeatherResult.setHasFixedSize(true)
        rvWeatherResult.layoutManager = LinearLayoutManager(this)
        rvWeatherResult.addItemDecoration(DividerItemDecoration(this, DividerItemDecoration.VERTICAL))
        rvWeatherResult.adapter = WeatherAdapter(this, temp?: throw Exception("empty list"))
    }
}
