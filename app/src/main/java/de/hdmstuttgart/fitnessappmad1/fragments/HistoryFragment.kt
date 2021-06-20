package de.hdmstuttgart.fitnessappmad1.fragments

import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import androidx.fragment.app.Fragment
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import de.hdmstuttgart.fitnessappmad1.Communicator
import de.hdmstuttgart.fitnessappmad1.R
import de.hdmstuttgart.fitnessappmad1.adapter.History
import de.hdmstuttgart.fitnessappmad1.adapter.HistoryAdapter
import de.hdmstuttgart.fitnessappmad1.databinding.FragmentHistoryBinding

class HistoryFragment : Fragment(R.layout.fragment_history), HistoryAdapter.OnItemClickListener {

    private lateinit var communicator: Communicator
    private lateinit var binding: FragmentHistoryBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentHistoryBinding.bind(view)

        setHasOptionsMenu(true)
        communicator = activity as Communicator

        val historyList = mutableListOf(
            History("10.06.2021", ),
            History("12.06.2021"),
            )

        val adapter = HistoryAdapter(historyList, this)
        binding.rvHistory.adapter = adapter
        binding.rvHistory.layoutManager = LinearLayoutManager(requireContext())
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu_exit, menu)
    }

    override fun onItemClick(position: Int) {
        communicator.switchToOverview()
    }
}