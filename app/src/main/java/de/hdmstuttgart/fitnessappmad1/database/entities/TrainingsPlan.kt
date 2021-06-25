package de.hdmstuttgart.fitnessapp.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity(tableName = "TrainingsPlans")
data class TrainingsPlan(
        @PrimaryKey
        @ColumnInfo(name = "TrainingsPlanId") val trainingsPlanId: Int,
        @ColumnInfo(name = "Name") val name: String,
        @ColumnInfo(name = "Date") val date: String
)