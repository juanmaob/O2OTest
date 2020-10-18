package com.seventhson.o2otest.data.repository

import com.seventhson.o2otest.data.database.AppDatabase
import com.seventhson.o2otest.data.database.entities.DataBaseRecipe
import com.seventhson.o2otest.data.database.entities.asDomainModel
import com.seventhson.o2otest.data.results.DataResult
import com.seventhson.o2otest.data.network.APIService
import com.seventhson.o2otest.data.network.reponse.RecipeContainerResponse
import com.seventhson.o2otest.data.network.reponse.asDatabaseModel
import com.seventhson.o2otest.data.network.reponse.asDomainModel
import com.seventhson.o2otest.domain.model.Recipe
import com.seventhson.o2otest.domain.repository.RecipeRepository
import kotlinx.coroutines.*
import retrofit2.Response
import javax.inject.Inject


class RecipeRepositoryImpl @Inject constructor(
    private val database: AppDatabase,
    private val apiService: APIService
) : RecipeRepository, Repository() {

    override fun refreshRecipes(text: String): DataResult<List<Recipe>> {
        val result: DataResult<out Response<*>>
        return if (text.isEmpty()) {
            //la llamada usando la base de datos
            result = execute(apiService.getRecipe(text))
            result.response?.let { saveRecipeList(it) }
            DataResult(
                result.state,
                getStoredRecipeList()
            )
        } else {
            //la llamada sin usar base de datos
            result = execute(apiService.getRecipe(text))
            DataResult(
                result.state,
                (result.response?.body() as? RecipeContainerResponse)?.asDomainModel()?.results
            )
        }
    }


    private fun saveRecipeList(response: Response<*>) = runBlocking {
        withContext(Dispatchers.IO) {
            database.recipeDao.insert((response.body() as RecipeContainerResponse).results.asDatabaseModel())
        }
    }

    private fun getStoredRecipeList(): List<Recipe> = runBlocking {
        withContext(Dispatchers.IO) {
            return@withContext database.recipeDao.getRecipeList().asDomainModel()
        }
    }

    private fun getStoredDatabaseRecipeList(): List<DataBaseRecipe> = runBlocking {
        withContext(Dispatchers.IO) {
            return@withContext database.recipeDao.getRecipeList()
        }
    }

    private fun deleteStoredRecipeList(list: List<DataBaseRecipe>) = runBlocking {
        withContext(Dispatchers.IO) {
            return@withContext database.recipeDao.deleteAll(list)
        }
    }

}
