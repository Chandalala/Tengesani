package com.tengesani

import android.app.Application
import com.tengesani.purchases.repository.PurchasesRepository

class TengesaniApp : Application(){
    private val database by lazy { AppDatabase.getDatabase(this) }
    val repository by lazy { PurchasesRepository(database.purchaseDao()) }
}