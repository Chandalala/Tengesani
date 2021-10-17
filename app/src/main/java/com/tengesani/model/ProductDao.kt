package com.tengesani.model

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface ProductDao {

    @Query("SELECT * FROM product")
    fun getAllProducts(): Flow<List<Product>>

    @Insert
    fun recordProduct(product: Product)

    @Delete
    fun cancelProduct(product: Product)


    @Update
    fun updateProduct(product: Product)

}