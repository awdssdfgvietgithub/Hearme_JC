package com.example.hearme_jc.data.viewmodel

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class EmailViewModel : ViewModel() {
    private var email: MutableState<String> = mutableStateOf("")

    fun SetEmail(email: String) {
        this.email.value = email
    }

    fun GetEmail(): String {
        return email.value
    }
}