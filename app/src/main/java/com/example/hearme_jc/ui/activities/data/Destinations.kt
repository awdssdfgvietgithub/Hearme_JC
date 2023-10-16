package com.example.hearme_jc.ui.activities.data

import com.example.hearme_jc.R
import com.example.hearme_jc.navigation.Screen

sealed class Destinations(val route: String, val title: String? = null, val icon: Int? = null) {
    object HomeScreen : Destinations(
        route = Screen.Home.route,
        title = "Home",
        icon = R.drawable.ic_home
    )

    object ExploreScreen : Destinations(
        route = Screen.Explore.route,
        title = "Favorite",
        icon = R.drawable.ic_explore
    )

    object LibraryScreen : Destinations(
        route = Screen.Library.route,
        title = "Notification",
        icon = R.drawable.ic_library
    )

    object ProfileScreen : Destinations(
        route = Screen.Profile.route,
        title = "Notification",
        icon = R.drawable.ic_profile
    )
}
