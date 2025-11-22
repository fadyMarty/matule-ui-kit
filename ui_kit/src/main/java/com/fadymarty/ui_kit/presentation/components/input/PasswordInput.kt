package com.fadymarty.ui_kit.presentation.components.input

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import com.fadymarty.ui_kit.presentation.components.icons.MatuleIcons

@Composable
fun PasswordInput(
    modifier: Modifier = Modifier,
    value: String = "",
    onValueChange: (String) -> Unit,
    isPasswordVisible: Boolean = false,
    label: String? = null,
    hint: String? = null,
    error: String? = null,
    onTrailingIconClick: () -> Unit,
    focus: Boolean = false,
) {
    Input(
        modifier = modifier,
        value = value,
        onValueChange = onValueChange,
        label = label,
        hint = hint,
        error = error,
        visualTransformation = if (isPasswordVisible) {
            VisualTransformation.None
        } else PasswordVisualTransformation('*'),
        trailingIcon = {
            Icon(
                modifier = Modifier
                    .size(20.dp)
                    .clickable(
                        interactionSource = null,
                        indication = null,
                        onClick = onTrailingIconClick
                    ),
                imageVector = if (isPasswordVisible) {
                    MatuleIcons.EyeOn
                } else MatuleIcons.EyeOff,
                contentDescription = null
            )
        },
        focus = focus
    )
}