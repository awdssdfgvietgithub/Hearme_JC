package com.example.hearme_jc.ui.fragments.accountsetup

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
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
import com.example.hearme_jc.data.model.Artist
import com.example.hearme_jc.data.model.ArtistsData
import com.example.hearme_jc.data.viewmodel.UserViewModel
import com.example.hearme_jc.navigation.Screen
import com.example.hearme_jc.ui.theme.Hearme_JCTheme
import com.example.hearme_jc.ui.theme.Primary500
import com.example.hearme_jc.ui.theme.White
import com.example.mylibrary.AppToggleButton
import com.example.mylibrary.PairButton

@Composable
fun FollowArtistsScreen(modifier: Modifier = Modifier, navController: NavController, userViewModel: UserViewModel) {
    Column(modifier.fillMaxSize()) {
        Column(
            modifier = modifier
                .padding(start = 24.dp, end = 24.dp, top = 24.dp)
                .weight(1f)
                .fillMaxSize()
        ) {
            Text(
                text = "Follow your favorite artists. Or you can skip it for now.",
                style = TextStyle(
                    fontSize = 18.sp,
                    lineHeight = 25.2.sp,
                    fontFamily = FontFamily(Font(R.font.urbanist_medium)),
                    fontWeight = FontWeight(500),
                    color = MaterialTheme.colorScheme.onBackground,

                    letterSpacing = 0.2.sp,
                )
            )

            Spacer(modifier = Modifier.height(24.dp))

            LazyColumnRowItemArtist(modifier.weight(1f))
        }
        CardPairButton(navController = navController)
    }
}

@Composable
fun CardPairButton(modifier: Modifier = Modifier, navController: NavController) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .border(
                1.dp,
                MaterialTheme.colorScheme.onSecondaryContainer,
                shape = RoundedCornerShape(topEnd = 40.dp, topStart = 40.dp)
            ),
        colors = CardDefaults.cardColors(MaterialTheme.colorScheme.background),
    ) {
        PairButton(
            modifier = Modifier.padding(24.dp),
            text1 = "Skip",
            text2 = "Continue",
            textColor1 = MaterialTheme.colorScheme.onTertiary,
            textColor2 = White,
            bgColor1 = MaterialTheme.colorScheme.onSecondaryContainer,
            bgColor2 = Primary500,
            font = FontFamily(Font(R.font.urbanist_bold)),
            onButtonClick1 = {
                navController.navigate(Screen.Home.route) {
                    popUpTo(0) {
                        inclusive = true
                    }
                }
            },
            onButtonClick2 = {
                navController.navigate(Screen.Home.route) {
                    popUpTo(0) {
                        inclusive = true
                    }
                }
            },
            haveShadow = false
        )
    }
}

@Composable
fun LazyColumnRowItemArtist(modifier: Modifier = Modifier) {
    LazyColumn(
        modifier = modifier
            .fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        contentPadding = PaddingValues(bottom = 24.dp),
    ) {
        items(ArtistsData.dataArtist()) {
            RowItemArtist(artist = it)
        }
    }
}

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun RowItemArtist(modifier: Modifier = Modifier, artist: Artist) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .background(color = MaterialTheme.colorScheme.background),
        verticalAlignment = Alignment.CenterVertically
    ) {
        GlideImage(
            model = artist.image,
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(80.dp)
                .clip(shape = CircleShape),
        )

        Spacer(modifier = Modifier.width(16.dp))

        Row(
            modifier
                .fillMaxWidth()
                .weight(1f),
        ) {
            Text(
                text = artist.artistName,
                style = TextStyle(
                    fontSize = 18.sp,
                    lineHeight = 21.6.sp,
                    fontFamily = FontFamily(Font(R.font.urbanist_bold)),
                    fontWeight = FontWeight(700),
                    color = MaterialTheme.colorScheme.onBackground,
                ),
                modifier = Modifier.weight(1f),
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )

            Spacer(modifier = Modifier.width(4.dp))

            Image(
                painter = painterResource(id = R.drawable.image_vector_verified),
                contentDescription = null,
                modifier = Modifier.size(24.dp),
                alignment = Alignment.TopStart
            )
        }

        Spacer(modifier = Modifier.width(16.dp))

        AppToggleButton(
            bgColorFalse = Primary500,
            txtColorFalse = White,
            bgColorTrue = White,
            txtColorTrue = Primary500,
            borderColorFalse = White,
            borderColorTrue = Primary500,
            fontFamily = FontFamily(Font(R.font.urbanist_semibold))
        )
    }
}

//@Preview(showBackground = true)
//@Composable
//fun CardPairButtonPreview() {
//    Hearme_JCTheme {
//        Surface(
//            modifier = Modifier.padding(24.dp),
//            color = MaterialTheme.colorScheme.background
//        ) {
//            val navController = rememberNavController()
//
//            CardPairButton(navController = navController)
//        }
//    }
//}

@Preview(showBackground = true)
@Composable
fun RowItemArtistPreview() {
    Hearme_JCTheme {
        Surface(
            modifier = Modifier.padding(24.dp),
            color = MaterialTheme.colorScheme.background
        ) {
            RowItemArtist(artist = ArtistsData.dataArtist()[0])
        }
    }
}

//@Preview(showBackground = true, widthDp = 412, heightDp = 915)
//@Composable
//fun FollowArtistsScreenPreview() {
//    Hearme_JCTheme {
//        Surface(
//            modifier = Modifier.fillMaxSize(),
//            color = MaterialTheme.colorScheme.background
//        ) {
//            val navController = rememberNavController()
//
//            FollowArtistsScreen(navController = navController)
//        }
//    }
//}