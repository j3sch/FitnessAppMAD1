package de.hdmstuttgart.fitnessapp.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import de.hdmstuttgart.fitnessapp.navigation.Communicator
import de.hdmstuttgart.fitnessapp.R
import de.hdmstuttgart.fitnessapp.database.DataBase
import de.hdmstuttgart.fitnessapp.database.TrainingsPlanGenerator
import de.hdmstuttgart.fitnessapp.database.entities.TrainingsPlan
import de.hdmstuttgart.fitnessapp.database.repositories.TrainingsPlanRepository
import de.hdmstuttgart.fitnessapp.database.viewmodels.TrainingsPlanViewModel
import de.hdmstuttgart.fitnessapp.databinding.FragmentHomeBinding
import de.hdmstuttgart.fitnessapp.datastore.SettingsViewModel
import kotlinx.coroutines.*

class HomeFragment(private val generator: TrainingsPlanGenerator) :  Fragment(R.layout.fragment_home) {

    private lateinit var binding: FragmentHomeBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentHomeBinding.bind(view)
        val scope = CoroutineScope(SupervisorJob())
        val dataBase = DataBase.getInstance(requireContext(), scope)

        val settingsViewModel by viewModels<SettingsViewModel>()
        TrainingsPlanViewModel(TrainingsPlanRepository(dataBase.trainingsPlanDao()))

        var length = 0
        var paramIntro = 0F
        var paramMain = 0F
        var paramOutro = 0F
        
        settingsViewModel.readTrainingLength.observe(viewLifecycleOwner, { trainingLength ->
            length = trainingLength.toInt() * 60
        })
        
        settingsViewModel.readFirstSliderValue.observe(viewLifecycleOwner, { firstSliderValue ->
            paramIntro = firstSliderValue / 100
        })

        settingsViewModel.readSecondSliderValue.observe(viewLifecycleOwner, { secondSliderValue ->
            paramOutro = (100 - secondSliderValue) / 100
            paramMain = (secondSliderValue - paramIntro * 100) / 100
        })

        binding.btnGenerate.setOnClickListener {
            val communicator = activity as Communicator
            scope.launch(Dispatchers.IO) {
                generator.exercisesForTrainingsPlan.clear()
                val trainingPlan: TrainingsPlan
                try {
                     trainingPlan = generator.createTrainingsPlan(
                        "neuer Trainingsplan",
                        length,
                        paramIntro,
                        paramMain,
                        paramOutro
                    )
                    communicator.switchToOverview(trainingPlan)
                } catch (e: Exception) {
                    e.printStackTrace()
//                    trainingsPlanViewModel.deleteTrainingsPlan(trainingPlan)
                    val replaceTrainingPlan = generator.createTrainingsPlan(
                            "neuer Trainingsplan",
                            length,
                            paramIntro,
                            paramMain,
                            paramOutro
                    )
                    communicator.switchToOverview(replaceTrainingPlan)
                }
            }
        }
    }
}
