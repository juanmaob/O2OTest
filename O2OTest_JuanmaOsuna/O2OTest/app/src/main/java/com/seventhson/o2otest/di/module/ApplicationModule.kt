package com.seventhson.o2otest.di.module

import android.app.Application
import android.content.Context
import androidx.room.Room
import com.seventhson.o2otest.data.database.AppDatabase
import com.seventhson.o2otest.ui.common.Navigator
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by Juanma Osuna on 4/04/19
 */
@Module
class ApplicationModule() {

    @Provides
    @Singleton
    fun providesApplicationContext(application: Application): Context {
        return application.applicationContext
    }

    @Provides
    @Singleton
    fun providesNavigator(): Navigator{
        return Navigator()
    }

    @Provides
    @Singleton
    fun provideDatabase(context: Context): AppDatabase {
        return Room.databaseBuilder(context, AppDatabase::class.java, "o2otest.db").build()
    }
}