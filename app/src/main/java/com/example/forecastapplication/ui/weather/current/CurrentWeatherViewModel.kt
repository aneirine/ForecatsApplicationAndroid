package com.example.forecastapplication.ui.weather.current

import androidx.lifecycle.ViewModel
import com.example.forecastapplication.data.repository.ForecastRepository
import com.example.forecastapplication.internal.lazyDeffered

class CurrentWeatherViewModel(
    private val forecastRepository: ForecastRepository
) : ViewModel() {

    val weather by lazyDeffered {
        forecastRepository.getCurrentWeather()
    }


}
