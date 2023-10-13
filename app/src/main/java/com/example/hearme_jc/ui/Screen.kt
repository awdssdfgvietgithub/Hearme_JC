package com.example.hearme_jc.ui

sealed class Screen(val route: String) {
    //Onboard, Sign up & Sign in
    object Splash : Screen(route = "splash_screen")
    object Walkthrough : Screen(route = "walk_through_screen")
    object LetYouIn : Screen(route = "let_you_in_screen")
    object SignUp : Screen(route = "sign_up_screen")
    object SignIn : Screen(route = "sign_in")

    //Account setup
    object FillYourProfile : Screen(route = "fill_your_profile")
    object CreateNewPin : Screen(route = "create_new_pin")
    object SetYourFingerprint : Screen(route = "set_your_fingerprint")
    object FollowArtists : Screen(route = "follow_artists")

    //Forgot & reset password
    object SelectMethods : Screen(route = "select_methods")
    object TypeOTP : Screen(route = "type_otp")
    object CreateNewPassword : Screen(route = "create_new_password")

    //Home & Action menu
    object Home : Screen(route = "home")
}