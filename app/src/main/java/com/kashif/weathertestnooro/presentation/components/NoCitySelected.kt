package com.kashif.weathertestnooro.presentation.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.kashif.weathertestnooro.R
import com.kashif.weathertestnooro.ui.theme.Dimens.font15
import com.kashif.weathertestnooro.ui.theme.Dimens.font30
import com.kashif.weathertestnooro.ui.theme.Dimens.lineHeight22
import com.kashif.weathertestnooro.ui.theme.Dimens.lineHeight45
import com.kashif.weathertestnooro.ui.theme.Dimens.padding286
import com.kashif.weathertestnooro.ui.theme.Dimens.padding47
import com.kashif.weathertestnooro.ui.theme.Dimens.size10
import com.kashif.weathertestnooro.ui.theme.TextColorDark
import com.kashif.weathertestnooro.utils.Poppins

/**
 * Created by Mohammad Kashif Ansari on 17,December,2024
 */
@Composable
fun NoCitySelected() {
    // Column is used to arrange elements vertically
    Column(
        modifier = Modifier
            .fillMaxWidth() // Make the column take up the full width of the parent
            .padding(top = padding286, start = padding47, end = padding47, bottom = 0.dp), // Set padding around the column
        horizontalAlignment = Alignment.CenterHorizontally // Align elements horizontally to the center
    ) {
        // First Text: Displays the message when no city is selected
        Text(
            text = stringResource(R.string.no_city_selected), // Text from resources
            style = TextStyle(
                fontFamily = Poppins, // Set font family to Poppins
                fontWeight = FontWeight.SemiBold, // Set font weight to SemiBold
                fontSize = font30, // Set font size for the message
                lineHeight = lineHeight45, // Set the line height
                textAlign = TextAlign.Center // Center-align the text
            ),
            color = TextColorDark, // Set text color to dark
        )

        // Spacer to provide vertical spacing between the two texts
        Spacer(modifier = Modifier.height(size10))

        // Second Text: Prompt to search for a city
        Text(
            text = stringResource(R.string.please_search_for_a_city), // Text from resources
            style = TextStyle(
                fontFamily = Poppins, // Set font family to Poppins
                fontWeight = FontWeight.SemiBold, // Set font weight to SemiBold
                fontSize = font15, // Set font size for the prompt
                lineHeight = lineHeight22, // Set line height
                textAlign = TextAlign.Center // Center-align the text
            ),
            color = TextColorDark, // Set text color to dark
        )
    }
}