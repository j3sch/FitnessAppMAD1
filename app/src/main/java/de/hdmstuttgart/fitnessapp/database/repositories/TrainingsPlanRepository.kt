package de.hdmstuttgart.fitnessapp.database.repositories

import de.hdmstuttgart.fitnessapp.database.daos.TrainingsPlanDao
import de.hdmstuttgart.fitnessapp.database.entities.Exercise
import de.hdmstuttgart.fitnessapp.database.entities.TrainingsPlan
import de.hdmstuttgart.fitnessapp.database.entities.relations.TrainingsPlanWithExercises
import kotlinx.coroutines.flow.Flow

class TrainingsPlanRepository (private val trainingsPlanDao: TrainingsPlanDao) {

    suspend fun insertTrainingsPlan(trainingsPlan: TrainingsPlan) : Long = trainingsPlanDao.insertOrUpdateTrainingsPlan(trainingsPlan)

    suspend fun updateTrainingsPlan(trainingsPlan: TrainingsPlan) = trainingsPlanDao.insertOrUpdateTrainingsPlan(trainingsPlan)

    suspend fun deleteTrainingsPlan(trainingsPlan: TrainingsPlan) = trainingsPlanDao.deleteTrainingsPlan(trainingsPlan)

    fun getAllTrainingsPlans(): Flow<List<TrainingsPlan>> = trainingsPlanDao.getAllTrainingsPlans()

    fun getExercisesForTrainingsPlan(trainingsPlan: TrainingsPlan): Flow<List<Exercise>> = trainingsPlanDao.getExercisesForTrainingsPlan(trainingsPlan.trainingsPlanId)

}