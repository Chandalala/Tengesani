package com.tengesani.repository.sales.model

import androidx.room.*
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