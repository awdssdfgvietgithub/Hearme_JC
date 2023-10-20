package com.example.hearme_jc.ui.fragments.onboardsignupsignin

import android.util.Log
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
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
import com.example.hearme_jc.data.model.SignInMethod
import com.example.hearme_jc.data.model.SignInMethodData
import com.example.hearme_jc.data.viewmodel.UserViewModel
import com.example.hearme_jc.navigation.Screen
import com.example.hearme_jc.ui.theme.Primary500
import com.example.hearme_jc.ui.theme.White
import com.example.mylibrary.AppNavigationButton
import com.example.mylibrary.AppTextFieldLeadingIcon

@Composable
fun SignInScreen(
    modifier: Modifier = Modifier,
    navController: NavController,
    userViewModel: UserViewModel,
) {
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
            text = stringResource(id = R.string.title_sign_in),
            style = TextStyle(
                fontSize = 32.sp,
                lineHeight = 38.4.sp,
                fontFamily = FontFamily(Font(R.font.urbanist_bold)),
                fontWeight = FontWeight(700),
                color = MaterialTheme.colorScheme.onBackground,
                textAlign = TextAlign.Center,
            ),
        )

        ContainerForSignInOrSignUp(
            navController = navController,
            userViewModel = userViewModel,
        )

        ContainerForChooseOptions()

        ContainsBottomText(
            modifier = Modifier.weight(1f),
            navController = navController,
            question = "Don’t have an account?",
            action = "Sign up",
            route = Screen.SignUp.route
        )
    }
}

@Composable
fun LazyRowThirdOptionsCard(modifier: Modifier = Modifier) {
    LazyRow(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Center,
    ) {
        items(SignInMethodData.data()) {
            Spacer(modifier = Modifier.width(if (this.equals(0)) 0.dp else 20.dp))
            ThirdOptionsCard(signInMethod = it)
        }
    }
}

@Composable
fun ThirdOptionsCard(modifier: Modifier = Modifier, signInMethod: SignInMethod) {
    Card(
        modifier = modifier,
        border = BorderStroke(1.dp, MaterialTheme.colorScheme.outlineVariant),
        colors = CardDefaults.cardColors(MaterialTheme.colorScheme.surface)
    ) {
        Column(
            modifier = modifier.padding(top = 18.dp, bottom = 18.dp, end = 32.dp, start = 32.dp),
        ) {
            Image(
                painter = painterResource(id = signInMethod.icon),
                contentDescription = null,
                modifier = Modifier.size(24.dp)
            )
        }
    }
}

@Composable
fun ContainerForChooseOptions(modifier: Modifier = Modifier) {
    Column(modifier = modifier) {
        DividerOtherMethod(text = "or continue with")

        Spacer(modifier = Modifier.height(20.dp))

        LazyRowThirdOptionsCard()
    }
}

@Composable
fun ContainerRememberMe(modifier: Modifier = Modifier) {
    Row(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        var isCheck by rememberSaveable {
            mutableStateOf(false)
        }

        Box(
            modifier = Modifier
                .size(24.dp)
                .background(
                    color = if (isCheck) Primary500 else White,
                    shape = RoundedCornerShape(8.dp)
                )
                .border(width = 3.dp, shape = RoundedCornerShape(8.dp), color = Primary500)
                .clickable { isCheck = !isCheck }
        )
        {
            IconButton(onClick = { isCheck = !isCheck }) {
                this@Row.AnimatedVisibility(visible = isCheck) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_check),
                        contentDescription = null,
                        tint = White
                    )
                }
            }
        }

        Spacer(modifier = Modifier.width(12.dp))

        Text(
            text = "Remember me",
            style = TextStyle(
                fontSize = 14.sp,
                lineHeight = 19.6.sp,
                fontFamily = FontFamily(Font(R.font.urbanist_semibold)),
                fontWeight = FontWeight(600),
                color = MaterialTheme.colorScheme.onBackground,
                letterSpacing = 0.2.sp,
            ),
        )
    }
}

@Composable
fun ContainerForSignInOrSignUp(
    modifier: Modifier = Modifier,
    navController: NavController,
    isSignIn: Boolean = true,
    userViewModel: UserViewModel,
) {
    var isChecked by rememberSaveable {
        mutableStateOf(false)
    }

    val email = rememberSaveable {
        mutableStateOf("")
    }

    val password = rememberSaveable {
        mutableStateOf("")
    }

    Column(modifier = modifier, verticalArrangement = Arrangement.Center) {
        AppTextFieldLeadingIcon(
            placeholderText = "Email",
            leftIcon = R.drawable.ic_email,
            placeholderFont = FontFamily(Font(R.font.urbanist_regular)),
            inputFont = FontFamily(Font(R.font.urbanist_semibold)),
            mainColor = MaterialTheme.colorScheme.onBackground,
            bgColor = MaterialTheme.colorScheme.primary,
            text = email
        )

        Spacer(modifier = Modifier.height(24.dp))

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

        Spacer(modifier = Modifier.height(24.dp))

        ContainerRememberMe()

        Spacer(modifier = Modifier.height(24.dp))

        val text = if (isSignIn) "Sign in" else "Sign up"
        AppNavigationButton(
            text = text,
            textColor = White,
            bgColor = Primary500,
            onButtonClick = {
                if (isSignIn) {
                    when (userViewModel.Login(email.value, password.value).toInt()) {
                        0 -> {
                            Log.v("RESULT", "Rỗng")
                        }

                        1 -> {
                            navController.navigate("${Screen.Home.route}/${email.value}") {
                                popUpTo(0) {
                                    inclusive = true
                                }
                            }
                        }

                        else -> {
                            Log.v("RESULT", "0 tồn tại")

                        }
                    }
                } else {
                    when (userViewModel.Register(email.value, password.value).toInt()) {
                        0 -> {
                            Log.v("RESULT", "Rỗng")
                        }

                        1 -> {
                            navController.navigate("${Screen.FillYourProfile.route}/${email.value}")
                        }

                        else -> {
                            Log.v("RESULT", "Trùng email")

                        }
                    }
                }
            },
            font = FontFamily(Font(R.font.urbanist_bold))
        )

        Spacer(modifier = Modifier.height(24.dp))

        if (isSignIn)
            Text(
                text = "Forgot the password?",
                style = TextStyle(
                    fontSize = 16.sp,
                    lineHeight = 22.4.sp,
                    fontFamily = FontFamily(Font(R.font.urbanist_semibold)),
                    fontWeight = FontWeight(600),
                    color = Color(0xFF06C149),
                    textAlign = TextAlign.Center,
                    letterSpacing = 0.2.sp,
                ),
                modifier = Modifier.fillMaxWidth()
            )
    }
}

//@Preview(showBackground = true, widthDp = 412, heightDp = 915)
//@Composable
//fun SignInPreview() {
//    Hearme_JCTheme {
//        Surface(
//            modifier = Modifier.fillMaxSize(),
//            color = MaterialTheme.colorScheme.background
//        ) {
//            val navController = rememberNavController()
//
//            SignInScreen(navController = navController)
//        }
//    }
//}