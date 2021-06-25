package de.hdmstuttgart.fitnessapp.database.entities.relations

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation
import de.hdmstuttgart.fitnessapp.database.entities.Exercise
import de.hdmstuttgart.fitnessapp.database.entities.TrainingsPlan


data class ExerciseWithTrainingsPlans(
    @Embedded val exercise: Exercise,
    @Relation(
        parentColumn = "ExerciseId",
        entityColumn = "TrainingsPlanId",
        associateBy = Junction(ExerciseTrainingsPlanCrossRef::class)
    )
    val trainingsPlans: List<TrainingsPlan>
)