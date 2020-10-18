package com.seventhson.o2otest.data.database.entities

import androidx.room.*
import androidx.room.ForeignKey.CASCADE
import com.seventhson.o2otest.domain.model.Recipe
import com.seventhson.o2otest.domain.model.RecipeContainer

@Entity
data class DataBaseRecipe (
    val title: String,
    @PrimaryKey
    val href: String,
    val ingredients: String,
    val thumbnail: String
)

fun List<DataBaseRecipe>.asDomainModel() : List<Recipe> {
    return map {
        Recipe(
            title = it.title,
            href = it.href,
            ingredients = it.ingredients,
            thumbnail = it.thumbnail
        )
    }
}

fun List<Recipe>.asDatabaseModel() : List<DataBaseRecipe> {
    return map {
        DataBaseRecipe(
            title = it.title,
            href = it.href,
            ingredients = it.ingredients,
            thumbnail = it.thumbnail
        )
    }
}