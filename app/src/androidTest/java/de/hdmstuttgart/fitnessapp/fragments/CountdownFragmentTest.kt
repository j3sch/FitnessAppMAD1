package de.hdmstuttgart.fitnessapp.fragments

import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.runners.AndroidJUnit4
import de.hdmstuttgart.fitnessapp.R
import junit.framework.TestCase
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class CountdownFragmentTest : TestCase() {

    @Before
    fun setup() {
       launchFragmentInContainer<CountdownFragment>()
    }

    @Test
    fun testTvCurrent() {
        onView(withId(R.id.tvCurrent))
            .check(matches(withText("Current")))
    }

    @Test
    fun countdownTest() {
        onView(withId(R.id.tvCountdown))
            .check(matches(withText("10:00")))
    }








    fun testGetNotification() {}

    fun testSetNotification() {}

    fun testGetNotificationManager() {}

    fun testSetNotificationManager() {}

    fun testOnViewCreated() {}

    fun testOnCreateOptionsMenu() {}
}