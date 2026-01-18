package com.fadymarty.ui_kit.presentation.components.input

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import com.fadymarty.ui_kit.presentation.components.icons.MatuleIcons

@Composable
fun PasswordInput(
    modifier: Modifier = Modifier,
    value: String,
    onValueChange: (String) -> Unit,
    isVisible: Boolean,
    onTrailingIconClick: () -> Unit,
    hint: String? = null,
    label: String? = null,
    error: String? = null,
    keyboardOptions: KeyboardOptions = KeyboardOptions(
        keyboardType = KeyboardType.Password
    ),
    keyboardActions: KeyboardActions = KeyboardActions.Default,
    focused: Boolean = false,
) {
    Input(
        modifier = modifier,
        value = value,
        onValueChange = onValueChange,
        hint = hint,
        label = label,
        error = error,
        visualTransformation = if (isVisible) {
            VisualTransformation.None
        } else PasswordVisualTransformation('*'),
        keyboardOptions = keyboardOptions,
        keyboardActions = keyboardActions,
        trailingIcon = {
            Icon(
                modifier = Modifier
                    .size(20.dp)
                    .clickable(
                        interactionSource = null,
                        indication = null,
                        onClick = onTrailingIconClick
                    ),
                imageVector = if (isVisible) {
                    MatuleIcons.VisibilityOn
                } else MatuleIcons.VisibilityOff,
                contentDescription = null,
            )
        },
        focused = focused
    )
}