package de.hdmstuttgart.fitnessapp.database.viewmodels

import android.app.Application
import androidx.lifecycle.*
import de.hdmstuttgart.fitnessapp.database.DataBase
import de.hdmstuttgart.fitnessapp.database.entities.Discipline
import de.hdmstuttgart.fitnessapp.database.entities.Exercise
import de.hdmstuttgart.fitnessapp.database.repositories.DisciplineRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

class DisciplineViewModel(private val repository: DisciplineRepository) : ViewModel() {
    var allExercisesForDiscipline: List<Exercise> = emptyList()

    fun insertDiscipline(discipline: Discipline) = viewModelScope.launch {
        repository.insertDiscipline(discipline)
    }

    fun insertDisciplineList(disciplines: List<Discipline>) = viewModelScope.launch {
        repository.insertListOfDisciplines(disciplines)
    }

    fun updateDiscipline(discipline: Discipline) = viewModelScope.launch {
        repository.updateDiscipline(discipline)
    }

    fun deleteDiscipline(discipline: Discipline) = viewModelScope.launch {
        repository.deleteDiscipline(discipline)
    }

    fun getAllDisciplines(): List<Discipline> {
        return repository.getAllDisciplines()
    }

    fun getAllDisciplines(name: String): Discipline {
        return repository.getDisciplineByName(name)
    }

    fun getExercisesForDiscipline(discipline: Discipline) = viewModelScope.launch {
        allExercisesForDiscipline = repository.getExercisesForDiscipline(discipline)
    }
}