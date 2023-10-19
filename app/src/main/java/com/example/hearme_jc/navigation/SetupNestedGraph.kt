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
            val param = it.arguments?.getString("email") ?: ""
            FillYourProfileScreen(navController = navController, userViewModel = userViewModel, email = param)
        }
        composable(route = Screen.CreateNewPin.route) {
            CreateNewPinScreen(navController = navController, userViewModel = userViewModel)
        }
        composable(route = Screen.SetYourFingerprint.route) {
            SetYourFingerprintScreen(navController = navController)
        }
        composable(route = Screen.FollowArtists.route) {
            FollowArtistsScreen(navController = navController, userViewModel = userViewModel)
        }
    }
}