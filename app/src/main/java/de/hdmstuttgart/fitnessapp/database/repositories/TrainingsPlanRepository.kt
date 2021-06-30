package de.hdmstuttgart.fitnessapp.database.repositories

import de.hdmstuttgart.fitnessapp.database.daos.TrainingsPlanDao
import de.hdmstuttgart.fitnessapp.database.entities.Discipline
import de.hdmstuttgart.fitnessapp.database.entities.Exercise
import de.hdmstuttgart.fitnessapp.database.entities.TrainingsPlan
import de.hdmstuttgart.fitnessapp.database.entities.relations.TrainingsPlanWithExercises
import kotlinx.coroutines.flow.Flow

class TrainingsPlanRepository (private val trainingsPlanDao: TrainingsPlanDao) {

    suspend fun insertTrainingsPlan(trainingsPlan: TrainingsPlan) : Long = trainingsPlanDao.insertOrUpdateTrainingsPlan(trainingsPlan)

    suspend fun updateTrainingsPlan(trainingsPlan: TrainingsPlan) = trainingsPlanDao.insertOrUpdateTrainingsPlan(trainingsPlan)

    suspend fun deleteTrainingsPlan(trainingsPlan: TrainingsPlan) = trainingsPlanDao.deleteTrainingsPlan(trainingsPlan)

    suspend fun getTrainingsPlanById(id: Int): TrainingsPlan = trainingsPlanDao.getTrainingsPlanById(id)

    fun getAllTrainingsPlans(): Flow<List<TrainingsPlan>> = trainingsPlanDao.getAllTrainingsPlans()

    suspend fun getExercisesForTrainingsPlanId(trainingsPlanId: Int): List<Exercise> {
        return trainingsPlanDao.getExercisesForTrainingsPlanId(trainingsPlanId).exercises
    }

}