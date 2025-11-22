package com.fadymarty.ui_kit.presentation.components.header

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.fadymarty.ui_kit.common.theme.MatuleTheme
import com.fadymarty.ui_kit.presentation.components.buttons.BackButton
import com.fadymarty.ui_kit.presentation.components.icons.MatuleIcons

@Composable
fun SmallHeader(
    modifier: Modifier = Modifier,
    leadingIcon: (@Composable () -> Unit)? = null,
    trailingIcon: (@Composable () -> Unit)? = null,
    label: String,
) {
    Box(
        modifier = modifier.height(48.dp)
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(32.dp),
            contentAlignment = Alignment.Center
        ) {
            Row(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(
                        start = 20.dp,
                        end = 26.dp
                    ),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                if (leadingIcon != null) {
                    leadingIcon()
                }
                if (trailingIcon != null) {
                    trailingIcon()
                }
            }
            Text(
                text = label,
                style = MatuleTheme.typography.title2Semibold
            )
        }
    }
}