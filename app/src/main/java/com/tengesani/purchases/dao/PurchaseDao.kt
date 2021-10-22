package com.tengesani.purchases.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.tengesani.purchases.model.Purchase
import kotlinx.coroutines.flow.Flow

@Dao
interface PurchaseDao {

    @Query("SELECT * FROM purchase")
    fun getAllPurchases(): LiveData<List<Purchase>>

    @Insert
    suspend fun recordPurchase(purchase: Purchase)

    @Delete
    fun cancelPurchase(purchase: Purchase)


    @Update
    fun updatePurchase(purchase: Purchase)

}