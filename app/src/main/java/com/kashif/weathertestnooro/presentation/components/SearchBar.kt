package com.kashif.weathertestnooro.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.kashif.weathertestnooro.R
import com.kashif.weathertestnooro.presentation.HomeViewModel
import com.kashif.weathertestnooro.ui.theme.BoxColor
import com.kashif.weathertestnooro.ui.theme.Dimens.cornerRadius
import com.kashif.weathertestnooro.ui.theme.Dimens.font15
import com.kashif.weathertestnooro.ui.theme.Dimens.lineHeight22
import com.kashif.weathertestnooro.ui.theme.Dimens.padding11
import com.kashif.weathertestnooro.ui.theme.Dimens.padding20
import com.kashif.weathertestnooro.ui.theme.Dimens.padding24
import com.kashif.weathertestnooro.ui.theme.Dimens.padding44
import com.kashif.weathertestnooro.ui.theme.Dimens.size17
import com.kashif.weathertestnooro.ui.theme.Dimens.size46
import com.kashif.weathertestnooro.ui.theme.TextColorDark
import com.kashif.weathertestnooro.ui.theme.TextColorLight
import com.kashif.weathertestnooro.utils.Poppins


/**
 * Created by Mohammad Kashif Ansari on 17,December,2024
 */
@Composable
fun SearchBar(onSearch: (String) -> Unit, focusRequester: FocusRequester) {
    // State to manage the text field input value
    var searchQuery by remember { mutableStateOf(TextFieldValue("")) }
    // To control the keyboard actions
    val keyboardController = LocalSoftwareKeyboardController.current

    // Box to wrap the entire search bar layout
    Box(
        modifier = Modifier
            .padding(horizontal = padding24, vertical = padding44) // Apply padding around the box
            .fillMaxWidth() // Make the Box take up the full width
            .height(size46) // Set a fixed height for the Box
            .background(BoxColor, RoundedCornerShape(cornerRadius)), // Set background color and rounded corners
        contentAlignment = Alignment.CenterStart // Align contents to the start (left)
    ) {
        // Row to arrange the text field and search icon horizontally
        Row(
            modifier = Modifier
                .fillMaxSize() // Make the Row take up the full size of the Box
                .padding(horizontal = padding20, vertical = padding11), // Apply padding to the Row
            horizontalArrangement = Arrangement.SpaceBetween, // Distribute space between elements
            verticalAlignment = Alignment.CenterVertically // Align elements vertically to the center
        ) {
            // BasicTextField to allow the user to input the search query
            BasicTextField(
                value = searchQuery, // Bind the value to the search query state
                onValueChange = { query -> searchQuery = query }, // Update the state when the text changes
                singleLine = true, // Ensure the text field is single-line
                textStyle = TextStyle(
                    fontFamily = Poppins, // Set font family to Poppins
                    fontWeight = FontWeight.Normal, // Set font weight to Normal
                    fontSize = font15, // Set the font size for the text
                    lineHeight = lineHeight22, // Set line height for the text
                    color = TextColorDark // Set the text color to dark
                ),
                keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Search), // Set IME action to search
                keyboardActions = KeyboardActions(
                    onSearch = {
                        keyboardController?.hide() // Dismiss the keyboard when the search action is triggered
                        onSearch(searchQuery.text) // Call onSearch with the current query
                    }
                ),
                decorationBox = { innerTextField ->
                    if (searchQuery.text.isEmpty()) {
                        // Display hint text when the search query is empty
                        Text(
                            text = stringResource(R.string.search_location), // Placeholder text
                            style = TextStyle(
                                fontFamily = Poppins, // Set font family
                                fontWeight = FontWeight.Normal, // Set font weight
                                fontSize = font15, // Set font size
                                lineHeight = lineHeight22, // Set line height
                                color = TextColorLight // Set hint text color
                            ),
                        )
                    }
                    innerTextField() // Display the actual text field inside the decoration box
                },
                modifier = Modifier
                    .fillMaxWidth() // Make the text field take up the full width of the Row
                    .weight(1f) // Allow the text field to take up the available space
                    .background(Color.Transparent) // Make the background transparent
                    .focusRequester(focusRequester) // Attach the focus requester to handle focus
            )

            // Search icon button that triggers the search when clicked
            Icon(
                imageVector = Icons.Default.Search, // Use the default search icon
                contentDescription = "Search", // Accessibility description for the icon
                tint = TextColorLight, // Set icon tint color
                modifier = Modifier
                    .clickable {
                        keyboardController?.hide() // Hide the keyboard when the icon is clicked
                        onSearch(searchQuery.text) // Trigger the search action
                    }
                    .size(size17) // Set the size of the icon
            )
        }
    }
}