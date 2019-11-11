package com.beardie.openweather.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class WeatherInfo (

    @SerializedName("temp")
    @Expose
    val temp: Float = 0.toFloat(),

    @SerializedName("pressure")
    @Expose
    val pressure: Float = 0.toFloat(),

    @SerializedName("humidity")
    @Expose
    val humidity: Float = 0.toFloat(),

    @SerializedName("temp_min")
    @Expose
    val tempMin: Float = 0.toFloat(),

    @SerializedName("temp_max")
    @Expose
    val tempMax: Float = 0.toFloat()
)