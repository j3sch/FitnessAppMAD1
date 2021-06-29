package de.hdmstuttgart.fitnessapp.datastore

import android.content.Context
import android.util.Log
import androidx.datastore.DataStore
import androidx.datastore.preferences.Preferences
import androidx.datastore.preferences.createDataStore
import androidx.datastore.preferences.edit
import androidx.datastore.preferences.preferencesKey
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import java.io.IOException

const val PREFERENCE_NAME = "_my_preferences"

class DataStoreRepository(context: Context) {

    private object PreferenceKeys {
        val trainingLength = preferencesKey<Float>("trainingLength")
        val firstSliderValue = preferencesKey<Float>("firstSliderValue")
        val secondSliderValue = preferencesKey<Float>("secondSliderValue")
        val isNotificationEnabled = preferencesKey<Boolean>("isNotificationEnabled")
    }

    private val dataStore: DataStore<Preferences> = context.createDataStore(name = PREFERENCE_NAME)

     suspend fun saveTrainingLength(trainingLength: Float) {
        dataStore.edit { preference ->
            preference[PreferenceKeys.trainingLength] = trainingLength
        }
    }

    suspend fun saveSliderValues(firstSliderValue: Float, secondSliderValue: Float) {
        dataStore.edit { preference ->
            preference[PreferenceKeys.firstSliderValue] = firstSliderValue
            preference[PreferenceKeys.secondSliderValue] = secondSliderValue
        }
    }

    suspend fun saveNotificationEnabledStatus(isNotificationEnabled: Boolean) {
        dataStore.edit { preference ->
            preference[PreferenceKeys.isNotificationEnabled] = isNotificationEnabled
        }
    }

    val readTrainingLength: Flow<Float> = dataStore.data
        .catch { exception ->
            if (exception is IOException) {
                Log.d("DataStore", exception.message.toString())
            } else {
                throw exception
            }
        }
        .map { preference ->
            val value: Float = preference[PreferenceKeys.trainingLength] ?: 3.00F
            value
    }

    val readFirstSliderValue: Flow<Float> = dataStore.data
        .catch { exception ->
            if (exception is IOException) {
                Log.d("DataStore", exception.message.toString())
            } else {
                throw exception
            }
        }
        .map { preference ->
            val value: Float = preference[PreferenceKeys.firstSliderValue] ?: 0F
            value
    }

    val readSecondSliderValue: Flow<Float> = dataStore.data
        .catch { exception ->
            if (exception is IOException) {
                Log.d("DataStore", exception.message.toString())
            } else {
                throw exception
            }
        }
        .map { preference ->
            val value: Float = preference[PreferenceKeys.secondSliderValue] ?: 0F
            value
    }

    val readIsNotificationEnabled: Flow<Boolean> = dataStore.data
        .catch { exception ->
            if (exception is IOException) {
                Log.d("DataStore", exception.message.toString())
            } else {
                throw exception
            }
        }
        .map { preference ->
            val value: Boolean = preference[PreferenceKeys.isNotificationEnabled] ?: true
            value
        }
}