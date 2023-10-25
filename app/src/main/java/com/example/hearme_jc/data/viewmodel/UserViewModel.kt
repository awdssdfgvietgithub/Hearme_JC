package com.example.hearme_jc.data.viewmodel

import android.annotation.SuppressLint
import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.hearme_jc.data.model.Artist
import com.example.hearme_jc.data.model.Name
import com.example.hearme_jc.data.model.User
import com.example.hearme_jc.data.model.UsersData
import kotlinx.coroutines.launch
import java.time.LocalDate
import java.time.ZoneId
import java.util.Date

class UserViewModel : ViewModel() {
    @SuppressLint("MutableCollectionMutableState")
    private var _users: MutableState<ArrayList<User>> = mutableStateOf(ArrayList())
    val users = _users

    init {
        viewModelScope.launch {
            _users.value = UsersData.data()
            getListDataUser()
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
            _users.value.add(User(email = email, password = password))
            return 1
        }
        return 2
    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun FillProfile(email: String, name: Name, dob: LocalDate, secondaryEmail: String, phone: String): Byte {
        if (email.isEmpty())
            return 0
        if (name.fullName.isEmpty() || name.nickName.isEmpty() || dob == LocalDate.parse("1500-01-01") || secondaryEmail.isEmpty() || phone.isEmpty())
            return 2
        if (users.value.any { it.email == email }) {
            _users.value.first { it.email == email }.apply {
                this.name = name
                this.dob = Date.from(dob.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant())
                this.secondaryEmail = secondaryEmail
                this.phone = phone
            }
            return 1
        }
        return 3
    }

    fun CreateNewPin(email: String, pin: List<String>): Byte {
        if (email.isEmpty())
            return 0
        if (pin.isEmpty())
            return 2
        if (users.value.any { it.email == email }) {
            _users.value.first { it.email == email }.apply {
                pin.forEach {
                    this.pin?.add(it)
                }
            }
            return 1
        }
        return 3
    }

    fun UpdateArtistsFollowing(email: String, artist: Artist, isFollow: Boolean): Byte {
        if (email.isEmpty())
            return 0
        if (artist.artistId.isEmpty())
            return 2
        if (users.value.any { it.email == email }) {
            _users.value.first { it.email == email }.apply {
                if (isFollow)
                    this.listArtistsFollowing.add(artist)
                else
                    this.listArtistsFollowing.remove(artist)
            }
            return 1
        }
        return 3
    }

    fun UpdateUserFollowing(email: String, emailFollow: String, isFollow: Boolean): Byte {
        if (email.isEmpty())
            return 0
        if (emailFollow.isEmpty())
            return 2
        if (users.value.any { it.email == email }) {
            _users.value.first { it.email == email }.apply {
                if (isFollow)
                    this.listUserFollowing.add(users.value.first { it.email == emailFollow })
                else
                    this.listUserFollowing.remove(users.value.first { it.email == emailFollow })
            }

            _users.value.first { it.email == emailFollow }.apply {
                if (isFollow)
                    this.listFollowers.add(users.value.first { it.email == email })
                else
                    this.listFollowers.remove(users.value.first { it.email == email })
            }

            Log.v("UpdateUserFollowing", users.value.first { it.email == email }.listUserFollowing.size.toString())
            return 1
        }
        return 3
    }

    fun IsFollowUser(email: String, emailFollow: String) =
        users.value.first { it.email == email }.listUserFollowing.any { it.email == emailFollow }

    fun IsFollowArtist(email: String, artistID: String) =
        users.value.first { it.email == email }.listArtistsFollowing.any { it.artistId == artistID }

    private fun getListDataUser() {
        UpdateUserFollowing(users.value[0].email, users.value[1].email, true)
//        UpdateUserFollowing(users.value[0].email, users.value[4].email, true)
//        UpdateUserFollowing(users.value[0].email, users.value[6].email, true)
//        UpdateUserFollowing(users.value[0].email, users.value[8].email, true)
//        UpdateUserFollowing(users.value[0].email, users.value[14].email, true)
//        UpdateUserFollowing(users.value[0].email, users.value[15].email, true)
//        UpdateUserFollowing(users.value[0].email, users.value[16].email, true)
//
//        UpdateUserFollowing(users.value[1].email, users.value[0].email, true)
//        UpdateUserFollowing(users.value[1].email, users.value[12].email, true)
//        UpdateUserFollowing(users.value[1].email, users.value[13].email, true)
//        UpdateUserFollowing(users.value[1].email, users.value[5].email, true)
//        UpdateUserFollowing(users.value[1].email, users.value[6].email, true)

//        UpdateUserFollowing(lst[2].email, lst[1], true)
//        UpdateUserFollowing(lst[2].email, lst[3], true)
//        UpdateUserFollowing(lst[2].email, lst[10], true)
//
//        UpdateUserFollowing(lst[3].email, lst[1], true)
//        UpdateUserFollowing(lst[3].email, lst[2], true)
//        UpdateUserFollowing(lst[3].email, lst[5], true)
//        UpdateUserFollowing(lst[3].email, lst[6], true)
//        UpdateUserFollowing(lst[3].email, lst[12], true)
//
//        UpdateUserFollowing(lst[4].email, lst[1], true)
//        UpdateUserFollowing(lst[4].email, lst[6], true)
//        UpdateUserFollowing(lst[4].email, lst[7], true)
//        UpdateUserFollowing(lst[4].email, lst[8], true)
//        UpdateUserFollowing(lst[4].email, lst[9], true)
//        UpdateUserFollowing(lst[4].email, lst[12], true)
//        UpdateUserFollowing(lst[4].email, lst[16], true)
//
//        UpdateUserFollowing(lst[5].email, lst[3], true)
//        UpdateUserFollowing(lst[5].email, lst[4], true)
//        UpdateUserFollowing(lst[5].email, lst[5], true)
//        UpdateUserFollowing(lst[5].email, lst[9], true)
//
//        UpdateUserFollowing(lst[6].email, lst[1], true)
//        UpdateUserFollowing(lst[6].email, lst[13], true)
//        UpdateUserFollowing(lst[6].email, lst[14], true)
//        UpdateUserFollowing(lst[6].email, lst[15], true)
//        UpdateUserFollowing(lst[6].email, lst[16], true)
//
//        UpdateUserFollowing(lst[7].email, lst[2], true)
//        UpdateUserFollowing(lst[7].email, lst[3], true)
//        UpdateUserFollowing(lst[7].email, lst[5], true)
//        UpdateUserFollowing(lst[7].email, lst[7], true)
//        UpdateUserFollowing(lst[7].email, lst[10], true)
//        UpdateUserFollowing(lst[7].email, lst[11], true)
//
//        UpdateUserFollowing(lst[8].email, lst[12], true)
//        UpdateUserFollowing(lst[8].email, lst[13], true)
//        UpdateUserFollowing(lst[8].email, lst[3], true)
//        UpdateUserFollowing(lst[8].email, lst[15], true)
//
//        UpdateUserFollowing(lst[9].email, lst[1], true)
//        UpdateUserFollowing(lst[9].email, lst[2], true)
//
//        UpdateUserFollowing(lst[10].email, lst[3], true)
//        UpdateUserFollowing(lst[10].email, lst[5], true)
//        UpdateUserFollowing(lst[10].email, lst[7], true)
//        UpdateUserFollowing(lst[10].email, lst[12], true)
    }
}