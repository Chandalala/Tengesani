package com.tengesani.sales.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.tengesani.sales.model.Sale

@Dao
interface SaleDao {

    @Query("SELECT * FROM sale")
    fun getAllSales(): LiveData<MutableList<Sale>>


    @Transaction
    suspend fun recordSale(sale: Sale): Sale {
        insertSale(sale)

        return getSale(sale.product_name)

    }

    @Query("Select * from sale where product_name IN(:product_name)")
    fun getSale(product_name: String):Sale


    @Insert
    suspend fun insertSale(sale: Sale)


    @Delete
    fun cancelSale(sale: Sale)


    @Update
    fun updateSale(sale: Sale)

}