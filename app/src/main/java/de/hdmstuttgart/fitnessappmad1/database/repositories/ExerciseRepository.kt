package de.hdmstuttgart.fitnessapp.database.repositories

import androidx.annotation.WorkerThread
import androidx.lifecycle.LiveData
import de.hdmstuttgart.fitnessapp.database.daos.ExerciseDao
import de.hdmstuttgart.fitnessapp.database.entities.Discipline
import de.hdmstuttgart.fitnessapp.database.entities.Exercise


class ExerciseRepository (private val exerciseDao: ExerciseDao) {

    suspend fun insertExercise(exercise: Exercise) = exerciseDao.insertOrUpdateExercise(exercise)

    suspend fun insertListOfExercises(exerciseList: List<Exercise>) = exerciseDao.insertListOfExercises(exerciseList)

    suspend fun updateExercise(exercise: Exercise) = exerciseDao.insertOrUpdateExercise(exercise)

    suspend fun deleteExercise(exercise: Exercise) = exerciseDao.deleteExercise(exercise)

    suspend fun getAllExercises() = exerciseDao.getAllExercises()

    suspend fun getAllExercisesByDiscipline(discipline: Discipline): List<Exercise> = exerciseDao.getAllExercisesByDiscipline(discipline.disciplineId)
}