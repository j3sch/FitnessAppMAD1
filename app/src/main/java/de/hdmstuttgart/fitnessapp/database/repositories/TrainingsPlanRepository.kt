package de.hdmstuttgart.fitnessapp.database.repositories

import de.hdmstuttgart.fitnessapp.database.daos.TrainingsPlanDao
import de.hdmstuttgart.fitnessapp.database.entities.TrainingsPlan

class TrainingsPlanRepository (private val trainingsPlanDao: TrainingsPlanDao) {

    suspend fun insertTrainingsPlan(trainingsPlan: TrainingsPlan) = trainingsPlanDao.insertOrUpdateTrainingsPlan(trainingsPlan)

    suspend fun updateTrainingsPlan(trainingsPlan: TrainingsPlan) = trainingsPlanDao.insertOrUpdateTrainingsPlan(trainingsPlan)

    suspend fun deleteTrainingsPlan(trainingsPlan: TrainingsPlan) = trainingsPlanDao.deleteTrainingsPlan(trainingsPlan)

    suspend fun getAllTrainingsPlans() = trainingsPlanDao.getAllTrainingsPlans()

    suspend fun getExercisesForTrainingsPlan(trainingsPlan: TrainingsPlan) = trainingsPlanDao.getExercisesForTrainingsPlan(trainingsPlan.trainingsPlanId).first().exercises

}