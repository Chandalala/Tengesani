package com.tengesani.product.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.tengesani.category.model.Product
import kotlinx.coroutines.flow.Flow

@Dao
interface ProductDao {

    @Query("SELECT * FROM product")
    fun getAllProducts(): LiveData<MutableList<Product>>

    @Insert
    fun recordProduct(product: Product)

    @Delete
    fun removeProduct(product: Product)


    @Update
    fun updateProduct(product: Product)

}