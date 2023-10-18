package com.example.mylibrary

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ButtonMorePopupSpinner(modifier: Modifier, onClick: () -> Unit, painter: Int, tint: Color) {
    IconButton(modifier = modifier, onClick = { onClick() }) {
        Icon(
            painter = painterResource(id = painter),
            contentDescription = null,
            tint = tint
        )
    }
}

@Composable
fun SmallButtonPlay(modifier: Modifier, onClick: () -> Unit, painter: Int, tint: Color) {
    IconButton(modifier = modifier, onClick = { onClick() }) {
        Icon(painter = painterResource(id = painter), contentDescription = null, tint = tint)
    }
}

@Composable
fun AppNavigationButton(
    modifier: Modifier = Modifier,
    text: String,
    onButtonClick: () -> Unit = {},
    textColor: Color,
    bgColor: Color,
    font: FontFamily,
    haveShadow: Boolean = true,
) {
    Button(
        onClick = { onButtonClick() },
        shape = RoundedCornerShape(size = 100.dp),
        colors = ButtonDefaults.buttonColors(bgColor),
        modifier =
        if (haveShadow)
            modifier
                .fillMaxWidth()
                .shadow(
                    elevation = 6.dp,
                    spotColor = Color(0x4006C149),
                    ambientColor = Color(0x4006C149),
                    shape = RoundedCornerShape(size = 100.dp),
                )
                .width(380.dp)
                .height(58.dp)
        else modifier
            .fillMaxWidth()
            .shadow(
                elevation = 0.dp,
            )
            .width(380.dp)
            .height(58.dp),
        elevation = if (haveShadow) ButtonDefaults.elevation(6.dp, 6.dp) else ButtonDefaults.elevation(0.dp, 0.dp),
    ) {
        Text(
            text = text,
            modifier = Modifier.padding(end = 16.dp, start = 16.dp),
            style = TextStyle(
                fontSize = 16.sp,
                lineHeight = 22.4.sp,
                fontFamily = font,
                fontWeight = FontWeight(700),
                color = textColor,
                textAlign = TextAlign.Center,
                letterSpacing = 0.2.sp,
            )
        )
    }
}

@Composable
fun PairButton(
    modifier: Modifier = Modifier,
    text1: String,
    text2: String,
    textColor1: Color,
    textColor2: Color,
    bgColor1: Color,
    bgColor2: Color,
    font: FontFamily,
    onButtonClick1: () -> Unit = {},
    onButtonClick2: () -> Unit = {},
    haveShadow: Boolean = true,
) {
    Row(modifier = modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(12.dp)) {
        AppNavigationButton(
            modifier = Modifier.weight(1f),
            text = text1,
            onButtonClick = { onButtonClick1() },
            textColor = textColor1,
            bgColor = bgColor1,
            font = font,
            haveShadow = haveShadow
        )

        AppNavigationButton(
            modifier = Modifier.weight(1f),
            text = text2,
            onButtonClick = { onButtonClick2() },
            textColor = textColor2,
            bgColor = bgColor2,
            font = font,
            haveShadow = haveShadow
        )
    }
}