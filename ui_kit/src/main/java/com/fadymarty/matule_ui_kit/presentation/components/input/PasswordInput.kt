package com.fadymarty.matule_ui_kit.presentation.components.input

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import com.fadymarty.matule_ui_kit.presentation.components.icons.MatuleIcons

@Composable
fun PasswordInput(
    modifier: Modifier = Modifier,
    value: String,
    onValueChange: (String) -> Unit,
    isPasswordVisible: Boolean,
    onTrailingIconClick: () -> Unit,
    hint: String? = null,
    label: String? = null,
    error: String? = null,
    focused: Boolean = false,
) {
    Input(
        modifier = modifier,
        value = value,
        onValueChange = onValueChange,
        hint = hint,
        label = label,
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
                    MatuleIcons.VisibilityOn
                } else MatuleIcons.VisibilityOff,
                contentDescription = null,
            )
        },
        focused = focused
    )
}