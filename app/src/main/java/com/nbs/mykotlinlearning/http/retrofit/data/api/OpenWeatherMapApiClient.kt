package com.nbs.mykotlinlearning.http.retrofit.data.api

import com.nbs.mykotlinlearning.http.retrofit.data.model.WeatherResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by sidiqpermana on 8/9/17.
 */
interface OpenWeatherMapApiClient {
    @GET("forecast/daily")
    fun getWeeklyForecast(@Query("q") city: String, @Query("appid") appId: String): Call<WeatherResponse>
}