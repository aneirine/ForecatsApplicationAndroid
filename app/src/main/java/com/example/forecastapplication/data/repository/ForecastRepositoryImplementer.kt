package com.example.forecastapplication.data.repository

import androidx.lifecycle.LiveData
import com.example.forecastapplication.data.db.CurrentWeatherDao
import com.example.forecastapplication.data.db.unitlocalized.ImperialCurrentWeatherEntry
import com.example.forecastapplication.data.network.WeatherNetworkDataSource

class ForecastRepositoryImplementer (
    private val currentWeatherDao: CurrentWeatherDao,
    private val weatherNetworkDataSource: WeatherNetworkDataSource
): ForecastRepository {
    override suspend fun getCurrentWeather(metric: Boolean): LiveData<ImperialCurrentWeatherEntry> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}