package de.hdmstuttgart.fitnessappmad1.fragments

import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuInflater
import androidx.fragment.app.Fragment
import android.view.View
import com.google.android.material.slider.RangeSlider
import de.hdmstuttgart.fitnessappmad1.R
import de.hdmstuttgart.fitnessappmad1.databinding.FragmentConfigureTrainingBinding
import kotlin.math.roundToInt

class ConfigureTrainingFragment : Fragment(R.layout.fragment_configure_training) {

    private lateinit var binding: FragmentConfigureTrainingBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
            super.onViewCreated(view, savedInstanceState)
        binding = FragmentConfigureTrainingBinding.bind(view)

        setHasOptionsMenu(true)

        binding.tvAufwaermen.text = getString(R.string.aufwaermen, 25.toString())
        binding.tvHauptteil.text = getString(R.string.hauptteil, 55.toString())
        binding.tvSchluss.text = getString(R.string.schluss, 80.toString())

        binding.rangeSlider.addOnSliderTouchListener(object : RangeSlider.OnSliderTouchListener {
                override fun onStartTrackingTouch(slider: RangeSlider) {
                    val values = binding.rangeSlider.values
                    Log.d("onStartTrackingTouch From", values[0].toString())
                    Log.d("onStartTrackingTouch T0", values[1].toString())
                }

                override fun onStopTrackingTouch(slider: RangeSlider) {
                    val values = binding.rangeSlider.values
                    Log.d("onStopTrackingTouch From", values[0].toString())
                    Log.d("onStopTrackingTouch T0", values[1].toString())
                    binding.tvAufwaermen.text = getString(R.string.aufwaermen, values[0].roundToInt().toString())
                    binding.tvHauptteil.text = getString(R.string.hauptteil, (values[1] - values[0]).roundToInt().toString())
                    binding.tvSchluss.text = getString(R.string.schluss, (binding.rangeSlider.valueTo - values[1]).roundToInt().toString())
                }
            })
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.to_home, menu)
    }
}