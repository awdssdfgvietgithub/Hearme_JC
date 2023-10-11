package com.example.hearme_jc.ui.activities

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.hearme_jc.R
import com.example.hearme_jc.ui.NavGraph
import com.example.hearme_jc.ui.Screen
import com.example.hearme_jc.ui.theme.Hearme_JCTheme
import com.example.hearme_jc.ui.theme.Primary500
import com.example.hearme_jc.ui.theme.White
import com.example.lib.MyClass

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Hearme_JCTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MainScreen()
                }
            }
        }
    }
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen() {
    val navController = rememberNavController()

    //State of topBar, false is its invisible
    val isShowToolbar = rememberSaveable {
        mutableStateOf(false)
    }

    //State of topBar, title of its
    val onTitleChange = rememberSaveable {
        mutableStateOf("")
    }

    //Get current screen/fragment
    val navBackStackEntry by navController.currentBackStackEntryAsState()

    //Check to recompose topBar when navigating to a screen/fragment
    when (navBackStackEntry?.destination?.route) {
        Screen.Splash.route -> {
            isShowToolbar.value = false
        }

        Screen.Walkthrough.route -> {
            isShowToolbar.value = false
            onTitleChange.value = ""
        }

        Screen.LetYouIn.route -> {
            isShowToolbar.value = true
            onTitleChange.value = ""
        }

        Screen.SignUp.route -> {
            isShowToolbar.value = true
            onTitleChange.value = ""

        }

        Screen.SignIn.route -> {
            isShowToolbar.value = true
            onTitleChange.value = ""

        }

        Screen.FillYourProfile.route -> {
            isShowToolbar.value = true
            onTitleChange.value = "Fill Your Profile"
        }

        Screen.CreateNewPin.route -> {
            isShowToolbar.value = true
            onTitleChange.value = "Create New PIN"
        }

        Screen.Home.route -> {
            isShowToolbar.value = true
            onTitleChange.value = ""

        }
    }

    Scaffold(topBar = {
        TopBar(
            isVisible = isShowToolbar,
            navController = navController,
            onTitleChange = onTitleChange
        )
    }) { values ->
        Column(modifier = Modifier.padding(values)) {
            NavGraph(
                navController = navController
            )
        }
    }
}

