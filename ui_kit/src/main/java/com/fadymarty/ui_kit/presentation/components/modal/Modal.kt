package com.fadymarty.ui_kit.presentation.components.modal

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import com.fadymarty.ui_kit.common.theme.MatuleTheme
import com.fadymarty.ui_kit.presentation.components.icons.MatuleIcons

@Composable
fun Modal(
    modifier: Modifier = Modifier,
    onDismissRequest: () -> Unit,
    title: String? = null,
    content: @Composable () -> Unit,
) {
    ModalBackground(
        modifier = modifier,
        onDismissRequest = onDismissRequest
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 24.dp)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp),
                horizontalArrangement = Arrangement.spacedBy(44.dp)
            ) {
                Box(
                    modifier = Modifier.weight(1f)
                ) {
                    title?.let {
                        Text(
                            text = title,
                            style = MatuleTheme.typography.title2ExtraBold
                        )
                    }
                }
                Box(
                    modifier = Modifier
                        .size(24.dp)
                        .clip(CircleShape)
                        .background(MatuleTheme.colorScheme.inputIcon)
                        .clickable(onClick = onDismissRequest)
                        .padding(7.dp)
                ) {
                    Icon(
                        modifier = Modifier.size(10.dp),
                        imageVector = MatuleIcons.Dismiss,
                        contentDescription = null,
                        tint = MatuleTheme.colorScheme.description
                    )
                }
            }
            content()
        }
    }
}