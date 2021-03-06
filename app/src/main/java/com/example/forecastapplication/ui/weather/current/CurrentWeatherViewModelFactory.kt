package com.example.forecastapplication.ui.weather.current

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.forecastapplication.data.repository.ForecastRepository
import com.example.forecastapplication.data.repository.ForecastRepositoryImplementer

class CurrentWeatherViewModelFactory(
    private val forecastRepository: ForecastRepository
) : ViewModelProvider.NewInstanceFactory() {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return CurrentWeatherViewModel(forecastRepository) as T
    }
}