@Composable
fun PairButton(
    modifier: Modifier = Modifier,
    text1: String,
    text2: String,
    route1: String,
    route2: String,
    textColor1: Color,
    textColor2: Color,
    bgColor1: Color,
    bgColor2: Color,
    navController: NavController,
) {
    Row(modifier = modifier, horizontalArrangement = Arrangement.spacedBy(12.dp)) {
        MainNavigationButton(
            modifier = Modifier.weight(1f),
            text = text1,
            navController = navController,
            route = route1,
            textColor = textColor1,
            bgColor = bgColor1
        )

        MainNavigationButton(
            modifier = Modifier.weight(1f),
            text = text2,
            navController = navController,
            route = route2,
            textColor = textColor2,
            bgColor = bgColor2
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainTextFieldLeadingIcon(
    modifier: Modifier = Modifier,
    placeholderText: String,
    leftIcon: Int,
    isPasswordType: Boolean? = null,
) {
    var text by rememberSaveable { mutableStateOf("") }

    var isTextFocused by rememberSaveable {
        mutableStateOf(false)
    }

    var passwordVisible by rememberSaveable { mutableStateOf(false) }

    OutlinedTextField(
        modifier = modifier
            .background(
                color = Color(0xFFF5F5F5),
                shape = RoundedCornerShape(size = 16.dp),
            )
            .height(60.dp)
            .fillMaxWidth()
            .onFocusChanged { isTextFocused = it.isFocused },
        textStyle = TextStyle(
            fontSize = 14.sp,
            lineHeight = 19.6.sp,
            fontFamily = FontFamily(Font(R.font.urbanist_semibold)),
            fontWeight = FontWeight(600),
            color = MaterialTheme.colorScheme.onBackground,
            letterSpacing = 0.2.sp,
        ),
        value = text,
        maxLines = 1,
        onValueChange = { text = it },
        placeholder = {
            Text(
                text = placeholderText,
                style = TextStyle(
                    fontSize = 14.sp,
                    lineHeight = 19.6.sp,
                    fontFamily = FontFamily(Font(R.font.urbanist_regular)),
                    fontWeight = FontWeight(400),
                    color = Color(0xFF9E9E9E),
                    letterSpacing = 0.2.sp,
                )
            )
        },
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = Color(0xFF06C149),
            unfocusedBorderColor = Color(0x00000000),
        ),
        shape = RoundedCornerShape(size = 16.dp),
        visualTransformation =
        if (passwordVisible && isPasswordType == true) VisualTransformation.None
        else if (isPasswordType == true) PasswordVisualTransformation()
        else VisualTransformation.None,

        keyboardOptions =
        if (isPasswordType == true) KeyboardOptions(keyboardType = KeyboardType.Password)
        else KeyboardOptions(keyboardType = KeyboardType.Text),

        trailingIcon = {
            if (isPasswordType == true) {
                val image = if (passwordVisible)
                    Icons.Filled.Visibility
                else Icons.Filled.VisibilityOff

                val tint =
                    if (isTextFocused || text.isNotEmpty()) MaterialTheme.colorScheme.onBackground else Color(
                        0xFF9E9E9E
                    )

                val description = if (passwordVisible) "Hide password" else "Show password"

                IconButton(onClick = { passwordVisible = !passwordVisible }) {
                    Icon(imageVector = image, description, tint = tint)
                }
            }
        },
        leadingIcon = {
            Icon(
                painter = painterResource(id = leftIcon),
                contentDescription = null,
                tint = if (isTextFocused || text.isNotEmpty()) MaterialTheme.colorScheme.onBackground else Color(
                    0xFF9E9E9E
                )
            )
        },
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainTextField(
    modifier: Modifier = Modifier,
    placeholderText: String,
) {
    var text by rememberSaveable { mutableStateOf("") }

    var isTextFocused by rememberSaveable {
        mutableStateOf(false)
    }

    OutlinedTextField(
        modifier = modifier
            .background(
                color = Color(0xFFF5F5F5),
                shape = RoundedCornerShape(size = 16.dp),
            )
            .height(56.dp)
            .fillMaxWidth()
            .onFocusChanged { isTextFocused = it.isFocused },
        value = text,
        onValueChange = { text = it },
        maxLines = 1,
        placeholder = {
            Text(
                text = placeholderText,
                style = TextStyle(
                    fontSize = 14.sp,
                    lineHeight = 19.6.sp,
                    fontFamily = FontFamily(Font(R.font.urbanist_regular)),
                    fontWeight = FontWeight(400),
                    color = Color(0xFF9E9E9E),
                    letterSpacing = 0.2.sp,
                )
            )
        },
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = Color(0xFF06C149),
            unfocusedBorderColor = Color(0x00000000),
        ),
        shape = RoundedCornerShape(size = 16.dp),
        textStyle = TextStyle(
            fontSize = 14.sp,
            lineHeight = 19.6.sp,
            fontFamily = FontFamily(Font(R.font.urbanist_semibold)),
            fontWeight = FontWeight(600),
            color = MaterialTheme.colorScheme.onBackground,
            letterSpacing = 0.2.sp,
        )
    )
}

@Composable
fun MainNavigationButton(
    modifier: Modifier = Modifier,
    text: String,
    navController: NavController,
    route: String,
    textColor: Color = Color(0xFFFFFFFF),
    bgColor: Color = Primary500,
) {
    Button(
        onClick = { navController.navigate(route) },
        modifier = modifier
            .fillMaxWidth()
            .shadow(
                elevation = 24.dp,
                spotColor = Color(0x4006C149),
                ambientColor = Color(0x4006C149),
                shape = RoundedCornerShape(size = 100.dp),
            )
            .width(380.dp)
            .height(58.dp),
        colors = ButtonDefaults.buttonColors(bgColor)
    ) {
        Text(
            text = text,
            modifier = Modifier.padding(end = 16.dp, start = 16.dp),
            style = TextStyle(
                fontSize = 16.sp,
                lineHeight = 22.4.sp,
                fontFamily = FontFamily(Font(R.font.urbanist_bold)),
                fontWeight = FontWeight(700),
                color = textColor,
                textAlign = TextAlign.Center,
                letterSpacing = 0.2.sp,
            )
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar(
    modifier: Modifier = Modifier,
    isVisible: MutableState<Boolean>,
    navController: NavController,
    onTitleChange: MutableState<String> = mutableStateOf(""),
) {
    AnimatedVisibility(visible = isVisible.value) {
        TopAppBar(title = {
            Text(
                text = onTitleChange.value, style = TextStyle(
                    fontSize = 24.sp,
                    lineHeight = 28.8.sp,
                    fontFamily = FontFamily(Font(R.font.urbanist_bold)),
                    fontWeight = FontWeight(700),
                    color = MaterialTheme.colorScheme.onBackground,
                )
            )
        }, modifier = modifier,
            navigationIcon = {
                IconButton(onClick = { navController.popBackStack() }) {
                    Icon(
                        imageVector = Icons.Default.ArrowBack,
                        contentDescription = null,
                        tint = MaterialTheme.colorScheme.onBackground
                    )
                }
            })
    }
}

@Preview(showBackground = true, widthDp = 412)
@Composable
fun MainTextFieldPreview() {
    Hearme_JCTheme {
        Surface(
            modifier = Modifier.padding(24.dp),
            color = MaterialTheme.colorScheme.background
        ) {
            val navController = rememberNavController()

            PairButton(
                text1 = "Skip",
                text2 = "Continue",
                route1 = Screen.CreateNewPin.route,
                route2 = Screen.CreateNewPin.route,
                textColor1 = MaterialTheme.colorScheme.onTertiary,
                textColor2 = White,
                bgColor1 = MaterialTheme.colorScheme.onSecondaryContainer,
                bgColor2 = Primary500,
                navController = navController,
            )
        }
    }
}
