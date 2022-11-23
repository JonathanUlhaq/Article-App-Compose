package com.belajar.articleapp.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.belajar.articleapp.R

// Set of Material typography styles to start with

val caption = FontFamily(
    Font(R.font.caption_regular,
        weight = FontWeight.Normal
    ),
    Font(R.font.caption_bold,
        weight = FontWeight.Bold
    )
)

val Typography = Typography(
    body1 = TextStyle(
        fontFamily = caption,
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp,
    ),
    body2 = TextStyle(
        fontFamily = caption,
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp,
    ),

    h1 = TextStyle(
        fontFamily = caption,
        fontWeight = FontWeight.Bold,
        fontSize = 32.sp,
    ),

    h2 = TextStyle(
        fontFamily = caption,
        fontWeight = FontWeight.Bold,
        fontSize = 14.sp,
    ),
    /* Other default text styles to override
    button = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.W500,
        fontSize = 14.sp
    ),
    caption = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp
    )
    */
)