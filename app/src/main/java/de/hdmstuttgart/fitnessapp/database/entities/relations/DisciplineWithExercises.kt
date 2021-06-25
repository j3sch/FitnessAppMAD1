package de.hdmstuttgart.fitnessapp.database.entities.relations

import androidx.room.Embedded
import androidx.room.Relation
import de.hdmstuttgart.fitnessapp.database.entities.Discipline
import de.hdmstuttgart.fitnessapp.database.entities.Exercise

data class DisciplineWithExercises (
    @Embedded val discipline: Discipline,
    @Relation(
        parentColumn = "DisciplineId",
        entityColumn = "DisciplineId"
    )
    val exercises: List<Exercise>
)