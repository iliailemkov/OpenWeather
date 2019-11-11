package com.beardie.openweather.di.modules

import androidx.lifecycle.ViewModel
import com.beardie.openweather.di.ViewModelKey
import com.beardie.openweather.ui.forecast.ForecastViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
internal abstract class ViewModelModule {
    @Binds
    @IntoMap
    @ViewModelKey(ForecastViewModel::class)
    abstract fun bindForecastViewModel(viewModel: ForecastViewModel): ViewModel
}