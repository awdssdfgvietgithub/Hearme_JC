package com.example.hearme_jc.ui.fragments.onboardsignupsignin.screen

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController

@Composable
fun SignUpScreen(
    modifier: Modifier = Modifier,
    navController: NavController,
) {
//    Column(
//        modifier = modifier
//            .fillMaxSize()
//            .padding(top = 24.dp, end = 24.dp, start = 24.dp)
//            .background(MaterialTheme.colorScheme.background),
//        horizontalAlignment = Alignment.CenterHorizontally,
//    ) {
//        Image(
//            painter = painterResource(id = R.drawable.logo_default),
//            contentDescription = null,
//            contentScale = ContentScale.None,
//            modifier = Modifier
//                .size(100.dp),
//        )
//
//        Text(
//            modifier = Modifier.weight(1f),
//            text = stringResource(id = R.string.title_sign_up),
//            style = TextStyle(
//                fontSize = 32.sp,
//                lineHeight = 38.4.sp,
//                fontFamily = FontFamily(Font(R.font.urbanist_bold)),
//                fontWeight = FontWeight(700),
//                color = MaterialTheme.colorScheme.onBackground,
//                textAlign = TextAlign.Center,
//            ),
//        )
//
//        if (userViewModel != null) {
//            if (emailViewModel != null) {
//                ContainerForSignInOrSignUp(
//                    navController = navController,
//                    isSignIn = false,
//                    userViewModel = userViewModel,
//                    emailViewModel = emailViewModel
//                )
//            }
//        }
//
//        ContainerForChooseOptions()
//
//        ContainsBottomText(
//            modifier = Modifier.weight(1f),
//            navController = navController,
//            question = "Already have an account?",
//            action = "Sign in",
//            route = Screen.SignIn.route
//        )
//    }
//}
//
////@Preview(showBackground = true, widthDp = 412, heightDp = 915)
////@Composable
////fun SignUpPreview() {
////    Hearme_JCTheme {
////        Surface(
////            modifier = Modifier.fillMaxSize(),
////            color = MaterialTheme.colorScheme.background
////        ) {
////            val navController = rememberNavController()
////
////            SignUpScreen(navController = navController)
////        }
////    }
////}
}