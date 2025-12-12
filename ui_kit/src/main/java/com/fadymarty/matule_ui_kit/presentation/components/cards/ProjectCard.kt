package com.fadymarty.matule_ui_kit.presentation.components.cards

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.fadymarty.matule_ui_kit.R
import com.fadymarty.matule_ui_kit.common.theme.MatuleTheme
import com.fadymarty.matule_ui_kit.presentation.components.buttons.SmallButton

@Composable
fun ProjectCard(
    modifier: Modifier = Modifier,
    title: String,
    onClick: () -> Unit,
) {
    CardBackground(
        modifier = modifier,
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Text(
                modifier = Modifier.fillMaxWidth(),
                text = title,
                style = MatuleTheme.typography.headlineMedium
            )
            Spacer(Modifier.height(44.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.Bottom,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    modifier = Modifier.padding(bottom = 4.dp),
                    text = "Прошло 2 дня",
                    style = MatuleTheme.typography.captionSemibold,
                    color = MatuleTheme.colorScheme.placeholder
                )
                SmallButton(
                    label = stringResource(R.string.open),
                    onClick = onClick
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun ProjectCardPreview() {
    MatuleTheme {
        ProjectCard(
            title = "Рубашка Воскресенье для машинного вязания",
            onClick = {},
        )
    }
}