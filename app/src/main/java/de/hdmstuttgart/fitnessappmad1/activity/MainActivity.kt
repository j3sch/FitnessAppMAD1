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
import de.hdmstuttgart.fitnessappmad1.fragments.*
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), Communicator {

    private val CHANNEL_ID = "channelID"
    private val CHANNEL_NAME = "channelName"

    lateinit var toggle: ActionBarDrawerToggle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        createNotificationChannel()
        switchToHome()

        toggle = ActionBarDrawerToggle(this, drawerLayout, R.string.open, R.string.close)
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        navView.setNavigationItemSelectedListener {
            drawerLayout.close()
            when (it.itemId) {
                R.id.home -> switchToHome()
                R.id.konfiguration -> Toast.makeText(applicationContext, "Clicked Trainingsplan konfigurieren", Toast.LENGTH_SHORT).show()
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
            item.itemId == R.id.action_exit -> {
                switchToHome()
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