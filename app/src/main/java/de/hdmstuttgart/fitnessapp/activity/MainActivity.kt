package de.hdmstuttgart.fitnessapp.activity

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import de.hdmstuttgart.fitnessapp.navigation.Communicator
import de.hdmstuttgart.fitnessapp.R
import de.hdmstuttgart.fitnessapp.database.DataBase
import de.hdmstuttgart.fitnessapp.database.TrainingsPlanGenerator
import de.hdmstuttgart.fitnessapp.database.entities.Exercise
import de.hdmstuttgart.fitnessapp.databinding.ActivityMainBinding
import de.hdmstuttgart.fitnessapp.fragments.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity(), Communicator {

    private lateinit var binding: ActivityMainBinding

    companion object {
        private const val CHANNEL_ID = "channelID"
        private const val CHANNEL_NAME = "channelName"
    }

    val scope = CoroutineScope(SupervisorJob())
    private lateinit var generator: TrainingsPlanGenerator

    lateinit var toggle: ActionBarDrawerToggle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        generator = TrainingsPlanGenerator(this, scope)
        val dataBase = DataBase.getInstance(this, scope)

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
                R.id.settings -> switchToSettings()
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
            item.itemId == R.id.to_countdown -> {
                switchToCountdown()
                true
            }
            else -> {
                super.onOptionsItemSelected(item)
            }
        }
    }

    override fun switchToCountdown() {
        supportFragmentManager.beginTransaction().apply {
            val countdownFragment = CountdownFragment(generator)
            replace(R.id.flFragment, countdownFragment)
            addToBackStack("attachCountDown")
            commit()
        }
    }

    override fun switchToHome() {
        supportFragmentManager.beginTransaction().apply {
            val homeFragment = HomeFragment(generator)
            replace(R.id.flFragment, homeFragment)
            addToBackStack("attachHome")
            commit()
        }
    }

    override fun switchToConfigureTraining() {
        supportFragmentManager.beginTransaction().apply {
            val configureTraining = ConfigureTrainingFragment()
            replace(R.id.flFragment, configureTraining)
            addToBackStack("attachConfigureTraining")
            commit()
        }
    }

    override fun switchToOverview() {
        supportFragmentManager.beginTransaction().apply {
            val overviewFragment = OverviewFragment(generator)
            replace(R.id.flFragment, overviewFragment)
            addToBackStack("attachOverview")
            commit()
        }
    }

    override fun switchToHistory() {
        supportFragmentManager.beginTransaction().apply {
            val historyFragment = HistoryFragment()
            replace(R.id.flFragment, historyFragment)
            addToBackStack("attachHistory")
            commit()
        }
    }

    override fun switchToSettings() {
        supportFragmentManager.beginTransaction().apply {
            val settingFragment = SettingFragment()
            replace(R.id.flFragment, settingFragment)
            addToBackStack("attachSettings")
            commit()
        }
    }

    override fun switchToFinish() {
        supportFragmentManager.beginTransaction().apply {
            val finishFragment = FinishFragment()
            replace(R.id.flFragment, finishFragment)
            addToBackStack("attachFinish")
            commit()
        }
    }

    override fun switchToExerciseDescription(exercise: Exercise, TO_SCREEN: String) {
        supportFragmentManager.beginTransaction().apply {
            val exerciseDescription = ExerciseDescriptionFragment(exercise, TO_SCREEN)
            replace(R.id.flFragment, exerciseDescription)
            addToBackStack("attachExerciseDescription")
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
}