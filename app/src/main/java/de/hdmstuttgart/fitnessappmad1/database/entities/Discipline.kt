package de.hdmstuttgart.fitnessapp.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Disciplines")
data class Discipline(
    @PrimaryKey
    @ColumnInfo(name = "DisciplineId") val disciplineId: Int,
    @ColumnInfo(name = "Name") val name: String
)