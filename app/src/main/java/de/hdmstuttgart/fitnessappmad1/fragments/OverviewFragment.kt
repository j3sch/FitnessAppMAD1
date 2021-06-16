package de.hdmstuttgart.fitnessappmad1.fragments

import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import de.hdmstuttgart.fitnessappmad1.Communicator
import de.hdmstuttgart.fitnessappmad1.R
import de.hdmstuttgart.fitnessappmad1.adapter.Overview
import de.hdmstuttgart.fitnessappmad1.adapter.OverviewAdapter
import kotlinx.android.synthetic.main.fragment_overview.*

class OverviewFragment : Fragment(R.layout.fragment_overview), OverviewAdapter.OnItemClickListener {

    private lateinit var communicator: Communicator

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

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
        rvOverview.adapter = adapter
        rvOverview.layoutManager = LinearLayoutManager(requireContext())

        btnStartTraining.setOnClickListener {
            communicator.switchToCountdown()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu_exit, menu)
    }

    override fun onItemClick(position: Int) {
        Toast.makeText(requireContext(), "Clicked Settings", Toast.LENGTH_SHORT).show()
    }
}