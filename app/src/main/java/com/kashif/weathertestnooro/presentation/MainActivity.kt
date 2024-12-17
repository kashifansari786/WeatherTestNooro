package com.kashif.weathertestnooro.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.navigation.compose.rememberNavController
import com.kashif.weathertestnooro.navigation.NavGraph
import com.kashif.weathertestnooro.ui.theme.WeatherTestNooroTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint // Enables Hilt dependency injection for the activity
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Enable edge-to-edge UI for immersive experience
        enableEdgeToEdge()

        setContent {
            WeatherTestNooroTheme { // Apply custom theme for the app
                val viewModels: HomeViewModel by viewModels() // Get the ViewModel using Hilt's dependency injection
                val navController = rememberNavController() // Create a NavController for navigation

                // Set up navigation graph with the ViewModel and NavController
                NavGraph(viewModel = viewModels, navController = navController)
            }
        }
    }
}