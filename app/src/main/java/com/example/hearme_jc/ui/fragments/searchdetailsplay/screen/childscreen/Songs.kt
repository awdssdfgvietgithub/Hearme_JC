package com.example.hearme_jc.ui.fragments.homeactionmenu.screen.childscreen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.hearme_jc.data.viewmodel.ArtistViewModel
import com.example.hearme_jc.data.viewmodel.EmailViewModel
import com.example.hearme_jc.data.viewmodel.MusicViewModel
import com.example.hearme_jc.data.viewmodel.UserViewModel
import com.example.hearme_jc.ui.fragments.homeactionmenu.screen.SongItemView
import com.example.hearme_jc.ui.fragments.searchdetailsplay.screen.childscreen.NotFoundScreen

@Composable
fun SongsSearchResultsScreen(
    navController: NavController,
    query: String,
    musicViewModel: MusicViewModel,
    artistViewModel: ArtistViewModel,
    userViewModel: UserViewModel,
    emailViewModel: EmailViewModel,
) {
    val songsData = musicViewModel.GetSongsByQuery(query)

    if (songsData.isEmpty())
        NotFoundScreen()

    LazyColumn(
        modifier = Modifier,
        verticalArrangement = Arrangement.spacedBy(16.dp),
        contentPadding = PaddingValues(end = 24.dp, start = 24.dp, bottom = 48.dp)
    ) {
        items(songsData) {
            SongItemView(it = it, artistViewModel = artistViewModel, type = 1)
        }
    }
}