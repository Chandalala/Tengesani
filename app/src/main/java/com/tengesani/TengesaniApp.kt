package com.tengesani

import android.app.Application
import com.tengesani.category.repository.CategoryRepository
import com.tengesani.expenses.repository.ExpensesRepository
import com.tengesani.product.repository.ProductRepository
import com.tengesani.purchases.repository.PurchasesRepository
import com.tengesani.sales.repository.SalesRepository

class TengesaniApp : Application(){
    private val database by lazy { AppDatabase.getDatabase(this) }
    val purchasesRepository by lazy { PurchasesRepository(database.purchaseDao()) }
    val salesRepository by lazy { SalesRepository(database.saleDao()) }
    val productRepository by lazy { ProductRepository(database.productDao()) }
    val categoryRepository by lazy { CategoryRepository(database.categoryDao()) }
    val expenseRepository by lazy { ExpensesRepository(database.expenseDao()) }



}