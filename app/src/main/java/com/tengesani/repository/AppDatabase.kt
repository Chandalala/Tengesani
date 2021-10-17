package com.tengesani.repository

import androidx.room.Database
import androidx.room.RoomDatabase
import com.tengesani.repository.sales.model.Sale
import com.tengesani.repository.sales.model.SaleDao

@Database(entities = [Sale::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun saleDao(): SaleDao

}