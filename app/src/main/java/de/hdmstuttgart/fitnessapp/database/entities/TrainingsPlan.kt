package de.hdmstuttgart.fitnessapp.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "TrainingsPlans")
data class TrainingsPlan(
        @PrimaryKey(autoGenerate = true)
        @ColumnInfo(name = "TrainingsPlanId") val trainingsPlanId: Int,
        @ColumnInfo(name = "Name") val name: String,
        @ColumnInfo(name = "Date") val date: String
){
        constructor(name: String, date: String): this(0, name, date)
}