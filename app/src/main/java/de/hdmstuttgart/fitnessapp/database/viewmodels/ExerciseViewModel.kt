package de.hdmstuttgart.fitnessapp.database.viewmodels

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import de.hdmstuttgart.fitnessapp.database.DataBase
import de.hdmstuttgart.fitnessapp.database.entities.Discipline
import de.hdmstuttgart.fitnessapp.database.entities.Exercise
import de.hdmstuttgart.fitnessapp.database.repositories.ExerciseRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

class ExerciseViewModel(private val repository: ExerciseRepository) : ViewModel() {


    var allExercises: List<Exercise> = emptyList()
    var allExercisesByDiscipline: List<Exercise> = emptyList()

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

    fun getAllExercises() = viewModelScope.launch {
        allExercises = repository.getAllExercises()
    }

    fun getAllExercisesByDiscipline(discipline: Discipline) = viewModelScope.launch {
        allExercisesByDiscipline = repository.getAllExercisesByDiscipline(discipline)
    }
}