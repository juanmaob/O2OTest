package com.seventhson.o2otest

import android.app.Application
import com.seventhson.o2otest.di.ApplicationComponent
import com.seventhson.o2otest.di.ApplicationModule
import com.seventhson.o2otest.di.DaggerApplicationComponent

/**
 * Created by Juanma Osuna on 4/04/19
 */
class O2OTestApplication: Application() {

    private lateinit var appComponent: ApplicationComponent

    override fun onCreate() {
        super.onCreate()
        initDagger()
    }

    private fun initDagger(){
        appComponent = DaggerApplicationComponent.builder()
            .applicationModule(ApplicationModule(this))
            .build()
    }

    fun getApplicationComponent(): ApplicationComponent{
        return appComponent
    }

}