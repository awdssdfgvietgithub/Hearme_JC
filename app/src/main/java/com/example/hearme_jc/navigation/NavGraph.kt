package com.example.hearme_jc.navigation

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.example.hearme_jc.data.viewmodel.UserViewModel

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun NavGraph(
    navController: NavHostController,
    userViewModel: UserViewModel,
) {
    NavHost(navController = navController, startDestination = Screen.TabHome.route) {
        //Onboard
        onboardGraph(navController)

        //Authentication
        authGraph(navController, userViewModel = userViewModel)

        //Setup
        setupGraph(navController, userViewModel = userViewModel)

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