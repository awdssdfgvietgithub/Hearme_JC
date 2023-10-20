package com.example.hearme_jc.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.hearme_jc.data.viewmodel.ArtistViewModel
import com.example.hearme_jc.data.viewmodel.CategoryViewModel
import com.example.hearme_jc.data.viewmodel.ChartsViewModel
import com.example.hearme_jc.data.viewmodel.MusicViewModel
import com.example.hearme_jc.ui.fragments.searchdetailsplay.screen.DetailsChartScreen
import com.example.hearme_jc.ui.fragments.searchdetailsplay.screen.ExploreScreen

fun NavGraphBuilder.tabExploreGraph(
    navController: NavController,
    musicViewModel: MusicViewModel,
    artistViewModel: ArtistViewModel,
) {
    navigation(startDestination = Screen.Explore.route, route = Screen.TabExplore.route) {
        composable(Screen.Explore.route) {
            val categoryViewModel = it.sharedViewModel<CategoryViewModel>(navController = navController)
            ExploreScreen(navController = navController, categoryViewModel = categoryViewModel)
        }
        composable(Screen.Chart.route) {
            val chartsViewModel = it.sharedViewModel<ChartsViewModel>(navController = navController)
            ChartsScreen(navController = navController, chartsViewModel = chartsViewModel)
        }
        composable(Screen.DetailsChart.route) {
            DetailsChartScreen(
                navController = navController,
                musicViewModel = musicViewModel,
                artistViewModel = artistViewModel
            )
        }
    }
}