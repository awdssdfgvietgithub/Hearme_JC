package com.example.hearme_jc.ui.fragments.homeactionmenu

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.hearme_jc.ui.theme.Hearme_JCTheme

@Composable
fun HomeScreen(navController: NavController) {

}

@Preview(showBackground = true, widthDp = 412, heightDp = 915)
@Composable
fun HomeScreenPreview() {
    Hearme_JCTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            val navController = rememberNavController()

            HomeScreen(navController = navController)
        }
    }
}