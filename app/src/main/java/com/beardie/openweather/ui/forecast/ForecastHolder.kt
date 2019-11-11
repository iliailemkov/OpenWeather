package com.beardie.openweather.ui.forecast

import android.content.Context
import android.view.LayoutInflater
import androidx.recyclerview.widget.RecyclerView
import com.beardie.openweather.R
import com.beardie.openweather.models.WeatherInfo
import kotlinx.android.synthetic.main.forecast_item.view.*

class ForecastHolder(context: Context) : RecyclerView.ViewHolder(LayoutInflater.from(context).inflate(
    R.layout.forecast_item, null)) {

    fun bind(weather : WeatherInfo) {
        itemView.tv_min.text = weather.temp.toString()
    }
}