package com.monksoft.inventory.addModule.view

import android.app.AlertDialog
import android.content.DialogInterface
import androidx.fragment.app.testing.launchFragment
import androidx.lifecycle.Lifecycle
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Test
import org.junit.runner.RunWith
import com.monksoft.inventory.R
import org.hamcrest.CoreMatchers.*
import org.hamcrest.MatcherAssert.assertThat

@RunWith(AndroidJUnit4::class)
class AddProductFragmentTest {

    @Test
    fun createDialog_notNullTest() {
        val scenario = launchFragment<AddProductFragment>(themeResId = R.style.Theme_Inventory)//hya que especificar el thema del proyecto
        scenario.moveToState(Lifecycle.State.RESUMED)
        scenario.onFragment { fragment ->
            assertThat(fragment.dialog, `is`(notNullValue()))
        }
    }

    @Test
    fun cancelDialog_isNullTest(){
        val scenario = launchFragment<AddProductFragment>(themeResId = R.style.Theme_Inventory)
        scenario.moveToState(Lifecycle.State.RESUMED)
        scenario.onFragment { fragment ->
            (fragment.dialog as? AlertDialog)?.let {
                it.getButton(DialogInterface.BUTTON_NEGATIVE).performClick()
                assertThat(fragment.dialog, `is`(nullValue()))
            }
        }
    }
}