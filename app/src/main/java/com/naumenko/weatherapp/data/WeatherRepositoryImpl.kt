package com.naumenko.weatherapp.data

import com.naumenko.weatherapp.data.dto.api.WeatherApi
import com.naumenko.weatherapp.domain.WeatherRepository
import com.naumenko.weatherapp.data.dto.api.mapper.toWeatherData
import com.naumenko.weatherapp.data.dto.api.mapper.toWeatherModel
import com.naumenko.weatherapp.domain.model.WeatherModel
import javax.inject.Inject

private const val API_KEY = "c20da1051f394b1d82270028230606"

class WeatherRepositoryImpl @Inject constructor(
    private val weatherApi: WeatherApi,
) : WeatherRepository {

    override suspend fun getWeatherData(cityName: String): WeatherModel {
        return weatherApi.getWeatherData(apiKey = API_KEY, cityName = cityName).toWeatherData().toWeatherModel()
    }
}