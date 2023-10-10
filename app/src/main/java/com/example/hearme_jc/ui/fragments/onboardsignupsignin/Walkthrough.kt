package com.example.hearme_jc.ui.fragments.onboardsignupsignin

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.hearme_jc.R
import com.example.hearme_jc.ui.Screen
import com.example.hearme_jc.ui.activities.MainNavigationButton

@Composable
fun WalkThroughScreen(
    modifier: Modifier = Modifier,
    navController: NavController,
) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
    ) {
        Column(modifier = Modifier.padding(bottom = 320.dp)) {
            Image(
                painter = painterResource(id = R.drawable.img_onboard),
                contentDescription = null,
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Crop
            )
        }

        BottomSheet(
            modifier = modifier
                .background(
                    MaterialTheme.colorScheme.background,
                    shape = RoundedCornerShape(topEnd = 60.dp, topStart = 60.dp)
                )
                .fillMaxWidth()
                .align(Alignment.BottomEnd)
                .padding(top = 48.dp, bottom = 48.dp, end = 24.dp, start = 24.dp),
            navController = navController
        )
    }
}

@Composable
fun BottomSheet(modifier: Modifier = Modifier, navController: NavController) {
    Box(
        modifier = modifier
    ) {
        Column {
            Text(
                text = stringResource(id = R.string.content_onboard),
                style = TextStyle(
                    fontSize = 40.sp,
                    lineHeight = 48.sp,
                    fontFamily = FontFamily(Font(R.font.urbanist_extrabold)),
                    fontWeight = FontWeight(700),
                    color = MaterialTheme.colorScheme.onBackground,
                    textAlign = TextAlign.Center,
                )
            )

            Spacer(modifier = Modifier.height(40.dp))
            Spacer(modifier = Modifier.height(40.dp))

            MainNavigationButton(
                text = stringResource(id = R.string.started_button_text),
                navController = navController,
                route = Screen.LetYouIn.route
            )
        }
    }
}