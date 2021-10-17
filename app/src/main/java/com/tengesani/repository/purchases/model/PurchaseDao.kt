package com.tengesani.repository.purchases.model

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface PurchaseDao {

    @Query("SELECT * FROM purchase")
    fun getAllPurchases(): Flow<List<Purchase>>

    @Insert
    fun recordPurchase(purchase: Purchase)

    @Delete
    fun cancelPurchase(purchase: Purchase)


    @Update
    fun updatePurchase(purchase: Purchase)

}