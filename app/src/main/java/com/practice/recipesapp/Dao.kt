package com.practice.recipesapp

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface Dao {
    @Query("SELECT * FROM recipe")
    fun getAll(): List<Recipe?>?

    @Insert
    fun insert(recipe: Recipe)
}