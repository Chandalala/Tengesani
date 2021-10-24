package com.tengesani.product.repository


import androidx.lifecycle.LiveData
import com.tengesani.product.model.Product
import com.tengesani.product.dao.ProductDao
import java.util.concurrent.Executors


class ProductRepository (var productDao: ProductDao){


     fun getAllProducts(): LiveData<MutableList<Product>> {


        return productDao.getAllProducts()
    }

     fun removeProduct(product: Product) {

         Executors.newSingleThreadExecutor().execute {


             productDao.removeProduct(product)

         }



     }

    fun recordProduct(product: Product){

        println(product.product_name+" "+product.category)

        Executors.newSingleThreadExecutor().execute {


            productDao.recordProduct(product)

        }


    }

    fun updateProduct(product: Product){

        Executors.newSingleThreadExecutor().execute {


            productDao.updateProduct(product)

        }


    }



}