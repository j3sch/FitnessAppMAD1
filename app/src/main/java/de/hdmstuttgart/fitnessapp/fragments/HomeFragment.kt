package de.hdmstuttgart.fitnessapp.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import de.hdmstuttgart.fitnessapp.navigation.Communicator
import de.hdmstuttgart.fitnessapp.R
import de.hdmstuttgart.fitnessapp.database.TrainingsPlanGenerator
import de.hdmstuttgart.fitnessapp.databinding.FragmentHomeBinding
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

        binding.btnGenerate.setOnClickListener {
            counter++
            val communicator = activity as Communicator
            scope.launch() {
                generator.createTrainingsPlan("newPlan$counter", 120, 0.125F, 0.75F, 0.125F)
            }
            communicator.switchToOverview()
        }
    }
}
