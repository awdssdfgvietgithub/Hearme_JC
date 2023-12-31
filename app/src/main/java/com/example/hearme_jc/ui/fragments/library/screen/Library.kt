package com.example.hearme_jc.ui.fragments.library.screen

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.hearme_jc.ui.theme.Hearme_JCTheme

@Composable
fun LibraryScreen(navController: NavController) {
    Text(text = "Library")
}

@Preview(showBackground = true, widthDp = 412, heightDp = 915)
@Composable
fun LibraryScreenPreview() {
    Hearme_JCTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            val navController = rememberNavController()

            LibraryScreen(navController = navController)
        }
    }
}