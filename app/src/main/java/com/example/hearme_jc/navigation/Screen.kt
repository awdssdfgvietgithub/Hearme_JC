package com.example.hearme_jc.navigation

sealed class Screen(val route: String) {
    //Nested navigation
    object Onboard: Screen(route = "onboard")
    object Auth: Screen(route = "auth")
    object Setup: Screen(route = "setup")
    object TabHome: Screen(route = "tab_home")
    object TabExplore: Screen(route = "tab_explore")
    object TabLibrary: Screen(route = "tab_library")
    object TabProfile: Screen(route = "tab_profile")


    //Onboard
    object Splash : Screen(route = "splash_screen")
    object Walkthrough : Screen(route = "walk_through_screen")
    object LetYouIn : Screen(route = "let_you_in_screen")

    //Authentication
    object SignUp : Screen(route = "sign_up_screen")
    object SignIn : Screen(route = "sign_in")
    object SelectMethods : Screen(route = "select_methods")
    object TypeOTP : Screen(route = "type_otp")
    object CreateNewPassword : Screen(route = "create_new_password")

    //Setup
    object FillYourProfile : Screen(route = "fill_your_profile")
    object CreateNewPin : Screen(route = "create_new_pin")
    object SetYourFingerprint : Screen(route = "set_your_fingerprint")
    object FollowArtists : Screen(route = "follow_artists")

    //Tab Home
    object Home : Screen(route = "home")

    //Tab Explore
    object Explore : Screen(route = "explore")

    //Tab Library
    object Library : Screen(route = "library")

    //Tab Profile
    object Profile : Screen(route = "profile")
}