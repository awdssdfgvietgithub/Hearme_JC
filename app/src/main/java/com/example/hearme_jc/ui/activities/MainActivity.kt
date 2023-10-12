package com.example.hearme_jc.ui.activities

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.hearme_jc.R
import com.example.hearme_jc.ui.NavGraph
import com.example.hearme_jc.ui.Screen
import com.example.hearme_jc.ui.theme.Hearme_JCTheme

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

        Screen.SetYourFingerprint.route -> {
            isShowToolbar.value = true
            onTitleChange.value = "Set Your Fingerprint"
        }

        Screen.FollowArtists.route -> {
            isShowToolbar.value = true
            onTitleChange.value = "Follow Artists"
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
