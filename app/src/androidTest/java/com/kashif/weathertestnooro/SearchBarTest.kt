package com.kashif.weathertestnooro

import androidx.compose.runtime.remember
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.semantics.SemanticsActions
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.assertIsFocused
import androidx.compose.ui.test.hasContentDescription
import androidx.compose.ui.test.hasTestTag
import androidx.compose.ui.test.hasText
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.performSemanticsAction
import androidx.compose.ui.test.performTextInput
import com.kashif.weathertestnooro.presentation.components.SearchBar
import org.junit.Rule
import org.junit.Test

/**
 * Created by Mohammad Kashif Ansari on 17,December,2024
 */
class SearchBarTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun testSearchBar_InputButtonClick(){
        var searchText=""

        // Initialize a FocusRequester instance outside the Composable
        val focusRequester = FocusRequester()

        // Start the UI
        composeTestRule.setContent {
            // Pass the FocusRequester to the SearchBar
            SearchBar(
                onSearch = { searchText = it },
                focusRequester = focusRequester
            )
        }

        // Request focus explicitly to ensure that the TextField gets focus
        composeTestRule
            .onNode(hasText("Search Location"))
            .performSemanticsAction(SemanticsActions.RequestFocus)

        // Verify that the TextField has focus
        composeTestRule.onNode(hasText("Search Location")).assertIsFocused()

        // Simulate text input
        val inputText = "Kanpur"
        composeTestRule.onNode(hasText("Search Location")).performTextInput(inputText)

        // Verify the entered text is displayed
        composeTestRule.onNodeWithText(inputText).assertIsDisplayed()

        // Simulate clicking the search button
        composeTestRule.onNode(hasContentDescription("Search")).performClick()

        // Assert that the search callback received the correct text
        assert(searchText == inputText)

    }
}