package de.hdmstuttgart.fitnessapp.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import de.hdmstuttgart.fitnessapp.database.TableData.populateDisciplineTable
import de.hdmstuttgart.fitnessapp.database.TableData.populateExerciseTable
import de.hdmstuttgart.fitnessapp.database.daos.DisciplineDao
import de.hdmstuttgart.fitnessapp.database.daos.ExerciseDao
import de.hdmstuttgart.fitnessapp.database.daos.TrainingsPlanDao
import de.hdmstuttgart.fitnessapp.database.entities.Discipline
import de.hdmstuttgart.fitnessapp.database.entities.Exercise
import de.hdmstuttgart.fitnessapp.database.entities.TrainingsPlan
import de.hdmstuttgart.fitnessapp.database.entities.relations.ExerciseTrainingsPlanCrossRef
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

private const val DB_NAME = "FitnessAppDatabase"

@Database(
    entities = [Exercise::class, Discipline::class, TrainingsPlan::class, ExerciseTrainingsPlanCrossRef::class],
    version = 1,
    exportSchema = false
)
abstract class DataBase : RoomDatabase() {

    abstract fun exerciseDao(): ExerciseDao
    abstract fun disciplineDao(): DisciplineDao
    abstract fun trainingsPlanDao(): TrainingsPlanDao

    private class DatabaseCallback(
        private val scope: CoroutineScope
    ) : RoomDatabase.Callback() {

        override fun onCreate(db: SupportSQLiteDatabase) {
            super.onCreate(db)

            instance?.let { database ->
                scope.launch {
                    val exerciseDao = database.exerciseDao()
                    val disciplineDao = database.disciplineDao()

                    exerciseDao.insertListOfExercises(populateExerciseTable())
                    disciplineDao.insertListOfDisciplines(populateDisciplineTable())
                }
            }
        }
    }

    companion object {
        @Volatile
        private var instance: DataBase? = null

        fun getInstance(context: Context, scope: CoroutineScope): DataBase {
            return instance ?: synchronized(this) {
                instance ?: buildDatabase(context, scope).also { instance = it }
            }
        }

        private fun buildDatabase(context: Context, scope: CoroutineScope): DataBase {
            return Room.databaseBuilder(context, DataBase::class.java, DB_NAME)
                .addCallback(DatabaseCallback(scope))
                .build()
        }

    }
}


