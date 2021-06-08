package de.hdmstuttgart.fitnessappmad1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import de.hdmstuttgart.fitnessappmad1.fragments.HomeFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.beginTransaction().apply {
            val homeFragment = HomeFragment()
            replace(R.id.flFragment, homeFragment)
            commit()
        }
    }
}