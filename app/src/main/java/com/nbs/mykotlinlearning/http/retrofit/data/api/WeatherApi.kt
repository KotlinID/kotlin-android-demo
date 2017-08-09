package com.nbs.mykotlinlearning.http.retrofit.data.api

import com.nbs.mykotlinlearning.http.retrofit.data.model.WeatherResponse
import retrofit2.Call

/**
 * Created by sidiqpermana on 8/9/17.
 */
interface WeatherApi{
    fun getWeeklyForecast(city: String): Call<WeatherResponse>
}