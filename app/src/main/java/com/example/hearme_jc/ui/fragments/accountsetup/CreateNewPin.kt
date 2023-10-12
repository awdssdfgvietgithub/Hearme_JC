package com.example.hearme_jc.ui.fragments.accountsetup

import android.media.Image
import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.focusable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.listSaver
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.runtime.toMutableStateList
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
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
import androidx.navigation.compose.rememberNavController
import com.example.hearme_jc.R
import com.example.hearme_jc.ui.theme.Hearme_JCTheme
import com.example.hearme_jc.ui.theme.Primary500
import com.example.hearme_jc.ui.theme.White
import com.example.mylibrary.AppNavigationButton

@Composable
fun CreateNewPinScreen(modifier: Modifier = Modifier, navController: NavController) {
    val numberArray = rememberSaveable(
        saver = listSaver(
            save = { it.toList() },
            restore = { mutableStateListOf<String>().apply { addAll(it) } }
        )
    ) { mutableStateListOf<String>() }
    Log.v("numberArray", "${numberArray.toList()}")

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
            numberArray = numberArray
        )

        AppNavigationButton(
            modifier = Modifier.padding(start = 24.dp, end = 24.dp),
            text = "Continue", textColor = White, bgColor = Primary500, font = FontFamily(
                Font(R.font.urbanist_bold)
            )
        )

        Spacer(modifier = Modifier.height(24.dp))

        PadNumbers(modifier = Modifier, numberArray = numberArray)
    }
}

@Composable
fun NumberButton(
    modifier: Modifier = Modifier,
    number: String,
    icon: Int? = null,
    onClickButton: () -> Unit,
) {
    Button(
        onClick = { onClickButton() }, modifier = modifier
            .fillMaxWidth()
            .height(56.dp)
    ) {
        if (icon == null)
            Text(
                text = number, style = TextStyle(
                    fontSize = 24.sp,
                    fontFamily = FontFamily(Font(R.font.urbanist_semibold)),
                    fontWeight = FontWeight(500),
                    color = MaterialTheme.colorScheme.onBackground,
                    textAlign = TextAlign.Center,
                )
            )
        else
            Icon(
                painter = painterResource(id = icon),
                contentDescription = null,
                tint = MaterialTheme.colorScheme.onBackground
            )
    }
}

@Composable
fun PadNumbers(modifier: Modifier = Modifier, numberArray: MutableList<String>) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .height(272.dp),
        shape = RoundedCornerShape(topEnd = 40.dp, topStart = 40.dp),
        colors = CardDefaults.cardColors(MaterialTheme.colorScheme.primary),
    ) {
        Column(
            modifier = modifier
                .fillMaxSize()
                .padding(top = 12.dp, end = 12.dp, start = 12.dp, bottom = 4.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            //1
            Row(modifier = Modifier.weight(1f)) {
                NumberButton(
                    modifier = Modifier.weight(1f),
                    number = "1",
                    onClickButton = {
                        if (numberArray.toList().size < 4) numberArray.add("1")
                    }
                )
                NumberButton(
                    modifier = Modifier.weight(1f),
                    number = "2",
                    onClickButton = { if (numberArray.toList().size < 4) numberArray.add("2") }
                )
                NumberButton(
                    modifier = Modifier.weight(1f),
                    number = "3",
                    onClickButton = { if (numberArray.toList().size < 4) numberArray.add("3") }
                )
            }
            //2
            Row(modifier = Modifier.weight(1f)) {
                NumberButton(
                    modifier = Modifier.weight(1f),
                    number = "4",
                    onClickButton = { if (numberArray.toList().size < 4) numberArray.add("4") }
                )
                NumberButton(
                    modifier = Modifier.weight(1f),
                    number = "5",
                    onClickButton = { if (numberArray.toList().size < 4) numberArray.add("5") }
                )
                NumberButton(
                    modifier = Modifier.weight(1f),
                    number = "6",
                    onClickButton = { if (numberArray.toList().size < 4) numberArray.add("6") }
                )
            }
            //3
            Row(modifier = Modifier.weight(1f)) {
                NumberButton(
                    modifier = Modifier.weight(1f),
                    number = "7",
                    onClickButton = { if (numberArray.toList().size < 4) numberArray.add("7") }
                )
                NumberButton(
                    modifier = Modifier.weight(1f),
                    number = "8",
                    onClickButton = { if (numberArray.toList().size < 4) numberArray.add("8") }
                )
                NumberButton(
                    modifier = Modifier.weight(1f),
                    number = "9",
                    onClickButton = { if (numberArray.toList().size < 4) numberArray.add("9") }
                )
            }
            //4
            Row(modifier = Modifier.weight(1f)) {
                NumberButton(
                    modifier = Modifier.weight(1f),
                    number = "*",
                    onClickButton = { }
                )
                NumberButton(
                    modifier = Modifier.weight(1f),
                    number = "0",
                    onClickButton = { if (numberArray.toList().size < 4) numberArray.add("0") }
                )
                NumberButton(
                    modifier = Modifier.weight(1f),
                    number = "",
                    icon = R.drawable.ic_clear,
                    onClickButton = {
                        if (numberArray.toList().isNotEmpty()) numberArray.removeLast()
                    }
                )
            }
        }
    }
}

