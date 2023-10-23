package com.example.hearme_jc.data.viewmodel

import android.annotation.SuppressLint
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.graphics.Color
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

    fun GetCategory(categoryID: String): Category {
        if (categories.value.any { it.categoryID == categoryID }) {
            return categories.value.first { it.categoryID == categoryID }
        }
        return Category("", "", "", Color.White)
    }
}