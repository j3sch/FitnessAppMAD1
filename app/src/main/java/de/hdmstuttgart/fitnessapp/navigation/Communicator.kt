package de.hdmstuttgart.fitnessapp.navigation

interface Communicator {

    fun switchToCountdown()

    fun switchToHome()

    fun switchToOverview()

    fun switchToHistory()

    fun switchToFinish()

    fun switchToConfigureTraining()

    fun switchToExerciseDescription()

    fun switchToSettings()
}