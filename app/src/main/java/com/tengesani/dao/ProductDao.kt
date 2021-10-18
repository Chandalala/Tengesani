package com.tengesani.dao

import androidx.room.*
import com.tengesani.model.Product
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