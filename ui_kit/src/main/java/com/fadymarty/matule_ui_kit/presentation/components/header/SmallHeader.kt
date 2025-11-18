package com.fadymarty.matule_ui_kit.presentation.components.header

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.fadymarty.matule_ui_kit.common.theme.MatuleTheme
import com.fadymarty.matule_ui_kit.presentation.components.buttons.BackButton
import com.fadymarty.matule_ui_kit.presentation.components.icons.MatuleIcons

@Composable
fun SmallHeader(
    modifier: Modifier = Modifier,
    label: String,
    onNavigateBack: (() -> Unit)? = null,
    onDeleteClick: (() -> Unit)? = null,
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(48.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            if (onNavigateBack != null) {
                BackButton(onClick = onNavigateBack)
            }
            Text(
                modifier = Modifier.padding(top = 2.dp),
                text = label,
                style = MatuleTheme.typography.title2SemiBold
            )
            if (onDeleteClick != null) {
                Icon(
                    modifier = Modifier
                        .size(20.dp)
                        .clickable(
                            interactionSource = null,
                            indication = null,
                            onClick = onDeleteClick
                        ),
                    imageVector = MatuleIcons.Delete,
                    contentDescription = null,
                    tint = MatuleTheme.colorScheme.inputIcon
                )
            }
        }
    }
}