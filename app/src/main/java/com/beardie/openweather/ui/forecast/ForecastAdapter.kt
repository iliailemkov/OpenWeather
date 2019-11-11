package com.beardie.openweather.ui.forecast

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.beardie.openweather.models.WeatherInfo

class ForecastAdapter : RecyclerView.Adapter<ForecastHolder>() {

    val items: ArrayList<WeatherInfo> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ForecastHolder(parent.context)

    override fun getItemCount() = items.size

    override fun onBindViewHolder(holder: ForecastHolder, position: Int) {
        holder.bind(items[position])
    }
}