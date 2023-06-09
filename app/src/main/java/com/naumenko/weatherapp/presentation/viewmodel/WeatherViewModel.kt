package com.naumenko.weatherapp.presentation.viewmodel

import com.airbnb.mvrx.MavericksViewModel
import com.airbnb.mvrx.MavericksViewModelFactory
import com.naumenko.weatherapp.di.AssistedViewModelFactory
import com.naumenko.weatherapp.di.daggerMavericksViewModelFactory
import com.naumenko.weatherapp.domain.WeatherRepository
import com.naumenko.weatherapp.domain.state.WeatherState
import com.naumenko.weatherapp.presentation.LoadEvent
import com.naumenko.weatherapp.presentation.SaveEvent
import com.naumenko.weatherapp.presentation.WeatherEvent
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject

class WeatherViewModel @AssistedInject constructor(
    @Assisted initialState: WeatherState,
    private val repository: WeatherRepository,
) :
    MavericksViewModel<WeatherState>(initialState) {

    @AssistedFactory
    interface Factory : AssistedViewModelFactory<WeatherViewModel, WeatherState> {
        override fun create(state: WeatherState): WeatherViewModel
    }

    companion object :
        MavericksViewModelFactory<WeatherViewModel, WeatherState> by daggerMavericksViewModelFactory()

     fun send(event: WeatherEvent){
         when(event){
             is SaveEvent ->{
                 setState(cityName = event.cityName)
             }
             is LoadEvent ->{
                setState(cityName = "Minsk")
             }
         }
     }

    private fun setState(cityName: String) {
        suspend {
            repository.getWeatherData(cityName)
        }.execute {
            copy(result = it)
        }
    }
}