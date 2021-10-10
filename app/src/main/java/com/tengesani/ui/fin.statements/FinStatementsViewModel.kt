package com.tengesani.ui.fin.statements

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class FinStatementsViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is finastate Fragment"
    }
    val text: LiveData<String> = _text
}