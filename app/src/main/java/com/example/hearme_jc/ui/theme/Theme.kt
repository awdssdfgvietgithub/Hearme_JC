package com.example.hearme_jc.ui.theme

import android.app.Activity
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat

private val DarkColorScheme = darkColorScheme(
    primary = Dark2,
    secondary = PurpleGrey80,
    tertiary = Pink80,
    background = Dark1,
    outlineVariant = Dark3,
    onBackground = White,
    onSurface = Greyscale700,
    onSecondary = Greyscale300,
    onSurfaceVariant = Greyscale600,
    surface = Dark2,
    onPrimary = White,
    onPrimaryContainer = White,
    onTertiary = White,
    onSecondaryContainer = Dark3,
    onTertiaryContainer = Greyscale300,
    inversePrimary = Dark2
)

private val LightColorScheme = lightColorScheme(
    primary = Greyscale50,
    secondary = PurpleGrey40,
    tertiary = Pink40,
    background = White,
    outlineVariant = Greyscale200,
    onBackground = Greyscale900,
    onSurface = Greyscale500,
    onSecondary = Greyscale700,
    onSurfaceVariant = Greyscale400,
    surface = White,
    onPrimary = Greyscale700,
    onPrimaryContainer = Greyscale500,
    onTertiary = Primary500,
    onSecondaryContainer = Primary100,
    onTertiaryContainer = Greyscale600,
    inversePrimary = Greyscale100

    /* Other default colors to override
    background = Color(0xFFFFFBFE),
    surface = Color(0xFFFFFBFE),
    onPrimary = Color.White,
    onSecondary = Color.White,
    onTertiary = Color.White,
    onBackground = Color(0xFF1C1B1F),
    onSurface = Color(0xFF1C1B1F),
    */
)

@Composable
fun Hearme_JCTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color is available on Android 12+
    dynamicColor: Boolean = true,
    content: @Composable () -> Unit,
) {
    val colorScheme = when {
//        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
//            val context = LocalContext.current
//            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
//        }

        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }
    val view = LocalView.current
    if (!view.isInEditMode) {
        SideEffect {
            val window = (view.context as Activity).window
            window.statusBarColor = colorScheme.primary.toArgb()
            WindowCompat.getInsetsController(window, view).isAppearanceLightStatusBars = darkTheme
        }
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}