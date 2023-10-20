package com.example.hearme_jc.ui.fragments.accountsetup

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.saveable.listSaver
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
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
import com.example.hearme_jc.ui.theme.Primary500
import com.example.hearme_jc.ui.theme.White
import com.example.mylibrary.AppNavigationButton
import com.example.mylibrary.AppTextFieldPIN
import com.example.mylibrary.PadNumbers

@Composable
fun CreateNewPinScreen(modifier: Modifier = Modifier, navController: NavController, userViewModel: UserViewModel, email: String) {
    val numberArray = rememberSaveable(
        saver = listSaver(
            save = { it.toList() },
            restore = { mutableStateListOf<String>().apply { addAll(it) } }
        )
    ) { mutableStateListOf<String>() }
    Log.v("CreateNewPinScreen",email)
    Column(modifier = modifier) {
        Spacer(modifier = Modifier.weight(1f))

        Text(
            modifier = Modifier.padding(start = 24.dp, end = 24.dp),
            text = "Add a PIN number to make your account more secure.",
            style = TextStyle(
                fontSize = 18.sp,
                lineHeight = 25.2.sp,
                fontFamily = FontFamily(Font(R.font.urbanist_regular)),
                fontWeight = FontWeight(400),
                color = MaterialTheme.colorScheme.onBackground,
                textAlign = TextAlign.Center,
                letterSpacing = 0.2.sp,
            )
        )

        Spacer(modifier = Modifier.height(80.dp))

        RowAppTextFieldPIN(
            modifier = modifier
                .weight(1f)
                .padding(start = 24.dp, end = 24.dp),
            numberArray = numberArray,
            fontFamily = FontFamily(Font(R.font.urbanist_bold)),
            bgColor = MaterialTheme.colorScheme.primary,
            mainColor = MaterialTheme.colorScheme.onBackground,
            focusBorder = Primary500,
            unfocusedBorder = MaterialTheme.colorScheme.outlineVariant,
        )

        AppNavigationButton(
            modifier = Modifier.padding(start = 24.dp, end = 24.dp),
            text = "Continue", textColor = White, bgColor = Primary500, font = FontFamily(
                Font(R.font.urbanist_bold)
            ),
            onButtonClick = {
                val rs = userViewModel.CreateNewPin(email, pin = numberArray).toInt()
                when (rs) {
                    0 -> {
                        Log.v("CreateNewPin","Email rong")
                    }

                    2 -> {
                        Log.v("CreateNewPin","Pin rong")
                    }

                    1 -> {
                        navController.navigate("${Screen.SetYourFingerprint.route}/$email")
                    }

                    else -> {
                        Log.v("CreateNewPin","Email khong chinh xac")
                    }
                }
            }
        )

        Spacer(modifier = Modifier.height(24.dp))

        PadNumbers(
            modifier = Modifier,
            numberArray = numberArray,
            icon = R.drawable.ic_clear,
            fontFamily = FontFamily(Font(R.font.urbanist_semibold)),
            onBackgroundColor = MaterialTheme.colorScheme.onBackground,
            background = MaterialTheme.colorScheme.primary
        )
    }
}

@Composable
fun RowAppTextFieldPIN(
    modifier: Modifier = Modifier,
    numberArray: MutableList<String>,
    fontFamily: FontFamily,
    bgColor: Color,
    mainColor: Color,
    focusBorder: Color,
    unfocusedBorder: Color,
) {
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        AppTextFieldPIN(
            modifier = Modifier.weight(1f),
            inputFont = fontFamily,
            bgColor = bgColor,
            mainColor = mainColor,
            onChangeText = {
                if (numberArray.toList().isNotEmpty()) numberArray.toList()[0] else ""
            },
            focusBorder = focusBorder,
            unfocusedBorder = unfocusedBorder,
        )

        AppTextFieldPIN(
            modifier = Modifier.weight(1f),
            inputFont = fontFamily,
            bgColor = bgColor,
            mainColor = mainColor,
            onChangeText = { if (numberArray.toList().size > 1) numberArray.toList()[1] else "" },
            focusBorder = focusBorder,
            unfocusedBorder = unfocusedBorder,
        )

        AppTextFieldPIN(
            modifier = Modifier.weight(1f),
            inputFont = fontFamily,
            bgColor = bgColor,
            mainColor = mainColor,
            onChangeText = { if (numberArray.toList().size > 2) numberArray.toList()[2] else "" },
            focusBorder = focusBorder,
            unfocusedBorder = unfocusedBorder,
        )

        AppTextFieldPIN(
            modifier = Modifier.weight(1f),
            inputFont = fontFamily,
            bgColor = bgColor,
            mainColor = mainColor,
            onChangeText = { if (numberArray.toList().size > 3) numberArray.toList()[3] else "" },
            focusBorder = focusBorder,
            unfocusedBorder = unfocusedBorder,
        )
    }
}