package com.tengesani.product.repository


import androidx.lifecycle.LifecycleCoroutineScope
import androidx.lifecycle.LiveData
import com.tengesani.category.model.Product
import com.tengesani.product.dao.ProductDao
import com.tengesani.purchases.dao.PurchaseDao
import com.tengesani.purchases.model.Purchase
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
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