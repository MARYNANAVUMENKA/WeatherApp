package com.naumenko.weatherapp.data.dto.api.modelsDto

import com.google.gson.annotations.SerializedName

data class DayDto(
    @SerializedName("maxtemp_c") val maxtempC: Double? = null,
    @SerializedName("maxtemp_f") val maxtempF: Double? = null,
    @SerializedName("mintemp_c") val mintempC: Double? = null,
    @SerializedName("mintemp_f") val mintempF: Double? = null,
    @SerializedName("totalsnow_cm") val totalsnowCm: Int? = null,
    @SerializedName("condition") val conditionDTO: ConditionDto? = ConditionDto()
)