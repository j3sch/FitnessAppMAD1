package de.hdmstuttgart.fitnessappmad1.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import de.hdmstuttgart.fitnessappmad1.model.Exercise
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


@Database(entities = [Exercise::class], version = 1)
abstract class ExerciseRoomDatabase : RoomDatabase() {

    abstract fun exerciseDao(): ExerciseDao

    companion object {
        @Volatile
        private var INSTANCE: ExerciseRoomDatabase? = null

        fun getDatabase(
            context: Context,
            scope: CoroutineScope
        ): ExerciseRoomDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    ExerciseRoomDatabase::class.java,
                    "exercise_database"
                )
                    .fallbackToDestructiveMigration()
                    .addCallback(WordDatabaseCallback(scope))
                    .build()
                INSTANCE = instance
                instance
            }
        }

        private class WordDatabaseCallback(
            private val scope: CoroutineScope
        ) : RoomDatabase.Callback() {

            override fun onCreate(db: SupportSQLiteDatabase) {
                super.onCreate(db)

                INSTANCE?.let { database ->
                    scope.launch(Dispatchers.IO) {
                        populateDatabase(database.exerciseDao())
                    }
                }
            }
        }

        suspend fun populateDatabase(wordDao: ExerciseDao) {

            wordDao.deleteAll()

            val exerciseList = mutableListOf(
                Exercise("Liegestuetzen", "..."),
            )

            for (exercise in exerciseList) {
                wordDao.insert(exercise)
            }
        }
    }
}
