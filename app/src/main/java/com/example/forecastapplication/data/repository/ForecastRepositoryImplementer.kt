package com.example.forecastapplication.data.repository

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.lifecycle.LiveData
import com.example.forecastapplication.data.db.CurrentWeatherDao
import com.example.forecastapplication.data.db.unitlocalized.ImperialCurrentWeatherEntry
import com.example.forecastapplication.data.network.WeatherNetworkDataSource
import com.example.forecastapplication.data.network.response.CurrentWeatherResponce
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.time.ZonedDateTime
import java.util.*

class ForecastRepositoryImplementer(
    private val currentWeatherDao: CurrentWeatherDao,
    private val weatherNetworkDataSource: WeatherNetworkDataSource
) : ForecastRepository {

    init {
        weatherNetworkDataSource.downloadedCurrentWeather.observeForever { newCurrentWeather ->
            persistFetchedCurrentWeather(newCurrentWeather)
        }
    }

    override suspend fun getCurrentWeather(): LiveData<ImperialCurrentWeatherEntry> {
        initWeatherData()
        return withContext(Dispatchers.IO) {
            return@withContext currentWeatherDao.getWeather()
        }
    }

    private fun persistFetchedCurrentWeather(fetchedWeather: CurrentWeatherResponce) {
        GlobalScope.launch(Dispatchers.IO) {
            currentWeatherDao.upsert(fetchedWeather.current)

        }
    }

    private suspend fun initWeatherData() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            if (isFetchCurrentNeeded(ZonedDateTime.now().minusHours(1))) {
                return fetchCurrentWeather()
            }
        } else {
            return fetchCurrentWeather();
        }

    }

    private suspend fun fetchCurrentWeather() {
        weatherNetworkDataSource.fetchCurrentWeather(
            "Los Angeles",
            Locale.getDefault().language
        )
    }


    private fun isFetchCurrentNeeded(lastFetchTime: ZonedDateTime): Boolean {
        return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val thirtyMinutesAgo = ZonedDateTime.now().minusMinutes(30);
            lastFetchTime.isBefore(thirtyMinutesAgo)
        } else {
            return true;
        }

    }
}