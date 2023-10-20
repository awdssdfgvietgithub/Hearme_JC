package com.example.hearme_jc.data.viewmodel

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.hearme_jc.data.model.Music
import com.example.hearme_jc.data.model.MusicsData
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.Calendar

class MusicViewModel : ViewModel() {
    @SuppressLint("MutableCollectionMutableState")
    private var _musics: MutableState<ArrayList<Music>> = mutableStateOf(arrayListOf())
    val musics = _musics

    init {
        viewModelScope.launch {
            _musics.value = MusicsData.dataMusic()
        }
    }

    fun GetAllMusics() = musics.value

    fun GetTrendingMusics(number: Int): ArrayList<Music> {
        return if (number <= 0)
            arrayListOf()
        else
            musics.value.sortedByDescending { it.totalListeners }.take(number) as ArrayList<Music>
    }

    fun GetMusic(musicID: String): Music {
        if (musicID.isEmpty()) {
            Log.v("GetMusic", "musicID is null")
            return Music(musicID = "", musicName = "")
        }
        if (musics.value.any { it.musicID == musicID })
            return musics.value.first { it.musicID == musicID }
        Log.v("GetMusic", "musicID is not existed")
        return Music(musicID = "", musicName = "")
    }

    @SuppressLint("SimpleDateFormat")
    fun GetMusicRelease(isToday: Boolean = true, isSongs: Boolean = true): ArrayList<Music> {
        val formatter = SimpleDateFormat("dd/MM/yyyy")
        val calToday = Calendar.getInstance()
        val calYesterday = Calendar.getInstance()
        calYesterday.add(Calendar.DATE, -1)
        val currentDate = formatter.format(calToday.time) // format date now
        val yesterdayDate = formatter.format(calYesterday.time) // format yesterday date

        if (isToday)
            if (isSongs)
                return musics.value.filter {
                    it.release?.let { it1 -> formatter.format(it1).compareTo(currentDate) } == 0 && it.categoryID != "ca002"
                } as ArrayList<Music>
            else
                return musics.value.filter {
                    it.release?.let { it1 -> formatter.format(it1).compareTo(currentDate) } == 0 && it.categoryID == "ca002"
                } as ArrayList<Music>
        else
            if (isSongs)
                return musics.value.filter {
                    it.release?.let { it1 -> formatter.format(it1).compareTo(yesterdayDate) } == 0 && it.categoryID != "ca002"
                } as ArrayList<Music>
            else
                return musics.value.filter {
                    it.release?.let { it1 -> formatter.format(it1).compareTo(yesterdayDate) } == 0 && it.categoryID == "ca002"
                } as ArrayList<Music>

    }
}