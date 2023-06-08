package com.naumenko.weatherapp.domain.state

import com.airbnb.mvrx.Async
import com.airbnb.mvrx.MavericksState
import com.airbnb.mvrx.Uninitialized
import com.naumenko.weatherapp.domain.model.WeatherData

data class WeatherState(
    val result: Async<WeatherData> = Uninitialized
) : MavericksState
