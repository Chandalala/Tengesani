package com.tengesani.product.model

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity
class Product (
    val product_name:String,
    val category:String,
    val date_created: String
   ){
    @PrimaryKey(autoGenerate = true) var productId: Int=0
}