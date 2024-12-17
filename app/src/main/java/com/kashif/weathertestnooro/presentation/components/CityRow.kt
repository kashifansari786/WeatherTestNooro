package com.kashif.weathertestnooro.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.kashif.weathertestnooro.R
import com.kashif.weathertestnooro.ui.theme.Black
import com.kashif.weathertestnooro.ui.theme.BoxColor
import com.kashif.weathertestnooro.ui.theme.Dimens.cornerRadius
import com.kashif.weathertestnooro.ui.theme.Dimens.font20
import com.kashif.weathertestnooro.ui.theme.Dimens.font60
import com.kashif.weathertestnooro.ui.theme.Dimens.lineHeight30
import com.kashif.weathertestnooro.ui.theme.Dimens.lineHeight90
import com.kashif.weathertestnooro.ui.theme.Dimens.padding10
import com.kashif.weathertestnooro.ui.theme.Dimens.padding15
import com.kashif.weathertestnooro.ui.theme.Dimens.padding25
import com.kashif.weathertestnooro.ui.theme.Dimens.size123
import com.kashif.weathertestnooro.ui.theme.Dimens.size5
import com.kashif.weathertestnooro.ui.theme.TextColorDark
import com.kashif.weathertestnooro.utils.Poppins

/**
 * Created by Mohammad Kashif Ansari on 17,December,2024
 */
@Composable
fun CityRow(
    cityName: String, // Name of the city to display
    temperature: Double, // Temperature to display
    weatherIconUrl: String, // URL for the weather icon image
    onCLick: () -> Unit // Lambda function that will be executed when the row is clicked
) {
    // Box is used to wrap the Row and other elements, allowing for flexible placement and layering
    Box(modifier = Modifier.fillMaxWidth().padding(start = padding25, end = padding25, top = padding10)) {
        // Row is used to display the content in a horizontal arrangement
        Row(
            modifier = Modifier
                .fillMaxWidth() // Make the row take the full width
                .clip(RoundedCornerShape(cornerRadius)) // Apply rounded corners to the row
                .background(BoxColor) // Set the background color of the row
                .padding(vertical = padding10) // Add padding to the vertical sides of the row
                .clickable { onCLick() } // Set a click listener to trigger the onCLick function
                .testTag("cityRow") // Assign a test tag for UI testing purposes
            ,
            horizontalArrangement = Arrangement.SpaceAround, // Distribute content evenly along the horizontal axis
            verticalAlignment = Alignment.CenterVertically // Align items vertically in the center
        ) {

            // Column used to arrange the text and temperature vertically
            Column(modifier = Modifier.padding(start = padding15, top = padding10)) {
                // Text for displaying the city name
                Text(
                    text = cityName,
                    style = TextStyle(
                        fontFamily = Poppins, // Set font family to Poppins
                        fontWeight = FontWeight.SemiBold, // Use semi-bold font weight
                        fontSize = font20, // Set font size
                        lineHeight = lineHeight30, // Set line height for text
                        color = TextColorDark // Set the color of the text
                    )
                )
                Spacer(modifier = Modifier.height(size5)) // Add spacing between city name and temperature
                // Row to display temperature and degree symbol side by side
                Row(horizontalArrangement = Arrangement.Center) {
                    // Text for displaying the temperature
                    Text(
                        text = "${temperature}",
                        style = TextStyle(
                            fontFamily = Poppins, // Set font family to Poppins
                            fontWeight = FontWeight.Medium, // Use medium font weight
                            fontSize = font60, // Set font size for temperature
                            lineHeight = lineHeight90, // Set line height for temperature text
                            color = TextColorDark // Set text color
                        )
                    )
                    // Icon for the degree symbol
                    Icon(
                        painter = painterResource(R.drawable.degree_symbol), // Degree icon
                        contentDescription = "degree", // Content description for accessibility
                        tint = Black, // Set icon tint color
                        modifier = Modifier.size(size5) // Set the size of the icon
                    )
                }
            }

            // AsyncImage for loading the weather icon from a URL asynchronously
            AsyncImage(
                model = "https:$weatherIconUrl", // Concatenate the base URL with the weather icon URL
                contentDescription = "Weather Icon", // Set the content description for accessibility
                modifier = Modifier.size(size123) // Set the size of the image
            )
        }
    }
}