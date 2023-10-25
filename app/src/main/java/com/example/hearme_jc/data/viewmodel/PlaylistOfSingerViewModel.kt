package com.example.hearme_jc.data.viewmodel

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.hearme_jc.data.model.PlaylistOfSinger
import com.example.hearme_jc.data.model.PlaylistOfSingerData

class PlaylistOfSingerViewModel : ViewModel() {
    private var _playlistsOfSingers: MutableState<ArrayList<PlaylistOfSinger>> = mutableStateOf(ArrayList())
    val playlistsOfSingers = _playlistsOfSingers

    init {
        _playlistsOfSingers.value = PlaylistOfSingerData.data()
    }

    fun GetPlayelistsOfSingerByQuery(query: String) =
        playlistsOfSingers.value.filter { it.playlistOfSingerName.trim().lowercase().contains(query.trim().lowercase()) }
}