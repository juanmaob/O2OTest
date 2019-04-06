package com.seventhson.o2otest.data.pojos

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable

/**
 * Created by Juanma Osuna on 4/04/19
 */

data class RecipeResponse(
    @SerializedName("title") val title: String,
    @SerializedName("version") val version: Float,
    @SerializedName("href") val href: String,
    @SerializedName("results") val results: List<Recipe>
)

data class Recipe(
    @SerializedName("title") val title: String,
    @SerializedName("href") val href: String,
    @SerializedName("ingredients") val ingredients: String,
    @SerializedName("thumbnail") val thumbnail: String
): Serializable



