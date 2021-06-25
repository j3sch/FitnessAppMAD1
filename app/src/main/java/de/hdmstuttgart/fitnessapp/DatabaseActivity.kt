package de.hdmstuttgart.fitnessapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import de.hdmstuttgart.fitnessapp.database.DataBase
import de.hdmstuttgart.fitnessapp.database.entities.Discipline
import de.hdmstuttgart.fitnessapp.database.repositories.DisciplineRepository
import de.hdmstuttgart.fitnessapp.database.repositories.ExerciseRepository
import de.hdmstuttgart.fitnessapp.database.repositories.TrainingsPlanRepository
import de.hdmstuttgart.fitnessapp.database.viewmodels.ExerciseViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob

class DatabaseActivity : AppCompatActivity() {

    private lateinit var mMovieViewModel: ExerciseViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val applicationScope = CoroutineScope(SupervisorJob())
        mMovieViewModel = ViewModelProvider(this).get(ExerciseViewModel::class.java)

        print(mMovieViewModel.getAllExercises())

        val database =  DataBase.getInstance(this, applicationScope)
        val exerciseRepo = ExerciseRepository(database.exerciseDao())
        val disciplineRepo = DisciplineRepository(database.disciplineDao())
        val trainingsPlanRepo = TrainingsPlanRepository(database.trainingsPlanDao())
    }
}