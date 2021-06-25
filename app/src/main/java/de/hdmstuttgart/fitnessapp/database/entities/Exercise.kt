package de.hdmstuttgart.fitnessapp.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Exercises")
data class Exercise(
        @PrimaryKey
        @ColumnInfo(name = "ExerciseId") val exerciseId: Int,
        @ColumnInfo(name = "Name") val name: String,
        @ColumnInfo(name = "Description") val description: String,
        @ColumnInfo(name = "Equipment") val equipment: String,
        @ColumnInfo(name = "Setup") val setup: String,
        @ColumnInfo(name = "Division") val division: String,
        @ColumnInfo(name = "Duration") val duration: Int,
        @ColumnInfo(name = "DisciplineId") val disciplineId: Int
)