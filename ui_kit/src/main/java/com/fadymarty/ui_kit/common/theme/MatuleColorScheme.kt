package com.fadymarty.ui_kit.common.theme

import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color

data class MatuleColorScheme(
    val accent: Color = MatulePalette.Accent,
    val onAccent: Color = MatulePalette.White,
    val accentInactive: Color = MatulePalette.AccentInactive,
    val background: Color = MatulePalette.White,
    val onBackground: Color = MatulePalette.Black,
    val error: Color = MatulePalette.Error,
    val success: Color = MatulePalette.Success,
    val inputBg: Color = MatulePalette.InputBg,
    val inputStroke: Color = MatulePalette.InputStroke,
    val inputIcon: Color = MatulePalette.InputIcon,
    val placeholder: Color = MatulePalette.Placeholder,
    val description: Color = MatulePalette.Description,
    val cardStroke: Color = MatulePalette.CardStroke,
)

val LocalMatuleColorScheme = staticCompositionLocalOf { MatuleColorScheme() }