package com.tengesani.purchases.ui

import android.app.Application
import androidx.lifecycle.*
import com.tengesani.purchases.model.Purchase
import com.tengesani.purchases.repository.PurchasesRepository

class PurchasesViewModel (
    var repository: PurchasesRepository,
    ): ViewModel() {



    private val _text = MutableLiveData<String>().apply {
        value = "This is purchases Fragment"
    }
    val text: LiveData<String> = _text


    val purchases:LiveData<MutableList<Purchase>>  = repository.getAllPurchases()

     fun cancelPurchase(purchase: Purchase) {


        repository.cancelPurchase(purchase)
    }

    fun recordPurchase() {


        repository.recordPurchases()
    }





}

class PurchasesViewModelFactory(private val repository: PurchasesRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(PurchasesViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return PurchasesViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}