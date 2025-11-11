package com.fadymarty.matule_ui_kit.presentation.components.snack_bar

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.fadymarty.matule_ui_kit.R
import com.fadymarty.matule_ui_kit.common.theme.MatuleTheme
import com.fadymarty.matule_ui_kit.presentation.components.icons.MatuleIcons

@Composable
fun SnackBar(
    modifier: Modifier = Modifier,
    onClose: () -> Unit,
) {
    Box(modifier = modifier) {
        Box(
            modifier = Modifier
                .padding(top = 12.dp, end = 12.dp)
                .fillMaxWidth()
                .clip(RoundedCornerShape(8.dp))
                .background(MatuleTheme.colorScheme.background)
                .padding(
                    start = 20.dp,
                    top = 24.dp,
                    end = 20.dp,
                    bottom = 40.dp,
                )
        ) {
            Text(
                text = stringResource(R.string.error_notification),
                style = MatuleTheme.typography.title2ExtraBold
            )
        }
        Box(
            modifier = Modifier
                .align(Alignment.TopEnd)
                .size(24.dp)
                .clip(CircleShape)
                .background(MatuleTheme.colorScheme.accent.copy(alpha = 0.5f))
                .clickable {
                    onClose()
                },
            contentAlignment = Alignment.Center
        ) {
            Icon(
                modifier = Modifier.size(10.dp),
                imageVector = MatuleIcons.Dismiss,
                contentDescription = null,
                tint = MatuleTheme.colorScheme.description
            )
        }
    }
}