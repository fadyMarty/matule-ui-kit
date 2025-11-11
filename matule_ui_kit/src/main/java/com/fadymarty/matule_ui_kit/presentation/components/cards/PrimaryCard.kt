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
fun PrimaryCard(
    modifier: Modifier = Modifier,
    title: String,
    type: String,
    price: Int,
    onClick: () -> Unit,
    added: Boolean,
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
            Spacer(Modifier.height(16.dp))
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
                        text = "$price ₽",
                        style = MatuleTheme.typography.title3Semibold,
                    )
                }
                SmallButton(
                    label = if (added) {
                        stringResource(R.string.add)
                    } else stringResource(R.string.remove),
                    onClick = onClick,
                    outlined = added
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun PrimaryCardPreview() {
    MatuleTheme {
        PrimaryCard(
            title = "Рубашка Воскресенье для машинного вязания",
            type = "Мужская одежда",
            price = 300,
            onClick = {},
            added = false
        )
    }
}