package com.fadymarty.ui_kit.presentation.components.input

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsFocusedAsState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import com.fadymarty.ui_kit.common.theme.MatuleTheme

@Composable
fun Input(
    modifier: Modifier = Modifier,
    value: String,
    onValueChange: (String) -> Unit,
    label: String? = null,
    hint: String? = null,
    error: String? = null,
    visualTransformation: VisualTransformation = VisualTransformation.None,
    trailingIcon: (@Composable () -> Unit)? = null,
    focus: Boolean = false,
) {
    val interactionSource = remember { MutableInteractionSource() }
    val isFocused by interactionSource.collectIsFocusedAsState()

    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        if (label != null) {
            Text(
                text = label,
                style = MatuleTheme.typography.captionRegular,
                color = MatuleTheme.colorScheme.description
            )
        }
        BasicTextField(
            modifier = Modifier.fillMaxWidth(),
            value = value,
            onValueChange = onValueChange,
            interactionSource = interactionSource,
            visualTransformation = visualTransformation,
            textStyle = MatuleTheme.typography.textRegular,
            cursorBrush = if (error != null) {
                SolidColor(MatuleTheme.colorScheme.error)
            } else SolidColor(MatuleTheme.colorScheme.accent)
        ) { innerTextField ->
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(10.dp))
                    .background(
                        color = if (error != null) {
                            MatuleTheme.colorScheme.error.copy(alpha = 0.1f)
                        } else MatuleTheme.colorScheme.inputBg
                    )
                    .border(
                        width = 1.dp,
                        color = when {
                            error != null -> MatuleTheme.colorScheme.error
                            isFocused || focus -> MatuleTheme.colorScheme.accent
                            value.isNotEmpty() -> MatuleTheme.colorScheme.inputIcon
                            else -> MatuleTheme.colorScheme.inputStroke
                        },
                        shape = RoundedCornerShape(10.dp)
                    )
                    .padding(14.dp)
            ) {
                Box(
                    modifier = Modifier.weight(1f)
                ) {
                    if (value.isEmpty() && hint != null) {
                        Text(
                            text = hint,
                            style = MatuleTheme.typography.textRegular,
                            color = MatuleTheme.colorScheme.placeholder
                        )
                    }
                    innerTextField()
                }
                if (trailingIcon != null) {
                    Spacer(Modifier.width(14.dp))
                    trailingIcon()
                }
            }
        }
        if (error != null) {
            Text(
                text = error,
                style = MatuleTheme.typography.captionRegular,
                color = MatuleTheme.colorScheme.error
            )
        }
    }
}