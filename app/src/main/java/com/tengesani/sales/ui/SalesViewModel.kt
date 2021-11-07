package com.tengesani.sales.ui

import androidx.lifecycle.*
import com.tengesani.sales.model.Sale
import com.tengesani.sales.repository.SalesRepository
import kotlinx.coroutines.*

class SalesViewModel (
    var repository: SalesRepository,
): ViewModel() {

    

    private val scope = CoroutineScope(Job() + Dispatchers.IO)


    fun getAllSales() : LiveData<MutableList<Sale>>? {

        return repository.getAllSales()
    }

    fun cancelSale(sale: Sale) {

        println("cancelling1")



        scope.launch {
            println("cancelling 2")

            repository.cancelSale(sale)

        }


    }



    val sl = MutableLiveData<Sale>()


    fun recordSale(sale: Sale) {



        scope.launch {


            sl.postValue(repository.recordSale(sale))


        }





    }





}

class SalesViewModelFactory(private val repository: SalesRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(SalesViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return SalesViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}