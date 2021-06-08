package de.hdmstuttgart.fitnessappmad1.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import de.hdmstuttgart.fitnessappmad1.model.Exercise
import kotlinx.coroutines.flow.Flow

@Dao
interface ExerciseDao {

    @Query("SELECT * FROM exercise_table ORDER BY titel ASC")
    fun readAllExercises(): Flow<List<Exercise>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(word: Exercise)

    @Query("DELETE FROM exercise_table")
    suspend fun deleteAll()
}
