package com.example.hearme_jc.ui.fragments.homeactionmenu.screen.childscreen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Surface
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.example.hearme_jc.R
import com.example.hearme_jc.data.model.Music
import com.example.hearme_jc.data.viewmodel.MusicViewModel
import com.example.hearme_jc.ui.fragments.searchdetailsplay.screen.childscreen.NotFoundScreen
import com.example.hearme_jc.ui.theme.Hearme_JCTheme

@Composable
fun AlbumsSearchResultsScreen(
    navController: NavController,
    query: String,
    musicViewModel: MusicViewModel,
) {
    val musicsData = musicViewModel.GetAlbumByQuery(query)

    if (musicsData.isEmpty())
        NotFoundScreen()

    LazyVerticalGrid(
        modifier = Modifier,
        columns = GridCells.Adaptive(160.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalArrangement = Arrangement.spacedBy(12.dp),
        contentPadding = PaddingValues(end = 24.dp, start = 24.dp, bottom = 48.dp)
    ) {
        items(musicsData) {
            AlbumItemView(it)
        }
    }
}

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun AlbumItemView(music: Music) {
    Column {
        GlideImage(
            modifier = Modifier
                .size(184.dp)
                .clip(RoundedCornerShape(32.dp)),
            model = music.image,
            contentDescription = null,
            contentScale = ContentScale.Crop
        )

        Spacer(modifier = Modifier.height(12.dp))

        Text(
            text = "Sweetener",
            style = TextStyle(
                fontSize = 20.sp,
                lineHeight = 24.sp,
                fontFamily = FontFamily(Font(R.font.urbanist_bold)),
                fontWeight = FontWeight(700),
                color = MaterialTheme.colorScheme.onBackground,
            ),
            maxLines = 1,
            overflow = TextOverflow.Ellipsis
        )

        Spacer(modifier = Modifier.height(4.dp))

        Text(
            text = "Ariana Grande",
            style = TextStyle(
                fontSize = 14.sp,
                lineHeight = 19.6.sp,
                fontFamily = FontFamily(Font(R.font.urbanist_semibold)),
                fontWeight = FontWeight(600),
                color = MaterialTheme.colorScheme.onSecondary,
                letterSpacing = 0.2.sp,
            ),
            maxLines = 1,
            overflow = TextOverflow.Ellipsis
        )

        Spacer(modifier = Modifier.height(4.dp))

        Text(
            text = "2018",
            style = TextStyle(
                fontSize = 14.sp,
                lineHeight = 19.6.sp,
                fontFamily = FontFamily(Font(R.font.urbanist_semibold)),
                fontWeight = FontWeight(600),
                color = MaterialTheme.colorScheme.onSecondary,

                letterSpacing = 0.2.sp,
            )
        )
    }
}

@Preview(showBackground = true)
@Composable
fun AlbumItemViewPreview() {
    Hearme_JCTheme {
        Surface(modifier = Modifier.padding(24.dp), color = MaterialTheme.colorScheme.background) {
            AlbumItemView(Music("", ""))
        }
    }
}