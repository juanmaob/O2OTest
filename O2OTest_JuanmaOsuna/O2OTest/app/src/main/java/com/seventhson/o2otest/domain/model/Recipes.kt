package com.seventhson.o2otest.domain.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

/**
 * Created by Juanma Osuna on 4/04/19
 */

data class RecipeContainer(
    val title: String,
    val version: Float,
    val href: String,
    val results: List<Recipe>
)

data class Recipe(
    val title: String,
    val href: String,
    val ingredients: String,
    val thumbnail: String
): Serializable



