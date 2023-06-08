package com.naumenko.weatherapp.data.dto.api.modelsDto

import com.google.gson.annotations.SerializedName

data class ForecastDataDto(
    @SerializedName("forecastday") val forecastDayDto: ArrayList<ForecastDayDto> = arrayListOf()
)