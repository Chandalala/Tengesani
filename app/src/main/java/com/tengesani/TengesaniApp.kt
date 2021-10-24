package com.tengesani

import android.app.Application
import com.tengesani.category.repository.CategoryRepository
import com.tengesani.product.repository.ProductRepository
import com.tengesani.purchases.repository.PurchasesRepository

class TengesaniApp : Application(){
    private val database by lazy { AppDatabase.getDatabase(this) }
    val purchasesRepository by lazy { PurchasesRepository(database.purchaseDao()) }
    val productRepository by lazy { ProductRepository(database.productDao()) }
    val categoryRepository by lazy { CategoryRepository(database.categoryDao()) }


}