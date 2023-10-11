package com.example.hearme_jc.ui.activities

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.hearme_jc.R
import com.example.hearme_jc.ui.NavGraph
import com.example.hearme_jc.ui.theme.Hearme_JCTheme
import com.example.hearme_jc.ui.theme.Primary500

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
    val isShowToolbar = remember {
        mutableStateOf(false)
    }

    Scaffold(topBar = {
        TopBar(
            isVisible = isShowToolbar.value,
            navController = navController
        )
    }) { values ->
        Column(modifier = Modifier.padding(values)) {
            NavGraph(navController = navController, isShowToolbar = isShowToolbar)
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainTextField(
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
        value = text,
        onValueChange = { text = it },
        placeholder = {
            Text(
                text = placeholderText,
                color = Color(0xFF9E9E9E)
            )
        },
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = Color(0xFF06C149),
            unfocusedBorderColor = Color(0x00000000),
        ),
        shape = RoundedCornerShape(size = 16.dp),
        leadingIcon = {
            Icon(
                painter = painterResource(id = leftIcon),
                contentDescription = null,
                tint = if (isTextFocused || text.isNotEmpty()) MaterialTheme.colorScheme.onBackground else Color(
                    0xFF9E9E9E
                ),
            )
        },

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
    )
}

@Composable
fun MainNavigationButton(
    modifier: Modifier = Modifier,
    text: String,
    navController: NavController,
    route: String,
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
        colors = ButtonDefaults.buttonColors(Primary500)
    ) {
        Text(
            text = text,
            modifier = Modifier.padding(end = 16.dp, start = 16.dp),
            style = TextStyle(
                fontSize = 16.sp,
                lineHeight = 22.4.sp,
                fontFamily = FontFamily(Font(R.font.urbanist_bold)),
                fontWeight = FontWeight(700),
                color = Color(0xFFFFFFFF),
                textAlign = TextAlign.Center,
                letterSpacing = 0.2.sp,
            )
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar(modifier: Modifier = Modifier, isVisible: Boolean, navController: NavController) {
    AnimatedVisibility(visible = isVisible) {
        TopAppBar(title = {
            Text(text = "")
        },
            navigationIcon = {
                IconButton(onClick = { navController.popBackStack() }) {
                    Icon(imageVector = Icons.Default.ArrowBack, contentDescription = null)
                }
            })
    }
}
