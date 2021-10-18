package com.tengesani.sales.dao

import androidx.room.*
import com.tengesani.sales.model.Sale
import kotlinx.coroutines.flow.Flow

@Dao
interface SaleDao {

    @Query("SELECT * FROM sale")
    fun getAllSales(): Flow<List<Sale>>

    @Insert
    fun recordSale(sale: Sale)

    @Delete
    fun cancelSale(sale: Sale)


    @Update
    fun updateSale(sale: Sale)

}