package com.example.forecastapplication.data.db.unitlocalized

import com.google.gson.annotations.SerializedName

interface UnitSpecificCurrentWeatherEntry {
    val cloudcover: Double
    val feelslike: Double
    val humidity: Double
    val isDay: String
    val observationTime: String
    val precip: Double
    val pressure: Double
    val temperature: Double
    val uvIndex: Double
    val visibility: Double
    val weatherCode: Double
    val weatherDescriptions: List<String>
    val windDegree: Double
    val windDir: String
    val windSpeed: Double
}