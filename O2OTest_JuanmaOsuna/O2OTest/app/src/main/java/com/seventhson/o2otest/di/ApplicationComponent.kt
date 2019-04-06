package com.seventhson.o2otest.di

import android.app.Application
import com.seventhson.o2otest.data.network.NetworkModule
import com.seventhson.o2otest.ui.main.di.MainComponent
import com.seventhson.o2otest.ui.main.di.MainModule
import dagger.Component
import javax.inject.Singleton

/**
 * Created by Juanma Osuna on 4/04/19
 */
@Singleton
@Component(modules = [ApplicationModule::class, NetworkModule::class])
interface ApplicationComponent {

    var application: Application//todo no se usa??

    fun plus(module: MainModule): MainComponent

}