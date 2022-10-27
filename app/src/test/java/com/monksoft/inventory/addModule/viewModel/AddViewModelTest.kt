package com.monksoft.inventory.addModule.viewModel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.monksoft.inventory.entities.Product
import org.hamcrest.CoreMatchers.*
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.annotation.Config

//@Config(sdk = [21,30])
//@Config(maxSdk = 30)
@RunWith(AndroidJUnit4::class)
internal class AddViewModelTest {
    @get:Rule
    var instantExcecutorRule = InstantTaskExecutorRule()

    @Test
    fun addProduct(){
        val addViewModule = AddViewModel()
        val producto = Product(117, "Xbox", 20, "https://www.trustedreviews.com" +
                "/wp-content/uploads/sites/54/2020/11/New-Console-Headers-Xbox-S-920x613.jpg", 4.8, 56)

        val observer = Observer<Boolean>{}

        try {
            addViewModule.getResult().observeForever(observer)
            addViewModule.addProduct(producto)
            val result = addViewModule.getResult().value

            assertThat(result, `is`(true))
            assertThat(result, not(nullValue()))
        } finally {
            addViewModule.getResult().removeObserver(observer)
        }
    }
}