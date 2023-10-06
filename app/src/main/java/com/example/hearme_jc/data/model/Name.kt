package com.example.hearme_jc.data.model

data class Name(var fullName: String, var nickName: String){
    constructor() : this("No name", "No name")
}
