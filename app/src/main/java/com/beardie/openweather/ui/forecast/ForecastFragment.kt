package com.beardie.openweather.ui.forecast

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.beardie.openweather.R
import com.beardie.openweather.di.ViewModelFactory
import com.beardie.openweather.models.ResponseWeather
import dagger.android.support.DaggerFragment
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.functions.Consumer
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.forecasts.*
import javax.inject.Inject


class ForecastFragment : DaggerFragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    private lateinit var viewModel: ForecastViewModel

    private var forecastAdapter: ForecastAdapter? = null

    private var disposable: Disposable? = null

    var forecasts: Consumer<List<ResponseWeather>> = Consumer { items ->
        run {
            forecastAdapter?.items!!.clear()
            forecastAdapter?.items!!.addAll(items.map { i -> i.main })
        }
    }

    var error: Consumer<Throwable> = Consumer {
        tv_empty_text.visibility = View.VISIBLE
        rv_forecast_list.visibility = View.GONE
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        viewModel = ViewModelProviders.of(this, viewModelFactory).get(ForecastViewModel::class.java)
        return inflater.inflate(R.layout.forecasts, container, false)
    }

    override fun onResume() {
        super.onResume()
        if (forecastAdapter == null)
            forecastAdapter = ForecastAdapter()
        rv_forecast_list.adapter = forecastAdapter
        rv_forecast_list.layoutManager = LinearLayoutManager(context)
        disposable = viewModel.getForecast().subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread()).subscribe(forecasts, error)
    }

    override fun onPause() {
        super.onPause()
        disposable?.dispose()
    }
}