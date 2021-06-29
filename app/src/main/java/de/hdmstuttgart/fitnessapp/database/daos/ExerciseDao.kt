package de.hdmstuttgart.fitnessapp.database.daos

import androidx.room.*
import de.hdmstuttgart.fitnessapp.database.entities.Exercise

@Dao
interface ExerciseDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertOrUpdateExercise(exercise: Exercise)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertListOfExercises(exercisesList: List<Exercise>)

    @Delete
    suspend fun deleteExercise(exercise: Exercise)

    @Query("SELECT * FROM Exercises ORDER BY ExerciseId ASC")
    fun getAllExercises(): List<Exercise>

    @Query("SELECT * FROM Exercises WHERE DisciplineId = :disciplineId")
    fun getAllExercisesByDiscipline(disciplineId: Int): List<Exercise>


}