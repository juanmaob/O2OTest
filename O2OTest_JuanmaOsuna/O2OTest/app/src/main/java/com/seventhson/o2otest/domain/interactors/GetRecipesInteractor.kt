package com.seventhson.o2otest.domain.interactors

import com.seventhson.o2otest.data.results.DataResult
import com.seventhson.o2otest.data.repository.RecipeRepositoryImpl
import com.seventhson.o2otest.domain.model.Recipe
import com.seventhson.o2otest.domain.repository.RecipeRepository
import javax.inject.Inject

class GetRecipesInteractor @Inject constructor(private val repository: RecipeRepository): Interactor<List<Recipe>>() {

    private lateinit var text: String

    fun setParams(text: String) {
        this.text = text
    }

    override fun executeRepoCall(): DataResult<List<Recipe>> = repository.refreshRecipes(text)

}