package com.fadymarty.ui_kit.presentation.components.card

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.dropShadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.shadow.Shadow
import androidx.compose.ui.unit.DpOffset
import androidx.compose.ui.unit.dp
import com.fadymarty.ui_kit.common.theme.MatuleTheme

@Composable
fun CardBackground(
    modifier: Modifier = Modifier,
    content: @Composable ColumnScope.() -> Unit,
) {
    Column(
        modifier = modifier
            .dropShadow(
                shape = RoundedCornerShape(12.dp),
                shadow = Shadow(
                    offset = DpOffset.Zero,
                    radius = 20.dp,
                    color = Color(0xFFE4E8F5),
                    alpha = 0.6f
                )
            )
            .fillMaxWidth()
            .clip(RoundedCornerShape(12.dp))
            .background(MatuleTheme.colorScheme.background)
            .border(
                width = 1.dp,
                color = MatuleTheme.colorScheme.cardStroke,
                shape = RoundedCornerShape(12.dp)
            ),
        content = content
    )
}