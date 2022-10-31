package com.monksoft.inventory.mainModule.view.adapters

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.PerformException
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.longClick
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.contrib.RecyclerViewActions.*
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import com.monksoft.inventory.clickInChild
import com.monksoft.inventory.mainModule.view.MainActivity
import org.hamcrest.CoreMatchers.*
import org.junit.Assert.fail
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@LargeTest
@RunWith(AndroidJUnit4::class)
class ProductAdapterTest {
    @Rule
    @JvmField
    var mActivityScenarioRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun listItem_click_successCheck(){
        onView(withId(R.id.recycleView))
            .perform(RecyclerViewActions.actionOnItemAtPosition<ProductAdapter.ViewHolder>(1, click()))

        onView(withId(com.google.android.material.R.id.snackbar_text))
            .check(matches(withText("Queso")))
    }

    @Test
    fun listItem_longClick_removeFromView(){
        onView(withId(R.id.recyclerView))
            .perform(actionOnItem<ProductAdapter.ViewHolder>(
                hasDescendant(withText(containsString("Tijeras"))), longClick()),
                scrollTo<ProductAdapter.ViewHolder>(withText(containsString("Vino")))
            )

        try {
            onView(withId(R.id.recyclerView))
                .perform(
                    scrollTo<ProductAdapter.ViewHolder>(
                        hasDescendant(withText(containsString("Tijeras")))
                    )
                )

            fail("Tijeras aun existe!!")
        } catch(e : Exception){
            assertThat((e as? PerformException), `is`(notNullValue()))
        }
    }

    @Test
    fun cbFavorite_click_changeState(){
        onView(withId(R.id.recyclerView))
            .perform(actionOnItemAtPosition<ProductAdapter.ViewHolder>(1, clickInChild(R.id.cbFavorite)))
    }
}