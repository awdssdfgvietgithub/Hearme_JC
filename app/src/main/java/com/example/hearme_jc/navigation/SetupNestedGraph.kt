package com.example.hearme_jc.navigation

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.hearme_jc.data.viewmodel.EmailViewModel
import com.example.hearme_jc.data.viewmodel.UserViewModel
import com.example.hearme_jc.ui.fragments.accountsetup.screen.CreateNewPinScreen
import com.example.hearme_jc.ui.fragments.accountsetup.screen.FillYourProfileScreen
import com.example.hearme_jc.ui.fragments.accountsetup.screen.FollowArtistsScreen
import com.example.hearme_jc.ui.fragments.accountsetup.screen.SetYourFingerprintScreen

@RequiresApi(Build.VERSION_CODES.O)
fun NavGraphBuilder.setupGraph(
    navController: NavController,
    emailViewModel: EmailViewModel,
    userViewModel: UserViewModel,
) {
    navigation(startDestination = Screen.FillYourProfile.route, route = Screen.Setup.route) {
        composable(route = Screen.FillYourProfile.route) {
            FillYourProfileScreen(navController = navController, emailViewModel = emailViewModel, userViewModel = userViewModel)
        }
        composable(route = Screen.CreateNewPin.route) {
            CreateNewPinScreen(navController = navController, emailViewModel = emailViewModel, userViewModel = userViewModel)
        }
        composable(route = Screen.SetYourFingerprint.route) {
            SetYourFingerprintScreen(navController = navController)
        }
        composable(route = Screen.FollowArtists.route) {
            FollowArtistsScreen(navController = navController, emailViewModel = emailViewModel, userViewModel = userViewModel)
        }
    }
}