package com.example.hearme_jc.ui.fragments.onboardsignupsignin.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.hearme_jc.R
import com.example.hearme_jc.data.model.SignInMethod
import com.example.hearme_jc.data.model.SignInMethodData
import com.example.hearme_jc.navigation.Screen
import com.example.hearme_jc.ui.theme.Hearme_JCTheme
import com.example.hearme_jc.ui.theme.Primary500
import com.example.hearme_jc.ui.theme.White
import com.example.mylibrary.AppNavigationButton

@Composable
fun LetsYouInScreen(
    modifier: Modifier = Modifier,
    navController: NavController,
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(top = 24.dp, end = 24.dp, start = 24.dp)
            .background(MaterialTheme.colorScheme.background),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Image(
            painter = painterResource(id = R.drawable.vector_image_let_you_in),
            contentDescription = null,
            modifier = Modifier
                .height(200.dp)
                .width(237.dp)
        )

        Text(
            text = "Let’s you in",
            style = TextStyle(
                fontSize = 48.sp,
                lineHeight = 57.6.sp,
                fontFamily = FontFamily(Font(R.font.urbanist_bold)),
                fontWeight = FontWeight(700),
                color = MaterialTheme.colorScheme.onBackground,
                textAlign = TextAlign.Center,
            ),
            modifier = Modifier.weight(1f)
        )

        LazyColumnMethodSignInCard()

        Spacer(modifier = Modifier.height(24.dp))
        DividerOtherMethod(text = "or")
        Spacer(modifier = Modifier.height(24.dp))

        if (navController != null) {
            AppNavigationButton(
                text = stringResource(id = R.string.method_sign_in_password),
                textColor = White,
                bgColor = Primary500,
                onButtonClick = { navController.navigate(Screen.SignIn.route) },
                font = FontFamily(Font(R.font.urbanist_bold))
            )
        }

        ContainsBottomText(
            navController = navController,
            modifier = Modifier.weight(1f),
            question = "Don’t have an account?",
            action = "Sign up",
            route = Screen.SignUp.route
        )
    }
}

@Composable
fun ContainsBottomText(
    modifier: Modifier = Modifier,
    navController: NavController,
    question: String,
    action: String,
    route: String,
) {
    Row(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.Bottom
    ) {
        Text(
            text = question,
            style = TextStyle(
                fontSize = 14.sp,
                lineHeight = 19.6.sp,
                fontFamily = FontFamily(Font(R.font.urbanist_regular)),
                fontWeight = FontWeight(400),
                color = Color(0xFF9E9E9E),
                textAlign = TextAlign.Right,
                letterSpacing = 0.2.sp,
            )
        )

        Spacer(modifier = Modifier.width(8.dp))

        Text(
            text = action,
            style = TextStyle(
                fontSize = 14.sp,
                lineHeight = 19.6.sp,
                fontFamily = FontFamily(Font(R.font.urbanist_semibold)),
                fontWeight = FontWeight(600),
                color = Color(0xFF06C149),
                letterSpacing = 0.2.sp,
            ),
            modifier = Modifier.clickable {
                navController.navigate(route) {
                    if (route == Screen.SignUp.route)
                        popUpTo(Screen.SignIn.route) {
                            inclusive = true
                        }
                    else if (route == Screen.SignIn.route)
                        popUpTo(Screen.SignUp.route) {
                            inclusive = true
                        }
                }
            }
        )
    }

    Spacer(modifier = Modifier.height(48.dp))
}

@Composable
fun DividerOtherMethod(modifier: Modifier = Modifier, text: String) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(10.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Divider(
            color = MaterialTheme.colorScheme.outlineVariant,
            thickness = 0.5.dp,
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
        )

        Spacer(modifier = Modifier.width(16.dp))

        Text(
            text = text,
            style = TextStyle(
                fontSize = 18.sp,
                lineHeight = 25.2.sp,
                fontFamily = FontFamily(Font(R.font.urbanist_semibold)),
                fontWeight = FontWeight(600),
                color = Color(0xFF616161),
                textAlign = TextAlign.Center,
                letterSpacing = 0.2.sp,
            ),
        )

        Spacer(modifier = Modifier.width(16.dp))

        Divider(
            color = MaterialTheme.colorScheme.outlineVariant,
            thickness = 0.5.dp,
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
        )

    }
}

@Composable
fun LazyColumnMethodSignInCard(modifier: Modifier = Modifier) {
    LazyColumn(verticalArrangement = Arrangement.spacedBy(16.dp), modifier = modifier) {
        items(SignInMethodData.data()) {
            MethodSignInCard(signInMethod = it)
        }
    }
}

@Composable
fun MethodSignInCard(modifier: Modifier = Modifier, signInMethod: SignInMethod) {
    Card(
        modifier = modifier
            .border(
                width = 1.dp,
                color = MaterialTheme.colorScheme.outlineVariant,
                shape = RoundedCornerShape(size = 16.dp)
            )
            .width(380.dp)
            .height(60.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surface,
        )
    ) {
        Row(
            modifier = Modifier
                .padding(start = 32.dp, top = 18.dp, end = 32.dp, bottom = 18.dp)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Image(
                painter = painterResource(id = signInMethod.icon),
                contentDescription = null,
                modifier = Modifier.size(24.dp)
            )

            Spacer(modifier = Modifier.width(12.dp))

            Text(
                text = signInMethod.name,
                style = TextStyle(
                    fontSize = 16.sp,
                    lineHeight = 22.4.sp,
                    fontFamily = FontFamily(Font(R.font.urbanist_semibold)),
                    fontWeight = FontWeight(600),
                    color = MaterialTheme.colorScheme.onBackground,
                    letterSpacing = 0.2.sp,
                ),
            )
        }
    }
}

@Preview(showBackground = true, widthDp = 412, heightDp = 915)
@Composable
fun LetsYouInScreenPreview() {
    Hearme_JCTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            val navController = rememberNavController()

            LetsYouInScreen(navController = navController)
        }
    }
}