package com.fadymarty.ui_kit.presentation.components.cards

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
fun ProjectCard(
    modifier: Modifier = Modifier,
    title: String,
    date: String,
    onOpenClick: () -> Unit,
) {
    CardBackground(
        modifier = modifier
            .fillMaxWidth()
            .height(136.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
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
                Text(
                    modifier = Modifier.padding(bottom = 4.dp),
                    text = date,
                    style = MatuleTheme.typography.captionSemibold,
                    color = MatuleTheme.colorScheme.placeholder
                )
                SmallButton(
                    label = "Открыть",
                    onClick = onOpenClick
                )
            }
        }
    }
}