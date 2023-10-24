package com.example.hearme_jc.navigation

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.example.hearme_jc.data.viewmodel.ArtistViewModel
import com.example.hearme_jc.data.viewmodel.EmailViewModel
import com.example.hearme_jc.data.viewmodel.MusicViewModel
import com.example.hearme_jc.data.viewmodel.UserViewModel

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun NavGraph(
    navController: NavHostController,
) {
    val emailViewModel: EmailViewModel = viewModel()
    val userViewModel: UserViewModel = viewModel()
    val musicViewModel: MusicViewModel = viewModel()
    val artistViewModel: ArtistViewModel = viewModel()

    NavHost(navController = navController, startDestination = Screen.TabExplore.route) {
        //Onboard
        onboardGraph(navController)

        //Authentication
        authGraph(navController, emailViewModel = emailViewModel, userViewModel = userViewModel)

        //Setup
        setupGraph(navController, emailViewModel = emailViewModel, userViewModel = userViewModel)

        //Tab Home
        tabHomeGraph(
            navController,
            emailViewModel = emailViewModel,
            userViewModel = userViewModel,
            musicViewModel = musicViewModel,
            artistViewModel = artistViewModel
        )

        //Tab Explore
        tabExploreGraph(
            navController,
            musicViewModel = musicViewModel,
            artistViewModel = artistViewModel,
            userViewModel = userViewModel,
            emailViewModel = emailViewModel
        )

        //Tab Library
        tabLibraryGraph(navController)

        //Tab Profile
        tabProfileGraph(navController)
    }
}

@Composable
inline fun <reified T : ViewModel> NavBackStackEntry.sharedViewModel(
    navController: NavController,
): T {
    val navGraphRoute = destination.parent?.route ?: return viewModel()
    val parentEntry = remember(this) {
        navController.getBackStackEntry(navGraphRoute)
    }
    return viewModel(parentEntry)
}