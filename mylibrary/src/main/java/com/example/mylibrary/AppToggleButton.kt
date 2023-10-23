package com.example.mylibrary

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun AppToggleButton(
    modifier: Modifier = Modifier,
    bgColorFalse: Color,
    txtColorFalse: Color,
    bgColorTrue: Color,
    txtColorTrue: Color,
    borderColorFalse: Color,
    borderColorTrue: Color,
    textFalse: String,
    textTrue: String,
    fontFamily: FontFamily,
    isChecked: MutableState<Boolean> = mutableStateOf(false),
) {
    OutlinedButton(
        onClick = { isChecked.value = !isChecked.value },
        modifier = modifier
            .defaultMinSize(minHeight = 1.dp)
            .padding(top = 2.dp, bottom = 2.dp),
        colors = if (isChecked.value) ButtonDefaults.buttonColors(bgColorTrue) else ButtonDefaults.buttonColors(bgColorFalse),
        border = if (isChecked.value) BorderStroke(width = 2.dp, color = borderColorTrue) else BorderStroke(
            width = 0.dp,
            color = borderColorFalse
        )
    ) {
        Text(
            modifier = Modifier,
            text = if (isChecked.value) textTrue else textFalse,
            style = if (isChecked.value) TextStyle(
                fontSize = 14.sp,
                lineHeight = 19.6.sp,
                fontFamily = fontFamily,
                fontWeight = FontWeight(600),
                color = txtColorTrue,
                textAlign = TextAlign.Center,
                letterSpacing = 0.2.sp,
            ) else TextStyle(
                fontSize = 14.sp,
                lineHeight = 19.6.sp,
                fontFamily = fontFamily,
                fontWeight = FontWeight(600),
                color = txtColorFalse,
                textAlign = TextAlign.Center,
                letterSpacing = 0.2.sp,
            )
        )
    }
}

@Preview(showBackground = true)
@Composable
fun AppToggleButtonPreview() {
    Surface(
        modifier = Modifier.padding(24.dp),
        color = MaterialTheme.colorScheme.surface
    ) {
        AppToggleButton(
            bgColorFalse = Color.Black,
            txtColorFalse = Color.White,
            bgColorTrue = Color.White,
            txtColorTrue = Color.Black,
            borderColorFalse = Color.White,
            borderColorTrue = Color.Black,
            fontFamily = FontFamily.Default,
            textFalse = "Follow",
            textTrue = "Following"
        )
    }
}