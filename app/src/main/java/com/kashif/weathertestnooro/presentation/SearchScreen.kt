package com.kashif.weathertestnooro.presentation


import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.navigation.NavController
import com.kashif.weathertestnooro.data.model.WeatherResponse
import com.kashif.weathertestnooro.presentation.components.CityRow
import com.kashif.weathertestnooro.presentation.components.SearchBar
import com.kashif.weathertestnooro.utils.Resources

/**
 * Created by Mohammad Kashif Ansari on 17,December,2024
 */
@Composable
fun SearchScreen(viewModel: HomeViewModel, navController: NavController) {

    // Collect the weather state from the ViewModel's weatherState Flow
    val weatherState by viewModel.weatherState.collectAsState()

    // Create focus requester for handling the focus of SearchBar
    val focusRequester = remember { FocusRequester() }

    // Get the current software keyboard controller for managing the keyboard
    val keyboardController = LocalSoftwareKeyboardController.current

    // Main column layout for the screen
    Column(modifier = Modifier.fillMaxSize()) {

        // SearchBar Composable that handles city search functionality
        SearchBar({ city ->
            viewModel.loadWeather(city) // Load weather data when a city is searched
        }, focusRequester = focusRequester)

        // Handle different states of weather data (Success, Error, Loading)
        when (weatherState) {
            is Resources.Success -> {
                val weather = (weatherState as Resources.Success<WeatherResponse>).data

                // If weather data is not null, display CityRow with the weather details
                weather?.let {
                    CityRow(
                        cityName = it.location.name,
                        temperature = it.current.temp_c,
                        weatherIconUrl = it.current.condition.icon,
                        onCLick = {
                            navController.popBackStack() // Navigate back to the previous screen on click
                        }
                    )
                }
            }
            is Resources.Error -> {
                // Handle error state (e.g., show an error message)
            }
            is Resources.Loading -> {
                // Show a loading indicator while weather data is being fetched
                CircularProgressIndicator(modifier = Modifier.align(Alignment.CenterHorizontally))
            }
            else -> {
                // Handle any other state (e.g., empty or initial state)
            }
        }

        // Request focus and show the keyboard explicitly when the screen is opened
        LaunchedEffect(Unit) {
            focusRequester.requestFocus() // Request focus for the SearchBar
            keyboardController?.show() // Show the software keyboard explicitly
        }
    }
}