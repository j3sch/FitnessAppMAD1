package de.hdmstuttgart.fitnessapp.fragments

import de.hdmstuttgart.fitnessapp.database.TrainingsPlanGenerator
import android.app.Notification
import android.app.PendingIntent
import android.app.TaskStackBuilder
import android.content.Intent
import android.os.Bundle
import android.os.CountDownTimer
import android.view.Menu
import android.view.MenuInflater
import android.view.View
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import de.hdmstuttgart.fitnessapp.navigation.Communicator
import de.hdmstuttgart.fitnessapp.R
import de.hdmstuttgart.fitnessapp.activity.MainActivity
import de.hdmstuttgart.fitnessapp.database.DataBase
import de.hdmstuttgart.fitnessapp.database.repositories.DisciplineRepository
import de.hdmstuttgart.fitnessapp.database.repositories.ExerciseRepository
import de.hdmstuttgart.fitnessapp.database.viewmodels.DisciplineViewModel
import de.hdmstuttgart.fitnessapp.databinding.FragmentCountdownBinding
import de.hdmstuttgart.fitnessapp.datastore.SettingsViewModel
import kotlinx.coroutines.*

class CountdownFragment : Fragment(R.layout.fragment_countdown) {
    companion object {
        const val CHANNEL_ID = "channelID"
        const val NOTIFICATION_ID = 0
    }

    private lateinit var binding: FragmentCountdownBinding

    private lateinit var exerciseRepo: ExerciseRepository

    private val scope = CoroutineScope(SupervisorJob())
    private var isPaused = false
    private var resumeFromMillis: Long = 0

    lateinit var notification: Notification
    lateinit var notificationManager: NotificationManagerCompat

    private val numberExercises = 7
    private var currentExercise = 0

    private var currentExerciseName = ""

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentCountdownBinding.bind(view)

        setHasOptionsMenu(true)
        startCountdown(60000, 10)

        val database = DataBase.getInstance(requireContext(), scope)
        exerciseRepo = ExerciseRepository(database.exerciseDao())

        val generator = TrainingsPlanGenerator(requireContext(), scope)

       scope.launch() {
           generator.createTrainingsPlan("newPlan22", 120, 0.125F, 0.75F, 0.125F)
       }

        binding.btnStartStop.setOnClickListener {
            if (!isPaused) {
                isPaused = true
            } else {
                isPaused = false
                startCountdown(resumeFromMillis, 10)
            }
        }

        binding.tvLast.setOnClickListener {
            binding.tvExercise.text = "Klimmzuege"
            scope.launch {
                lastButton()
            }
        }

        binding.tvCurrent.setOnClickListener {
            binding.tvExercise.text = "Exercise"
            scope.launch {
                currentButton()
            }
        }

        binding.tvNext.setOnClickListener {
            val communicator = activity as Communicator
            if (currentExercise < numberExercises) {
                currentExercise++
                scope.launch {
                    nextButton()
                }
            } else {
                communicator.switchToFinish()
            }
        }

        val intent = Intent(requireContext(), MainActivity::class.java)
        intent.putExtra("exercise", 5)
        val pendingIntent = TaskStackBuilder.create(requireContext()).run {
            addNextIntentWithParentStack(intent)
            getPendingIntent(0, PendingIntent.FLAG_UPDATE_CURRENT)
        }

        notification = NotificationCompat.Builder(requireContext(), CHANNEL_ID)
            .setSmallIcon(R.drawable.ic_baseline_timer_24)
            .setContentTitle("Zeit vorbei")
            .setContentText("Deine Zeit für die Übung $currentExerciseName ist abgelaufen")
            .setAutoCancel(true)
            .setContentIntent(pendingIntent)
            .build()

        notificationManager = NotificationManagerCompat.from(requireContext())
    }

    private fun startCountdown(millisInFuture: Long, countDownInterval: Long) {
        object : CountDownTimer(millisInFuture, countDownInterval) {
            override fun onTick(millisUntilFinished: Long) {
                val textTimeRemaining = millisUntilFinished / 1000
                val circleTimeRemaining = millisUntilFinished / 10
                if (isPaused) {
                    binding.tvCountdown.text = textTimeRemaining.toString()
                    binding.pbCountdown.progress = circleTimeRemaining.toInt()
                    resumeFromMillis = millisUntilFinished
                    cancel()
                } else {
                    try {
                        binding.tvCountdown.text = textTimeRemaining.toString()
                        binding.pbCountdown.progress = circleTimeRemaining.toInt()
                    } catch (e: Exception) {
                        cancel()
                        e.printStackTrace()
                    }
                }
            }

            override fun onFinish() {
                val settingsViewModel by viewModels<SettingsViewModel>()
                settingsViewModel.readIsNotificationEnabled.observe(viewLifecycleOwner, { isNotificationEnabled ->
                    if (isNotificationEnabled) {
                        notificationManager.notify(NOTIFICATION_ID, notification)
                    }
                })
                binding.tvCountdown.text = getString(R.string.done)
            }
        }.start()
    }

    private suspend fun nextButton() {
        isPaused = true
        delay(100)
        withContext(Dispatchers.Main) {
//            binding.tvExercise.text = exerciseRepo.getAllExercises()[1].name
            isPaused = false
            startCountdown(60000, 10)
        }
    }

    private suspend fun currentButton() {
        isPaused = true
        delay(100)
        withContext(Dispatchers.Main) {
            isPaused = false
            startCountdown(60000, 10)
        }
    }

    private suspend fun lastButton() {
        isPaused = true
        delay(100)
        withContext(Dispatchers.Main) {
            isPaused = false
            startCountdown(60000, 10)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.to_home, menu)
    }
}
