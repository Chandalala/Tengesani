package com.tengesani.sales.model

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity
data class Sale(

    val product_name:String,
    val sale_price:Double,
    val category:String,
    val quantity_sold:Int,
    val sale_date: String

    ){

    @PrimaryKey(autoGenerate = true) var sale_id: Int=0


}
