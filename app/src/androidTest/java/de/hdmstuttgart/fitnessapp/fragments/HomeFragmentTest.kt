package de.hdmstuttgart.fitnessapp.fragments

import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import de.hdmstuttgart.fitnessapp.R
import de.hdmstuttgart.fitnessapp.activity.MainActivity
import junit.framework.TestCase
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class HomeFragmentTest : TestCase() {

    @Test
    fun btnGenerateDisplayed() {
//        ActivityScenario.launch(MainActivity::class.java)

        launchFragmentInContainer<HomeFragment>()
        onView(withId(R.id.btnGenerate))
            .check(matches(isDisplayed()))

        onView(withId(R.id.btnGenerate))
            .check(matches(withText("Generate \n Trainingsplan")))
    }
}