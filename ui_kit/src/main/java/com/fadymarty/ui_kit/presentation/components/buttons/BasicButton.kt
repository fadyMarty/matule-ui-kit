package com.fadymarty.ui_kit.presentation.components.buttons

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.fadymarty.ui_kit.common.theme.MatuleTheme
import com.fadymarty.ui_kit.common.util.TestTags

@Composable
fun BasicButton(
    modifier: Modifier = Modifier,
    label: String,
    onClick: () -> Unit,
    enabled: Boolean,
    outlined: Boolean,
    tertiary: Boolean,
    textStyle: TextStyle,
    contentPadding: PaddingValues,
) {
    if (outlined) {
        OutlinedButton(
            modifier = modifier.testTag(TestTags.OUTLINED_BUTTON),
            onClick = onClick,
            enabled = enabled,
            border = BorderStroke(
                width = 1.dp,
                color = MatuleTheme.colorScheme.accent
            ),
            shape = RoundedCornerShape(10.dp),
            contentPadding = contentPadding
        ) {
            Text(
                text = label,
                style = textStyle,
                color = MatuleTheme.colorScheme.accent,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
        }
    } else {
        Button(
            modifier = modifier.testTag(TestTags.BUTTON),
            onClick = onClick,
            enabled = enabled,
            colors = ButtonDefaults.buttonColors(
                containerColor = if (tertiary) {
                    MatuleTheme.colorScheme.inputBg
                } else MatuleTheme.colorScheme.accent,
                disabledContainerColor = MatuleTheme.colorScheme.accentInactive,
                contentColor = if (tertiary) {
                    MatuleTheme.colorScheme.onBackground
                } else MatuleTheme.colorScheme.onAccent,
                disabledContentColor = MatuleTheme.colorScheme.onAccent
            ),
            shape = RoundedCornerShape(10.dp),
            contentPadding = contentPadding
        ) {
            Text(
                text = label,
                style = textStyle,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
        }
    }
}