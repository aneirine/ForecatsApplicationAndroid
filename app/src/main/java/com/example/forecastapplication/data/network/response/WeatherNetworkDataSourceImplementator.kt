package com.example.forecastapplication.data.network.response

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.forecastapplication.data.ApixuWeatherApiService
import com.example.forecastapplication.data.network.WeatherNetworkDataSource
import com.example.forecastapplication.internal.NoConnectivityExceptions

class WeatherNetworkDataSourceImplementator(
    private val apixuWeatherApiService: ApixuWeatherApiService
) : WeatherNetworkDataSource {

    private val _downloadedCurrentWeather = MutableLiveData<CurrentWeatherResponce>()
    override val downloadedCurrentWeather: LiveData<CurrentWeatherResponce>
        get() = _downloadedCurrentWeather

    override suspend fun fetchCurrentWeather(location: String, languageCode: String) {
        try {
            val fetchedCurrentWeather = apixuWeatherApiService
                .getCurrentWeather(location, languageCode)
                .await()
            _downloadedCurrentWeather.postValue(fetchedCurrentWeather)
        } catch (e: NoConnectivityExceptions) {
            Log.e("Connectivity", "No internet connection", e)
        }
    }
}