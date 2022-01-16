package com.tengesani.dashboard.ui

import android.app.Application
import androidx.lifecycle.*
import com.tengesani.purchases.model.Purchase
import kotlinx.coroutines.*

class DashboardViewModel (
/*
    var repository: DashboardRepository,
*/
    ): ViewModel() {



    private var _text = MutableLiveData<String>().apply {
        value = "This is dashboard Fragment"
    }
    val text: LiveData<String> = _text





}
/*

class DashboardViewModelFactory(private val repository: DashboardRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(DashboardViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return DashboardViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}*/
