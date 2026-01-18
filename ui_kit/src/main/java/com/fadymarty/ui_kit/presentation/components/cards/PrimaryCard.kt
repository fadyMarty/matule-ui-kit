package com.fadymarty.ui_kit.presentation.components.cards

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.fadymarty.ui_kit.common.theme.MatuleTheme
import com.fadymarty.ui_kit.presentation.components.buttons.SmallButton

@Composable
fun PrimaryCard(
    modifier: Modifier = Modifier,
    title: String,
    type: String,
    price: String,
    onClick: () -> Unit,
    onButtonClick: () -> Unit,
    added: Boolean,
) {
    CardBackground(
        modifier = modifier
            .fillMaxWidth()
            .height(136.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .clickable(onClick = onClick)
                .padding(16.dp),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = title,
                style = MatuleTheme.typography.headlineMedium
            )
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.Bottom
            ) {
                Column(
                    verticalArrangement = Arrangement.spacedBy(4.dp)
                ) {
                    Text(
                        text = type,
                        style = MatuleTheme.typography.captionSemibold,
                        color = MatuleTheme.colorScheme.placeholder
                    )
                    Text(
                        text = price,
                        style = MatuleTheme.typography.title3Semibold
                    )
                }
                SmallButton(
                    label = if (added) "Убрать" else "Добавить",
                    onClick = onButtonClick,
                    outlined = added
                )
            }
        }
    }
}