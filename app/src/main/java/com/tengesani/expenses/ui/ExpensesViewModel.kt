package com.tengesani.expenses.ui

import android.app.Application
import androidx.lifecycle.*
import com.tengesani.expenses.model.Expense
import com.tengesani.expenses.repository.ExpensesRepository
import kotlinx.coroutines.*

class ExpensesViewModel (
    var repository: ExpensesRepository,
): ViewModel() {



    private var _text = MutableLiveData<String>().apply {
        value = "This is expenses Fragment"
    }
    val text: LiveData<String> = _text

    private val scope = CoroutineScope(Job() + Dispatchers.IO)


    fun getAllExpenses() : LiveData<MutableList<Expense>>? {

        return repository.getAllExpenses()
    }

    fun cancelExpense(expense: Expense) {

        println("cancelling1")



        scope.launch {
            println("cancelling 2")

            repository.cancelExpense(expense)

        }


    }



    val pr = MutableLiveData<Expense>()


    fun recordExpense(expense: Expense) {



        scope.launch {


            pr.postValue(repository.recordExpense(expense))


        }





    }


    fun updateExpense(expense: Expense){



        scope.launch {

            repository.updateExpense(expense)


        }




    }






}

class ExpensesViewModelFactory(private val repository: ExpensesRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ExpensesViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return ExpensesViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}