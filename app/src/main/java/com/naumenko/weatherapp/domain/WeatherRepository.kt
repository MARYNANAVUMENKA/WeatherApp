package com.naumenko.weatherapp.domain

import com.naumenko.weatherapp.domain.model.WeatherModel

interface WeatherRepository {

    suspend fun getWeatherData(cityName: String): WeatherModel
}