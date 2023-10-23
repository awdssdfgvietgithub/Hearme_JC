package com.example.hearme_jc.ui.fragments.searchdetailsplay.viewmodel

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class ChartsScreenViewModel : ViewModel() {
    private var _categoryItem: MutableState<String> = mutableStateOf("")
    val categoryItem = _categoryItem

    fun GetCategoryItem() = categoryItem.value

    fun SetCategoryItem(categoryID: String) {
        _categoryItem.value = categoryID
    }
}