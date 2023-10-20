package com.example.hearme_jc.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.hearme_jc.ui.fragments.onboardsignupsignin.screen.LetsYouInScreen
import com.example.hearme_jc.ui.fragments.onboardsignupsignin.screen.SplashScreen
import com.example.hearme_jc.ui.fragments.onboardsignupsignin.screen.WalkThroughScreen

fun NavGraphBuilder.onboardGraph(navController: NavController) {
    navigation(startDestination = Screen.Splash.route, route = Screen.Onboard.route) {
        composable(route = Screen.Splash.route) {
            SplashScreen(navController = navController)
        }
        composable(route = Screen.Walkthrough.route) {
            WalkThroughScreen(navController = navController)
        }
        composable(route = Screen.LetYouIn.route) {
            LetsYouInScreen(navController = navController)
        }
    }
}