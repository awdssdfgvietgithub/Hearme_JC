package com.example.hearme_jc.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.hearme_jc.ui.fragments.accountsetup.CreateNewPinScreen
import com.example.hearme_jc.ui.fragments.accountsetup.FillYourProfileScreen
import com.example.hearme_jc.ui.fragments.homeactionmenu.HomeScreen
import com.example.hearme_jc.ui.fragments.onboardsignupsignin.LetsYouInScreen
import com.example.hearme_jc.ui.fragments.onboardsignupsignin.SignInScreen
import com.example.hearme_jc.ui.fragments.onboardsignupsignin.SignUpScreen
import com.example.hearme_jc.ui.fragments.onboardsignupsignin.SplashScreen
import com.example.hearme_jc.ui.fragments.onboardsignupsignin.WalkThroughScreen

@Composable
fun NavGraph(
    navController: NavHostController,
) {
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
        composable(Screen.SignIn.route) {
            SignInScreen(navController = navController)
        }
        composable(Screen.SignUp.route) {
            SignUpScreen(navController = navController)
        }

        //Account Setup
        composable(Screen.FillYourProfile.route) {
            FillYourProfileScreen(navController = navController)
        }
        composable(Screen.CreateNewPin.route) {
            CreateNewPinScreen(navController = navController)
        }


        //Home & Action menu
        composable(Screen.Home.route) {
            HomeScreen(navController = navController)
        }
    }
}