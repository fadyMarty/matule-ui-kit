package com.fadymarty.matule_ui_kit.presentation.components.input

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsFocusedAsState
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import com.fadymarty.matule_ui_kit.common.theme.MatuleTheme
import com.fadymarty.matule_ui_kit.presentation.util.TestTags
import com.fadymarty.matule_ui_kit.presentation.util.borderColorRes
import com.fadymarty.matule_ui_kit.presentation.util.colorRes

@Composable
fun Input(
    modifier: Modifier = Modifier,
    value: String,
    onValueChange: (String) -> Unit,
    hint: String? = null,
    label: String? = null,
    error: String? = null,
    visualTransformation: VisualTransformation = VisualTransformation.None,
    focus: Boolean = false,
    trailingIcon: (@Composable () -> Unit)? = null,
) {
    val interactionSource = remember { MutableInteractionSource() }
    val isFocused by interactionSource.collectIsFocusedAsState()

    val errorColor = MatuleTheme.colorScheme.error
    val backgroundColor = if (error != null) {
        MatuleTheme.colorScheme.error.copy(alpha = 0.1f)
    } else MatuleTheme.colorScheme.inputBg
    val borderColor = when {
        error != null -> MatuleTheme.colorScheme.error
        isFocused || focus -> MatuleTheme.colorScheme.accent
        value.isNotEmpty() -> MatuleTheme.colorScheme.inputIcon
        else -> MatuleTheme.colorScheme.inputStroke
    }

    Column(
        modifier = modifier
    ) {
        if (label != null) {
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
            singleLine = true,
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
                    .height(48.dp)
                    .clip(RoundedCornerShape(10.dp))
                    .background(
                        color = backgroundColor
                    )
                    .border(
                        width = 1.dp,
                        color = borderColor,
                        shape = RoundedCornerShape(10.dp)
                    )
                    .padding(
                        start = 14.dp,
                        end = 15.dp,
                    )
                    .testTag(TestTags.INPUT_CONTAINER)
                    .semantics {
                        colorRes = backgroundColor
                        borderColorRes = borderColor
                    },
                verticalAlignment = Alignment.CenterVertically
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
                    Spacer(Modifier.width(8.dp))
                    trailingIcon()
                }
            }
        }
        if (error != null) {
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