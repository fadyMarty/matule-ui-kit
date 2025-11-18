package com.fadymarty.matule_ui_kit.presentation.components.select

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.unit.dp
import com.fadymarty.matule_ui_kit.common.theme.MatuleTheme
import com.fadymarty.matule_ui_kit.common.util.TestTags
import com.fadymarty.matule_ui_kit.presentation.components.icons.MatuleIcons
import com.fadymarty.matule_ui_kit.presentation.components.modal.Modal

@Composable
fun Select(
    modifier: Modifier = Modifier,
    items: List<String>,
    selectedItem: String? = null,
    onItemClick: (String) -> Unit,
    hint: String,
    label: String? = null,
    leadingIcon: (@Composable () -> Unit)? = null,
) {
    var isModalVisible by remember {
        mutableStateOf(false)
    }

    Column(
        modifier = modifier.fillMaxWidth()
    ) {
        label?.let {
            Text(
                text = it,
                style = MatuleTheme.typography.captionRegular,
                color = MatuleTheme.colorScheme.description
            )
            Spacer(Modifier.height(4.dp))
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(48.dp)
                .clip(RoundedCornerShape(10.dp))
                .background(MatuleTheme.colorScheme.inputBg)
                .border(
                    width = 1.dp,
                    color = MatuleTheme.colorScheme.inputStroke,
                    shape = RoundedCornerShape(10.dp)
                )
                .clickable {
                    isModalVisible = true
                }
                .padding(
                    start = if (leadingIcon != null) 12.dp else 14.dp,
                    end = 14.dp
                )
                .testTag(TestTags.SELECT),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                if (leadingIcon != null) {
                    leadingIcon()
                }
                if (selectedItem == null) {
                    Text(
                        text = hint,
                        style = MatuleTheme.typography.headlineRegular,
                        color = MatuleTheme.colorScheme.placeholder
                    )
                }
                if (selectedItem != null) {
                    Text(
                        text = selectedItem,
                        style = MatuleTheme.typography.headlineRegular,
                    )
                }
            }
            Icon(
                imageVector = MatuleIcons.ChevronDown,
                contentDescription = null,
                tint = MatuleTheme.colorScheme.description
            )
        }
    }

    if (isModalVisible) {
        Modal(
            modifier = Modifier.testTag(TestTags.SELECT_BOTTOM_SHEET),
            onDismissRequest = {
                isModalVisible = false
            },
            title = hint
        ) {
            LazyColumn(
                modifier = Modifier.fillMaxWidth()
            ) {
                items(items) { item ->
                    Text(
                        modifier = Modifier
                            .fillMaxWidth()
                            .clip(RoundedCornerShape(10.dp))
                            .clickable {
                                onItemClick(item)
                                isModalVisible = false
                            }
                            .padding(14.dp),
                        text = item,
                        style = MatuleTheme.typography.headlineRegular
                    )
                }
            }
        }
    }
}