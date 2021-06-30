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
import de.hdmstuttgart.fitnessapp.databinding.FragmentExerciseDescriptionBinding
import kotlinx.coroutines.*

class ExerciseDescriptionFragment(private val exercise: Exercise) : Fragment(R.layout.fragment_exercise_description) {
    private lateinit var communicator: Communicator
    private lateinit var binding: FragmentExerciseDescriptionBinding
    private lateinit var list: List<Discipline>

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentExerciseDescriptionBinding.bind(view)
        val scope = CoroutineScope(SupervisorJob())
        val database = DataBase.getInstance(requireContext(), scope)
        val disciplineRepo = DisciplineRepository(database.disciplineDao())

        scope.launch {
            list = disciplineRepo.getAllDisciplines()
            withContext(Dispatchers.Main) {
                binding.tvDisciplineContent.text = list[exercise.disciplineId - 1].name
            }
        }
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
        inflater.inflate(R.menu.to_overview, menu)
    }
}