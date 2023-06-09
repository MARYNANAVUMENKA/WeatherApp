package com.naumenko.weatherapp.domain.model

data class WeatherModel(
    val time: String,
    val data: String,
    val cityName: String,
    val conditionIcon: String,
    val temperature: String,
    val condition: String,
    val windIcon: Int,
    val wind: String,
    val dropIcon: Int,
    val drop: String,
    val conditionIconToday: String,
    val tempToday: String,
    val today: Int,
    val conditionIconTomorrow: String,
    val tempTomorrow: String,
    val tomorrow: Int,
    val conditionIconAfterTomorrow: String,
    val tempAfterTomorrow: String,
    val afterTomorrow: Int,
)