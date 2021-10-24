package com.tengesani.category.model

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity
data class Category(

    val category_name:String,
    val date_created: String

    ) {
    @PrimaryKey(autoGenerate = true) var categoryId: Int = 0
}