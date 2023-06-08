package com.naumenko.weatherapp.data.dto.api

import com.naumenko.weatherapp.data.dto.api.modelsDto.ResponseWeatherData
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherApi {

    companion object {
        const val BASE_URL = "https://api.weatherapi.com/v1/"
    }

    @GET("forecast.json")
    suspend fun getWeatherData(
        @Query("q") cityName: String,
        @Query("days") forecastDays: String = "3",
        @Query("aqi") airQualityData: String = "no",
        @Query("alerts") weatherAlerts: String = "no",
        @Query("key") apiKey: String,
    ): ResponseWeatherData
}