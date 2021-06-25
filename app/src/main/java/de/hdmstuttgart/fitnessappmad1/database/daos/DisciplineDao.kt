package de.hdmstuttgart.fitnessapp.database.daos

import androidx.room.*
import de.hdmstuttgart.fitnessapp.database.entities.Discipline
import de.hdmstuttgart.fitnessapp.database.entities.relations.DisciplineWithExercises

@Dao
interface DisciplineDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertOrUpdateDiscipline(discipline: Discipline)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertListOfDisciplines(disciplineList: List<Discipline>)

    @Delete
    suspend fun deleteDiscipline(discipline: Discipline)

    @Query("SELECT * FROM Disciplines ORDER BY DisciplineId ASC")
    suspend fun getAllDisciplines(): List<Discipline>

    @Transaction
    @Query("SELECT * FROM Disciplines WHERE DisciplineId = :disciplineId")
    suspend fun getExercisesForDiscipline(disciplineId: Int): List<DisciplineWithExercises>
}