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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.kashif.weathertestnooro.R
import com.kashif.weathertestnooro.data.model.WeatherResponse
import com.kashif.weathertestnooro.ui.theme.BoxColor
import com.kashif.weathertestnooro.ui.theme.Dimens.cornerRadius
import com.kashif.weathertestnooro.ui.theme.Dimens.font12
import com.kashif.weathertestnooro.ui.theme.Dimens.font15
import com.kashif.weathertestnooro.ui.theme.Dimens.font30
import com.kashif.weathertestnooro.ui.theme.Dimens.font70
import com.kashif.weathertestnooro.ui.theme.Dimens.lineHeight105
import com.kashif.weathertestnooro.ui.theme.Dimens.lineHeight18
import com.kashif.weathertestnooro.ui.theme.Dimens.lineHeight22
import com.kashif.weathertestnooro.ui.theme.Dimens.lineHeight45
import com.kashif.weathertestnooro.ui.theme.Dimens.padding20
import com.kashif.weathertestnooro.ui.theme.Dimens.padding21
import com.kashif.weathertestnooro.ui.theme.Dimens.padding30
import com.kashif.weathertestnooro.ui.theme.Dimens.size10
import com.kashif.weathertestnooro.ui.theme.Dimens.size123
import com.kashif.weathertestnooro.ui.theme.Dimens.size21
import com.kashif.weathertestnooro.ui.theme.Dimens.size4
import com.kashif.weathertestnooro.ui.theme.Dimens.size8
import com.kashif.weathertestnooro.ui.theme.TextColorDark
import com.kashif.weathertestnooro.ui.theme.TextColorLight
import com.kashif.weathertestnooro.ui.theme.TextColorLight2
import com.kashif.weathertestnooro.utils.Poppins
import com.kashif.weathertestnooro.utils.Resources

/**
 * Created by Mohammad Kashif Ansari on 17,December,2024
 */
@Composable
fun WeatherIconWithTemperature(weatherState: Resources<WeatherResponse>?) {
    // Check if weather data is available
    if (weatherState?.data != null) {
        val weatherData = weatherState.data

        // Column to display the weather details vertically, aligned in the center
        Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.padding(top = padding21)) {

            // Weather Icon (Sun, Clouds, etc.)
            Box(contentAlignment = Alignment.Center) {
                AsyncImage(
                    model = "https:" + weatherData.current.condition.icon, // URL of the weather icon
                    contentDescription = "Weather Icon",
                    modifier = Modifier.size(size123) // Set size for the image
                )
            }

            // Location and Temperature
            Row(horizontalArrangement = Arrangement.Center, verticalAlignment = Alignment.CenterVertically) {
                Text(
                    text = weatherData.location.name, // Display location name
                    Modifier.testTag("name"),
                    style = TextStyle(
                        fontFamily = Poppins,
                        fontWeight = FontWeight.SemiBold,
                        fontSize = font30,
                        lineHeight = lineHeight45,
                        color = TextColorDark
                    ),
                )
                Spacer(modifier = Modifier.width(size10)) // Spacer between location and the icon
                Icon(
                    painter = painterResource(R.drawable.arrow), // Arrow icon for direction
                    contentDescription = "Search",
                    modifier = Modifier.size(size21)
                )
            }

            Spacer(modifier = Modifier.height(size8)) // Spacer between location and temperature

            // Temperature display
            Row(horizontalArrangement = Arrangement.Center) {
                Text(
                    text = weatherData.current.temp_c.toString(), // Display current temperature
                    Modifier.testTag("temp"),
                    style = TextStyle(
                        fontFamily = Poppins,
                        fontWeight = FontWeight.Medium,
                        fontSize = font70,
                        lineHeight = lineHeight105,
                        textAlign = TextAlign.Center,
                        color = TextColorDark
                    )
                )
                Icon(
                    painter = painterResource(R.drawable.degree_symbol), // Degree symbol
                    contentDescription = "degree",
                    tint = TextColorDark,
                    modifier = Modifier.size(size8)
                )
            }

            // Spacer to separate the temperature and weather statistics
            Box(modifier = Modifier
                .fillMaxWidth()
                .padding(padding30), contentAlignment = Alignment.Center) {

                // Weather statistics (humidity, UV, feels like)
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(cornerRadius)) // Rounded corners for the box
                        .background(BoxColor)
                        .padding(vertical = padding20),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceAround,
                ) {
                    // Humidity information
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Text(
                            stringResource(R.string.humidity),
                            style = TextStyle(
                                fontFamily = Poppins,
                                fontWeight = FontWeight.Medium,
                                fontSize = font12,
                                lineHeight = lineHeight18,
                                textAlign = TextAlign.Center,
                                color = TextColorLight
                            )
                        )
                        Spacer(modifier = Modifier.height(size4)) // Spacer between label and value
                        Text(
                            weatherData.current.humidity.toString() + stringResource(R.string.percentage_symbol),
                            Modifier.testTag("humidity"),
                            style = TextStyle(
                                fontFamily = Poppins,
                                fontWeight = FontWeight.Medium,
                                fontSize = font15,
                                lineHeight = lineHeight22,
                                textAlign = TextAlign.Center,
                                color = TextColorLight2
                            )
                        )
                    }

                    // UV Index information
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Text(
                            stringResource(R.string.uv),
                            style = TextStyle(
                                fontFamily = Poppins,
                                fontWeight = FontWeight.Medium,
                                fontSize = font12,
                                lineHeight = lineHeight18,
                                textAlign = TextAlign.Center,
                                color = TextColorLight
                            )
                        )
                        Spacer(modifier = Modifier.height(size4)) // Spacer between label and value
                        Text(
                            weatherData.current.uv.toString(),
                            Modifier.testTag("uv"),
                            style = TextStyle(
                                fontFamily = Poppins,
                                fontWeight = FontWeight.Medium,
                                fontSize = font15,
                                lineHeight = lineHeight22,
                                textAlign = TextAlign.Center,
                                color = TextColorLight2
                            )
                        )
                    }

                    // Feels Like temperature information
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Text(
                            stringResource(R.string.feels_like),
                            style = TextStyle(
                                fontFamily = Poppins,
                                fontWeight = FontWeight.Medium,
                                fontSize = font12,
                                lineHeight = lineHeight18,
                                textAlign = TextAlign.Center,
                                color = TextColorLight
                            )
                        )
                        Spacer(modifier = Modifier.height(size4)) // Spacer between label and value
                        Text(
                            weatherData.current.feelsLike.toString() + stringResource(R.string.degree_symbol),
                            Modifier.testTag("feels"),
                            style = TextStyle(
                                fontFamily = Poppins,
                                fontWeight = FontWeight.Medium,
                                fontSize = font15,
                                lineHeight = lineHeight22,
                                textAlign = TextAlign.Center,
                                color = TextColorLight2
                            )
                        )
                    }
                }
            }
        }
    }
}