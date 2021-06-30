package de.hdmstuttgart.fitnessapp.navigation

import de.hdmstuttgart.fitnessapp.database.entities.Exercise
import de.hdmstuttgart.fitnessapp.database.entities.TrainingsPlan

interface Communicator {

    fun switchToCountdown(trainingsPlan: TrainingsPlan)

    fun switchToHome()

    fun switchToOverview(trainingsPlan: TrainingsPlan)

    fun switchToHistory()

    fun switchToFinish()

    fun switchToConfigureTraining()

    fun switchToExerciseDescription(exercise: Exercise)

    fun switchToSettings()
}