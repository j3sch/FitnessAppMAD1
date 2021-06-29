package de.hdmstuttgart.fitnessapp.datastore

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class SettingsViewModel(application: Application): AndroidViewModel(application) {

    private val repository = DataStoreRepository(application)

    val readTrainingLength = repository.readTrainingLength.asLiveData()

    val readFirstSliderValue = repository.readFirstSliderValue.asLiveData()

    val readSecondSliderValue = repository.readSecondSliderValue.asLiveData()

    val readIsNotificationEnabled = repository.readIsNotificationEnabled.asLiveData()

    fun saveTrainingLength(trainingLength: Float) = viewModelScope.launch(Dispatchers.IO) {
        repository.saveTrainingLength(trainingLength)
    }

    fun saveSliderValues(firstSliderValue: Float, secondSliderValue: Float) = viewModelScope.launch(Dispatchers.IO) {
        repository.saveSliderValues(firstSliderValue, secondSliderValue)
    }

    fun saveIsNotificationEnabled(isNotificationEnabled: Boolean) = viewModelScope.launch(Dispatchers.IO) {
        repository.saveNotificationEnabledStatus(isNotificationEnabled)
    }
}