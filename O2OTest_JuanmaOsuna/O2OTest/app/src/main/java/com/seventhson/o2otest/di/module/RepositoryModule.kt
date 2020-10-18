package com.seventhson.o2otest.di.module


import com.seventhson.o2otest.data.database.AppDatabase
import com.seventhson.o2otest.data.network.APIService
import com.seventhson.o2otest.data.repository.RecipeRepositoryImpl
import com.seventhson.o2otest.domain.repository.RecipeRepository
import dagger.Module
import dagger.Provides

@Module
class RepositoryModule {
    @Provides
    fun providesMyObjectRepository(database: AppDatabase, apiService: APIService): RecipeRepository {
        return RecipeRepositoryImpl(database, apiService)
    }
}