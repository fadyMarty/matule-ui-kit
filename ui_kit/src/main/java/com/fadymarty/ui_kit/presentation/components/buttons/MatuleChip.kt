package com.fadymarty.ui_kit.presentation.components.buttons

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import com.fadymarty.ui_kit.common.theme.MatuleTheme

@Composable
fun MatuleChip(
    modifier: Modifier = Modifier,
    selected: Boolean,
    label: String,
    onClick: () -> Unit,
) {
    Box(
        modifier = modifier
            .clip(RoundedCornerShape(10.dp))
            .background(
                color = if (selected) {
                    MatuleTheme.colorScheme.accent
                } else MatuleTheme.colorScheme.inputBg
            )
            .clickable(onClick = onClick)
            .padding(
                horizontal = 20.dp,
                vertical = 14.dp
            )
    ) {
        Text(
            text = label,
            style = MatuleTheme.typography.textMedium,
            color = if (selected) {
                MatuleTheme.colorScheme.onAccent
            } else MatuleTheme.colorScheme.description
        )
    }
}