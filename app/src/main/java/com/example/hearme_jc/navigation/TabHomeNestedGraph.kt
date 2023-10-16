package com.example.hearme_jc.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.hearme_jc.ui.fragments.homeactionmenu.HomeScreen

fun NavGraphBuilder.tabHomeGraph(navController: NavController) {
    navigation(startDestination = Screen.Home.route, route = Screen.TabHome.route) {
        composable(Screen.Home.route) {
            HomeScreen(navController = navController)
        }
    }
}