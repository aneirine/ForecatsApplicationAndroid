package com.example.forecastapplication.data.repository

import androidx.lifecycle.LiveData
import com.example.forecastapplication.data.db.CurrentWeatherDao
import com.example.forecastapplication.data.db.unitlocalized.ImperialCurrentWeatherEntry
import com.example.forecastapplication.data.network.WeatherNetworkDataSource
import com.example.forecastapplication.data.network.response.CurrentWeatherResponce
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class ForecastRepositoryImplementer(
    private val currentWeatherDao: CurrentWeatherDao,
    private val weatherNetworkDataSource: WeatherNetworkDataSource
) : ForecastRepository {

    init {
        weatherNetworkDataSource.downloadedCurrentWeather.observeForever { newCurrentWeather ->
        }
    }

    override suspend fun getCurrentWeather(metric: Boolean): LiveData<ImperialCurrentWeatherEntry> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    private fun persistFetchedCurrentWeather(fetchedWeather: CurrentWeatherResponce) {
        GlobalScope.launch {
            
        }
    }
}