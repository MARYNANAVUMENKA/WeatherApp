package com.naumenko.weatherapp.data.dto.api.modelsDto

import com.google.gson.annotations.SerializedName

data class ConditionDto(
    @SerializedName("text") val text: String? = null,
    @SerializedName("icon") val icon: String? = null,
    @SerializedName("code") val code: Int? = null
)