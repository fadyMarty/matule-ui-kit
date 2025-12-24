package com.fadymarty.matule_ui_kit.presentation.components.tab_bar

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

data class TabBarItem(
    val icon: ImageVector,
    val iconSize: Dp = 32.dp,
    val iconPadding: PaddingValues = PaddingValues.Zero,
    val label: String,
    val route: Any,
)
