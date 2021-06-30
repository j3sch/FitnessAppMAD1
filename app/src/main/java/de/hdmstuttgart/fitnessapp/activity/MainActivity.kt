package de.hdmstuttgart.fitnessapp.activity

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.os.Build
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import de.hdmstuttgart.fitnessapp.R
import de.hdmstuttgart.fitnessapp.database.TrainingsPlanGenerator
import de.hdmstuttgart.fitnessapp.database.entities.Exercise
import de.hdmstuttgart.fitnessapp.database.entities.TrainingsPlan
import de.hdmstuttgart.fitnessapp.databinding.ActivityMainBinding
import de.hdmstuttgart.fitnessapp.fragments.*
import de.hdmstuttgart.fitnessapp.navigation.Communicator
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob

class MainActivity : AppCompatActivity(), Communicator {

    private lateinit var binding: ActivityMainBinding

    companion object {
        private const val CHANNEL_ID = "channelID"
        private const val CHANNEL_NAME = "channelName"
    }

    val scope = CoroutineScope(SupervisorJob())
    private lateinit var generator: TrainingsPlanGenerator
    private lateinit var currentTrainingPlan: TrainingsPlan;

    lateinit var toggle: ActionBarDrawerToggle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        generator = TrainingsPlanGenerator(this, scope)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        createNotificationChannel()
        switchToHome()

        when (intent.getIntExtra("exercise", 0)) {
            5 -> switchToCountdown(currentTrainingPlan)
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
                onBackPressed()
                true
            }
            item.itemId == R.id.to_countdown -> {
                switchToCountdown(currentTrainingPlan)
                true
            }
            item.itemId == R.id.to_history -> {
                switchToHistory()
                true
            }
            else -> {
                super.onOptionsItemSelected(item)
            }
        }
    }

    override fun switchToCountdown(trainingsPlan: TrainingsPlan) {

        supportFragmentManager.beginTransaction().apply {
            val countdownFragment = CountdownFragment(trainingsPlan)
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

    override fun switchToOverview(trainingsPlan: TrainingsPlan) {
        currentTrainingPlan = trainingsPlan
        supportFragmentManager.beginTransaction().apply {
            val overviewFragment = OverviewFragment(trainingsPlan)
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

    override fun switchToExerciseDescription(exercise: Exercise) {
        supportFragmentManager.beginTransaction().apply {
            val exerciseDescription = ExerciseDescriptionFragment(exercise)
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