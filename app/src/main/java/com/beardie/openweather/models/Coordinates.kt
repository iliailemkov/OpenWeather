package com.beardie.openweather.models

import com.google.gson.annotations.SerializedName


data class Coordinates(
    @SerializedName("long")
    val longitude: Double,
    @SerializedName("lat")
    val latitude: Double
)