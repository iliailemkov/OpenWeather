package com.beardie.openweather.remote

import com.beardie.openweather.models.ResponseForecast5
import com.beardie.openweather.models.ResponseWeather
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import io.reactivex.Observable
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query
import java.util.concurrent.Executors
import java.util.concurrent.TimeUnit

interface WeatherApi {

    @GET("weather")
    fun getWeather(
        @Query("lat") lat: Double,
        @Query("lon") lon: Double,
        @Query("appid") apiKey: String
    ): Observable<ResponseWeather>

    @GET("forecast")
    fun getForecast16(
        @Query("id") id: Int,
        @Query("appid") apiKey: String
    ): Observable<ResponseForecast5>

    companion object {
        val base_url = "http://api.openweathermap.org/data/2.5/"
        val days = 16

        private val gson: Gson
            get() = GsonBuilder().setLenient().create()

        fun create(): WeatherApi {

            val retrofit = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .callbackExecutor(Executors.newSingleThreadExecutor())
                .client(
                    OkHttpClient.Builder()
                        .connectTimeout(60, TimeUnit.SECONDS).build()
                )
                .baseUrl(base_url)
                .build()

            return retrofit.create(WeatherApi::class.java)
        }
    }
}