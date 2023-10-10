package com.example.hearme_jc.ui

sealed class Screen(val route: String, val title: String? = null, val navIcon: Int? = null) {
    //Onboard, Sign up & Sign in
    object Splash : Screen(route = "splash_screen")
    object Walkthrough : Screen(route = "walk_through_screen")
    object LetYouIn : Screen(route = "let_you_in_screen")
    object SignUp : Screen(route = "sign_up_screen")
    object SignIn : Screen(route = "sign_in")

    //Account setup

    //Home & Action menu
    object Home : Screen(route = "home")


}