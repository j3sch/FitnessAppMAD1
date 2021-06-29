package de.hdmstuttgart.fitnessapp.database.daos

import androidx.room.*
import de.hdmstuttgart.fitnessapp.database.entities.Discipline
import de.hdmstuttgart.fitnessapp.database.entities.relations.ExerciseTrainingsPlanCrossRef

@Dao
interface ExerciseTPDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertOrUpdateCrossRef(crossRef: ExerciseTrainingsPlanCrossRef)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertListOfCrossRef(crossRefList: List<ExerciseTrainingsPlanCrossRef>)

    @Delete
    suspend fun deleteCrossRef(crossRef: ExerciseTrainingsPlanCrossRef)

    @Query("SELECT * FROM ExerciseTrainingsPlanCrossRef")
    fun getAllCrossRefs(): List<ExerciseTrainingsPlanCrossRef>
}