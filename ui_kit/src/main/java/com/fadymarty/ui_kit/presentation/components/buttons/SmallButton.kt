package com.fadymarty.ui_kit.presentation.components.buttons

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.fadymarty.ui_kit.common.theme.MatuleTheme

@Composable
fun SmallButton(
    modifier: Modifier = Modifier,
    label: String,
    onClick: () -> Unit,
    enabled: Boolean = true,
    outlined: Boolean = false,
    tertiary: Boolean = false,
) {
    BasicButton(
        modifier = modifier.width(96.dp),
        label = label,
        onClick = onClick,
        enabled = enabled,
        outlined = outlined,
        tertiary = tertiary,
        textStyle = MatuleTheme.typography.captionSemibold,
        contentPadding = PaddingValues(horizontal = 13.5.dp, vertical = 10.dp),
    )
}