package de.hdmstuttgart.fitnessapp.database.viewmodels

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import de.hdmstuttgart.fitnessapp.database.DataBase
import de.hdmstuttgart.fitnessapp.database.entities.Exercise
import de.hdmstuttgart.fitnessapp.database.entities.TrainingsPlan
import de.hdmstuttgart.fitnessapp.database.repositories.TrainingsPlanRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

class TrainingsPlanViewModel(application: Application, scope: CoroutineScope) : ViewModel() {
    private val repository: TrainingsPlanRepository

    var allTrainingsPlans: List<TrainingsPlan> = emptyList()
    var exercisesByTrainingsPlan: List<Exercise> = emptyList()

    init {
        val trainingsPlanDao = DataBase.getInstance(application, scope).trainingsPlanDao()
        repository = TrainingsPlanRepository(trainingsPlanDao)
    }

    fun insertTrainingsPlan(trainingsPlan: TrainingsPlan) = viewModelScope.launch {
        repository.insertTrainingsPlan(trainingsPlan)
    }

    fun updateTrainingsPlan(trainingsPlan: TrainingsPlan) = viewModelScope.launch {
        repository.updateTrainingsPlan(trainingsPlan)
    }

    fun deleteTrainingsPlan(trainingsPlan: TrainingsPlan) = viewModelScope.launch {
        repository.deleteTrainingsPlan(trainingsPlan)
    }

    fun getAllTrainingsPlans() = viewModelScope.launch {
        allTrainingsPlans = repository.getAllTrainingsPlans()
    }

    fun getExercisesForTrainingsPlan(trainingsPlan: TrainingsPlan) = viewModelScope.launch {
        exercisesByTrainingsPlan = repository.getExercisesForTrainingsPlan(trainingsPlan)
    }
}