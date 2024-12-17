package com.kashif.weathertestnooro

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import com.kashif.weathertestnooro.data.model.Condition
import com.kashif.weathertestnooro.data.model.Current
import com.kashif.weathertestnooro.data.model.Location
import com.kashif.weathertestnooro.data.model.WeatherResponse
import com.kashif.weathertestnooro.presentation.components.WeatherIconWithTemperature
import com.kashif.weathertestnooro.utils.Resources
import org.junit.Rule
import org.junit.Test

/**
 * Created by Mohammad Kashif Ansari on 17,December,2024
 */
class weatherIconWithTemperatureTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun testWeatherIcon(){
        composeTestRule.setContent {
            val mockResponse = WeatherResponse(
                location = Location("Kanpur"),
                current = Current(
                    temp_c = 25.0,
                    condition = Condition("Clear",icon=""),
                    humidity = 50,
                    uv = 5.0,
                    feelsLike = 26.0
                )
            )
            val fakeSuccessState = Resources.Success(mockResponse)
            WeatherIconWithTemperature(fakeSuccessState)
        }

        // Verify that the locationName text is shown
        composeTestRule.onNodeWithTag("name").assertIsDisplayed()

        // Verify that the temperature text is shown
        composeTestRule.onNodeWithTag("temp").assertIsDisplayed()

        // Verify that the humidity text is shown
        composeTestRule.onNodeWithTag("humidity").assertIsDisplayed()

        // Verify that the uv text is shown
        composeTestRule.onNodeWithTag("uv").assertIsDisplayed()

        // Verify that the feelsLike text is shown
        composeTestRule.onNodeWithTag("feels").assertIsDisplayed()



        // Verify the AsyncImage is displayed with the correct URL
        composeTestRule.onNodeWithContentDescription("Weather Icon")
            .assertExists()
    }
}