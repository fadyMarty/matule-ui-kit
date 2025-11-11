package com.fadymarty.matule_ui_kit.presentation.components.header

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.fadymarty.matule_ui_kit.common.theme.MatuleTheme
import com.fadymarty.matule_ui_kit.presentation.components.buttons.BackButton
import com.fadymarty.matule_ui_kit.presentation.components.icons.MatuleIcons

@Composable
fun BigHeader(
    modifier: Modifier = Modifier,
    label: String,
    onNavigateBack: () -> Unit,
    onDeleteClick: () -> Unit,
) {
    Column(
        modifier = modifier.fillMaxWidth()
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            BackButton(
                onClick = onNavigateBack
            )
            Icon(
                modifier = Modifier
                    .padding(top = 11.dp, end = 11.dp)
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
        Spacer(Modifier.height(32.dp))
        Text(
            text = label,
            style = MatuleTheme.typography.title1ExtraBold
        )
    }
}