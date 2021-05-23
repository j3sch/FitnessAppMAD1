package de.hdmstuttgart.fitnessappmad1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import de.hdmstuttgart.fitnessappmad1.application.ExercisesApplication
import de.hdmstuttgart.fitnessappmad1.viewmodel.ExerciseViewModel
import de.hdmstuttgart.fitnessappmad1.viewmodel.WordViewModelFactory

class MainActivity : AppCompatActivity() {

    private val exerciseViewModel: ExerciseViewModel by viewModels {
        WordViewModelFactory((application as ExercisesApplication).repository)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}