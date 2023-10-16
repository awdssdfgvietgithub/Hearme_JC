package com.example.hearme_jc.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.hearme_jc.ui.fragments.searchdetailsplay.ExploreScreen

fun NavGraphBuilder.tabExploreGraph(navController: NavController) {
    navigation(startDestination = Screen.Explore.route, route = Screen.TabExplore.route) {
        composable(Screen.Explore.route) {
            ExploreScreen(navController = navController)
        }
    }
}