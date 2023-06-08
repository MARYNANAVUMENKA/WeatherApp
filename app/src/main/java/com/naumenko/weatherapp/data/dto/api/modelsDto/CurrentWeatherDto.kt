package com.naumenko.weatherapp.data.dto.api.modelsDto

import com.google.gson.annotations.SerializedName

data class CurrentWeatherDto(
    @SerializedName("temp_c") val tempC: Double? = null,
    @SerializedName("temp_f") val tempF: Double? = null,
    @SerializedName("is_day") val isDay: Int? = null,
    @SerializedName("condition") val conditionDTO: ConditionDto? = ConditionDto(),
    @SerializedName("wind_mph") val windMph: Double? = null,
    @SerializedName("humidity") val humidity: Int? = null
)