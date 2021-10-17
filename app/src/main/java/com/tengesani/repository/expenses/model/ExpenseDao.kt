package com.tengesani.repository.expenses.model

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface ExpenseDao {

    @Query("SELECT * FROM expense")
    fun getAllExpenses(): Flow<List<Expense>>

    @Insert
    fun recordExpense(expense: Expense)

    @Delete
    fun cancelExpense(expense: Expense)

    @Update
    fun updateExpense(expense: Expense)

}