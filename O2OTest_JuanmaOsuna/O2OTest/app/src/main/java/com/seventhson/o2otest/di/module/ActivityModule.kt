package com.seventhson.o2otest.di.module

import com.seventhson.o2otest.ui.detail.DetailActivity
import com.seventhson.o2otest.ui.main.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector


@Module
abstract class ActivityModule {

    @ContributesAndroidInjector
    abstract fun bindMainActivity(): MainActivity

    @ContributesAndroidInjector
    abstract fun bindDetailActivity(): DetailActivity


}