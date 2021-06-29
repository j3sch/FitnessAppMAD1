package de.hdmstuttgart.fitnessapp.database.repositories

import de.hdmstuttgart.fitnessapp.database.daos.DisciplineDao
import de.hdmstuttgart.fitnessapp.database.entities.Discipline
import de.hdmstuttgart.fitnessapp.database.entities.Exercise
import de.hdmstuttgart.fitnessapp.database.entities.relations.DisciplineWithExercises
import kotlinx.coroutines.flow.Flow

class DisciplineRepository (private val disciplineDao: DisciplineDao) {


    suspend fun insertDiscipline(discipline: Discipline) = disciplineDao.insertOrUpdateDiscipline(discipline)

    suspend fun insertListOfDisciplines(disciplineList: List<Discipline>) = disciplineDao.insertListOfDisciplines(disciplineList)

    suspend fun updateDiscipline(discipline: Discipline) = disciplineDao.insertOrUpdateDiscipline(discipline)

    suspend fun deleteDiscipline(discipline: Discipline) = disciplineDao.deleteDiscipline(discipline)

    suspend fun getAllDisciplines(): List<Discipline> = disciplineDao.getAllDisciplines()

    suspend fun getDisciplineByName(name: String): Discipline = disciplineDao.getDisciplineByName(name)

    suspend fun getExercisesForDiscipline(discipline: Discipline): List<DisciplineWithExercises> = disciplineDao.getExercisesForDiscipline(discipline.disciplineId)
}