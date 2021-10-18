package com.tengesani.repository.fin.statements.model

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity
class FinStatement(
    @PrimaryKey val statement_id: Int,
    val total_sales:Double,
    val total_purchases:Double,
    val total_expenses:Double,
    val profit:Double,
    val date: String

    ) {
}