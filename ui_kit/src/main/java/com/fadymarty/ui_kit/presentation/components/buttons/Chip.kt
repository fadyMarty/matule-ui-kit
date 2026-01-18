package com.fadymarty.ui_kit.presentation.components.buttons

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.unit.dp
import com.fadymarty.ui_kit.common.theme.MatuleTheme
import com.fadymarty.ui_kit.common.util.TestTags
import com.fadymarty.ui_kit.common.util.colorRes

@Composable
fun Chip(
    modifier: Modifier = Modifier,
    selected: Boolean,
    onClick: () -> Unit,
    label: String,
) {
    val containerColor = if (selected) {
        MatuleTheme.colorScheme.accent
    } else MatuleTheme.colorScheme.inputBg

    Button(
        modifier = modifier
            .testTag(TestTags.CHIP_BUTTON)
            .semantics {
                colorRes = containerColor
            },
        onClick = onClick,
        shape = RoundedCornerShape(10.dp),
        contentPadding = PaddingValues(
            horizontal = 20.dp,
            vertical = 14.dp
        ),
        colors = ButtonDefaults.buttonColors(
            containerColor = containerColor,
            contentColor = if (selected) {
                MatuleTheme.colorScheme.onAccent
            } else MatuleTheme.colorScheme.description
        )
    ) {
        Text(
            text = label,
            style = MatuleTheme.typography.textMedium
        )
    }
}