package com.example.forecastapplication.data.response


import com.google.gson.annotations.SerializedName

data class CurrentWeatherResponse(
    @SerializedName("current")
    val currentWeatherEnrty: CurrentWeatherEnrty,
    val location: Location
)