package com.kashif.weathertestnooro

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

/**
 * Created by Mohammad Kashif Ansari on 17,December,2024
 */

@HiltAndroidApp
class WeatherApplication : Application() {
    // This class is used to initialize Hilt for dependency injection across the app.
    // It is annotated with @HiltAndroidApp to set up the necessary components for Hilt injection.
}