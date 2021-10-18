package com.tengesani.sales.model

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity
data class Sale(

    @PrimaryKey val sale_id: Int,
    val product_name:String,
    val sale_price:Double,
    val category:String,
    val quantity_sold:Int,
    val sale_date: String

    ){


}
