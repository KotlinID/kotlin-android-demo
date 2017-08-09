package com.nbs.mykotlinlearning.http.retrofit.di

import android.app.Application
import android.content.Context
import com.nbs.mykotlinlearning.App
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by sidiqpermana on 8/9/17.
 */
@Module
class AppModule(val app: App) {
    @Provides
    @Singleton
    fun provideContext(): Context = app

    @Provides
    @Singleton
    fun provideApplication(): Application = app
}