package com.tengesani.purchases.ui

import android.app.Application
import androidx.lifecycle.*
import com.tengesani.purchases.model.Purchase
import com.tengesani.purchases.repository.PurchasesRepository
import kotlinx.coroutines.*

class PurchasesViewModel (
    var repository: PurchasesRepository,
    ): ViewModel() {



    private var _text = MutableLiveData<String>().apply {
        value = "This is purchases Fragment"
    }
    val text: LiveData<String> = _text

    private val scope = CoroutineScope(Job() + Dispatchers.IO)


     fun getAllPurchases() : LiveData<MutableList<Purchase>>? {

        return repository.getAllPurchases()
    }

     fun cancelPurchase(purchase: Purchase) {

         println("cancelling1")



         scope.launch {
             println("cancelling 2")

             repository.cancelPurchase(purchase)

         }


    }



    val pr = MutableLiveData<Purchase>()


    fun recordPurchase(purchase: Purchase) {



         scope.launch {


             pr.postValue(repository.recordPurchase(purchase))


         }





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