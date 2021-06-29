package de.hdmstuttgart.fitnessapp.database.viewmodels

import androidx.lifecycle.*
import de.hdmstuttgart.fitnessapp.database.entities.Discipline
import de.hdmstuttgart.fitnessapp.database.entities.Exercise
import de.hdmstuttgart.fitnessapp.database.entities.relations.DisciplineWithExercises
import de.hdmstuttgart.fitnessapp.database.repositories.DisciplineRepository
import kotlinx.coroutines.launch

class DisciplineViewModel(private val repository: DisciplineRepository) : ViewModel() {

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

    fun getAllDisciplines(): LiveData<List<Discipline>> {
        val result = MutableLiveData<List<Discipline>>()
        viewModelScope.launch {
            result.postValue(repository.getAllDisciplines())
        }
        return result
    }

    fun getDisciplineByName(name: String): LiveData<Discipline> {
        val result = MutableLiveData<Discipline>()
        viewModelScope.launch {
            result.postValue(repository.getDisciplineByName(name))
        }
        return result
    }

    fun getExercisesForDiscipline(discipline: Discipline): LiveData<List<DisciplineWithExercises>> {
        val result = MutableLiveData<List<DisciplineWithExercises>>()
        viewModelScope.launch {
            result.postValue(repository.getExercisesForDiscipline(discipline))
        }
        return result
    }
}