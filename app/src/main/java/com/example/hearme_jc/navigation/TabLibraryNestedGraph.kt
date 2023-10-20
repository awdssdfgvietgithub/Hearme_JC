package com.example.hearme_jc.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.hearme_jc.ui.fragments.library.screen.LibraryScreen

fun NavGraphBuilder.tabLibraryGraph(navController: NavController) {
    navigation(startDestination = Screen.Library.route, route = Screen.TabLibrary.route) {
        composable(Screen.Library.route) {
            LibraryScreen(navController = navController)
        }
    }
}