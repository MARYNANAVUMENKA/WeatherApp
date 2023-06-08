package com.naumenko.weatherapp.di

import com.naumenko.weatherapp.presentation.viewmodel.WeatherViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
interface ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(WeatherViewModel::class)
    fun viewModelFactory(factory: WeatherViewModel.Factory): AssistedViewModelFactory<*, *>

}
