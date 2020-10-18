package com.seventhson.o2otest.domain.repository

import com.seventhson.o2otest.data.results.DataResult
import com.seventhson.o2otest.domain.model.Recipe

interface RecipeRepository {

    fun refreshRecipes(text: String) : DataResult<List<Recipe>>

}