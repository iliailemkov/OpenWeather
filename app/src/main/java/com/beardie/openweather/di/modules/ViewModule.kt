package com.beardie.openweather.di.modules

import com.beardie.openweather.MainActivity
import com.beardie.openweather.ui.forecast.ForecastFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ViewModule {

    @ContributesAndroidInjector
    abstract fun mainActivity(): MainActivity

    @ContributesAndroidInjector
    abstract fun forecastFragment(): ForecastFragment
}