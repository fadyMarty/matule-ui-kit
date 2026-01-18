package com.fadymarty.ui_kit.presentation.components.tab_bar

import androidx.annotation.DrawableRes
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

data class TabBarItem(
    @DrawableRes val icon: Int,
    val label: String,
    val route: Any,
    val iconSize: Dp = 32.dp,
    val iconPadding: PaddingValues = PaddingValues.Zero,
)
