package com.kashif.weathertestnooro.utils

/**
 * Created by Mohammad Kashif Ansari on 17,December,2024
 */
sealed class Resources<T>(val data: T? = null, val message: String? = null) {
    // Success class to handle successful data fetch
    class Success<T>(data: T) : Resources<T>(data)

    // Error class to handle failure or errors in fetching data
    class Error<T>(message: String, data: T? = null) : Resources<T>(data, message)

    // Loading class to represent loading state
    class Loading<T> : Resources<T>()
}