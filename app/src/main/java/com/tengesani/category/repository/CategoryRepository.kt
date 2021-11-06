package com.tengesani.category.repository


import androidx.lifecycle.LiveData
import com.tengesani.category.dao.CategoryDao
import com.tengesani.category.model.Category

import java.util.concurrent.Executors


class CategoryRepository (var categoryDao: CategoryDao){


     fun getAllCategories(): LiveData<MutableList<Category>> {


        return categoryDao.getAllCategories()
    }

     fun removeCategory(category: Category) {

         Executors.newSingleThreadExecutor().execute {


             categoryDao.removeCategory(category)

         }



     }

    fun recordCategory(category: Category):Category{

        Executors.newSingleThreadExecutor().execute {


            categoryDao.recordCategory(category)

        }


        return category;
    }

    fun updateCategory(category: Category){

        Executors.newSingleThreadExecutor().execute {


            categoryDao.updateCategory(category)

        }


    }



}