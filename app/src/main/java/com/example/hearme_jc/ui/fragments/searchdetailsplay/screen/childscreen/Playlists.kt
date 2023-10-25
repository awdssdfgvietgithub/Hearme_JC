package com.example.hearme_jc.ui.fragments.homeactionmenu.screen.childscreen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.example.hearme_jc.R
import com.example.hearme_jc.data.viewmodel.ArtistViewModel
import com.example.hearme_jc.data.viewmodel.EmailViewModel
import com.example.hearme_jc.data.viewmodel.MusicViewModel
import com.example.hearme_jc.data.viewmodel.PlaylistOfSingerViewModel
import com.example.hearme_jc.data.viewmodel.UserViewModel

@Composable
fun PlaylistsSearchResultsScreen(
    navController: NavController,
    query: String,
    musicViewModel: MusicViewModel,
    artistViewModel: ArtistViewModel,
    userViewModel: UserViewModel,
    emailViewModel: EmailViewModel,
    playlistOfSingerViewModel: PlaylistOfSingerViewModel,
) {
    val playlistData = playlistOfSingerViewModel.GetPlayelistsOfSingerByQuery(query)

    LazyVerticalGrid(
        columns = GridCells.Adaptive(160.dp),
        verticalArrangement = Arrangement.spacedBy(20.dp),
        horizontalArrangement = Arrangement.spacedBy(12.dp),
        contentPadding = PaddingValues(end = 24.dp, start = 24.dp, bottom = 48.dp)
    ) {
        items(playlistData) {
            PlaylistItemView(
                modifier = Modifier.width(184.dp),
                name = "${artistViewModel.GetArtist(it.artistID).artistName} - ${it.playlistOfSingerName}",
                image = it.image.toString(),
            )
        }
    }
}

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun PlaylistItemView(modifier: Modifier = Modifier, image: String, name: String) {
    Column(modifier.width(184.dp)) {
        GlideImage(
            modifier = Modifier
                .clip(RoundedCornerShape(32.dp)),
            model = image,
            contentDescription = null,
            contentScale = ContentScale.Crop
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = name,
            style = TextStyle(
                fontSize = 18.sp,
                lineHeight = 25.2.sp,
                fontFamily = FontFamily(Font(R.font.urbanist_bold)),
                fontWeight = FontWeight(700),
                color = MaterialTheme.colorScheme.onBackground,
                letterSpacing = 0.2.sp,
            ),
            maxLines = 2,
            overflow = TextOverflow.Ellipsis
        )
    }
}