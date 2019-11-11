package com.beardie.openweather.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName


@Entity
data class ResponseWeather(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val coordinates: Coordinates,
    val weather: List<Weather>,
    val base: String,
    val main: WeatherInfo,
    val visibility: Int,
    //val wind: Wind,
    //val clouds: Clouds,
    @SerializedName("dt")
    val updateTime: Int,
    //@SerializedName("sys")
    //val sunsetAndSunrise: SunsetAndSunrise,
    @SerializedName("name")
    val name: String,
    val cod: Int)