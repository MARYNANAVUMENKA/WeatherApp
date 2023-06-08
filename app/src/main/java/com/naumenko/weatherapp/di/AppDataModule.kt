package com.naumenko.weatherapp.di

import com.naumenko.weatherapp.data.dto.api.WeatherApi
import com.naumenko.weatherapp.data.WeatherRepositoryImpl
import com.naumenko.weatherapp.domain.WeatherRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppDataModule {

    @Singleton
    @Provides
    fun provideWeatherRepository(
        weatherApi: WeatherApi,
    ): WeatherRepository {
        return WeatherRepositoryImpl(weatherApi)
    }
}