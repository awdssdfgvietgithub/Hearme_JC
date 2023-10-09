package com.example.hearme_jc.ui

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.hearme_jc.ui.fragments.onboardsignupsignin.LetsYouInScreen
import com.example.hearme_jc.ui.fragments.onboardsignupsignin.SplashScreen
import com.example.hearme_jc.ui.fragments.onboardsignupsignin.WalkThroughScreen

@Composable
fun NavGraph(navController: NavHostController) {
    NavHost(navController = navController, startDestination = Screen.Splash.route) {
        composable(Screen.Splash.route) {
            SplashScreen(navController = navController)
        }
        composable(Screen.Walkthrough.route) {
            WalkThroughScreen(navController = navController)
        }
        composable(Screen.LetYouIn.route) {
            LetsYouInScreen(navController = navController)
        }
    }
}