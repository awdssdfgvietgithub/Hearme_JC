package com.example.hearme_jc.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.hearme_jc.ui.fragments.profilesetting.ProfileScreen

fun NavGraphBuilder.tabProfileGraph(navController: NavController) {
    navigation(startDestination = Screen.Profile.route, route = Screen.TabProfile.route) {
        composable(Screen.Profile.route) {
            ProfileScreen(navController = navController)
        }
    }
}