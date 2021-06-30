package de.hdmstuttgart.fitnessapp.fragments

import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import androidx.fragment.app.Fragment
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import de.hdmstuttgart.fitnessapp.navigation.Communicator
import de.hdmstuttgart.fitnessapp.R
import de.hdmstuttgart.fitnessapp.adapter.HistoryAdapter
import de.hdmstuttgart.fitnessapp.database.DataBase
import de.hdmstuttgart.fitnessapp.database.entities.TrainingsPlan
import de.hdmstuttgart.fitnessapp.database.repositories.TrainingsPlanRepository
import de.hdmstuttgart.fitnessapp.database.viewmodels.TrainingsPlanViewModel
import de.hdmstuttgart.fitnessapp.databinding.FragmentHistoryBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob

class HistoryFragment : Fragment(R.layout.fragment_history), HistoryAdapter.OnItemClickListener {

    private lateinit var communicator: Communicator
    private lateinit var binding: FragmentHistoryBinding
    private val scope = CoroutineScope(SupervisorJob())
    private var trainingPlanList: List<TrainingsPlan> = arrayListOf()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentHistoryBinding.bind(view)

        setHasOptionsMenu(true)
        communicator = activity as Communicator

//        val historyList = mutableListOf(
//            History("10.06.2021", ),
//            History("12.06.2021"),
//            )


        val dataBase = DataBase.getInstance(requireContext(), scope)
        val trainingsPlanViewModel = TrainingsPlanViewModel(TrainingsPlanRepository(dataBase.trainingsPlanDao()))
        trainingsPlanViewModel.getAllTrainingsPlans().observe(viewLifecycleOwner, { trainingPlanList ->
            this.trainingPlanList = trainingPlanList
            println(trainingPlanList)
            val adapter = HistoryAdapter(trainingPlanList, this)
            binding.rvHistory.adapter = adapter
        })
        binding.rvHistory.layoutManager = LinearLayoutManager(requireContext())
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.to_home, menu)
    }

    override fun onItemClick(position: Int) {
        communicator.switchToOverview(trainingPlanList[position])
    }
}