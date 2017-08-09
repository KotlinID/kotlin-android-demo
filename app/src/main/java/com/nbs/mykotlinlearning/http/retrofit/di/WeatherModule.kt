package com.nbs.mykotlinlearning.http.retrofit.di

import com.nbs.mykotlinlearning.http.retrofit.data.api.OpenWeatherMapApiClient
import com.nbs.mykotlinlearning.http.retrofit.data.api.WeatherApi
import com.nbs.mykotlinlearning.http.retrofit.data.api.WeatherRestApi
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import javax.inject.Singleton

/**
 * Created by sidiqpermana on 8/9/17.
 */
@Module
class WeatherModule{
    @Provides
    @Singleton
    fun provideWeatherApi(openWeatherMapApiClient: OpenWeatherMapApiClient): WeatherApi = WeatherRestApi(openWeatherMapApiClient)

    @Provides
    @Singleton
    fun provideOpenWeatherApiClient(retrofit: Retrofit) = retrofit.create(OpenWeatherMapApiClient::class.java)
}