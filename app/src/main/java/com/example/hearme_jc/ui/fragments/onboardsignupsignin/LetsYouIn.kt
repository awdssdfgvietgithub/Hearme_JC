package com.example.hearme_jc.ui.fragments.onboardsignupsignin

import android.annotation.SuppressLint
import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.hearme_jc.R
import com.example.hearme_jc.ui.activities.TopBar
import com.example.hearme_jc.ui.theme.Hearme_JCTheme

@Composable
fun LetsYouInScreen(modifier: Modifier = Modifier, navController: NavController?) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 24.dp, end = 24.dp, start = 24.dp)
            .background(MaterialTheme.colorScheme.background),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Image(
            painter = painterResource(id = R.drawable.vector_image_let_you_in),
            contentDescription = null,
            modifier = Modifier
                .height(200.dp)
                .width(237.dp),
        )
    }
}

@Preview(showBackground = true, widthDp = 412, heightDp = 915)
@Composable
fun LetsYouInScreenPreview() {
    Hearme_JCTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            LetsYouInScreen(navController = null)
        }
    }
}