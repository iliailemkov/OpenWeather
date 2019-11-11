package com.beardie.openweather.remote

import com.beardie.openweather.remote.models.PlaceDetailsResponse
import com.beardie.openweather.remote.models.PlacesResponse
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query


interface PlacesApi {

    @GET("place/autocomplete/json")
    fun getPlaces(
        @Query("input") input: String,
        @Query("key") apiKey: String
    ): Observable<PlacesResponse>

    @GET("place/details/json")
    fun getPlaceDetailsById(
        @Query("placeid") placeId: String,
        @Query("key") apiKey: String
    ): Observable<PlaceDetailsResponse>

    @GET("geocode/json")
    fun getPlaceDetailsByCoords(
        @Query("latlng") latlng: String,
        @Query("language") lang: String,
        @Query("key") apiKey: String
    ): Observable<PlaceDetailsResponse>

    companion object {
        const val BASE_URL = "https://maps.googleapis.com/maps/api/"
    }
}