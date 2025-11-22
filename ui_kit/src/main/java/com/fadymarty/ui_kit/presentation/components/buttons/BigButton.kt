package com.fadymarty.ui_kit.presentation.components.buttons

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.fadymarty.ui_kit.common.theme.MatuleTheme

@Composable
fun BigButton(
    modifier: Modifier = Modifier,
    label: String,
    onClick: () -> Unit,
    enabled: Boolean = true,
    outlined: Boolean = false,
    tertiary: Boolean = false,
) {
    if (outlined) {
        OutlinedButton(
            modifier = modifier.fillMaxWidth(),
            onClick = onClick,
            enabled = enabled,
            contentPadding = PaddingValues(16.dp),
            shape = RoundedCornerShape(10.dp),
            border = BorderStroke(
                width = 1.dp,
                color = MatuleTheme.colorScheme.accent
            )
        ) {
            Text(
                text = label,
                style = MatuleTheme.typography.title3Semibold
            )
        }
    } else {
        Button(
            modifier = modifier.fillMaxWidth(),
            onClick = onClick,
            enabled = enabled,
            contentPadding = PaddingValues(16.dp),
            shape = RoundedCornerShape(10.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = if (tertiary) {
                    MatuleTheme.colorScheme.inputBg
                } else MatuleTheme.colorScheme.accent,
                contentColor = if (tertiary) {
                    MatuleTheme.colorScheme.onBackground
                } else MatuleTheme.colorScheme.onAccent,
                disabledContainerColor = MatuleTheme.colorScheme.accentInactive,
                disabledContentColor = MatuleTheme.colorScheme.onAccent
            )
        ) {
            Text(
                text = label,
                style = MatuleTheme.typography.title3Semibold
            )
        }
    }
}