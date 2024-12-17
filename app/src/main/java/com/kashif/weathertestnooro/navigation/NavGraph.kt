package com.kashif.weathertestnooro.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.kashif.weathertestnooro.presentation.HomeScreen
import com.kashif.weathertestnooro.presentation.HomeViewModel
import com.kashif.weathertestnooro.presentation.SearchScreen

/**
 * Created by Mohammad Kashif Ansari on 17,December,2024
 */
// Composable function that defines the navigation graph for the app
@Composable
fun NavGraph(
    navController: NavHostController, // NavController to handle navigation
    viewModel: HomeViewModel // ViewModel that will be passed to screens
) {
    // NavHost to set up navigation for the app
    NavHost(
        navController = navController, // NavController to manage navigation
        startDestination = Routes.HomeScreen.routes // Set the start screen to HomeScreen
    ) {
        // Composable for the HomeScreen route
        composable(Routes.HomeScreen.routes) {
            // HomeScreen is displayed when this route is navigated to, passing the viewModel and navController
            HomeScreen(viewModel, navController)
        }

        // Composable for the SearchScreen route
        composable(Routes.SearchScreen.routes) {
            // SearchScreen is displayed when this route is navigated to, passing the viewModel and navController
            SearchScreen(viewModel, navController)
        }
    }
}