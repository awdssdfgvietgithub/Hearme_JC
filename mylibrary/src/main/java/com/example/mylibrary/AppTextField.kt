package com.example.mylibrary

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun AppTextFieldPIN(
    modifier: Modifier = Modifier,
    inputFont: FontFamily,
    bgColor: Color,
    mainColor: Color,
    onChangeText: (String) -> String,
    focusBorder: Color,
    unfocusedBorder: Color,
) {
    val text = ""

    val maxChar = 1

    var number by rememberSaveable {
        mutableStateOf("")
    }

    var isTextFocused by rememberSaveable {
        mutableStateOf(false)
    }

    androidx.compose.material3.OutlinedTextField(
        modifier = modifier
            .background(
                color = bgColor,
                shape = RoundedCornerShape(size = 16.dp),
            )
            .fillMaxWidth(),
        value = onChangeText(text),
        readOnly = true,
        singleLine = true,
        onValueChange = {
            if (it.length <= maxChar) number = it

        },
        colors = OutlinedTextFieldDefaults.colors(
            focusedBorderColor = focusBorder, unfocusedBorderColor = unfocusedBorder,
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
        visualTransformation = PasswordVisualTransformation(mask = '\u25CF'),

        keyboardOptions =
        KeyboardOptions(keyboardType = KeyboardType.Number)
    )
}

@Composable
fun AppTextFieldLeadingIcon(
    modifier: Modifier = Modifier,
    placeholderText: String,
    leftIcon: Int,
    isPasswordType: Boolean? = null,
    placeholderFont: FontFamily,
    inputFont: FontFamily,
    bgColor: Color,
    mainColor: Color,
) {
    var text by rememberSaveable { mutableStateOf("") }

    var isTextFocused by rememberSaveable {
        mutableStateOf(false)
    }

    var passwordVisible by rememberSaveable { mutableStateOf(false) }

    OutlinedTextField(
        modifier = modifier
            .background(
                color = bgColor,
                shape = RoundedCornerShape(size = 16.dp),
            )
            .height(60.dp)
            .fillMaxWidth()
            .onFocusChanged { isTextFocused = it.isFocused },
        textStyle = TextStyle(
            fontSize = 14.sp,
            lineHeight = 19.6.sp,
            fontFamily = placeholderFont,
            fontWeight = FontWeight(600),
            color = mainColor,
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
                    fontFamily = inputFont,
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
                    if (isTextFocused || text.isNotEmpty()) mainColor else Color(
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
                tint = if (isTextFocused || text.isNotEmpty()) mainColor else Color(
                    0xFF9E9E9E
                )
            )
        },
    )
}

@Composable
fun AppTextField(
    modifier: Modifier = Modifier,
    placeholderText: String,
    placeholderFont: FontFamily,
    inputFont: FontFamily,
    bgColor: Color,
    mainColor: Color,
) {
    var text by rememberSaveable { mutableStateOf("") }

    var isTextFocused by rememberSaveable {
        mutableStateOf(false)
    }

    OutlinedTextField(
        modifier = modifier
            .background(
                color = bgColor,
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
                    fontFamily = placeholderFont,
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
            fontFamily = inputFont,
            fontWeight = FontWeight(600),
            color = mainColor,
            letterSpacing = 0.2.sp,
        )
    )
}

