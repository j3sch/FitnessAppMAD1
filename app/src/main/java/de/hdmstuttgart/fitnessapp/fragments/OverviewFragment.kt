package de.hdmstuttgart.fitnessapp.fragments

import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import androidx.fragment.app.Fragment
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import de.hdmstuttgart.fitnessapp.navigation.Communicator
import de.hdmstuttgart.fitnessapp.R
import de.hdmstuttgart.fitnessapp.adapter.Overview
import de.hdmstuttgart.fitnessapp.adapter.OverviewAdapter
import de.hdmstuttgart.fitnessapp.databinding.FragmentOverviewBinding

class OverviewFragment : Fragment(R.layout.fragment_overview), OverviewAdapter.OnItemClickListener {

    private lateinit var communicator: Communicator
    private lateinit var binding: FragmentOverviewBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentOverviewBinding.bind(view)

        setHasOptionsMenu(true)
        communicator = activity as Communicator

        val overviewList = mutableListOf(
            Overview("Liegestuetzen", "Aufwaehrmen", "5:00"),
            Overview("Liegestuetzen", "Aufwaehrmen", "5:00"),
            Overview("Liegestuetzen", "Aufwaehrmen", "5:00"),
            Overview("Liegestuetzen", "Aufwaehrmen", "5:00"),
            Overview("Liegestuetzen", "Aufwaehrmen", "5:00"),
            Overview("Liegestuetzen", "Aufwaehrmen", "5:00"),
            Overview("Liegestuetzen", "Aufwaehrmen", "5:00"),
            Overview("Liegestuetzen", "Aufwaehrmen", "5:00"),
            Overview("Liegestuetzen", "Aufwaehrmen", "5:00"),
            Overview("Liegestuetzen", "Aufwaehrmen", "5:00"),
        )

        val adapter = OverviewAdapter(overviewList, this)
        binding.rvOverview.adapter = adapter
        binding.rvOverview.layoutManager = LinearLayoutManager(requireContext())

        binding.btnStartTraining.setOnClickListener {
            communicator.switchToCountdown()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.to_home, menu)
    }

    override fun onItemClick(position: Int) {
        communicator.switchToExerciseDescription()
    }
}