package com.example.hearme_jc.data.viewmodel

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.hearme_jc.data.model.TopicSearch
import com.example.hearme_jc.data.model.TopicSearchData

class TopicSearchViewModel : ViewModel() {
    var _topicSearches: MutableState<ArrayList<TopicSearch>> = mutableStateOf(ArrayList())
    val topicSearches = _topicSearches

    init {
        _topicSearches.value = TopicSearchData.data()
    }

    fun GetAllTopicSearches() = topicSearches.value

    fun GetTopicSearch(name: String) = topicSearches.value.first { it.name == name }

    fun UpdateStateTopicSearch(name: String) {
        _topicSearches.value.forEach {
            it.isChecked = false
        }
        _topicSearches.value.first { it.name == name }.apply {
            this.isChecked = true
        }
    }
}