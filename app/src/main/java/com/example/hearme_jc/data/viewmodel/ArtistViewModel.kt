package com.example.hearme_jc.data.viewmodel

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.hearme_jc.data.model.Artist
import com.example.hearme_jc.data.model.ArtistsData
import kotlinx.coroutines.launch

class ArtistViewModel : ViewModel() {
    @SuppressLint("MutableCollectionMutableState")
    private var _artists: MutableState<ArrayList<Artist>> = mutableStateOf(ArrayList())
    val artists = _artists

    init {
        viewModelScope.launch {
            _artists.value = ArtistsData.dataArtist()
        }
    }

    fun GetAllArtists() = artists.value

    fun GetPopularArtists(number: Int): ArrayList<Artist> {
        return if (number <= 0)
            arrayListOf()
        else
            artists.value.sortedByDescending { it.totalFollowers }.take(number) as ArrayList<Artist>
    }

    fun GetArtist(artistID: String): Artist {
        if (artistID.isEmpty()) {
            Log.v("GetArtist", "artistID is null")
            return Artist(artistId = "", artistName = "")
        }
        if (artists.value.any { it.artistId == artistID })
            return artists.value.first { it.artistId == artistID }
        Log.v("GetArtist", "artistID is not existed")
        return Artist(artistId = "", artistName = "")
    }
}