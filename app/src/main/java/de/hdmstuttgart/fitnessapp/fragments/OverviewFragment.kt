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
import de.hdmstuttgart.fitnessapp.database.entities.Exercise
import de.hdmstuttgart.fitnessapp.database.entities.TrainingsPlan
import de.hdmstuttgart.fitnessapp.database.repositories.DisciplineRepository
import de.hdmstuttgart.fitnessapp.database.repositories.TrainingsPlanRepository
import de.hdmstuttgart.fitnessapp.database.viewmodels.DisciplineViewModel
import de.hdmstuttgart.fitnessapp.database.viewmodels.TrainingsPlanViewModel
import de.hdmstuttgart.fitnessapp.databinding.FragmentOverviewBinding
import kotlinx.coroutines.*

class OverviewFragment(
    private val generator: TrainingsPlanGenerator,
    private val trainingsPlan: TrainingsPlan
) : Fragment(R.layout.fragment_overview), OverviewAdapter.OnItemClickListener {

    private lateinit var communicator: Communicator
    private lateinit var binding: FragmentOverviewBinding
    private val exerciseList: ArrayList<Exercise> = arrayListOf()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentOverviewBinding.bind(view)
        val scope = CoroutineScope(SupervisorJob())
        val dataBase = DataBase.getInstance(requireContext(), scope)

        setHasOptionsMenu(true)
        communicator = activity as Communicator

        val disciplineViewModel = DisciplineViewModel(DisciplineRepository(dataBase.disciplineDao()))

        val trainingsPlanViewModel = TrainingsPlanViewModel(TrainingsPlanRepository(dataBase.trainingsPlanDao()))

        scope.launch {
            exerciseList.clear()
            exerciseList.addAll(trainingsPlanViewModel.getExercisesForTrainingsPlanId(trainingsPlan.trainingsPlanId))
        }

        disciplineViewModel.getAllDisciplines().observe(viewLifecycleOwner, { disciplines ->
            val adapter = OverviewAdapter(exerciseList, this, disciplines)
            binding.rvOverview.adapter = adapter
            adapter.notifyDataSetChanged()
        })
        binding.rvOverview.layoutManager = LinearLayoutManager(requireContext())

        binding.btnStartTraining.setOnClickListener {
            communicator.switchToCountdown(trainingsPlan)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {

        val index = parentFragmentManager.backStackEntryCount - 2
        val lastFragmentName = parentFragmentManager.getBackStackEntryAt(index).name
        if (lastFragmentName == "attachHome") {
            inflater.inflate(R.menu.to_home, menu)
        } else {
            inflater.inflate(R.menu.to_history, menu)
        }
    }

    override fun onItemClick(position: Int) {
        val exercise = exerciseList[position]
        communicator.switchToExerciseDescription(exercise)
    }
}