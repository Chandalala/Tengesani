package com.tengesani.product.ui

import androidx.lifecycle.*
import com.tengesani.product.model.Product
import com.tengesani.product.repository.ProductRepository

class ProductViewModel (
    var repository: ProductRepository,
    ): ViewModel() {



    val products:LiveData<MutableList<Product>>  = repository.getAllProducts()

     fun removeProduct(product: Product) {


        repository.removeProduct(product)
    }

    fun recordProduct(product: Product) {


        repository.recordProduct(product)
    }





}

class ProductViewModelFactory(private val repository: ProductRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ProductViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return ProductViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}