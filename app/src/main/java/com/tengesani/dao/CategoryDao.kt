package com.tengesani.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.tengesani.model.Category
import kotlinx.coroutines.flow.Flow

@Dao
interface CategoryDao {

    @Query("SELECT * FROM category")
    fun getAllCategories(): LiveData<MutableList<Category>>

    @Insert
    fun recordCategory(category: Category)

    @Delete
    fun cancelCategory(category: Category)


    @Update
    fun updateCategory(category: Category)

}