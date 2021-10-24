package com.tengesani.purchases.repository


import androidx.lifecycle.LifecycleCoroutineScope
import androidx.lifecycle.LiveData
import com.tengesani.purchases.dao.PurchaseDao
import com.tengesani.purchases.model.Purchase
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import java.util.concurrent.Executors


class PurchasesRepository (var purchaseDao: PurchaseDao){


     fun getAllPurchases(): LiveData<MutableList<Purchase>> {

        return purchaseDao.getAllPurchases()
    }

     fun cancelPurchase(purchase: Purchase) {

         Executors.newSingleThreadExecutor().execute {


             purchaseDao.cancelPurchase(purchase)

         }



     }

    fun recordPurchase(purchase: Purchase){

        fun main() = runBlocking { // this: CoroutineScope
            launch { // launch a new coroutine and continue
                delay(1000L) // non-blocking delay for 1 second (default time unit is ms)
                // print after delay
                purchaseDao.recordPurchase(purchase)
            }

        }

        main()

    }



}