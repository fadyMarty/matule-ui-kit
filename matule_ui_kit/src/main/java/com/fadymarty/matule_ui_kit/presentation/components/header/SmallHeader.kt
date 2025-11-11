package com.fadymarty.matule_ui_kit.presentation.components.header

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
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
    onNavigateBack: () -> Unit,
    onDeleteClick: () -> Unit,
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .padding(
                start = 20.dp,
                end = 26.dp,
                bottom = 16.dp
            )
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            BackButton(
                onClick = onNavigateBack
            )
            Text(
                text = label,
                style = MatuleTheme.typography.title2SemiBold,
            )
            Icon(
                modifier = Modifier
                    .size(20.dp)
                    .clickable(
                        interactionSource = null,
                        indication = null
                    ) {
                        onDeleteClick()
                    },
                imageVector = MatuleIcons.Delete,
                contentDescription = null,
                tint = MatuleTheme.colorScheme.inputIcon
            )
        }
    }
}