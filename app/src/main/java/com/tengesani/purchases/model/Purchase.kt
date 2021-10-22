package com.tengesani.purchases.model

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity
data class Purchase(

    @PrimaryKey val purchase_id: Long,
    val product_name:String,
    val purchase_price:Double,
    val category:String,
    val quantity:Int,
    val purchase_date: String

    ){


}
