package com.tengesani.purchases.repository

import android.app.Application
import com.tengesani.AppDatabase
import androidx.lifecycle.LiveData
import com.tengesani.purchases.dao.PurchaseDao
import com.tengesani.purchases.model.Purchase
import kotlinx.coroutines.flow.Flow


class PurchasesRepository (var purchaseDao: PurchaseDao){


     fun getAllPurchases(): Flow<List<Purchase>> {
        return purchaseDao.getAllPurchases()
    }


}