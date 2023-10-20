package com.example.hearme_jc.ui.fragments.accountsetup.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.hearme_jc.R
import com.example.hearme_jc.navigation.Screen
import com.example.hearme_jc.ui.theme.Primary500
import com.example.hearme_jc.ui.theme.White
import com.example.mylibrary.PairButton

@Composable
fun SetYourFingerprintScreen(modifier: Modifier = Modifier, navController: NavController) {
    Column(modifier = modifier.padding(start = 24.dp, end = 24.dp)) {
        Spacer(modifier = Modifier.weight(1f))

        Text(
            text = "Add a fingerprint to make your account more secure.",
            style = TextStyle(
                fontSize = 18.sp,
                lineHeight = 25.2.sp,
                fontFamily = FontFamily(Font(R.font.urbanist_regular)),
                fontWeight = FontWeight(400),
                color = MaterialTheme.colorScheme.onBackground,
                textAlign = TextAlign.Center,
                letterSpacing = 0.2.sp,
            )
        )

        Spacer(modifier = Modifier.weight(1f))

        ContainerFingerprint(modifier = modifier.fillMaxWidth())

        Spacer(modifier = Modifier.weight(1f))

        Text(
            text = "Please put your finger on the fingerprint scanner to get started.",
            style = TextStyle(
                fontSize = 18.sp,
                lineHeight = 25.2.sp,
                fontFamily = FontFamily(Font(R.font.urbanist_regular)),
                fontWeight = FontWeight(400),
                color = MaterialTheme.colorScheme.onBackground,

                textAlign = TextAlign.Center,
                letterSpacing = 0.2.sp,
            )
        )

        Spacer(modifier = Modifier.weight(1f))

        PairButton(
            text1 = "Skip",
            text2 = "Continue",
            textColor1 = MaterialTheme.colorScheme.onTertiary,
            textColor2 = White,
            bgColor1 = MaterialTheme.colorScheme.onSecondaryContainer,
            bgColor2 = Primary500,
            font = FontFamily(Font(R.font.urbanist_bold)),
            onButtonClick1 = { navController.navigate(Screen.FollowArtists.route) },
            onButtonClick2 = { navController.navigate(Screen.FollowArtists.route) },
        )

        Spacer(modifier = Modifier.height(48.dp))
    }
}

@Composable
fun ContainerFingerprint(modifier: Modifier = Modifier) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(34.28.dp), horizontalArrangement = Arrangement.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.image_vector_finger),
            contentDescription = null,
            modifier = Modifier,
            contentScale = ContentScale.None
        )
    }
}

//@Preview(showBackground = true, widthDp = 412, heightDp = 915)
//@Composable
//fun SetYourFingerprintScreenPreview() {
//    Hearme_JCTheme {
//        Surface(
//            modifier = Modifier.fillMaxSize(),
//            color = MaterialTheme.colorScheme.background
//        ) {
//            val navController = rememberNavController()
//
//            SetYourFingerprintScreen(navController = navController)
//        }
//    }
//}