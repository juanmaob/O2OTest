package com.seventhson.o2otest.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.seventhson.o2otest.data.database.entities.DataBaseRecipe


@Dao
abstract class RecipeDao: BaseDao<DataBaseRecipe> {

    @Query("SELECT * FROM DataBaseRecipe")
    abstract fun getRecipeList(): List<DataBaseRecipe>

}