package com.seventhson.o2otest.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.RoomDatabase
import com.seventhson.o2otest.data.database.dao.RecipeDao
import com.seventhson.o2otest.data.database.entities.DataBaseRecipe


@Database(
    entities = [DataBaseRecipe::class], version = 1
)
abstract class AppDatabase: RoomDatabase() {
    abstract val recipeDao: RecipeDao
}
