package com.tengesani.category.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.tengesani.category.model.Category

@Dao
interface CategoryDao {

    @Query("SELECT * FROM category")
    fun getAllCategories(): LiveData<MutableList<Category>>

    @Insert
    fun recordCategory(category: Category)

    @Delete
    fun removeCategory(category: Category)


    @Update
    fun updateCategory(category: Category)

}