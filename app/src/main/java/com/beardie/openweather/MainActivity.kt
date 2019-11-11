package com.beardie.openweather

import android.os.Bundle
import com.beardie.openweather.ui.forecast.ForecastFragment
import dagger.android.support.DaggerAppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : DaggerAppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportFragmentManager.beginTransaction().replace(root.id, ForecastFragment()).commit()
    }
}