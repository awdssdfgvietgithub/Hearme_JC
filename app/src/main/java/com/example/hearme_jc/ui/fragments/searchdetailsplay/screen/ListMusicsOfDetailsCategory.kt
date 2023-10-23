package com.example.hearme_jc.ui.fragments.searchdetailsplay.screen

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
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
import androidx.compose.ui.text.style.LineBreak
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.example.hearme_jc.R
import com.example.hearme_jc.data.model.DetailsCategory
import com.example.hearme_jc.data.model.Music
import com.example.hearme_jc.data.viewmodel.ArtistViewModel
import com.example.hearme_jc.data.viewmodel.DetailsCategoryViewModel
import com.example.hearme_jc.data.viewmodel.MusicViewModel
import com.example.hearme_jc.ui.fragments.homeactionmenu.screen.SongItemView
import java.time.LocalDate
import java.time.format.DateTimeFormatter

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun ListMusicsOfDetailsCategoryScreen(
    navController: NavController,
    musicViewModel: MusicViewModel,
    artistViewModel: ArtistViewModel,
    categoryID: String,
    detailsCategoryID: String,
    detailsCategoryViewModel: DetailsCategoryViewModel,
) {
    val data = when (detailsCategoryID) {
        "c003" -> {
            musicViewModel.GetAlbumsTopGlobal() as ArrayList<Music>
        }

        "c004" -> {
            musicViewModel.GetAlbumsTopUnitedStates() as ArrayList<Music>
        }

        "c005" -> {
            musicViewModel.GetSongsTopGlobal() as ArrayList<Music>
        }

        "c006" -> {
            musicViewModel.GetSongsTopUnitedStates() as ArrayList<Music>
        }

        else -> {
            ArrayList()
        }
    }

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 24.dp, end = 24.dp, start = 24.dp),
        verticalArrangement = Arrangement.spacedBy(24.dp)
    ) {
        item {
            FullDetailsCategoryCard(
                modifier = Modifier,
                detailsCategory = detailsCategoryViewModel.GetDetailsCategory(detailsCategoryID)
            )
        }

        item {
            Divider(modifier = Modifier.fillMaxWidth(), color = MaterialTheme.colorScheme.outlineVariant, thickness = 1.dp)
        }

        items(data) {
            SongItemView(it = it, artistViewModel = artistViewModel, type = 1)
        }
        
        item { 
            Spacer(modifier = Modifier.height(48.dp))
        }
    }
}

@RequiresApi(Build.VERSION_CODES.O)
@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun FullDetailsCategoryCard(modifier: Modifier = Modifier, detailsCategory: DetailsCategory) {
    val splitName = detailsCategory.chartName.split(" ")

    val current = LocalDate.now()
    val formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy")
    val formatted = current.format(formatter)

    androidx.compose.material3.Card(
        modifier = Modifier
            .clip(RoundedCornerShape(32.dp))
            .fillMaxWidth()
            .height(IntrinsicSize.Max),
        colors = CardDefaults.cardColors(Color.Transparent)
    ) {
        Column {
            Box(modifier = modifier.weight(1f), contentAlignment = Alignment.Center) {
                GlideImage(
                    modifier = Modifier
                        .clip(RoundedCornerShape(32.dp)),
                    model = detailsCategory.image,
                    contentDescription = null,
                    contentScale = ContentScale.FillBounds,
                )

                Text(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(60.dp),
                    text = detailsCategory.chartName.uppercase(),
                    style = TextStyle(
                        fontSize = 24.sp,
                        lineHeight = 28.8.sp,
                        fontFamily = FontFamily(Font(R.font.urbanist_bold)),
                        fontWeight = FontWeight(700),
                        color = Color.White,
                        textAlign = TextAlign.Center,
                        lineBreak = LineBreak.Heading
                    ),
                )
            }

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                modifier = Modifier.fillMaxWidth(),
                text = detailsCategory.chartName,
                style = TextStyle(
                    fontSize = 24.sp,
                    lineHeight = 28.8.sp,
                    fontFamily = FontFamily(Font(R.font.urbanist_bold)),
                    fontWeight = FontWeight(700),
                    color = MaterialTheme.colorScheme.onBackground,
                    textAlign = TextAlign.Center,
                )
            )

            Spacer(modifier = Modifier.height(12.dp))

            Text(
                modifier = Modifier.fillMaxWidth(),
                text = "The most played ${splitName[1]} from last week.",
                style = TextStyle(
                    fontSize = 18.sp,
                    lineHeight = 25.2.sp,
                    fontFamily = FontFamily(Font(R.font.urbanist_medium)),
                    fontWeight = FontWeight(500),
                    color = MaterialTheme.colorScheme.onBackground,
                    textAlign = TextAlign.Center,
                    letterSpacing = 0.2.sp,
                )
            )

            Spacer(modifier = Modifier.height(12.dp))

            Text(
                modifier = Modifier.fillMaxWidth(),
                text = "By Hearme | $formatted",
                style = TextStyle(
                    fontSize = 14.sp,
                    lineHeight = 19.6.sp,
                    fontFamily = FontFamily(Font(R.font.urbanist_semibold)),
                    fontWeight = FontWeight(600),
                    color = MaterialTheme.colorScheme.onBackground,
                    textAlign = TextAlign.Center,
                    letterSpacing = 0.2.sp,
                )
            )
        }
    }
}

