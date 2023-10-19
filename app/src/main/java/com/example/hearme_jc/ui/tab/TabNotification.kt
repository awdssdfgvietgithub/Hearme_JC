package com.example.hearme_jc.ui.tab

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Tab
import androidx.compose.material.TabRow
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import com.example.hearme_jc.R
import com.example.hearme_jc.ui.theme.Primary500

enum class TabNotification(val title: String) {
    Songs("Songs"),
    Podcasts("Podcasts")
}

@Composable
fun TabSongs(modifier: Modifier = Modifier, selectedTabIndex: Int, onSelectedTab: (TabNotification) -> Unit) {
    TabRow(
        modifier = modifier.fillMaxWidth(),
        selectedTabIndex = selectedTabIndex,
        contentColor = Primary500,
        backgroundColor = Color.Transparent,

    ) {
        TabNotification.values().forEachIndexed() { index, tabPage ->
            Tab(
                selected = index == selectedTabIndex,
                onClick = { onSelectedTab(tabPage) },
                text = {
                    Text(
                        text = tabPage.name,
                        style = TextStyle(
                            fontSize = 18.sp,
                            lineHeight = 25.2.sp,
                            fontFamily = FontFamily(Font(R.font.urbanist_semibold)),
                            fontWeight = FontWeight(600),
                            textAlign = TextAlign.Center,
                            letterSpacing = 0.2.sp,
                        )
                    )
                },
                selectedContentColor = Primary500,
                unselectedContentColor = MaterialTheme.colors.onSurface,
            )
        }
    }
}