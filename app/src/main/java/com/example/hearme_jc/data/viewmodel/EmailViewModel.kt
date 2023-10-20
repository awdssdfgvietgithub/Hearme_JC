package com.example.hearme_jc.data.viewmodel

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class EmailViewModel : ViewModel() {
    private var _email: MutableState<String> = mutableStateOf("")
    val email = _email

    fun SetEmail(email: String) {
        this._email.value = email
    }

    fun GetEmail(): String {
        return email.value
    }

    override fun onCleared() {
        super.onCleared()
        println("ViewModel cleared")
    }
}