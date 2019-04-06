package com.seventhson.o2otest.di

import android.app.Application
import com.seventhson.o2otest.O2OTestApplication
import com.seventhson.o2otest.ui.common.Navigator
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by Juanma Osuna on 4/04/19
 */
@Module
class ApplicationModule(private val application: Application) {

    @Provides
    @Singleton
    fun providesApplication(): Application {
        return application
    }

    @Provides
    @Singleton
    fun providesNavigator(): Navigator{
        return Navigator()
    }


}