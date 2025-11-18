package com.fadymarty.matule_ui_kit.presentation.components.cards

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.fadymarty.matule_ui_kit.R
import com.fadymarty.matule_ui_kit.common.theme.MatuleTheme
import com.fadymarty.matule_ui_kit.presentation.components.controls.Counter
import com.fadymarty.matule_ui_kit.presentation.components.icons.MatuleIcons

@Composable
fun CartCard(
    modifier: Modifier = Modifier,
    title: String,
    price: Int,
    count: Int,
    onMinusClick: () -> Unit,
    onPlusClick: () -> Unit,
    onDeleteClick: () -> Unit,
) {
    CardBackground(
        modifier = modifier,
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 16.dp)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp)
            ) {
                Text(
                    modifier = Modifier.weight(1f),
                    text = title,
                    style = MatuleTheme.typography.headlineMedium
                )
                Spacer(Modifier.width(8.dp))
                Icon(
                    modifier = Modifier
                        .size(20.dp)
                        .clickable(
                            interactionSource = null,
                            indication = null,
                            onClick = onDeleteClick
                        ),
                    imageVector = MatuleIcons.Close,
                    contentDescription = null,
                    tint = MatuleTheme.colorScheme.description
                )
            }
            Spacer(Modifier.height(34.dp))
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(
                        start = 20.dp,
                        end = 9.dp
                    ),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "$price ₽",
                    style = MatuleTheme.typography.headlineMedium,
                )
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = stringResource(R.string.count, count),
                        style = MatuleTheme.typography.textRegular
                    )
                    Spacer(Modifier.width(42.dp))
                    Counter(
                        onMinusClick = onMinusClick,
                        onPlusClick = onPlusClick,
                        count = count
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun CartCardPreview() {
    MatuleTheme {
        CartCard(
            title = "Рубашка Воскресенье для машинного вязания",
            price = 300,
            count = 1,
            onMinusClick = {},
            onPlusClick = {},
            onDeleteClick = {},
        )
    }
}