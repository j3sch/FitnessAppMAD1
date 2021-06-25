package de.hdmstuttgart.fitnessapp.database.entities.relations

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation
import de.hdmstuttgart.fitnessapp.database.entities.Discipline
import de.hdmstuttgart.fitnessapp.database.entities.Exercise
import de.hdmstuttgart.fitnessapp.database.entities.TrainingsPlan

data class TrainingsPlanWithExercises(
    @Embedded val trainingsPlan: TrainingsPlan,
    @Relation(
        parentColumn = "TrainingsPlanId",
        entityColumn = "ExerciseId",
        associateBy = Junction(ExerciseTrainingsPlanCrossRef::class)
    )
    val exercises: List<Exercise>
)