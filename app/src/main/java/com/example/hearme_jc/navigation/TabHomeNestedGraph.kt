package com.example.hearme_jc.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import com.example.hearme_jc.data.viewmodel.ArtistViewModel
import com.example.hearme_jc.data.viewmodel.EmailViewModel
import com.example.hearme_jc.data.viewmodel.MusicViewModel
import com.example.hearme_jc.data.viewmodel.UserViewModel
import com.example.hearme_jc.ui.fragments.homeactionmenu.screen.HomeScreen
import com.example.hearme_jc.ui.fragments.homeactionmenu.screen.NotificationScreen
import com.example.hearme_jc.ui.fragments.homeactionmenu.screen.SeeAllPopularArtistsScreen
import com.example.hearme_jc.ui.fragments.homeactionmenu.screen.SeeAllTrendingNowScreen

fun NavGraphBuilder.tabHomeGraph(
    navController: NavController,
    emailViewModel: EmailViewModel,
    userViewModel: UserViewModel,
    musicViewModel: MusicViewModel,
    artistViewModel: ArtistViewModel,
) {
    navigation(
        startDestination = Screen.Home.route, route = Screen.TabHome.route
    ) {
        composable(route = Screen.Home.route) {
            HomeScreen(
                navController = navController,
                emailViewModel = emailViewModel,
                userViewModel = userViewModel,
                musicViewModel = musicViewModel,
                artistViewModel = artistViewModel
            )
        }
        composable(Screen.SeeAllTrendingNow.route) {
            SeeAllTrendingNowScreen(
                navController = navController,
                musicViewModel = musicViewModel,
                artistViewModel = artistViewModel
            )
        }
        composable(Screen.SeeAllPopularArtists.route) {
            SeeAllPopularArtistsScreen(navController = navController, artistViewModel = artistViewModel)
        }
        composable(route = Screen.Notification.route) {
            NotificationScreen(
                navController = navController,
                musicViewModel = musicViewModel,
                artistViewModel = artistViewModel
            )
        }
    }
}