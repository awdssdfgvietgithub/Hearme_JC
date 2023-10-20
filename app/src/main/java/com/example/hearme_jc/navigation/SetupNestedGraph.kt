package com.example.hearme_jc.navigation

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import androidx.navigation.navigation
import com.example.hearme_jc.data.viewmodel.UserViewModel
import com.example.hearme_jc.ui.fragments.accountsetup.CreateNewPinScreen
import com.example.hearme_jc.ui.fragments.accountsetup.FillYourProfileScreen
import com.example.hearme_jc.ui.fragments.accountsetup.FollowArtistsScreen
import com.example.hearme_jc.ui.fragments.accountsetup.SetYourFingerprintScreen

@RequiresApi(Build.VERSION_CODES.O)
fun NavGraphBuilder.setupGraph(navController: NavController, userViewModel: UserViewModel) {
    navigation(startDestination = Screen.FillYourProfile.route, route = Screen.Setup.route) {
        composable(route = "${Screen.FillYourProfile.route}/{email}", arguments = listOf(navArgument("email") {
            type = NavType.StringType
        })) {
            val emailParam = it.arguments?.getString("email") ?: ""
            FillYourProfileScreen(navController = navController, userViewModel = userViewModel, email = emailParam)
        }
        composable(route = "${Screen.CreateNewPin.route}/{email}", arguments = listOf(navArgument("email") {
            type = NavType.StringType
        })) {
            val emailParam = it.arguments?.getString("email") ?: ""
            CreateNewPinScreen(navController = navController, userViewModel = userViewModel, email = emailParam)
        }
        composable(route = "${Screen.SetYourFingerprint.route}/{email}", arguments = listOf(navArgument("email") {
            type = NavType.StringType
        })) {
            val emailParam = it.arguments?.getString("email") ?: ""
            SetYourFingerprintScreen(navController = navController, email = emailParam)
        }
        composable(route = "${Screen.FollowArtists.route}/{email}", arguments = listOf(navArgument("email") {
            type = NavType.StringType
        })) {
            val emailParam = it.arguments?.getString("email") ?: ""
            FollowArtistsScreen(
                navController = navController, userViewModel = userViewModel, email = emailParam
            )
        }
    }
}