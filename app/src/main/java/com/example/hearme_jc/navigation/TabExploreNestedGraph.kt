package com.example.hearme_jc.navigation

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import androidx.navigation.navigation
import com.example.hearme_jc.data.viewmodel.ArtistViewModel
import com.example.hearme_jc.data.viewmodel.CategoryViewModel
import com.example.hearme_jc.data.viewmodel.DetailsCategoryViewModel
import com.example.hearme_jc.data.viewmodel.EmailViewModel
import com.example.hearme_jc.data.viewmodel.MusicViewModel
import com.example.hearme_jc.data.viewmodel.TopicSearchViewModel
import com.example.hearme_jc.data.viewmodel.UserViewModel
import com.example.hearme_jc.ui.fragments.searchdetailsplay.screen.DetailsCategory
import com.example.hearme_jc.ui.fragments.searchdetailsplay.screen.ExploreScreen
import com.example.hearme_jc.ui.fragments.searchdetailsplay.screen.ListMusicsOfDetailsCategoryScreen
import com.example.hearme_jc.ui.fragments.searchdetailsplay.screen.ResultSearchScreen

@RequiresApi(Build.VERSION_CODES.O)
fun NavGraphBuilder.tabExploreGraph(
    navController: NavController,
    musicViewModel: MusicViewModel,
    artistViewModel: ArtistViewModel,
    userViewModel: UserViewModel,
    emailViewModel: EmailViewModel,
) {
    navigation(startDestination = Screen.Explore.route, route = Screen.TabExplore.route) {
        composable(Screen.Explore.route) {
            val categoryViewModel = it.sharedViewModel<CategoryViewModel>(navController = navController)
            ExploreScreen(
                navController = navController,
                categoryViewModel = categoryViewModel,
            )
        }
        composable("${Screen.DetailsCategory.route}/{categoryID}", arguments = listOf(navArgument("categoryID") {
            type = NavType.StringType
        })) {
            val categoryViewModel = it.sharedViewModel<CategoryViewModel>(navController = navController)
            val detailsCategoryViewModel = it.sharedViewModel<DetailsCategoryViewModel>(navController = navController)
            val categoryID = it.arguments?.getString("categoryID").toString()
            DetailsCategory(
                navController = navController,
                categoryViewModel = categoryViewModel,
                categoryID = categoryID,
                detailsCategoryViewModel = detailsCategoryViewModel
            )
        }
        composable(
            "${Screen.ListMusicsOfDetailsCategory.route}/{categoryID}/{detailsCategoryID}", arguments = listOf(
                navArgument("categoryID") { type = NavType.StringType },
                navArgument("detailsCategoryID") { type = NavType.StringType }
            )
        ) {
            val detailsCategoryViewModel = it.sharedViewModel<DetailsCategoryViewModel>(navController = navController)
            val categoryID = it.arguments?.getString("categoryID").toString()
            val detailsCategoryID = it.arguments?.getString("detailsCategoryID").toString()
            ListMusicsOfDetailsCategoryScreen(
                navController = navController,
                musicViewModel = musicViewModel,
                artistViewModel = artistViewModel,
                categoryID = categoryID,
                detailsCategoryID = detailsCategoryID,
                detailsCategoryViewModel = detailsCategoryViewModel
            )
        }
        composable(
            route = "${Screen.ResultSearch.route}/{query}",
            arguments = listOf(navArgument("query") { type = NavType.StringType })
        ) {
            val query = it.arguments?.getString("query").toString()
            val topicSearchViewModel = it.sharedViewModel<TopicSearchViewModel>(navController = navController)
            ResultSearchScreen(
                navController = navController,
                query = query,
                musicViewModel = musicViewModel,
                artistViewModel = artistViewModel,
                userViewModel = userViewModel,
                emailViewModel = emailViewModel
            )
        }
    }
}