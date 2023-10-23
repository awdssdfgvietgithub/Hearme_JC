package com.example.hearme_jc.data.viewmodel

import android.annotation.SuppressLint
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.hearme_jc.data.model.RecentSearch
import com.example.hearme_jc.data.model.RecentSearchesData

class RecentSearchViewModel : ViewModel() {
    @SuppressLint("MutableCollectionMutableState")
    private var _recentSearches: MutableState<ArrayList<RecentSearch>> = mutableStateOf(arrayListOf())
    val recentSearches = _recentSearches

    init {
        _recentSearches.value = RecentSearchesData.data()
    }

    fun GetAllRecentSearches() = recentSearches

    fun UpdateRecentSearch(name: String) {
        if (recentSearches.value.any { it.name == name }) {
            _recentSearches.value.remove(RecentSearch(name))
        }
        _recentSearches.value.add(RecentSearch(name))
    }

    fun DeleteRecentSearch(name: String) {
        if (recentSearches.value.any { it.name == name }) {
            _recentSearches.value.remove(RecentSearch(name))
        }
    }

    fun DeleteAllRecentSearches() {
        _recentSearches.value.clear()
    }
}