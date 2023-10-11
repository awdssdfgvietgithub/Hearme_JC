package com.example.hearme_jc.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.hearme_jc.ui.fragments.accountsetup.FillYourProfileScreen
import com.example.hearme_jc.ui.fragments.homeactionmenu.HomeScreen
import com.example.hearme_jc.ui.fragments.onboardsignupsignin.LetsYouInScreen
import com.example.hearme_jc.ui.fragments.onboardsignupsignin.SignInScreen
import com.example.hearme_jc.ui.fragments.onboardsignupsignin.SignUpScreen
import com.example.hearme_jc.ui.fragments.onboardsignupsignin.SplashScreen
import com.example.hearme_jc.ui.fragments.onboardsignupsignin.WalkThroughScreen

@Composable
fun NavGraph(navController: NavHostController, isShowToolbar: MutableState<Boolean>) {
    NavHost(navController = navController, startDestination = Screen.Splash.route) {
        //Onboard, Sign up & Sign in
        composable(Screen.Splash.route) {
            isShowToolbar.value = false
            SplashScreen(navController = navController)
        }
        composable(Screen.Walkthrough.route) {
            isShowToolbar.value = false
            WalkThroughScreen(navController = navController)
        }
        composable(Screen.LetYouIn.route) {
            isShowToolbar.value = true
            LetsYouInScreen(navController = navController)
        }
        composable(Screen.SignIn.route) {
            isShowToolbar.value = true
            SignInScreen(navController = navController)
        }
        composable(Screen.SignUp.route) {
            isShowToolbar.value = true
            SignUpScreen(navController = navController)
        }

        //Account Setup
        composable(Screen.FillYourProfile.route) {
            isShowToolbar.value = true
            FillYourProfileScreen(navController = navController)
        }

        //Home & Action menu
        composable(Screen.Home.route) {
            isShowToolbar.value = true
            HomeScreen(navController = navController)
        }
    }
}