package com.kashif.weathertestnooro.navigation

import com.kashif.weathertestnooro.utils.Constants.HOME_SCREEN
import com.kashif.weathertestnooro.utils.Constants.SEARCH_SCREEN

/**
 * Created by Mohammad Kashif Ansari on 17,December,2024
 */
// Sealed class to represent different navigation routes in the app
sealed class Routes(val routes: String) {
    // Object for the HomeScreen route, inherits from Routes with a specific route name
    object HomeScreen : Routes(HOME_SCREEN)

    // Object for the SearchScreen route, inherits from Routes with a specific route name
    object SearchScreen : Routes(SEARCH_SCREEN)
}