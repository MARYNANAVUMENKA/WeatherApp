package com.naumenko.weatherapp.data.dto.api.mapper

import com.naumenko.weatherapp.data.dto.api.modelsDto.ResponseWeatherData
import com.naumenko.weatherapp.data.dto.api.modelsDto.WeatherData
import com.naumenko.weatherapp.domain.model.WeatherModel

fun ResponseWeatherData.toWeatherData(): WeatherData {
    return WeatherData(responseWeatherData = this)
}

fun WeatherData.toWeatherModel(): WeatherModel {
    return WeatherModel(
        time,
        data,
        cityName,
        conditionIcon,
        temperature,
        condition,
        windIcon,
        wind,
        dropIcon,
        drop,
        conditionIconToday,
        tempToday,
        today,
        conditionIconTomorrow,
        tempTomorrow,
        tomorrow,
        conditionIconAfterTomorrow,
        tempAfterTomorrow,
        afterTomorrow
    )
}