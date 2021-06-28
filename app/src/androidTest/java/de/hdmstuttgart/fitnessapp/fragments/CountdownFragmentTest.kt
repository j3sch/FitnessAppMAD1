package de.hdmstuttgart.fitnessapp.fragments

import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.runners.AndroidJUnit4
import de.hdmstuttgart.fitnessapp.R
import de.hdmstuttgart.fitnessapp.activity.MainActivity
import junit.framework.TestCase
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class CountdownFragmentTest : TestCase() {

    @Test
    fun testTvCurrent() {
        ActivityScenario.launch(MainActivity::class.java)


        onView(withId(R.id.tvCurrent))
            .check(matches(isDisplayed()))
//
//        onView(withId(R.id.tvCurrent))
//            .check(matches(withText("Current")))
    }








    fun testGetNotification() {}

    fun testSetNotification() {}

    fun testGetNotificationManager() {}

    fun testSetNotificationManager() {}

    fun testOnViewCreated() {}

    fun testOnCreateOptionsMenu() {}
}