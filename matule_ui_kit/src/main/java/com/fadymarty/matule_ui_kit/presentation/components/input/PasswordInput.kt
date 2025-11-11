package com.fadymarty.matule_ui_kit.presentation.components.input

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
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
    hint: String? = null,
    label: String? = null,
    error: String? = null,
    focus: Boolean = false,
) {
    var isPasswordVisible by rememberSaveable {
        mutableStateOf(false)
    }

    Input(
        modifier = modifier,
        value = value,
        onValueChange = onValueChange,
        hint = hint,
        label = label,
        error = error,
        visualTransformation = if (isPasswordVisible) {
            VisualTransformation.None
        } else PasswordVisualTransformation(),
        focus = focus,
        trailingIcon = {
            Icon(
                modifier = Modifier
                    .size(20.dp)
                    .clickable(
                        interactionSource = null,
                        indication = null
                    ) {
                        isPasswordVisible = !isPasswordVisible
                    },
                imageVector = if (isPasswordVisible) {
                    MatuleIcons.EyeOn
                } else MatuleIcons.EyeOff,
                contentDescription = null,
            )
        }
    )
}