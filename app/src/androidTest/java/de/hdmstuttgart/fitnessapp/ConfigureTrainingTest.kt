package de.hdmstuttgart.fitnessapp

import android.view.Gravity
import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.DrawerActions
import androidx.test.espresso.contrib.DrawerMatchers.isClosed
import androidx.test.espresso.matcher.ViewMatchers.*
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
    fun configureTraining() {
        onView(withId(R.id.drawerLayout))
            .check(matches(isClosed(Gravity.LEFT)))
            .perform(DrawerActions.open())

        onView(withId(R.id.configure))
            .perform(click())

        onView(withId(R.id.tvTrainingTime))
            .check(matches(withText("3,00")))

        onView(withId(R.id.btnMinus))
            .perform(click())

        onView(withId(R.id.tvTrainingTime))
            .check(matches(withText("2,45")))


        onView(withId(R.id.btnPlus))
            .perform(click())

        onView(withId(R.id.tvTrainingTime))
            .check(matches(withText("3,00")))

        onView(withId(R.id.rangeSlider))
            .check(matches(isDisplayed()))


    }
}