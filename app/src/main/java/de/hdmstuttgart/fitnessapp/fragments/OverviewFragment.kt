package de.hdmstuttgart.fitnessapp.fragments

import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import androidx.fragment.app.Fragment
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import de.hdmstuttgart.fitnessapp.navigation.Communicator
import de.hdmstuttgart.fitnessapp.R
import de.hdmstuttgart.fitnessapp.adapter.OverviewAdapter
import de.hdmstuttgart.fitnessapp.database.DataBase
import de.hdmstuttgart.fitnessapp.database.TrainingsPlanGenerator
import de.hdmstuttgart.fitnessapp.database.repositories.DisciplineRepository
import de.hdmstuttgart.fitnessapp.database.repositories.TrainingsPlanRepository
import de.hdmstuttgart.fitnessapp.databinding.FragmentOverviewBinding
import kotlinx.coroutines.*

class OverviewFragment(private val generator: TrainingsPlanGenerator) : Fragment(R.layout.fragment_overview), OverviewAdapter.OnItemClickListener {

    private lateinit var communicator: Communicator
    private lateinit var binding: FragmentOverviewBinding
//    private lateinit var overviewList: ArrayList<Exercise>

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentOverviewBinding.bind(view)
        val scope = CoroutineScope(SupervisorJob())
        val dataBase = DataBase.getInstance(requireContext(), scope)
        val trainingsPlanRepo = TrainingsPlanRepository(dataBase.trainingsPlanDao())
        val disciplineRepo = DisciplineRepository(dataBase.disciplineDao())

        setHasOptionsMenu(true)
        communicator = activity as Communicator

        Thread.sleep(100)
            val adapter = OverviewAdapter(generator.exercisesForTrainingsPlan, this)
            binding.rvOverview.adapter = adapter
            adapter.notifyDataSetChanged()

        scope.launch() {
            for (d in generator.exercisesForTrainingsPlan) {
                println("Aufgabe: " + d.name)
            }
        }

        binding.rvOverview.layoutManager = LinearLayoutManager(requireContext())

        binding.btnStartTraining.setOnClickListener {
            communicator.switchToCountdown()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.to_home, menu)
    }

    override fun onItemClick(position: Int) {
        val exercise = generator.exercisesForTrainingsPlan[position]
        communicator.switchToExerciseDescription(exercise)
    }
}