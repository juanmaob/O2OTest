package com.seventhson.o2otest.ui.common

import androidx.appcompat.app.AppCompatActivity
import com.seventhson.o2otest.O2OTestApplication
import com.seventhson.o2otest.di.ApplicationComponent

/**
 * Created by Juanma Osuna on 4/04/19
 */
abstract class BaseActivity: AppCompatActivity() {

    fun getApplicationComponent(): ApplicationComponent {
        return (application as O2OTestApplication).getApplicationComponent()
    }

}