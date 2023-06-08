package com.naumenko.weatherapp.presentation

interface WeatherEvent

class SaveEvent(val cityName: String) : WeatherEvent

class LoadEvent : WeatherEvent