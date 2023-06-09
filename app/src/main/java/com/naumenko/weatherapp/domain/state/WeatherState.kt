package com.naumenko.weatherapp.domain.state

import com.airbnb.mvrx.Async
import com.airbnb.mvrx.MavericksState
import com.airbnb.mvrx.Uninitialized
import com.naumenko.weatherapp.domain.model.WeatherModel

data class WeatherState(
    val result: Async<WeatherModel> = Uninitialized
) : MavericksState
