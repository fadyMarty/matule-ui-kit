package com.fadymarty.ui_kit.presentation.components.input

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsFocusedAsState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.unit.dp
import com.fadymarty.ui_kit.common.theme.MatuleTheme
import com.fadymarty.ui_kit.presentation.components.icons.MatuleIcons

@Composable
fun SearchInput(
    modifier: Modifier = Modifier,
    value: String,
    onValueChange: (String) -> Unit,
    onClearClick: () -> Unit,
    hint: String? = null,
    focused: Boolean = false,
) {
    val interactionSource = remember { MutableInteractionSource() }
    val isFocused by interactionSource.collectIsFocusedAsState()

    BasicTextField(
        modifier = modifier,
        value = value,
        onValueChange = onValueChange,
        cursorBrush = SolidColor(MatuleTheme.colorScheme.accent),
        interactionSource = interactionSource,
        textStyle = MatuleTheme.typography.headlineRegular,
        singleLine = true
    ) { innerTextField ->
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .border(
                    width = 1.dp,
                    color = MatuleTheme.colorScheme.inputStroke,
                    shape = RoundedCornerShape(10.dp)
                )
                .clip(RoundedCornerShape(10.dp))
                .background(MatuleTheme.colorScheme.inputBg)

                .padding(14.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Icon(
                modifier = Modifier.size(20.dp),
                imageVector = MatuleIcons.Search,
                contentDescription = null,
                tint = MatuleTheme.colorScheme.description
            )
            Box(
                modifier = Modifier.weight(1f)
            ) {
                if (value.isEmpty() && hint != null) {
                    Text(
                        text = hint,
                        style = MatuleTheme.typography.headlineRegular,
                        color = MatuleTheme.colorScheme.placeholder
                    )
                }
                innerTextField()
            }
            if (focused || isFocused) {
                Icon(
                    modifier = Modifier
                        .size(20.dp)
                        .clickable(
                            interactionSource = null,
                            indication = null,
                            onClick = onClearClick
                        ),
                    imageVector = MatuleIcons.Close,
                    contentDescription = null,
                    tint = MatuleTheme.colorScheme.description
                )
            }
        }
    }
}