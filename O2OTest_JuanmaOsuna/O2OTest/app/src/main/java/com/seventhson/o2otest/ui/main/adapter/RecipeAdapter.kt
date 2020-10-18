package com.seventhson.o2otest.ui.main.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.seventhson.o2otest.R
import com.seventhson.o2otest.domain.model.Recipe

/**
 * Created by Juanma Osuna on 5/04/19
 */
class RecipeAdapter(private val recipeList: MutableList<Recipe>, private val onItemClick: (Recipe, ImageView) -> Unit):
    RecyclerView.Adapter<RecipeViewHolder>() {


    override fun onBindViewHolder(holder: RecipeViewHolder, position: Int) {
        val item = recipeList[position]
        holder.render(item, onItemClick)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecipeViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return RecipeViewHolder(layoutInflater.inflate(R.layout.item_recipe, parent, false))
    }

    override fun getItemCount(): Int {
        return recipeList.size
    }

    fun addAll(list: List<Recipe>) {
        recipeList.clear()
        recipeList.addAll(list)
        notifyDataSetChanged()
    }


}

