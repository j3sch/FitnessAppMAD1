package de.hdmstuttgart.fitnessapp.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import de.hdmstuttgart.fitnessapp.Communicator
import de.hdmstuttgart.fitnessapp.R
import de.hdmstuttgart.fitnessapp.databinding.FragmentHomeBinding

class HomeFragment :  Fragment(R.layout.fragment_home) {

    private lateinit var communicator: Communicator
    private lateinit var binding: FragmentHomeBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentHomeBinding.bind(view)

        communicator = activity as Communicator

        binding.btnGenerate.setOnClickListener {
            communicator.switchToOverview()
        }
    }
}
