package com.naumenko.weatherapp.domain

import com.naumenko.weatherapp.data.dto.api.modelsDto.ResponseWeatherData

interface WeatherRepository {

    suspend fun getWeatherData(cityName: String): ResponseWeatherData
}