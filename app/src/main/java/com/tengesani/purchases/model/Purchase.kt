package com.tengesani.purchases.model

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity
data class Purchase(


    val product_name:String,
    val purchase_price:Double,
    val category:String,
    val quantity:Int,
    val purchase_date: String

    ){

    @PrimaryKey(autoGenerate = true) var purchaseId: Int=0


}
