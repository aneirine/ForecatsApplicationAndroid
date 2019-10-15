package com.example.forecastapplication.data.response


import com.google.gson.annotations.SerializedName

data class CurrentWeatherResponce(
    @SerializedName("current")
    val current: CurrentWeatherEntry,
    val location: Location,
    val request: Request
)