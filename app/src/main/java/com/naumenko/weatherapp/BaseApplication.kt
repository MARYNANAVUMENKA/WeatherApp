package com.naumenko.weatherapp

import android.app.Application
import androidx.activity.ComponentActivity
import com.airbnb.mvrx.Mavericks
import com.naumenko.weatherapp.di.AppComponent
import com.naumenko.weatherapp.di.DaggerAppComponent

class BaseApplication : Application() {
    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.create()
        Mavericks.initialize(this)
    }
}
fun ComponentActivity.appComponent(): AppComponent {
    return (application as BaseApplication).appComponent
}