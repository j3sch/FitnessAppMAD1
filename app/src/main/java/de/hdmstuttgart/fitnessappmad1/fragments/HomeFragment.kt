package de.hdmstuttgart.fitnessappmad1.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import de.hdmstuttgart.fitnessappmad1.Communicator
import de.hdmstuttgart.fitnessappmad1.R
import de.hdmstuttgart.fitnessappmad1.databinding.FragmentHomeBinding

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
