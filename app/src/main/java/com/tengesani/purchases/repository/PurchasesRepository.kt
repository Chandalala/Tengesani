package com.tengesani.purchases.repository

import android.app.Application
import com.tengesani.AppDatabase
import androidx.lifecycle.LiveData
import com.tengesani.purchases.dao.PurchaseDao
import com.tengesani.purchases.model.Purchase
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking


class PurchasesRepository (var purchaseDao: PurchaseDao){


     fun getAllPurchases(): Flow<List<Purchase>> {
   /*      var i=20
         while (i<1000){

             fun main() = runBlocking { // this: CoroutineScope
                 launch { // launch a new coroutine and continue
                     delay(1000L) // non-blocking delay for 1 second (default time unit is ms)
                   // print after delay
                     purchaseDao.recordPurchase(
                         Purchase(i, "Product $i",3.20+i,
                             "CT $i",8+i,"18-04-92")
                     )
                 }

             }

             main()



             i++
         }*/


        return purchaseDao.getAllPurchases()
    }




}