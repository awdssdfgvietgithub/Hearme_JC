package com.example.hearme_jc.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.hearme_jc.ui.fragments.forgotresetpassword.CreateNewPasswordScreen
import com.example.hearme_jc.ui.fragments.forgotresetpassword.SelectMethodsScreen
import com.example.hearme_jc.ui.fragments.forgotresetpassword.TypeOTPScreen
import com.example.hearme_jc.ui.fragments.onboardsignupsignin.SignInScreen
import com.example.hearme_jc.ui.fragments.onboardsignupsignin.SignUpScreen

fun NavGraphBuilder.authGraph(navController: NavController) {
    navigation(startDestination = Screen.SignIn.route, route = Screen.Auth.route) {
        composable(route = Screen.SignIn.route) {
            SignInScreen(navController = navController)
        }
        composable(route = Screen.SignUp.route) {
            SignUpScreen(navController = navController)
        }
        composable(route = Screen.SelectMethods.route) {
            SelectMethodsScreen(navController = navController)
        }
        composable(route = Screen.TypeOTP.route) {
            TypeOTPScreen(navController = navController)
        }
        composable(route = Screen.CreateNewPassword.route) {
            CreateNewPasswordScreen(navController = navController)
        }
    }
}