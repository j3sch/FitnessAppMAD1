package de.hdmstuttgart.fitnessappmad1.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import de.hdmstuttgart.fitnessappmad1.model.Exercise
import de.hdmstuttgart.fitnessappmad1.repository.ExerciseRepository
import kotlinx.coroutines.launch

class ExerciseViewModel (private val repository: ExerciseRepository) : ViewModel() {

    val readAllExercise: LiveData<List<Exercise>> = repository.readAllExercises.asLiveData()

    fun insert(exercise: Exercise) = viewModelScope.launch {
        repository.insert(exercise)
    }
}

class WordViewModelFactory(private val repository: ExerciseRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ExerciseViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return ExerciseViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
