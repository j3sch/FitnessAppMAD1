package de.hdmstuttgart.fitnessapp.fragments

import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import de.hdmstuttgart.fitnessapp.R
import de.hdmstuttgart.fitnessapp.activity.MainActivity
import junit.framework.TestCase
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class CountdownFragmentTest : TestCase() {

    @get:Rule
    val activityRule = ActivityScenarioRule(MainActivity::class.java)

    @Before
    fun setup() {
       launchFragmentInContainer<CountdownFragment>()
    }

    @Test
    fun testTvCurrent() {
        onView(withId(R.id.tvCurrent))
            .check(matches(isDisplayed()))
            .check(matches(withText("Current")))

        activityRule.scenario.close()
    }
//
//    @Test
//    fun countdownStartTest() {
//        onView(withId(R.id.tvCountdown))
//            .check(matches(withText("@string/countdown_time")))

//        runBlocking {
//            delay(500L)
//        }
//
//        onView(withId(R.id.tvCountdown))
//            .check(matches(withText("1")))
//    }

//    @Test
//    fun stopCountDown() {
//
//        runBlocking {
//            delay(500L)
//        }
//
//        onView(withId(R.id.tvCountdown))
//            .check(matches(withText("1")))
//        onView(withId(R.id.btnStartStop))
//            .perform(click())
//
//        runBlocking {
//            delay(1000L)
//        }
//
//        onView(withId(R.id.tvCountdown))
//            .check(matches(withText("59")))
//    }
}