package com.fadymarty.matule_ui_kit.presentation.components.input

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsFocusedAsState
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.unit.dp
import com.fadymarty.matule_ui_kit.common.theme.MatuleTheme
import com.fadymarty.matule_ui_kit.presentation.components.icons.MatuleIcons

@Composable
fun SearchInput(
    modifier: Modifier = Modifier,
    value: String,
    onValueChange: (String) -> Unit,
    hint: String? = null,
    onClear: () -> Unit,
    focus: Boolean = false,
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
                .height(48.dp)
                .clip(RoundedCornerShape(10.dp))
                .background(MatuleTheme.colorScheme.inputBg)
                .border(
                    width = 1.dp,
                    color = MatuleTheme.colorScheme.inputStroke,
                    shape = RoundedCornerShape(10.dp)
                )
                .padding(horizontal = 14.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                modifier = Modifier.size(20.dp),
                imageVector = MatuleIcons.Search,
                contentDescription = null,
                tint = MatuleTheme.colorScheme.description
            )
            Spacer(Modifier.width(8.dp))
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
            Spacer(Modifier.width(8.dp))
            if (isFocused || focus) {
                Icon(
                    modifier = Modifier
                        .size(20.dp)
                        .clickable(
                            interactionSource = null,
                            indication = null
                        ) {
                            onClear()
                        },
                    imageVector = MatuleIcons.Close,
                    contentDescription = null,
                    tint = MatuleTheme.colorScheme.description
                )
            }
        }
    }
}