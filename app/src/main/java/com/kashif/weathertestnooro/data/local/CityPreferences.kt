package com.kashif.weathertestnooro.data.local

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.dataStore
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import com.kashif.weathertestnooro.utils.Constants.SELECTED_CITY_PREFERENCE
import com.kashif.weathertestnooro.utils.Constants.WEATHER_PREF_NAME
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

/**
 * Created by Mohammad Kashif Ansari on 17,December,2024
 */

// Extension function to create a DataStore instance
val Context.dataStore: DataStore<androidx.datastore.preferences.core.Preferences> by preferencesDataStore(name = WEATHER_PREF_NAME)

class CityPreferences(private val context: Context) {


    // Define a key for the saved city
    companion object {
        private val CITY_KEY = stringPreferencesKey(SELECTED_CITY_PREFERENCE)
    }

//    // Retrieve the saved city as a Flow
    val getCity: Flow<String?> = context.dataStore.data
        .map { preferences ->
            preferences[CITY_KEY] // Return the saved city value, or null if not set
        }

    // Save a new city into DataStore
     suspend fun saveCity(city: String) {
        context.dataStore.edit { preferences ->
            preferences[CITY_KEY] = city
        }
    }

}