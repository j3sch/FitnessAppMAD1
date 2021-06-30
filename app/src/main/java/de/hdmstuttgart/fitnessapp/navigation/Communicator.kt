package de.hdmstuttgart.fitnessapp.navigation

import de.hdmstuttgart.fitnessapp.database.entities.Exercise

interface Communicator {

    fun switchToCountdown()

    fun switchToHome()

    fun switchToOverview()

    fun switchToHistory()

    fun switchToFinish()

    fun switchToConfigureTraining()

    fun switchToExerciseDescription(exercise: Exercise, TO_SCREEN: String)

    fun switchToSettings()
}