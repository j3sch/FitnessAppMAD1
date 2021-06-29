package de.hdmstuttgart.fitnessapp.database.daos

import androidx.lifecycle.LiveData
import androidx.room.*
import de.hdmstuttgart.fitnessapp.database.entities.Discipline
import de.hdmstuttgart.fitnessapp.database.entities.relations.DisciplineWithExercises
import kotlinx.coroutines.flow.Flow

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

    @Query("SELECT * FROM Disciplines WHERE Name = :name")
    suspend fun getDisciplineByName(name: String): Discipline

    @Transaction
    @Query("SELECT * FROM Disciplines WHERE DisciplineId = :disciplineId")
    suspend fun getExercisesForDiscipline(disciplineId: Int): List<DisciplineWithExercises>
}