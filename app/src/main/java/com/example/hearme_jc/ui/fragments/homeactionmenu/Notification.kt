package com.example.hearme_jc.ui.fragments.homeactionmenu

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.hearme_jc.R
import com.example.hearme_jc.data.model.Music
import com.example.hearme_jc.data.model.MusicsData
import com.example.hearme_jc.ui.tab.TabSongs
import com.example.hearme_jc.ui.theme.Primary500
import com.example.mylibrary.ButtonMorePopupSpinner
import com.example.mylibrary.SmallButtonPlay
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.rememberPagerState
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.Calendar

@OptIn(ExperimentalPagerApi::class)
@Composable
fun NotificationScreen(navController: NavController) {
    val pagerState = rememberPagerState(initialPage = 0)
    val scope = rememberCoroutineScope()

    Column(
        modifier = Modifier
            .padding(end = 24.dp, start = 24.dp)
            .fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(24.dp)
    ) {
        TabSongs(selectedTabIndex = pagerState.currentPage, onSelectedTab = {
            scope.launch {
                pagerState.animateScrollToPage(it.ordinal)
            }
        })

        Column(
            modifier = Modifier
                .weight(1f)
        ) {
            HorizontalPager(state = pagerState, count = 2) { index ->
                when (index) {
                    0 -> SongsNotificationScreen(navController = navController)
                    1 -> PodcastsNotificationScreen(navController = navController)
                }
            }
        }
    }
}

@Composable
fun SongsNotificationScreen(navController: NavController) {
    LazyColumn() {
        item {
            Text(
                text = "New Music Release Today",
                style = TextStyle(
                    fontSize = 18.sp,
                    lineHeight = 21.6.sp,
                    fontFamily = FontFamily(Font(R.font.urbanist_bold)),
                    fontWeight = FontWeight(700),
                    color = MaterialTheme.colorScheme.onBackground,

                    )
            )
            LazyColumnSongs()
        }
        item {
            Text(
                text = "Yesterday",
                style = TextStyle(
                    fontSize = 18.sp,
                    lineHeight = 21.6.sp,
                    fontFamily = FontFamily(Font(R.font.urbanist_bold)),
                    fontWeight = FontWeight(700),
                    color = MaterialTheme.colorScheme.onBackground,

                    )
            )
            LazyColumnSongs(isYesterday = true)
        }
    }
}

@Composable
fun LazyColumnSongs(modifier: Modifier = Modifier, isYesterday: Boolean = false) {
    val formatter = SimpleDateFormat("dd/MM/yyyy")
    val calToday = Calendar.getInstance()
    val calYesterday = Calendar.getInstance()
    calYesterday.add(Calendar.DATE, -1)
    val currentDate = formatter.format(calToday.time) // format date now
    val yesterdayDate = formatter.format(calYesterday.time) // format yesterday date

    val data: ArrayList<Music> = MusicsData.dataMusic()
    val filterData = if (isYesterday)
        data.filter {
            formatter.format(
                it.release
            ).compareTo(
                yesterdayDate
            ) == 0 && it.categoryID != "ca002"
        }
    else
        data.filter {
            formatter.format(
                it.release
            ).compareTo(
                currentDate
            ) == 0 && it.categoryID != "ca002"
        }
    LazyColumn(
        modifier = modifier.height(400.dp),
        verticalArrangement = Arrangement.spacedBy(24.dp),
        contentPadding = PaddingValues(bottom = if (isYesterday) 24.dp else 0.dp)
    ) {
        items(filterData) {
            SongItemView(modifier = Modifier, it)
        }
    }
}

