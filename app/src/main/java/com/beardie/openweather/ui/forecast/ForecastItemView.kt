package com.beardie.openweather.ui.forecast

import android.content.Context
import android.widget.LinearLayout
import android.widget.TextView

class ForecastItemView(context: Context) : LinearLayout(context) {
    val title: TextView = TextView(context)
    val average: TextView = TextView(context)
    val max: TextView = TextView(context)
    val min: TextView = TextView(context)
}