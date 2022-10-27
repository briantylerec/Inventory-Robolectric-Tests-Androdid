package com.monksoft.inventory.mainModule.viewModel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.hamcrest.CoreMatchers
import org.hamcrest.CoreMatchers.not
import org.hamcrest.CoreMatchers.nullValue
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
internal class MainViewModelTest {
    @get:Rule
    var instantExcecutorRule = InstantTaskExecutorRule()

    @Test
    fun checkWelcomeTest(){
        val mainViewModel = MainViewModel(ApplicationProvider.getApplicationContext())
        val observer = Observer<Boolean>{}

        try{
            mainViewModel.isWelcome().observeForever(observer)
            val result = mainViewModel.isWelcome().value

            assertThat(result, not(nullValue()))
            assertThat(result, CoreMatchers.`is`(true))
        } finally {
            mainViewModel.isWelcome().removeObserver(observer)
        }
    }
}