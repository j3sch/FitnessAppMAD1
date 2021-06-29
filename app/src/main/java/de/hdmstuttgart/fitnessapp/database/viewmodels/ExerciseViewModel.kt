package de.hdmstuttgart.fitnessapp.database.viewmodels

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import de.hdmstuttgart.fitnessapp.database.DataBase
import de.hdmstuttgart.fitnessapp.database.entities.Discipline
import de.hdmstuttgart.fitnessapp.database.entities.Exercise
import de.hdmstuttgart.fitnessapp.database.repositories.ExerciseRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

class ExerciseViewModel(private val repository: ExerciseRepository) : ViewModel() {
    fun insertExercise(exercise: Exercise) = viewModelScope.launch {
        repository.insertExercise(exercise)
    }

    fun insertExerciseList(exercises: List<Exercise>) = viewModelScope.launch {
        repository.insertListOfExercises(exercises)
    }

    fun updateExercise(exercise: Exercise) = viewModelScope.launch {
        repository.updateExercise(exercise)
    }

    fun deleteExercise(exercise: Exercise) = viewModelScope.launch {
        repository.deleteExercise(exercise)
    }

    fun getAllExercises(): LiveData<List<Exercise>> {
        val result = MutableLiveData<List<Exercise>>()
        viewModelScope.launch {
            result.postValue(repository.getAllExercises())
        }
        return result
    }

    fun getAllExercisesByDiscipline(discipline: Discipline) : LiveData<List<Exercise>> {
        val result = MutableLiveData<List<Exercise>>()
        viewModelScope.launch {
            result.postValue(repository.getAllExercisesByDiscipline(discipline))
        }
        return result
    }
}