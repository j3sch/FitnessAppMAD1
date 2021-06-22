package de.hdmstuttgart.fitnessappmad1.fragments

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import de.hdmstuttgart.fitnessappmad1.Communicator
import de.hdmstuttgart.fitnessappmad1.R
import de.hdmstuttgart.fitnessappmad1.databinding.FragmentExerciseDescriptionBinding

class ExerciseDescriptionFragment : Fragment(R.layout.fragment_exercise_description) {
    private lateinit var communicator: Communicator
    private lateinit var binding: FragmentExerciseDescriptionBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentExerciseDescriptionBinding.bind(view)

        setHasOptionsMenu(true)
        communicator = activity as Communicator
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.to_overview, menu)
    }
}