package com.tengesani.category.ui

import android.app.Application
import androidx.lifecycle.*
import com.tengesani.category.model.Category
import com.tengesani.category.repository.CategoryRepository


class CategoryViewModel (
    var repository: CategoryRepository,
    ): ViewModel() {


    val categories:LiveData<MutableList<Category>>  = repository.getAllCategories()

     fun removeCategory(Category: Category) {
        repository.removeCategory(Category)
    }

    fun recordCategory(Category: Category) {


        repository.recordCategory(Category)
    }





}

class CategoryViewModelFactory(private val repository: CategoryRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(CategoryViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return CategoryViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}