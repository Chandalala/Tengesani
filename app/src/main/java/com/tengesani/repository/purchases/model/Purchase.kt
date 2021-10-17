package com.tengesani.repository.purchases.model

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.LocalDateTime

@Entity
data class Purchase(

    @PrimaryKey val sale_id: Int,
    val product_name:String,
    val purchase_price:Double,
    val category:String,
    val quantity:Int,
    val purchase_date: LocalDateTime = LocalDateTime.now(),

    ){


}
