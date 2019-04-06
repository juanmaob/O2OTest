package com.seventhson.o2otest.data.network

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

/**
 * Created by Juanma Osuna on 4/04/19
 */
@Module
class NetworkModule {

    @Singleton
    @Provides
    fun providesGson(): Gson {
        return GsonBuilder().create()
    }

    @Singleton
    @Provides
    internal fun provideRetrofitClient(gson: Gson): Retrofit {
        return Retrofit.Builder()
            .baseUrl("http://www.recipepuppy.com")
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
    }

    @Singleton
    @Provides
    fun provideApiService(retrofit: Retrofit): APIService {
        return retrofit.create(APIService::class.java)
    }

}