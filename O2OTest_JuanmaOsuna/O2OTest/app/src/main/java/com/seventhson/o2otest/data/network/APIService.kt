package com.seventhson.o2otest.data.network

import com.seventhson.o2otest.data.pojos.RecipeResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by Juanma Osuna on 4/04/19
 */
interface APIService {

    @GET("/api")
    fun getRecipe(@Query("q") name: String): Call<RecipeResponse>

}