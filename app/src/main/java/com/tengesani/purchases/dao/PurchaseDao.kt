package com.tengesani.purchases.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.tengesani.purchases.model.Purchase
import kotlinx.coroutines.flow.Flow

@Dao
interface PurchaseDao {

    @Query("SELECT * FROM purchase")
    fun getAllPurchases(): LiveData<MutableList<Purchase>>

    @Transaction
    suspend fun recordPurchase(purchase: Purchase):Purchase{
        insertPurchase(purchase)

        return getPurchase(purchase.product_name)

    }

    @Query("Select * from purchase where product_name IN(:product_name)")
     fun getPurchase(product_name: String):Purchase

    @Insert
    suspend fun insertPurchase(purchase: Purchase)

    @Delete
    suspend fun cancelPurchase(purchase: Purchase)


    @Update
    suspend fun updatePurchase(purchase: Purchase)

}