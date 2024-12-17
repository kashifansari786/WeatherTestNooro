package com.kashif.weathertestnooro.data.remote

import com.kashif.weathertestnooro.data.model.WeatherResponse
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by Mohammad Kashif Ansari on 17,December,2024
 */


// Interface for interacting with the Weather API service
interface WeatherApiService {

    // Defines a GET request to fetch current weather data in JSON format
    @GET("current.json")
    suspend fun getCurrentWeatherData(
        @Query("key") apiKey: String, // API key used to authenticate the request
        @Query("q") city: String // City name for which the weather data is fetched
    ): WeatherResponse // Returns a WeatherResponse object containing the weather data
}