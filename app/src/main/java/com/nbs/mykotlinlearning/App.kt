package com.nbs.mykotlinlearning

import android.app.Application
import com.nbs.mykotlinlearning.http.retrofit.di.AppComponent
import com.nbs.mykotlinlearning.http.retrofit.di.AppModule
import com.nbs.mykotlinlearning.http.retrofit.di.DaggerAppComponent

/**
 * Created by sidiqpermana on 8/9/17.
 */
class App: Application() {
    companion object {
        lateinit var appComponent: AppComponent
    }

    override fun onCreate() {
        super.onCreate()

        appComponent = DaggerAppComponent.builder().appModule(AppModule(this)).build()

    }
}