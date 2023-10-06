package com.example.hearme_jc.data.model

data class Time(val hours: Int, val minutes: Int, val seconds: Int) {
    val h: Int
        get() = if (hours < 0) 0 else hours
    val m: Int
        get() = if (minutes > 60) 60 else minutes
    val s: Int
        get() = if (seconds > 60) 60 else seconds
}
