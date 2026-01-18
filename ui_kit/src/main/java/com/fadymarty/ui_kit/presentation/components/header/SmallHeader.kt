package com.fadymarty.ui_kit.presentation.components.header

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.fadymarty.ui_kit.common.theme.MatuleTheme

@Composable
fun SmallHeader(
    modifier: Modifier = Modifier,
    title: String,
    navigationIcon: (@Composable () -> Unit)? = null,
    trailingIcon: (@Composable () -> Unit)? = null,
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(48.dp)
            .padding(horizontal = 20.dp)
    ) {
        navigationIcon?.let {
            navigationIcon()
        }
        Text(
            modifier = Modifier
                .align(Alignment.TopCenter)
                .padding(2.dp),
            text = title,
            style = MatuleTheme.typography.title2SemiBold
        )
        trailingIcon?.let {
            Box(
                modifier = Modifier
                    .align(Alignment.TopEnd)
                    .padding(top = 6.dp, end = 6.dp)
            ) {
                trailingIcon()
            }
        }
    }
}