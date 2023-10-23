package com.example.hearme_jc.data.viewmodel

import android.annotation.SuppressLint
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.hearme_jc.data.model.DetailsCategory
import com.example.hearme_jc.data.model.DetailsCategoryData

class DetailsCategoryViewModel : ViewModel() {
    @SuppressLint("MutableCollectionMutableState")
    private val _detailsCategory: MutableState<ArrayList<DetailsCategory>> = mutableStateOf(ArrayList())
    val detailsCategory = _detailsCategory

    init {
        _detailsCategory.value = DetailsCategoryData.dataDetailsCategory()
    }

    fun GetAllDetailsCategory() = detailsCategory.value

    fun GetDetailsCategory(detailsCategoryID: String): DetailsCategory {
        if (detailsCategory.value.any { it.chartId == detailsCategoryID }) {
            return detailsCategory.value.first { it.chartId == detailsCategoryID }
        }
        return DetailsCategory("", "", 0)
    }
}