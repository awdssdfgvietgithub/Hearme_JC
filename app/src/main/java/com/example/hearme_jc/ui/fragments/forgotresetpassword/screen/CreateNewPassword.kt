package com.example.hearme_jc.ui.fragments.forgotresetpassword.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.hearme_jc.R
import com.example.hearme_jc.data.viewmodel.EmailViewModel
import com.example.hearme_jc.data.viewmodel.UserViewModel
import com.example.hearme_jc.navigation.Screen
import com.example.hearme_jc.ui.fragments.onboardsignupsignin.screen.ContainerRememberMe
import com.example.hearme_jc.ui.theme.Primary300
import com.example.hearme_jc.ui.theme.Primary500
import com.example.hearme_jc.ui.theme.White
import com.example.mylibrary.AppDialogNavigation
import com.example.mylibrary.AppNavigationButton
import com.example.mylibrary.AppTextFieldLeadingIcon

@Composable
fun CreateNewPasswordScreen(
    modifier: Modifier = Modifier,
    navController: NavController,
    emailViewModel: EmailViewModel,
    userViewModel: UserViewModel,
) {
    var showDialog by rememberSaveable {
        mutableStateOf(false)
    }

    if (showDialog) {
        AppDialogNavigation(
            setShowDialog = { showDialog = it },
            painterCircleColor = Primary300,
            painterMainBackground = R.drawable.ic_circle_dialog,
            painterMainIcon = R.drawable.ic_authorization,
            background = MaterialTheme.colorScheme.surface,
            fontFamily = FontFamily(Font(R.font.urbanist_bold)),
            title = "Congratulations",
            body = "Your account is ready to use. You will be redirected to the Home page in a few seconds..",
            titleColor = Primary500,
            bodyColor = MaterialTheme.colorScheme.onBackground,
            onNavigation = {
                navController.navigate(Screen.Home.route) {
                    popUpTo(0) {
                        inclusive = true
                    }
                }
            }
        )
    }

    Column(
        modifier = modifier
            .padding(end = 24.dp, start = 24.dp)
            .fillMaxSize()
    ) {
        Spacer(modifier = Modifier.weight(1f))

        Image(
            painter = painterResource(id = R.drawable.image_vector_create_new_password),
            contentDescription = null,
            modifier = Modifier
                .width(329.dp)
                .height(250.dp)
                .fillMaxWidth()
        )

        Spacer(modifier = Modifier.weight(1f))

        ContainerCreateNewPassword()

        Spacer(modifier = Modifier.height(24.dp))

        ContainerRememberMe()

        Spacer(modifier = Modifier.weight(1f))

        AppNavigationButton(
            text = "Continue",
            textColor = White,
            bgColor = Primary500,
            font = FontFamily(Font(R.font.urbanist_bold)),
            onButtonClick = { showDialog = true }
        )

        Spacer(modifier = Modifier.height(48.dp))
    }
}

@Composable
fun ContainerCreateNewPassword(modifier: Modifier = Modifier) {
    val password = rememberSaveable {
        mutableStateOf("")
    }

    val rePassword = rememberSaveable {
        mutableStateOf("")
    }

    Column(modifier = modifier.fillMaxWidth(), verticalArrangement = Arrangement.spacedBy(24.dp)) {
        Text(
            text = "Create Your New Password",
            style = TextStyle(
                fontSize = 18.sp,
                lineHeight = 25.2.sp,
                fontFamily = FontFamily(Font(R.font.urbanist_medium)),
                fontWeight = FontWeight(500),
                color = MaterialTheme.colorScheme.onBackground,
                letterSpacing = 0.2.sp,
            )
        )

        AppTextFieldLeadingIcon(
            placeholderText = "Password",
            leftIcon = R.drawable.ic_lock,
            placeholderFont = FontFamily(Font(R.font.urbanist_regular)),
            inputFont = FontFamily(Font(R.font.urbanist_semibold)),
            mainColor = MaterialTheme.colorScheme.onBackground,
            isPasswordType = true,
            bgColor = MaterialTheme.colorScheme.primary,
            text = password
        )

        AppTextFieldLeadingIcon(
            placeholderText = "Re-password",
            leftIcon = R.drawable.ic_lock,
            placeholderFont = FontFamily(Font(R.font.urbanist_regular)),
            inputFont = FontFamily(Font(R.font.urbanist_semibold)),
            mainColor = MaterialTheme.colorScheme.onBackground,
            isPasswordType = true,
            bgColor = MaterialTheme.colorScheme.primary,
            text = rePassword
        )
    }
}

//@Preview(showBackground = true, widthDp = 412, heightDp = 915)
//@Composable
//fun CreateNewPasswordScreenPreview() {
//    Hearme_JCTheme {
//        Surface(
//            modifier = Modifier.fillMaxSize(),
//            color = MaterialTheme.colorScheme.background
//        ) {
//            val navController = rememberNavController()
//
//            CreateNewPasswordScreen(navController = navController)
//        }
//    }
//}