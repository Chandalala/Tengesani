package com.tengesani.expenses.repository


import androidx.lifecycle.LiveData
import com.tengesani.expenses.dao.ExpenseDao
import com.tengesani.expenses.model.Expense


class ExpensesRepository (var expenseDao: ExpenseDao){


     fun getAllExpenses(): LiveData<MutableList<Expense>> {

        return expenseDao.getAllExpenses()
    }

    suspend  fun cancelExpense(expense: Expense) {
        println("cancelling")

        expenseDao.cancelExpense(expense)



    }

    suspend fun recordExpense(expense: Expense): Expense{


        return expenseDao.recordExpense(expense)



    }


    suspend fun updateExpense(expense: Expense){


        expenseDao.updateExpense(expense)



    }



}