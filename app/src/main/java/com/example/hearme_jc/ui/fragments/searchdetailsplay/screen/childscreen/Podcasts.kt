package com.example.hearme_jc.ui.fragments.homeactionmenu.screen.childscreen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
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
import com.example.hearme_jc.data.model.Music
import com.example.hearme_jc.data.viewmodel.ArtistViewModel
import com.example.hearme_jc.data.viewmodel.EmailViewModel
import com.example.hearme_jc.data.viewmodel.MusicViewModel
import com.example.hearme_jc.data.viewmodel.UserViewModel
import com.example.hearme_jc.ui.fragments.searchdetailsplay.screen.childscreen.NotFoundScreen
import com.example.hearme_jc.ui.theme.Primary500
import com.example.mylibrary.CustomCheckBox

@Composable
fun PodcastsSearchResultsScreen(
    navController: NavController,
    query: String,
    musicViewModel: MusicViewModel,
    artistViewModel: ArtistViewModel,
    userViewModel: UserViewModel,
    emailViewModel: EmailViewModel,
) {
    val episodeData = musicViewModel.GetEpisodesByQuery(query, 5)
    val artistsData = artistViewModel.GetPodcasterByQuery(query, 5)

    if (episodeData.isEmpty() && artistsData.isEmpty())
        NotFoundScreen()

    LazyColumn {
        item {
            Row(modifier = Modifier.padding(end = 24.dp, start = 24.dp)) {
                Text(
                    modifier = Modifier.weight(1f),
                    text = "Podcasts & Shows",
                    style = TextStyle(
                        fontSize = 24.sp,
                        lineHeight = 28.8.sp,
                        fontFamily = FontFamily(Font(R.font.urbanist_bold)),
                        fontWeight = FontWeight(700),
                        color = MaterialTheme.colorScheme.onBackground,
                    )
                )

                Text(
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

            Spacer(modifier = Modifier.height(20.dp))
        }

        item {
            LazyRow(
                horizontalArrangement = Arrangement.spacedBy(12.dp),
                contentPadding = PaddingValues(end = 24.dp, start = 24.dp)
            ) {
                items(artistsData) {
                    PodcastsItemView(modifier = Modifier, name = it.artistName, image = it.image.toString())
                }
            }
        }

        item {
            Spacer(modifier = Modifier.height(24.dp))

            Row(modifier = Modifier.padding(end = 24.dp, start = 24.dp)) {
                Text(
                    modifier = Modifier.weight(1f),
                    text = "Episodes",
                    style = TextStyle(
                        fontSize = 24.sp,
                        lineHeight = 28.8.sp,
                        fontFamily = FontFamily(Font(R.font.urbanist_bold)),
                        fontWeight = FontWeight(700),
                        color = MaterialTheme.colorScheme.onBackground,
                    )
                )

                Text(
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

            Spacer(modifier = Modifier.height(24.dp))
        }

        items(episodeData) {
            EpisodeItemView(
                modifier = Modifier.padding(end = 24.dp, start = 24.dp, bottom = 24.dp),
                music = it,
                artistViewModel = artistViewModel
            )
        }

        item {
            Spacer(modifier = Modifier.height(24.dp))
        }
    }
}

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun PodcastsItemView(modifier: Modifier = Modifier, image: String, name: String) {
    Column(modifier.width(160.dp)) {
        GlideImage(
            modifier = Modifier
                .size(160.dp)
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
            maxLines = 1,
            overflow = TextOverflow.Ellipsis
        )
    }
}

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun EpisodeItemView(modifier: Modifier = Modifier, music: Music, artistViewModel: ArtistViewModel) {
    var checkedLoved by rememberSaveable {
        mutableStateOf(false)
    }

    var checkedPlaylist by rememberSaveable {
        mutableStateOf(false)
    }

    var checkedDownload by rememberSaveable {
        mutableStateOf(false)
    }

    Row(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        GlideImage(
            modifier = Modifier
                .size(116.dp)
                .clip(RoundedCornerShape(32.dp)),
            model = music.image,
            contentDescription = null,
            contentScale = ContentScale.Crop
        )

        Column(
            modifier = Modifier
                .fillMaxSize()
                .weight(1f),
            verticalArrangement = Arrangement.spacedBy(12.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                modifier = Modifier.fillMaxWidth(),
                text = music.musicName,
                style = TextStyle(
                    fontSize = 18.sp,
                    lineHeight = 21.6.sp,
                    fontFamily = FontFamily(Font(R.font.urbanist_bold)),
                    fontWeight = FontWeight(700),
                    color = MaterialTheme.colorScheme.onBackground,
                    textAlign = TextAlign.Start

                ),
                maxLines = 2,
                overflow = TextOverflow.Ellipsis
            )

            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(12.dp)) {
                Text(
                    modifier = Modifier.weight(1f),
                    text = artistViewModel.GetArtist(music.artistID.toString()).artistName,
                    style = TextStyle(
                        fontSize = 12.sp,
                        fontFamily = FontFamily(Font(R.font.urbanist_medium)),
                        fontWeight = FontWeight(500),
                        color = MaterialTheme.colorScheme.onSecondary,
                        letterSpacing = 0.2.sp,
                        textAlign = TextAlign.Start
                    ),
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )

                Text(
                    text = "|",
                    style = TextStyle(
                        fontSize = 12.sp,
                        fontFamily = FontFamily(Font(R.font.urbanist_medium)),
                        fontWeight = FontWeight(500),
                        color = MaterialTheme.colorScheme.onSecondary,
                        letterSpacing = 0.2.sp,
                    )
                )

                Text(
                    text = "${music.duration?.m}:${music.duration?.s} mins",
                    style = TextStyle(
                        fontSize = 12.sp,
                        fontFamily = FontFamily(Font(R.font.urbanist_medium)),
                        fontWeight = FontWeight(500),
                        color = MaterialTheme.colorScheme.onSecondary,
                        letterSpacing = 0.2.sp,
                    ),
                    maxLines = 1,
                )
            }

            Row(modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
                Row(modifier = Modifier.weight(1f), verticalAlignment = Alignment.CenterVertically) {
                    CustomCheckBox(
                        modifier = Modifier.size(20.dp),
                        iconOff = R.drawable.ic_light_heart,
                        iconOn = R.drawable.ic_bold_heart,
                        colorOff = MaterialTheme.colorScheme.onBackground,
                        colorOn = Primary500,
                        onCheckedChange = { checkedLoved = !checkedLoved },
                        checked = checkedLoved
                    )

                    CustomCheckBox(
                        modifier = Modifier.size(20.dp),
                        iconOff = R.drawable.ic_add_playlist,
                        iconOn = R.drawable.ic_add_playlist,
                        colorOff = MaterialTheme.colorScheme.onBackground,
                        colorOn = Primary500,
                        onCheckedChange = { checkedPlaylist = !checkedPlaylist },
                        checked = checkedPlaylist
                    )

                    CustomCheckBox(
                        modifier = Modifier.size(20.dp),
                        iconOff = R.drawable.ic_light_down,
                        iconOn = R.drawable.ic_bold_down,
                        colorOff = MaterialTheme.colorScheme.onBackground,
                        colorOn = Primary500,
                        onCheckedChange = { checkedDownload = !checkedDownload },
                        checked = checkedDownload
                    )

                    IconButton(onClick = { }) {
                        Icon(
                            modifier = Modifier.size(20.dp),
                            painter = painterResource(id = R.drawable.ic_more),
                            contentDescription = null,
                            tint = MaterialTheme.colorScheme.onBackground
                        )
                    }
                }

                IconButton(onClick = { }) {
                    Icon(
                        modifier = Modifier.size(32.dp),
                        painter = painterResource(id = R.drawable.ic_play),
                        contentDescription = null,
                        tint = Primary500
                    )
                }
            }
        }
    }
}
