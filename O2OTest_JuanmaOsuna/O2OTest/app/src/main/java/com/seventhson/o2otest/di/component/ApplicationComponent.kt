package com.seventhson.o2otest.di.component

import android.app.Application
import com.seventhson.o2otest.O2OTestApplication
import com.seventhson.o2otest.data.network.NetworkModule
import com.seventhson.o2otest.di.module.ActivityModule
import com.seventhson.o2otest.di.module.ApplicationModule
import com.seventhson.o2otest.di.module.RepositoryModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import javax.inject.Singleton

/**
 * Created by Juanma Osuna on 4/04/19
 */
@Singleton
@Component(modules = [AndroidInjectionModule::class,
    ApplicationModule::class,
    NetworkModule::class,
    ActivityModule::class,
    RepositoryModule::class])
interface ApplicationComponent {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder

        fun build(): ApplicationComponent
    }

    fun inject(app: O2OTestApplication)

}