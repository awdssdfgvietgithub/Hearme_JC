package com.example.hearme_jc.data.viewmodel

import android.annotation.SuppressLint
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.hearme_jc.data.model.CategoriesData
import com.example.hearme_jc.data.model.Category

class CategoryViewModel : ViewModel() {
    @SuppressLint("MutableCollectionMutableState")
    private val _categories: MutableState<ArrayList<Category>> = mutableStateOf(ArrayList())
    val categories = _categories

    init {
        _categories.value = CategoriesData.dataCategory()
    }

    fun GetAllCategories() = categories.value

}