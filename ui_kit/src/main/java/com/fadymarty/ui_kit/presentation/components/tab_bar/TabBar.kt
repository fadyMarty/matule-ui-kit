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
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.unit.DpOffset
import androidx.compose.ui.unit.dp
import com.fadymarty.ui_kit.common.theme.MatuleTheme
import com.fadymarty.ui_kit.common.util.TestTags
import com.fadymarty.ui_kit.common.util.colorRes

@Composable
fun TabBar(
    modifier: Modifier = Modifier,
    items: List<TabBarItem>,
    currentRoute: String?,
    onItemClick: (TabBarItem) -> Unit,
) {
    NavigationBar(
        modifier = modifier
            .height(88.dp)
            .dropShadow(
                shape = RectangleShape,
                shadow = Shadow(
                    offset = DpOffset(0.dp, (-0.5).dp),
                    radius = 0.dp,
                    color = Color(0xFFA0A0A0),
                    alpha = 0.3f
                )
            ),
        containerColor = MatuleTheme.colorScheme.background
    ) {
        items.forEach { item ->
            val isSelected = currentRoute == item.route::class.qualifiedName
            val iconColor = if (isSelected) {
                MatuleTheme.colorScheme.accent
            } else MatuleTheme.colorScheme.inputIcon

            NavigationBarItem(
                modifier = Modifier
                    .testTag(
                        TestTags.TAB_BAR_ITEM + item.label
                    )
                    .semantics {
                        colorRes = iconColor
                    },
                selected = isSelected,
                colors = NavigationBarItemDefaults.colors(
                    indicatorColor = Color.Transparent,
                    unselectedIconColor = MatuleTheme.colorScheme.inputIcon,
                    selectedIconColor = MatuleTheme.colorScheme.accent
                ),
                icon = {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Icon(
                            modifier = Modifier
                                .padding(item.iconPadding)
                                .size(item.iconSize),
                            imageVector = ImageVector.vectorResource(item.icon),
                            contentDescription = null
                        )
                        Text(
                            text = item.label,
                            style = MatuleTheme.typography.caption2Regular
                        )
                    }
                },
                onClick = {
                    onItemClick(item)
                }
            )
        }
    }
}