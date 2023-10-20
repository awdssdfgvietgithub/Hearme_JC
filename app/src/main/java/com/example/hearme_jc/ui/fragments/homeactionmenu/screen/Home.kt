package com.example.hearme_jc.ui.fragments.homeactionmenu.screen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.example.hearme_jc.R
import com.example.hearme_jc.data.model.Artist
import com.example.hearme_jc.data.model.Chart
import com.example.hearme_jc.data.model.ChartData
import com.example.hearme_jc.data.model.Music
import com.example.hearme_jc.data.viewmodel.ArtistViewModel
import com.example.hearme_jc.data.viewmodel.EmailViewModel
import com.example.hearme_jc.data.viewmodel.MusicViewModel
import com.example.hearme_jc.data.viewmodel.UserViewModel
import com.example.hearme_jc.navigation.Screen
import com.example.hearme_jc.ui.theme.Primary500

@Composable
fun HomeScreen(
    navController: NavController,
    emailViewModel: EmailViewModel,
    userViewModel: UserViewModel,
    musicViewModel: MusicViewModel,
    artistViewModel: ArtistViewModel,
) {
//    Log.v("HomeScreen GET", emailViewModel.GetEmail())
//    Log.v("Current List", userViewModel.GetAllUsers().first { it.email == emailViewModel.GetEmail() }.toString())

    Column(
        modifier = Modifier
            .padding(top = 24.dp)
            .verticalScroll(rememberScrollState()), Arrangement.spacedBy(32.dp)
    ) {
        ContainerTrendingNow(navController = navController, artistViewModel = artistViewModel, musicViewModel = musicViewModel)
        ContainerPopularArtists(navController = navController, artistViewModel = artistViewModel)
        ContainerTopChar(navController = navController)
    }
}

@Composable
fun ContainerTopChar(modifier: Modifier = Modifier, navController: NavController) {
    Column(modifier = modifier, Arrangement.spacedBy(16.dp)) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(end = 24.dp, start = 24.dp)
        ) {
            TitleLazyRow(modifier = Modifier.weight(1f), text = "Top Charts")

            SeeAllLazyRow(modifier = Modifier.weight(1f), onClick = {})
        }

        LazyRowChartCard(modifier = Modifier)
    }
}

@Composable
fun LazyRowChartCard(modifier: Modifier) {
    LazyRow(
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        contentPadding = PaddingValues(end = 24.dp, start = 24.dp, bottom = 48.dp)
    ) {
        items(ChartData.dataChart()) {
            ChartCard(modifier = Modifier.width(160.dp), chart = it, modifierGI = Modifier.size(160.dp))
        }
    }
}

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun ChartCard(modifier: Modifier, chart: Chart, modifierGI: Modifier) {
    Card(modifier = Modifier, colors = CardDefaults.cardColors(Color.Transparent)) {
        Box(modifier = modifier, contentAlignment = Alignment.Center) {
            GlideImage(
                modifier = modifierGI
                    .clip(RoundedCornerShape(32.dp)),
                model = chart.image,
                contentDescription = null,
                contentScale = ContentScale.Crop,
            )

            Text(
                modifier = Modifier.fillMaxSize(),
                text = chart.chartName,
                style = TextStyle(
                    fontSize = 24.sp,
                    lineHeight = 28.8.sp,
                    fontFamily = FontFamily(Font(R.font.urbanist_bold)),
                    fontWeight = FontWeight(700),
                    color = Color.White,
                    textAlign = TextAlign.Center,
                )
            )
        }
    }
}

@Composable
fun ContainerPopularArtists(modifier: Modifier = Modifier, navController: NavController, artistViewModel: ArtistViewModel) {
    Column(modifier = modifier, Arrangement.spacedBy(16.dp)) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(end = 24.dp, start = 24.dp)
        ) {
            TitleLazyRow(modifier = Modifier.weight(1f), text = "Popular Artists")

            SeeAllLazyRow(modifier = Modifier.weight(1f), onClick = { navController.navigate(Screen.SeeAllPopularArtists.route) })
        }

        LazyRowArtistCard(modifier = Modifier, artistViewModel = artistViewModel)
    }
}

