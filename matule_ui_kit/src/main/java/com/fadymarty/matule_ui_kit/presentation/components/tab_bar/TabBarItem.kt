package com.fadymarty.matule_ui_kit.presentation.components.tab_bar

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

data class TabBarItem(
    val icon: @Composable () -> ImageVector,
    val iconSize: Dp = 32.dp,
    val spacing: Dp = 0.dp,
    val label: @Composable () -> String,
    val route: Any,
)
