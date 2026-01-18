package com.fadymarty.ui_kit.presentation.components.controls

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.fadymarty.ui_kit.common.theme.MatuleTheme
import com.fadymarty.ui_kit.presentation.components.icons.MatuleIcons

@Composable
fun Counter(
    onMinusClick: () -> Unit,
    onPlusClick: () -> Unit,
    count: Int,
) {
    Row(
        modifier = Modifier
            .clip(RoundedCornerShape(8.dp))
            .background(MatuleTheme.colorScheme.inputBg)
            .padding(6.dp),
        horizontalArrangement = Arrangement.spacedBy(6.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            modifier = Modifier.clickable(
                interactionSource = null,
                indication = null
            ) {
                if (count > 1) onMinusClick()
            },
            imageVector = MatuleIcons.Minus,
            contentDescription = null,
            tint = if (count < 2) {
                MatuleTheme.colorScheme.inputIcon
            } else MatuleTheme.colorScheme.description
        )
        VerticalDivider(
            modifier = Modifier
                .height(16.dp)
                .width(0.dp),
            thickness = 1.dp,
            MatuleTheme.colorScheme.inputStroke
        )
        Icon(
            modifier = Modifier.clickable(
                interactionSource = null,
                indication = null,
                onClick = onPlusClick
            ),
            imageVector = MatuleIcons.Plus,
            contentDescription = null,
            tint = MatuleTheme.colorScheme.description
        )
    }
}

@Preview
@Composable
private fun CounterPreview() {
    MatuleTheme {
        Counter(
            onMinusClick = {

            },
            onPlusClick = {

            },
            count = 2
        )
    }
}