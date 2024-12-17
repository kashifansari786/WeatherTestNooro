package com.kashif.weathertestnooro.di

import android.content.Context
import com.kashif.weathertestnooro.data.local.CityPreferences
import com.kashif.weathertestnooro.data.remote.WeatherApiService
import com.kashif.weathertestnooro.utils.Constants.BASE_URL
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

/**
 * Created by Mohammad Kashif Ansari on 17,December,2024
 */

// AppModule is a Hilt module that provides dependencies to the entire application
@Module
@InstallIn(SingletonComponent::class) // Install this module in the SingletonComponent to ensure it is available throughout the app's lifetime
class AppModule {

    // Provides the WeatherApiService as a singleton
    @Singleton
    @Provides
    fun provideWeatherApi(): WeatherApiService {
        return Retrofit.Builder()
            // Set the base URL for the API
            .baseUrl(BASE_URL)
            // Add GsonConverterFactory to handle JSON responses
            .addConverterFactory(GsonConverterFactory.create())
            // Build the Retrofit instance and create the WeatherApiService interface
            .build()
            .create(WeatherApiService::class.java)
    }

    // Provides the CityPreferences as a singleton, using the application context for access
    @Singleton
    @Provides
    fun provideCityPreferences(@ApplicationContext context: Context): CityPreferences {
        // Instantiate the CityPreferences class with the application context
        return CityPreferences(context)
    }
}