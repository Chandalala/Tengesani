package com.tengesani.category.model

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity
class Category(

    @PrimaryKey val category_id: Int,
    val category_name:String,
    val date_created: String

    ) {
}