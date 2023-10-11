package com.example.mylibrary

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun AppNavigationButton(
    modifier: Modifier = Modifier,
    text: String,
    navController: NavController,
    route: String,
    textColor: Color,
    bgColor: Color,
    font: FontFamily,
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
//                fontFamily = font,
                fontWeight = FontWeight(700),
                color = textColor,
                textAlign = TextAlign.Center,
                letterSpacing = 0.2.sp,
            )
        )
    }
}