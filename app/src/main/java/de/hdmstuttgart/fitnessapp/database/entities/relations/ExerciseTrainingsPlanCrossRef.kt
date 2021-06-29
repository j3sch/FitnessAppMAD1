package de.hdmstuttgart.fitnessapp.database.entities.relations

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "ExerciseTrainingsPlanCrossRef", primaryKeys = ["ExerciseId", "TrainingsPlanId"])
data class ExerciseTrainingsPlanCrossRef(
    @ColumnInfo(name = "ExerciseId") val exerciseId: Int,
    @ColumnInfo(name = "TrainingsPlanId")val trainingsPlanId: Int
)