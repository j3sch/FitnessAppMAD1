package de.hdmstuttgart.fitnessapp

import androidx.core.content.ContentProviderCompat.requireContext
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import de.hdmstuttgart.fitnessapp.activity.MainActivity
import de.hdmstuttgart.fitnessapp.database.DataBase
import de.hdmstuttgart.fitnessapp.database.repositories.TrainingsPlanRepository
import de.hdmstuttgart.fitnessapp.database.viewmodels.TrainingsPlanViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
@LargeTest
class RunThroughTest {

    @get:Rule
    val activityRule = ActivityScenarioRule(MainActivity::class.java)

//    @Test
//    fun training() {
//        onView(withId(R.id.btnGenerate))
//            .perform(click())
//
//        onView(withId(R.id.btnStartTraining))
//            .perform(click())
//
//        runBlocking {
//            delay(1000L)
//            onView(withId(R.id.btnStartStop))
//                .perform(click())
//
//            onView(withId(R.id.tvNext))
//                .perform(click())
//        }
//    }
}