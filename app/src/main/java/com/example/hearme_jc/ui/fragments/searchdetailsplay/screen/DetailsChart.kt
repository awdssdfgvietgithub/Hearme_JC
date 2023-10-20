package com.example.hearme_jc.ui.fragments.searchdetailsplay.screen

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.hearme_jc.data.viewmodel.ArtistViewModel
import com.example.hearme_jc.data.viewmodel.MusicViewModel
import com.example.hearme_jc.ui.theme.Hearme_JCTheme

@Composable
fun DetailsChartScreen(navController: NavController, musicViewModel: MusicViewModel, artistViewModel: ArtistViewModel) {
    Text(text = "DetailsChartScreen")
}

@Preview(showBackground = true, widthDp = 412, heightDp = 915)
@Composable
fun DetailsChartScreenPreview() {
    Hearme_JCTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            val navController = rememberNavController()

            ProfileScreen(navController = navController)
        }
    }
}