@Composable
fun RowAppTextFieldPIN(modifier: Modifier = Modifier, numberArray: MutableList<String>) {
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        AppTextFieldPIN(
            modifier = Modifier.weight(1f),
            inputFont = FontFamily(Font(R.font.urbanist_regular)),
            bgColor = MaterialTheme.colorScheme.primary,
            mainColor = MaterialTheme.colorScheme.onBackground,
            onChangeText = { if (numberArray.toList().size > 0) numberArray.toList()[0] else "" }
        )

        AppTextFieldPIN(
            modifier = Modifier.weight(1f),
            inputFont = FontFamily(Font(R.font.urbanist_regular)),
            bgColor = MaterialTheme.colorScheme.primary,
            mainColor = MaterialTheme.colorScheme.onBackground,
            onChangeText = { if (numberArray.toList().size > 1) numberArray.toList()[1] else "" }
        )

        AppTextFieldPIN(
            modifier = Modifier.weight(1f),
            inputFont = FontFamily(Font(R.font.urbanist_regular)),
            bgColor = MaterialTheme.colorScheme.primary,
            mainColor = MaterialTheme.colorScheme.onBackground,
            onChangeText = { if (numberArray.toList().size > 2) numberArray.toList()[2] else "" }
        )

        AppTextFieldPIN(
            modifier = Modifier.weight(1f),
            inputFont = FontFamily(Font(R.font.urbanist_regular)),
            bgColor = MaterialTheme.colorScheme.primary,
            mainColor = MaterialTheme.colorScheme.onBackground,
            onChangeText = { if (numberArray.toList().size > 3) numberArray.toList()[3] else "" }
        )
    }
}

//Chua lam duoc
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppTextFieldPIN(
    modifier: Modifier = Modifier,
    inputFont: FontFamily,
    bgColor: Color,
    mainColor: Color,
    onChangeText: (String) -> String,
) {
    val text = ""

    val maxChar = 1

    var number by rememberSaveable {
        mutableStateOf("")
    }

    var isTextFocused by rememberSaveable {
        mutableStateOf(false)
    }

    val focusRequester = remember { FocusRequester() }


    OutlinedTextField(
        modifier = modifier
            .background(
                color = bgColor,
                shape = RoundedCornerShape(size = 16.dp),
            )
//            .height(83.dp)
            .fillMaxWidth()
//            .onFocusChanged { isTextFocused = it.isFocused }
            .focusRequester(focusRequester),
        value = onChangeText(text),
        readOnly = true,
        singleLine = true,
        onValueChange = { if (it.length <= maxChar) number = it },
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = Primary500,
            unfocusedBorderColor = Color(0xFFEEEEEE),
        ),
        shape = RoundedCornerShape(size = 16.dp),
        textStyle = TextStyle(
            fontSize = 40.sp,
            lineHeight = 28.8.sp,
            fontFamily = inputFont,
            fontWeight = FontWeight(700),
            color = mainColor,
            letterSpacing = 0.2.sp,
            textAlign = TextAlign.Center
        ),
//        visualTransformation = PasswordVisualTransformation(mask = '\u25CF'),

        keyboardOptions =
        KeyboardOptions(keyboardType = KeyboardType.Number)
    )

    LaunchedEffect(Unit) {
        if (onChangeText(text).isNotEmpty())
            focusRequester.requestFocus()
    }
}

@Preview(showBackground = true, widthDp = 412, heightDp = 915)
@Composable
fun CreateNewPinScreenPreview() {
    Hearme_JCTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            val navController = rememberNavController()

            CreateNewPinScreen(navController = navController)
        }
    }
}