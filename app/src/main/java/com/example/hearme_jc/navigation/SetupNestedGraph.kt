package com.example.hearme_jc.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.hearme_jc.ui.fragments.accountsetup.CreateNewPinScreen
import com.example.hearme_jc.ui.fragments.accountsetup.FillYourProfileScreen
import com.example.hearme_jc.ui.fragments.accountsetup.FollowArtistsScreen
import com.example.hearme_jc.ui.fragments.accountsetup.SetYourFingerprintScreen

fun NavGraphBuilder.setupGraph(navController: NavController){
    navigation(startDestination = Screen.FillYourProfile.route, route = Screen.Setup.route) {
        composable(route = Screen.FillYourProfile.route) {
            FillYourProfileScreen(navController = navController)
        }
        composable(route = Screen.CreateNewPin.route) {
            CreateNewPinScreen(navController = navController)
        }
        composable(route = Screen.SetYourFingerprint.route) {
            SetYourFingerprintScreen(navController = navController)
        }
        composable(route = Screen.FollowArtists.route) {
            FollowArtistsScreen(navController = navController)
        }
    }
}