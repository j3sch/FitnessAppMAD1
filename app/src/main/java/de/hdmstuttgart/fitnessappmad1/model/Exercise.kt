
package de.hdmstuttgart.fitnessappmad1.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "exercise_table")
data class Exercise (
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val titel: String,
    val description: String

)
