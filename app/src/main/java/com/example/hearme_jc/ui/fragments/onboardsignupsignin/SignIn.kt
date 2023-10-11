package com.example.hearme_jc.ui.fragments.onboardsignupsignin

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.hearme_jc.R
import com.example.hearme_jc.data.model.SignInMethod
import com.example.hearme_jc.data.model.SignInMethodData
import com.example.hearme_jc.ui.Screen
import com.example.hearme_jc.ui.activities.MainNavigationButton
import com.example.hearme_jc.ui.activities.MainTextFieldLeadingIcon
import com.example.hearme_jc.ui.theme.Hearme_JCTheme

@Composable
fun SignInScreen(modifier: Modifier = Modifier, navController: NavController) {
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

        ContainerForSignInOrSignUp(navController = navController)

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
fun ContainerForSignInOrSignUp(
    modifier: Modifier = Modifier,
    navController: NavController,
    isSignIn: Boolean = true,
) {
    var isChecked by rememberSaveable {
        mutableStateOf(false)
    }

    Column(modifier = modifier, verticalArrangement = Arrangement.Center) {
        MainTextFieldLeadingIcon(placeholderText = "Email", leftIcon = R.drawable.ic_email)

        Spacer(modifier = Modifier.height(24.dp))

        MainTextFieldLeadingIcon(
            placeholderText = "Password",
            leftIcon = R.drawable.ic_lock,
            isPasswordType = true
        )

        Spacer(modifier = Modifier.height(24.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Checkbox(checked = isChecked, onCheckedChange = { isChecked = it })

            Spacer(modifier = Modifier.width(12.dp))

            Text(
                text = "Remember me",
                style = TextStyle(
                    fontSize = 14.sp,
                    lineHeight = 19.6.sp,
                    fontFamily = FontFamily(Font(R.font.urbanist_semibold)),
                    fontWeight = FontWeight(600),
                    color = Color(0xFF212121),
                    letterSpacing = 0.2.sp,
                ),
            )
        }

        Spacer(modifier = Modifier.height(24.dp))

        val text = if (isSignIn) "Sign in" else "Sign up"
        val route = if (isSignIn) Screen.Home.route else Screen.FillYourProfile.route
        MainNavigationButton(
            text = text,
            navController = navController,
            route = route
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

@Preview(showBackground = true, widthDp = 412, heightDp = 915)
@Composable
fun SignInPreview() {
    Hearme_JCTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            val navController = rememberNavController()

            SignInScreen(navController = navController)
        }
    }
}