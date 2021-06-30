package de.hdmstuttgart.fitnessapp.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import de.hdmstuttgart.fitnessapp.navigation.Communicator
import de.hdmstuttgart.fitnessapp.R
import de.hdmstuttgart.fitnessapp.database.TrainingsPlanGenerator
import de.hdmstuttgart.fitnessapp.databinding.FragmentHomeBinding
import de.hdmstuttgart.fitnessapp.datastore.SettingsViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.launch

class HomeFragment(private val generator: TrainingsPlanGenerator) :  Fragment(R.layout.fragment_home) {

    private lateinit var binding: FragmentHomeBinding
    private var counter = 0

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentHomeBinding.bind(view)
        val scope = CoroutineScope(SupervisorJob())
        val settingsViewModel by viewModels<SettingsViewModel>()
        
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
            counter++
            val communicator = activity as Communicator
            scope.launch() {
                println(length)
                println(paramIntro)
                println(paramMain)
                println(paramOutro)
                generator.createTrainingsPlan("newPlan$counter", length, paramIntro, paramMain, paramOutro)
            }
            communicator.switchToOverview()
        }
    }
}
