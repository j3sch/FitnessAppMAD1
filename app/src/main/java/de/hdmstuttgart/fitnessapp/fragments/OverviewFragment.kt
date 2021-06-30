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
import de.hdmstuttgart.fitnessapp.database.entities.Discipline
import de.hdmstuttgart.fitnessapp.database.repositories.DisciplineRepository
import de.hdmstuttgart.fitnessapp.database.viewmodels.DisciplineViewModel
import de.hdmstuttgart.fitnessapp.databinding.FragmentOverviewBinding
import kotlinx.coroutines.*

class OverviewFragment(private val generator: TrainingsPlanGenerator) : Fragment(R.layout.fragment_overview), OverviewAdapter.OnItemClickListener {

    companion object {
        const val TO_SCREEN = "overview"
    }


    private lateinit var communicator: Communicator
    private lateinit var binding: FragmentOverviewBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentOverviewBinding.bind(view)
        val scope = CoroutineScope(SupervisorJob())
        val dataBase = DataBase.getInstance(requireContext(), scope)

        setHasOptionsMenu(true)
        communicator = activity as Communicator
        Thread.sleep(100)

        val disciplineViewModel = DisciplineViewModel(DisciplineRepository(dataBase.disciplineDao()))

        disciplineViewModel.getAllDisciplines().observe(viewLifecycleOwner, { disciplines ->
            val adapter = OverviewAdapter(generator.exercisesForTrainingsPlan, this, disciplines)
            binding.rvOverview.adapter = adapter
            adapter.notifyDataSetChanged()
        })
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
        communicator.switchToExerciseDescription(exercise, TO_SCREEN)
    }
}