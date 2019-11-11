package com.beardie.openweather.location

import android.Manifest.permission.ACCESS_COARSE_LOCATION
import android.Manifest.permission.ACCESS_FINE_LOCATION
import android.content.res.Resources
import android.location.Location
import android.location.LocationListener
import android.location.LocationManager
import android.os.Bundle
import androidx.annotation.RequiresPermission
import com.google.android.gms.maps.model.LatLng
import io.reactivex.SingleEmitter


class LocationProvider(private val locationManager: LocationManager) : LocationListener {
    private var emitter: SingleEmitter<LatLng>? = null

    @RequiresPermission(anyOf = [ACCESS_COARSE_LOCATION, ACCESS_FINE_LOCATION])
    fun getLastKnownLocation(emitter: SingleEmitter<LatLng>?): Location? {
        this.emitter = emitter
        var location: Location? = null
        val isGPSEnabled = locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER)

        // getting network status
        val isNetworkEnabled = locationManager.isProviderEnabled(LocationManager.NETWORK_PROVIDER)

        if (isNetworkEnabled) {
            try {
                locationManager.requestLocationUpdates(
                    LocationManager.NETWORK_PROVIDER,
                    MIN_TIME_BW_UPDATES,
                    MIN_DISTANCE_CHANGE_FOR_UPDATES.toFloat(), this
                )
                location = locationManager.getLastKnownLocation(LocationManager.NETWORK_PROVIDER)
            } catch (e: Exception) {


            }

        }

        if (isGPSEnabled) {
            try {
                if (location == null) {
                    locationManager.requestLocationUpdates(
                        LocationManager.GPS_PROVIDER,
                        MIN_TIME_BW_UPDATES,
                        MIN_DISTANCE_CHANGE_FOR_UPDATES.toFloat(), this
                    )
                    location = locationManager
                        .getLastKnownLocation(LocationManager.GPS_PROVIDER)
                }

            } catch (e: Exception) {
                emitter?.onError(Resources.NotFoundException(GPS_DISABLED))
            }

        } else emitter?.onError(Resources.NotFoundException(GPS_DISABLED))
        val providers = locationManager.getProviders(true)
        for (provider in providers) {
            val l = locationManager.getLastKnownLocation(provider) ?: continue
            if (location == null || l.accuracy < location.accuracy) {
                location = l
            }
        }
        if (location != null) {
            emitter!!.onSuccess(LatLng(location.latitude, location.longitude))
        }
        return location
    }

    override fun onLocationChanged(location: Location) {
        if (emitter != null) {
            emitter!!.onSuccess(LatLng(location.latitude, location.longitude))
            locationManager.removeUpdates(this)
        }
        emitter = null
    }

    override fun onStatusChanged(s: String, i: Int, bundle: Bundle) {
    }

    override fun onProviderEnabled(s: String) {
    }

    override fun onProviderDisabled(s: String) {
    }

    companion object {
        const val GPS_DISABLED = "Gps disabled"
        private const val MIN_TIME_BW_UPDATES: Long = 7000
        private const val MIN_DISTANCE_CHANGE_FOR_UPDATES = 1
    }
}