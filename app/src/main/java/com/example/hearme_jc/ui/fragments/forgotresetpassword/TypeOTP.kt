package com.example.hearme_jc.ui.fragments.forgotresetpassword

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.saveable.listSaver
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
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
import com.example.hearme_jc.navigation.Screen
import com.example.hearme_jc.ui.fragments.accountsetup.RowAppTextFieldPIN
import com.example.hearme_jc.ui.theme.Hearme_JCTheme
import com.example.hearme_jc.ui.theme.Primary500
import com.example.hearme_jc.ui.theme.White
import com.example.mylibrary.AppNavigationButton
import com.example.mylibrary.PadNumbers

@Composable
fun TypeOTPScreen(modifier: Modifier = Modifier, navController: NavController) {
    val numberArray = rememberSaveable(
        saver = listSaver(
            save = { it.toList() },
            restore = { mutableStateListOf<String>().apply { addAll(it) } }
        )
    ) { mutableStateListOf<String>() }

//    var isVisible by rememberSaveable {
//        mutableStateOf(true)
//    }
    Log.v("numberArray", "${numberArray.toList()}")

    Column(modifier = modifier.fillMaxSize()) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(24.dp)
                .weight(1f),
        ) {
            Spacer(modifier = Modifier.weight(1f))

            Text(
                modifier = Modifier.fillMaxWidth(),
                text = "Code has been send to +1 111 ******99",
                style = TextStyle(
                    fontSize = 18.sp,
                    lineHeight = 25.2.sp,
                    fontFamily = FontFamily(Font(R.font.urbanist_medium)),
                    fontWeight = FontWeight(500),
                    color = MaterialTheme.colorScheme.onBackground,
                    textAlign = TextAlign.Center,
                    letterSpacing = 0.2.sp,
                )
            )

            Spacer(modifier = Modifier.height(80.dp))

            RowAppTextFieldPIN(
                modifier = Modifier,
                numberArray = numberArray,
                fontFamily = FontFamily(Font(R.font.urbanist_bold)),
                bgColor = MaterialTheme.colorScheme.primary,
                mainColor = MaterialTheme.colorScheme.onBackground,
                focusBorder = Primary500,
                unfocusedBorder = MaterialTheme.colorScheme.outlineVariant,
            )

            Spacer(modifier = Modifier.height(80.dp))

            Text(
                modifier = Modifier.fillMaxWidth(),
                text = "Resend code in 55 s",
                style = TextStyle(
                    fontSize = 18.sp,
                    lineHeight = 25.2.sp,
                    fontFamily = FontFamily(Font(R.font.urbanist_medium)),
                    fontWeight = FontWeight(500),
                    color = MaterialTheme.colorScheme.onBackground,
                    textAlign = TextAlign.Center,
                    letterSpacing = 0.2.sp,
                )
            )

            Spacer(modifier = Modifier.weight(1f))

            AppNavigationButton(
                text = "Verify",
                textColor = White,
                bgColor = Primary500,
                font = FontFamily(Font(R.font.urbanist_bold)),
                onButtonClick = { navController.navigate(Screen.CreateNewPassword.route) }
            )
        }
//        AnimatedVisibility(visible = isVisible) {
            PadNumbers(
                modifier = Modifier,
                numberArray = numberArray,
                icon = R.drawable.ic_clear,
                fontFamily = FontFamily(Font(R.font.urbanist_semibold)),
                onBackgroundColor = MaterialTheme.colorScheme.onBackground,
                background = MaterialTheme.colorScheme.primary
            )
//        }
    }
}

@Preview(showBackground = true, widthDp = 412, heightDp = 915)
@Composable
fun TypeOTPScreenPreview() {
    Hearme_JCTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            val navController = rememberNavController()

            TypeOTPScreen(navController = navController)
        }
    }
}