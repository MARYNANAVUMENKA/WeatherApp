package com.naumenko.weatherapp.data.dto.api.modelsDto

import com.google.gson.annotations.SerializedName

data class ResponseWeatherData(
    @SerializedName("location") val locationDto: LocationDto? = LocationDto(),
    @SerializedName("current") val current: CurrentWeatherDto? = CurrentWeatherDto(),
    @SerializedName("forecast") val forecastDataDto: ForecastDataDto? = ForecastDataDto()
)