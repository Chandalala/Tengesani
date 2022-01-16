package com.tengesani.expenses.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class Expense (

    val expense_name:String,
    val amount:Double,
    val date_incurred: String

    ){

    @PrimaryKey(autoGenerate = true) var expenseId: Int=0


}