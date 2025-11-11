package com.fadymarty.matule_ui_kit.presentation.components.buttons

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.fadymarty.matule_ui_kit.common.theme.MatuleTheme

@Composable
fun LoginButton(
    modifier: Modifier = Modifier,
    label: String,
    onClick: () -> Unit,
    trailingIcon: @Composable () -> Unit,
) {
    Button(
        modifier = modifier.fillMaxWidth(),
        onClick = onClick,
        contentPadding = PaddingValues(14.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = MatuleTheme.colorScheme.background,
            contentColor = MatuleTheme.colorScheme.onBackground
        ),
        shape = RoundedCornerShape(12.dp),
        border = BorderStroke(
            width = 1.dp,
            color = MatuleTheme.colorScheme.inputStroke
        )
    ) {
        trailingIcon()
        Spacer(Modifier.width(16.dp))
        Text(
            text = label,
            style = MatuleTheme.typography.headlineMedium
        )
    }
}