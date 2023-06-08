package com.naumenko.weatherapp.di

import com.airbnb.mvrx.MavericksViewModel
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class, ViewModelModule::class, AppDataModule::class])
interface AppComponent {

    fun viewModelFactories(): Map<Class<out MavericksViewModel<*>>, AssistedViewModelFactory<*, *>>
}