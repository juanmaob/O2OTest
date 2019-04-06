package com.seventhson.o2otest.ui.main.di

import com.seventhson.o2otest.ui.main.MainActivity
import dagger.Subcomponent

/**
 * Created by Juanma Osuna on 4/04/19
 */
@Subcomponent(modules = [MainModule::class])
interface MainComponent {
    fun inject(activity: MainActivity)
}