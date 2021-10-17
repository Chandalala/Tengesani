package com.tengesani.repository.sales.model

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.LocalDateTime

@Entity
data class Sale(

    @PrimaryKey val sale_id: Int,
    val product_name:String,
    val sale_price:Double,
    val category:String,
    val quantity_sold:Int,
    val sale_date: LocalDateTime = LocalDateTime.now(),

    ){


}
