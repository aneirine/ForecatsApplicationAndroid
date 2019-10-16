package com.example.forecastapplication.data.network.response


import com.example.forecastapplication.data.db.entity.CurrentWeatherEntry
import com.example.forecastapplication.data.db.entity.Location
import com.example.forecastapplication.data.db.entity.Request
import com.google.gson.annotations.SerializedName

data class CurrentWeatherResponce(
    @SerializedName("current")
    val current: CurrentWeatherEntry,
    val location: Location,
    val request: Request
)