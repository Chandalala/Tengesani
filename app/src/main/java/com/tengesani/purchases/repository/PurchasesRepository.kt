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

    suspend  fun cancelPurchase(purchase: Purchase) {
        println("cancelling")

        purchaseDao.cancelPurchase(purchase)



    }

    suspend fun recordPurchase(purchase: Purchase): Purchase{


        return purchaseDao.recordPurchase(purchase)



    }


    suspend fun updatePurchase(purchase: Purchase){


        purchaseDao.updatePurchase(purchase)



    }



}