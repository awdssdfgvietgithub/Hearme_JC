package com.example.mylibrary

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Snackbar
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun AppSnackBar(
    modifier: Modifier = Modifier,
    title: String,
    content: String,
    profileImageRes: Int? = null,
    actionImageRes: Int? = null,
    onAction: () -> Unit,
) {
    Snackbar(
        elevation = 0.dp,
        backgroundColor = Color.Transparent
    ) {
        Box(
            modifier = modifier
                .fillMaxWidth()
                .wrapContentHeight()
        ) {
            Column(
                modifier = modifier
                    .padding(16.dp)
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(16.dp))
                    .background(Color.Blue)
                    .padding(start = 78.dp, top = 8.dp, bottom = 12.dp, end = 8.dp),
                horizontalAlignment = Alignment.Start
            ) {
                Text(text = title, color = Color.White, fontWeight = FontWeight.Bold, fontSize = 20.sp)
                Spacer(modifier = modifier.padding(vertical = 4.dp))
                Text(text = content, color = Color.White, fontWeight = FontWeight.Bold, fontSize = 20.sp)
            }

        }
    }
}