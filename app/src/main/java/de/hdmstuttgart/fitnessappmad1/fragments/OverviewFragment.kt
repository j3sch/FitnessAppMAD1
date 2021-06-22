package de.hdmstuttgart.fitnessappmad1.fragments

import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import androidx.fragment.app.Fragment
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import de.hdmstuttgart.fitnessappmad1.Communicator
import de.hdmstuttgart.fitnessappmad1.R
import de.hdmstuttgart.fitnessappmad1.adapter.Overview
import de.hdmstuttgart.fitnessappmad1.adapter.OverviewAdapter
import de.hdmstuttgart.fitnessappmad1.databinding.FragmentOverviewBinding

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