package com.example.hearme_jc.ui.fragments.homeactionmenu.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.hearme_jc.data.viewmodel.ArtistViewModel

@Composable
fun SeeAllPopularArtistsScreen(navController: NavController, artistViewModel: ArtistViewModel) {
    LazyVerticalGrid(
        columns = GridCells.Adaptive(160.dp),
        verticalArrangement = Arrangement.spacedBy(24.dp),
        horizontalArrangement = Arrangement.spacedBy(12.dp),
        contentPadding = PaddingValues(top = 24.dp, end = 24.dp, start = 24.dp, bottom = 48.dp)
    ) {
        items(artistViewModel.GetPopularArtists(10)) {
            ArtistCard(modifier = Modifier.width(184.dp), artist = it, modifierGI = Modifier.size(184.dp))
        }
    }
}