@Composable
fun SongItemView(modifier: Modifier = Modifier, it: Music) {
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        MusicCard(
            modifier = Modifier.width(80.dp), music = it, modifierGI = Modifier
                .size(80.dp)
                .clip(RoundedCornerShape(20.dp)), isHaveMusicName = false
        )

        Column(
            modifier = Modifier
                .fillMaxSize()
                .weight(1f),
            verticalArrangement = Arrangement.spacedBy(10.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(12.dp)) {
                Text(
                    text = "Today",
                    style = TextStyle(
                        fontSize = 12.sp,
                        fontFamily = FontFamily(Font(R.font.urbanist_medium)),
                        fontWeight = FontWeight(500),
                        color = MaterialTheme.colorScheme.onSecondary,
                        letterSpacing = 0.2.sp,
                    )
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
                    text = "${it.duration.m}:${it.duration.s} mins",
                    style = TextStyle(
                        fontSize = 12.sp,
                        fontFamily = FontFamily(Font(R.font.urbanist_medium)),
                        fontWeight = FontWeight(500),
                        color = MaterialTheme.colorScheme.onSecondary,
                        letterSpacing = 0.2.sp,
                    )
                )
            }

            Text(
                modifier = modifier.fillMaxWidth(),
                text = it.musicName,
                style = TextStyle(
                    fontSize = 18.sp,
                    lineHeight = 21.6.sp,
                    fontFamily = FontFamily(Font(R.font.urbanist_bold)),
                    fontWeight = FontWeight(700),
                    color = MaterialTheme.colorScheme.onBackground,
                    textAlign = TextAlign.Start,
                ),
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )

            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(12.dp)) {
                Text(
                    text = it.GetArtist(artistID = it.artistID)?.artistName ?: "",
                    style = TextStyle(
                        fontSize = 12.sp,
                        fontFamily = FontFamily(Font(R.font.urbanist_medium)),
                        fontWeight = FontWeight(500),
                        color = MaterialTheme.colorScheme.onSecondary,
                        letterSpacing = 0.2.sp,
                    )
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
                    text = if (it.isAlbum) "Album" else "Single",
                    style = TextStyle(
                        fontSize = 12.sp,
                        fontFamily = FontFamily(Font(R.font.urbanist_medium)),
                        fontWeight = FontWeight(500),
                        color = MaterialTheme.colorScheme.onSecondary,
                        letterSpacing = 0.2.sp,
                    )
                )
            }
        }

        Row(
            modifier = Modifier.fillMaxHeight(),
            horizontalArrangement = Arrangement.spacedBy(20.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            SmallButtonPlay(modifier = Modifier.size(26.7.dp), onClick = { }, painter = R.drawable.ic_play, tint = Primary500)

            ButtonMorePopupSpinner(
                modifier = Modifier.size(20.dp),
                onClick = {},
                painter = R.drawable.ic_more,
                tint = MaterialTheme.colorScheme.onBackground
            )
        }
    }
}

@Composable
fun PodcastsNotificationScreen(navController: NavController) {
    LazyColumn() {
        item {
            Text(
                text = "New Podcasts Release Today",
                style = TextStyle(
                    fontSize = 18.sp,
                    lineHeight = 21.6.sp,
                    fontFamily = FontFamily(Font(R.font.urbanist_bold)),
                    fontWeight = FontWeight(700),
                    color = MaterialTheme.colorScheme.onBackground,

                    )
            )
            LazyColumnPodcasts()
        }
        item {
            Text(
                text = "Yesterday",
                style = TextStyle(
                    fontSize = 18.sp,
                    lineHeight = 21.6.sp,
                    fontFamily = FontFamily(Font(R.font.urbanist_bold)),
                    fontWeight = FontWeight(700),
                    color = MaterialTheme.colorScheme.onBackground,

                    )
            )
            LazyColumnPodcasts(isYesterday = true)
        }
    }
}

@SuppressLint("SimpleDateFormat")
@Composable
fun LazyColumnPodcasts(modifier: Modifier = Modifier, isYesterday: Boolean = false) {
    val formatter = SimpleDateFormat("dd/MM/yyyy")
    val calToday = Calendar.getInstance()
    val calYesterday = Calendar.getInstance()
    calYesterday.add(Calendar.DATE, -1)
    val currentDate = formatter.format(calToday.time) // format date now
    val yesterdayDate = formatter.format(calYesterday.time) // format yesterday date

    val data: ArrayList<Music> = MusicsData.dataMusic()
    val filterData = if (isYesterday)
        data.filter {
            formatter.format(
                it.release
            ).compareTo(
                yesterdayDate
            ) == 0 && it.categoryID == "ca002"
        }
    else
        data.filter {
            formatter.format(
                it.release
            ).compareTo(
                currentDate
            ) == 0 && it.categoryID == "ca002"
        }
    LazyColumn(
        modifier = modifier.height(400.dp),
        verticalArrangement = Arrangement.spacedBy(24.dp),
        contentPadding = PaddingValues(bottom = if (isYesterday) 24.dp else 0.dp)
    ) {
        items(filterData) {
            SongItemView(modifier = Modifier, it)
        }
    }
}


