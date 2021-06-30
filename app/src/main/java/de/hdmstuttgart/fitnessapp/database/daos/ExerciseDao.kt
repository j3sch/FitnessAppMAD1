package de.hdmstuttgart.fitnessapp.database.daos

import androidx.lifecycle.LiveData
import androidx.room.*
import de.hdmstuttgart.fitnessapp.database.entities.Exercise
import de.hdmstuttgart.fitnessapp.database.entities.relations.DisciplineWithExercises
import kotlinx.coroutines.flow.Flow

@Dao
interface ExerciseDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertOrUpdateExercise(exercise: Exercise)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertListOfExercises(exercisesList: List<Exercise>)

    @Delete
    suspend fun deleteExercise(exercise: Exercise)

    @Query ("SELECT * FROM Exercises WHERE ExerciseId = :exerciseId")
    suspend fun getExerciseById(exerciseId: Int): Exercise

    @Query("SELECT * FROM Exercises ORDER BY ExerciseId ASC")
    suspend fun getAllExercises(): List<Exercise>

    @Transaction
    @Query("SELECT * FROM Exercises WHERE DisciplineId = :disciplineId")
    suspend fun getAllExercisesByDiscipline(disciplineId: Int): DisciplineWithExercises
<<<<<<< HEAD
=======


>>>>>>> f604f76d8caa420a8fc0a332df682c4b758b9f2c
}