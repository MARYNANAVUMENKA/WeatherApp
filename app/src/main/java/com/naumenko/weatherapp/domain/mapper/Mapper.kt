package com.naumenko.weatherapp.domain.mapper

import com.naumenko.weatherapp.data.dto.api.modelsDto.ResponseWeatherData
import com.naumenko.weatherapp.domain.model.WeatherData

fun ResponseWeatherData.toWeatherData(): WeatherData {
    return WeatherData(responseWeatherData = this)
}