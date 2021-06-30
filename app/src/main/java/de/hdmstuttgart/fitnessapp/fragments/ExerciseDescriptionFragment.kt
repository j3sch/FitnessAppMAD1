package de.hdmstuttgart.fitnessapp.fragments

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import de.hdmstuttgart.fitnessapp.navigation.Communicator
import de.hdmstuttgart.fitnessapp.R
import de.hdmstuttgart.fitnessapp.database.DataBase
import de.hdmstuttgart.fitnessapp.database.entities.Discipline
import de.hdmstuttgart.fitnessapp.database.entities.Exercise
import de.hdmstuttgart.fitnessapp.database.repositories.DisciplineRepository
import de.hdmstuttgart.fitnessapp.database.viewmodels.DisciplineViewModel
import de.hdmstuttgart.fitnessapp.databinding.FragmentExerciseDescriptionBinding
import kotlinx.coroutines.*

class ExerciseDescriptionFragment(
    private val exercise: Exercise,
    private val TO_SCREEN: String
    ) : Fragment(R.layout.fragment_exercise_description) {
    private lateinit var communicator: Communicator
    private lateinit var binding: FragmentExerciseDescriptionBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentExerciseDescriptionBinding.bind(view)

        val scope = CoroutineScope(SupervisorJob())
        val database = DataBase.getInstance(requireContext(), scope)
        val disciplineViewModel = DisciplineViewModel(DisciplineRepository(database.disciplineDao()))
        lateinit var disciplineList: List<Discipline>

        disciplineViewModel.getAllDisciplines().observe(viewLifecycleOwner, { disciplines ->
            disciplineList = disciplines
            binding.tvDisciplineContent.text = disciplineList[exercise.disciplineId - 1].name
        })

        (exercise.disciplineId.toString())
        setHasOptionsMenu(true)
        communicator = activity as Communicator

        binding.tvExerciseName.text = exercise.name
        binding.tvDescriptionContent.text = exercise.description
        binding.tvSetupContent.text = exercise.setup
        binding.tvEquipmentContent.text = exercise.equipment
        binding.tvDivisionContent.text = exercise.division
        binding.tvTimeContent.text = exercise.duration.toString()
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        if (TO_SCREEN == "overview") {
            inflater.inflate(R.menu.to_overview, menu)
        } else {
        inflater.inflate(R.menu.to_countdown, menu)
        }
    }
}