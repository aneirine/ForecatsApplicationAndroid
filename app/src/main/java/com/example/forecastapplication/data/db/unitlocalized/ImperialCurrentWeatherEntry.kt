package com.example.forecastapplication.data.db.unitlocalized

import androidx.room.ColumnInfo

class ImperialCurrentWeatherEntry(
    @ColumnInfo(name = "humidity")
    val humidity: Double,
    @ColumnInfo(name = "isDay")
    val isDay: String,
    @ColumnInfo(name = "observationTime")
    val observationTime: String,
    @ColumnInfo(name = "pressure")
    val pressure: Double,
    @ColumnInfo(name = "temperature")
    val temperature: Double,
    @ColumnInfo(name = "uvIndex")
    val uvIndex: Double,
    @ColumnInfo(name = "visibility")
    val visibility: Double,
    @ColumnInfo(name = "weatherCode")
    val weatherCode: Double,
    @ColumnInfo(name = "windDegree")
    val windDegree: Double,
    @ColumnInfo(name = "windSpeed")
    val windSpeed: Double,
    @ColumnInfo(name = "cloudcover")
    val cloudCover: Double,
    @ColumnInfo(name = "feelslike")
    val feelsLike: Double,
    @ColumnInfo(name = "precip")
    val precipitation: Double,
    @ColumnInfo(name = "windDir")
    val windDirection: String
)