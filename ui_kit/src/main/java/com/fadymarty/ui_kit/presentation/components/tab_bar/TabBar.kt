package com.fadymarty.ui_kit.presentation.components.tab_bar

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.dropShadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.shadow.Shadow
import androidx.compose.ui.unit.DpOffset
import androidx.compose.ui.unit.dp
import com.fadymarty.ui_kit.common.theme.MatuleTheme

@Composable
fun TabBar(
    modifier: Modifier = Modifier,
    items: List<TabBarItem>,
    selectedRoute: String?,
    onItemClick: (TabBarItem) -> Unit,
) {
    NavigationBar(
        modifier = modifier
            .dropShadow(
                shape = RectangleShape,
                shadow = Shadow(
                    offset = DpOffset(0.dp, (-0.5).dp),
                    radius = 0.dp,
                    color = Color(0xFFA0A0A0),
                    alpha = 0.3f
                )
            )
            .height(88.dp),
        containerColor = MatuleTheme.colorScheme.background
    ) {
        items.forEach { item ->
            NavigationBarItem(
                selected = item.route::class.qualifiedName == selectedRoute,
                onClick = {
                    onItemClick(item)
                },
                colors = NavigationBarItemDefaults.colors(
                    indicatorColor = Color.Transparent,
                    selectedIconColor = MatuleTheme.colorScheme.accent,
                    unselectedIconColor = MatuleTheme.colorScheme.inputIcon
                ),
                icon = {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Icon(
                            modifier = Modifier
                                .padding(item.iconPadding)
                                .size(item.iconSize),
                            imageVector = item.icon,
                            contentDescription = null
                        )
                        Text(
                            text = item.label,
                            style = MatuleTheme.typography.caption2Regular
                        )
                    }
                }
            )
        }
    }
}