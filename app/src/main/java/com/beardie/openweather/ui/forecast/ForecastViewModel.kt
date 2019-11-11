package com.beardie.openweather.ui.forecast

import androidx.lifecycle.ViewModel
import com.beardie.openweather.repository.ForecastRepository
import javax.inject.Inject

class ForecastViewModel @Inject constructor(
    private var forecastRepository: ForecastRepository
) : ViewModel() {
    fun getForecast() = forecastRepository.getForecast16()
}