package com.seventhson.o2otest.ui.main.adapter

import android.view.View
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.seventhson.o2otest.domain.model.Recipe
import com.seventhson.o2otest.utils.fromUrl
import kotlinx.android.synthetic.main.item_recipe.view.*

/**
 * Created by Juanma Osuna on 5/04/19
 */
class RecipeViewHolder(view: View): RecyclerView.ViewHolder(view) {

    fun render(recipe: Recipe, onItemClick: (Recipe, ImageView) -> Unit) {
        itemView.ivRecipe.fromUrl(recipe.thumbnail)
        itemView.tvRecipe.text = recipe.title
        itemView.tvIngredients.text = recipe.ingredients
        itemView.tvWebRef.text = recipe.href
        itemView.setOnClickListener { onItemClick(recipe, itemView.ivRecipe) }
    }
}