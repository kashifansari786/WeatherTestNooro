package com.kashif.weathertestnooro.data.model

import com.google.gson.annotations.SerializedName
import com.squareup.moshi.Json

/**
 * Created by Mohammad Kashif Ansari on 17,December,2024
 */

// This data class holds the weather response from the API
data class WeatherResponse(
    val location: Location, // Holds location details like city name
    val current: Current // Holds current weather details like temperature, condition, etc.
)

// This data class holds the location details like city name
data class Location(
    val name: String // The name of the city or location
)

// This data class holds the current weather details like temperature, humidity, and condition
data class Current(
    val temp_c: Double, // The current temperature in Celsius
    val condition: Condition, // The weather condition (e.g., sunny, rainy)
    val humidity: Int, // Humidity percentage
    val uv: Double, // UV index
    @SerializedName("feelslike_c") val feelsLike: Double // The temperature that feels like in Celsius, annotated for JSON deserialization
)

// This data class holds the condition of the weather, including text (description) and icon URL
data class Condition(
    val text: String, // The text description of the weather condition (e.g., "Clear", "Cloudy")
    val icon: String // The URL for the weather icon image
)