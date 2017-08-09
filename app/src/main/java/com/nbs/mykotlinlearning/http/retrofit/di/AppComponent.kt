package com.nbs.mykotlinlearning.http.retrofit.di

import com.nbs.mykotlinlearning.http.retrofit.view.ForecastActivity
import dagger.Component
import javax.inject.Singleton

/**
 * Created by sidiqpermana on 8/9/17.
 */
@Singleton
@Component(modules = arrayOf(AppModule::class,
        NetworkModule::class,
        WeatherModule::class))
interface AppComponent{
    fun inject(forecastActivity: ForecastActivity)
}