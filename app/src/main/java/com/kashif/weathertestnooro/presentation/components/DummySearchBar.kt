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
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.kashif.weathertestnooro.navigation.Routes
import com.kashif.weathertestnooro.ui.theme.BoxColor
import com.kashif.weathertestnooro.ui.theme.Dimens.cornerRadius
import com.kashif.weathertestnooro.ui.theme.Dimens.font15
import com.kashif.weathertestnooro.ui.theme.Dimens.lineHeight22
import com.kashif.weathertestnooro.ui.theme.Dimens.padding11
import com.kashif.weathertestnooro.ui.theme.Dimens.padding20
import com.kashif.weathertestnooro.ui.theme.Dimens.padding24
import com.kashif.weathertestnooro.ui.theme.Dimens.padding44
import com.kashif.weathertestnooro.ui.theme.Dimens.padding46
import com.kashif.weathertestnooro.ui.theme.Dimens.padding47
import com.kashif.weathertestnooro.ui.theme.Dimens.size17
import com.kashif.weathertestnooro.ui.theme.TextColorLight
import com.kashif.weathertestnooro.utils.Poppins

/**
 * Created by Mohammad Kashif Ansari on 17,December,2024
 */

@Composable
fun DummySearchBar(navController: NavController) {
    // Box container for holding the search bar UI components with specified padding and background
    Box(
        modifier = Modifier
            .padding(horizontal = padding24, vertical = padding44) // Set horizontal and vertical padding for the Box
            .fillMaxWidth() // Make the Box take up the full width
            .height(padding46) // Set the height of the Box
            .background(BoxColor, RoundedCornerShape(cornerRadius)) // Set the background color and rounded corners
            .clickable { navController.navigate(Routes.SearchScreen.routes) }, // Navigate to SearchScreen on click
        contentAlignment = Alignment.CenterStart // Align the content inside the Box to the start (left side)
    )  {
        // Row for arranging the text and icon horizontally within the Box
        Row(
            modifier = Modifier
                .fillMaxSize() // Make the Row take up the full size of the Box
                .padding(horizontal = padding20, vertical = padding11), // Apply padding to Row
            horizontalArrangement = Arrangement.SpaceBetween, // Space out the items evenly between the start and end of the Row
            verticalAlignment = Alignment.CenterVertically // Align items vertically in the center
        ) {
            // Text element displaying the "Search Location" text
            Text(
                text = "Search Location", // Text content
                style = TextStyle(
                    fontFamily = Poppins, // Set the font family to Poppins
                    fontWeight = FontWeight.Normal, // Set the font weight to Normal
                    fontSize = font15, // Set the font size
                    lineHeight = lineHeight22, // Set the line height for the text
                    color = TextColorLight // Set the text color to light
                )
            )

            // Icon element displaying the search icon
            Icon(
                imageVector = Icons.Default.Search, // Use the default search icon
                contentDescription = "Search", // Content description for accessibility
                tint = TextColorLight, // Set the icon tint color
                modifier = Modifier
                    .size(size17) // Set the size of the icon
            )
        }
    }
}