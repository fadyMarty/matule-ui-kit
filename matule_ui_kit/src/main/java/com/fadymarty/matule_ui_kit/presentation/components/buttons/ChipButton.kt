package com.fadymarty.matule_ui_kit.presentation.components.buttons

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.fadymarty.matule_ui_kit.common.theme.MatuleTheme

@Composable
fun ChipButton(
    modifier: Modifier = Modifier,
    selected: Boolean,
    onClick: () -> Unit,
    label: String,
) {
    Button(
        modifier = modifier,
        onClick = onClick,
        shape = RoundedCornerShape(10.dp),
        contentPadding = PaddingValues(
            horizontal = 20.dp,
            vertical = 14.dp
        ),
        colors = ButtonDefaults.buttonColors(
            containerColor = if (selected) {
                MatuleTheme.colorScheme.accent
            } else MatuleTheme.colorScheme.inputBg,
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