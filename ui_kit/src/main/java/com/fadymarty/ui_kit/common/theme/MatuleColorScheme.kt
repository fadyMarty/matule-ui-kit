package com.fadymarty.ui_kit.common.theme

import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color

data class MatuleColorScheme(
    val accent: Color = MatulePallete.Accent,
    val onAccent: Color = MatulePallete.White,
    val accentInactive: Color = MatulePallete.AccentInactive,
    val onBackground: Color = MatulePallete.Black,
    val background: Color = MatulePallete.White,
    val error: Color = MatulePallete.Error,
    val success: Color = MatulePallete.Success,
    val inputBg: Color = MatulePallete.InputBg,
    val inputStroke: Color = MatulePallete.InputStroke,
    val inputIcon: Color = MatulePallete.InputIcon,
    val placeholder: Color = MatulePallete.Placeholder,
    val description: Color = MatulePallete.Description,
    val cardStroke: Color = MatulePallete.CardStroke,
)

val LocalMatuleColorScheme = staticCompositionLocalOf { MatuleColorScheme() }
