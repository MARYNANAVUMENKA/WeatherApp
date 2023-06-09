package com.naumenko.weatherapp.data.dto.api.modelsDto

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.naumenko.weatherapp.EMPTY
import com.naumenko.weatherapp.R
import java.text.SimpleDateFormat
import java.util.*

data class WeatherData(
    val responseWeatherData: ResponseWeatherData
) {
    val time: String
        get() = getTimeFormatted(responseWeatherData.locationDto?.localtime)
    val data: String
        get() = getDateFormatted(responseWeatherData.locationDto?.localtime)
    val cityName: String get() = responseWeatherData.locationDto?.name?: String.EMPTY
    val conditionIcon: String get() = getIconUrl(responseWeatherData.current?.conditionDTO?.icon)
    val temperature: String get() = "${responseWeatherData.current?.tempF.toString()} °F"
    val condition: String
        get() = responseWeatherData.forecastDataDto?.forecastDayDto?.get(0)?.dayDto?.conditionDTO?.text
            ?: String.EMPTY

    @get:DrawableRes
    val windIcon: Int get() = R.drawable.ic_wind
    val wind: String get() = "${responseWeatherData.current?.windMph.toString()} mph"

    @get:DrawableRes
    val dropIcon: Int get() = R.drawable.ic_drop
    val drop: String get() = "${responseWeatherData.current?.humidity.toString()} %"
    val conditionIconToday: String
        get() = getIconUrl(
            responseWeatherData.forecastDataDto?.forecastDayDto?.get(0)?.dayDto?.conditionDTO?.icon)
    val tempToday: String
        get() = "${responseWeatherData.forecastDataDto?.forecastDayDto?.get(0)?.dayDto?.mintempF}°/${
            responseWeatherData.forecastDataDto?.forecastDayDto?.get(0)?.dayDto?.maxtempF}°F"

    @get:StringRes
    val today: Int get() = R.string.today
    val conditionIconTomorrow: String
        get() = getIconUrl(
            responseWeatherData.forecastDataDto?.forecastDayDto?.get(1)?.dayDto?.conditionDTO?.icon)
    val tempTomorrow: String
        get() = "${responseWeatherData.forecastDataDto?.forecastDayDto?.get(1)?.dayDto?.mintempF}°/${
            responseWeatherData.forecastDataDto?.forecastDayDto?.get(1)?.dayDto?.maxtempF}°F"

    @get:StringRes
    val tomorrow: Int get() = R.string.tomorrow
    val conditionIconAfterTomorrow: String
        get() = getIconUrl(
            responseWeatherData.forecastDataDto?.forecastDayDto?.get(2)?.dayDto?.conditionDTO?.icon)
    val tempAfterTomorrow: String
        get() = "${
            responseWeatherData.forecastDataDto?.forecastDayDto?.get(2)?.dayDto?.mintempF
        }°/${responseWeatherData.forecastDataDto?.forecastDayDto?.get(2)?.dayDto?.maxtempF}°F"

    @get:StringRes
    val afterTomorrow: Int get() = R.string.after_tomorrow

    private fun getIconUrl(url: String?): String {
        return if (url != null) "https:$url" else String.EMPTY
    }

    private fun getTimeFormatted(timeEpoch: String?): String {
        return if (timeEpoch != null) {
            val mainDateFormat = SimpleDateFormat("yyyy-mm-dd hh:mm", Locale.ENGLISH)
            val unixDate = mainDateFormat.parse(timeEpoch)
            val dateFormat = SimpleDateFormat("hh:mm aa", Locale.ENGLISH)
            if (unixDate != null) {
                dateFormat.format(unixDate)
            } else {
                String.EMPTY
            }
        } else {
            String.EMPTY
        }
    }

    private fun getDateFormatted(timeEpoch: String?): String {
        return if (timeEpoch != null) {
            val mainDateFormat = SimpleDateFormat("yyyy-MM-dd hh:mm", Locale.ENGLISH)
            val unixDate = mainDateFormat.parse(timeEpoch)
            val dateFormat = SimpleDateFormat("EEEE, dd MMM yyyy", Locale.ENGLISH)
            if (unixDate != null) {
                dateFormat.format(unixDate)
            } else {
                String.EMPTY
            }
        } else {
            String.EMPTY
        }
    }
}