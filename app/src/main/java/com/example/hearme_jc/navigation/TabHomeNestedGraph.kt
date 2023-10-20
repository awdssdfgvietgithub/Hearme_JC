package com.example.hearme_jc.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import androidx.navigation.navArgument
import com.example.hearme_jc.ui.fragments.homeactionmenu.HomeScreen
import com.example.hearme_jc.ui.fragments.homeactionmenu.NotificationScreen
import com.example.hearme_jc.ui.fragments.homeactionmenu.SeeAllPopularArtistsScreen
import com.example.hearme_jc.ui.fragments.homeactionmenu.SeeAllTrendingNowScreen

fun NavGraphBuilder.tabHomeGraph(navController: NavController) {
    navigation(
        startDestination = "${Screen.Home.route}/phuongviet.huit@gmail.com", route = Screen.TabHome.route
    ) {
        composable(route = "${Screen.Home.route}/{email}",
            arguments = listOf(navArgument("email") {
                type = NavType.StringType
            })
        ) {
            val emailParams = it.arguments?.getString("email").toString()
            HomeScreen(navController = navController, email = emailParams)
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