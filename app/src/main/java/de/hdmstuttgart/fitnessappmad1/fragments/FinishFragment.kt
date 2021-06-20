package de.hdmstuttgart.fitnessappmad1.fragments

import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import androidx.fragment.app.Fragment
import android.view.View
import de.hdmstuttgart.fitnessappmad1.Communicator
import de.hdmstuttgart.fitnessappmad1.R
import de.hdmstuttgart.fitnessappmad1.databinding.FragmentFinishBinding

class FinishFragment : Fragment(R.layout.fragment_finish) {

    private lateinit var communicator: Communicator
    private lateinit var binding: FragmentFinishBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentFinishBinding.bind(view)

        setHasOptionsMenu(true)
        communicator = activity as Communicator

        binding.tvBackToHome.setOnClickListener {
            communicator.switchToHome()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu_exit, menu)
    }
}