package com.tengesani.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.LocalDateTime

@Entity
class Category(

    @PrimaryKey val category_id: Int,
    val category_name:String,
    val date_created: LocalDateTime = LocalDateTime.now(),

    ) {
}