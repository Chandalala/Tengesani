package com.tengesani.repository.expenses.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.LocalDateTime

@Entity
class Expense (
    @PrimaryKey val expense_id: Int,
    val expense_name:String,
    val amount:Double,
    val date_incurred: LocalDateTime = LocalDateTime.now(),
        ){
}