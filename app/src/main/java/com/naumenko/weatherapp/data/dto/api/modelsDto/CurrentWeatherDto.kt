package com.naumenko.weatherapp.data.dto.api.modelsDto

import com.google.gson.annotations.SerializedName

data class CurrentWeatherDto(
    @SerializedName("temp_c") var tempC: Double? = null,
    @SerializedName("temp_f") var tempF: Double? = null,
    @SerializedName("is_day") var isDay: Int? = null,
    @SerializedName("condition") var conditionDTO: ConditionDto? = ConditionDto(),
    @SerializedName("wind_mph") var windMph: Double? = null,
    @SerializedName("humidity") var humidity: Int? = null
)