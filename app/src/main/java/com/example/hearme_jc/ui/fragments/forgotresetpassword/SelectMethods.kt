package com.example.hearme_jc.ui.fragments.forgotresetpassword

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.hearme_jc.R
import com.example.hearme_jc.navigation.Screen
import com.example.hearme_jc.ui.theme.Hearme_JCTheme
import com.example.hearme_jc.ui.theme.Primary500
import com.example.hearme_jc.ui.theme.TranparentGreen
import com.example.hearme_jc.ui.theme.White
import com.example.mylibrary.AppNavigationButton

@Composable
fun SelectMethodsScreen(modifier: Modifier = Modifier, navController: NavController) {
    Column(modifier = modifier.padding(start = 24.dp, end = 24.dp).fillMaxSize()) {
        Spacer(modifier = Modifier.weight(1f))

        Image(
            painter = painterResource(id = R.drawable.image_vector_forgot_password),
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .height(250.dp)
                .width(276.dp)
        )

        Spacer(modifier = Modifier.weight(1f))

        ContainerSelectMethods()

        Spacer(modifier = Modifier.weight(1f))

        AppNavigationButton(
            text = "Continue",
            textColor = White,
            bgColor = Primary500,
            font = FontFamily(Font(R.font.urbanist_bold)),
            onButtonClick = { navController.navigate(Screen.TypeOTP.route) }
        )

        Spacer(modifier = Modifier.height(48.dp))
    }
}

@Composable
fun CardIconMethod(modifier: Modifier = Modifier, icon: Int) {
    Card(
        colors = CardDefaults.cardColors(TranparentGreen), modifier = Modifier.size(80.dp), shape = CircleShape
    ) {
        Box(modifier = modifier.fillMaxSize(), contentAlignment = Center) {
            Icon(
                painter = painterResource(id = icon),
                contentDescription = null,
                modifier = Modifier.size(26.67.dp),
                tint = Primary500
            )
        }
    }
}

@Composable
fun CardMethod(modifier: Modifier = Modifier, icon: Int, title: String, body: String, onClick: () -> Unit, isSelected: Boolean) {
    Card(
        modifier = modifier
            .fillMaxWidth(),
        colors = CardDefaults.cardColors(MaterialTheme.colorScheme.surface),
        border = if (isSelected) BorderStroke(width = 3.dp, color = Primary500) else BorderStroke(
            width = 1.dp,
            color = MaterialTheme.colorScheme.outlineVariant
        ),
        shape = RoundedCornerShape(32.dp)
    ) {
        Row(
            modifier = Modifier
                .clickable { onClick() }
                .padding(24.dp)
                .fillMaxWidth()
                .height(IntrinsicSize.Max)
                .clip(RoundedCornerShape(32.dp))
        ) {
            CardIconMethod(icon = icon)

            Spacer(modifier = Modifier.width(20.dp))

            Column(verticalArrangement = Arrangement.Center, modifier = Modifier.fillMaxHeight()) {
                Text(
                    modifier = Modifier.fillMaxWidth(),
                    text = title,
                    style = TextStyle(
                        fontSize = 14.sp,
                        lineHeight = 19.6.sp,
                        fontFamily = FontFamily(Font(R.font.urbanist_medium)),
                        fontWeight = FontWeight(500),
                        color = MaterialTheme.colorScheme.onTertiaryContainer,

                        letterSpacing = 0.2.sp,
                    )
                )

                Spacer(modifier = Modifier.height(8.dp))

                Text(
                    modifier = Modifier.fillMaxWidth(),
                    text = body,
                    style = TextStyle(
                        fontSize = 16.sp,
                        lineHeight = 22.4.sp,
                        fontFamily = FontFamily(Font(R.font.urbanist_bold)),
                        fontWeight = FontWeight(700),
                        color = MaterialTheme.colorScheme.onBackground,

                        letterSpacing = 0.2.sp,
                    )
                )
            }
        }
    }
}

@Composable
fun ContainerSelectMethods(modifier: Modifier = Modifier) {
    var isSelected by rememberSaveable {
        mutableStateOf(true)
    }

    Column(modifier = modifier.fillMaxWidth(), verticalArrangement = Arrangement.spacedBy(24.dp)) {
        Text(
            text = "Select which contact details should we use to reset your password",
            style = TextStyle(
                fontSize = 18.sp,
                lineHeight = 25.2.sp,
                fontFamily = FontFamily(Font(R.font.urbanist_medium)),
                fontWeight = FontWeight(500),
                color = MaterialTheme.colorScheme.onBackground,
                letterSpacing = 0.2.sp,
            )
        )

        CardMethod(
            icon = R.drawable.ic_message,
            title = "via SMS:",
            body = "+1 111 123 231",
            onClick = { isSelected = true },
            isSelected = isSelected
        )

        CardMethod(
            icon = R.drawable.ic_email,
            title = "via Email:",
            body = "abc@gmail.com",
            onClick = { isSelected = false },
            isSelected = !isSelected
        )
    }
}

@Preview(showBackground = true, widthDp = 412, heightDp = 915)
@Composable
fun SelectMethodsScreenPreview() {
    Hearme_JCTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            val navController = rememberNavController()

            SelectMethodsScreen(navController = navController)
        }
    }
}