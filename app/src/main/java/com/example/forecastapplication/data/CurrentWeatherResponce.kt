package com.example.forecastapplication.data


import com.google.gson.annotations.SerializedName

data class CurrentWeatherResponce(
    val current: Current,
    val location: Location
)