package com.naumenko.weatherapp.domain.model

import androidx.annotation.DrawableRes
import com.naumenko.weatherapp.R
import com.naumenko.weatherapp.data.dto.api.modelsDto.ResponseWeatherData
import java.text.SimpleDateFormat
import java.util.*

data class WeatherData(
    val responseWeatherData: ResponseWeatherData
) {
    val time: String get() = getTimeFormatted(responseWeatherData.locationDto?.localtime) ?: "00:00AM"
    val data: String
        get() = getDateFormatted(responseWeatherData.locationDto?.localtime) ?: "Tuesday, 12 Apr 2022"
    val cityName: String get() = responseWeatherData.locationDto?.name ?: "Minsk"
    val conditionIcon: String? get() = getIconUrl(responseWeatherData.current?.conditionDTO?.icon)
    val temperature: String get() = "${responseWeatherData.current?.tempF.toString()} °F"
    val condition: String get() = responseWeatherData.forecastDataDto?.forecastDayDto?.get(0)?.dayDto?.conditionDTO?.text?: ""
    @get:DrawableRes
    val windIcon: Int get() = R.drawable.ic_wind
    val wind: String get() = "${responseWeatherData.current?.windMph.toString()} mph"
    @get:DrawableRes
    val dropIcon: Int get() = R.drawable.ic_drop
    val drop: String get() = "${responseWeatherData.current?.humidity.toString()} %"
    val conditionIconToday: String? get() = getIconUrl(responseWeatherData.forecastDataDto?.forecastDayDto?.get(0)?.dayDto?.conditionDTO?.icon)
    val tempToday:String get() ="${responseWeatherData.forecastDataDto?.forecastDayDto?.get(0)?.dayDto?.mintempF}°/${responseWeatherData.forecastDataDto?.forecastDayDto?.get(0)?.dayDto?.maxtempF}°F"
    val today:String get() = "Today"
    val conditionIconTomorrow: String? get() = getIconUrl(responseWeatherData.forecastDataDto?.forecastDayDto?.get(1)?.dayDto?.conditionDTO?.icon)
    val tempTomorrow:String get() ="${responseWeatherData.forecastDataDto?.forecastDayDto?.get(1)?.dayDto?.mintempF}°/${responseWeatherData.forecastDataDto?.forecastDayDto?.get(1)?.dayDto?.maxtempF}°F"
    val tomorrow:String get() = "Tomorrow"
    val conditionIconAfterTomorrow: String? get() = getIconUrl(responseWeatherData.forecastDataDto?.forecastDayDto?.get(2)?.dayDto?.conditionDTO?.icon)
    val tempAfterTomorrow:String get() ="${responseWeatherData.forecastDataDto?.forecastDayDto?.get(2)?.dayDto?.mintempF}°/${responseWeatherData.forecastDataDto?.forecastDayDto?.get(2)?.dayDto?.maxtempF}°F"
    val afterTomorrow:String get() = "After Tomorrow"

    private fun getIconUrl(url: String?): String? {
        return if (url != null) "https:$url" else null
    }

    private fun getTimeFormatted(timeEpoch: String?): String? {
        return if (timeEpoch != null) {
            val mainDateFormat = SimpleDateFormat("yyyy-mm-dd hh:mm", Locale.ENGLISH)
            val unixDate = mainDateFormat.parse(timeEpoch)
            val dateFormat = SimpleDateFormat("hh:mm aa", Locale.ENGLISH)
            if (unixDate != null) {
                dateFormat.format(unixDate)
            } else {
                null
            }
        } else {
            null
        }
    }

    private fun getDateFormatted(timeEpoch: String?): String? {
        return if (timeEpoch != null) {
            val mainDateFormat = SimpleDateFormat("yyyy-MM-dd hh:mm", Locale.ENGLISH)
            val unixDate = mainDateFormat.parse(timeEpoch)
            val dateFormat = SimpleDateFormat("EEEE, dd MMM yyyy", Locale.ENGLISH)
            if (unixDate != null) {
                dateFormat.format(unixDate)
            } else {
                null
            }
        } else {
            null
        }
    }
}