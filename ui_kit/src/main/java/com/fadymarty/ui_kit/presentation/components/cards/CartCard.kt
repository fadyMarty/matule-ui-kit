package com.fadymarty.ui_kit.presentation.components.cards

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
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
import com.fadymarty.ui_kit.common.theme.MatuleTheme
import com.fadymarty.ui_kit.presentation.components.controls.Counter
import com.fadymarty.ui_kit.presentation.components.icons.MatuleIcons

@Composable
fun CartCard(
    modifier: Modifier = Modifier,
    title: String,
    price: String,
    count: Int,
    onMinusClick: () -> Unit,
    onPlusClick: () -> Unit,
    onDeleteClick: () -> Unit,
) {
    CardBackground(
        modifier = modifier
            .fillMaxWidth()
            .height(138.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(vertical = 16.dp),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Text(
                    modifier = Modifier.weight(1f),
                    text = title,
                    style = MatuleTheme.typography.headlineMedium
                )
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
                    text = price,
                    style = MatuleTheme.typography.headlineMedium,
                )
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(42.dp)
                ) {
                    Text(
                        text = "$count штук",
                        style = MatuleTheme.typography.textRegular
                    )
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