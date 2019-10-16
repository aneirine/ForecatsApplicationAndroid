package com.example.forecastapplication.data.network

import androidx.lifecycle.LiveData
import com.example.forecastapplication.data.network.response.CurrentWeatherResponce

interface WeatherNetworkDataSource {
    val downloadedCurrentWeather: LiveData<CurrentWeatherResponce>

    suspend fun fetchCurrentWeather(
        location: String,
        languageCode: String
    ) {

    }
}