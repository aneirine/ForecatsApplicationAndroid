package com.example.forecastapplication.data.db.unitlocalized

import com.google.gson.annotations.SerializedName

interface UnitSpecificCurrentWeatherEntry {
    val cloudCover: Double
    val feelsLike: Double
    val humidity: Double
    val isDay: String
    val observationTime: String
    val precipitation: Double
    val pressure: Double
    val temperature: Double
    val uvIndex: Double
    val visibility: Double
    val weatherCode: Double
    val windDegree: Double
    val windDirection: String
    val windSpeed: Double
}