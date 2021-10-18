package com.tengesani

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.tengesani.model.Category
import com.tengesani.dao.CategoryDao
import com.tengesani.model.Product
import com.tengesani.dao.ProductDao
import com.tengesani.expenses.model.Expense
import com.tengesani.repository.expenses.dao.ExpenseDao
import com.tengesani.repository.fin.statements.dao.FinStatementDao
import com.tengesani.repository.fin.statements.model.FinStatement
import com.tengesani.purchases.model.Purchase
import com.tengesani.purchases.dao.PurchaseDao
import com.tengesani.sales.model.Sale
import com.tengesani.sales.dao.SaleDao

@Database(entities = [Purchase::class, Sale::class, Expense::class, FinStatement::class,
    Category::class, Product::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun purchaseDao(): PurchaseDao
    abstract fun saleDao(): SaleDao
    abstract fun expenseDao(): ExpenseDao
    abstract fun finStatementDao(): FinStatementDao
    abstract fun categoryDao(): CategoryDao
    abstract fun productDao(): ProductDao

    companion object {

        @Volatile
        private var INSTANCE: AppDatabase? = null


        fun getDatabase(context: Context): AppDatabase {
            synchronized(this) {

                var instance = INSTANCE

                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        AppDatabase::class.java,
                        "user_details_database"
                    )
                        .fallbackToDestructiveMigration()
                        .build()

                    INSTANCE = instance
                }
                return instance
            }
        }
    }

}