package com.seventhson.o2otest.ui.main

import androidx.annotation.UiThread
import com.seventhson.o2otest.data.network.APIService
import com.seventhson.o2otest.data.pojos.Recipe
import com.seventhson.o2otest.data.pojos.RecipeResponse
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import kotlin.reflect.KFunction1

/**
 * Created by Juanma Osuna on 4/04/19
 */

class MainInteractor(private val apiService: APIService) {


    fun getRecipes(onSuccess: (List<Recipe>) -> Unit, text: String) {

        val response = GlobalScope.async() {
            val response = apiService.getRecipe(text).execute()
            response.body() as RecipeResponse
        }
        MainScope().launch() {
            onSuccess(response.await().results)
        }

    }


}