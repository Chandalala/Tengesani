package com.tengesani.model

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface CategoryDao {

    @Query("SELECT * FROM category")
    fun getAllCategories(): Flow<List<Category>>

    @Insert
    fun recordCategory(category: Category)

    @Delete
    fun cancelCategory(category: Category)


    @Update
    fun updateCategory(category: Category)

}