package com.kashif.weathertestnooro

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import com.kashif.weathertestnooro.presentation.components.CityRow
import org.junit.Rule
import org.junit.Test

/**
 * Created by Mohammad Kashif Ansari on 17,December,2024
 */
class CityRowTest {

    @get:Rule
    val composeRule = createComposeRule()


    @Test
    fun testCityRow_clickAction(){
        var wasClicked = false

        //start the UI
        composeRule.setContent {
            CityRow(
                cityName = "kanpur",
                temperature = 10.2,
                weatherIconUrl = "//cdn.weatherapi.com/weather/64x64/day/122.png",
                onCLick = { wasClicked = true }
            )
        }

        //verify cityname is displayed
        composeRule.onNodeWithText("kanpur").assertIsDisplayed()

        //verify city temp is displayed
        composeRule.onNodeWithText(10.2.toString()).assertIsDisplayed()

        //verify weatherIcon is displayed
        composeRule.onNodeWithContentDescription("Weather Icon").assertIsDisplayed()

        //perform click action
        composeRule.onNodeWithTag("cityRow").performClick()

        //verify the click action triggered
        assert((wasClicked))
    }
}