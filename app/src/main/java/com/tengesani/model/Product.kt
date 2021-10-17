package com.tengesani.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.LocalDateTime

@Entity
class Product (
    @PrimaryKey val product_id: Int,
    val product_name:String,
    val category:String,
    val date_created: LocalDateTime = LocalDateTime.now(),
   ){
}