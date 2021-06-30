package de.hdmstuttgart.fitnessapp.database.daos

import androidx.lifecycle.LiveData
import androidx.room.*
import de.hdmstuttgart.fitnessapp.database.entities.Discipline
import de.hdmstuttgart.fitnessapp.database.entities.TrainingsPlan
import de.hdmstuttgart.fitnessapp.database.entities.relations.TrainingsPlanWithExercises
import kotlinx.coroutines.flow.Flow

@Dao
interface TrainingsPlanDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertOrUpdateTrainingsPlan(trainingsPlan: TrainingsPlan): Long

    @Delete
    suspend fun deleteTrainingsPlan(trainingsPlan: TrainingsPlan)

    @Query("SELECT * FROM TrainingsPlans WHERE TrainingsPlanId = :id")
    suspend fun getTrainingsPlanById(id: Int): TrainingsPlan

    @Query("SELECT * FROM TrainingsPlans ORDER BY TrainingsPlanId ASC")
    fun getAllTrainingsPlans(): Flow<List<TrainingsPlan>>

    @Transaction
    @Query("SELECT * FROM TrainingsPlans WHERE TrainingsPlanId = :trainingsPlanId")
    fun getExercisesForTrainingsPlanId(trainingsPlanId: Int) : TrainingsPlanWithExercises
}