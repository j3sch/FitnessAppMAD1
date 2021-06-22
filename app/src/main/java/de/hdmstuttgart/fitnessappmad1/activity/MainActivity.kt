package de.hdmstuttgart.fitnessappmad1.activity

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import de.hdmstuttgart.fitnessappmad1.Communicator
import de.hdmstuttgart.fitnessappmad1.R
import de.hdmstuttgart.fitnessappmad1.databinding.ActivityMainBinding
import de.hdmstuttgart.fitnessappmad1.fragments.*

class MainActivity : AppCompatActivity(), Communicator {

    private lateinit var binding: ActivityMainBinding

    private val CHANNEL_ID = "channelID"
    private val CHANNEL_NAME = "channelName"

    lateinit var toggle: ActionBarDrawerToggle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        createNotificationChannel()
        switchToHome()

        when (intent.getIntExtra("exercise", 0)) {
            5 -> switchToCountdown()
            8 -> switchToFinish()
        }

        toggle = ActionBarDrawerToggle(this, binding.drawerLayout, R.string.open, R.string.close)
        binding.drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        binding.navView.setNavigationItemSelectedListener {
            binding.drawerLayout.close()
            when (it.itemId) {
                R.id.home -> switchToHome()
                R.id.configure -> switchToConfigureTraining()
                R.id.history -> switchToHistory()
                R.id.settings -> Toast.makeText(applicationContext, "Clicked Settings", Toast.LENGTH_SHORT).show()
            }
            true
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when {
            toggle.onOptionsItemSelected(item) -> {
                true
            }
            item.itemId == R.id.to_home -> {
                switchToHome()
                true
            }
            item.itemId == R.id.to_overview -> {
                switchToOverview()
                true
            }
            else -> {
                super.onOptionsItemSelected(item)
            }
        }
    }

    override fun switchToCountdown() {
        supportFragmentManager.beginTransaction().apply {
            val timerFragment = CountdownFragment()
            replace(R.id.flFragment, timerFragment)
            commit()
        }
    }

    override fun switchToHome() {
        supportFragmentManager.beginTransaction().apply {
            val homeFragment = HomeFragment()
            replace(R.id.flFragment, homeFragment)
            commit()
        }
    }

    override fun switchToConfigureTraining() {
        supportFragmentManager.beginTransaction().apply {
            val configureTraining = ConfigureTrainingFragment()
            replace(R.id.flFragment, configureTraining)
            commit()
        }
    }

    override fun switchToOverview() {
        supportFragmentManager.beginTransaction().apply {
            val overviewFragment = OverviewFragment()
            replace(R.id.flFragment, overviewFragment)
            commit()
        }
    }

    override fun switchToHistory() {
        supportFragmentManager.beginTransaction().apply {
            val historyFragment = HistoryFragment()
            replace(R.id.flFragment, historyFragment)
            commit()
        }
    }

    override fun switchToFinish() {
        supportFragmentManager.beginTransaction().apply {
            val finishFragment = FinishFragment()
            replace(R.id.flFragment, finishFragment)
            commit()
        }
    }

    override fun switchToExerciseDescription() {
        supportFragmentManager.beginTransaction().apply {
            val exerciseDescription = ExerciseDescriptionFragment()
            replace(R.id.flFragment, exerciseDescription)
            commit()
        }
    }

    private fun createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channel = NotificationChannel(
                CHANNEL_ID, CHANNEL_NAME,
                NotificationManager.IMPORTANCE_DEFAULT
            )
            val manager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            manager.createNotificationChannel(channel)
        }
    }

//    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
//        val inflater: MenuInflater = menuInflater
//        inflater.inflate(R.menu.menu_exit, menu)
//        return true
//    }
//
//    override fun onPrepareOptionsMenu(menu: Menu?): Boolean {
//        return false
//    }
}