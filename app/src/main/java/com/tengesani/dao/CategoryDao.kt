package com.tengesani.dao

import androidx.room.*
import com.tengesani.model.Category
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