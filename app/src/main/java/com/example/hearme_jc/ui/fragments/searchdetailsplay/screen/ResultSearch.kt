package com.example.hearme_jc.ui.fragments.searchdetailsplay.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.hearme_jc.R
import com.example.hearme_jc.data.viewmodel.ArtistViewModel
import com.example.hearme_jc.data.viewmodel.EmailViewModel
import com.example.hearme_jc.data.viewmodel.MusicViewModel
import com.example.hearme_jc.data.viewmodel.PlaylistOfSingerViewModel
import com.example.hearme_jc.data.viewmodel.UserViewModel
import com.example.hearme_jc.ui.fragments.homeactionmenu.screen.childscreen.AlbumsSearchResultsScreen
import com.example.hearme_jc.ui.fragments.homeactionmenu.screen.childscreen.ArtistsSearchResultsScreen
import com.example.hearme_jc.ui.fragments.homeactionmenu.screen.childscreen.PlaylistsSearchResultsScreen
import com.example.hearme_jc.ui.fragments.homeactionmenu.screen.childscreen.PodcastsSearchResultsScreen
import com.example.hearme_jc.ui.fragments.homeactionmenu.screen.childscreen.ProfilesSearchResultsScreen
import com.example.hearme_jc.ui.fragments.homeactionmenu.screen.childscreen.SongsSearchResultsScreen
import com.example.hearme_jc.ui.fragments.homeactionmenu.screen.childscreen.TopSearchResultsScreen
import com.example.hearme_jc.ui.theme.Hearme_JCTheme
import com.example.hearme_jc.ui.theme.Primary500

enum class ListChip(val title: String) {
    Top("Top"),
    Songs("Songs"),
    Artists("Artists"),
    Albums("Albums"),
    Podcasts("Podcasts"),
    Playlists("Playlists"),
    Profiles("Profiles")
}

@Composable
fun ResultSearchScreen(
    navController: NavController,
    query: String,
    musicViewModel: MusicViewModel,
    artistViewModel: ArtistViewModel,
    userViewModel: UserViewModel,
    emailViewModel: EmailViewModel,
    playlistOfSingerViewModel: PlaylistOfSingerViewModel,
) {
    val itemsList: ArrayList<String> = arrayListOf()
    ListChip.values().forEach {
        itemsList.add(it.title)
    }

    val selectedItem = rememberSaveable {
        mutableStateOf(itemsList[0])
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 24.dp),
        verticalArrangement = Arrangement.spacedBy(24.dp)
    ) {
        LazyRowTopicSearches(modifier = Modifier, selectedItem = selectedItem, itemsList = itemsList)

        Column(modifier = Modifier.fillMaxSize()) {
            when (selectedItem.value) {
                ListChip.Top.title -> {
                    TopSearchResultsScreen(
                        navController = navController,
                        query = query,
                        musicViewModel = musicViewModel,
                        artistViewModel = artistViewModel,
                        userViewModel = userViewModel,
                        emailViewModel = emailViewModel
                    )
                }

                ListChip.Songs.title -> {
                    SongsSearchResultsScreen(
                        navController = navController,
                        query = query,
                        musicViewModel = musicViewModel,
                        artistViewModel = artistViewModel,
                        userViewModel = userViewModel,
                        emailViewModel = emailViewModel
                    )
                }

                ListChip.Artists.title -> {
                    ArtistsSearchResultsScreen(
                        navController = navController,
                        query = query,
                        artistViewModel = artistViewModel,
                        userViewModel = userViewModel,
                        emailViewModel = emailViewModel
                    )
                }

                ListChip.Albums.title -> {
                    AlbumsSearchResultsScreen(
                        navController = navController,
                        query = query,
                        musicViewModel = musicViewModel,
                    )
                }

                ListChip.Podcasts.title -> {
                    PodcastsSearchResultsScreen(
                        navController = navController,
                        query = query,
                        musicViewModel = musicViewModel,
                        artistViewModel = artistViewModel,
                        userViewModel = userViewModel,
                        emailViewModel = emailViewModel
                    )
                }

                ListChip.Playlists.title -> {
                    PlaylistsSearchResultsScreen(
                        navController = navController,
                        query = query,
                        musicViewModel = musicViewModel,
                        artistViewModel = artistViewModel,
                        userViewModel = userViewModel,
                        emailViewModel = emailViewModel,
                        playlistOfSingerViewModel = playlistOfSingerViewModel
                    )
                }

                ListChip.Profiles.title -> {
                    ProfilesSearchResultsScreen(
                        navController = navController,
                        query = query,
                        userViewModel = userViewModel,
                        emailViewModel = emailViewModel
                    )
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LazyRowTopicSearches(modifier: Modifier = Modifier, selectedItem: MutableState<String>, itemsList: ArrayList<String>) {
    LazyRow(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(12.dp),
        contentPadding = PaddingValues(start = 24.dp, end = 24.dp)
    ) {
        items(itemsList) {
            FilterChip(
                selected = (it == selectedItem.value),
                onClick = {
                    selectedItem.value = it
                },
                label = {
                    Text(
                        modifier = Modifier.padding(top = 8.dp, bottom = 8.dp, end = 5.dp, start = 5.dp),
                        text = it,
                        style = TextStyle(
                            fontSize = 16.sp,
                            lineHeight = 22.4.sp,
                            fontFamily = FontFamily(Font(R.font.urbanist_semibold)),
                            fontWeight = FontWeight(600),
                            textAlign = TextAlign.Center,
                            letterSpacing = 0.2.sp,
                        )
                    )
                },
                shape = RoundedCornerShape(100.dp),
                colors = FilterChipDefaults.filterChipColors(
                    labelColor = Primary500,
                    selectedLabelColor = Color.White,
                    disabledLabelColor = Primary500,
                    selectedContainerColor = Primary500,
                    disabledContainerColor = Color.Transparent
                ),
                border = FilterChipDefaults.filterChipBorder(
                    borderColor = Primary500,
                    borderWidth = 2.dp
                )
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun TopicSearchCardPreview() {
    Hearme_JCTheme {
        Surface(color = MaterialTheme.colorScheme.background, modifier = Modifier.padding(24.dp)) {
            val itemsList: ArrayList<String> = arrayListOf()
            ListChip.values().forEach {
                itemsList.add(it.title)
            }

            val selectedItem = rememberSaveable {
                mutableStateOf(itemsList[0])
            }

            LazyRowTopicSearches(selectedItem = selectedItem, itemsList = itemsList)
        }
    }
}
