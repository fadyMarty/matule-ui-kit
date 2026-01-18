package com.fadymarty.ui_kit.presentation.components.controls

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.dropShadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.shadow.Shadow
import androidx.compose.ui.unit.DpOffset
import androidx.compose.ui.unit.dp
import com.fadymarty.ui_kit.common.theme.MatuleTheme

@Composable
fun Toggle(
    modifier: Modifier = Modifier,
    checked: Boolean,
    onClick: () -> Unit,
) {
    val animatedSpacing by animateDpAsState(
        targetValue = if (checked) 20.dp else 0.dp
    )
    val animatedColor by animateColorAsState(
        targetValue = if (checked) {
            MatuleTheme.colorScheme.accent
        } else MatuleTheme.colorScheme.inputStroke
    )

    Row(
        modifier = modifier
            .width(48.dp)
            .height(28.dp)
            .clip(CircleShape)
            .background(animatedColor)
            .clickable(
                interactionSource = null,
                indication = null
            ) {
                onClick()
            }
            .padding(2.dp)
    ) {
        Spacer(
            modifier = Modifier.width(animatedSpacing)
        )
        Box(
            modifier = Modifier
                .size(24.dp)
                .dropShadow(
                    shape = CircleShape,
                    shadow = Shadow(
                        radius = 1.dp,
                        color = Color.Black,
                        offset = DpOffset(0.dp, 3.dp),
                        alpha = 0.06f
                    )
                )
                .dropShadow(
                    shape = CircleShape,
                    shadow = Shadow(
                        radius = 8.dp,
                        color = Color.Black,
                        offset = DpOffset(0.dp, 3.dp),
                        alpha = 0.15f
                    )
                )
                .clip(CircleShape)
                .background(MatuleTheme.colorScheme.background)
        )
    }
}