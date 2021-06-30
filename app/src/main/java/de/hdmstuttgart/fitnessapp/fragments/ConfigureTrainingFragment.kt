package de.hdmstuttgart.fitnessapp.fragments

import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuInflater
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.google.android.material.slider.RangeSlider
import de.hdmstuttgart.fitnessapp.R
import de.hdmstuttgart.fitnessapp.databinding.FragmentConfigureTrainingBinding
import de.hdmstuttgart.fitnessapp.datastore.SettingsViewModel
import kotlin.math.round
import kotlin.math.roundToInt

class ConfigureTrainingFragment : Fragment(R.layout.fragment_configure_training) {

    var time: Float = 3.00F
    private lateinit var binding: FragmentConfigureTrainingBinding
    val settingsViewModel by viewModels<SettingsViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
            super.onViewCreated(view, savedInstanceState)
        binding = FragmentConfigureTrainingBinding.bind(view)

        setHasOptionsMenu(true)

        settingsViewModel.readTrainingLength.observe(viewLifecycleOwner, { trainingLength ->
            time = trainingLength
            binding.tvTrainingTime.text = String.format("%.2f", trainingLength)
        })

        settingsViewModel.readFirstSliderValue.observe(viewLifecycleOwner, { value1 ->
            settingsViewModel.readSecondSliderValue.observe(viewLifecycleOwner, { value2 ->
                binding.rangeSlider.values = mutableListOf(value1, value2)
                binding.tvWarmUp.text = getString(R.string.warm_up, value1.roundToInt().toString() + "%")
                binding.tvMainPart.text = getString(R.string.main_part, ( value2 -  value1).roundToInt().toString() + "%")
                binding.tvEnd.text = getString(R.string.end, (binding.rangeSlider.valueTo -  value2).roundToInt().toString() + "%")
            })
        })

        binding.rangeSlider.addOnSliderTouchListener(object : RangeSlider.OnSliderTouchListener {
                override fun onStartTrackingTouch(slider: RangeSlider) {
                    val values = binding.rangeSlider.values
                    Log.d("onStartTrackingTouch From", values[0].toString())
                    Log.d("onStartTrackingTouch T0", values[1].toString())
                }

                override fun onStopTrackingTouch(slider: RangeSlider) {
                    val values = binding.rangeSlider.values
                    settingsViewModel.saveSliderValues(values[0], values[1])
                    Log.d("onStopTrackingTouch From", values[0].toString())
                    Log.d("onStopTrackingTouch T0", values[1].toString())
                }
            })

        binding.btnMinus.setOnClickListener {
            val newTime: Float
            if (time > 1) {
                newTime = if (time % 1f == 0f) {
                    time - 0.55f
                } else {
                    time - 0.15f
                }
                time = round(newTime * 100) / 100f
                settingsViewModel.saveTrainingLength(time)
            }
        }

        binding.btnPlus.setOnClickListener {
            val newTime: Float
            if (time < 5) {
                newTime = if (time.toString().length == 4
                    && time.toString().substring(2, 4) == "45") {
                    time + 0.55f
                } else {
                    time + 0.15f
                }
                time = round(newTime * 100) / 100f
                settingsViewModel.saveTrainingLength(time)
            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.to_home, menu)
    }
}