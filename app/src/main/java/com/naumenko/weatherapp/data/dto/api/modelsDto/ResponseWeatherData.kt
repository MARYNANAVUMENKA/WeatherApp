package com.naumenko.weatherapp.data.dto.api.modelsDto

import com.google.gson.annotations.SerializedName

data class ResponseWeatherData(
    @SerializedName("location") var locationDto: LocationDto? = LocationDto(),
    @SerializedName("current") var current: CurrentWeatherDto? = CurrentWeatherDto(),
    @SerializedName("forecast") var forecastDataDto: ForecastDataDto? = ForecastDataDto()
)