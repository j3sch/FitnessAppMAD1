package de.hdmstuttgart.fitnessapp.database.daos

import androidx.room.*
import de.hdmstuttgart.fitnessapp.database.entities.TrainingsPlan
import de.hdmstuttgart.fitnessapp.database.entities.relations.TrainingsPlanWithExercises

@Dao
interface TrainingsPlanDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertOrUpdateTrainingsPlan(trainingsPlan: TrainingsPlan): Long

    @Delete
    suspend fun deleteTrainingsPlan(trainingsPlan: TrainingsPlan)

    @Query("SELECT * FROM TrainingsPlans ORDER BY TrainingsPlanId ASC")
    suspend fun getAllTrainingsPlans(): List<TrainingsPlan>

    @Transaction
    @Query("SELECT * FROM TrainingsPlans WHERE TrainingsPlanId = :trainingsPlanId")
    suspend fun getExercisesForTrainingsPlan(trainingsPlanId: Int) : List<TrainingsPlanWithExercises>
}