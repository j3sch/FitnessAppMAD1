package de.hdmstuttgart.fitnessappmad1.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import de.hdmstuttgart.fitnessappmad1.Communicator
import de.hdmstuttgart.fitnessappmad1.R
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment :  Fragment(R.layout.fragment_home) {

    private lateinit var communicator: Communicator

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        communicator = activity as Communicator

        btnGenerate.setOnClickListener {
            communicator.switchToCountdown()
        }
    }
}
