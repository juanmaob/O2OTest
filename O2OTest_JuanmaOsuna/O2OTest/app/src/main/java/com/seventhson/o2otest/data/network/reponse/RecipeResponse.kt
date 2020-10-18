package com.seventhson.o2otest.data.network.reponse

import com.google.gson.annotations.SerializedName
import com.seventhson.o2otest.data.database.entities.DataBaseRecipe
import com.seventhson.o2otest.domain.model.Recipe
import com.seventhson.o2otest.domain.model.RecipeContainer
import java.io.Serializable

data class RecipeContainerResponse(
    @SerializedName("title") val title: String,
    @SerializedName("version") val version: Float,
    @SerializedName("href") val href: String,
    @SerializedName("results") val results: List<RecipeResponse>
)

data class RecipeResponse(
    @SerializedName("title") val title: String,
    @SerializedName("href") val href: String,
    @SerializedName("ingredients") val ingredients: String,
    @SerializedName("thumbnail") val thumbnail: String
): Serializable


//DTOs

fun RecipeContainerResponse.asDomainModel() : RecipeContainer {
    return RecipeContainer(
        title = title,
        version = version,
        href = href,
        results = results.asDomainModel()
    )
}

fun List<RecipeResponse>.asDomainModel() : List<Recipe> {
    return map {
        Recipe(
            title = it.title,
            href = it.href,
            ingredients = it.ingredients,
            thumbnail = it.thumbnail
        )
    }
}

fun List<RecipeResponse>.asDatabaseModel() : List<DataBaseRecipe> {
    return map {
        DataBaseRecipe(
            title = it.title,
            href = it.href,
            ingredients = it.ingredients,
            thumbnail = it.thumbnail
        )
    }
}