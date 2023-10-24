package com.example.mylibrary

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeOut
import androidx.compose.animation.shrinkOut
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource

@Composable
fun CustomCheckBox(
    modifier: Modifier = Modifier,
    iconOff: Int,
    iconOn: Int,
    colorOff: Color,
    colorOn: Color,
    onCheckedChange: (Boolean) -> Unit,
    checked: Boolean,
) {
    IconButton(modifier = modifier, onClick = { onCheckedChange(!checked) }) {
        Icon(
            painter = painterResource(id = iconOff),
            contentDescription = "Unchecked",
            tint = colorOff
        )
        AnimatedVisibility(
            modifier = modifier,
            visible = checked,
            exit = shrinkOut(shrinkTowards = Alignment.TopStart) + fadeOut()
        ) {
            Icon(
                painter = painterResource(id = iconOn),
                contentDescription = "Checked",
                tint = colorOn
            )
        }
    }
}

