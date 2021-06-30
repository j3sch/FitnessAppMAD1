package de.hdmstuttgart.fitnessapp.fragments

import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import androidx.fragment.app.Fragment
import android.view.View
import androidx.fragment.app.viewModels
import de.hdmstuttgart.fitnessapp.R
import de.hdmstuttgart.fitnessapp.databinding.FragmentSettingBinding
import de.hdmstuttgart.fitnessapp.datastore.SettingsViewModel
import de.hdmstuttgart.fitnessapp.navigation.Communicator

class SettingFragment : Fragment(R.layout.fragment_setting) {

    private lateinit var communicator: Communicator
    private lateinit var binding: FragmentSettingBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentSettingBinding.bind(view)

        setHasOptionsMenu(true)
        communicator = activity as Communicator

        binding.chipNotification.setOnClickListener {
            val settingsViewModel by viewModels<SettingsViewModel>()
            settingsViewModel.saveIsNotificationEnabled(binding.chipNotification.isChecked)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.to_home, menu)
    }
}