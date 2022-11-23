package com.belajar.articleapp.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import com.google.accompanist.systemuicontroller.rememberSystemUiController

private val DarkColorPalette = darkColors(
    primary = White,
    secondary = DarkWhite,
    background = Black,
    onSecondary = DarkerWhite,
    surface = SemiWhite
)

private val LightColorPalette = lightColors(
    primary = Black,
    secondary = LightGrey,
    background = White,
    onSecondary = DarkGrey,
    surface = SemiBlack
    /* Other default colors to override
    background = Color.White,
    surface = Color.White,
    onPrimary = Color.White,
    onSecondary = Color.Black,
    onBackground = Color.Black,
    onSurface = Color.Black,
    */
)

@Composable
fun ArticleAppTheme(darkTheme: Boolean = isSystemInDarkTheme(), content: @Composable () -> Unit) {
    val status = rememberSystemUiController()
    val colors = if (darkTheme) {
        status.setStatusBarColor(Color.Black)
        status.setSystemBarsColor(Color.Black)
        DarkColorPalette
    } else {
        status.setStatusBarColor(Color.White)
        status.setSystemBarsColor(Color.White)
        LightColorPalette
    }

    MaterialTheme(
        colors = colors,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}