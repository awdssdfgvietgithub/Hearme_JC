package com.example.hearme_jc.data.viewmodel

import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.hearme_jc.data.model.Name
import com.example.hearme_jc.data.model.User
import com.example.hearme_jc.data.model.UsersData
import kotlinx.coroutines.launch
import java.time.LocalDate
import java.time.ZoneId
import java.util.Date

class UserViewModel : ViewModel() {
    private var users: MutableState<ArrayList<User>> = mutableStateOf(ArrayList())

    init {
        viewModelScope.launch {
            users.value = UsersData.data()
        }
    }

    fun GetAllUsers(): ArrayList<User> {
        return users.value
    }

    fun Login(email: String, password: String): Byte {
        if (email.isEmpty() || password.isEmpty())
            return 0
        if (users.value.any { it.email == email && it.password == password }) {
            return 1
        }
        return 2
    }

    fun Register(email: String, password: String): Byte {
        if (email.isEmpty() || password.isEmpty())
            return 0
        if (!users.value.any { it.email == email }) {
            users.value.add(User(email = email, password = password))
            return 1
        }
        return 2
    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun FillProfile(email: String, name: Name, dob: LocalDate, secondaryEmail: String, phone: String): Byte {
        if (email.isEmpty())
            return 0
        if (users.value.any { it.email == email }) {
            users.value.first { it.email == email }.apply {
                this.name = name
                this.dob = Date.from(dob.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant())
                this.secondaryEmail = secondaryEmail
                this.phone = phone
            }
            Log.v("TEST", users.value.first { it.email == email }.toString())
            return 1
        }
        return 2
    }
}