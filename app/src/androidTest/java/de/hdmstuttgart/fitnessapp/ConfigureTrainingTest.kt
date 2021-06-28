package de.hdmstuttgart.fitnessapp

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import de.hdmstuttgart.fitnessapp.activity.MainActivity
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
@LargeTest
class ConfigureTrainingTest {

    @get:Rule
    val activityRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun stopStartCountdown() {

        onView(withId(R.id.btnGenerate))
            .perform(click())

        onView(withId(R.id.btnStartTraining))
            .perform(click())


        onView(withId(R.id.btnStartStop))
            .perform(click())

//        onView(withId(R.id.pbCountdown))
//            .check()


        onView(withId(R.id.btnStartStop))
            .perform(click())

        activityRule.scenario.close()
    }
}