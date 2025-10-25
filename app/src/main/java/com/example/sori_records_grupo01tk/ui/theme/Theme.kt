package com.example.sori_records_grupo01tk.ui.theme

import android.app.Activity
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext

// --- Dark theme ---
private val DarkColorScheme = darkColorScheme(
    primary = PrimaryColor,
    onPrimary = TextOnDark,
    secondary = SecondaryColor,
    onSecondary = TextOnDark,
    background = BackgroundDark,
    onBackground = TextOnDark,
    surface = BackgroundDark,
    onSurface = TextOnDark,
    error = ErrorColor,
    onError = TextOnDark
)

// --- Light theme ---
private val LightColorScheme = lightColorScheme(
    primary = PrimaryColor,
    onPrimary = TextOnLight,
    secondary = SecondaryColor,
    onSecondary = TextOnLight,
    background = BackgroundLight,
    onBackground = TextOnLight,
    surface = BackgroundLight,
    onSurface = TextOnLight,
    error = ErrorColor,
    onError = TextOnLight
)
@Composable
fun Sori_RecordsGrupo01TKTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color is available on Android 12+
    dynamicColor: Boolean = true,
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }

        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}