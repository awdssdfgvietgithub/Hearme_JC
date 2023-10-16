package com.example.hearme_jc.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost

@Composable
fun NavGraph(
    navController: NavHostController,
) {
    NavHost(navController = navController, startDestination = Screen.Onboard.route) {
        //Onboard
        onboardGraph(navController)

        //Authentication
        authGraph(navController)

        //Setup
        setupGraph(navController)

        //Tab Home
        tabHomeGraph(navController)

        //Tab Explore
        tabExploreGraph(navController)

        //Tab Library
        tabLibraryGraph(navController)

        //Tab Profile
        tabProfileGraph(navController)
    }
}