package de.hdmstuttgart.fitnessapp.fragments

import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.runners.AndroidJUnit4
import de.hdmstuttgart.fitnessapp.R
import junit.framework.TestCase
import org.junit.Test
import org.junit.runner.RunWith

//@RunWith(AndroidJUnit4::class)
//class HomeFragmentTest : TestCase() {
//
//    @Test
//    fun btnGenerateDisplayed() {
//
//        launchFragmentInContainer<HomeFragment>()
//        onView(withId(R.id.btnGenerate))
//            .check(matches(isDisplayed()))
//
//        onView(withId(R.id.btnGenerate))
//            .check(matches(withText("Generate \n Trainingsplan")))
//    }
//}