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
import android.widget.Toast
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import de.hdmstuttgart.fitnessapp.navigation.Communicator
import de.hdmstuttgart.fitnessapp.R
import de.hdmstuttgart.fitnessapp.activity.MainActivity
import de.hdmstuttgart.fitnessapp.databinding.FragmentCountdownBinding
import de.hdmstuttgart.fitnessapp.datastore.SettingsViewModel
import kotlinx.coroutines.*

class CountdownFragment(private val generator: TrainingsPlanGenerator) : Fragment(R.layout.fragment_countdown) {
    companion object {
        const val CHANNEL_ID = "channelID"
        const val NOTIFICATION_ID = 0
    }

    private lateinit var binding: FragmentCountdownBinding

    private val scope = CoroutineScope(SupervisorJob())
    private var isPaused = false
    private var resumeFromMillis: Long = 0

    lateinit var notification: Notification
    lateinit var notificationManager: NotificationManagerCompat

    private val numberExercises = generator.exercisesForTrainingsPlan.size
    private var currentExercise = 0
    private var exerciseList = generator.exercisesForTrainingsPlan

    private var currentExerciseName = ""

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentCountdownBinding.bind(view)

        setHasOptionsMenu(true)
        println(exerciseList[currentExercise].duration)
        startCountdown(exerciseList[currentExercise].duration.toLong() * 60000, 10)
        binding.pbCountdown.max = exerciseList[currentExercise].duration * 6000

        currentExerciseName = exerciseList[currentExercise].name
        binding.tvExercise.text = currentExerciseName

        binding.btnStartStop.setOnClickListener {
            if (!isPaused) {
                isPaused = true
            } else {
                isPaused = false
                startCountdown(resumeFromMillis, 10)
            }
        }

        binding.tvExercise.setOnClickListener {
        }

        binding.tvLast.setOnClickListener {
            if (currentExercise > 0) {
                currentExercise--
                scope.launch {
                    lastButton()
                }
            } else {
                Toast.makeText(requireContext(), "Bereits bei der ersten Übung", Toast.LENGTH_LONG).show()
            }

        }

        binding.tvNext.setOnClickListener {
            val communicator = activity as Communicator
            if (currentExercise < numberExercises - 1) {
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
            currentExerciseName = exerciseList[currentExercise].name
            binding.tvExercise.text = currentExerciseName
            isPaused = false
            startCountdown(exerciseList[currentExercise].duration.toLong() * 60000, 10)
            binding.pbCountdown.max = exerciseList[currentExercise].duration * 6000
        }
    }

    private suspend fun lastButton() {
        isPaused = true
        delay(100)
        withContext(Dispatchers.Main) {
            currentExerciseName = exerciseList[currentExercise].name
            binding.tvExercise.text = currentExerciseName
            isPaused = false
            startCountdown(exerciseList[currentExercise].duration.toLong() * 60000, 10)
            binding.pbCountdown.max = exerciseList[currentExercise].duration * 6000
        }
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.to_home, menu)
    }
}
