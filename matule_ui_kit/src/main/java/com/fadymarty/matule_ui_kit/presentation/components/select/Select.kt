package com.fadymarty.matule_ui_kit.presentation.components.select

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import com.fadymarty.matule_ui_kit.common.theme.MatuleTheme
import com.fadymarty.matule_ui_kit.presentation.components.icons.MatuleIcons

@Composable
fun Select(
    modifier: Modifier = Modifier,
    hint: String? = null,
    label: String?,
    leadingIcon: (@Composable () -> Unit)? = null,
    onClick: () -> Unit,
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .height(48.dp)
            .clip(RoundedCornerShape(10.dp))
            .background(MatuleTheme.colorScheme.inputBg)
            .border(
                width = 1.dp,
                color = MatuleTheme.colorScheme.inputStroke,
                shape = RoundedCornerShape(10.dp)
            )
            .padding(
                start = if (leadingIcon != null) 12.dp else 14.dp,
                end = 14.dp
            )
            .clickable { onClick() },
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            if (leadingIcon != null) {
                leadingIcon()
            }
            if (hint != null && label == null) {
                Text(
                    text = hint,
                    style = MatuleTheme.typography.headlineRegular,
                    color = MatuleTheme.colorScheme.placeholder
                )
            }
            if (label != null) {
                Text(
                    text = label,
                    style = MatuleTheme.typography.headlineRegular,
                )
            }
        }
        Icon(
            imageVector = MatuleIcons.ChevronDown,
            contentDescription = null,
            tint = MatuleTheme.colorScheme.description
        )
    }
}