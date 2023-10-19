package com.example.hearme_jc.ui.fragments.onboardsignupsignin

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.hearme_jc.R
import com.example.hearme_jc.data.viewmodel.UserViewModel
import com.example.hearme_jc.navigation.Screen

@Composable
fun SignUpScreen(modifier: Modifier = Modifier, navController: NavController, userViewModel: UserViewModel) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(top = 24.dp, end = 24.dp, start = 24.dp)
            .background(MaterialTheme.colorScheme.background),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Image(
            painter = painterResource(id = R.drawable.logo_default),
            contentDescription = null,
            contentScale = ContentScale.None,
            modifier = Modifier
                .size(100.dp),
        )

        Text(
            modifier = Modifier.weight(1f),
            text = stringResource(id = R.string.title_sign_up),
            style = TextStyle(
                fontSize = 32.sp,
                lineHeight = 38.4.sp,
                fontFamily = FontFamily(Font(R.font.urbanist_bold)),
                fontWeight = FontWeight(700),
                color = MaterialTheme.colorScheme.onBackground,
                textAlign = TextAlign.Center,
            ),
        )

        ContainerForSignInOrSignUp(navController = navController, isSignIn = false, userViewModel = userViewModel)

        ContainerForChooseOptions()

        ContainsBottomText(
            modifier = Modifier.weight(1f),
            navController = navController,
            question = "Already have an account?",
            action = "Sign in",
            route = Screen.SignIn.route
        )
    }
}

//@Preview(showBackground = true, widthDp = 412, heightDp = 915)
//@Composable
//fun SignUpPreview() {
//    Hearme_JCTheme {
//        Surface(
//            modifier = Modifier.fillMaxSize(),
//            color = MaterialTheme.colorScheme.background
//        ) {
//            val navController = rememberNavController()
//
//            SignUpScreen(navController = navController)
//        }
//    }
//}