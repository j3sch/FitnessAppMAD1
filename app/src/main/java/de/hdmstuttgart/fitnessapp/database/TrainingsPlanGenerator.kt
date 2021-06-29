import android.app.Application
import android.content.Context
import android.os.Debug
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import de.hdmstuttgart.fitnessapp.database.DataBase
import de.hdmstuttgart.fitnessapp.database.entities.Discipline
import de.hdmstuttgart.fitnessapp.database.entities.Exercise
import de.hdmstuttgart.fitnessapp.database.entities.TrainingsPlan
import de.hdmstuttgart.fitnessapp.database.entities.relations.ExerciseTrainingsPlanCrossRef
import de.hdmstuttgart.fitnessapp.database.repositories.DisciplineRepository
import de.hdmstuttgart.fitnessapp.database.repositories.ExerciseRepository
import de.hdmstuttgart.fitnessapp.database.repositories.ExerciseTPRepository
import de.hdmstuttgart.fitnessapp.database.repositories.TrainingsPlanRepository
import de.hdmstuttgart.fitnessapp.database.viewmodels.DisciplineViewModel
import de.hdmstuttgart.fitnessapp.database.viewmodels.ExerciseViewModel
import de.hdmstuttgart.fitnessapp.database.viewmodels.TrainingsPlanViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
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

    fun createTrainingsPlan(
        name: String,
        maximumTime: Int,
        paramIntro: Float,
        paramMain: Float,
        paramOutro: Float
    ) {
        val date = LocalDateTime.now().format(DateTimeFormatter.ofPattern(datePattern))
        val trainingsPlanRepo = TrainingsPlanRepository(dataBase.trainingsPlanDao())
        val exerciseTPRepository = ExerciseTPRepository(dataBase.exerciseTPDao())
        val trainingsPlanViewModel = TrainingsPlanViewModel(trainingsPlanRepo)
        val trainingsPlan = TrainingsPlan(name, date)
        trainingsPlanViewModel.insertTrainingsPlan(trainingsPlan)


        val durationIntro = maximumTime * paramIntro
        val durationMain = (maximumTime * paramMain) / 2
        val durationOutro = maximumTime * paramOutro

        val disciplines: List<Discipline> = getDisciplinesForTrainingsPlan()
        println(disciplines[0].name + " " + disciplines[1].name + " " + disciplines[2].name + " " + disciplines[3].name)

        for (discipline in disciplines) {
            when (discipline.name) {
                introDisciplineName -> {
                    exercisesForTrainingsPlan.addAll(
                        getExercisesForDiscipline(
                            discipline,
                            durationIntro
                        )
                    )
                }
                outroDisciplineName -> {
                    exercisesForTrainingsPlan.addAll(
                        getExercisesForDiscipline(
                            discipline,
                            durationOutro
                        )
                    )
                }
                else -> {
                    exercisesForTrainingsPlan.addAll(
                        getExercisesForDiscipline(
                            discipline,
                            durationMain
                        )
                    )
                }
            }
        }
        printList(exercisesForTrainingsPlan)


    }
    private fun fillExerciseTrainingsPlanCrossRef(trainingsPlan: TrainingsPlan, trainingsPlanExercises: List<Exercise>): List<ExerciseTrainingsPlanCrossRef>{
        val crossRefs = mutableListOf<ExerciseTrainingsPlanCrossRef>()
        for (tp in trainingsPlanExercises){
            crossRefs.add(ExerciseTrainingsPlanCrossRef(tp.exerciseId, trainingsPlan.trainingsPlanId))
        }
        return  crossRefs
    }

    private fun getDisciplinesForTrainingsPlan(): List<Discipline> {
        val disciplineRepo = DisciplineRepository(dataBase.disciplineDao())
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

    private fun getExercisesForDiscipline(
        discipline: Discipline,
        duration: Float
    ): MutableList<Exercise> {
        val exerciseRepo = ExerciseRepository(dataBase.exerciseDao())
        val disciplineRepo = DisciplineRepository(dataBase.disciplineDao())
        var i = 0F
        val newExercises: MutableList<Exercise> = mutableListOf()
        val allExercises: List<Exercise> =
            exerciseRepo.getAllExercisesByDiscipline(disciplineRepo.getDisciplineByName("Hochsprung")) //should be discipline
        while (i <= duration && newExercises.size < allExercises.size) { // ADD CHECK TO MAKE SURE IT STOPS WHEN THERE ARE NO MORE EXERCISES AVAILABLE
            print("check")
            val newExercise: Exercise = getRandomFromList(allExercises)
            if (!checkForDuplicateExercise(newExercise, newExercises)) {
                i += newExercise.duration
                println("Duration: $i")
                newExercises.add(newExercise)
            }
        }
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