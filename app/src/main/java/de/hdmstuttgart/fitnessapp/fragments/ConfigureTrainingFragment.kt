package de.hdmstuttgart.fitnessapp.fragments

import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuInflater
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.slider.RangeSlider
import de.hdmstuttgart.fitnessapp.R
import de.hdmstuttgart.fitnessapp.databinding.FragmentConfigureTrainingBinding
import de.hdmstuttgart.fitnessapp.datastore.DataStoreViewModel
import kotlin.math.round
import kotlin.math.roundToInt

class ConfigureTrainingFragment() : Fragment(R.layout.fragment_configure_training) {

    var time: Float = 3.00f
    private var firstSliderValue: Float = 25f
    private var secondSliderValue: Float = 80f


    private lateinit var binding: FragmentConfigureTrainingBinding
    private lateinit var dataStoreViewModel: DataStoreViewModel


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
            super.onViewCreated(view, savedInstanceState)
        binding = FragmentConfigureTrainingBinding.bind(view)
        dataStoreViewModel = ViewModelProvider(this).get(DataStoreViewModel::class.java)

        setHasOptionsMenu(true)

        dataStoreViewModel.readTrainingLength.observe(viewLifecycleOwner, { trainingLength ->
            binding.tvTrainingTime.text = String.format("%.2f", trainingLength)
        })

        dataStoreViewModel.readFirstSliderValue.observe(viewLifecycleOwner, { value ->
            firstSliderValue = value
        })

        dataStoreViewModel.readSecondSliderValue.observe(viewLifecycleOwner, { value ->
            secondSliderValue = value
        })

        binding.rangeSlider.values = mutableListOf(secondSliderValue, firstSliderValue)
        binding.tvWarmUp.text = getString(R.string.warm_up, 25.toString() + "%")
        binding.tvMainPart.text = getString(R.string.main_part, 55.toString() + "%")
        binding.tvEnd.text = getString(R.string.end, 80.toString() +"%")

        binding.rangeSlider.addOnSliderTouchListener(object : RangeSlider.OnSliderTouchListener {
                override fun onStartTrackingTouch(slider: RangeSlider) {
                    val values = binding.rangeSlider.values
                    Log.d("onStartTrackingTouch From", values[0].toString())
                    Log.d("onStartTrackingTouch T0", values[1].toString())
                }

                override fun onStopTrackingTouch(slider: RangeSlider) {
                    val values = binding.rangeSlider.values
                    dataStoreViewModel.saveSliderValues(values[0], values[1])
                    Log.d("onStopTrackingTouch From", values[0].toString())
                    Log.d("onStopTrackingTouch T0", values[1].toString())
                    binding.tvWarmUp.text = getString(R.string.warm_up, values[0].roundToInt().toString() + "%")
                    binding.tvMainPart.text = getString(R.string.main_part, (values[1] - values[0]).roundToInt().toString() + "%")
                    binding.tvEnd.text = getString(R.string.end, (binding.rangeSlider.valueTo - values[1]).roundToInt().toString() + "%")
                }
            })

        binding.btnMinus.setOnClickListener {
            val newTime: Float;
            if (time > 1) {
                newTime = if (time % 1f == 0f) {
                    time - 0.55f;
                } else {
                    time - 0.15f;
                }
                time = round(newTime * 100) / 100f
                dataStoreViewModel.saveTrainingLength(time)
            }
        }

        binding.btnPlus.setOnClickListener {
            val newTime: Float
            if (time < 5) {
                newTime = if (time.toString().length == 4
                    && time.toString().substring(2, 4) == "45") {
                    time + 0.55f;
                } else {
                    time + 0.15f;
                }
                time = round(newTime * 100) / 100f
                dataStoreViewModel.saveTrainingLength(time)
            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.to_home, menu)
    }
}