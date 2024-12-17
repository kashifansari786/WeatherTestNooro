package com.kashif.weathertestnooro.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.kashif.weathertestnooro.data.model.WeatherResponse
import com.kashif.weathertestnooro.presentation.components.CityRow
import com.kashif.weathertestnooro.presentation.components.DummySearchBar
import com.kashif.weathertestnooro.presentation.components.NoCitySelected
import com.kashif.weathertestnooro.presentation.components.WeatherIconWithTemperature
import com.kashif.weathertestnooro.utils.Resources

/**
 * Created by Mohammad Kashif Ansari on 17,December,2024
 */
@Composable
fun HomeScreen(viewModels: HomeViewModel, navController: NavController) {

    // Collect saved city and weather state from the ViewModel
    val savedCity by viewModels.savedCity.collectAsState(initial = null)
    val weatherState by viewModels.weatherState.collectAsState()

    // Trigger loading weather data when saved city changes
    LaunchedEffect(savedCity) {
        savedCity?.let { viewModels.loadWeather(it) }
    }

    // Main Column to organize UI components vertically
    Column(modifier = Modifier.fillMaxSize()) {

        // Dummy SearchBar to navigate to SearchScreen
        DummySearchBar(navController)

        // Handle different states of weather data
        when (weatherState) {

            // If data is successfully loaded, show weather details
            is Resources.Success -> {
                WeatherIconWithTemperature(weatherState)
            }

            // If there is an error, display NoCitySelected message
            is Resources.Error -> {
                NoCitySelected()
            }

            // If data is loading, show a progress indicator
            is Resources.Loading -> {
                CircularProgressIndicator(modifier = Modifier.align(Alignment.CenterHorizontally))
            }

            // Default case to handle other states or empty weather data
            else -> {
                NoCitySelected()
            }
        }
    }
}


