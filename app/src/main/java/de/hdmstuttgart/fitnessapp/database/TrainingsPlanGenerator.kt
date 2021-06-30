package de.hdmstuttgart.fitnessapp.database

import android.content.Context

import de.hdmstuttgart.fitnessapp.database.entities.Discipline
import de.hdmstuttgart.fitnessapp.database.entities.Exercise
import de.hdmstuttgart.fitnessapp.database.entities.TrainingsPlan
import de.hdmstuttgart.fitnessapp.database.entities.relations.ExerciseTrainingsPlanCrossRef
import de.hdmstuttgart.fitnessapp.database.repositories.DisciplineRepository
import de.hdmstuttgart.fitnessapp.database.repositories.ExerciseRepository
import de.hdmstuttgart.fitnessapp.database.repositories.ExerciseTPRepository
import de.hdmstuttgart.fitnessapp.database.repositories.TrainingsPlanRepository
import kotlinx.coroutines.CoroutineScope
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class TrainingsPlanGenerator(
    val context: Context,
    val scope: CoroutineScope
) {

    companion object {
        const val introDisciplineName = "Einleitung"
        const val outroDisciplineName = "Schluss"
        const val datePattern = "dd.MM.yyyy"
    }

    val dataBase = DataBase.getInstance(context, scope)
    var exercisesForTrainingsPlan: ArrayList<Exercise> = arrayListOf()
    private lateinit var newTrainingsPlan: TrainingsPlan

    //Repos and ViewModels
    private val disciplineRepo = DisciplineRepository(dataBase.disciplineDao())
    private val exerciseRepo = ExerciseRepository(dataBase.exerciseDao())
    private val trainingsPlanRepo = TrainingsPlanRepository(dataBase.trainingsPlanDao())
    private val exerciseTPRepo = ExerciseTPRepository(dataBase.exerciseTPDao())

    suspend fun createTrainingsPlan(
        name: String,
        maximumTime: Int,
        paramIntro: Float,
        paramMain: Float,
        paramOutro: Float
    ): TrainingsPlan {
        val date = LocalDateTime.now().format(DateTimeFormatter.ofPattern(datePattern))

        val trainingsPlan = TrainingsPlan(name, date)
        val newTrainingsPlanId = trainingsPlanRepo.insertTrainingsPlan(trainingsPlan)
        newTrainingsPlan = trainingsPlanRepo.getTrainingsPlanById(newTrainingsPlanId.toInt())

        val durationIntro = maximumTime * paramIntro
        val durationMain = (maximumTime * paramMain) / 2
        val durationOutro = maximumTime * paramOutro

        val disciplines: List<Discipline> = getDisciplinesForTrainingsPlan()
        println(disciplines[0].name + " " + disciplines[1].name + " " + disciplines[2].name + " " + disciplines[3].name)

        for (discipline in disciplines) {
            when (discipline.name) {
                introDisciplineName -> {
                    val exercises = getExercisesForDiscipline(discipline, durationIntro)
                    println(discipline.name)
                    printList(exercises)
                    exercisesForTrainingsPlan.addAll(exercises)
                }
                outroDisciplineName -> {
                    val exercises = getExercisesForDiscipline(discipline, durationOutro)
                    println(discipline.name)
                    printList(exercises)
                    exercisesForTrainingsPlan.addAll(exercises)
                }
                else -> {
                    val exercises = getExercisesForDiscipline(discipline, durationMain)
                    println(discipline.name)
                    printList(exercises)
                    exercisesForTrainingsPlan.addAll(exercises)
                }
            }
        }
        exerciseTPRepo.insertListOfCrossRef(getExerciseTrainingsPlanCrossRefs(newTrainingsPlan, exercisesForTrainingsPlan))

        return newTrainingsPlan
    }

    fun getNewTrainingsPlan(): TrainingsPlan {
        return newTrainingsPlan
    }

    private fun getExerciseTrainingsPlanCrossRefs(
        trainingsPlan: TrainingsPlan,
        trainingsPlanExercises: List<Exercise>
    ): List<ExerciseTrainingsPlanCrossRef> {
        val crossRefs = mutableListOf<ExerciseTrainingsPlanCrossRef>()
        for (exercise in trainingsPlanExercises) {
            crossRefs.add(
                ExerciseTrainingsPlanCrossRef(
                    exercise.exerciseId,
                    trainingsPlan.trainingsPlanId
                )
            )
        }
        return crossRefs
    }

    private suspend fun getDisciplinesForTrainingsPlan(): List<Discipline> {
        val disciplines = mutableListOf<Discipline>()
        disciplines.add(disciplineRepo.getDisciplineByName(introDisciplineName))
        val allDisciplines = disciplineRepo.getAllDisciplines().toMutableList()
        val firstDiscipline = getRandomDisciplineFromList(allDisciplines)
        allDisciplines.remove(firstDiscipline)
        val secondDiscipline = getRandomDisciplineFromList(allDisciplines)
        disciplines.add(firstDiscipline)
        disciplines.add(secondDiscipline)
        disciplines.add(disciplineRepo.getDisciplineByName(outroDisciplineName))
        return disciplines
    }

    private fun getRandomDisciplineFromList(disciplines: List<Discipline>): Discipline {
        val disc = getRandomFromList(disciplines)
        return if (disc.name != introDisciplineName && disc.name != outroDisciplineName) {
            disc
        } else getRandomDisciplineFromList(disciplines)
    }

    private suspend fun getExercisesForDiscipline(
        discipline: Discipline,
        maxDuration: Float
    ): MutableList<Exercise> {
        val pauseExercise: Exercise = exerciseRepo.getExerciseById(100)
        var currentDuration = 0F
        val durationThreshold = 1.1F * maxDuration
        val newExercises: MutableList<Exercise> = mutableListOf()
        val allExercises = exerciseRepo.getAllExercisesByDiscipline(discipline).toMutableList()
        while (currentDuration < maxDuration && allExercises.size > 0) {
            val newExercise: Exercise = getRandomFromList(allExercises)
            if (!checkForDuplicateExercise(newExercise, newExercises) ) {
                println(newExercise.name)
                if(currentDuration + newExercise.duration > durationThreshold){
                    allExercises.remove(newExercise)
                    if(allExercises.size > 0) {
                        continue
                    } else {
                        break
                    }
                } else {
                    allExercises.remove(newExercise)
                    currentDuration += newExercise.duration
                    newExercises.add(newExercise)
                }
            }
        }
        println("MaxDuration: $maxDuration CurrentDuration: $currentDuration")
        return newExercises
    }

    private fun <T> getRandomFromList(list: List<T>): T {
        return list.random()
    }

    private fun checkForDuplicateExercise(newExercise: Exercise, newList: List<Exercise>): Boolean {
        return newList.contains(newExercise)
    }

    private fun printList(list: List<Exercise>) {
        for (i in list) {
            println("List Item: " + i.name)
        }
    }
}