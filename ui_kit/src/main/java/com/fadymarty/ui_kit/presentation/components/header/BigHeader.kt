package com.fadymarty.ui_kit.presentation.components.header

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.fadymarty.ui_kit.common.theme.MatuleTheme
import com.fadymarty.ui_kit.presentation.components.buttons.BackButton
import com.fadymarty.ui_kit.presentation.components.icons.MatuleIcons

@Composable
fun BigHeader(
    modifier: Modifier = Modifier,
    leadingIcon: (@Composable () -> Unit)? = null,
    trailingIcon: (@Composable () -> Unit)? = null,
    label: String,
) {
    Column {
        Row(
            modifier = modifier
                .fillMaxWidth()
                .height(56.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            if (leadingIcon != null) {
                leadingIcon()
            }
            if (trailingIcon != null) {
                Box(
                    modifier = Modifier.padding(
                        top = 11.dp,
                        end = 11.dp
                    )
                ) {
                    trailingIcon()
                }
            }
        }
        Text(
            text = label,
            style = MatuleTheme.typography.title1ExtraBold
        )
    }
}