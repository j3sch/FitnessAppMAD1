package de.hdmstuttgart.fitnessapp.database.entities.relations

import androidx.room.ColumnInfo
import androidx.room.Entity

@Entity(tableName = "ExerciseTrainingsPlanCrossRef", primaryKeys = ["ExerciseId", "TrainingsPlanId"])
data class ExerciseTrainingsPlanCrossRef(
    @ColumnInfo(name = "ExerciseId") val exerciseId: Int,
    @ColumnInfo(name = "TrainingsPlanId")val trainingsPlanId: Int
)