package com.naumenko.weatherapp.data.dto.api.modelsDto

import com.google.gson.annotations.SerializedName

data class ForecastDayDto(
    @SerializedName("date") val date: String? = null,
    @SerializedName("date_epoch") val dateEpoch: Int? = null,
    @SerializedName("day") val dayDto: DayDto? = DayDto()
)