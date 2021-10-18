package com.tengesani.expenses.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class Expense (
    @PrimaryKey val expense_id: Int,
    val expense_name:String,
    val amount:Double,
    val date_incurred: String
        ){
}