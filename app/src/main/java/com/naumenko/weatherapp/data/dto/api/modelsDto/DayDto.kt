package com.naumenko.weatherapp.data.dto.api.modelsDto

import com.google.gson.annotations.SerializedName

data class DayDto(
    @SerializedName("maxtemp_c") var maxtempC: Double? = null,
    @SerializedName("maxtemp_f") var maxtempF: Double? = null,
    @SerializedName("mintemp_c") var mintempC: Double? = null,
    @SerializedName("mintemp_f") var mintempF: Double? = null,
    @SerializedName("totalsnow_cm") var totalsnowCm: Int? = null,
    @SerializedName("condition") var conditionDTO: ConditionDto? = ConditionDto()
)