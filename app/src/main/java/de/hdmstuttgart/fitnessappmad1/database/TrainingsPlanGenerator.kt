package de.hdmstuttgart.fitnessapp.database

import android.app.Application
import de.hdmstuttgart.fitnessapp.database.entities.Discipline
import de.hdmstuttgart.fitnessapp.database.entities.Exercise
import de.hdmstuttgart.fitnessapp.database.repositories.ExerciseRepository
import de.hdmstuttgart.fitnessapp.database.viewmodels.ExerciseViewModel
import kotlinx.coroutines.CoroutineScope

class TrainingsPlanGenerator(
    val name: String,
    val maximumTime: Int,
    val disciplines: ArrayList<Discipline>,
    val application: Application,
    val scope: CoroutineScope
) {
    private var durationIntro: Float = 0F
    private var durationMain1: Float = 0F
    private var durationMain2: Float = 0F
    private var durationEnd: Float = 0F

    var trainingsPlan: ArrayList<Exercise> = arrayListOf()

    fun createTrainingsPlan(paramIntro: Float, paramMain: Float, paramEnd: Float) {
        durationIntro = maximumTime * paramIntro
        durationMain1 = (maximumTime * paramMain) / 2
        durationMain2 = durationMain1
        durationEnd = maximumTime * paramEnd

        //set Disciplines

        val times: FloatArray = floatArrayOf(durationIntro, durationMain1, durationMain2, durationEnd)
        for (discipline in disciplines) {
            val newExercises: ArrayList<Exercise> = getExercisesForDiscipline(discipline, durationIntro)


        }
    }

    private fun getExercisesForDiscipline(discipline: Discipline, duration: Float) : ArrayList<Exercise> {
        val exerciseViewModel = ExerciseViewModel(application, scope)
        var i = 0F
        val newExercises: ArrayList<Exercise> = arrayListOf()
        exerciseViewModel.getAllExercisesByDiscipline(discipline)
        val allExercises: List<Exercise> = exerciseViewModel.allExercises
        while (i <= duration) {
            val newExercise: Exercise = getRandomFromList(allExercises)
            if(!checkForDuplicateExercise(newExercise, newExercises)){
                i += newExercise.duration
                newExercises.add(newExercise)
            }
        }
        return newExercises
    }

    private fun getRandomFromList(list: List<Exercise>): Exercise {
        return list.random()
    }

    private fun checkForDuplicateExercise(newExercise: Exercise, newList : ArrayList<Exercise>): Boolean {
        for (existingExercise in newList) {
            if (existingExercise.exerciseId == newExercise.exerciseId) {
                return true
            }
        }
        return false
    }
}