@Composable
fun LazyRowArtistCard(modifier: Modifier = Modifier, artistViewModel: ArtistViewModel) {
    LazyRow(
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        contentPadding = PaddingValues(end = 24.dp, start = 24.dp)
    ) {
        items(artistViewModel.GetPopularArtists(5)) {
            ArtistCard(modifier = Modifier.width(160.dp), artist = it, modifierGI = Modifier.size(160.dp))
        }
    }
}

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun ArtistCard(modifier: Modifier, artist: Artist, modifierGI: Modifier) {
    Card(modifier = modifier, colors = CardDefaults.cardColors(Color.Transparent)) {
        Column(
            modifier = modifier,
            verticalArrangement = Arrangement.spacedBy(8.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            GlideImage(
                modifier = modifierGI
                    .clip(CircleShape),
                model = artist.image,
                contentDescription = null,
                contentScale = ContentScale.Crop,
            )

            Text(
                modifier = Modifier.fillMaxWidth(),
                text = artist.artistName,
                style = TextStyle(
                    fontSize = 18.sp,
                    lineHeight = 25.2.sp,
                    fontFamily = FontFamily(Font(R.font.urbanist_bold)),
                    fontWeight = FontWeight(700),
                    color = MaterialTheme.colorScheme.onBackground,
                    letterSpacing = 0.2.sp,
                    textAlign = TextAlign.Center
                ),
                maxLines = 2,
                overflow = TextOverflow.Ellipsis,
            )
        }
    }
}

@Composable
fun ContainerTrendingNow(
    modifier: Modifier = Modifier,
    navController: NavController,
    artistViewModel: ArtistViewModel,
    musicViewModel: MusicViewModel,
) {
    Column(modifier = modifier, Arrangement.spacedBy(16.dp)) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(end = 24.dp, start = 24.dp)
        ) {
            TitleLazyRow(modifier = Modifier.weight(1f), text = "Trending Now")

            SeeAllLazyRow(modifier = Modifier.weight(1f), onClick = { navController.navigate(Screen.SeeAllTrendingNow.route) })
        }

        LazyRowMusicCard(modifier = Modifier, artistViewModel = artistViewModel, musicViewModel = musicViewModel)
    }
}

@Composable
fun LazyRowMusicCard(modifier: Modifier, artistViewModel: ArtistViewModel, musicViewModel: MusicViewModel) {
    LazyRow(
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        contentPadding = PaddingValues(end = 24.dp, start = 24.dp)
    ) {
        items(musicViewModel.GetTrendingMusics(5)) {
            MusicCard(
                modifier = Modifier.width(160.dp), music = it, modifierGI = Modifier
                    .size(160.dp)
                    .clip(RoundedCornerShape(32.dp)),
                artistViewModel = artistViewModel
            )
        }
    }
}

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun MusicCard(
    modifier: Modifier,
    music: Music,
    modifierGI: Modifier,
    isHaveMusicName: Boolean = true,
    artistViewModel: ArtistViewModel,
) {
    Card(modifier = Modifier, colors = CardDefaults.cardColors(Color.Transparent)) {
        Column(modifier = modifier, verticalArrangement = Arrangement.spacedBy(8.dp)) {
            GlideImage(
                modifier = modifierGI,
                model = music.image,
                contentDescription = null,
                contentScale = ContentScale.Crop,
            )

            if (isHaveMusicName)
                Text(
                    text = "${music.musicName} - ${artistViewModel.GetArtist(music.artistID.toString()).artistName}",
                    style = TextStyle(
                        fontSize = 18.sp,
                        lineHeight = 25.2.sp,
                        fontFamily = FontFamily(Font(R.font.urbanist_bold)),
                        fontWeight = FontWeight(700),
                        color = MaterialTheme.colorScheme.onBackground,
                        letterSpacing = 0.2.sp,
                    ),
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis,
                )
        }
    }
}

@Composable
fun SeeAllLazyRow(modifier: Modifier, onClick: () -> Unit) {
    Text(
        modifier = modifier.clickable { onClick() },
        text = "See All",
        style = TextStyle(
            fontSize = 16.sp,
            lineHeight = 22.4.sp,
            fontFamily = FontFamily(Font(R.font.urbanist_bold)),
            fontWeight = FontWeight(700),
            color = Primary500,
            textAlign = TextAlign.Right,
            letterSpacing = 0.2.sp,
        )
    )
}

@Composable
fun TitleLazyRow(modifier: Modifier, text: String) {
    Text(
        modifier = modifier,
        text = text,
        style = TextStyle(
            fontSize = 24.sp,
            lineHeight = 28.8.sp,
            fontFamily = FontFamily(Font(R.font.urbanist_bold)),
            fontWeight = FontWeight(700),
            color = MaterialTheme.colorScheme.onBackground,
        )
    )
}

//@Preview(showBackground = true, widthDp = 412, heightDp = 915)
//@Composable
//fun HomeScreenPreview() {
//    Hearme_JCTheme {
//        Surface(
//            modifier = Modifier.fillMaxSize(),
//            color = MaterialTheme.colorScheme.background
//        ) {
//            val navController = rememberNavController()
//
//            HomeScreen(navController = navController)
//        }
//    }
//}