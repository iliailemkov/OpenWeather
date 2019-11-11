package com.beardie.openweather.di.modules

import android.app.Application
import android.content.SharedPreferences
import android.preference.PreferenceManager
import com.beardie.openweather.repository.ForecastRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Module
class AppModule {
    @Provides
    @Singleton
    fun provideSharedPreference(app: Application): SharedPreferences =
        PreferenceManager.getDefaultSharedPreferences(app)

    @Singleton
    @Provides
    fun providePersonRepository() = ForecastRepository()
}