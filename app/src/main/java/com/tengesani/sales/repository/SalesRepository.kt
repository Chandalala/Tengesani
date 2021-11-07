package com.tengesani.sales.repository


import androidx.lifecycle.LiveData
import com.tengesani.sales.dao.SaleDao
import com.tengesani.sales.model.Sale


class SalesRepository (var saleDao: SaleDao){


     fun getAllSales(): LiveData<MutableList<Sale>> {

        return saleDao.getAllSales()
    }

    suspend  fun cancelSale(Sale: Sale) {
        println("cancelling")

        saleDao.cancelSale(Sale)



    }

    suspend fun recordSale(Sale: Sale): Sale{


        return saleDao.recordSale(Sale)



    }



}