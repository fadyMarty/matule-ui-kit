package com.fadymarty.ui_kit.common.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider

@Composable
fun MatuleTheme(
    content: @Composable () -> Unit,
) {
    val colorScheme = MatuleColorScheme()

    CompositionLocalProvider(
        LocalMatuleColorScheme provides colorScheme,
        LocalMatuleTypography provides MatuleTypography()
    ) {
        MaterialTheme(
            colorScheme = lightColorScheme(
                primary = colorScheme.accent,
                onPrimary = colorScheme.onAccent,
                background = colorScheme.background,
                onBackground = colorScheme.onBackground,
                error = colorScheme.error
            ),
            content = content
        )
    }
}

object MatuleTheme {

    val colorScheme: MatuleColorScheme
        @Composable
        get() = LocalMatuleColorScheme.current

    val typography: MatuleTypography
        @Composable
        get() = LocalMatuleTypography.current
}