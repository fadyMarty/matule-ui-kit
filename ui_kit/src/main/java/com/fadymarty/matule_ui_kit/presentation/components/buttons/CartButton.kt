package com.fadymarty.matule_ui_kit.presentation.components.buttons

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.fadymarty.matule_ui_kit.R
import com.fadymarty.matule_ui_kit.common.theme.MatuleTheme

@Composable
fun CartButton(
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
    price: Int,
) {
    Button(
        modifier = modifier.fillMaxWidth(),
        onClick = onClick,
        contentPadding = PaddingValues(16.dp),
        shape = RoundedCornerShape(10.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                modifier = Modifier.size(20.dp),
                painter = painterResource(R.drawable.ic_shopping_cart),
                contentDescription = null
            )
            Spacer(Modifier.width(16.dp))
            Text(
                text = stringResource(R.string.add_to_cart),
                style = MatuleTheme.typography.title3Semibold
            )
            Spacer(Modifier.weight(1f))
            Text(
                text = price.toString(),
                style = MatuleTheme.typography.title3Semibold
            )
            Spacer(Modifier.width(6.dp))
            Text(
                text = "₽",
                style = MatuleTheme.typography.title3Semibold
            )
        }
    }
}