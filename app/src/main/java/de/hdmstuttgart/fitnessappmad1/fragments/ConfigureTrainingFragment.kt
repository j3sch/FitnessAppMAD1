package de.hdmstuttgart.fitnessappmad1.fragments

import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuInflater
import androidx.fragment.app.Fragment
import android.view.View
import com.google.android.material.slider.RangeSlider
import de.hdmstuttgart.fitnessappmad1.Communicator
import de.hdmstuttgart.fitnessappmad1.R
import kotlinx.android.synthetic.main.fragment_configure_training.*
import kotlin.math.roundToInt

class ConfigureTrainingFragment : Fragment(R.layout.fragment_configure_training) {
    
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
            super.onViewCreated(view, savedInstanceState)
        
            setHasOptionsMenu(true)

            tvAufwaermen.text = getString(R.string.aufwaermen, 2.toString())
            tvHauptteil.text = getString(R.string.hauptteil, 5.toString())
            tvSchluss.text = getString(R.string.schluss, 3.toString())

            rangeSlider.addOnSliderTouchListener(object : RangeSlider.OnSliderTouchListener {
                override fun onStartTrackingTouch(slider: RangeSlider) {
                    val values = rangeSlider.values
                    Log.d("onStartTrackingTouch From", values[0].toString())
                    Log.d("onStartTrackingTouch T0", values[1].toString())
                }

                override fun onStopTrackingTouch(slider: RangeSlider) {
                    val values = rangeSlider.values
                    Log.d("onStopTrackingTouch From", values[0].toString())
                    Log.d("onStopTrackingTouch T0", values[1].toString())
                    tvAufwaermen.text = getString(R.string.aufwaermen, values[0].roundToInt().toString())
                    tvHauptteil.text = getString(R.string.hauptteil, (values[1] - values[0]).roundToInt().toString())
                    tvSchluss.text = getString(R.string.schluss, (rangeSlider.valueTo - values[1]).roundToInt().toString())
                }
            })
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu_exit, menu)
    }
}