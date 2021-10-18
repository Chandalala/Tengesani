package com.tengesani.repository.fin.statements.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class FinStatementsViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is finastate Fragment"
    }
    val text: LiveData<String> = _text
}