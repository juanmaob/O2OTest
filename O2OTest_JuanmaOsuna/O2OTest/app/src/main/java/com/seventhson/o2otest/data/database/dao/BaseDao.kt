package com.seventhson.o2otest.data.database.dao

import androidx.room.*
import com.seventhson.o2otest.data.database.entities.DataBaseRecipe


interface BaseDao<T> {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(any: List<T>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(any: T)

    @Update
    fun update(any: T)

    @Delete
    fun delete(any: T)

    @Delete
    fun deleteAll(any: List<T>)


}