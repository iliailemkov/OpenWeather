package com.beardie.openweather.repository

import com.beardie.openweather.models.ResponseWeather
import com.beardie.openweather.remote.WeatherApi
import io.reactivex.Observable
import javax.inject.Inject

class ForecastRepository @Inject constructor(){
    fun getForecast16() : Observable<List<ResponseWeather>> =
        WeatherApi.create().getForecast16(524901, "4b1fcbdefbc27071b8d2b8e5f499dd1c").map { response -> response.forecasts }
}