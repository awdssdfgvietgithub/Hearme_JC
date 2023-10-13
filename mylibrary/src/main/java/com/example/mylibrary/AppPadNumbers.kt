package com.example.mylibrary

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun NumberButton(
    modifier: Modifier = Modifier,
    number: String,
    icon: Int? = null,
    onClickButton: () -> Unit,
    fontFamily: FontFamily? = null,
    onBackgroundColor: Color = MaterialTheme.colorScheme.onBackground,
) {
    Button(
        onClick = { onClickButton() }, modifier = modifier
            .fillMaxWidth()
            .height(56.dp),
        colors = ButtonDefaults.buttonColors(Color.Transparent),
        border = BorderStroke(0.dp, Color.Transparent),
        elevation = ButtonDefaults.elevation(0.dp, 0.dp)

    ) {
        if (icon == null)
            Text(
                text = number, style = TextStyle(
                    fontSize = 24.sp,
                    fontFamily = fontFamily,
                    fontWeight = FontWeight(500),
                    color = onBackgroundColor,
                    textAlign = TextAlign.Center,
                )
            )
        else
            Icon(
                painter = painterResource(id = icon),
                contentDescription = null,
                tint = onBackgroundColor
            )
    }
}

@Composable
fun PadNumbers(
    modifier: Modifier = Modifier,
    numberArray: MutableList<String>,
    icon: Int,
    fontFamily: FontFamily,
    onBackgroundColor: Color = MaterialTheme.colorScheme.onBackground,
    background: Color = MaterialTheme.colorScheme.primary,
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .height(272.dp),
        shape = RoundedCornerShape(topEnd = 40.dp, topStart = 40.dp),
        colors = CardDefaults.cardColors(background),
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
                    },
                    fontFamily = fontFamily,
                    onBackgroundColor = onBackgroundColor
                )
                NumberButton(
                    modifier = Modifier.weight(1f),
                    number = "2",
                    onClickButton = { if (numberArray.toList().size < 4) numberArray.add("2") },
                    fontFamily = fontFamily, onBackgroundColor = onBackgroundColor

                )
                NumberButton(
                    modifier = Modifier.weight(1f),
                    number = "3",
                    onClickButton = { if (numberArray.toList().size < 4) numberArray.add("3") },
                    fontFamily = fontFamily, onBackgroundColor = onBackgroundColor
                )
            }
            //2
            Row(modifier = Modifier.weight(1f)) {
                NumberButton(
                    modifier = Modifier.weight(1f),
                    number = "4",
                    onClickButton = { if (numberArray.toList().size < 4) numberArray.add("4") },
                    fontFamily = fontFamily, onBackgroundColor = onBackgroundColor
                )
                NumberButton(
                    modifier = Modifier.weight(1f),
                    number = "5",
                    onClickButton = { if (numberArray.toList().size < 4) numberArray.add("5") },
                    fontFamily = fontFamily, onBackgroundColor = onBackgroundColor
                )
                NumberButton(
                    modifier = Modifier.weight(1f),
                    number = "6",
                    onClickButton = { if (numberArray.toList().size < 4) numberArray.add("6") },
                    fontFamily = fontFamily, onBackgroundColor = onBackgroundColor
                )
            }
            //3
            Row(modifier = Modifier.weight(1f)) {
                NumberButton(
                    modifier = Modifier.weight(1f),
                    number = "7",
                    onClickButton = { if (numberArray.toList().size < 4) numberArray.add("7") },
                    fontFamily = fontFamily, onBackgroundColor = onBackgroundColor
                )
                NumberButton(
                    modifier = Modifier.weight(1f),
                    number = "8",
                    onClickButton = { if (numberArray.toList().size < 4) numberArray.add("8") },
                    fontFamily = fontFamily, onBackgroundColor = onBackgroundColor
                )
                NumberButton(
                    modifier = Modifier.weight(1f),
                    number = "9",
                    onClickButton = { if (numberArray.toList().size < 4) numberArray.add("9") },
                    fontFamily = fontFamily, onBackgroundColor = onBackgroundColor
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
                    onClickButton = { if (numberArray.toList().size < 4) numberArray.add("0") },
                    fontFamily = fontFamily, onBackgroundColor = onBackgroundColor
                )
                NumberButton(
                    modifier = Modifier.weight(1f),
                    number = "",
                    icon = icon,
                    onClickButton = {
                        if (numberArray.toList().isNotEmpty()) numberArray.removeLast()
                    }, fontFamily = fontFamily, onBackgroundColor = onBackgroundColor
                )
            }
        }
    }
}