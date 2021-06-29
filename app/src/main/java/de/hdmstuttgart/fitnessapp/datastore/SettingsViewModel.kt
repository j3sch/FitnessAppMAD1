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

    fun saveTrainingLength(value: Float) = viewModelScope.launch(Dispatchers.IO) {
        repository.saveTrainingLength(value)
    }

    fun saveSliderValues(firstSliderValue: Float, secondSliderValue: Float) = viewModelScope.launch(Dispatchers.IO) {
        repository.saveSliderValues(firstSliderValue, secondSliderValue)
    }
}