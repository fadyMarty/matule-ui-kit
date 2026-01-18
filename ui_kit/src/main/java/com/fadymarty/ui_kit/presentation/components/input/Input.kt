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
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import com.fadymarty.ui_kit.common.theme.MatuleTheme
import com.fadymarty.ui_kit.common.util.TestTags
import com.fadymarty.ui_kit.common.util.borderColorRes
import com.fadymarty.ui_kit.common.util.colorRes

@Composable
fun Input(
    modifier: Modifier = Modifier,
    value: String,
    onValueChange: (String) -> Unit,
    hint: String? = null,
    label: String? = null,
    error: String? = null,
    visualTransformation: VisualTransformation = VisualTransformation.None,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    keyboardActions: KeyboardActions = KeyboardActions.Default,
    trailingIcon: (@Composable () -> Unit)? = null,
    focused: Boolean = false,
) {
    val interactionSource = remember { MutableInteractionSource() }
    val isFocused by interactionSource.collectIsFocusedAsState()

    val errorColor = MatuleTheme.colorScheme.error
    val backgroundColor = if (error != null) {
        MatuleTheme.colorScheme.error.copy(alpha = 0.1f)
    } else MatuleTheme.colorScheme.inputBg
    val borderColor = when {
        error != null -> MatuleTheme.colorScheme.error
        focused || isFocused -> MatuleTheme.colorScheme.accent
        value.isNotEmpty() -> MatuleTheme.colorScheme.inputIcon
        else -> MatuleTheme.colorScheme.inputStroke
    }

    Column(modifier = modifier) {
        label?.let {
            Text(
                text = label,
                style = MatuleTheme.typography.captionRegular,
                color = MatuleTheme.colorScheme.description,
            )
            Spacer(Modifier.height(4.dp))
        }
        BasicTextField(
            value = value,
            onValueChange = onValueChange,
            interactionSource = interactionSource,
            visualTransformation = visualTransformation,
            keyboardOptions = keyboardOptions,
            keyboardActions = keyboardActions,
            singleLine = true,
            textStyle = MatuleTheme.typography.textRegular.copy(
                color = MatuleTheme.colorScheme.onBackground
            ),
            cursorBrush = if (error != null) {
                SolidColor(MatuleTheme.colorScheme.error)
            } else SolidColor(MatuleTheme.colorScheme.accent)
        ) { innerTextField ->
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .border(
                        width = 1.dp,
                        color = borderColor,
                        shape = RoundedCornerShape(10.dp)
                    )
                    .clip(RoundedCornerShape(10.dp))
                    .background(backgroundColor)
                    .padding(vertical = 14.dp)
                    .padding(start = 14.dp, end = 15.dp)
                    .testTag(TestTags.INPUT)
                    .semantics {
                        colorRes = backgroundColor
                        borderColorRes = borderColor
                    },
                horizontalArrangement = Arrangement.spacedBy(8.dp)
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
                trailingIcon?.let {
                    trailingIcon()
                }
            }
        }
        error?.let {
            Spacer(Modifier.height(8.dp))
            Text(
                modifier = Modifier
                    .testTag(TestTags.INPUT_ERROR_TEXT)
                    .semantics {
                        colorRes = errorColor
                    },
                text = error,
                style = MatuleTheme.typography.captionRegular,
                color = errorColor
            )
        }
    }
}