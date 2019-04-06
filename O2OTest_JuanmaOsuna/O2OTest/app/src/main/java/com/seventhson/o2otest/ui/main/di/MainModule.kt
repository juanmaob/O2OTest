package com.seventhson.o2otest.ui.main.di

import android.app.Activity
import com.seventhson.o2otest.data.network.APIService
import com.seventhson.o2otest.ui.main.MainInteractor
import com.seventhson.o2otest.ui.main.MainPresenter
import dagger.Module
import dagger.Provides

/**
 * Created by Juanma Osuna on 4/04/19
 */
@Module
class MainModule(private val  activity: Activity) {

    @Provides
    fun provideActivity(): Activity {
        return this.activity
    }

    @Provides
    fun provideMainInteractor(apiService: APIService): MainInteractor {
        return MainInteractor(apiService)
    }

    @Provides
    fun providesMainPresnter(mainInteractor: MainInteractor): MainPresenter {
        return MainPresenter(mainInteractor)
    }

}