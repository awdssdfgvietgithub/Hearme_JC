package com.example.hearme_jc.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.hearme_jc.data.viewmodel.EmailViewModel
import com.example.hearme_jc.data.viewmodel.UserViewModel
import com.example.hearme_jc.ui.fragments.forgotresetpassword.screen.CreateNewPasswordScreen
import com.example.hearme_jc.ui.fragments.forgotresetpassword.screen.SelectMethodsScreen
import com.example.hearme_jc.ui.fragments.forgotresetpassword.screen.TypeOTPScreen
import com.example.hearme_jc.ui.fragments.onboardsignupsignin.screen.SignInScreen
import com.example.hearme_jc.ui.fragments.onboardsignupsignin.screen.SignUpScreen

fun NavGraphBuilder.authGraph(
    navController: NavController,
    emailViewModel: EmailViewModel,
    userViewModel: UserViewModel,
) {
    navigation(startDestination = Screen.SignIn.route, route = Screen.Auth.route) {
        composable(route = Screen.SignIn.route) {
//            val emailViewModel = it.sharedViewModel<EmailViewModel>(navController = navController)
//            val userViewModel = it.sharedViewModel<UserViewModel>(navController = navController)

            SignInScreen(navController = navController, emailViewModel = emailViewModel, userViewModel = userViewModel)
        }
        composable(route = Screen.SignUp.route) {
            SignUpScreen(navController = navController)
//            val emailViewModel = it.sharedViewModel<EmailViewModel>(navController = navController)
        }
        composable(route = Screen.SelectMethods.route) {
//            val emailViewModel = it.sharedViewModel<EmailViewModel>(navController = navController)
            SelectMethodsScreen(navController = navController, emailViewModel = emailViewModel)
        }
        composable(route = Screen.TypeOTP.route) {
            TypeOTPScreen(navController = navController)
//            val emailViewModel = it.sharedViewModel<EmailViewModel>(navController = navController)
        }
        composable(route = Screen.CreateNewPassword.route) {
            CreateNewPasswordScreen(navController = navController, emailViewModel = emailViewModel, userViewModel = userViewModel)
//            val emailViewModel = it.sharedViewModel<EmailViewModel>(navController = navController)
        }
    }
}