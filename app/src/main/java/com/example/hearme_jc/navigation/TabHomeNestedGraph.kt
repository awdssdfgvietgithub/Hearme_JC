package com.example.hearme_jc.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.hearme_jc.ui.fragments.homeactionmenu.HomeScreen
import com.example.hearme_jc.ui.fragments.homeactionmenu.NotificationScreen
import com.example.hearme_jc.ui.fragments.homeactionmenu.SeeAllPopularArtistsScreen
import com.example.hearme_jc.ui.fragments.homeactionmenu.SeeAllTrendingNowScreen

fun NavGraphBuilder.tabHomeGraph(navController: NavController) {
    navigation(startDestination = Screen.Home.route, route = Screen.TabHome.route) {
        composable(Screen.Home.route) {
            HomeScreen(navController = navController)
        }
        composable(Screen.SeeAllTrendingNow.route) {
            SeeAllTrendingNowScreen(navController = navController)
        }
        composable(Screen.SeeAllPopularArtists.route) {
            SeeAllPopularArtistsScreen(navController = navController)
        }
        composable(route = Screen.Notification.route) {
            NotificationScreen(navController = navController)
        }

//        composable(route = Screen.SongsNotification.route) {
////            SignInScreen(navController = navController)
//        }
//
//        composable(route = Screen.PodcastsNotification.route) {
////            SignInScreen(navController = navController)
//        }
    }
}