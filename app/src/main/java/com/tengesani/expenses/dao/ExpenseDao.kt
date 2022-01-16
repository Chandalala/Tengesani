package com.tengesani.expenses.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.tengesani.expenses.model.Expense
import com.tengesani.purchases.model.Purchase
import kotlinx.coroutines.flow.Flow

@Dao
interface ExpenseDao {

    @Query("SELECT * FROM expense")
    fun getAllExpenses(): LiveData<MutableList<Expense>>

    @Transaction
    suspend fun recordExpense(expense: Expense):Expense{
        insertExpense(expense)

        return getExpense(expense.expense_name)

    }


    @Insert
    fun insertExpense(expense: Expense)

    @Query("Select * from expense where expense_name IN(:expenseName)")
    fun getExpense(expenseName: String):Expense

    @Delete
    fun cancelExpense(expense: Expense)

    @Update
    fun updateExpense(expense: Expense)

}