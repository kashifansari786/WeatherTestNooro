package com.kashif.weathertestnooro.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kashif.weathertestnooro.data.model.WeatherResponse
import com.kashif.weathertestnooro.data.remote.WeatherRepository
import com.kashif.weathertestnooro.utils.Resources
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * Created by Mohammad Kashif Ansari on 17,December,2024
 */

@HiltViewModel
class HomeViewModel @Inject constructor(private val repository: WeatherRepository) : ViewModel() {

    // StateFlow to manage the weather state (Success, Error, Loading)
    private val _weatherState = MutableStateFlow<Resources<WeatherResponse>?>(null)
    val weatherState: StateFlow<Resources<WeatherResponse>?> = _weatherState

    // Flow to observe the saved city from the repository
    val savedCity = repository.getCity()

    // Function to load weather data for a specific city
    fun loadWeather(city: String) = viewModelScope.launch {
        // Set weather state to loading while waiting for data
        _weatherState.value = Resources.Loading()

        // Fetch weather data from repository
        val weatherResponse = repository.getWeather(city)

        // Save the city for later use
        repository.saveCity(city)

        // Update the weather state with the fetched data
        _weatherState.value = weatherResponse
    }
}