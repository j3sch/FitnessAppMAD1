package de.hdmstuttgart.fitnessapp.database.viewmodels

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import de.hdmstuttgart.fitnessapp.database.DataBase
import de.hdmstuttgart.fitnessapp.database.entities.Discipline
import de.hdmstuttgart.fitnessapp.database.entities.Exercise
import de.hdmstuttgart.fitnessapp.database.entities.relations.DisciplineWithExercises
import de.hdmstuttgart.fitnessapp.database.repositories.DisciplineRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

class DisciplineViewModel(application: Application, scope: CoroutineScope) : ViewModel() {
    private val repository: DisciplineRepository

    var allDisciplines : List<Discipline> = emptyList()
    var allExercisesForDiscipline : List<Exercise> = emptyList()

    init {
        val disciplineDao = DataBase.getInstance(application, scope).disciplineDao()
        repository = DisciplineRepository(disciplineDao)
    }

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

    fun getAllDisciplines() = viewModelScope.launch {
        allDisciplines = repository.getAllDisciplines()
    }

    fun getExercisesForDiscipline(discipline: Discipline) = viewModelScope.launch {
        allExercisesForDiscipline = repository.getExercisesForDiscipline(discipline)
    }
}