package com.naumenko.weatherapp.data.dto.api.modelsDto

import com.google.gson.annotations.SerializedName

data class ForecastDataDto(
    @SerializedName("forecastday") var forecastDayDto: ArrayList<ForecastDayDto> = arrayListOf()
)